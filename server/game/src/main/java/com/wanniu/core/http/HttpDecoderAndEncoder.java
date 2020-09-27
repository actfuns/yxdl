/*     */ package com.wanniu.core.http;
/*     */ 
/*     */ import com.wanniu.core.logfs.Out;
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
/*     */ 
/*     */ 
/*     */ public class HttpDecoderAndEncoder
/*     */ {
/*     */   public static void Request(ChannelHandlerContext ctx, FullHttpRequest req) {}
/*     */   
/*     */   public static Map<String, String> parse(FullHttpRequest fullReq) throws Exception {
/*  51 */     HttpMethod method = fullReq.getMethod();
/*     */     
/*  53 */     Map<String, String> parmMap = new HashMap<>();
/*     */     
/*  55 */     if (HttpMethod.GET == method) {
/*     */       
/*  57 */       QueryStringDecoder decoder = new QueryStringDecoder(fullReq.getUri());
/*  58 */       Set<Map.Entry<String, List<String>>> set = decoder.parameters().entrySet();
/*  59 */       for (Map.Entry<String, List<String>> entry : set) {
/*  60 */         parmMap.put(entry.getKey(), ((List<String>)entry.getValue()).get(0));
/*     */       }
/*  62 */     } else if (HttpMethod.POST == method) {
/*     */       
/*  64 */       HttpPostRequestDecoder decoder = new HttpPostRequestDecoder((HttpRequest)fullReq);
/*  65 */       decoder.offer((HttpContent)fullReq);
/*     */       
/*  67 */       List<InterfaceHttpData> parmList = decoder.getBodyHttpDatas();
/*     */       
/*  69 */       for (InterfaceHttpData parm : parmList)
/*     */       {
/*  71 */         Attribute data = (Attribute)parm;
/*  72 */         parmMap.put(data.getName(), data.getValue());
/*     */       }
/*     */     
/*     */     } else {
/*     */       
/*  77 */       throw new Exception("");
/*     */     } 
/*     */     
/*  80 */     return parmMap;
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
/*  91 */     Response(ctx, req, msg, HttpResponseStatus.OK);
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
/*     */   
/*     */   public static void Response(ChannelHandlerContext ctx, FullHttpRequest req, String msg, HttpResponseStatus status) {
/*     */     try {
/* 105 */       DefaultFullHttpResponse defaultFullHttpResponse = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, Unpooled.wrappedBuffer(msg.getBytes("UTF-8")));
/* 106 */       defaultFullHttpResponse.headers().set("Content-Type", "text/plain");
/* 107 */       defaultFullHttpResponse.headers().set("Content-Length", Integer.valueOf(defaultFullHttpResponse.content().readableBytes()));
/* 108 */       defaultFullHttpResponse.headers().set("Access-Control-Allow-Origin", "*");
/* 109 */       if (HttpHeaders.isKeepAlive((HttpMessage)req)) {
/* 110 */         defaultFullHttpResponse.headers().set("Connection", "keep-alive");
/*     */       }
/* 112 */       ctx.write(defaultFullHttpResponse);
/* 113 */       ctx.flush();
/*     */     }
/* 115 */     catch (Exception e) {
/* 116 */       Out.error(new Object[] { "HttpDecoderAndEncoder Response", e });
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\core\http\HttpDecoderAndEncoder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */