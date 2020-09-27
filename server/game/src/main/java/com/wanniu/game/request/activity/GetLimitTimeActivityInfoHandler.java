package com.wanniu.game.request.activity;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;

import java.io.IOException;

import pomelo.area.LimitTimeActivityHandler;


@GClientEvent("area.limitTimeActivityHandler.getLimitTimeActivityInfoRequest")
public class GetLimitTimeActivityInfoHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        return new PomeloResponse() {
            protected void write() throws IOException {
                LimitTimeActivityHandler.GetLimitTimeActivityInfoResponse.Builder res = LimitTimeActivityHandler.GetLimitTimeActivityInfoResponse.newBuilder();
                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


