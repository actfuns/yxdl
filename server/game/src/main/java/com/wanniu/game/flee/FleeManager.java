package com.wanniu.game.flee;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GEntity;
import com.wanniu.core.util.DateUtil;
import com.wanniu.game.GWorld;
import com.wanniu.game.area.AreaUtil;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.ConstsTR;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.ext.BattleRoyaleRankExt;
import com.wanniu.game.item.ItemUtil;
import com.wanniu.game.item.NormalItem;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.FleePO;
import com.wanniu.game.rank.RankType;
import com.wanniu.redis.PlayerPOManager;

import java.util.Date;
import java.util.List;

import pomelo.area.FleeHandler;


public class FleeManager {
    private WNPlayer player;
    private FleePO fleePo;
    private long joinTime;

    public FleeManager(WNPlayer player) {
        this.player = player;
        this.fleePo = loadFleePO(player.getId());
    }

    private FleePO loadFleePO(String playerId) {
        FleePO fleePO = (FleePO) PlayerPOManager.findPO(ConstsTR.player_fleeTR, playerId, FleePO.class);
        if (fleePO == null) {
            fleePO = new FleePO();
            PlayerPOManager.put(ConstsTR.player_fleeTR, playerId, (GEntity) fleePO);
        }
        return fleePO;
    }


    public FleeHandler.FleeInfoResponse getFleeInfoResponse() {
        refreshFlee();

        FleeHandler.FleeInfoResponse.Builder res = FleeHandler.FleeInfoResponse.newBuilder();
        res.setS2CCode(200);
        res.setCurrentRank(FleeService.getInstance().getPlayerRank(this.player.getId()));
        res.setMaxRank(this.fleePo.maxRank);
        res.setGrade(this.fleePo.grade);
        res.setMaxGrade(this.fleePo.maxGrade);
        res.setScore(this.fleePo.score);
        res.setSeasonEndTime(this.fleePo.seasonEndTime.getTime());
        res.setJoinTime(0);
        if (FleeService.getInstance().getMatchPlayer().contains(this.player.getId())) {
            res.setJoinTime((int) Math.floor((this.joinTime / 1000L)));
            res.setAvgMatchTime(FleeService.getInstance().getAvgMatchingTime());
        }
        for (BattleRoyaleRankExt r : GameData.BattleRoyaleRanks.values()) {
            FleeHandler.GradeReward.Builder re = FleeHandler.GradeReward.newBuilder();
            re.setGradeId(r.iD);
            if (this.fleePo.receiveGrades.contains(Integer.valueOf(r.iD))) {
                re.setStatus(2);
            } else {
                re.setStatus((this.fleePo.grade >= r.iD && this.fleePo.isPlayed) ? 1 : 0);
            }
            res.addGradeRewards(re);
        }

        return res.build();
    }

    private void refreshFlee() {
        Date seasonEndDate = FleeService.getInstance().getSeasonEndDate();
        if (!DateUtil.isSameDay(this.fleePo.seasonEndTime, seasonEndDate)) {
            this.fleePo.seasonEndTime = seasonEndDate;
            this.fleePo.receiveGrades.clear();
            resetGrade();
        }
    }


    public FleeHandler.FleeLookBtlReportResponse getFleeLookBtlReportResponse() {
        FleeHandler.FleeLookBtlReportResponse.Builder res = FleeHandler.FleeLookBtlReportResponse.newBuilder();
        res.setS2CCode(200);

        for (int i = this.fleePo.reports.size() - 1; i >= 0; i--) {
            FleeReportCO co = this.fleePo.reports.get(i);
            FleeHandler.FleeBtlReport.Builder rep = FleeHandler.FleeBtlReport.newBuilder();
            rep.setCreateTime(co.datetime);
            rep.setRank(co.rank);
            rep.setScoreChange(co.scoreChange);
            res.addBr(rep);
        }

        return res.build();
    }


    public FleeHandler.GetRewardResponse getRewardResponse(int gradeId) {
        FleeHandler.GetRewardResponse.Builder res = FleeHandler.GetRewardResponse.newBuilder();
        res.setS2CCode(200);
        if (this.fleePo.receiveGrades.contains(Integer.valueOf(gradeId))) {
            res.setS2CCode(500);
            res.setS2CMsg(LangService.getValue("FLEE_GOT"));
            return res.build();
        }
        if (this.fleePo.grade < gradeId) {
            res.setS2CCode(500);
            res.setS2CMsg(LangService.getValue("FLEE_CANNOT_GOT_THIS_RANK"));
            return res.build();
        }
        BattleRoyaleRankExt re = (BattleRoyaleRankExt) GameData.BattleRoyaleRanks.get(Integer.valueOf(gradeId));

        List<NormalItem> gradeReward = ItemUtil.createItemsByItemCode(re.gradeRewards);
        if (!this.player.bag.testAddEntityItems(gradeReward, true)) {
            res.setS2CCode(500);
            res.setS2CMsg(LangService.getValue("BAG_NOT_ENOUGH_POS"));
            return res.build();
        }
        this.fleePo.receiveGrades.add(Integer.valueOf(gradeId));
        this.player.bag.addEntityItems(gradeReward, Const.GOODS_CHANGE_TYPE.flee);
        return res.build();
    }


    private void resetGrade() {
        int newGrade = ((BattleRoyaleRankExt) GameData.BattleRoyaleRanks.get(Integer.valueOf(this.fleePo.grade))).rankInherit;
        if (newGrade == 0) {
            newGrade = 1;
        }
        int newScore = ((BattleRoyaleRankExt) GameData.BattleRoyaleRanks.get(Integer.valueOf(newGrade))).rankScore;
        this.fleePo.grade = newGrade;
        this.fleePo.score = newScore;
    }


    public FleeHandler.EnterFleeResponse enterFlee() {
        FleeHandler.EnterFleeResponse.Builder res = FleeHandler.EnterFleeResponse.newBuilder();
        res.setS2CCode(200);
        if (!FleeService.getInstance().isInOpenTime()) {
            res.setS2CCode(500);
            res.setS2CMsg(LangService.getValue("FLEE_NOT_OPEN"));
            return res.build();
        }

        List<String> matchPlayer = FleeService.getInstance().getMatchPlayer();
        if (!matchPlayer.contains(this.player.getId())) {
            synchronized (matchPlayer) {
                matchPlayer.add(this.player.getId());
                this.joinTime = System.currentTimeMillis();
                if (matchPlayer.size() == 10) {
                    for (String id : matchPlayer) {
                        WNPlayer wp = PlayerUtil.getOnlinePlayer(id);
                        FleeService.getInstance().updateMatchingTime(wp.fleeManager.getMatchedTime());
                        AreaUtil.dispatchByAreaId(wp, GlobalConfig.Flee_MapID, null);
                    }
                    matchPlayer.clear();
                }
            }
        }
        res.setJoinTime((int) Math.floor((this.joinTime / 1000L)));
        res.setAvgMatchTime(FleeService.getInstance().getAvgMatchingTime());
        return res.build();
    }


    public void onPlayerOffline() {
        cancelMatchFlee();
    }


    public FleeHandler.CancelMatchResponse cancelMatchFlee() {
        FleeHandler.CancelMatchResponse.Builder res = FleeHandler.CancelMatchResponse.newBuilder();
        res.setS2CCode(200);

        List<String> matchPlayer = FleeService.getInstance().getMatchPlayer();
        if (matchPlayer.contains(this.player.getId())) {
            synchronized (matchPlayer) {
                matchPlayer.remove(this.player.getId());
            }
        }
        return res.build();
    }


    private int addScore(int score) {
        int oldScore = this.fleePo.score;

        this.fleePo.score += score;
        if (this.fleePo.score < 0) {
            this.fleePo.score = 0;
        }
        this.fleePo.grade = FleeService.getInstance().getGradeIdByScore(this.fleePo.score);
        if (this.fleePo.maxGrade < this.fleePo.grade) {
            this.fleePo.maxGrade = this.fleePo.grade;
        }


        RankType.FLEE.getHandler().asyncUpdateRank(GWorld.__SERVER_ID, this.player.getId(), this.fleePo.score);

        int currentRank = FleeService.getInstance().getPlayerRank(this.player.getId());
        if (this.fleePo.maxRank > currentRank) {
            this.fleePo.maxRank = currentRank;
        }

        return this.fleePo.score - oldScore;
    }


    public int onGameOver(int rank) {
        this.fleePo.isPlayed = true;
        int addScore = 0;
        if (rank <= 5) {
            addScore = GlobalConfig.Flee_OneToFive_GetPoint + (5 - rank) * 100;
        } else if (this.fleePo.score < GlobalConfig.Flee_RankBase_GetPoint) {
            addScore = GlobalConfig.Flee_RankBase_BaseGetPoint + (10 - rank) * GlobalConfig.Flee_RankBase_BaseGetPoint;
        } else {
            addScore = GlobalConfig.Flee_SixToTen_GetPoint + (rank - 6) * 100;
            addScore = -addScore;
        }

        int scoreChange = addScore(addScore);
        this.fleePo.reports.add(new FleeReportCO(DateUtil.getDateTime(), rank, scoreChange));
        if (this.fleePo.reports.size() > GlobalConfig.Flee_ReportCount) {
            this.fleePo.reports.remove(0);
        }
        return scoreChange;
    }


    public long getMatchedTime() {
        return System.currentTimeMillis() - this.joinTime;
    }
}


