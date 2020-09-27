package com.wanniu.core.tcp.protocol;

import com.wanniu.core.GGlobal;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.entity.GPlayer;
import com.wanniu.core.logfs.Out;
import io.netty.channel.Channel;


public abstract class NetHandler {
    private Channel __session__;
    private short type;

    public NetHandler() {
        GClientEvent handler = getClass().<GClientEvent>getAnnotation(GClientEvent.class);
        if (handler != null) {
            this.type = handler.type();
        }
    }


    public short getType() {
        return this.type;
    }


    public void bindSession(Channel session) {
        this.__session__ = session;
    }


    public void write(Message msg) {
        if (this.__session__ != null) {
            if (!this.__session__.isActive()) {
                GPlayer pl = (GPlayer) this.__session__.attr(GGlobal.__KEY_PLAYER).get();
                String pId = (pl == null) ? "" : pl.getId();
                Out.warn(new Object[]{"send msg warning noActivity,pid=", pId});
            } else if (!this.__session__.isWritable()) {
                GPlayer pl = (GPlayer) this.__session__.attr(GGlobal.__KEY_PLAYER).get();
                String pId = (pl == null) ? "" : pl.getId();
                Out.warn(new Object[]{"send msg warning noWriteable,pid=", pId});
            } else {
                this.__session__.writeAndFlush(msg, this.__session__.voidPromise());
            }
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


