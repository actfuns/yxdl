package com.wanniu.core.tcp.protocol;

import com.wanniu.core.GConfig;
import com.wanniu.core.GGlobal;
import com.wanniu.core.logfs.Out;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;


public final class GDecoder
        extends ByteToMessageDecoder {
    private static int __RESPONSE_MAX_LEN = GConfig.getInstance().getInt("game.response.maxlen", GGlobal.__RESPONSE_MAX_LEN);


    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> packets) throws Exception {
        if (in.readableBytes() < Header.SIZE) {
            return;
        }
        in = in.order(GGlobal.__BYTE_ORDER);
        in.markReaderIndex();
        Packet packet = new Packet(ctx.channel());
        Header header = packet.getHeader();
        header.decode(in);

        int len = header.getLength();

        if (len > __RESPONSE_MAX_LEN || len < 0) {
            Channel session = ctx.channel();
            Out.warn(new Object[]{"包体长度错误：" + len +
                    " 句柄：" + header.getTypeHexString() + session.remoteAddress()});
            session.close();

            return;
        }
        if (in.readableBytes() < len) {
            in.resetReaderIndex();
            header = null;
            packet = null;

            return;
        }

        ByteBuf body = packet.init();
        body.writeBytes(in, len);


        packets.add(packet);
    }
}


