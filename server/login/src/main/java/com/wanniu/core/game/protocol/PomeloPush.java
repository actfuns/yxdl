package com.wanniu.core.game.protocol;

import io.netty.buffer.ByteBuf;


public abstract class PomeloPush
        extends PomeloResponse {
    public PomeloPush() {
        this.type = 3;
        (getHeader()).route_s = getRoute();
    }

    public ByteBuf getContent() {
        return super.getContent().slice();
    }

    public abstract String getRoute();
}


