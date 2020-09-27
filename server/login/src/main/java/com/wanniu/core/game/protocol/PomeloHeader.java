package com.wanniu.core.game.protocol;

import com.wanniu.core.tcp.protocol.Header;
import io.netty.buffer.ByteBuf;


public final class PomeloHeader
        extends Header {
    public static final byte SIZE = 4;
    protected byte pomelo_type = 4;

    protected int length;
    public boolean compressRoute;
    public short route_n;
    public String route_s;

    public void setRoute(String route) {
        this.route_s = route;
        this.compressRoute = false;
    }

    public void setRoute(short route) {
        this.route_n = route;
        this.type = route;
        this.compressRoute = true;
    }

    public void setRoute(short route_n, String route_s) {
        this.route_n = route_n;
        this.route_s = route_s;
        if (route_s != null) {
            this.compressRoute = true;
        }
    }

    public int getLength() {
        return this.length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public byte getPomeloType() {
        return this.pomelo_type;
    }

    public void setPomeloType(byte pomelo_type) {
        this.pomelo_type = pomelo_type;
    }


    public String getTypeHexString() {
        return "0x" + Integer.toHexString(this.type) + ":" + this.route_s;
    }


    public void encode(ByteBuf out) {
        out.writeByte(this.pomelo_type);
        out.writeByte(this.length >> 16 & 0xFF);
        out.writeByte(this.length >> 8 & 0xFF);
        out.writeByte(this.length & 0xFF);
    }


    public void decode(ByteBuf in) {
        this.pomelo_type = in.readByte();
        this.length = (in.readByte() & 0xFF) << 16 | (in.readByte() & 0xFF) << 8 | in.readByte() & 0xFF;
    }
}


