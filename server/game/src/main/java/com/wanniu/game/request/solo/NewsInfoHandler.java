package com.wanniu.game.request.solo;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.SoloHandler;


@GClientEvent("area.soloHandler.newsInfoRequest")
public class NewsInfoHandler
        extends SoloRequestFilter {
    public PomeloResponse request(final WNPlayer player) throws Exception {
        return new PomeloResponse() {
            protected void write() throws IOException {
                SoloHandler.NewsInfoResponse.Builder res = SoloHandler.NewsInfoResponse.newBuilder();
                player.soloManager.handleNewsInfo(res);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


