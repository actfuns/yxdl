package com.wanniu.game.poes;

import com.wanniu.core.game.entity.GEntity;
import com.wanniu.core.logfs.Out;
import com.wanniu.game.DBTable;
import com.wanniu.game.common.Const;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.solo.SoloService;
import com.wanniu.game.solo.po.BattleRecordPO;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


@DBTable("player_solo_data")
public class SoloDataPO
        extends GEntity {
    public boolean havePlayed;
    public int score;
    public int curRank;
    public int soloPoint;
    public int soloPointToday;
    public int rankId;
    public Date rankGotTime;
    public Map<Integer, RankStatus> rankRewards;
    public List<RankStatus> dailyRewards;
    public int dailyReceived;
    public int dailyBattleTimes;
    public int dailyRewardRound;
    public Date dailyResetTime;
    public Date lastJoinedTime;
    public int contWinTimes;
    public int extrWinTimes;
    public int maxContWinTimes;
    public int contLoseTimes;
    public int maxContLoseTimes;
    public int term;
    public int battleTimes;
    public int winTotalTimes;
    public int loseTotalTimes;
    public int winTimes_canglang;
    public int winTimes_yujian;
    public int winTimes_yixian;
    public int winTimes_shenjian;
    public int winTimes_linghu;
    public int battleTimes_canglang;
    public int battleTimes_yujian;
    public int battleTimes_yixian;
    public int battleTimes_shenjian;
    public int battleTimes_linghu;
    public List<BattleRecordPO> battleRecords;

    public SoloDataPO() {
    }

    public SoloDataPO(String playerId) {
        this.havePlayed = false;

        this.score = 0;
        this.curRank = 0;
        this.soloPoint = 0;
        this.soloPointToday = 0;

        this.rankId = 1;
        this.rankGotTime = null;
        this.rankRewards = new HashMap<>();


        this.dailyRewards = new ArrayList<>();
        this.dailyReceived = 0;
        this.dailyBattleTimes = 0;
        this.dailyRewardRound = 0;

        this.dailyResetTime = null;
        this.lastJoinedTime = null;

        this.contWinTimes = 0;
        this.extrWinTimes = 0;
        this.maxContWinTimes = 0;
        this.contLoseTimes = 0;
        this.maxContLoseTimes = 0;


        this.term = SoloService.getInstance().getTerm();
        this.battleTimes = 0;
        this.winTotalTimes = 0;
        this.loseTotalTimes = 0;

        this.winTimes_canglang = 0;
        this.winTimes_yujian = 0;
        this.winTimes_yixian = 0;
        this.winTimes_shenjian = 0;
        this.winTimes_linghu = 0;


        this.battleTimes_canglang = 0;
        this.battleTimes_yujian = 0;
        this.battleTimes_yixian = 0;
        this.battleTimes_shenjian = 0;
        this.battleTimes_linghu = 0;
        this.battleRecords = new ArrayList<>();
    }


    private int _getWinRate(int winTimes, int battleTimes) {
        if (battleTimes == 0) {
            battleTimes = 1;
        }
        float a = winTimes;
        float b = battleTimes;
        return Math.round(a / b * 10000.0F);
    }

    public static void main(String[] args) {
        float a = 2.0F;
        float b = 3.0F;
        int c = Math.round(a / b * 10000.0F);
        System.out.println(c);
    }


    public int getWinRate(Const.Profession pro) {
        switch (pro.getValue()) {
            case 0:
                return _getWinRate(this.winTotalTimes, this.battleTimes);
            case 1:
                return _getWinRate(this.winTimes_canglang, this.battleTimes_canglang);
            case 2:
                return _getWinRate(this.winTimes_yujian, this.battleTimes_yujian);
            case 3:
                return _getWinRate(this.winTimes_yixian, this.battleTimes_yixian);
            case 4:
                return _getWinRate(this.winTimes_shenjian, this.battleTimes_shenjian);
            case 5:
                return _getWinRate(this.winTimes_linghu, this.battleTimes_linghu);
        }
        return 0;
    }


    public void recordBattle(BattleRecordPO battleRecord) {
        this.battleTimes++;
        switch (battleRecord.result) {
            case 1:
                this.winTotalTimes++;
                addBattleTimesByPro(battleRecord.vsPro, true);
                break;
            case 2:
                this.loseTotalTimes++;
                addBattleTimesByPro(battleRecord.vsPro, false);
                break;
            case 3:
                addBattleTimesByPro(battleRecord.vsPro, false);
                break;
            default:
                Out.error(new Object[]{"错误的战斗记录", getClass()});
                break;
        }
        addBattleRecord(battleRecord);
    }


    private void addBattleTimesByPro(int pro, boolean isWin) {
        switch (pro) {
            case 1:
                this.battleTimes_canglang++;
                if (isWin) {
                    this.winTimes_canglang++;
                }
                break;
            case 2:
                this.battleTimes_yujian++;
                if (isWin) {
                    this.winTimes_yujian++;
                }
                break;
            case 3:
                this.battleTimes_yixian++;
                if (isWin) {
                    this.winTimes_yixian++;
                }
                break;
            case 4:
                this.battleTimes_shenjian++;
                if (isWin) {
                    this.winTimes_shenjian++;
                }
                break;
            case 5:
                this.battleTimes_linghu++;
                if (isWin) {
                    this.winTimes_linghu++;
                }
                break;
        }
    }


    private boolean isExpired(Date oldDate, Date newDate, long validMillis) {
        return (oldDate.getTime() + validMillis < newDate.getTime());
    }


    private void addBattleRecord(BattleRecordPO battleRecord) {
        long validDay = (GlobalConfig.Solo_ReportTime * 3600 * 1000);
        Iterator<BattleRecordPO> iter = this.battleRecords.iterator();
        Date now = new Date();
        while (iter.hasNext()) {
            if (isExpired(((BattleRecordPO) iter.next()).battleTime, now, validDay)) {
                iter.remove();
            }
        }

        if (this.battleRecords.size() < GlobalConfig.Solo_ReportCount) {
            this.battleRecords.add(battleRecord);
        } else {
            this.battleRecords.remove(0);
            this.battleRecords.add(battleRecord);
        }
    }

    public static class RankStatus {
        public int rankId;
        public int status;

        public int getRankId() {
            return this.rankId;
        }

        public void setRankId(int rankId) {
            this.rankId = rankId;
        }

        public int getStatus() {
            return this.status;
        }

        public void setStatus(int status) {
            this.status = status;
        }
    }
}


