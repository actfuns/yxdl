/*    */ package com.wanniu.csharp;
/*    */ 
/*    */ import com.wanniu.core.tcp.client.ClientBootstrap;
/*    */ import com.wanniu.csharp.protocol.CSharpCodecFactory;
/*    */ import io.netty.channel.ChannelHandler;
/*    */ import io.netty.channel.ChannelInitializer;
/*    */ import io.netty.channel.EventLoopGroup;
/*    */ import io.netty.channel.nio.NioEventLoopGroup;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CSharpBootstrap
/*    */   extends ClientBootstrap
/*    */ {
/*    */   public CSharpBootstrap(ChannelHandler handler) {
/* 16 */     super((ChannelInitializer)new CSharpCodecFactory(handler), (EventLoopGroup)new NioEventLoopGroup());
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\csharp\CSharpBootstrap.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */