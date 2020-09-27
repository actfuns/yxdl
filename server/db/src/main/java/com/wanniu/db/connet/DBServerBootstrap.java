package com.wanniu.db.connet;

import com.wanniu.core.GConfig;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.tcp.protocol.GDecoder;
import com.wanniu.core.tcp.protocol.GEncoder;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;


public class DBServerBootstrap {
    private static DBServerBootstrap instance;
    private ServerBootstrap serverBootstrap;
    private EventLoopGroup bossGroup;
    private EventLoopGroup workerGroup;

    public static DBServerBootstrap getInstance() {
        if (instance == null) {
            instance = new DBServerBootstrap();
        }
        return instance;
    }


    public void start() {
        try {
            this.bossGroup = (EventLoopGroup) new NioEventLoopGroup();
            this.workerGroup = (EventLoopGroup) new NioEventLoopGroup();
            this.serverBootstrap = new ServerBootstrap();

            this.serverBootstrap.group(this.bossGroup, this.workerGroup);
            this.serverBootstrap.channel(NioServerSocketChannel.class);

            this.serverBootstrap.childHandler((ChannelHandler) new ChannelInitializer<SocketChannel>() {
                protected void initChannel(SocketChannel ch) throws Exception {
                    ChannelPipeline pipeline = ch.pipeline();

                    pipeline.addLast("encoder", (ChannelHandler) new GEncoder());
                    pipeline.addLast("decoder", (ChannelHandler) new GDecoder());
                    pipeline.addLast("handler", (ChannelHandler) new DBServerHandler());
                }
            });

            ((ServerBootstrap) ((ServerBootstrap) this.serverBootstrap.option(ChannelOption.SO_LINGER, Integer.valueOf(0)))

                    .option(ChannelOption.SO_REUSEADDR, Boolean.valueOf(true)))
                    .childOption(ChannelOption.TCP_NODELAY, Boolean.valueOf(true))
                    .childOption(ChannelOption.SO_KEEPALIVE, Boolean.valueOf(true));

            String ip = GConfig.getInstance().getDBHost();
            int port = GConfig.getInstance().getDBPort();
            InetSocketAddress socketAddress = (ip != null && ip.length() > 6) ? new InetSocketAddress(ip, port) : new InetSocketAddress(port);
            this.serverBootstrap.bind(socketAddress).sync();

            Out.info(new Object[]{"服务绑定于 -> " + socketAddress});
        } catch (Exception e) {
            e.printStackTrace();
            shutDown();
            Out.error(new Object[]{e});
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e1) {
                Out.error(new Object[]{e1});
            }
        }
    }


    public void shutDown() {
        if (this.bossGroup != null) {
            this.bossGroup.shutdownGracefully();
        }
        if (this.workerGroup != null)
            this.workerGroup.shutdownGracefully();
    }
}


