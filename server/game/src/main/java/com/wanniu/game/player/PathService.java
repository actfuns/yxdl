/*     */ package com.wanniu.game.player;
/*     */ 
/*     */ import com.wanniu.game.area.AreaDataConfig;
/*     */ import com.wanniu.game.data.base.MapBase;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PathService
/*     */ {
/*     */   private static PathService instance;
/*  22 */   private Map<Integer, Map<Integer, Integer>> adj = null;
/*  23 */   private Map<Integer, Map<Integer, Integer>> pathMap = null;
/*     */   
/*     */   private PathService() {
/*  26 */     Map<Integer, MapBase> allMaps = (AreaDataConfig.getInstance()).allMaps;
/*  27 */     Set<Integer> sceneIds = allMaps.keySet();
/*  28 */     this.adj = new HashMap<>();
/*  29 */     this.pathMap = new HashMap<>();
/*  30 */     for (Iterator<Integer> iterator = sceneIds.iterator(); iterator.hasNext(); ) { int id = ((Integer)iterator.next()).intValue();
/*  31 */       this.adj.put(Integer.valueOf(id), new HashMap<>()); }
/*     */ 
/*     */     
/*  34 */     allMaps.values().forEach(prop -> {
/*     */           Map<String, Integer> toPath = prop.toPath;
/*     */           
/*     */           for (String pointId : toPath.keySet()) {
/*     */             addEdge(prop.mapID, ((Integer)toPath.get(pointId)).intValue(), Integer.parseInt(pointId));
/*     */           }
/*     */         });
/*  41 */     traverse();
/*     */   }
/*     */   
/*     */   public static PathService getInstance() {
/*  45 */     if (instance == null) {
/*  46 */       instance = new PathService();
/*     */     }
/*  48 */     return instance;
/*     */   }
/*     */   
/*     */   private void addEdge(int fromId, int toId, int pointId) {
/*  52 */     ((Map<Integer, Integer>)this.adj.get(Integer.valueOf(fromId))).put(Integer.valueOf(toId), Integer.valueOf(pointId));
/*     */   }
/*     */   
/*     */   private void traverse() {
/*  56 */     for (Iterator<Integer> iterator = this.adj.keySet().iterator(); iterator.hasNext(); ) { int id = ((Integer)iterator.next()).intValue();
/*  57 */       Map<Integer, Integer> data = _bfs(id);
/*  58 */       this.pathMap.put(Integer.valueOf(id), data); }
/*     */   
/*     */   }
/*     */   
/*     */   private Map<Integer, Integer> _bfs(int fromId) {
/*  63 */     Map<Integer, Boolean> marked = new HashMap<>();
/*  64 */     for (Iterator<Integer> iterator = this.adj.keySet().iterator(); iterator.hasNext(); ) { int areaId = ((Integer)iterator.next()).intValue();
/*  65 */       marked.put(Integer.valueOf(areaId), Boolean.valueOf(false)); }
/*     */     
/*  67 */     Map<Integer, Integer> data = new HashMap<>();
/*  68 */     data.put(Integer.valueOf(fromId), Integer.valueOf(-1));
/*  69 */     marked.put(Integer.valueOf(fromId), Boolean.valueOf(true));
/*  70 */     _bfsUtil(data, marked, fromId);
/*  71 */     return data;
/*     */   }
/*     */   
/*     */   private void _bfsUtil(Map<Integer, Integer> data, Map<Integer, Boolean> marked, int id) {
/*  75 */     List<Integer> que = new ArrayList<>();
/*  76 */     que.add(Integer.valueOf(id));
/*  77 */     while (que.size() != 0) {
/*  78 */       id = ((Integer)que.remove(0)).intValue();
/*  79 */       if (this.adj.get(Integer.valueOf(id)) != null) {
/*  80 */         for (Iterator<Integer> iterator = ((Map)this.adj.get(Integer.valueOf(id))).keySet().iterator(); iterator.hasNext(); ) { int childId = ((Integer)iterator.next()).intValue();
/*  81 */           if (marked.get(Integer.valueOf(childId)) == null || !((Boolean)marked.get(Integer.valueOf(childId))).booleanValue()) {
/*  82 */             data.put(Integer.valueOf(childId), Integer.valueOf(id));
/*  83 */             marked.put(Integer.valueOf(childId), Boolean.valueOf(true));
/*  84 */             que.add(Integer.valueOf(childId));
/*     */           }  }
/*     */       
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public int findPath(int fromId, int toId) {
/*  92 */     List<Integer> result = new ArrayList<>();
/*     */     
/*  94 */     if (this.pathMap.get(Integer.valueOf(fromId)) != null && this.pathMap.get(Integer.valueOf(toId)) != null) {
/*  95 */       Map<Integer, Integer> data = this.pathMap.get(Integer.valueOf(fromId));
/*  96 */       result.add(Integer.valueOf(toId));
/*  97 */       int pid = (data.get(Integer.valueOf(toId)) == null) ? -1 : ((Integer)data.get(Integer.valueOf(toId))).intValue();
/*  98 */       while (pid != -1) {
/*  99 */         result.add(Integer.valueOf(pid));
/* 100 */         pid = ((Integer)data.get(Integer.valueOf(pid))).intValue();
/*     */       } 
/*     */     } 
/*     */     
/* 104 */     int pointId = 0;
/* 105 */     if (result.size() >= 2) {
/* 106 */       int secondAreaId = ((Integer)result.get(result.size() - 2)).intValue();
/* 107 */       pointId = ((Integer)((Map)this.adj.get(Integer.valueOf(fromId))).get(Integer.valueOf(secondAreaId))).intValue();
/*     */     } 
/* 109 */     return pointId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int findToAreaByPointId(int areaId, String pointId) {
/* 116 */     MapBase prop = AreaDataConfig.getInstance().get(areaId);
/* 117 */     if (prop != null) {
/* 118 */       Map<String, Integer> toPathData = prop.toPath;
/* 119 */       if (toPathData.containsKey(pointId)) {
/* 120 */         return ((Integer)toPathData.get(pointId)).intValue();
/*     */       }
/*     */     } 
/* 123 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static float[] findToAreaXYByPointId(int areaId, String pointId) {
/* 130 */     MapBase prop = AreaDataConfig.getInstance().get(areaId);
/* 131 */     if (prop != null) {
/* 132 */       Map<String, float[]> toPathXY = prop.toPathXY;
/* 133 */       if (toPathXY.containsKey(pointId)) {
/* 134 */         return toPathXY.get(pointId);
/*     */       }
/*     */     } 
/* 137 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static float[] findToAreaXYByAreaId(int areaId, int toAreaId) {
/* 144 */     MapBase prop = AreaDataConfig.getInstance().get(areaId);
/* 145 */     if (prop != null) {
/* 146 */       Map<Integer, float[]> toPathXY = prop.toAreaXY;
/* 147 */       if (toPathXY.containsKey(Integer.valueOf(toAreaId))) {
/* 148 */         return toPathXY.get(Integer.valueOf(toAreaId));
/*     */       }
/*     */     } 
/* 151 */     return null;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\player\PathService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */