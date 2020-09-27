package com.wanniu.core.game.protocol;

import com.alibaba.fastjson.JSONObject;
import com.wanniu.core.GConfig;
import com.wanniu.core.GGame;
import com.wanniu.core.GGlobal;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.tcp.BufferUtil;
import com.wanniu.csharp.CSharpClient;
import com.wanniu.csharp.protocol.CSharpMessage;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;


public class PomeloDecoder
        extends ByteToMessageDecoder {
    private static int __REQ_MAX_LEN = GConfig.getInstance().getInt("tcp.request.maxlen", GGlobal.__REQUEST_MAX_LEN);


    private static final ByteBuf HANDSHAKE;


    static {
        JSONObject res = new JSONObject();
        res.put("code", Integer.valueOf(200));
        JSONObject sys = new JSONObject();
        sys.put("heartbeat", Integer.valueOf(30));
        res.put("sys", sys);
        byte[] bs = res.toJSONString().getBytes(GGlobal.UTF_8);
        PomeloHeader head = new PomeloHeader();
        head.setPomeloType((byte) 1);
        head.setLength(bs.length);
        HANDSHAKE = BufferUtil.getAutoBuffer(4 + bs.length);
        head.encode(HANDSHAKE);
        HANDSHAKE.writeBytes(bs);

        PomeloHeader head_hb = new PomeloHeader();
        head_hb.setPomeloType((byte) 3);
        head_hb.setLength(0);
    }

    private static final ByteBuf HEARTBEAT = BufferUtil.getAutoBuffer(4);

    static {
        head_hb.encode(HEARTBEAT);
    }


    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> messages) throws Exception {
        if (in.readableBytes() < 4) {
            return;
        }
        in.markReaderIndex();

        PomeloPacket packet = new PomeloPacket(ctx.channel());
        PomeloHeader header = packet.getHeader();
        header.decode(in);

        int len = header.getLength();

        if (len > __REQ_MAX_LEN || len < 0) {
            Channel session = ctx.channel();
            Out.warn(new Object[]{header.route_s, "包体长度错误：", Integer.valueOf(len), session.remoteAddress()});
            session.close();

            return;
        }
        if (in.readableBytes() < len) {
            in.resetReaderIndex();
            header = null;
            packet = null;

            return;
        }
        ByteBuf body = packet.init();
        body.writeBytes(in, len);
        switch (header.pomelo_type) {


            case 1:
                ctx.channel().writeAndFlush(BufferUtil.getBuffer(HANDSHAKE.array()));
                break;

            case 2:
                Out.debug(new Object[]{"TYPE_HANDSHAKE_ACK!!"});
                break;

            case 4:
                packet.readyBody();

                if (header.isBattlePak()) {
                    CSharpClient.getInstance().dispatch(new CSharpMessage(packet));
                    break;
                }
                header.setReceiveTime(System.nanoTime());
                GGame.getInstance().putGlobalRoute(header.route_s, packet);
                break;


            case 3:
                Out.debug(new Object[]{"TYPE_HEARTBEAT: ", new String(body.array(), GGlobal.UTF_8)});

                ctx.channel().writeAndFlush(BufferUtil.getBuffer(HEARTBEAT.array()));
                break;

            case 5:
                Out.debug(new Object[]{"TYPE_KICK: ", new String(body.array(), GGlobal.UTF_8)});
                break;
        }
    }
}


