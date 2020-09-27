/*    */ package com.wanniu.game.request.rich;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.rich.RichHandler;
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
/*    */ @GClientEvent("rich.richHandler.fetchTurnAwardRequest")
/*    */ public class FetchTurnAwardHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 25 */     WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 26 */     RichHandler.FetchTurnAwardRequest req = RichHandler.FetchTurnAwardRequest.parseFrom(this.pak.getRemaingBytes());
/* 27 */     int turnId = req.getId();
/*    */     
/* 29 */     final RichHandler.FetchTurnAwardResponse.Builder res = player.richManager.fetchTurnAward(player.getId(), turnId);
/*    */ 
/*    */     
/* 32 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 35 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\rich\FetchTurnAwardHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */