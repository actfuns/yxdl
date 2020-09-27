/*     */ package com.wanniu.game.item;
/*     */ 
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.util.StringUtil;
/*     */ import com.wanniu.game.data.BeforeFilterCO;
/*     */ import com.wanniu.game.data.GameData;
/*     */ import com.wanniu.game.data.MiscCO;
/*     */ import com.wanniu.game.data.PlantingCO;
/*     */ import com.wanniu.game.data.base.DEquipBase;
/*     */ import com.wanniu.game.data.base.DItemBase;
/*     */ import com.wanniu.game.data.base.DItemEquipBase;
/*     */ import com.wanniu.game.data.ext.EquipSockExt;
/*     */ import com.wanniu.game.data.ext.ItemIdConfigExt;
/*     */ import com.wanniu.game.data.ext.ItemTypeConfigExt;
/*     */ import com.wanniu.game.data.ext.ReBuildExt;
/*     */ import com.wanniu.game.data.ext.TreasureClassExt;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ItemConfig
/*     */ {
/*  30 */   private Map<String, DItemBase> itemTemplates = new HashMap<>();
/*     */ 
/*     */   
/*  33 */   private Map<String, DEquipBase> equipTemplates = new HashMap<>();
/*     */ 
/*     */   
/*  36 */   private Map<String, List<Integer>> gemPos = new HashMap<>();
/*     */ 
/*     */   
/*  39 */   public Map<String, BeforeFilterCO> tcs = null;
/*     */ 
/*     */   
/*  42 */   public Map<Integer, Map<Integer, ReBuildExt>> rebuildMap = null;
/*     */ 
/*     */ 
/*     */   
/*  46 */   public static Map<String, MiscCO> seedMiscMap = null;
/*     */   
/*  48 */   public static Map<String, MiscCO> productMiscMap = null;
/*     */   
/*  50 */   public static Map<String, PlantingCO> plantingMap = null;
/*     */   
/*     */   public static ItemConfig getInstance() {
/*  53 */     return Holder.instance;
/*     */   }
/*     */ 
/*     */   
/*     */   private static final class Holder
/*     */   {
/*  59 */     public static final ItemConfig instance = new ItemConfig();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void loadScript() {
/*  67 */     this.itemTemplates.putAll(GameData.Jewels);
/*  68 */     this.itemTemplates.putAll(GameData.RideItems);
/*  69 */     this.itemTemplates.putAll(GameData.PetItems);
/*  70 */     this.itemTemplates.putAll(GameData.Chests);
/*  71 */     this.itemTemplates.putAll(GameData.Potions);
/*  72 */     this.itemTemplates.putAll(GameData.Mates);
/*  73 */     this.itemTemplates.putAll(GameData.Miscs);
/*  74 */     this.itemTemplates.putAll(GameData.Virtuals);
/*  75 */     this.itemTemplates.putAll(GameData.Ranks);
/*  76 */     this.itemTemplates.putAll(GameData.Quests);
/*  77 */     this.itemTemplates.putAll(GameData.Actives);
/*  78 */     this.itemTemplates.putAll(GameData.FashionItems);
/*     */ 
/*     */     
/*  81 */     this.equipTemplates.putAll(GameData.NormalEquips);
/*  82 */     this.equipTemplates.putAll(GameData.BlueEquips);
/*  83 */     this.equipTemplates.putAll(GameData.PurpleEquips);
/*  84 */     this.equipTemplates.putAll(GameData.LegendEquips);
/*  85 */     this.equipTemplates.putAll(GameData.SuitEquips);
/*  86 */     this.equipTemplates.putAll(GameData.RideEquips);
/*  87 */     this.equipTemplates.putAll(GameData.UniqueEquips);
/*     */ 
/*     */     
/*  90 */     for (EquipSockExt sock : GameData.EquipSocks.values()) {
/*  91 */       for (String gem : sock.typeList) {
/*  92 */         List<Integer> poses = this.gemPos.get(gem);
/*  93 */         if (poses == null) {
/*  94 */           poses = new ArrayList<>();
/*  95 */           this.gemPos.put(gem, poses);
/*     */         } 
/*     */         
/*  98 */         if (!poses.contains(Integer.valueOf(sock.typeID))) {
/*  99 */           poses.add(Integer.valueOf(sock.typeID));
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 105 */     this.tcs = new HashMap<>();
/* 106 */     for (BeforeFilterCO filter : GameData.BeforeFilters.values()) {
/* 107 */       if (filter.dynamicLv.indexOf("~") != -1) {
/* 108 */         String[] lvZones = filter.dynamicLv.split(",");
/* 109 */         for (String lvZone : lvZones) {
/* 110 */           String[] lvs = lvZone.split("~");
/* 111 */           if (lvs.length == 2) {
/* 112 */             int min = Integer.parseInt(lvs[0]);
/* 113 */             int max = Integer.parseInt(lvs[1]);
/* 114 */             for (int i = min; i <= max; i++) {
/* 115 */               this.tcs.put(filter.tcCode + i, filter);
/*     */             }
/*     */           } else {
/* 118 */             Out.error(new Object[] { "BeforeFilterCO.dynamicLv 格式错误：~号分隔必须有2个level数字" });
/*     */           } 
/*     */         } 
/*     */         continue;
/*     */       } 
/* 123 */       this.tcs.put(filter.tcCode + filter.dynamicLv, filter);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 128 */     this.rebuildMap = new HashMap<>();
/* 129 */     for (ReBuildExt reBuildExt : GameData.ReBuilds.values()) {
/* 130 */       if (!this.rebuildMap.containsKey(Integer.valueOf(reBuildExt.level)))
/* 131 */         this.rebuildMap.put(Integer.valueOf(reBuildExt.level), new HashMap<>()); 
/* 132 */       if (!((Map)this.rebuildMap.get(Integer.valueOf(reBuildExt.level))).containsKey(Integer.valueOf(reBuildExt.lockNum))) {
/* 133 */         ((Map<Integer, ReBuildExt>)this.rebuildMap.get(Integer.valueOf(reBuildExt.level))).put(Integer.valueOf(reBuildExt.lockNum), reBuildExt);
/*     */       }
/*     */     } 
/*     */     
/* 137 */     seedMiscMap = new HashMap<>();
/* 138 */     for (MiscCO miscCO : GameData.Miscs.values()) {
/* 139 */       if (miscCO.code.length() == 6) {
/* 140 */         String strs = miscCO.code.substring(0, 4);
/* 141 */         if (strs.equals("seed"))
/* 142 */           seedMiscMap.put(miscCO.code, miscCO); 
/*     */       } 
/*     */     } 
/* 145 */     productMiscMap = new HashMap<>();
/* 146 */     for (MiscCO miscCO : GameData.Miscs.values()) {
/* 147 */       if (miscCO.code.length() == 9) {
/* 148 */         String strs = miscCO.code.substring(0, 7);
/* 149 */         if (strs.equals("product"))
/* 150 */           productMiscMap.put(miscCO.code, miscCO); 
/*     */       } 
/*     */     } 
/* 153 */     plantingMap = new HashMap<>();
/* 154 */     for (PlantingCO plantingCO : GameData.Plantings.values()) {
/* 155 */       plantingMap.put(plantingCO.code, plantingCO);
/*     */     }
/*     */   }
/*     */   
/*     */   public Map<String, DItemBase> getItemTemplates() {
/* 160 */     return this.itemTemplates;
/*     */   }
/*     */   
/*     */   public Map<String, DEquipBase> getEquipTemplates() {
/* 164 */     return this.equipTemplates;
/*     */   }
/*     */   
/*     */   public DEquipBase getEquipProp(String templateCode) {
/* 168 */     DEquipBase result = this.equipTemplates.get(templateCode);
/* 169 */     if (result == null) {
/* 170 */       Out.error(new Object[] { String.format("Item equipTemplate [%s] is not found.", new Object[] { templateCode }) });
/*     */     }
/* 172 */     return result;
/*     */   }
/*     */   
/*     */   public DItemEquipBase getItemPropByName(String name) {
/* 176 */     for (DItemEquipBase result : this.itemTemplates.values()) {
/* 177 */       if (result.name.equals(name)) {
/* 178 */         return result;
/*     */       }
/*     */     } 
/* 181 */     for (DItemEquipBase result : this.equipTemplates.values()) {
/* 182 */       if (result.name.equals(name)) {
/* 183 */         return result;
/*     */       }
/*     */     } 
/* 186 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DItemEquipBase getItemProp(String templateCode) {
/* 196 */     DItemEquipBase result = (DItemEquipBase)this.itemTemplates.get(templateCode);
/* 197 */     if (result == null) {
/* 198 */       result = (DItemEquipBase)this.equipTemplates.get(templateCode);
/*     */     }
/* 200 */     if (result == null) {
/* 201 */       Out.error(new Object[] { getClass(), String.format("Item template [%s] is not found.", new Object[] { templateCode }) });
/*     */     }
/* 203 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<DEquipBase> getEquipProps(int qColor, int tcLevel, int itemSecondType) {
/* 210 */     List<DEquipBase> list = new ArrayList<>();
/* 211 */     Collection<DEquipBase> collection = this.equipTemplates.values();
/* 212 */     for (DEquipBase template : collection) {
/* 213 */       if (template.qcolor == qColor && template.tcLevel == tcLevel && getSecondType(template.type) == itemSecondType && template.isValid != 0) {
/* 214 */         list.add(template);
/*     */       }
/*     */     } 
/* 217 */     return list;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemIdConfigExt getIdConfig(String itemType) {
/* 224 */     return (ItemIdConfigExt)GameData.ItemIdConfigs.get(itemType);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemTypeConfigExt getTypeConfig(String subType) {
/* 231 */     for (ItemTypeConfigExt cfg : GameData.ItemTypeConfigs.values()) {
/* 232 */       for (String component : cfg.subTypes) {
/* 233 */         if (!StringUtil.isEmpty(component) && component.equalsIgnoreCase(subType)) {
/* 234 */           return cfg;
/*     */         }
/*     */       } 
/*     */     } 
/* 238 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getFirstType(String type) {
/* 245 */     return (getTypeConfig(type)).iD;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSecondType(String type) {
/* 252 */     return (getIdConfig(type)).typeID;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TreasureClassExt getTcProp(String tcCode) {
/* 259 */     return (TreasureClassExt)GameData.TreasureClasss.get(tcCode);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DItemBase findUnEquipPropsByProp(String prop) {
/* 266 */     Collection<DItemBase> items = this.itemTemplates.values();
/* 267 */     for (DItemBase item : items) {
/* 268 */       if (item.prop.equals(prop)) {
/* 269 */         return item;
/*     */       }
/*     */     } 
/* 272 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<DItemBase> findUnEquipPropsByType(String type) {
/* 279 */     Collection<DItemBase> items = this.itemTemplates.values();
/* 280 */     List<DItemBase> ret = new ArrayList<>();
/* 281 */     for (DItemBase item : items) {
/* 282 */       if (item.type.equals(type)) {
/* 283 */         ret.add(item);
/*     */       }
/*     */     } 
/* 286 */     return ret;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<Integer> findPosByGem(String gem) {
/* 293 */     return this.gemPos.get(gem);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getRealTC(String tc, int level) {
/* 300 */     if (level <= 0) {
/* 301 */       return tc;
/*     */     }
/* 303 */     BeforeFilterCO lvTC = this.tcs.get(tc + level);
/* 304 */     if (lvTC == null) {
/* 305 */       return tc;
/*     */     }
/*     */     
/* 308 */     return lvTC.tcForLv;
/*     */   }
/*     */   
/*     */   private ItemConfig() {}
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\item\ItemConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */