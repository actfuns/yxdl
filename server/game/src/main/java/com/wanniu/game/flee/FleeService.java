package com.wanniu.game.flee;

import com.wanniu.core.game.JobFactory;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.DateUtil;
import com.wanniu.game.GWorld;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.ConstsTR;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.ext.BattleRoyaleRankExt;
import com.wanniu.game.data.ext.BattleRoyaleRankSeasonRewardExt;
import com.wanniu.game.leaderBoard.LeaderBoardDetail;
import com.wanniu.game.mail.MailUtil;
import com.wanniu.game.mail.data.MailData;
import com.wanniu.game.mail.data.MailSysData;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.poes.FleeSystemPO;
import com.wanniu.game.rank.RankType;
import com.wanniu.redis.GameDao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;


public class FleeService {
    private FleeSystemPO fleeSystemPO;
    private static FleeService instance;
    public long sumMatchingTime;
    public int matchedNumber;
    private List<String> matchPlayer = new ArrayList<>();


    private static final long MIN_SEASON_MILLISEC = TimeUnit.DAYS.toMillis(3L);

    public static FleeService getInstance() {
        if (instance == null) {
            instance = new FleeService();
        }
        return instance;
    }

    private FleeService() {
        initFleeSystem();

        long initialDelay = this.fleeSystemPO.seasonEndTime.getTime() - System.currentTimeMillis();
        JobFactory.addFixedRateJob(new Runnable() {
            public void run() {
                try {
                    List<LeaderBoardDetail> datas = RankType.FLEE.getHandler().getRankDetail(GWorld.__SERVER_ID, 0, -1);
                    int rank = 0;
                    for (LeaderBoardDetail detail : datas) {
                        rank++;
                        Map<Integer, BattleRoyaleRankSeasonRewardExt> personalRanks = GameData.BattleRoyaleRankSeasonRewards;
                        BattleRoyaleRankSeasonRewardExt ext = null;
                        for (BattleRoyaleRankSeasonRewardExt temp : personalRanks.values()) {
                            if (rank >= temp.startRank && rank <= temp.stopRank) {
                                ext = temp;
                                break;
                            }
                        }
                        if (ext == null) {
                            continue;
                        }
                        Map<String, Integer> rankRewards = ext.rankRewards;
                        MailSysData mailData = new MailSysData("Flee_reward_last");
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
                        MailUtil.getInstance().sendMailToOnePlayer(detail.memberId, (MailData) mailData, Const.GOODS_CHANGE_TYPE.flee);
                    }
                    RankType.FLEE.getHandler().delRank(GWorld.__SERVER_ID);
                    FleeService.this.fleeSystemPO.seasonEndTime = FleeService.this.calcSoloSeasonTime();
                    GameDao.update(String.valueOf(GWorld.__SERVER_ID), ConstsTR.fleeSystemTR, FleeService.this.fleeSystemPO);
                } catch (Exception e) {
                    Out.error(new Object[]{e});
                }
            }
        }initialDelay, TimeUnit.DAYS.toMillis(7L));
    }


    private void initFleeSystem() {
        FleeSystemPO syspo = (FleeSystemPO) GameDao.get(String.valueOf(GWorld.__SERVER_ID), ConstsTR.fleeSystemTR, FleeSystemPO.class);
        if (syspo != null) {
            this.fleeSystemPO = syspo;
        } else {
            this.fleeSystemPO = new FleeSystemPO(String.valueOf(GWorld.__SERVER_ID));
            this.fleeSystemPO.seasonEndTime = calcSoloSeasonTime();
            GameDao.update(String.valueOf(GWorld.__SERVER_ID), ConstsTR.fleeSystemTR, this.fleeSystemPO);
        }
    }


    private Date calcSoloSeasonTime() {
        Date endDate = calcSeasonEndTime(GlobalConfig.Flee_SeasonDay, GlobalConfig.Flee_SeasonWeekday);
        if (endDate.getTime() - System.currentTimeMillis() < MIN_SEASON_MILLISEC) {
            endDate = calcSeasonEndTime(GlobalConfig.Flee_SeasonDay + 7, GlobalConfig.Flee_SeasonWeekday);
        }
        return endDate;
    }


    private Date calcSeasonEndTime(int term, int endWeekDay) {
        if (endWeekDay >= 7) {
            endWeekDay = 0;
        }
        Date endDate = DateUtil.getFiveTimeOfDay(DateUtil.getDateAfter(term));
        Calendar endC = Calendar.getInstance();
        endC.setTime(endDate);
        endC.set(7, endWeekDay + 1);

        return endC.getTime();
    }


    public Date getSeasonEndDate() {
        return this.fleeSystemPO.seasonEndTime;
    }


    public int getPlayerRank(String playerId) {
        return (int) RankType.FLEE.getHandler().getRank(GWorld.__SERVER_ID, playerId);
    }

    public List<String> getMatchPlayer() {
        return this.matchPlayer;
    }


    public int getGradeIdByScore(int score) {
        int max = 1;
        for (BattleRoyaleRankExt b : GameData.BattleRoyaleRanks.values()) {
            if (b.iD > max && score >= b.rankScore) {
                max = b.iD;
            }
        }
        return max;
    }


    public boolean isInOpenTime() {
        Calendar c = Calendar.getInstance();
        int weekDay = c.get(7) - 1;
        if (!GlobalConfig.Flee_Weekly_OpenTime.contains(String.valueOf(weekDay))) {
            return false;
        }
        String[] openTime = GlobalConfig.Flee_Daily_OpenTime.split(",");
        Date nowTime = new Date();
        if (nowTime.after(DateUtil.format(openTime[0])) && nowTime.before(DateUtil.format(openTime[1]))) {
            return true;
        }

        return false;
    }


    public int getAvgMatchingTime() {
        if (this.matchedNumber <= 0) {
            return GlobalConfig.Flee_MATCH_TIME;
        }
        int second = (int) (this.sumMatchingTime / this.matchedNumber) / 1000;
        if (second > GlobalConfig.Flee_MATCH_TIME) {
            second = GlobalConfig.Flee_MATCH_TIME;
        }
        return second;
    }


    public void updateMatchingTime(long matchedTime) {
        this.matchedNumber++;
        this.sumMatchingTime += matchedTime;
    }
}


