package com.wanniu.core.pay.message;

import com.wanniu.core.game.message.ResponseMessage;

import java.io.IOException;


public class PayPingMessage
        extends ResponseMessage {
    protected void write() throws IOException {
    }

    public short getType() {
        return 242;
    }
}


