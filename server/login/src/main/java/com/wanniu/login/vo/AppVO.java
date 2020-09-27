/*     */ package com.wanniu.login.vo;
/*     */ 
/*     */ import com.alibaba.fastjson.JSON;
/*     */ import com.alibaba.fastjson.JSONArray;
/*     */ import com.alibaba.fastjson.JSONObject;
/*     */ import com.wanniu.core.GServer;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.redis.GCache;
/*     */ import com.wanniu.core.redis.GlobalDao;
/*     */ import com.wanniu.core.tcp.protocol.Packet;
/*     */ import com.wanniu.core.util.StringUtil;
/*     */ import com.wanniu.login.LoginServer;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ 
/*     */ public class AppVO
/*     */ {
/*  22 */   public Map<Integer, ServerVO> allServers = new ConcurrentHashMap<>();
/*     */   
/*  24 */   public Map<Integer, AreaVO> areas = new ConcurrentHashMap<>();
/*     */   
/*     */   public int appId;
/*     */   
/*     */   public AppVO(int appId) {
/*  29 */     this.appId = appId;
/*     */   }
/*     */   
/*     */   public void addArea(int areaId, String name) {
/*  33 */     AreaVO area = getArea(areaId);
/*  34 */     area.areaName = name;
/*  35 */     GCache.hset("/arealist/" + this.appId, String.valueOf(areaId), name);
/*     */   }
/*     */   
/*     */   public void addArea(AreaVO area) {
/*  39 */     this.areas.put(Integer.valueOf(area.areaId), area);
/*     */   }
/*     */   
/*     */   public void removeArea(int areaId) {
/*  43 */     AreaVO area = this.areas.remove(Integer.valueOf(areaId));
/*  44 */     if (area != null) {
/*  45 */       for (Iterator<Integer> iterator = area.areaServers.keySet().iterator(); iterator.hasNext(); ) { int logicServerId = ((Integer)iterator.next()).intValue();
/*  46 */         this.allServers.remove(Integer.valueOf(logicServerId));
/*  47 */         GCache.hremove("/serverlist/" + this.appId, String.valueOf(logicServerId)); }
/*     */       
/*  49 */       GCache.hremove("/arealist/" + this.appId, String.valueOf(areaId));
/*     */     } 
/*     */   }
/*     */   
/*     */   public AreaVO getArea(int areaId) {
/*  54 */     AreaVO area = this.areas.get(Integer.valueOf(areaId));
/*  55 */     if (area == null) {
/*  56 */       String name = GCache.hget("/arealist/" + this.appId, String.valueOf(areaId));
/*  57 */       if (name != null) {
/*  58 */         area = new AreaVO(areaId);
/*  59 */         area.appId = this.appId;
/*  60 */         area.areaName = name;
/*  61 */         this.areas.put(Integer.valueOf(area.areaId), area);
/*     */       } 
/*  63 */       if (area == null) {
/*  64 */         area = new AreaVO(areaId);
/*  65 */         this.areas.put(Integer.valueOf(areaId), area);
/*     */       } 
/*     */     } 
/*  68 */     return area;
/*     */   }
/*     */   
/*     */   public void addServer(ServerVO server) {
/*  72 */     ServerVO oldServer = this.allServers.get(Integer.valueOf(server.logicServerId));
/*  73 */     if (oldServer != null) {
/*  74 */       AreaVO areaVO = getArea(oldServer.areaId);
/*  75 */       if (areaVO.areaId != server.areaId) {
/*  76 */         areaVO.remove(server.logicServerId);
/*     */       }
/*     */     } 
/*  79 */     AreaVO area = getArea(server.areaId);
/*  80 */     area.add(server);
/*  81 */     this.allServers.put(Integer.valueOf(server.logicServerId), server);
/*     */   }
/*     */   
/*     */   public void remove(int logicServerId) {
/*  85 */     ServerVO server = get(logicServerId);
/*  86 */     if (server != null) {
/*  87 */       AreaVO area = this.areas.get(Integer.valueOf(server.areaId));
/*  88 */       if (area != null) {
/*  89 */         area.remove(logicServerId);
/*     */       }
/*  91 */       this.allServers.remove(Integer.valueOf(logicServerId));
/*     */     } 
/*  93 */     GCache.hremove("/serverlist/" + this.appId, String.valueOf(logicServerId));
/*     */   }
/*     */   
/*     */   public ServerVO get(int logicServerId) {
/*  97 */     return this.allServers.get(Integer.valueOf(logicServerId));
/*     */   }
/*     */   
/*     */   public void changeArea(ServerVO server) {
/* 101 */     this.areas.remove(Integer.valueOf(server.areaId));
/* 102 */     addServer(server);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JSONArray getServerList(Map<Integer, Integer> histories, Packet pak) {
/* 110 */     String ip = pak.getIp();
/* 111 */     String uid = pak.getUid();
/* 112 */     Out.info(new Object[] { uid, " login at : ", ip });
/* 113 */     JSONArray arr = new JSONArray();
/* 114 */     for (AreaVO area : this.areas.values()) {
/* 115 */       JSONObject json = new JSONObject();
/* 116 */       JSONArray areaServers = new JSONArray();
/* 117 */       for (ServerVO server : area.areaServers.values()) {
/* 118 */         if (server.show > 0) {
/* 119 */           JSONArray show = server.toShowJSON();
/* 120 */           if (server.show == ServerShow.INNER.value && !LoginServer.getInstance().isWhiteList(ip, uid)) {
/* 121 */             show.set(4, Integer.valueOf(ServerLoad.MAINTAIN.value));
/*     */           }
/* 123 */           int roleCount = histories.containsKey(Integer.valueOf(server.logicServerId)) ? ((Integer)histories.get(Integer.valueOf(server.logicServerId))).intValue() : 0;
/* 124 */           show.add(Integer.valueOf(roleCount));
/* 125 */           if (roleCount > 0) {
/* 126 */             JSONArray players = new JSONArray();
/* 127 */             String s_players = GlobalDao.hget(String.valueOf(server.logicServerId), uid);
/* 128 */             if (StringUtil.isNotEmpty(s_players)) {
/* 129 */               JSONObject jsPlayers = JSON.parseObject(s_players);
/* 130 */               for (String rid : jsPlayers.keySet()) {
/* 131 */                 players.add(jsPlayers.getJSONObject(rid));
/*     */               }
/* 133 */               Collections.sort((List<?>)players, new Comparator()
/*     */                   {
/*     */                     public int compare(Object o1, Object o2) {
/* 136 */                       Long t1 = ((JSONObject)o1).getLong("time");
/* 137 */                       Long t2 = ((JSONObject)o2).getLong("time");
/* 138 */                       if (t1 == t2) return 0; 
/* 139 */                       if (t1 == null) return 1; 
/* 140 */                       if (t2 == null) return -1; 
/* 141 */                       return -t1.compareTo(t2);
/*     */                     }
/*     */                   });
/*     */             } 
/* 145 */             show.add(players);
/*     */           } 
/* 147 */           areaServers.add(show);
/*     */         } 
/*     */       } 
/* 150 */       json.put(area.areaName, areaServers);
/* 151 */       arr.add(json);
/*     */     } 
/* 153 */     if (pak.getSession().isActive()) {
/* 154 */       GServer.getInstance().addLoginSession(pak.getSession());
/*     */     }
/* 156 */     return arr;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-login\xmds-login.jar!\com\wanniu\login\vo\AppVO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */