package com.wanniu.core.db.message;

import com.wanniu.core.GConfig;
import com.wanniu.core.GGame;
import com.wanniu.core.db.DBType;
import com.wanniu.core.tcp.protocol.RequestMessage;

import java.io.IOException;


public class DBJoinMessage
        extends RequestMessage {
    protected void write() throws IOException {
        this.body.writeLong(this.reqId);
        this.body.writeInt(GGame.__SERVER_ID);

        String redisHost = GConfig.getInstance().get("server.redis.host", "127.0.0.1");
        int redisPort = GConfig.getInstance().getInt("server.redis.port", 6379);
        String pwd = GConfig.getInstance().get("server.redis.password");
        int db = GConfig.getInstance().getInt("server.redis.db", 0);

        this.body.writeString(redisHost);
        this.body.writeShort(redisPort);
        this.body.writeString(pwd);
        this.body.writeByte(db);

        this.body.writeString(GConfig.getInstance().get("game.dsname", "game-ds"));
        this.body.writeString(GConfig.getInstance().get("game.dbname", "game_db"));
    }


    public short getType() {
        return DBType.JOIN;
    }
}


