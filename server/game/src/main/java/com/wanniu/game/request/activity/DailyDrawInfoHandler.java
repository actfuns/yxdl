/*     */ package com.wanniu.game.request.activity;
/*     */ 
/*     */ import com.wanniu.core.game.entity.GClientEvent;
/*     */ import com.wanniu.core.game.protocol.PomeloRequest;
/*     */ import com.wanniu.core.game.protocol.PomeloResponse;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.tcp.protocol.Packet;
/*     */ import com.wanniu.game.activity.ActivityManager;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.data.AdventureItemAddCO;
/*     */ import com.wanniu.game.data.AdventureItemCO;
/*     */ import com.wanniu.game.data.GameData;
/*     */ import com.wanniu.game.data.ext.ActivityConfigExt;
/*     */ import com.wanniu.game.data.ext.ActivityExt;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import java.io.IOException;
/*     */ import java.util.List;
/*     */ import pomelo.area.ActivityFavorHandler;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @GClientEvent("area.activityFavorHandler.dailyDrawInfoRequest")
/*     */ public class DailyDrawInfoHandler
/*     */   extends PomeloRequest
/*     */ {
/*     */   public PomeloResponse request() throws Exception {
/*  29 */     ActivityFavorHandler.DailyDrawInfoRequest req = ActivityFavorHandler.DailyDrawInfoRequest.parseFrom(this.pak.getRemaingBytes());
/*  30 */     final int id = req.getId();
/*  31 */     return new PomeloResponse() { protected void write() throws IOException {
/*     */           ActivityExt activityExt, activityExtAdd;
/*  33 */           WNPlayer player = (WNPlayer)DailyDrawInfoHandler.this.pak.getPlayer();
/*     */           
/*  35 */           ActivityManager activityManager = player.activityManager;
/*     */ 
/*     */           
/*  38 */           ActivityFavorHandler.DailyDrawInfoResponse.Builder res = ActivityFavorHandler.DailyDrawInfoResponse.newBuilder();
/*     */           
/*  40 */           switch (id) {
/*     */             case 0:
/*  42 */               res.setFreeCountLeft((activityManager.toJson4Serialize()).daily_draw_free_time);
/*     */               
/*  44 */               for (AdventureItemCO adventureItemCO : GameData.AdventureItems.values()) {
/*  45 */                 ActivityFavorHandler.DailyDrawAwardInfo.Builder awardInfoBuilder = ActivityFavorHandler.DailyDrawAwardInfo.newBuilder();
/*  46 */                 awardInfoBuilder.setId(adventureItemCO.id);
/*  47 */                 awardInfoBuilder.setCode(adventureItemCO.item);
/*  48 */                 awardInfoBuilder.setNum(adventureItemCO.itemNum);
/*  49 */                 res.addAwards(awardInfoBuilder.build());
/*     */               } 
/*     */               
/*  52 */               activityExt = activityManager.findActivityByType(Const.ActivityRewardType.LUCK_DRAW.getValue());
/*  53 */               res.setBeginTime(activityExt.openTime);
/*  54 */               res.setEndTime(activityExt.closeTime);
/*  55 */               res.setDescribe(activityExt.activityRule);
/*  56 */               res.setFreeCountUpdateTimeStamp(activityManager.DailyDrawGetFreeTimeUpdateTime().getTime());
/*     */               break;
/*     */             case 1:
/*  59 */               res.setFreeCountLeft((activityManager.toJson4Serialize()).daily_draw_free_time_add);
/*     */               
/*  61 */               for (AdventureItemAddCO adventureItemAddCO : GameData.AdventureItemAdds.values()) {
/*  62 */                 ActivityFavorHandler.DailyDrawAwardInfo.Builder awardInfoBuilder = ActivityFavorHandler.DailyDrawAwardInfo.newBuilder();
/*  63 */                 awardInfoBuilder.setId(adventureItemAddCO.id);
/*  64 */                 awardInfoBuilder.setCode(adventureItemAddCO.item);
/*  65 */                 awardInfoBuilder.setNum(adventureItemAddCO.itemNum);
/*  66 */                 res.addAwards(awardInfoBuilder.build());
/*     */               } 
/*     */               
/*  69 */               activityExtAdd = activityManager.findActivityByType(Const.ActivityRewardType.SPRING_DRAW.getValue());
/*  70 */               res.setBeginTime(activityExtAdd.openTime);
/*  71 */               res.setEndTime(activityExtAdd.closeTime);
/*  72 */               res.setDescribe(activityExtAdd.activityRule);
/*  73 */               res.setFreeCountUpdateTimeStamp(activityManager.DailyDrawGetFreeTimeUpdateTime().getTime());
/*     */               break;
/*     */ 
/*     */             
/*     */             default:
/*     */               return;
/*     */           } 
/*     */           
/*  81 */           int count = player.bag.findItemNumByCode(Const.raffletickets);
/*  82 */           res.setExploredTicketCountLeft(count);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*  89 */           List<ActivityConfigExt> activityConfigExt = activityManager.findActivitieConfigsByRewardType(Const.ActivityRewardType.LUCK_DRAW);
/*  90 */           int proportion = -1;
/*  91 */           for (ActivityConfigExt activityConfigExt_temp : activityConfigExt) {
/*  92 */             if (activityConfigExt_temp.notes1.equals("Activity_Adventure_Proportion")) {
/*  93 */               proportion = activityConfigExt_temp.parameter1;
/*     */             }
/*     */           } 
/*  96 */           if (proportion == -1) {
/*  97 */             Out.debug(new Object[] { "数据表记录缺失" });
/*     */             return;
/*     */           } 
/* 100 */           res.setProportion(proportion);
/*     */           
/* 102 */           res.setS2CCode(200);
/* 103 */           this.body.writeBytes(res.build().toByteArray());
/*     */         } }
/*     */       ;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\activity\DailyDrawInfoHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */