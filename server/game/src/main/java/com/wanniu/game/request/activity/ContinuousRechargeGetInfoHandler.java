/*    */ package com.wanniu.game.request.activity;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.core.util.DateUtils;
/*    */ import com.wanniu.game.GWorld;
/*    */ import com.wanniu.game.activity.RechargeActivityService;
/*    */ import com.wanniu.game.data.AddRechargeLimitCO;
/*    */ import com.wanniu.game.data.GameData;
/*    */ import com.wanniu.game.player.GlobalConfig;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import java.time.LocalDate;
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
/*    */ @GClientEvent("area.activityFavorHandler.continuousRechargeGetInfoRequest")
/*    */ public class ContinuousRechargeGetInfoHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 32 */     WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*    */     
/* 34 */     final ActivityFavorHandler.ContinuousRechargeGetInfoResponse.Builder res = ActivityFavorHandler.ContinuousRechargeGetInfoResponse.newBuilder();
/*    */     
/* 36 */     ActivityFavorHandler.ContinuousRechargeInfo.Builder info = ActivityFavorHandler.ContinuousRechargeInfo.newBuilder();
/*    */     
/* 38 */     LocalDate openServerDate = GWorld.OPEN_SERVER_DATE;
/* 39 */     info.setBeginTime(openServerDate.atTime(0, 0, 0).format(DateUtils.F_YYYYMMDDHHMMSS));
/* 40 */     info.setEndTime(openServerDate.plusDays(6L).atTime(23, 59, 59).format(DateUtils.F_YYYYMMDDHHMMSS));
/*    */     
/* 42 */     Map<Integer, Integer> stateInfo = RechargeActivityService.getInstance().getContinuousRechargeInfo(player.getId());
/*    */     
/* 44 */     info.setDay(RechargeActivityService.getInstance().getContinuousRechargeDay(player.getId()));
/*    */     
/* 46 */     for (AddRechargeLimitCO temlate : GameData.AddRechargeLimits.values()) {
/* 47 */       ActivityFavorHandler.ContinuousRechargeAwardInfo.Builder builder = ActivityFavorHandler.ContinuousRechargeAwardInfo.newBuilder();
/* 48 */       builder.setDay(temlate.addTime);
/* 49 */       builder.setMoney(temlate.rechargeLimit);
/*    */       
/* 51 */       String[] arrayOfString = temlate.rechargeFReward.split(",");
/* 52 */       for (String strs1_item : arrayOfString) {
/* 53 */         ActivityFavorHandler.ContinuousRechargeItem.Builder item = ActivityFavorHandler.ContinuousRechargeItem.newBuilder();
/* 54 */         String[] strs2 = strs1_item.split(":");
/* 55 */         item.setCode(strs2[0]);
/* 56 */         item.setGroupCount(Integer.parseInt(strs2[1]));
/* 57 */         builder.addItem(item);
/*    */       } 
/*    */       
/* 60 */       builder.setState(((Integer)stateInfo.getOrDefault(Integer.valueOf(temlate.addTime), Integer.valueOf(0))).intValue());
/* 61 */       info.addContinuousRechargeAwardInfo(builder);
/*    */ 
/*    */       
/* 64 */       if (builder.getDay() == info.getDay()) {
/* 65 */         info.setNeedNum(builder.getMoney());
/* 66 */         info.setCurrNum(player.prepaidManager.getTodayPayValue() / 100);
/*    */       } 
/*    */     } 
/*    */ 
/*    */     
/* 71 */     ActivityFavorHandler.ContinuousRechargeAwardInfo.Builder awardInfo = ActivityFavorHandler.ContinuousRechargeAwardInfo.newBuilder();
/* 72 */     awardInfo.setDay(0);
/* 73 */     awardInfo.setMoney(0);
/*    */     
/* 75 */     String[] strs1 = GlobalConfig.AddRecharge_Reward.split(",");
/* 76 */     for (String strs1_item : strs1) {
/* 77 */       ActivityFavorHandler.ContinuousRechargeItem.Builder item = ActivityFavorHandler.ContinuousRechargeItem.newBuilder();
/* 78 */       String[] strs2 = strs1_item.split(":");
/* 79 */       item.setCode(strs2[0]);
/* 80 */       item.setGroupCount(Integer.parseInt(strs2[1]));
/* 81 */       awardInfo.addItem(item);
/*    */     } 
/*    */     
/* 84 */     awardInfo.setState(((Integer)stateInfo.getOrDefault(Integer.valueOf(0), Integer.valueOf(0))).intValue());
/* 85 */     info.addContinuousRechargeAwardInfo(awardInfo);
/*    */ 
/*    */     
/* 88 */     res.setS2CCode(200);
/* 89 */     res.setContinuousRechargeInfo(info);
/*    */     
/* 91 */     return new PomeloResponse() {
/*    */         protected void write() throws IOException {
/* 93 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\activity\ContinuousRechargeGetInfoHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */