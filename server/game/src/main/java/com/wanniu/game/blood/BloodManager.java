/*     */ package com.wanniu.game.blood;
/*     */ 
/*     */ import com.wanniu.core.game.entity.GEntity;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.ConstsTR;
/*     */ import com.wanniu.game.common.ModuleManager;
/*     */ import com.wanniu.game.data.BloodListCO;
/*     */ import com.wanniu.game.data.BloodSuitConfigCO;
/*     */ import com.wanniu.game.data.GameData;
/*     */ import com.wanniu.game.data.QuestCO;
/*     */ import com.wanniu.game.data.ext.BloodSuitListExt;
/*     */ import com.wanniu.game.item.ItemUtil;
/*     */ import com.wanniu.game.item.NormalItem;
/*     */ import com.wanniu.game.player.BILogService;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.poes.BloodPO;
/*     */ import com.wanniu.redis.PlayerPOManager;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BloodManager
/*     */   extends ModuleManager
/*     */ {
/*     */   private WNPlayer player;
/*     */   public BloodPO bloodPO;
/*  35 */   public static List<String> itemFilter = Arrays.asList(new String[] { "vq01", "vq02", "vq03", "vq04", "vq05", "vq06", "vq07", "vq08", "vq09", "vq10" });
/*     */   
/*     */   public BloodManager(WNPlayer player) {
/*  38 */     this.player = player;
/*  39 */     BloodPO bloodPO = (BloodPO)PlayerPOManager.findPO(ConstsTR.player_blood, player.getId(), BloodPO.class);
/*  40 */     if (bloodPO == null) {
/*  41 */       bloodPO = new BloodPO(player.getId());
/*  42 */       PlayerPOManager.put(ConstsTR.player_blood, player.getId(), (GEntity)bloodPO);
/*     */     } 
/*  44 */     this.bloodPO = bloodPO;
/*     */   }
/*     */ 
/*     */   
/*     */   private void _init() {}
/*     */ 
/*     */   
/*     */   public List<NormalItem> getBloodItems() {
/*  52 */     List<NormalItem> bloods = this.player.bag.findItemBySecondType(Const.ItemSecondType.virtQuest);
/*     */     
/*  54 */     return bloods;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Map<Integer, List<Integer>> getActivedSuits() {
/*  61 */     Map<Integer, List<Integer>> activedSuits = new HashMap<>();
/*  62 */     for (Map.Entry<Integer, Integer> entry : (Iterable<Map.Entry<Integer, Integer>>)this.bloodPO.equipedMap.entrySet()) {
/*  63 */       for (BloodSuitListExt bloodSuitListExt : GameData.BloodSuitLists.values()) {
/*  64 */         if (bloodSuitListExt.partIdList.contains(entry.getValue())) {
/*  65 */           if (!activedSuits.containsKey(Integer.valueOf(bloodSuitListExt.suitID2))) {
/*  66 */             activedSuits.put(Integer.valueOf(bloodSuitListExt.suitID2), new LinkedList<>());
/*     */           }
/*  68 */           List<Integer> suitList = activedSuits.get(Integer.valueOf(bloodSuitListExt.suitID2));
/*  69 */           suitList.add(entry.getValue());
/*     */         } 
/*     */       } 
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  97 */     return activedSuits;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int equipBlood(String itemId) {
/* 104 */     NormalItem item = this.player.bag.findItemById(itemId);
/* 105 */     int pos = this.player.bag.findPosById(itemId);
/* 106 */     if (pos == -1) {
/* 107 */       return 1;
/*     */     }
/* 109 */     if (item.prop.itemSecondType != Const.ItemSecondType.virtQuest.getValue()) {
/* 110 */       return 2;
/*     */     }
/* 112 */     if (itemFilter.contains(item.itemCode())) {
/* 113 */       return 3;
/*     */     }
/* 115 */     BloodListCO bloodListCO = (BloodListCO)GameData.BloodLists.get(Integer.valueOf(((QuestCO)GameData.Quests.get(item.itemCode())).min));
/*     */ 
/*     */     
/* 118 */     this.player.bag.discardItemByPos(pos, 0, true, Const.GOODS_CHANGE_TYPE.blood);
/*     */ 
/*     */     
/* 121 */     if (this.bloodPO.equipedMap.containsKey(Integer.valueOf(bloodListCO.sortID3))) {
/* 122 */       int oldBloodId = ((Integer)this.bloodPO.equipedMap.get(Integer.valueOf(bloodListCO.sortID3))).intValue();
/* 123 */       String oldBloodCode = "blood" + oldBloodId;
/* 124 */       NormalItem entityItem = ItemUtil.createItemsByItemCode(oldBloodCode, 1).get(0);
/* 125 */       this.player.bag.addEntityItem(entityItem, Const.GOODS_CHANGE_TYPE.blood, null, false, false);
/*     */     } 
/*     */ 
/*     */     
/* 129 */     this.bloodPO.equipedMap.put(Integer.valueOf(bloodListCO.sortID3), Integer.valueOf(bloodListCO.bloodID));
/*     */     
/* 131 */     blooodSync();
/*     */     
/* 133 */     ansycReportBloodChange(1, bloodListCO.sortID3, bloodListCO);
/*     */     
/* 135 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   private void ansycReportBloodChange(int type, int position, BloodListCO bloodListCO) {
/*     */     try {
/* 141 */       Map<String, Object> data = new HashMap<>();
/* 142 */       data.put("code", bloodListCO.code);
/* 143 */       data.put("name", bloodListCO.bloodName);
/* 144 */       for (BloodSuitListExt bloodSuitListExt : GameData.BloodSuitLists.values()) {
/* 145 */         if (bloodSuitListExt.partIdList.contains(Integer.valueOf(bloodListCO.bloodID))) {
/* 146 */           data.put("suitID", Integer.valueOf(bloodSuitListExt.suitID2));
/* 147 */           data.put("suitName", bloodSuitListExt.suitName);
/*     */           break;
/*     */         } 
/*     */       } 
/* 151 */       BILogService.getInstance().ansycReportBloodChange(this.player.getPlayer(), type, position, data);
/* 152 */     } catch (Exception e) {
/* 153 */       Out.warn(new Object[] { "ansycReportBloodChange", e });
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean unequipBlood(int sortId) {
/* 161 */     if (!this.bloodPO.equipedMap.containsKey(Integer.valueOf(sortId))) {
/* 162 */       return false;
/*     */     }
/* 164 */     int bloodId = ((Integer)this.bloodPO.equipedMap.get(Integer.valueOf(sortId))).intValue();
/*     */     
/* 166 */     String code = "blood" + bloodId;
/*     */ 
/*     */ 
/*     */     
/* 170 */     this.player.bag.addCodeItemMail(code, 1, Const.ForceType.DEFAULT, Const.GOODS_CHANGE_TYPE.blood, "Bag_full_common");
/*     */     
/* 172 */     this.bloodPO.equipedMap.remove(Integer.valueOf(sortId));
/*     */ 
/*     */     
/* 175 */     blooodSync();
/*     */     
/* 177 */     List<BloodListCO> cs = GameData.findBloodLists(v -> code.equals(v.code));
/* 178 */     if (!cs.isEmpty()) {
/* 179 */       BloodListCO bloodListCO = cs.get(0);
/* 180 */       ansycReportBloodChange(2, bloodListCO.sortID3, bloodListCO);
/*     */     } 
/*     */     
/* 183 */     return true;
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
/*     */   public Map<Const.PlayerBtlData, Integer> calSingleInfluence(int sortId) {
/* 318 */     Map<Const.PlayerBtlData, Integer> data = new ConcurrentHashMap<>();
/* 319 */     if (!this.bloodPO.equipedMap.containsKey(Integer.valueOf(sortId))) {
/* 320 */       return data;
/*     */     }
/*     */     
/* 323 */     BloodListCO bloodListCO = (BloodListCO)GameData.BloodLists.get(this.bloodPO.equipedMap.get(Integer.valueOf(sortId)));
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
/* 340 */     if (bloodListCO.proNum >= 1) {
/* 341 */       data.put(Const.PlayerBtlData.getE(bloodListCO.prop1), Integer.valueOf(bloodListCO.num1));
/*     */     }
/* 343 */     if (bloodListCO.proNum >= 2) {
/* 344 */       data.put(Const.PlayerBtlData.getE(bloodListCO.prop2), Integer.valueOf(bloodListCO.num2));
/*     */     }
/* 346 */     if (bloodListCO.proNum >= 3) {
/* 347 */       data.put(Const.PlayerBtlData.getE(bloodListCO.prop3), Integer.valueOf(bloodListCO.num3));
/*     */     }
/* 349 */     if (bloodListCO.proNum >= 4) {
/* 350 */       data.put(Const.PlayerBtlData.getE(bloodListCO.prop4), Integer.valueOf(bloodListCO.num4));
/*     */     }
/*     */     
/* 353 */     return data;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Map<Const.PlayerBtlData, Integer> calAllInfluence() {
/* 360 */     Map<Const.PlayerBtlData, Integer> data = new ConcurrentHashMap<>();
/*     */ 
/*     */     
/* 363 */     for (Map.Entry<Integer, Integer> entry1 : (Iterable<Map.Entry<Integer, Integer>>)this.bloodPO.equipedMap.entrySet()) {
/* 364 */       Map<Const.PlayerBtlData, Integer> singleData = calSingleInfluence(((Integer)entry1.getKey()).intValue());
/* 365 */       for (Map.Entry<Const.PlayerBtlData, Integer> entry2 : singleData.entrySet()) {
/* 366 */         Const.PlayerBtlData key = entry2.getKey();
/* 367 */         Integer value = entry2.getValue();
/* 368 */         if (data.containsKey(key)) {
/* 369 */           data.put(key, Integer.valueOf(((Integer)data.get(key)).intValue() + value.intValue())); continue;
/*     */         } 
/* 371 */         data.put(key, value);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 378 */     Map<Integer, List<Integer>> activedSuits = getActivedSuits();
/* 379 */     for (Map.Entry<Integer, List<Integer>> entry : activedSuits.entrySet()) {
/* 380 */       List<BloodSuitConfigCO> bloodSuitConfigCOs = GameData.findBloodSuitConfigs(t -> (t.suitID == ((Integer)entry.getKey()).intValue() && t.partReqCount <= ((List)entry.getValue()).size()));
/*     */       
/* 382 */       for (BloodSuitConfigCO bloodSuitConfigCO : bloodSuitConfigCOs) {
/* 383 */         Const.PlayerBtlData key = Const.PlayerBtlData.getE(bloodSuitConfigCO.prop);
/* 384 */         Integer value = Integer.valueOf(bloodSuitConfigCO.num);
/* 385 */         if (data.containsKey(key)) {
/* 386 */           data.put(key, Integer.valueOf(((Integer)data.get(key)).intValue() + value.intValue())); continue;
/*     */         } 
/* 388 */         data.put(key, value);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 393 */     return data;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void blooodSync() {
/* 400 */     this.player.btlDataManager.data_blood = calAllInfluence();
/* 401 */     this.player.btlDataManager.calFinalData();
/* 402 */     this.player.onBloodChange();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onPlayerEvent(Const.PlayerEventType eventType) {
/* 408 */     switch (eventType) {
/*     */     
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Const.ManagerType getManagerType() {
/* 418 */     return Const.ManagerType.BLOOD;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\blood\BloodManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */