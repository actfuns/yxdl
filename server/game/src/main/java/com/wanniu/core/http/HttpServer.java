package com.wanniu.core.http;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.handler.stream.ChunkedWriteHandler;


public class HttpServer {
    private HttpServerHandler httpServerHandler = new HttpServerHandler();


    EventLoopGroup bossGroup = (EventLoopGroup) new NioEventLoopGroup();
    EventLoopGroup workerGroup = (EventLoopGroup) new NioEventLoopGroup();

    public void run(int port) throws Exception {
        try {
            ServerBootstrap b = new ServerBootstrap();
            ((ServerBootstrap) b.group(this.bossGroup, this.workerGroup).channel(NioServerSocketChannel.class))
                    .childHandler((ChannelHandler) new ChannelInitializer<SocketChannel>() {
                        public void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast("http-decoder", (ChannelHandler) new HttpRequestDecoder());
                            ch.pipeline().addLast("http-aggregator", (ChannelHandler) new HttpObjectAggregator(65536));
                            ch.pipeline().addLast("http-encoder", (ChannelHandler) new HttpResponseEncoder());
                            ch.pipeline().addLast("http-chunked", (ChannelHandler) new ChunkedWriteHandler());
                            ch.pipeline().addLast(new ChannelHandler[]{(ChannelHandler) HttpServer.access$000(this.this$0)});
                        }
                    });
            ChannelFuture f = b.bind(port).sync();

            System.out.println("Http Server start Success! http://127.0.0.1:" + port + '/');
            f.channel().closeFuture().sync();
        } finally {
            this.bossGroup.shutdownGracefully();
            this.workerGroup.shutdownGracefully();
        }
    }

    public void addHandler(HttpServerMsgHandler handler) {
        this.httpServerHandler.addHandler(handler);
    }
}


