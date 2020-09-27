package com.wanniu.core;

import com.wanniu.core.tcp.protocol.Prefix;

import java.nio.ByteBuffer;


public final class GBuffer {
    private ByteBuffer body;

    private GBuffer(int size) {
        malloc(size);
    }

    private GBuffer(byte[] src) {
        this.body = ByteBuffer.wrap(src).order(GGlobal.__BYTE_ORDER);
    }

    private GBuffer(ByteBuffer input) {
        this.body = input;
    }


    public static GBuffer allocate() {
        return allocate(GGlobal.__BUFFER_CAPACITY);
    }

    public static GBuffer allocate(int size) {
        return new GBuffer(size);
    }

    public static GBuffer wrap(byte[] bytes) {
        return new GBuffer(bytes);
    }

    public static GBuffer wrap(ByteBuffer buffer) {
        return new GBuffer(buffer);
    }

    public boolean getBoolean() {
        return (getByte() != 0);
    }

    public byte getByte() {
        return this.body.get();
    }

    public short getShort() {
        return this.body.getShort();
    }

    public int getInt() {
        return this.body.getInt();
    }

    public float getFloat() {
        return this.body.getFloat();
    }

    public long getLong() {
        return this.body.getLong();
    }

    public double getDouble() {
        return this.body.getDouble();
    }


    public String getString() {
        short size = getShort();
        if (size == 0) {
            return null;
        }
        byte[] tmp = new byte[size];
        this.body.get(tmp);
        return new String(tmp, GConst.UTF_8);
    }

    public byte[] getBytes(int size) {
        byte[] bytes = new byte[size];
        this.body.get(bytes);
        return bytes;
    }

    public GBuffer flip() {
        this.body.flip();
        return this;
    }

    public void skip(int size) {
        this.body.position(this.body.position() + size);
    }


    public byte[] getBytes(Prefix prefix) {
        byte[] bytes = null;
        switch (prefix) {
            case null:
                bytes = new byte[this.body.get()];
                break;
            case SHORT:
                bytes = new byte[this.body.getShort()];
                break;
            case INT:
                bytes = new byte[this.body.getInt()];
                break;
        }
        this.body.get(bytes);
        return bytes;
    }


    public byte[] getBytes() {
        if (this.body.position() > 0) {
            byte[] bytes = new byte[this.body.position()];
            this.body.flip();
            this.body.get(bytes);
            return bytes;
        }
        byte[] remain = new byte[this.body.limit() - this.body.position()];
        this.body.get(remain);
        return remain;
    }


    public void putBytes(Prefix prefix, byte[] data) {
        switch (prefix) {
            case null:
                putByte(data.length);
                break;
            case SHORT:
                putShort(data.length);
                break;
            case INT:
                putInt(data.length);
                break;
        }
        put(data);
    }

    public void putBuffer(Prefix prefix, ByteBuffer buffer) {
        switch (prefix) {
            case null:
                putByte(buffer.remaining());
                break;
            case SHORT:
                putShort(buffer.remaining());
                break;
            case INT:
                putInt(buffer.remaining());
                break;
        }
        put(buffer);
    }


    public void putString(String value) {
        if (value == null) {
            putShort(0);
            return;
        }
        byte[] sbuf = value.getBytes(GConst.UTF_8);
        putBytes(Prefix.SHORT, sbuf);
    }

    public void putBoolean(boolean b) {
        putByte((byte) (b ? 1 : 0));
    }

    public void putShort(int i) {
        putShort((short) i);
    }

    public void putByte(int i) {
        putByte((byte) i);
    }


    public void put(byte[] src) {
        autoExpand(src.length);
        this.body.put(src);
    }

    public void put(byte[] src, int start, int length) {
        autoExpand(length);
        this.body.put(src, start, length);
    }

    public void put(ByteBuffer buffer) {
        autoExpand(buffer.remaining());
        this.body.put(buffer);
    }

    public void putDouble(double d) {
        autoExpand(8);
        this.body.putDouble(d);
    }

    public void putFloat(float f) {
        autoExpand(4);
        this.body.putFloat(f);
    }

    public void putLong(long l) {
        autoExpand(8);
        this.body.putLong(l);
    }

    public void putInt(int i) {
        autoExpand(4);
        this.body.putInt(i);
    }

    public void putShort(short s) {
        autoExpand(2);
        this.body.putShort(s);
    }

    public void putByte(byte b) {
        autoExpand(1);
        this.body.put(b);
    }

    private void malloc(int size) {
        this.body = ByteBuffer.allocate(size).order(GGlobal.__BYTE_ORDER);
    }

    private void autoExpand(int count) {
        if (this.body.capacity() < this.body.position() + count) {
            ByteBuffer buffer = this.body;
            buffer.flip();
            malloc(this.body.capacity() + Math.max(32, count));
            this.body.put(buffer);
        }
    }
}


