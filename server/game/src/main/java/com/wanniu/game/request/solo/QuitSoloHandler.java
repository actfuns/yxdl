/*    */ package com.wanniu.game.request.solo;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.SoloHandler;
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
/*    */ @GClientEvent("area.soloHandler.quitSoloRequest")
/*    */ public class QuitSoloHandler
/*    */   extends SoloRequestFilter
/*    */ {
/*    */   public PomeloResponse request(final WNPlayer player) throws Exception {
/* 23 */     return new PomeloResponse()
/*    */       {
/*    */         
/*    */         protected void write() throws IOException
/*    */         {
/* 28 */           SoloHandler.QuitSoloResponse.Builder res = SoloHandler.QuitSoloResponse.newBuilder();
/* 29 */           player.soloManager.handleQuitSolo();
/*    */           
/* 31 */           res.setS2CCode(200);
/* 32 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\solo\QuitSoloHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */