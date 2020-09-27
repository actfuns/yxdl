package com.wanniu.core.tcp.protocol;

import com.wanniu.core.logfs.Out;
import io.netty.buffer.ByteBuf;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;


public class Header {
    protected short type;
    protected int length;

    public void decode(ByteBuf in) {
        this.type = in.readShort();
        this.length = in.readInt();
    }

    public void decodeHeader(ByteBuf in) {
        decode(in);
    }

    public void decode(Header header) {
        this.type = header.getType();
        this.length = header.getLength();
    }


    public void encode(ByteBuf out) {
        out.writeShort(this.type);
        out.writeInt(this.length);
    }

    public int getLength() {
        return this.length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public short getType() {
        return this.type;
    }


    public String getTypeHexString() {
        return "0x" + Integer.toHexString(this.type);
    }

    public void setType(short type) {
        this.type = type;
    }


    private static byte calcBytes() {
        Field[] fs = Header.class.getDeclaredFields();
        return (byte) (calcSize(fs) - 2);
    }

    public static int calcSize(Field[] fs) {
        int bits = 0;
        byte b;
        int i;
        Field[] arrayOfField;
        for (i = (arrayOfField = fs).length, b = 0; b < i; ) {
            Field f = arrayOfField[b];
            int mod = f.getModifiers();
            String type = f.getGenericType().toString().intern();
            if (!Modifier.isStatic(mod)) {
                if (type.equals("byte")) {
                    bits += 8;
                } else if (type.equals("short")) {
                    bits += 16;
                } else if (type.equals("int")) {
                    bits += 32;
                } else if (type.equals("long")) {
                    bits += 64;
                } else if (type.equals("char")) {
                    bits += 16;
                } else if (type.equals("float")) {
                    bits += 32;
                } else if (type.equals("double")) {
                    bits += 64;
                } else {
                    Out.warn(new Object[]{"过滤了非基础数据类型属性：" + Modifier.toString(mod) + " - " + type + "[" + f.getName() + "]"});
                }

            } else if (!"SIZE".equals(f.getName())) {
                Out.warn(new Object[]{"过滤了静态属性：" + Modifier.toString(mod) + " - " + type + "[" + f.getName() + "]"});
            }
            b++;
        }

        bits /= 8;
        if (bits > 127 || bits < -128) {
            Out.error(new Object[]{"数值[" + bits + "]超过byte边界"});
            return 0;
        }
        return bits;
    }


    public static final byte SIZE = calcBytes();
}


