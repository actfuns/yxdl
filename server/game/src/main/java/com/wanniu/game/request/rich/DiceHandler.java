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
/*    */ @GClientEvent("rich.richHandler.diceRequest")
/*    */ public class DiceHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 25 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*    */ 
/*    */     
/* 28 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 31 */           RichHandler.DiceResponse.Builder res = player.richManager.dice(player.getId());
/*    */           
/* 33 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\rich\DiceHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */