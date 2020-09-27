package com.wanniu.core.tcp;

import io.netty.channel.Channel;

public interface NetEvent {
    void bind(Channel paramChannel);

    void ping();

    void close();
}


