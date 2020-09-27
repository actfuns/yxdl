/*     */ package com.wanniu.game.arena;
/*     */ 
/*     */ import com.wanniu.core.game.JobFactory;
/*     */ import com.wanniu.core.game.entity.GPlayer;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.util.DateUtil;
/*     */ import com.wanniu.game.GWorld;
/*     */ import com.wanniu.game.area.AreaUtil;
/*     */ import com.wanniu.game.arena.po.ArenaSystemPO;
/*     */ import com.wanniu.game.common.ConstsTR;
/*     */ import com.wanniu.game.data.base.MapBase;
/*     */ import com.wanniu.game.player.GlobalConfig;
/*     */ import com.wanniu.game.player.PlayerUtil;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.rank.RankType;
/*     */ import com.wanniu.game.rank.handler.ArenaScoreAllRankHandler;
/*     */ import com.wanniu.game.rank.handler.ArenaScoreRankHandler;
/*     */ import com.wanniu.redis.GameDao;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ArenaService
/*     */ {
/*  28 */   private static final long MIN_SEASON_MILLISEC = TimeUnit.DAYS.toMillis(3L);
/*     */   
/*     */   public static final int ARENA_MAP_ID = 70002;
/*     */   
/*     */   private ArenaSystemPO arenaSystem;
/*     */   
/*     */   private MapBase arenaMap;
/*     */   private Date beginTime;
/*     */   private Date endTime;
/*     */   private Date awardTime;
/*     */   private static ArenaService instance;
/*     */   
/*     */   public MapBase getArenaMap() {
/*  41 */     return this.arenaMap;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static ArenaService getInstance() {
/*  47 */     if (instance == null) {
/*  48 */       instance = new ArenaService();
/*     */     }
/*  50 */     return instance;
/*     */   }
/*     */ 
/*     */   
/*     */   private ArenaService() {
/*  55 */     init();
/*     */   }
/*     */   
/*     */   private void init() {
/*  59 */     initOpenTime();
/*  60 */     initArenaSystem();
/*     */     
/*  62 */     long delay = DateUtil.getFiveDelay();
/*  63 */     Out.info(new Object[] { "arenaService init timer delay:", Long.valueOf(delay) });
/*  64 */     JobFactory.addScheduleJob(new Runnable()
/*     */         {
/*     */           public void run() {
/*  67 */             Out.info(new Object[] { "arenaService scheduleJob..." }, );
/*  68 */             ArenaService.this.initOpenTime();
/*     */           }
/*  70 */         },  delay, TimeUnit.DAYS.toMillis(1L));
/*     */ 
/*     */     
/*  73 */     delay = DateUtil.getTaskDelay(this.beginTime);
/*  74 */     delay -= TimeUnit.MINUTES.toMillis(5L);
/*  75 */     JobFactory.addScheduleJob(new Runnable()
/*     */         {
/*     */           public void run() {
/*  78 */             if (ArenaService.this.checkIsOpenDay()) {
/*  79 */               RankType.ARENA_SCORE.getHandler().delRank(GWorld.__SERVER_ID);
/*     */             }
/*     */           }
/*     */         }, 
/*  83 */         delay, TimeUnit.DAYS.toMillis(1L));
/*     */     
/*  85 */     long seasonDelay = this.arenaSystem.seasonResetTime.getTime() - System.currentTimeMillis();
/*  86 */     JobFactory.addScheduleJob(new Runnable()
/*     */         {
/*     */           public void run() {
/*  89 */             Out.info(new Object[] { "SoloService reset soloSeason ..." }, );
/*  90 */             ArenaService.this.resetSeason();
/*     */           }
/*  92 */         },  seasonDelay, GlobalConfig.JJC_SeasonDay * TimeUnit.DAYS.toMillis(1L));
/*     */ 
/*     */     
/*  95 */     JobFactory.addScheduleJob(new Runnable()
/*     */         {
/*     */           public void run()
/*     */           {
/*  99 */             for (GPlayer p : PlayerUtil.getAllOnlinePlayer()) {
/* 100 */               WNPlayer wp = (WNPlayer)p;
/* 101 */               wp.updateSuperScriptList(wp.arenaManager.getSuperScript());
/*     */             } 
/*     */           }
/* 104 */         },  DateUtil.getTaskDelay(this.beginTime), TimeUnit.DAYS.toMillis(1L));
/*     */     
/* 106 */     JobFactory.addScheduleJob(new Runnable()
/*     */         {
/*     */           public void run()
/*     */           {
/* 110 */             for (GPlayer p : PlayerUtil.getAllOnlinePlayer()) {
/* 111 */               WNPlayer wp = (WNPlayer)p;
/* 112 */               wp.updateSuperScriptList(wp.arenaManager.getSuperScript());
/*     */             } 
/*     */           }
/* 115 */         },  DateUtil.getTaskDelay(this.endTime), TimeUnit.DAYS.toMillis(1L));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void resetSeason() {
/* 124 */     Out.info(new Object[] { "reset term in ArenaService.resetSeason..." });
/* 125 */     this.arenaSystem.term++;
/* 126 */     this.arenaSystem.seasonResetTime = calcSoloSeasonTime();
/* 127 */     updateArenaSystemToRedis();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Date calcSoloSeasonTime() {
/* 136 */     Date endDate = calcSeasonEndTime(GlobalConfig.JJC_SeasonDay, GlobalConfig.JJC_SeasonWeekday);
/* 137 */     if (endDate.getTime() - System.currentTimeMillis() < MIN_SEASON_MILLISEC) {
/* 138 */       endDate = calcSeasonEndTime(GlobalConfig.JJC_SeasonDay + 7, GlobalConfig.JJC_SeasonWeekday);
/*     */     }
/* 140 */     return endDate;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getSeasonEndTime() {
/* 150 */     return this.arenaSystem.seasonResetTime;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Date calcSeasonEndTime(int term, int endWeekDay) {
/* 161 */     if (endWeekDay >= 7) {
/* 162 */       endWeekDay = 0;
/*     */     }
/* 164 */     Date endDate = DateUtil.getFiveTimeOfDay(DateUtil.getDateAfter(term));
/* 165 */     Calendar endC = Calendar.getInstance();
/* 166 */     endC.setTime(endDate);
/* 167 */     endC.set(7, endWeekDay + 1);
/*     */     
/* 169 */     return endC.getTime();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTerm() {
/* 178 */     return this.arenaSystem.term;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void initOpenTime() {
/* 185 */     this.arenaMap = AreaUtil.getAreaProp(70002);
/* 186 */     String[] openTimes = GlobalConfig.JJC_Daily_OpenTime.split(";")[0].split(",");
/* 187 */     this.beginTime = DateUtil.format(openTimes[0]);
/* 188 */     this.endTime = DateUtil.format(openTimes[1]);
/* 189 */     this.awardTime = DateUtil.format(GlobalConfig.JJC_Daily_Award);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void initArenaSystem() {
/* 196 */     ArenaSystemPO syspo = (ArenaSystemPO)GameDao.get(String.valueOf(GWorld.__SERVER_ID), ConstsTR.arenaSystemTR, ArenaSystemPO.class);
/* 197 */     if (syspo != null) {
/* 198 */       this.arenaSystem = syspo;
/*     */     } else {
/* 200 */       this.arenaSystem = new ArenaSystemPO(String.valueOf(GWorld.__SERVER_ID));
/* 201 */       this.arenaSystem.seasonResetTime = calcSoloSeasonTime();
/* 202 */       updateArenaSystemToRedis();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getBeginTime() {
/* 210 */     return this.beginTime.getTime();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getEndTime() {
/* 217 */     return this.endTime.getTime();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isInOpenTime() {
/* 224 */     if (!checkIsOpenDay()) {
/* 225 */       return false;
/*     */     }
/* 227 */     Date nowTime = new Date();
/* 228 */     if (nowTime.after(this.beginTime) && nowTime.before(this.endTime)) {
/* 229 */       return true;
/*     */     }
/* 231 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean checkIsOpenDay() {
/* 241 */     Calendar c = Calendar.getInstance();
/* 242 */     int weekDay = c.get(7) - 1;
/* 243 */     return GlobalConfig.JJC_Weekly_OpenTime.contains(String.valueOf(weekDay));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void updateArenaSystemToRedis() {
/* 250 */     GameDao.update(String.valueOf(GWorld.__SERVER_ID), ConstsTR.arenaSystemTR, this.arenaSystem);
/*     */   }
/*     */   
/*     */   private double getDoubleScoreByMills(int score) {
/* 254 */     long time = this.arenaSystem.seasonResetTime.getTime();
/* 255 */     String s = score + "." + (time - System.currentTimeMillis());
/* 256 */     return Double.parseDouble(s);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void refreshScoreRank(String playerId, int score) {
/* 263 */     ArenaScoreRankHandler.getInstance().asyncUpdateRank(GWorld.__SERVER_ID, playerId, score);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getLastAllScoreRank(String playerId) {
/* 273 */     int term = getTerm();
/* 274 */     if (term <= 0) {
/* 275 */       return 0;
/*     */     }
/* 277 */     return (int)RankType.ARENA_SCOREALL.getHandler().getSeasonRank(GWorld.__SERVER_ID, term - 1, playerId);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getCurrentAllScoreRank(String playerId) {
/* 287 */     return (int)RankType.ARENA_SCOREALL.getHandler().getSeasonRank(GWorld.__SERVER_ID, getTerm(), playerId);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getCurrentAllScoreScore(String playerId) {
/* 297 */     return (PlayerUtil.getOnlinePlayer(playerId)).arenaManager.getCurrentTotalScore();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void refreshMonthScoreRank(String playerId, int scoreMonth) {
/* 304 */     ArenaScoreAllRankHandler.getInstance().asyncUpdateRank(GWorld.__SERVER_ID, playerId, scoreMonth);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canDrawDayAward() {
/* 320 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\arena\ArenaService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */