package com.wanniu.csharp.protocol;

import com.wanniu.core.GGlobal;
import com.wanniu.core.tcp.protocol.Header;
import io.netty.buffer.ByteBuf;


public final class CSharpHeader
        extends Header {
    public static final byte SIZE = 8;
    private String uid;
    private int uidLength = 0;

    public int getCharpLength() {
        return this.uidLength + this.length;
    }

    public String getUid() {
        return this.uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
        this.uidLength = uid.length();
    }

    public int getUidLength() {
        return this.uidLength;
    }

    public int getBodyLength() {
        return getLength();
    }


    public void encode(ByteBuf out) {
        out.writeShort(this.uid.length());
        out.writeInt(getLength());
        out.writeBytes(this.uid.getBytes(GGlobal.UTF_8));
    }


    public void decode(ByteBuf in) {
        this.uidLength = readU16(in);

        this.length = readU32(in);
    }

    public int readU8(ByteBuf in) {
        return in.readByte() & 0xFF;
    }

    public int readU16(ByteBuf in) {
        return readU8(in) | readU8(in) << 8;
    }

    public int readU32(ByteBuf in) {
        return readU8(in) | readU8(in) << 8 | readU8(in) << 16 | readU8(in) << 24;
    }

    public void readBody(ByteBuf in) {
        byte[] uid = new byte[this.uidLength];
        in.readBytes(uid);
        this.uid = new String(uid, GGlobal.UTF_8);
    }
}


