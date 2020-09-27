/*    */ package com.wanniu.game.request.activity;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.core.tcp.protocol.Packet;
/*    */ import com.wanniu.game.activity.ActivityManager;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.ActivityFavorHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.activityFavorHandler.dailyRechargeGetAwardRequest")
/*    */ public class DailyRechargeGetAwardHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 21 */     ActivityFavorHandler.DailyRechargeGetAwardRequest req = ActivityFavorHandler.DailyRechargeGetAwardRequest.parseFrom(this.pak.getRemaingBytes());
/* 22 */     final int awardId = req.getAwardId();
/* 23 */     return new PomeloResponse() {
/*    */         protected void write() throws IOException {
/* 25 */           WNPlayer player = (WNPlayer)DailyRechargeGetAwardHandler.this.pak.getPlayer();
/*    */           
/* 27 */           ActivityManager activityManager = player.activityManager;
/*    */ 
/*    */           
/* 30 */           ActivityFavorHandler.DailyRechargeGetAwardResponse.Builder res = ActivityFavorHandler.DailyRechargeGetAwardResponse.newBuilder();
/*    */ 
/*    */           
/* 33 */           boolean result = activityManager.DailyRecharge_GetAward(awardId);
/*    */           
/* 35 */           if (result) {
/*    */             
/* 37 */             res.setS2CCode(200);
/* 38 */             Out.info(new Object[] { player.getId(), ":每日充值奖励领取成功,奖励id:", Integer.valueOf(this.val$awardId) });
/*    */           } else {
/*    */             
/* 41 */             res.setS2CCode(500);
/* 42 */             res.setS2CMsg("ACTIVITY_NOT_REQUIRMENT");
/*    */           } 
/*    */ 
/*    */           
/* 46 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\activity\DailyRechargeGetAwardHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */