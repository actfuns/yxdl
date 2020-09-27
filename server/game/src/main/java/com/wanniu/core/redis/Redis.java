/*     */ package com.wanniu.core.redis;
/*     */ 
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
/*     */ import redis.clients.jedis.Jedis;
/*     */ import redis.clients.jedis.JedisPool;
/*     */ import redis.clients.jedis.JedisPubSub;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Redis
/*     */ {
/*     */   public static final int DEFAULT_TIMEOUT = 5000;
/*     */   public static final int DEFAULT_DATABASE = 0;
/*     */   private JedisPool pool;
/*     */   
/*     */   public Redis(String host, int port) {
/*  20 */     this(host, port, 0);
/*     */   }
/*     */   
/*     */   public Redis(String host, int port, int database) {
/*  24 */     this(host, port, 5000, null, database);
/*     */   }
/*     */   
/*     */   public Redis(String host, int port, String password) {
/*  28 */     this(host, port, 5000, password, 0);
/*     */   }
/*     */   
/*     */   public Redis(String host, int port, String password, int dbIndex) {
/*  32 */     this(host, port, 5000, password, dbIndex);
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
/*     */   public Redis(String host, int port, int timeout, String password, int index) {
/*  44 */     this(8, host, port, timeout, password, index);
/*     */   }
/*     */ 
/*     */   
/*     */   public Redis(int connection, String host, int port, int timeout, String password, int database) {
/*  49 */     GenericObjectPoolConfig config = new GenericObjectPoolConfig();
/*  50 */     config.setMaxTotal(connection);
/*  51 */     config.setMaxIdle(connection);
/*  52 */     this.pool = new JedisPool(config, host, port, timeout, password, database);
/*  53 */     Out.info(new Object[] { "Redis 连接信息:host=", host, ",port=", Integer.valueOf(port), ",database=", Integer.valueOf(database), ",timeout=", Integer.valueOf(timeout), "ms,password=", password });
/*  54 */     ping();
/*     */   }
/*     */   
/*     */   public void ping() {
/*  58 */     try (Jedis j = this.pool.getResource()) {
/*  59 */       String ret = j.ping();
/*  60 */       if (ret.equals("PONG")) {
/*  61 */         Out.info(new Object[] { "Redis服务器连接正常" });
/*     */       } else {
/*  63 */         Out.error(new Object[] { "Redis服务器连接异常" });
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void del(String key) {
/*  69 */     try (Jedis j = this.pool.getResource()) {
/*  70 */       j.del(key);
/*     */     } 
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
/*     */   public long publish(String channel, String message) {
/*  83 */     try (Jedis j = this.pool.getResource()) {
/*  84 */       long ret = j.publish(channel, message).longValue();
/*  85 */       return ret;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void subscribe(JedisPubSub jedisPubSub, String... channel) {
/*  96 */     try (Jedis j = this.pool.getResource()) {
/*  97 */       j.subscribe(jedisPubSub, channel);
/*     */     } 
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
/*     */   public void psubscribe(JedisPubSub jedisPubSub, String... channel) {
/* 111 */     try (Jedis j = this.pool.getResource()) {
/* 112 */       j.psubscribe(jedisPubSub, channel);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long dbSize() {
/* 122 */     try (Jedis j = this.pool.getResource()) {
/* 123 */       long ret = j.dbSize().longValue();
/* 124 */       return ret;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String quit() {
/* 130 */     try (Jedis j = this.pool.getResource()) {
/* 131 */       String ret = j.quit();
/* 132 */       return ret;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void destory() {
/* 137 */     this.pool.destroy();
/*     */   }
/*     */   
/*     */   public void close() {
/* 141 */     this.pool.close();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Jedis getJedis() {
/* 150 */     return this.pool.getResource();
/*     */   }
/*     */   
/*     */   public JedisPool getPool() {
/* 154 */     return this.pool;
/*     */   }
/*     */   
/*     */   public void setPool(JedisPool pool) {
/* 158 */     this.pool = pool;
/*     */   }
/*     */   
/*     */   public String get(String key) {
/* 162 */     try (Jedis j = this.pool.getResource()) {
/* 163 */       return j.get(key);
/*     */     } 
/*     */   }
/*     */   
/*     */   public String get(String key, String defaullt) {
/* 168 */     try (Jedis j = this.pool.getResource()) {
/* 169 */       String s = j.get(key);
/* 170 */       if (s == null) {
/* 171 */         return defaullt;
/*     */       }
/* 173 */       return s;
/*     */     } 
/*     */   }
/*     */   
/*     */   public int scard(String key) {
/* 178 */     try (Jedis j = this.pool.getResource()) {
/* 179 */       Long value = j.scard(key);
/* 180 */       return (value == null) ? 0 : value.intValue();
/*     */     } 
/*     */   }
/*     */   
/*     */   public Long scardx(String key) {
/* 185 */     try (Jedis j = this.pool.getResource()) {
/* 186 */       return j.scard(key);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void sadd(String key, String... members) {
/* 191 */     try (Jedis j = this.pool.getResource()) {
/* 192 */       j.sadd(key, members);
/*     */     } 
/*     */   }
/*     */   
/*     */   public Boolean sismember(String key, String member) {
/* 197 */     try (Jedis j = this.pool.getResource()) {
/* 198 */       return j.sismember(key, member);
/*     */     } 
/*     */   }
/*     */   
/*     */   public Long hincrBy(String key, String field, long value) {
/* 203 */     try (Jedis j = this.pool.getResource()) {
/* 204 */       return j.hincrBy(key, field, value);
/*     */     } 
/*     */   }
/*     */   
/*     */   public Map<String, String> hgetAll(String key) {
/* 209 */     try (Jedis j = this.pool.getResource()) {
/* 210 */       return j.hgetAll(key);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void hset(String key, String field, String value) {
/* 215 */     try (Jedis j = this.pool.getResource()) {
/* 216 */       j.hset(key, field, value);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void hmset(String key, Map<String, String> hash) {
/* 221 */     try (Jedis j = this.pool.getResource()) {
/* 222 */       j.hmset(key, hash);
/*     */     } 
/*     */   }
/*     */   
/*     */   public Long hdel(String key, String... fields) {
/* 227 */     try (Jedis j = this.pool.getResource()) {
/* 228 */       return j.hdel(key, fields);
/*     */     } 
/*     */   }
/*     */   
/*     */   public Object eval(String script) {
/* 233 */     try (Jedis j = this.pool.getResource()) {
/* 234 */       return j.eval(script);
/*     */     } 
/*     */   }
/*     */   
/*     */   public Set<String> smembers(String key) {
/* 239 */     try (Jedis j = this.pool.getResource()) {
/* 240 */       return j.smembers(key);
/*     */     } 
/*     */   }
/*     */   
/*     */   public Boolean hexists(String key, String field) {
/* 245 */     try (Jedis j = this.pool.getResource()) {
/* 246 */       return j.hexists(key, field);
/*     */     } 
/*     */   }
/*     */   
/*     */   public Long hsetnx(String key, String field, String value) {
/* 251 */     try (Jedis j = this.pool.getResource()) {
/* 252 */       return j.hsetnx(key, field, value);
/*     */     } 
/*     */   }
/*     */   
/*     */   public String hget(String key, String field) {
/* 257 */     try (Jedis j = this.pool.getResource()) {
/* 258 */       return j.hget(key, field);
/*     */     } 
/*     */   }
/*     */   
/*     */   public String save() {
/* 263 */     try (Jedis j = this.pool.getResource()) {
/* 264 */       return j.save();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\core\redis\Redis.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */