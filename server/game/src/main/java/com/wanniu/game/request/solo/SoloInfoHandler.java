package com.wanniu.game.request.solo;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.SoloHandler;


@GClientEvent("area.soloHandler.soloInfoRequest")
public class SoloInfoHandler
        extends SoloRequestFilter {
    public PomeloResponse request(final WNPlayer player) throws Exception {
        return new PomeloResponse() {
            protected void write() throws IOException {
                SoloHandler.SoloInfoResponse.Builder res = SoloHandler.SoloInfoResponse.newBuilder();
                player.soloManager.handleSoloInfo(res);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


