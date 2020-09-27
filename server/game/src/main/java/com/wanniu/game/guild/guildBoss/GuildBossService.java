package com.wanniu.game.guild.guildBoss;

import com.wanniu.core.GGame;
import com.wanniu.core.db.GCache;
import com.wanniu.core.game.JobFactory;
import com.wanniu.core.game.entity.GPlayer;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.DateUtil;
import com.wanniu.core.util.StringUtil;
import com.wanniu.game.GWorld;
import com.wanniu.game.area.Area;
import com.wanniu.game.area.AreaUtil;
import com.wanniu.game.auction.AuctionService;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.ConstsTR;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.GuildBossRatioCO;
import com.wanniu.game.data.base.MapBase;
import com.wanniu.game.data.base.MonsterBase;
import com.wanniu.game.data.ext.GuildSettingExt;
import com.wanniu.game.data.ext.RankRewardExt;
import com.wanniu.game.guild.GuildService;
import com.wanniu.game.guild.GuildUtil;
import com.wanniu.game.item.NormalItem;
import com.wanniu.game.mail.MailUtil;
import com.wanniu.game.mail.data.MailData;
import com.wanniu.game.mail.data.MailSysData;
import com.wanniu.game.monster.GuildBossRatioConfig;
import com.wanniu.game.monster.MonsterConfig;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.rank.handler.GuildBossPreRankGuildHandler;
import com.wanniu.game.rank.handler.GuildBossPreRankSingleHandler;
import com.wanniu.game.rank.handler.GuildBossRankGuildHandler;
import com.wanniu.game.rank.handler.GuildBossRankSingleHandler;
import com.wanniu.game.task.TaskEvent;
import com.wanniu.game.task.TaskQueue;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.time.DateUtils;


public class GuildBossService {
    public static final int GUILDBOSS_MAP_ID = 52001;
    public static final int GUILDBOSS_BOSS_ID = 552001;
    private MapBase arenaMap;
    private Calendar cal = Calendar.getInstance();
    private ScheduledFuture<?> overSchedule;
    private int guildBossLevel = 0;
    private Date guildBossUpgradeDate;
    private static final GuildBossService instance = new GuildBossService();

    public void init() {
        boolean isOpenTime = isInOpenTime();
        if (isOpenTime) {
            GuildBossCenter.getInstance().onBegin();
        }
        GuildSettingExt settingProp = GuildUtil.getGuildSettingExtProp();

        Date begin = DateUtil.format(settingProp.gBossOpenTime);
        Date preEnd = DateUtil.format(settingProp.gBossCloseTime);
        addBeginSchedule(begin);
        addPreEndSchedule(preEnd);


        initGuildBossLevel();
    }

    private void initGuildBossLevel() {
        String data = GCache.hget(Integer.toString(GWorld.__SERVER_ID), ConstsTR.GuildBossTR.value);
        if (StringUtil.isEmpty(data)) {
            MonsterBase base = MonsterConfig.getInstance().get(552001);
            this.guildBossLevel = base.level;
        } else {
            this.guildBossLevel = Integer.parseInt(data);
        }
        Out.info(new Object[]{"初始化仙盟Boss升级. level=", Integer.valueOf(this.guildBossLevel)});
    }


    public int getGuildBossLevel() {
        if (this.guildBossLevel == 0) {
            return (MonsterConfig.getInstance().get(552001)).level;
        }
        return this.guildBossLevel;
    }


    public synchronized void upgradeGuildBoss() {
        int newLv = this.guildBossLevel + GlobalConfig.GuildBoss_GrowLevel;
        GuildBossRatioCO co = GuildBossRatioConfig.getGuildBossRatioCO(newLv);
        if (co != null) {
            Date now = new Date();
            if (this.guildBossUpgradeDate == null || !DateUtils.isSameDay(this.guildBossUpgradeDate, now)) {
                this.guildBossUpgradeDate = now;
                this.guildBossLevel++;
                GCache.hset(Integer.toString(GWorld.__SERVER_ID), ConstsTR.GuildBossTR.value, String.valueOf(this.guildBossLevel));
                Out.info(new Object[]{"仙盟Boss升级. level=", Integer.valueOf(this.guildBossLevel)});
            }
        } else {
            Out.info(new Object[]{"仙盟Boss已满级. level=", Integer.valueOf(this.guildBossLevel)});
        }
    }

    public void gmBegin() {
        onGuildBossOpen();
        if (this.overSchedule != null) {
            this.overSchedule.cancel(false);
            this.overSchedule = null;
        }
    }

    public void gmEnd() {
        if (!GuildBossCenter.getInstance().isOpen() || this.overSchedule != null) {
            return;
        }
        processGuildBossPreOver();
    }


    private void processGuildBossPreOver() {
        if (!GuildBossCenter.getInstance().isOpen()) {
            return;
        }
        GuildBossCenter.getInstance().onOver();
        pushAllScenesClose();
        staticsAllRank();
        this.overSchedule = JobFactory.addDelayJob(() -> onGuildBossClosed(), ((GlobalConfig.GuildBoss_LeaveTime + 2) * 1000));
    }


    public void addBeginSchedule(Date date) {
        JobFactory.addScheduleJob(new Runnable() {
            public void run() {
                GuildBossService.this.onGuildBossOpen();
            }
        }, DateUtil.getTaskDelay(date), TimeUnit.DAYS.toMillis(1L));
    }


    public void addPreEndSchedule(Date date) {
        JobFactory.addScheduleJob(new Runnable() {
            public void run() {
                GuildBossService.this.onGuildPreClosed();
            }
        }, DateUtil.getTaskDelay(date), TimeUnit.DAYS.toMillis(1L));
    }

    public void onGuildBossOpen() {
        Out.info(new Object[]{"工会BOSS活动开始了。。。。"});
        GWorld.getInstance().ansycExec(() -> processGuildBossOpen());
    }


    private void processGuildBossOpen() {
        if (GuildBossCenter.getInstance().isOpen()) {
            return;
        }
        processPreStaticDataToToday();
        checkBeforeBegin();
        GuildBossCenter.getInstance().onBegin();
        pointAll();
    }


    private void processPreStaticDataToToday() {
        processPreStaticSingleDataToToday();
        processPreStaticGuildDataToToday();
    }


    private void processPreStaticSingleDataToToday() {
        List<RankBean> todayList = GuildBossRankSingleHandler.getInstance().getDataList();
        GuildBossPreRankSingleHandler.getInstance().putStaticData(todayList);
    }


    private void processPreStaticGuildDataToToday() {
        List<GuildBossAreaHurtRankCenter.GuildStaticRankBean> todayList = GuildBossRankGuildHandler.getInstance().getDataList();
        GuildBossPreRankGuildHandler.getInstance().putStaticData(todayList);
    }


    public void pointAll() {
        Map<String, GPlayer> map = GGame.getInstance().getOnlinePlayers();
        if (map != null && !map.isEmpty()) {
            Collection<GPlayer> playerIds = map.values();
            for (GPlayer player : playerIds) {
                ((WNPlayer) player).guildBossManager.pushScripts();
            }
        }
    }

    private void checkBeforeBegin() {
        Map<String, String> maps = GuildBossCenter.getInstance().getHasEnterGuildIds();
        if (maps != null && !maps.isEmpty()) {
            StringBuffer sb = new StringBuffer();
            Set<Map.Entry<String, String>> sets = maps.entrySet();
            for (Map.Entry<String, String> e : sets) {
                String guildId = e.getKey();
                String instanceId = e.getValue();
                sb.append(guildId).append(",").append(instanceId);
                Area area = AreaUtil.getArea(instanceId);
                if (area != null) {
                    area.dispose(false);
                    sb.append(",scene not null");
                }
            }
            Out.warn(new Object[]{"在仙盟BOSS活动开始的时候发现有遗留场景留下来！！！！开始处理...赶紧查问题！！！[", sb.toString(), "]"});
        }

        GuildBossCenter.getInstance().clear();
        GuildBossAreaHurtRankCenter.getInstance().clearOldData();
    }


    private void processGuildBossOver() {
        if (this.overSchedule != null) {
            this.overSchedule.cancel(false);
            this.overSchedule = null;
        }
        processAllSceneOver();
        GuildBossCenter.getInstance().clear();
    }


    public void staticsAllRank() {
        TaskQueue.put(new TaskEvent(Const.EventType.statics_ranks, new Object[0]));
    }


    public void processStaticsAllRanks() {
        List<RankBean> worldRanks = new ArrayList<>();
        List<GuildRankBean> guildList = new ArrayList<>();
        Map<String, GuildRankBean> map = GuildBossAreaHurtRankCenter.getInstance().getDataMap();
        if (map != null && !map.isEmpty()) {
            Set<String> sets = map.keySet();
            for (String guildId : sets) {
                GuildBossAreaHurtRankCenter.getInstance().processOver(guildId);
                GuildRankBean bean = GuildBossAreaHurtRankCenter.getInstance().onlyGetGuildRankBean(guildId);
                if (bean == null) {
                    continue;
                }
                guildList.add(bean);
                if (bean.getHurtList() != null && !bean.getHurtList().isEmpty()) {
                    worldRanks.addAll(bean.getHurtList());
                }
            }
        }
        Collections.sort(worldRanks, GuildBossAreaHurtRankCenter.SORT_HURT);
        Collections.sort(guildList, GuildBossAreaHurtRankCenter.SORT_GUILD);
        Collections.sort(guildList, GuildBossAreaHurtRankCenter.SORT_GUILD_HURT);
        sendSingleRankReward(worldRanks);
        sendFirstKillReward(guildList);
        sendGuildRank(guildList);
        sendGuildKilledReward(guildList);
    }


    public List<RankBean> getWorldSingleRank() {
        List<RankBean> worldRanks = new ArrayList<>();
        Map<String, GuildRankBean> map = GuildBossAreaHurtRankCenter.getInstance().getDataMap();
        if (map != null && !map.isEmpty()) {
            Set<String> sets = map.keySet();
            for (String guildId : sets) {
                GuildRankBean bean = GuildBossAreaHurtRankCenter.getInstance().onlyGetGuildRankBean(guildId);
                if (bean == null) {
                    continue;
                }
                if (bean.getHurtList() != null && !bean.getHurtList().isEmpty()) {
                    worldRanks.addAll(bean.getHurtList());
                }
            }
        }
        if (worldRanks != null && !worldRanks.isEmpty()) {
            Collections.sort(worldRanks, GuildBossAreaHurtRankCenter.SORT_HURT);
        }
        return worldRanks;
    }

    public List<GuildRankBean> getGuildRankSort() {
        List<GuildRankBean> guildRanks = new ArrayList<>();
        Map<String, GuildRankBean> map = GuildBossAreaHurtRankCenter.getInstance().getDataMap();
        if (map != null && !map.isEmpty()) {
            Set<String> sets = map.keySet();
            for (String guildId : sets) {
                GuildRankBean bean = GuildBossAreaHurtRankCenter.getInstance().onlyGetGuildRankBean(guildId);
                if (bean == null) {
                    continue;
                }
                guildRanks.add(bean);
            }
        }
        if (guildRanks != null && !guildRanks.isEmpty()) {
            Collections.sort(guildRanks, GuildBossAreaHurtRankCenter.SORT_GUILD_ONLY_HURT);
        }
        return guildRanks;
    }


    private void sendFirstKillReward(List<GuildRankBean> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        GuildRankBean bean = list.get(0);
        RankRewardExt co = getRankRewardExt(3, 1, 1);
        if (co == null) {
            Out.warn(new Object[]{"在发送仙盟BOSS工会首杀奖励的时候发现拿不到配表！guildId=", bean.getGuildId()});
            return;
        }
        if (!bean.hasKilled()) {
            Out.info(new Object[]{"本次仙盟BOSS没有工会击杀BOSS"});
            return;
        }
        Out.info(new Object[]{"在仙盟活动中,有个工会获取了首杀奖励,奖励准备上拍卖。。guildId=", bean.getGuildId()});
        AuctionService.getInstance().addAuctionItem(co.getList(), bean.getGuildId(), co.rewardSource);
        AuctionService.getInstance().processGuildAuctionsPoint(bean.getGuildId());
    }


    private void sendGuildRank(List<GuildRankBean> list) {
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                GuildRankBean bean = list.get(i);
                int rank = i + 1;
                RankRewardExt co = getRankRewardExt(2, rank, 1);
                if (co == null) {
                    Out.warn(new Object[]{"在发送仙盟BOSS世界个人排名奖励的时候发现根据某个名次拿不到配表！rank=", Integer.valueOf(rank)});

                } else if (bean.getTotalHurt() > 0L) {


                    Out.info(new Object[]{"在仙盟活动中,有个工会获取了排名奖励,奖励准备上拍卖。。guildId=", bean.getGuildId(), "排名=", Integer.valueOf(rank)});
                    AuctionService.getInstance().addAuctionItem(co.getList(), bean.getGuildId(), co.rewardSource);
                    List<NormalItem> randoms = co.getRandomReward();
                    if (randoms != null && !randoms.isEmpty()) {
                        Out.info(new Object[]{"在仙盟活动中,有个工会获取了随机排名奖励,奖励准备上拍卖。。guildId=", bean.getGuildId(), "排名=", Integer.valueOf(rank)});
                        AuctionService.getInstance().addAuctionItem(randoms, bean.getGuildId(), co.rewardSource);
                    }


                    GuildService.addGuildMoneyByGuildBoss(bean.getGuildId(), co, rank);

                    AuctionService.getInstance().processGuildAuctionsPoint(bean.getGuildId());
                }
            }
            GuildBossRankGuildHandler.getInstance().putStaticData(copyList(list));
        }
    }

    private List<GuildBossAreaHurtRankCenter.GuildStaticRankBean> copyList(List<GuildRankBean> list) {
        List<GuildBossAreaHurtRankCenter.GuildStaticRankBean> newList = new ArrayList<>();
        if (list != null && !list.isEmpty()) {
            for (GuildRankBean rb : list) {
                newList.add(GuildBossAreaHurtRankCenter.GuildStaticRankBean.getGuildStaticRankBean(rb));
            }
        }
        return newList;
    }


    public void sendGuildKilledReward(List<GuildRankBean> list) {
        RankRewardExt co = getRankRewardExt(4, 1, 1);
        if (co == null) {
            Out.warn(new Object[]{"在发送仙盟BOSS击杀奖励拿不到配表！"});
            return;
        }
        for (GuildRankBean bean : list) {
            if (bean.hasKilled()) {
                Out.info(new Object[]{"在仙盟活动中,有个工会击杀了BOSS,奖励准备上拍卖。。guildId=", bean.getGuildId()});
                AuctionService.getInstance().addAuctionItem(co.getList(), bean.getGuildId(), co.rewardSource);
                AuctionService.getInstance().processGuildAuctionsPoint(bean.getGuildId());
            }
        }
    }


    private void sendSingleRankReward(List<RankBean> worldRanks) {
        if (worldRanks != null && !worldRanks.isEmpty()) {
            for (int i = 0; i < worldRanks.size(); i++) {
                RankBean bean = worldRanks.get(i);
                int rank = i + 1;
                RankRewardExt co = getRankRewardExt(1, rank, 0);
                if (co == null) {
                    Out.warn(new Object[]{"在发送仙盟BOSS世界个人排名奖励的时候发现根据某个名次拿不到配表！rank=", Integer.valueOf(rank)});
                } else {

                    sendMail(bean.getId(), rank, co.getList());
                }
            }
            GuildBossRankSingleHandler.getInstance().putStaticData(worldRanks);
        }
    }

    private void sendMail(String playerId, int rank, List<NormalItem> list) {
        MailSysData mailData = new MailSysData("GuildBossSoloReward");
        Map<String, String> replace = new HashMap<>();
        replace.put("rank", String.valueOf(rank));
        mailData.replace = replace;
        mailData.attachments = new ArrayList();
        if (list != null && !list.isEmpty()) {
            for (NormalItem attach : list) {
                MailData.Attachment item = new MailData.Attachment();
                item.itemCode = attach.itemCode();
                item.itemNum = attach.getNum();
                mailData.attachments.add(item);
            }
        }
        MailUtil.getInstance().sendMailToOnePlayer(playerId, (MailData) mailData, Const.GOODS_CHANGE_TYPE.GUILD_BOSS);
    }

    private RankRewardExt getRankRewardExt(int rankType, int rank, int auction) {
        List<RankRewardExt> props = GameData.findRankRewards(t ->
                (t.rankType == rankType && rank >= t.startRank && rank <= t.stopRank && t.isAuction == auction));

        if (props != null && !props.isEmpty()) {
            return props.get(0);
        }
        return null;
    }


    public void pushAllScenesClose() {
        Map<String, String> maps = GuildBossCenter.getInstance().getHasEnterGuildIds();
        if (maps != null && !maps.isEmpty()) {
            Set<Map.Entry<String, String>> sets = maps.entrySet();
            for (Map.Entry<String, String> e : sets) {
                String instanceId = e.getValue();
                Area area = AreaUtil.getArea(instanceId);
                if (area != null) {
                    ((GuildBossArea) area).preOverProcess();
                }
            }
        }
    }

    public void processAllSceneOver() {
        Map<String, String> maps = GuildBossCenter.getInstance().getHasEnterGuildIds();
        if (maps != null && !maps.isEmpty()) {
            Set<Map.Entry<String, String>> sets = maps.entrySet();
            for (Map.Entry<String, String> e : sets) {
                String instanceId = e.getValue();
                Area area = AreaUtil.getArea(instanceId);
                if (area != null) {
                    ((GuildBossArea) area).onGameOver();
                    AreaUtil.closeArea(instanceId);
                }
            }
        }
    }

    public void onGuildPreClosed() {
        Out.info(new Object[]{"工会BOSS活动快结束了。。。。"});
        GWorld.getInstance().ansycExec(() -> processGuildBossPreOver());
    }


    public void onGuildBossClosed() {
        Out.info(new Object[]{"工会BOSS活动结束了。。。。"});
        GWorld.getInstance().ansycExec(() -> processGuildBossOver());
    }


    public Area enterGuildBossSence(WNPlayer player, int bossLevel) {
        Map<String, Object> userData = new HashMap<>();
        userData.put("lv", Integer.valueOf(bossLevel));
        return AreaUtil.dispatchByAreaId(player, 52001, userData);
    }

    public MapBase getGuildBossMap() {
        if (this.arenaMap == null) {
            this.arenaMap = AreaUtil.getAreaProp(52001);
        }
        return this.arenaMap;
    }

    public boolean isInOpenTime() {
        long now = System.currentTimeMillis();
        this.cal.setTimeInMillis(now);

        int hours = this.cal.get(11);
        int minutes = this.cal.get(12);

        GuildSettingExt prop = GuildUtil.getGuildSettingExtProp();
        if (hours < prop.guildBossBeginHours || hours > prop.guildBossEndHours) {
            return false;
        }
        if (prop.guildBossBeginHours == prop.guildBossEndHours) {
            if (hours == prop.guildBossBeginHours &&
                    minutes >= prop.guildBossBeginMinutes && minutes < prop.guildBossEndMinutes) {
                return true;
            }
        } else if (prop.guildBossBeginHours < prop.guildBossEndHours) {
            if (hours == prop.guildBossBeginHours) {
                if (minutes >= prop.guildBossBeginMinutes)
                    return true;
            } else {
                if (hours > prop.guildBossBeginHours && hours < prop.guildBossEndHours)
                    return true;
                if (hours == prop.guildBossEndHours &&
                        minutes < prop.guildBossEndMinutes) {
                    return true;
                }
            }
        }
        return false;
    }


    public int getEndSeconds() {
        Calendar cal = Calendar.getInstance();
        int hours = cal.get(11);
        int minutes = cal.get(12);
        int seconds = cal.get(13);
        GuildSettingExt prop = GuildUtil.getGuildSettingExtProp();
        if (hours > prop.guildBossEndHours) {
            return 0;
        }
        int total = 0;
        total += (prop.guildBossEndHours - hours) * 3600;
        if (minutes >= prop.guildBossEndMinutes && total == 0) {
            return 0;
        }
        total += (prop.guildBossEndMinutes - minutes) * 60;
        total -= seconds;
        return total;
    }


    public static GuildBossService getInstance() {
        return instance;
    }
}


