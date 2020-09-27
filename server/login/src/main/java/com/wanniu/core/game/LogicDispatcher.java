package com.wanniu.core.game;

import com.wanniu.core.game.protocol.PomeloHeader;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.tcp.PacketDispatcher;
import com.wanniu.core.tcp.protocol.Header;
import com.wanniu.core.tcp.protocol.NetHandler;
import com.wanniu.core.tcp.protocol.Packet;


public final class LogicDispatcher
        extends PacketDispatcher {
    public final void execute(Packet action) {
        Header header = action.getHeader();
        NetHandler handler = (NetHandler) this.handlers.get(Short.valueOf(header.getType()));
        if (handler == null && header instanceof PomeloHeader) {
            handler = (NetHandler) this.s_handlers.get(((PomeloHeader) header).route_s);
        }
        if (handler != null) {
            if (action.isClosed())
                return;
            try {
                handler.bindSession(action.getSession());
                handler.execute(action);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Out.warn(new Object[]{"未找到该协议号:" + header.getTypeHexString()});
        }
    }
}


