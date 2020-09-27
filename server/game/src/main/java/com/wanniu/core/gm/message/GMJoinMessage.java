package com.wanniu.core.gm.message;

import com.wanniu.core.GConfig;
import com.wanniu.core.GGame;
import com.wanniu.core.gm.GMType;
import com.wanniu.core.tcp.protocol.Message;

import java.io.IOException;


public class GMJoinMessage
        extends Message {
    protected void write() throws IOException {
        this.body.writeString(GConfig.getInstance().get("server.gm.auth"));
        this.body.writeInt(GGame.__SERVER_ID);
        this.body.writeShort(GGame.getInstance().getOnlineCount());
        this.body.writeString(GConfig.getInstance().getGamePubHost());
        this.body.writeInt(GConfig.getInstance().getGamePort());
        this.body.writeString(GConfig.getInstance().get("game.name"));
        this.body.writeInt(GConfig.getInstance().getInt("game.areaId", 0));
        this.body.writeInt(GGame.__APP_ID);
    }


    public short getType() {
        return GMType.JOIN;
    }
}


