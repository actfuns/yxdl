/*    */ package com.wanniu.game.request.activity;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.core.tcp.protocol.Packet;
/*    */ import com.wanniu.game.activity.ActivityManager;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.game.prepaid.PrepaidManager;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.ActivityFavorHandler;
/*    */ import pomelo.area.ActivityHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.activityFavorHandler.dailyRechargeGetInfoRequest")
/*    */ public class DailyRechargeGetInfoHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 22 */     ActivityFavorHandler.DailyRechargeGetInfoRequest req = ActivityFavorHandler.DailyRechargeGetInfoRequest.parseFrom(this.pak.getRemaingBytes());
/* 23 */     return new PomeloResponse() {
/*    */         protected void write() throws IOException {
/* 25 */           WNPlayer player = (WNPlayer)DailyRechargeGetInfoHandler.this.pak.getPlayer();
/*    */           
/* 27 */           ActivityManager activityManager = player.activityManager;
/* 28 */           PrepaidManager prepaidManager = player.prepaidManager;
/*    */           
/* 30 */           ActivityFavorHandler.DailyRechargeGetInfoResponse.Builder res = ActivityFavorHandler.DailyRechargeGetInfoResponse.newBuilder();
/*    */ 
/*    */           
/* 33 */           ActivityHandler.totalInfo totalInfo = activityManager.DailyRecharge_Today().build();
/* 34 */           res.setTotalInfo(totalInfo);
/* 35 */           res.setRechargeNum(prepaidManager.getDailyCharge());
/* 36 */           res.setRechargeMax(activityManager.DailyRecharge_GetTodayMax());
/*    */ 
/*    */           
/* 39 */           res.setS2CCode(200);
/* 40 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\activity\DailyRechargeGetInfoHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */