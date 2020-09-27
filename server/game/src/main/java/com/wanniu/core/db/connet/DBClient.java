/*     */ package com.wanniu.core.db.connet;
/*     */ 
/*     */ import com.alibaba.fastjson.JSONObject;
/*     */ import com.wanniu.core.GConfig;
/*     */ import com.wanniu.core.GGlobal;
/*     */ import com.wanniu.core.GSystem;
/*     */ import com.wanniu.core.db.DBType;
/*     */ import com.wanniu.core.db.QueryVo;
/*     */ import com.wanniu.core.db.message.DBJoinMessage;
/*     */ import com.wanniu.core.db.message.DBPingMessage;
/*     */ import com.wanniu.core.db.message.DBQueryMessage;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.tcp.client.ClientCallback;
/*     */ import com.wanniu.core.tcp.client.ClientWorker;
/*     */ import com.wanniu.core.tcp.protocol.Message;
/*     */ import com.wanniu.core.tcp.protocol.Packet;
/*     */ import com.wanniu.core.tcp.protocol.Prefix;
/*     */ import com.wanniu.core.tcp.protocol.RequestMessage;
/*     */ import io.netty.channel.ChannelHandler;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ public class DBClient
/*     */   extends ClientWorker
/*     */ {
/*  28 */   private static DBClient instance = new DBClient();
/*     */   
/*     */   public static DBClient getInstance() {
/*  31 */     return instance;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEnable() {
/*  38 */     return GConfig.getInstance().isEnableDB();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void start() {
/*  46 */     if (isEnable()) {
/*  47 */       this.serverHost = GConfig.getInstance().get("server.db.host");
/*  48 */       this.serverPort = GConfig.getInstance().getInt("server.db.port");
/*  49 */       this.bootstrap = new DBClientBootstrap((ChannelHandler)new DBClientHandler((ClientCallback)this));
/*  50 */       super.start();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void add(Message message) {
/*  56 */     if (!isEnable()) {
/*     */       return;
/*     */     }
/*  59 */     super.add(message);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void doStart() {
/*  65 */     Out.info(new Object[] { "开始重新注册DB服务..." });
/*  66 */     Packet pc = this.bootstrap.request((RequestMessage)new DBJoinMessage());
/*  67 */     if (pc == null) {
/*  68 */       if (this.session == null) {
/*     */         return;
/*     */       }
/*     */     } else {
/*  72 */       int status = pc.getInt();
/*  73 */       if (status == 200) {
/*  74 */         registed();
/*     */         return;
/*     */       } 
/*     */     } 
/*  78 */     Out.info(new Object[] { String.format("无法注册DB服 -> %s:%d", new Object[] { this.serverHost, Integer.valueOf(this.serverPort) }) });
/*  79 */     GSystem.waitMills(5000);
/*  80 */     doStart();
/*     */   }
/*     */   
/*     */   public void registed() {
/*  84 */     Out.info(new Object[] { "成功注册到DB服务，开始等待信息发送..." });
/*     */   }
/*     */ 
/*     */   
/*     */   public void handlePacket(Packet pak) {
/*  89 */     long reqId = pak.getLong();
/*  90 */     response(reqId, pak);
/*     */   }
/*     */ 
/*     */   
/*     */   public void ping() {
/*  95 */     add((Message)new DBPingMessage());
/*     */   }
/*     */   
/*     */   public <T> T get(QueryVo vo, Class<T> cl) {
/*  99 */     List<T> ts = query(vo, cl);
/* 100 */     if (ts != null && !ts.isEmpty()) {
/* 101 */       return ts.get(0);
/*     */     }
/* 103 */     return null;
/*     */   }
/*     */   
/*     */   public <T> List<T> query(QueryVo vo, Class<T> cl) {
/* 107 */     if (!isEnable()) {
/* 108 */       return new ArrayList<>();
/*     */     }
/* 110 */     DBQueryMessage dbQuery = new DBQueryMessage(vo);
/* 111 */     Packet response = request((RequestMessage)dbQuery);
/* 112 */     List<T> result = new ArrayList<>();
/* 113 */     if (response != null) {
/* 114 */       byte[] buf = response.getBytes(Prefix.INT);
/* 115 */       if (buf != null) {
/* 116 */         String res = new String(buf, GGlobal.UTF_8);
/* 117 */         result = JSONObject.parseArray(res, cl);
/*     */       } 
/*     */     } 
/* 120 */     return result;
/*     */   }
/*     */   
/*     */   public void onPlayerleave(final String playerId) {
/* 124 */     if (isEnable())
/* 125 */       getInstance().add(new Message()
/*     */           {
/*     */             protected void write() throws IOException {
/* 128 */               this.body.writeString(playerId);
/*     */             }
/*     */ 
/*     */             
/*     */             public short getType() {
/* 133 */               return DBType.NOTIFY;
/*     */             }
/*     */           }); 
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\core\db\connet\DBClient.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */