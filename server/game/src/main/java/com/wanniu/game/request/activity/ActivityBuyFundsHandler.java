/*    */ package com.wanniu.game.request.activity;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.game.GWorld;
/*    */ import com.wanniu.game.activity.ActivityCenterManager;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.common.msg.ErrorResponse;
/*    */ import com.wanniu.game.player.GlobalConfig;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import java.util.HashMap;
/*    */ import pomelo.area.ActivityHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.activityHandler.activityBuyFundsRequest")
/*    */ public class ActivityBuyFundsHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 30 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*    */     
/* 32 */     HashMap<Integer, Integer> actInfo = player.activityManager.getActivityInfo(Const.ActivityRewardType.FOUNDATION.getValue());
/* 33 */     if (actInfo != null) {
/* 34 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("ACTIVITY_NOT_REQUIRMENT"));
/*    */     }
/*    */     
/* 37 */     int needDiamond = GlobalConfig.Activity_Fund_Buy;
/* 38 */     if (!player.moneyManager.costDiamond(needDiamond, Const.GOODS_CHANGE_TYPE.BUY_FUNDS)) {
/* 39 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("ACTIVITY_NOT_CONDITION"));
/*    */     }
/*    */     
/* 42 */     Out.info(new Object[] { "购买基金，playerId=", player.getId() });
/* 43 */     HashMap<Integer, Integer> data = new HashMap<>();
/* 44 */     player.activityManager.addActivityInfo(Const.ActivityRewardType.FOUNDATION.getValue(), data);
/*    */     
/* 46 */     ActivityCenterManager.getIntance().addFundRecord(GWorld.__SERVER_ID);
/*    */     
/* 48 */     return new PomeloResponse() {
/*    */         protected void write() throws IOException {
/* 50 */           ActivityHandler.ActivityBuyFundsRes.Builder res = ActivityHandler.ActivityBuyFundsRes.newBuilder();
/* 51 */           res.setS2CCode(200);
/* 52 */           this.body.writeBytes(res.build().toByteArray());
/*    */           
/* 54 */           player.activityManager.updateSuperScriptList();
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\activity\ActivityBuyFundsHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */