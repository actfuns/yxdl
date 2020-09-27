/*    */ package com.wanniu.csharp.protocol;
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
/*    */ public class CSharpCodecFactory
/*    */   extends ChannelInitializer<SocketChannel>
/*    */ {
/*    */   private ChannelHandler handler;
/*    */   
/*    */   public CSharpCodecFactory(ChannelHandler handler) {
/* 18 */     this.handler = handler;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void initChannel(SocketChannel ch) throws Exception {
/* 23 */     ChannelPipeline pipeline = ch.pipeline();
/* 24 */     pipeline.addLast("decoder", (ChannelHandler)new CSharpDecoder());
/* 25 */     pipeline.addLast("encoder", (ChannelHandler)new CSharpEncoder());
/* 26 */     pipeline.addLast("handler", this.handler);
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\csharp\protocol\CSharpCodecFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */