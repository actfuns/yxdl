package com.wanniu.db.handler;

import com.wanniu.core.GConfig;
import com.wanniu.core.GGlobal;
import com.wanniu.core.db.DBType;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.tcp.protocol.Message;
import com.wanniu.core.tcp.protocol.Packet;
import com.wanniu.db.DBServer;
import com.wanniu.db.dao.RedisDao;

import java.io.IOException;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;


public class RegisterHandler
        extends DBHandler {
    public void execute(Packet pak) {
        long reqId = pak.getLong();
        int logicServerId = pak.getInt();
        pak.setAttr(GGlobal._KEY_LOGICSERVERID, Integer.valueOf(logicServerId));

        try {
            String redisHost = pak.getString();
            int redisPort = pak.getShort();
            int db = pak.getByte();
            String pwd = pak.getString();

            int timeout = GConfig.getInstance().getInt("server.redis.timeout", 2000);

            JedisPoolConfig config = new JedisPoolConfig();

            config.setTestOnBorrow(GConfig.getInstance().getBoolean("server.redis.testonborrow", true));

            config.setTestOnReturn(GConfig.getInstance().getBoolean("server.redis.testonreturn", true));
            config.setMaxIdle(GConfig.getInstance().getInt("server.redis.maxidle", 20));
            config.setMaxWaitMillis(GConfig.getInstance().getInt("server.redis.maxwait", 1000));
            config.setMaxTotal(GConfig.getInstance().getInt("server.redis.total", 5));

            JedisPool pool = new JedisPool((GenericObjectPoolConfig) config, redisHost, redisPort, timeout, pwd, db);

            JedisPool oldPool = RedisDao.putRedisPools(logicServerId, pool);
            if (oldPool != null) {
                oldPool.destroy();
            }


            String dsName = pak.getString();
            String dbName = pak.getString();
            pak.setAttr(GGlobal._KEY_USER_ID, dsName);
            pak.setAttr(GGlobal._KEY_USER_NAME, dbName);
        } catch (Exception e) {
            write(new RegisterResponse(reqId, 500));
            Out.error(new Object[]{e});

            return;
        }
        DBServer.Channels.put(Integer.valueOf(logicServerId), pak.getSession());

        Out.info(new Object[]{"服务器:【" + logicServerId + "】 注册成功！"});
        write(new RegisterResponse(reqId, 200));
    }

    private static class RegisterResponse
            extends Message {
        long reqId;
        int status;

        RegisterResponse(long reqId, int status) {
            this.reqId = reqId;
            this.status = status;
        }


        protected void write() throws IOException {
            this.body.writeLong(this.reqId);
            this.body.writeInt(this.status);
        }


        public short getType() {
            return DBType.JOIN;
        }
    }
}


