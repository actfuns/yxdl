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
/*    */ @GClientEvent("area.fleeHandler.cancelMatchRequest")
/*    */ public class CancelMatchHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 23 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 24 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 27 */           FleeHandler.CancelMatchResponse res = player.fleeManager.cancelMatchFlee();
/* 28 */           this.body.writeBytes(res.toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\flee\CancelMatchHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */