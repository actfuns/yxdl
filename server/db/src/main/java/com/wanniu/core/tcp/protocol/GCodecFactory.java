package com.wanniu.core.tcp.protocol;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;


public final class GCodecFactory
        extends ChannelInitializer<SocketChannel> {
    private ChannelHandler handler;

    public GCodecFactory(ChannelHandler handler) {
        this.handler = handler;
    }


    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();

        pipeline.addLast("decoder", (ChannelHandler) new GDecoder());
        pipeline.addLast("encoder", (ChannelHandler) new GEncoder());
        pipeline.addLast("handler", this.handler);
    }
}


