package com.wanniu.core.tcp.protocol;

import com.wanniu.core.GGlobal;
import com.wanniu.core.tcp.BufferUtil;
import io.netty.buffer.ByteBuf;


public final class Body {
    private ByteBuf body;

    public Body() {
        this(GGlobal.__BODY_CAPACITY);
    }

    public Body(int initCapacity) {
        this.body = BufferUtil.getAutoBuffer(initCapacity);
    }


    public void writeBoolean(boolean bool) {
        writeByte(bool);
    }


    public void writeByte(int value) {
        this.body.writeByte(value);
    }


    public void writeByte(boolean value) {
        this.body.writeByte(value ? 1 : 0);
    }


    public void writeShort(short value) {
        this.body.writeShort(value);
    }


    public void writeShort(int value) {
        this.body.writeShort((short) value);
    }


    public void writeInt(int value) {
        this.body.writeInt(value);
    }


    public void writeFloat(float value) {
        this.body.writeFloat(value);
    }


    public void writeLong(long value) {
        this.body.writeLong(value);
    }


    public void writeDouble(double value) {
        this.body.writeDouble(value);
    }


    public void writeString(String utf) {
        if (utf == null) {
            this.body.writeShort(0);
            return;
        }
        if (utf.length() > 5000) {
            utf = utf.substring(0, 5000);
        }

        byte[] bytes = utf.getBytes(GGlobal.UTF_8);
        this.body.writeShort((short) bytes.length);
        this.body.writeBytes(bytes);
    }


    public void writeBytes(byte[] inwrite) {
        this.body.writeBytes(inwrite);
    }


    public void writeBytes(byte[] inwrite, int offset) {
        this.body.writeBytes(inwrite, offset, inwrite.length - offset);
    }


    public void writeBytes(byte[] inwrite, int offset, int length) {
        this.body.writeBytes(inwrite, offset, length);
    }


    public void write2DBytes(byte[][] inwrite) {
        for (int i = 0; i < inwrite.length; i++) {
            this.body.writeBytes(inwrite[i]);
        }
    }


    public void writeBuffer(ByteBuf buffer) {
        this.body.writeBytes(buffer);
    }


    public void writeBytes(Prefix prefix, byte[] inwrite) {
        int length = (inwrite != null) ? inwrite.length : 0;
        switch (prefix) {
            case null:
                this.body.writeByte((byte) length);
                break;
            case SHORT:
                this.body.writeShort((short) length);
                break;
            case INT:
                this.body.writeInt(length);
                break;
        }
        if (length == 0) {
            return;
        }
        this.body.writeBytes(inwrite);
    }


    public void clear() {
        this.body.clear();
    }


    public int size() {
        return this.body.readableBytes();
    }


    public byte[] getBytes() {
        return this.body.array();
    }

    public ByteBuf getBuffer() {
        return this.body;
    }
}


