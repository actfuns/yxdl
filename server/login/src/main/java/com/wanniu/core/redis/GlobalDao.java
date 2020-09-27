/*     */ package com.wanniu.core.redis;
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
/*     */   
/*     */   public static final Jedis getRedis() {
/*  42 */     return RedisPool.getResource();
/*     */   }
/*     */   
/*     */   public static final void release(Jedis redis) {
/*  46 */     if (redis != null) {
/*  47 */       redis.close();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final byte[] encode(String utf) {
/*  55 */     return SafeEncoder.encode(utf);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final String decode(byte[] body) {
/*  62 */     if (body == null || body.length == 0)
/*  63 */       return null; 
/*  64 */     return SafeEncoder.encode(body);
/*     */   }
/*     */   
/*     */   public static final String get(String key) {
/*  68 */     Jedis redis = getRedis();
/*     */     try {
/*  70 */       return redis.get(key);
/*     */     } finally {
/*  72 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final byte[] get(byte[] key) {
/*  77 */     Jedis redis = getRedis();
/*     */     try {
/*  79 */       return redis.get(key);
/*     */     } finally {
/*  81 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final String hget(String key, String field) {
/*  86 */     Jedis redis = getRedis();
/*     */     try {
/*  88 */       return redis.hget(key, field);
/*     */     } finally {
/*  90 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final byte[] hget(String key, byte[] field) {
/*  95 */     Jedis redis = getRedis();
/*     */     try {
/*  97 */       return redis.hget(encode(key), field);
/*     */     } finally {
/*  99 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final long hset(String key, String field, String value) {
/* 104 */     Jedis redis = getRedis();
/*     */     try {
/* 106 */       return redis.hset(key, field, value).longValue();
/*     */     } finally {
/* 108 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final long hset(String key, String field, byte[] value) {
/* 113 */     Jedis redis = getRedis();
/*     */     try {
/* 115 */       return redis.hset(encode(key), encode(field), value).longValue();
/*     */     } finally {
/* 117 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final String put(String key, String value) {
/* 122 */     Jedis redis = getRedis();
/*     */     try {
/* 124 */       return redis.set(key, value);
/*     */     } finally {
/* 126 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final String put(String key, byte[] value) {
/* 131 */     Jedis redis = getRedis();
/*     */     try {
/* 133 */       return redis.set(encode(key), value);
/*     */     } finally {
/* 135 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final String put(String key, String value, int expired) {
/* 140 */     Jedis redis = getRedis();
/*     */     try {
/* 142 */       return redis.setex(key, expired, value);
/*     */     } finally {
/* 144 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final String put(String key, byte[] value, int expired) {
/* 149 */     Jedis redis = getRedis();
/*     */     try {
/* 151 */       return redis.setex(encode(key), expired, value);
/*     */     } finally {
/* 153 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final long remove(String key) {
/* 158 */     Jedis redis = getRedis();
/*     */     try {
/* 160 */       return redis.del(key).longValue();
/*     */     } finally {
/* 162 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final long remove(byte[] key) {
/* 167 */     Jedis redis = getRedis();
/*     */     try {
/* 169 */       return redis.del(key).longValue();
/*     */     } finally {
/* 171 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final long hremove(String key, String field) {
/* 176 */     Jedis redis = getRedis();
/*     */     try {
/* 178 */       return redis.hdel(key, new String[] { field }).longValue();
/*     */     } finally {
/* 180 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final long hremove(String key, byte[] field) {
/* 185 */     Jedis redis = getRedis();
/*     */     try {
/* 187 */       return redis.hdel(encode(key), new byte[][] { field }).longValue();
/*     */     } finally {
/* 189 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final boolean exists(String key) {
/* 194 */     Jedis redis = getRedis();
/*     */     try {
/* 196 */       return redis.exists(key).booleanValue();
/*     */     } finally {
/* 198 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final boolean exists(byte[] key) {
/* 203 */     Jedis redis = getRedis();
/*     */     try {
/* 205 */       return redis.exists(key).booleanValue();
/*     */     } finally {
/* 207 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final boolean hexists(String key, String field) {
/* 212 */     Jedis redis = getRedis();
/*     */     try {
/* 214 */       return redis.hexists(key, field).booleanValue();
/*     */     } finally {
/* 216 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final boolean hexists(String key, byte[] field) {
/* 221 */     Jedis redis = getRedis();
/*     */     try {
/* 223 */       return redis.hexists(encode(key), field).booleanValue();
/*     */     } finally {
/* 225 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final Set<String> hkeys(String key) {
/* 230 */     Jedis jedis = getRedis();
/*     */     try {
/* 232 */       return jedis.hkeys(key);
/*     */     } finally {
/* 234 */       release(jedis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final List<String> hvals(String key) {
/* 239 */     Jedis jedis = getRedis();
/*     */     try {
/* 241 */       return jedis.hvals(key);
/*     */     } finally {
/* 243 */       release(jedis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final Map<String, String> hgetAll(String key) {
/* 248 */     Jedis redis = getRedis();
/*     */     try {
/* 250 */       return redis.hgetAll(key);
/*     */     } finally {
/* 252 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final long expire(String key, int sec) {
/* 257 */     Jedis redis = getRedis();
/*     */     try {
/* 259 */       return redis.expire(key, sec).longValue();
/*     */     } finally {
/* 261 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final long expire(byte[] key, int sec) {
/* 266 */     Jedis redis = getRedis();
/*     */     try {
/* 268 */       return redis.expire(key, sec).longValue();
/*     */     } finally {
/* 270 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final String rename(String oldKey, String newKey) {
/* 275 */     Jedis redis = getRedis();
/*     */     try {
/* 277 */       return redis.rename(oldKey, newKey);
/*     */     } finally {
/* 279 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final String rename(byte[] oldKey, byte[] newKey) {
/* 284 */     Jedis redis = getRedis();
/*     */     try {
/* 286 */       return redis.rename(oldKey, newKey);
/*     */     } finally {
/* 288 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final void destroy() {
/* 293 */     if (RedisPool != null) {
/* 294 */       RedisPool.destroy();
/* 295 */       RedisPool = null;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-login\xmds-login.jar!\com\wanniu\core\redis\GlobalDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */