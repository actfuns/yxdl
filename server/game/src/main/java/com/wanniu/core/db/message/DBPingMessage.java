package com.wanniu.core.db.message;

import com.wanniu.core.db.DBType;
import com.wanniu.core.tcp.protocol.RequestMessage;

import java.io.IOException;


public class DBPingMessage
        extends RequestMessage {
    protected void write() throws IOException {
    }

    public short getType() {
        return DBType.PING;
    }
}


