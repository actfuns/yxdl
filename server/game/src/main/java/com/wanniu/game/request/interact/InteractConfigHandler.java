package com.wanniu.game.request.interact;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.interact.PlayerInteract;

import java.io.IOException;

import pomelo.area.InteractHandler;


@GClientEvent("area.interactHandler.interactConfigRequest")
public class InteractConfigHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        return new PomeloResponse() {
            protected void write() throws IOException {
                InteractHandler.InteractConfigResponse.Builder res = InteractHandler.InteractConfigResponse.newBuilder();
                res.setS2CCode(200);
                res.addAllS2CData(PlayerInteract.getConfig());
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


