package com.wanniu.core.game;

import com.wanniu.core.GConfig;
import com.wanniu.core.game.protocol.PomeloDecoder;
import com.wanniu.core.game.protocol.PomeloEncoder;
import com.wanniu.core.logfs.Out;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.handler.timeout.IdleStateHandler;

import java.net.InetSocketAddress;


public final class GServerBootstrap {
    private static GServerBootstrap instance;
    private ServerBootstrap serverBootstrap;
    private EventLoopGroup bossGroup;
    private EventLoopGroup workerGroup;

    public static GServerBootstrap getInstance() {
        if (instance == null) {
            instance = new GServerBootstrap();
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
                    pipeline.addLast("idleHandler", (ChannelHandler) new IdleStateHandler(60, 0, 0) {
                        protected void channelIdle(ChannelHandlerContext ctx, IdleStateEvent evt) throws Exception {
                            Out.debug(

                                    new Object[]{ctx.channel(), " idle..."});
                            ctx.close();
                        }
                    });
                    pipeline.addLast("decoder", (ChannelHandler) new PomeloDecoder());
                    pipeline.addLast("encoder", (ChannelHandler) new PomeloEncoder());
                    pipeline.addLast("handler", (ChannelHandler) new ServerSessionHandler());
                }
            });


            ((ServerBootstrap) ((ServerBootstrap) this.serverBootstrap.option(ChannelOption.SO_LINGER, Integer.valueOf(0)))

                    .option(ChannelOption.SO_REUSEADDR, Boolean.valueOf(true)))
                    .childOption(ChannelOption.TCP_NODELAY, Boolean.valueOf(true))
                    .childOption(ChannelOption.SO_KEEPALIVE, Boolean.valueOf(true));

            String ip = GConfig.getInstance().getLoginHost();
            int port = GConfig.getInstance().getLoginPort();
            InetSocketAddress socketAddress = (ip != null && ip.length() > 6) ? new InetSocketAddress(ip, port) : new InetSocketAddress(port);
            this.serverBootstrap.bind(socketAddress).sync();

            Out.info(new Object[]{"服务绑定于 -> " + socketAddress});
        } catch (Exception e) {
            shutDown();
            Out.error(new Object[]{e});
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException interruptedException) {
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


