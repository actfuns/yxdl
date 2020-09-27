package com.wanniu.game.arena;

import com.wanniu.core.game.JobFactory;
import com.wanniu.core.game.entity.GPlayer;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.DateUtil;
import com.wanniu.game.GWorld;
import com.wanniu.game.area.AreaUtil;
import com.wanniu.game.arena.po.ArenaSystemPO;
import com.wanniu.game.common.ConstsTR;
import com.wanniu.game.data.base.MapBase;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.rank.RankType;
import com.wanniu.game.rank.handler.ArenaScoreAllRankHandler;
import com.wanniu.game.rank.handler.ArenaScoreRankHandler;
import com.wanniu.redis.GameDao;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class ArenaService {
    private static final long MIN_SEASON_MILLISEC = TimeUnit.DAYS.toMillis(3L);

    public static final int ARENA_MAP_ID = 70002;

    private ArenaSystemPO arenaSystem;

    private MapBase arenaMap;
    private Date beginTime;
    private Date endTime;
    private Date awardTime;
    private static ArenaService instance;

    public MapBase getArenaMap() {
        return this.arenaMap;
    }


    public static ArenaService getInstance() {
        if (instance == null) {
            instance = new ArenaService();
        }
        return instance;
    }


    private ArenaService() {
        init();
    }

    private void init() {
        initOpenTime();
        initArenaSystem();

        long delay = DateUtil.getFiveDelay();
        Out.info(new Object[]{"arenaService init timer delay:", Long.valueOf(delay)});
        JobFactory.addScheduleJob(new Runnable() {
            public void run() {
                Out.info(new Object[]{"arenaService scheduleJob..."}, );
                ArenaService.this.initOpenTime();
            }
        }, delay, TimeUnit.DAYS.toMillis(1L));


        delay = DateUtil.getTaskDelay(this.beginTime);
        delay -= TimeUnit.MINUTES.toMillis(5L);
        JobFactory.addScheduleJob(new Runnable() {
                                      public void run() {
                                          if (ArenaService.this.checkIsOpenDay()) {
                                              RankType.ARENA_SCORE.getHandler().delRank(GWorld.__SERVER_ID);
                                          }
                                      }
                                  },
                delay, TimeUnit.DAYS.toMillis(1L));

        long seasonDelay = this.arenaSystem.seasonResetTime.getTime() - System.currentTimeMillis();
        JobFactory.addScheduleJob(new Runnable() {
            public void run() {
                Out.info(new Object[]{"SoloService reset soloSeason ..."}, );
                ArenaService.this.resetSeason();
            }
        }, seasonDelay, GlobalConfig.JJC_SeasonDay * TimeUnit.DAYS.toMillis(1L));


        JobFactory.addScheduleJob(new Runnable() {
            public void run() {
                for (GPlayer p : PlayerUtil.getAllOnlinePlayer()) {
                    WNPlayer wp = (WNPlayer) p;
                    wp.updateSuperScriptList(wp.arenaManager.getSuperScript());
                }
            }
        }, DateUtil.getTaskDelay(this.beginTime), TimeUnit.DAYS.toMillis(1L));

        JobFactory.addScheduleJob(new Runnable() {
            public void run() {
                for (GPlayer p : PlayerUtil.getAllOnlinePlayer()) {
                    WNPlayer wp = (WNPlayer) p;
                    wp.updateSuperScriptList(wp.arenaManager.getSuperScript());
                }
            }
        }, DateUtil.getTaskDelay(this.endTime), TimeUnit.DAYS.toMillis(1L));
    }


    private void resetSeason() {
        Out.info(new Object[]{"reset term in ArenaService.resetSeason..."});
        this.arenaSystem.term++;
        this.arenaSystem.seasonResetTime = calcSoloSeasonTime();
        updateArenaSystemToRedis();
    }


    private Date calcSoloSeasonTime() {
        Date endDate = calcSeasonEndTime(GlobalConfig.JJC_SeasonDay, GlobalConfig.JJC_SeasonWeekday);
        if (endDate.getTime() - System.currentTimeMillis() < MIN_SEASON_MILLISEC) {
            endDate = calcSeasonEndTime(GlobalConfig.JJC_SeasonDay + 7, GlobalConfig.JJC_SeasonWeekday);
        }
        return endDate;
    }


    public Date getSeasonEndTime() {
        return this.arenaSystem.seasonResetTime;
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


    public int getTerm() {
        return this.arenaSystem.term;
    }


    private void initOpenTime() {
        this.arenaMap = AreaUtil.getAreaProp(70002);
        String[] openTimes = GlobalConfig.JJC_Daily_OpenTime.split(";")[0].split(",");
        this.beginTime = DateUtil.format(openTimes[0]);
        this.endTime = DateUtil.format(openTimes[1]);
        this.awardTime = DateUtil.format(GlobalConfig.JJC_Daily_Award);
    }


    private void initArenaSystem() {
        ArenaSystemPO syspo = (ArenaSystemPO) GameDao.get(String.valueOf(GWorld.__SERVER_ID), ConstsTR.arenaSystemTR, ArenaSystemPO.class);
        if (syspo != null) {
            this.arenaSystem = syspo;
        } else {
            this.arenaSystem = new ArenaSystemPO(String.valueOf(GWorld.__SERVER_ID));
            this.arenaSystem.seasonResetTime = calcSoloSeasonTime();
            updateArenaSystemToRedis();
        }
    }


    public long getBeginTime() {
        return this.beginTime.getTime();
    }


    public long getEndTime() {
        return this.endTime.getTime();
    }


    public boolean isInOpenTime() {
        if (!checkIsOpenDay()) {
            return false;
        }
        Date nowTime = new Date();
        if (nowTime.after(this.beginTime) && nowTime.before(this.endTime)) {
            return true;
        }
        return false;
    }


    public boolean checkIsOpenDay() {
        Calendar c = Calendar.getInstance();
        int weekDay = c.get(7) - 1;
        return GlobalConfig.JJC_Weekly_OpenTime.contains(String.valueOf(weekDay));
    }


    private void updateArenaSystemToRedis() {
        GameDao.update(String.valueOf(GWorld.__SERVER_ID), ConstsTR.arenaSystemTR, this.arenaSystem);
    }

    private double getDoubleScoreByMills(int score) {
        long time = this.arenaSystem.seasonResetTime.getTime();
        String s = score + "." + (time - System.currentTimeMillis());
        return Double.parseDouble(s);
    }


    public void refreshScoreRank(String playerId, int score) {
        ArenaScoreRankHandler.getInstance().asyncUpdateRank(GWorld.__SERVER_ID, playerId, score);
    }


    public int getLastAllScoreRank(String playerId) {
        int term = getTerm();
        if (term <= 0) {
            return 0;
        }
        return (int) RankType.ARENA_SCOREALL.getHandler().getSeasonRank(GWorld.__SERVER_ID, term - 1, playerId);
    }


    public int getCurrentAllScoreRank(String playerId) {
        return (int) RankType.ARENA_SCOREALL.getHandler().getSeasonRank(GWorld.__SERVER_ID, getTerm(), playerId);
    }


    public int getCurrentAllScoreScore(String playerId) {
        return (PlayerUtil.getOnlinePlayer(playerId)).arenaManager.getCurrentTotalScore();
    }


    public void refreshMonthScoreRank(String playerId, int scoreMonth) {
        ArenaScoreAllRankHandler.getInstance().asyncUpdateRank(GWorld.__SERVER_ID, playerId, scoreMonth);
    }


    public boolean canDrawDayAward() {
        return false;
    }
}


