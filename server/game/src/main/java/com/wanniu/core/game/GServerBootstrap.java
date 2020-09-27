/*     */ package com.wanniu.core.game;
/*     */ 
/*     */ import com.wanniu.core.GConfig;
/*     */ import com.wanniu.core.GGlobal;
/*     */ import com.wanniu.core.game.protocol.PomeloDecoder;
/*     */ import com.wanniu.core.game.protocol.PomeloEncoder;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.tcp.GBootstrap;
/*     */ import io.netty.bootstrap.ServerBootstrap;
/*     */ import io.netty.channel.Channel;
/*     */ import io.netty.channel.ChannelHandler;
/*     */ import io.netty.channel.ChannelHandlerContext;
/*     */ import io.netty.channel.ChannelInitializer;
/*     */ import io.netty.channel.ChannelOption;
/*     */ import io.netty.channel.ChannelPipeline;
/*     */ import io.netty.channel.EventLoopGroup;
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
/*     */ public final class GServerBootstrap
/*     */   extends GBootstrap
/*     */ {
/*     */   private static GServerBootstrap instance;
/*     */   private ServerBootstrap serverBootstrap;
/*  34 */   private EventLoopGroup bossGroup = Loop;
/*  35 */   private EventLoopGroup workerGroup = Loop;
/*     */ 
/*     */ 
/*     */   
/*     */   public static GServerBootstrap getInstance() {
/*  40 */     if (instance == null) {
/*  41 */       instance = new GServerBootstrap();
/*     */     }
/*  43 */     return instance;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void start() {
/*     */     try {
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
/*     */                     protected void channelIdle(ChannelHandlerContext ctx, IdleStateEvent evt) throws Exception {
/*  63 */                       Out.info(new Object[] { ctx.channel().remoteAddress(), " idle close!!!" });
/*  64 */                       ctx.channel().attr(GGlobal.__KEY_SESSION_TIMEOUT).set(Boolean.valueOf(true));
/*  65 */                       ctx.close();
/*     */                     }
/*     */                   });
/*     */               
/*  69 */               pipeline.addLast("decoder", (ChannelHandler)new PomeloDecoder());
/*  70 */               pipeline.addLast("encoder", (ChannelHandler)new PomeloEncoder());
/*  71 */               pipeline.addLast("handler", (ChannelHandler)new ServerSessionHandler());
/*     */             }
/*     */           });
/*     */       
/*  75 */       ((ServerBootstrap)this.serverBootstrap
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*  82 */         .option(ChannelOption.SO_REUSEADDR, Boolean.valueOf(true)))
/*     */ 
/*     */         
/*  85 */         .childOption(ChannelOption.TCP_NODELAY, Boolean.valueOf(true))
/*     */ 
/*     */ 
/*     */         
/*  89 */         .childOption(ChannelOption.WRITE_BUFFER_HIGH_WATER_MARK, Integer.valueOf(262144))
/*  90 */         .childOption(ChannelOption.WRITE_BUFFER_LOW_WATER_MARK, Integer.valueOf(131072));
/*     */ 
/*     */       
/*  93 */       String ip = GConfig.getInstance().getGameHost();
/*  94 */       int port = GConfig.getInstance().getGamePort();
/*  95 */       InetSocketAddress socketAddress = (ip != null && ip.length() > 6) ? new InetSocketAddress(ip, port) : new InetSocketAddress(port);
/*  96 */       this.serverBootstrap.bind(socketAddress).sync();
/*     */       
/*  98 */       Out.info(new Object[] { "服务绑定于 -> ", socketAddress });
/*  99 */     } catch (Exception e) {
/* 100 */       Out.error(new Object[] { e });
/*     */       try {
/* 102 */         Thread.sleep(1000L);
/* 103 */       } catch (InterruptedException interruptedException) {}
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\core\game\GServerBootstrap.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */