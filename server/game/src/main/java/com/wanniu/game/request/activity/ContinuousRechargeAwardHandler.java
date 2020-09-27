/*    */ package com.wanniu.game.request.activity;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.activity.RechargeActivityService;
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
/*    */ @GClientEvent("area.activityFavorHandler.continuousRechargeAwardRequest")
/*    */ public class ContinuousRechargeAwardHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 25 */     ActivityFavorHandler.ContinuousRechargeAwardRequest request = ActivityFavorHandler.ContinuousRechargeAwardRequest.parseFrom(this.pak.getRemaingBytes());
/* 26 */     int day = request.getDay();
/*    */     
/* 28 */     if (day < 0) {
/* 29 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("PARAM_ERROR"));
/*    */     }
/*    */     
/* 32 */     WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*    */     
/* 34 */     PomeloResponse errorcode = RechargeActivityService.getInstance().receiveContinuousRecharge(player, day);
/* 35 */     if (errorcode != null) {
/* 36 */       return errorcode;
/*    */     }
/*    */     
/* 39 */     return new PomeloResponse() {
/*    */         protected void write() throws IOException {
/* 41 */           ActivityFavorHandler.ContinuousRechargeAwardResponse.Builder res = ActivityFavorHandler.ContinuousRechargeAwardResponse.newBuilder();
/* 42 */           res.setS2CCode(200);
/* 43 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\activity\ContinuousRechargeAwardHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */