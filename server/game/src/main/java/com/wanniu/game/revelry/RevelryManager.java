package com.wanniu.game.revelry;

import com.wanniu.core.game.JobFactory;
import com.wanniu.core.logfs.Out;
import com.wanniu.game.GWorld;
import com.wanniu.game.common.Const;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.RevelryCO;
import com.wanniu.game.data.RevelryConfigCO;
import com.wanniu.game.guild.GuildServiceCenter;
import com.wanniu.game.mail.MailUtil;
import com.wanniu.game.mail.data.MailData;
import com.wanniu.game.mail.data.MailSysData;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.GuildMemberPO;
import com.wanniu.game.rank.RankType;
import com.wanniu.game.rank.SimpleRankData;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;

import org.apache.commons.lang3.StringUtils;


public class RevelryManager {
    private static final RevelryManager instance = new RevelryManager();


    private static final Map<String, ScheduledFuture<?>> settlementFutureMap = new ConcurrentHashMap<>();

    public static RevelryManager getInstance() {
        return instance;
    }


    public RankType toRankType(int activityKey) {
        switch (activityKey) {
            case 1:
                return RankType.HP;
            case 2:
                return RankType.PHY;
            case 3:
                return RankType.MAGIC;
            case 4:
                return RankType.XIANYUAN;
            case 5:
                return RankType.DEMON_TOWER;
            case 6:
                return RankType.LEVEL;
            case 7:
                return RankType.FIGHTPOWER;
            case 8:
                return RankType.GUILD_LEVEL;
            case 9:
                return RankType.PET;
            case 10:
                return RankType.Mount;
            case 11:
                return RankType.ARENA_SCORE;
            case 12:
                return RankType.PVP_5V5;
        }
        return RankType.FIGHTPOWER;
    }


    public boolean isGuildRankKey(int activityKey) {
        return (activityKey == 8);
    }

    public void onLogin(WNPlayer player) {
        LocalDate openServerDate = GWorld.OPEN_SERVER_DATE;
        LocalDate now = LocalDate.now();

        boolean isOpen = GameData.Revelrys.values().stream().filter(v -> (v.isOpen == 1 && now.isBefore(openServerDate.plusDays(v.endDays2)))).findFirst().isPresent();
        player.updateSuperScript(Const.SUPERSCRIPT_TYPE.ACTIVITY_REVELRY, isOpen ? 1 : 0);
    }


    public List<RevelryClass> getRevelryClassList() {
        LocalDate openServerDate = GWorld.OPEN_SERVER_DATE;
        LocalDate now = LocalDate.now();


        List<RevelryCO> templates = GameData.findRevelrys(v -> (v.isOpen == 1 && now.isBefore(openServerDate.plusDays(v.endDays2))));
        templates.sort((o1, o2) -> o1.endDays1 - o2.endDays1);


        Map<String, RevelryClass> tabCaches = new TreeMap<>();

        for (RevelryCO template : templates) {

            RevelryClass revelryClass = tabCaches.computeIfAbsent(template.activityTab, key -> new RevelryClass(template.activityName1));


            RevelryToday today = revelryClass.getTodays().computeIfAbsent(template.activityID, key -> new RevelryToday(template.activityName2));


            RevelryColumn column = new RevelryColumn();
            column.setId(template.tabID);
            column.setName(template.tabName);
            column.setLabel(template.activityKey2);
            column.setGoto1(template.goTo1);
            column.setGoto2(template.goTo2);
            column.setTip(template.activityDesc);
            today.getColumns().add(column);


            LocalDateTime endTime = GWorld.OPEN_SERVER_DATE.plusDays(template.endDays1).atTime(0, 0, 0, 0);
            long timeleft = Duration.between(LocalDateTime.now(), endTime).getSeconds();
            if (timeleft > 0L && timeleft < today.getTimeleft()) {
                today.setTimeleft(timeleft);
            }
        }

        return new ArrayList<>(tabCaches.values());
    }


    public void onResetOpenServerDate(LocalDate openServerDate) {
        LocalDateTime now = LocalDateTime.now();
        GameData.Revelrys.values().stream().filter(v -> (v.isOpen == 1)).forEach(v -> {
            ScheduledFuture<?> future = settlementFutureMap.get(v.tabID);
            if (future != null) {
                future.cancel(true);
            }
            LocalDateTime endTime = openServerDate.plusDays(v.endDays1).atTime(0, 0, 0, 0);
            if (now.isBefore(endTime)) {
                long timeleft = Duration.between(now, endTime).getSeconds();
                settlementFutureMap.put(v.tabID, JobFactory.addDelayJob((), timeleft * 1000L));
                Out.info(new Object[]{"冲榜活动添加结果任务. tabID=", v.tabID, ",timeleft=", Long.valueOf(timeleft)});
            }
        });
    }


    public void settlementResult(String tabID) {
        Out.info(new Object[]{"冲榜活动结算。tabID=", tabID});

        RevelryCO template = (RevelryCO) GameData.Revelrys.get(tabID);
        RankType rankType = getInstance().toRankType(template.activityKey);
        Map<Integer, SimpleRankData> rankMap = rankType.getHandler().copyRankToKey(tabID);

        List<RevelryConfigCO> configs = GameData.findRevelryConfigs(v -> tabID.equals(v.type));
        for (RevelryConfigCO config : configs) {
            for (int rank = config.parameter1; rank <= config.parameter2; rank++) {
                SimpleRankData rankData = rankMap.get(Integer.valueOf(rank));
                if (rankData != null) {


                    if (isGuildRankKey(template.activityKey)) {
                        sendGuildRankReward(config, template.tabName, rankData.getId(), rank);

                    } else {

                        List<MailData.Attachment> attachments = new ArrayList<>();
                        buildAttachment(attachments, config.item1code, config.num1);
                        buildAttachment(attachments, config.item2code, config.num2);
                        buildAttachment(attachments, config.item3code, config.num3);
                        buildAttachment(attachments, config.item4code, config.num4);

                        sendPlayerRankReward(template.tabName, rankData.getId(), rank, attachments);
                    }
                }
            }
        }
        Out.info(new Object[]{"冲榜活动结算结束。tabID=", tabID});
    }


    private void sendGuildRankReward(RevelryConfigCO config, String rankName, String guildId, int rank) {
        ArrayList<GuildMemberPO> members = GuildServiceCenter.getInstance().getGuildMemberList(guildId);
        for (GuildMemberPO member : members) {
            List<MailData.Attachment> attachments = new ArrayList<>();


            if (member.job == Const.GuildJob.PRESIDENT.getValue()) {
                buildAttachment(attachments, config.item1code, config.num1);
                buildAttachment(attachments, config.item2code, config.num2);
            } else {

                buildAttachment(attachments, config.item3code, config.num3);
                buildAttachment(attachments, config.item4code, config.num4);
            }

            sendPlayerRankReward(rankName, member.playerId, rank, attachments);
        }
    }

    private void sendPlayerRankReward(String rankName, String playerId, int rank, List<MailData.Attachment> attachments) {
        try {
            MailSysData mailData = new MailSysData("RankRevelryReward");
            mailData.attachments = attachments;


            mailData.replace = new HashMap<>();
            mailData.replace.put("rankName", rankName);
            mailData.replace.put("rank", String.valueOf(rank));

            MailUtil.getInstance().sendMailToOnePlayer(playerId, (MailData) mailData, Const.GOODS_CHANGE_TYPE.REVELRY);
        } catch (Exception e) {
            Out.warn(new Object[]{"冲榜活动结算时发放奖励异常.rank=", Integer.valueOf(rank), ",playerId=", playerId});
        }
    }

    private void buildAttachment(List<MailData.Attachment> attachments, String itemCode, int itemNum) {
        if (StringUtils.isNotEmpty(itemCode)) {
            MailData.Attachment item = new MailData.Attachment();
            item.itemCode = itemCode;
            item.itemNum = itemNum;
            attachments.add(item);
        }
    }
}


