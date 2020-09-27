/*    */ package com.wanniu.game.downjoy;
/*    */ 
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import java.io.BufferedReader;
/*    */ import java.io.DataOutputStream;
/*    */ import java.io.InputStreamReader;
/*    */ import java.net.HttpURLConnection;
/*    */ import java.net.URL;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class HttpClientUtil
/*    */ {
/*    */   public static final String DEFAULT_URL_CONTENT_TYPE = "application/x-www-form-urlencoded";
/*    */   public static final String JSON_CONTENT_TYPE = "application/json";
/*    */   public static final int CONNECT_TIME_OUT = 5000;
/*    */   public static final String DEFAULT_CHARSET = "UTF-8";
/*    */   
/*    */   public static String doPost(String postURL, String requestBody) throws Exception {
/* 33 */     return doPost(postURL, requestBody, "application/x-www-form-urlencoded");
/*    */   }
/*    */   
/*    */   public static String doPost(String postURL, String requestBody, String contentType) throws Exception {
/* 37 */     Out.info(new Object[] { "HTTP POST URL=", postURL, ", requestBody=", requestBody });
/*    */     
/* 39 */     HttpURLConnection httpConn = null;
/*    */     
/*    */     try {
/* 42 */       URL postUrl = new URL(postURL);
/*    */       
/* 44 */       httpConn = (HttpURLConnection)postUrl.openConnection();
/*    */ 
/*    */ 
/*    */       
/* 48 */       httpConn.setDoOutput(true);
/*    */       
/* 50 */       httpConn.setDoInput(true);
/*    */       
/* 52 */       httpConn.setRequestMethod("POST");
/*    */       
/* 54 */       httpConn.setUseCaches(false);
/*    */       
/* 56 */       httpConn.setInstanceFollowRedirects(true);
/* 57 */       httpConn.setRequestProperty("Content-Type", contentType + "; charset=UTF-8;");
/*    */       
/* 59 */       byte[] bytes = requestBody.getBytes("UTF-8");
/* 60 */       httpConn.setRequestProperty("Content-Length", String.valueOf(bytes.length));
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 66 */       httpConn.setConnectTimeout(5000);
/*    */       
/* 68 */       httpConn.setReadTimeout(5000);
/*    */ 
/*    */       
/* 71 */       httpConn.connect();
/* 72 */       DataOutputStream out = new DataOutputStream(httpConn.getOutputStream());
/* 73 */       out.write(bytes);
/* 74 */       out.flush();
/* 75 */       out.close();
/* 76 */       int status = httpConn.getResponseCode();
/* 77 */       if (status != 200) {
/* 78 */         System.out.println("发送请求失败，状态码：[" + status + "] 返回信息：" + httpConn.getResponseMessage());
/* 79 */         return null;
/*    */       } 
/* 81 */       BufferedReader reader = new BufferedReader(new InputStreamReader(httpConn.getInputStream(), "UTF-8"));
/* 82 */       StringBuffer responseSb = new StringBuffer();
/* 83 */       String line = null;
/* 84 */       while ((line = reader.readLine()) != null) {
/* 85 */         responseSb.append(line.trim());
/*    */       }
/* 87 */       reader.close();
/* 88 */       return responseSb.toString().trim();
/*    */     } finally {
/* 90 */       httpConn.disconnect();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\downjoy\HttpClientUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */