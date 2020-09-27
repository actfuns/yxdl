package com.wanniu.game.request.onlineGift;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.OnlineGiftHandler;


@GClientEvent("area.onlineGiftHandler.getGiftInfoRequest")
public class GetGiftInfoHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();


        return new PomeloResponse() {
            protected void write() throws IOException {
                OnlineGiftHandler.GetGiftInfoResponse.Builder res = OnlineGiftHandler.GetGiftInfoResponse.newBuilder();
                res.setS2CCode(200);
                OnlineGiftHandler.OnlineGift gift = player.onlineGiftManager.toJson4Payload();
                res.setS2CGift(gift);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


