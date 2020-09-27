package com.wanniu.csharp.protocol;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;


public class CSharpCodecFactory
        extends ChannelInitializer<SocketChannel> {
    private ChannelHandler handler;

    public CSharpCodecFactory(ChannelHandler handler) {
        this.handler = handler;
    }


    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast("decoder", (ChannelHandler) new CSharpDecoder());
        pipeline.addLast("encoder", (ChannelHandler) new CSharpEncoder());
        pipeline.addLast("handler", this.handler);
    }
}


