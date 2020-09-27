/*     */ package com.wanniu.core.game;
/*     */ 
/*     */ import com.wanniu.core.GConfig;
/*     */ import com.wanniu.core.game.protocol.PomeloDecoder;
/*     */ import com.wanniu.core.game.protocol.PomeloEncoder;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import io.netty.bootstrap.ServerBootstrap;
/*     */ import io.netty.channel.Channel;
/*     */ import io.netty.channel.ChannelHandler;
/*     */ import io.netty.channel.ChannelHandlerContext;
/*     */ import io.netty.channel.ChannelInitializer;
/*     */ import io.netty.channel.ChannelOption;
/*     */ import io.netty.channel.ChannelPipeline;
/*     */ import io.netty.channel.EventLoopGroup;
/*     */ import io.netty.channel.nio.NioEventLoopGroup;
/*     */ import io.netty.channel.socket.SocketChannel;
/*     */ import io.netty.channel.socket.nio.NioServerSocketChannel;
/*     */ import io.netty.handler.timeout.IdleStateEvent;
/*     */ import io.netty.handler.timeout.IdleStateHandler;
/*     */ import java.net.InetSocketAddress;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class GServerBootstrap
/*     */ {
/*     */   private static GServerBootstrap instance;
/*     */   private ServerBootstrap serverBootstrap;
/*     */   private EventLoopGroup bossGroup;
/*     */   private EventLoopGroup workerGroup;
/*     */   
/*     */   public static GServerBootstrap getInstance() {
/*  38 */     if (instance == null) {
/*  39 */       instance = new GServerBootstrap();
/*     */     }
/*  41 */     return instance;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void start() {
/*     */     try {
/*  49 */       this.bossGroup = (EventLoopGroup)new NioEventLoopGroup();
/*  50 */       this.workerGroup = (EventLoopGroup)new NioEventLoopGroup();
/*  51 */       this.serverBootstrap = new ServerBootstrap();
/*     */       
/*  53 */       this.serverBootstrap.group(this.bossGroup, this.workerGroup);
/*  54 */       this.serverBootstrap.channel(NioServerSocketChannel.class);
/*     */       
/*  56 */       this.serverBootstrap.childHandler((ChannelHandler)new ChannelInitializer<SocketChannel>()
/*     */           {
/*     */             protected void initChannel(SocketChannel ch) throws Exception {
/*  59 */               ChannelPipeline pipeline = ch.pipeline();
/*  60 */               pipeline.addLast("idleHandler", (ChannelHandler)new IdleStateHandler(60, 0, 0)
/*     */                   {
/*     */                     protected void channelIdle(ChannelHandlerContext ctx, IdleStateEvent evt) throws Exception
/*     */                     {
/*  64 */                       Out.debug(
/*     */                           
/*  66 */                           new Object[] { ctx.channel(), " idle..." });
/*     */                       ctx.close(); }
/*     */                   });
/*  69 */               pipeline.addLast("decoder", (ChannelHandler)new PomeloDecoder());
/*  70 */               pipeline.addLast("encoder", (ChannelHandler)new PomeloEncoder());
/*  71 */               pipeline.addLast("handler", (ChannelHandler)new ServerSessionHandler());
/*     */             }
/*     */           });
/*     */ 
/*     */       
/*  76 */       ((ServerBootstrap)((ServerBootstrap)this.serverBootstrap.option(ChannelOption.SO_LINGER, Integer.valueOf(0)))
/*     */         
/*  78 */         .option(ChannelOption.SO_REUSEADDR, Boolean.valueOf(true)))
/*  79 */         .childOption(ChannelOption.TCP_NODELAY, Boolean.valueOf(true))
/*  80 */         .childOption(ChannelOption.SO_KEEPALIVE, Boolean.valueOf(true));
/*     */       
/*  82 */       String ip = GConfig.getInstance().getLoginHost();
/*  83 */       int port = GConfig.getInstance().getLoginPort();
/*  84 */       InetSocketAddress socketAddress = (ip != null && ip.length() > 6) ? new InetSocketAddress(ip, port) : new InetSocketAddress(port);
/*  85 */       this.serverBootstrap.bind(socketAddress).sync();
/*     */       
/*  87 */       Out.info(new Object[] { "服务绑定于 -> " + socketAddress });
/*  88 */     } catch (Exception e) {
/*  89 */       shutDown();
/*  90 */       Out.error(new Object[] { e });
/*     */       try {
/*  92 */         Thread.sleep(1000L);
/*  93 */       } catch (InterruptedException interruptedException) {}
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void shutDown() {
/* 102 */     if (this.bossGroup != null) {
/* 103 */       this.bossGroup.shutdownGracefully();
/*     */     }
/* 105 */     if (this.workerGroup != null)
/* 106 */       this.workerGroup.shutdownGracefully(); 
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-login\xmds-login.jar!\com\wanniu\core\game\GServerBootstrap.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */