/*    */ package com.wanniu.game.request.activity;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.activity.RechargeActivityService;
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
/*    */ @GClientEvent("area.activityFavorHandler.singleRechargeAwardRequest")
/*    */ public class SingleRechargeAwardHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 23 */     ActivityFavorHandler.SingleRechargeAwardRequest request = ActivityFavorHandler.SingleRechargeAwardRequest.parseFrom(this.pak.getRemaingBytes());
/* 24 */     int id = request.getId();
/* 25 */     WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*    */     
/* 27 */     PomeloResponse errorcode = RechargeActivityService.getInstance().receiveSingleRecharge(player, id);
/* 28 */     if (errorcode != null) {
/* 29 */       return errorcode;
/*    */     }
/*    */     
/* 32 */     return new PomeloResponse() {
/*    */         protected void write() throws IOException {
/* 34 */           ActivityFavorHandler.ContinuousRechargeAwardResponse.Builder res = ActivityFavorHandler.ContinuousRechargeAwardResponse.newBuilder();
/* 35 */           res.setS2CCode(200);
/* 36 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\activity\SingleRechargeAwardHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */