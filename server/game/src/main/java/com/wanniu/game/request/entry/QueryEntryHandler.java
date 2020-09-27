package com.wanniu.game.request.entry;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;

import java.io.IOException;

import pomelo.gate.GateHandler;


@GClientEvent("gate.gateHandler.queryEntryRequest")
public class QueryEntryHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        return new PomeloResponse() {
            protected void write() throws IOException {
                GateHandler.QueryEntryResponse.Builder res = GateHandler.QueryEntryResponse.newBuilder();
                res.setS2CCode(200);


                res.setS2CToken("succeed!");

                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


