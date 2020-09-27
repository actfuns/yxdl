package com.wanniu.core.http;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;

import java.util.Map;

public interface HttpServerMsgHandler {
    String getPath();

    void doPost(ChannelHandlerContext paramChannelHandlerContext, FullHttpRequest paramFullHttpRequest, Map<String, String> paramMap);

    void doGet(ChannelHandlerContext paramChannelHandlerContext, FullHttpRequest paramFullHttpRequest, Map<String, String> paramMap);
}


