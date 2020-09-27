package com.wanniu.gm;

import com.wanniu.core.GGlobal;

import java.io.IOException;

public class GMCDKResponse
        extends GMResponse {
    private boolean ok = true;
    private byte[] bytes;

    public GMCDKResponse(byte[] bytes) {
        super(252);
        this.bytes = bytes;
    }

    public GMCDKResponse(String errMsg) {
        this(errMsg.getBytes(GGlobal.UTF_8));
        this.ok = false;
    }


    protected void response() throws IOException {
        this.body.writeBoolean(this.ok);
        this.body.writeInt(this.bytes.length);
        this.body.writeBytes(this.bytes);
    }
}


