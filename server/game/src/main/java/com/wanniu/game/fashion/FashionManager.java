/*     */ package com.wanniu.game.fashion;
/*     */ 
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.ModuleManager;
/*     */ import com.wanniu.game.data.GameData;
/*     */ import com.wanniu.game.data.ext.FashSuitConfigExt;
/*     */ import com.wanniu.game.data.ext.FashionExt;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.player.bi.LogReportService;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import pomelo.area.PlayerHandler;
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
/*     */ 
/*     */ public class FashionManager
/*     */   extends ModuleManager
/*     */ {
/*     */   public WNPlayer player;
/*     */   
/*     */   public FashionManager(WNPlayer player) {
/*  36 */     this.player = player;
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
/*     */   private boolean getFashionGet(String code) {
/*  58 */     boolean have = false;
/*  59 */     for (String temp_code : this.player.playerBasePO.fashions_get) {
/*  60 */       if (temp_code.equals(code)) {
/*  61 */         have = true;
/*     */         break;
/*     */       } 
/*     */     } 
/*  65 */     if (!have) {
/*  66 */       return false;
/*     */     }
/*  68 */     return true;
/*     */   }
/*     */   
/*     */   private PlayerHandler.SuperScriptType createSuperScriptType(int type, int num) {
/*  72 */     PlayerHandler.SuperScriptType.Builder data = PlayerHandler.SuperScriptType.newBuilder();
/*  73 */     data.setType(type);
/*  74 */     data.setNumber(num);
/*  75 */     return data.build();
/*     */   }
/*     */   
/*     */   public List<PlayerHandler.SuperScriptType> getSuperScriptList() {
/*  79 */     List<PlayerHandler.SuperScriptType> ls = new ArrayList<>();
/*     */     
/*  81 */     ls.add(createSuperScriptType(Const.SUPERSCRIPT_TYPE.FLAG_FASHION.getValue(), this.player.playerBasePO.fashion_get_spot));
/*     */ 
/*     */     
/*  84 */     return ls;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean activiateFashion(String code) {
/*  93 */     if (getFashionGet(code)) {
/*  94 */       return false;
/*     */     }
/*     */     
/*  97 */     FashionExt fashionExt = (FashionExt)GameData.Fashions.get(code);
/*  98 */     if (this.player.getPro() != fashionExt.pro)
/*     */     {
/* 100 */       return false;
/*     */     }
/* 102 */     this.player.playerBasePO.fashions_get.add(code);
/*     */     
/* 104 */     LogReportService.getInstance().ansycReportFashion(this.player, code);
/*     */     
/* 106 */     this.player.playerBasePO.fashion_get_spot = 1;
/* 107 */     List<PlayerHandler.SuperScriptType> ls = getSuperScriptList();
/* 108 */     this.player.updateSuperScriptList(ls);
/*     */     
/* 110 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equipFashion(String code, boolean isOn) {
/* 117 */     FashionExt fashionExt = (FashionExt)GameData.Fashions.get(code);
/*     */     
/* 119 */     if (!getFashionGet(code)) {
/* 120 */       return false;
/*     */     }
/* 122 */     if (isOn) {
/* 123 */       this.player.playerBasePO.fashions_equiped.put(Integer.valueOf(fashionExt.type), fashionExt.code);
/*     */     } else {
/* 125 */       this.player.playerBasePO.fashions_equiped.put(Integer.valueOf(fashionExt.type), null);
/*     */     } 
/*     */     
/* 128 */     fashionSync();
/* 129 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void fashionSync() {
/* 137 */     this.player.btlDataManager.data_fashion = calAllInfluence();
/* 138 */     this.player.btlDataManager.calFinalData();
/* 139 */     this.player.onFashionChange();
/* 140 */     this.player.refreshBattlerServerAvatar();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Map<Const.PlayerBtlData, Integer> calAllInfluence() {
/* 147 */     Map<Const.PlayerBtlData, Integer> data = new ConcurrentHashMap<>();
/*     */ 
/*     */     
/* 150 */     for (Map.Entry<Integer, String> entry : (Iterable<Map.Entry<Integer, String>>)this.player.playerBasePO.fashions_equiped.entrySet()) {
/* 151 */       if (entry.getValue() == null) {
/*     */         continue;
/*     */       }
/* 154 */       String code = entry.getValue();
/*     */       
/* 156 */       FashionExt fashion = (FashionExt)GameData.Fashions.get(code);
/*     */       
/* 158 */       deepCopy(data, fashion.atts);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 163 */     Map<Integer, List<String>> suits = new HashMap<>();
/* 164 */     for (FashionExt fashion : GameData.Fashions.values()) {
/* 165 */       List<String> list = suits.get(Integer.valueOf(fashion.fashionID));
/* 166 */       if (list == null) {
/* 167 */         list = new ArrayList<>();
/* 168 */         suits.put(Integer.valueOf(fashion.fashionID), list);
/*     */       } 
/* 170 */       if (list.contains(fashion.code)) {
/* 171 */         Out.debug(new Object[] { list });
/* 172 */         Out.error(new Object[] { "居然会走到这里？" });
/*     */         
/*     */         continue;
/*     */       } 
/* 176 */       if (this.player.playerBasePO.fashions_get.contains(fashion.code))
/*     */       {
/* 178 */         list.add(fashion.code);
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
/* 190 */     for (FashSuitConfigExt suit : GameData.FashSuitConfigs.values()) {
/* 191 */       for (Iterator<Integer> iterator = suits.keySet().iterator(); iterator.hasNext(); ) { int suitID = ((Integer)iterator.next()).intValue();
/* 192 */         int count = ((List)suits.get(Integer.valueOf(suitID))).size();
/* 193 */         if (count == 2) {
/* 194 */           deepCopy(data, suit.Attr2Map);
/*     */         }
/* 196 */         if (count == 3) {
/* 197 */           deepCopy(data, suit.Attr3Map);
/*     */         } }
/*     */     
/*     */     } 
/* 201 */     return data;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void deepCopy(Map<Const.PlayerBtlData, Integer> data, Map<Const.PlayerBtlData, Integer> source) {
/* 208 */     if (source == null) {
/*     */       return;
/*     */     }
/* 211 */     for (Map.Entry<Const.PlayerBtlData, Integer> entry : source.entrySet()) {
/* 212 */       if (data.get(entry.getKey()) != null && ((Integer)data.get(entry.getKey())).intValue() > 0) {
/* 213 */         data.put(entry.getKey(), Integer.valueOf(((Integer)data.get(entry.getKey())).intValue() + ((Integer)entry.getValue()).intValue())); continue;
/*     */       } 
/* 215 */       data.put(entry.getKey(), entry.getValue());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public List<ItemOuterClass.EquipFashionInfo> toJson4Fashion() {
/* 221 */     List<ItemOuterClass.EquipFashionInfo> list = new ArrayList<>();
/* 222 */     for (String temp_code : this.player.playerBasePO.fashions_get) {
/* 223 */       FashionExt fashion = (FashionExt)GameData.Fashions.get(temp_code);
/*     */       
/* 225 */       ItemOuterClass.EquipFashionInfo.Builder fashionInfo = ItemOuterClass.EquipFashionInfo.newBuilder();
/* 226 */       fashionInfo.setPos(fashion.type);
/* 227 */       fashionInfo.setItemcode(temp_code);
/* 228 */       list.add(fashionInfo.build());
/*     */     } 
/* 230 */     return list;
/*     */   }
/*     */   
/*     */   public void onPlayerEvent(Const.PlayerEventType eventType) {
/*     */     List<PlayerHandler.SuperScriptType> ls;
/* 235 */     switch (eventType) {
/*     */       case AFTER_LOGIN:
/* 237 */         ls = getSuperScriptList();
/* 238 */         this.player.updateSuperScriptList(ls);
/*     */         break;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Const.ManagerType getManagerType() {
/* 249 */     return Const.ManagerType.FASHION;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\fashion\FashionManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */