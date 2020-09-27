package com.wanniu.core.proxy.message;

import com.alibaba.fastjson.JSON;
import com.wanniu.core.GConfig;
import com.wanniu.core.GGame;
import com.wanniu.core.tcp.protocol.Message;

import java.io.IOException;


public class ProxyJoinMessage
        extends Message {
    public static String SECRT = GConfig.getInstance().get("server.proxy.auth");


    protected void write() throws IOException {
        this.body.writeString(SECRT);
        this.body.writeInt(GGame.__SERVER_ID);
        this.body.writeInt(GConfig.getInstance().getInt("game.areaId", 0));
        this.body.writeShort(GGame.getInstance().getOnlineCount());
        this.body.writeString(JSON.toJSONString(GGame.__CS_NODE));
    }


    public short getType() {
        return 255;
    }
}


