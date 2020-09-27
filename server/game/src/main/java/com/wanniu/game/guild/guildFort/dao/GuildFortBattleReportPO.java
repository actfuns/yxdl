/*    */ package com.wanniu.game.guild.guildFort.dao;
/*    */ 
/*    */ import com.alibaba.fastjson.annotation.JSONField;
/*    */ 
/*    */ public class GuildFortBattleReportPO {
/*  6 */   public int fortId = 0;
/*  7 */   public String fortName = "";
/*  8 */   public GuildFortContenderPO defenser = null;
/*  9 */   public GuildFortContenderPO attacker = null;
/*    */   
/*    */   @JSONField(deserialize = false, serialize = false)
/*    */   public GuildFortContenderPO getContender(String guildId) {
/* 13 */     if (this.defenser != null && this.defenser.guildId.equals(guildId))
/* 14 */       return this.defenser; 
/* 15 */     if (this.attacker != null && this.attacker.guildId.equals(guildId)) {
/* 16 */       return this.attacker;
/*    */     }
/*    */     
/* 19 */     return null;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\guild\guildFort\dao\GuildFortBattleReportPO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */