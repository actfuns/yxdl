/*    */ package com.wanniu.game.request.activity;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.activity.ActivityManager;
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
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.activityFavorHandler.limitTimeGiftInfoRequest")
/*    */ public class LimitTimeGiftInfoHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 33 */     ActivityFavorHandler.LimitTimeGiftInfoRequest req = ActivityFavorHandler.LimitTimeGiftInfoRequest.parseFrom(this.pak.getRemaingBytes());
/*    */     
/* 35 */     WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*    */     
/* 37 */     ActivityManager activityManager = player.activityManager;
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 42 */     final ActivityFavorHandler.LimitTimeGiftInfoResponse.Builder res = ActivityFavorHandler.LimitTimeGiftInfoResponse.newBuilder();
/*    */     
/* 44 */     res.setS2CCode(200);
/* 45 */     res.addAllLimitTimeGiftInfo(activityManager.getLimitTimeGiftInfos());
/*    */ 
/*    */     
/* 48 */     return new PomeloResponse() {
/*    */         protected void write() throws IOException {
/* 50 */           res.setS2CCode(200);
/* 51 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\activity\LimitTimeGiftInfoHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */