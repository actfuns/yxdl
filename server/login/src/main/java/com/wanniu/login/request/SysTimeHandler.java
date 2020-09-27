package com.wanniu.login.request;

import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.game.request.GClientEvent;
import com.wanniu.login.proto.Common;

import java.io.IOException;


@GClientEvent("connector.entryHandler.getSysTimeRequest")
public class SysTimeHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        return new PomeloResponse() {
            protected void write() throws IOException {
                Common.SysTimeResponse.Builder res = Common.SysTimeResponse.newBuilder();
                res.setS2CCode(200);

                res.setS2CTime(String.valueOf(System.currentTimeMillis()));

                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


