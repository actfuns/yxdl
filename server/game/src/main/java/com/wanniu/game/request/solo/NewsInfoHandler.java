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
/*    */ @GClientEvent("area.soloHandler.newsInfoRequest")
/*    */ public class NewsInfoHandler
/*    */   extends SoloRequestFilter
/*    */ {
/*    */   public PomeloResponse request(final WNPlayer player) throws Exception {
/* 22 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException
/*    */         {
/* 26 */           SoloHandler.NewsInfoResponse.Builder res = SoloHandler.NewsInfoResponse.newBuilder();
/* 27 */           player.soloManager.handleNewsInfo(res);
/* 28 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\solo\NewsInfoHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */