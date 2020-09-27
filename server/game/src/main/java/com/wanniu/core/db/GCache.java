/*     */ package com.wanniu.core.db;
/*     */ 
/*     */ import com.wanniu.core.GConfig;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
/*     */ import redis.clients.jedis.Jedis;
/*     */ import redis.clients.jedis.JedisPool;
/*     */ import redis.clients.jedis.JedisPoolConfig;
/*     */ import redis.clients.jedis.Tuple;
/*     */ import redis.clients.util.SafeEncoder;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GCache
/*     */ {
/*  23 */   private static int REDIS_CONN_COUTN = GConfig.getInstance().getInt("server.redis.total", 5);
/*     */   private static JedisPool RedisPool;
/*     */   
/*     */   static {
/*  27 */     JedisPoolConfig config = new JedisPoolConfig();
/*     */     
/*  29 */     config.setTestOnBorrow(GConfig.getInstance().getBoolean("server.redis.testonborrow", true));
/*     */     
/*  31 */     config.setTestOnReturn(GConfig.getInstance().getBoolean("server.redis.testonreturn", true));
/*  32 */     config.setMaxIdle(GConfig.getInstance().getInt("server.redis.maxidle", 20));
/*  33 */     config.setMaxWaitMillis(GConfig.getInstance().getInt("server.redis.maxwait", 1000));
/*  34 */     config.setMaxTotal(REDIS_CONN_COUTN);
/*     */     
/*  36 */     String redisHost = GConfig.getInstance().get("server.redis.host", "127.0.0.1");
/*  37 */     int redisPort = GConfig.getInstance().getInt("server.redis.port", 6379);
/*  38 */     String pwd = GConfig.getInstance().get("server.redis.password");
/*  39 */     int db = GConfig.getInstance().getInt("server.redis.db", 0);
/*  40 */     int timeout = GConfig.getInstance().getInt("server.redis.timeout", 2000);
/*  41 */     RedisPool = new JedisPool((GenericObjectPoolConfig)config, redisHost, redisPort, timeout, (pwd != null) ? pwd.trim() : null, db);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final Jedis getRedis() {
/*  75 */     return RedisPool.getResource();
/*     */   }
/*     */ 
/*     */   
/*     */   public static final void release(Jedis redis) {
/*  80 */     if (redis != null) {
/*  81 */       redis.close();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final byte[] encode(String utf) {
/*  91 */     return SafeEncoder.encode(utf);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final String decode(byte[] body) {
/*  98 */     if (body == null || body.length == 0)
/*  99 */       return null; 
/* 100 */     return SafeEncoder.encode(body);
/*     */   }
/*     */   
/*     */   public static final String get(String key) {
/* 104 */     Jedis redis = getRedis();
/*     */     try {
/* 106 */       return redis.get(key);
/*     */     } finally {
/* 108 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final byte[] get(byte[] key) {
/* 113 */     Jedis redis = getRedis();
/*     */     try {
/* 115 */       return redis.get(key);
/*     */     } finally {
/* 117 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final String hget(String key, String field) {
/* 122 */     Jedis redis = getRedis();
/*     */     try {
/* 124 */       return redis.hget(key, field);
/*     */     } finally {
/* 126 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final long hincr(String key, String field, long v) {
/* 131 */     Jedis redis = getRedis();
/*     */     try {
/* 133 */       return redis.hincrBy(key, field, v).longValue();
/*     */     } finally {
/* 135 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final byte[] hget(String key, byte[] field) {
/* 140 */     Jedis redis = getRedis();
/*     */     try {
/* 142 */       return redis.hget(encode(key), field);
/*     */     } finally {
/* 144 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final long hset(String key, String field, String value) {
/* 149 */     Jedis redis = getRedis();
/*     */     try {
/* 151 */       return redis.hset(key, field, value).longValue();
/*     */     } finally {
/* 153 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final long hset(String key, String field, byte[] value) {
/* 158 */     Jedis redis = getRedis();
/*     */     try {
/* 160 */       return redis.hset(encode(key), encode(field), value).longValue();
/*     */     } finally {
/* 162 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final String put(String key, String value) {
/* 167 */     Jedis redis = getRedis();
/*     */     try {
/* 169 */       return redis.set(key, value);
/*     */     } finally {
/* 171 */       release(redis);
/*     */     } 
/*     */   }
/*     */   public static final long push(String key, String value) {
/* 175 */     Jedis redis = getRedis();
/*     */     try {
/* 177 */       return redis.lpush(key, new String[] { value }).longValue();
/*     */     } finally {
/* 179 */       release(redis);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static final String put(String key, byte[] value) {
/* 185 */     Jedis redis = getRedis();
/*     */     try {
/* 187 */       return redis.set(encode(key), value);
/*     */     } finally {
/* 189 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final String put(String key, String value, int expired) {
/* 194 */     Jedis redis = getRedis();
/*     */     try {
/* 196 */       return redis.setex(key, expired, value);
/*     */     } finally {
/* 198 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final String put(String key, byte[] value, int expired) {
/* 203 */     Jedis redis = getRedis();
/*     */     try {
/* 205 */       return redis.setex(encode(key), expired, value);
/*     */     } finally {
/* 207 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final long remove(String key) {
/* 212 */     Jedis redis = getRedis();
/*     */     try {
/* 214 */       return redis.del(key).longValue();
/*     */     } finally {
/* 216 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final long remove(byte[] key) {
/* 221 */     Jedis redis = getRedis();
/*     */     try {
/* 223 */       return redis.del(key).longValue();
/*     */     } finally {
/* 225 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final long hremove(String key, String field) {
/* 230 */     Jedis redis = getRedis();
/*     */     try {
/* 232 */       return redis.hdel(key, new String[] { field }).longValue();
/*     */     } finally {
/* 234 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final long hremove(String key, byte[] field) {
/* 239 */     Jedis redis = getRedis();
/*     */     try {
/* 241 */       return redis.hdel(encode(key), new byte[][] { field }).longValue();
/*     */     } finally {
/* 243 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final boolean exists(String key) {
/* 248 */     Jedis redis = getRedis();
/*     */     try {
/* 250 */       return redis.exists(key).booleanValue();
/*     */     } finally {
/* 252 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final boolean exists(byte[] key) {
/* 257 */     Jedis redis = getRedis();
/*     */     try {
/* 259 */       return redis.exists(key).booleanValue();
/*     */     } finally {
/* 261 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final boolean hexists(String key, String field) {
/* 266 */     Jedis redis = getRedis();
/*     */     try {
/* 268 */       return redis.hexists(key, field).booleanValue();
/*     */     } finally {
/* 270 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final boolean hexists(String key, byte[] field) {
/* 275 */     Jedis redis = getRedis();
/*     */     try {
/* 277 */       return redis.hexists(encode(key), field).booleanValue();
/*     */     } finally {
/* 279 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final Set<String> hkeys(String key) {
/* 284 */     Jedis jedis = getRedis();
/*     */     try {
/* 286 */       return jedis.hkeys(key);
/*     */     } finally {
/* 288 */       release(jedis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final List<String> hvals(String key) {
/* 293 */     Jedis jedis = getRedis();
/*     */     try {
/* 295 */       return jedis.hvals(key);
/*     */     } finally {
/* 297 */       release(jedis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final Map<String, String> hgetAll(String key) {
/* 302 */     Jedis redis = getRedis();
/*     */     try {
/* 304 */       return redis.hgetAll(key);
/*     */     } finally {
/* 306 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final long expire(String key, int sec) {
/* 311 */     Jedis redis = getRedis();
/*     */     try {
/* 313 */       return redis.expire(key, sec).longValue();
/*     */     } finally {
/* 315 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final long expire(byte[] key, int sec) {
/* 320 */     Jedis redis = getRedis();
/*     */     try {
/* 322 */       return redis.expire(key, sec).longValue();
/*     */     } finally {
/* 324 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final String rename(String oldKey, String newKey) {
/* 329 */     Jedis redis = getRedis();
/*     */     try {
/* 331 */       return redis.rename(oldKey, newKey);
/*     */     } finally {
/* 333 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final String rename(byte[] oldKey, byte[] newKey) {
/* 338 */     Jedis redis = getRedis();
/*     */     try {
/* 340 */       return redis.rename(oldKey, newKey);
/*     */     } finally {
/* 342 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final String hmset(String key, Map<String, String> map) {
/* 347 */     Jedis redis = getRedis();
/*     */     try {
/* 349 */       return redis.hmset(key, map);
/*     */     } finally {
/* 351 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final Long zadd(String key, double score, String member) {
/* 356 */     try (Jedis redis = getRedis()) {
/* 357 */       return redis.zadd(key, score, member);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final Long zadd(String key, Map<String, Double> scoreMembers) {
/* 362 */     try (Jedis redis = getRedis()) {
/* 363 */       return redis.zadd(key, scoreMembers);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static Set<Tuple> zrevrangeWithScores(String key, long start, long end) {
/* 368 */     try (Jedis redis = getRedis()) {
/* 369 */       return redis.zrevrangeWithScores(key, start, end);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static Set<String> zrevrange(String key, long start, long end) {
/* 374 */     try (Jedis redis = getRedis()) {
/* 375 */       return redis.zrevrange(key, start, end);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static Long zrevrank(String key, String member) {
/* 380 */     try (Jedis redis = getRedis()) {
/* 381 */       return redis.zrevrank(key, member);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static Double zscore(String key, String member) {
/* 386 */     try (Jedis redis = getRedis()) {
/* 387 */       return redis.zscore(key, member);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static Long zrem(String key, String member) {
/* 392 */     try (Jedis redis = getRedis()) {
/* 393 */       return redis.zrem(key, new String[] { member });
/*     */     } 
/*     */   }
/*     */   
/*     */   public static Long del(String key) {
/* 398 */     try (Jedis redis = getRedis()) {
/* 399 */       return redis.del(key);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final long hsetnx(String key, String field, String value) {
/* 404 */     Jedis redis = getRedis();
/*     */     try {
/* 406 */       return redis.hsetnx(key, field, value).longValue();
/*     */     } finally {
/* 408 */       release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final void destroy() {
/* 413 */     if (RedisPool != null) {
/* 414 */       RedisPool.destroy();
/* 415 */       RedisPool = null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public static List<String> lRangeAll(String key) {
/* 420 */     Jedis redis = getRedis();
/* 421 */     long end = redis.llen(key).longValue();
/*     */     try {
/* 423 */       return redis.lrange(key, 0L, end);
/*     */     } finally {
/* 425 */       release(redis);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\core\db\GCache.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */