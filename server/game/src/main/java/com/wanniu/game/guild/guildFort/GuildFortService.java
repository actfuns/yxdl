/*     */ package com.wanniu.game.guild.guildFort;
/*     */ 
/*     */ import com.wanniu.core.game.JobFactory;
/*     */ import com.wanniu.core.game.LangService;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.util.DateUtil;
/*     */ import com.wanniu.game.GWorld;
/*     */ import com.wanniu.game.player.GlobalConfig;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.ScheduledFuture;
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
/*     */ public class GuildFortService
/*     */ {
/*     */   public static final int PREPARE_AREA_ID = 54001;
/*     */   public static final int PVE_AREA_ID = 54002;
/*     */   public static final int PVP_AREA_ID = 54003;
/*  29 */   private static final int DAYS_PER_ROUND = GlobalConfig.GuildFort_RoundDays;
/*  30 */   private long MILLISECONDS_PER_ROUND = (DAYS_PER_ROUND * 24 * 3600 * 1000);
/*  31 */   private long BID_END_PRE_NOTICE_TIME = 1800000L;
/*  32 */   private long BATTLE_BEGIN_PRE_NOTICE_TIME = 600000L;
/*  33 */   private long BATTLE_END_PRE_NOTICE_TIME5 = 300000L;
/*  34 */   private long BATTLE_END_PRE_NOTICE_TIME1 = 60000L;
/*  35 */   private static final String[] WEEKDAY = new String[] { "周日", "周一", "周二", "周三", "周四", "周五", "周六" };
/*  36 */   public static List<String> state = new ArrayList<>();
/*     */   
/*     */   private long bidBeginTime;
/*     */   private long bidEndTime;
/*     */   private long battlePrepareTime;
/*     */   private long battleBeginTime;
/*     */   private long battleEndTime;
/*     */   private int firstEntry;
/*  44 */   private ScheduledFuture<?> bidBeginNoticeFuture = null;
/*  45 */   private ScheduledFuture<?> bidPreEndNoticeFuture = null;
/*  46 */   private ScheduledFuture<?> battlePreNoticeFuture = null;
/*     */   
/*     */   private ScheduledFuture<?> f1;
/*     */   
/*     */   private ScheduledFuture<?> f2;
/*     */   private ScheduledFuture<?> f3;
/*     */   private ScheduledFuture<?> f4;
/*     */   private ScheduledFuture<?> f5;
/*     */   
/*     */   public static void main(String[] args) throws InterruptedException {
/*  56 */     ScheduledFuture<?> f = JobFactory.addScheduleJob(new Runnable()
/*     */         {
/*     */           public void run() {
/*  59 */             System.err.println("test future");
/*     */           }
/*     */         },  1000L, 5000L);
/*     */     
/*  63 */     Thread.sleep(2000L);
/*  64 */     while (!f.cancel(true)) {
/*  65 */       System.err.println("f cancelled:" + f.isCancelled() + " isDone:" + f.isDone());
/*  66 */       Thread.sleep(1000L);
/*     */     } 
/*     */     
/*  69 */     System.out.println("f cancelled:" + f.isCancelled() + " isDone:" + f.isDone());
/*     */   }
/*     */   
/*     */   private GuildFortService() {
/*  73 */     initDebugConfig();
/*  74 */     initTimes();
/*     */     
/*  76 */     startTimers();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void initDebugConfig() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void reload() {
/*  96 */     if (!GWorld.DEBUG) {
/*     */       return;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 102 */     this.f1.cancel(true);
/* 103 */     this.f2.cancel(true);
/* 104 */     this.f3.cancel(true);
/* 105 */     this.f4.cancel(true);
/* 106 */     this.f5.cancel(true);
/* 107 */     cancelBidNotice();
/*     */     
/* 109 */     initTimes();
/* 110 */     startTimers();
/*     */     
/* 112 */     System.err.println("init guild service reloaded......");
/*     */   }
/*     */ 
/*     */   
/*     */   private void initTimes() {
/* 117 */     long lastTime = getTimeFromString(GlobalConfig.GuildFort_BattleEndTime);
/* 118 */     long nowTime = System.currentTimeMillis();
/*     */     
/* 120 */     this.battleEndTime = getRealTime(GlobalConfig.GuildFort_BattleEndTime, lastTime, nowTime, "battleEndTime");
/*     */     
/* 122 */     this.bidBeginTime = getRealTime(GlobalConfig.GuildFort_BidStartTime, this.battleEndTime, nowTime, "bidBeginTime");
/* 123 */     this.bidEndTime = getRealTime(GlobalConfig.GuildFort_BidEndTime, this.battleEndTime, nowTime, "bidEndTime");
/* 124 */     this.battleBeginTime = getRealTime(GlobalConfig.GuildFort_BattleStartTime, this.battleEndTime, nowTime, "battleBeginTime");
/* 125 */     this.battlePrepareTime = this.battleBeginTime - (GlobalConfig.GuildFort_PreStart * 60 * 1000);
/* 126 */     logTimeInfo();
/*     */   }
/*     */   
/*     */   private long getRealTime(String timeString, long lastTime, long nowTime, String flag) {
/* 130 */     long configTime = getTimeFromString(timeString);
/*     */     
/* 132 */     if (nowTime > lastTime) {
/* 133 */       System.out.println(getRecentNextRound(configTime, nowTime));
/* 134 */       return getRecentNextRound(configTime, nowTime);
/*     */     } 
/*     */     
/* 137 */     if (flag.equals("battleEndTime")) {
/* 138 */       return getCurrentRound(configTime, lastTime, flag);
/*     */     }
/* 140 */     return getCurrentRound(configTime, lastTime, flag);
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
/*     */   private long getTimeFromString(String strTime) {
/* 153 */     if (strTime == null) {
/* 154 */       strTime = "5,8:25:00";
/*     */     }
/* 156 */     String[] strs = strTime.trim().split(",");
/* 157 */     int dayOfWeek = Integer.parseInt(strs[0]) + 1;
/* 158 */     Date date = DateUtil.format(strs[1]);
/* 159 */     Calendar c = Calendar.getInstance();
/* 160 */     c.setTime(date);
/* 161 */     c.set(7, dayOfWeek);
/* 162 */     if (dayOfWeek == 1) {
/* 163 */       c.add(7, 7);
/*     */     }
/* 165 */     return c.getTimeInMillis();
/*     */   }
/*     */   
/*     */   private long getNextRoundTime(long currentRoundTime) {
/* 169 */     Date date = new Date(currentRoundTime);
/* 170 */     if (GWorld.DEBUG) {
/* 171 */       return DateUtil.getDateAfter(date, DAYS_PER_ROUND).getTimeInMillis();
/*     */     }
/*     */ 
/*     */     
/* 175 */     return DateUtil.getDateAfter(date, DAYS_PER_ROUND).getTimeInMillis();
/*     */   }
/*     */   
/*     */   private static Calendar getDateAfterMinute(Date date, int minute) {
/* 179 */     Calendar now = Calendar.getInstance();
/* 180 */     now.setTime(date);
/*     */     
/* 182 */     now.add(12, minute);
/* 183 */     return now;
/*     */   }
/*     */   
/*     */   public void print(long timeLong) {
/* 187 */     System.err.println((new Date(timeLong)).toString());
/*     */   }
/*     */   
/*     */   private long getCurrentRound(long configTime, long lastTime, String flag) {
/* 191 */     while (configTime < lastTime && lastTime - configTime > this.MILLISECONDS_PER_ROUND) {
/* 192 */       configTime = getNextRoundTime(configTime);
/*     */     }
/*     */     
/* 195 */     return configTime;
/*     */   }
/*     */   
/*     */   private long getRecentNextRound(long configTime, long nowTime) {
/*     */     while (true) {
/* 200 */       configTime = getNextRoundTime(configTime);
/* 201 */       if (configTime > nowTime)
/* 202 */         return configTime; 
/*     */     } 
/*     */   }
/*     */   private long getDelayTime(long configTime) {
/* 206 */     long now = System.currentTimeMillis();
/* 207 */     if (configTime <= now) {
/* 208 */       configTime = getNextRoundTime(configTime);
/*     */     }
/* 210 */     long mills = configTime - now;
/* 211 */     return mills;
/*     */   }
/*     */   
/*     */   private String getLogString(String title, long time) {
/* 215 */     Date date = new Date(time);
/* 216 */     return title + "\t" + date.toString();
/*     */   }
/*     */   
/*     */   private void logTimeInfo() {
/* 220 */     StringBuilder sb = new StringBuilder("Guild Fort Times:\r\n");
/* 221 */     sb.append(getLogString("bidBeginTime\t", this.bidBeginTime)).append("\r\n");
/* 222 */     sb.append(getLogString("bidEndTime\t", this.bidEndTime)).append("\r\n");
/* 223 */     sb.append(getLogString("battlePrepareTime", this.battlePrepareTime)).append("\r\n");
/* 224 */     sb.append(getLogString("battleBeginTime\t", this.battleBeginTime)).append("\r\n");
/* 225 */     sb.append(getLogString("battleEndTime\t", this.battleEndTime)).append("\r\n");
/* 226 */     sb.append("-------------------------------------------------------------------");
/* 227 */     Out.error(new Object[] { sb.toString() });
/*     */   }
/*     */   
/*     */   private String getBidBeginNoticeMsg() {
/* 231 */     String msgStr = LangService.getValue("GUILDFORT_INBIDDING_NOTICE");
/* 232 */     msgStr = msgStr.replace("{beginTime}", getTimeString(this.bidBeginTime));
/* 233 */     msgStr = msgStr.replace("{endTime}", getTimeString(this.bidEndTime));
/*     */     
/* 235 */     return msgStr;
/*     */   }
/*     */ 
/*     */   
/*     */   private static String getTimeString(long time) {
/* 240 */     Date d = new Date(time);
/* 241 */     Calendar c = Calendar.getInstance();
/* 242 */     c.setTime(d);
/* 243 */     String timeStr = DateUtil.format(d, "HH:mm:ss");
/* 244 */     int index = c.get(7) - 1;
/* 245 */     return WEEKDAY[index] + " " + timeStr;
/*     */   }
/*     */   
/*     */   public String getBattleBeginTimeString() {
/* 249 */     return getTimeString(this.battleBeginTime);
/*     */   }
/*     */   
/*     */   public String getBattleEndTimeString() {
/* 253 */     return getTimeString(this.battleEndTime);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void startBidBeginNotice(long delay) {
/* 260 */     if (this.bidBeginNoticeFuture != null) {
/*     */       return;
/*     */     }
/* 263 */     final String msgStr = getBidBeginNoticeMsg();
/* 264 */     this.bidBeginNoticeFuture = JobFactory.addScheduleJob(new Runnable()
/*     */         {
/*     */           public void run() {
/* 267 */             GuildFortUtil.sendRollTipsToAllAnsy(msgStr);
/*     */           }
/*     */         },  delay, 86400000L);
/*     */   }
/*     */   
/*     */   private long getBidBeginNoticeDelay() {
/* 273 */     long delay = 0L;
/* 274 */     long now = System.currentTimeMillis();
/* 275 */     long begin = getTimeFromString(GlobalConfig.GuildFort_BidStartTime);
/*     */     
/* 277 */     if (begin > now) {
/* 278 */       delay = begin - now;
/*     */     } else {
/* 280 */       Date date = new Date(begin);
/* 281 */       delay = DateUtil.getDateAfter(date, 1).getTimeInMillis() - now;
/*     */     } 
/* 283 */     return delay;
/*     */   }
/*     */   
/*     */   private void startBidPreEndNotice() {
/* 287 */     if (this.bidPreEndNoticeFuture != null) {
/*     */       return;
/*     */     }
/* 290 */     final String msgStr = LangService.getValue("GUILDFORT_PREBIDEND_NOTICE");
/* 291 */     this.bidPreEndNoticeFuture = JobFactory.addDelayJob(new Runnable()
/*     */         {
/*     */           public void run() {
/* 294 */             GuildFortUtil.sendRollTipsToAllAnsy(msgStr);
/*     */           }
/* 296 */         },  getBidEndRemainMills() - this.BID_END_PRE_NOTICE_TIME);
/*     */   }
/*     */   
/*     */   private void startBattlePreNoticeFuture() {
/* 300 */     if (this.battlePreNoticeFuture != null) {
/*     */       return;
/*     */     }
/* 303 */     final String msgStr = LangService.getValue("GUILDFORT_PREBATTLE_NOTICE");
/* 304 */     this.battlePreNoticeFuture = JobFactory.addDelayJob(new Runnable()
/*     */         {
/*     */           public void run() {
/* 307 */             GuildFortUtil.sendRollTipsToAllAnsy(msgStr);
/*     */           }
/* 309 */         },  this.battlePrepareTime - System.currentTimeMillis() - this.BATTLE_BEGIN_PRE_NOTICE_TIME);
/*     */   }
/*     */   
/*     */   private void startBattleEndPreFiveMinute() {
/* 313 */     JobFactory.addDelayJob(new Runnable()
/*     */         {
/*     */           public void run() {
/* 316 */             String msgStr = LangService.getValue("GUILDFORT_ENDBATTLE_FIVEMINUTE_NOTICE");
/* 317 */             GuildFortUtil.sendRollTipsToAllAnsy(msgStr);
/* 318 */             GuildFortService.this.startBattleEndPreOneMinute();
/*     */           }
/* 320 */         },  this.battleEndTime - System.currentTimeMillis() - this.BATTLE_END_PRE_NOTICE_TIME5);
/*     */   }
/*     */   
/*     */   private void startBattleEndPreOneMinute() {
/* 324 */     JobFactory.addDelayJob(new Runnable()
/*     */         {
/*     */           public void run() {
/* 327 */             String msgStr = LangService.getValue("GUILDFORT_ENDBATTLE_ONEMINUTE_NOTICE");
/* 328 */             GuildFortUtil.sendRollTipsToAllAnsy(msgStr);
/*     */           }
/* 330 */         },  this.battleEndTime - System.currentTimeMillis() - this.BATTLE_END_PRE_NOTICE_TIME1);
/*     */   }
/*     */   
/*     */   private void cancelBidNotice() {
/* 334 */     if (this.bidBeginNoticeFuture != null) {
/* 335 */       this.bidBeginNoticeFuture.cancel(true);
/* 336 */       this.bidBeginNoticeFuture = null;
/*     */     } 
/*     */     
/* 339 */     if (this.bidPreEndNoticeFuture != null) {
/* 340 */       this.bidPreEndNoticeFuture.cancel(true);
/* 341 */       this.bidPreEndNoticeFuture = null;
/*     */     } 
/*     */   }
/*     */   
/*     */   private void cancelBattleNotice() {
/* 346 */     if (this.battlePreNoticeFuture != null) {
/* 347 */       this.battlePreNoticeFuture.cancel(true);
/* 348 */       this.battlePreNoticeFuture = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void startTimers() {
/* 359 */     long delay = getDelayTime(this.bidBeginTime);
/*     */     
/* 361 */     this.f1 = JobFactory.addScheduleJob(new Runnable()
/*     */         {
/*     */           
/*     */           public void run()
/*     */           {
/* 366 */             GuildFortCenter.getInstance().onBidTimeBegin();
/*     */           }
/*     */         },  delay, this.MILLISECONDS_PER_ROUND);
/*     */ 
/*     */     
/* 371 */     delay = getDelayTime(this.bidEndTime);
/* 372 */     this.f2 = JobFactory.addScheduleJob(new Runnable()
/*     */         {
/*     */           public void run()
/*     */           {
/* 376 */             GuildFortCenter.getInstance().onBidTimeEnd();
/*     */           }
/*     */         },  delay, this.MILLISECONDS_PER_ROUND);
/*     */ 
/*     */     
/* 381 */     delay = getDelayTime(this.battlePrepareTime);
/* 382 */     this.f3 = JobFactory.addScheduleJob(new Runnable()
/*     */         {
/*     */           public void run()
/*     */           {
/* 386 */             GuildFortCenter.getInstance().onPrepareBattle();
/*     */           }
/*     */         },  delay, this.MILLISECONDS_PER_ROUND);
/*     */     
/* 390 */     delay = getDelayTime(this.battleBeginTime);
/* 391 */     this.f4 = JobFactory.addScheduleJob(new Runnable()
/*     */         {
/*     */           public void run() {
/* 394 */             GuildFortCenter.getInstance().onBattleTimeBegin();
/*     */           }
/*     */         },  delay, this.MILLISECONDS_PER_ROUND);
/*     */ 
/*     */     
/* 399 */     delay = getDelayTime(this.battleEndTime);
/* 400 */     this.f5 = JobFactory.addScheduleJob(new Runnable()
/*     */         {
/*     */           public void run() {
/* 403 */             GuildFortCenter.getInstance().onBattleTimeEnd();
/* 404 */             GuildFortService.this.initTimes();
/* 405 */             System.out.println("+++++++++++++++++++++++++战斗结束");
/*     */           }
/*     */         },  delay, this.MILLISECONDS_PER_ROUND);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isIn(long begin, long end) {
/* 414 */     long now = System.currentTimeMillis();
/* 415 */     return (now > begin && now < end);
/*     */   }
/*     */   
/*     */   private static class GuildFortServiceHolder {
/* 419 */     public static final GuildFortService INSTANCE = new GuildFortService();
/*     */   }
/*     */   
/*     */   public static GuildFortService getInstance() {
/* 423 */     return GuildFortServiceHolder.INSTANCE;
/*     */   }
/*     */   
/*     */   public boolean isInBidTime() {
/* 427 */     return isIn(this.bidBeginTime, this.bidEndTime);
/*     */   }
/*     */   
/*     */   public boolean isInBidEndedTime() {
/* 431 */     return isIn(this.bidEndTime, this.battlePrepareTime);
/*     */   }
/*     */   
/*     */   public boolean isInEnterFortTime() {
/* 435 */     return isIn(this.battlePrepareTime, this.battleEndTime);
/*     */   }
/*     */   
/*     */   public boolean isInPrepareBattleTime() {
/* 439 */     return isIn(this.battlePrepareTime, this.battleBeginTime);
/*     */   }
/*     */   
/*     */   public boolean isInBattleTime() {
/* 443 */     return isIn(this.battleBeginTime, this.battleEndTime);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isInOpen() {
/* 450 */     return isIn(this.bidBeginTime, this.battleEndTime);
/*     */   }
/*     */   
/*     */   private long getBidEndRemainMills() {
/* 454 */     return this.bidEndTime - System.currentTimeMillis();
/*     */   }
/*     */   
/*     */   public int getBidEndRemainSecond() {
/* 458 */     if (isInBidTime()) {
/* 459 */       return (int)(getBidEndRemainMills() / 1000L);
/*     */     }
/* 461 */     return 0;
/*     */   }
/*     */   
/*     */   public int getBidBeginRemainSecond() {
/* 465 */     if (!isInOpen()) {
/* 466 */       return (int)(this.bidBeginTime - System.currentTimeMillis()) / 1000;
/*     */     }
/* 468 */     return 0;
/*     */   }
/*     */   
/*     */   public int getBattleBeginRemainSecond() {
/* 472 */     if (isInBidEndedTime()) {
/* 473 */       return (int)((this.battlePrepareTime - System.currentTimeMillis()) / 1000L);
/*     */     }
/* 475 */     return 0;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\guild\guildFort\GuildFortService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */