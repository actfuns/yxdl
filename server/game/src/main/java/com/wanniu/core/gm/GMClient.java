/*    */ package com.wanniu.core.gm;
/*    */ 
/*    */ import com.wanniu.core.GConfig;
/*    */ import com.wanniu.core.gm.connect.GMBootstrap;
/*    */ import com.wanniu.core.gm.connect.GMSessionHandler;
/*    */ import com.wanniu.core.gm.message.GMJoinMessage;
/*    */ import com.wanniu.core.gm.message.GMPingMessage;
/*    */ import com.wanniu.core.gm.request.GMHandler;
/*    */ import com.wanniu.core.tcp.client.ClientBootstrap;
/*    */ import com.wanniu.core.tcp.client.ClientCallback;
/*    */ import com.wanniu.core.tcp.client.ClientWorker;
/*    */ import com.wanniu.core.tcp.protocol.Message;
/*    */ import com.wanniu.core.tcp.protocol.NetHandler;
/*    */ import com.wanniu.core.tcp.protocol.Packet;
/*    */ import io.netty.channel.ChannelHandler;
/*    */ 
/*    */ public final class GMClient
/*    */   extends ClientWorker {
/* 19 */   private static GMClient instance = new GMClient();
/*    */   
/*    */   private GMDispatcher __dispacher__;
/*    */   
/*    */   public static GMClient getInstance() {
/* 24 */     return instance;
/*    */   }
/*    */   
/*    */   private GMClient() {
/* 28 */     this.__dispacher__ = new GMDispatcher();
/*    */   }
/*    */   
/*    */   public void start() {
/* 32 */     if (GConfig.getInstance().isEnableGm()) {
/* 33 */       this.serverHost = GConfig.getInstance().get("server.gm.host");
/* 34 */       this.serverPort = GConfig.getInstance().getInt("server.gm.port");
/* 35 */       this.bootstrap = (ClientBootstrap)new GMBootstrap((ChannelHandler)new GMSessionHandler((ClientCallback)this));
/*    */       
/* 37 */       super.start();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void ping() {
/* 43 */     add((Message)new GMPingMessage());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void registerHandler(GMHandler handler) {
/* 50 */     this.__dispacher__.registerHandler((NetHandler)handler);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void doStart() {
/* 56 */     add((Message)new GMJoinMessage());
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void handlePacket(Packet packet) {
/* 62 */     this.__dispacher__.execute(packet);
/*    */   }
/*    */   
/*    */   public void stop() {
/* 66 */     close(this.session);
/*    */   }
/*    */   
/*    */   public NetHandler getHandler(short type) {
/* 70 */     return this.__dispacher__.handlers.get(Short.valueOf(type));
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\core\gm\GMClient.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */