package com.wanniu.core.login;

import com.alibaba.fastjson.JSONObject;
import com.wanniu.core.GConfig;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;


public class AuthServer {
    public static final String K_TOKEN = "/token/";
    public static final String K_PLAYER_SERVERS = "/player/servers/";
    private static JedisPool RedisPool;

    static {
        JedisPoolConfig config = new JedisPoolConfig();

        config.setTestOnBorrow(GConfig.getInstance().getBoolean("auth.redis.testonborrow", true));

        config.setTestOnReturn(GConfig.getInstance().getBoolean("auth.redis.testonreturn", true));
        config.setMaxIdle(GConfig.getInstance().getInt("auth.redis.maxidle", 20));
        config.setMaxWaitMillis(GConfig.getInstance().getInt("auth.redis.maxwait", 1000));
        config.setMaxTotal(GConfig.getInstance().getInt("auth.redis.total", 5));

        String redisHost = GConfig.getInstance().get("auth.redis.host", "127.0.0.1");
        int redisPort = GConfig.getInstance().getInt("auth.redis.port", 6379);
        String pwd = GConfig.getInstance().get("auth.redis.password");
        int db = GConfig.getInstance().getInt("auth.redis.db", 0);
        RedisPool = new JedisPool((GenericObjectPoolConfig) config, redisHost, redisPort, 2000, (pwd != null) ? pwd.trim() : null, db);
    }


    private static final Jedis getRedis() {
        return RedisPool.getResource();
    }

    public static final String get(String key) {
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

    public static final long hset(String key, String field, String value) {
        Jedis redis = getRedis();
        try {
            return redis.hset(key, field, value).longValue();
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

    public static final String put(String key, String value, int expired) {
        Jedis redis = getRedis();
        try {
            return redis.setex(key, expired, value);
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

    public static final long hremove(String key, String field) {
        Jedis redis = getRedis();
        try {
            return redis.hdel(key, new String[]{field}).longValue();
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

    public static final boolean hexists(String key, String field) {
        Jedis redis = getRedis();
        try {
            return redis.hexists(key, field).booleanValue();
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

    public static final String rename(String oldKey, String newKey) {
        Jedis redis = getRedis();
        try {
            return redis.rename(oldKey, newKey);
        } finally {
            release(redis);
        }
    }


    public static final void release(Jedis redis) {
        redis.close();
    }

    public static final void publish(JSONObject json) {
        Jedis redis = getRedis();
        try {
            redis.publish("/server/login", json.toJSONString());
        } finally {
            release(redis);
        }
    }
}


