package com.wanniu.csharp.protocol;

import com.wanniu.core.tcp.protocol.Header;
import com.wanniu.core.tcp.protocol.Packet;
import io.netty.buffer.ByteBuf;


public class CSharpPacket
        extends Packet {
    public CSharpPacket(CSharpHeader header) {
        this.header = header;
    }

    public short getPacketType() {
        return this.header.getType();
    }


    public CSharpHeader getHeader() {
        return (CSharpHeader) this.header;
    }

    public void readBody(ByteBuf in) {
        ByteBuf body = init();
        body.writeBytes(in, this.header.getLength());
    }


    public String toString() {
        return this.header.getTypeHexString();
    }
}


