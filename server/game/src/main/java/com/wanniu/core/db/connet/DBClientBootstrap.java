package com.wanniu.core.db.connet;

import com.wanniu.core.tcp.client.ClientBootstrap;
import com.wanniu.core.tcp.protocol.GCodecFactory;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;


public class DBClientBootstrap
        extends ClientBootstrap {
    public DBClientBootstrap(ChannelHandler handler) {
        super((ChannelInitializer) new GCodecFactory(handler));
    }
}


