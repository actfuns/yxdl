/*    */ package com.wanniu.game.guild.guildBoss;
/*    */ 
/*    */ import java.util.Collection;
/*    */ import java.util.HashMap;
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RankBean
/*    */ {
/*    */   private String id;
/*    */   private long hurt;
/* 28 */   private transient Map<Integer, Long> newHurtMap = new HashMap<>();
/*    */   private transient int rank;
/*    */   private transient int guildRank;
/*    */   
/*    */   public int getGuildRank() {
/* 33 */     return this.guildRank;
/*    */   }
/*    */   
/*    */   public void setGuildRank(int guildRank) {
/* 37 */     this.guildRank = guildRank;
/*    */   }
/*    */   
/*    */   public int getRank() {
/* 41 */     return this.rank;
/*    */   }
/*    */   
/*    */   public void setRank(int rank) {
/* 45 */     this.rank = rank;
/*    */   }
/*    */   
/*    */   public void setNewData(int enterCount, long hurt) {
/* 49 */     this.newHurtMap.put(Integer.valueOf(enterCount), Long.valueOf(hurt));
/*    */   }
/*    */   
/*    */   public void reset() {
/* 53 */     long tp = 0L;
/* 54 */     Collection<Long> cols = this.newHurtMap.values();
/* 55 */     for (Iterator<Long> iterator = cols.iterator(); iterator.hasNext(); ) { long hp = ((Long)iterator.next()).longValue();
/* 56 */       tp += hp; }
/*    */     
/* 58 */     this.hurt = tp;
/*    */   }
/*    */   
/*    */   public String getId() {
/* 62 */     return this.id;
/*    */   }
/*    */   
/*    */   public void setId(String id) {
/* 66 */     this.id = id;
/*    */   }
/*    */   
/*    */   public long getHurt() {
/* 70 */     return this.hurt;
/*    */   }
/*    */   
/*    */   public void setHurt(long hurt) {
/* 74 */     this.hurt = hurt;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\guild\guildBoss\RankBean.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */