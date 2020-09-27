package com.wanniu.game.request.player;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.PlayerHandler;


@GClientEvent("area.playerHandler.setCustomConfigRequest")
public class SetCustomConfigHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();

        PlayerHandler.CustomConfigRequest req = PlayerHandler.CustomConfigRequest.parseFrom(this.pak.getRemaingBytes());
        final String key = req.getC2SKey();
        final String value = req.getC2SValue();

        return new PomeloResponse() {
            protected void write() throws IOException {
                PlayerHandler.CustomConfigResponse.Builder res = PlayerHandler.CustomConfigResponse.newBuilder();

                if (player.setClientCustomConfig(key, value, false)) {
                    res.setS2CCode(200);
                } else {
                    res.setS2CCode(500);
                }
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


