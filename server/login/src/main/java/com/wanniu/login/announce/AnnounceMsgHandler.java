package com.wanniu.login.announce;

import com.wanniu.core.http.HttpDecoderAndEncoder;
import com.wanniu.core.http.HttpServerMsgHandler;
import com.wanniu.core.logfs.Out;
import com.wanniu.login.AnnounceServer;
import com.wanniu.login.po.AnnouncementPO;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;

import java.util.Map;


public class AnnounceMsgHandler
        implements HttpServerMsgHandler {
    private String path;

    public AnnounceMsgHandler(String path) {
        this.path = path;
    }


    public String getPath() {
        return this.path;
    }


    public void doGet(ChannelHandlerContext ctx, FullHttpRequest request, Map<String, String> parmMap) {
    }


    public void doPost(ChannelHandlerContext ctx, FullHttpRequest request, Map<String, String> parmMap) {
        AnnouncementPO announce = AnnounceServer.announce;
        if (announce == null) {
            Out.error(new Object[]{"未获取到公告"});
            HttpDecoderAndEncoder.Response(ctx, request, "");
        } else {
            Out.debug(new Object[]{"公告：" + announce.content});
            HttpDecoderAndEncoder.Response(ctx, request, announce.content);
        }
    }
}


