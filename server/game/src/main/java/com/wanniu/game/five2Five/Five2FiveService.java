package com.wanniu.game.five2Five;

import com.google.protobuf.GeneratedMessage;
import com.wanniu.core.game.JobFactory;
import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GPlayer;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.DateUtil;
import com.wanniu.game.GWorld;
import com.wanniu.game.area.Area;
import com.wanniu.game.area.AreaData;
import com.wanniu.game.area.AreaUtil;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.Utils;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.GameMapCO;
import com.wanniu.game.data.base.MapBase;
import com.wanniu.game.data.ext.PersonalRankExt;
import com.wanniu.game.five2Five.dao.Five2FiveDao;
import com.wanniu.game.functionOpen.FunctionOpenUtil;
import com.wanniu.game.item.ItemUtil;
import com.wanniu.game.item.NormalItem;
import com.wanniu.game.leaderBoard.LeaderBoardDetail;
import com.wanniu.game.mail.MailUtil;
import com.wanniu.game.mail.data.MailData;
import com.wanniu.game.mail.data.MailSysData;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.Five2FivePO;
import com.wanniu.game.poes.Five2FivePlayerBtlReportPO;
import com.wanniu.game.poes.Five2FiveSystemPO;
import com.wanniu.game.rank.RankType;
import com.wanniu.game.team.TeamData;
import com.wanniu.game.team.TeamManager;
import com.wanniu.game.team.TeamService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

import pomelo.five2five.Five2FiveHandler;


public class Five2FiveService {
    private static final long MIN_SEASON_MILLISEC = TimeUnit.DAYS.toMillis(3L);


    private Five2FiveSystemPO five2FiveSystemPo;


    public enum Five2FiveResult {
        DEFAULT, WIN, FAIL, TIE;
    }


    public static Five2FiveService getInstance() {
        if (instance == null) {
            synchronized (Five2FiveService.class) {
                if (instance == null) {
                    instance = new Five2FiveService();
                }
            }
        }
        return instance;
    }

    private static Five2FiveService instance = null;

    private Five2FiveService() {
        init();
    }


    private void init() {
        JobFactory.addDelayJob(new Five2FiveMatchTeamThread(), 3000L, TimeUnit.MILLISECONDS);

        this.five2FiveSystemPo = Five2FiveDao.getFive2FivePO(String.valueOf(GWorld.__SERVER_ID));
        if (this.five2FiveSystemPo == null) {
            this.five2FiveSystemPo = new Five2FiveSystemPO();
            this.five2FiveSystemPo.logicServerId = GWorld.__SERVER_ID;
            this.five2FiveSystemPo.id = UUID.randomUUID().toString();
            this.five2FiveSystemPo.seasonRefreshTime = calcSoloSeasonTime();
            updateFive2FiveSystem(this.five2FiveSystemPo);
        }


        long initialDelay = this.five2FiveSystemPo.seasonRefreshTime.getTime() - System.currentTimeMillis();
        JobFactory.addFixedRateJob(new Runnable() {
            public void run() {
                try {
                    Out.info(new Object[]{"开始发放5v5周奖励"}, );
                    List<LeaderBoardDetail> datas = RankType.PVP_5V5.getHandler().getRankDetail(Five2FiveService.this.five2FiveSystemPo.logicServerId, 0, -1);
                    int rank = 1;
                    for (LeaderBoardDetail detail : datas) {
                        String playerId = detail.memberId;
                        WNPlayer player = PlayerUtil.getOnlinePlayer(playerId);
                        if (player != null) {
                            Map<Integer, PersonalRankExt> personalRanks = GameData.PersonalRanks;
                            PersonalRankExt maxExt = null;
                            for (PersonalRankExt temp : personalRanks.values()) {
                                if (maxExt == null || (temp.startRank > maxExt.startRank && temp.stopRank > maxExt.stopRank)) {
                                    maxExt = temp;
                                }
                            }
                            PersonalRankExt rankExt = null;
                            for (PersonalRankExt rankReward : personalRanks.values()) {
                                int startRank = rankReward.startRank;
                                int endRank = rankReward.stopRank;
                                if (rank >= startRank && rank <= endRank) {
                                    rankExt = rankReward;
                                    break;
                                }
                            }
                            if (rankExt == null) {
                                rankExt = maxExt;
                            }
                            Map<String, Integer> rankRewards = rankExt.rankRewards;
                            MailSysData mailData = new MailSysData("Trial_Competition");
                            Map<String, String> replace = new HashMap<>();
                            replace.put("rank", String.valueOf(rank));
                            mailData.replace = replace;
                            mailData.attachments = new ArrayList();

                            for (Map.Entry<String, Integer> attach : rankRewards.entrySet()) {
                                MailData.Attachment item = new MailData.Attachment();
                                item.itemCode = attach.getKey();
                                item.itemNum = ((Integer) attach.getValue()).intValue();
                                mailData.attachments.add(item);
                            }
                            MailUtil.getInstance().sendMailToOnePlayer(playerId, (MailData) mailData, Const.GOODS_CHANGE_TYPE.five2five);
                        } else {
                            Map<String, Integer> hasNoReciveRankRewardPlayer = Five2FiveService.this.five2FiveSystemPo.hasNoReciveRankRewardPlayer;
                            if (hasNoReciveRankRewardPlayer == null) {
                                hasNoReciveRankRewardPlayer = new HashMap<>();
                            }
                            hasNoReciveRankRewardPlayer.put(playerId, Integer.valueOf(rank));
                            Five2FiveService.this.five2FiveSystemPo.hasNoReciveRankRewardPlayer = hasNoReciveRankRewardPlayer;
                        }
                        rank++;
                    }
                    RankType.PVP_5V5.getHandler().delRank(GWorld.__SERVER_ID);
                    Out.info(new Object[]{"发放5v5周奖励结束"});
                    Five2FiveService.this.five2FiveSystemPo.seasonRefreshTime = Five2FiveService.this.calcSoloSeasonTime();

                    Five2FiveService.this.updateFive2FiveSystem(Five2FiveService.this.five2FiveSystemPo);
                } catch (Exception e) {
                    Out.error(new Object[]{e});
                }
            }
        }initialDelay, TimeUnit.DAYS.toMillis(7L));


        for (String times : GlobalConfig.Group_Daily_OpenTime.split(";")) {
            String[] time = times.split(",");
            Date begin = DateUtil.format(time[0]);
            Date end = DateUtil.format(time[1]);
            JobFactory.addScheduleJob(new Runnable() {
                public void run() {
                    for (GPlayer p : PlayerUtil.getAllOnlinePlayer()) {
                        WNPlayer wp = (WNPlayer) p;
                        wp.updateSuperScriptList(wp.five2FiveManager.getSuperScript());
                    }
                }
            }, DateUtil.getTaskDelay(begin), TimeUnit.DAYS.toMillis(1L));

            JobFactory.addScheduleJob(new Runnable() {
                public void run() {
                    for (GPlayer p : PlayerUtil.getAllOnlinePlayer()) {
                        WNPlayer wp = (WNPlayer) p;
                        wp.updateSuperScriptList(wp.five2FiveManager.getSuperScript());
                        wp.five2FiveManager.cancelFive2FiveMatch(false);
                    }
                    Five2FiveMatchPool.clearMatchPool();
                }
            }, DateUtil.getTaskDelay(end), TimeUnit.DAYS.toMillis(1L));
        }
    }


    private Date calcSoloSeasonTime() {
        Date endDate = calcSeasonEndTime(7, 0);
        if (endDate.getTime() - System.currentTimeMillis() < MIN_SEASON_MILLISEC) {
            endDate = calcSeasonEndTime(14, 0);
        }
        return endDate;
    }


    private static Date calcSeasonEndTime(int term, int endWeekDay) {
        if (endWeekDay >= 7) {
            endWeekDay = 0;
        }
        Date endDate = DateUtil.getFiveTimeOfDay(DateUtil.getDateAfter(term));
        Calendar endC = Calendar.getInstance();
        endC.setTime(endDate);
        endC.set(7, endWeekDay + 1);

        return endC.getTime();
    }


    public int getAvgWaitTime(boolean single) {
        long totalWaitTime = 0L;
        int totalMatchSuccessCount = 0;
        if (single) {
            totalWaitTime = this.five2FiveSystemPo.singleTotalMatchSuccessCostTime;
            totalMatchSuccessCount = this.five2FiveSystemPo.totalMatchSuccessSingle;
        } else {
            totalWaitTime = this.five2FiveSystemPo.teamTotalMatchSuccessCostTime;
            totalMatchSuccessCount = this.five2FiveSystemPo.totalMatchSuccessTeam;
        }
        if (totalMatchSuccessCount == 0) {
            return GlobalConfig.Group_AverageTime;
        }
        return (int) (totalWaitTime / totalMatchSuccessCount / 1000L);
    }


    public void singleApplyMatch(WNPlayer player) {
        Five2FiveMatchPool.singlePutInApplyPool(player);
    }


    public void teamApplyMatch(TeamData teamData) {
        Five2FiveMatchPool.teamPutInApplyPool(teamData.teamMembers, teamData.id);
    }


    public Date applyMatchTime(String playerId) {
        return Five2FiveMatchPool.applyMatchTime(playerId);
    }


    public String isCanEnter(WNPlayer player) {
        if (!isInOpenTime()) {
            return LangService.getValue("FIVE_2_FIVE_NOT_IN_TIME");
        }
        if (player.getLevel() < (FunctionOpenUtil.findFunctionOpenPropsByFuncName("5v5")).openLv) {
            return LangService.getValue("FIVE_2_FIVE_NOT_ENOUGH_LEVEL");
        }
        TeamManager tm = player.teamManager;
        boolean isInTeam = tm.isInTeam();
        GameMapCO gameMapCO = (GameMapCO) GameData.GameMaps.get(Integer.valueOf(GlobalConfig.Group_Map));

        Date applyMatchTime = applyMatchTime(player.getId());
        if (applyMatchTime != null) {
            return LangService.getValue("FIVE_2_FIVE_MATCHING");
        }

        if (player.soloManager.isBusy() || player.soloManager.isInMatching()) {
            return LangService.getValue("FIVE_2_FIVE_BUSY");
        }
        if (isInTeam) {
            boolean isTeamLeader = tm.isTeamLeader();
            if (!isTeamLeader) {
                return LangService.getValue("TEAM_NO_AUTHORITY");
            }
            Map<String, TeamData.TeamMemberData> teamMembers = tm.getTeamMembers();
            for (Map.Entry<String, TeamData.TeamMemberData> teamMember : teamMembers.entrySet()) {
                String teamPlayerId = teamMember.getKey();
                if (!PlayerUtil.isOnline(teamPlayerId)) {
                    return LangService.getValue("FIVE_2_FIVE_NOT_ONLINE");
                }
                String validateResult = processValidate(PlayerUtil.getOnlinePlayer(teamPlayerId), gameMapCO);
                if (!validateResult.equals("")) {
                    return validateResult;
                }
            }
        }
        return "";
    }


    public String processValidate(WNPlayer player, GameMapCO gameMapCO) {
        if (!funIsOpen(player)) {
            return LangService.getValue("FIVE_2_FIVE_MEM_NOT_OPEN");
        }


        if (player.soloManager.isBusy() || player.soloManager.isInMatching() || player.arenaManager.isInArenaMap(player.getAreaId())) {
            return LangService.getValue("FIVE_2_FIVE_TEAM_MEM_BUSY");
        }

        Date applyMatchTime = applyMatchTime(player.getId());
        if (applyMatchTime != null) {
            return LangService.getValue("FIVE_2_FIVE_TEAM_MEM_BUSY");
        }

        String isCan = AreaUtil.canEnterArea((MapBase) gameMapCO, player);
        if (isCan != null) {
            return isCan;
        }
        return "";
    }


    public boolean isInOpenTime() {
        if (GWorld.DEBUG) {
            return true;
        }
        Calendar c = Calendar.getInstance();
        int weekDay = c.get(7) - 1;
        if (!GlobalConfig.Group_Weekly_OpenTime.contains(String.valueOf(weekDay))) {
            return false;
        }
        Date nowTime = c.getTime();
        for (String times : GlobalConfig.Group_Daily_OpenTime.split(";")) {
            String[] time = times.split(",");
            Date begin = DateUtil.format(time[0]);
            Date end = DateUtil.format(time[1]);
            if (nowTime.after(begin) && nowTime.before(end)) {
                return true;
            }
        }
        return false;
    }


    public boolean funIsOpen(WNPlayer player) {
        return player.functionOpenManager.isOpen(Const.FunctionType.FIVE_2_FIVE.getValue());
    }


    public int getFive2FiveScore(String playerId) {
        WNPlayer player = PlayerUtil.getOnlinePlayer(playerId);
        Five2FivePO five2FivePO = null;
        if (player == null) {
            five2FivePO = Five2FiveDao.getPlayerFive2FivePO(playerId);
        } else {
            five2FivePO = player.allBlobData.five2FivePo;
            if (five2FivePO == null) {
                five2FivePO = Five2FiveDao.getPlayerFive2FivePO(playerId);
                player.allBlobData.five2FivePo = five2FivePO;
            }
        }
        int score = five2FivePO.score;
        return score;
    }


    public void processTeamChangeOnFive2Five(String leaderId) {
        Date applyTime = applyMatchTime(leaderId);

        if (applyTime != null) {
            Five2FiveHandler.Five2FiveTeamChangePush.Builder teamChangePush = Five2FiveHandler.Five2FiveTeamChangePush.newBuilder();
            teamChangePush.setS2CCode(200);
            WNPlayer leaderPlayer = PlayerUtil.getOnlinePlayer(leaderId);
            if (leaderPlayer == null) {
                return;
            }
            leaderPlayer.receive("five2five.five2FivePush.five2FiveTeamChangePush", (GeneratedMessage) teamChangePush.build());
        }
    }


    public void five2FiveAfterMatchSucess(Five2FiveMatchTeamVo matchTeamVoA, Five2FiveMatchTeamVo matchTeamVoB) {
        List<Five2FiveTempTeamMember> tempTeamMemsA = matchTeamVoA.tempTeamMember;
        int memNumberA = tempTeamMemsA.size();
        List<Five2FiveHandler.Five2FiveMatchMemberInfo> matchMemInfosA = new ArrayList<>();
        for (int i = 0; i < memNumberA; i++) {
            Five2FiveHandler.Five2FiveMatchMemberInfo.Builder matchMemInfo = Five2FiveHandler.Five2FiveMatchMemberInfo.newBuilder();
            Five2FiveTempTeamMember tempTeamMem = tempTeamMemsA.get(i);
            matchMemInfo.setPlayerId(tempTeamMem.playerId);
            matchMemInfo.setPlayerPro(tempTeamMem.playerPro);
            matchMemInfo.setPlayerLvl(tempTeamMem.playerLvl);
            matchMemInfo.setPlayerName(tempTeamMem.playerName);
            matchMemInfo.setReadyStatus(0);
            matchMemInfosA.add(matchMemInfo.build());
        }


        List<Five2FiveTempTeamMember> tempTeamMemsB = matchTeamVoB.tempTeamMember;
        int memNumberB = tempTeamMemsB.size();
        List<Five2FiveHandler.Five2FiveMatchMemberInfo> matchMemInfosB = new ArrayList<>();
        for (int j = 0; j < memNumberB; j++) {
            Five2FiveHandler.Five2FiveMatchMemberInfo.Builder matchMemInfo = Five2FiveHandler.Five2FiveMatchMemberInfo.newBuilder();
            Five2FiveTempTeamMember tempTeamMem = tempTeamMemsB.get(j);
            matchMemInfo.setPlayerId(tempTeamMem.playerId);
            matchMemInfo.setPlayerPro(tempTeamMem.playerPro);
            matchMemInfo.setPlayerLvl(tempTeamMem.playerLvl);
            matchMemInfo.setPlayerName(tempTeamMem.playerName);
            matchMemInfo.setReadyStatus(0);
            matchMemInfosB.add(matchMemInfo.build());
        }


        Five2FiveHandler.Five2FiveMatchMemberInfoPush.Builder matchMemPushA = Five2FiveHandler.Five2FiveMatchMemberInfoPush.newBuilder();
        matchMemPushA.setS2CCode(200);
        matchMemPushA.setTempTeamId(matchTeamVoA.tempTeamId);
        matchMemPushA.addAllMatchTeamInfoA(matchMemInfosA);
        matchMemPushA.addAllMatchTeamInfoB(matchMemInfosB);
        int waitResonseTimeSec = GlobalConfig.Group_ReadyTime;
        matchMemPushA.setWaitResponseTimeSec(waitResonseTimeSec);
        for (int k = 0; k < memNumberA; k++) {
            Five2FiveTempTeamMember tempTeamMem = tempTeamMemsA.get(k);
            String playerId = tempTeamMem.playerId;
            WNPlayer player = PlayerUtil.findPlayer(playerId);
            if (player != null) {

                player.receive("five2five.five2FivePush.five2FiveMatchMemberInfoPush", (GeneratedMessage) matchMemPushA.build());
            }
        }
        Five2FiveHandler.Five2FiveMatchMemberInfoPush.Builder matchMemPushB = Five2FiveHandler.Five2FiveMatchMemberInfoPush.newBuilder();
        matchMemPushB.setS2CCode(200);
        matchMemPushB.setTempTeamId(matchTeamVoB.tempTeamId);
        matchMemPushB.addAllMatchTeamInfoA(matchMemInfosA);
        matchMemPushB.addAllMatchTeamInfoB(matchMemInfosB);
        matchMemPushB.setWaitResponseTimeSec(waitResonseTimeSec);
        for (int m = 0; m < memNumberB; m++) {
            Five2FiveTempTeamMember tempTeamMem = tempTeamMemsB.get(m);
            String playerId = tempTeamMem.playerId;
            WNPlayer player = PlayerUtil.findPlayer(playerId);
            if (player != null) {

                player.receive("five2five.five2FivePush.five2FiveMatchMemberInfoPush", (GeneratedMessage) matchMemPushB.build());
            }
        }

        List<Five2FiveTeamApplyVo> teamMatchVosA = matchTeamVoA.teamMatchVos;
        if (teamMatchVosA != null) {
            long teamCostTime = this.five2FiveSystemPo.teamTotalMatchSuccessCostTime;
            for (int n = 0; n < teamMatchVosA.size(); n++) {
                Five2FiveTeamApplyVo teamMatchVoA = teamMatchVosA.get(n);
                long thisTeamCostTime = System.currentTimeMillis() - teamMatchVoA.joinTime.getTime();
                teamCostTime += thisTeamCostTime;
            }
            this.five2FiveSystemPo.teamTotalMatchSuccessCostTime = teamCostTime;
            this.five2FiveSystemPo.totalMatchSuccessTeam++;
        }

        List<Five2FiveSingleApplyVo> singleMatchVosA = matchTeamVoA.singleMatchVos;
        if (singleMatchVosA != null) {
            long singleCostTime = this.five2FiveSystemPo.singleTotalMatchSuccessCostTime;
            for (Five2FiveSingleApplyVo single : singleMatchVosA) {
                long thisPlayerCostTime = System.currentTimeMillis() - single.joinTime.getTime();
                singleCostTime += thisPlayerCostTime;
            }
            this.five2FiveSystemPo.singleTotalMatchSuccessCostTime = singleCostTime;
            this.five2FiveSystemPo.totalMatchSuccessSingle += singleMatchVosA.size();
        }

        List<Five2FiveTeamApplyVo> teamMatchVosB = matchTeamVoB.teamMatchVos;
        if (teamMatchVosB != null) {
            long teamCostTime = this.five2FiveSystemPo.teamTotalMatchSuccessCostTime;
            for (int n = 0; n < teamMatchVosB.size(); n++) {
                Five2FiveTeamApplyVo teamMatchVoB = teamMatchVosB.get(n);
                long thisTeamCostTime = System.currentTimeMillis() - teamMatchVoB.joinTime.getTime();
                teamCostTime += thisTeamCostTime;
            }

            this.five2FiveSystemPo.teamTotalMatchSuccessCostTime = teamCostTime;
            this.five2FiveSystemPo.totalMatchSuccessTeam++;
        }

        List<Five2FiveSingleApplyVo> singleMatchVosB = matchTeamVoB.singleMatchVos;
        if (singleMatchVosB != null) {
            long singleCostTime = this.five2FiveSystemPo.singleTotalMatchSuccessCostTime;
            for (Five2FiveSingleApplyVo single : singleMatchVosB) {
                long thisPlayerCostTime = System.currentTimeMillis() - single.joinTime.getTime();
                singleCostTime += thisPlayerCostTime;
            }
            this.five2FiveSystemPo.singleTotalMatchSuccessCostTime = singleCostTime;
            this.five2FiveSystemPo.totalMatchSuccessSingle += singleMatchVosB.size();
        }

        pushMatchPool();

        waitPlayerReady(matchTeamVoA, matchTeamVoB);
        updateFive2FiveSystem(this.five2FiveSystemPo);
    }


    public boolean singleQuitFive2FiveMatch(String playerId, boolean isSelf) {
        if (!isInOpenTime()) {
            return false;
        }
        boolean re = Five2FiveMatchPool.singleRemoveApplyPool(playerId);
        if (re && !isSelf) {
            pushCancelMatch(playerId);
        }
        return re;
    }


    public Five2FiveMatchTeamVo getMatchingTeam(String tempTeamId) {
        return Five2FiveMatchPool.getMatchingTeam(tempTeamId);
    }


    public void updatePlayerFive2FiveBtlReportPO(Five2FivePlayerBtlReportPO btlPo) {
        Five2FiveDao.updatePlayerFive2FiveBtlReportPO(btlPo);
    }


    public void updateFive2FiveSystem(Five2FiveSystemPO systemPo) {
        Five2FiveDao.updateFive2FiveSystem(systemPo);
    }


    public void delPlayerFive2FiveBtlReportPO(Five2FivePlayerBtlReportPO btlPo) {
        Five2FiveDao.delPlayerFive2FiveBtlReportPO(btlPo);
    }


    public void shardMatchResult(String instanceId, List<Five2FivePlayerResultInfoVo> resultInfos) {
        Five2FiveDao.updateShardBtlReport(instanceId, resultInfos);
    }


    public List<Five2FivePlayerResultInfoVo> queryResultInfos(String instanceId) {
        return Five2FiveDao.getShardBtlReport(instanceId);
    }


    public synchronized void afterAllChoiced(Five2FiveMatchTeamVo matchTeamVoA, Five2FiveMatchTeamVo matchTeamVoB) {
        if (Five2FiveMatchPool.removeMatchedTeam(matchTeamVoA.tempTeamId) == null ||
                Five2FiveMatchPool.removeMatchedTeam(matchTeamVoB.tempTeamId) == null) {
            Out.warn(new Object[]{"5v5 removeMatchedTeam null occured"});
            return;
        }
        Out.info(new Object[]{"five2five readyInScene:TeamA:", matchTeamVoA.tempTeamId, ",teamB:", matchTeamVoB.tempTeamId});
        if (!matchTeamVoA.isAllChoice.compareAndSet(false, true)) {
            Out.warn(new Object[]{"five2fivelog:err1:", matchTeamVoA.tempTeamId});

            return;
        }
        matchTeamVoB.isAllChoice.set(true);

        CopyOnWriteArrayList<Five2FiveTempTeamMember> tempTeamMemsA = matchTeamVoA.tempTeamMember;
        CopyOnWriteArrayList<Five2FiveTempTeamMember> tempTeamMemsB = matchTeamVoB.tempTeamMember;

        Area area = null;
        Map<String, Object> userData = Utils.ofMap(new Object[]{"tempTeamMemsA", tempTeamMemsA, "tempTeamMemsB", tempTeamMemsB});
        for (Five2FiveTempTeamMember tempTeamMem : tempTeamMemsA) {
            WNPlayer memPlayer = PlayerUtil.getOnlinePlayer(tempTeamMem.playerId);
            if (memPlayer == null) {
                Out.warn(new Object[]{"player offlined in 5v5, playerId=" + tempTeamMem.playerId});
                continue;
            }
            if (area == null) {
                area = enterFive2FiveArea(memPlayer, userData, matchTeamVoA.tempTeamId);
                continue;
            }
            enterFive2FiveArea(memPlayer, area, userData, matchTeamVoA.tempTeamId);
        }

        for (Five2FiveTempTeamMember tempTeamMem : tempTeamMemsB) {
            WNPlayer memPlayer = PlayerUtil.getOnlinePlayer(tempTeamMem.playerId);
            if (memPlayer == null) {
                Out.warn(new Object[]{"player offlined in 5v5, playerId=" + tempTeamMem.playerId});
                continue;
            }
            if (area == null) {
                area = enterFive2FiveArea(memPlayer, userData, matchTeamVoB.tempTeamId);
                continue;
            }
            enterFive2FiveArea(memPlayer, area, userData, matchTeamVoB.tempTeamId);
        }
    }


    private Area enterFive2FiveArea(WNPlayer player, Map<String, Object> userData, String templateId) {
        cancelFollow(player);
        Area area = AreaUtil.createAreaAndDispatch(player, Arrays.asList(new String[]{player.getId()}, ), player.getLogicServerId(), GlobalConfig.Group_Map, userData);
        if (!PlayerUtil.isOnline(player.getId())) {
            area.addPlayer(player);
            area.playerEnterRequest(player);
            player.getXmdsManager().playerReady(player.getId());
            area.onPlayerAutoBattle(player, true);
        }
        Out.info(new Object[]{"five2fivelog:in scene:playerId:", player.getId(), ",templateId=", templateId, ",sceneid:", Integer.valueOf(area.areaId), ",sceneInstanceId:", area.instanceId});
        return area;
    }


    private void enterFive2FiveArea(WNPlayer player, Area area, Map<String, Object> userData, String templateId) {
        cancelFollow(player);
        if (area != null && !area.isClose()) {
            if (!PlayerUtil.isOnline(player.getId())) {
                area.addPlayer(player);
                area.playerEnterRequest(player);
                player.getXmdsManager().playerReady(player.getId());
                area.onPlayerAutoBattle(player, true);
            } else {
                AreaData areaData = new AreaData(area.areaId, area.instanceId);
                AreaUtil.dispatchByInstanceId(player, areaData);
            }
        }
        Out.info(new Object[]{"five2fivelog:in scene:playerId:", player.getId(), ",templateId=", templateId, ",sceneid:", Integer.valueOf(area.areaId), ",sceneInstanceId:", area.instanceId});
    }


    private void cancelFollow(WNPlayer player) {
        if (player.getTeamManager().isTeamLeader()) {
            for (String id : player.getTeamManager().getTeamMembers().keySet()) {
                WNPlayer p = PlayerUtil.getOnlinePlayer(id);
                if (p == null) {
                    continue;
                }
                TeamService.followLeader(p, false);
            }
        } else {
            TeamService.followLeader(player, false);
        }
    }


    public String getFirstRankInfo() {
        return RankType.PVP_5V5.getHandler().getFirstRankMemberId(this.five2FiveSystemPo.logicServerId);
    }


    public int getPlayerRank(String playerId) {
        return (int) RankType.PVP_5V5.getHandler().getRank(this.five2FiveSystemPo.logicServerId, playerId);
    }


    public List<NormalItem> createItem(Map<String, Integer> rewards) {
        List<NormalItem> returnItems = new ArrayList<>();
        for (String itemCode : rewards.keySet()) {
            List<NormalItem> items = ItemUtil.createItemsByItemCode(itemCode, ((Integer) rewards.get(itemCode)).intValue());
            returnItems.addAll(items);
        }
        return returnItems;
    }


    @Deprecated
    public boolean teamIsMatchedSuccess(String teamId) {
        return Five2FiveMatchPool.teamIsMakeWithOthers(teamId);
    }


    public Five2FivePO createFive2FivePO(String playerId) {
        Five2FivePO five2FivePO = new Five2FivePO();
        five2FivePO.createTime = new Date();
        five2FivePO.updateTime = this.five2FiveSystemPo.seasonRefreshTime;
        return five2FivePO;
    }


    public Five2FiveSystemPO getFive2FiveSystemPO() {
        return this.five2FiveSystemPo;
    }


    public static final int getApplyPlayerCount() {
        return Five2FiveMatchPool.getApplyPlayer().size();
    }


    private void waitPlayerReady(final Five2FiveMatchTeamVo matchTeamVoA, final Five2FiveMatchTeamVo matchTeamVoB) {
        JobFactory.addDelayJob(new Runnable() {
            public void run() {
                Five2FiveService.this.afterAllChoiced(matchTeamVoA, matchTeamVoB);
            }
        } (GlobalConfig.Group_ReadyTime + 1), TimeUnit.SECONDS);
    }


    private void pushMatchFailed(String playerId, boolean single, boolean isReMatch) {
        Five2FiveHandler.Five2FiveMatchFailedPush.Builder matchFailedPush = Five2FiveHandler.Five2FiveMatchFailedPush.newBuilder();
        matchFailedPush.setS2CCode(200);
        if (isReMatch) {
            Five2FiveHandler.Five2FiveMatchTime.Builder matchTime = Five2FiveHandler.Five2FiveMatchTime.newBuilder();
            matchTime.setAvgWaitTime(getAvgWaitTime(single));
            matchTime.setMatchTime((int) (System.currentTimeMillis() / 1000L));
            matchFailedPush.setFive2FiveMatchTime(matchTime);
        }
        WNPlayer player = PlayerUtil.getOnlinePlayer(playerId);
        if (player != null) {
            player.receive("five2five.five2FivePush.five2FiveMatchFailedPush", (GeneratedMessage) matchFailedPush.build());
        }
    }


    @Deprecated
    void afterMatchedFailedProcess(Five2FiveMatchTeamVo matchTeamVo) {
        CopyOnWriteArrayList<Five2FiveTempTeamMember> tempTeamMems = matchTeamVo.tempTeamMember;
        List<Five2FiveTeamApplyVo> teamMatchVos = matchTeamVo.teamMatchVos;
        List<Five2FiveSingleApplyVo> singleMatchVos = matchTeamVo.singleMatchVos;
        if (singleMatchVos != null) {
            for (int i = 0; i < singleMatchVos.size(); i++) {
                Five2FiveSingleApplyVo single = singleMatchVos.get(i);
                WNPlayer player = single.player;
                if (player != null) {
                    for (int j = 0; j < tempTeamMems.size(); j++) {
                        Five2FiveTempTeamMember tempTeamMem = tempTeamMems.get(j);
                        if (tempTeamMem.isReadyOrCancel.get() == Const.Five2Five.five2five_choice_ready.value && player.getId().equals(tempTeamMem.playerId)) {
                            Five2FiveMatchPool.singlePutInApplyPool(player);
                            pushMatchFailed(tempTeamMem.playerId, true, true);
                        } else if ((tempTeamMem.isReadyOrCancel.get() == Const.Five2Five.five2five_choice_giveup.value || tempTeamMem.isReadyOrCancel.get() == 0) && player.getId().equals(tempTeamMem.playerId)) {
                            pushMatchFailed(tempTeamMem.playerId, true, false);
                        }
                    }
                }
            }
        }

        if (teamMatchVos != null) {
            for (int i = 0; i < teamMatchVos.size(); i++) {
                Five2FiveTeamApplyVo teamMatchVo = teamMatchVos.get(i);
                boolean isTeamAllReady = true;
                for (String teamMemPlayerId : teamMatchVo.teamMembers.keySet()) {
                    WNPlayer player = PlayerUtil.getOnlinePlayer(teamMemPlayerId);
                    if (player != null) {
                        for (Five2FiveTempTeamMember tempTeamMem : tempTeamMems) {
                            if (tempTeamMem.isReadyOrCancel.get() != Const.Five2Five.five2five_choice_ready.value && player.getId().equals(tempTeamMem.playerId)) {
                                isTeamAllReady = false;
                            }
                        }
                    }
                }
                if (isTeamAllReady) {
                    for (String teamMemPlayerId : teamMatchVo.teamMembers.keySet()) {
                        pushMatchFailed(teamMemPlayerId, false, true);
                    }
                    Five2FiveMatchPool.teamPutInApplyPool(teamMatchVo.teamMembers, teamMatchVo.teamId);
                } else {
                    for (String teamMemPlayerId : teamMatchVo.teamMembers.keySet()) {
                        pushMatchFailed(teamMemPlayerId, false, false);
                    }
                }
            }
        }
    }


    public void pushCancelMatch(String playerId) {
        WNPlayer memPlayer = PlayerUtil.getOnlinePlayer(playerId);
        if (memPlayer != null) {
            Five2FiveHandler.Five2FiveLeaderCancelMatchPush.Builder leaderCancelMatch = Five2FiveHandler.Five2FiveLeaderCancelMatchPush.newBuilder();
            leaderCancelMatch.setS2CCode(200);
            memPlayer.receive("five2five.five2FivePush.five2FiveLeaderCancelMatchPush", (GeneratedMessage) leaderCancelMatch.build());
        }
    }


    public void pushReady(String readyId, String pushPlayer) {
        Five2FiveHandler.Five2FiveMemberChoicePush.Builder memChoice = Five2FiveHandler.Five2FiveMemberChoicePush.newBuilder();
        memChoice.setS2CCode(200);
        memChoice.setAgreeOrReady(Const.Five2Five.five2five_choice_type_ready.value);
        memChoice.setPlayerId(readyId);
        memChoice.setChoice(Const.Five2Five.five2five_choice_ready.value);
        WNPlayer player = PlayerUtil.getOnlinePlayer(pushPlayer);
        if (player != null) {
            player.receive("five2five.five2FivePush.five2FiveMemberChoicePush", (GeneratedMessage) memChoice.build());
        }
    }


    public void pushMatchPool() {
        Five2FiveHandler.Five2FiveMatchPoolChangePush.Builder poolChange = Five2FiveHandler.Five2FiveMatchPoolChangePush.newBuilder();
        poolChange.setS2CCode(200);
        List<String> poolPlayers = Five2FiveMatchPool.getApplyPlayer();
        poolChange.setPreNumber(poolPlayers.size());
        for (int i = 0; i < poolPlayers.size(); i++) {
            String tempPlayerId = poolPlayers.get(i);
            WNPlayer tempPlayer = PlayerUtil.getOnlinePlayer(tempPlayerId);
            if (tempPlayer != null)
                tempPlayer.receive("five2five.five2FivePush.five2FiveMatchPoolChangePush", (GeneratedMessage) poolChange.build());
        }
    }
}


