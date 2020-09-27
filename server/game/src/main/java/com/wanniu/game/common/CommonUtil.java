/*     */ package com.wanniu.game.common;
/*     */ 
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.util.StringUtil;
/*     */ import com.wanniu.game.bag.WNBag;
/*     */ import com.wanniu.game.common.msg.MessageUtil;
/*     */ import com.wanniu.game.data.GameData;
/*     */ import com.wanniu.game.data.base.FourProp;
/*     */ import com.wanniu.game.data.ext.AffixExt;
/*     */ import com.wanniu.game.data.ext.AttributeExt;
/*     */ import com.wanniu.game.data.ext.BaseDataExt;
/*     */ import com.wanniu.game.data.ext.CharacterExt;
/*     */ import com.wanniu.game.message.MessageData;
/*     */ import com.wanniu.game.util.BlackWordUtil;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import pomelo.Common;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CommonUtil
/*     */ {
/*     */   public static Common.PropertyStruct.Builder transferDataType(String key, Object value) {
/*  30 */     Common.PropertyStruct.Builder data = Common.PropertyStruct.newBuilder();
/*  31 */     data.setKey(key);
/*  32 */     data.setValue(String.valueOf(value));
/*     */     
/*  34 */     if (value instanceof Integer) {
/*  35 */       data.setType(1);
/*     */     } else {
/*  37 */       data.setType(2);
/*     */     } 
/*  39 */     return data;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int calFightPower(Map<Const.PlayerBtlData, Integer> allInflus) {
/*  46 */     float fightPower = 0.0F;
/*  47 */     Map<Integer, AttributeExt> map = GameData.Attributes;
/*  48 */     for (AttributeExt att : map.values()) {
/*  49 */       if (att.isEffect == 1 && 
/*  50 */         allInflus.containsKey(att.btlProp)) {
/*  51 */         int value = ((Integer)allInflus.get(att.btlProp)).intValue();
/*  52 */         if (value > 0)
/*     */         {
/*  54 */           fightPower += Math.abs(value) * att.scoreRatio;
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  60 */     return (int)fightPower;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int calPlayerFightPower(Map<Const.PlayerBtlData, Integer> allInflus, int pro) {
/*  67 */     float fightPower = 0.0F;
/*  68 */     Map<Integer, AttributeExt> map = GameData.Attributes;
/*  69 */     for (AttributeExt att : map.values()) {
/*  70 */       if (att.isEffect == 1) {
/*  71 */         if (att.btlProp == null) {
/*  72 */           Out.error(new Object[] { "calPlayerFightPower :: ", att.attName });
/*     */           continue;
/*     */         } 
/*  75 */         if (allInflus.containsKey(att.btlProp)) {
/*  76 */           int value = ((Integer)allInflus.get(att.btlProp)).intValue();
/*  77 */           if (att.btlProp == Const.PlayerBtlData.CritDamage) {
/*  78 */             value -= ((CharacterExt)GameData.Characters.get(Integer.valueOf(pro))).critDamage;
/*     */           }
/*  80 */           fightPower += Math.abs(value) * att.scoreRatio;
/*     */         } 
/*     */       } 
/*     */     } 
/*  84 */     return (int)fightPower;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int calOneAttributeFightScroreByStr(String key, int value) {
/*  94 */     Const.PlayerBtlData data = Const.PlayerBtlData.valueOf(key);
/*  95 */     if (data == null) {
/*  96 */       Out.warn(new Object[] { "发现属性不存在2:", key });
/*  97 */       return 0;
/*     */     } 
/*  99 */     AttributeExt att = (AttributeExt)GameData.Attributes.get(Integer.valueOf(data.id));
/* 100 */     if (att == null) {
/* 101 */       Out.warn(new Object[] { "发现属性不存在1:", key });
/* 102 */       return 0;
/*     */     } 
/* 104 */     return (int)(Math.abs(value) * att.scoreRatio);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int calOneAttributeFightScroreById(int key, int value, int qColor) {
/* 114 */     AffixExt affix = (AffixExt)GameData.Affixs.get(Integer.valueOf(key));
/* 115 */     if (affix == null) {
/* 116 */       Out.warn(new Object[] { "发现属性不存在3:", Integer.valueOf(key) });
/* 117 */       return 0;
/*     */     } 
/* 119 */     FourProp pair = (FourProp)affix.props.get(Integer.valueOf(qColor));
/* 120 */     if (pair == null) {
/* 121 */       Out.warn(new Object[] { "发现属性不存在4:", Integer.valueOf(key), ",", Integer.valueOf(qColor) });
/* 122 */       return 0;
/*     */     } 
/* 124 */     return calOneAttributeFightScroreByStr(pair.prop, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int calPetFightPower(Map<Const.PlayerBtlData, Integer> allInflus, int petId) {
/* 131 */     float fightPower = 0.0F;
/* 132 */     Map<Integer, AttributeExt> map = GameData.Attributes;
/* 133 */     for (AttributeExt att : map.values()) {
/* 134 */       if (att.isEffect == 1 && 
/* 135 */         allInflus.containsKey(att.btlProp)) {
/* 136 */         int value = ((Integer)allInflus.get(att.btlProp)).intValue();
/* 137 */         if (att.btlProp == Const.PlayerBtlData.CritDamage) {
/* 138 */           value -= ((BaseDataExt)GameData.BaseDatas.get(Integer.valueOf(petId))).initCritDamage;
/*     */         }
/* 140 */         if (value > 0)
/*     */         {
/* 142 */           fightPower += Math.abs(value) * att.scoreRatio;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 147 */     return (int)fightPower;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int calFightPowerByData(Map<String, Integer> influs) {
/* 154 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getUnRealLogicServerId(int logicServerId, int acrossServerId, boolean isAcross) {
/* 161 */     if (isAcross) {
/* 162 */       return acrossServerId;
/*     */     }
/* 164 */     return logicServerId;
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
/*     */   public static int getGrowUpValue(int initValue, float growUpValue, int lvl) {
/* 176 */     return (int)Math.round(initValue * Math.pow(growUpValue, (lvl - 1)));
/*     */   }
/*     */   
/*     */   public static boolean isLegalString(String name) {
/* 180 */     String pattern = "^[一-龥_a-zA-Z0-9]+$";
/* 181 */     if (!name.matches("^[一-龥_a-zA-Z0-9]+$")) {
/* 182 */       return false;
/*     */     }
/* 184 */     if (BlackWordUtil.isIncludeBlackString(name)) {
/* 185 */       return false;
/*     */     }
/*     */     
/* 188 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getWeek() {
/* 197 */     Date date = new Date();
/* 198 */     Calendar cal = Calendar.getInstance();
/* 199 */     cal.setTime(date);
/* 200 */     int w = cal.get(7) - 1;
/* 201 */     if (0 == w) {
/* 202 */       w = 7;
/*     */     }
/* 204 */     return w;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static List<WNBag.SimpleItemInfo> parseItems(String itemStr) {
/* 214 */     List<WNBag.SimpleItemInfo> items = new ArrayList<>();
/* 215 */     if (StringUtil.isEmpty(itemStr)) {
/* 216 */       return items;
/*     */     }
/* 218 */     String[] timeStr = itemStr.split(";");
/* 219 */     for (int i = 0; i < timeStr.length; i++) {
/* 220 */       String elemStr = timeStr[i];
/* 221 */       if (!StringUtil.isEmpty(elemStr)) {
/*     */ 
/*     */ 
/*     */         
/* 225 */         String[] tmp = elemStr.split(":");
/*     */         
/* 227 */         if (tmp.length == 2)
/*     */         
/*     */         { 
/*     */           
/* 231 */           WNBag.SimpleItemInfo item = new WNBag.SimpleItemInfo();
/* 232 */           item.itemCode = tmp[0];
/* 233 */           item.itemNum = Integer.parseInt(tmp[1]);
/* 234 */           items.add(item); } 
/*     */       } 
/* 236 */     }  return items;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void sendIconMsgType(Const.MESSAGE_TYPE msgType, String playerId) {
/* 243 */     MessageData message = MessageUtil.createMessage(msgType.getValue(), playerId, null);
/* 244 */     MessageUtil.sendMessageToPlayer(message, playerId);
/*     */   }
/*     */   
/*     */   public static void printAttrMap(Map<Const.PlayerBtlData, Integer> map) {
/* 248 */     StringBuffer sb = new StringBuffer("");
/* 249 */     for (Const.PlayerBtlData pbd : map.keySet()) {
/* 250 */       sb.append(pbd.chName + ":" + map.get(pbd)).append("  ");
/*     */     }
/* 252 */     System.out.println(sb);
/*     */   }
/*     */   
/*     */   public static void printAttrList(List<Common.AttributeSimple> list) {
/* 256 */     StringBuffer sb = new StringBuffer("");
/* 257 */     for (Common.AttributeSimple attr : list) {
/* 258 */       int id = attr.getId();
/* 259 */       Const.PlayerBtlData pbd = Const.PlayerBtlData.getE(id);
/* 260 */       sb.append(pbd.chName + ":" + attr.getValue()).append("  ");
/*     */     } 
/* 262 */     System.out.println(sb);
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\common\CommonUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */