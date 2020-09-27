package com.wanniu.core.game.message;

import com.wanniu.core.game.protocol.PomeloResponse;
import io.netty.buffer.ByteBuf;


public abstract class MulticastMessage
        extends PomeloResponse {
    public ByteBuf getContent() {
        return super.getContent().slice();
    }

    public String getRoute() {
        return null;
    }
}


