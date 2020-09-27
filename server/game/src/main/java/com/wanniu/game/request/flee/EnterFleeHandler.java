package com.wanniu.game.request.flee;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.FleeHandler;


@GClientEvent("area.fleeHandler.enterFleeRequest")
public class EnterFleeHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        return new PomeloResponse() {
            protected void write() throws IOException {
                FleeHandler.EnterFleeResponse res = player.fleeManager.enterFlee();
                this.body.writeBytes(res.toByteArray());
            }
        };
    }
}


