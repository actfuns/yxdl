package com.wanniu.game.request.rich;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.rich.RichHandler;


@GClientEvent("rich.richHandler.fetchTurnAwardRequest")
public class FetchTurnAwardHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        WNPlayer player = (WNPlayer) this.pak.getPlayer();
        RichHandler.FetchTurnAwardRequest req = RichHandler.FetchTurnAwardRequest.parseFrom(this.pak.getRemaingBytes());
        int turnId = req.getId();

        final RichHandler.FetchTurnAwardResponse.Builder res = player.richManager.fetchTurnAward(player.getId(), turnId);


        return new PomeloResponse() {
            protected void write() throws IOException {
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


