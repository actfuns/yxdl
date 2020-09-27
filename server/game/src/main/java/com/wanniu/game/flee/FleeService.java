/*     */ package com.wanniu.game.flee;
/*     */ 
/*     */ import com.wanniu.core.game.JobFactory;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.util.DateUtil;
/*     */ import com.wanniu.game.GWorld;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.ConstsTR;
/*     */ import com.wanniu.game.data.GameData;
/*     */ import com.wanniu.game.data.ext.BattleRoyaleRankExt;
/*     */ import com.wanniu.game.data.ext.BattleRoyaleRankSeasonRewardExt;
/*     */ import com.wanniu.game.leaderBoard.LeaderBoardDetail;
/*     */ import com.wanniu.game.mail.MailUtil;
/*     */ import com.wanniu.game.mail.data.MailData;
/*     */ import com.wanniu.game.mail.data.MailSysData;
/*     */ import com.wanniu.game.player.GlobalConfig;
/*     */ import com.wanniu.game.poes.FleeSystemPO;
/*     */ import com.wanniu.game.rank.RankType;
/*     */ import com.wanniu.redis.GameDao;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.TimeUnit;
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
/*     */ 
/*     */ 
/*     */ public class FleeService
/*     */ {
/*     */   private FleeSystemPO fleeSystemPO;
/*     */   private static FleeService instance;
/*     */   public long sumMatchingTime;
/*     */   public int matchedNumber;
/*  48 */   private List<String> matchPlayer = new ArrayList<>();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  53 */   private static final long MIN_SEASON_MILLISEC = TimeUnit.DAYS.toMillis(3L);
/*     */   
/*     */   public static FleeService getInstance() {
/*  56 */     if (instance == null) {
/*  57 */       instance = new FleeService();
/*     */     }
/*  59 */     return instance;
/*     */   }
/*     */   
/*     */   private FleeService() {
/*  63 */     initFleeSystem();
/*     */     
/*  65 */     long initialDelay = this.fleeSystemPO.seasonEndTime.getTime() - System.currentTimeMillis();
/*  66 */     JobFactory.addFixedRateJob(new Runnable()
/*     */         {
/*     */           public void run()
/*     */           {
/*     */             try {
/*  71 */               List<LeaderBoardDetail> datas = RankType.FLEE.getHandler().getRankDetail(GWorld.__SERVER_ID, 0, -1);
/*  72 */               int rank = 0;
/*  73 */               for (LeaderBoardDetail detail : datas) {
/*  74 */                 rank++;
/*  75 */                 Map<Integer, BattleRoyaleRankSeasonRewardExt> personalRanks = GameData.BattleRoyaleRankSeasonRewards;
/*  76 */                 BattleRoyaleRankSeasonRewardExt ext = null;
/*  77 */                 for (BattleRoyaleRankSeasonRewardExt temp : personalRanks.values()) {
/*  78 */                   if (rank >= temp.startRank && rank <= temp.stopRank) {
/*  79 */                     ext = temp;
/*     */                     break;
/*     */                   } 
/*     */                 } 
/*  83 */                 if (ext == null) {
/*     */                   continue;
/*     */                 }
/*  86 */                 Map<String, Integer> rankRewards = ext.rankRewards;
/*  87 */                 MailSysData mailData = new MailSysData("Flee_reward_last");
/*  88 */                 Map<String, String> replace = new HashMap<>();
/*  89 */                 replace.put("rank", String.valueOf(rank));
/*  90 */                 mailData.replace = replace;
/*  91 */                 mailData.attachments = new ArrayList();
/*     */                 
/*  93 */                 for (Map.Entry<String, Integer> attach : rankRewards.entrySet()) {
/*  94 */                   MailData.Attachment item = new MailData.Attachment();
/*  95 */                   item.itemCode = attach.getKey();
/*  96 */                   item.itemNum = ((Integer)attach.getValue()).intValue();
/*  97 */                   mailData.attachments.add(item);
/*     */                 } 
/*  99 */                 MailUtil.getInstance().sendMailToOnePlayer(detail.memberId, (MailData)mailData, Const.GOODS_CHANGE_TYPE.flee);
/*     */               } 
/* 101 */               RankType.FLEE.getHandler().delRank(GWorld.__SERVER_ID);
/* 102 */               FleeService.this.fleeSystemPO.seasonEndTime = FleeService.this.calcSoloSeasonTime();
/* 103 */               GameDao.update(String.valueOf(GWorld.__SERVER_ID), ConstsTR.fleeSystemTR, FleeService.this.fleeSystemPO);
/* 104 */             } catch (Exception e) {
/* 105 */               Out.error(new Object[] { e });
/*     */             } 
/*     */           }
/* 108 */         }initialDelay, TimeUnit.DAYS.toMillis(7L));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void initFleeSystem() {
/* 116 */     FleeSystemPO syspo = (FleeSystemPO)GameDao.get(String.valueOf(GWorld.__SERVER_ID), ConstsTR.fleeSystemTR, FleeSystemPO.class);
/* 117 */     if (syspo != null) {
/* 118 */       this.fleeSystemPO = syspo;
/*     */     } else {
/* 120 */       this.fleeSystemPO = new FleeSystemPO(String.valueOf(GWorld.__SERVER_ID));
/* 121 */       this.fleeSystemPO.seasonEndTime = calcSoloSeasonTime();
/* 122 */       GameDao.update(String.valueOf(GWorld.__SERVER_ID), ConstsTR.fleeSystemTR, this.fleeSystemPO);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Date calcSoloSeasonTime() {
/* 132 */     Date endDate = calcSeasonEndTime(GlobalConfig.Flee_SeasonDay, GlobalConfig.Flee_SeasonWeekday);
/* 133 */     if (endDate.getTime() - System.currentTimeMillis() < MIN_SEASON_MILLISEC) {
/* 134 */       endDate = calcSeasonEndTime(GlobalConfig.Flee_SeasonDay + 7, GlobalConfig.Flee_SeasonWeekday);
/*     */     }
/* 136 */     return endDate;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Date calcSeasonEndTime(int term, int endWeekDay) {
/* 147 */     if (endWeekDay >= 7) {
/* 148 */       endWeekDay = 0;
/*     */     }
/* 150 */     Date endDate = DateUtil.getFiveTimeOfDay(DateUtil.getDateAfter(term));
/* 151 */     Calendar endC = Calendar.getInstance();
/* 152 */     endC.setTime(endDate);
/* 153 */     endC.set(7, endWeekDay + 1);
/*     */     
/* 155 */     return endC.getTime();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getSeasonEndDate() {
/* 164 */     return this.fleeSystemPO.seasonEndTime;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getPlayerRank(String playerId) {
/* 174 */     return (int)RankType.FLEE.getHandler().getRank(GWorld.__SERVER_ID, playerId);
/*     */   }
/*     */   
/*     */   public List<String> getMatchPlayer() {
/* 178 */     return this.matchPlayer;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getGradeIdByScore(int score) {
/* 188 */     int max = 1;
/* 189 */     for (BattleRoyaleRankExt b : GameData.BattleRoyaleRanks.values()) {
/* 190 */       if (b.iD > max && score >= b.rankScore) {
/* 191 */         max = b.iD;
/*     */       }
/*     */     } 
/* 194 */     return max;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isInOpenTime() {
/* 203 */     Calendar c = Calendar.getInstance();
/* 204 */     int weekDay = c.get(7) - 1;
/* 205 */     if (!GlobalConfig.Flee_Weekly_OpenTime.contains(String.valueOf(weekDay))) {
/* 206 */       return false;
/*     */     }
/* 208 */     String[] openTime = GlobalConfig.Flee_Daily_OpenTime.split(",");
/* 209 */     Date nowTime = new Date();
/* 210 */     if (nowTime.after(DateUtil.format(openTime[0])) && nowTime.before(DateUtil.format(openTime[1]))) {
/* 211 */       return true;
/*     */     }
/*     */     
/* 214 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getAvgMatchingTime() {
/* 223 */     if (this.matchedNumber <= 0) {
/* 224 */       return GlobalConfig.Flee_MATCH_TIME;
/*     */     }
/* 226 */     int second = (int)(this.sumMatchingTime / this.matchedNumber) / 1000;
/* 227 */     if (second > GlobalConfig.Flee_MATCH_TIME) {
/* 228 */       second = GlobalConfig.Flee_MATCH_TIME;
/*     */     }
/* 230 */     return second;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateMatchingTime(long matchedTime) {
/* 239 */     this.matchedNumber++;
/* 240 */     this.sumMatchingTime += matchedTime;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\flee\FleeService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */