/*    */ package com.wanniu.game.guild.guildBoss;
/*    */ 
/*    */ import com.alibaba.fastjson.JSONObject;
/*    */ import com.wanniu.core.db.GCache;
/*    */ import com.wanniu.game.common.ConstsTR;
/*    */ import java.util.List;
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
/*    */ 
/*    */ 
/*    */ public class GuildBossAreaHurtRankService
/*    */ {
/*    */   public void saveAfterOver(String guildId, List<RankBean> list) {
/* 30 */     GCache.hset(ConstsTR.guildBossHurtTR.value, guildId, JSONObject.toJSONString(list));
/*    */   }
/*    */   
/*    */   private GuildBossAreaHurtRankService() {}
/*    */   
/*    */   private static class GuildBossAreaHurtRankServiceHolder {
/* 36 */     public static final GuildBossAreaHurtRankService INSTANCE = new GuildBossAreaHurtRankService();
/*    */   }
/*    */   
/*    */   public static GuildBossAreaHurtRankService getInstance() {
/* 40 */     return GuildBossAreaHurtRankServiceHolder.INSTANCE;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\guild\guildBoss\GuildBossAreaHurtRankService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */