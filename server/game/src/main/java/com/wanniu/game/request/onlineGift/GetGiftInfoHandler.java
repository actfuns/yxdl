/*    */ package com.wanniu.game.request.onlineGift;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.OnlineGiftHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.onlineGiftHandler.getGiftInfoRequest")
/*    */ public class GetGiftInfoHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 23 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*    */ 
/*    */     
/* 26 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 29 */           OnlineGiftHandler.GetGiftInfoResponse.Builder res = OnlineGiftHandler.GetGiftInfoResponse.newBuilder();
/* 30 */           res.setS2CCode(200);
/* 31 */           OnlineGiftHandler.OnlineGift gift = player.onlineGiftManager.toJson4Payload();
/* 32 */           res.setS2CGift(gift);
/* 33 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\onlineGift\GetGiftInfoHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */