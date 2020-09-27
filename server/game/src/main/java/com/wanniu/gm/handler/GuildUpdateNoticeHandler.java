/*    */ package com.wanniu.gm.handler;
/*    */ 
/*    */ import com.alibaba.fastjson.JSONArray;
/*    */ import com.wanniu.game.guild.GuildServiceCenter;
/*    */ import com.wanniu.game.guild.GuildUtil;
/*    */ import com.wanniu.game.poes.GuildPO;
/*    */ import com.wanniu.gm.GMEvent;
/*    */ import com.wanniu.gm.GMResponse;
/*    */ import com.wanniu.gm.GMStateResponse;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GMEvent
/*    */ public class GuildUpdateNoticeHandler
/*    */   extends GMBaseHandler
/*    */ {
/*    */   public GMResponse execute(JSONArray arr) {
/* 22 */     String guildId = arr.getString(0);
/* 23 */     String notice = arr.getString(1);
/* 24 */     if (notice != null && notice.length() > 100) {
/* 25 */       notice = notice.substring(0, 100);
/*    */     }
/* 27 */     GuildPO guild = GuildUtil.getGuild(guildId);
/* 28 */     guild.notice = notice;
/*    */     
/* 30 */     GuildServiceCenter.getInstance().saveGuild(guild);
/* 31 */     return (GMResponse)new GMStateResponse(1);
/*    */   }
/*    */   
/*    */   public short getType() {
/* 35 */     return 12338;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\gm\handler\GuildUpdateNoticeHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */