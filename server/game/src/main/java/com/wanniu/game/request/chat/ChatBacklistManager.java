/*    */ package com.wanniu.game.request.chat;
/*    */ 
/*    */ import com.alibaba.fastjson.JSON;
/*    */ import com.wanniu.core.util.StringUtil;
/*    */ import java.util.concurrent.ConcurrentHashMap;
/*    */ import java.util.concurrent.ConcurrentMap;
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
/*    */ public class ChatBacklistManager
/*    */ {
/* 28 */   private static final ChatBacklistManager instance = new ChatBacklistManager();
/* 29 */   private final ConcurrentMap<String, Long> backlist = new ConcurrentHashMap<>();
/*    */   
/*    */   public static ChatBacklistManager getInstance() {
/* 32 */     return instance;
/*    */   }
/*    */   
/*    */   public boolean inBacklist(String ip) {
/* 36 */     if (StringUtil.isNotEmpty(ip)) {
/* 37 */       return this.backlist.containsKey(ip);
/*    */     }
/* 39 */     return false;
/*    */   }
/*    */   
/*    */   public void addIp(String ip) {
/* 43 */     this.backlist.put(ip, Long.valueOf(System.currentTimeMillis()));
/*    */   }
/*    */   
/*    */   public void remove(String ip) {
/* 47 */     this.backlist.remove(ip);
/*    */   }
/*    */   
/*    */   public String toString() {
/* 51 */     return JSON.toJSONString(this.backlist);
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\chat\ChatBacklistManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */