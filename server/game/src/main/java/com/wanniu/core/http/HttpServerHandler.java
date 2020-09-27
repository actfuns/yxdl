/*    */ package com.wanniu.core.http;
/*    */ 
/*    */ import io.netty.channel.ChannelHandler.Sharable;
/*    */ import io.netty.channel.ChannelHandlerContext;
/*    */ import io.netty.channel.SimpleChannelInboundHandler;
/*    */ import io.netty.handler.codec.http.FullHttpRequest;
/*    */ import io.netty.handler.codec.http.HttpMethod;
/*    */ import java.net.URI;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ @Sharable
/*    */ public class HttpServerHandler
/*    */   extends SimpleChannelInboundHandler<FullHttpRequest>
/*    */ {
/* 17 */   private Map<String, HttpServerMsgHandler> httphandlersChain = new HashMap<>();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void channelRead0(ChannelHandlerContext ctx, FullHttpRequest request) throws Exception {
/* 25 */     URI uri = new URI(request.getUri());
/*    */     
/* 27 */     String path = uri.getPath();
/* 28 */     HttpServerMsgHandler handler = this.httphandlersChain.get(path);
/* 29 */     Map<String, String> parmMap = HttpDecoderAndEncoder.parse(request);
/* 30 */     if (handler != null) {
/* 31 */       if (request.getMethod().equals(HttpMethod.GET)) {
/* 32 */         handler.doGet(ctx, request, parmMap);
/* 33 */       } else if (request.getMethod().equals(HttpMethod.POST) || request.getMethod().equals(HttpMethod.OPTIONS)) {
/* 34 */         handler.doPost(ctx, request, parmMap);
/*    */       } 
/*    */     } else {
/*    */       
/* 38 */       ctx.close();
/*    */     } 
/*    */   }
/*    */   
/*    */   public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
/* 43 */     ctx.flush();
/*    */   }
/*    */ 
/*    */   
/*    */   public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
/* 48 */     ctx.close();
/*    */   }
/*    */   
/*    */   public void addHandler(HttpServerMsgHandler handler) {
/* 52 */     this.httphandlersChain.put(handler.getPath(), handler);
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\core\http\HttpServerHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */