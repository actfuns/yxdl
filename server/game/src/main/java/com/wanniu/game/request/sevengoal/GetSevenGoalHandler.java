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
/*    */ @GClientEvent("sevengoal.sevenGoalHandler.getSevenGoalRequest")
/*    */ public class GetSevenGoalHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 24 */     WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 25 */     final SevenGoalHandler.GetSevenGoalResponse.Builder res = player.sevenGoalManager.getSevenGoal();
/*    */ 
/*    */     
/* 28 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 31 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\sevengoal\GetSevenGoalHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */