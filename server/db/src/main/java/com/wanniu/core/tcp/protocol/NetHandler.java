package com.wanniu.core.tcp.protocol;

import io.netty.channel.Channel;


public abstract class NetHandler {
    private Channel __session__;
    private short type;

    public short getType() {
        return this.type;
    }


    public void bindSession(Channel session) {
        this.__session__ = session;
    }


    public void send(Message msg) {
        if (this.__session__ != null) {
            this.__session__.writeAndFlush(msg);
        }
    }


    public void write(Message msg) {
        if (this.__session__ != null) {
            this.__session__.writeAndFlush(msg.getContent());
        }
    }


    public abstract void execute(Packet paramPacket);


    public boolean isGateHandler() {
        return false;
    }

    public int getRunIndex() {
        return 0;
    }
}


