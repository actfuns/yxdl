/*      */ package com.wanniu.game.item;
/*      */ 
/*      */ import Xmds.RefreshPlayerPropertyChange;
/*      */ import com.wanniu.core.game.LangService;
/*      */ import com.wanniu.core.logfs.Out;
/*      */ import com.wanniu.core.util.RandomUtil;
/*      */ import com.wanniu.core.util.StringUtil;
/*      */ import com.wanniu.game.bag.WNBag;
/*      */ import com.wanniu.game.common.Const;
/*      */ import com.wanniu.game.common.Utils;
/*      */ import com.wanniu.game.data.AfterFilterCO;
/*      */ import com.wanniu.game.data.EnchantCO;
/*      */ import com.wanniu.game.data.GameData;
/*      */ import com.wanniu.game.data.MeltConfigCO;
/*      */ import com.wanniu.game.data.ReBuildStarCO;
/*      */ import com.wanniu.game.data.base.DEquipBase;
/*      */ import com.wanniu.game.data.base.DItemBase;
/*      */ import com.wanniu.game.data.base.DItemEquipBase;
/*      */ import com.wanniu.game.data.base.FourProp;
/*      */ import com.wanniu.game.data.ext.AffixExt;
/*      */ import com.wanniu.game.data.ext.EnchantExt;
/*      */ import com.wanniu.game.data.ext.TreasureClassExt;
/*      */ import com.wanniu.game.equip.EquipCraftConfig;
/*      */ import com.wanniu.game.equip.EquipUtil;
/*      */ import com.wanniu.game.equip.NormalEquip;
/*      */ import com.wanniu.game.equip.RepeatKeyMap;
/*      */ import com.wanniu.game.item.data.AttsObj;
/*      */ import com.wanniu.game.item.data.tc.TCItemData;
/*      */ import com.wanniu.game.item.po.ItemSpeData;
/*      */ import com.wanniu.game.item.po.PlayerItemPO;
/*      */ import com.wanniu.game.player.AttributeUtil;
/*      */ import com.wanniu.game.player.GlobalConfig;
/*      */ import com.wanniu.game.player.WNPlayer;
/*      */ import com.wanniu.game.request.bag.UseItemHandler;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collections;
/*      */ import java.util.Date;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.UUID;
/*      */ import org.apache.commons.lang3.StringUtils;
/*      */ import pomelo.Common;
/*      */ import pomelo.area.EquipHandler;
/*      */ import pomelo.item.ItemOuterClass;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class ItemUtil
/*      */ {
/*      */   public static boolean isEquipByItemType(int itemType) {
/*   65 */     if (itemType == Const.ItemType.Weapon.getValue() || itemType == Const.ItemType.Armor.getValue() || itemType == Const.ItemType.Oranament.getValue() || itemType == Const.ItemType.RideEquip.getValue()) {
/*   66 */       return true;
/*      */     }
/*   68 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static DItemEquipBase getPropByCode(String code) {
/*   78 */     if (StringUtils.isEmpty(code)) {
/*   79 */       return null;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*   85 */     DItemEquipBase prop = ItemConfig.getInstance().getItemProp(code);
/*   86 */     return prop;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static DItemBase getUnEquipPropByCode(String code) {
/*   97 */     return (DItemBase)ItemConfig.getInstance().getItemProp(code);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isVirtualItem(String code) {
/*  107 */     DItemEquipBase prop = ItemConfig.getInstance().getItemProp(code);
/*  108 */     if (prop == null) {
/*  109 */       return false;
/*      */     }
/*      */     
/*  112 */     int itemSecondType = ItemConfig.getInstance().getSecondType(prop.type);
/*  113 */     if (itemSecondType == Const.ItemSecondType.virtual.getValue())
/*      */     {
/*      */ 
/*      */       
/*  117 */       return true;
/*      */     }
/*      */     
/*  120 */     return false;
/*      */   }
/*      */   
/*      */   public static List<Common.AttributeSimple> getStrengthSimpleAtt(Map<String, Integer> data, int enClass, int enLevel) {
/*  124 */     List<Common.AttributeSimple> newDataArray = new ArrayList<>();
/*  125 */     int maxClass = GlobalConfig.EquipmentCraft_Enchant_MaxEnClass;
/*  126 */     int maxLevel = GlobalConfig.EquipmentCraft_Enchant_MaxenLevel;
/*      */     
/*  128 */     for (Map.Entry<String, Integer> entry : data.entrySet()) {
/*  129 */       Common.AttributeSimple.Builder tempData = Common.AttributeSimple.newBuilder();
/*  130 */       if (((String)entry.getKey()).equals("MinPhy")) {
/*  131 */         tempData.setId(AttributeUtil.getIdByKey("Phy"));
/*  132 */         tempData.setValue(0);
/*  133 */         if (enClass < maxClass || (enClass == maxClass && enLevel < maxLevel)) {
/*  134 */           EnchantExt enchantExt = EquipUtil.getStrengthConfig(enClass, enLevel);
/*  135 */           tempData.setValue((int)(0.5D * (((Integer)data.get(entry.getKey())).intValue() + ((Integer)data.get("MaxPhy")).intValue()) * ((EnchantCO)enchantExt).propPer / 10000.0D));
/*      */         } 
/*  137 */         newDataArray.add(tempData.build());
/*      */       } 
/*  139 */       if (((String)entry.getKey()).equals("MinMag")) {
/*  140 */         tempData.setId(AttributeUtil.getIdByKey("Mag"));
/*  141 */         tempData.setValue(0);
/*  142 */         if (enClass < maxClass || (enClass == maxClass && enLevel < maxLevel)) {
/*  143 */           EnchantExt enchantExt = EquipUtil.getStrengthConfig(enClass, enLevel);
/*  144 */           tempData.setValue((int)(0.5D * (((Integer)data.get(entry.getKey())).intValue() + ((Integer)data.get("MaxMag")).intValue()) * ((EnchantCO)enchantExt).propPer / 10000.0D));
/*      */         } 
/*  146 */         newDataArray.add(tempData.build());
/*      */       } 
/*      */     } 
/*  149 */     for (Map.Entry<String, Integer> entry : data.entrySet()) {
/*  150 */       if (!((String)entry.getKey()).equals("MinMag") && !((String)entry.getKey()).equals("MaxMag") && !((String)entry.getKey()).equals("MinPhy") && !((String)entry.getKey()).equals("MaxPhy")) {
/*  151 */         Common.AttributeSimple.Builder newData = Common.AttributeSimple.newBuilder();
/*  152 */         newData.setId(AttributeUtil.getIdByKey(entry.getKey()));
/*  153 */         newData.setValue(0);
/*  154 */         if (enClass < maxClass || (enClass == maxClass && enLevel < maxLevel)) {
/*  155 */           EnchantExt enchantExt = EquipUtil.getStrengthConfig(enClass, enLevel);
/*  156 */           newData.setValue(((Integer)data.get(entry.getKey())).intValue() * ((EnchantCO)enchantExt).propPer / 10000);
/*      */         } 
/*  158 */         newDataArray.add(newData.build());
/*      */       } 
/*      */     } 
/*  161 */     return newDataArray;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static NormalItem createItemByDbOpts(PlayerItemPO itemDb) {
/*  216 */     DItemEquipBase prop = ItemConfig.getInstance().getItemProp(itemDb.code);
/*  217 */     if (prop == null) {
/*      */       
/*  219 */       Out.error(new Object[] { "createItemByDbOpts error,code have deleted: ", itemDb.code });
/*      */       
/*  221 */       throw new RuntimeException();
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  236 */     NormalItem item = createItemByOpts(itemDb, prop);
/*  237 */     return item;
/*      */   }
/*      */ 
/*      */   
/*      */   public static NormalItem createItemByOpts(PlayerItemPO itemDb, DItemEquipBase prop) {
/*  242 */     int itemSecondType = ItemConfig.getInstance().getSecondType(prop.type);
/*  243 */     NormalItem item = null;
/*  244 */     if (isEquipByItemType(prop.itemType)) {
/*  245 */       NormalEquip normalEquip = new NormalEquip(itemDb, prop);
/*  246 */     } else if (itemSecondType == Const.ItemSecondType.virtual.getValue()) {
/*  247 */       item = new VirtualItem(itemDb, prop);
/*      */     } else {
/*  249 */       item = new NormalItem(itemDb, prop);
/*      */     } 
/*      */     
/*  252 */     return item;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int getIndexByRare(List<Integer> rareArray) {
/*  259 */     int result = 0;
/*  260 */     if (rareArray == null || rareArray.size() == 0)
/*  261 */       return result; 
/*  262 */     int rares = 0;
/*  263 */     for (Iterator<Integer> iterator = rareArray.iterator(); iterator.hasNext(); ) { int rare = ((Integer)iterator.next()).intValue();
/*  264 */       rares += rare; }
/*      */     
/*  266 */     if (rares == 0) {
/*  267 */       return result;
/*      */     }
/*  269 */     int ranRare = RandomUtil.getInt(0, rares);
/*  270 */     int maxRare = 0;
/*  271 */     for (int i = 0; i < rareArray.size(); i++) {
/*  272 */       int rare = ((Integer)rareArray.get(i)).intValue();
/*  273 */       maxRare += rare;
/*  274 */       if (rare > 0 && ranRare <= maxRare) {
/*  275 */         result = i;
/*      */         
/*      */         break;
/*      */       } 
/*      */     } 
/*  280 */     return result;
/*      */   }
/*      */   
/*      */   public static ItemSpeData createItemSpeData(DItemEquipBase prop, int worth) {
/*  284 */     ItemSpeData speData = new ItemSpeData();
/*      */     
/*  286 */     if (isEquipByItemType(prop.itemType)) {
/*  287 */       speData = initSpeData((DEquipBase)prop);
/*  288 */     } else if (ItemConfig.getInstance().getSecondType(prop.type) == Const.ItemSecondType.virtual.getValue()) {
/*  289 */       speData.worth = worth;
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  296 */     return speData;
/*      */   }
/*      */   
/*      */   public static ItemSpeData initSpeData(DEquipBase prop) {
/*  300 */     ItemSpeData speData = new ItemSpeData();
/*      */     
/*  302 */     speData.baseAtts = new HashMap<>();
/*  303 */     if (StringUtil.isEmpty(prop.baseCode)) {
/*  304 */       speData.extAtts = new RepeatKeyMap();
/*      */ 
/*      */       
/*  307 */       initBaseAtts(speData.baseAtts, prop);
/*  308 */       initExtAtts(speData.extAtts, prop, 0, 0);
/*      */       
/*  310 */       Map<String, Integer> exarAttr = getSameAttsExtAttributes(speData.extAtts, prop.type, prop.code);
/*  311 */       if (exarAttr != null) {
/*  312 */         speData.extAttsAdd = exarAttr;
/*      */       }
/*  314 */       initLegendAtts(speData, prop);
/*      */     } else {
/*      */       
/*  317 */       for (String attrName : prop.baseAtts.keySet()) {
/*  318 */         FourProp pair = (FourProp)prop.baseAtts.get(attrName);
/*  319 */         if (pair == null) {
/*      */           continue;
/*      */         }
/*  322 */         speData.baseAtts.put(pair.prop, Integer.valueOf(RandomUtil.getInt(pair.min, pair.max)));
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  332 */     return speData;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void initBaseAtts(Map<String, Integer> baseAtts, DEquipBase prop) {
/*  339 */     for (String attrName : prop.baseAtts.keySet()) {
/*  340 */       FourProp pair = (FourProp)prop.baseAtts.get(attrName);
/*  341 */       if (pair == null) {
/*      */         continue;
/*      */       }
/*  344 */       baseAtts.put(pair.prop, Integer.valueOf(RandomUtil.getInt(pair.min, pair.max)));
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void initExtAtts(RepeatKeyMap<Integer, Integer> extAtts, DEquipBase prop, int lastCount, int lockedCount) {
/*  357 */     int rdIndex = RandomUtil.hit(new int[] { GlobalConfig.Equipment_MinAffixChance, 10000 - GlobalConfig.Equipment_MinAffixChance });
/*  358 */     int rdTimes = (rdIndex == 0) ? prop.minAffixCount : prop.maxAffixCount;
/*  359 */     rdTimes = (rdTimes > lastCount) ? rdTimes : lastCount;
/*      */ 
/*      */     
/*  362 */     if (lastCount != 0 && rdTimes < prop.maxAffixCount) {
/*  363 */       rdIndex = RandomUtil.hit(new int[] { GlobalConfig.Equipment_ReBuild_AddAffixChance, 10000 - GlobalConfig.Equipment_ReBuild_AddAffixChance });
/*  364 */       rdTimes = (rdIndex == 0) ? (rdTimes + 1) : rdTimes;
/*      */     } 
/*      */ 
/*      */     
/*  368 */     rdTimes -= lockedCount;
/*      */     
/*  370 */     List<Integer> usedGroupId = new ArrayList<>();
/*  371 */     for (int i = 0; i < rdTimes; i++) {
/*  372 */       AffixExt finalAffix = initRebuildOneAtts(prop, usedGroupId, Const.AffixType.normal);
/*  373 */       if (finalAffix != null) {
/*      */ 
/*      */         
/*  376 */         FourProp rdProp = (FourProp)finalAffix.props.get(Integer.valueOf(prop.qcolor));
/*  377 */         if (rdProp != null) {
/*  378 */           extAtts.put(Integer.valueOf(finalAffix.iD), Integer.valueOf(RandomUtil.getInt(rdProp.min, rdProp.max)));
/*      */         }
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void initRebuildExtAtts(RepeatKeyMap<Integer, Integer> tempExtAtts, DEquipBase prop, int lastCount, int lockedCount) {
/*  393 */     int rdIndex = RandomUtil.hit(new int[] { GlobalConfig.Equipment_MinAffixChance, 10000 - GlobalConfig.Equipment_MinAffixChance });
/*  394 */     int rdTimes = (rdIndex == 0) ? prop.minAffixCount : prop.maxAffixCount;
/*  395 */     rdTimes = (rdTimes > lastCount) ? rdTimes : lastCount;
/*      */ 
/*      */     
/*  398 */     if (lastCount != 0 && rdTimes < prop.maxAffixCount) {
/*  399 */       rdIndex = RandomUtil.hit(new int[] { GlobalConfig.Equipment_ReBuild_AddAffixChance, 10000 - GlobalConfig.Equipment_ReBuild_AddAffixChance });
/*  400 */       rdTimes = (rdIndex == 0) ? (rdTimes + 1) : rdTimes;
/*      */     } 
/*      */ 
/*      */     
/*  404 */     rdTimes -= lockedCount;
/*  405 */     if (rdTimes > 5) {
/*  406 */       Out.error(new Object[] { "equip", prop.code, ",", prop.desc, "rebuild rdTimes error ", Integer.valueOf(rdTimes) });
/*      */     }
/*      */     
/*  409 */     List<Integer> usedGroupId = new ArrayList<>();
/*  410 */     StringBuilder sb = new StringBuilder(">>>>>>>>>usedGroupId:");
/*      */     
/*  412 */     for (RepeatKeyMap.Pair<Integer, Integer> rp : (Iterable<RepeatKeyMap.Pair<Integer, Integer>>)tempExtAtts.entrySet()) {
/*  413 */       if (((Integer)rp.k).intValue() > 0) {
/*  414 */         AffixExt affix = (AffixExt)GameData.Affixs.get(rp.k);
/*  415 */         if (affix == null) {
/*  416 */           Out.warn(new Object[] { "key=" + rp.k + " val=" + rp.v });
/*      */           
/*      */           continue;
/*      */         } 
/*  420 */         int gid = affix.groupID;
/*  421 */         usedGroupId.add(Integer.valueOf(gid));
/*  422 */         sb.append(gid).append(",");
/*      */       } 
/*      */     } 
/*  425 */     Out.debug(new Object[] { sb });
/*      */     
/*  427 */     for (int i = 0; i < rdTimes; i++) {
/*  428 */       AffixExt finalAffix = initRebuildOneAtts(prop, usedGroupId, Const.AffixType.normal);
/*  429 */       if (finalAffix != null) {
/*      */ 
/*      */         
/*  432 */         FourProp rdProp = (FourProp)finalAffix.props.get(Integer.valueOf(prop.qcolor));
/*  433 */         if (rdProp != null) {
/*  434 */           int val = RandomUtil.getInt(calcRebuildPropMin(rdProp.min), rdProp.max);
/*  435 */           tempExtAtts.putIfEmpty(Integer.valueOf(finalAffix.iD), Integer.valueOf(val));
/*  436 */           if (val < rdProp.min) {
/*  437 */             Out.info(new Object[] { "成功生成一条属性低于下限>>>>>>>>>>" + finalAffix.iD + "," + ((FourProp)finalAffix.props.get(Integer.valueOf(prop.qcolor))).prop + "," + val + " min=" + rdProp.min });
/*      */           } else {
/*  439 */             Out.debug(new Object[] { "成功生成一条属性>>>>>>>>>>" + finalAffix.iD + "," + ((FourProp)finalAffix.props.get(Integer.valueOf(prop.qcolor))).prop + "," + val });
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int calcRebuildPropMin(int originalMin) {
/*  452 */     return originalMin * GlobalConfig.Equipment_PropNum_FloorRate / 100;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void seniorInitExtAtts(RepeatKeyMap<Integer, Integer> extAtts, RepeatKeyMap<Integer, Integer> tempExtAtts_senior, DEquipBase prop) {
/*  461 */     List<RepeatKeyMap.Pair<Integer, Integer>> list = extAtts.entrySet();
/*  462 */     for (RepeatKeyMap.Pair<Integer, Integer> p : list) {
/*  463 */       AffixExt finalAffix = (AffixExt)GameData.Affixs.get(p.k);
/*  464 */       if (finalAffix == null) {
/*  465 */         Out.warn(new Object[] { "key=" + p.k + " val=" + p.v });
/*      */         continue;
/*      */       } 
/*  468 */       FourProp rdProp = (FourProp)finalAffix.props.get(Integer.valueOf(prop.qcolor));
/*  469 */       if (rdProp == null) {
/*      */         continue;
/*      */       }
/*  472 */       int max = rdProp.max;
/*  473 */       if (((Integer)p.v).intValue() < max) {
/*  474 */         int addPer = RandomUtil.getIndex(GlobalConfig.Equipment_SeniorReBuild_MaxRatio + 1);
/*  475 */         if (addPer <= 0) {
/*  476 */           tempExtAtts_senior.put(p.k, p.v);
/*      */           continue;
/*      */         } 
/*  479 */         int add = Math.round((((Integer)p.v).intValue() * addPer) * 1.0F / 100.0F);
/*  480 */         if (add <= 0) {
/*  481 */           tempExtAtts_senior.put(p.k, p.v);
/*      */           continue;
/*      */         } 
/*  484 */         int after = add + ((Integer)p.v).intValue();
/*  485 */         after = (after > max) ? max : after;
/*  486 */         tempExtAtts_senior.put(p.k, Integer.valueOf(after)); continue;
/*      */       } 
/*  488 */       tempExtAtts_senior.put(p.k, p.v);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void initLegendAtts(ItemSpeData speData, DEquipBase prop) {
/*  498 */     List<Integer> usedGroupId = new ArrayList<>();
/*  499 */     AffixExt finalAffix = initOneAtts(prop, usedGroupId, Const.AffixType.legend);
/*  500 */     if (finalAffix != null) {
/*  501 */       FourProp rdProp = (FourProp)finalAffix.props.get(Integer.valueOf(prop.qcolor));
/*  502 */       if (rdProp != null) {
/*  503 */         speData.legendAtts = new HashMap<>();
/*  504 */         speData.legendAtts.put(Integer.valueOf(finalAffix.iD), Integer.valueOf(RandomUtil.getInt(rdProp.min, rdProp.max)));
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void initUniqueAtts(List<AttsObj> uniqueAtts, DEquipBase prop) {
/*  513 */     for (FourProp pair : prop.uniqueAtts.values()) {
/*  514 */       uniqueAtts.add(new AttsObj(pair.prop, RandomUtil.getInt(pair.min, pair.max), pair.par, pair.min, pair.max));
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private static ReBuildStarCO findReBuildStarCObyNum(int num, String type) {
/*  520 */     List<ReBuildStarCO> list = GameData.findReBuildStars(t -> 
/*  521 */         (t.type.equals(type) && t.enClass == num));
/*      */     
/*  523 */     if (list != null && !list.isEmpty()) {
/*  524 */       return list.get(0);
/*      */     }
/*  526 */     return null;
/*      */   }
/*      */   
/*      */   private static ReBuildStarCO findReBuildStarCObyMax(List<ReBuildStarCO> lt) {
/*  530 */     if (lt == null || lt.isEmpty()) {
/*  531 */       return null;
/*      */     }
/*  533 */     ReBuildStarCO maxCO = null;
/*  534 */     for (ReBuildStarCO co : lt) {
/*  535 */       if (maxCO == null) {
/*  536 */         maxCO = co; continue;
/*      */       } 
/*  538 */       maxCO = (co.enClass > maxCO.enClass) ? co : maxCO;
/*      */     } 
/*      */     
/*  541 */     return maxCO;
/*      */   }
/*      */   
/*      */   private static List<ReBuildStarCO> findMaxStarCO(String type) {
/*  545 */     List<ReBuildStarCO> list = GameData.findReBuildStars(t -> t.type.equals(type));
/*      */ 
/*      */     
/*  548 */     return list;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Map<String, Integer> getSameAttsExtAttributes(RepeatKeyMap<Integer, Integer> attrs, String type, String code) {
/*  556 */     Map<Integer, Integer> sames = new HashMap<>();
/*  557 */     for (Integer key : attrs.keySet()) {
/*  558 */       if (sames.containsKey(key)) {
/*  559 */         sames.put(key, Integer.valueOf(((Integer)sames.get(key)).intValue() + 1)); continue;
/*      */       } 
/*  561 */       sames.put(key, Integer.valueOf(1));
/*      */     } 
/*      */ 
/*      */     
/*  565 */     Map<String, Integer> attr = null;
/*  566 */     for (Integer key : sames.keySet()) {
/*  567 */       int repeatTimes = ((Integer)sames.get(key)).intValue();
/*  568 */       if (repeatTimes <= 1) {
/*      */         continue;
/*      */       }
/*  571 */       attr = (attr == null) ? new HashMap<>() : attr;
/*  572 */       ReBuildStarCO co = findReBuildStarCObyNum(repeatTimes, type);
/*  573 */       if (co == null) {
/*  574 */         Out.warn(new Object[] { "重铸装备获取额外属性失败1,发现当前相同的条目数大于配表数量,当前数量为:" + repeatTimes, "部位=" + type, "code=", code });
/*  575 */         List<ReBuildStarCO> lt = findMaxStarCO(type);
/*  576 */         co = findReBuildStarCObyMax(lt);
/*  577 */         if (co == null)
/*  578 */           Out.warn(new Object[] { "重铸装备获取额外属性失败1,发现不可预料的情况,难道是配表为空?,当前数量为:" + repeatTimes, "部位=" + type, "code=", code }); 
/*      */         continue;
/*      */       } 
/*  581 */       Const.PlayerBtlData data = Const.PlayerBtlData.getE(co.prop);
/*  582 */       Integer vl = attr.get(data.toString());
/*  583 */       if (vl == null) {
/*  584 */         attr.put(data.toString(), Integer.valueOf(co.proNum)); continue;
/*      */       } 
/*  586 */       attr.put(data.toString(), Integer.valueOf(co.proNum + vl.intValue()));
/*      */     } 
/*      */ 
/*      */     
/*  590 */     return attr;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static AffixExt initRebuildOneAtts(DEquipBase prop, List<Integer> usedGroupId, Const.AffixType affixType) {
/*  597 */     List<AffixExt> list_affixs = new ArrayList<>();
/*  598 */     List<Integer> rareArray = new ArrayList<>();
/*      */     
/*  600 */     StringBuilder sb = new StringBuilder("================");
/*  601 */     for (AffixExt affix : GameData.Affixs.values()) {
/*  602 */       if ((affix.equipType.equalsIgnoreCase("All") || affix.equipType.indexOf(prop.type) != -1) && (prop.tcLevel == affix.level || affix.level == 0) && (StringUtil.isEmpty(affix.pro) || affix.pro.indexOf(prop.pro) != -1) && affixType.value == affix.affixType && affix.isValid == 1) {
/*      */ 
/*      */         
/*  605 */         list_affixs.add(affix);
/*  606 */         sb.append(affix.groupID).append(",");
/*  607 */         rareArray.add(Integer.valueOf(affix.rare));
/*      */       } 
/*      */     } 
/*      */     
/*  611 */     Out.debug(new Object[] { Integer.valueOf(list_affixs.size()), ":::::", sb });
/*  612 */     if (list_affixs.size() > 0) {
/*      */       while (true) {
/*  614 */         int index = Utils.getIndexByRareByList(rareArray);
/*  615 */         AffixExt finalAffix = list_affixs.get(index);
/*      */         
/*  617 */         if (isValid(usedGroupId, finalAffix.groupID)) {
/*  618 */           usedGroupId.add(Integer.valueOf(finalAffix.groupID));
/*  619 */           return finalAffix;
/*      */         } 
/*  621 */         Out.debug(new Object[] { Integer.valueOf(finalAffix.groupID) });
/*      */       } 
/*      */     }
/*      */     
/*  625 */     Out.error(new Object[] { "not six affix prop:", prop.code, ":", prop.name });
/*      */     
/*  627 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static AffixExt getFixOneAtts(int lv, String type, String pro, Const.AffixType affixType, String attName) {
/*  639 */     AffixExt fixAffix = null;
/*  640 */     for (AffixExt affix : GameData.Affixs.values()) {
/*  641 */       if ((affix.equipType.equalsIgnoreCase("All") || affix.equipType.indexOf(type) != -1) && (lv == affix.level || affix.level == 0) && (StringUtil.isEmpty(affix.pro) || affix.pro.indexOf(pro) != -1) && affixType.value == affix.affixType && affix.isValid == 1 && attName
/*  642 */         .equals(affix.attName)) {
/*  643 */         fixAffix = affix;
/*      */         break;
/*      */       } 
/*      */     } 
/*  647 */     return fixAffix;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static AffixExt initOneAtts(DEquipBase prop, List<Integer> usedGroupId, Const.AffixType affixType) {
/*  654 */     List<AffixExt> list_affixs = new ArrayList<>();
/*  655 */     List<Integer> rareArray = new ArrayList<>();
/*  656 */     for (AffixExt affix : GameData.Affixs.values()) {
/*  657 */       if ((affix.equipType.equalsIgnoreCase("All") || affix.equipType.indexOf(prop.type) != -1) && (prop.tcLevel == affix.level || affix.level == 0) && (StringUtil.isEmpty(affix.pro) || affix.pro.indexOf(prop.pro) != -1) && !usedGroupId.contains(Integer.valueOf(affix.groupID)) && affixType.value == affix.affixType && affix.isValid == 1) {
/*  658 */         list_affixs.add(affix);
/*  659 */         rareArray.add(Integer.valueOf(affix.rare));
/*      */       } 
/*      */     } 
/*  662 */     if (list_affixs.size() > 0) {
/*  663 */       int index = Utils.getIndexByRareByList(rareArray);
/*  664 */       AffixExt finalAffix = list_affixs.get(index);
/*  665 */       usedGroupId.add(Integer.valueOf(finalAffix.groupID));
/*  666 */       return finalAffix;
/*      */     } 
/*  668 */     Out.error(new Object[] { "not six affix prop:", prop.code, ":", prop.name });
/*      */     
/*  670 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static boolean isValid(List<Integer> usedGroupId, int groupID) {
/*  681 */     int haved = 1;
/*  682 */     for (Integer i : usedGroupId) {
/*  683 */       if (i.intValue() == groupID) {
/*  684 */         haved++;
/*      */       }
/*      */     } 
/*  687 */     boolean result = false;
/*  688 */     switch (haved) {
/*      */       case 1:
/*  690 */         result = true;
/*      */         break;
/*      */       case 2:
/*  693 */         result = Utils.randomPercent(GlobalConfig.Equipment_SameAffixChance2);
/*      */         break;
/*      */       case 3:
/*  696 */         result = Utils.randomPercent(GlobalConfig.Equipment_SameAffixChance3);
/*      */         break;
/*      */       case 4:
/*  699 */         result = Utils.randomPercent(GlobalConfig.Equipment_SameAffixChance4);
/*      */         break;
/*      */       case 5:
/*  702 */         result = Utils.randomPercent(GlobalConfig.Equipment_SameAffixChance5);
/*      */         break;
/*      */     } 
/*      */     
/*  706 */     return result;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void initAllExtAtts(List<AttsObj> extAtts, DEquipBase prop) {
/*  713 */     for (AffixExt affix : GameData.Affixs.values()) {
/*  714 */       if ((affix.equipType.equalsIgnoreCase("All") || affix.equipType.indexOf(prop.type) != -1) && (prop.tcLevel == affix.level || affix.level == 0) && (StringUtil.isEmpty(affix.pro) || affix.pro.indexOf(prop.pro) != -1) && affix.isValid == 1) {
/*  715 */         FourProp rdProp = (FourProp)affix.props.get(Integer.valueOf(prop.qcolor));
/*  716 */         if (rdProp != null) {
/*  717 */           extAtts.add(new AttsObj(rdProp.prop, RandomUtil.getInt(rdProp.min, rdProp.max), rdProp.par, rdProp.min, rdProp.max));
/*      */         }
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static List<NormalItem> createItemsByItemCode(Map<String, Integer> rewards) {
/*  730 */     List<NormalItem> returnItems = new ArrayList<>();
/*  731 */     for (String itemCode : rewards.keySet()) {
/*  732 */       List<NormalItem> items = createItemsByItemCode(itemCode, ((Integer)rewards.get(itemCode)).intValue());
/*  733 */       returnItems.addAll(items);
/*      */     } 
/*  735 */     return returnItems;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static List<NormalItem> createItemsByItemCode(String code, int groupCount) {
/*  745 */     DItemEquipBase prop = ItemConfig.getInstance().getItemProp(code);
/*  746 */     if (prop == null) {
/*  747 */       return new ArrayList<>();
/*      */     }
/*  749 */     return createItemsByProp(prop, groupCount);
/*      */   }
/*      */   
/*      */   private static List<NormalItem> createItemsByProp(DItemEquipBase prop, int groupCount) {
/*  753 */     List<NormalItem> items = new ArrayList<>();
/*      */     
/*  755 */     if (ItemConfig.getInstance().getSecondType(prop.type) == Const.ItemSecondType.virtual.getValue()) {
/*  756 */       PlayerItemPO itemDb = new PlayerItemPO();
/*  757 */       itemDb.id = UUID.randomUUID().toString();
/*  758 */       itemDb.code = prop.code;
/*  759 */       itemDb.groupCount = 1;
/*  760 */       itemDb.isNew = 1;
/*  761 */       itemDb.speData = createItemSpeData(prop, groupCount);
/*  762 */       itemDb.gotTime = new Date();
/*  763 */       itemDb.cdTime = 0L;
/*  764 */       itemDb.isBind = 0;
/*      */       
/*  766 */       NormalItem item = createItemByOpts(itemDb, prop);
/*  767 */       Out.debug(new Object[] { "生成一个虚拟物品：", item });
/*  768 */       items.add(item);
/*  769 */       return items;
/*      */     } 
/*      */     
/*  772 */     int remainCount = groupCount;
/*  773 */     while (remainCount > 0) {
/*  774 */       int count = remainCount;
/*  775 */       if (remainCount > prop.groupCount) {
/*  776 */         count = prop.groupCount;
/*      */       }
/*  778 */       remainCount -= count;
/*      */       
/*  780 */       PlayerItemPO itemDb = new PlayerItemPO();
/*  781 */       itemDb.id = UUID.randomUUID().toString();
/*  782 */       itemDb.code = prop.code;
/*  783 */       itemDb.groupCount = count;
/*  784 */       itemDb.isNew = 1;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  792 */       itemDb.speData = createItemSpeData(prop, 0);
/*      */       
/*  794 */       itemDb.gotTime = new Date();
/*  795 */       itemDb.cdTime = 0L;
/*  796 */       itemDb.isBind = prop.bindType;
/*      */       
/*  798 */       NormalItem item = createItemByOpts(itemDb, prop);
/*  799 */       items.add(item);
/*      */     } 
/*  801 */     return items;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static List<NormalItem> createEquipsByTcLevelAndType(int qColor, int tcLevel, int itemSecondType) {
/*  808 */     List<NormalItem> items = new ArrayList<>();
/*  809 */     List<DEquipBase> props = ItemConfig.getInstance().getEquipProps(qColor, tcLevel, itemSecondType);
/*  810 */     if (props.size() <= 0) {
/*  811 */       Out.debug(new Object[] { ItemUtil.class, "创建装备失败 qColor:", Integer.valueOf(qColor), " tcLevel:", Integer.valueOf(tcLevel), " itemSecondType:", Integer.valueOf(itemSecondType) });
/*  812 */       return items;
/*      */     } 
/*      */     
/*  815 */     List<Integer> rareArray = new ArrayList<>();
/*  816 */     props.forEach(prop -> rareArray.add(Integer.valueOf(prop.rare)));
/*      */ 
/*      */     
/*  819 */     int index = getIndexByRare(rareArray);
/*  820 */     DEquipBase prop = props.get(index);
/*  821 */     return createItemsByProp((DItemEquipBase)prop, 1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static List<NormalItem> createItemsByItemData(TreasureClassExt prop, TCItemData itemData, int color, boolean isNumOfRare, List<Integer> colorRareArray, int level) {
/*  829 */     List<NormalItem> items = new ArrayList<>();
/*  830 */     String itemCode = itemData.code;
/*  831 */     int num = itemData.num;
/*  832 */     if (num == 0) {
/*  833 */       num = Utils.random(itemData.minNum, itemData.maxNum);
/*      */     }
/*      */     
/*  836 */     if (isNumOfRare) {
/*  837 */       num *= itemData.rare;
/*      */     }
/*      */     
/*  840 */     if (itemData.tcType == 1) {
/*      */       
/*  842 */       int itemSecondType = Const.ItemSecondType.getV(itemCode);
/*  843 */       int tcLevel = prop.tcLevel;
/*  844 */       for (int i = 0; i < num; i++) {
/*  845 */         List<NormalItem> getItems = createEquipsByTcLevelAndType(color, tcLevel, itemSecondType);
/*  846 */         items.addAll(getItems);
/*      */       } 
/*      */     } else {
/*      */       
/*  850 */       TreasureClassExt tcProp = ItemConfig.getInstance().getTcProp(itemCode);
/*  851 */       if (tcProp != null && itemData.tcType == 3) {
/*  852 */         List<NormalItem> getItems = null;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  859 */         getItems = createItemsByTcCode(itemCode, colorRareArray, level);
/*  860 */         items.addAll(getItems);
/*      */       } else {
/*  862 */         List<NormalItem> getItems = createItemsByItemCode(itemCode, num);
/*  863 */         items.addAll(getItems);
/*      */       } 
/*      */     } 
/*  866 */     return items;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static List<NormalItem> createItemsByTcCode(String code) {
/*  874 */     return createItemsByTcCode(code, null, 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static List<NormalItem> createItemsByRealTC(String code, int level) {
/*  883 */     return createItemsByTcCode(code, null, level);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static List<NormalItem> createItemsByTcCode(String code, List<Integer> colorRareArray, int level) {
/*  890 */     System.out.println(code + "::::::::::::::::::::::::TCCODE:::::::::::::::::::::::");
/*  891 */     List<NormalItem> items = new ArrayList<>();
/*  892 */     if (StringUtil.isEmpty(code)) {
/*  893 */       return items;
/*      */     }
/*  895 */     if (level > 0) {
/*  896 */       code = ItemConfig.getInstance().getRealTC(code, level);
/*  897 */       System.out.println("error:::::::::::::::::::::::::::::::::level");
/*      */     } 
/*  899 */     TreasureClassExt prop = ItemConfig.getInstance().getTcProp(code);
/*  900 */     if (prop == null) {
/*  901 */       System.out.println("error:::::::::::::::::::::::::::::::::prop");
/*  902 */       return items;
/*      */     } 
/*      */ 
/*      */     
/*  906 */     int picks = prop.picks;
/*  907 */     boolean isHasColor = true;
/*      */     
/*  909 */     if (colorRareArray == null || colorRareArray.size() == 0) {
/*  910 */       isHasColor = false;
/*      */     }
/*  912 */     if (picks > 0) {
/*  913 */       System.out.println("error:::::::::::::::::::::::::::::::::picks");
/*  914 */       for (int i = 0; i < picks; i++) {
/*  915 */         List<Integer> rareArray = new ArrayList<>();
/*  916 */         rareArray.add(Integer.valueOf(prop.noDrop));
/*  917 */         List<TCItemData> itemDatas = prop.items;
/*  918 */         for (TCItemData itemData : itemDatas) {
/*  919 */           rareArray.add(Integer.valueOf(itemData.rare));
/*      */         }
/*  921 */         int index = getIndexByRare(rareArray);
/*  922 */         if (index > 0) {
/*  923 */           if (colorRareArray == null || colorRareArray.size() == 0) {
/*  924 */             colorRareArray = new ArrayList<>();
/*  925 */             colorRareArray.add(Integer.valueOf(prop.white));
/*  926 */             colorRareArray.add(Integer.valueOf(prop.blue));
/*  927 */             colorRareArray.add(Integer.valueOf(prop.purple));
/*  928 */             colorRareArray.add(Integer.valueOf(prop.legend));
/*  929 */             colorRareArray.add(Integer.valueOf(prop.green));
/*      */           } 
/*      */           
/*  932 */           int colorIndex = getIndexByRare(colorRareArray);
/*  933 */           int color = colorIndex;
/*      */           
/*  935 */           TCItemData itemData = itemDatas.get(index - 1);
/*      */           
/*  937 */           List<NormalItem> getItems = null;
/*  938 */           if (prop.overColor != 0) {
/*  939 */             getItems = createItemsByItemData(prop, itemData, color, false, colorRareArray, level);
/*      */           } else {
/*  941 */             getItems = createItemsByItemData(prop, itemData, color, false, null, level);
/*      */           } 
/*  943 */           System.out.println(getItems + "error:::::::::::::::::::::::::::::::::getItems");
/*  944 */           items.addAll(getItems);
/*      */         } 
/*  946 */         if (!isHasColor) {
/*  947 */           colorRareArray = null;
/*      */         }
/*      */       } 
/*      */     } else {
/*  951 */       picks = Math.abs(picks);
/*  952 */       for (int i = 0; i < picks; i++) {
/*      */         
/*  954 */         List<TCItemData> itemDatas = prop.items;
/*  955 */         TCItemData itemData = itemDatas.get(i);
/*  956 */         if (itemData != null) {
/*  957 */           if (colorRareArray == null || colorRareArray.size() == 0) {
/*  958 */             colorRareArray = new ArrayList<>();
/*  959 */             colorRareArray.add(Integer.valueOf(prop.white));
/*  960 */             colorRareArray.add(Integer.valueOf(prop.blue));
/*  961 */             colorRareArray.add(Integer.valueOf(prop.purple));
/*  962 */             colorRareArray.add(Integer.valueOf(prop.legend));
/*  963 */             colorRareArray.add(Integer.valueOf(prop.green));
/*      */           } 
/*      */           
/*  966 */           int colorIndex = getIndexByRare(colorRareArray);
/*  967 */           int color = colorIndex + 1;
/*      */ 
/*      */           
/*  970 */           List<NormalItem> getItems = null;
/*  971 */           if (prop.overColor != 0) {
/*  972 */             getItems = createItemsByItemData(prop, itemData, color, true, colorRareArray, level);
/*      */           } else {
/*  974 */             getItems = createItemsByItemData(prop, itemData, color, true, null, level);
/*      */           } 
/*  976 */           System.out.println(getItems + "error:::::::::::::::::::::::::::::::::getItems2");
/*  977 */           items.addAll(getItems);
/*      */         } 
/*  979 */         if (!isHasColor) {
/*  980 */           colorRareArray = null;
/*      */         }
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  986 */     AfterFilterCO afterFilter = (AfterFilterCO)GameData.AfterFilters.get(code);
/*  987 */     if (afterFilter != null) {
/*  988 */       for (NormalItem item : items) {
/*  989 */         if (StringUtil.isEmpty(afterFilter.bindType)) {
/*      */           continue;
/*      */         }
/*      */         try {
/*  993 */           item.setBindFilter(Integer.parseInt(afterFilter.bindType));
/*      */ 
/*      */           
/*  996 */           item.setBindFilter(Integer.parseInt(afterFilter.noAuction));
/*  997 */         } catch (Exception e) {
/*  998 */           Out.error(new Object[] { "过滤表填错了" });
/*      */         } 
/*      */       } 
/*      */     }
/* 1002 */     System.out.println(items + "error:::::::::::::::::::::::::::::::::items");
/* 1003 */     return items;
/*      */   }
/*      */   
/*      */   public static List<NormalItem> getPackUpItems(List<NormalItem> items) {
/* 1007 */     Map<String, NormalItem> temp = new HashMap<>();
/* 1008 */     List<NormalItem> data = new ArrayList<>();
/*      */     
/* 1010 */     for (int i = 0; i < items.size(); i++) {
/* 1011 */       NormalItem item = items.get(i);
/*      */       
/* 1013 */       if (item.isVirtual()) {
/* 1014 */         if (temp.get(item.itemDb.code) == null) {
/* 1015 */           temp.put(item.itemDb.code, item);
/*      */         } else {
/* 1017 */           ((VirtualItem)temp.get(item.itemDb.code)).addWorth(item.getWorth());
/*      */         } 
/*      */       } else {
/* 1020 */         data.add(item);
/*      */       } 
/*      */     } 
/*      */     
/* 1024 */     for (NormalItem item : temp.values()) {
/* 1025 */       data.add(item);
/*      */     }
/*      */     
/* 1028 */     temp = new HashMap<>();
/* 1029 */     Map<String, NormalItem> tempBind = new HashMap<>();
/* 1030 */     List<NormalItem> newData = new ArrayList<>();
/*      */ 
/*      */     
/* 1033 */     for (int j = 0; j < data.size(); j++) {
/* 1034 */       NormalItem item = data.get(j);
/* 1035 */       if (item != null)
/*      */       {
/*      */ 
/*      */         
/* 1039 */         if (item.itemDb.groupCount != item.prop.groupCount) {
/* 1040 */           if (item.isBinding()) {
/* 1041 */             mergeItems(item, tempBind, newData);
/*      */           } else {
/* 1043 */             mergeItems(item, temp, newData);
/*      */           } 
/*      */         } else {
/* 1046 */           newData.add(item);
/*      */         }  } 
/*      */     } 
/* 1049 */     for (NormalItem item : temp.values()) {
/* 1050 */       newData.add(item);
/*      */     }
/*      */     
/* 1053 */     for (NormalItem item : tempBind.values()) {
/* 1054 */       newData.add(item);
/*      */     }
/*      */     
/* 1057 */     return newData;
/*      */   }
/*      */   
/*      */   public static void mergeItems(NormalItem item, Map<String, NormalItem> temp, List<NormalItem> newData) {
/* 1061 */     if (temp.get(item.itemDb.code) == null) {
/* 1062 */       temp.put(item.itemDb.code, item);
/*      */     }
/* 1064 */     else if (((NormalItem)temp.get(item.itemDb.code)).itemDb.groupCount + item.itemDb.groupCount >= item.prop.groupCount) {
/* 1065 */       int tmpCount = item.itemDb.groupCount;
/*      */       
/* 1067 */       item.setNum(item.prop.groupCount);
/* 1068 */       newData.add(item);
/*      */ 
/*      */ 
/*      */       
/* 1072 */       ((NormalItem)temp.get(item.itemDb.code)).setNum(((NormalItem)temp.get(item.itemDb.code)).itemDb.groupCount + tmpCount - item.prop.groupCount);
/* 1073 */       if (((NormalItem)temp.get(item.itemDb.code)).itemDb.groupCount == 0) {
/* 1074 */         temp.remove(item.itemDb.code);
/*      */       }
/*      */     } else {
/*      */       
/* 1078 */       ((NormalItem)temp.get(item.itemDb.code)).addGroupNum(item.itemDb.groupCount);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public static int getPackUpItemsNum(List<NormalItem> items) {
/* 1084 */     int sum = 0;
/* 1085 */     for (int i = 0; i < items.size(); i++) {
/* 1086 */       if (((NormalItem)items.get(i)).prop.itemSecondType != Const.ItemSecondType.virtual.getValue() && 
/*      */ 
/*      */         
/* 1089 */         !((NormalItem)items.get(i)).isVirtQuest()) {
/* 1090 */         sum++;
/*      */       }
/*      */     } 
/* 1093 */     return sum;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int getPropBindType(DItemEquipBase template, Const.ForceType forceType) {
/* 1120 */     int bindType = template.bindType;
/* 1121 */     if (forceType == Const.ForceType.BIND) {
/* 1122 */       bindType = Const.BindType.BIND.getValue();
/* 1123 */     } else if (forceType == Const.ForceType.UN_BIND) {
/* 1124 */       if (isEquipByItemType(template.itemType)) {
/* 1125 */         bindType = Const.BindType.EQUIP_BIND.getValue();
/*      */       } else {
/* 1127 */         bindType = Const.BindType.UN_BIND.getValue();
/*      */       } 
/*      */     } 
/* 1130 */     return bindType;
/*      */   }
/*      */   
/*      */   public static ItemOuterClass.MiniItem.Builder getMiniItemData(String code, int num) {
/* 1134 */     return getMiniItemData(code, num, null);
/*      */   }
/*      */   
/*      */   public static ItemOuterClass.MiniItem.Builder getMiniItemData(String code, int num, Const.ForceType forceBindType) {
/* 1138 */     DItemEquipBase prop = getPropByCode(code);
/* 1139 */     if (prop != null) {
/* 1140 */       int bindType = getPropBindType(prop, forceBindType);
/* 1141 */       ItemOuterClass.MiniItem.Builder data = ItemOuterClass.MiniItem.newBuilder();
/* 1142 */       data.setCode(prop.code);
/* 1143 */       data.setGroupCount(num);
/* 1144 */       data.setIcon(prop.icon);
/* 1145 */       data.setQColor(prop.qcolor);
/* 1146 */       data.setName(prop.name);
/* 1147 */       data.setStar(0);
/* 1148 */       data.setBindType(bindType);
/*      */       
/* 1150 */       return data;
/*      */     } 
/*      */     
/* 1153 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static List<Object[]> getEnchantMaterial(DItemEquipBase prop) {
/* 1227 */     List<Object[]> data = new ArrayList();
/* 1228 */     String codes = GlobalConfig.Magical_MateCodes;
/* 1229 */     String counts = GlobalConfig.Magical_MateCounts;
/* 1230 */     String diamonds = GlobalConfig.Magical_MatePrice;
/*      */     
/* 1232 */     if (StringUtil.isEmpty(codes) || StringUtil.isEmpty(counts) || StringUtil.isEmpty(diamonds)) {
/* 1233 */       return data;
/*      */     }
/*      */     
/* 1236 */     String[] codesArray = codes.split(",");
/* 1237 */     String[] countsArray = counts.split(",");
/* 1238 */     String[] diamondsArray = diamonds.split(",");
/*      */     
/* 1240 */     data.add(new Object[] { codesArray[prop.qcolor], Integer.valueOf(Integer.parseInt(countsArray[prop.qcolor])), Integer.valueOf(Integer.parseInt(diamondsArray[prop.qcolor])) });
/*      */     
/* 1242 */     return data;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static NormalItem getEquip(WNPlayer player, EquipHandler.EquipPos equipPos) {
/* 1317 */     if (equipPos.getBagOrBody() == Const.EquipPos.BODY.value) {
/* 1318 */       return (NormalItem)player.equipManager.getEquipment(equipPos.getPosOrGrid());
/*      */     }
/* 1320 */     return player.getWnBag().getItem(equipPos.getPosOrGrid());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static MeltConfigCO getMeltProp(int meltLevel, int quality) {
/* 1331 */     return EquipCraftConfig.getInstance().getMeltProp(meltLevel, quality);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static NormalItem getItemById(WNPlayer player, String id) {
/* 1351 */     NormalItem item = player.bag.findItemById(id);
/* 1352 */     if (item != null) {
/* 1353 */       return item;
/*      */     }
/*      */     
/* 1356 */     NormalEquip normalEquip = player.equipManager.getEquipById(id);
/* 1357 */     if (normalEquip != null) {
/* 1358 */       return (NormalItem)normalEquip;
/*      */     }
/* 1360 */     return null;
/*      */   }
/*      */   
/*      */   public static UseItemHandler.GetItemChanagePropertyResult getItemChanageProperty(NormalItem item) {
/* 1364 */     DItemBase prop = (DItemBase)item.prop;
/* 1365 */     return getItemChanageProperty(prop);
/*      */   }
/*      */   
/*      */   public static UseItemHandler.GetItemChanagePropertyResult getItemChanageProperty(DItemBase prop) {
/* 1369 */     RefreshPlayerPropertyChange itemData = new RefreshPlayerPropertyChange();
/* 1370 */     UseItemHandler.GetItemChanagePropertyResult data = new UseItemHandler.GetItemChanagePropertyResult(itemData, false);
/*      */     
/* 1372 */     if (prop.itemSecondType == Const.ItemSecondType.hpot.getValue()) {
/* 1373 */       itemData.changeType = Const.PropertyChangeType.HP.value;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     }
/*      */     else {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1391 */       itemData.changeType = Const.PropertyChangeType.HPAndMP.value;
/*      */     } 
/*      */     
/* 1394 */     int format = AttributeUtil.getFormatByName(prop.prop);
/* 1395 */     itemData.valueType = format;
/*      */     
/* 1397 */     itemData.value = prop.min;
/* 1398 */     itemData.duration = prop.par;
/* 1399 */     if (prop.par > 0) {
/* 1400 */       itemData.timestamp = System.currentTimeMillis() + prop.par;
/*      */     } else {
/* 1402 */       itemData.timestamp = 0L;
/*      */     } 
/*      */     
/* 1405 */     data.itemData = itemData;
/*      */     
/* 1407 */     return data;
/*      */   }
/*      */   
/*      */   public static String getColorItemNameByQcolor(int itemQcolor, String itemName) {
/* 1411 */     if (itemQcolor == Const.ItemQuality.WHITE.getValue()) {
/* 1412 */       itemName = LangService.getValue("ITEM_QCOLOR_NAME_WHITE").replace("{itemName}", itemName);
/* 1413 */     } else if (itemQcolor == Const.ItemQuality.GREEN.getValue()) {
/* 1414 */       itemName = LangService.getValue("ITEM_QCOLOR_NAME_GREEN").replace("{itemName}", itemName);
/* 1415 */     } else if (itemQcolor == Const.ItemQuality.BLUE.getValue()) {
/* 1416 */       itemName = LangService.getValue("ITEM_QCOLOR_NAME_BLUE").replace("{itemName}", itemName);
/* 1417 */     } else if (itemQcolor == Const.ItemQuality.PURPLE.getValue()) {
/* 1418 */       itemName = LangService.getValue("ITEM_QCOLOR_NAME_PURPLE").replace("{itemName}", itemName);
/* 1419 */     } else if (itemQcolor == Const.ItemQuality.ORANGE.getValue()) {
/* 1420 */       itemName = LangService.getValue("ITEM_QCOLOR_NAME_ORANGE").replace("{itemName}", itemName);
/* 1421 */     } else if (itemQcolor == Const.ItemQuality.RED.getValue()) {
/* 1422 */       itemName = LangService.getValue("ITEM_QCOLOR_NAME_RED").replace("{itemName}", itemName);
/*      */     } 
/* 1424 */     return itemName;
/*      */   }
/*      */   
/*      */   public static int getEquipScoreRatio(String code) {
/* 1428 */     DItemEquipBase prop = getPropByCode(code);
/* 1429 */     if (prop == null) {
/* 1430 */       Out.error(new Object[] { "there is no prop for Equip ", code });
/* 1431 */       return 0;
/*      */     } 
/* 1433 */     if (!isEquipByItemType(prop.itemType)) {
/* 1434 */       return 0;
/*      */     }
/*      */     
/* 1437 */     return 0;
/*      */   }
/*      */   
/*      */   public static int getEquipScore(Map<String, Integer> attrs) {
/* 1441 */     int score = 0;
/* 1442 */     for (Map.Entry<String, Integer> node : attrs.entrySet()) {
/* 1443 */       score += (int)(AttributeUtil.getScoreRatioByKey(node.getKey()) * Math.abs(((Integer)node.getValue()).intValue()));
/*      */     }
/* 1445 */     return score;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int getMaxStrengthLevel() {
/* 1464 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static ArrayList<WNBag.SimpleItemInfo> parseString(String itemCode) {
/* 1471 */     ArrayList<WNBag.SimpleItemInfo> simpleItemInfos = new ArrayList<>();
/* 1472 */     if (StringUtil.isEmpty(itemCode)) {
/* 1473 */       return simpleItemInfos;
/*      */     }
/* 1475 */     String[] rewards = itemCode.split(";");
/* 1476 */     for (String ss : rewards) {
/* 1477 */       String[] rw = ss.split(":");
/* 1478 */       if (rw.length == 2) {
/* 1479 */         WNBag.SimpleItemInfo item = new WNBag.SimpleItemInfo();
/* 1480 */         item.itemCode = rw[0];
/* 1481 */         item.itemNum = Integer.parseInt(rw[1]);
/* 1482 */         item.forceType = Const.ForceType.BIND;
/* 1483 */         simpleItemInfos.add(item);
/*      */       } 
/*      */     } 
/* 1486 */     return simpleItemInfos;
/*      */   }
/*      */   
/*      */   public static Map<String, Integer> parseString2Map(String itemCode) {
/* 1490 */     if (StringUtils.isEmpty(itemCode)) {
/* 1491 */       return Collections.emptyMap();
/*      */     }
/*      */     
/* 1494 */     Map<String, Integer> awards = new HashMap<>();
/* 1495 */     String[] items = StringUtils.split(itemCode, ";");
/* 1496 */     for (String item : items) {
/* 1497 */       String[] codenum = item.split(":");
/* 1498 */       awards.put(codenum[0], Integer.valueOf(Integer.parseInt(codenum[1])));
/*      */     } 
/* 1500 */     return awards;
/*      */   }
/*      */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\item\ItemUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */