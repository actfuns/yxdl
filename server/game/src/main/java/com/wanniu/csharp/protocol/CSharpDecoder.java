package com.wanniu.csharp.protocol;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;


public class CSharpDecoder
        extends ByteToMessageDecoder {
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> messages) throws Exception {
        if (in.readableBytes() < 8) {
            return;
        }
        in.markReaderIndex();
        CSharpHeader header = new CSharpHeader();


        header.decode(in);

        int len = header.getCharpLength();
        if (len < 0) {
            ctx.channel().close();

            return;
        }
        if (in.readableBytes() < len) {
            in.resetReaderIndex();
            header = null;
            return;
        }
        header.readBody(in);

        CSharpPacket packet = new CSharpPacket(header);
        packet.readBody(in);

        messages.add(packet);
    }
}


