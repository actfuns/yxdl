package com.wanniu.game.request.interact;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.InteractHandler;


@GClientEvent("area.interactHandler.interactTimesRequest")
public class InteractTimesHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        return new PomeloResponse() {
            protected void write() throws IOException {
                InteractHandler.InteractTimesResponse.Builder data = player.getInteractManager().interactTimes(player);
                data.setS2CCode(200);
                this.body.writeBytes(data.build().toByteArray());
            }
        };
    }
}


