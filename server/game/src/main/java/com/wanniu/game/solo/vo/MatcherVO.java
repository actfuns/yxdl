/*     */ package com.wanniu.game.solo.vo;
/*     */ 
/*     */ import com.wanniu.game.player.GlobalConfig;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ 
/*     */ public class MatcherVO {
/*     */   private WNPlayer player;
/*     */   private int score;
/*     */   private boolean isOnline;
/*     */   private long beginTime;
/*     */   private int scoreRange;
/*     */   private long offlineTime;
/*     */   private boolean markedDel;
/*     */   
/*     */   public boolean isMarkedDel() {
/*  16 */     return this.markedDel;
/*     */   }
/*     */   
/*     */   public void setMarkedDel(boolean markedDel) {
/*  20 */     this.markedDel = markedDel;
/*     */   }
/*     */   
/*     */   public long getBeginTime() {
/*  24 */     return this.beginTime;
/*     */   }
/*     */   
/*     */   public void setBeginTime(long beginTimeMills) {
/*  28 */     this.beginTime = beginTimeMills;
/*     */   }
/*     */   
/*     */   public MatcherVO(int score, WNPlayer player) {
/*  32 */     this.player = player;
/*  33 */     this.score = score;
/*  34 */     this.isOnline = true;
/*  35 */     this.beginTime = System.currentTimeMillis();
/*  36 */     this.scoreRange = GlobalConfig.Solo_MatchRangeIncrease;
/*  37 */     this.offlineTime = 0L;
/*     */   }
/*     */   
/*     */   public WNPlayer getPlayer() {
/*  41 */     return this.player;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void increaseScoreRange() {
/*  48 */     this.scoreRange += GlobalConfig.Solo_MatchRangeIncrease;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMinScore() {
/*  55 */     return (this.score - this.scoreRange < 0) ? 0 : (this.score - this.scoreRange);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMaxScore() {
/*  62 */     return this.score + this.scoreRange;
/*     */   }
/*     */   
/*     */   public int getScoreRange() {
/*  66 */     return this.scoreRange;
/*     */   }
/*     */   
/*     */   public String getPlayerId() {
/*  70 */     return this.player.getId();
/*     */   }
/*     */   
/*     */   public int getScore() {
/*  74 */     return this.score;
/*     */   }
/*     */   
/*     */   public void setScore(int score) {
/*  78 */     this.score = score;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isOnline() {
/*  85 */     return this.isOnline;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOnline() {
/*  92 */     this.isOnline = true;
/*  93 */     this.offlineTime = 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOffline() {
/* 100 */     this.isOnline = false;
/* 101 */     this.offlineTime = System.currentTimeMillis();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getOfflinedTime() {
/* 108 */     if (this.offlineTime == 0L) {
/* 109 */       return 0;
/*     */     }
/* 111 */     return (int)(System.currentTimeMillis() - this.offlineTime) / 1000;
/*     */   }
/*     */   
/*     */   public int getWaitTime() {
/* 115 */     return (int)(System.currentTimeMillis() - this.beginTime) / 1000;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\solo\vo\MatcherVO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */