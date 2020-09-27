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
/*    */ @GClientEvent("area.playerHandler.clientReadyRequest")
/*    */ public class ClientReadyHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 23 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*    */ 
/*    */ 
/*    */     
/* 27 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 30 */           PlayerHandler.ClientReadyResponse.Builder res = PlayerHandler.ClientReadyResponse.newBuilder();
/* 31 */           player.onReady();
/* 32 */           if (player.area != null) {
/* 33 */             player.area.onReady(player);
/*    */           }
/* 35 */           res.setS2CCode(200);
/* 36 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\player\ClientReadyHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */