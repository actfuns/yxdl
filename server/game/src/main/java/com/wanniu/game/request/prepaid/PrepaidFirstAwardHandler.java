package com.wanniu.game.request.prepaid;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.PrepaidHandler;


@GClientEvent("area.prepaidHandler.prepaidFirstAwardRequest")
public class PrepaidFirstAwardHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        return new PomeloResponse() {
            protected void write() throws IOException {
                PrepaidHandler.PrepaidFirstResponse res = player.prepaidManager.getPrepaidFirstAward();
                this.body.writeBytes(res.toByteArray());
            }
        };
    }
}


