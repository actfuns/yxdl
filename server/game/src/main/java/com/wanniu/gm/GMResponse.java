package com.wanniu.gm;

import com.wanniu.core.tcp.protocol.Message;

import java.io.IOException;

public abstract class GMResponse
        extends Message {
    protected long key;
    private short type;

    public GMResponse(int type) {
        this.type = (short) type;
    }

    public GMResponse(long key, int type) {
        this.key = key;
        this.type = (short) type;
    }

    public void setKey(long key) {
        this.key = key;
    }


    protected void write() throws IOException {
        this.body.writeLong(this.key);
        response();
    }


    protected abstract void response() throws IOException;

    public short getType() {
        return this.type;
    }
}


