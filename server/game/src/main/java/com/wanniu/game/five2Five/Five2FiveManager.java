package com.wanniu.game.five2Five;

import com.google.protobuf.GeneratedMessage;
import com.wanniu.core.game.LangService;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.DateUtil;
import com.wanniu.game.GWorld;
import com.wanniu.game.area.AreaUtil;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.ModuleManager;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.GameMapCO;
import com.wanniu.game.data.ext.DayRewardExt;
import com.wanniu.game.data.ext.PersonalRankExt;
import com.wanniu.game.five2Five.dao.Five2FiveDao;
import com.wanniu.game.item.NormalItem;
import com.wanniu.game.mail.MailUtil;
import com.wanniu.game.mail.data.MailData;
import com.wanniu.game.mail.data.MailSysData;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.Five2FivePO;
import com.wanniu.game.poes.Five2FivePlayerBtlReportPO;
import com.wanniu.game.poes.Five2FiveSystemPO;
import com.wanniu.game.poes.PlayerPO;
import com.wanniu.game.rank.RankType;
import com.wanniu.game.team.TeamData;
import com.wanniu.game.team.TeamManager;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import pomelo.area.PlayerHandler;
import pomelo.five2five.Five2FiveHandler;


public class Five2FiveManager
        extends ModuleManager {
    private WNPlayer player;
    private int isAgreeOrRefuse;

    public Five2FiveManager(WNPlayer player) {
        this.player = player;
    }


    public void applyFive2Five(String playerId, Five2FiveHandler.Five2FiveResponse.Builder res) {
        Five2FivePO five2FivePO = this.player.allBlobData.five2FivePo;
        if (five2FivePO == null) {
            five2FivePO = Five2FiveDao.getPlayerFive2FivePO(this.player.getId());
            if (five2FivePO == null) {
                res.setS2CCode(500);
                res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
                return;
            }
            this.player.allBlobData.five2FivePo = five2FivePO;
        }
        refreshFive2FiveInfo(five2FivePO);
        res.setS2CCode(200);
        Five2FiveHandler.Five2FiveRankInfo.Builder firstRankInfo = Five2FiveHandler.Five2FiveRankInfo.newBuilder();
        String firstPlayerId = Five2FiveService.getInstance().getFirstRankInfo();
        if (!firstPlayerId.equals("")) {
            firstRankInfo.setPlayerId(firstPlayerId);
            WNPlayer firstPlayer = PlayerUtil.getOnlinePlayer(firstPlayerId);
            PlayerPO playerPo = null;
            if (firstPlayer == null) {
                playerPo = PlayerUtil.getPlayerBaseData(firstPlayerId);
            } else {
                playerPo = firstPlayer.player;
            }
            firstRankInfo.setPlayerName(playerPo.name);
            firstRankInfo.setPlayerLvl(playerPo.level);
            firstRankInfo.setPro(playerPo.pro);
            firstRankInfo.setPlayerUpLvl(playerPo.upLevel);
            firstRankInfo.setPlayerFightPower(playerPo.fightPower);
            int firstScore = Five2FiveService.getInstance().getFive2FiveScore(firstPlayerId);
            firstRankInfo.setScore(firstScore);
            res.setFirstRankInfo(firstRankInfo);
        }

        res.setScore(five2FivePO.score);
        long selfRank = Five2FiveService.getInstance().getPlayerRank(playerId);
        res.setRank((int) selfRank);
        res.setWin(five2FivePO.winCount);
        res.setTie(five2FivePO.tieCount);
        res.setFail(five2FivePO.failCount);
        res.setMvp(five2FivePO.mvpCount);
        res.setTotalCanReciveCount(five2FivePO.canReciveRewardCount);
        res.setHasRecivedCount(five2FivePO.hasReciveRewardCount);

        TeamManager tm = this.player.teamManager;
        boolean isInTeam = tm.isInTeam();
        int avgWaitTime = 0;
        if (isInTeam) {
            avgWaitTime = Five2FiveService.getInstance().getAvgWaitTime(false);
        } else {
            avgWaitTime = Five2FiveService.getInstance().getAvgWaitTime(true);
        }

        Five2FiveHandler.Five2FiveMatchTime.Builder matchTime = Five2FiveHandler.Five2FiveMatchTime.newBuilder();
        matchTime.setAvgWaitTime(avgWaitTime);
        Date applyMatchTime = Five2FiveService.getInstance().applyMatchTime(playerId);
        if (applyMatchTime != null) {
            matchTime.setMatchTime((int) Math.floor((applyMatchTime.getTime() / 1000L)));
        } else {
            matchTime.setMatchTime(0);
        }
        res.setMatchPeople(Five2FiveMatchPool.getApplyPlayer().size());
        res.setFive2FiveMatchTime(matchTime);
        res.setSeasonEndTime(String.valueOf((Five2FiveService.getInstance().getFive2FiveSystemPO()).seasonRefreshTime.getTime()));
    }


    public void cancelFive2FiveMatch(boolean isSelf) {
        String playerId = this.player.getId();
        if (applyMatchTime(playerId) == null) {
            return;
        }

        Five2FiveService.getInstance().singleQuitFive2FiveMatch(playerId, isSelf);

        Five2FiveService.getInstance().pushMatchPool();
    }


    public void applyFive2FiveMatch(Five2FiveHandler.Five2FiveMatchResponse.Builder res, int matchOrReMatch) {
        TeamManager tm = this.player.teamManager;
        if (matchOrReMatch == 2) {
            TeamData teamData = tm.getTeam();
            Map<String, TeamData.TeamMemberData> teamMembers = teamData.teamMembers;
            for (TeamData.TeamMemberData memData : teamMembers.values()) {
                String memPlayerId = memData.id;
                Five2FiveService.getInstance().singleQuitFive2FiveMatch(memPlayerId, true);
            }
        }

        String validateResult = Five2FiveService.getInstance().isCanEnter(this.player);
        if (!validateResult.equals("")) {
            res.setS2CCode(500);
            res.setS2CMsg(validateResult);

            return;
        }
        res.setS2CCode(200);
        boolean isInTeam = tm.isInTeam();

        Date now = new Date();
        if (isInTeam) {
            TeamData teamData = tm.getTeam();
            Map<String, TeamData.TeamMemberData> teamMembers = teamData.teamMembers;
            List<Five2FiveHandler.Five2FiveMatchMemberInfo> five2FiveMatchMemberInfos = new ArrayList<>();
            for (TeamData.TeamMemberData memData : teamMembers.values()) {
                String memPlayerId = memData.id;
                Five2FiveService.getInstance().singleQuitFive2FiveMatch(memPlayerId, true);

                Five2FiveHandler.Five2FiveMatchMemberInfo.Builder memInfo = Five2FiveHandler.Five2FiveMatchMemberInfo.newBuilder();
                WNPlayer player = memData.getPlayer();
                if (player == null) {
                    continue;
                }
                player.five2FiveManager.isAgreeOrRefuse = 0;
                memInfo.setPlayerId(player.getId());
                memInfo.setPlayerPro(player.getPro());
                memInfo.setPlayerLvl(player.getLevel());
                memInfo.setPlayerName(player.getName());
                int readyStatus = 0;
                if (memPlayerId.equals(teamData.leaderId)) {
                    readyStatus = Const.Five2Five.five2five_choice_ready.value;
                }
                memInfo.setReadyStatus(readyStatus);
                five2FiveMatchMemberInfos.add(memInfo.build());
            }

            if (teamMembers.size() > 1) {
                for (TeamData.TeamMemberData memData : teamMembers.values()) {
                    WNPlayer player = memData.getPlayer();
                    if (player == null) {
                        continue;
                    }
                    Five2FiveHandler.Five2FiveApplyMatchPush.Builder applyMatch = Five2FiveHandler.Five2FiveApplyMatchPush.newBuilder();
                    applyMatch.addAllFive2FiveMatchMemberInfo(five2FiveMatchMemberInfos);
                    applyMatch.setWaitResponseTimeSec(GlobalConfig.Group_ReadyTime);
                    player.receive("five2five.five2FivePush.five2FiveApplyMatchPush", (GeneratedMessage) applyMatch.build());
                }
            } else {
                Five2FiveService.getInstance().teamApplyMatch(teamData);

                int avgWaitTime = Five2FiveService.getInstance().getAvgWaitTime(false);
                Five2FiveHandler.Five2FiveMatchTime.Builder matchTime = Five2FiveHandler.Five2FiveMatchTime.newBuilder();
                matchTime.setAvgWaitTime(avgWaitTime);
                matchTime.setMatchTime((int) (now.getTime() / 1000L));
                res.setFive2FiveMatchTime(matchTime);
            }

            this.player.five2FiveManager.isAgreeOrRefuse = Const.Five2Five.five2five_choice_ready.value;
        } else {
            int avgWaitTime = Five2FiveService.getInstance().getAvgWaitTime(true);
            Five2FiveHandler.Five2FiveMatchTime.Builder matchTime = Five2FiveHandler.Five2FiveMatchTime.newBuilder();
            matchTime.setAvgWaitTime(avgWaitTime);
            matchTime.setMatchTime((int) (now.getTime() / 1000L));
            res.setFive2FiveMatchTime(matchTime);
            Five2FiveService.getInstance().singleApplyMatch(this.player);
            this.isAgreeOrRefuse = 0;
        }

        Five2FiveService.getInstance().pushMatchPool();
    }


    public String agreeMatch(WNPlayer player) {
        TeamManager tm = player.teamManager;
        if (tm == null) {
            return LangService.getValue("SOMETHING_ERR");
        }

        TeamData teamData = tm.getTeam();
        if (teamData == null) {
            return LangService.getValue("SOMETHING_ERR");
        }

        player.five2FiveManager.isAgreeOrRefuse = Const.Five2Five.five2five_choice_ready.value;
        Five2FiveHandler.Five2FiveMemberChoicePush.Builder choice = Five2FiveHandler.Five2FiveMemberChoicePush.newBuilder();
        choice.setS2CCode(200);
        choice.setAgreeOrReady(Const.Five2Five.five2five_choice_type_agree.value);
        choice.setPlayerId(player.getId());
        choice.setChoice(Const.Five2Five.five2five_choice_ready.value);

        int agreeNumber = 0;
        int refuseNumber = 0;
        Map<String, TeamData.TeamMemberData> teamMembers = teamData.teamMembers;
        for (TeamData.TeamMemberData memData : teamMembers.values()) {
            WNPlayer playerMem = memData.getPlayer();
            if (playerMem == null) {
                continue;
            }

            int teamMemAgreeOrRefuse = playerMem.five2FiveManager.isAgreeOrRefuse;
            if (teamMemAgreeOrRefuse == Const.Five2Five.five2five_choice_giveup.value) {
                refuseNumber++;
            }
            if (teamMemAgreeOrRefuse == Const.Five2Five.five2five_choice_ready.value) {
                agreeNumber++;
            }
            playerMem.receive("five2five.five2FivePush.five2FiveMemberChoicePush", (GeneratedMessage) choice.build());
        }

        Five2FiveHandler.Five2FiveApplyMatchResultPush.Builder applyMatchResultPush = Five2FiveHandler.Five2FiveApplyMatchResultPush.newBuilder();
        boolean isPush = false;
        if (refuseNumber != 0 && agreeNumber + refuseNumber == teamMembers.size()) {
            applyMatchResultPush.setS2CCode(500);
            isPush = true;
        } else if (agreeNumber == teamMembers.size()) {
            Five2FiveService.getInstance().teamApplyMatch(teamData);

            applyMatchResultPush.setS2CCode(200);

            Five2FiveHandler.Five2FiveMatchTime.Builder matchTime = Five2FiveHandler.Five2FiveMatchTime.newBuilder();
            int avgWaitTime = Five2FiveService.getInstance().getAvgWaitTime(false);
            matchTime.setAvgWaitTime(avgWaitTime);
            matchTime.setMatchTime((int) (System.currentTimeMillis() / 1000L));
            applyMatchResultPush.setFive2FiveMatchTime(matchTime);
            isPush = true;
        }
        if (isPush) {
            for (TeamData.TeamMemberData teamMemberData : teamMembers.values()) {
                WNPlayer teamPlayer = teamMemberData.getPlayer();
                if (teamPlayer == null) {
                    continue;
                }
                teamPlayer.receive("five2five.five2FivePush.five2FiveApplyMatchResultPush", (GeneratedMessage) applyMatchResultPush.build());
            }


            Five2FiveService.getInstance().pushMatchPool();
        }
        return "";
    }


    public String refuseMatch(WNPlayer player) {
        TeamManager tm = player.teamManager;
        if (tm == null) {
            return LangService.getValue("SOMETHING_ERR");
        }

        TeamData teamData = tm.getTeam();
        if (teamData == null) {
            return LangService.getValue("SOMETHING_ERR");
        }

        player.five2FiveManager.isAgreeOrRefuse = Const.Five2Five.five2five_choice_giveup.value;
        Five2FiveHandler.Five2FiveMemberChoicePush.Builder choice = Five2FiveHandler.Five2FiveMemberChoicePush.newBuilder();
        choice.setS2CCode(200);
        choice.setAgreeOrReady(Const.Five2Five.five2five_choice_type_agree.value);
        choice.setPlayerId(player.getId());
        choice.setChoice(Const.Five2Five.five2five_choice_giveup.value);

        Map<String, TeamData.TeamMemberData> teamMembers = teamData.teamMembers;
        for (TeamData.TeamMemberData memData : teamMembers.values()) {
            WNPlayer playerMem = memData.getPlayer();
            if (playerMem == null) {
                continue;
            }
            playerMem.receive("five2five.five2FivePush.five2FiveMemberChoicePush", (GeneratedMessage) choice.build());
        }
        return "";
    }


    public String matchReady(String tempTeamId) {
        Five2FiveMatchTeamVo tempTeamVo = Five2FiveService.getInstance().getMatchingTeam(tempTeamId);
        if (tempTeamVo == null) {
            return LangService.getValue("SOMETHING_ERR");
        }

        CopyOnWriteArrayList<Five2FiveTempTeamMember> tempTeamMembers = tempTeamVo.tempTeamMember;
        int totalReadyNumber = 0;
        for (Five2FiveTempTeamMember tempTeamMember : tempTeamMembers) {
            String playerId = tempTeamMember.playerId;
            WNPlayer tempTeamPlayer = PlayerUtil.findPlayer(playerId);
            if (tempTeamPlayer == null) {
                continue;
            }
            if (playerId.equals(this.player.getId())) {
                tempTeamMember.isReadyOrCancel.set(Const.Five2Five.five2five_choice_ready.value);
            }
            if (tempTeamMember.isReadyOrCancel.get() == Const.Five2Five.five2five_choice_ready.value) {
                totalReadyNumber++;
            }

            Five2FiveService.getInstance().pushReady(this.player.getId(), playerId);
        }

        CopyOnWriteArrayList<Five2FiveTempTeamMember> oppoTempTeamMembers = (Five2FiveService.getInstance().getMatchingTeam(tempTeamVo.oppoTempTeamId)).tempTeamMember;
        for (Five2FiveTempTeamMember tempTeamMember : oppoTempTeamMembers) {
            if (tempTeamMember.isReadyOrCancel.get() == Const.Five2Five.five2five_choice_ready.value) {
                totalReadyNumber++;
            }

            Five2FiveService.getInstance().pushReady(this.player.getId(), tempTeamMember.playerId);
        }
        if (totalReadyNumber == tempTeamMembers.size() + oppoTempTeamMembers.size()) {
            if (!tempTeamVo.isAllChoice.get()) {
                Five2FiveMatchTeamVo tempTeamVoB = Five2FiveService.getInstance().getMatchingTeam(tempTeamVo.oppoTempTeamId);
                Five2FiveService.getInstance().afterAllChoiced(tempTeamVo, tempTeamVoB);
                tempTeamVo.isAllChoice.set(true);
            } else {
                return "";
            }
        }
        return "";
    }


    public String reciveReward() {
        Five2FivePO five2FivePo = this.player.allBlobData.five2FivePo;
        if (five2FivePo == null) {
            return LangService.getValue("FIVE_2_FIVE_NO_REWERD_CAN_RECIVE");
        }
        int canReciveRewardCount = canReciveRewardCount();
        if (canReciveRewardCount == 0) {
            return LangService.getValue("FIVE_2_FIVE_NO_REWERD_CAN_RECIVE");
        }

        DayRewardExt dayReward = (DayRewardExt) GameData.DayRewards.get(Integer.valueOf(five2FivePo.hasReciveRewardCount + 1));
        if (dayReward == null) {
            return LangService.getValue("FIVE_2_FIVE_NO_REWERD_CAN_RECIVE");
        }

        List<NormalItem> rankReward = Five2FiveService.getInstance().createItem(dayReward.dayRewards);

        if (!this.player.getWnBag().testAddEntityItems(rankReward, true)) {
            return LangService.getValue("BAG_NOT_ENOUGH_POS");
        }

        this.player.getWnBag().addEntityItems(rankReward, Const.GOODS_CHANGE_TYPE.five2five);


        five2FivePo.lastReciveRewardTime = new Date();
        five2FivePo.hasReciveRewardCount++;

        updateSuperScript();
        return "";
    }


    public String shardMatchResult(String instanceId) {
        List<Five2FivePlayerBtlReportPO> five2FiveBtlReportPO = this.player.allBlobData.five2FiveBtlReportPO;
        if (five2FiveBtlReportPO == null) {
            return LangService.getValue("FIVE_2_FIVE_NO_REPORT");
        }
        int resultA = Five2FiveService.Five2FiveResult.TIE.ordinal();
        List<Five2FivePlayerResultInfoVo> resultInfos = new ArrayList<>();
        for (int i = 0; i < five2FiveBtlReportPO.size(); i++) {
            Five2FivePlayerBtlReportPO reportPo = five2FiveBtlReportPO.get(i);
            if (reportPo != null &&
                    instanceId.equals(reportPo.id)) {
                if (reportPo.resultInfoA != null && reportPo.resultInfoB != null) {
                    for (Five2FivePlayerResultInfoVo everyResultInfo : reportPo.resultInfoA.values()) {
                        resultInfos.add(everyResultInfo);

                        if (everyResultInfo.playerId.equals(reportPo.playerId)) {
                            resultA = reportPo.status;
                        }
                    }
                    for (Five2FivePlayerResultInfoVo everyResultInfo : reportPo.resultInfoB.values()) {
                        resultInfos.add(everyResultInfo);

                        if (everyResultInfo.playerId.equals(reportPo.playerId)) {
                            if (reportPo.status == Five2FiveService.Five2FiveResult.WIN.ordinal()) {
                                resultA = Five2FiveService.Five2FiveResult.FAIL.ordinal();
                                continue;
                            }
                            if (reportPo.status == Five2FiveService.Five2FiveResult.FAIL.ordinal()) {
                                resultA = Five2FiveService.Five2FiveResult.WIN.ordinal();
                            }
                        }
                    }
                }

                break;
            }
        }
        if (resultInfos.size() == 0) {
            return LangService.getValue("FIVE_2_FIVE_NO_REPORT");
        }
        ((Five2FivePlayerResultInfoVo) resultInfos.get(0)).resultA = resultA;
        Five2FiveService.getInstance().shardMatchResult(instanceId, resultInfos);
        Out.info(new Object[]{"试炼战报,插入分享后的战报成功!角色id=", this.player.getId(), ",战报id=", instanceId});
        String shareContent = LangService.getValue("5V5_SHARE");
        shareContent = shareContent.replace("playerName", this.player.getName());
        shareContent = shareContent.replace("Battlefield", instanceId);
        return "";
    }


    public void lookBtlReport(Five2FiveHandler.Five2FiveLookBtlReportResponse.Builder res) {
        String playerId = this.player.getId();
        List<Five2FivePlayerBtlReportPO> five2FiveBtlReportPO = this.player.allBlobData.five2FiveBtlReportPO;
        List<Five2FiveHandler.Five2FiveBtlReport> playerResultInfo = new ArrayList<>();
        if (five2FiveBtlReportPO == null) {
            five2FiveBtlReportPO = Five2FiveDao.getPlayerFive2FiveBtlReportPO(playerId);
            if (five2FiveBtlReportPO == null) {
                res.setS2CCode(200);
                res.addAllBr(playerResultInfo);
                return;
            }
            this.player.allBlobData.five2FiveBtlReportPO = five2FiveBtlReportPO;
        }
        res.setS2CCode(200);
        for (Five2FivePlayerBtlReportPO btlReport : five2FiveBtlReportPO) {
            Map<String, Five2FivePlayerResultInfoVo> resultInfosA = btlReport.resultInfoA;
            Map<String, Five2FivePlayerResultInfoVo> resultInfosB = btlReport.resultInfoB;
            Map<String, Five2FivePlayerResultInfoVo> resultInfos = new HashMap<>();
            resultInfos.putAll(resultInfosA);
            resultInfos.putAll(resultInfosB);
            Five2FivePlayerResultInfoVo resultInfo = resultInfos.get(playerId);
            Five2FiveHandler.Five2FiveBtlReport.Builder five2FiveBtlReport = Five2FiveHandler.Five2FiveBtlReport.newBuilder();
            five2FiveBtlReport.setStatus(btlReport.status);
            five2FiveBtlReport.setScoreChange(btlReport.scoreChange);
            five2FiveBtlReport.setKillCount(resultInfo.killCount);
            five2FiveBtlReport.setHurt(resultInfo.hurt);
            five2FiveBtlReport.setTreatMent(resultInfo.treatMent);
            Date createTime = btlReport.createTime;
            String createTimeStr = DateUtil.format(createTime, "yyyy/MM/dd");
            five2FiveBtlReport.setCreateTime(createTimeStr);
            playerResultInfo.add(five2FiveBtlReport.build());
        }
        res.addAllBr(playerResultInfo);
    }


    public void lookMatchResult(String matchResultId, Five2FiveHandler.Five2FiveLookMatchResultResponse.Builder res) {
        List<Five2FivePlayerResultInfoVo> resultInfos = Five2FiveService.getInstance().queryResultInfos(matchResultId);
        if (resultInfos.size() == 0) {
            res.setS2CCode(500);
            res.setS2CMsg(LangService.getValue("FIVE_2_FIVE_NO_REPORT"));
            return;
        }
        res.setS2CCode(200);
        List<Five2FivePlayerResultInfoVo> playerResultInfos = Five2FiveService.getInstance().queryResultInfos(matchResultId);
        List<Five2FiveHandler.Five2FivePlayerResultInfo> playerResultInfosA = new ArrayList<>();
        List<Five2FiveHandler.Five2FivePlayerResultInfo> playerResultInfosB = new ArrayList<>();
        int number = 0;
        for (Five2FivePlayerResultInfoVo everyResultInfo : playerResultInfos) {
            Five2FiveHandler.Five2FivePlayerResultInfo.Builder tempResult = Five2FiveHandler.Five2FivePlayerResultInfo.newBuilder();
            tempResult.setHurt(everyResultInfo.hurt);
            tempResult.setIsMvp(everyResultInfo.isMvp);
            tempResult.setKillCount(everyResultInfo.killCount);
            tempResult.setPlayerId(everyResultInfo.playerId);
            tempResult.setTreatMent(everyResultInfo.treatMent);
            tempResult.setPlayerName(everyResultInfo.playerName);
            tempResult.setPlayerLevel(everyResultInfo.playerLevel);
            tempResult.setPlayerPro(everyResultInfo.playerPro);
            tempResult.setDeadCount(everyResultInfo.deadCount);
            if (number < Five2FiveMatchPool.getBeginNeedCount()) {
                playerResultInfosA.add(tempResult.build());
            } else {
                playerResultInfosB.add(tempResult.build());
            }
            number++;
        }
        res.setS2CCode(200);
        res.addAllResultInfoA(playerResultInfosA);
        res.addAllResultInfoB(playerResultInfosB);
        res.setResultA(((Five2FivePlayerResultInfoVo) resultInfos.get(0)).resultA);
    }


    public void refreshRewardCount() {
        Five2FivePO five2FivePo = this.player.allBlobData.five2FivePo;
        Date lastChallengeTime = five2FivePo.lastChallengeTime;
        if (lastChallengeTime == null || DateUtil.canRefreshData(5, lastChallengeTime)) {
            five2FivePo.canReciveRewardCount = 0;
            five2FivePo.hasReciveRewardCount = 0;
        }
    }


    public int canReciveRewardCount() {
        Five2FivePO five2FivePo = this.player.allBlobData.five2FivePo;
        if (five2FivePo == null) {
            return 0;
        }
        refreshRewardCount();
        return five2FivePo.canReciveRewardCount - five2FivePo.hasReciveRewardCount;
    }


    public Date applyMatchTime(String playerId) {
        return Five2FiveService.getInstance().applyMatchTime(playerId);
    }


    public void refreshNewDay() {
        updateSuperScript();
        Out.debug(new Object[]{"==========>> Five2FiveManager.refreshNewDay() on ", new Date()});
    }


    public String leaveFive2FiveArea() {
        int historyAreaId = (this.player.getPlayerTempData()).historyAreaId;
        if (historyAreaId <= 0) {
            return LangService.getValue("AREA_ID_NULL");
        }

        Object finalResult = AreaUtil.dispatchByAreaId(this.player, historyAreaId, (this.player.getPlayerTempData()).historyX, (this.player.getPlayerTempData()).historyY);
        if (finalResult != null) {
            return LangService.getValue("AREA_ID_NULL");
        }
        return LangService.getValue("SOMETHING_ERR");
    }


    public void onGameEnd(String resultInstanceId, int result, int killCount, int hurt, int treatMent, int scoreChange, boolean isMvp, Map<String, Five2FivePlayerResultInfoVo> resultInfosA, Map<String, Five2FivePlayerResultInfoVo> resultInfosB) {
        Five2FivePO five2FivePO = this.player.allBlobData.five2FivePo;
        refreshFive2FiveInfo(five2FivePO);
        int oldScore = five2FivePO.score;
        five2FivePO.score = (five2FivePO.score + scoreChange < 0) ? 0 : (five2FivePO.score + scoreChange);
        if (result == Five2FiveService.Five2FiveResult.WIN.ordinal()) {
            five2FivePO.winCount++;
        } else if (result == Five2FiveService.Five2FiveResult.TIE.ordinal()) {
            five2FivePO.tieCount++;
        } else {
            five2FivePO.failCount++;
        }
        if (isMvp) {
            five2FivePO.mvpCount++;
        }
        five2FivePO.canReciveRewardCount = (five2FivePO.canReciveRewardCount + 1 >= GlobalConfig.Group_RewardTimes) ? GlobalConfig.Group_RewardTimes : (five2FivePO.canReciveRewardCount + 1);
        five2FivePO.lastChallengeTime = new Date();


        Five2FivePlayerBtlReportPO reportPo = new Five2FivePlayerBtlReportPO();
        reportPo.id = resultInstanceId;
        reportPo.playerId = this.player.getId();
        reportPo.status = result;
        reportPo.scoreChange = five2FivePO.score - oldScore;
        reportPo.resultInfoA = resultInfosA;
        reportPo.resultInfoB = resultInfosB;
        reportPo.createTime = new Date();
        List<Five2FivePlayerBtlReportPO> reportPos = this.player.allBlobData.five2FiveBtlReportPO;
        if (reportPos == null) {
            reportPos = Five2FiveDao.getPlayerFive2FiveBtlReportPO(this.player.getId());
        }
        if (reportPos.size() >= GlobalConfig.Group_Record) {
            Five2FivePlayerBtlReportPO firstBtlReport = reportPos.get(reportPos.size() - 1);
            Five2FiveService.getInstance().delPlayerFive2FiveBtlReportPO(firstBtlReport);
            reportPos.remove(reportPos.size() - 1);
            Out.info(new Object[]{"试炼战报,删除多余的战报:角色id=", this.player.getId(), ",战报id=", firstBtlReport.id});
        }
        reportPos.add(0, reportPo);
        this.player.allBlobData.five2FiveBtlReportPO = reportPos;

        Five2FiveService.getInstance().updatePlayerFive2FiveBtlReportPO(reportPo);
        Out.info(new Object[]{"试炼战报,写入战报:角色id=", this.player.getId(), ",战报id=", reportPo.id});

        int oldRank = Five2FiveService.getInstance().getPlayerRank(this.player.getId());


        RankType.PVP_5V5.getHandler().asyncUpdateRank(GWorld.__SERVER_ID, this.player.getId(), five2FivePO.score);

        Five2FiveHandler.Five2FiveOnGameEndPush.Builder gameEndPush = Five2FiveHandler.Five2FiveOnGameEndPush.newBuilder();
        gameEndPush.setS2CCode(200);
        Five2FiveHandler.Five2FiveGameResult.Builder gameResult = Five2FiveHandler.Five2FiveGameResult.newBuilder();
        gameResult.setResult(result);
        gameResult.setNewScore(five2FivePO.score - oldScore);
        gameResult.setCurrScore(five2FivePO.score);
        gameResult.setMvpCount(five2FivePO.mvpCount);
        int currentRank = Five2FiveService.getInstance().getPlayerRank(this.player.getId());
        gameResult.setRankChange((oldRank == 0) ? currentRank : (oldRank - currentRank));
        gameResult.setCurrRank(currentRank);
        gameResult.setInstanceId(resultInstanceId);
        gameEndPush.setS2CGameResult(gameResult);
        gameEndPush.setS2CGameOverTime(((GameMapCO) GameData.GameMaps.get(Integer.valueOf(GlobalConfig.Group_Map))).timeCount);
        List<Five2FiveHandler.Five2FivePlayerResultInfo> resultsA = new ArrayList<>();
        for (Five2FivePlayerResultInfoVo resultInfoVo : resultInfosA.values()) {
            Five2FiveHandler.Five2FivePlayerResultInfo.Builder temp = Five2FiveHandler.Five2FivePlayerResultInfo.newBuilder();
            temp.setPlayerId(resultInfoVo.playerId);
            temp.setKillCount(resultInfoVo.killCount);
            temp.setHurt(resultInfoVo.hurt);
            temp.setTreatMent(resultInfoVo.treatMent);
            temp.setIsMvp(resultInfoVo.isMvp);
            temp.setPlayerName(resultInfoVo.playerName);
            temp.setPlayerLevel(resultInfoVo.playerLevel);
            temp.setPlayerPro(resultInfoVo.playerPro);
            temp.setDeadCount(resultInfoVo.deadCount);
            resultsA.add(temp.build());
        }
        List<Five2FiveHandler.Five2FivePlayerResultInfo> resultsB = new ArrayList<>();
        for (Five2FivePlayerResultInfoVo resultInfoVo : resultInfosB.values()) {
            Five2FiveHandler.Five2FivePlayerResultInfo.Builder temp = Five2FiveHandler.Five2FivePlayerResultInfo.newBuilder();
            temp.setPlayerId(resultInfoVo.playerId);
            temp.setKillCount(resultInfoVo.killCount);
            temp.setHurt(resultInfoVo.hurt);
            temp.setTreatMent(resultInfoVo.treatMent);
            temp.setIsMvp(resultInfoVo.isMvp);
            temp.setPlayerName(resultInfoVo.playerName);
            temp.setPlayerLevel(resultInfoVo.playerLevel);
            temp.setPlayerPro(resultInfoVo.playerPro);
            temp.setDeadCount(resultInfoVo.deadCount);
            resultsB.add(temp.build());
        }
        gameEndPush.addAllResultInfoA(resultsA);
        gameEndPush.addAllResultInfoB(resultsB);
        this.player.receive("five2five.five2FivePush.five2FiveOnGameEndPush", (GeneratedMessage) gameEndPush.build());
        this.player.dailyActivityMgr.onEvent(Const.DailyType.PVP_5V5, "0", 1);
    }


    public void onPlayerOffline() {
        if (Five2FiveService.getInstance().isInOpenTime()) {
            Five2FiveMatchPool.singleRemoveApplyPool(this.player.getId());
        }
    }


    public void onPlayerOnline() {
        Five2FivePO five2FivePO = this.player.allBlobData.five2FivePo;
        if (five2FivePO == null) {
            five2FivePO = Five2FiveDao.getPlayerFive2FivePO(this.player.getId());
            if (five2FivePO == null) {
                return;
            }
            this.player.allBlobData.five2FivePo = five2FivePO;
        }
        Five2FiveSystemPO five2FiveSystemPo = Five2FiveService.getInstance().getFive2FiveSystemPO();
        if (five2FiveSystemPo != null) {
            Map<String, Integer> hasNoReciveRankRewardPlayer = five2FiveSystemPo.hasNoReciveRankRewardPlayer;
            if (hasNoReciveRankRewardPlayer != null && hasNoReciveRankRewardPlayer.containsKey(this.player.getId())) {
                Map<Integer, PersonalRankExt> personalRanks = GameData.PersonalRanks;
                PersonalRankExt maxExt = null;
                for (PersonalRankExt temp : personalRanks.values()) {
                    if (maxExt == null || (temp.startRank > maxExt.startRank && temp.stopRank > maxExt.stopRank)) {
                        maxExt = temp;
                    }
                }
                PersonalRankExt rankExt = null;
                int rank = ((Integer) hasNoReciveRankRewardPlayer.get(this.player.getId())).intValue();
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
                MailUtil.getInstance().sendMailToOnePlayer(this.player.getId(), (MailData) mailData, Const.GOODS_CHANGE_TYPE.five2five);
                hasNoReciveRankRewardPlayer.remove(this.player.getId());
                Five2FiveService.getInstance().updateFive2FiveSystem(five2FiveSystemPo);
            }
        }
    }


    private void refreshFive2FiveInfo(Five2FivePO five2FivePO) {
        Five2FiveSystemPO five2FiveSystemPo = Five2FiveService.getInstance().getFive2FiveSystemPO();
        Date seasonRefreshTime = five2FiveSystemPo.seasonRefreshTime;

        if (five2FivePO.updateTime == null || !DateUtil.isSameDay(five2FivePO.updateTime, seasonRefreshTime)) {
            five2FivePO.score = 0;
            five2FivePO.winCount = 0;
            five2FivePO.tieCount = 0;
            five2FivePO.failCount = 0;
            five2FivePO.mvpCount = 0;
            five2FivePO.updateTime = seasonRefreshTime;
        }
        refreshRewardCount();
    }


    private void updateSuperScript() {
        List<PlayerHandler.SuperScriptType> list = new ArrayList<>();
        list.addAll(getSuperScript());
        this.player.updateSuperScriptList(list);
    }


    public List<PlayerHandler.SuperScriptType> getSuperScript() {
        List<PlayerHandler.SuperScriptType> list = new ArrayList<>();
        if (!this.player.functionOpenManager.isOpen(Const.FunctionType.FIVE_2_FIVE.getValue())) {
            return list;
        }
        PlayerHandler.SuperScriptType.Builder data = PlayerHandler.SuperScriptType.newBuilder();
        data.setType(Const.SUPERSCRIPT_TYPE.FIVE_2_FIVE_REWARD.getValue());
        data.setNumber(canReciveRewardCount());

        PlayerHandler.SuperScriptType.Builder data2 = PlayerHandler.SuperScriptType.newBuilder();
        data2.setType(Const.SUPERSCRIPT_TYPE.FIVE_2_FIVE.getValue());
        data2.setNumber(Five2FiveService.getInstance().isInOpenTime() ? 1 : 0);

        list.add(data.build());
        list.add(data2.build());
        return list;
    }


    public void onPlayerEvent(Const.PlayerEventType eventType) {
        switch (eventType) {
            case REFRESH_NEWDAY:
                refreshNewDay();
                break;
            case AFTER_LOGIN:
                onPlayerOnline();
                break;
        }
    }


    public Const.ManagerType getManagerType() {
        return Const.ManagerType.FIVE_2_FIVE;
    }
}


