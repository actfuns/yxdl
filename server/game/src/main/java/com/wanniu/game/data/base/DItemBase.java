/*     */ package com.wanniu.game.data.base;
/*     */ 
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.data.ext.ItemIdConfigExt;
/*     */ import com.wanniu.game.data.ext.ItemTypeConfigExt;
/*     */ import com.wanniu.game.item.ItemConfig;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class DItemBase
/*     */   extends DItemEquipBase
/*     */ {
/*     */   public String tips;
/*     */   public String ways;
/*     */   public int useCD;
/*     */   public String prop;
/*     */   public int par;
/*     */   public int min;
/*     */   public int max;
/*     */   public String smallIcon;
/*     */   public int destID;
/*     */   public int isApply;
/*     */   public int isApplyNow;
/*     */   public String applyTips;
/*     */   public String waysID;
/*     */   public int itemOrder;
/*     */   public String orderRule;
/*     */   public int orderID;
/*     */   public int minAffixCount;
/*     */   public int maxAffixCount;
/*     */   public Map<Integer, String> chestTC;
/*     */   public int redPoint;
/*     */   
/*     */   public void initProperty() {
/*  65 */     ItemIdConfigExt itemIdConfigProp = ItemConfig.getInstance().getIdConfig(this.type);
/*  66 */     if (itemIdConfigProp != null) {
/*  67 */       this.itemTypeId = itemIdConfigProp.typeID;
/*  68 */       this.itemOrder = itemIdConfigProp.order;
/*  69 */       this.orderRule = itemIdConfigProp.orderRule;
/*     */     } else {
/*  71 */       Out.error(new Object[] { getClass().getName(), " item no prop in itemIdConfig :", this.type, ", name:", this.name });
/*     */     } 
/*     */     
/*  74 */     ItemTypeConfigExt itemTypeConfigProp = ItemConfig.getInstance().getTypeConfig(this.type);
/*  75 */     if (itemTypeConfigProp != null) {
/*  76 */       int itemType = Const.ItemType.getV(itemTypeConfigProp.parentCode);
/*  77 */       if (itemType == 0) {
/*  78 */         Out.error(new Object[] { getClass().getName(), " item no element in itemType:", itemTypeConfigProp.parentCode, ", name:", this.name });
/*     */       }
/*     */       
/*  81 */       this.itemType = itemType;
/*  82 */       this.orderID = itemTypeConfigProp.order;
/*     */     } else {
/*  84 */       Out.error(new Object[] { getClass().getName(), " item no prop in itemTypeConfig :", this.type, ", name:", this.name });
/*     */     } 
/*     */ 
/*     */     
/*  88 */     int itemSecondType = Const.ItemSecondType.getV(this.type);
/*  89 */     if (itemSecondType == 0) {
/*  90 */       Out.error(new Object[] { getClass().getName(), " item no itemSecondType : ", this.type, ", name:", this.name });
/*     */     }
/*  92 */     this.itemSecondType = itemSecondType;
/*     */     
/*  94 */     if (this.itemType == Const.ItemType.Chest.getValue()) {
/*  95 */       this.chestTC = new HashMap<>();
/*  96 */       if (this.prop.indexOf(":") != -1)
/*  97 */       { String[] tcs = this.prop.split(";");
/*  98 */         for (String str : tcs) {
/*  99 */           String[] proTC = str.split(":");
/* 100 */           if (proTC.length != 0) {
/*     */ 
/*     */             
/* 103 */             int pro = Integer.parseInt(proTC[0]);
/* 104 */             String tc = proTC[1];
/* 105 */             if (pro == 0) {
/* 106 */               this.chestTC.put(Integer.valueOf(1), tc);
/* 107 */               this.chestTC.put(Integer.valueOf(2), tc);
/* 108 */               this.chestTC.put(Integer.valueOf(3), tc);
/* 109 */               this.chestTC.put(Integer.valueOf(4), tc);
/* 110 */               this.chestTC.put(Integer.valueOf(5), tc);
/*     */             } else {
/* 112 */               this.chestTC.put(Integer.valueOf(pro), tc);
/*     */             } 
/*     */           } 
/*     */         }  }
/* 116 */       else { this.chestTC.put(Integer.valueOf(1), this.prop);
/* 117 */         this.chestTC.put(Integer.valueOf(2), this.prop);
/* 118 */         this.chestTC.put(Integer.valueOf(3), this.prop);
/* 119 */         this.chestTC.put(Integer.valueOf(4), this.prop);
/* 120 */         this.chestTC.put(Integer.valueOf(5), this.prop); }
/*     */     
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String getKey() {
/* 127 */     return this.code;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\data\base\DItemBase.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */