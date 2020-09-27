package com.wanniu.core.gm.message;

import com.wanniu.core.GGame;
import com.wanniu.core.game.message.ResponseMessage;
import com.wanniu.core.gm.GMType;

import java.io.IOException;


public class GMPingMessage
        extends ResponseMessage {
    protected void write() throws IOException {
        this.body.writeShort(GGame.getInstance().getOnlineCount());
    }


    public short getType() {
        return GMType.PING;
    }
}


