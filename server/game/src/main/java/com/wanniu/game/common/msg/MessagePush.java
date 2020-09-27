package com.wanniu.game.common.msg;

import com.google.protobuf.GeneratedMessage;
import com.wanniu.core.game.protocol.PomeloPush;

import java.io.IOException;


public class MessagePush
        extends PomeloPush {
    private GeneratedMessage msg;
    private String route;

    public MessagePush(String route, GeneratedMessage msg) {
        this.msg = msg;
        this.route = route;
        (getHeader()).route_s = route;
    }


    protected void write() throws IOException {
        this.body.writeBytes(this.msg.toByteArray());
    }


    public String getRoute() {
        return this.route;
    }

    public GeneratedMessage getMsg() {
        return this.msg;
    }
}


