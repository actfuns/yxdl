package com.wanniu.core.gm.connect;

import com.wanniu.core.tcp.client.ClientBootstrap;
import com.wanniu.core.tcp.protocol.GCodecFactory;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;


public class GMBootstrap
        extends ClientBootstrap {
    public GMBootstrap(ChannelHandler handler) {
        super((ChannelInitializer) new GCodecFactory(handler));
    }
}


