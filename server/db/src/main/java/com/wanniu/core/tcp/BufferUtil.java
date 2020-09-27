package com.wanniu.core.tcp;

import com.wanniu.core.GGlobal;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;


public final class BufferUtil {
    public static ByteBuf getAutoBuffer() {
        return getAutoBuffer(GGlobal.__BUFFER_CAPACITY);
    }


    public static ByteBuf getAutoBuffer(int initCapacity) {
        ByteBuf body = Unpooled.buffer(initCapacity).order(GGlobal.__BYTE_ORDER);
        return body;
    }


    public static byte[] getBufBytes(ByteBuf src) {
        return src.array();
    }

    public static ByteBuf getBuffer(byte[] buf) {
        ByteBuf body = Unpooled.buffer(buf.length).order(GGlobal.__BYTE_ORDER);
        return body.writeBytes(buf);
    }
}


