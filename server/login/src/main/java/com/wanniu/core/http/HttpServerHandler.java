package com.wanniu.core.http;

import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpMethod;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@Sharable
public class HttpServerHandler
        extends SimpleChannelInboundHandler<FullHttpRequest> {
    private HashMap<String, HttpServerMsgHandler> httphandlersChain = new HashMap<>();


    protected void channelRead0(ChannelHandlerContext ctx, FullHttpRequest request) throws Exception {
        URI uri = new URI(request.getUri());

        String path = uri.getPath();
        HttpServerMsgHandler handler = this.httphandlersChain.get(path);
        Map<String, String> parmMap = HttpDecoderAndEncoder.parse(request);
        if (handler != null) {
            if (request.getMethod().equals(HttpMethod.GET)) {
                handler.doGet(ctx, request, parmMap);
            } else if (request.getMethod().equals(HttpMethod.POST) || request.getMethod().equals(HttpMethod.OPTIONS)) {
                handler.doPost(ctx, request, parmMap);
            }
        } else {
            ctx.close();
        }
    }

    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }


    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        ctx.close();
    }

    public void addHandler(HttpServerMsgHandler handler) {
        this.httphandlersChain.put(handler.getPath(), handler);
    }
}


