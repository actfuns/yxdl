package com.wanniu.csharp;

import com.wanniu.core.tcp.client.ClientBootstrap;
import com.wanniu.csharp.protocol.CSharpCodecFactory;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;


public class CSharpBootstrap
        extends ClientBootstrap {
    public CSharpBootstrap(ChannelHandler handler) {
        super((ChannelInitializer) new CSharpCodecFactory(handler), (EventLoopGroup) new NioEventLoopGroup());
    }
}


