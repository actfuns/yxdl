/*     */ package com.wanniu.game.request.activity;
/*     */ 
/*     */ import com.wanniu.core.game.LangService;
/*     */ import com.wanniu.core.game.entity.GClientEvent;
/*     */ import com.wanniu.core.game.protocol.PomeloRequest;
/*     */ import com.wanniu.core.game.protocol.PomeloResponse;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.game.activity.ActivityManager;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.msg.ErrorResponse;
/*     */ import com.wanniu.game.data.AdventureItemAddCO;
/*     */ import com.wanniu.game.data.AdventureItemCO;
/*     */ import com.wanniu.game.data.ext.ActivityConfigExt;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.player.bi.LogReportService;
/*     */ import com.wanniu.game.poes.ActivityDataPO;
/*     */ import java.io.IOException;
/*     */ import java.util.List;
/*     */ import pomelo.area.ActivityFavorHandler;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @GClientEvent("area.activityFavorHandler.dailyDrawRequest")
/*     */ public class DailyDrawHandler
/*     */   extends PomeloRequest
/*     */ {
/*     */   public PomeloResponse request() throws Exception {
/*     */     List<AdventureItemCO> adventureItemCOList;
/*     */     List<AdventureItemAddCO> adventureItemCOAddList;
/*  35 */     ActivityFavorHandler.DailyDrawRequest req = ActivityFavorHandler.DailyDrawRequest.parseFrom(this.pak.getRemaingBytes());
/*  36 */     int id = req.getId();
/*  37 */     int timeType = req.getTimeType();
/*  38 */     int costType = req.getCostType();
/*     */     
/*  40 */     WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*     */     
/*  42 */     ActivityManager activityManager = player.activityManager;
/*  43 */     ActivityDataPO activityDataPO = activityManager.toJson4Serialize();
/*     */ 
/*     */     
/*  46 */     List<ActivityConfigExt> activityConfigExt = activityManager.findActivitieConfigsByRewardType(Const.ActivityRewardType.LUCK_DRAW);
/*  47 */     int proportion = -1;
/*  48 */     for (ActivityConfigExt activityConfigExt_temp : activityConfigExt) {
/*  49 */       if (activityConfigExt_temp.notes1.equals("Activity_Adventure_Proportion")) {
/*  50 */         proportion = activityConfigExt_temp.parameter1;
/*     */       }
/*     */     } 
/*  53 */     if (proportion == -1) {
/*  54 */       Out.error(new Object[] { "数据表记录缺失" });
/*  55 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("PARAM_ERROR"));
/*     */     } 
/*     */ 
/*     */     
/*  59 */     int raffleticketsItemCount = player.bag.findItemNumByCode(Const.raffletickets);
/*  60 */     int needConsumeCount = 0;
/*  61 */     int needConsumeMoney = 0;
/*     */ 
/*     */     
/*  64 */     Const.GOODS_CHANGE_TYPE costDes = Const.GOODS_CHANGE_TYPE.ActivityDraw;
/*  65 */     if (id == 1) {
/*  66 */       costDes = Const.GOODS_CHANGE_TYPE.ActivityDrawSpring;
/*     */     }
/*     */     
/*  69 */     switch (costType) {
/*     */       case 0:
/*  71 */         switch (id) {
/*     */           case 0:
/*  73 */             if (activityDataPO.daily_draw_free_time < 1) {
/*  74 */               return (PomeloResponse)new ErrorResponse(LangService.getValue("ACTIVITY_DAILY_DRAW_NO_FREE_TIME"));
/*     */             }
/*  76 */             activityDataPO.daily_draw_free_time--;
/*     */             break;
/*     */           case 1:
/*  79 */             if (activityDataPO.daily_draw_free_time_add < 1) {
/*  80 */               return (PomeloResponse)new ErrorResponse(LangService.getValue("ACTIVITY_DAILY_DRAW_NO_FREE_TIME"));
/*     */             }
/*  82 */             activityDataPO.daily_draw_free_time_add--;
/*     */             break;
/*     */         } 
/*  85 */         return (PomeloResponse)new ErrorResponse(LangService.getValue("PARAM_ERROR"));
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case 1:
/*  91 */         if (timeType == 0) {
/*  92 */           needConsumeCount = 1;
/*     */         
/*     */         }
/*  95 */         else if (timeType == 1) {
/*  96 */           needConsumeCount = 10;
/*     */         } else {
/*  98 */           return (PomeloResponse)new ErrorResponse(LangService.getValue("PARAM_ERROR"));
/*     */         } 
/*     */         
/* 101 */         if (!player.bag.discardItem(Const.raffletickets, needConsumeCount, costDes)) {
/* 102 */           return (PomeloResponse)new ErrorResponse(LangService.getValue("ACTIVITY_DAILY_DRAW_NO_EXPLORE_TICKETS"));
/*     */         }
/*     */         break;
/*     */ 
/*     */       
/*     */       case 2:
/* 108 */         if (timeType == 0) {
/* 109 */           if (raffleticketsItemCount >= 1) {
/* 110 */             needConsumeCount = 1;
/*     */           } else {
/* 112 */             needConsumeMoney = proportion * 1;
/*     */           }
/*     */         
/*     */         }
/* 116 */         else if (timeType == 1) {
/* 117 */           if (raffleticketsItemCount >= 10) {
/* 118 */             needConsumeCount = 10;
/*     */           } else {
/* 120 */             needConsumeCount = raffleticketsItemCount;
/* 121 */             needConsumeMoney = proportion * (10 - raffleticketsItemCount);
/*     */           } 
/*     */         } else {
/* 124 */           return (PomeloResponse)new ErrorResponse(LangService.getValue("PARAM_ERROR"));
/*     */         } 
/*     */ 
/*     */         
/* 128 */         if (needConsumeMoney > 0 && 
/* 129 */           !player.moneyManager.costDiamond(needConsumeMoney, costDes)) {
/* 130 */           return (PomeloResponse)new ErrorResponse(LangService.getValue("ACTIVITY_DAILY_DRAW_NO_DIAMOND"));
/*     */         }
/*     */ 
/*     */         
/* 134 */         if (needConsumeCount > 0) {
/* 135 */           player.bag.discardItem(Const.raffletickets, needConsumeCount, costDes);
/*     */         }
/*     */         break;
/*     */       default:
/* 139 */         return (PomeloResponse)new ErrorResponse(LangService.getValue("PARAM_ERROR"));
/*     */     } 
/*     */     
/* 142 */     final ActivityFavorHandler.DailyDrawResponse.Builder res = ActivityFavorHandler.DailyDrawResponse.newBuilder();
/* 143 */     res.setExploredTicketCountLeft(raffleticketsItemCount - needConsumeCount);
/*     */     
/* 145 */     switch (id) {
/*     */       case 0:
/* 147 */         adventureItemCOList = null;
/* 148 */         if (timeType == 0) {
/* 149 */           adventureItemCOList = activityManager.DailyDraw_Draw(1);
/*     */         } else {
/* 151 */           adventureItemCOList = activityManager.DailyDraw_Draw(10);
/*     */         } 
/* 153 */         for (AdventureItemCO adventureItemCO : adventureItemCOList) {
/* 154 */           ActivityFavorHandler.DailyDrawAwardInfo.Builder awardInfoBuilder = ActivityFavorHandler.DailyDrawAwardInfo.newBuilder();
/* 155 */           awardInfoBuilder.setId(adventureItemCO.id);
/* 156 */           awardInfoBuilder.setCode(adventureItemCO.item);
/* 157 */           awardInfoBuilder.setNum(adventureItemCO.itemNum);
/* 158 */           res.addAwards(awardInfoBuilder.build());
/*     */         } 
/*     */         
/* 161 */         res.setFreeCountLeft(activityDataPO.daily_draw_free_time);
/*     */         
/* 163 */         Out.info(new Object[] { player.getId(), ":每日抽奖成功,抽奖类型:", (timeType == 0) ? "单抽" : "十连抽", "常规抽奖" });
/*     */         break;
/*     */       case 1:
/* 166 */         adventureItemCOAddList = null;
/* 167 */         if (timeType == 0) {
/* 168 */           adventureItemCOAddList = activityManager.DailyDraw_Draw_Add(1);
/*     */         } else {
/* 170 */           adventureItemCOAddList = activityManager.DailyDraw_Draw_Add(10);
/*     */         } 
/* 172 */         for (AdventureItemAddCO adventureItemAddCO : adventureItemCOAddList) {
/* 173 */           ActivityFavorHandler.DailyDrawAwardInfo.Builder awardInfoBuilder = ActivityFavorHandler.DailyDrawAwardInfo.newBuilder();
/* 174 */           awardInfoBuilder.setId(adventureItemAddCO.id);
/* 175 */           awardInfoBuilder.setCode(adventureItemAddCO.item);
/* 176 */           awardInfoBuilder.setNum(adventureItemAddCO.itemNum);
/* 177 */           res.addAwards(awardInfoBuilder.build());
/*     */         } 
/*     */         
/* 180 */         res.setFreeCountLeft(activityDataPO.daily_draw_free_time_add);
/*     */         
/* 182 */         Out.info(new Object[] { player.getId(), ":每日抽奖成功,抽奖类型:", (timeType == 0) ? "单抽" : "十连抽", "新春抽奖" });
/*     */         break;
/*     */       default:
/* 185 */         return (PomeloResponse)new ErrorResponse(LangService.getValue("PARAM_ERROR"));
/*     */     } 
/*     */ 
/*     */     
/* 189 */     int count = (timeType == 0) ? 1 : 10;
/* 190 */     LogReportService.getInstance().ansycReportLuckDraw(player, id, count, needConsumeMoney, needConsumeCount);
/*     */     
/* 192 */     return new PomeloResponse() {
/*     */         protected void write() throws IOException {
/* 194 */           res.setS2CCode(200);
/* 195 */           this.body.writeBytes(res.build().toByteArray());
/*     */         }
/*     */       };
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\activity\DailyDrawHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */