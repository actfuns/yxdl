package com.wanniu.game.request.player;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;

import java.io.IOException;

import pomelo.area.PlayerHandler;


@GClientEvent("area.playerHandler.reliveSendPosRequest")
public class ReliveSendPosHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        return new PomeloResponse() {
            protected void write() throws IOException {
                PlayerHandler.ReliveSendPosResponse.Builder res = PlayerHandler.ReliveSendPosResponse.newBuilder();


                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


