/*    */ package com.wanniu.game.request.interact;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.InteractHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.interactHandler.interactTimesRequest")
/*    */ public class InteractTimesHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 17 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 18 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 21 */           InteractHandler.InteractTimesResponse.Builder data = player.getInteractManager().interactTimes(player);
/* 22 */           data.setS2CCode(200);
/* 23 */           this.body.writeBytes(data.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\interact\InteractTimesHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */