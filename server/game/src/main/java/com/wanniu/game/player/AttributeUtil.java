/*     */ package com.wanniu.game.player;
/*     */ 
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.data.AttributeCO;
/*     */ import com.wanniu.game.data.GameData;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import pomelo.Common;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AttributeUtil
/*     */ {
/*     */   public static String getKeyByName(String name) {
/*  19 */     for (AttributeCO dAttr : GameData.Attributes.values()) {
/*  20 */       if (dAttr.attName.equals(name)) {
/*  21 */         return dAttr.attKey;
/*     */       }
/*     */     } 
/*  24 */     Out.error(new Object[] { name, " is not found:getKeyByName" });
/*  25 */     throw new RuntimeException();
/*     */   }
/*     */   
/*     */   public static String getNameByKey(String key) {
/*  29 */     for (AttributeCO dAttr : GameData.Attributes.values()) {
/*  30 */       if (dAttr.attKey.equals(key)) {
/*  31 */         return dAttr.attName;
/*     */       }
/*     */     } 
/*  34 */     Out.error(new Object[] { key, " is not found:getNameByKey" });
/*  35 */     throw new RuntimeException();
/*     */   }
/*     */   
/*     */   public static AttributeCO find(String key) {
/*  39 */     for (AttributeCO dAttr : GameData.Attributes.values()) {
/*  40 */       if (dAttr.attKey.equals(key)) {
/*  41 */         return dAttr;
/*     */       }
/*     */     } 
/*  44 */     Out.error(new Object[] { key, " is not found:find" });
/*  45 */     throw new RuntimeException();
/*     */   }
/*     */   
/*     */   public static String getDescByKey(String key) {
/*  49 */     for (AttributeCO dAttr : GameData.Attributes.values()) {
/*  50 */       if (dAttr.attKey.equals(key)) {
/*  51 */         return dAttr.attDesc;
/*     */       }
/*     */     } 
/*  54 */     Out.error(new Object[] { key, " is not found:getDescByKey" });
/*  55 */     throw new RuntimeException();
/*     */   }
/*     */   
/*     */   public static int getIdByKey(String key) {
/*  59 */     for (AttributeCO dAttr : GameData.Attributes.values()) {
/*  60 */       if (dAttr.attKey.equals(key)) {
/*  61 */         return dAttr.iD;
/*     */       }
/*     */     } 
/*  64 */     Out.error(new Object[] { key, " is not found:getIdByKey" });
/*  65 */     throw new RuntimeException();
/*     */   }
/*     */   
/*     */   public static int getIdByName(String name) {
/*  69 */     for (AttributeCO dAttr : GameData.Attributes.values()) {
/*  70 */       if (dAttr.attName.equals(name)) {
/*  71 */         return dAttr.iD;
/*     */       }
/*     */     } 
/*  74 */     Out.error(new Object[] { name, " is not found:name" });
/*  75 */     throw new RuntimeException();
/*     */   }
/*     */   
/*     */   public static int getFormatByName(String name) {
/*  79 */     for (AttributeCO dAttr : GameData.Attributes.values()) {
/*  80 */       if (dAttr.attName.equals(name)) {
/*  81 */         return dAttr.isFormat;
/*     */       }
/*     */     } 
/*  84 */     Out.error(new Object[] { name, " is not found:getFormatByName" });
/*  85 */     throw new RuntimeException();
/*     */   }
/*     */   
/*     */   public static AttributeCO getPropByKey(String key) {
/*  89 */     for (AttributeCO dAttr : GameData.Attributes.values()) {
/*  90 */       if (dAttr.attKey.equals(key)) {
/*  91 */         return dAttr;
/*     */       }
/*     */     } 
/*  94 */     Out.error(new Object[] { key, " is not found:getPropByKey" });
/*  95 */     throw new RuntimeException();
/*     */   }
/*     */   
/*     */   public static AttributeCO getPropByName(String name) {
/*  99 */     for (AttributeCO dAttr : GameData.Attributes.values()) {
/* 100 */       if (dAttr.attName.equals(name)) {
/* 101 */         return dAttr;
/*     */       }
/*     */     } 
/* 104 */     Out.error(new Object[] { name, " is not found:getPropByName" });
/* 105 */     throw new RuntimeException();
/*     */   }
/*     */   
/*     */   public static int getFormatByKey(String key) {
/* 109 */     for (AttributeCO dAttr : GameData.Attributes.values()) {
/* 110 */       if (dAttr.attKey.equals(key)) {
/* 111 */         return dAttr.isFormat;
/*     */       }
/*     */     } 
/* 114 */     Out.error(new Object[] { key, " is not found:getFormatByKey" });
/* 115 */     throw new RuntimeException();
/*     */   }
/*     */   
/*     */   public static List<Common.AttributeSimple> getAttributeSimple(Map<String, Integer> attrs) {
/* 119 */     List<Common.AttributeSimple> data = new ArrayList<>();
/* 120 */     for (String key : attrs.keySet()) {
/* 121 */       for (AttributeCO da : GameData.Attributes.values()) {
/* 122 */         if (da.attKey.equals(key)) {
/* 123 */           Common.AttributeSimple.Builder as = Common.AttributeSimple.newBuilder();
/* 124 */           as.setId(da.iD);
/* 125 */           as.setValue(((Integer)attrs.get(key)).intValue());
/* 126 */           data.add(as.build());
/*     */         } 
/*     */       } 
/*     */     } 
/* 130 */     return data;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static List<Common.AttributeBase> getAttributeBase(Map<String, Integer> attrs) {
/* 150 */     ArrayList<Common.AttributeBase> data = new ArrayList<>();
/* 151 */     for (Map.Entry<String, Integer> node : attrs.entrySet()) {
/* 152 */       for (AttributeCO dAttr : GameData.Attributes.values()) {
/* 153 */         if (dAttr.attKey.equals(node.getKey())) {
/* 154 */           Common.AttributeBase.Builder builder = Common.AttributeBase.newBuilder();
/* 155 */           builder.setId(dAttr.iD);
/* 156 */           builder.setValue(((Integer)node.getValue()).intValue());
/* 157 */           builder.setIsFormat(dAttr.isFormat);
/* 158 */           data.add(builder.build());
/*     */         } 
/*     */       } 
/*     */     } 
/* 162 */     return data;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static List<Common.AttributeBase> getAttributeBaseByArray(List<Map<String, Integer>> attrArray) {
/* 171 */     List<Common.AttributeBase> data = new ArrayList<>();
/* 172 */     for (int i = 0; i < attrArray.size(); i++) {
/* 173 */       Map<String, Integer> attrs = attrArray.get(i);
/* 174 */       for (String key : attrs.keySet()) {
/* 175 */         AttributeCO prop = find(key);
/* 176 */         if (null != prop) {
/* 177 */           Common.AttributeBase.Builder attrBase = Common.AttributeBase.newBuilder();
/* 178 */           attrBase.setId(prop.iD);
/* 179 */           attrBase.setValue(((Integer)attrs.get(key)).intValue());
/* 180 */           attrBase.setIsFormat(prop.isFormat);
/* 181 */           data.add(attrBase.build());
/*     */         } 
/*     */       } 
/*     */     } 
/* 185 */     return data;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static List<Common.AttributeBase> getAttributeWithNext(Map<String, Integer> attrs, Map<String, Integer> nextAttrs) {
/* 196 */     List<Common.AttributeBase> data = new ArrayList<>();
/* 197 */     Iterator<String> nextKeys = nextAttrs.keySet().iterator();
/* 198 */     while (nextKeys.hasNext()) {
/* 199 */       String nextkey = nextKeys.next();
/* 200 */       AttributeCO prop = getPropByKey(nextkey);
/* 201 */       if (prop != null) {
/* 202 */         Common.AttributeBase.Builder ab = Common.AttributeBase.newBuilder();
/* 203 */         if (attrs.get(nextkey) != null && ((Integer)attrs.get(nextkey)).intValue() > 0) {
/* 204 */           ab.setId(prop.iD);
/* 205 */           ab.setValue(((Integer)attrs.get(nextkey)).intValue());
/* 206 */           ab.setNextValue(((Integer)nextAttrs.get(nextkey)).intValue());
/* 207 */           ab.setIsFormat(prop.isFormat);
/*     */ 
/*     */         
/*     */         }
/*     */         else {
/*     */ 
/*     */           
/* 214 */           ab.setId(prop.iD);
/* 215 */           ab.setValue(0);
/* 216 */           ab.setNextValue(((Integer)nextAttrs.get(nextkey)).intValue());
/* 217 */           ab.setIsFormat(prop.isFormat);
/*     */         } 
/* 219 */         data.add(ab.build());
/*     */       } 
/*     */     } 
/*     */     
/* 223 */     return data;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ArrayList<Common.AttributeBase> getAttributeBaseWithParam1(Map<String, Integer> attrs, Map<String, Integer> param1Attrs) {
/* 234 */     ArrayList<Common.AttributeBase> data = new ArrayList<>();
/* 235 */     for (Map.Entry<String, Integer> node : attrs.entrySet()) {
/* 236 */       String key = node.getKey();
/* 237 */       AttributeCO prop = find(key);
/* 238 */       if (!param1Attrs.containsKey(key)) {
/* 239 */         param1Attrs.put(key, Integer.valueOf(0));
/*     */       }
/* 241 */       Common.AttributeBase.Builder builder = Common.AttributeBase.newBuilder();
/* 242 */       builder.setId(prop.iD);
/* 243 */       builder.setValue(((Integer)node.getValue()).intValue());
/* 244 */       builder.setParam1(((Integer)param1Attrs.get(key)).intValue());
/* 245 */       builder.setIsFormat(prop.isFormat);
/* 246 */       data.add(builder.build());
/*     */     } 
/* 248 */     return data;
/*     */   }
/*     */   
/*     */   public static float getScoreRatioByKey(String key) {
/* 252 */     for (AttributeCO dAttr : GameData.Attributes.values()) {
/* 253 */       if (dAttr.attKey.equals(key)) {
/* 254 */         if (dAttr.isEffect == 1) {
/* 255 */           return dAttr.scoreRatio;
/*     */         }
/* 257 */         return 0.0F;
/*     */       } 
/*     */     } 
/*     */     
/* 261 */     Out.error(new Object[] { key, " is not found:getScoreRatioByKey" });
/* 262 */     throw new RuntimeException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void addData2AllData(Map<Const.PlayerBtlData, Integer> src, Map<Const.PlayerBtlData, Integer> dest) {
/* 272 */     for (Const.PlayerBtlData key : src.keySet()) {
/* 273 */       if (dest.containsKey(key)) {
/* 274 */         int value = ((Integer)dest.get(key)).intValue() + ((Integer)src.get(key)).intValue();
/* 275 */         dest.put(key, Integer.valueOf(value)); continue;
/*     */       } 
/* 277 */       dest.put(key, src.get(key));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void addData2AllDataByKey(Map<String, Integer> src, Map<Const.PlayerBtlData, Integer> dest) {
/* 289 */     for (String key : src.keySet()) {
/* 290 */       Const.PlayerBtlData btlData = Const.PlayerBtlData.getEByKey(key);
/* 291 */       if (btlData == null) {
/* 292 */         Out.error(new Object[] { "找不到装备对应的属性：", key });
/*     */         continue;
/*     */       } 
/* 295 */       if (dest.containsKey(btlData)) {
/* 296 */         int value = ((Integer)dest.get(btlData)).intValue() + ((Integer)src.get(key)).intValue();
/* 297 */         dest.put(btlData, Integer.valueOf(value)); continue;
/*     */       } 
/* 299 */       dest.put(btlData, src.get(key));
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\player\AttributeUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */