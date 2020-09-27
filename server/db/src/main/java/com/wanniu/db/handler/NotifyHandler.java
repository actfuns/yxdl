package com.wanniu.db.handler;

import com.alibaba.fastjson.JSONObject;
import com.wanniu.core.GGlobal;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.tcp.protocol.Packet;
import com.wanniu.db.dao.MysqlDao;
import com.wanniu.db.dao.RedisDao;

import java.util.Map;


public class NotifyHandler
        extends DBHandler {
    public void execute(Packet pak) {
        int logicServerId = ((Integer) pak.getAttr(GGlobal._KEY_LOGICSERVERID)).intValue();
        String dsName = (String) pak.getAttr(GGlobal._KEY_USER_ID);
        String dbName = (String) pak.getAttr(GGlobal._KEY_USER_NAME);
        String playerId = pak.getString();

        Map<String, String> pos = RedisDao.hgetAll(logicServerId, playerId);
        for (Map.Entry<String, String> entry : pos.entrySet()) {
            String table = tableName(entry.getKey());
            if (MysqlDao.isTable(dsName, table)) {
                JSONObject entityJson = JSONObject.parseObject(entry.getValue());
                entityJson.put("playerId", playerId);
                if (MysqlDao.update(dsName, dbName, table, entityJson) == 0)
                    MysqlDao.insert(dsName, dbName, table, entityJson);
                continue;
            }
            Out.debug(new Object[]{table, " not exists!!!"});
        }
    }
}


