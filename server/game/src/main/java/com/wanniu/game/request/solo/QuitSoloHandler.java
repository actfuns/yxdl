package com.wanniu.game.request.solo;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.SoloHandler;


@GClientEvent("area.soloHandler.quitSoloRequest")
public class QuitSoloHandler
        extends SoloRequestFilter {
    public PomeloResponse request(final WNPlayer player) throws Exception {
        return new PomeloResponse() {

            protected void write() throws IOException {
                SoloHandler.QuitSoloResponse.Builder res = SoloHandler.QuitSoloResponse.newBuilder();
                player.soloManager.handleQuitSolo();

                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


