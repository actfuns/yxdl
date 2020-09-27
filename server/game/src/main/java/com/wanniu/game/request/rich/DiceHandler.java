package com.wanniu.game.request.rich;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.rich.RichHandler;


@GClientEvent("rich.richHandler.diceRequest")
public class DiceHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();


        return new PomeloResponse() {
            protected void write() throws IOException {
                RichHandler.DiceResponse.Builder res = player.richManager.dice(player.getId());

                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


