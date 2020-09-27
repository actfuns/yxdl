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
/*    */ 
/*    */ @GClientEvent("area.guildFortHandler.applyAccessRequest")
/*    */ public class ApplyAccessHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 23 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 24 */     GuildFortHandler.ApplyAccessRequest req = GuildFortHandler.ApplyAccessRequest.parseFrom(this.pak.getRemaingBytes());
/* 25 */     final int fortId = req.getAreaId();
/*    */     
/* 27 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 30 */           GuildFortHandler.ApplyAccessResponse.Builder res = GuildFortHandler.ApplyAccessResponse.newBuilder();
/* 31 */           String msg = player.guildFortManager.handleEnterPrepareArea(fortId);
/* 32 */           if (msg != null) {
/* 33 */             res.setS2CCode(500);
/* 34 */             res.setS2CMsg(msg);
/*    */           } else {
/* 36 */             res.setS2CCode(200);
/*    */           } 
/* 38 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\guild\guildFort\ApplyAccessHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */