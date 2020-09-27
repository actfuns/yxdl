/*    */ package com.wanniu.gm.handler;
/*    */ 
/*    */ import com.alibaba.fastjson.JSON;
/*    */ import com.alibaba.fastjson.JSONArray;
/*    */ import com.alibaba.fastjson.TypeReference;
/*    */ import com.wanniu.core.db.GCache;
/*    */ import com.wanniu.gm.GMEvent;
/*    */ import com.wanniu.gm.GMJsonResponse;
/*    */ import com.wanniu.gm.GMResponse;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GMEvent
/*    */ public class RedisCommandHandler
/*    */   extends GMBaseHandler
/*    */ {
/*    */   public GMResponse execute(JSONArray arr) {
/* 39 */     String command = arr.getString(0);
/*    */     
/* 41 */     Object result = null;
/* 42 */     switch (command) {
/*    */       case "HVALS":
/* 44 */         result = GCache.hvals(arr.getString(1));
/*    */         break;
/*    */       case "HGETALL":
/* 47 */         result = GCache.hgetAll(arr.getString(1));
/*    */         break;
/*    */       case "HMSET":
/* 50 */         GCache.hmset(arr.getString(1), (Map)JSON.parseObject(arr.getString(2), new TypeReference<Map<String, String>>() {  }, new com.alibaba.fastjson.parser.Feature[0]));
/*    */         break;
/*    */     } 
/*    */ 
/*    */ 
/*    */     
/* 56 */     return (GMResponse)new GMJsonResponse(JSON.toJSONString(result));
/*    */   }
/*    */ 
/*    */   
/*    */   public short getType() {
/* 61 */     return 8;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\gm\handler\RedisCommandHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */