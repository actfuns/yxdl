/*    */ package com.wanniu.game.request.guild.guildFort;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.GuildFortHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.guildFortHandler.getGuildAreaListRequest")
/*    */ public class GetGuildAreaListHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 22 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 23 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 26 */           GuildFortHandler.GetGuildAreaListResponse.Builder res = GuildFortHandler.GetGuildAreaListResponse.newBuilder();
/* 27 */           String msg = player.guildFortManager.handleGetGuildAreaList(res);
/* 28 */           if (msg != null) {
/* 29 */             res.setS2CCode(500);
/* 30 */             res.setS2CMsg(msg);
/*    */           } else {
/* 32 */             res.setS2CCode(200);
/*    */           } 
/* 34 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\guild\guildFort\GetGuildAreaListHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */