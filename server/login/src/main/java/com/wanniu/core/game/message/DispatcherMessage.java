package com.wanniu.core.game.message;

import com.wanniu.core.tcp.protocol.Packet;
import io.netty.buffer.ByteBuf;

import java.io.IOException;


public class DispatcherMessage
        extends MulticastMessage {
    private ByteBuf buffer;

    public DispatcherMessage(Packet packet) {
        this.header.decode(packet.getHeader());
        this.buffer = packet.getBody();
    }


    protected void write() throws IOException {
        this.body.writeBuffer(this.buffer);
    }


    public short getType() {
        return this.header.getType();
    }
}



