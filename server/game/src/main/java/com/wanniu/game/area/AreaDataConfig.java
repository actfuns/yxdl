/*    */ package com.wanniu.game.area;
/*    */ 
/*    */ import com.wanniu.game.data.GameData;
/*    */ import com.wanniu.game.data.base.MapBase;
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.function.Predicate;
/*    */ 
/*    */ public class AreaDataConfig
/*    */ {
/*    */   private static AreaDataConfig instance;
/*    */   public Map<Integer, MapBase> allMaps;
/*    */   
/*    */   public static AreaDataConfig getInstance() {
/* 17 */     if (instance == null) {
/* 18 */       instance = new AreaDataConfig();
/*    */     }
/* 20 */     return instance;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private AreaDataConfig() {
/* 29 */     this.allMaps = new HashMap<>();
/*    */     this.allMaps.putAll(GameData.GameMaps);
/*    */     this.allMaps.putAll(GameData.DungeonMaps);
/* 32 */     this.allMaps.putAll(GameData.NormalMaps); } public final MapBase get(int mapId) { return this.allMaps.get(Integer.valueOf(mapId)); }
/*    */ 
/*    */   
/*    */   public final List<MapBase> find(Predicate<MapBase> pre) {
/* 36 */     List<MapBase> list = new ArrayList<>();
/* 37 */     for (MapBase map : this.allMaps.values()) {
/* 38 */       if (pre.test(map)) {
/* 39 */         list.add(map);
/*    */       }
/*    */     } 
/* 42 */     return list;
/*    */   }
/*    */   
/*    */   public final void foreach(Predicate<MapBase> pre) {
/* 46 */     for (MapBase map : this.allMaps.values())
/* 47 */       pre.test(map); 
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\area\AreaDataConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */