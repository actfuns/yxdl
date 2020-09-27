/*     */ package com.wanniu.game.solo;
/*     */ 
/*     */ import com.wanniu.core.game.JobFactory;
/*     */ import com.wanniu.core.game.entity.GPlayer;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.util.DateUtil;
/*     */ import com.wanniu.game.GWorld;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.ConstsTR;
/*     */ import com.wanniu.game.data.GameData;
/*     */ import com.wanniu.game.data.SoloRankCO;
/*     */ import com.wanniu.game.data.ext.SoloRankSeasonRewardExt;
/*     */ import com.wanniu.game.leaderBoard.LeaderBoardDetail;
/*     */ import com.wanniu.game.mail.MailUtil;
/*     */ import com.wanniu.game.mail.data.MailData;
/*     */ import com.wanniu.game.mail.data.MailSysData;
/*     */ import com.wanniu.game.player.GlobalConfig;
/*     */ import com.wanniu.game.player.PlayerUtil;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.rank.RankType;
/*     */ import com.wanniu.game.solo.po.SoloSystemPO;
/*     */ import com.wanniu.redis.GameDao;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Calendar;
/*     */ import java.util.Collection;
/*     */ import java.util.Comparator;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SoloService
/*     */ {
/*     */   public static class OpenInfo
/*     */   {
/*     */     public String openTimeStr;
/*     */     public String closeTimeStr;
/*     */     public Date openTime;
/*     */     public Date closeTime;
/*     */   }
/*  47 */   private static final long MIN_SEASON_MILLISEC = TimeUnit.DAYS.toMillis(3L);
/*     */   private SoloRankCO[] soloRanks;
/*     */   private List<OpenInfo> soloOpenInfoList;
/*     */   private SoloSystemPO soloSystem;
/*     */   private static SoloService soloService;
/*     */   private static final int RANK_LIST_LIMIT = 500;
/*     */   private static final int MAX_REWARD_RANK = 10000;
/*     */   
/*     */   public static SoloService getInstance() {
/*  56 */     if (soloService == null) {
/*  57 */       soloService = new SoloService();
/*     */     }
/*  59 */     return soloService;
/*     */   }
/*     */   
/*     */   private SoloService() {
/*  63 */     init();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void init() {
/*  70 */     initSoloSystem();
/*  71 */     initSoloRanks();
/*  72 */     initOpenTimeList();
/*     */     
/*  74 */     long delay = DateUtil.getFiveDelay();
/*  75 */     JobFactory.addScheduleJob(new Runnable()
/*     */         {
/*     */           public void run() {
/*  78 */             Out.info(new Object[] { "soloService scheduleJob..." }, );
/*  79 */             SoloService.this.resetOpenTime();
/*     */           }
/*     */         },  delay, 86400000L);
/*     */     
/*  83 */     long seasonDelay = getSeasonEndTime() - System.currentTimeMillis();
/*  84 */     JobFactory.addScheduleJob(new Runnable()
/*     */         {
/*     */           public void run() {
/*  87 */             Out.info(new Object[] { "SoloService reset soloSeason ..." }, );
/*  88 */             SoloService.this.resetSeason();
/*     */           }
/*     */         },  seasonDelay, (GlobalConfig.Solo_SeasonDay * 24 * 3600 * 1000));
/*     */ 
/*     */     
/*  93 */     for (OpenInfo info : this.soloOpenInfoList) {
/*  94 */       JobFactory.addScheduleJob(new Runnable()
/*     */           {
/*     */             public void run()
/*     */             {
/*  98 */               for (GPlayer p : PlayerUtil.getAllOnlinePlayer()) {
/*  99 */                 WNPlayer wp = (WNPlayer)p;
/* 100 */                 wp.updateSuperScriptList(wp.soloManager.getSuperScript());
/*     */               } 
/*     */             }
/* 103 */           },  DateUtil.getTaskDelay(info.openTime), TimeUnit.DAYS.toMillis(1L));
/*     */       
/* 105 */       JobFactory.addScheduleJob(new Runnable()
/*     */           {
/*     */             public void run()
/*     */             {
/* 109 */               for (GPlayer p : PlayerUtil.getAllOnlinePlayer()) {
/* 110 */                 WNPlayer wp = (WNPlayer)p;
/* 111 */                 wp.updateSuperScriptList(wp.soloManager.getSuperScript());
/* 112 */                 wp.soloManager.quitMatching(false);
/*     */               } 
/* 114 */               SoloMatcher.getInstance().resetMatchingList();
/*     */             }
/* 116 */           },  DateUtil.getTaskDelay(info.closeTime), TimeUnit.DAYS.toMillis(1L));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void resetOpenTime() {
/* 124 */     for (OpenInfo info : this.soloOpenInfoList) {
/* 125 */       info.openTime = DateUtil.format(info.openTimeStr);
/* 126 */       info.closeTime = DateUtil.format(info.closeTimeStr);
/*     */     } 
/* 128 */     this.soloSystem.rounds++;
/*     */     
/* 130 */     updateSoloSystemToRedis();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void resetSeason() {
/* 137 */     if (System.currentTimeMillis() < this.soloSystem.seasonEndTime.getTime()) {
/* 138 */       Out.error(new Object[] { "SoloService resetSeason error......." });
/*     */       return;
/*     */     } 
/* 141 */     sendSeasonReward();
/* 142 */     this.soloSystem.seasonEndTime = calcSoloSeasonTime();
/* 143 */     this.soloSystem.term++;
/* 144 */     this.soloSystem.rounds = 1;
/*     */     
/* 146 */     updateSoloSystemToRedis();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getSeasonEndTime() {
/* 153 */     return this.soloSystem.seasonEndTime.getTime();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void initOpenTimeList() {
/* 160 */     this.soloOpenInfoList = new ArrayList<>();
/* 161 */     String[] rangeList = GlobalConfig.Solo_Daily_OpenTime.split(";");
/* 162 */     for (int i = 0; i < rangeList.length; i++) {
/*     */       
/* 164 */       String[] timeList = rangeList[i].split(",");
/* 165 */       if (timeList.length >= 2) {
/* 166 */         OpenInfo oi = new OpenInfo();
/* 167 */         oi.openTimeStr = timeList[0];
/* 168 */         oi.openTime = DateUtil.format(timeList[0]);
/* 169 */         oi.closeTimeStr = timeList[1];
/* 170 */         oi.closeTime = DateUtil.format(timeList[1]);
/* 171 */         this.soloOpenInfoList.add(oi);
/*     */       } else {
/* 173 */         Out.error(new Object[] { "Error in SoloManager.getOpenTimeList() ", Integer.valueOf(timeList.length) });
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isInOpenTime() {
/* 184 */     Calendar c = Calendar.getInstance();
/* 185 */     int weekDay = c.get(7) - 1;
/* 186 */     if (!GlobalConfig.Solo_Weekly_OpenTime.contains(String.valueOf(weekDay))) {
/* 187 */       return false;
/*     */     }
/* 189 */     Date nowTime = new Date();
/* 190 */     for (OpenInfo oi : this.soloOpenInfoList) {
/* 191 */       if (nowTime.after(oi.openTime) && nowTime.before(oi.closeTime)) {
/* 192 */         return true;
/*     */       }
/*     */     } 
/*     */     
/* 196 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<OpenInfo> getOpenInfoList() {
/* 205 */     return this.soloOpenInfoList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void initSoloRanks() {
/* 212 */     if (this.soloRanks == null || this.soloRanks.length < 1) {
/* 213 */       this.soloRanks = new SoloRankCO[GameData.SoloRanks.size()];
/* 214 */       int i = 0;
/* 215 */       for (SoloRankCO prop : GameData.SoloRanks.values()) {
/* 216 */         this.soloRanks[i] = prop;
/* 217 */         i++;
/*     */       } 
/*     */       
/* 220 */       Arrays.sort(this.soloRanks, new Comparator<SoloRankCO>()
/*     */           {
/*     */             public int compare(SoloRankCO o1, SoloRankCO o2) {
/* 223 */               return (o1.iD > o2.iD) ? 1 : -1;
/*     */             }
/*     */           });
/*     */       
/* 227 */       for (SoloRankCO prop : this.soloRanks) {
/* 228 */         Out.debug(new Object[] { "==============solorankid after sort:", Integer.valueOf(prop.iD) });
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void initSoloSystem() {
/* 234 */     SoloSystemPO syspo = (SoloSystemPO)GameDao.get(String.valueOf(GWorld.__SERVER_ID), ConstsTR.soloSystemTR, SoloSystemPO.class);
/* 235 */     if (syspo != null) {
/* 236 */       this.soloSystem = syspo;
/*     */     } else {
/* 238 */       this.soloSystem = new SoloSystemPO(String.valueOf(GWorld.__SERVER_ID));
/* 239 */       this.soloSystem.seasonEndTime = calcSoloSeasonTime();
/* 240 */       updateSoloSystemToRedis();
/*     */     } 
/*     */   }
/*     */   
/*     */   private Date calcSoloSeasonTime() {
/* 245 */     Date endDate = _calcSeasonEndTime(GlobalConfig.Solo_SeasonDay, GlobalConfig.Solo_SeasonWeekday);
/* 246 */     if (endDate.getTime() - System.currentTimeMillis() < MIN_SEASON_MILLISEC) {
/* 247 */       endDate = _calcSeasonEndTime(GlobalConfig.Solo_SeasonDay + 7, GlobalConfig.Solo_SeasonWeekday);
/*     */     }
/* 249 */     return endDate;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Date _calcSeasonEndTime(int term, int endWeekDay) {
/* 260 */     if (endWeekDay >= 7) {
/* 261 */       endWeekDay = 0;
/*     */     }
/* 263 */     Date endDate = DateUtil.getFiveTimeOfDay(DateUtil.getDateAfter(term));
/* 264 */     Calendar endC = Calendar.getInstance();
/* 265 */     endC.setTime(endDate);
/* 266 */     endC.set(7, endWeekDay + 1);
/*     */     
/* 268 */     return endC.getTime();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int calcRankId(int score) {
/* 278 */     int rankId = 0;
/* 279 */     for (SoloRankCO rank : this.soloRanks) {
/* 280 */       if (score >= rank.rankScore) {
/* 281 */         rankId = rank.iD;
/*     */       }
/*     */     } 
/* 284 */     return rankId;
/*     */   }
/*     */   
/*     */   public int getTerm() {
/* 288 */     return this.soloSystem.term;
/*     */   }
/*     */   
/*     */   public int getRounds() {
/* 292 */     return this.soloSystem.rounds;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addSoloNews(String news) {
/* 301 */     List<String> msgs = this.soloSystem.soloNewses;
/* 302 */     if (msgs.size() >= GlobalConfig.Solo_SoloNews_Number) {
/* 303 */       msgs.remove(0);
/*     */     }
/* 305 */     msgs.add(news);
/* 306 */     updateSoloSystemToRedis();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<String> getAllSoloNews() {
/* 315 */     return this.soloSystem.soloNewses;
/*     */   }
/*     */   
/*     */   private void updateSoloSystemToRedis() {
/* 319 */     GameDao.update(String.valueOf(GWorld.__SERVER_ID), ConstsTR.soloSystemTR, this.soloSystem);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void sendSeasonReward() {
/* 327 */     int start = 0;
/* 328 */     int end = start + 500;
/* 329 */     int season = getTerm();
/*     */     
/* 331 */     List<LeaderBoardDetail> rankList = RankType.SOLO_SCORE.getHandler().getRankDetail(GWorld.__SERVER_ID, season, start, end);
/* 332 */     while (rankList.size() > 0) {
/* 333 */       Out.debug(new Object[] { "rank list end limit :", Integer.valueOf(end) });
/* 334 */       for (LeaderBoardDetail board : rankList) {
/* 335 */         MailUtil.getInstance().sendMailToOnePlayer(board.memberId, (MailData)generateRewardMail(board.rank), Const.GOODS_CHANGE_TYPE.solo);
/*     */       }
/* 337 */       start += 500;
/* 338 */       end += 500;
/* 339 */       if (end > 10000) {
/*     */         break;
/*     */       }
/* 342 */       rankList = RankType.SOLO_SCORE.getHandler().getRankDetail(GWorld.__SERVER_ID, season, start, end);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private MailSysData generateRewardMail(long rank) {
/* 353 */     Collection<SoloRankSeasonRewardExt> props = GameData.SoloRankSeasonRewards.values();
/* 354 */     for (SoloRankSeasonRewardExt prop : props) {
/* 355 */       if (rank >= prop.startRank && rank <= prop.stopRank) {
/* 356 */         ArrayList<MailData.Attachment> list = new ArrayList<>();
/* 357 */         MailSysData mailData = new MailSysData("Solo_reward");
/* 358 */         mailData.replace = new HashMap<>();
/* 359 */         mailData.replace.put("rank", String.valueOf(rank));
/*     */         
/* 361 */         for (String itemCode : prop.rankRewards.keySet()) {
/* 362 */           MailData.Attachment attach = new MailData.Attachment();
/* 363 */           attach.itemCode = itemCode;
/* 364 */           attach.itemNum = ((Integer)prop.rankRewards.get(itemCode)).intValue();
/* 365 */           list.add(attach);
/*     */         } 
/* 367 */         mailData.attachments = list;
/* 368 */         return mailData;
/*     */       } 
/*     */     } 
/* 371 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void refreshSoloScoreToLeaderBoard(WNPlayer player, int score) {
/* 382 */     player.rankManager.onEvent(RankType.SOLO_SCORE, new Object[] { Integer.valueOf(getTerm()), Integer.valueOf(score) });
/*     */   }
/*     */   
/*     */   public long getRank(String playerId) {
/* 386 */     return RankType.SOLO_SCORE.getHandler().getSeasonRank(GWorld.__SERVER_ID, getTerm(), playerId);
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\solo\SoloService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */