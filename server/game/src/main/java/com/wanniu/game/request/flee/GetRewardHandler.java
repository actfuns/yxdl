/*    */ package com.wanniu.game.request.flee;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.FleeHandler;
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
/*    */ @GClientEvent("area.fleeHandler.getRewardRequest")
/*    */ public class GetRewardHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 24 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 25 */     final FleeHandler.GetRewardRequest req = FleeHandler.GetRewardRequest.parseFrom(this.pak.getRemaingBytes());
/* 26 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 29 */           FleeHandler.GetRewardResponse res = player.fleeManager.getRewardResponse(req.getGradeId());
/* 30 */           this.body.writeBytes(res.toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\flee\GetRewardHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */