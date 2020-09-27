/*    */ package com.wanniu.core.game;
/*    */ 
/*    */ import com.wanniu.core.GGame;
/*    */ import com.wanniu.core.GGlobal;
/*    */ import com.wanniu.core.game.entity.GPlayer;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class ServerSessionHandler
/*    */   extends ChannelInboundHandlerAdapter
/*    */ {
/*    */   public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
/* 26 */     Out.info(new Object[] { "连接被建立，Session:", ctx.channel().remoteAddress() });
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
/* 32 */     if (cause instanceof java.io.IOException || cause instanceof io.netty.handler.codec.DecoderException) {
/* 33 */       Out.debug(new Object[] { "Netty try IOException||DecoderException.", ctx.channel().remoteAddress(), cause.getMessage() });
/*    */     } else {
/* 35 */       Out.error(new Object[] { "Netty try exception.", ctx.channel().remoteAddress(), cause });
/*    */     } 
/* 37 */     ctx.close();
/*    */   }
/*    */ 
/*    */   
/*    */   public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
/* 42 */     Channel session = ctx.channel();
/* 43 */     Out.info(new Object[] { "连接被关闭:", session.remoteAddress() });
/*    */     try {
/* 45 */       if (session.attr(GGlobal.__KEY_PLAYER) != null) {
/* 46 */         GPlayer player = (GPlayer)session.attr(GGlobal.__KEY_PLAYER).get();
/* 47 */         if (player != null && player.getSession() == session) {
/* 48 */           player.doLogout(false);
/*    */         }
/*    */       } 
/*    */     } finally {
/* 52 */       GGame.getInstance().onSessionClose(session);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void channelRead(ChannelHandlerContext ctx, Object packet) throws Exception {
/* 58 */     GGame.getInstance().addPacket((Packet)packet);
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\core\game\ServerSessionHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */