/*     */ package com.wanniu.game.data.ext;
/*     */ 
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.util.ClassUtil;
/*     */ import com.wanniu.core.util.StringUtil;
/*     */ import com.wanniu.game.data.TreasureClassCO;
/*     */ import com.wanniu.game.item.data.tc.TCItemData;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TreasureClassExt
/*     */   extends TreasureClassCO
/*     */ {
/*     */   public List<TCItemData> items;
/*     */   
/*     */   public void initProperty() {
/*  43 */     this.items = new ArrayList<>();
/*  44 */     for (int i = 1; i <= 20; i++) {
/*  45 */       Object _item = null;
/*  46 */       Object _rare = null;
/*     */       try {
/*  48 */         _item = ClassUtil.getProperty(this, "item" + i);
/*  49 */         _rare = ClassUtil.getProperty(this, "prob" + i);
/*  50 */       } catch (Exception e) {
/*  51 */         Out.error(new Object[] { e });
/*     */       } 
/*  53 */       String item = null;
/*  54 */       int rare = 0;
/*  55 */       if (_item != null) {
/*  56 */         item = _item.toString();
/*  57 */         if (item.trim().length() != 0) {
/*     */           
/*  59 */           rare = ((Integer)_rare).intValue();
/*     */           
/*  61 */           String[] itemData = item.split("#");
/*  62 */           String itemCode = itemData[0];
/*  63 */           int num = 1;
/*  64 */           List<Integer> expandParas = new ArrayList<>();
/*  65 */           if (itemData.length > 1) {
/*     */             
/*  67 */             if (StringUtil.isNotEmpty(itemData[1])) {
/*  68 */               String[] expandParaStrs = itemData[1].split(",");
/*  69 */               for (String expandParaStr : expandParaStrs) {
/*  70 */                 expandParas.add(Integer.valueOf(Integer.parseInt(expandParaStr.replace("{", "").replace("}", ""))));
/*     */               }
/*     */             } 
/*  73 */             if (itemData[1].substring(0, 1).equals("{")) {
/*  74 */               String[] numData = itemData[1].substring(1, itemData[1].length() - 1).split(",");
/*  75 */               int minNum = Integer.parseInt(numData[0]);
/*  76 */               int maxNum = Integer.parseInt(numData[1]);
/*     */               
/*  78 */               TCItemData tc = new TCItemData();
/*  79 */               tc.tcType = 2;
/*  80 */               tc.code = itemCode;
/*  81 */               tc.minNum = minNum;
/*  82 */               tc.maxNum = maxNum;
/*  83 */               tc.rare = rare;
/*  84 */               tc.expandParas = expandParas;
/*  85 */               this.items.add(tc);
/*     */             } else {
/*  87 */               num = Integer.parseInt(itemData[1]);
/*  88 */               TCItemData tc = new TCItemData();
/*  89 */               tc.tcType = 2;
/*  90 */               tc.code = itemCode;
/*  91 */               tc.num = num;
/*  92 */               tc.rare = rare;
/*  93 */               tc.expandParas = expandParas;
/*  94 */               this.items.add(tc);
/*     */             } 
/*     */           } else {
/*     */             
/*  98 */             TCItemData tc = new TCItemData();
/*  99 */             Matcher matcher_tc = Pattern.compile("^[0-9A-Z]").matcher(itemCode);
/* 100 */             Matcher matcher_item = Pattern.compile("^[a-z]").matcher(itemCode);
/* 101 */             if (matcher_tc.find()) {
/* 102 */               tc.tcType = 3;
/* 103 */             } else if (matcher_item.find()) {
/* 104 */               tc.tcType = 2;
/*     */             } else {
/* 106 */               tc.tcType = 1;
/*     */             } 
/*     */             
/* 109 */             tc.code = itemCode;
/* 110 */             tc.num = num;
/* 111 */             tc.rare = rare;
/* 112 */             tc.expandParas = expandParas;
/* 113 */             this.items.add(tc);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public String getKey() {
/* 121 */     return this.tcCode;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\data\ext\TreasureClassExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */