package com.wanniu.core.proxy.message;

import com.wanniu.core.GGame;
import com.wanniu.core.game.message.ResponseMessage;

import java.io.IOException;


public class ProxyPingMessage
        extends ResponseMessage {
    protected void write() throws IOException {
        this.body.writeShort(GGame.getInstance().getOnlineCount());
    }


    public short getType() {
        return 242;
    }
}


