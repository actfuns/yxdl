/*    */ package com.wanniu.game.request.revelry;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.activity.RechargeActivityService;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.revelry.ActivityRevelryHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("revelry.activityRevelryHandler.revelryRechargeAwardRequest")
/*    */ public class RevelryRechargeAwardHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 23 */     ActivityRevelryHandler.RevelryRechargeAwardRequest req = ActivityRevelryHandler.RevelryRechargeAwardRequest.parseFrom(this.pak.getRemaingBytes());
/* 24 */     int id = req.getId();
/* 25 */     WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*    */     
/* 27 */     PomeloResponse errorcode = RechargeActivityService.getInstance().receiveRevelryRecharge(player, id);
/* 28 */     if (errorcode != null) {
/* 29 */       return errorcode;
/*    */     }
/*    */     
/* 32 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 35 */           ActivityRevelryHandler.RevelryRechargeAwardResponse.Builder result = ActivityRevelryHandler.RevelryRechargeAwardResponse.newBuilder();
/* 36 */           result.setS2CCode(200);
/* 37 */           this.body.writeBytes(result.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\revelry\RevelryRechargeAwardHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */