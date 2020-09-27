package com.wanniu.game.request.sevengoal;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.sevengoal.SevenGoalHandler;


@GClientEvent("sevengoal.sevenGoalHandler.fetchAwardRequest")
public class FetchAwardHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        WNPlayer player = (WNPlayer) this.pak.getPlayer();
        SevenGoalHandler.FetchAwardRequest request = SevenGoalHandler.FetchAwardRequest.parseFrom(this.pak.getRemaingBytes());
        int dayId = request.getId();
        final SevenGoalHandler.FetchAwardResponse.Builder res = player.sevenGoalManager.fetchAward(dayId);


        return new PomeloResponse() {
            protected void write() throws IOException {
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


