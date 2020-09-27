package com.wanniu.core.db;

import com.wanniu.core.GConfig;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Tuple;
import redis.clients.util.SafeEncoder;


public class GCache {
    private static int REDIS_CONN_COUTN = GConfig.getInstance().getInt("server.redis.total", 5);
    private static JedisPool RedisPool;

    static {
        JedisPoolConfig config = new JedisPoolConfig();

        config.setTestOnBorrow(GConfig.getInstance().getBoolean("server.redis.testonborrow", true));

        config.setTestOnReturn(GConfig.getInstance().getBoolean("server.redis.testonreturn", true));
        config.setMaxIdle(GConfig.getInstance().getInt("server.redis.maxidle", 20));
        config.setMaxWaitMillis(GConfig.getInstance().getInt("server.redis.maxwait", 1000));
        config.setMaxTotal(REDIS_CONN_COUTN);

        String redisHost = GConfig.getInstance().get("server.redis.host", "127.0.0.1");
        int redisPort = GConfig.getInstance().getInt("server.redis.port", 6379);
        String pwd = GConfig.getInstance().get("server.redis.password");
        int db = GConfig.getInstance().getInt("server.redis.db", 0);
        int timeout = GConfig.getInstance().getInt("server.redis.timeout", 2000);
        RedisPool = new JedisPool((GenericObjectPoolConfig) config, redisHost, redisPort, timeout, (pwd != null) ? pwd.trim() : null, db);
    }


    public static final Jedis getRedis() {
        return RedisPool.getResource();
    }


    public static final void release(Jedis redis) {
        if (redis != null) {
            redis.close();
        }
    }


    public static final byte[] encode(String utf) {
        return SafeEncoder.encode(utf);
    }


    public static final String decode(byte[] body) {
        if (body == null || body.length == 0)
            return null;
        return SafeEncoder.encode(body);
    }

    public static final String get(String key) {
        Jedis redis = getRedis();
        try {
            return redis.get(key);
        } finally {
            release(redis);
        }
    }

    public static final byte[] get(byte[] key) {
        Jedis redis = getRedis();
        try {
            return redis.get(key);
        } finally {
            release(redis);
        }
    }

    public static final String hget(String key, String field) {
        Jedis redis = getRedis();
        try {
            return redis.hget(key, field);
        } finally {
            release(redis);
        }
    }

    public static final long hincr(String key, String field, long v) {
        Jedis redis = getRedis();
        try {
            return redis.hincrBy(key, field, v).longValue();
        } finally {
            release(redis);
        }
    }

    public static final byte[] hget(String key, byte[] field) {
        Jedis redis = getRedis();
        try {
            return redis.hget(encode(key), field);
        } finally {
            release(redis);
        }
    }

    public static final long hset(String key, String field, String value) {
        Jedis redis = getRedis();
        try {
            return redis.hset(key, field, value).longValue();
        } finally {
            release(redis);
        }
    }

    public static final long hset(String key, String field, byte[] value) {
        Jedis redis = getRedis();
        try {
            return redis.hset(encode(key), encode(field), value).longValue();
        } finally {
            release(redis);
        }
    }

    public static final String put(String key, String value) {
        Jedis redis = getRedis();
        try {
            return redis.set(key, value);
        } finally {
            release(redis);
        }
    }

    public static final long push(String key, String value) {
        Jedis redis = getRedis();
        try {
            return redis.lpush(key, new String[]{value}).longValue();
        } finally {
            release(redis);
        }
    }


    public static final String put(String key, byte[] value) {
        Jedis redis = getRedis();
        try {
            return redis.set(encode(key), value);
        } finally {
            release(redis);
        }
    }

    public static final String put(String key, String value, int expired) {
        Jedis redis = getRedis();
        try {
            return redis.setex(key, expired, value);
        } finally {
            release(redis);
        }
    }

    public static final String put(String key, byte[] value, int expired) {
        Jedis redis = getRedis();
        try {
            return redis.setex(encode(key), expired, value);
        } finally {
            release(redis);
        }
    }

    public static final long remove(String key) {
        Jedis redis = getRedis();
        try {
            return redis.del(key).longValue();
        } finally {
            release(redis);
        }
    }

    public static final long remove(byte[] key) {
        Jedis redis = getRedis();
        try {
            return redis.del(key).longValue();
        } finally {
            release(redis);
        }
    }

    public static final long hremove(String key, String field) {
        Jedis redis = getRedis();
        try {
            return redis.hdel(key, new String[]{field}).longValue();
        } finally {
            release(redis);
        }
    }

    public static final long hremove(String key, byte[] field) {
        Jedis redis = getRedis();
        try {
            return redis.hdel(encode(key), new byte[][]{field}).longValue();
        } finally {
            release(redis);
        }
    }

    public static final boolean exists(String key) {
        Jedis redis = getRedis();
        try {
            return redis.exists(key).booleanValue();
        } finally {
            release(redis);
        }
    }

    public static final boolean exists(byte[] key) {
        Jedis redis = getRedis();
        try {
            return redis.exists(key).booleanValue();
        } finally {
            release(redis);
        }
    }

    public static final boolean hexists(String key, String field) {
        Jedis redis = getRedis();
        try {
            return redis.hexists(key, field).booleanValue();
        } finally {
            release(redis);
        }
    }

    public static final boolean hexists(String key, byte[] field) {
        Jedis redis = getRedis();
        try {
            return redis.hexists(encode(key), field).booleanValue();
        } finally {
            release(redis);
        }
    }

    public static final Set<String> hkeys(String key) {
        Jedis jedis = getRedis();
        try {
            return jedis.hkeys(key);
        } finally {
            release(jedis);
        }
    }

    public static final List<String> hvals(String key) {
        Jedis jedis = getRedis();
        try {
            return jedis.hvals(key);
        } finally {
            release(jedis);
        }
    }

    public static final Map<String, String> hgetAll(String key) {
        Jedis redis = getRedis();
        try {
            return redis.hgetAll(key);
        } finally {
            release(redis);
        }
    }

    public static final long expire(String key, int sec) {
        Jedis redis = getRedis();
        try {
            return redis.expire(key, sec).longValue();
        } finally {
            release(redis);
        }
    }

    public static final long expire(byte[] key, int sec) {
        Jedis redis = getRedis();
        try {
            return redis.expire(key, sec).longValue();
        } finally {
            release(redis);
        }
    }

    public static final String rename(String oldKey, String newKey) {
        Jedis redis = getRedis();
        try {
            return redis.rename(oldKey, newKey);
        } finally {
            release(redis);
        }
    }

    public static final String rename(byte[] oldKey, byte[] newKey) {
        Jedis redis = getRedis();
        try {
            return redis.rename(oldKey, newKey);
        } finally {
            release(redis);
        }
    }

    public static final String hmset(String key, Map<String, String> map) {
        Jedis redis = getRedis();
        try {
            return redis.hmset(key, map);
        } finally {
            release(redis);
        }
    }

    public static final Long zadd(String key, double score, String member) {
        try (Jedis redis = getRedis()) {
            return redis.zadd(key, score, member);
        }
    }

    public static final Long zadd(String key, Map<String, Double> scoreMembers) {
        try (Jedis redis = getRedis()) {
            return redis.zadd(key, scoreMembers);
        }
    }

    public static Set<Tuple> zrevrangeWithScores(String key, long start, long end) {
        try (Jedis redis = getRedis()) {
            return redis.zrevrangeWithScores(key, start, end);
        }
    }

    public static Set<String> zrevrange(String key, long start, long end) {
        try (Jedis redis = getRedis()) {
            return redis.zrevrange(key, start, end);
        }
    }

    public static Long zrevrank(String key, String member) {
        try (Jedis redis = getRedis()) {
            return redis.zrevrank(key, member);
        }
    }

    public static Double zscore(String key, String member) {
        try (Jedis redis = getRedis()) {
            return redis.zscore(key, member);
        }
    }

    public static Long zrem(String key, String member) {
        try (Jedis redis = getRedis()) {
            return redis.zrem(key, new String[]{member});
        }
    }

    public static Long del(String key) {
        try (Jedis redis = getRedis()) {
            return redis.del(key);
        }
    }

    public static final long hsetnx(String key, String field, String value) {
        Jedis redis = getRedis();
        try {
            return redis.hsetnx(key, field, value).longValue();
        } finally {
            release(redis);
        }
    }

    public static final void destroy() {
        if (RedisPool != null) {
            RedisPool.destroy();
            RedisPool = null;
        }
    }

    public static List<String> lRangeAll(String key) {
        Jedis redis = getRedis();
        long end = redis.llen(key).longValue();
        try {
            return redis.lrange(key, 0L, end);
        } finally {
            release(redis);
        }
    }
}


