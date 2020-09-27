/*    */ package com.wanniu.login.request;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
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
/*    */ public class TokenUtils
/*    */ {
/*    */   public static Map<String, String> build(String channel, String uid, String mac, String os) {
/* 22 */     Map<String, String> tokenInfo = new HashMap<>();
/* 23 */     tokenInfo.put("channel", channel);
/* 24 */     tokenInfo.put("uid", uid);
/* 25 */     tokenInfo.put("mac", mac);
/* 26 */     tokenInfo.put("os", os);
/* 27 */     return tokenInfo;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-login\xmds-login.jar!\com\wanniu\login\request\TokenUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */