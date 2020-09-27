/*     */ package com.wanniu.core.login;
/*     */ 
/*     */ import com.alibaba.fastjson.JSONObject;
/*     */ import com.wanniu.core.GConfig;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
/*     */ import redis.clients.jedis.Jedis;
/*     */ import redis.clients.jedis.JedisPool;
/*     */ import redis.clients.jedis.JedisPoolConfig;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AuthServer
/*     */ {
/*     */   public static final String K_TOKEN = "/token/";
/*     */   public static final String K_PLAYER_SERVERS = "/player/servers/";
/*     */   private static JedisPool RedisPool;
/*     */   
/*     */   static {
/*  27 */     JedisPoolConfig config = new JedisPoolConfig();
/*     */     
/*  29 */     config.setTestOnBorrow(GConfig.getInstance().getBoolean("auth.redis.testonborrow", true));
/*     */     
/*  31 */     config.setTestOnReturn(GConfig.getInstance().getBoolean("auth.redis.testonreturn", true));
/*  32 */     config.setMaxIdle(GConfig.getInstance().getInt("auth.redis.maxidle", 20));
/*  33 */     config.setMaxWaitMillis(GConfig.getInstance().getInt("auth.redis.maxwait", 1000));
/*  34 */     config.setMaxTotal(GConfig.getInstance().getInt("auth.redis.total", 5));
/*     */     
/*  36 */     String redisHost = GConfig.getInstance().get("auth.redis.host", "127.0.0.1");
/*  37 */     int redisPort = GConfig.getInstance().getInt("auth.redis.port", 6379);
/*  38 */     String pwd = GConfig.getInstance().get("auth.redis.password");
/*  39 */     int db = GConfig.getInstance().getInt("auth.redis.db", 0);
/*  40 */     RedisPool = new JedisPool((GenericObjectPoolConfig)config, redisHost, redisPort, 2000, (pwd != null) ? pwd.trim() : null, db);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final Jedis getRedis() {
/*  47 */     return RedisPool.getResource();
/*     */   }
/*     */   
/*     */   public static final String get(String key) {
/*  51 */     Jedis redis = getRedis();
/*     */     try {
/*  53 */       return redis.get(key);
/*     */     } finally {
/*  55 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final String hget(String key, String field) {
/*  60 */     Jedis redis = getRedis();
/*     */     try {
/*  62 */       return redis.hget(key, field);
/*     */     } finally {
/*  64 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final long hset(String key, String field, String value) {
/*  69 */     Jedis redis = getRedis();
/*     */     try {
/*  71 */       return redis.hset(key, field, value).longValue();
/*     */     } finally {
/*  73 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final String put(String key, String value) {
/*  78 */     Jedis redis = getRedis();
/*     */     try {
/*  80 */       return redis.set(key, value);
/*     */     } finally {
/*  82 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final String put(String key, String value, int expired) {
/*  87 */     Jedis redis = getRedis();
/*     */     try {
/*  89 */       return redis.setex(key, expired, value);
/*     */     } finally {
/*  91 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final long remove(String key) {
/*  96 */     Jedis redis = getRedis();
/*     */     try {
/*  98 */       return redis.del(key).longValue();
/*     */     } finally {
/* 100 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final long hremove(String key, String field) {
/* 105 */     Jedis redis = getRedis();
/*     */     try {
/* 107 */       return redis.hdel(key, new String[] { field }).longValue();
/*     */     } finally {
/* 109 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final boolean exists(String key) {
/* 114 */     Jedis redis = getRedis();
/*     */     try {
/* 116 */       return redis.exists(key).booleanValue();
/*     */     } finally {
/* 118 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final boolean hexists(String key, String field) {
/* 123 */     Jedis redis = getRedis();
/*     */     try {
/* 125 */       return redis.hexists(key, field).booleanValue();
/*     */     } finally {
/* 127 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final Set<String> hkeys(String key) {
/* 132 */     Jedis jedis = getRedis();
/*     */     try {
/* 134 */       return jedis.hkeys(key);
/*     */     } finally {
/* 136 */       release(jedis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final List<String> hvals(String key) {
/* 141 */     Jedis jedis = getRedis();
/*     */     try {
/* 143 */       return jedis.hvals(key);
/*     */     } finally {
/* 145 */       release(jedis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final Map<String, String> hgetAll(String key) {
/* 150 */     Jedis redis = getRedis();
/*     */     try {
/* 152 */       return redis.hgetAll(key);
/*     */     } finally {
/* 154 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final long expire(String key, int sec) {
/* 159 */     Jedis redis = getRedis();
/*     */     try {
/* 161 */       return redis.expire(key, sec).longValue();
/*     */     } finally {
/* 163 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final String rename(String oldKey, String newKey) {
/* 168 */     Jedis redis = getRedis();
/*     */     try {
/* 170 */       return redis.rename(oldKey, newKey);
/*     */     } finally {
/* 172 */       release(redis);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static final void release(Jedis redis) {
/* 179 */     redis.close();
/*     */   }
/*     */   
/*     */   public static final void publish(JSONObject json) {
/* 183 */     Jedis redis = getRedis();
/*     */     try {
/* 185 */       redis.publish("/server/login", json.toJSONString());
/*     */     } finally {
/* 187 */       release(redis);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\core\login\AuthServer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */