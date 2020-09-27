/*     */ package com.wanniu.core.util;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class NumberUtil
/*     */ {
/*     */   public static String inAssignArea(double number, String area) throws NumberFormatException {
/*  26 */     String[] newArea = area.split(";");
/*  27 */     int index = newArea.length;
/*  28 */     String[] name = new String[index];
/*  29 */     double[] hight = new double[index];
/*  30 */     double[] low = new double[index];
/*     */     
/*     */     int i;
/*  33 */     for (i = 0; i < index; i++) {
/*  34 */       int fromIndex = 0;
/*  35 */       int toIndex = newArea[i].indexOf(">");
/*     */       
/*  37 */       hight[i] = Double.parseDouble(newArea[i].substring(fromIndex, toIndex));
/*     */       
/*  39 */       fromIndex = ++toIndex;
/*  40 */       toIndex = newArea[i].lastIndexOf(">");
/*     */       
/*  42 */       name[i] = newArea[i].substring(fromIndex, toIndex);
/*     */       
/*  44 */       fromIndex = newArea[i].indexOf("=", fromIndex) + 1;
/*     */       
/*  46 */       low[i] = Double.parseDouble(newArea[i].substring(fromIndex));
/*     */     } 
/*     */ 
/*     */     
/*  50 */     for (i = 0; i < index; i++) {
/*  51 */       if (number >= low[i] && ((i == 0) ? (number <= hight[i]) : (number < hight[i])))
/*     */       {
/*     */         
/*  54 */         return name[i];
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/*  59 */     return "无";
/*     */   }
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
/*     */   public static String inArea(double number, String area) throws NumberFormatException {
/*  74 */     String[] newArea = area.split(";");
/*  75 */     int index = newArea.length;
/*  76 */     String[] name = new String[index];
/*  77 */     double[] num = new double[index];
/*     */     
/*     */     int i;
/*  80 */     for (i = 0; i < index; i++) {
/*  81 */       int fromIndex = 0;
/*     */       
/*  83 */       boolean flag = (i == index - 1);
/*     */ 
/*     */ 
/*     */       
/*  87 */       int toIndex = flag ? newArea[i].indexOf("<", fromIndex) : newArea[i].indexOf(">", fromIndex);
/*     */       
/*  89 */       name[i] = newArea[i].substring(fromIndex, toIndex);
/*  90 */       fromIndex = ++toIndex;
/*     */       
/*  92 */       num[i] = Double.parseDouble(newArea[i].substring(fromIndex));
/*     */     } 
/*     */ 
/*     */     
/*  96 */     for (i = 0; i < index - 1; i++) {
/*     */ 
/*     */       
/*  99 */       if (num[i] <= number) {
/* 100 */         return name[i];
/*     */       }
/*     */     } 
/*     */     
/* 104 */     if (number < num[index - 1]) {
/* 105 */       return name[index - 1];
/*     */     }
/*     */     
/* 108 */     return "无";
/*     */   }
/*     */   
/*     */   public static Integer createInteger(String str) {
/* 112 */     return Integer.decode(str);
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\cor\\util\NumberUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */