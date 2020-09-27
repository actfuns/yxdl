/*     */ package com.wanniu.core.redis;
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
/*     */ import redis.clients.util.SafeEncoder;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GCache
/*     */ {
/*     */   private static JedisPool RedisPool;
/*     */   
/*     */   static {
/*  24 */     JedisPoolConfig config = new JedisPoolConfig();
/*     */     
/*  26 */     config.setTestOnBorrow(GConfig.getInstance().getBoolean("server.redis.testonborrow", true));
/*     */     
/*  28 */     config.setTestOnReturn(GConfig.getInstance().getBoolean("server.redis.testonreturn", true));
/*  29 */     config.setMaxIdle(GConfig.getInstance().getInt("server.redis.maxidle", 20));
/*  30 */     config.setMaxWaitMillis(GConfig.getInstance().getInt("server.redis.maxwait", 1000));
/*  31 */     config.setMaxTotal(GConfig.getInstance().getInt("server.redis.total", 5));
/*     */     
/*  33 */     String redisHost = GConfig.getInstance().get("server.redis.host", "127.0.0.1");
/*  34 */     int redisPort = GConfig.getInstance().getInt("server.redis.port", 6379);
/*  35 */     String pwd = GConfig.getInstance().get("server.redis.password");
/*  36 */     int db = GConfig.getInstance().getInt("server.redis.db", 0);
/*  37 */     RedisPool = new JedisPool((GenericObjectPoolConfig)config, redisHost, redisPort, 2000, (pwd != null) ? pwd.trim() : null, db);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static final Jedis getRedis() {
/*  43 */     return RedisPool.getResource();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final byte[] encode(String utf) {
/*  50 */     return SafeEncoder.encode(utf);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final String decode(byte[] body) {
/*  57 */     if (body == null || body.length == 0)
/*  58 */       return null; 
/*  59 */     return SafeEncoder.encode(body);
/*     */   }
/*     */   
/*     */   public static final String get(String key) {
/*  63 */     Jedis redis = getRedis();
/*     */     try {
/*  65 */       return redis.get(key);
/*     */     } finally {
/*  67 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final byte[] get(byte[] key) {
/*  72 */     Jedis redis = getRedis();
/*     */     try {
/*  74 */       return redis.get(key);
/*     */     } finally {
/*  76 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final String hget(String key, String field) {
/*  81 */     Jedis redis = getRedis();
/*     */     try {
/*  83 */       return redis.hget(key, field);
/*     */     } finally {
/*  85 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final byte[] hget(String key, byte[] field) {
/*  90 */     Jedis redis = getRedis();
/*     */     try {
/*  92 */       return redis.hget(encode(key), field);
/*     */     } finally {
/*  94 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final long hset(String key, String field, String value) {
/*  99 */     Jedis redis = getRedis();
/*     */     try {
/* 101 */       return redis.hset(key, field, value).longValue();
/*     */     } finally {
/* 103 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final long hset(String key, String field, byte[] value) {
/* 108 */     Jedis redis = getRedis();
/*     */     try {
/* 110 */       return redis.hset(encode(key), encode(field), value).longValue();
/*     */     } finally {
/* 112 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final String put(String key, String value) {
/* 117 */     Jedis redis = getRedis();
/*     */     try {
/* 119 */       return redis.set(key, value);
/*     */     } finally {
/* 121 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final String put(String key, byte[] value) {
/* 126 */     Jedis redis = getRedis();
/*     */     try {
/* 128 */       return redis.set(encode(key), value);
/*     */     } finally {
/* 130 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final String put(String key, String value, int expired) {
/* 135 */     Jedis redis = getRedis();
/*     */     try {
/* 137 */       return redis.setex(key, expired, value);
/*     */     } finally {
/* 139 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final String put(String key, byte[] value, int expired) {
/* 144 */     Jedis redis = getRedis();
/*     */     try {
/* 146 */       return redis.setex(encode(key), expired, value);
/*     */     } finally {
/* 148 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final long remove(String key) {
/* 153 */     Jedis redis = getRedis();
/*     */     try {
/* 155 */       return redis.del(key).longValue();
/*     */     } finally {
/* 157 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final long remove(byte[] key) {
/* 162 */     Jedis redis = getRedis();
/*     */     try {
/* 164 */       return redis.del(key).longValue();
/*     */     } finally {
/* 166 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final long hremove(String key, String field) {
/* 171 */     Jedis redis = getRedis();
/*     */     try {
/* 173 */       return redis.hdel(key, new String[] { field }).longValue();
/*     */     } finally {
/* 175 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final long hremove(String key, byte[] field) {
/* 180 */     Jedis redis = getRedis();
/*     */     try {
/* 182 */       return redis.hdel(encode(key), new byte[][] { field }).longValue();
/*     */     } finally {
/* 184 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final boolean exists(String key) {
/* 189 */     Jedis redis = getRedis();
/*     */     try {
/* 191 */       return redis.exists(key).booleanValue();
/*     */     } finally {
/* 193 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final boolean exists(byte[] key) {
/* 198 */     Jedis redis = getRedis();
/*     */     try {
/* 200 */       return redis.exists(key).booleanValue();
/*     */     } finally {
/* 202 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final boolean hexists(String key, String field) {
/* 207 */     Jedis redis = getRedis();
/*     */     try {
/* 209 */       return redis.hexists(key, field).booleanValue();
/*     */     } finally {
/* 211 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final boolean hexists(String key, byte[] field) {
/* 216 */     Jedis redis = getRedis();
/*     */     try {
/* 218 */       return redis.hexists(encode(key), field).booleanValue();
/*     */     } finally {
/* 220 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final Set<String> hkeys(String key) {
/* 225 */     Jedis jedis = getRedis();
/*     */     try {
/* 227 */       return jedis.hkeys(key);
/*     */     } finally {
/* 229 */       release(jedis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final List<String> hvals(String key) {
/* 234 */     Jedis jedis = getRedis();
/*     */     try {
/* 236 */       return jedis.hvals(key);
/*     */     } finally {
/* 238 */       release(jedis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final Map<String, String> hgetAll(String key) {
/* 243 */     Jedis redis = getRedis();
/*     */     try {
/* 245 */       return redis.hgetAll(key);
/*     */     } finally {
/* 247 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final long expire(String key, int sec) {
/* 252 */     Jedis redis = getRedis();
/*     */     try {
/* 254 */       return redis.expire(key, sec).longValue();
/*     */     } finally {
/* 256 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final long expire(byte[] key, int sec) {
/* 261 */     Jedis redis = getRedis();
/*     */     try {
/* 263 */       return redis.expire(key, sec).longValue();
/*     */     } finally {
/* 265 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final String rename(String oldKey, String newKey) {
/* 270 */     Jedis redis = getRedis();
/*     */     try {
/* 272 */       return redis.rename(oldKey, newKey);
/*     */     } finally {
/* 274 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final String rename(byte[] oldKey, byte[] newKey) {
/* 279 */     Jedis redis = getRedis();
/*     */     try {
/* 281 */       return redis.rename(oldKey, newKey);
/*     */     } finally {
/* 283 */       release(redis);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static final void release(Jedis jedis) {
/* 289 */     jedis.close();
/*     */   }
/*     */   
/*     */   public static final void destroy() {
/* 293 */     if (RedisPool != null) {
/* 294 */       RedisPool.destroy();
/* 295 */       RedisPool = null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final void publish(JSONObject json) {
/* 300 */     Jedis redis = getRedis();
/* 301 */     redis.publish("/server/login", json.toJSONString());
/* 302 */     release(redis);
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-login\xmds-login.jar!\com\wanniu\core\redis\GCache.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */