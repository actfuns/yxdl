/*    */ package com.wanniu.db.dao;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import redis.clients.jedis.Jedis;
/*    */ import redis.clients.jedis.JedisPool;
/*    */ import redis.clients.util.SafeEncoder;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RedisDao
/*    */ {
/* 16 */   private static Map<Integer, JedisPool> redisPools = new HashMap<>();
/*    */   
/*    */   public static JedisPool putRedisPools(int logicServerId, JedisPool redisPool) {
/* 19 */     return redisPools.put(Integer.valueOf(logicServerId), redisPool);
/*    */   }
/*    */   
/*    */   public static final Jedis getRedis(int logicServerId) {
/* 23 */     JedisPool redisPool = redisPools.get(Integer.valueOf(logicServerId));
/* 24 */     if (redisPool == null) {
/* 25 */       return null;
/*    */     }
/* 27 */     return redisPool.getResource();
/*    */   }
/*    */   
/*    */   public static final String get(int logicServerId, String key) {
/* 31 */     Jedis redis = getRedis(logicServerId);
/*    */     try {
/* 33 */       return redis.get(key);
/*    */     } finally {
/* 35 */       release(redis);
/*    */     } 
/*    */   }
/*    */   
/*    */   public static final byte[] get(int logicServerId, byte[] key) {
/* 40 */     Jedis redis = getRedis(logicServerId);
/*    */     try {
/* 42 */       return redis.get(key);
/*    */     } finally {
/* 44 */       release(redis);
/*    */     } 
/*    */   }
/*    */   
/*    */   public static final String hget(int logicServerId, String key, String field) {
/* 49 */     Jedis redis = getRedis(logicServerId);
/*    */     try {
/* 51 */       return redis.hget(key, field);
/*    */     } finally {
/* 53 */       release(redis);
/*    */     } 
/*    */   }
/*    */   
/*    */   public static final byte[] hget(int logicServerId, String key, byte[] field) {
/* 58 */     Jedis redis = getRedis(logicServerId);
/*    */     try {
/* 60 */       return redis.hget(encode(key), field);
/*    */     } finally {
/* 62 */       release(redis);
/*    */     } 
/*    */   }
/*    */   
/*    */   public static final Map<String, String> hgetAll(int logicServerId, String key) {
/* 67 */     Jedis redis = getRedis(logicServerId);
/*    */     try {
/* 69 */       return redis.hgetAll(key);
/*    */     } finally {
/* 71 */       release(redis);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public static final void release(Jedis redis) {
/* 77 */     if (redis != null) {
/* 78 */       redis.close();
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static final byte[] encode(String utf) {
/* 85 */     return SafeEncoder.encode(utf);
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-db\xmds-db.jar!\com\wanniu\db\dao\RedisDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */