package com.wanniu.game.request.arena;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.tcp.protocol.Packet;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.request.solo.SoloRequestFilter;

import java.io.IOException;

import pomelo.area.ArenaHandler;


@GClientEvent("area.arenaHandler.arenaRewardRequest")
public class ArenaRewardHandler
        extends SoloRequestFilter {
    public PomeloResponse request(final WNPlayer player) throws Exception {
        return new PomeloResponse() {
            protected void write() throws IOException {
                ArenaHandler.ArenaRewardResponse.Builder res = ArenaHandler.ArenaRewardResponse.newBuilder();
                ArenaHandler.ArenaRewardRequest req = ArenaHandler.ArenaRewardRequest.parseFrom(ArenaRewardHandler.this.pak.getRemaingBytes());
                player.arenaManager.handleGetReward(req.getC2SType(), res);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


