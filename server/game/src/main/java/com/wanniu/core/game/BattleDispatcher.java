package com.wanniu.core.game;

import com.wanniu.core.tcp.PacketDispatcher;
import com.wanniu.core.tcp.protocol.Header;
import com.wanniu.core.tcp.protocol.NetHandler;
import com.wanniu.core.tcp.protocol.Packet;


public final class BattleDispatcher
        extends PacketDispatcher {
    public final void execute(Packet action) {
        Header header = action.getHeader();
        NetHandler handler = (NetHandler) this.handlers.get(Short.valueOf(header.getType()));
        if (handler != null) {
            if (action.isClosed())
                return;
            handler.bindSession(action.getSession());
            handler.execute(action);
        }
    }
}


