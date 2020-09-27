/*    */ package com.wanniu.game.request.prepaid;
/*    */ 
/*    */ import com.google.gson.Gson;
/*    */ import java.io.IOException;
/*    */ import java.util.Map;
/*    */ import org.apache.http.HttpEntity;
/*    */ import org.apache.http.client.methods.CloseableHttpResponse;
/*    */ import org.apache.http.client.methods.HttpPost;
/*    */ import org.apache.http.client.methods.HttpUriRequest;
/*    */ import org.apache.http.impl.client.CloseableHttpClient;
/*    */ import org.apache.http.impl.client.HttpClientBuilder;
/*    */ import org.apache.http.util.EntityUtils;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class HttpClientPost
/*    */ {
/*    */   public static boolean doPost(String url, String userId, String userCode, int gameType, Double money) {
/* 39 */     CloseableHttpClient httpClient = HttpClientBuilder.create().build();
/*    */ 
/*    */     
/* 42 */     StringBuffer params = new StringBuffer();
/*    */     
/*    */     try {
/* 45 */       params.append("userId=" + userId);
/* 46 */       params.append("&");
/* 47 */       params.append("userCode=" + userCode);
/* 48 */       params.append("&");
/* 49 */       params.append("gameType=" + gameType);
/* 50 */       params.append("&");
/* 51 */       params.append("money=" + money);
/* 52 */     } catch (Exception e1) {
/* 53 */       e1.printStackTrace();
/*    */     } 
/*    */ 
/*    */     
/* 57 */     HttpPost httpPost = new HttpPost(url + "?" + params);
/*    */ 
/*    */     
/* 60 */     httpPost.setHeader("Content-Type", "application/json;charset=utf8");
/*    */ 
/*    */     
/* 63 */     CloseableHttpResponse response = null;
/* 64 */     String msg = null;
/*    */     
/*    */     try {
/* 67 */       response = httpClient.execute((HttpUriRequest)httpPost);
/*    */       
/* 69 */       HttpEntity responseEntity = response.getEntity();
/*    */       
/* 71 */       String s = EntityUtils.toString(responseEntity);
/* 72 */       Gson gson = new Gson();
/* 73 */       Map map = (Map)gson.fromJson(s, Map.class);
/* 74 */       msg = (String)map.get("msg");
/*    */     
/*    */     }
/* 77 */     catch (Exception e) {
/* 78 */       e.printStackTrace();
/*    */     } finally {
/*    */       
/*    */       try {
/* 82 */         if (httpClient != null) {
/* 83 */           httpClient.close();
/*    */         }
/* 85 */         if (response != null) {
/* 86 */           response.close();
/*    */         }
/* 88 */       } catch (IOException e) {
/* 89 */         e.printStackTrace();
/*    */       } 
/*    */     } 
/*    */ 
/*    */     
/* 94 */     return msg.equalsIgnoreCase("成功");
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\prepaid\HttpClientPost.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */