/*     */ package com.wanniu.core.util.http;
/*     */ 
/*     */ import java.util.Vector;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class HttpRespons
/*     */ {
/*     */   String urlString;
/*     */   int defaultPort;
/*     */   String file;
/*     */   String host;
/*     */   String path;
/*     */   int port;
/*     */   String protocol;
/*     */   String query;
/*     */   String ref;
/*     */   String userInfo;
/*     */   String contentEncoding;
/*     */   String content;
/*     */   String contentType;
/*     */   int code;
/*     */   String message;
/*     */   String method;
/*     */   int connectTimeout;
/*     */   int readTimeout;
/*     */   Vector<String> contentCollection;
/*     */   
/*     */   public String getContent() {
/*  31 */     return this.content;
/*     */   }
/*     */   
/*     */   public String getContentType() {
/*  35 */     return this.contentType;
/*     */   }
/*     */   
/*     */   public int getCode() {
/*  39 */     return this.code;
/*     */   }
/*     */   
/*     */   public String getMessage() {
/*  43 */     return this.message;
/*     */   }
/*     */   
/*     */   public Vector<String> getContentCollection() {
/*  47 */     return this.contentCollection;
/*     */   }
/*     */   
/*     */   public String getContentEncoding() {
/*  51 */     return this.contentEncoding;
/*     */   }
/*     */   
/*     */   public String getMethod() {
/*  55 */     return this.method;
/*     */   }
/*     */   
/*     */   public int getConnectTimeout() {
/*  59 */     return this.connectTimeout;
/*     */   }
/*     */   
/*     */   public int getReadTimeout() {
/*  63 */     return this.readTimeout;
/*     */   }
/*     */   
/*     */   public String getUrlString() {
/*  67 */     return this.urlString;
/*     */   }
/*     */   
/*     */   public int getDefaultPort() {
/*  71 */     return this.defaultPort;
/*     */   }
/*     */   
/*     */   public String getFile() {
/*  75 */     return this.file;
/*     */   }
/*     */   
/*     */   public String getHost() {
/*  79 */     return this.host;
/*     */   }
/*     */   
/*     */   public String getPath() {
/*  83 */     return this.path;
/*     */   }
/*     */   
/*     */   public int getPort() {
/*  87 */     return this.port;
/*     */   }
/*     */   
/*     */   public String getProtocol() {
/*  91 */     return this.protocol;
/*     */   }
/*     */   
/*     */   public String getQuery() {
/*  95 */     return this.query;
/*     */   }
/*     */   
/*     */   public String getRef() {
/*  99 */     return this.ref;
/*     */   }
/*     */   
/*     */   public String getUserInfo() {
/* 103 */     return this.userInfo;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\cor\\util\http\HttpRespons.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */