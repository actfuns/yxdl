/*    */ package com.wanniu.game.request.activity;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.core.tcp.protocol.Packet;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.data.ActivityCO;
/*    */ import com.wanniu.game.data.GameData;
/*    */ import com.wanniu.game.data.ext.ActivityExt;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Map;
/*    */ import pomelo.area.ActivityHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.activityHandler.interestActivityAdRequest")
/*    */ public class InterestActivityAdHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 26 */     return new PomeloResponse() {
/*    */         protected void write() throws IOException {
/* 28 */           WNPlayer player = (WNPlayer)InterestActivityAdHandler.this.pak.getPlayer();
/* 29 */           ActivityHandler.InterestActivityAdResponse.Builder res = ActivityHandler.InterestActivityAdResponse.newBuilder();
/*    */           
/* 31 */           long now = System.currentTimeMillis();
/* 32 */           Map<Integer, ActivityExt> props = GameData.Activitys;
/*    */           
/* 34 */           ArrayList<ActivityHandler.ActivityListInfo> list_info = new ArrayList<>();
/* 35 */           for (ActivityCO p : props.values()) {
/* 36 */             ActivityExt prop = (ActivityExt)p;
/* 37 */             if (prop.beginTime < now && now < prop.endTime) {
/* 38 */               if (prop.activityTab == Const.ActivityRewardType.FIRST_PAY.getValue()) {
/* 39 */                 if (player.activityManager.hasFirstPayReward()) {
/*    */                   continue;
/*    */                 }
/* 42 */               } else if (prop.activityTab == Const.ActivityRewardType.SECOND_PAY.getValue()) {
/* 43 */                 if (!player.activityManager.hasFirstPayReward()) {
/*    */                   continue;
/*    */                 }
/* 46 */                 if (!player.activityManager.isSecondPayVaild()) {
/*    */                   continue;
/*    */                 }
/* 49 */               } else if (prop.activityTab == Const.ActivityRewardType.OPEN_SEVEN_DAY.getValue()) {
/*    */                 continue;
/*    */               } 
/* 52 */               ActivityHandler.ActivityListInfo.Builder info = ActivityHandler.ActivityListInfo.newBuilder();
/* 53 */               info.setActivityId(prop.activityID);
/* 54 */               info.setHudNum(player.activityManager.getActivityHud(prop.activityID, prop.activityTab));
/* 55 */               list_info.add(info.build());
/*    */             } 
/*    */           } 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */           
/* 64 */           res.addAllS2CActivityList(list_info);
/* 65 */           res.setS2CCode(200);
/* 66 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\activity\InterestActivityAdHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */