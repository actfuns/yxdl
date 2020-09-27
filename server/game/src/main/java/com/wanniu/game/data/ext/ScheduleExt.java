/*    */ package com.wanniu.game.data.ext;
/*    */ 
/*    */ import com.wanniu.core.util.StringUtil;
/*    */ import com.wanniu.game.data.ScheduleCO;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ public class ScheduleExt
/*    */   extends ScheduleCO {
/*    */   public List<String> mapIDArray;
/*    */   public List<String> targetArray;
/*    */   public List<Integer> weekArray;
/*    */   public List<TimeCond> timeArray;
/*    */   public List<TimeCond> periodInCalendarArray;
/*    */   
/*    */   public void initArray(List<String> arr, String str, boolean isWeek) {
/* 17 */     if (StringUtil.isEmpty(str)) {
/*    */       return;
/*    */     }
/*    */     
/* 21 */     if (isWeek && 
/* 22 */       str.equals("0")) {
/*    */       return;
/*    */     }
/*    */ 
/*    */     
/* 27 */     String[] tempData = str.split(";");
/*    */     
/* 29 */     for (int i = 0; i < tempData.length; i++)
/*    */     {
/* 31 */       arr.add(tempData[i]);
/*    */     }
/*    */   }
/*    */   
/*    */   public void initTime(List<TimeCond> arr, String str) {
/* 36 */     if (StringUtil.isEmpty(str) || "0" == str) {
/*    */       return;
/*    */     }
/* 39 */     String[] timeStr = str.split(";");
/* 40 */     for (int i = 0; i < timeStr.length; i++) {
/* 41 */       String elemStr = timeStr[i];
/* 42 */       if (!StringUtil.isEmpty(elemStr)) {
/*    */ 
/*    */ 
/*    */         
/* 46 */         String[] tmp = elemStr.split("-");
/*    */         
/* 48 */         if (tmp.length == 2) {
/*    */ 
/*    */ 
/*    */           
/* 52 */           TimeCond timeCond = new TimeCond();
/* 53 */           timeCond.beginTime = tmp[0];
/* 54 */           timeCond.endTime = tmp[1];
/* 55 */           arr.add(timeCond);
/*    */         } 
/*    */       } 
/*    */     } 
/*    */   }
/*    */   public void initProperty() {
/* 61 */     this.mapIDArray = new ArrayList<>();
/* 62 */     this.targetArray = new ArrayList<>();
/* 63 */     this.weekArray = new ArrayList<>();
/* 64 */     this.timeArray = new ArrayList<>();
/* 65 */     this.periodInCalendarArray = new ArrayList<>();
/*    */ 
/*    */     
/* 68 */     initArray(this.mapIDArray, this.mapID, false);
/* 69 */     initArray(this.targetArray, this.target, false);
/* 70 */     List<String> tmpWeek = new ArrayList<>();
/* 71 */     initArray(tmpWeek, this.openday, true);
/*    */     
/* 73 */     for (int i = 0; i < tmpWeek.size(); i++) {
/* 74 */       this.weekArray.add(Integer.valueOf(Integer.parseInt(tmpWeek.get(i))));
/*    */     }
/*    */     
/* 77 */     initTime(this.timeArray, this.openPeriod);
/* 78 */     initTime(this.periodInCalendarArray, this.periodInCalendar);
/*    */   }
/*    */   
/*    */   public static class TimeCond {
/*    */     public String beginTime;
/*    */     public String endTime;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\data\ext\ScheduleExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */