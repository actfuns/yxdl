package com.wanniu.core.pay.connect;

import com.wanniu.core.tcp.client.ClientBootstrap;
import com.wanniu.core.tcp.protocol.GCodecFactory;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;


public class PayBootstrap
        extends ClientBootstrap {
    public PayBootstrap(ChannelHandler handler) {
        super((ChannelInitializer) new GCodecFactory(handler));
    }
}


