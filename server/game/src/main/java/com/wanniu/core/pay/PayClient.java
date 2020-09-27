/*    */ package com.wanniu.core.pay;
/*    */ 
/*    */ import com.wanniu.core.GConfig;
/*    */ import com.wanniu.core.pay.connect.PayBootstrap;
/*    */ import com.wanniu.core.pay.connect.PaySessionHandler;
/*    */ import com.wanniu.core.pay.message.PayJoinMessage;
/*    */ import com.wanniu.core.pay.message.PayPingMessage;
/*    */ import com.wanniu.core.pay.request.PayHandler;
/*    */ import com.wanniu.core.tcp.client.ClientBootstrap;
/*    */ import com.wanniu.core.tcp.client.ClientCallback;
/*    */ import com.wanniu.core.tcp.client.ClientWorker;
/*    */ import com.wanniu.core.tcp.protocol.Message;
/*    */ import com.wanniu.core.tcp.protocol.NetHandler;
/*    */ import com.wanniu.core.tcp.protocol.Packet;
/*    */ import io.netty.channel.ChannelHandler;
/*    */ 
/*    */ public final class PayClient
/*    */   extends ClientWorker
/*    */ {
/* 20 */   private static PayClient instance = new PayClient();
/*    */   
/*    */   private PayDispatcher __dispacher__;
/*    */   
/*    */   public static PayClient getInstance() {
/* 25 */     return instance;
/*    */   }
/*    */   
/*    */   private PayClient() {
/* 29 */     this.__dispacher__ = new PayDispatcher();
/*    */   }
/*    */ 
/*    */   
/*    */   public void ping() {
/* 34 */     add((Message)new PayPingMessage());
/*    */   }
/*    */   
/*    */   public void start() {
/* 38 */     if (GConfig.getInstance().isEnablePay()) {
/* 39 */       this.serverHost = GConfig.getInstance().get("server.pay.host");
/* 40 */       this.serverPort = GConfig.getInstance().getInt("server.pay.port");
/* 41 */       this.bootstrap = (ClientBootstrap)new PayBootstrap((ChannelHandler)new PaySessionHandler((ClientCallback)this));
/* 42 */       (new Thread(this.__dispacher__, String.format("GM<-%s:%d", new Object[] { this.serverHost, Integer.valueOf(this.serverPort) }))).start();
/* 43 */       super.start();
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void registerHandler(PayHandler handler) {
/* 51 */     this.__dispacher__.registerHandler((NetHandler)handler);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void doStart() {
/* 57 */     add((Message)new PayJoinMessage());
/*    */   }
/*    */ 
/*    */   
/*    */   public void handlePacket(Packet packet) {
/* 62 */     this.__dispacher__.add(packet);
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


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\core\pay\PayClient.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */