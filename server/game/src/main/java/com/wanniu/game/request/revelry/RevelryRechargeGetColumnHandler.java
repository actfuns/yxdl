/*    */ package com.wanniu.game.request.revelry;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.core.util.DateUtils;
/*    */ import com.wanniu.game.GWorld;
/*    */ import com.wanniu.game.activity.RechargeActivityService;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.common.msg.ErrorResponse;
/*    */ import com.wanniu.game.data.ext.ActivityExt;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import java.time.LocalDate;
/*    */ import java.util.Map;
/*    */ import pomelo.revelry.ActivityRevelryHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("revelry.activityRevelryHandler.revelryRechargeGetColumnRequest")
/*    */ public class RevelryRechargeGetColumnHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 32 */     final ActivityRevelryHandler.RevelryRechargeGetColumnResponse.Builder result = ActivityRevelryHandler.RevelryRechargeGetColumnResponse.newBuilder();
/*    */     
/* 34 */     WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*    */     
/* 36 */     ActivityExt activityExt = player.activityManager.findActivityByType(Const.ActivityRewardType.REVELRY_RECHARGE.getValue());
/* 37 */     if (activityExt == null) {
/* 38 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("PARAM_ERROR"));
/*    */     }
/* 40 */     result.setDescribe(activityExt.activityRule);
/*    */     
/* 42 */     LocalDate openServerDate = GWorld.OPEN_SERVER_DATE;
/* 43 */     result.setBeginTime(openServerDate.atTime(0, 0, 0).format(DateUtils.F_YYYYMMDDHHMMSS));
/* 44 */     result.setEndTime(openServerDate.plusDays(6L).atTime(23, 59, 59).format(DateUtils.F_YYYYMMDDHHMMSS));
/*    */     
/* 46 */     int day = RechargeActivityService.getInstance().getOpenServerDay();
/* 47 */     if (day > 0) {
/* 48 */       result.setToday(day);
/*    */     }
/*    */     
/* 51 */     Map<Integer, String> columns = RechargeActivityService.getInstance().getAllColumn();
/* 52 */     for (Map.Entry<Integer, String> e : columns.entrySet()) {
/* 53 */       ActivityRevelryHandler.RevelryRechargeColumn.Builder column = ActivityRevelryHandler.RevelryRechargeColumn.newBuilder();
/* 54 */       column.setDay(((Integer)e.getKey()).intValue());
/* 55 */       column.setName(e.getValue());
/* 56 */       result.addColumn(column);
/*    */     } 
/*    */     
/* 59 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 62 */           result.setS2CCode(200);
/* 63 */           this.body.writeBytes(result.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\revelry\RevelryRechargeGetColumnHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */