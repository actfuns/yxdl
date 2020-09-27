/*     */ package com.wanniu.game.player;
/*     */ 
/*     */ import Xmds.PlayerPKInfoData;
/*     */ import com.alibaba.fastjson.JSON;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.util.RandomUtil;
/*     */ import com.wanniu.game.area.Area;
/*     */ import com.wanniu.game.area.AreaDataConfig;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.Utils;
/*     */ import com.wanniu.game.data.base.DItemEquipBase;
/*     */ import com.wanniu.game.data.base.MapBase;
/*     */ import com.wanniu.game.equip.NormalEquip;
/*     */ import com.wanniu.game.item.ItemConfig;
/*     */ import com.wanniu.game.item.ItemUtil;
/*     */ import com.wanniu.game.item.NormalItem;
/*     */ import com.wanniu.game.poes.PlayerPKDataPO;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PkRuleManager
/*     */ {
/*     */   public WNPlayer player;
/*     */   public PlayerPKDataPO pkData;
/*     */   
/*     */   public PkRuleManager(WNPlayer player, PlayerPKDataPO pkData) {
/*  32 */     this.player = player;
/*  33 */     this.pkData = pkData;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object[] dropRandItemFromBag() {
/*  40 */     Object[] item = this.player.bag.randomGetItem(GlobalConfig.pkDrop, GlobalConfig.Mysterious_DropItemsMaxNum);
/*  41 */     return item;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void mijingDrop(List<NormalItem> finalResultData) {
/*  51 */     boolean hasRate = RandomUtil.hasHitRate(10000, GlobalConfig.Mysterious_DropItemsPro);
/*  52 */     if (hasRate) {
/*  53 */       Object[] dropItem = dropRandItemFromBag();
/*  54 */       if (dropItem != null) {
/*  55 */         Out.info(new Object[] { "pk dead drop,playerId=", (this.player == null) ? "" : this.player.getId(), ",code=", dropItem[0] });
/*  56 */         finalResultData.addAll(ItemUtil.createItemsByItemCode(dropItem[0].toString(), ((Integer)dropItem[1]).intValue()));
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public List<NormalItem> dropItemByKilled(int pkValue, Area area) {
/*  62 */     List<NormalItem> finalResultData = new ArrayList<>(2);
/*  63 */     if (area.sceneType == Const.SCENE_TYPE.ILLUSION_2.getValue()) {
/*  64 */       mijingDrop(finalResultData);
/*  65 */       return finalResultData;
/*     */     } 
/*     */     
/*  68 */     int rand = RandomUtil.getInt(10000);
/*  69 */     if (rand < GlobalConfig.PK_Killed_LostBagItem_Chance) {
/*  70 */       int cost = RandomUtil.getInt(100, 1000);
/*  71 */       int dropMoneyCount = this.player.moneyManager.costGoldOnPk(cost, Const.GOODS_CHANGE_TYPE.hitUser);
/*  72 */       if (dropMoneyCount > 0) {
/*  73 */         List<NormalItem> itemList = ItemUtil.createItemsByItemCode("gold", dropMoneyCount);
/*     */         
/*  75 */         if (itemList != null && !itemList.isEmpty()) {
/*  76 */           NormalItem it = itemList.get(0);
/*  77 */           DItemEquipBase base = ItemConfig.getInstance().getItemProp("goldpkdrop");
/*  78 */           it.prop = it.prop.copy();
/*  79 */           it.prop.icon = base.icon;
/*  80 */           it.prop.name = String.valueOf(dropMoneyCount);
/*  81 */           finalResultData.add(it);
/*     */         } 
/*     */       } 
/*     */     } 
/*  85 */     if (pkValue <= 0) {
/*  86 */       return finalResultData;
/*     */     }
/*     */     
/*  89 */     Out.debug(new Object[] { Integer.valueOf(pkValue), " : ", Integer.valueOf(GlobalConfig.PK_Killed_LostEquip_PKValue) });
/*  90 */     if (pkValue >= GlobalConfig.PK_Killed_LostEquip_PKValue) {
/*  91 */       int rate = Math.min(GlobalConfig.PK_Killed_LostEquip_MaxRate, pkValue * 100 / GlobalConfig.PK_Killed_LostEquip_Denominator);
/*  92 */       Out.debug(new Object[] { "rate : ", Integer.valueOf(rate) });
/*  93 */       if (Utils.randomPercent(rate)) {
/*  94 */         Map<Integer, NormalEquip> equips = this.player.equipManager.equips;
/*  95 */         List<Integer> dropEquipPoss = new ArrayList<>(equips.size());
/*  96 */         for (Iterator<Integer> iterator = equips.keySet().iterator(); iterator.hasNext(); ) { int pos = ((Integer)iterator.next()).intValue();
/*  97 */           if (GlobalConfig.PK_EXCEPT_TYPES.indexOf(Integer.valueOf(pos)) == -1) {
/*  98 */             dropEquipPoss.add(Integer.valueOf(pos));
/*     */           } }
/*     */         
/* 101 */         if (dropEquipPoss.size() > 0) {
/* 102 */           int randomIndex = RandomUtil.getIndex(dropEquipPoss.size());
/* 103 */           int randomPos = ((Integer)dropEquipPoss.get(randomIndex)).intValue();
/* 104 */           NormalEquip randomBodyData = this.player.equipManager.getEquipment(randomPos);
/* 105 */           if (this.player.equipManager.DropEquipAndReturn(randomPos)) {
/* 106 */             finalResultData.add(randomBodyData);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 112 */     for (int i = 0; i < GlobalConfig.PK_Killed_LostBagItem_MaxCount; i++) {
/* 113 */       int rand2 = RandomUtil.getInt(10000);
/* 114 */       Out.debug(new Object[] { Integer.valueOf(rand2), " < ", Integer.valueOf(GlobalConfig.PK_Killed_LostBagItem_Chance) });
/* 115 */       if (rand2 < GlobalConfig.PK_Killed_LostBagItem_Chance) {
/* 116 */         NormalItem resultData = this.player.bag.randomGetItem();
/*     */         
/* 118 */         if (resultData != null) {
/* 119 */           finalResultData.add(resultData);
/*     */         }
/*     */       } 
/*     */     } 
/* 123 */     return finalResultData;
/*     */   }
/*     */   
/*     */   public int getPkValue() {
/* 127 */     String _result = this.player.getXmdsManager().getPlayerPKInfoData(this.player.getId());
/* 128 */     PlayerPKInfoData result = (PlayerPKInfoData)JSON.parseObject(_result, PlayerPKInfoData.class);
/* 129 */     this.pkData.pkValue = result.pkValue;
/* 130 */     return result.pkValue;
/*     */   }
/*     */   
/*     */   public Map<String, Object> getPkDataToBattleJson() {
/* 134 */     Map<String, Object> data = new HashMap<>();
/* 135 */     data.put("mode", Integer.valueOf(this.pkData.pkModel));
/* 136 */     data.put("value", Integer.valueOf(this.pkData.pkValue));
/* 137 */     data.put("level", Integer.valueOf(this.pkData.pkLevel));
/*     */ 
/*     */     
/* 140 */     MapBase sceneProp = AreaDataConfig.getInstance().get(this.player.getAreaId());
/* 141 */     if (sceneProp != null) {
/* 142 */       if (sceneProp.changePKtype == 0) {
/* 143 */         data.put("mode", Integer.valueOf(sceneProp.pktype));
/*     */       } else {
/* 145 */         this.pkData.pkModel = this.pkData.historyPkModel;
/* 146 */         data.put("mode", Integer.valueOf(this.pkData.pkModel));
/*     */       } 
/*     */     }
/* 149 */     return data;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setPkModel(int newPkModel) {
/* 154 */     if (this.pkData.pkModel != newPkModel) {
/* 155 */       this.pkData.pkModel = newPkModel;
/* 156 */       this.player.getXmdsManager().refreshPlayerPKMode(this.player.getId(), this.pkData.pkModel);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setHistoryPkModel() {
/* 161 */     this.pkData.historyPkModel = this.pkData.pkModel;
/*     */   }
/*     */   
/*     */   public void onExitGuild() {
/* 165 */     if (this.pkData.pkModel == Const.PkModel.Guild.value) {
/* 166 */       setPkModel(Const.PkModel.Peace.value);
/*     */     }
/*     */   }
/*     */   
/*     */   public void onExitTeam() {
/* 171 */     if (this.pkData.pkModel == Const.PkModel.Team.value) {
/* 172 */       setPkModel(Const.PkModel.Peace.value);
/*     */     }
/*     */   }
/*     */   
/*     */   public int getPkValueData() {
/* 177 */     return this.pkData.pkValue;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\player\PkRuleManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */