/*     */ package com.wanniu.game.data.ext;
/*     */ 
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.util.ClassUtil;
/*     */ import com.wanniu.core.util.StringUtil;
/*     */ import com.wanniu.game.common.Utils;
/*     */ import com.wanniu.game.data.SkillValueCO;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SkillValueExt
/*     */   extends SkillValueCO
/*     */ {
/*     */   public Map<String, Integer> costManaSetData;
/*     */   public Map<String, Integer> exdDmgSetData;
/*     */   public Map<Integer, Integer> BuffTimeData;
/*     */   public Map<String, SkillValueSetData> valueSetData;
/*     */   
/*     */   public static class SkillValueSetData
/*     */   {
/*     */     public String valueName;
/*  24 */     public Map<String, Integer> valueSet = new HashMap<>();
/*     */     
/*     */     public int valueAttribute;
/*     */   }
/*     */ 
/*     */   
/*     */   public void initProperty() {
/*  31 */     String costManaSetStr = this.costManaSet;
/*     */     
/*  33 */     this.costManaSetData = new HashMap<>();
/*  34 */     if (StringUtil.isNotEmpty(costManaSetStr)) {
/*  35 */       String[] a_costManaSetStr = costManaSetStr.split(";");
/*  36 */       int len = a_costManaSetStr.length;
/*  37 */       for (int i = 0; i < len; i++) {
/*  38 */         String str = a_costManaSetStr[i];
/*  39 */         String[] a_str = str.split(":");
/*  40 */         if (a_str != null && a_str.length >= 2) {
/*  41 */           this.costManaSetData.put(a_str[0], Integer.valueOf(Integer.parseInt(a_str[1])));
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  46 */     String exdDmgSetStr = this.exdDmgSet;
/*  47 */     this.exdDmgSetData = new HashMap<>();
/*  48 */     if (StringUtil.isNotEmpty(exdDmgSetStr)) {
/*  49 */       String[] a_exdDmgSetStr = exdDmgSetStr.split(";");
/*  50 */       int len = a_exdDmgSetStr.length;
/*  51 */       for (int i = 0; i < len; i++) {
/*  52 */         String str = a_exdDmgSetStr[i];
/*  53 */         String[] a_str = str.split(":");
/*  54 */         if (a_str != null && a_str.length >= 2) {
/*  55 */           this.exdDmgSetData.put(a_str[0], Integer.valueOf(Integer.parseInt(a_str[1])));
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  60 */     String BuffTimeStr = this.buffTime;
/*  61 */     this.BuffTimeData = new HashMap<>();
/*  62 */     if (StringUtil.isNotEmpty(BuffTimeStr)) {
/*  63 */       String[] BuffTimeArray = BuffTimeStr.split(";");
/*  64 */       for (int i = 0; i < BuffTimeArray.length; i++) {
/*  65 */         String str = BuffTimeArray[i];
/*  66 */         String[] a_str = str.split(":");
/*  67 */         if (a_str != null && a_str.length >= 2) {
/*  68 */           this.BuffTimeData.put(Integer.valueOf(Integer.parseInt(a_str[0])), Integer.valueOf(Integer.parseInt(a_str[1])));
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*     */     try {
/*  74 */       this.valueSetData = new HashMap<>();
/*  75 */       String valueSetStr4 = null;
/*  76 */       Object vss = null;
/*  77 */       for (int j = 1; j < 3; j++) {
/*  78 */         if (j == 1) {
/*  79 */           vss = ClassUtil.getProperty(this, "valueSet");
/*     */         } else {
/*  81 */           vss = ClassUtil.getProperty(this, "valueSet" + j);
/*     */         } 
/*  83 */         if (vss != null) {
/*     */ 
/*     */           
/*  86 */           valueSetStr4 = (String)vss;
/*  87 */           Map<String, Integer> valueSetData4 = new HashMap<>();
/*  88 */           if (StringUtil.isNotEmpty(valueSetStr4))
/*     */           
/*  90 */           { String[] a_valueSetStr4 = valueSetStr4.split(";");
/*  91 */             int len4 = a_valueSetStr4.length;
/*  92 */             for (int i = 0; i < len4; i++) {
/*  93 */               String str4 = a_valueSetStr4[i];
/*  94 */               String[] a_str4 = str4.split(":");
/*  95 */               if (a_str4 != null && a_str4.length >= 2) {
/*     */                 
/*  97 */                 String value = a_str4[1];
/*  98 */                 int _value = 0;
/*  99 */                 String[] tmp = value.split("-");
/*     */                 
/* 101 */                 if (tmp.length > 1) {
/*     */                   
/* 103 */                   _value = Utils.random(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]));
/*     */                 } else {
/* 105 */                   _value = Integer.parseInt(value);
/*     */                 } 
/*     */                 
/* 108 */                 valueSetData4.put(a_str4[0], Integer.valueOf(_value));
/*     */               } 
/*     */             } 
/* 111 */             String keystring = "valueSetData" + j;
/* 112 */             SkillValueSetData data = new SkillValueSetData();
/* 113 */             data.valueName = (String)ClassUtil.getProperty(this, "valueAttributeName" + j);
/* 114 */             data.valueSet = valueSetData4;
/* 115 */             data.valueAttribute = ((Integer)ClassUtil.getProperty(this, "valueAttribute" + j)).intValue();
/* 116 */             this.valueSetData.put(keystring, data); } 
/*     */         } 
/*     */       } 
/* 119 */     } catch (Exception e) {
/* 120 */       Out.error(new Object[] { e });
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\data\ext\SkillValueExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */