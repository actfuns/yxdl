/*     */ package com.wanniu.game.functionOpen;
/*     */ 
/*     */ import com.wanniu.game.data.GameData;
/*     */ import com.wanniu.game.data.OpenLvCO;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ public class FunctionOpenUtil
/*     */ {
/*     */   public static List<OpenLvCO> getPropList() {
/*  13 */     List<OpenLvCO> list = new ArrayList<>();
/*  14 */     for (Map.Entry<Integer, OpenLvCO> node : (Iterable<Map.Entry<Integer, OpenLvCO>>)GameData.OpenLvs.entrySet()) {
/*  15 */       list.add(node.getValue());
/*     */     }
/*  17 */     return list;
/*     */   }
/*     */   
/*     */   public static List<OpenLvCO> findFunctionOpenPropsByIsReq(int isReq) {
/*  21 */     List<OpenLvCO> props = new ArrayList<>();
/*  22 */     for (Map.Entry<Integer, OpenLvCO> node : (Iterable<Map.Entry<Integer, OpenLvCO>>)GameData.OpenLvs.entrySet()) {
/*  23 */       OpenLvCO data = node.getValue();
/*  24 */       if (data.isReq == isReq) {
/*  25 */         props.add(data);
/*     */       }
/*     */     } 
/*  28 */     return props;
/*     */   }
/*     */   
/*     */   public static List<OpenLvCO> findFunctionOpenPropsByIsReqAndOpenReq(int isReq, String openReq) {
/*  32 */     List<OpenLvCO> props = new ArrayList<>();
/*  33 */     for (Map.Entry<Integer, OpenLvCO> node : (Iterable<Map.Entry<Integer, OpenLvCO>>)GameData.OpenLvs.entrySet()) {
/*  34 */       OpenLvCO each = node.getValue();
/*  35 */       if (each.isReq == isReq && each.openReq.equals(openReq)) {
/*  36 */         props.add(each);
/*     */       }
/*     */     } 
/*  39 */     return props;
/*     */   }
/*     */ 
/*     */   
/*     */   public static List<OpenLvCO> getPropListByReqEvent(int reqType, String reqEvent) {
/*  44 */     if (reqEvent == null)
/*     */     {
/*  46 */       return findFunctionOpenPropsByIsReq(reqType);
/*     */     }
/*     */ 
/*     */     
/*  50 */     return findFunctionOpenPropsByIsReqAndOpenReq(reqType, reqEvent);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static List<OpenLvCO> getPropListByReqTypeArray(List<Integer> reqTypeArray) {
/*  56 */     List<OpenLvCO> props = new ArrayList<>();
/*  57 */     for (Map.Entry<Integer, OpenLvCO> node : (Iterable<Map.Entry<Integer, OpenLvCO>>)GameData.OpenLvs.entrySet()) {
/*  58 */       OpenLvCO each = node.getValue();
/*  59 */       if (reqTypeArray.indexOf(Integer.valueOf(each.isReq)) != -1) {
/*  60 */         props.add(each);
/*     */       }
/*     */     } 
/*  63 */     return props;
/*     */   }
/*     */ 
/*     */   
/*     */   public static List<OpenLvCO> getPropListByIdArray(ArrayList<Integer> idArray) {
/*  68 */     List<OpenLvCO> props = new ArrayList<>();
/*  69 */     for (Map.Entry<Integer, OpenLvCO> node : (Iterable<Map.Entry<Integer, OpenLvCO>>)GameData.OpenLvs.entrySet()) {
/*  70 */       OpenLvCO each = node.getValue();
/*  71 */       if (idArray.indexOf(Integer.valueOf(each.iD)) != -1) {
/*  72 */         props.add(each);
/*     */       }
/*     */     } 
/*  75 */     return props;
/*     */   }
/*     */   
/*     */   public static List<OpenLvCO> getPropListByFunctionNameArray(List<String> nameArray) {
/*  79 */     List<OpenLvCO> props = new ArrayList<>();
/*  80 */     for (Map.Entry<Integer, OpenLvCO> node : (Iterable<Map.Entry<Integer, OpenLvCO>>)GameData.OpenLvs.entrySet()) {
/*  81 */       OpenLvCO each = node.getValue();
/*  82 */       if (nameArray.indexOf(each.fun) != -1) {
/*  83 */         props.add(each);
/*     */       }
/*     */     } 
/*  86 */     return props;
/*     */   }
/*     */   
/*     */   public static OpenLvCO getPropById(int funcId) {
/*  90 */     return (OpenLvCO)GameData.OpenLvs.get(Integer.valueOf(funcId));
/*     */   }
/*     */   
/*     */   public static OpenLvCO findFunctionOpenPropsByFuncName(String funcName) {
/*  94 */     for (Map.Entry<Integer, OpenLvCO> node : (Iterable<Map.Entry<Integer, OpenLvCO>>)GameData.OpenLvs.entrySet()) {
/*  95 */       OpenLvCO each = node.getValue();
/*  96 */       if (each.fun.equals(funcName)) {
/*  97 */         return each;
/*     */       }
/*     */     } 
/* 100 */     return null;
/*     */   }
/*     */   
/*     */   public static OpenLvCO getPropByName(String funcName) {
/* 104 */     return findFunctionOpenPropsByFuncName(funcName);
/*     */   }
/*     */   
/*     */   public static String getTipsByName(String funcName) {
/* 108 */     OpenLvCO prop = getPropByName(funcName);
/* 109 */     if (prop != null) {
/* 110 */       return prop.tips;
/*     */     }
/* 112 */     return "";
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean isDefaultOpen(String funcName) {
/* 117 */     int state = getDefaultOpenState(funcName);
/* 118 */     return (state == 1);
/*     */   }
/*     */   
/*     */   public static boolean isDefaultClose(String funcName) {
/* 122 */     int state = getDefaultOpenState(funcName);
/* 123 */     return (state == -1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getDefaultOpenState(String funcName) {
/* 133 */     OpenLvCO prop = getPropByName(funcName);
/* 134 */     if (prop == null) {
/* 135 */       return 1;
/*     */     }
/* 137 */     if (prop.isOpen == 0) {
/* 138 */       return -1;
/*     */     }
/* 140 */     if (prop.type == 0) {
/* 141 */       return 1;
/*     */     }
/* 143 */     return 0;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\functionOpen\FunctionOpenUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */