/*    */ package com.wanniu.game.request.activity;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.activity.ActivityManager;
/*    */ import com.wanniu.game.common.msg.ErrorResponse;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.ActivityFavorHandler;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.activityFavorHandler.limitTimeGiftBuyRequest")
/*    */ public class LimitTimeGiftBuyHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 33 */     ActivityFavorHandler.LimitTimeGiftBuyRequest req = ActivityFavorHandler.LimitTimeGiftBuyRequest.parseFrom(this.pak.getRemaingBytes());
/* 34 */     int id = req.getId();
/*    */     
/* 36 */     WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*    */     
/* 38 */     ActivityManager activityManager = player.activityManager;
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 43 */     final ActivityFavorHandler.LimitTimeGiftBuyResponse.Builder res = ActivityFavorHandler.LimitTimeGiftBuyResponse.newBuilder();
/*    */     
/* 45 */     int result = activityManager.BugLimitTimeGift(id);
/*    */     
/* 47 */     switch (result) {
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
/*    */ 
/*    */       
/*    */       case 0:
/* 62 */         return new PomeloResponse() {
/*    */             protected void write() throws IOException {
/* 64 */               res.setS2CCode(200);
/* 65 */               this.body.writeBytes(res.build().toByteArray());
/*    */             }
/*    */           };
/*    */       case 2:
/*    */         return (PomeloResponse)new ErrorResponse(LangService.getValue("LIMIT_TIME_GIFT_BOUGHT"));
/*    */       case 3:
/*    */         return (PomeloResponse)new ErrorResponse(LangService.getValue("LIMIT_TIME_GIFT_NO_ENOUTH_DIAMOND"));
/*    */     } 
/*    */     return (PomeloResponse)new ErrorResponse(LangService.getValue("PARAM_ERROR"));
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\activity\LimitTimeGiftBuyHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */