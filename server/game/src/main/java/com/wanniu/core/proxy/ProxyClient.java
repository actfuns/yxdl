package com.wanniu.core.proxy;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wanniu.core.GConfig;
import com.wanniu.core.GGame;
import com.wanniu.core.game.entity.GPlayer;
import com.wanniu.core.proxy.message.ProxyJoinMessage;
import com.wanniu.core.proxy.message.ProxyPingMessage;
import com.wanniu.core.tcp.client.ClientCallback;
import com.wanniu.core.tcp.client.ClientWorker;
import com.wanniu.core.tcp.protocol.Message;
import com.wanniu.core.tcp.protocol.Packet;
import com.wanniu.core.tcp.protocol.Prefix;
import com.wanniu.core.tcp.protocol.RequestMessage;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;

import java.io.IOException;


public final class ProxyClient
        extends ClientWorker {
    private static ProxyClient instance = new ProxyClient();

    public static ProxyClient getInstance() {
        return instance;
    }


    public void start() {
        if (GConfig.getInstance().isEnableProxy()) {
            this.serverHost = GConfig.getInstance().get("server.proxy.host");
            this.serverPort = GConfig.getInstance().getInt("server.proxy.port");
            this.bootstrap = new ProxyBootstrap((ChannelHandler) new ProxySessionHandler((ClientCallback) this));
            super.start();
        }
    }


    public void ping() {
        add((Message) new ProxyPingMessage());
    }


    public void doStart() {
        send((Message) new ProxyJoinMessage());
    }

    public JSONObject request(final ProxyType.ProxyMethod type, final JSONObject json) {
        Packet pak = request(new RequestMessage() {
            protected void write() throws IOException {
                this.body.writeLong(this.reqId);
                this.body.writeShort(type.value);
                this.body.writeString(json.toJSONString());
            }


            public short getType() {
                return 257;
            }
        });

        return JSON.parseObject(pak.getString());
    }

    public Packet query(final int sid, final JSONObject json) {
        Packet pak = request(new RequestMessage() {
            protected void write() throws IOException {
                this.body.writeLong(this.reqId);
                this.body.writeInt(sid);
                this.body.writeString(json.toJSONString());
            }

            public short getType() {
                return 513;
            }
        });

        return pak;
    }


    public void handlePacket(final Packet pak) {
        if (pak.getPacketType() == 257 || pak.getPacketType() == 770) {
            long reqId = pak.getLong();
            response(reqId, pak);
        } else if (pak.getPacketType() == 498) {
            GGame.getInstance().closeArea(pak.getString());
        } else if (pak.getPacketType() == 499) {
            GGame.getInstance().onPlayerDie(pak.getString(), pak.getString(), pak.getString());
        } else if (pak.getPacketType() == 497) {
            ByteBuf buf = Unpooled.wrappedBuffer(pak.getBytes(Prefix.INT));
            int count = pak.getShort();
            for (int i = 0; i < count; i++) {
                GPlayer player = GGame.getInstance().getPlayer(pak.getString());
                if (player != null && player.getSession() != null) {
                    player.getSession().writeAndFlush(buf.slice());
                }
            }
        } else {
            GGame.getInstance().ansycExec(new Runnable() {
                public void run() {
                    GGame.getInstance().onAcrossReceive(pak);
                }
            });
        }
    }

    public void stop() {
        close(this.session);
    }
}


