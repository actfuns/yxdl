package com.wanniu.core.game.protocol;

import com.wanniu.core.tcp.BufferUtil;
import com.wanniu.core.tcp.protocol.Header;
import com.wanniu.core.tcp.protocol.Message;
import io.netty.buffer.ByteBuf;


public abstract class PomeloResponse
        extends Message {
    private ByteBuf route;
    private int capacity;

    protected Header newHeader() {
        return new PomeloHeader();
    }

    public PomeloHeader getHeader() {
        return (PomeloHeader) this.header;
    }


    public byte type = 2;

    protected ByteBuf newContent() {
        PomeloHeader header = getHeader();
        int capacity = 1;
        capacity += Protocol.msgHasId(this.type) ? Protocol.caculateMsgIdBytes(header.getType()) : 0;
        if (Protocol.msgHasRoute(this.type)) {
            if (header.compressRoute) {
                capacity += 2;
            } else {
                this.route = Protocol.strencode(header.route_s);
                capacity++;
                capacity += this.route.readableBytes();
            }
        }
        capacity += this.body.getBuffer().readableBytes();
        this.capacity = capacity;
        return BufferUtil.getAutoBuffer(4 + capacity);
    }

    protected void encodeHeader() {
        PomeloHeader header = getHeader();

        header.setLength(this.capacity);
        header.encode(this.content);
    }

    protected void encodeBody() {
        PomeloHeader header = getHeader();


        int flag = this.type << 1 | (header.compressRoute ? 1 : 0);


        this.content.writeByte(flag);


        if (Protocol.msgHasId(this.type)) {
            int id = header.getType();
            do {
                int tmp = id % 128;
                int next = id / 128;
                if (next != 0) {
                    tmp += 128;
                }
                this.content.writeByte(tmp);
                id = next;
            } while (id != 0);
        }


        if (Protocol.msgHasRoute(this.type)) {
            if (header.compressRoute) {
                this.content.writeByte(header.route_n >> 8 & 0xFF);
                this.content.writeByte(header.route_n & 0xFF);
            } else if (this.route != null) {
                this.content.writeByte(this.route.readableBytes() & 0xFF);
                this.content.writeBytes(this.route);
            } else {
                this.content.writeByte(0);
            }
        }


        this.content.writeBytes(this.body.getBuffer());
    }

    public short getType() {
        return 0;
    }
}


