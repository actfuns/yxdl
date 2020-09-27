/*    */ package com.wanniu.core.game;
/*    */ 
/*    */ import com.wanniu.core.GServer;
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.core.tcp.protocol.Packet;
/*    */ import io.netty.channel.Channel;
/*    */ import io.netty.channel.ChannelHandlerContext;
/*    */ import io.netty.channel.ChannelInboundHandlerAdapter;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class ServerSessionHandler
/*    */   extends ChannelInboundHandlerAdapter
/*    */ {
/*    */   public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
/* 19 */     Out.debug(
/* 20 */         new Object[] { "连接被建立，Session:" + ctx.channel().remoteAddress().toString() });
/*    */   }
/*    */ 
/*    */   
/*    */   public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
/* 25 */     Out.debug(
/*    */ 
/*    */ 
/*    */ 
/*    */         
/* 30 */         new Object[] { "exceptionCaught" });
/*    */     Channel session = ctx.channel();
/*    */     Out.warn(new Object[] { session.remoteAddress() + "未验证时发生的异常" });
/*    */     ctx.close(); } public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
/* 34 */     Channel session = ctx.channel();
/* 35 */     GServer.getInstance().onSessionClose(session);
/*    */   }
/*    */ 
/*    */   
/*    */   public void channelRead(ChannelHandlerContext ctx, Object packet) throws Exception {
/* 40 */     GServer.getInstance().addPacket((Packet)packet);
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-login\xmds-login.jar!\com\wanniu\core\game\ServerSessionHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */