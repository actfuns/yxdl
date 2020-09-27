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
/*    */ @Sharable
/*    */ public class HttpServerHandler
/*    */   extends SimpleChannelInboundHandler<FullHttpRequest>
/*    */ {
/* 16 */   private HashMap<String, HttpServerMsgHandler> httphandlersChain = new HashMap<>();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void channelRead0(ChannelHandlerContext ctx, FullHttpRequest request) throws Exception {
/* 23 */     URI uri = new URI(request.getUri());
/*    */     
/* 25 */     String path = uri.getPath();
/* 26 */     HttpServerMsgHandler handler = this.httphandlersChain.get(path);
/* 27 */     Map<String, String> parmMap = HttpDecoderAndEncoder.parse(request);
/* 28 */     if (handler != null) {
/* 29 */       if (request.getMethod().equals(HttpMethod.GET)) {
/* 30 */         handler.doGet(ctx, request, parmMap);
/* 31 */       } else if (request.getMethod().equals(HttpMethod.POST) || request.getMethod().equals(HttpMethod.OPTIONS)) {
/* 32 */         handler.doPost(ctx, request, parmMap);
/*    */       } 
/*    */     } else {
/* 35 */       ctx.close();
/*    */     } 
/*    */   }
/*    */   
/*    */   public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
/* 40 */     ctx.flush();
/*    */   }
/*    */ 
/*    */   
/*    */   public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
/* 45 */     ctx.close();
/*    */   }
/*    */   
/*    */   public void addHandler(HttpServerMsgHandler handler) {
/* 49 */     this.httphandlersChain.put(handler.getPath(), handler);
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-login\xmds-login.jar!\com\wanniu\core\http\HttpServerHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */