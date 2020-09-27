/*    */ package com.wanniu.core.tcp.client;
/*    */ 
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import io.netty.bootstrap.Bootstrap;
/*    */ import io.netty.channel.Channel;
/*    */ import io.netty.channel.ChannelFuture;
/*    */ import io.netty.channel.ChannelHandler;
/*    */ import io.netty.channel.ChannelInitializer;
/*    */ import io.netty.channel.ChannelOption;
/*    */ import io.netty.channel.EventLoopGroup;
/*    */ import io.netty.channel.nio.NioEventLoopGroup;
/*    */ import io.netty.channel.socket.SocketChannel;
/*    */ import io.netty.channel.socket.nio.NioSocketChannel;
/*    */ import java.net.InetSocketAddress;
/*    */ import java.util.concurrent.TimeUnit;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ClientBootstrap
/*    */ {
/*    */   private Bootstrap boots;
/*    */   protected Channel session;
/*    */   
/*    */   public ClientBootstrap(ChannelInitializer<SocketChannel> factory) {
/* 27 */     this.boots = new Bootstrap();
/* 28 */     this.boots.channel(NioSocketChannel.class);
/* 29 */     this.boots.option(ChannelOption.TCP_NODELAY, Boolean.valueOf(true));
/* 30 */     this.boots.option(ChannelOption.SO_KEEPALIVE, Boolean.valueOf(true));
/* 31 */     this.boots.handler((ChannelHandler)factory);
/* 32 */     this.boots.group((EventLoopGroup)new NioEventLoopGroup(2));
/*    */   }
/*    */   
/*    */   public Channel connect(String host, int port) {
/*    */     try {
/* 37 */       ChannelFuture future = this.boots.connect(new InetSocketAddress(host, port));
/* 38 */       future.awaitUninterruptibly(10L, TimeUnit.SECONDS);
/*    */       
/* 40 */       if (!future.isSuccess()) {
/* 41 */         future.cause().printStackTrace();
/* 42 */         return null;
/*    */       } 
/* 44 */       this.session = future.channel();
/* 45 */       return future.channel();
/* 46 */     } catch (Exception e) {
/* 47 */       Out.error(new Object[] { e });
/* 48 */       return null;
/*    */     } 
/*    */   }
/*    */   
/*    */   public void quit(Channel session) {
/* 53 */     if (session != null)
/* 54 */       session.close(); 
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-login\xmds-login.jar!\com\wanniu\core\tcp\client\ClientBootstrap.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */