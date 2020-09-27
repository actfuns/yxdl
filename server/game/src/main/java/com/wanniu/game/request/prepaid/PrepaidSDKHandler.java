package com.wanniu.game.request.prepaid;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;

import java.io.IOException;

import pomelo.area.PrepaidHandler;


@GClientEvent("area.prepaidHandler.prepaidSDKRequest")
public class PrepaidSDKHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        return new PomeloResponse() {
            protected void write() throws IOException {
                PrepaidHandler.PrepaidSDKResponse.Builder res = PrepaidHandler.PrepaidSDKResponse.newBuilder();


                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


