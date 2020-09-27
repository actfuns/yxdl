/*    */ package com.wanniu.game.request.sevengoal;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.sevengoal.SevenGoalHandler;
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
/*    */ @GClientEvent("sevengoal.sevenGoalHandler.fetchAwardRequest")
/*    */ public class FetchAwardHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 25 */     WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 26 */     SevenGoalHandler.FetchAwardRequest request = SevenGoalHandler.FetchAwardRequest.parseFrom(this.pak.getRemaingBytes());
/* 27 */     int dayId = request.getId();
/* 28 */     final SevenGoalHandler.FetchAwardResponse.Builder res = player.sevenGoalManager.fetchAward(dayId);
/*    */ 
/*    */     
/* 31 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 34 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\sevengoal\FetchAwardHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */