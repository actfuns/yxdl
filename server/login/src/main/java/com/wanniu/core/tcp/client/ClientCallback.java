package com.wanniu.core.tcp.client;

import com.wanniu.core.tcp.NetEvent;
import com.wanniu.core.tcp.protocol.Packet;

public interface ClientCallback extends NetEvent {
    void handlePacket(Packet paramPacket);
}


