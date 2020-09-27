/*     */ package com.wanniu.game.equip;
/*     */ 
/*     */ import com.wanniu.core.common.IntIntPair;
/*     */ import com.wanniu.game.bag.WNBag;
/*     */ import com.wanniu.game.data.GameData;
/*     */ import com.wanniu.game.data.MeltConfigCO;
/*     */ import com.wanniu.game.data.ext.CombineExt;
/*     */ import com.wanniu.game.data.ext.EnchantExt;
/*     */ import com.wanniu.game.data.ext.EquipMakeExt;
/*     */ import com.wanniu.game.data.ext.SuitConfigExt;
/*     */ import com.wanniu.game.data.ext.SuitListExt;
/*     */ import com.wanniu.game.item.ItemUtil;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
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
/*     */ 
/*     */ public class EquipCraftConfig
/*     */ {
/*     */   private static EquipCraftConfig instance;
/*     */   
/*     */   public static EquipCraftConfig getInstance() {
/*  35 */     if (instance == null) {
/*  36 */       instance = new EquipCraftConfig();
/*     */     }
/*  38 */     return instance;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  43 */   private List<Integer> refineMagicGroupIds = null;
/*     */ 
/*     */ 
/*     */   
/*     */   private EquipCraftConfig() {
/*  48 */     this.refineMagicGroupIds = new ArrayList<>();
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
/*     */   public CombineExt getCombineProp(int destId) {
/*  66 */     return (CombineExt)GameData.Combines.get(Integer.valueOf(destId));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemOuterClass.Combine getCombineFormula(CombineExt prop) {
/*  76 */     ItemOuterClass.Combine.Builder data = ItemOuterClass.Combine.newBuilder();
/*  77 */     data.setProduct(ItemUtil.getMiniItemData(prop.destCode, 1, null));
/*     */     
/*  79 */     List<ItemOuterClass.MiniItem> materials = new ArrayList<>();
/*  80 */     for (WNBag.SimpleItemInfo componet : prop.material) {
/*     */       
/*  82 */       ItemOuterClass.MiniItem tmp = ItemUtil.getMiniItemData(componet.itemCode, componet.itemNum, null).build();
/*  83 */       if (tmp != null) {
/*  84 */         materials.add(tmp);
/*     */       }
/*     */     } 
/*  87 */     data.addAllMaterials(materials);
/*  88 */     data.setGold(prop.costGold);
/*     */     
/*  90 */     return data.build();
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
/*     */   public EnchantExt getEnchantConfig(int enClass, int enLevel) {
/* 110 */     List<EnchantExt> list = GameData.findEnchants(t -> 
/* 111 */         (t.enClass == enClass && t.enLevel == enLevel));
/*     */     
/* 113 */     return (list.size() > 0) ? list.get(0) : null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMaxStrengthLevel() {
/* 120 */     return GameData.Enchants.values().size();
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
/*     */   public List<Integer> getRefineMagicGroupIds() {
/* 179 */     return this.refineMagicGroupIds;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public EquipMakeExt getEquipMakePropByCode(String targetCode) {
/* 186 */     List<EquipMakeExt> list = GameData.findEquipMakes(t -> t.targetCode.equals(targetCode));
/*     */ 
/*     */     
/* 189 */     if (list.size() > 0) {
/* 190 */       return list.get(0);
/*     */     }
/* 192 */     return null;
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
/*     */   public MeltConfigCO getMeltProp(int meltLevel, int quality) {
/* 221 */     Collection<MeltConfigCO> col = GameData.MeltConfigs.values();
/* 222 */     for (MeltConfigCO cfg : col) {
/* 223 */       if (cfg.meltLevel == meltLevel && cfg.equipQColor == quality) {
/* 224 */         return cfg;
/*     */       }
/*     */     } 
/* 227 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<IntIntPair> getValidSuits(WNPlayer player) {
/* 237 */     List<IntIntPair> results = new ArrayList<>();
/* 238 */     for (SuitListExt config : GameData.SuitLists.values()) {
/* 239 */       if (config.isValid == 0) {
/*     */         continue;
/*     */       }
/* 242 */       if (player.player.level < config.level) {
/*     */         continue;
/*     */       }
/* 245 */       List<String> suitCodes = config.getContaintsCode(player.equipManager.equips);
/* 246 */       if (suitCodes.size() == 0) {
/*     */         continue;
/*     */       }
/* 249 */       results.add(new IntIntPair(config.suitID, suitCodes.size()));
/*     */     } 
/* 251 */     return results;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Map<String, Integer> getSuitAtts(List<IntIntPair> configs) {
/* 261 */     Map<String, Integer> results = new HashMap<>();
/* 262 */     for (SuitConfigExt config : GameData.SuitConfigs.values()) {
/* 263 */       for (IntIntPair idCount : configs) {
/* 264 */         if (config.suitID == idCount.first && config.partReqCount <= idCount.second) {
/* 265 */           if (results.containsKey(config._prop)) {
/* 266 */             results.put(config._prop, Integer.valueOf(((Integer)results.get(config._prop)).intValue() + config.min)); continue;
/*     */           } 
/* 268 */           results.put(config._prop, Integer.valueOf(config.min));
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 273 */     return results;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\equip\EquipCraftConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */