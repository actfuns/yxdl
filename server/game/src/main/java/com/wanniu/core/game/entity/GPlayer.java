package com.wanniu.core.game.entity;

import com.wanniu.core.GGame;
import com.wanniu.core.GGlobal;
import com.wanniu.core.tcp.protocol.Message;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;

import java.util.Date;


public abstract class GPlayer {
    public static volatile long Buf = 0L;
    public static volatile long Count = 0L;

    protected Channel session;
    protected byte state = 0;

    private Date logoutDate;

    public long modifyTime;

    public final Watcher watcher;


    public void bind(Channel session) {
        this.session = session;
        session.attr(GGlobal.__KEY_PLAYER).set(this);
        GGame.getInstance().addPlayer(this);
    }


    public byte getState() {
        return this.state;
    }

    public void setState(byte state) {
        this.state = state;
    }


    public Channel getSession() {
        return this.session;
    }

    public static class Watcher {
        public int count;
        public long buf;

        public void inrc(ByteBuf buf) {
            if (!GGame.MONITOR)
                return;
            this.buf += buf.readableBytes();
            this.count++;
        }
    }

    public GPlayer() {
        this.watcher = new Watcher();
        this.modifyTime = System.currentTimeMillis();
    }

    public void endWatch() {
        if (GGame.MONITOR) {
            Buf += this.watcher.buf;
            Count += this.watcher.count;
        }
    }


    public void receive(Message msg) {
        if (this.session != null) {
            msg.getContent();
            this.watcher.inrc(msg.getContent());
            this.session.writeAndFlush(msg);
        }
    }


    public void write(Message msg) {
        if (this.session != null) {
            this.watcher.inrc(msg.getContent());
            this.session.writeAndFlush(msg.getContent());
        }
    }


    public Date getLogoutTime() {
        return this.logoutDate;
    }

    public void setLogoutTime(Date date) {
        this.logoutDate = date;
    }


    public void doLogout(boolean self) {
        setState((byte) 0);
        Date date = new Date();
        this.logoutDate = date;
        setLogoutTime(date);
        GGame.getInstance().removePlayer(this);
        if (!self) {
            GGame.getInstance().addWaitPlayer(this);
        }
        onLogout(self);
        sync();
    }

    public void bindBattleServer(String serverId) {
    }

    public abstract String getId();

    public abstract void onLogout(boolean paramBoolean);

    public abstract String getUid();

    public abstract String getBattleServerId();

    public abstract String getName();

    public abstract void sync();

    public abstract void free();
}


