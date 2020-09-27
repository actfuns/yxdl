package com.wanniu.core.game.protocol;

import com.wanniu.core.GGame;
import com.wanniu.core.game.request.GameHandler;
import com.wanniu.core.tcp.protocol.Packet;


public abstract class PomeloRequest
        extends GameHandler {
    public static final int OK = 200;
    public static final int KICK = 400;
    public static final int FAIL = 500;
    protected Packet pak;

    public void execute(Packet pak) {
        this.watcher.begin(pak.getHeader().getLength());
        this.pak = pak;
        PomeloResponse res = null;
        try {
            res = request();
        } catch (Exception e) {
            res = GGame.getInstance().getErrResponse(e);
        }
        if (res != null) {
            PomeloHeader header = res.getHeader();
            header.setType(pak.getHeader().getType());
            this.watcher.end(res.getContent().readableBytes());
            write(res);
        } else {
            this.watcher.end(0);
        }
    }

    public abstract PomeloResponse request() throws Exception;
}


