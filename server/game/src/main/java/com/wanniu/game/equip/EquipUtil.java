/*     */ package com.wanniu.game.equip;
/*     */ 
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.util.StringUtil;
/*     */ import com.wanniu.game.bag.WNBag;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.Utils;
/*     */ import com.wanniu.game.data.CharacterCO;
/*     */ import com.wanniu.game.data.EnchantCO;
/*     */ import com.wanniu.game.data.GameData;
/*     */ import com.wanniu.game.data.base.DEquipBase;
/*     */ import com.wanniu.game.data.base.DItemBase;
/*     */ import com.wanniu.game.data.base.DItemEquipBase;
/*     */ import com.wanniu.game.data.ext.EnchantExt;
/*     */ import com.wanniu.game.data.ext.EquipMakeExt;
/*     */ import com.wanniu.game.data.ext.ReBornExt;
/*     */ import com.wanniu.game.data.ext.ReBuildExt;
/*     */ import com.wanniu.game.data.ext.RefineExt;
/*     */ import com.wanniu.game.data.ext.SeniorReBuildExt;
/*     */ import com.wanniu.game.item.ItemConfig;
/*     */ import com.wanniu.game.item.ItemUtil;
/*     */ import com.wanniu.game.item.data.AttsObj;
/*     */ import com.wanniu.game.item.po.PlayerItemPO;
/*     */ import com.wanniu.game.player.AttributeUtil;
/*     */ import com.wanniu.game.player.GlobalConfig;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.poes.PlayerBasePO;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import pomelo.Common;
/*     */ import pomelo.area.EquipHandler;
/*     */ import pomelo.item.ItemOuterClass;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EquipUtil
/*     */ {
/*     */   public static int maxStrengthLevel;
/*  48 */   public static List<String> strengthMaterial = new ArrayList<>();
/*     */   
/*  50 */   public static List<String> makeMaterial = new ArrayList<>();
/*     */   static {
/*  52 */     for (EnchantExt enchant : GameData.Enchants.values()) {
/*  53 */       if (maxStrengthLevel < enchant.iD) {
/*  54 */         maxStrengthLevel = enchant.iD;
/*     */       }
/*  56 */       if (StringUtil.isNotEmpty(enchant.mateCode1) && !strengthMaterial.contains(enchant.mateCode1)) {
/*  57 */         strengthMaterial.add(enchant.mateCode1);
/*     */       }
/*  59 */       if (StringUtil.isNotEmpty(enchant.mateCode2) && !strengthMaterial.contains(enchant.mateCode2)) {
/*  60 */         strengthMaterial.add(enchant.mateCode2);
/*     */       }
/*     */     } 
/*     */     
/*  64 */     for (EquipMakeExt make : GameData.EquipMakes.values()) {
/*  65 */       if (StringUtil.isNotEmpty(make.reqMateCode1) && !makeMaterial.contains(make.reqMateCode1)) {
/*  66 */         makeMaterial.add(make.reqMateCode1);
/*     */       }
/*  68 */       if (StringUtil.isNotEmpty(make.reqMateCode2) && !makeMaterial.contains(make.reqMateCode2)) {
/*  69 */         makeMaterial.add(make.reqMateCode2);
/*     */       }
/*  71 */       if (StringUtil.isNotEmpty(make.reqMateCode3) && !makeMaterial.contains(make.reqMateCode3)) {
/*  72 */         makeMaterial.add(make.reqMateCode3);
/*     */       }
/*     */     } 
/*     */     
/*  76 */     for (RefineExt refineExt : GameData.Refines.values()) {
/*  77 */       if (StringUtil.isNotEmpty(refineExt.mateCode1) && !makeMaterial.contains(refineExt.mateCode1)) {
/*  78 */         makeMaterial.add(refineExt.mateCode1);
/*     */       }
/*  80 */       if (StringUtil.isNotEmpty(refineExt.mateCode2) && !makeMaterial.contains(refineExt.mateCode2)) {
/*  81 */         makeMaterial.add(refineExt.mateCode2);
/*     */       }
/*     */     } 
/*     */     
/*  85 */     for (ReBuildExt reBuildExt : GameData.ReBuilds.values()) {
/*  86 */       if (StringUtil.isNotEmpty(reBuildExt.mateCode1) && !makeMaterial.contains(reBuildExt.mateCode1)) {
/*  87 */         makeMaterial.add(reBuildExt.mateCode1);
/*     */       }
/*  89 */       if (StringUtil.isNotEmpty(reBuildExt.mateCode2) && !makeMaterial.contains(reBuildExt.mateCode2)) {
/*  90 */         makeMaterial.add(reBuildExt.mateCode2);
/*     */       }
/*  92 */       if (StringUtil.isNotEmpty(reBuildExt.mateCode3) && !makeMaterial.contains(reBuildExt.mateCode3)) {
/*  93 */         makeMaterial.add(reBuildExt.mateCode3);
/*     */       }
/*     */     } 
/*     */     
/*  97 */     for (SeniorReBuildExt seniorReBuildExt : GameData.SeniorReBuilds.values()) {
/*  98 */       if (StringUtil.isNotEmpty(seniorReBuildExt.mateCode1) && !makeMaterial.contains(seniorReBuildExt.mateCode1)) {
/*  99 */         makeMaterial.add(seniorReBuildExt.mateCode1);
/*     */       }
/* 101 */       if (StringUtil.isNotEmpty(seniorReBuildExt.mateCode2) && !makeMaterial.contains(seniorReBuildExt.mateCode2)) {
/* 102 */         makeMaterial.add(seniorReBuildExt.mateCode2);
/*     */       }
/* 104 */       if (StringUtil.isNotEmpty(seniorReBuildExt.mateCode3) && !makeMaterial.contains(seniorReBuildExt.mateCode3)) {
/* 105 */         makeMaterial.add(seniorReBuildExt.mateCode3);
/*     */       }
/*     */     } 
/*     */     
/* 109 */     for (ReBornExt reBornExt : GameData.ReBorns.values()) {
/* 110 */       if (StringUtil.isNotEmpty(reBornExt.mateCode1) && !makeMaterial.contains(reBornExt.mateCode1)) {
/* 111 */         makeMaterial.add(reBornExt.mateCode1);
/*     */       }
/* 113 */       if (StringUtil.isNotEmpty(reBornExt.mateCode2) && !makeMaterial.contains(reBornExt.mateCode2)) {
/* 114 */         makeMaterial.add(reBornExt.mateCode2);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static List<ItemOuterClass.EquipmentJewelAtt> toJson4Gem(PlayerBasePO.EquipStrengthPos posInfo) {
/* 125 */     List<ItemOuterClass.EquipmentJewelAtt> data = new ArrayList<>();
/* 126 */     if (posInfo.gems == null)
/* 127 */       return data; 
/* 128 */     for (Iterator<Integer> iterator = posInfo.gems.keySet().iterator(); iterator.hasNext(); ) { int gem_index = ((Integer)iterator.next()).intValue();
/*     */       
/* 130 */       String gemCode = (String)posInfo.gems.get(Integer.valueOf(gem_index));
/* 131 */       ItemOuterClass.EquipmentJewelAtt.Builder gemData = ItemOuterClass.EquipmentJewelAtt.newBuilder();
/* 132 */       gemData.setIndex(gem_index);
/* 133 */       if (StringUtil.isNotEmpty(gemCode)) {
/* 134 */         DItemBase prop = ItemUtil.getUnEquipPropByCode(gemCode);
/* 135 */         gemData.setId(AttributeUtil.getIdByName(prop.prop));
/* 136 */         gemData.setValue(prop.min);
/*     */         
/* 138 */         ItemOuterClass.MiniItem.Builder mini = ItemUtil.getMiniItemData(gemCode, 1);
/* 139 */         if (prop != null && mini != null) {
/* 140 */           gemData.setGem(mini);
/*     */         }
/*     */       } 
/*     */       
/* 144 */       data.add(gemData.build()); }
/*     */     
/* 146 */     Out.debug(new Object[] { EquipUtil.class, " toJson4Gem ", data });
/* 147 */     return data;
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
/*     */   public static boolean fillGem(PlayerBasePO.EquipStrengthPos posInfo, int[] index, String code, WNPlayer player) {
/* 184 */     DItemBase prop = ItemUtil.getUnEquipPropByCode(code);
/* 185 */     if (prop == null) {
/* 186 */       Out.error(new Object[] { "Equip fillGem config error code ", code });
/* 187 */       return false;
/*     */     } 
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
/* 200 */     if (posInfo.gems.size() >= posInfo.socks) {
/* 201 */       return false;
/*     */     }
/*     */     
/* 204 */     for (int i = 1; i <= posInfo.socks; i++) {
/* 205 */       if (!posInfo.gems.containsKey(Integer.valueOf(i))) {
/* 206 */         posInfo.gems.put(Integer.valueOf(i), code);
/* 207 */         index[0] = i;
/*     */         break;
/*     */       } 
/*     */     } 
/* 211 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static EquipHandler.EquipStrengthenData getStrengthInfo(WNPlayer player, int pos) {
/* 220 */     NormalEquip equip = player.equipManager.getEquipment(pos);
/* 221 */     PlayerBasePO.EquipStrengthPos pair = player.equipManager.strengthPos.get(Integer.valueOf(pos));
/* 222 */     EquipHandler.EquipStrengthenData.Builder data = EquipHandler.EquipStrengthenData.newBuilder();
/* 223 */     List<Common.AttributeSimple> simpleAtts = new ArrayList<>();
/* 224 */     if (pair.enSection == GlobalConfig.EquipmentCraft_Enchant_MaxEnClass && pair.enLevel == GlobalConfig.EquipmentCraft_Enchant_MaxenLevel) {
/* 225 */       data.addAllSimpleAtts(simpleAtts);
/*     */     } else {
/* 227 */       List<ItemOuterClass.MiniItem> list_cost_items = new ArrayList<>();
/* 228 */       EnchantExt prop = getStrengthConfig(pair.enSection, pair.enLevel);
/* 229 */       if (prop != null) {
/* 230 */         for (String code : prop.mates.keySet()) {
/* 231 */           list_cost_items.add(ItemUtil.getMiniItemData(code, prop.mates.getIntValue(code), null).build());
/*     */         }
/* 233 */         data.addAllCostItem(list_cost_items);
/* 234 */         data.setNeedGoldNum(prop.costGold);
/* 235 */         if (equip != null) {
/* 236 */           Map<String, Integer> atts = new HashMap<>();
/* 237 */           Utils.deepCopy(atts, equip.itemDb.speData.baseAtts);
/* 238 */           if (equip.itemDb.speData.extAtts == null) {
/* 239 */             Utils.deepCopy(atts, equip.prop.fixedAtts);
/*     */           } else {
/* 241 */             Utils.deepCopyAffix(atts, equip.itemDb.speData.extAtts, equip.getQLevel());
/*     */           } 
/* 243 */           data.addAllSimpleAtts(ItemUtil.getStrengthSimpleAtt(atts, pair.enSection, pair.enLevel));
/*     */         } 
/*     */       } else {
/* 246 */         Out.error(new Object[] { "pos = ", Integer.valueOf(pos), ",enSection = ", Integer.valueOf(pair.enSection), ", enLevel = ", Integer.valueOf(pair.enLevel) });
/*     */       } 
/*     */     } 
/* 249 */     return data.build();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static List<Common.Avatar> getAvatarData(int pro, PlayerBasePO playerBasePO, boolean changeModel) {
/* 260 */     CharacterCO basicProp = (CharacterCO)GameData.Characters.get(Integer.valueOf(pro));
/* 261 */     Map<Integer, PlayerItemPO> equipDatas = playerBasePO.equipGrids;
/* 262 */     Map<Integer, PlayerBasePO.EquipStrengthPos> strengthPos = playerBasePO.strengthPos;
/* 263 */     PlayerItemPO tmpCloth = equipDatas.get(Integer.valueOf(Const.EquipType.CLOTH.getValue()));
/* 264 */     PlayerItemPO tmpRHand = equipDatas.get(Integer.valueOf(Const.EquipType.MAIN_HAND.getValue()));
/*     */     
/* 266 */     List<Common.Avatar> data = new ArrayList<>();
/* 267 */     Common.Avatar.Builder avatar = Common.Avatar.newBuilder();
/* 268 */     avatar.setEffectType(0);
/* 269 */     avatar.setTag(Const.AVATAR_TYPE.AVATAR_BODY.value);
/*     */ 
/*     */     
/* 272 */     if (tmpCloth != null) {
/* 273 */       DEquipBase prop = (DEquipBase)ItemConfig.getInstance().getItemProp(tmpCloth.code);
/* 274 */       if (StringUtil.isNotEmpty(prop.avatarId)) {
/* 275 */         avatar.setFileName(String.valueOf(prop.avatarId));
/*     */       } else {
/* 277 */         avatar.setFileName(String.valueOf(basicProp.model));
/*     */       } 
/*     */     } else {
/* 280 */       avatar.setFileName(String.valueOf(basicProp.model));
/*     */     } 
/* 282 */     data.add(avatar.build());
/*     */     
/* 284 */     Common.Avatar.Builder avatar_r = Common.Avatar.newBuilder();
/* 285 */     avatar_r.setTag(Const.AVATAR_TYPE.R_HAND_WEAPON.value);
/* 286 */     String defaultRoleWeapon = basicProp.weaponmodel;
/* 287 */     if (tmpRHand != null) {
/* 288 */       String reDefaultWeapon; DEquipBase prop = (DEquipBase)ItemConfig.getInstance().getItemProp(tmpRHand.code);
/*     */       
/* 290 */       if (StringUtil.isEmpty(prop.avatarId)) {
/* 291 */         reDefaultWeapon = defaultRoleWeapon;
/*     */       } else {
/* 293 */         reDefaultWeapon = String.valueOf(prop.avatarId);
/*     */       } 
/*     */       
/* 296 */       PlayerBasePO.EquipStrengthPos pair = strengthPos.get(Integer.valueOf(Const.EquipType.MAIN_HAND.getValue()));
/* 297 */       if (basicProp.pro == Const.PlayerPro.YU_JIAN.value) {
/* 298 */         Common.Avatar.Builder avatar_l = Common.Avatar.newBuilder();
/* 299 */         avatar_l.setEffectType(getEffectTypeId(pair.enSection, pair.enLevel));
/* 300 */         avatar_l.setTag(Const.AVATAR_TYPE.L_HAND_WEAPON.value);
/* 301 */         avatar_l.setFileName(String.valueOf(reDefaultWeapon));
/* 302 */         data.add(avatar_l.build());
/*     */         
/* 304 */         avatar_r.setEffectType(getEffectTypeId(pair.enSection, pair.enLevel));
/* 305 */         avatar_r.setFileName(String.valueOf(reDefaultWeapon));
/*     */       } else {
/* 307 */         avatar_r.setEffectType(getEffectTypeId(pair.enSection, pair.enLevel));
/* 308 */         avatar_r.setFileName(String.valueOf(reDefaultWeapon));
/*     */       }
/*     */     
/* 311 */     } else if (basicProp.pro == Const.PlayerPro.YU_JIAN.value) {
/* 312 */       Common.Avatar.Builder avatar_l = Common.Avatar.newBuilder();
/* 313 */       avatar_l.setEffectType(0);
/* 314 */       avatar_l.setTag(Const.AVATAR_TYPE.L_HAND_WEAPON.value);
/* 315 */       avatar_l.setFileName(String.valueOf(defaultRoleWeapon));
/* 316 */       data.add(avatar_l.build());
/*     */       
/* 318 */       avatar_r.setEffectType(0);
/* 319 */       avatar_r.setFileName(String.valueOf(defaultRoleWeapon));
/*     */     } else {
/* 321 */       avatar_r.setEffectType(0);
/* 322 */       avatar_r.setFileName(String.valueOf(defaultRoleWeapon));
/*     */     } 
/*     */     
/* 325 */     data.add(avatar_r.build());
/*     */     
/* 327 */     return data;
/*     */   }
/*     */   
/*     */   public static int getEffectTypeId(int enClass, int enLevel) {
/* 331 */     Out.debug(new Object[] { "Equip getEffectTypeId: ", Integer.valueOf(enClass), ",", Integer.valueOf(enLevel) });
/* 332 */     if (enClass == 0 && enLevel < 1) {
/* 333 */       return 0;
/*     */     }
/* 335 */     EnchantExt enchantExt = EquipCraftConfig.getInstance().getEnchantConfig(enClass, enLevel);
/* 336 */     if (enchantExt == null) {
/* 337 */       Out.error(new Object[] { "equip getEffectTypeId null:", Integer.valueOf(enLevel) });
/* 338 */       return 0;
/*     */     } 
/* 340 */     return ((EnchantCO)enchantExt).effectType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static EnchantExt getStrengthConfig(int enClass, int enLevel) {
/* 350 */     if (enClass > GlobalConfig.EquipmentCraft_Enchant_MaxEnClass || enLevel > GlobalConfig.EquipmentCraft_Enchant_MaxenLevel) {
/* 351 */       return null;
/*     */     }
/* 353 */     if (enClass == GlobalConfig.EquipmentCraft_Enchant_MaxEnClass && enLevel == GlobalConfig.EquipmentCraft_Enchant_MaxenLevel) {
/* 354 */       return null;
/*     */     }
/* 356 */     if (enLevel == GlobalConfig.EquipmentCraft_Enchant_MaxenLevel) {
/* 357 */       enClass++;
/* 358 */       enLevel = 0;
/*     */     } else {
/* 360 */       enLevel++;
/*     */     } 
/*     */     
/* 363 */     return EquipCraftConfig.getInstance().getEnchantConfig(enClass, enLevel);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isMaxStrengthLevel(int enClass, int enLevel) {
/* 370 */     if (enClass == GlobalConfig.EquipmentCraft_Enchant_MaxEnClass && enLevel == GlobalConfig.EquipmentCraft_Enchant_MaxenLevel) {
/* 371 */       return true;
/*     */     }
/*     */     
/* 374 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean existSameTypeGem(int type, PlayerBasePO.EquipStrengthPos posInfo) {
/* 381 */     for (String code : posInfo.gems.values()) {
/* 382 */       if (StringUtil.isNotEmpty(code)) {
/* 383 */         DItemEquipBase prop = ItemConfig.getInstance().getItemProp(code);
/* 384 */         if (type == ((DItemBase)prop).par) {
/* 385 */           return true;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 390 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static List<WNBag.SimpleItemInfo> getGemList(PlayerBasePO.EquipStrengthPos posInfo, int index) {
/* 400 */     List<WNBag.SimpleItemInfo> itemList = new ArrayList<>();
/*     */     
/* 402 */     String jewel_code = (String)posInfo.gems.get(Integer.valueOf(index));
/* 403 */     if (StringUtil.isNotEmpty(jewel_code)) {
/* 404 */       Const.ForceType forceType = Const.ForceType.getE(Const.BindType.UN_BIND.getValue());
/* 405 */       WNBag.SimpleItemInfo map = new WNBag.SimpleItemInfo();
/* 406 */       map.itemCode = jewel_code;
/* 407 */       map.itemNum = 1;
/* 408 */       map.forceType = forceType;
/* 409 */       itemList.add(map);
/*     */     } 
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
/* 426 */     return itemList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static List<Common.AttributeBase> getAttsAttributeBase(List<AttsObj> atts) {
/* 433 */     List<Common.AttributeBase> list = new ArrayList<>();
/* 434 */     if (atts == null) {
/* 435 */       return list;
/*     */     }
/* 437 */     for (AttsObj att : atts) {
/* 438 */       Common.AttributeBase ab = getAttributeBase(att);
/* 439 */       list.add(ab);
/*     */     } 
/* 441 */     return list;
/*     */   }
/*     */   
/*     */   public static Common.AttributeBase getAttributeBase(AttsObj att) {
/* 445 */     Common.AttributeBase.Builder ab = Common.AttributeBase.newBuilder();
/*     */     
/* 447 */     ab.setId(AttributeUtil.getIdByKey(att.key));
/* 448 */     ab.setIsFormat(AttributeUtil.getFormatByKey(att.key));
/* 449 */     ab.setValue(att.value);
/*     */     
/* 451 */     ab.setMinValue(att.min);
/* 452 */     ab.setMaxValue(att.max);
/*     */     
/* 454 */     ab.setParam3(att.par);
/* 455 */     return ab.build();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static List<ItemOuterClass.ItemDetail> getAllEquipDetails4PayLoad(PlayerBasePO playerBasePO, Map<Integer, PlayerItemPO> equipGrids) {
/* 462 */     List<NormalEquip> list = new ArrayList<>();
/* 463 */     for (PlayerItemPO itemDb : equipGrids.values()) {
/* 464 */       list.add((NormalEquip)ItemUtil.createItemByDbOpts(itemDb));
/*     */     }
/* 466 */     List<ItemOuterClass.ItemDetail> data = new ArrayList<>();
/* 467 */     for (NormalEquip equip : list) {
/* 468 */       data.add(equip.getItemDetail(playerBasePO).build());
/*     */     }
/* 470 */     return data;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\equip\EquipUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */