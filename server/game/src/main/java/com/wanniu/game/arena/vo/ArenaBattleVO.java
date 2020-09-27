/*    */ package com.wanniu.game.arena.vo;
/*    */ 
/*    */ import pomelo.area.ArenaHandler;
/*    */ 
/*    */ public class ArenaBattleVO {
/*    */   private String name;
/*    */   private int score;
/*    */   private int pro;
/*    */   private String id;
/*    */   private int killCount;
/* 11 */   private long updateTime = System.currentTimeMillis();
/*    */   private int force;
/*    */   
/*    */   public String getName() {
/* 15 */     return this.name;
/*    */   }
/*    */   
/*    */   public void setName(String name) {
/* 19 */     this.name = name;
/*    */   }
/*    */   
/*    */   public int getScore() {
/* 23 */     return this.score;
/*    */   }
/*    */   
/*    */   public void setScore(int score) {
/* 27 */     this.score = score;
/*    */   }
/*    */   
/*    */   public int getPro() {
/* 31 */     return this.pro;
/*    */   }
/*    */   
/*    */   public void setPro(int pro) {
/* 35 */     this.pro = pro;
/*    */   }
/*    */   
/*    */   public String getId() {
/* 39 */     return this.id;
/*    */   }
/*    */   
/*    */   public void setId(String id) {
/* 43 */     this.id = id;
/*    */   }
/*    */   
/*    */   public int getKillCount() {
/* 47 */     return this.killCount;
/*    */   }
/*    */   
/*    */   public void setKillCount(int killCount) {
/* 51 */     this.killCount = killCount;
/*    */   }
/*    */   
/*    */   public long getUpdateTime() {
/* 55 */     return this.updateTime;
/*    */   }
/*    */   
/*    */   public void setUpdateTime(long updateTime) {
/* 59 */     this.updateTime = updateTime;
/*    */   }
/*    */   
/*    */   public int getForce() {
/* 63 */     return this.force;
/*    */   }
/*    */   
/*    */   public void setForce(int force) {
/* 67 */     this.force = force;
/*    */   }
/*    */   
/*    */   public ArenaHandler.ArenaBattleScore toBuilder(boolean isScore) {
/* 71 */     ArenaHandler.ArenaBattleScore.Builder builder = ArenaHandler.ArenaBattleScore.newBuilder();
/* 72 */     builder.setId(this.id);
/* 73 */     builder.setName(this.name);
/* 74 */     builder.setPro(this.pro);
/* 75 */     if (isScore) {
/* 76 */       builder.setScore(this.score);
/*    */     } else {
/* 78 */       builder.setScore(this.killCount);
/*    */     } 
/*    */     
/* 81 */     return builder.build();
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\arena\vo\ArenaBattleVO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */