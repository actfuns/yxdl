package com.wanniu.core.game.protocol;

import com.wanniu.core.tcp.protocol.Header;
import com.wanniu.core.tcp.protocol.Packet;
import io.netty.channel.Channel;


public class PomeloPacket
        extends Packet {
    public PomeloPacket(Channel session) {
        this.header = new PomeloHeader();
        this.session = session;
    }

    public short getPacketType() {
        return this.header.getType();
    }


    public PomeloHeader getHeader() {
        return (PomeloHeader) this.header;
    }


    public String toString() {
        return this.header.getTypeHexString();
    }

    public int getU8() {
        return this.body.readByte() & 0xFF;
    }

    public void readyBody() {
        byte flag = getByte();
        PomeloHeader header = getHeader();
        header.compressRoute = ((flag & 0x1) != 0);
        byte type = (byte) (flag >> 1 & 0x7);
        if (Protocol.msgHasId(type)) {
            int id = 0;
            int m = 0;
            int i = 0;
            do {
                m = getU8();
                id += (m & 0x7F) * (1 << 7 * i);
                i++;
            } while (m >= 128);
            header.setType((short) id);
        }
        if (Protocol.msgHasRoute(type))
            if (header.compressRoute) {
                header.route_n = (short) (getU8() << 8 | getU8());
            } else {
                int routeLen = getU8();
                byte[] dst = new byte[routeLen];
                getBytes(dst);
                header.route_s = Protocol.strdecode(dst);
            }
    }
}


