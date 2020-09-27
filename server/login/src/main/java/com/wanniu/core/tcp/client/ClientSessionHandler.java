/*    */ package com.wanniu.core.tcp.client;
/*    */ 
/*    */ import com.wanniu.core.tcp.protocol.Packet;
/*    */ import io.netty.channel.ChannelHandlerContext;
/*    */ import io.netty.channel.ChannelInboundHandlerAdapter;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ClientSessionHandler
/*    */   extends ChannelInboundHandlerAdapter
/*    */ {
/*    */   private final ClientCallback callback;
/*    */   
/*    */   public ClientSessionHandler(ClientCallback callback) {
/* 17 */     this.callback = callback;
/*    */   }
/*    */ 
/*    */   
/*    */   public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
/* 22 */     super.channelRegistered(ctx);
/*    */   }
/*    */ 
/*    */   
/*    */   public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
/* 27 */     super.channelUnregistered(ctx);
/*    */   }
/*    */ 
/*    */   
/*    */   public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
/* 32 */     this.callback.close();
/* 33 */     super.exceptionCaught(ctx, cause);
/*    */   }
/*    */ 
/*    */   
/*    */   public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
/* 38 */     this.callback.handlePacket((Packet)msg);
/*    */   }
/*    */ 
/*    */   
/*    */   public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
/* 43 */     super.channelReadComplete(ctx);
/*    */   }
/*    */ 
/*    */   
/*    */   public void channelActive(ChannelHandlerContext ctx) throws Exception {
/* 48 */     super.channelActive(ctx);
/*    */   }
/*    */ 
/*    */   
/*    */   public void channelInactive(ChannelHandlerContext ctx) throws Exception {
/* 53 */     super.channelInactive(ctx);
/*    */   }
/*    */ 
/*    */   
/*    */   public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
/* 58 */     super.userEventTriggered(ctx, evt);
/*    */   }
/*    */ 
/*    */   
/*    */   public void channelWritabilityChanged(ChannelHandlerContext ctx) throws Exception {
/* 63 */     super.channelWritabilityChanged(ctx);
/*    */   }
/*    */ 
/*    */   
/*    */   public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
/* 68 */     super.handlerAdded(ctx);
/* 69 */     this.callback.bind(ctx.channel());
/*    */   }
/*    */ 
/*    */   
/*    */   public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
/* 74 */     super.handlerRemoved(ctx);
/* 75 */     this.callback.close();
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-login\xmds-login.jar!\com\wanniu\core\tcp\client\ClientSessionHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */