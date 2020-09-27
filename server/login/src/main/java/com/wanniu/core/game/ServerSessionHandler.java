package com.wanniu.core.game;

import com.wanniu.core.GServer;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.tcp.protocol.Packet;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;


public final class ServerSessionHandler
        extends ChannelInboundHandlerAdapter {
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Out.debug(
                new Object[]{"连接被建立，Session:" + ctx.channel().remoteAddress().toString()});
    }


    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        Out.debug(


                new Object[]{"exceptionCaught"});
        Channel session = ctx.channel();
        Out.warn(new Object[]{session.remoteAddress() + "未验证时发生的异常"});
        ctx.close();
    }

    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel session = ctx.channel();
        GServer.getInstance().onSessionClose(session);
    }


    public void channelRead(ChannelHandlerContext ctx, Object packet) throws Exception {
        GServer.getInstance().addPacket((Packet) packet);
    }
}


