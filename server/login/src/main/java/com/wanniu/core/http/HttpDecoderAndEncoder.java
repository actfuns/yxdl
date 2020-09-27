/*     */ package com.wanniu.core.http;
/*     */ 
/*     */ import io.netty.buffer.Unpooled;
/*     */ import io.netty.channel.ChannelHandlerContext;
/*     */ import io.netty.handler.codec.http.DefaultFullHttpResponse;
/*     */ import io.netty.handler.codec.http.FullHttpRequest;
/*     */ import io.netty.handler.codec.http.HttpContent;
/*     */ import io.netty.handler.codec.http.HttpHeaders;
/*     */ import io.netty.handler.codec.http.HttpMessage;
/*     */ import io.netty.handler.codec.http.HttpMethod;
/*     */ import io.netty.handler.codec.http.HttpRequest;
/*     */ import io.netty.handler.codec.http.HttpResponseStatus;
/*     */ import io.netty.handler.codec.http.HttpVersion;
/*     */ import io.netty.handler.codec.http.QueryStringDecoder;
/*     */ import io.netty.handler.codec.http.multipart.Attribute;
/*     */ import io.netty.handler.codec.http.multipart.HttpPostRequestDecoder;
/*     */ import io.netty.handler.codec.http.multipart.InterfaceHttpData;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class HttpDecoderAndEncoder
/*     */ {
/*     */   public static void Request(ChannelHandlerContext ctx, FullHttpRequest req) {}
/*     */   
/*     */   public static Map<String, String> parse(FullHttpRequest fullReq) throws Exception {
/*  48 */     HttpMethod method = fullReq.getMethod();
/*     */     
/*  50 */     Map<String, String> parmMap = new HashMap<>();
/*     */     
/*  52 */     if (HttpMethod.GET == method) {
/*     */       
/*  54 */       QueryStringDecoder decoder = new QueryStringDecoder(fullReq.getUri());
/*  55 */       Set<Map.Entry<String, List<String>>> set = decoder.parameters().entrySet();
/*  56 */       for (Map.Entry<String, List<String>> entry : set) {
/*  57 */         parmMap.put(entry.getKey(), ((List<String>)entry.getValue()).get(0));
/*     */       }
/*  59 */     } else if (HttpMethod.POST == method) {
/*     */       
/*  61 */       HttpPostRequestDecoder decoder = new HttpPostRequestDecoder((HttpRequest)fullReq);
/*  62 */       decoder.offer((HttpContent)fullReq);
/*     */       
/*  64 */       List<InterfaceHttpData> parmList = decoder.getBodyHttpDatas();
/*     */       
/*  66 */       for (InterfaceHttpData parm : parmList)
/*     */       {
/*  68 */         Attribute data = (Attribute)parm;
/*  69 */         parmMap.put(data.getName(), data.getValue());
/*     */       }
/*     */     
/*     */     } else {
/*     */       
/*  74 */       throw new Exception("");
/*     */     } 
/*     */     
/*  77 */     return parmMap;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void Response(ChannelHandlerContext ctx, FullHttpRequest req, String msg) {
/*  88 */     Response(ctx, req, msg, HttpResponseStatus.OK);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void Response(ChannelHandlerContext ctx, FullHttpRequest req, String msg, HttpResponseStatus status) {
/*     */     try {
/* 101 */       DefaultFullHttpResponse defaultFullHttpResponse = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, 
/* 102 */           Unpooled.wrappedBuffer(msg.getBytes("UTF-8")));
/* 103 */       defaultFullHttpResponse.headers().set("Content-Type", "text/plain");
/* 104 */       defaultFullHttpResponse.headers().set("Content-Length", Integer.valueOf(defaultFullHttpResponse.content().readableBytes()));
/* 105 */       defaultFullHttpResponse.headers().set("Access-Control-Allow-Origin", "*");
/* 106 */       if (HttpHeaders.isKeepAlive((HttpMessage)req)) {
/* 107 */         defaultFullHttpResponse.headers().set("Connection", "keep-alive");
/*     */       }
/* 109 */       ctx.write(defaultFullHttpResponse);
/* 110 */       ctx.flush();
/*     */     }
/* 112 */     catch (Exception e) {
/* 113 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-login\xmds-login.jar!\com\wanniu\core\http\HttpDecoderAndEncoder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */