/*    */ package com.wanniu.core.tcp.protocol;
/*    */ 
/*    */ import io.netty.channel.Channel;
/*    */ import io.netty.channel.ChannelHandler;
/*    */ import io.netty.channel.ChannelInitializer;
/*    */ import io.netty.channel.ChannelPipeline;
/*    */ import io.netty.channel.socket.SocketChannel;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class GCodecFactory
/*    */   extends ChannelInitializer<SocketChannel>
/*    */ {
/*    */   private ChannelHandler handler;
/*    */   
/*    */   public GCodecFactory(ChannelHandler handler) {
/* 18 */     this.handler = handler;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void initChannel(SocketChannel ch) throws Exception {
/* 23 */     ChannelPipeline pipeline = ch.pipeline();
/*    */     
/* 25 */     pipeline.addLast("decoder", (ChannelHandler)new GDecoder());
/* 26 */     pipeline.addLast("encoder", (ChannelHandler)new GEncoder());
/* 27 */     pipeline.addLast("handler", this.handler);
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\core\tcp\protocol\GCodecFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */