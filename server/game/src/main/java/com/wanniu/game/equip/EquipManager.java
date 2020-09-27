/*      */ package com.wanniu.game.equip;
/*      */ 
/*      */ import com.google.protobuf.GeneratedMessage;
/*      */ import com.wanniu.core.common.IntIntPair;
/*      */ import com.wanniu.core.game.entity.GEntity;
/*      */ import com.wanniu.core.logfs.Out;
/*      */ import com.wanniu.core.util.DateUtil;
/*      */ import com.wanniu.core.util.RandomUtil;
/*      */ import com.wanniu.core.util.StringUtil;
/*      */ import com.wanniu.game.GWorld;
/*      */ import com.wanniu.game.common.Const;
/*      */ import com.wanniu.game.common.ConstsTR;
/*      */ import com.wanniu.game.common.Utils;
/*      */ import com.wanniu.game.common.msg.WNNotifyManager;
/*      */ import com.wanniu.game.data.EquipSockCO;
/*      */ import com.wanniu.game.data.GameData;
/*      */ import com.wanniu.game.data.base.DEquipBase;
/*      */ import com.wanniu.game.data.base.DItemBase;
/*      */ import com.wanniu.game.data.base.FourProp;
/*      */ import com.wanniu.game.data.ext.AffixExt;
/*      */ import com.wanniu.game.data.ext.EnchantBonusExt;
/*      */ import com.wanniu.game.data.ext.EnchantExt;
/*      */ import com.wanniu.game.data.ext.EquipMakeExt;
/*      */ import com.wanniu.game.data.ext.EquipSockExt;
/*      */ import com.wanniu.game.data.ext.ReBornExt;
/*      */ import com.wanniu.game.data.ext.ReBuildExt;
/*      */ import com.wanniu.game.data.ext.RefineExt;
/*      */ import com.wanniu.game.data.ext.SeniorReBuildExt;
/*      */ import com.wanniu.game.data.ext.SmritiExt;
/*      */ import com.wanniu.game.data.ext.SuitListExt;
/*      */ import com.wanniu.game.item.ItemConfig;
/*      */ import com.wanniu.game.item.ItemUtil;
/*      */ import com.wanniu.game.item.NormalItem;
/*      */ import com.wanniu.game.item.data.AttsObj;
/*      */ import com.wanniu.game.item.po.PlayerItemPO;
/*      */ import com.wanniu.game.player.AttributeUtil;
/*      */ import com.wanniu.game.player.BILogService;
/*      */ import com.wanniu.game.player.GlobalConfig;
/*      */ import com.wanniu.game.player.WNPlayer;
/*      */ import com.wanniu.game.poes.PlayerBasePO;
/*      */ import com.wanniu.game.poes.RedPointPO;
/*      */ import com.wanniu.game.rank.RankType;
/*      */ import com.wanniu.game.sevengoal.SevenGoalManager;
/*      */ import com.wanniu.game.task.TaskUtils;
/*      */ import com.wanniu.redis.PlayerPOManager;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Date;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.concurrent.ConcurrentHashMap;
/*      */ import pomelo.Common;
/*      */ import pomelo.area.PlayerHandler;
/*      */ import pomelo.item.ItemOuterClass;
/*      */ import pomelo.player.PlayerOuterClass;
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
/*      */ public class EquipManager
/*      */ {
/*      */   public WNPlayer player;
/*      */   public Map<Integer, NormalEquip> equips;
/*      */   public Map<Integer, PlayerBasePO.EquipStrengthPos> strengthPos;
/*      */   public int effectTypeId;
/*      */   public boolean isEffectTypeFlush;
/*      */   public int maxStrengthLevel;
/*      */   public Map<Integer, Integer> redpoints;
/*      */   
/*      */   public EquipManager(WNPlayer player, Map<Integer, PlayerItemPO> equipDatas, Map<Integer, PlayerBasePO.EquipStrengthPos> strengthPos) {
/*   93 */     this.player = player;
/*   94 */     this.strengthPos = strengthPos;
/*   95 */     this.redpoints = new ConcurrentHashMap<>();
/*      */     
/*   97 */     _init(equipDatas);
/*      */   }
/*      */   
/*      */   private void _init(Map<Integer, PlayerItemPO> equipDatas) {
/*  101 */     this.equips = new ConcurrentHashMap<>();
/*      */     
/*  103 */     Iterator<Integer> keys = equipDatas.keySet().iterator();
/*  104 */     while (keys.hasNext()) {
/*  105 */       int gridIndex = ((Integer)keys.next()).intValue();
/*  106 */       if (equipDatas.get(Integer.valueOf(gridIndex)) == null)
/*      */         continue; 
/*  108 */       NormalEquip equip = (NormalEquip)ItemUtil.createItemByDbOpts(equipDatas.get(Integer.valueOf(gridIndex)));
/*  109 */       if (equip != null) {
/*  110 */         this.equips.put(Integer.valueOf(gridIndex), equip);
/*      */       }
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  120 */     this.maxStrengthLevel = EquipCraftConfig.getInstance().getMaxStrengthLevel();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public NormalEquip getEquipment(int pos) {
/*  128 */     return this.equips.get(Integer.valueOf(pos));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getEquipmentById(String id) {
/*  135 */     for (Iterator<Integer> iterator = this.equips.keySet().iterator(); iterator.hasNext(); ) { int pos = ((Integer)iterator.next()).intValue();
/*  136 */       NormalEquip equip = getEquipment(pos);
/*  137 */       if (equip != null && equip.itemDb.id.equals(id)) {
/*  138 */         return pos;
/*      */       } }
/*      */     
/*  141 */     return 0;
/*      */   }
/*      */   
/*      */   public NormalEquip getEquipById(String id) {
/*  145 */     for (Iterator<Integer> iterator = this.equips.keySet().iterator(); iterator.hasNext(); ) { int pos = ((Integer)iterator.next()).intValue();
/*  146 */       NormalEquip equip = this.equips.get(Integer.valueOf(pos));
/*  147 */       if (equip.itemDb.id.equals(id)) {
/*  148 */         return equip;
/*      */       } }
/*      */     
/*  151 */     return null;
/*      */   }
/*      */   
/*      */   public List<SmritiExt> findSmritiCO(int lv) {
/*  155 */     List<SmritiExt> list = GameData.findSmritis(t -> (t.level == lv));
/*      */ 
/*      */     
/*  158 */     return list;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ItemOuterClass.EquipGridStrengthInfo getStrenghInfo(int pos) {
/*  165 */     PlayerBasePO.EquipStrengthPos info = this.strengthPos.get(Integer.valueOf(pos));
/*  166 */     ItemOuterClass.EquipGridStrengthInfo.Builder data = ItemOuterClass.EquipGridStrengthInfo.newBuilder();
/*  167 */     data.setPos(pos);
/*  168 */     data.setEnSection(info.enSection);
/*  169 */     data.setEnLevel(info.enLevel);
/*  170 */     data.addAllJewelAtts(EquipUtil.toJson4Gem(info));
/*  171 */     data.setSocks(info.socks);
/*  172 */     return data.build();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<ItemOuterClass.EquipGridStrengthInfo> toJson4StrengthPos() {
/*  179 */     List<ItemOuterClass.EquipGridStrengthInfo> list = new ArrayList<>();
/*  180 */     if (this.strengthPos == null)
/*  181 */       return list; 
/*  182 */     for (Iterator<Integer> iterator = this.strengthPos.keySet().iterator(); iterator.hasNext(); ) { int pos = ((Integer)iterator.next()).intValue();
/*  183 */       list.add(getStrenghInfo(pos)); }
/*      */     
/*  185 */     return list;
/*      */   }
/*      */   
/*      */   public PlayerOuterClass.Equipments toJson4Payload() {
/*  189 */     PlayerOuterClass.Equipments.Builder data = PlayerOuterClass.Equipments.newBuilder();
/*  190 */     List<ItemOuterClass.Grid> equips = new ArrayList<>();
/*  191 */     for (Iterator<Integer> iterator = this.equips.keySet().iterator(); iterator.hasNext(); ) { int pos = ((Integer)iterator.next()).intValue();
/*  192 */       equips.add(getEquip4PayLoad(pos)); }
/*      */     
/*  194 */     data.addAllEquips(equips);
/*  195 */     return data.build();
/*      */   }
/*      */   
/*      */   public List<ItemOuterClass.ItemDetail> getAllEquipDetails4PayLoad() {
/*  199 */     List<ItemOuterClass.ItemDetail> data = new ArrayList<>();
/*  200 */     for (NormalEquip equip : this.equips.values()) {
/*  201 */       data.add(equip.getItemDetail(this.player.playerBasePO).build());
/*      */     }
/*  203 */     return data;
/*      */   }
/*      */   
/*      */   public ItemOuterClass.Grid getEquip4PayLoad(int pos) {
/*  207 */     ItemOuterClass.Grid.Builder equipGrid = ItemOuterClass.Grid.newBuilder();
/*  208 */     equipGrid.setGridIndex(pos);
/*  209 */     NormalItem equip = this.equips.get(Integer.valueOf(pos));
/*  210 */     if (equip != null) {
/*  211 */       equipGrid.setItem(equip.toJSON4GridPayload());
/*      */     }
/*  213 */     return equipGrid.build();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isAvatarPart(int pos) {
/*  222 */     boolean mainBool = (pos == Const.EquipType.MAIN_HAND.getValue());
/*  223 */     boolean clothBool = (pos == Const.EquipType.CLOTH.getValue());
/*  224 */     return (mainBool || clothBool);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean equip(NormalEquip equipment) {
/*  234 */     if (equipment != null) {
/*  235 */       NormalEquip oldequip = this.equips.get(Integer.valueOf(equipment.getPosition()));
/*      */       
/*  237 */       this.equips.put(Integer.valueOf(equipment.getPosition()), equipment);
/*      */       
/*  239 */       if (equipment.getBind() == 2) {
/*  240 */         equipment.setBind(1);
/*  241 */         _updateAndPush(new int[] { equipment.getPosition() }, true);
/*      */       } else {
/*  243 */         _updateAndPush(new int[] { equipment.getPosition() }, false);
/*      */       } 
/*      */       
/*  246 */       if (isAvatarPart(equipment.getPosition()) && StringUtil.isNotEmpty(equipment.prop.avatarId)) {
/*  247 */         if (oldequip == null) {
/*  248 */           if (equipment.getPosition() == Const.EquipType.CLOTH.getValue()) {
/*  249 */             if (!this.player.basicProp.model.equals(String.valueOf(equipment.prop.avatarId))) {
/*  250 */               this.player.refreshBattlerServerAvatar();
/*      */             }
/*  252 */           } else if (equipment.getPosition() == Const.EquipType.MAIN_HAND.getValue() && 
/*  253 */             !this.player.basicProp.weaponmodel.equals(String.valueOf(equipment.prop.avatarId))) {
/*  254 */             this.player.refreshBattlerServerAvatar();
/*      */           }
/*      */         
/*      */         }
/*  258 */         else if (oldequip.prop.avatarId != equipment.prop.avatarId) {
/*  259 */           this.player.refreshBattlerServerAvatar();
/*      */         } 
/*      */       }
/*      */ 
/*      */       
/*  264 */       equipSync(Const.GOODS_CHANGE_TYPE.equip);
/*      */       
/*  266 */       PlayerBasePO.EquipStrengthPos strengthLevel = this.strengthPos.get(Integer.valueOf(equipment.getPosition()));
/*  267 */       if (strengthLevel.enSection > 0 || strengthLevel.enLevel > 0) {
/*      */         
/*  269 */         this.player.taskManager.dealTaskEvent(Const.TaskType.TRAIN_EQUIP, String.valueOf(equipment.getPosition()), strengthLevel.enSection * (GlobalConfig.EquipmentCraft_Enchant_MaxenLevel + 1) + strengthLevel.enLevel);
/*  270 */         TaskUtils.dealTrainEquipAllTask(this.player);
/*      */       } 
/*  272 */       this.player.taskManager.dealTaskEvent(Const.TaskType.TAKE_EQUIP_Qt, equipment.getQLevel() + "|" + equipment.getQColor() + "|" + equipment.getPosition(), 1);
/*      */ 
/*      */       
/*  275 */       ansycReportEquipChange(equipment, 1, equipment.getPosition());
/*      */       
/*  277 */       return true;
/*      */     } 
/*  279 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void ansycReportEquipChange(NormalEquip equip, int type, int position) {
/*  285 */     if (equip.getQColor() < 4) {
/*      */       return;
/*      */     }
/*      */     try {
/*  289 */       Map<String, Object> data = new HashMap<>();
/*  290 */       data.put("equipCode", equip.prop.code);
/*  291 */       data.put("equipName", equip.prop.name);
/*      */       
/*  293 */       for (SuitListExt config : GameData.SuitLists.values()) {
/*  294 */         if (config.isValid == 0) {
/*      */           continue;
/*      */         }
/*  297 */         if (this.player.getLevel() < config.level) {
/*      */           continue;
/*      */         }
/*      */         
/*  301 */         if (config.partCodes.contains(equip.prop.code)) {
/*  302 */           data.put("suitID", Integer.valueOf(config.suitID));
/*  303 */           data.put("suitName", config.suitName);
/*      */           
/*      */           break;
/*      */         } 
/*      */       } 
/*  308 */       BILogService.getInstance().ansycReportEquipChange(this.player.getPlayer(), type, position, data);
/*  309 */     } catch (Exception e) {
/*  310 */       Out.warn(new Object[] { "ansycReportEquipChange", e });
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean unEquip(int position) {
/*  321 */     if (this.equips.size() == 0) {
/*  322 */       return false;
/*      */     }
/*  324 */     NormalEquip oldequip = this.equips.get(Integer.valueOf(position));
/*      */     
/*  326 */     this.equips.remove(Integer.valueOf(position));
/*      */     
/*  328 */     _updateAndPush(new int[] { position }, false);
/*  329 */     if (isAvatarPart(position)) {
/*  330 */       DEquipBase prop = oldequip.prop;
/*  331 */       if (oldequip.getPosition() == Const.EquipType.CLOTH.getValue()) {
/*  332 */         if (!this.player.basicProp.model.equals(String.valueOf(prop.avatarId))) {
/*  333 */           this.player.refreshBattlerServerAvatar();
/*      */         }
/*  335 */       } else if (oldequip.getPosition() == Const.EquipType.MAIN_HAND.getValue() && 
/*  336 */         !this.player.basicProp.weaponmodel.equals(String.valueOf(prop.avatarId))) {
/*  337 */         this.player.refreshBattlerServerAvatar();
/*      */       } 
/*      */     } 
/*      */     
/*  341 */     equipSync();
/*      */ 
/*      */     
/*  344 */     ansycReportEquipChange(oldequip, 2, oldequip.getPosition());
/*      */     
/*  346 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean DropEquipAndReturn(int position) {
/*  357 */     if (unEquip(position)) {
/*  358 */       return true;
/*      */     }
/*  360 */     return false;
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
/*      */   public boolean fillGem(int pos, int[] index, String code, WNPlayer player) {
/*  372 */     PlayerBasePO.EquipStrengthPos posInfo = this.strengthPos.get(Integer.valueOf(pos));
/*  373 */     if (posInfo != null && 
/*  374 */       EquipUtil.fillGem(posInfo, index, code, player)) {
/*  375 */       _updateAndPushPOS(new int[] { pos }, true);
/*      */       
/*  377 */       equipSync();
/*  378 */       this.player.getPlayerTasks().dealTaskEvent(Const.TaskType.FILL_GEM, code, 1);
/*      */       
/*  380 */       updateGemLevelRank();
/*      */ 
/*      */       
/*  383 */       player.achievementManager.onGemFillTotalLevel();
/*      */       
/*  385 */       updateFillGemScript(null);
/*  386 */       return true;
/*      */     } 
/*      */     
/*  389 */     return false;
/*      */   }
/*      */   
/*      */   public void updateGemLevelRank() {
/*  393 */     int level = 0;
/*  394 */     for (PlayerBasePO.EquipStrengthPos pos : this.player.equipManager.strengthPos.values()) {
/*  395 */       for (String code : pos.gems.values()) {
/*  396 */         if (StringUtil.isEmpty(code))
/*      */           continue; 
/*  398 */         DItemBase prop = ItemUtil.getUnEquipPropByCode(code);
/*  399 */         level += prop.levelReq;
/*      */       } 
/*      */     } 
/*      */     
/*  403 */     this.player.rankManager.onEvent(RankType.GemLevel, new Object[] { Integer.valueOf(level) });
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
/*      */   public boolean unfillGem(int pos, int index) {
/*  415 */     PlayerBasePO.EquipStrengthPos posInfo = this.strengthPos.get(Integer.valueOf(pos));
/*  416 */     if (posInfo != null) {
/*  417 */       String code = (String)posInfo.gems.get(Integer.valueOf(index));
/*  418 */       if (StringUtil.isEmpty(code)) {
/*  419 */         return false;
/*      */       }
/*      */       
/*  422 */       posInfo.gems.remove(Integer.valueOf(index));
/*      */       
/*  424 */       NormalItem item = ItemUtil.createItemsByItemCode(code, 1).get(0);
/*  425 */       this.player.bag.addEntityItem(item, Const.GOODS_CHANGE_TYPE.equipmosaic, null, false, false);
/*      */       
/*  427 */       _updateAndPushPOS(new int[] { pos }, true);
/*  428 */       equipSync();
/*      */ 
/*      */       
/*  431 */       updateGemLevelRank();
/*  432 */       return true;
/*      */     } 
/*  434 */     return false;
/*      */   }
/*      */   
/*      */   public void _updateAndPushPOS(int[] gridIndexs, boolean refresh) {
/*  438 */     update();
/*  439 */     WNNotifyManager.getInstance().pushEquipmentPOS(this.player, gridIndexs, refresh);
/*  440 */     WNNotifyManager.getInstance().pushEquipmentDynamic(this.player, gridIndexs, refresh);
/*      */   }
/*      */   
/*      */   public void _updateAndPush(int[] gridIndexs, boolean refresh) {
/*  444 */     _updateAndPush(gridIndexs, refresh, true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void _updateAndPush(int[] gridIndexs, boolean refresh, boolean isDressed) {
/*  451 */     update();
/*  452 */     if (isDressed) {
/*  453 */       WNNotifyManager.getInstance().pushEquipmentDynamic(this.player, gridIndexs, refresh);
/*      */     } else {
/*  455 */       List<Integer> list = new ArrayList<>();
/*  456 */       for (int pos : gridIndexs) {
/*  457 */         list.add(Integer.valueOf(pos));
/*      */       }
/*  459 */       WNNotifyManager.getInstance().pushBagItemDynamic(this.player, list, refresh);
/*      */     } 
/*      */   }
/*      */   
/*      */   public Map<String, Integer> calAllInfluence() {
/*  464 */     Map<String, Integer> data = new ConcurrentHashMap<>(); Iterator<Integer> iterator;
/*  465 */     for (iterator = this.strengthPos.keySet().iterator(); iterator.hasNext(); ) { int position = ((Integer)iterator.next()).intValue();
/*      */       
/*  467 */       NormalEquip equip = getEquipment(position);
/*      */ 
/*      */       
/*  470 */       if (equip != null) {
/*  471 */         if (equip.speData.extAtts == null) {
/*  472 */           Utils.deepCopy(data, equip.prop.fixedAtts);
/*      */         } else {
/*  474 */           Utils.deepCopyAffix(data, equip.speData.extAtts, equip.getQColor());
/*      */         } 
/*  476 */         if (equip.speData.extAttsAdd != null) {
/*  477 */           Utils.deepCopy(data, equip.speData.extAttsAdd);
/*      */         }
/*      */         
/*  480 */         Utils.deepCopyAffix(data, equip.speData.legendAtts, equip.getQColor());
/*      */       } 
/*      */       
/*  483 */       PlayerBasePO.EquipStrengthPos strengthInfo = this.strengthPos.get(Integer.valueOf(position));
/*  484 */       if (strengthInfo == null || (strengthInfo.enSection == 0 && strengthInfo.enLevel == 0)) {
/*  485 */         if (equip != null) {
/*  486 */           Utils.deepCopy(data, equip.speData.baseAtts);
/*      */         }
/*      */         continue;
/*      */       } 
/*  490 */       if (equip != null) {
/*  491 */         EnchantExt enchantExt = (EnchantExt)GameData.Enchants.get(Integer.valueOf(strengthInfo.enSection * 100 + strengthInfo.enLevel));
/*  492 */         if (equip.speData.baseAtts != null && enchantExt != null) {
/*  493 */           for (String key : equip.speData.baseAtts.keySet()) {
/*  494 */             int value = ((Integer)equip.speData.baseAtts.get(key)).intValue();
/*  495 */             value = value * (10000 + enchantExt.propPer) / 10000;
/*  496 */             if (data.containsKey(key)) {
/*  497 */               data.put(key, Integer.valueOf(((Integer)data.get(key)).intValue() + value)); continue;
/*      */             } 
/*  499 */             data.put(key, Integer.valueOf(value));
/*      */           } 
/*      */         }
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/*  506 */       if (strengthInfo.enSection > 0) {
/*  507 */         for (int section = 1; section <= strengthInfo.enSection; section++) {
/*  508 */           for (EnchantBonusExt enchantBonusCO : GameData.EnchantBonuss.values()) {
/*  509 */             if (enchantBonusCO._type == position && enchantBonusCO.enClass == section) {
/*  510 */               if (data.containsKey(enchantBonusCO._prop)) {
/*  511 */                 data.put(enchantBonusCO._prop, Integer.valueOf(((Integer)data.get(enchantBonusCO._prop)).intValue() + enchantBonusCO.min)); break;
/*      */               } 
/*  513 */               data.put(enchantBonusCO._prop, Integer.valueOf(enchantBonusCO.min));
/*      */ 
/*      */               
/*      */               break;
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       } }
/*      */ 
/*      */ 
/*      */     
/*  524 */     for (iterator = this.strengthPos.keySet().iterator(); iterator.hasNext(); ) { int position = ((Integer)iterator.next()).intValue();
/*  525 */       PlayerBasePO.EquipStrengthPos strengthInfo = this.strengthPos.get(Integer.valueOf(position));
/*  526 */       for (Iterator<Integer> iterator1 = strengthInfo.gems.keySet().iterator(); iterator1.hasNext(); ) { int index = ((Integer)iterator1.next()).intValue();
/*  527 */         String code = (String)strengthInfo.gems.get(Integer.valueOf(index));
/*  528 */         DItemBase prop = (DItemBase)ItemConfig.getInstance().getItemProp(code);
/*  529 */         String key = AttributeUtil.getKeyByName(prop.prop);
/*  530 */         if (StringUtil.isEmpty(key)) {
/*  531 */           Out.error(new Object[] { EquipUtil.class, "Equip fillGem config error code ", code, ",index=", Integer.valueOf(index) });
/*      */           
/*      */           continue;
/*      */         } 
/*  535 */         String gemProp = AttributeUtil.getKeyByName(prop.prop);
/*  536 */         int gemValue = prop.min;
/*  537 */         if (data.containsKey(gemProp)) {
/*  538 */           data.put(gemProp, Integer.valueOf(((Integer)data.get(gemProp)).intValue() + gemValue)); continue;
/*      */         } 
/*  540 */         data.put(gemProp, Integer.valueOf(gemValue)); }
/*      */        }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  546 */     List<IntIntPair> list_suits = EquipCraftConfig.getInstance().getValidSuits(this.player);
/*  547 */     Map<String, Integer> suitAttr = EquipCraftConfig.getInstance().getSuitAtts(list_suits);
/*  548 */     Utils.deepCopy(data, suitAttr);
/*      */     
/*  550 */     return data;
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
/*      */   public void sendNotice(WNPlayer player, NormalEquip equip) {}
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
/*      */   public Object[] equipStrengthen(int pos) {
/*  591 */     NormalEquip equip = getEquipment(pos);
/*  592 */     Object[] result = { Boolean.valueOf(true), Integer.valueOf(0) };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  599 */     PlayerBasePO.EquipStrengthPos pair = this.strengthPos.get(Integer.valueOf(pos));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  609 */     EnchantExt enchantExt = EquipUtil.getStrengthConfig(pair.enSection, pair.enLevel);
/*  610 */     if (enchantExt == null) {
/*  611 */       Out.error(new Object[] { "无法获取强化配置！" });
/*  612 */       return result;
/*      */     } 
/*      */ 
/*      */     
/*  616 */     int oldLevel = pair.enSection * 100 + pair.enLevel;
/*      */     
/*  618 */     pair.enSection = enchantExt.enClass;
/*  619 */     pair.enLevel = enchantExt.enLevel;
/*  620 */     Out.info(new Object[] { "强化部位 playerId=", this.player.getId(), ",pos=", Integer.valueOf(pos), ",level=", Integer.valueOf(pair.enSection * 10 + pair.enLevel) });
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  625 */     int tmpEffectTypeId = EquipUtil.getEffectTypeId(pair.enSection, pair.enLevel);
/*  626 */     if (this.effectTypeId != tmpEffectTypeId) {
/*  627 */       this.isEffectTypeFlush = true;
/*      */     } else {
/*  629 */       this.isEffectTypeFlush = false;
/*      */     } 
/*  631 */     this.effectTypeId = tmpEffectTypeId;
/*      */     
/*  633 */     if (((Boolean)result[0]).booleanValue()) {
/*  634 */       sendNotice(this.player, equip);
/*      */       
/*  636 */       _updateAndPushPOS(new int[] { pos }, true);
/*      */       
/*  638 */       if (isAvatarPart(pos) && 
/*  639 */         this.isEffectTypeFlush) {
/*  640 */         this.player.refreshBattlerServerAvatar();
/*      */       }
/*      */       
/*  643 */       equipSync();
/*  644 */       int newLevel = pair.enSection * (GlobalConfig.EquipmentCraft_Enchant_MaxenLevel + 1) + pair.enLevel;
/*  645 */       this.player.taskManager.dealTaskEvent(Const.TaskType.TRAIN_EQUIP, String.valueOf(pos), newLevel);
/*  646 */       TaskUtils.dealTrainEquipAllTask(this.player);
/*  647 */       this.player.achievementManager.equipEnhance(pos, newLevel);
/*  648 */       this.player.achievementManager.onEquipPosStrengthLevel(pos, newLevel);
/*      */       
/*  650 */       updateStrengthScript(null);
/*      */       
/*  652 */       this.player.sevenGoalManager.processGoal(SevenGoalManager.SevenGoalTaskType.EQUIP_STRENTHEN_COUNT, new Object[] { Integer.valueOf(getTotalStrenthenLv()) });
/*      */       
/*  654 */       BILogService.getInstance().ansycReportStrengthenCultivate(this.player.getPlayer(), pos, oldLevel, pair.enSection * 100 + pair.enLevel, enchantExt.mates);
/*  655 */       return result;
/*      */     } 
/*      */     
/*  658 */     return result;
/*      */   }
/*      */   
/*      */   private void equipSync() {
/*  662 */     equipSync(Const.GOODS_CHANGE_TYPE.def);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void equipSync(Const.GOODS_CHANGE_TYPE from) {
/*  669 */     this.player.btlDataManager.data_equip = calAllInfluence();
/*  670 */     this.player.onEquipChange(from);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int weaponNum() {
/*  679 */     int num = 0;
/*  680 */     if (this.equips.get(Integer.valueOf(Const.EquipType.MAIN_HAND.getValue())) != null) {
/*  681 */       num++;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  689 */     return num;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean haveBothHandWeapon() {
/*  698 */     NormalEquip mainH = this.equips.get(Integer.valueOf(Const.EquipType.MAIN_HAND.getValue()));
/*  699 */     if (mainH != null && mainH.prop.isBothHand == 1) {
/*  700 */       return true;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  709 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean haveSingleHandWeapon() {
/*  718 */     NormalEquip mainH = this.equips.get(Integer.valueOf(Const.EquipType.MAIN_HAND.getValue()));
/*  719 */     if (mainH != null && mainH.prop.isBothHand == 0) {
/*  720 */       return true;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  729 */     return false;
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
/*      */   public static class ResultEquipNumAndQt
/*      */   {
/*      */     public boolean isEnoughNum;
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
/*      */     public int value;
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
/*      */   public ResultEquipNumAndQt equipNumAndQt(int num, int qt) {
/*  788 */     ResultEquipNumAndQt result = new ResultEquipNumAndQt();
/*  789 */     result.isEnoughNum = false;
/*  790 */     result.value = 0;
/*  791 */     int equpNum = 0;
/*  792 */     for (Iterator<Integer> iterator = this.equips.keySet().iterator(); iterator.hasNext(); ) { int pos = ((Integer)iterator.next()).intValue();
/*  793 */       NormalEquip equip = this.equips.get(Integer.valueOf(pos));
/*  794 */       if (qt != 0) {
/*  795 */         if (equip.getQColor() >= qt)
/*  796 */           equpNum++; 
/*      */         continue;
/*      */       } 
/*  799 */       equpNum++; }
/*      */ 
/*      */     
/*  802 */     if (equpNum >= num) {
/*  803 */       result.isEnoughNum = true;
/*      */     }
/*  805 */     result.value = equpNum;
/*  806 */     return result;
/*      */   }
/*      */ 
/*      */   
/*      */   public static class EquipAndLevelData
/*      */   {
/*      */     public int maxLevel;
/*      */     
/*      */     public Map<Integer, PlayerBasePO.EquipStrengthPos> equips;
/*      */   }
/*      */ 
/*      */   
/*      */   public EquipAndLevelData getAllEquipAndLevel() {
/*  819 */     EquipAndLevelData arr = new EquipAndLevelData();
/*  820 */     arr.equips = new HashMap<>();
/*  821 */     arr.maxLevel = 0;
/*  822 */     for (Map.Entry<Integer, PlayerBasePO.EquipStrengthPos> node : this.strengthPos.entrySet()) {
/*  823 */       PlayerBasePO.EquipStrengthPos sectionAndLevel = node.getValue();
/*  824 */       arr.equips.put(node.getKey(), node.getValue());
/*      */       
/*  826 */       int maxLevel = sectionAndLevel.enSection * (GlobalConfig.EquipmentCraft_Enchant_MaxenLevel + 1) + sectionAndLevel.enLevel;
/*  827 */       if (arr.maxLevel < maxLevel) {
/*  828 */         arr.maxLevel = maxLevel;
/*      */       }
/*      */     } 
/*  831 */     return arr;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int hasAllStrenghLevel(int lv) {
/*  838 */     int validNum = 0;
/*  839 */     for (int i = 1; i <= Const.EquipType.CHARM.getValue(); i++) {
/*  840 */       PlayerBasePO.EquipStrengthPos pair = this.strengthPos.get(Integer.valueOf(i));
/*  841 */       if (pair != null)
/*      */       {
/*      */         
/*  844 */         if (pair.enLevel >= lv)
/*  845 */           validNum++; 
/*      */       }
/*      */     } 
/*  848 */     return validNum;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void reborn(NormalEquip equip, int pos, boolean isDressed) {
/*  855 */     if (equip.itemDb.isNew == 1) {
/*  856 */       equip.itemDb.isNew = 0;
/*      */     }
/*  858 */     DEquipBase finalProp = equip.prop;
/*  859 */     if (StringUtil.isNotEmpty(equip.prop.baseCode)) {
/*  860 */       finalProp = ItemConfig.getInstance().getEquipProp(equip.prop.baseCode);
/*      */     }
/*      */     
/*  863 */     equip.speData.tempBaseAtts = new HashMap<>();
/*  864 */     for (String attrName : finalProp.baseAtts.keySet()) {
/*  865 */       FourProp pair = (FourProp)finalProp.baseAtts.get(attrName);
/*  866 */       if (pair == null) {
/*      */         continue;
/*      */       }
/*  869 */       equip.speData.tempBaseAtts.put(pair.prop, Integer.valueOf(RandomUtil.getInt(pair.min, pair.max)));
/*      */     } 
/*  871 */     if (isDressed) {
/*  872 */       _updateAndPush(new int[] { pos }, true);
/*      */     } else {
/*      */       
/*  875 */       _updateAndPush(new int[] { pos }, true, false);
/*      */     } 
/*      */ 
/*      */     
/*  879 */     this.player.taskManager.dealTaskEvent(Const.TaskType.EQUIP_REBORN, "", 1);
/*      */     
/*  881 */     this.player.achievementManager.onEquipReborn();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void saveReborn(NormalEquip equip, int pos, boolean isDressed) {
/*  888 */     if (equip.speData.tempBaseAtts == null) {
/*      */       return;
/*      */     }
/*  891 */     if (equip.itemDb.isNew == 1) {
/*  892 */       equip.itemDb.isNew = 0;
/*      */     }
/*  894 */     equip.speData.baseAtts = equip.speData.tempBaseAtts;
/*  895 */     equip.speData.tempBaseAtts = null;
/*      */     
/*  897 */     if (isDressed) {
/*  898 */       _updateAndPush(new int[] { pos }, true);
/*  899 */       equipSync(Const.GOODS_CHANGE_TYPE.saveReborn);
/*      */     } else {
/*  901 */       _updateAndPush(new int[] { pos }, true, false);
/*      */     } 
/*      */   }
/*      */   
/*      */   private boolean contain(List<Integer> val, int index) {
/*  906 */     for (Iterator<Integer> iterator = val.iterator(); iterator.hasNext(); ) { int i = ((Integer)iterator.next()).intValue();
/*  907 */       if (i == index) {
/*  908 */         return true;
/*      */       } }
/*      */ 
/*      */     
/*  912 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean checkRebuildLocks(List<Integer> lockIndexs, int attrSize) {
/*  923 */     int maxLockSize = getCanLockNum(attrSize);
/*      */     
/*  925 */     if (maxLockSize < 0 || lockIndexs.size() > maxLockSize) {
/*  926 */       return false;
/*      */     }
/*      */     
/*  929 */     for (Iterator<Integer> iterator = lockIndexs.iterator(); iterator.hasNext(); ) { int lockIndex = ((Integer)iterator.next()).intValue();
/*  930 */       if (lockIndex < 1 || lockIndex > attrSize) {
/*  931 */         return false;
/*      */       } }
/*      */ 
/*      */     
/*  935 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int getCanLockNum(int attrSize) {
/*  945 */     int maxLockSize = 0;
/*      */     
/*  947 */     switch (attrSize) {
/*      */       case 3:
/*  949 */         maxLockSize = GlobalConfig.Equipment_ReBuild_MaxNumtoLock3;
/*      */         break;
/*      */       case 4:
/*  952 */         maxLockSize = GlobalConfig.Equipment_ReBuild_MaxNumtoLock4;
/*      */         break;
/*      */       case 5:
/*  955 */         maxLockSize = GlobalConfig.Equipment_ReBuild_MaxNumtoLock5;
/*      */         break;
/*      */     } 
/*      */     
/*  959 */     return maxLockSize;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void rebuild(NormalEquip equip, int pos, boolean isDressed, List<Integer> lockedAttIdList) {
/*  966 */     if (equip.itemDb.isNew == 1) {
/*  967 */       equip.itemDb.isNew = 0;
/*      */     }
/*  969 */     equip.speData.tempExtAtts = new RepeatKeyMap<>();
/*  970 */     equip.speData.tempExtAttsAdd = null;
/*      */     
/*  972 */     int index = 1;
/*      */     
/*  974 */     for (RepeatKeyMap.Pair<Integer, Integer> rp : (Iterable<RepeatKeyMap.Pair<Integer, Integer>>)equip.speData.extAtts.entrySet()) {
/*  975 */       if (contain(lockedAttIdList, index)) {
/*  976 */         equip.speData.tempExtAtts.put(rp.k, rp.v);
/*      */       } else {
/*  978 */         equip.speData.tempExtAtts.put(new RepeatKeyMap.Pair<>(Integer.valueOf(0), Integer.valueOf(0)));
/*      */       } 
/*  980 */       index++;
/*      */     } 
/*      */     
/*  983 */     DEquipBase finalProp = equip.prop;
/*  984 */     if (StringUtil.isNotEmpty(equip.prop.baseCode)) {
/*  985 */       finalProp = ItemConfig.getInstance().getEquipProp(equip.prop.baseCode);
/*      */     }
/*      */     
/*  988 */     ItemUtil.initRebuildExtAtts(equip.speData.tempExtAtts, finalProp, (equip.speData.extAtts == null) ? equip.prop.fixedAtts.size() : equip.speData.extAtts.size(), lockedAttIdList.size());
/*  989 */     Map<String, Integer> exarAttr = ItemUtil.getSameAttsExtAttributes(equip.speData.tempExtAtts, equip.prop.type, equip.prop.code);
/*  990 */     if (exarAttr != null) {
/*  991 */       equip.speData.tempExtAttsAdd = exarAttr;
/*      */     }
/*      */     
/*  994 */     if (isDressed) {
/*  995 */       _updateAndPush(new int[] { pos }, true);
/*      */     } else {
/*  997 */       _updateAndPush(new int[] { pos }, true, false);
/*      */     } 
/*      */ 
/*      */     
/* 1001 */     this.player.taskManager.dealTaskEvent(Const.TaskType.EQUIP_REBUILD, "", 1);
/* 1002 */     this.player.achievementManager.onEquipRebuild();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void seniorRebuild(NormalEquip equip, int pos, boolean isDressed) {
/* 1010 */     if (equip.itemDb.isNew == 1) {
/* 1011 */       equip.itemDb.isNew = 0;
/*      */     }
/*      */     
/* 1014 */     equip.speData.tempExtAtts_senior = new RepeatKeyMap<>();
/*      */     
/* 1016 */     DEquipBase finalProp = equip.prop;
/* 1017 */     if (StringUtil.isNotEmpty(equip.prop.baseCode)) {
/* 1018 */       finalProp = ItemConfig.getInstance().getEquipProp(equip.prop.baseCode);
/*      */     }
/*      */     
/* 1021 */     ItemUtil.seniorInitExtAtts(equip.speData.extAtts, equip.speData.tempExtAtts_senior, finalProp);
/*      */     
/* 1023 */     if (isDressed) {
/* 1024 */       _updateAndPush(new int[] { pos }, true);
/* 1025 */       equipSync();
/*      */     } else {
/* 1027 */       _updateAndPush(new int[] { pos }, true, false);
/*      */     } 
/*      */ 
/*      */     
/* 1031 */     this.player.taskManager.dealTaskEvent(Const.TaskType.EQUIP_REBUILD, "", 1);
/* 1032 */     this.player.achievementManager.onEquipRebuild();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void saveRebuild(NormalEquip equip, int pos, boolean isDressed) {
/* 1039 */     if (equip.speData.tempExtAtts == null) {
/*      */       return;
/*      */     }
/* 1042 */     if (equip.itemDb.isNew == 1) {
/* 1043 */       equip.itemDb.isNew = 0;
/*      */     }
/* 1045 */     equip.speData.extAtts = equip.speData.tempExtAtts;
/* 1046 */     equip.speData.extAttsAdd = equip.speData.tempExtAttsAdd;
/* 1047 */     equip.speData.tempExtAttsAdd = null;
/* 1048 */     equip.speData.tempExtAtts = null;
/*      */     
/* 1050 */     equip.speData.tempExtAtts_senior = null;
/*      */ 
/*      */     
/* 1053 */     equip.speData.tempUniqueAtts = null;
/*      */     
/* 1055 */     if (isDressed) {
/* 1056 */       _updateAndPush(new int[] { pos }, true);
/* 1057 */       equipSync(Const.GOODS_CHANGE_TYPE.saveReborn);
/*      */     } else {
/* 1059 */       _updateAndPush(new int[] { pos }, true, false);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void smritiEquip(NormalEquip leftEquip, int leftPos, boolean leftIsDressed, NormalEquip rightEquip, int rightPos, boolean rightIsDressed) {
/* 1064 */     rightEquip.speData.extAtts.clear();
/* 1065 */     copyAtts(leftEquip, rightEquip, leftEquip.speData.extAtts, rightEquip.speData.extAtts);
/* 1066 */     rightEquip.speData.extAttsAdd = leftEquip.speData.extAttsAdd;
/*      */ 
/*      */     
/* 1069 */     leftEquip.speData.extAtts.clear();
/* 1070 */     leftEquip.speData.extAttsAdd = null;
/*      */     
/* 1072 */     if (leftEquip.itemDb.isNew == 1) {
/* 1073 */       leftEquip.itemDb.isNew = 0;
/*      */     }
/*      */     
/* 1076 */     if (rightEquip.itemDb.isNew == 1) {
/* 1077 */       rightEquip.itemDb.isNew = 0;
/*      */     }
/*      */     
/* 1080 */     ItemUtil.initExtAtts(leftEquip.speData.extAtts, leftEquip.prop, 0, 0);
/*      */     
/* 1082 */     _updateAndPush(new int[] { leftPos }, true, leftIsDressed);
/* 1083 */     _updateAndPush(new int[] { rightPos }, true, rightIsDressed);
/*      */     
/* 1085 */     if (leftIsDressed || rightIsDressed) {
/* 1086 */       equipSync(Const.GOODS_CHANGE_TYPE.smriti_equip);
/*      */     }
/*      */   }
/*      */   
/*      */   private void copyAtts(NormalEquip leftEquip, NormalEquip rightEquip, RepeatKeyMap<Integer, Integer> source, RepeatKeyMap<Integer, Integer> dist) {
/* 1091 */     if (source != null && !source.isEmpty()) {
/* 1092 */       List<RepeatKeyMap.Pair<Integer, Integer>> list = source.getValues();
/* 1093 */       for (RepeatKeyMap.Pair<Integer, Integer> k : list) {
/* 1094 */         AffixExt affix = (AffixExt)GameData.Affixs.get(k.k);
/* 1095 */         if (affix == null) {
/* 1096 */           Out.warn(new Object[] { "key=" + k.k + " val=" + k.v });
/*      */           continue;
/*      */         } 
/* 1099 */         AffixExt finalAffix = ItemUtil.getFixOneAtts(rightEquip.prop.tcLevel, rightEquip.prop.type, rightEquip.prop.pro, Const.AffixType.normal, affix.attName);
/* 1100 */         if (finalAffix == null) {
/* 1101 */           dist.put((Integer)k.k, (Integer)k.v);
/* 1102 */           Out.error(new Object[] { "smritiEquip can't find dist attr。src:" + leftEquip.getId() + "," + k.k + "," + k.v + " dist:" + rightEquip.getId() });
/*      */           continue;
/*      */         } 
/* 1105 */         FourProp rdProp = (FourProp)finalAffix.props.get(Integer.valueOf(rightEquip.prop.qcolor));
/* 1106 */         if (rdProp == null) {
/* 1107 */           dist.put(Integer.valueOf(finalAffix.iD), (Integer)k.v);
/* 1108 */           Out.error(new Object[] { "smritiEquip can't find dist qcolor。src:" + leftEquip.getId() + "," + k.k + "," + k.v + " dist:" + rightEquip.getId() });
/*      */           
/*      */           continue;
/*      */         } 
/* 1112 */         int finalVal = ((Integer)k.v).intValue();
/* 1113 */         if (finalVal > rdProp.max) {
/* 1114 */           finalVal = rdProp.max;
/* 1115 */           Out.error(new Object[] { "smritiEquip exceed max value。src:" + leftEquip.getId() + "," + k.k + "," + k.v + " dist:" + rightEquip.getId() + "," + k.k + "," + rdProp.max });
/*      */         } 
/* 1117 */         int min = ItemUtil.calcRebuildPropMin(rdProp.min);
/* 1118 */         if (finalVal < min) {
/* 1119 */           finalVal = min;
/* 1120 */           Out.info(new Object[] { "smritiEquip less min value。src:" + leftEquip.getId() + "," + k.k + "," + k.v + " dist:" + rightEquip.getId() + "," + k.k + "," + min });
/*      */         } 
/* 1122 */         dist.put(Integer.valueOf(finalAffix.iD), Integer.valueOf(finalVal));
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void saveSeniorRebuild(NormalEquip equip, int pos, boolean isDressed) {
/* 1131 */     if (equip.speData.tempExtAtts_senior == null) {
/*      */       return;
/*      */     }
/* 1134 */     if (equip.itemDb.isNew == 1) {
/* 1135 */       equip.itemDb.isNew = 0;
/*      */     }
/* 1137 */     equip.speData.extAtts = equip.speData.tempExtAtts_senior;
/*      */     
/* 1139 */     equip.speData.tempExtAtts_senior = null;
/*      */ 
/*      */     
/* 1142 */     equip.speData.tempUniqueAtts = null;
/*      */     
/* 1144 */     if (isDressed) {
/* 1145 */       _updateAndPush(new int[] { pos }, true);
/* 1146 */       equipSync(Const.GOODS_CHANGE_TYPE.saveReborn);
/*      */     } else {
/* 1148 */       _updateAndPush(new int[] { pos }, true, false);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void refineLegend(NormalEquip equip, int pos, boolean isDressed) {
/* 1159 */     if (equip.itemDb.speData.legendAtts == null) {
/*      */       return;
/*      */     }
/*      */     
/* 1163 */     if (equip.itemDb.isNew == 1) {
/* 1164 */       equip.itemDb.isNew = 0;
/*      */     }
/*      */     
/* 1167 */     List<Integer> usedGroupId = new ArrayList<>();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1173 */     DEquipBase finalProp = equip.prop;
/* 1174 */     if (StringUtil.isNotEmpty(equip.prop.baseCode)) {
/* 1175 */       finalProp = ItemConfig.getInstance().getEquipProp(equip.prop.baseCode);
/*      */     }
/*      */     
/* 1178 */     AffixExt affxExt = ItemUtil.initOneAtts(finalProp, usedGroupId, Const.AffixType.legend);
/*      */     
/* 1180 */     FourProp rdProp = (FourProp)affxExt.props.get(Integer.valueOf(equip.prop.qcolor));
/* 1181 */     if (rdProp == null) {
/*      */       return;
/*      */     }
/*      */     
/* 1185 */     equip.speData.tempUniqueAtts = new HashMap<>();
/* 1186 */     equip.speData.tempUniqueAtts.put(Integer.valueOf(affxExt.iD), Integer.valueOf(RandomUtil.getInt(rdProp.min, rdProp.max)));
/*      */     
/* 1188 */     if (isDressed) {
/* 1189 */       _updateAndPush(new int[] { pos }, true);
/* 1190 */       equipSync();
/*      */     } else {
/* 1192 */       _updateAndPush(new int[] { pos }, true, false);
/*      */     } 
/*      */ 
/*      */     
/* 1196 */     this.player.taskManager.dealTaskEvent(Const.TaskType.EQUIP_REFINE, "", 1);
/* 1197 */     this.player.achievementManager.onEquipRefine();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void saveRefineLegend(NormalEquip equip, int pos, boolean isDressed) {
/* 1204 */     if (equip.speData.tempUniqueAtts == null) {
/*      */       return;
/*      */     }
/* 1207 */     if (equip.itemDb.isNew == 1) {
/* 1208 */       equip.itemDb.isNew = 0;
/*      */     }
/*      */ 
/*      */     
/* 1212 */     equip.itemDb.speData.legendAtts = equip.speData.tempUniqueAtts;
/* 1213 */     equip.speData.tempUniqueAtts = null;
/*      */     
/* 1215 */     if (isDressed) {
/* 1216 */       _updateAndPush(new int[] { pos }, true);
/* 1217 */       equipSync();
/*      */     } else {
/* 1219 */       _updateAndPush(new int[] { pos }, true, false);
/*      */     } 
/*      */   }
/*      */   
/*      */   public List<Common.AttributeBase> getRefineExtProp(NormalEquip equip) {
/* 1224 */     List<Common.AttributeBase> result = new ArrayList<>();
/* 1225 */     DEquipBase extProp = equip.prop;
/* 1226 */     if (StringUtil.isNotEmpty(equip.prop.baseCode)) {
/* 1227 */       extProp = ItemConfig.getInstance().getEquipProp(equip.prop.baseCode);
/*      */     }
/*      */     
/* 1230 */     List<AttsObj> extAtts = new ArrayList<>();
/* 1231 */     ItemUtil.initAllExtAtts(extAtts, extProp);
/*      */     
/* 1233 */     for (AttsObj att : extAtts) {
/* 1234 */       result.add(EquipUtil.getAttributeBase(att));
/*      */     }
/* 1236 */     return result;
/*      */   }
/*      */   
/*      */   public List<PlayerHandler.SuperScriptType> getSuperScript() {
/* 1240 */     List<PlayerHandler.SuperScriptType> list = new ArrayList<>();
/* 1241 */     list.addAll(getWorkSuperScript());
/* 1242 */     list.addAll(getStrengthSuperScript());
/* 1243 */     list.addAll(getGemFillSuperScript(null));
/* 1244 */     list.addAll(getEquipSuperScript(null));
/* 1245 */     return list;
/*      */   }
/*      */   
/*      */   public void pushScripts() {
/* 1249 */     PlayerHandler.SuperScriptPush.Builder data = PlayerHandler.SuperScriptPush.newBuilder();
/* 1250 */     List<PlayerHandler.SuperScriptType> list = getWorkSuperScript();
/* 1251 */     if (list != null && !list.isEmpty()) {
/* 1252 */       data.addAllS2CData(list);
/* 1253 */       this.player.receive("area.playerPush.onSuperScriptPush", (GeneratedMessage)data.build());
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public int getMakePoint() {
/* 1259 */     if (!this.player.functionOpenManager.isOpen(Const.FunctionType.Make.getValue())) {
/* 1260 */       return 0;
/*      */     }
/* 1262 */     int number = 0;
/* 1263 */     for (EquipMakeExt make : GameData.EquipMakes.values()) {
/* 1264 */       if (this.player.player.gold < make.costMoney) {
/*      */         continue;
/*      */       }
/* 1267 */       if (StringUtil.isNotEmpty(make.reqMateCode1) && 
/* 1268 */         this.player.bag.findItemNumByCode(make.reqMateCode1) < make.reqMateCount1) {
/*      */         continue;
/*      */       }
/*      */       
/* 1272 */       if (StringUtil.isNotEmpty(make.reqMateCode2) && 
/* 1273 */         this.player.bag.findItemNumByCode(make.reqMateCode2) < make.reqMateCount2) {
/*      */         continue;
/*      */       }
/*      */       
/* 1277 */       if (StringUtil.isNotEmpty(make.reqMateCode3) && 
/* 1278 */         this.player.bag.findItemNumByCode(make.reqMateCode3) < make.reqMateCount3) {
/*      */         continue;
/*      */       }
/*      */       
/* 1282 */       if (this.player.getLevel() / 10 * 10 != make.equipLevel) {
/*      */         continue;
/*      */       }
/* 1285 */       number = 1;
/*      */     } 
/*      */     
/* 1288 */     return number;
/*      */   }
/*      */ 
/*      */   
/*      */   public int getRebornPoint() {
/* 1293 */     if (!this.player.functionOpenManager.isOpen(Const.FunctionType.Reborn.getValue())) {
/* 1294 */       return 0;
/*      */     }
/* 1296 */     if (this.player.playerBasePO.openRebornToday) {
/* 1297 */       return 0;
/*      */     }
/* 1299 */     int number = 0;
/* 1300 */     for (ReBornExt reBornExt : GameData.ReBorns.values()) {
/* 1301 */       if (this.player.player.gold < reBornExt.costGold) {
/*      */         continue;
/*      */       }
/* 1304 */       if (StringUtil.isNotEmpty(reBornExt.mateCode1) && 
/* 1305 */         this.player.bag.findItemNumByCode(reBornExt.mateCode1) < reBornExt.mateCount1) {
/*      */         continue;
/*      */       }
/*      */       
/* 1309 */       if (StringUtil.isNotEmpty(reBornExt.mateCode2) && 
/* 1310 */         this.player.bag.findItemNumByCode(reBornExt.mateCode2) < reBornExt.mateCount2) {
/*      */         continue;
/*      */       }
/*      */ 
/*      */       
/* 1315 */       if (this.player.getLevel() / 10 * 10 != reBornExt.level) {
/*      */         continue;
/*      */       }
/* 1318 */       number = 1;
/*      */     } 
/*      */     
/* 1321 */     return number;
/*      */   }
/*      */ 
/*      */   
/*      */   public int getRebuildPoint() {
/* 1326 */     if (!this.player.functionOpenManager.isOpen(Const.FunctionType.Rebuild.getValue())) {
/* 1327 */       return 0;
/*      */     }
/* 1329 */     if (this.player.playerBasePO.openRebuildToday) {
/* 1330 */       return 0;
/*      */     }
/* 1332 */     int number = 0;
/* 1333 */     for (ReBuildExt reBuildExt : GameData.ReBuilds.values()) {
/* 1334 */       if (this.player.player.gold < reBuildExt.costGold) {
/*      */         continue;
/*      */       }
/* 1337 */       if (StringUtil.isNotEmpty(reBuildExt.mateCode1) && 
/* 1338 */         this.player.bag.findItemNumByCode(reBuildExt.mateCode1) < reBuildExt.mateCount1) {
/*      */         continue;
/*      */       }
/*      */       
/* 1342 */       if (StringUtil.isNotEmpty(reBuildExt.mateCode2) && 
/* 1343 */         this.player.bag.findItemNumByCode(reBuildExt.mateCode2) < reBuildExt.mateCount2) {
/*      */         continue;
/*      */       }
/*      */       
/* 1347 */       if (StringUtil.isNotEmpty(reBuildExt.mateCode3) && 
/* 1348 */         this.player.bag.findItemNumByCode(reBuildExt.mateCode3) < reBuildExt.mateCount3) {
/*      */         continue;
/*      */       }
/*      */ 
/*      */       
/* 1353 */       if (this.player.getLevel() / 10 * 10 != reBuildExt.level) {
/*      */         continue;
/*      */       }
/* 1356 */       number = 1;
/*      */     } 
/*      */     
/* 1359 */     if (number > 0) {
/* 1360 */       return number;
/*      */     }
/* 1362 */     for (SeniorReBuildExt seniorReBuildExt : GameData.SeniorReBuilds.values()) {
/* 1363 */       if (this.player.player.gold < seniorReBuildExt.costGold) {
/*      */         continue;
/*      */       }
/* 1366 */       if (StringUtil.isNotEmpty(seniorReBuildExt.mateCode1) && 
/* 1367 */         this.player.bag.findItemNumByCode(seniorReBuildExt.mateCode1) < seniorReBuildExt.mateCount1) {
/*      */         continue;
/*      */       }
/*      */       
/* 1371 */       if (StringUtil.isNotEmpty(seniorReBuildExt.mateCode2) && 
/* 1372 */         this.player.bag.findItemNumByCode(seniorReBuildExt.mateCode2) < seniorReBuildExt.mateCount2) {
/*      */         continue;
/*      */       }
/*      */ 
/*      */       
/* 1377 */       if (StringUtil.isNotEmpty(seniorReBuildExt.mateCode3) && 
/* 1378 */         this.player.bag.findItemNumByCode(seniorReBuildExt.mateCode3) < seniorReBuildExt.mateCount3) {
/*      */         continue;
/*      */       }
/*      */ 
/*      */       
/* 1383 */       if (this.player.getLevel() / 10 * 10 != seniorReBuildExt.level) {
/*      */         continue;
/*      */       }
/* 1386 */       number = 1;
/*      */     } 
/*      */     
/* 1389 */     return number;
/*      */   }
/*      */ 
/*      */   
/*      */   public int getKaiguangPoint() {
/* 1394 */     if (!this.player.functionOpenManager.isOpen(Const.FunctionType.REFINE.getValue())) {
/* 1395 */       return 0;
/*      */     }
/* 1397 */     if (this.player.playerBasePO.openKaiguangToday)
/*      */     {
/* 1399 */       return 0;
/*      */     }
/* 1401 */     int number = 0;
/* 1402 */     for (RefineExt reFineExt : GameData.Refines.values()) {
/* 1403 */       if (this.player.player.gold < reFineExt.costGold) {
/*      */         continue;
/*      */       }
/*      */       
/* 1407 */       if (StringUtil.isNotEmpty(reFineExt.mateCode1) && 
/* 1408 */         this.player.bag.findItemNumByCode(reFineExt.mateCode1) < reFineExt.mateCount1) {
/*      */         continue;
/*      */       }
/*      */ 
/*      */       
/* 1413 */       if (StringUtil.isNotEmpty(reFineExt.mateCode2) && 
/* 1414 */         this.player.bag.findItemNumByCode(reFineExt.mateCode2) < reFineExt.mateCount2) {
/*      */         continue;
/*      */       }
/*      */ 
/*      */ 
/*      */       
/* 1420 */       if (this.player.getLevel() / 10 * 10 != reFineExt.level) {
/*      */         continue;
/*      */       }
/*      */       
/* 1424 */       number = 1;
/*      */     } 
/*      */ 
/*      */     
/* 1428 */     return number;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<PlayerHandler.SuperScriptType> getWorkSuperScript() {
/* 1435 */     List<PlayerHandler.SuperScriptType> list = new ArrayList<>();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1443 */     int number1 = getMakePoint();
/* 1444 */     PlayerHandler.SuperScriptType.Builder data1 = PlayerHandler.SuperScriptType.newBuilder();
/* 1445 */     data1.setType(Const.SUPERSCRIPT_TYPE.MAKE.getValue());
/* 1446 */     data1.setNumber(number1);
/* 1447 */     list.add(data1.build());
/*      */ 
/*      */     
/* 1450 */     int number2 = getRebornPoint();
/* 1451 */     PlayerHandler.SuperScriptType.Builder data2 = PlayerHandler.SuperScriptType.newBuilder();
/* 1452 */     data2.setType(Const.SUPERSCRIPT_TYPE.REBORN.getValue());
/* 1453 */     data2.setNumber(number2);
/* 1454 */     list.add(data2.build());
/*      */ 
/*      */     
/* 1457 */     int number3 = getRebuildPoint();
/* 1458 */     PlayerHandler.SuperScriptType.Builder data3 = PlayerHandler.SuperScriptType.newBuilder();
/* 1459 */     data3.setType(Const.SUPERSCRIPT_TYPE.REBUILD.getValue());
/* 1460 */     data3.setNumber(number3);
/* 1461 */     list.add(data3.build());
/*      */ 
/*      */     
/* 1464 */     int number4 = getKaiguangPoint();
/* 1465 */     PlayerHandler.SuperScriptType.Builder data4 = PlayerHandler.SuperScriptType.newBuilder();
/* 1466 */     data4.setType(Const.SUPERSCRIPT_TYPE.KAIGUANG.getValue());
/* 1467 */     data4.setNumber(number4);
/* 1468 */     list.add(data4.build());
/*      */ 
/*      */     
/* 1471 */     PlayerHandler.SuperScriptType.Builder data = PlayerHandler.SuperScriptType.newBuilder();
/* 1472 */     data.setType(Const.SUPERSCRIPT_TYPE.WORKING.getValue());
/* 1473 */     data.setNumber(number1 + number2 + number3 + number4);
/* 1474 */     list.add(data.build());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1480 */     return list;
/*      */   }
/*      */   
/*      */   public RedPointBean findRedPointBean(List<RedPointBean> list, int code) {
/* 1484 */     if (list == null || list.isEmpty()) {
/* 1485 */       return null;
/*      */     }
/* 1487 */     for (RedPointBean bean : list) {
/* 1488 */       if (bean.id == code) {
/* 1489 */         return bean;
/*      */       }
/*      */     } 
/* 1492 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<PlayerHandler.SuperScriptType> getStrengthSuperScript() {
/* 1499 */     List<PlayerHandler.SuperScriptType> list = new ArrayList<>();
/* 1500 */     if (!this.player.functionOpenManager.isOpen(Const.FunctionType.STRENGTHEN.getValue())) {
/* 1501 */       return list;
/*      */     }
/*      */     
/* 1504 */     int number = 0;
/*      */     
/* 1506 */     for (Iterator<Integer> iterator = this.strengthPos.keySet().iterator(); iterator.hasNext(); ) { int pos = ((Integer)iterator.next()).intValue();
/* 1507 */       PlayerBasePO.EquipStrengthPos posInfo = this.strengthPos.get(Integer.valueOf(pos));
/* 1508 */       int level = posInfo.enSection * 100 + posInfo.enLevel;
/* 1509 */       if (level < EquipUtil.maxStrengthLevel) {
/* 1510 */         int nextLv = level + 1;
/* 1511 */         if (posInfo.enLevel >= 9) {
/* 1512 */           nextLv = (posInfo.enSection + 1) * 100;
/*      */         }
/* 1514 */         EnchantExt enchant = (EnchantExt)GameData.Enchants.get(Integer.valueOf(nextLv));
/* 1515 */         if (enchant != null && this.player.bag.isItemNumEnough(enchant.mateCode1, enchant.mateCount1) && this.player.bag.isItemNumEnough(enchant.mateCode2, enchant.mateCount2) && this.player.player.gold >= enchant.costGold) {
/* 1516 */           number = 1;
/*      */           break;
/*      */         } 
/*      */       }  }
/*      */     
/* 1521 */     PlayerHandler.SuperScriptType.Builder data = PlayerHandler.SuperScriptType.newBuilder();
/* 1522 */     data.setType(Const.SUPERSCRIPT_TYPE.EQUIP_STRENGTH.getValue());
/* 1523 */     data.setNumber(number);
/* 1524 */     list.add(data.build());
/* 1525 */     return list;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<PlayerHandler.SuperScriptType> getGemFillSuperScript(String templateCode) {
/* 1532 */     long start = System.currentTimeMillis();
/* 1533 */     List<PlayerHandler.SuperScriptType> list = new ArrayList<>();
/*      */     
/* 1535 */     if (!this.player.functionOpenManager.isOpen(Const.FunctionType.SetNew.getValue())) {
/* 1536 */       return list;
/*      */     }
/*      */     
/* 1539 */     int number = 0;
/*      */     
/* 1541 */     if (StringUtil.isNotEmpty(templateCode)) {
/*      */       
/* 1543 */       boolean flag = false;
/* 1544 */       List<Integer> codePoses = ItemConfig.getInstance().findPosByGem(templateCode);
/* 1545 */       for (Iterator<Integer> iterator = codePoses.iterator(); iterator.hasNext(); ) { int pos = ((Integer)iterator.next()).intValue();
/* 1546 */         PlayerBasePO.EquipStrengthPos posInfo = this.strengthPos.get(Integer.valueOf(pos));
/* 1547 */         for (int i = 1; i <= posInfo.socks; i++) {
/* 1548 */           String code = (String)posInfo.gems.get(Integer.valueOf(i));
/* 1549 */           if (StringUtil.isEmpty(code)) {
/* 1550 */             number = 1;
/* 1551 */             flag = true;
/*      */             break;
/*      */           } 
/*      */         } 
/* 1555 */         if (flag) {
/*      */           break;
/*      */         } }
/*      */ 
/*      */       
/* 1560 */       if (number == 0) {
/* 1561 */         DItemBase baseProp = (DItemBase)ItemConfig.getInstance().getItemProp(templateCode);
/* 1562 */         List<Integer> poses = ItemConfig.getInstance().findPosByGem(templateCode);
/*      */         
/* 1564 */         Map<Integer, Integer> gemLevels = new HashMap<>();
/*      */         
/* 1566 */         for (Iterator<Integer> iterator1 = this.strengthPos.keySet().iterator(); iterator1.hasNext(); ) { int pos = ((Integer)iterator1.next()).intValue();
/* 1567 */           if (!poses.contains(Integer.valueOf(pos))) {
/*      */             continue;
/*      */           }
/* 1570 */           PlayerBasePO.EquipStrengthPos posInfo = this.strengthPos.get(Integer.valueOf(pos));
/* 1571 */           for (String code : posInfo.gems.values()) {
/* 1572 */             if (StringUtil.isEmpty(code)) {
/*      */               continue;
/*      */             }
/* 1575 */             DItemBase prop = (DItemBase)ItemConfig.getInstance().getItemProp(code);
/* 1576 */             if (!gemLevels.containsKey(Integer.valueOf(prop.par)) || ((Integer)gemLevels.get(Integer.valueOf(prop.par))).intValue() > prop.levelReq) {
/* 1577 */               gemLevels.put(Integer.valueOf(prop.par), Integer.valueOf(prop.levelReq));
/*      */             }
/*      */           }  }
/*      */ 
/*      */         
/* 1582 */         int level = gemLevels.containsKey(Integer.valueOf(baseProp.par)) ? ((Integer)gemLevels.get(Integer.valueOf(baseProp.par))).intValue() : 0;
/* 1583 */         if (baseProp.levelReq > level) {
/* 1584 */           number = 1;
/*      */         }
/*      */       } 
/*      */     } else {
/*      */       
/* 1589 */       boolean flag = false;
/* 1590 */       for (Iterator<Integer> iterator = this.strengthPos.keySet().iterator(); iterator.hasNext(); ) { int pos = ((Integer)iterator.next()).intValue();
/* 1591 */         PlayerBasePO.EquipStrengthPos posInfo = this.strengthPos.get(Integer.valueOf(pos));
/* 1592 */         for (int i = 1; i <= posInfo.socks; i++) {
/* 1593 */           String code = (String)posInfo.gems.get(Integer.valueOf(i));
/* 1594 */           if (!StringUtil.isNotEmpty(code)) {
/*      */ 
/*      */             
/* 1597 */             List<String> typeList = ((EquipSockExt)GameData.EquipSocks.get(Integer.valueOf(pos))).typeList;
/* 1598 */             for (String _code : typeList) {
/* 1599 */               if (this.player.bag.findFirstItemByCode(_code) != null) {
/* 1600 */                 number = 1;
/* 1601 */                 flag = true;
/*      */                 break;
/*      */               } 
/*      */             } 
/* 1605 */             if (flag)
/*      */               break; 
/*      */           } 
/*      */         } 
/* 1609 */         if (flag) {
/*      */           break;
/*      */         } }
/*      */ 
/*      */       
/* 1614 */       if (number == 0) {
/*      */         
/* 1616 */         Map<Integer, Integer> posCodeLevelBag = new HashMap<>();
/* 1617 */         List<NormalItem> list_bag = this.player.bag.findItemByType(Const.ItemSecondType.gem.getKey());
/* 1618 */         if (list_bag.size() == 0) {
/* 1619 */           number = 0;
/*      */         } else {
/* 1621 */           for (NormalItem bagItem : list_bag) {
/* 1622 */             List<Integer> list_gem_pos = ItemConfig.getInstance().findPosByGem(bagItem.itemCode());
/* 1623 */             for (Iterator<Integer> iterator2 = list_gem_pos.iterator(); iterator2.hasNext(); ) { int bagPos = ((Integer)iterator2.next()).intValue();
/* 1624 */               if (posCodeLevelBag.get(Integer.valueOf(bagPos)) == null || ((Integer)posCodeLevelBag.get(Integer.valueOf(bagPos))).intValue() < bagItem.prop.levelReq) {
/* 1625 */                 posCodeLevelBag.put(Integer.valueOf(bagPos), Integer.valueOf(bagItem.prop.levelReq));
/*      */               } }
/*      */           
/*      */           } 
/*      */ 
/*      */           
/* 1631 */           Map<Integer, Integer> posCodeLevel = new HashMap<>();
/*      */           Iterator<Integer> iterator1;
/* 1633 */           for (iterator1 = this.strengthPos.keySet().iterator(); iterator1.hasNext(); ) { int pos = ((Integer)iterator1.next()).intValue();
/* 1634 */             PlayerBasePO.EquipStrengthPos posInfo = this.strengthPos.get(Integer.valueOf(pos));
/* 1635 */             for (String code : posInfo.gems.values()) {
/* 1636 */               if (StringUtil.isEmpty(code)) {
/*      */                 continue;
/*      */               }
/* 1639 */               DItemBase prop = (DItemBase)ItemConfig.getInstance().getItemProp(code);
/* 1640 */               if (posCodeLevel.get(Integer.valueOf(pos)) == null || ((Integer)posCodeLevel.get(Integer.valueOf(pos))).intValue() > prop.levelReq) {
/* 1641 */                 posCodeLevel.put(Integer.valueOf(pos), Integer.valueOf(prop.levelReq));
/*      */               }
/*      */             }  }
/*      */           
/* 1645 */           flag = false;
/* 1646 */           for (iterator1 = posCodeLevelBag.keySet().iterator(); iterator1.hasNext(); ) { int bagPos = ((Integer)iterator1.next()).intValue();
/* 1647 */             int levelBag = ((Integer)posCodeLevelBag.get(Integer.valueOf(bagPos))).intValue();
/* 1648 */             for (Iterator<Integer> iterator2 = posCodeLevel.keySet().iterator(); iterator2.hasNext(); ) { int pos = ((Integer)iterator2.next()).intValue();
/* 1649 */               if (bagPos == pos && 
/* 1650 */                 levelBag > ((Integer)posCodeLevel.get(Integer.valueOf(pos))).intValue()) {
/* 1651 */                 number = 1;
/* 1652 */                 flag = true;
/*      */                 
/*      */                 break;
/*      */               }  }
/*      */             
/* 1657 */             if (flag) {
/*      */               break;
/*      */             } }
/*      */         
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/* 1665 */     long cost = System.currentTimeMillis() - start;
/* 1666 */     if (cost > 10L) {
/* 1667 */       Out.info(new Object[] { "getGemFillSuperScript cost ", Long.valueOf(cost) });
/*      */     }
/*      */     
/* 1670 */     PlayerHandler.SuperScriptType.Builder data = PlayerHandler.SuperScriptType.newBuilder();
/* 1671 */     data.setType(Const.SUPERSCRIPT_TYPE.EQUIP_FILL_GEM.getValue());
/* 1672 */     data.setNumber(number);
/* 1673 */     list.add(data.build());
/* 1674 */     return list;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<PlayerHandler.SuperScriptType> getEquipSuperScript(NormalEquip equip) {
/* 1681 */     List<PlayerHandler.SuperScriptType> list = new ArrayList<>();
/*      */     
/* 1683 */     int number = 0;
/*      */     
/* 1685 */     if (equip != null) {
/* 1686 */       if (equip.getLevel() <= this.player.getLevel() && (equip.prop.Pro == this.player.getPro() || equip.prop.Pro == 0)) {
/* 1687 */         NormalEquip playerEquip = this.equips.get(Integer.valueOf(equip.getPosition()));
/* 1688 */         if (playerEquip == null) {
/* 1689 */           number = 1;
/*      */         }
/* 1691 */         else if (playerEquip.getEquipScore(this.player.playerBasePO) < equip.getEquipScore(this.player.playerBasePO)) {
/* 1692 */           number = 1;
/*      */         } 
/*      */       } 
/*      */     } else {
/*      */       
/* 1697 */       boolean flag = false;
/* 1698 */       for (Const.EquipType ePos : Const.EquipType.values()) {
/* 1699 */         int pos = ePos.getValue();
/* 1700 */         List<NormalEquip> list_all = this.player.bag.findEquipByType(pos, this.player.getPro(), this.player.getLevel());
/* 1701 */         if (list_all.size() > 0) {
/* 1702 */           NormalEquip playerEquip = this.equips.containsKey(Integer.valueOf(pos)) ? this.equips.get(Integer.valueOf(pos)) : null;
/* 1703 */           if (playerEquip == null) {
/* 1704 */             number = 1;
/* 1705 */             flag = true;
/*      */           } else {
/* 1707 */             for (NormalEquip bagEquip : list_all) {
/* 1708 */               if (playerEquip.getEquipScore(this.player.playerBasePO) < bagEquip.getEquipScore(this.player.playerBasePO)) {
/* 1709 */                 number = 1;
/* 1710 */                 flag = true;
/*      */                 break;
/*      */               } 
/*      */             } 
/*      */           } 
/*      */         } 
/* 1716 */         if (flag) {
/*      */           break;
/*      */         }
/*      */       } 
/*      */     } 
/* 1721 */     PlayerHandler.SuperScriptType.Builder data = PlayerHandler.SuperScriptType.newBuilder();
/* 1722 */     data.setType(Const.SUPERSCRIPT_TYPE.EQUIP_EQUIP.getValue());
/* 1723 */     data.setNumber(number);
/* 1724 */     list.add(data.build());
/* 1725 */     return list;
/*      */   }
/*      */   
/*      */   private void removeSameScript(List<PlayerHandler.SuperScriptType> list) {
/* 1729 */     if (list == null || list.size() == 0) {
/*      */       return;
/*      */     }
/* 1732 */     Iterator<PlayerHandler.SuperScriptType> iter = list.iterator();
/* 1733 */     while (iter.hasNext()) {
/* 1734 */       PlayerHandler.SuperScriptType script = iter.next();
/* 1735 */       int oldNum = this.redpoints.containsKey(Integer.valueOf(script.getType())) ? ((Integer)this.redpoints.get(Integer.valueOf(script.getType()))).intValue() : 0;
/* 1736 */       if (script.getNumber() > 0) {
/* 1737 */         if (oldNum > 0) {
/* 1738 */           iter.remove(); continue;
/*      */         } 
/* 1740 */         this.redpoints.put(Integer.valueOf(script.getType()), Integer.valueOf(script.getNumber()));
/*      */         continue;
/*      */       } 
/* 1743 */       if (oldNum <= 0) {
/* 1744 */         iter.remove(); continue;
/*      */       } 
/* 1746 */       this.redpoints.put(Integer.valueOf(script.getType()), Integer.valueOf(script.getNumber()));
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public RedPointPO getAndCheckUpdateRedPointPO(String playerId) {
/* 1753 */     RedPointPO redPointPO = (RedPointPO)PlayerPOManager.findPO(ConstsTR.redpointTR, playerId, RedPointPO.class);
/* 1754 */     if (redPointPO == null) {
/* 1755 */       synchronized (this.player) {
/* 1756 */         redPointPO = (RedPointPO)PlayerPOManager.findPO(ConstsTR.redpointTR, playerId, RedPointPO.class);
/* 1757 */         if (redPointPO == null) {
/* 1758 */           redPointPO = new RedPointPO();
/* 1759 */           PlayerPOManager.put(ConstsTR.redpointTR, playerId, (GEntity)redPointPO);
/*      */         } 
/*      */       } 
/*      */     }
/* 1763 */     checkupdateRedpoint(redPointPO);
/* 1764 */     return redPointPO;
/*      */   }
/*      */   
/*      */   public void checkupdateRedpoint(RedPointPO redPointPO) {
/* 1768 */     if (redPointPO.list != null) {
/* 1769 */       Date now = new Date();
/* 1770 */       for (RedPointBean bean : redPointPO.list) {
/* 1771 */         boolean isSameDay = DateUtil.isSameDay(bean.date, now);
/* 1772 */         if (!isSameDay) {
/* 1773 */           bean.date = now;
/* 1774 */           bean.point = 0;
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateMakeScript(String code) {
/* 1784 */     if (StringUtil.isEmpty(code) || EquipUtil.makeMaterial.contains(code)) {
/* 1785 */       GWorld.getInstance().ansycExec(() -> {
/*      */             List<PlayerHandler.SuperScriptType> list = getWorkSuperScript();
/*      */             this.player.updateSuperScriptList(list);
/*      */           });
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateStrengthScript(String code) {
/* 1797 */     if (StringUtil.isEmpty(code) || EquipUtil.strengthMaterial.contains(code)) {
/* 1798 */       GWorld.getInstance().ansycExec(() -> {
/*      */             List<PlayerHandler.SuperScriptType> list = getStrengthSuperScript();
/*      */             removeSameScript(list);
/*      */             this.player.updateSuperScriptList(list);
/*      */           });
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateFillGemScript(String code) {
/* 1810 */     if (StringUtil.isEmpty(code) || GameData.Jewels.containsKey(code)) {
/* 1811 */       GWorld.getInstance().ansycExec(() -> {
/*      */             List<PlayerHandler.SuperScriptType> list = getGemFillSuperScript(code);
/*      */             removeSameScript(list);
/*      */             this.player.updateSuperScriptList(list);
/*      */           });
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateEquipScript(NormalEquip equip) {
/* 1823 */     GWorld.getInstance().ansycExec(() -> {
/*      */           List<PlayerHandler.SuperScriptType> list = getEquipSuperScript(equip);
/*      */           this.player.updateSuperScriptList(list);
/*      */         });
/*      */   }
/*      */   
/*      */   public void updateSuperScript() {
/* 1830 */     GWorld.getInstance().ansycExec(() -> {
/*      */           List<PlayerHandler.SuperScriptType> list = getSuperScript();
/*      */           this.player.updateSuperScriptList(list);
/*      */         });
/*      */   }
/*      */   
/*      */   public void onLogin() {
/* 1837 */     this.redpoints.clear();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void OnPlayerLevelUp() {
/* 1845 */     int level = this.player.player.level;
/* 1846 */     for (Iterator<Integer> iterator = this.strengthPos.keySet().iterator(); iterator.hasNext(); ) { int pos = ((Integer)iterator.next()).intValue();
/* 1847 */       EquipSockCO sockCO = (EquipSockCO)GameData.EquipSocks.get(Integer.valueOf(pos));
/* 1848 */       if (sockCO == null) {
/*      */         continue;
/*      */       }
/* 1851 */       PlayerBasePO.EquipStrengthPos posInfo = this.strengthPos.get(Integer.valueOf(pos));
/* 1852 */       int sockNum = 0;
/* 1853 */       if (level >= sockCO.sock1OpenLvl) {
/* 1854 */         sockNum++;
/*      */       }
/* 1856 */       if (level >= sockCO.sock2OpenLvl) {
/* 1857 */         sockNum++;
/*      */       }
/* 1859 */       if (level >= sockCO.sock3OpenLvl) {
/* 1860 */         sockNum++;
/*      */       }
/* 1862 */       if (level >= sockCO.sock4OpenLvl) {
/* 1863 */         sockNum++;
/*      */       }
/* 1865 */       if (level >= sockCO.sock5OpenLvl) {
/* 1866 */         sockNum++;
/*      */       }
/* 1868 */       posInfo.socks = sockNum; }
/*      */ 
/*      */     
/* 1871 */     int len = (Const.EquipType.values()).length;
/* 1872 */     int[] grids = new int[len];
/* 1873 */     for (int i = 0; i < len; i++) {
/* 1874 */       grids[i] = i + 1;
/*      */     }
/* 1876 */     _updateAndPushPOS(grids, false);
/*      */     
/* 1878 */     updateFillGemScript(null);
/*      */   }
/*      */   
/*      */   private void update() {
/* 1882 */     this.player.playerBasePO.equipGrids = new HashMap<>();
/* 1883 */     for (Iterator<Integer> iterator = this.equips.keySet().iterator(); iterator.hasNext(); ) { int pos = ((Integer)iterator.next()).intValue();
/* 1884 */       if (this.equips.get(Integer.valueOf(pos)) != null) {
/* 1885 */         this.player.playerBasePO.equipGrids.put(Integer.valueOf(pos), ((NormalEquip)this.equips.get(Integer.valueOf(pos))).itemDb);
/*      */       } }
/*      */   
/*      */   }
/*      */   
/*      */   public int getTotalStrenthenLv() {
/* 1891 */     int totalLv = 0;
/* 1892 */     for (PlayerBasePO.EquipStrengthPos equipStrengthPos : this.strengthPos.values()) {
/* 1893 */       totalLv += equipStrengthPos.enSection * 10 + equipStrengthPos.enLevel;
/*      */     }
/* 1895 */     return totalLv;
/*      */   }
/*      */   
/*      */   public void refreshNewDay() {
/* 1899 */     this.player.playerBasePO.openRebornToday = false;
/* 1900 */     this.player.playerBasePO.openRebuildToday = false;
/* 1901 */     this.player.playerBasePO.openKaiguangToday = false;
/*      */   }
/*      */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\equip\EquipManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */