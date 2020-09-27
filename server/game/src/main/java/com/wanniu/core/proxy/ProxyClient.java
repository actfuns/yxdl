/*     */ package com.wanniu.core.proxy;
/*     */ 
/*     */ import com.alibaba.fastjson.JSON;
/*     */ import com.alibaba.fastjson.JSONObject;
/*     */ import com.wanniu.core.GConfig;
/*     */ import com.wanniu.core.GGame;
/*     */ import com.wanniu.core.game.entity.GPlayer;
/*     */ import com.wanniu.core.proxy.message.ProxyJoinMessage;
/*     */ import com.wanniu.core.proxy.message.ProxyPingMessage;
/*     */ import com.wanniu.core.tcp.client.ClientCallback;
/*     */ import com.wanniu.core.tcp.client.ClientWorker;
/*     */ import com.wanniu.core.tcp.protocol.Message;
/*     */ import com.wanniu.core.tcp.protocol.Packet;
/*     */ import com.wanniu.core.tcp.protocol.Prefix;
/*     */ import com.wanniu.core.tcp.protocol.RequestMessage;
/*     */ import io.netty.buffer.ByteBuf;
/*     */ import io.netty.buffer.Unpooled;
/*     */ import io.netty.channel.ChannelHandler;
/*     */ import java.io.IOException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class ProxyClient
/*     */   extends ClientWorker
/*     */ {
/*  28 */   private static ProxyClient instance = new ProxyClient();
/*     */   
/*     */   public static ProxyClient getInstance() {
/*  31 */     return instance;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void start() {
/*  38 */     if (GConfig.getInstance().isEnableProxy()) {
/*  39 */       this.serverHost = GConfig.getInstance().get("server.proxy.host");
/*  40 */       this.serverPort = GConfig.getInstance().getInt("server.proxy.port");
/*  41 */       this.bootstrap = new ProxyBootstrap((ChannelHandler)new ProxySessionHandler((ClientCallback)this));
/*  42 */       super.start();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void ping() {
/*  48 */     add((Message)new ProxyPingMessage());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void doStart() {
/*  54 */     send((Message)new ProxyJoinMessage());
/*     */   }
/*     */   
/*     */   public JSONObject request(final ProxyType.ProxyMethod type, final JSONObject json) {
/*  58 */     Packet pak = request(new RequestMessage()
/*     */         {
/*     */           protected void write() throws IOException {
/*  61 */             this.body.writeLong(this.reqId);
/*  62 */             this.body.writeShort(type.value);
/*  63 */             this.body.writeString(json.toJSONString());
/*     */           }
/*     */ 
/*     */           
/*     */           public short getType() {
/*  68 */             return 257;
/*     */           }
/*     */         });
/*     */     
/*  72 */     return JSON.parseObject(pak.getString());
/*     */   }
/*     */   
/*     */   public Packet query(final int sid, final JSONObject json) {
/*  76 */     Packet pak = request(new RequestMessage()
/*     */         {
/*     */           protected void write() throws IOException {
/*  79 */             this.body.writeLong(this.reqId);
/*  80 */             this.body.writeInt(sid);
/*  81 */             this.body.writeString(json.toJSONString());
/*     */           }
/*     */           
/*     */           public short getType() {
/*  85 */             return 513;
/*     */           }
/*     */         });
/*     */     
/*  89 */     return pak;
/*     */   }
/*     */ 
/*     */   
/*     */   public void handlePacket(final Packet pak) {
/*  94 */     if (pak.getPacketType() == 257 || pak.getPacketType() == 770) {
/*  95 */       long reqId = pak.getLong();
/*  96 */       response(reqId, pak);
/*  97 */     } else if (pak.getPacketType() == 498) {
/*  98 */       GGame.getInstance().closeArea(pak.getString());
/*  99 */     } else if (pak.getPacketType() == 499) {
/* 100 */       GGame.getInstance().onPlayerDie(pak.getString(), pak.getString(), pak.getString());
/* 101 */     } else if (pak.getPacketType() == 497) {
/* 102 */       ByteBuf buf = Unpooled.wrappedBuffer(pak.getBytes(Prefix.INT));
/* 103 */       int count = pak.getShort();
/* 104 */       for (int i = 0; i < count; i++) {
/* 105 */         GPlayer player = GGame.getInstance().getPlayer(pak.getString());
/* 106 */         if (player != null && player.getSession() != null) {
/* 107 */           player.getSession().writeAndFlush(buf.slice());
/*     */         }
/*     */       } 
/*     */     } else {
/* 111 */       GGame.getInstance().ansycExec(new Runnable()
/*     */           {
/*     */             public void run() {
/* 114 */               GGame.getInstance().onAcrossReceive(pak);
/*     */             }
/*     */           });
/*     */     } 
/*     */   }
/*     */   
/*     */   public void stop() {
/* 121 */     close(this.session);
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\core\proxy\ProxyClient.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */