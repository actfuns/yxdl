package com.wanniu.game.request.solo;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.SoloHandler;


@GClientEvent("area.soloHandler.drawRankRewardRequest")
public class DrawRankRewardHandler
        extends SoloRequestFilter {
    public PomeloResponse request(final WNPlayer player) throws Exception {
        SoloHandler.DrawRankRewardRequest req = SoloHandler.DrawRankRewardRequest.parseFrom(this.pak.getRemaingBytes());
        final int rankId = req.getC2SRankId();
        return new PomeloResponse() {
            protected void write() throws IOException {
                SoloHandler.DrawRankRewardResponse.Builder res = SoloHandler.DrawRankRewardResponse.newBuilder();
                player.soloManager.handleDrawRankReward(rankId, res);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


