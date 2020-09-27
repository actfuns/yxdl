/*    */ package com.wanniu.game.guild.guildBoss;
/*    */ 
/*    */ import com.wanniu.game.poes.GuildPO;
/*    */ import java.util.Map;
/*    */ import java.util.concurrent.ConcurrentHashMap;
/*    */ 
/*    */ public class GuildBossCenter
/*    */ {
/*  9 */   private Map<String, String> hasEnterGuildIds = new ConcurrentHashMap<>();
/*    */   private boolean isOpen = false;
/*    */   private long beginTime;
/*    */   
/*    */   public boolean isOpen() {
/* 14 */     return this.isOpen;
/*    */   }
/*    */   
/*    */   public void onBegin() {
/* 18 */     this.isOpen = true;
/* 19 */     this.beginTime = System.currentTimeMillis();
/*    */   }
/*    */   
/*    */   public long getBeginTime() {
/* 23 */     return this.beginTime;
/*    */   }
/*    */   
/*    */   public void setBeginTime(long beginTime) {
/* 27 */     this.beginTime = beginTime;
/*    */   }
/*    */   
/*    */   public void onOver() {
/* 31 */     this.isOpen = false;
/*    */   }
/*    */   
/*    */   public void addOneGuildId(String guildId, String instanceId, GuildPO po) {
/* 35 */     synchronized (po) {
/* 36 */       this.hasEnterGuildIds.put(guildId, instanceId);
/*    */     } 
/*    */   }
/*    */   
/*    */   public void removeOneGuildId(String guildId, GuildPO po) {
/* 41 */     synchronized (po) {
/* 42 */       this.hasEnterGuildIds.remove(guildId);
/*    */     } 
/*    */   }
/*    */   
/*    */   public String getGuildBossScenceIdByGuildId(String guildId, GuildPO po) {
/* 47 */     synchronized (po) {
/* 48 */       return this.hasEnterGuildIds.get(guildId);
/*    */     } 
/*    */   }
/*    */   
/*    */   public String getGuildBossScenceIdByGuildIdNoLock(String guildId) {
/* 53 */     return this.hasEnterGuildIds.get(guildId);
/*    */   }
/*    */   
/*    */   public Map<String, String> getHasEnterGuildIds() {
/* 57 */     return this.hasEnterGuildIds;
/*    */   }
/*    */   
/*    */   public void clear() {
/* 61 */     this.hasEnterGuildIds.clear();
/*    */   }
/*    */ 
/*    */   
/*    */   private static class GuildBossCenterHolder
/*    */   {
/* 67 */     public static final GuildBossCenter INSTANCE = new GuildBossCenter();
/*    */   }
/*    */   
/*    */   public static GuildBossCenter getInstance() {
/* 71 */     return GuildBossCenterHolder.INSTANCE;
/*    */   }
/*    */   
/*    */   private GuildBossCenter() {}
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\guild\guildBoss\GuildBossCenter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */