package com.wanniu.db.handler;

import com.alibaba.fastjson.JSONObject;
import com.wanniu.core.GGlobal;
import com.wanniu.core.db.ModifyDataType;
import com.wanniu.core.db.ModifyOperateType;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.tcp.protocol.Packet;
import com.wanniu.db.dao.MysqlDao;
import com.wanniu.db.dao.RedisDao;


public class UpdateHandler
        extends DBHandler {
    public void execute(Packet pak) {
        int logicServerId = ((Integer) pak.getAttr(GGlobal._KEY_LOGICSERVERID)).intValue();
        String dsName = (String) pak.getAttr(GGlobal._KEY_USER_ID);
        String dbName = (String) pak.getAttr(GGlobal._KEY_USER_NAME);
        String table = pak.getString();
        String field = pak.getString();
        int op = pak.getByte();
        String tableName = tableName(table);
        if (op == ModifyOperateType.DELETE.value) {
            MysqlDao.delete(dsName, dbName, tableName, field);
        } else {
            int type = pak.getByte();
            JSONObject entityJson = null;
            if (type == ModifyDataType.MAP.value) {
                String entityStr = RedisDao.hget(logicServerId, table, field);
                entityJson = JSONObject.parseObject(entityStr);
            } else if (type == ModifyDataType.STRING.value) {
                String entityStr = RedisDao.get(logicServerId, field);
                entityJson = JSONObject.parseObject(entityStr);
            }
            if (entityJson != null) {
                if (op == ModifyOperateType.INSERT.value) {
                    MysqlDao.insert(dsName, dbName, tableName, entityJson);
                } else if (MysqlDao.update(dsName, dbName, tableName, entityJson) == 0) {
                    MysqlDao.insert(dsName, dbName, tableName, entityJson);
                }
            } else {

                Out.error(new Object[]{Integer.valueOf(logicServerId), " 找不到TR: ", table, " Key: ", field, " type: ", Integer.valueOf(type), " 的数据 ;有可能REDIS中已经被删除"});
            }
        }
    }
}


