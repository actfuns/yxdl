/*     */ package com.wanniu.core.util.http;
/*     */ 
/*     */ import com.alibaba.fastjson.JSON;
/*     */ import com.wanniu.core.logfs.Out;
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
/*     */ 
/*     */ public class HttpRequester
/*     */ {
/*     */   private String defaultContentEncoding;
/*     */   
/*     */   public HttpRequester() {
/*  25 */     this.defaultContentEncoding = Charset.defaultCharset().name();
/*     */   }
/*     */   
/*     */   public HttpRequester(String encoding) {
/*  29 */     this.defaultContentEncoding = encoding;
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
/*  41 */     return send(urlString, "GET", null, null);
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
/*  56 */     return send(urlString, "GET", params, null);
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
/*  73 */     return send(urlString, "GET", params, propertys);
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
/*  85 */     return send(urlString, "POST", null, null);
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
/* 100 */     return send(urlString, "POST", params, null);
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
/* 117 */     return send(urlString, "POST", params, propertys);
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
/* 130 */     Out.info(new Object[] { "HTTP ", method, " URL=", urlString, " parameters=", JSON.toJSONString(parameters) });
/* 131 */     HttpURLConnection urlConnection = null;
/*     */     
/* 133 */     if (method.equalsIgnoreCase("GET") && parameters != null) {
/* 134 */       StringBuffer param = new StringBuffer();
/* 135 */       int i = 0;
/* 136 */       for (String key : parameters.keySet()) {
/* 137 */         if (i == 0) {
/* 138 */           param.append("?");
/*     */         } else {
/* 140 */           param.append("&");
/* 141 */         }  param.append(key).append("=").append(parameters.get(key));
/* 142 */         i++;
/*     */       } 
/* 144 */       urlString = urlString + param;
/*     */     } 
/* 146 */     URL url = new URL(urlString);
/* 147 */     urlConnection = (HttpURLConnection)url.openConnection();
/*     */     
/* 149 */     urlConnection.setRequestMethod(method);
/* 150 */     urlConnection.setDoOutput(true);
/* 151 */     urlConnection.setDoInput(true);
/* 152 */     urlConnection.setUseCaches(false);
/* 153 */     urlConnection.setConnectTimeout(3000);
/* 154 */     urlConnection.setReadTimeout(5000);
/*     */     
/* 156 */     if (propertys != null) {
/* 157 */       for (String key : propertys.keySet()) {
/* 158 */         urlConnection.addRequestProperty(key, propertys.get(key));
/*     */       }
/*     */     }
/* 161 */     if (method.equalsIgnoreCase("POST") && parameters != null) {
/* 162 */       StringBuffer param = new StringBuffer();
/* 163 */       for (String key : parameters.keySet()) {
/* 164 */         param.append("&");
/* 165 */         param.append(key).append("=").append(parameters.get(key));
/*     */       } 
/* 167 */       OutputStream output = urlConnection.getOutputStream();
/* 168 */       output.write(param.toString().getBytes());
/* 169 */       output.flush();
/* 170 */       output.close();
/*     */     } 
/*     */     
/* 173 */     return makeContent(urlString, urlConnection);
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
/* 185 */     HttpRespons httpResponser = new HttpRespons();
/*     */     try {
/* 187 */       InputStream in = urlConnection.getInputStream();
/* 188 */       BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
/*     */       
/* 190 */       httpResponser.contentCollection = new Vector<>();
/* 191 */       StringBuffer temp = new StringBuffer();
/* 192 */       String line = bufferedReader.readLine();
/* 193 */       while (line != null) {
/* 194 */         httpResponser.contentCollection.add(line);
/* 195 */         temp.append(line);
/* 196 */         line = bufferedReader.readLine();
/*     */       } 
/* 198 */       bufferedReader.close();
/*     */       
/* 200 */       String ecod = urlConnection.getContentEncoding();
/* 201 */       if (ecod == null) {
/* 202 */         ecod = this.defaultContentEncoding;
/*     */       }
/* 204 */       httpResponser.urlString = urlString;
/*     */       
/* 206 */       httpResponser.defaultPort = urlConnection.getURL().getDefaultPort();
/* 207 */       httpResponser.file = urlConnection.getURL().getFile();
/* 208 */       httpResponser.host = urlConnection.getURL().getHost();
/* 209 */       httpResponser.path = urlConnection.getURL().getPath();
/* 210 */       httpResponser.port = urlConnection.getURL().getPort();
/* 211 */       httpResponser.protocol = urlConnection.getURL().getProtocol();
/* 212 */       httpResponser.query = urlConnection.getURL().getQuery();
/* 213 */       httpResponser.ref = urlConnection.getURL().getRef();
/* 214 */       httpResponser.userInfo = urlConnection.getURL().getUserInfo();
/*     */       
/* 216 */       httpResponser.content = new String(temp.toString().getBytes(), ecod);
/* 217 */       httpResponser.contentEncoding = ecod;
/* 218 */       httpResponser.code = urlConnection.getResponseCode();
/* 219 */       httpResponser.message = urlConnection.getResponseMessage();
/* 220 */       httpResponser.contentType = urlConnection.getContentType();
/* 221 */       httpResponser.method = urlConnection.getRequestMethod();
/* 222 */       httpResponser.connectTimeout = urlConnection.getConnectTimeout();
/* 223 */       httpResponser.readTimeout = urlConnection.getReadTimeout();
/*     */       
/* 225 */       return httpResponser;
/* 226 */     } catch (IOException e) {
/* 227 */       throw e;
/*     */     } finally {
/* 229 */       if (urlConnection != null) {
/* 230 */         urlConnection.disconnect();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDefaultContentEncoding() {
/* 238 */     return this.defaultContentEncoding;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDefaultContentEncoding(String defaultContentEncoding) {
/* 245 */     this.defaultContentEncoding = defaultContentEncoding;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\cor\\util\http\HttpRequester.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */