package com.wanniu.core.pay;

import com.wanniu.core.GConfig;
import com.wanniu.core.pay.connect.PayBootstrap;
import com.wanniu.core.pay.connect.PaySessionHandler;
import com.wanniu.core.pay.message.PayJoinMessage;
import com.wanniu.core.pay.message.PayPingMessage;
import com.wanniu.core.pay.request.PayHandler;
import com.wanniu.core.tcp.client.ClientBootstrap;
import com.wanniu.core.tcp.client.ClientCallback;
import com.wanniu.core.tcp.client.ClientWorker;
import com.wanniu.core.tcp.protocol.Message;
import com.wanniu.core.tcp.protocol.NetHandler;
import com.wanniu.core.tcp.protocol.Packet;
import io.netty.channel.ChannelHandler;

public final class PayClient
        extends ClientWorker {
    private static PayClient instance = new PayClient();

    private PayDispatcher __dispacher__;

    public static PayClient getInstance() {
        return instance;
    }

    private PayClient() {
        this.__dispacher__ = new PayDispatcher();
    }


    public void ping() {
        add((Message) new PayPingMessage());
    }

    public void start() {
        if (GConfig.getInstance().isEnablePay()) {
            this.serverHost = GConfig.getInstance().get("server.pay.host");
            this.serverPort = GConfig.getInstance().getInt("server.pay.port");
            this.bootstrap = (ClientBootstrap) new PayBootstrap((ChannelHandler) new PaySessionHandler((ClientCallback) this));
            (new Thread(this.__dispacher__, String.format("GM<-%s:%d", new Object[]{this.serverHost, Integer.valueOf(this.serverPort)}))).start();
            super.start();
        }
    }


    public void registerHandler(PayHandler handler) {
        this.__dispacher__.registerHandler((NetHandler) handler);
    }


    public void doStart() {
        add((Message) new PayJoinMessage());
    }


    public void handlePacket(Packet packet) {
        this.__dispacher__.add(packet);
    }

    public void stop() {
        close(this.session);
    }

    public NetHandler getHandler(short type) {
        return this.__dispacher__.handlers.get(Short.valueOf(type));
    }
}


