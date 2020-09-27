package com.wanniu.core.game;

import com.wanniu.core.GConfig;
import com.wanniu.core.GGlobal;
import com.wanniu.core.game.protocol.PomeloDecoder;
import com.wanniu.core.game.protocol.PomeloEncoder;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.tcp.GBootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.handler.timeout.IdleStateHandler;

import java.net.InetSocketAddress;


public final class GServerBootstrap
        extends GBootstrap {
    private static GServerBootstrap instance;
    private ServerBootstrap serverBootstrap;
    private EventLoopGroup bossGroup = Loop;
    private EventLoopGroup workerGroup = Loop;


    public static GServerBootstrap getInstance() {
        if (instance == null) {
            instance = new GServerBootstrap();
        }
        return instance;
    }


    public void start() {
        try {
            this.serverBootstrap = new ServerBootstrap();

            this.serverBootstrap.group(this.bossGroup, this.workerGroup);
            this.serverBootstrap.channel(NioServerSocketChannel.class);

            this.serverBootstrap.childHandler((ChannelHandler) new ChannelInitializer<SocketChannel>() {
                protected void initChannel(SocketChannel ch) throws Exception {
                    ChannelPipeline pipeline = ch.pipeline();
                    pipeline.addLast("idleHandler", (ChannelHandler) new IdleStateHandler(60, 0, 0) {
                        protected void channelIdle(ChannelHandlerContext ctx, IdleStateEvent evt) throws Exception {
                            Out.info(new Object[]{ctx.channel().remoteAddress(), " idle close!!!"});
                            ctx.channel().attr(GGlobal.__KEY_SESSION_TIMEOUT).set(Boolean.valueOf(true));
                            ctx.close();
                        }
                    });

                    pipeline.addLast("decoder", (ChannelHandler) new PomeloDecoder());
                    pipeline.addLast("encoder", (ChannelHandler) new PomeloEncoder());
                    pipeline.addLast("handler", (ChannelHandler) new ServerSessionHandler());
                }
            });

            ((ServerBootstrap) this.serverBootstrap


                    .option(ChannelOption.SO_REUSEADDR, Boolean.valueOf(true)))


                    .childOption(ChannelOption.TCP_NODELAY, Boolean.valueOf(true))


                    .childOption(ChannelOption.WRITE_BUFFER_HIGH_WATER_MARK, Integer.valueOf(262144))
                    .childOption(ChannelOption.WRITE_BUFFER_LOW_WATER_MARK, Integer.valueOf(131072));


            String ip = GConfig.getInstance().getGameHost();
            int port = GConfig.getInstance().getGamePort();
            InetSocketAddress socketAddress = (ip != null && ip.length() > 6) ? new InetSocketAddress(ip, port) : new InetSocketAddress(port);
            this.serverBootstrap.bind(socketAddress).sync();

            Out.info(new Object[]{"服务绑定于 -> ", socketAddress});
        } catch (Exception e) {
            Out.error(new Object[]{e});
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException interruptedException) {
            }
        }
    }
}


