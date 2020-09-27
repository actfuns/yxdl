package com.wanniu.core.pay.message;

import com.wanniu.core.GGame;
import com.wanniu.core.tcp.protocol.Message;

import java.io.IOException;


public class PayJoinMessage
        extends Message {
    protected void write() throws IOException {
        this.body.writeInt(GGame.__SERVER_ID);
    }


    public short getType() {
        return 241;
    }
}


