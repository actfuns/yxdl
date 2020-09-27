/*    */ package com.wanniu.game.request.player;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.PlayerHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.playerHandler.setCustomConfigRequest")
/*    */ public class SetCustomConfigHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 23 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*    */     
/* 25 */     PlayerHandler.CustomConfigRequest req = PlayerHandler.CustomConfigRequest.parseFrom(this.pak.getRemaingBytes());
/* 26 */     final String key = req.getC2SKey();
/* 27 */     final String value = req.getC2SValue();
/*    */     
/* 29 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 32 */           PlayerHandler.CustomConfigResponse.Builder res = PlayerHandler.CustomConfigResponse.newBuilder();
/*    */           
/* 34 */           if (player.setClientCustomConfig(key, value, false)) {
/* 35 */             res.setS2CCode(200);
/*    */           } else {
/* 37 */             res.setS2CCode(500);
/*    */           } 
/* 39 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\player\SetCustomConfigHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */