package com.wanniu.core.tcp.client;

import com.wanniu.core.logfs.Out;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;
import java.util.concurrent.TimeUnit;


public class ClientBootstrap {
    private Bootstrap boots;
    protected Channel session;

    public ClientBootstrap(ChannelInitializer<SocketChannel> factory) {
        this.boots = new Bootstrap();
        this.boots.channel(NioSocketChannel.class);
        this.boots.option(ChannelOption.TCP_NODELAY, Boolean.valueOf(true));
        this.boots.option(ChannelOption.SO_KEEPALIVE, Boolean.valueOf(true));
        this.boots.handler((ChannelHandler) factory);
        this.boots.group((EventLoopGroup) new NioEventLoopGroup(2));
    }

    public Channel connect(String host, int port) {
        try {
            ChannelFuture future = this.boots.connect(new InetSocketAddress(host, port));
            future.awaitUninterruptibly(10L, TimeUnit.SECONDS);

            if (!future.isSuccess()) {
                future.cause().printStackTrace();
                return null;
            }
            this.session = future.channel();
            return future.channel();
        } catch (Exception e) {
            Out.error(new Object[]{e});
            return null;
        }
    }

    public void quit(Channel session) {
        if (session != null)
            session.close();
    }
}


