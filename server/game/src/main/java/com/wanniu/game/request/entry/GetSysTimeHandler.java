package com.wanniu.game.request.entry;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;

import java.io.IOException;

import pomelo.connector.EntryHandler;


@GClientEvent("connector.entryHandler.getSysTimeRequest")
public class GetSysTimeHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        return new PomeloResponse() {
            protected void write() throws IOException {
                EntryHandler.GetSysTimeResponse.Builder res = EntryHandler.GetSysTimeResponse.newBuilder();
                res.setS2CCode(200);
                res.setS2CTime(String.valueOf(System.currentTimeMillis()));
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }

    public short getType() {
        return 786;
    }
}


