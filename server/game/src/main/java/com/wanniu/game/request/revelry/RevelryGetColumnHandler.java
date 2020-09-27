/*     */ package com.wanniu.game.request.revelry;
/*     */ 
/*     */ import com.wanniu.core.game.LangService;
/*     */ import com.wanniu.core.game.entity.GClientEvent;
/*     */ import com.wanniu.core.game.protocol.PomeloRequest;
/*     */ import com.wanniu.core.game.protocol.PomeloResponse;
/*     */ import com.wanniu.game.common.msg.ErrorResponse;
/*     */ import com.wanniu.game.data.GameData;
/*     */ import com.wanniu.game.data.KingCO;
/*     */ import com.wanniu.game.revelry.RevelryClass;
/*     */ import com.wanniu.game.revelry.RevelryColumn;
/*     */ import com.wanniu.game.revelry.RevelryManager;
/*     */ import com.wanniu.game.revelry.RevelryToday;
/*     */ import java.io.IOException;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import pomelo.revelry.ActivityRevelryHandler;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @GClientEvent("revelry.activityRevelryHandler.revelryGetColumnRequest")
/*     */ public class RevelryGetColumnHandler
/*     */   extends PomeloRequest
/*     */ {
/*     */   public PomeloResponse request() throws Exception {
/*  35 */     final ActivityRevelryHandler.RevelryGetColumnResponse.Builder result = ActivityRevelryHandler.RevelryGetColumnResponse.newBuilder();
/*     */     
/*  37 */     List<RevelryClass> revelryClassList = RevelryManager.getInstance().getRevelryClassList();
/*  38 */     if (revelryClassList.isEmpty()) {
/*  39 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("PARAM_ERROR"));
/*     */     }
/*     */ 
/*     */     
/*  43 */     for (RevelryClass revelryClass : revelryClassList) {
/*  44 */       ActivityRevelryHandler.RevelryTabInfo.Builder tabInfo = ActivityRevelryHandler.RevelryTabInfo.newBuilder().setName(revelryClass.getName());
/*     */       
/*  46 */       int defaultSeleteIndex = 0;
/*  47 */       long timeleft = 2147483647L;
/*     */       
/*  49 */       for (Map.Entry<String, RevelryToday> e : (Iterable<Map.Entry<String, RevelryToday>>)revelryClass.getTodays().entrySet()) {
/*  50 */         ActivityRevelryHandler.RevelryTodayInfo.Builder todayInfo = ActivityRevelryHandler.RevelryTodayInfo.newBuilder().setName(((RevelryToday)e.getValue()).getName());
/*     */ 
/*     */         
/*  53 */         for (RevelryColumn column : ((RevelryToday)e.getValue()).getColumns()) {
/*  54 */           ActivityRevelryHandler.RevelryColumnInfo.Builder columnInfo = ActivityRevelryHandler.RevelryColumnInfo.newBuilder();
/*  55 */           columnInfo.setId(column.getId());
/*  56 */           columnInfo.setName(column.getName());
/*  57 */           columnInfo.setLabel(column.getLabel());
/*  58 */           columnInfo.setGoto1(column.getGoto1());
/*  59 */           columnInfo.setGoto2(column.getGoto2());
/*  60 */           columnInfo.setTip(column.getTip());
/*  61 */           todayInfo.addColumn(columnInfo);
/*     */         } 
/*     */         
/*  64 */         tabInfo.addToday(todayInfo);
/*  65 */         if (((RevelryToday)e.getValue()).getTimeleft() < timeleft) {
/*  66 */           timeleft = ((RevelryToday)e.getValue()).getTimeleft();
/*  67 */           defaultSeleteIndex = tabInfo.getTodayCount();
/*     */         } 
/*     */       } 
/*     */       
/*  71 */       result.setSelectedIndex(defaultSeleteIndex);
/*  72 */       result.addInfo(tabInfo);
/*     */     } 
/*     */ 
/*     */     
/*  76 */     for (Map.Entry<Integer, KingCO> e : (Iterable<Map.Entry<Integer, KingCO>>)GameData.Kings.entrySet()) {
/*  77 */       if (((KingCO)e.getValue()).isOpen == 0) {
/*     */         continue;
/*     */       }
/*  80 */       KingCO template = e.getValue();
/*  81 */       ActivityRevelryHandler.KingExchange.Builder exchange = ActivityRevelryHandler.KingExchange.newBuilder();
/*  82 */       exchange.setTabId(template.tabID);
/*  83 */       exchange.setTabName(template.tabName);
/*     */       
/*  85 */       exchange.setItem1Code(template.item1code);
/*  86 */       exchange.setItem1Num(template.num1);
/*     */       
/*  88 */       exchange.setItem2Code(template.item2code);
/*  89 */       exchange.setItem2Num(template.num2);
/*     */       
/*  91 */       exchange.setAvatarId(template.avatarId);
/*  92 */       exchange.setTip(template.activityDesc);
/*  93 */       exchange.setShowType(template.showType);
/*     */       
/*  95 */       result.addExchange(exchange);
/*     */     } 
/*     */     
/*  98 */     return new PomeloResponse()
/*     */       {
/*     */         protected void write() throws IOException {
/* 101 */           result.setS2CCode(200);
/* 102 */           this.body.writeBytes(result.build().toByteArray());
/*     */         }
/*     */       };
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\revelry\RevelryGetColumnHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */