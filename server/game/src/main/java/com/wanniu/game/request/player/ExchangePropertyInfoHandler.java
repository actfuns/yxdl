package com.wanniu.game.request.player;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.PlayerHandler;


@GClientEvent("area.playerHandler.exchangePropertyInfoRequest")
public class ExchangePropertyInfoHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        WNPlayer player = (WNPlayer) this.pak.getPlayer();

        final PlayerHandler.ExchangePropertyInfoResponse.Builder res = PlayerHandler.ExchangePropertyInfoResponse.newBuilder();
        res.setS2CCode(200);
        res.setCount((player.getPlayer()).exchangCount);

        return new PomeloResponse() {
            protected void write() throws IOException {
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


