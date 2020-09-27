package com.wanniu.game.request.rich;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.rich.RichHandler;


@GClientEvent("rich.richHandler.getRichInfoRequest")
public class GetRichInfoHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        WNPlayer player = (WNPlayer) this.pak.getPlayer();
        final RichHandler.GetRichInfoResponse.Builder res = player.richManager.getRichInfo(player.getId());


        return new PomeloResponse() {
            protected void write() throws IOException {
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


