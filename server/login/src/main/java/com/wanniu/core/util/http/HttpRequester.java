/*     */ package com.wanniu.core.util.http;
/*     */ 
/*     */ import java.io.BufferedReader;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.OutputStream;
/*     */ import java.net.HttpURLConnection;
/*     */ import java.net.URL;
/*     */ import java.nio.charset.Charset;
/*     */ import java.util.Map;
/*     */ import java.util.Vector;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class HttpRequester
/*     */ {
/*     */   private String defaultContentEncoding;
/*     */   
/*     */   public HttpRequester() {
/*  22 */     this.defaultContentEncoding = Charset.defaultCharset().name();
/*     */   }
/*     */   
/*     */   public HttpRequester(String encoding) {
/*  26 */     this.defaultContentEncoding = encoding;
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
/*     */   public HttpRespons sendGet(String urlString) throws IOException {
/*  38 */     return send(urlString, "GET", null, null);
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
/*     */ 
/*     */   
/*     */   public HttpRespons sendGet(String urlString, Map<String, String> params) throws IOException {
/*  53 */     return send(urlString, "GET", params, null);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HttpRespons sendGet(String urlString, Map<String, String> params, Map<String, String> propertys) throws IOException {
/*  70 */     return send(urlString, "GET", params, propertys);
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
/*     */   public HttpRespons sendPost(String urlString) throws IOException {
/*  82 */     return send(urlString, "POST", null, null);
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
/*     */ 
/*     */   
/*     */   public HttpRespons sendPost(String urlString, Map<String, String> params) throws IOException {
/*  97 */     return send(urlString, "POST", params, null);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HttpRespons sendPost(String urlString, Map<String, String> params, Map<String, String> propertys) throws IOException {
/* 114 */     return send(urlString, "POST", params, propertys);
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
/*     */   private HttpRespons send(String urlString, String method, Map<String, String> parameters, Map<String, String> propertys) throws IOException {
/* 127 */     HttpURLConnection urlConnection = null;
/*     */     
/* 129 */     if (method.equalsIgnoreCase("GET") && parameters != null) {
/* 130 */       StringBuffer param = new StringBuffer();
/* 131 */       int i = 0;
/* 132 */       for (String key : parameters.keySet()) {
/* 133 */         if (i == 0) {
/* 134 */           param.append("?");
/*     */         } else {
/* 136 */           param.append("&");
/* 137 */         }  param.append(key).append("=").append(parameters.get(key));
/* 138 */         i++;
/*     */       } 
/* 140 */       urlString = String.valueOf(urlString) + param;
/*     */     } 
/* 142 */     URL url = new URL(urlString);
/* 143 */     urlConnection = (HttpURLConnection)url.openConnection();
/*     */     
/* 145 */     urlConnection.setRequestMethod(method);
/* 146 */     urlConnection.setDoOutput(true);
/* 147 */     urlConnection.setDoInput(true);
/* 148 */     urlConnection.setUseCaches(false);
/* 149 */     urlConnection.setConnectTimeout(3000);
/* 150 */     urlConnection.setReadTimeout(5000);
/*     */     
/* 152 */     if (propertys != null) {
/* 153 */       for (String key : propertys.keySet()) {
/* 154 */         urlConnection.addRequestProperty(key, propertys.get(key));
/*     */       }
/*     */     }
/* 157 */     if (method.equalsIgnoreCase("POST") && parameters != null) {
/* 158 */       StringBuffer param = new StringBuffer();
/* 159 */       for (String key : parameters.keySet()) {
/* 160 */         param.append("&");
/* 161 */         param.append(key).append("=").append(parameters.get(key));
/*     */       } 
/* 163 */       OutputStream output = urlConnection.getOutputStream();
/* 164 */       output.write(param.toString().getBytes());
/* 165 */       output.flush();
/* 166 */       output.close();
/*     */     } 
/*     */     
/* 169 */     return makeContent(urlString, urlConnection);
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
/*     */   private HttpRespons makeContent(String urlString, HttpURLConnection urlConnection) throws IOException {
/* 181 */     HttpRespons httpResponser = new HttpRespons();
/*     */     try {
/* 183 */       InputStream in = urlConnection.getInputStream();
/* 184 */       BufferedReader bufferedReader = new BufferedReader(
/* 185 */           new InputStreamReader(in));
/* 186 */       httpResponser.contentCollection = new Vector<>();
/* 187 */       StringBuffer temp = new StringBuffer();
/* 188 */       String line = bufferedReader.readLine();
/* 189 */       while (line != null) {
/* 190 */         httpResponser.contentCollection.add(line);
/* 191 */         temp.append(line).append("\r\n");
/* 192 */         line = bufferedReader.readLine();
/*     */       } 
/* 194 */       bufferedReader.close();
/*     */       
/* 196 */       String ecod = urlConnection.getContentEncoding();
/* 197 */       if (ecod == null) {
/* 198 */         ecod = this.defaultContentEncoding;
/*     */       }
/* 200 */       httpResponser.urlString = urlString;
/*     */       
/* 202 */       httpResponser.defaultPort = urlConnection.getURL().getDefaultPort();
/* 203 */       httpResponser.file = urlConnection.getURL().getFile();
/* 204 */       httpResponser.host = urlConnection.getURL().getHost();
/* 205 */       httpResponser.path = urlConnection.getURL().getPath();
/* 206 */       httpResponser.port = urlConnection.getURL().getPort();
/* 207 */       httpResponser.protocol = urlConnection.getURL().getProtocol();
/* 208 */       httpResponser.query = urlConnection.getURL().getQuery();
/* 209 */       httpResponser.ref = urlConnection.getURL().getRef();
/* 210 */       httpResponser.userInfo = urlConnection.getURL().getUserInfo();
/*     */       
/* 212 */       httpResponser.content = new String(temp.toString().getBytes(), ecod);
/* 213 */       httpResponser.contentEncoding = ecod;
/* 214 */       httpResponser.code = urlConnection.getResponseCode();
/* 215 */       httpResponser.message = urlConnection.getResponseMessage();
/* 216 */       httpResponser.contentType = urlConnection.getContentType();
/* 217 */       httpResponser.method = urlConnection.getRequestMethod();
/* 218 */       httpResponser.connectTimeout = urlConnection.getConnectTimeout();
/* 219 */       httpResponser.readTimeout = urlConnection.getReadTimeout();
/*     */       
/* 221 */       return httpResponser;
/* 222 */     } catch (IOException e) {
/* 223 */       throw e;
/*     */     } finally {
/* 225 */       if (urlConnection != null) {
/* 226 */         urlConnection.disconnect();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDefaultContentEncoding() {
/* 234 */     return this.defaultContentEncoding;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDefaultContentEncoding(String defaultContentEncoding) {
/* 241 */     this.defaultContentEncoding = defaultContentEncoding;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-login\xmds-login.jar!\com\wanniu\cor\\util\http\HttpRequester.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */