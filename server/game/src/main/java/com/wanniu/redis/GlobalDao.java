/*     */ package com.wanniu.redis;
/*     */ 
/*     */ import com.wanniu.core.GConfig;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
/*     */ import redis.clients.jedis.Jedis;
/*     */ import redis.clients.jedis.JedisPool;
/*     */ import redis.clients.jedis.JedisPoolConfig;
/*     */ import redis.clients.util.SafeEncoder;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GlobalDao
/*     */ {
/*     */   private static JedisPool RedisPool;
/*     */   
/*     */   static {
/*  21 */     JedisPoolConfig config = new JedisPoolConfig();
/*     */     
/*  23 */     config.setTestOnBorrow(GConfig.getInstance().getBoolean("global.redis.testonborrow", true));
/*     */     
/*  25 */     config.setTestOnReturn(GConfig.getInstance().getBoolean("global.redis.testonreturn", true));
/*  26 */     config.setMaxIdle(GConfig.getInstance().getInt("global.redis.maxidle", 20));
/*  27 */     config.setMaxWaitMillis(GConfig.getInstance().getInt("global.redis.maxwait", 1000));
/*  28 */     config.setMaxTotal(GConfig.getInstance().getInt("global.redis.total", 5));
/*     */     
/*  30 */     String redisHost = GConfig.getInstance().get("global.redis.host", GConfig.getInstance().get("server.redis.host", "127.0.0.1"));
/*  31 */     int redisPort = GConfig.getInstance().getInt("global.redis.port", GConfig.getInstance().getInt("server.redis.port", 6379));
/*  32 */     String pwd = GConfig.getInstance().get("global.redis.password", GConfig.getInstance().get("server.redis.password"));
/*  33 */     int db = GConfig.getInstance().getInt("global.redis.db", 1);
/*     */     
/*  35 */     RedisPool = new JedisPool((GenericObjectPoolConfig)config, redisHost, redisPort, 2000, (pwd != null) ? pwd.trim() : null, db);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static final Jedis getRedis() {
/*  41 */     return RedisPool.getResource();
/*     */   }
/*     */   
/*     */   public static final void release(Jedis redis) {
/*  45 */     if (redis != null) {
/*  46 */       redis.close();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final byte[] encode(String utf) {
/*  54 */     return SafeEncoder.encode(utf);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final String decode(byte[] body) {
/*  61 */     if (body == null || body.length == 0)
/*  62 */       return null; 
/*  63 */     return SafeEncoder.encode(body);
/*     */   }
/*     */   
/*     */   public static final String get(String key) {
/*  67 */     Jedis redis = getRedis();
/*     */     try {
/*  69 */       return redis.get(key);
/*     */     } finally {
/*  71 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final byte[] get(byte[] key) {
/*  76 */     Jedis redis = getRedis();
/*     */     try {
/*  78 */       return redis.get(key);
/*     */     } finally {
/*  80 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final String hget(String key, String field) {
/*  85 */     Jedis redis = getRedis();
/*     */     try {
/*  87 */       return redis.hget(key, field);
/*     */     } finally {
/*  89 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final byte[] hget(String key, byte[] field) {
/*  94 */     Jedis redis = getRedis();
/*     */     try {
/*  96 */       return redis.hget(encode(key), field);
/*     */     } finally {
/*  98 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final long hset(String key, String field, String value) {
/* 103 */     Jedis redis = getRedis();
/*     */     try {
/* 105 */       return redis.hset(key, field, value).longValue();
/*     */     } finally {
/* 107 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final long hsetnx(String key, String field, String value) {
/* 112 */     Jedis redis = getRedis();
/*     */     try {
/* 114 */       return redis.hsetnx(key, field, value).longValue();
/*     */     } finally {
/* 116 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final long setnx(String key, String value) {
/* 121 */     Jedis redis = getRedis();
/*     */     try {
/* 123 */       return redis.setnx(key, value).longValue();
/*     */     } finally {
/* 125 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final long hset(String key, String field, byte[] value) {
/* 130 */     Jedis redis = getRedis();
/*     */     try {
/* 132 */       return redis.hset(encode(key), encode(field), value).longValue();
/*     */     } finally {
/* 134 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final String put(String key, String value) {
/* 139 */     Jedis redis = getRedis();
/*     */     try {
/* 141 */       return redis.set(key, value);
/*     */     } finally {
/* 143 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final String put(String key, byte[] value) {
/* 148 */     Jedis redis = getRedis();
/*     */     try {
/* 150 */       return redis.set(encode(key), value);
/*     */     } finally {
/* 152 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final String put(String key, String value, int expired) {
/* 157 */     Jedis redis = getRedis();
/*     */     try {
/* 159 */       return redis.setex(key, expired, value);
/*     */     } finally {
/* 161 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final String put(String key, byte[] value, int expired) {
/* 166 */     Jedis redis = getRedis();
/*     */     try {
/* 168 */       return redis.setex(encode(key), expired, value);
/*     */     } finally {
/* 170 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final long remove(String key) {
/* 175 */     Jedis redis = getRedis();
/*     */     try {
/* 177 */       return redis.del(key).longValue();
/*     */     } finally {
/* 179 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final long remove(byte[] key) {
/* 184 */     Jedis redis = getRedis();
/*     */     try {
/* 186 */       return redis.del(key).longValue();
/*     */     } finally {
/* 188 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final long hremove(String key, String field) {
/* 193 */     Jedis redis = getRedis();
/*     */     try {
/* 195 */       return redis.hdel(key, new String[] { field }).longValue();
/*     */     } finally {
/* 197 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final long hremove(String key, byte[] field) {
/* 202 */     Jedis redis = getRedis();
/*     */     try {
/* 204 */       return redis.hdel(encode(key), new byte[][] { field }).longValue();
/*     */     } finally {
/* 206 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final boolean exists(String key) {
/* 211 */     Jedis redis = getRedis();
/*     */     try {
/* 213 */       return redis.exists(key).booleanValue();
/*     */     } finally {
/* 215 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final boolean exists(byte[] key) {
/* 220 */     Jedis redis = getRedis();
/*     */     try {
/* 222 */       return redis.exists(key).booleanValue();
/*     */     } finally {
/* 224 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final boolean hexists(String key, String field) {
/* 229 */     Jedis redis = getRedis();
/*     */     try {
/* 231 */       return redis.hexists(key, field).booleanValue();
/*     */     } finally {
/* 233 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final boolean hexists(String key, byte[] field) {
/* 238 */     Jedis redis = getRedis();
/*     */     try {
/* 240 */       return redis.hexists(encode(key), field).booleanValue();
/*     */     } finally {
/* 242 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final Set<String> hkeys(String key) {
/* 247 */     Jedis jedis = getRedis();
/*     */     try {
/* 249 */       return jedis.hkeys(key);
/*     */     } finally {
/* 251 */       release(jedis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final List<String> hvals(String key) {
/* 256 */     Jedis jedis = getRedis();
/*     */     try {
/* 258 */       return jedis.hvals(key);
/*     */     } finally {
/* 260 */       release(jedis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final Map<String, String> hgetAll(String key) {
/* 265 */     Jedis redis = getRedis();
/*     */     try {
/* 267 */       return redis.hgetAll(key);
/*     */     } finally {
/* 269 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final long expire(String key, int sec) {
/* 274 */     Jedis redis = getRedis();
/*     */     try {
/* 276 */       return redis.expire(key, sec).longValue();
/*     */     } finally {
/* 278 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final long expire(byte[] key, int sec) {
/* 283 */     Jedis redis = getRedis();
/*     */     try {
/* 285 */       return redis.expire(key, sec).longValue();
/*     */     } finally {
/* 287 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final String rename(String oldKey, String newKey) {
/* 292 */     Jedis redis = getRedis();
/*     */     try {
/* 294 */       return redis.rename(oldKey, newKey);
/*     */     } finally {
/* 296 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final String rename(byte[] oldKey, byte[] newKey) {
/* 301 */     Jedis redis = getRedis();
/*     */     try {
/* 303 */       return redis.rename(oldKey, newKey);
/*     */     } finally {
/* 305 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final long incr(String key) {
/* 310 */     Jedis redis = getRedis();
/*     */     try {
/* 312 */       return redis.incr(key).longValue();
/*     */     } finally {
/* 314 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final void destroy() {
/* 319 */     if (RedisPool != null) {
/* 320 */       RedisPool.destroy();
/* 321 */       RedisPool = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final void publish(String channel, String message) {
/* 329 */     try (Jedis redis = getRedis()) {
/* 330 */       redis.publish(channel, message);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\redis\GlobalDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */