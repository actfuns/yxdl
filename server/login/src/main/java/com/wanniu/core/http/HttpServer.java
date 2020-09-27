/*    */ package com.wanniu.core.http;
/*    */ 
/*    */ import io.netty.bootstrap.ServerBootstrap;
/*    */ import io.netty.channel.Channel;
/*    */ import io.netty.channel.ChannelFuture;
/*    */ import io.netty.channel.ChannelHandler;
/*    */ import io.netty.channel.ChannelInitializer;
/*    */ import io.netty.channel.EventLoopGroup;
/*    */ import io.netty.channel.nio.NioEventLoopGroup;
/*    */ import io.netty.channel.socket.SocketChannel;
/*    */ import io.netty.channel.socket.nio.NioServerSocketChannel;
/*    */ import io.netty.handler.codec.http.HttpObjectAggregator;
/*    */ import io.netty.handler.codec.http.HttpRequestDecoder;
/*    */ import io.netty.handler.codec.http.HttpResponseEncoder;
/*    */ import io.netty.handler.stream.ChunkedWriteHandler;
/*    */ 
/*    */ public class HttpServer
/*    */ {
/*    */   private HttpServerHandler httpServerHandler;
/*    */   EventLoopGroup bossGroup;
/*    */   EventLoopGroup workerGroup;
/*    */   
/*    */   public HttpServer() {
/* 24 */     this.bossGroup = (EventLoopGroup)new NioEventLoopGroup();
/* 25 */     this.workerGroup = (EventLoopGroup)new NioEventLoopGroup();
/*    */     this.httpServerHandler = new HttpServerHandler();
/*    */   } public void run(int port) throws Exception {
/*    */     try {
/* 29 */       ServerBootstrap b = new ServerBootstrap();
/* 30 */       ((ServerBootstrap)b.group(this.bossGroup, this.workerGroup).channel(NioServerSocketChannel.class))
/* 31 */         .childHandler((ChannelHandler)new ChannelInitializer<SocketChannel>()
/*    */           {
/*    */             public void initChannel(SocketChannel ch) throws Exception {
/* 34 */               ch.pipeline().addLast("http-decoder", (ChannelHandler)new HttpRequestDecoder());
/* 35 */               ch.pipeline().addLast("http-aggregator", (ChannelHandler)new HttpObjectAggregator(65536));
/* 36 */               ch.pipeline().addLast("http-encoder", (ChannelHandler)new HttpResponseEncoder());
/* 37 */               ch.pipeline().addLast("http-chunked", (ChannelHandler)new ChunkedWriteHandler());
/* 38 */               ch.pipeline().addLast(new ChannelHandler[] { (ChannelHandler)HttpServer.access$0(this.this$0) });
/*    */             }
/*    */           });
/* 41 */       ChannelFuture f = b.bind(port).sync();
/*    */       
/* 43 */       System.out.println("Http Server start Success! http://127.0.0.1:" + port + '/');
/* 44 */       f.channel().closeFuture().sync();
/*    */     } finally {
/* 46 */       this.bossGroup.shutdownGracefully();
/* 47 */       this.workerGroup.shutdownGracefully();
/*    */     } 
/*    */   }
/*    */   
/*    */   public void addHandler(HttpServerMsgHandler handler) {
/* 52 */     this.httpServerHandler.addHandler(handler);
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-login\xmds-login.jar!\com\wanniu\core\http\HttpServer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */