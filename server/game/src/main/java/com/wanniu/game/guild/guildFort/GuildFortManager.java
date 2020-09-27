package com.wanniu.game.guild.guildFort;

import com.wanniu.core.db.GCache;
import com.wanniu.core.game.LangService;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.DateUtil;
import com.wanniu.game.area.Area;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.ModuleManager;
import com.wanniu.game.data.GuildLevelCO;
import com.wanniu.game.guild.GuildServiceCenter;
import com.wanniu.game.guild.GuildUtil;
import com.wanniu.game.guild.guildFort.dao.GuildFortAwardPO;
import com.wanniu.game.guild.guildFort.dao.GuildFortBattleReportPO;
import com.wanniu.game.guild.guildFort.dao.GuildFortBidderPO;
import com.wanniu.game.guild.guildFort.dao.GuildFortContenderPO;
import com.wanniu.game.guild.guildFort.dao.GuildFortMemberPO;
import com.wanniu.game.guild.guildFort.dao.GuildFortReportPO;
import com.wanniu.game.item.NormalItem;
import com.wanniu.game.mail.MailUtil;
import com.wanniu.game.mail.data.MailData;
import com.wanniu.game.mail.data.MailSysData;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.GuildPO;
import com.wanniu.game.team.TeamData;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import pomelo.area.GuildFortHandler;
import pomelo.area.PlayerHandler;


public class GuildFortManager
        extends ModuleManager {
    private WNPlayer player;
    private GuildFortAwardPO dailyAwards = null;
    private int fortId = 0;


    private static final String Tradenionstrongholds = "Tradenionstrongholds";


    private static final String Rewardstatus = "Rewardstatus";


    private String getGuildId() {
        return this.player.guildManager.getGuildId();
    }


    private String getJobName() {
        return this.player.guildManager.getJobName();
    }


    public GuildFortManager(WNPlayer wnPlayer) {
        this.player = wnPlayer;
        if (this.player.playerAttachPO.guildFortDailyAwards == null) {
            this.player.playerAttachPO.guildFortDailyAwards = new GuildFortAwardPO();
        }
        this.dailyAwards = this.player.playerAttachPO.guildFortDailyAwards;

        System.out.println("=========================================================" + this.dailyAwards);
    }

    private boolean isSameDay(long date) {
        return DateUtil.isSameDay(new Date(), new Date(date));
    }


    public void onPlayerEvent(Const.PlayerEventType eventType) {
        if (eventType == Const.PlayerEventType.REFRESH_NEWDAY) {
            recalcDailyAwards();
        } else if (eventType == Const.PlayerEventType.OFFLINE) {
            setFortId(0);
        } else if (eventType == Const.PlayerEventType.AFTER_LOGIN) {
            System.out.println("AFTER_LOGIN====================================" + this.dailyAwards.updateDate);
            if (!isSameDay(this.dailyAwards.updateDate)) {
                recalcDailyAwards();
            }
        }
    }


    public Const.ManagerType getManagerType() {
        return Const.ManagerType.GUILD_FORT;
    }


    public void recalcDailyAwards() {
        synchronized (this.dailyAwards.awardStatus) {
            this.dailyAwards.awardStatus.clear();
            List<GuildFort> list = GuildFortCenter.getInstance().getOccupiedForts(getGuildId());
            for (GuildFort fort : list) {
                this.dailyAwards.awardStatus.put(Integer.valueOf(fort.getId()), GuildFortAwardPO.AwardFlag.HAS_AWARD);
            }


            this.dailyAwards.updateDate = System.currentTimeMillis();
        }
    }


    public void clearDailyAwards() {
        synchronized (this.dailyAwards.awardStatus) {
            this.dailyAwards.awardStatus.clear();
        }
    }

    private GuildFortAwardPO.AwardFlag getAwardFlag(int fortId) {
        synchronized (this.dailyAwards.awardStatus) {
            if (this.dailyAwards.awardStatus.containsKey(Integer.valueOf(fortId))) {

                GuildFortAwardPO.AwardFlag flag = (GuildFortAwardPO.AwardFlag) this.dailyAwards.awardStatus.get(Integer.valueOf(fortId));


                return (GuildFortAwardPO.AwardFlag) this.dailyAwards.awardStatus.get(Integer.valueOf(fortId));
            }


            return GuildFortAwardPO.AwardFlag.NO_AWARD;
        }
    }

    private List<Integer> getAwardFortIds() {
        List<Integer> fortIds = new ArrayList<>();
        synchronized (this.dailyAwards.awardStatus) {
            for (Integer fortId : this.dailyAwards.awardStatus.keySet()) {
                if (this.dailyAwards.awardStatus.get(fortId) == GuildFortAwardPO.AwardFlag.HAS_AWARD) {
                    fortIds.add(fortId);
                }
            }
        }
        return fortIds;
    }

    private boolean hasAward() {
        return (getAwardFortIds().size() > 0);
    }

    private boolean isBidded(GuildFort fort) {
        if (GuildFortService.getInstance().isInBidTime() &&
                fort.isInBidders(getGuildId())) {
            return true;
        }


        return false;
    }

    public String handleGetGuildAreaList(GuildFortHandler.GetGuildAreaListResponse.Builder res) {
        int status = GuildFortCenter.getInstance().getStatus(false);
        res.setCurStatus(status);
        for (GuildFort fort : GuildFortCenter.getInstance().getAllGuildFort()) {
            GuildFortHandler.GuildAreaInfo.Builder data = GuildFortHandler.GuildAreaInfo.newBuilder();
            data.setAreaId(fort.getId());


            String occupyId = GCache.hget("Tradenionstrongholds", String.valueOf(fort.getId()));
            data.setApplied(isBidded(fort) ? 1 : 0);
            if (occupyId == null || occupyId.equals("")) {
                data.setGuildId("");
                data.setGuildName("");
            } else {
                GuildPO guild = GuildServiceCenter.getInstance().getGuild(occupyId);
                data.setGuildId(occupyId);
                data.setGuildName(guild.name);
            }

            data.setGuildName1(fort.getDefenserName());
            data.setGuildName2(fort.getAttackerName());

            res.addAreaList(data);
        }

        return null;
    }

    public String handleGetGuildAreaDetail(GuildFortHandler.GetGuildAreaDetailResponse.Builder res, int fortId) {
        GuildFort fort = GuildFortCenter.getInstance().getFort(fortId);
        if (fort == null) {
            return LangService.getValue("GUILDFORT_FORTID_NOT_EXIST");
        }
        GuildFortHandler.GuildAreaDetail.Builder data = GuildFortHandler.GuildAreaDetail.newBuilder();

        String occupyId = GCache.hget("Tradenionstrongholds", String.valueOf(fort.getId()));

        if (occupyId == null || occupyId.equals("")) {
            data.setGuildId("");
        } else {
            GuildPO guild = GuildServiceCenter.getInstance().getGuild(occupyId);
            data.setGuildId(occupyId);
            data.setGuildName(guild.name);
            data.setGuildLevel(guild.level);
            data.setGuildLeaderId(guild.presidentId);
            data.setGuildLeaderName(guild.presidentName);
            data.setGuildNumberCount(GuildUtil.getGuildMemberCount(occupyId));
            GuildLevelCO prop = GuildUtil.getGuildLevelPropByLevel(guild.level);
            data.setGuildNumberTotalCount(prop.member);
        }
        data.addAllWinnerAwardList(fort.getWinnerReward());
        data.addAllDailyAwardList(fort.getDailyAward());


        data.setDailyAwardFlag((getAwardFlag(fortId)).value);
        int status = GuildFortCenter.getInstance().getStatus(isBidded(fort));
        data.setAreaStatus(status);
        if (status == GuildFortCenter.Status.NOT_BEGIN.value) {
            data.setCountDown(GuildFortService.getInstance().getBidBeginRemainSecond());
        } else if (status == GuildFortCenter.Status.INTIME_NOTBID.value || status == GuildFortCenter.Status.INTIME_BIDDED.value) {

            data.setCountDown(GuildFortService.getInstance().getBidEndRemainSecond());
        } else if (status == GuildFortCenter.Status.BID_ENDED.value) {
            data.setCountDown(GuildFortService.getInstance().getBattleBeginRemainSecond());
        }

        res.setAreaDetail(data.build());
        return null;
    }

    public String handleGetGuildAreaApplyList(GuildFortHandler.GetGuildAreaApplyListResponse.Builder res, int fortId) {
        GuildFort fort = GuildFortCenter.getInstance().getFort(fortId);
        if (fort == null) {
            return LangService.getValue("GUILDFORT_FORTID_NOT_EXIST");
        }
        GuildFortService service = GuildFortService.getInstance();
        if (!service.isInOpen()) {
            return LangService.getValue("GUILDFORT_NOT_OPENED");
        }

        for (GuildFortBidderPO bidder : fort.getBidders()) {
            GuildFortHandler.GuildAreaApplyInfo.Builder data = GuildFortHandler.GuildAreaApplyInfo.newBuilder();
            GuildPO guild = GuildServiceCenter.getInstance().getGuild(bidder.guildId);
            data.setGuildIcon(guild.icon);
            data.setGuildId(bidder.guildId);
            data.setGuildName(guild.name);
            data.setGuildLevel(guild.level);
            data.setGuildLeaderId(guild.presidentId);
            data.setGuildLeaderName(guild.presidentName);
            data.setGuildNumberCount(GuildUtil.getGuildMemberCount(bidder.guildId));
            GuildLevelCO prop = GuildUtil.getGuildLevelPropByLevel(guild.level);
            data.setGuildNumberTotalCount(prop.member);
            if (GuildFortService.getInstance().isInBidTime()) {
                if (this.player.guildManager.getGuildId().equals(bidder.guildId)) {
                    data.setApplyFund(bidder.fund);
                } else {
                    data.setApplyFund(0);
                }
            } else {
                data.setApplyFund(bidder.fund);
            }
            data.setIsWinner(fort.isBidWinner(bidder.guildId));
            res.addApplyList(data);
        }
        if (service.isInBidTime()) {
            res.setCountDown(GuildFortService.getInstance().getBidEndRemainSecond());
        }
        return null;
    }


    private void bidCommitNotify(GuildPO guild, String playerName, String fortName, int fund, long sumFund) {
        String msgStr = LangService.getValue("GUILDFORT_FUNDCHANGED_NOTICE2");


        msgStr = msgStr.replace("{position}", getJobName()).replace("{name}", playerName).replace("{fortname}", fortName).replace("{fund}", String.valueOf(fund)).replace("{sumfund}", String.valueOf(sumFund));
        Set<String> playerIds = GuildUtil.getGuildMemberIdList(guild.id);
        GuildFortUtil.sendRollTipsAsyn(playerIds, msgStr, Const.CHAT_SCOPE.GUILD);

        MailSysData mailData = new MailSysData("GuildFortBidFundCommit");
        mailData.replace = new HashMap<>();
        mailData.replace.put("position", getJobName());
        mailData.replace.put("name", playerName);
        mailData.replace.put("fortname", fortName);
        mailData.replace.put("fund", String.valueOf(fund));
        mailData.replace.put("sumfund", String.valueOf(sumFund));
        List<String> ids = GuildServiceCenter.getInstance().getGuildMemberIdList(guild.id, new Const.GuildJob[]{Const.GuildJob.PRESIDENT, Const.GuildJob.VICE_PRESIDENT});
        MailUtil.getInstance().sendMailToSomePlayer(ids.<String>toArray(new String[ids.size()]), (MailData) mailData, Const.GOODS_CHANGE_TYPE.guild_mail);
    }

    private void bidCancelNotify(GuildPO guild, String playerName, String fortName, int fund) {
        String msgStr = LangService.getValue("GUILDFORT_FUNDCHANGED_NOTICE1");

        msgStr = msgStr.replace("{position}", getJobName()).replace("{name}", playerName).replace("{fortname}", fortName).replace("{fund}", String.valueOf(fund));
        Set<String> playerIds = GuildUtil.getGuildMemberIdList(guild.id);
        GuildFortUtil.sendRollTipsAsyn(playerIds, msgStr, Const.CHAT_SCOPE.GUILD);

        MailSysData mailData = new MailSysData("GuildFortBidFundCancel");
        mailData.replace = new HashMap<>();
        mailData.replace.put("position", getJobName());
        mailData.replace.put("name", playerName);
        mailData.replace.put("fortname", fortName);
        mailData.replace.put("fund", String.valueOf(fund));
        List<String> ids = GuildServiceCenter.getInstance().getGuildMemberIdList(guild.id, new Const.GuildJob[]{Const.GuildJob.PRESIDENT, Const.GuildJob.VICE_PRESIDENT});
        MailUtil.getInstance().sendMailToSomePlayer(ids.<String>toArray(new String[ids.size()]), (MailData) mailData, Const.GOODS_CHANGE_TYPE.guild_mail);
    }

    public String handleApplyFund(GuildFortHandler.ApplyFundResponse.Builder res, int fortId, int fund) {
        if (fund <= 0) {
            return LangService.getValue("GUILD_FUND_NOT_ENOUGH");
        }

        if (fund < GlobalConfig.GuildFort_MinBetMoney) {
            return LangService.getValue("SOMETHING_ERR");
        }

        if (!GuildFortService.getInstance().isInBidTime()) {
            return LangService.getValue("GUILDFORT_NOTIN_BIDTIME");
        }

        GuildFort fort = GuildFortCenter.getInstance().getFort(fortId);
        if (fort == null) {
            return LangService.getValue("GUILDFORT_FORTID_NOT_EXIST");
        }
        if (!this.player.guildManager.isInGuild()) {
            return LangService.getValue("GUILD_NOT_JOIN");
        }
        if (!this.player.guildManager.isPresident() && !this.player.guildManager.isVicePresident()) {
            return LangService.getValue("GUILDFORT_NOT_PRISIDENT_ONBID");
        }
        GuildPO guild = this.player.guildManager.getGuildInfo();
        if (guild.fund < fund) {
            return LangService.getValue("GUILD_FUND_NOT_ENOUGH");
        }
        if (!fort.isInBidders(guild.id) && GuildFortCenter.getInstance().isBitFortExceeded(guild.id)) {
            return LangService.getValue("GUILDFORT_BITFORT_EXCEEDED");
        }

        int afterCommitFund = fort.commitBidFund(guild.id, fund);
        if (afterCommitFund > 0) {
            bidCommitNotify(guild, this.player.getName(), fort.getName(), fund, afterCommitFund);
            GuildFortCenter.getInstance().onBidOperation();
        } else {
            return LangService.getValue("SOMETHING_ERR");
        }


        return null;
    }

    public String handleApplyCancelFund(int fortId) {
        if (!GuildFortService.getInstance().isInBidTime()) {
            return LangService.getValue("GUILDFORT_NOTIN_BIDTIME");
        }

        GuildFort fort = GuildFortCenter.getInstance().getFort(fortId);
        if (fort == null) {
            return LangService.getValue("GUILDFORT_FORTID_NOT_EXIST");
        }

        if (!this.player.guildManager.isInGuild()) {
            return LangService.getValue("GUILD_NOT_JOIN");
        }
        if (!this.player.guildManager.isPresident() && !this.player.guildManager.isVicePresident()) {
            return LangService.getValue("GUILDFORT_NOT_PRISIDENT_ONBID");
        }
        GuildPO guild = this.player.guildManager.getGuildInfo();
        if (!fort.isInBidders(guild.id)) {
            return LangService.getValue("GUILDFORT_NOT_BIDDED");
        }

        int fund = fort.extractBidFund(guild.id);
        if (fund > 0) {
            Out.info(new Object[]{"Apply cancel fund guild id:", guild.id, " original fund:", Long.valueOf(guild.fund), " to caneled fund:" + fund});
            bidCancelNotify(guild, this.player.getName(), fort.getName(), fund);
            GuildFortCenter.getInstance().onBidOperation();
        } else {
            return LangService.getValue("SOMETHING_ERR");
        }

        return null;
    }

    public String handleEnterPrepareArea(int fortId) {
        GuildFort fort = GuildFortCenter.getInstance().getFort(fortId);
        if (fort == null) {
            return LangService.getValue("GUILDFORT_FORTID_NOT_EXIST");
        }

        if (!GuildFortService.getInstance().isInEnterFortTime()) {
            return LangService.getValue("GUILDFORT_NOT_IN_BATTLETIME");
        }
        if (GuildFortService.getInstance().isInBattleTime() && fort.isBattleOver()) {
            return LangService.getValue("GUILDFORT_BATTLE_ENDED");
        }


        Area area = fort.requestEnterPrepareArea(this.player);
        if (area == null) {
            return LangService.getValue("GUILDFORT_NOT_IN_BATTLEGUILD");
        }
        setFortId(fort.getId());

        return null;
    }

    private String handleEnterPveArea(int fortId) {
        GuildFort fort = GuildFortCenter.getInstance().getFort(fortId);
        if (fort == null) {
            return LangService.getValue("GUILDFORT_FORTID_NOT_EXIST");
        }
        if (!GuildFortService.getInstance().isInBattleTime()) {
            return LangService.getValue("GUILDFORT_NOT_IN_BATTLETIME");
        }

        if (fort.isBattleOver()) {
            return LangService.getValue("GUILDFORT_BATTLE_ENDED");
        }

        Area area = fort.requestEnterPveArea(this.player);
        if (area == null) {
            return LangService.getValue("GUILDFORT_NOT_IN_BATTLEGUILD");
        }

        return null;
    }

    private String handleEnterPvpArea(int fortId) {
        GuildFort fort = GuildFortCenter.getInstance().getFort(fortId);
        if (fort == null) {
            return LangService.getValue("GUILDFORT_FORTID_NOT_EXIST");
        }
        if (!GuildFortService.getInstance().isInBattleTime()) {
            return LangService.getValue("GUILDFORT_NOT_IN_BATTLETIME");
        }

        if (fort.isBattleOver()) {
            return LangService.getValue("GUILDFORT_BATTLE_ENDED");
        }

        Area area = fort.requestEnterPvpArea(this.player);
        if (area == null) {
            return LangService.getValue("GUILDFORT_NOT_IN_BATTLEGUILD");
        }

        return null;
    }

    public String handleApplyDailyAwardList(GuildFortHandler.ApplyDailyAwardListResponse.Builder res) {
        for (GuildFort fort : GuildFortCenter.getInstance().getAllGuildFort()) {
            GuildFortHandler.AreaAward.Builder data = GuildFortHandler.AreaAward.newBuilder();
            data.setAreaId(fort.getId());
            data.addAllDailyAwardList(fort.getDailyAward());

            String occupyId = GCache.hget("Tradenionstrongholds", String.valueOf(fort.getId()));


            if (occupyId == null) {
                data.setGuildName("");
                data.setStatus(GuildFortAwardPO.AwardFlag.NO_AWARD.value);

                res.addAreaAwardList(data);

                continue;
            }
            if (fort.isOccupier(getGuildId())) {


                GuildFortAwardPO.AwardFlag flag = getAwardFlag(fort.getId());


                data.setGuildName(this.player.guildManager.getGuildName());
                data.setStatus(flag.value);

            } else {


                GuildPO guild = GuildServiceCenter.getInstance().getGuild(occupyId);

                if (guild != null) {
                    data.setGuildName(guild.name);
                } else {
                    data.setGuildName("");
                }
                data.setStatus(GuildFortAwardPO.AwardFlag.NO_AWARD.value);
            }
            res.addAreaAwardList(data);
        }

        return null;
    }


    private String getDailyAward(GuildFort fort) {
        List<NormalItem> dailyAward = fort.generateDailyAward();

        if (!this.player.getWnBag().testAddEntityItems(dailyAward, true)) {
            return LangService.getValue("BAG_NOT_ENOUGH_POS");
        }

        this.player.getWnBag().addEntityItems(dailyAward, Const.GOODS_CHANGE_TYPE.guildfort_daily_award);


        this.dailyAwards.awardStatus.put(Integer.valueOf(fort.getId()), GuildFortAwardPO.AwardFlag.AWARDED);
        this.dailyAwards.updateDate = System.currentTimeMillis();

        pushRedPoint();

        return null;
    }

    public String handleApplyDailyAward(int fortId) {
        GuildFort fort = GuildFortCenter.getInstance().getFort(fortId);
        if (fort == null) {
            return LangService.getValue("GUILDFORT_FORTID_NOT_EXIST");
        }

        if (!fort.isOccupier(getGuildId())) {
            return LangService.getValue("GUILDFORT_NO_AWARD");
        }


        GuildFortAwardPO.AwardFlag flag = getAwardFlag(fortId);


        switch (flag) {
            case NO_AWARD:
                return LangService.getValue("GUILDFORT_NO_AWARD");
            case AWARDED:
                return LangService.getValue("GUILDFORT_ERR_AWARDED");
            case HAS_AWARD:
                return getDailyAward(fort);
        }

        Out.error(new Object[]{"something error occured in handleApplyDailyAward with fortId:", Integer.valueOf(fortId), " playerId:" + this.player
                .getId()});
        return LangService.getValue("SOMETHING_ERR");
    }


    private GuildFortHandler.FortGuildInfo buildStatInfo(GuildFortContenderPO stat) {
        GuildFortHandler.FortGuildInfo.Builder data = GuildFortHandler.FortGuildInfo.newBuilder();
        GuildPO guild = GuildServiceCenter.getInstance().getGuild(stat.getGuildId());
        if (guild != null) {
            data.setGuildIcon(guild.icon);
            data.setGuildName(guild.name);
            data.setGuildLevel(guild.level);
        }
        data.setGuildId(stat.getGuildId());
        data.setArmyFlag(stat.killFlagNum);
        data.setKill(stat.killPlayerNum);
        data.setDefenseSoul(stat.defBuffScore);
        data.setAttackSoul(stat.attBuffScore);
        data.setMumber(stat.memberNumber);
        data.setDefense(stat.defBuff);
        data.setAttack(stat.attBuff);
        data.setScore(stat.getScore());

        return data.build();
    }

    public String handleApplyFortGuildInfo(GuildFortHandler.ApplyFortGuildInfoResponse.Builder res) {
        if (this.player.getAreaId() != 54002 && this.player.getAreaId() != 54003 && this.player.getAreaId() != 54001) {
            return LangService.getValue("GUILDFORT_NOT_IN_BATTLEGUILD");
        }
        if (!GuildFortService.getInstance().isInEnterFortTime()) {
            return LangService.getValue("GUILDFORT_NOT_IN_BATTLETIME");
        }

        GuildFort fort = GuildFortCenter.getInstance().getFort(this.fortId);
        if (fort == null) {
            return LangService.getValue("GUILDFORT_FORTID_NOT_EXIST");
        }

        GuildFortContenderPO me = fort.getStatByPlayer(this.player, false);
        GuildFortContenderPO opponent = fort.getStatByPlayer(this.player, true);
        res.setOwnGuild(buildStatInfo(me));
        res.setEnemyGuild(buildStatInfo(opponent));

        return null;
    }

    public String handleChangeArea(int areaId) {
        if (this.fortId == 0) {
            return LangService.getValue("GUILDFORT_FORTID_NOT_EXIST");
        }
        String result = checkTeam(this.player);
        if (result != null) {
            return result;
        }
        if (areaId == 54002)
            return handleEnterPveArea(this.fortId);
        if (areaId == 54003)
            return handleEnterPvpArea(this.fortId);
        if (areaId == 54001) {
            return handleEnterPrepareArea(this.fortId);
        }

        return LangService.getValue("AREA_ID_NULL");
    }

    public void handleLeaveArea(int areaId) {
        if (areaId == 54001) {
            setFortId(0);
        }
    }

    private String checkTeam(WNPlayer player) {
        Map<String, TeamData.TeamMemberData> members = player.getTeamManager().getTeamMembers();
        if (members == null || members.isEmpty()) {
            return null;
        }
        if (!player.getTeamManager().isTeamLeader() && player.getTeamManager().isFollowLeader()) {
            return LangService.getValue("TEAM_FOLLOW_CHANGE_AREA");
        }
        String guildId = getGuildId();

        for (TeamData.TeamMemberData member : members.values()) {
            if (member.getPlayer() == null || (member.getPlayer()).guildManager == null ||
                    (member.getPlayer()).guildManager.guild == null)
                return LangService.getValue("GUILDFORT_NOT_SAME_GUILD");
            if (!(member.getPlayer()).guildManager.getGuildId().equals(guildId)) {
                return LangService.getValue("GUILDFORT_NOT_SAME_GUILD");
            }
        }

        return null;
    }

    public String handleApplyAllReportList(GuildFortHandler.ApplyAllReportListResponse.Builder res) {
        List<GuildFortReportPO> reports = GuildFortCenter.getInstance().getReports();
        for (GuildFortReportPO report : reports) {
            GuildFortHandler.ReportList.Builder data = GuildFortHandler.ReportList.newBuilder();
            data.setDate(report.date);
            Map<Integer, GuildFortBattleReportPO> battleReports = report.battleReports;
            for (Integer fId : battleReports.keySet()) {
                GuildFortBattleReportPO br = battleReports.get(fId);
                if (br.defenser.guildId.equals("") && br.attacker.guildId.equals("")) {
                    continue;
                }

                GuildFortHandler.ReportListInfo.Builder subData = GuildFortHandler.ReportListInfo.newBuilder();
                subData.setAreaId(fId.intValue());
                subData.setDefenseGuildName(br.defenser.guildName);
                subData.setDefenseGuildIcon(br.defenser.guildIcon);
                subData.setAttackGuildName(br.attacker.guildName);
                subData.setAttackGuildIcon(br.attacker.guildIcon);

                if (br.defenser.isWinner()) {
                    subData.setResult(0);
                } else if (br.attacker.isWinner()) {
                    subData.setResult(1);
                } else {
                    subData.setResult(2);
                }
                data.addReportListInfo(subData);
            }

            if (data.getReportListInfoCount() > 0) {
                res.addReportList(data);
            }
        }


        return null;
    }

    private void buildReportGuildDetail(GuildFortHandler.ReportGuildDetail.Builder res, GuildFortContenderPO contender) {
        res.setGuildIcon(contender.guildIcon);
        res.setGuildId(contender.guildId);
        res.setGuildName(contender.guildName);
        res.setGuildLevel(contender.guildLevel);
        res.setIsWinner(contender.isWinner() ? 1 : 0);

        res.setCollect(contender.pickItemNum);
        res.setDefense(contender.defBuff);
        res.setSoul(contender.killMonsterNum);
        res.setAttack(contender.attBuff);
        res.setKill(contender.killPlayerNum);
        res.setKillScore(contender.killPlayerScore);
        res.setDestroyFlag(contender.killFlagNum);
        res.setDestroyFlagScore(contender.killFlagScore);

        res.setTotalScore(contender.getScore());
    }

    public String handleApplyReportDetail(GuildFortHandler.ApplyReportDetailResponse.Builder res, String date, int fortId) {
        List<GuildFortReportPO> reports = GuildFortCenter.getInstance().getReports();
        for (GuildFortReportPO report : reports) {
            if (report.date.equals(date)) {
                GuildFortBattleReportPO br = (GuildFortBattleReportPO) report.battleReports.get(Integer.valueOf(fortId));
                if (br != null) {
                    GuildFortHandler.ReportDetail.Builder data = GuildFortHandler.ReportDetail.newBuilder();
                    data.setAreaId(fortId);
                    GuildFortHandler.ReportGuildDetail.Builder subData = GuildFortHandler.ReportGuildDetail.newBuilder();
                    buildReportGuildDetail(subData, br.defenser);
                    data.setDetail1(subData);
                    subData = GuildFortHandler.ReportGuildDetail.newBuilder();
                    buildReportGuildDetail(subData, br.attacker);
                    data.setDetail2(subData);
                    res.setReportDetail(data);
                    return null;
                }
            }
        }

        return LangService.getValue("GUILDFORT_REPORT_NOT_FOUND");
    }


    public String handleApplyReportStatistics(GuildFortHandler.ApplyReportStatisticsResponse.Builder res, String date, int fortId, String guildId) {
        List<GuildFortReportPO> reports = GuildFortCenter.getInstance().getReports();
        for (GuildFortReportPO report : reports) {
            if (report.date.equals(date)) {
                GuildFortBattleReportPO br = (GuildFortBattleReportPO) report.battleReports.get(Integer.valueOf(fortId));
                if (br != null) {
                    GuildFortContenderPO ct = br.getContender(guildId);
                    if (ct != null) {
                        for (GuildFortMemberPO m : ct.getMembers()) {
                            GuildFortHandler.ReportStatisticsDetail.Builder data = GuildFortHandler.ReportStatisticsDetail.newBuilder();
                            data.setName(m.playerName);
                            data.setLevel(m.playerLevel);
                            data.setJob(m.guildJob);

                            data.setKill(m.getKilledPlayerNum());
                            data.setDestroyFlag(m.getKilledFlagNum());

                            data.setDamage(m.getFightHurt());
                            data.setCure(m.getFightCure());
                            data.setDefenseScore(m.getDefBuffScore());
                            data.setAttackSoul(m.getAttBuffScore());
                            data.setTotalScore(m.getScore());


                            res.addStatisticsDetail(data);
                        }
                        return null;
                    }
                }
            }
        }

        return LangService.getValue("GUILDFORT_REPORT_NOT_FOUND");
    }

    private void setFortId(int fortId) {
        this.fortId = fortId;
    }


    public List<PlayerHandler.SuperScriptType> getSuperScript() {
        List<PlayerHandler.SuperScriptType> list = new ArrayList<>();
        boolean isInBid = GuildFortService.getInstance().isInBidTime();
        boolean isInEnterFort = GuildFortService.getInstance().isInEnterFortTime();
        boolean isCanAward = hasAward();

        PlayerHandler.SuperScriptType.Builder data = null;

        data = PlayerHandler.SuperScriptType.newBuilder();
        data.setType(Const.SUPERSCRIPT_TYPE.GUILDFORT_INBID.getValue());
        if (isInBid) {
            data.setNumber(1);
        } else {
            data.setNumber(0);
        }
        list.add(data.build());

        data = PlayerHandler.SuperScriptType.newBuilder();
        data.setType(Const.SUPERSCRIPT_TYPE.GUILDFORT_INBATTLE.getValue());
        if (isInEnterFort) {
            data.setNumber(1);
        } else {
            data.setNumber(0);
        }
        list.add(data.build());

        data = PlayerHandler.SuperScriptType.newBuilder();
        data.setType(Const.SUPERSCRIPT_TYPE.GUILDFORT_INAWARD.getValue());
        if (isCanAward) {
            data.setNumber(1);
        } else {
            data.setNumber(0);
        }
        list.add(data.build());

        return list;
    }

    public void pushRedPoint() {
        this.player.updateSuperScriptList(getSuperScript());
        this.player.guildManager.pushRedPoint();
    }

    public boolean needUpdateRedPoint() {
        return (GuildFortService.getInstance().isInBidTime() || GuildFortService.getInstance().isInEnterFortTime() ||
                hasAward());
    }
}


