package com.wanniu.core.tcp;

import io.netty.channel.Channel;

public interface NetEvent {
  void bind(Channel paramChannel);
  
  void ping();
  
  void close();
}


/* Location:              D:\Yxdl\xmds-login\xmds-login.jar!\com\wanniu\core\tcp\NetEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */