package com.wanniu.game.request.solo;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.SoloHandler;


@GClientEvent("area.soloHandler.rewardInfoRequest")
public class RewardInfoHandler
        extends SoloRequestFilter {
    public PomeloResponse request(final WNPlayer player) throws Exception {
        return new PomeloResponse() {

            protected void write() throws IOException {
                SoloHandler.RewardInfoResponse.Builder res = SoloHandler.RewardInfoResponse.newBuilder();
                player.soloManager.handleRewardInfo(res);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


