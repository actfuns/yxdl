/*     */ package com.wanniu.login.vo;
/*     */ 
/*     */ import com.alibaba.fastjson.JSONArray;
/*     */ import com.wanniu.core.GGlobal;
/*     */ import com.wanniu.core.game.protocol.PomeloPush;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.login.LoginServer;
/*     */ import com.wanniu.login.proto.LoginHandler;
/*     */ import io.netty.channel.Channel;
/*     */ import java.io.IOException;
/*     */ import java.util.Collection;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ServerVO
/*     */ {
/*     */   public int appId;
/*     */   public int areaId;
/*     */   public int logicServerId;
/*     */   public String name;
/*     */   public String host;
/*     */   public int port;
/*  23 */   public int show = ServerShow.OUTER.value;
/*  24 */   public int load = ServerLoad.SMOOTH.value;
/*     */   
/*     */   public boolean isNew;
/*     */   public boolean isHot;
/*     */   public boolean isRecommend;
/*     */   public int olCount;
/*  30 */   public int olLimit = 1000;
/*     */   
/*     */   public String extObj;
/*     */   
/*     */   public long pingtime;
/*     */   
/*     */   public JSONArray toShowJSON() {
/*  37 */     JSONArray arr = new JSONArray();
/*  38 */     arr.add(Integer.valueOf(this.logicServerId));
/*  39 */     arr.add(this.name);
/*  40 */     arr.add(this.host);
/*  41 */     arr.add(Integer.valueOf(this.port));
/*  42 */     arr.add(Integer.valueOf(this.load));
/*  43 */     arr.add(Integer.valueOf(this.isNew ? 1 : 0));
/*  44 */     arr.add(Integer.valueOf(this.isHot ? 1 : 0));
/*  45 */     arr.add(Integer.valueOf(this.isRecommend ? 1 : 0));
/*  46 */     arr.add(this.extObj);
/*  47 */     return arr;
/*     */   }
/*     */   
/*     */   public void setLoad(int load) {
/*  51 */     if (this.load != load) {
/*  52 */       this.load = load;
/*  53 */       syncClientState();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setOlCount(int onlineCount) {
/*  58 */     if (onlineCount < 0) {
/*  59 */       this.olCount = 0;
/*  60 */       setLoad(ServerLoad.MAINTAIN.value);
/*  61 */       Out.info(new Object[] { this.name, "维护了。。。" });
/*     */     } else {
/*  63 */       int load = ServerLoad.SMOOTH.value;
/*  64 */       this.olCount = onlineCount;
/*  65 */       if (onlineCount >= this.olLimit / 2) {
/*  66 */         load = ServerLoad.FULL.value;
/*  67 */       } else if (onlineCount > this.olLimit / 3) {
/*  68 */         load = ServerLoad.FULL.value;
/*  69 */       } else if (onlineCount > this.olLimit / 8) {
/*  70 */         load = ServerLoad.BUSY.value;
/*     */       } 
/*  72 */       if (this.load == ServerLoad.MAINTAIN.value) {
/*  73 */         Out.info(new Object[] { this.name, "连接了。。。" });
/*     */       }
/*  75 */       setLoad(load);
/*  76 */       this.pingtime = System.currentTimeMillis();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setShow(int show) {
/*  81 */     if (show != this.show) {
/*  82 */       this.show = show;
/*  83 */       syncClientState();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void syncClientState() {
/*  88 */     Collection<Channel> channels = LoginServer.getInstance().getLoginSessions().values();
/*  89 */     for (Channel channel : channels) {
/*  90 */       channel.writeAndFlush(new PomeloPush()
/*     */           {
/*     */             protected void write() throws IOException {
/*  93 */               LoginHandler.ServerStatePush.Builder push = LoginHandler.ServerStatePush.newBuilder();
/*  94 */               String ip = channel.remoteAddress().toString();
/*  95 */               ip = ip.substring(1, ip.indexOf(":"));
/*  96 */               String uid = (String)channel.attr(GGlobal._KEY_USER_ID).get();
/*  97 */               push.setSid(ServerVO.this.logicServerId);
/*  98 */               if (ServerVO.this.show == ServerShow.OUTER.value || (ServerVO.this.show == ServerShow.INNER.value && LoginServer.getInstance().isWhiteList(ip, uid))) {
/*  99 */                 push.setState(ServerVO.this.load);
/*     */               } else {
/* 101 */                 push.setState(ServerLoad.MAINTAIN.value);
/*     */               } 
/* 103 */               this.body.writeBytes(push.build().toByteArray());
/*     */             }
/*     */ 
/*     */             
/*     */             public String getRoute() {
/* 108 */               return "login.loginPush.serverStatePush";
/*     */             }
/*     */           });
/*     */     } 
/*     */   }
/*     */   
/*     */   public String toString() {
/* 115 */     return String.valueOf(this.appId) + " : " + this.logicServerId + " - " + this.name + " ->　" + this.host + ":" + this.port;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-login\xmds-login.jar!\com\wanniu\login\vo\ServerVO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */