package com.wanniu.db.dao;

import java.util.HashMap;
import java.util.Map;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.util.SafeEncoder;


public class RedisDao {
    private static Map<Integer, JedisPool> redisPools = new HashMap<>();

    public static JedisPool putRedisPools(int logicServerId, JedisPool redisPool) {
        return redisPools.put(Integer.valueOf(logicServerId), redisPool);
    }

    public static final Jedis getRedis(int logicServerId) {
        JedisPool redisPool = redisPools.get(Integer.valueOf(logicServerId));
        if (redisPool == null) {
            return null;
        }
        return redisPool.getResource();
    }

    public static final String get(int logicServerId, String key) {
        Jedis redis = getRedis(logicServerId);
        try {
            return redis.get(key);
        } finally {
            release(redis);
        }
    }

    public static final byte[] get(int logicServerId, byte[] key) {
        Jedis redis = getRedis(logicServerId);
        try {
            return redis.get(key);
        } finally {
            release(redis);
        }
    }

    public static final String hget(int logicServerId, String key, String field) {
        Jedis redis = getRedis(logicServerId);
        try {
            return redis.hget(key, field);
        } finally {
            release(redis);
        }
    }

    public static final byte[] hget(int logicServerId, String key, byte[] field) {
        Jedis redis = getRedis(logicServerId);
        try {
            return redis.hget(encode(key), field);
        } finally {
            release(redis);
        }
    }

    public static final Map<String, String> hgetAll(int logicServerId, String key) {
        Jedis redis = getRedis(logicServerId);
        try {
            return redis.hgetAll(key);
        } finally {
            release(redis);
        }
    }


    public static final void release(Jedis redis) {
        if (redis != null) {
            redis.close();
        }
    }


    public static final byte[] encode(String utf) {
        return SafeEncoder.encode(utf);
    }
}


