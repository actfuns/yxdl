/*     */ package com.wanniu.login;
/*     */ 
/*     */ import com.alibaba.fastjson.JSON;
/*     */ import com.alibaba.fastjson.JSONObject;
/*     */ import com.wanniu.core.GServer;
/*     */ import com.wanniu.core.GSystem;
/*     */ import com.wanniu.core.game.protocol.PomeloHeader;
/*     */ import com.wanniu.core.game.protocol.PomeloPacket;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.redis.GCache;
/*     */ import com.wanniu.core.tcp.protocol.NetHandler;
/*     */ import com.wanniu.core.tcp.protocol.Packet;
/*     */ import com.wanniu.core.util.DateUtil;
/*     */ import com.wanniu.core.util.StringUtil;
/*     */ import com.wanniu.login.vo.AppVO;
/*     */ import com.wanniu.login.vo.AreaVO;
/*     */ import com.wanniu.login.vo.ServerLoad;
/*     */ import com.wanniu.login.vo.ServerShow;
/*     */ import com.wanniu.login.vo.ServerVO;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ 
/*     */ public class LoginServer
/*     */   extends GServer
/*     */ {
/*  28 */   public static Map<Integer, AppVO> Apps = new ConcurrentHashMap<>();
/*     */   
/*     */   static {
/*  31 */     instance = new LoginServer();
/*     */   }
/*     */   
/*     */   public static LoginServer getInstance() {
/*  35 */     return (LoginServer)instance;
/*     */   }
/*     */ 
/*     */   
/*     */   public void start() {
/*  40 */     super.start();
/*  41 */     GSystem.addFixedRateJob(new Runnable()
/*     */         {
/*     */           public void run() {
/*  44 */             long currTime = System.currentTimeMillis();
/*  45 */             for (AppVO app : LoginServer.Apps.values()) {
/*  46 */               for (ServerVO server : app.allServers.values()) {
/*  47 */                 if (server.load != ServerLoad.MAINTAIN.value && currTime - server.pingtime > 61000L) {
/*  48 */                   server.setLoad(ServerLoad.MAINTAIN.value);
/*  49 */                   Out.warn(new Object[] { server.name, " last ping [", DateUtil.format(new Date(server.pingtime), "yyyy-MM-dd HH:mm:ss.SSS"), "] 变为维护状态了！" });
/*     */                 } 
/*     */               } 
/*     */             } 
/*     */           }
/*  54 */         }, 15000L, 30000L);
/*     */   }
/*     */   public void distatcher(JSONObject json) {
/*     */     ServerVO server;
/*  58 */     int areaId, show, onlineCount, appId = json.getIntValue("appId");
/*  59 */     int logicServerId = json.containsKey("logicServerId") ? json.getIntValue("logicServerId") : 0;
/*  60 */     AppVO app = getApp(appId);
/*  61 */     if (app == null) {
/*  62 */       app = new AppVO(appId);
/*  63 */       Apps.put(Integer.valueOf(appId), app);
/*  64 */       List<String> servers = GCache.hvals("/serverlist/" + appId);
/*  65 */       if (servers != null) {
/*  66 */         for (String str : servers) {
/*     */           try {
/*  68 */             app.addServer((ServerVO)JSON.parseObject(str, ServerVO.class));
/*  69 */           } catch (Exception e) {
/*  70 */             e.printStackTrace();
/*     */           } 
/*     */         } 
/*     */       }
/*     */     } 
/*  75 */     int type = json.getIntValue("type");
/*  76 */     if (type != 259) {
/*  77 */       Out.info(new Object[] { String.format("Message. Msg(%s): %s", new Object[] { Integer.toHexString(json.getInteger("type").intValue()), json.toJSONString() }) });
/*     */     }
/*  79 */     switch (type) {
/*     */       case 257:
/*  81 */         server = app.get(logicServerId);
/*  82 */         areaId = json.containsKey("areaId") ? json.getIntValue("areaId") : 0;
/*  83 */         if (server != null && server.areaId != areaId) {
/*  84 */           app.remove(logicServerId);
/*     */         }
/*  86 */         if (server == null) {
/*  87 */           server = new ServerVO();
/*     */         }
/*  89 */         server.appId = appId;
/*  90 */         server.areaId = areaId;
/*  91 */         server.logicServerId = logicServerId;
/*  92 */         server.name = json.getString("name");
/*  93 */         server.host = json.getString("host");
/*  94 */         server.port = json.getIntValue("port");
/*  95 */         if (json.containsKey("olLimit")) {
/*  96 */           server.olLimit = json.getIntValue("olLimit");
/*     */         }
/*  98 */         if (json.containsKey("recommend")) {
/*  99 */           server.isRecommend = json.getBooleanValue("recommend");
/*     */         }
/* 101 */         if (json.containsKey("new")) {
/* 102 */           server.isNew = json.getBooleanValue("new");
/*     */         }
/* 104 */         if (json.containsKey("hot")) {
/* 105 */           server.isHot = json.getBooleanValue("hot");
/*     */         }
/* 107 */         if (json.containsKey("show")) {
/* 108 */           server.setShow(json.getIntValue("show"));
/*     */         }
/* 110 */         server.setOlCount(server.olCount);
/* 111 */         server.setLoad(Math.max(server.load, ServerLoad.SMOOTH.value));
/* 112 */         app.addServer(server);
/* 113 */         GCache.hset("/serverlist/" + appId, String.valueOf(server.logicServerId), JSON.toJSONString(server));
/* 114 */         Out.info(new Object[] { "游戏服接入：", server });
/*     */         return;
/*     */       
/*     */       case 258:
/* 118 */         server = app.get(logicServerId);
/* 119 */         if (server == null)
/* 120 */           return;  show = json.containsKey("show") ? json.getIntValue("show") : ServerShow.OUTER.value;
/* 121 */         server.setShow(show);
/*     */         return;
/*     */       
/*     */       case 259:
/* 125 */         server = app.get(logicServerId);
/* 126 */         if (server == null)
/* 127 */           return;  onlineCount = json.getIntValue("load");
/* 128 */         server.setOlCount(onlineCount);
/*     */         return;
/*     */       
/*     */       case 260:
/* 132 */         server = app.get(logicServerId);
/* 133 */         server.areaId = json.getIntValue("areaId");
/* 134 */         app.changeArea(server);
/*     */         return;
/*     */       
/*     */       case 261:
/* 138 */         app.addArea(json.getIntValue("areaId"), json.getString("areaName"));
/*     */         return;
/*     */       
/*     */       case 262:
/* 142 */         app.removeArea(json.getIntValue("areaId"));
/*     */         return;
/*     */       
/*     */       case 263:
/* 146 */         app.remove(logicServerId);
/*     */         return;
/*     */       
/*     */       case 264:
/* 150 */         server = app.get(logicServerId);
/* 151 */         if (server == null)
/* 152 */           return;  server.host = json.getString("ip");
/* 153 */         server.port = json.getIntValue("port");
/*     */         return;
/*     */     } 
/*     */     
/* 157 */     Out.warn(new Object[] { "未定义的类型：0x", Integer.toHexString(json.getIntValue("type")), json.toJSONString() });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public AppVO getApp(int appId) {
/* 163 */     AppVO app = Apps.get(Integer.valueOf(appId));
/* 164 */     if (app == null) {
/* 165 */       Map<String, String> areas = GCache.hgetAll("/arealist/" + appId);
/* 166 */       if (areas != null) {
/* 167 */         app = new AppVO(appId);
/* 168 */         for (Map.Entry<String, String> entry : areas.entrySet()) {
/* 169 */           app.addArea(new AreaVO(Integer.valueOf(entry.getKey()).intValue(), entry.getValue()));
/*     */         }
/* 171 */         List<String> servers = GCache.hvals("/serverlist/" + appId);
/* 172 */         if (servers != null) {
/* 173 */           for (String server : servers) {
/*     */             try {
/* 175 */               app.addServer((ServerVO)JSON.parseObject(server, ServerVO.class));
/* 176 */             } catch (Exception e) {
/* 177 */               e.printStackTrace();
/*     */             } 
/*     */           } 
/*     */         }
/* 181 */         Apps.put(Integer.valueOf(appId), app);
/*     */       } 
/*     */     } 
/* 184 */     return app;
/*     */   }
/*     */   
/*     */   public void addPacket(Packet packet) {
/* 188 */     PomeloPacket pak = (PomeloPacket)packet;
/* 189 */     PomeloHeader header = pak.getHeader();
/* 190 */     putGlobalRoute(header.route_s, packet);
/*     */   }
/*     */   
/*     */   public void registerHandler(NetHandler handler) {
/* 194 */     super.registerHandler(handler);
/*     */   }
/*     */   
/*     */   public boolean isWhiteList(String ip, String uid) {
/*     */     try {
/* 199 */       if (ip.startsWith("192.168.1.")) {
/* 200 */         return true;
/*     */       }
/* 202 */       String ltime = GCache.hget("/server/whitelist/ip", ip);
/* 203 */       if (StringUtil.isEmpty(ltime)) {
/* 204 */         ltime = GCache.hget("/server/whitelist/uid", uid);
/*     */       }
/* 206 */       if (StringUtil.isEmpty(ltime)) {
/* 207 */         return false;
/*     */       }
/* 209 */       long time = Long.parseLong(ltime);
/* 210 */       if (time > 0L && System.currentTimeMillis() > time) {
/* 211 */         return false;
/*     */       }
/*     */     }
/* 214 */     catch (Exception e) {
/* 215 */       Out.error(new Object[] { e });
/* 216 */       return false;
/*     */     } 
/* 218 */     return true;
/*     */   }
/*     */   
/*     */   public boolean isBlackList(String ip, String uid) {
/* 222 */     String ltime = GCache.hget("/server/blacklist/uid", uid);
/* 223 */     if (StringUtil.isEmpty(ltime)) {
/* 224 */       ltime = GCache.hget("/server/blacklist/ip", ip);
/*     */     }
/* 226 */     if (StringUtil.isNotEmpty(ltime)) {
/* 227 */       long time = Long.parseLong(ltime);
/* 228 */       if (time == 0L || System.currentTimeMillis() < time) {
/* 229 */         return true;
/*     */       }
/*     */     } 
/* 232 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isBlackIp(String ip) {
/* 236 */     String ltime = GCache.hget("/server/blacklist/ip", ip);
/* 237 */     if (StringUtil.isNotEmpty(ltime)) {
/* 238 */       long time = Long.parseLong(ltime);
/* 239 */       if (time == 0L || System.currentTimeMillis() < time) {
/* 240 */         return true;
/*     */       }
/*     */     } 
/* 243 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-login\xmds-login.jar!\com\wanniu\login\LoginServer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */