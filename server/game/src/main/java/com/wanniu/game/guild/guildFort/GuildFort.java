package com.wanniu.game.guild.guildFort;

import com.google.protobuf.GeneratedMessage;
import com.wanniu.core.db.GCache;
import com.wanniu.core.game.JobFactory;
import com.wanniu.core.game.LangService;
import com.wanniu.core.logfs.Out;
import com.wanniu.game.area.Area;
import com.wanniu.game.area.AreaUtil;
import com.wanniu.game.area.DamageHealVO;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.Utils;
import com.wanniu.game.common.msg.MessagePush;
import com.wanniu.game.data.ext.GuildFortExt;
import com.wanniu.game.guild.GuildServiceCenter;
import com.wanniu.game.guild.GuildUtil;
import com.wanniu.game.guild.guildFort.dao.GuildFortBattleReportPO;
import com.wanniu.game.guild.guildFort.dao.GuildFortBidderPO;
import com.wanniu.game.guild.guildFort.dao.GuildFortContenderPO;
import com.wanniu.game.guild.guildFort.dao.GuildFortMemberPO;
import com.wanniu.game.guild.guildFort.dao.GuildFortPO;
import com.wanniu.game.item.ItemUtil;
import com.wanniu.game.item.NormalItem;
import com.wanniu.game.mail.MailUtil;
import com.wanniu.game.mail.data.MailData;
import com.wanniu.game.mail.data.MailSysData;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.GuildPO;
import com.wanniu.game.rank.RankType;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import pomelo.area.GuildFortHandler;
import pomelo.item.ItemOuterClass;


public class GuildFort {
    private GuildFortExt fortConfig = null;
    private GuildFortPO po = null;


    private boolean battleOver = false;

    public GuildFortContenderPO defenser = null;
    public GuildFortContenderPO attacker = null;

    private GuildFortPveArea defPrepareArea = null;
    private GuildFortPveArea attPrepareArea = null;
    private GuildFortPveArea defPveArea = null;
    private GuildFortPveArea attPveArea = null;
    private GuildFortPvpArea pvpArea = null;


    public GuildFort(GuildFortExt fortConfig) {
        this.fortConfig = fortConfig;
        this.po = new GuildFortPO();
        this.po.fortId = fortConfig.iD;
    }

    public void setPo(GuildFortPO guildFortPO) {
        this.po = guildFortPO;
    }

    public GuildFortPO getPo() {
        return this.po;
    }


    public List<ItemOuterClass.MiniItem> getWinnerReward() {
        List<ItemOuterClass.MiniItem> res = new ArrayList<>();
        for (String key : this.fortConfig.winnerReward.keySet()) {
            ItemOuterClass.MiniItem.Builder data = ItemUtil.getMiniItemData(key, ((Integer) this.fortConfig.winnerReward.get(key)).intValue());
            res.add(data.build());
        }

        return res;
    }

    public List<ItemOuterClass.MiniItem> getDailyAward() {
        List<ItemOuterClass.MiniItem> res = new ArrayList<>();
        for (String key : this.fortConfig.dailyReward.keySet()) {
            ItemOuterClass.MiniItem.Builder data = ItemUtil.getMiniItemData(key, ((Integer) this.fortConfig.dailyReward.get(key)).intValue());
            res.add(data.build());
        }

        return res;
    }

    public List<NormalItem> generateDailyAward() {
        return ItemUtil.createItemsByItemCode(this.fortConfig.dailyReward);
    }


    public int getId() {
        return this.fortConfig.iD;
    }


    public String getOccupyGuildId() {
        return GCache.hget("Tradenionstrongholds", String.valueOf(this.po.fortId));
    }

    public String getOccupyGuildIds() {
        return this.po.occupyGuildId;
    }

    public boolean isOccupier(String guildId) {
        String id = GCache.hget("Tradenionstrongholds", String.valueOf(this.po.fortId));
        if (id != null && id.equals(guildId)) {
            return true;
        }
        return false;
    }


    public int commitBidFund(String guildId, int fund) {
        GuildPO guild = GuildServiceCenter.getInstance().getGuild(guildId);
        int sumFund = 0;
        if (guild != null) {
            Out.info(new Object[]{"Apply fund guild id:", guild.id, " original fund:", Long.valueOf(guild.fund), " to deduct fund:" + fund});
            guild.fund -= fund;

            boolean isIn = false;
            for (GuildFortBidderPO bidder : this.po.bidders) {
                if (bidder.guildId.equals(guildId)) {
                    if (bidder.fund + fund > Integer.MAX_VALUE) {
                        Out.error(new Object[]{"Bid fund overflowed, guildId:" + guildId, " biddedFund:", Integer.valueOf(bidder.fund), " toAdd fund:", Integer.valueOf(fund)});
                        return sumFund;
                    }
                    bidder.fund += fund;
                    sumFund = bidder.fund;
                    isIn = true;

                    break;
                }
            }
            if (!isIn) {
                GuildFortBidderPO bidder = new GuildFortBidderPO(guildId, fund);
                this.po.bidders.add(bidder);
                sumFund = bidder.fund;
            }
        } else {
            Out.warn(new Object[]{"Can't find the guild when commitBidFund by guildId=", guildId, " and fund=", Integer.valueOf(fund)});
        }

        return sumFund;
    }


    public int extractBidFund(String guildId) {
        int index = getInBiddersIndex(guildId);
        if (index != -1 && index < this.po.bidders.size()) {
            GuildFortBidderPO bidder = this.po.bidders.remove(index);
            Out.info(new Object[]{"Apply cancel all bidded fund, guild id=", guildId, "  fund=", Integer.valueOf(bidder.fund)});

            return returnBidFund(guildId, bidder.fund);
        }
        return 0;
    }

    private int getInBiddersIndex(String guildId) {
        int index = 0;
        for (GuildFortBidderPO bidder : this.po.bidders) {
            if (bidder.guildId.equals(guildId)) {
                return index;
            }
            index++;
        }
        return -1;
    }


    private void sendBidSucMail(String guildId, int fund) {
        GuildPO guild = GuildServiceCenter.getInstance().getGuild(guildId);

        MailSysData mailData = new MailSysData("GuildFortBidSuccess");
        mailData.replace = new HashMap<>();
        mailData.replace.put("guildname", guild.name);
        mailData.replace.put("fund", String.valueOf(fund));
        mailData.replace.put("fortname", getName());
        mailData.replace.put("fighttime", GuildFortService.getInstance().getBattleBeginTimeString());
        Set<String> ids = GuildUtil.getGuildMemberIdList(guildId);
        MailUtil.getInstance().sendMailToSomePlayer(ids.<String>toArray(new String[ids.size()]), (MailData) mailData, Const.GOODS_CHANGE_TYPE.guild_mail);
    }


    private void sendBidFailMail(String guildId, int fund) {
        GuildPO guild = GuildServiceCenter.getInstance().getGuild(guildId);

        MailSysData mailData = new MailSysData("GuildFortBidFailed");
        mailData.replace = new HashMap<>();
        mailData.replace.put("guildname", guild.name);
        mailData.replace.put("fund", String.valueOf(fund));
        mailData.replace.put("fortname", getName());

        Set<String> ids = GuildUtil.getGuildMemberIdList(guildId);
        MailUtil.getInstance().sendMailToSomePlayer(ids.<String>toArray(new String[ids.size()]), (MailData) mailData, Const.GOODS_CHANGE_TYPE.guild_mail);
    }


    private void sendBattleWinMail(GuildPO guild, int score, GuildFortContenderPO opponent) {
        String opponentName = "";
        if (opponent != null) {
            opponentName = opponent.guildName;
        }

        MailSysData mailData = new MailSysData("GuildFortNotifyBattleEndForWin");
        mailData.replace = new HashMap<>();
        mailData.replace.put("fortname", getName());
        mailData.replace.put("point", String.valueOf(score));
        mailData.replace.put("guildname", opponentName);

        ArrayList<MailData.Attachment> list = new ArrayList<>();
        for (String itemCode : this.fortConfig.winnerReward.keySet()) {
            MailData.Attachment attach = new MailData.Attachment();
            attach.itemCode = itemCode;
            attach.itemNum = ((Integer) this.fortConfig.winnerReward.get(itemCode)).intValue();
            list.add(attach);
        }
        mailData.attachments = list;

        Set<String> ids = GuildUtil.getGuildMemberIdList(guild.id);
        MailUtil.getInstance().sendMailToSomePlayer(ids.<String>toArray(new String[ids.size()]), (MailData) mailData, Const.GOODS_CHANGE_TYPE.guild_mail);
    }


    private void sendBattleFailMail(GuildPO guild, int score, GuildFortContenderPO opponent) {
        String opponentName = "";
        if (opponent != null) {
            opponentName = opponent.guildName;
        }

        MailSysData mailData = new MailSysData("GuildFortNotifyBattleEndForLose");
        mailData.replace = new HashMap<>();
        mailData.replace.put("fortname", getName());
        mailData.replace.put("point", String.valueOf(score));
        mailData.replace.put("guildname", opponentName);

        ArrayList<MailData.Attachment> list = new ArrayList<>();
        for (String itemCode : this.fortConfig.loserReward.keySet()) {
            MailData.Attachment attach = new MailData.Attachment();
            attach.itemCode = itemCode;
            attach.itemNum = ((Integer) this.fortConfig.loserReward.get(itemCode)).intValue();
            list.add(attach);
        }
        mailData.attachments = list;

        Set<String> ids = GuildUtil.getGuildMemberIdList(guild.id);
        MailUtil.getInstance().sendMailToSomePlayer(ids.<String>toArray(new String[ids.size()]), (MailData) mailData, Const.GOODS_CHANGE_TYPE.guild_mail);
    }


    public boolean isInBidders(String guildId) {
        return (getInBiddersIndex(guildId) != -1);
    }


    public void onBidOver() {
        calcBidResult();
    }


    private void buildReport() {
        GuildFortBattleReportPO report = new GuildFortBattleReportPO();
        report.fortId = this.fortConfig.iD;
        report.fortName = this.fortConfig.name;
        if (this.defenser != null) {
            this.defenser.build();
            report.defenser = this.defenser;
        } else {
            report.defenser = new GuildFortContenderPO();
        }

        if (this.attacker != null) {
            this.attacker.build();
            report.attacker = this.attacker;
        } else {
            report.attacker = new GuildFortContenderPO();
        }

        GuildFortCenter.getInstance().addBattleReport(report);
    }


    private void updateWinTimes(GuildFortContenderPO po, boolean isWin, GuildFortContenderPO opponent) {
        GuildPO guild = GuildServiceCenter.getInstance().getGuild(po.guildId);
        if (guild != null) {
            guild.fortInfo.onStat(isWin);
            if (isWin) {
                sendBattleWinMail(guild, po.getScore(), opponent);
                po.setWinner(true);
            } else {
                sendBattleFailMail(guild, po.getScore(), opponent);
            }
        } else {
            Out.error(new Object[]{"can't find the guild when updateWinTimes, guildId=", po.guildId, " isWin=", Boolean.valueOf(isWin)});
        }
    }

    private void setNobodyOccupied() {
        this.po.occupyGuildId = null;
    }

    private void calcBidResult() {
        System.out.println("-----------------------------------------------------------------------------::::::result:::::");
        List<GuildFortBidderPO> toSort = this.po.bidders;
        toSort.sort(new Comparator<GuildFortBidderPO>() {
            public int compare(GuildFortBidderPO o1, GuildFortBidderPO o2) {
                if (o1.fund < o2.fund)
                    return 1;
                if (o1.fund > o2.fund) {
                    return -1;
                }
                return 0;
            }
        });

        int size = toSort.size();
        if (size == 0) {
            this.defenser = null;
            this.attacker = null;
        } else if (size == 1) {
            this.defenser = new GuildFortContenderPO(((GuildFortBidderPO) toSort.get(0)).guildId);
            this.attacker = null;
            sendBidSucMail(this.defenser.guildId, ((GuildFortBidderPO) toSort.get(0)).fund);
        } else {
            this.defenser = new GuildFortContenderPO(((GuildFortBidderPO) toSort.get(0)).guildId);
            this.attacker = new GuildFortContenderPO(((GuildFortBidderPO) toSort.get(1)).guildId);
            sendBidSucMail(this.defenser.guildId, ((GuildFortBidderPO) toSort.get(0)).fund);
            sendBidSucMail(this.attacker.guildId, ((GuildFortBidderPO) toSort.get(1)).fund);
        }

        for (int i = 2; i < size; i++) {
            GuildFortBidderPO bidder = toSort.get(i);
            returnBidFund(bidder.guildId, bidder.fund);
            sendBidFailMail(bidder.guildId, bidder.fund);
        }
    }

    private void calcBattleResult() {
        this.po.occupyGuildId = null;
        if (this.defenser == null && this.attacker == null) {
            this.po.occupyGuildId = null;
            return;
        }
        if (this.defenser != null && this.attacker == null) {
            if (this.defenser.getScore() >= GlobalConfig.GuildFort_MinWinPoint) {
                this.po.occupyGuildId = this.defenser.getGuildId();
                updateWinTimes(this.defenser, true, this.attacker);
            } else {
                this.po.occupyGuildId = null;
                updateWinTimes(this.defenser, false, this.attacker);
            }
            return;
        }
        if (this.defenser != null && this.attacker != null) {
            if (this.defenser.getScore() < this.attacker.getScore()) {
                if (this.attacker.getScore() >= GlobalConfig.GuildFort_MinWinPoint) {
                    this.po.occupyGuildId = this.attacker.getGuildId();
                    updateWinTimes(this.attacker, true, this.defenser);
                } else {
                    updateWinTimes(this.attacker, false, this.defenser);
                }
                updateWinTimes(this.defenser, false, this.attacker);
            } else {
                if (this.defenser.getScore() >= GlobalConfig.GuildFort_MinWinPoint) {
                    this.po.occupyGuildId = this.defenser.getGuildId();
                    updateWinTimes(this.defenser, true, this.attacker);
                } else {
                    updateWinTimes(this.defenser, false, this.attacker);
                }
                updateWinTimes(this.attacker, false, this.defenser);
            }

            return;
        }
        this.po.occupyGuildId = null;
    }


    private int returnBidFund(String guildId, int fund) {
        GuildPO guild = GuildServiceCenter.getInstance().getGuild(guildId);
        if (guild != null) {
            int deductedFund = fund * (100 - GlobalConfig.GuildFort_BackRate) / 100;
            guild.fund += deductedFund;
            Out.info(new Object[]{"return Bid Fund guild id=", guildId, "  fund=", Integer.valueOf(fund)});
            return deductedFund;
        }
        Out.warn(new Object[]{"Can't find the guild when return bidFund by guildId=", guildId, " return fund=", Integer.valueOf(fund)});


        return 0;
    }

    private void broadcastBattleOver() {
        String guildId = getOccupyGuildId();
        if (guildId != null) {
            GuildPO guild = GuildServiceCenter.getInstance().getGuild(guildId);
            if (guild != null) {
                String msgStr = LangService.getValue("GUILDFORT_BATTLEEND_NOTICE");
                msgStr = msgStr.replace("{fortname}", getName()).replace("{guildname}", guild.name);
                GuildFortUtil.sendRollTipsToAllAnsy(msgStr);
            } else {
                Out.warn(new Object[]{"Can't find guild by guildId = ", guildId});
            }
        } else {
            Out.info(new Object[]{getName(), " no one occupied..."});
        }
    }


    public List<String> getAllMemberIds() {
        List<String> ids = new ArrayList<>();
        if (this.defenser != null) {
            ids.addAll(GuildUtil.getGuildMemberIdList(this.defenser.guildId));
        }
        if (this.attacker != null) {
            ids.addAll(GuildUtil.getGuildMemberIdList(this.attacker.guildId));
        }

        return ids;
    }


    public void onBattleBegin() {
        setNobodyOccupied();
        if (this.defenser == null && this.attacker == null) {
            setBattleOver(true);
            dispose();
            return;
        }
        setBattleOver(false);
    }


    public synchronized void onBattleOver() {
        if (isBattleOver()) {
            Out.warn(new Object[]{"guild fort battle has already overed!!!"});
            return;
        }
        setBattleOver(true);
        calcBattleResult();
        pushBattleResult();
        updateRank();
        buildReport();
        broadcastBattleOver();
        dispose();
    }

    private void closeAllArea() {
        if (this.pvpArea != null) {
            AreaUtil.closeArea(this.pvpArea.instanceId);
            this.pvpArea = null;
        }
        if (this.defPveArea != null) {
            AreaUtil.closeArea(this.defPveArea.instanceId);
            this.defPveArea = null;
        }
        if (this.attPveArea != null) {
            AreaUtil.closeArea(this.attPveArea.instanceId);
            this.attPveArea = null;
        }
        if (this.defPrepareArea != null) {
            AreaUtil.closeArea(this.defPrepareArea.instanceId);
            this.defPrepareArea = null;
        }
        if (this.attPrepareArea != null) {
            AreaUtil.closeArea(this.attPrepareArea.instanceId);
            this.attPrepareArea = null;
        }
    }

    private void dispose() {
        this.po.bidders.clear();
        JobFactory.addDelayJob(new Runnable() {
            public void run() {
                GuildFort.this.closeAllArea();
            }
        }, 5000L);
        this.defenser = null;
        this.attacker = null;
    }

    public boolean isBattleOver() {
        return this.battleOver;
    }

    private void setBattleOver(boolean isOver) {
        this.battleOver = isOver;
    }


    public boolean isBattleMember(WNPlayer player) {
        return !(getContenderByPlayer(player) == null);
    }


    public Area requestEnterPrepareArea(WNPlayer player) {
        String guildId = player.guildManager.getGuildId();
        if (isDefenserMember(guildId)) {
            if (this.defPrepareArea == null) {
                Map<String, Object> userData = Utils.ofMap(new Object[]{"fortId", Integer.valueOf(getId())});
                this.defPrepareArea = (GuildFortPveArea) AreaUtil.dispatchByAreaId(player, 54001, userData);
            } else {
                AreaUtil.changeTeamArea(player, this.defPrepareArea.getAreaData());
            }
            return this.defPrepareArea;
        }

        if (isAttackerMember(guildId)) {
            if (this.attPrepareArea == null) {
                Map<String, Object> userData = Utils.ofMap(new Object[]{"fortId", Integer.valueOf(getId())});
                this.attPrepareArea = (GuildFortPveArea) AreaUtil.dispatchByAreaId(player, 54001, userData);
            } else {
                AreaUtil.changeTeamArea(player, this.attPrepareArea.getAreaData());
            }
            return this.attPrepareArea;
        }

        return null;
    }

    public Area requestEnterPveArea(WNPlayer player) {
        if (isDefenserMember(player.guildManager.getGuildId())) {
            if (this.defPveArea == null) {
                Map<String, Object> userData = Utils.ofMap(new Object[]{"fortId", Integer.valueOf(getId())});
                this.defPveArea = (GuildFortPveArea) AreaUtil.dispatchByAreaId(player, 54002, userData);
            } else {
                AreaUtil.changeTeamArea(player, this.defPveArea.getAreaData());
            }
            return this.defPveArea;
        }

        if (isAttackerMember(player.guildManager.getGuildId())) {
            if (this.attPveArea == null) {
                Map<String, Object> userData = Utils.ofMap(new Object[]{"fortId", Integer.valueOf(getId())});
                this.attPveArea = (GuildFortPveArea) AreaUtil.dispatchByAreaId(player, 54002, userData);
            } else {
                AreaUtil.changeTeamArea(player, this.attPveArea.getAreaData());
            }
            return this.attPveArea;
        }

        return null;
    }

    public Area requestEnterPvpArea(WNPlayer player) {
        if (this.pvpArea == null) {
            Map<String, Object> userData = Utils.ofMap(new Object[]{"fortId", Integer.valueOf(getId())});
            this.pvpArea = (GuildFortPvpArea) AreaUtil.dispatchByAreaId(player, 54003, userData);
        } else {
            AreaUtil.changeTeamArea(player, this.pvpArea.getAreaData());
        }

        return this.pvpArea;
    }

    public GuildFortContenderPO getContenderByPlayer(WNPlayer player) {
        return getContenderByGuildId(player.guildManager.getGuildId());
    }


    private MessagePush generateDefenserReport(GuildFortHandler.FortGuildStatistics.Builder defBuilder, GuildFortHandler.FortGuildStatistics.Builder attBuilder) {
        GuildFortHandler.OnGuildFortPush.Builder res = GuildFortHandler.OnGuildFortPush.newBuilder();
        res.setS2CCode(200);

        if (defBuilder != null) {
            res.setOwnGuild(defBuilder);
        }
        if (attBuilder != null) {
            res.setEnemyGuild(attBuilder);
        }

        return new MessagePush("area.guildFortPush.onGuildFortPush", (GeneratedMessage) res.build());
    }

    private MessagePush generateAttackerReport(GuildFortHandler.FortGuildStatistics.Builder defBuilder, GuildFortHandler.FortGuildStatistics.Builder attBuilder) {
        GuildFortHandler.OnGuildFortPush.Builder res = GuildFortHandler.OnGuildFortPush.newBuilder();
        res.setS2CCode(200);

        if (defBuilder != null) {
            res.setEnemyGuild(defBuilder);
        }
        if (attBuilder != null) {
            res.setOwnGuild(attBuilder);
        }

        return new MessagePush("area.guildFortPush.onGuildFortPush", (GeneratedMessage) res.build());
    }

    private GuildFortHandler.FortGuildStatistics.Builder getStatistics(GuildFortContenderPO contender) {
        if (contender == null) {
            return null;
        }
        GuildFortHandler.FortGuildStatistics.Builder def = GuildFortHandler.FortGuildStatistics.newBuilder();
        GuildFortStatPush stat = contender.getPush();
        def.setArmyFlag(stat.killFlagNum);
        def.setMumber(stat.memberNumber);
        def.setDefenseSoul(stat.defBuffScore);
        def.setAttackSoul(stat.attBuffScore);
        def.setKill(stat.killPlayerNum);
        def.setAttack(stat.attBuff);
        def.setDefense(stat.defBuff);

        def.setScore(stat.score);
        return def;
    }


    public GuildFortContenderPO getStatByPlayer(WNPlayer player, boolean isOpponent) {
        String gid = player.guildManager.getGuildId();
        if (isDefenserMember(gid)) {
            if (isOpponent) {
                if (this.attacker != null) {
                    return this.attacker.getContenderPO();
                }
            } else if (this.defenser != null) {
                return this.defenser.getContenderPO();
            }

        } else if (isAttackerMember(gid)) {
            if (isOpponent) {
                if (this.defenser != null) {
                    return this.defenser.getContenderPO();
                }
            } else if (this.attacker != null) {
                return this.attacker.getContenderPO();
            }
        }


        return new GuildFortContenderPO();
    }

    public GuildFortContenderPO getContenderByGuildId(String guildId) {
        if (isDefenserMember(guildId))
            return this.defenser;
        if (isAttackerMember(guildId)) {
            return this.attacker;
        }
        return null;
    }


    private void addDefBuffScore(GuildFortContenderPO contender, int score) {
        contender.defBuffScore += score;
        int afterAddDiv = contender.defBuffScore / GlobalConfig.GuildFort_PickAddDefense;
        if (afterAddDiv > contender.defBuff) {
            contender.defBuff = afterAddDiv;
            pushReport();
            pushBuffChanged(contender);
        }
    }

    private void addAttBuffScore(GuildFortContenderPO contender, int score) {
        contender.attBuffScore += score;
        int afterAddDiv = contender.attBuffScore / GlobalConfig.GuildFort_KillMonAddAttack;
        if (afterAddDiv > contender.attBuff) {
            contender.attBuff = afterAddDiv;
            pushReport();
            pushBuffChanged(contender);
        }
    }

    private void pushReport() {
        GuildFortHandler.FortGuildStatistics.Builder defBuilder = getStatistics(this.defenser);
        GuildFortHandler.FortGuildStatistics.Builder attBuilder = getStatistics(this.attacker);

        MessagePush defMsg = generateDefenserReport(defBuilder, attBuilder);
        MessagePush attMsg = generateAttackerReport(defBuilder, attBuilder);

        if (this.defPrepareArea != null) {
            this.defPrepareArea.pushReport(defMsg, attMsg);
        }
        if (this.defPveArea != null) {
            this.defPveArea.pushReport(defMsg, attMsg);
        }
        if (this.attPrepareArea != null) {
            this.attPrepareArea.pushReport(defMsg, attMsg);
        }
        if (this.attPveArea != null) {
            this.attPveArea.pushReport(defMsg, attMsg);
        }
        if (this.pvpArea != null) {
            this.pvpArea.pushReport(defMsg, attMsg);
        }
    }

    private void pushBattleResult() {
        if (this.defenser != null) {
            for (GuildFortMemberPO member : this.defenser.getMembers()) {
                WNPlayer player = PlayerUtil.getOnlinePlayer(member.playerId);
                if (player != null) {
                    player.sendSysTip("据点战结果在这里。。。", Const.TipsType.NORMAL);
                }
            }
        }

        if (this.attacker != null) {
            for (GuildFortMemberPO member : this.attacker.getMembers()) {
                WNPlayer player = PlayerUtil.getOnlinePlayer(member.playerId);
                if (player != null) {
                    player.sendSysTip("据点战结果在这里。。。", Const.TipsType.NORMAL);
                }
            }
        }
    }

    private void pushBuffChanged(GuildFortContenderPO contender) {
        if (this.pvpArea != null) {
            this.pvpArea.onAddBuff(contender);
        }
    }

    private void addScore(GuildFortContenderPO contender, int score) {
        System.out.println("-----------------------------------------------add----------------" + score);
        System.out.println("-----------------------------------------------contender---------------" + contender.score);
        contender.score += score;
        pushReport();
        if (contender.score >= GlobalConfig.GuildFort_MaxWinPoint) {
            onBattleOver();
        }
    }


    public void onPlayerEntered(WNPlayer player) {
        GuildFortContenderPO contender = getContenderByPlayer(player);
        contender.getMemberAndPut(player);
        pushReport();
    }

    public void onPickedItem(WNPlayer player, int itemId) {
        if (isBattleOver()) {
            Out.warn(new Object[]{"guild fort battle is overed while on stat"});

            return;
        }
        GuildFortContenderPO contender = getContenderByPlayer(player);
        GuildFortMemberPO stat = contender.getMemberAndPut(player);
        Integer times = (Integer) GlobalConfig.guildFortPickPoint.get(Integer.valueOf(itemId));
        if (times == null) {
            Out.warn(new Object[]{"guildFortPickPoint not contains the itemId,itemId: ", Integer.valueOf(itemId), " playerId: " + player.getId()});
            return;
        }
        stat.onPickedItem(itemId, times.intValue());

        addDefBuffScore(contender, times.intValue());
    }

    public void onKilledMonster(WNPlayer player, int monsterId) {
        if (isBattleOver()) {
            Out.warn(new Object[]{"guild fort battle is overed while on stat"});
            return;
        }
        GuildFortContenderPO contender = getContenderByPlayer(player);
        GuildFortMemberPO stat = contender.getMemberAndPut(player);
        Integer times = (Integer) GlobalConfig.guildFortKillMonPoint.get(Integer.valueOf(monsterId));
        if (times == null) {
            Out.warn(new Object[]{"guildFortKillMonPoint not contains the monster,monsterId: ", Integer.valueOf(monsterId), " playerId: " + player.getId()});

            return;
        }
        stat.onKilledMonster(monsterId, times.intValue());
        addAttBuffScore(contender, times.intValue());
    }

    public void onKilledFlag(WNPlayer player, int monsterId) {
        if (isBattleOver()) {
            Out.warn(new Object[]{"guild fort battle is overed while on stat"});
            return;
        }
        GuildFortContenderPO contender = getContenderByPlayer(player);
        GuildFortMemberPO stat = contender.getMemberAndPut(player);
        stat.onKilledFlag(GlobalConfig.GuildFort_DestroyPoint);

        addScore(contender, GlobalConfig.GuildFort_DestroyPoint);
    }

    public void onKilledPlayer(WNPlayer player) {
        if (isBattleOver()) {
            Out.warn(new Object[]{"guild fort battle is overed while on stat"});

            return;
        }
        GuildFortContenderPO contender = getContenderByPlayer(player);
        GuildFortMemberPO stat = contender.getMemberAndPut(player);
        stat.onKilledPlayer(GlobalConfig.GuildFort_KillPoint);

        addScore(contender, GlobalConfig.GuildFort_KillPoint);
    }

    public void onBattleReport(WNPlayer player, DamageHealVO report, int count) {
        if (isBattleOver()) {
            Out.warn(new Object[]{"guild fort battle is overed while on stat"});
            return;
        }
        GuildFortContenderPO contender = getContenderByPlayer(player);
        GuildFortMemberPO stat = contender.getMemberAndPut(player);
        stat.onFightHurt(report.TotalDamage, count);
        stat.onFightHurt(report.TotalHealing, count);
    }


    public boolean isDefenserMember(String guildId) {
        return (this.defenser != null && this.defenser.isMember(guildId));
    }

    public boolean isAttackerMember(String guildId) {
        return (this.attacker != null && this.attacker.isMember(guildId));
    }

    public List<GuildFortBidderPO> getBidders() {
        return this.po.bidders;
    }

    public boolean isBidWinner(String guildId) {
        if (this.defenser != null && this.defenser.getGuildId().equals(guildId)) {
            return true;
        }

        return false;
    }

    public String getName() {
        return this.fortConfig.name;
    }

    public String getDefenserName() {
        if (this.defenser == null) {
            return "";
        }

        return this.defenser.guildName;
    }

    public String getAttackerName() {
        if (this.attacker == null) {
            return "";
        }

        return this.attacker.guildName;
    }


    public void updateRank() {
        String guildId = getOccupyGuildId();
        if (guildId == null) {
            Out.error(new Object[]{"occupied guild id null occured in update rank"});
            return;
        }
        GuildPO guild = GuildServiceCenter.getInstance().getGuild(guildId);
        if (guild != null)
            RankType.GUILD_FORT.getHandler().handle(guild);
    }

    public GuildFort() {
    }
}


