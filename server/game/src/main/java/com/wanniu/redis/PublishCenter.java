/*    */ package com.wanniu.redis;
/*    */ 
/*    */ import com.wanniu.core.GConfig;
/*    */ import com.wanniu.core.redis.Redis;
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
/*    */ public class PublishCenter
/*    */ {
/*    */   private static Redis redis;
/*    */   
/*    */   static {
/* 30 */     String host = GConfig.getInstance().get("publish.redis.host", "127.0.0.1");
/* 31 */     int port = GConfig.getInstance().getInt("publish.redis.port", 6379);
/* 32 */     String password = GConfig.getInstance().get("publish.redis.password", null);
/* 33 */     int dbIndex = GConfig.getInstance().getInt("publish.redis.db", 1);
/* 34 */     redis = new Redis(host, port, password, dbIndex);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void publish(String channel, String message) {
/* 41 */     redis.publish(channel, message);
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\redis\PublishCenter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */