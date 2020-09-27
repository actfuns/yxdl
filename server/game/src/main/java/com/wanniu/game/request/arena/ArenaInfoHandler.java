package com.wanniu.game.request.arena;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.request.solo.SoloRequestFilter;

import java.io.IOException;

import pomelo.area.ArenaHandler;


@GClientEvent("area.arenaHandler.arenaInfoRequest")
public class ArenaInfoHandler
        extends SoloRequestFilter {
    public PomeloResponse request(final WNPlayer player) throws Exception {
        return new PomeloResponse() {
            protected void write() throws IOException {
                ArenaHandler.ArenaInfoResponse.Builder res = player.arenaManager.getArenaInfo();
                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


