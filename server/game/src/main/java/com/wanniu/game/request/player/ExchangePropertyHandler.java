package com.wanniu.game.request.player;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.PlayerHandler;


@GClientEvent("area.playerHandler.exchangePropertyRequest")
public class ExchangePropertyHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        PlayerHandler.ExchangePropertyRequest request = PlayerHandler.ExchangePropertyRequest.parseFrom(this.pak.getRemaingBytes());
        int type = request.getType();

        WNPlayer player = (WNPlayer) this.pak.getPlayer();

        PomeloResponse result = player.baseDataManager.exchange(type);
        if (result != null) {
            return result;
        }

        final PlayerHandler.ExchangePropertyResponse.Builder res = PlayerHandler.ExchangePropertyResponse.newBuilder();
        res.setS2CCode(200);
        res.setCount((player.getPlayer()).exchangCount);

        return new PomeloResponse() {
            protected void write() throws IOException {
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


