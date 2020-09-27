package com.wanniu.core.tcp.protocol;

import com.wanniu.core.GGlobal;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.util.AttributeKey;


public class Packet {
    protected Header header;
    protected ByteBuf body;
    protected Channel session;

    public Packet() {
    }

    public Packet(Channel session) {
        this.session = session;
        this.header = new Header();
    }

    public ByteBuf init() {
        this.body = Unpooled.buffer(this.header.getLength()).order(GGlobal.__BYTE_ORDER);
        return this.body;
    }

    public double getDouble() {
        return this.body.readDouble();
    }

    public float getFloat() {
        return this.body.readFloat();
    }

    public long getLong() {
        return this.body.readLong();
    }

    public int getInt() {
        return this.body.readInt();
    }

    public short getShort() {
        return this.body.readShort();
    }

    public byte getByte() {
        return this.body.readByte();
    }

    public boolean getBoolean() {
        return (getByte() == 1);
    }


    public void getBytes(byte[] dst) {
        this.body.readBytes(dst);
    }


    public String getString() {
        byte[] src = getBytes(Prefix.SHORT);
        return (src == null) ? null : new String(src, GGlobal.UTF_8);
    }


    public byte[] getBytes(Prefix prefix) {
        int len = 0;

        switch (prefix) {
            case null:
                len = getByte();
                break;
            case SHORT:
                len = getShort();
                break;
            case INT:
                len = getInt();
                break;
        }

        if (len == 0) {
            return null;
        }
        byte[] dst = new byte[len];
        getBytes(dst);

        return dst;
    }


    public void fillBody(byte[] src) {
        this.body.writeBytes(src);
    }


    public void resetBody() {
        this.body.clear();
    }


    public Channel getSession() {
        return this.session;
    }

    public <T> T getAttr(AttributeKey<T> att) {
        return (T) this.session.attr(att).get();
    }

    public <T> void setAttr(AttributeKey<T> att, T value) {
        this.session.attr(att).set(value);
    }

    public String toString() {
        return this.header.getTypeHexString();
    }

    public short getPacketType() {
        return this.header.getType();
    }


    public byte[] getBytes() {
        return this.body.array();
    }

    public byte[] getRemaingBytes() {
        int length = this.body.readableBytes();
        byte[] array = new byte[length];
        this.body.getBytes(this.body.readerIndex(), array, 0, length);
        return array;
    }


    public Header getHeader() {
        return this.header;
    }


    public ByteBuf getBody() {
        return this.body;
    }


    public void skip(int len) {
        this.body.skipBytes(len);
    }


    public int remaing() {
        return this.body.readableBytes();
    }


    public boolean isClosed() {
        return !(this.session != null && this.session.isActive());
    }

    public void close() {
        if (this.session != null) {
            this.session.close();
        }
    }

    public String getIp() {
        if (this.session != null) {
            String ip = this.session.remoteAddress().toString();
            return ip.substring(1, ip.indexOf(":"));
        }
        return null;
    }

    public void setSession(Channel session) {
        this.session = session;
    }


    public String getUid() {
        return (String) this.session.attr(GGlobal._KEY_USER_ID).get();
    }
}


