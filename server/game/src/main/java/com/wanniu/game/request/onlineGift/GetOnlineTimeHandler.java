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
/*    */ @GClientEvent("area.onlineGiftHandler.getOnlineTimeRequest")
/*    */ public class GetOnlineTimeHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 22 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 23 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 26 */           OnlineGiftHandler.GetOnlineTimeResponse.Builder res = OnlineGiftHandler.GetOnlineTimeResponse.newBuilder();
/* 27 */           long onlineTime = player.onlineGiftManager.onlineData.sumTime;
/* 28 */           res.setS2CCode(200);
/* 29 */           OnlineGiftHandler.OnlineGift.Builder gift = OnlineGiftHandler.OnlineGift.newBuilder();
/* 30 */           gift.setOnlineTime((int)onlineTime);
/* 31 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\onlineGift\GetOnlineTimeHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */