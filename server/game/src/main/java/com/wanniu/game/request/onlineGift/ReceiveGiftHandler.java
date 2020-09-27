/*    */ package com.wanniu.game.request.onlineGift;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.core.logfs.Out;
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
/*    */ 
/*    */ @GClientEvent("area.onlineGiftHandler.receiveGiftRequest")
/*    */ public class ReceiveGiftHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 26 */     final OnlineGiftHandler.ReceiveGiftRequest req = OnlineGiftHandler.ReceiveGiftRequest.parseFrom(this.pak.getRemaingBytes());
/*    */     
/* 28 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 29 */     return new PomeloResponse() {
/*    */         protected void write() throws IOException {
/*    */           String msg;
/* 32 */           OnlineGiftHandler.ReceiveGiftResponse.Builder res = OnlineGiftHandler.ReceiveGiftResponse.newBuilder();
/*    */           
/* 34 */           if (req.getC2SId() == 0) {
/* 35 */             res.setS2CCode(500);
/* 36 */             res.setS2CMsg(LangService.getValue("PARAM_ERROR"));
/* 37 */             this.body.writeBytes(res.build().toByteArray());
/*    */             return;
/*    */           } 
/* 40 */           int resultCode = player.onlineGiftManager.receiveGift(req.getC2SId());
/* 41 */           if (resultCode == 0) {
/* 42 */             OnlineGiftHandler.OnlineGift giftData = player.onlineGiftManager.toJson4Payload();
/* 43 */             res.setS2CGift(giftData);
/* 44 */             res.setS2CCode(200);
/* 45 */             this.body.writeBytes(res.build().toByteArray());
/* 46 */             Out.info(new Object[] { this.val$player.getId(), ":领取在线礼包，礼包id:", Integer.valueOf(this.val$req.getC2SId()) });
/*    */             
/*    */             return;
/*    */           } 
/* 50 */           if (resultCode == -1) {
/* 51 */             msg = LangService.getValue("ONLINE_HAVE_RECEIVED");
/* 52 */           } else if (resultCode == -2) {
/* 53 */             msg = LangService.getValue("ONLINE_UPLEVEL_NOT_MATCH");
/* 54 */           } else if (resultCode == -3) {
/* 55 */             msg = LangService.getValue("ONLINE_LEVEL_NOT_MATCH");
/* 56 */           } else if (resultCode == -4) {
/* 57 */             msg = LangService.getValue("ONLINE_TIME_NOT_ENOUGH");
/* 58 */           } else if (resultCode == -5) {
/* 59 */             msg = LangService.getValue("BAG_NOT_ENOUGH_POS");
/* 60 */           } else if (resultCode == -6) {
/* 61 */             msg = LangService.getValue("PARAM_ERROR");
/*    */           } else {
/* 63 */             msg = LangService.getValue("SOMETHING_ERR");
/*    */           } 
/* 65 */           res.setS2CCode(500);
/* 66 */           res.setS2CMsg(msg);
/* 67 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\onlineGift\ReceiveGiftHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */