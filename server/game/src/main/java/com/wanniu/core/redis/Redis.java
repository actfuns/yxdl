package com.wanniu.core.redis;

import com.wanniu.core.logfs.Out;

import java.util.Map;
import java.util.Set;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPubSub;


public class Redis {
    public static final int DEFAULT_TIMEOUT = 5000;
    public static final int DEFAULT_DATABASE = 0;
    private JedisPool pool;

    public Redis(String host, int port) {
        this(host, port, 0);
    }

    public Redis(String host, int port, int database) {
        this(host, port, 5000, null, database);
    }

    public Redis(String host, int port, String password) {
        this(host, port, 5000, password, 0);
    }

    public Redis(String host, int port, String password, int dbIndex) {
        this(host, port, 5000, password, dbIndex);
    }


    public Redis(String host, int port, int timeout, String password, int index) {
        this(8, host, port, timeout, password, index);
    }


    public Redis(int connection, String host, int port, int timeout, String password, int database) {
        GenericObjectPoolConfig config = new GenericObjectPoolConfig();
        config.setMaxTotal(connection);
        config.setMaxIdle(connection);
        this.pool = new JedisPool(config, host, port, timeout, password, database);
        Out.info(new Object[]{"Redis 连接信息:host=", host, ",port=", Integer.valueOf(port), ",database=", Integer.valueOf(database), ",timeout=", Integer.valueOf(timeout), "ms,password=", password});
        ping();
    }

    public void ping() {
        try (Jedis j = this.pool.getResource()) {
            String ret = j.ping();
            if (ret.equals("PONG")) {
                Out.info(new Object[]{"Redis服务器连接正常"});
            } else {
                Out.error(new Object[]{"Redis服务器连接异常"});
            }
        }
    }

    public void del(String key) {
        try (Jedis j = this.pool.getResource()) {
            j.del(key);
        }
    }


    public long publish(String channel, String message) {
        try (Jedis j = this.pool.getResource()) {
            long ret = j.publish(channel, message).longValue();
            return ret;
        }
    }


    public void subscribe(JedisPubSub jedisPubSub, String... channel) {
        try (Jedis j = this.pool.getResource()) {
            j.subscribe(jedisPubSub, channel);
        }
    }


    public void psubscribe(JedisPubSub jedisPubSub, String... channel) {
        try (Jedis j = this.pool.getResource()) {
            j.psubscribe(jedisPubSub, channel);
        }
    }


    public long dbSize() {
        try (Jedis j = this.pool.getResource()) {
            long ret = j.dbSize().longValue();
            return ret;
        }
    }


    public String quit() {
        try (Jedis j = this.pool.getResource()) {
            String ret = j.quit();
            return ret;
        }
    }

    public void destory() {
        this.pool.destroy();
    }

    public void close() {
        this.pool.close();
    }


    public Jedis getJedis() {
        return this.pool.getResource();
    }

    public JedisPool getPool() {
        return this.pool;
    }

    public void setPool(JedisPool pool) {
        this.pool = pool;
    }

    public String get(String key) {
        try (Jedis j = this.pool.getResource()) {
            return j.get(key);
        }
    }

    public String get(String key, String defaullt) {
        try (Jedis j = this.pool.getResource()) {
            String s = j.get(key);
            if (s == null) {
                return defaullt;
            }
            return s;
        }
    }

    public int scard(String key) {
        try (Jedis j = this.pool.getResource()) {
            Long value = j.scard(key);
            return (value == null) ? 0 : value.intValue();
        }
    }

    public Long scardx(String key) {
        try (Jedis j = this.pool.getResource()) {
            return j.scard(key);
        }
    }

    public void sadd(String key, String... members) {
        try (Jedis j = this.pool.getResource()) {
            j.sadd(key, members);
        }
    }

    public Boolean sismember(String key, String member) {
        try (Jedis j = this.pool.getResource()) {
            return j.sismember(key, member);
        }
    }

    public Long hincrBy(String key, String field, long value) {
        try (Jedis j = this.pool.getResource()) {
            return j.hincrBy(key, field, value);
        }
    }

    public Map<String, String> hgetAll(String key) {
        try (Jedis j = this.pool.getResource()) {
            return j.hgetAll(key);
        }
    }

    public void hset(String key, String field, String value) {
        try (Jedis j = this.pool.getResource()) {
            j.hset(key, field, value);
        }
    }

    public void hmset(String key, Map<String, String> hash) {
        try (Jedis j = this.pool.getResource()) {
            j.hmset(key, hash);
        }
    }

    public Long hdel(String key, String... fields) {
        try (Jedis j = this.pool.getResource()) {
            return j.hdel(key, fields);
        }
    }

    public Object eval(String script) {
        try (Jedis j = this.pool.getResource()) {
            return j.eval(script);
        }
    }

    public Set<String> smembers(String key) {
        try (Jedis j = this.pool.getResource()) {
            return j.smembers(key);
        }
    }

    public Boolean hexists(String key, String field) {
        try (Jedis j = this.pool.getResource()) {
            return j.hexists(key, field);
        }
    }

    public Long hsetnx(String key, String field, String value) {
        try (Jedis j = this.pool.getResource()) {
            return j.hsetnx(key, field, value);
        }
    }

    public String hget(String key, String field) {
        try (Jedis j = this.pool.getResource()) {
            return j.hget(key, field);
        }
    }

    public String save() {
        try (Jedis j = this.pool.getResource()) {
            return j.save();
        }
    }
}


