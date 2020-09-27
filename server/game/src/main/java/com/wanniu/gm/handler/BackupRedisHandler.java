/*    */ package com.wanniu.gm.handler;
/*    */ 
/*    */ import com.alibaba.fastjson.JSONArray;
/*    */ import com.wanniu.core.GConfig;
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.core.redis.Redis;
/*    */ import com.wanniu.game.GWorld;
/*    */ import com.wanniu.gm.GMEvent;
/*    */ import com.wanniu.gm.GMResponse;
/*    */ import com.wanniu.gm.GMStateResponse;
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import java.nio.file.Files;
/*    */ import java.time.LocalDateTime;
/*    */ import java.time.format.DateTimeFormatter;
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
/*    */ public class BackupRedisHandler
/*    */   extends GMBaseHandler
/*    */ {
/*    */   public GMResponse execute(JSONArray arr) {
/* 43 */     String redisHost = GConfig.getInstance().get("server.redis.host", "127.0.0.1");
/* 44 */     int redisPort = GConfig.getInstance().getInt("server.redis.port", 6379);
/* 45 */     String pwd = GConfig.getInstance().get("server.redis.password");
/* 46 */     int db = GConfig.getInstance().getInt("server.redis.db", 0);
/* 47 */     Redis redis = new Redis(redisHost, redisPort, 6000000, (pwd != null) ? pwd.trim() : null, db);
/* 48 */     redis.save();
/* 49 */     redis.close();
/*    */     
/* 51 */     makeDir();
/*    */     
/* 53 */     String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
/* 54 */     File source = new File("/data/redis/dump_" + redisPort + ".rdb");
/* 55 */     File dest = new File("/data/backup/temp/dump_" + GWorld.__SERVER_ID + ".rdb." + date);
/*    */     try {
/* 57 */       Files.copy(source.toPath(), dest.toPath(), new java.nio.file.CopyOption[0]);
/* 58 */       return (GMResponse)new GMStateResponse(1);
/* 59 */     } catch (IOException e) {
/* 60 */       Out.error(new Object[] { e });
/* 61 */       return (GMResponse)new GMStateResponse(0);
/*    */     } 
/*    */   }
/*    */   
/*    */   private void makeDir() {
/* 66 */     File dest = new File("/data/backup/temp/");
/* 67 */     if (!dest.exists()) {
/* 68 */       dest.mkdirs();
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public short getType() {
/* 74 */     return 4;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\gm\handler\BackupRedisHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */