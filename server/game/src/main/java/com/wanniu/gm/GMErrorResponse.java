package com.wanniu.gm;

import com.wanniu.game.GWorld;

import java.io.IOException;

public class GMErrorResponse
        extends GMResponse {
    public GMErrorResponse() {
        super(251);
    }


    protected void response() throws IOException {
        this.body.writeInt(GWorld.__SERVER_ID);
    }
}


