package com.wanniu.game.request.flee;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.FleeHandler;


@GClientEvent("area.fleeHandler.getRewardRequest")
public class GetRewardHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        final FleeHandler.GetRewardRequest req = FleeHandler.GetRewardRequest.parseFrom(this.pak.getRemaingBytes());
        return new PomeloResponse() {
            protected void write() throws IOException {
                FleeHandler.GetRewardResponse res = player.fleeManager.getRewardResponse(req.getGradeId());
                this.body.writeBytes(res.toByteArray());
            }
        };
    }
}


