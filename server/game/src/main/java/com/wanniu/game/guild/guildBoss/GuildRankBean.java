/*    */ package com.wanniu.game.guild.guildBoss;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collections;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
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
/*    */ 
/*    */ public class GuildRankBean
/*    */ {
/*    */   private String guildId;
/*    */   private long bossKillTime;
/* 30 */   private Map<String, RankBean> hurtMap = new HashMap<>();
/* 31 */   private List<RankBean> hurtList = new ArrayList<>();
/*    */   private boolean hasKilled = false;
/*    */   
/*    */   public boolean hasKilled() {
/* 35 */     return this.hasKilled;
/*    */   }
/*    */   
/*    */   public void setHasKilled(boolean hasKilled) {
/* 39 */     this.hasKilled = hasKilled;
/*    */   }
/*    */   
/*    */   public long getTotalHurt() {
/* 43 */     long total = 0L;
/* 44 */     if (this.hurtList != null && !this.hurtList.isEmpty()) {
/* 45 */       for (RankBean bean : this.hurtList) {
/* 46 */         total += bean.getHurt();
/*    */       }
/*    */     }
/* 49 */     return total;
/*    */   }
/*    */   
/*    */   public long getBossKillTime() {
/* 53 */     return this.bossKillTime;
/*    */   }
/*    */   
/*    */   public void setBossKillTime(long bossKillTime) {
/* 57 */     this.bossKillTime = bossKillTime;
/*    */   }
/*    */   
/*    */   public GuildRankBean(String guildId) {
/* 61 */     this.guildId = guildId;
/* 62 */     this.bossKillTime = -1L;
/*    */   }
/*    */   
/*    */   public String getGuildId() {
/* 66 */     return this.guildId;
/*    */   }
/*    */   
/*    */   public void setRankBeanIfNull(RankBean bean) {
/* 70 */     RankBean tmBean = this.hurtMap.get(bean.getId());
/* 71 */     if (tmBean == null) {
/* 72 */       this.hurtMap.put(bean.getId(), bean);
/* 73 */       synchronized (this.hurtList) {
/* 74 */         this.hurtList.add(bean);
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   public List<RankBean> getHurtListWithLock() {
/* 80 */     synchronized (this.hurtList) {
/* 81 */       return new ArrayList<>(this.hurtList);
/*    */     } 
/*    */   }
/*    */   
/*    */   public RankBean onlyGetRankBean(String playerId) {
/* 86 */     return this.hurtMap.get(playerId);
/*    */   }
/*    */   
/*    */   public List<RankBean> getHurtList() {
/* 90 */     return this.hurtList;
/*    */   }
/*    */   
/*    */   public void sort() {
/* 94 */     Collections.sort(this.hurtList, GuildBossAreaHurtRankCenter.SORT_HURT);
/* 95 */     for (int i = 0; i < this.hurtList.size(); i++) {
/* 96 */       RankBean bean = this.hurtList.get(i);
/* 97 */       bean.setGuildRank(i + 1);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\guild\guildBoss\GuildRankBean.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */