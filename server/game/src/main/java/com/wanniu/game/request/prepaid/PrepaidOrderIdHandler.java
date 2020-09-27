/*    */ package com.wanniu.game.request.prepaid;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.game.prepaid.PrepaidService;
/*    */ import pomelo.area.PrepaidHandler;
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
/*    */ @GClientEvent("area.prepaidHandler.prepaidOrderIdRequest")
/*    */ public class PrepaidOrderIdHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 24 */     PrepaidHandler.PrepaidOrderIdRequest req = PrepaidHandler.PrepaidOrderIdRequest.parseFrom(this.pak.getRemaingBytes());
/* 25 */     int productId = req.getC2SProductId();
/* 26 */     int channelId = req.getC2SChannelId();
/* 27 */     WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 28 */     int isCard = req.getC2SType();
/*    */     
/* 30 */     String imei = req.getC2SImei();
/* 31 */     int os = req.getC2SOs();
/*    */     
/* 33 */     return PrepaidService.getInstance().createOrderId(productId, channelId, player, (isCard == 1), imei, os);
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\prepaid\PrepaidOrderIdHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */