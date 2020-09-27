package com.wanniu.core.http;

import com.wanniu.core.logfs.Out;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpContent;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMessage;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.handler.codec.http.QueryStringDecoder;
import io.netty.handler.codec.http.multipart.Attribute;
import io.netty.handler.codec.http.multipart.HttpPostRequestDecoder;
import io.netty.handler.codec.http.multipart.InterfaceHttpData;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class HttpDecoderAndEncoder {
    public static void Request(ChannelHandlerContext ctx, FullHttpRequest req) {
    }

    public static Map<String, String> parse(FullHttpRequest fullReq) throws Exception {
        HttpMethod method = fullReq.getMethod();

        Map<String, String> parmMap = new HashMap<>();

        if (HttpMethod.GET == method) {

            QueryStringDecoder decoder = new QueryStringDecoder(fullReq.getUri());
            Set<Map.Entry<String, List<String>>> set = decoder.parameters().entrySet();
            for (Map.Entry<String, List<String>> entry : set) {
                parmMap.put(entry.getKey(), ((List<String>) entry.getValue()).get(0));
            }
        } else if (HttpMethod.POST == method) {

            HttpPostRequestDecoder decoder = new HttpPostRequestDecoder((HttpRequest) fullReq);
            decoder.offer((HttpContent) fullReq);

            List<InterfaceHttpData> parmList = decoder.getBodyHttpDatas();

            for (InterfaceHttpData parm : parmList) {
                Attribute data = (Attribute) parm;
                parmMap.put(data.getName(), data.getValue());
            }

        } else {

            throw new Exception("");
        }

        return parmMap;
    }


    public static void Response(ChannelHandlerContext ctx, FullHttpRequest req, String msg) {
        Response(ctx, req, msg, HttpResponseStatus.OK);
    }


    public static void Response(ChannelHandlerContext ctx, FullHttpRequest req, String msg, HttpResponseStatus status) {
        try {
            DefaultFullHttpResponse defaultFullHttpResponse = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, Unpooled.wrappedBuffer(msg.getBytes("UTF-8")));
            defaultFullHttpResponse.headers().set("Content-Type", "text/plain");
            defaultFullHttpResponse.headers().set("Content-Length", Integer.valueOf(defaultFullHttpResponse.content().readableBytes()));
            defaultFullHttpResponse.headers().set("Access-Control-Allow-Origin", "*");
            if (HttpHeaders.isKeepAlive((HttpMessage) req)) {
                defaultFullHttpResponse.headers().set("Connection", "keep-alive");
            }
            ctx.write(defaultFullHttpResponse);
            ctx.flush();
        } catch (Exception e) {
            Out.error(new Object[]{"HttpDecoderAndEncoder Response", e});
        }
    }
}


