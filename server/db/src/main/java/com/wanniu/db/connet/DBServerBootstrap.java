/*    */ package com.wanniu.db.connet;
/*    */ 
/*    */ import com.wanniu.core.GConfig;
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.core.tcp.protocol.GDecoder;
/*    */ import com.wanniu.core.tcp.protocol.GEncoder;
/*    */ import io.netty.bootstrap.ServerBootstrap;
/*    */ import io.netty.channel.Channel;
/*    */ import io.netty.channel.ChannelHandler;
/*    */ import io.netty.channel.ChannelInitializer;
/*    */ import io.netty.channel.ChannelOption;
/*    */ import io.netty.channel.ChannelPipeline;
/*    */ import io.netty.channel.EventLoopGroup;
/*    */ import io.netty.channel.nio.NioEventLoopGroup;
/*    */ import io.netty.channel.socket.SocketChannel;
/*    */ import io.netty.channel.socket.nio.NioServerSocketChannel;
/*    */ import java.net.InetSocketAddress;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DBServerBootstrap
/*    */ {
/*    */   private static DBServerBootstrap instance;
/*    */   private ServerBootstrap serverBootstrap;
/*    */   private EventLoopGroup bossGroup;
/*    */   private EventLoopGroup workerGroup;
/*    */   
/*    */   public static DBServerBootstrap getInstance() {
/* 35 */     if (instance == null) {
/* 36 */       instance = new DBServerBootstrap();
/*    */     }
/* 38 */     return instance;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void start() {
/*    */     try {
/* 46 */       this.bossGroup = (EventLoopGroup)new NioEventLoopGroup();
/* 47 */       this.workerGroup = (EventLoopGroup)new NioEventLoopGroup();
/* 48 */       this.serverBootstrap = new ServerBootstrap();
/*    */       
/* 50 */       this.serverBootstrap.group(this.bossGroup, this.workerGroup);
/* 51 */       this.serverBootstrap.channel(NioServerSocketChannel.class);
/*    */       
/* 53 */       this.serverBootstrap.childHandler((ChannelHandler)new ChannelInitializer<SocketChannel>()
/*    */           {
/*    */             protected void initChannel(SocketChannel ch) throws Exception {
/* 56 */               ChannelPipeline pipeline = ch.pipeline();
/*    */               
/* 58 */               pipeline.addLast("encoder", (ChannelHandler)new GEncoder());
/* 59 */               pipeline.addLast("decoder", (ChannelHandler)new GDecoder());
/* 60 */               pipeline.addLast("handler", (ChannelHandler)new DBServerHandler());
/*    */             }
/*    */           });
/*    */       
/* 64 */       ((ServerBootstrap)((ServerBootstrap)this.serverBootstrap.option(ChannelOption.SO_LINGER, Integer.valueOf(0)))
/*    */         
/* 66 */         .option(ChannelOption.SO_REUSEADDR, Boolean.valueOf(true)))
/* 67 */         .childOption(ChannelOption.TCP_NODELAY, Boolean.valueOf(true))
/* 68 */         .childOption(ChannelOption.SO_KEEPALIVE, Boolean.valueOf(true));
/*    */       
/* 70 */       String ip = GConfig.getInstance().getDBHost();
/* 71 */       int port = GConfig.getInstance().getDBPort();
/* 72 */       InetSocketAddress socketAddress = (ip != null && ip.length() > 6) ? new InetSocketAddress(ip, port) : new InetSocketAddress(port);
/* 73 */       this.serverBootstrap.bind(socketAddress).sync();
/*    */       
/* 75 */       Out.info(new Object[] { "服务绑定于 -> " + socketAddress });
/* 76 */     } catch (Exception e) {
/* 77 */       e.printStackTrace();
/* 78 */       shutDown();
/* 79 */       Out.error(new Object[] { e });
/*    */       try {
/* 81 */         Thread.sleep(1000L);
/* 82 */       } catch (InterruptedException e1) {
/* 83 */         Out.error(new Object[] { e1 });
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void shutDown() {
/* 92 */     if (this.bossGroup != null) {
/* 93 */       this.bossGroup.shutdownGracefully();
/*    */     }
/* 95 */     if (this.workerGroup != null)
/* 96 */       this.workerGroup.shutdownGracefully(); 
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-db\xmds-db.jar!\com\wanniu\db\connet\DBServerBootstrap.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */