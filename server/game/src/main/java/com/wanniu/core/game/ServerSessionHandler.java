package com.wanniu.core.game;

import com.wanniu.core.GGame;
import com.wanniu.core.GGlobal;
import com.wanniu.core.game.entity.GPlayer;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.tcp.protocol.Packet;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;


public final class ServerSessionHandler
        extends ChannelInboundHandlerAdapter {
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Out.info(new Object[]{"连接被建立，Session:", ctx.channel().remoteAddress()});
    }


    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        if (cause instanceof java.io.IOException || cause instanceof io.netty.handler.codec.DecoderException) {
            Out.debug(new Object[]{"Netty try IOException||DecoderException.", ctx.channel().remoteAddress(), cause.getMessage()});
        } else {
            Out.error(new Object[]{"Netty try exception.", ctx.channel().remoteAddress(), cause});
        }
        ctx.close();
    }


    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel session = ctx.channel();
        Out.info(new Object[]{"连接被关闭:", session.remoteAddress()});
        try {
            if (session.attr(GGlobal.__KEY_PLAYER) != null) {
                GPlayer player = (GPlayer) session.attr(GGlobal.__KEY_PLAYER).get();
                if (player != null && player.getSession() == session) {
                    player.doLogout(false);
                }
            }
        } finally {
            GGame.getInstance().onSessionClose(session);
        }
    }


    public void channelRead(ChannelHandlerContext ctx, Object packet) throws Exception {
        GGame.getInstance().addPacket((Packet) packet);
    }
}


