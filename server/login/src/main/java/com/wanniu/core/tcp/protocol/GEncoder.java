package com.wanniu.core.tcp.protocol;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;


public final class GEncoder
        extends MessageToByteEncoder<Message> {
    protected void encode(ChannelHandlerContext ctx, Message msg, ByteBuf out) throws Exception {
        out.writeBytes(msg.getContent());
        ctx.flush();
    }
}


