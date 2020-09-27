/*    */ package com.wanniu.game.request.vip;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.core.tcp.protocol.Packet;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.VipHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.vipHandler.getEveryDayGiftRequest")
/*    */ public class GetEveryDayGiftHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 19 */     return new PomeloResponse() {
/*    */         protected void write() throws IOException {
/* 21 */           WNPlayer player = (WNPlayer)GetEveryDayGiftHandler.this.pak.getPlayer();
/* 22 */           VipHandler.GetEveryDayGiftRequest req = VipHandler.GetEveryDayGiftRequest.parseFrom(GetEveryDayGiftHandler.this.pak.getRemaingBytes());
/* 23 */           int type = req.getC2SType();
/* 24 */           int result = player.vipManager.takeDailyReward(type);
/* 25 */           VipHandler.GetEveryDayGiftResponse.Builder res = VipHandler.GetEveryDayGiftResponse.newBuilder();
/* 26 */           if (result == 0) {
/* 27 */             res.setS2CCode(200);
/* 28 */           } else if (result == -1) {
/* 29 */             res.setS2CCode(500);
/* 30 */             res.setS2CMsg(LangService.getValue("CARD_MONTH_NONE"));
/* 31 */           } else if (result == -2) {
/* 32 */             res.setS2CCode(500);
/* 33 */             res.setS2CMsg(LangService.getValue("CARD_FOREVER_NONE"));
/* 34 */           } else if (result == -3) {
/* 35 */             res.setS2CCode(500);
/* 36 */             res.setS2CMsg(LangService.getValue("CARD_RECEIVED"));
/* 37 */           } else if (result == -4) {
/* 38 */             res.setS2CCode(500);
/* 39 */             res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
/*    */           } 
/*    */ 
/*    */ 
/*    */ 
/*    */           
/* 45 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\vip\GetEveryDayGiftHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */