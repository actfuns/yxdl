package com.wanniu.gm;

import com.wanniu.game.GWorld;

import java.io.IOException;

public class GMStateResponse
        extends GMResponse {
    private byte state;

    public GMStateResponse(int state) {
        super(250);
        this.state = (byte) state;
    }


    protected void response() throws IOException {
        this.body.writeInt(GWorld.__SERVER_ID);
        this.body.writeByte(0);
        this.body.writeByte(this.state);
    }
}


