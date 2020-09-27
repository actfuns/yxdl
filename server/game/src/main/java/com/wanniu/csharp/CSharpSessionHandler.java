package com.wanniu.csharp;

import com.wanniu.core.logfs.Out;
import com.wanniu.csharp.protocol.CSharpPacket;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;


@Sharable
public class CSharpSessionHandler
        extends ChannelInboundHandlerAdapter {
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        Out.error(new Object[]{"连接出现异常，Session:", ctx
                .channel().remoteAddress(), "; Exception:", cause
                .getMessage()});
        super.exceptionCaught(ctx, cause);
    }


    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        CSharpClient.getInstance().handle((CSharpPacket) msg);
    }


    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        CSharpClient.getInstance().close(ctx.channel());
    }
}


