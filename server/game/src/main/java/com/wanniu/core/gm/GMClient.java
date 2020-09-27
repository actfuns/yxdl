package com.wanniu.core.gm;

import com.wanniu.core.GConfig;
import com.wanniu.core.gm.connect.GMBootstrap;
import com.wanniu.core.gm.connect.GMSessionHandler;
import com.wanniu.core.gm.message.GMJoinMessage;
import com.wanniu.core.gm.message.GMPingMessage;
import com.wanniu.core.gm.request.GMHandler;
import com.wanniu.core.tcp.client.ClientBootstrap;
import com.wanniu.core.tcp.client.ClientCallback;
import com.wanniu.core.tcp.client.ClientWorker;
import com.wanniu.core.tcp.protocol.Message;
import com.wanniu.core.tcp.protocol.NetHandler;
import com.wanniu.core.tcp.protocol.Packet;
import io.netty.channel.ChannelHandler;

public final class GMClient
        extends ClientWorker {
    private static GMClient instance = new GMClient();

    private GMDispatcher __dispacher__;

    public static GMClient getInstance() {
        return instance;
    }

    private GMClient() {
        this.__dispacher__ = new GMDispatcher();
    }

    public void start() {
        if (GConfig.getInstance().isEnableGm()) {
            this.serverHost = GConfig.getInstance().get("server.gm.host");
            this.serverPort = GConfig.getInstance().getInt("server.gm.port");
            this.bootstrap = (ClientBootstrap) new GMBootstrap((ChannelHandler) new GMSessionHandler((ClientCallback) this));

            super.start();
        }
    }


    public void ping() {
        add((Message) new GMPingMessage());
    }


    public void registerHandler(GMHandler handler) {
        this.__dispacher__.registerHandler((NetHandler) handler);
    }


    public void doStart() {
        add((Message) new GMJoinMessage());
    }


    public void handlePacket(Packet packet) {
        this.__dispacher__.execute(packet);
    }

    public void stop() {
        close(this.session);
    }

    public NetHandler getHandler(short type) {
        return this.__dispacher__.handlers.get(Short.valueOf(type));
    }
}


