/*     */ package com.wanniu.login;
/*     */ 
/*     */ import com.alibaba.fastjson.JSON;
/*     */ import com.alibaba.fastjson.JSONObject;
/*     */ import com.wanniu.core.GConfig;
/*     */ import com.wanniu.core.GSystem;
/*     */ import com.wanniu.core.http.HttpServer;
/*     */ import com.wanniu.core.http.HttpServerMsgHandler;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.redis.GCache;
/*     */ import com.wanniu.login.announce.AnnounceMsgHandler;
/*     */ import redis.clients.jedis.Jedis;
/*     */ import redis.clients.jedis.JedisPubSub;
/*     */ 
/*     */ public class LoginMain
/*     */ {
/*     */   public static void main(String[] args) {
/*  18 */     server_main(args);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  23 */     startHttpServer();
/*     */   }
/*     */   
/*     */   public static void server_main(String[] args) {
/*  27 */     GConfig.getInstance().init();
/*  28 */     AnnounceServer.getInstance().init();
/*     */     
/*  30 */     (new Thread(new Runnable()
/*     */         {
/*     */           public void run() {
/*     */             while (true) {
/*  34 */               Jedis subscriberJedis = null;
/*     */               try {
/*  36 */                 subscriberJedis = GCache.getRedis();
/*  37 */                 subscriberJedis.subscribe(new JedisPubSub()
/*     */                     {
/*     */                       public void onMessage(String channel, String message) {
/*     */                         try {
/*  41 */                           JSONObject json = JSON.parseObject(message);
/*  42 */                           LoginServer.getInstance().distatcher(json);
/*  43 */                         } catch (Exception e) {
/*  44 */                           e.printStackTrace();
/*  45 */                           Out.error(new Object[] { String.format("Message. Channel: %s, Msg: %s", new Object[] { channel, message }) });
/*     */                         } 
/*     */                       }
/*     */ 
/*     */                       
/*     */                       public void onSubscribe(String channel, int subscribedChannels) {
/*  51 */                         Out.info(
/*  52 */                             new Object[] { Integer.valueOf(subscribedChannels), " subscribedChannels onSubscribe: ", channel });
/*     */                       }
/*     */                       
/*     */                       public void onUnsubscribe(String channel, int subscribedChannels) {
/*  56 */                         Out.warn(
/*  57 */                             new Object[] { Integer.valueOf(subscribedChannels), " subscribedChannels onUnsubscribe: ", channel });
/*     */                       }
/*  59 */                     }, new String[] { "/server/login" });
/*  60 */               } catch (Exception e) {
/*  61 */                 Out.error(new Object[] { "auth redis closed!!!", e.toString() });
/*  62 */                 if (subscriberJedis != null) {
/*  63 */                   GCache.release(subscriberJedis);
/*     */                 }
/*  65 */                 GSystem.waitMills(1000);
/*     */               } 
/*     */             } 
/*     */           }
/*  69 */         })).start();
/*     */     
/*  71 */     (new Thread(new Runnable()
/*     */         {
/*     */           public void run() {
/*     */             while (true) {
/*  75 */               Jedis subscriberJedis = null;
/*     */               try {
/*  77 */                 subscriberJedis = GCache.getRedis();
/*  78 */                 subscriberJedis.subscribe(new JedisPubSub()
/*     */                     {
/*     */                       public void onMessage(String channel, String message)
/*     */                       {
/*     */                         try {
/*  83 */                           AnnounceServer.getInstance().init();
/*  84 */                         } catch (Exception e) {
/*  85 */                           e.printStackTrace();
/*  86 */                           Out.error(new Object[] { String.format("Message. Channel: %s, Msg: %s", new Object[] { channel, message }) });
/*     */                         } 
/*     */                       }
/*     */ 
/*     */                       
/*     */                       public void onSubscribe(String channel, int subscribedChannels) {
/*  92 */                         Out.info(
/*  93 */                             new Object[] { Integer.valueOf(subscribedChannels), " subscribedChannels onSubscribe: ", channel });
/*     */                       }
/*     */                       
/*     */                       public void onUnsubscribe(String channel, int subscribedChannels) {
/*  97 */                         Out.warn(
/*  98 */                             new Object[] { Integer.valueOf(subscribedChannels), " subscribedChannels onUnsubscribe: ", channel });
/*     */                       }
/* 100 */                     }, new String[] { "/login/announce" });
/* 101 */               } catch (Exception e) {
/* 102 */                 Out.error(new Object[] { "auth redis closed!!!", e.toString() });
/* 103 */                 if (subscriberJedis != null) {
/* 104 */                   GCache.release(subscriberJedis);
/*     */                 }
/* 106 */                 GSystem.waitMills(1000);
/*     */               } 
/*     */             } 
/*     */           }
/* 110 */         })).start();
/* 111 */     LoginServer.getInstance().start();
/*     */   }
/*     */   
/*     */   public static void addArea(int areaId, String areaName) {
/* 115 */     GConfig.getInstance().init();
/* 116 */     JSONObject json = new JSONObject();
/* 117 */     json.put("type", Integer.valueOf(261));
/* 118 */     json.put("appId", Integer.valueOf(80));
/* 119 */     json.put("areaId", Integer.valueOf(areaId));
/* 120 */     json.put("areaName", areaName);
/* 121 */     GCache.publish(json);
/* 122 */     Out.info(new Object[] { "已执行！！！" });
/* 123 */     System.exit(1);
/*     */   }
/*     */   
/*     */   public static void removeArea(int areaId) {
/* 127 */     GConfig.getInstance().init();
/* 128 */     JSONObject json = new JSONObject();
/* 129 */     json.put("type", Integer.valueOf(262));
/* 130 */     json.put("appId", Integer.valueOf(80));
/* 131 */     json.put("areaId", Integer.valueOf(areaId));
/* 132 */     GCache.publish(json);
/* 133 */     Out.info(new Object[] { "已执行！！！" });
/* 134 */     System.exit(1);
/*     */   }
/*     */   
/*     */   public static void removeServer(int logicServerId) {
/* 138 */     GConfig.getInstance().init();
/* 139 */     JSONObject json = new JSONObject();
/* 140 */     json.put("type", Integer.valueOf(263));
/* 141 */     json.put("appId", Integer.valueOf(80));
/* 142 */     json.put("logicServerId", Integer.valueOf(logicServerId));
/* 143 */     GCache.publish(json);
/* 144 */     Out.info(new Object[] { "已执行！！！" });
/* 145 */     System.exit(1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void startHttpServer() {
/* 152 */     AnnounceMsgHandler handler = new AnnounceMsgHandler("/announce");
/* 153 */     final HttpServer httpServer = new HttpServer();
/* 154 */     httpServer.addHandler((HttpServerMsgHandler)handler);
/* 155 */     Thread t = new Thread("充值监听：待修改")
/*     */       {
/*     */         public void run() {
/*     */           try {
/* 159 */             httpServer.run(GConfig.getInstance().getInt("httpserver.port"));
/* 160 */           } catch (Exception e) {
/* 161 */             Out.error(new Object[] { e });
/*     */           } 
/*     */         }
/*     */       };
/* 165 */     t.start();
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-login\xmds-login.jar!\com\wanniu\login\LoginMain.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */