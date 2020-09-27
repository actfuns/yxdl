package com.wanniu.db.handler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wanniu.core.GConfig;
import com.wanniu.core.GGlobal;
import com.wanniu.core.db.DBType;
import com.wanniu.core.db.PoolFactory;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.tcp.protocol.Packet;
import com.wanniu.core.tcp.protocol.Prefix;
import com.wanniu.core.tcp.protocol.RequestMessage;
import com.wanniu.db.dao.MysqlDao;

import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public final class QueryHandler
        extends DBHandler {
    private final Executor ansycExec = new ThreadPoolExecutor(
            GConfig.getInstance().getInt("async.query.min", 1),
            GConfig.getInstance().getInt("async.query.max", 5),
            GConfig.getInstance().getInt("async.query.idle", 30), TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(), (ThreadFactory) new PoolFactory("查询服务"));

    private void ansycExec(final Runnable command) {
        this.ansycExec.execute(new Runnable() {
            public void run() {
                try {
                    command.run();
                } catch (Exception e) {
                    Out.error(new Object[]{e});
                }
            }
        });
    }


    public void execute(Packet pak) {
        ansycExec(() -> {
            String tableName;
            String dsName = (String) paramPacket.getAttr(GGlobal._KEY_USER_ID);
            String dbName = (String) paramPacket.getAttr(GGlobal._KEY_USER_NAME);
            long reqId = paramPacket.getLong();
            String table = paramPacket.getString();
            int type = paramPacket.getByte();
            String val = paramPacket.getString();
            JSONObject conVal = null;
            switch (type) {
                case 1:
                    tableName = tableName(table);
                    if (MysqlDao.isTable(dsName, tableName)) {
                        conVal = new JSONObject();
                        conVal.put((MysqlDao.getPkeyField(dsName, tableName)).filedName, val);
                    }
                    break;
                case 2:
                case 3:
                    if (val != null) {
                        conVal = JSON.parseObject(val);
                    }
                    break;
            }
            final String result = (type == 3) ? MysqlDao.executeQuery(dsName, table, conVal) : MysqlDao.select(dsName, dbName, tableName(table), conVal);
            RequestMessage res = new RequestMessage() {
                protected void write() throws IOException {
                    this.body.writeLong(this.reqId);
                    this.body.writeBytes(Prefix.INT, (result == null) ? null : result.getBytes(GGlobal.UTF_8));
                }

                public short getType() {
                    return DBType.QUERY;
                }
            };
            res.setReqId(reqId);
            paramPacket.getSession().writeAndFlush(res);
        });
    }
}


