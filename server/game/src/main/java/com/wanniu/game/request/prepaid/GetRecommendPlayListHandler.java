package com.wanniu.game.request.prepaid;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;

import java.io.IOException;

import pomelo.area.VitalityHandler;


@GClientEvent("area.vitalityHandler.getRecommendPlayListRequest")
public class GetRecommendPlayListHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        return new PomeloResponse() {
            protected void write() throws IOException {
                VitalityHandler.GetRecommendPlayListResponse.Builder res = VitalityHandler.GetRecommendPlayListResponse.newBuilder();


                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


