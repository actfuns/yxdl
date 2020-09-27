package com.wanniu.core.tcp.client;

import com.wanniu.core.tcp.NetEvent;
import com.wanniu.core.tcp.protocol.Packet;

public interface ClientCallback extends NetEvent {
  void handlePacket(Packet paramPacket);
}


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\core\tcp\client\ClientCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */