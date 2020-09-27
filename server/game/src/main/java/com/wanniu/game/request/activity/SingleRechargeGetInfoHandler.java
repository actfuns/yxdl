/*    */ package com.wanniu.game.request.activity;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.activity.RechargeActivityService;
/*    */ import com.wanniu.game.bag.WNBag;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.common.msg.ErrorResponse;
/*    */ import com.wanniu.game.data.GameData;
/*    */ import com.wanniu.game.data.ext.ActivityConfigExt;
/*    */ import com.wanniu.game.data.ext.ActivityExt;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Map;
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
/*    */ @GClientEvent("area.activityFavorHandler.singleRechargeGetInfoRequest")
/*    */ public class SingleRechargeGetInfoHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 35 */     WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*    */     
/* 37 */     ActivityExt activityExt = player.activityManager.findActivityByType(Const.ActivityRewardType.SINGLE_RECHARGE.getValue());
/* 38 */     if (activityExt == null) {
/* 39 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("PARAM_ERROR"));
/*    */     }
/*    */ 
/*    */     
/* 43 */     ActivityFavorHandler.SingleRechargeInfo.Builder info = ActivityFavorHandler.SingleRechargeInfo.newBuilder();
/* 44 */     info.setBeginTime(activityExt.openTime);
/* 45 */     info.setEndTime(activityExt.closeTime);
/* 46 */     info.setDescribe(activityExt.activityRule);
/*    */     
/* 48 */     Map<Integer, Integer> stateInfo = RechargeActivityService.getInstance().getSingleRechargeInfo(player.getId());
/* 49 */     List<ActivityConfigExt> activityConfigExts = GameData.findActivityConfigs(t -> (t.type == activityExt.activityID));
/* 50 */     for (ActivityConfigExt template : activityConfigExts) {
/* 51 */       ActivityFavorHandler.SingleRechargeAwardInfo.Builder srab = ActivityFavorHandler.SingleRechargeAwardInfo.newBuilder();
/* 52 */       srab.setId(template.id);
/*    */       
/* 54 */       ArrayList<WNBag.SimpleItemInfo> rewardItem = player.activityManager.getRankReward(template.RankReward);
/* 55 */       for (WNBag.SimpleItemInfo sii : rewardItem) {
/* 56 */         ActivityFavorHandler.SingleRechargeItem.Builder item = ActivityFavorHandler.SingleRechargeItem.newBuilder();
/* 57 */         item.setCode(sii.itemCode);
/* 58 */         item.setGroupCount(sii.itemNum);
/* 59 */         srab.addItem(item);
/*    */       } 
/* 61 */       srab.setState(((Integer)stateInfo.getOrDefault(Integer.valueOf(template.id), Integer.valueOf(0))).intValue());
/* 62 */       srab.setCurrNum(0);
/* 63 */       srab.setNeedNum(template.parameter1);
/* 64 */       info.addSingleRechargeAwardInfo(srab);
/*    */     } 
/*    */     
/* 67 */     final ActivityFavorHandler.SingleRechargeGetInfoResponse.Builder res = ActivityFavorHandler.SingleRechargeGetInfoResponse.newBuilder();
/* 68 */     res.setS2CCode(200);
/* 69 */     res.setSingleRechargeInfo(info);
/* 70 */     return new PomeloResponse() {
/*    */         protected void write() throws IOException {
/* 72 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\activity\SingleRechargeGetInfoHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */