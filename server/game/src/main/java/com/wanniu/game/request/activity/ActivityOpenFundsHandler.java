/*    */ package com.wanniu.game.request.activity;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.GWorld;
/*    */ import com.wanniu.game.activity.ActivityCenterManager;
/*    */ import com.wanniu.game.player.GlobalConfig;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.ActivityHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.activityHandler.activityOpenFundsRequest")
/*    */ public class ActivityOpenFundsHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 20 */     WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 21 */     final ActivityHandler.ActivityOpenFundsRes.Builder res = player.activityManager.openFunds();
/* 22 */     res.setS2CCode(200);
/* 23 */     res.setS2CNeedVipLevel(0);
/* 24 */     res.setS2CNeedDiamond(GlobalConfig.Activity_Fund_Buy);
/* 25 */     res.setS2CHasBuyNum(ActivityCenterManager.getIntance().getFundsNum(GWorld.__SERVER_ID));
/*    */     
/* 27 */     return new PomeloResponse() {
/*    */         protected void write() throws IOException {
/* 29 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\activity\ActivityOpenFundsHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */