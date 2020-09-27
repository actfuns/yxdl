/*     */ package com.wanniu.game.data.base;
/*     */ 
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.util.ClassUtil;
/*     */ import com.wanniu.core.util.StringUtil;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.data.ItemIdConfigCO;
/*     */ import com.wanniu.game.data.ItemTypeConfigCO;
/*     */ import com.wanniu.game.data.ext.ItemIdConfigExt;
/*     */ import com.wanniu.game.data.ext.ItemTypeConfigExt;
/*     */ import com.wanniu.game.item.ItemConfig;
/*     */ import com.wanniu.game.player.AttributeUtil;
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
/*     */ public abstract class DEquipBase
/*     */   extends DItemEquipBase
/*     */ {
/*     */   public int isBothHand;
/*     */   public int space;
/*     */   public int isValid;
/*     */   public int isIdentfied;
/*     */   public int rare;
/*     */   public int tcLevel;
/*     */   public int qLevel;
/*     */   public int upReq;
/*     */   public int meltLevel;
/*     */   public int socksNum;
/*     */   public int canLvUp;
/*     */   public int canUpgrade;
/*     */   public String affixSheet;
/*     */   public String affixCount;
/*     */   public String prop1;
/*     */   public int par1;
/*     */   public int min1;
/*     */   public int max1;
/*     */   public String prop2;
/*     */   public int par2;
/*     */   public int min2;
/*     */   public int max2;
/*     */   public String prop3;
/*     */   public int par3;
/*     */   public int min3;
/*     */   public int max3;
/*     */   public int noMelt;
/*     */   public int wareHouseValue;
/*     */   public int wareHouseCost;
/*     */   public String baseCode;
/*     */   public int rPropCount;
/*     */   public Map<String, Integer> fixedAtts;
/*     */   public String rProp1;
/*     */   public int rPar1;
/*     */   public int rMin1;
/*     */   public int rMax1;
/*     */   public String rProp2;
/*     */   public int rPar2;
/*     */   public int rMin2;
/*     */   public int rMax2;
/*     */   public String rProp3;
/*     */   public int rPar3;
/*     */   public int rMin3;
/*     */   public int rMax3;
/*     */   public String rProp4;
/*     */   public int rPar4;
/*     */   public int rMin4;
/*     */   public int rMax4;
/*     */   public String rProp5;
/*     */   public int rPar5;
/*     */   public int rMin5;
/*     */   public int rMax5;
/*     */   public String rProp6;
/*     */   public int rPar6;
/*     */   public int rMin6;
/*     */   public int rMax6;
/*     */   public int uPar1;
/*     */   public String uProp1;
/*     */   public int uMin1;
/*     */   public int uMax1;
/*     */   public String uProp2;
/*     */   public int uPar2;
/*     */   public int uMin2;
/*     */   public int uMax2;
/*     */   public int suitID;
/*     */   public int starLevel;
/*     */   public int SocksNum;
/*     */   public int itemOrder;
/*     */   public String orderRule;
/*     */   public int orderID;
/*     */   public Map<String, FourProp> baseAtts;
/*     */   public int minAffixCount;
/*     */   public int maxAffixCount;
/*     */   public String waysID;
/*     */   public Map<String, FourProp> uniqueAtts;
/*     */   
/*     */   public void initProperty() {
/* 170 */     initProp();
/*     */   }
/*     */   public void initProp() {
/* 173 */     if (StringUtil.isEmpty(this.type)) {
/* 174 */       Out.error(new Object[] { this.code, " type is nil" });
/*     */       return;
/*     */     } 
/* 177 */     ItemIdConfigExt itemIdConfigExt = ItemConfig.getInstance().getIdConfig(this.type);
/* 178 */     if (itemIdConfigExt != null) {
/* 179 */       this.itemTypeId = ((ItemIdConfigCO)itemIdConfigExt).typeID;
/* 180 */       this.itemOrder = ((ItemIdConfigCO)itemIdConfigExt).order;
/* 181 */       this.orderRule = ((ItemIdConfigCO)itemIdConfigExt).orderRule;
/*     */     } else {
/* 183 */       Out.error(new Object[] { getClass().getName(), " equip no prop in itemIdConfig :", this.type, ", name:", this.name });
/*     */     } 
/*     */ 
/*     */     
/* 187 */     ItemTypeConfigExt itemTypeConfigExt = ItemConfig.getInstance().getTypeConfig(this.type);
/* 188 */     if (itemTypeConfigExt != null) {
/* 189 */       int itemType = Const.ItemType.getV(((ItemTypeConfigCO)itemTypeConfigExt).parentCode);
/* 190 */       if (itemType == 0) {
/* 191 */         Out.error(new Object[] { getClass().getName(), " equip no element in itemType:", ((ItemTypeConfigCO)itemTypeConfigExt).parentCode, ", name:", this.name });
/*     */       }
/*     */       
/* 194 */       this.itemType = itemType;
/* 195 */       this.orderID = ((ItemTypeConfigCO)itemTypeConfigExt).order;
/*     */     } else {
/* 197 */       Out.error(new Object[] { getClass().getName(), " equip no prop in itemTypeConfig :", this.type, ", name:", this.name });
/*     */     } 
/*     */     
/* 200 */     int itemSecondType = Const.ItemSecondType.getV(this.type);
/* 201 */     if (itemSecondType == 0) {
/* 202 */       Out.error(new Object[] { getClass().getName(), " equip no itemSecondType : ", this.type, ", name:", this.name });
/*     */     }
/* 204 */     this.itemSecondType = itemSecondType;
/*     */     
/* 206 */     this.groupCount = 1;
/*     */     
/* 208 */     this.Pro = Const.PlayerPro.Value(this.pro);
/*     */ 
/*     */     
/* 211 */     this.baseAtts = new HashMap<>(); int i;
/* 212 */     for (i = 1; i <= 3; i++) {
/* 213 */       String attrName = "prop" + i;
/* 214 */       String attrPar = "par" + i;
/* 215 */       String attrMin = "min" + i;
/* 216 */       String attrMax = "max" + i;
/* 217 */       String key = null;
/*     */       
/*     */       try {
/* 220 */         if (ClassUtil.getProperty(this, attrName) == null || StringUtil.isEmpty((String)ClassUtil.getProperty(this, attrName))) {
/* 221 */           Out.debug(new Object[] { getClass().getName(), " EquipProp attName is space" });
/*     */         } else {
/*     */           
/* 224 */           key = AttributeUtil.getKeyByName((String)ClassUtil.getProperty(this, attrName));
/* 225 */           if (StringUtil.isNotEmpty(key))
/*     */           
/*     */           { 
/*     */             
/* 229 */             FourProp minMax = new FourProp(key, ((Integer)ClassUtil.getProperty(this, attrPar)).intValue(), ((Integer)ClassUtil.getProperty(this, attrMin)).intValue(), ((Integer)ClassUtil.getProperty(this, attrMax)).intValue());
/* 230 */             this.baseAtts.put(key, minMax); }
/*     */           else
/* 232 */           { Out.error(new Object[] { getClass().getName(), " EquipProp attrName not exist ", attrName }); } 
/*     */         } 
/* 234 */       } catch (Exception e) {
/* 235 */         Out.error(new Object[] { e });
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 240 */     this.uniqueAtts = new HashMap<>();
/* 241 */     for (i = 1; i <= 2; i++) {
/* 242 */       String attrName = "uProp" + i;
/* 243 */       String par = "uPar" + i;
/* 244 */       String minValue = "uMin" + i;
/* 245 */       String maxValue = "uMax" + i;
/*     */       
/*     */       try {
/* 248 */         Object attrNameObj = ClassUtil.getProperty(this, attrName);
/* 249 */         if (attrNameObj != null && !StringUtil.isEmpty((String)attrNameObj))
/*     */         {
/*     */           
/* 252 */           this.uniqueAtts.put(AttributeUtil.getKeyByName((String)attrNameObj), new FourProp(
/* 253 */                 AttributeUtil.getKeyByName((String)attrNameObj), (
/* 254 */                 (Integer)ClassUtil.getProperty(this, par)).intValue(), (
/* 255 */                 (Integer)ClassUtil.getProperty(this, minValue)).intValue(), (
/* 256 */                 (Integer)ClassUtil.getProperty(this, maxValue)).intValue()));
/*     */         }
/* 258 */       } catch (Exception e) {
/* 259 */         Out.error(new Object[] { e });
/*     */       } 
/*     */     } 
/*     */     
/* 263 */     if (StringUtil.isNotEmpty(this.affixCount)) {
/* 264 */       String[] countData = this.affixCount.substring(1, this.affixCount.length() - 1).split(",");
/* 265 */       this.minAffixCount = Integer.parseInt(countData[0]);
/* 266 */       this.maxAffixCount = Integer.parseInt(countData[1]);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\data\base\DEquipBase.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */