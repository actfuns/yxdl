/*    */ package com.wanniu.game.area;
/*    */ 
/*    */ import com.wanniu.game.GWorld;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.concurrent.ConcurrentHashMap;
/*    */ 
/*    */ 
/*    */ public class AreaMap
/*    */   extends ConcurrentHashMap<String, Area>
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 14 */   private Map<String, Map<String, Area>> Areas = new ConcurrentHashMap<>();
/*    */   
/*    */   private String getKey(int logicServerId, int areaId) {
/* 17 */     return GWorld.__SERVER_ID + ":" + areaId;
/*    */   }
/*    */   
/*    */   private String getKey(Area area) {
/* 21 */     return GWorld.__SERVER_ID + ":" + area.areaId;
/*    */   }
/*    */ 
/*    */   
/*    */   public Area put(String key, Area area) {
/* 26 */     Map<String, Area> areas = this.Areas.get(getKey(area));
/* 27 */     int line = 1;
/* 28 */     if (areas == null) {
/* 29 */       areas = new ConcurrentHashMap<>();
/* 30 */       this.Areas.put(getKey(area), areas);
/*    */     } 
/* 32 */     boolean find = false;
/*    */     while (true) {
/* 34 */       find = false;
/* 35 */       for (Area a : areas.values()) {
/* 36 */         if (a.lineIndex == line) {
/* 37 */           line++;
/* 38 */           find = true;
/*    */         } 
/*    */       } 
/* 41 */       if (!find) {
/* 42 */         area.lineIndex = line;
/* 43 */         areas.put(key, area);
/* 44 */         return super.put(key, area);
/*    */       } 
/*    */     } 
/*    */   }
/*    */   public Area remove(Object key) {
/* 49 */     Area area = super.remove(key);
/* 50 */     if (area != null) {
/* 51 */       Map<String, Area> areas = this.Areas.get(getKey(area));
/* 52 */       if (areas != null) {
/* 53 */         areas.remove(key);
/*    */       }
/*    */     } 
/* 56 */     return area;
/*    */   }
/*    */   
/*    */   public Area dispactch(int areaId, int logicServerId, int addCount) {
/* 60 */     Map<String, Area> areas = this.Areas.get(getKey(logicServerId, areaId));
/* 61 */     if (areas != null) {
/* 62 */       for (Area area : areas.values()) {
/* 63 */         if (!area.isFull(addCount)) {
/* 64 */           return area;
/*    */         }
/*    */       } 
/*    */     }
/* 68 */     return null;
/*    */   }
/*    */   
/*    */   public List<Area> getAreas(int areaId, int logicServerId) {
/* 72 */     List<Area> list = new ArrayList<>();
/* 73 */     Map<String, Area> areas = this.Areas.get(getKey(logicServerId, areaId));
/* 74 */     if (areas != null) {
/* 75 */       list.addAll(areas.values());
/*    */     }
/* 77 */     return list;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\area\AreaMap.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */