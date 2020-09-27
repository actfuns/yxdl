package com.wanniu.gm;

import com.alibaba.fastjson.JSONObject;
import com.wanniu.core.GGlobal;
import com.wanniu.core.tcp.protocol.Prefix;
import com.wanniu.game.GWorld;

import java.io.IOException;

public class GMJsonResponse
        extends GMResponse {
    private String json;

    public GMJsonResponse(JSONObject json) {
        super(250);
        this.json = json.toJSONString();
    }


    protected void response() throws IOException {
        this.body.writeInt(GWorld.__SERVER_ID);
        this.body.writeByte(1);
        this.body.writeBytes(Prefix.INT, this.json.getBytes(GGlobal.UTF_8));
    }

    public GMJsonResponse(String json) {
        super(250);
        this.json = json;
    }
}


