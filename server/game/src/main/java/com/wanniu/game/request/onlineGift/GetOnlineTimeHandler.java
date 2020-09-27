package com.wanniu.game.request.onlineGift;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.OnlineGiftHandler;


@GClientEvent("area.onlineGiftHandler.getOnlineTimeRequest")
public class GetOnlineTimeHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        return new PomeloResponse() {
            protected void write() throws IOException {
                OnlineGiftHandler.GetOnlineTimeResponse.Builder res = OnlineGiftHandler.GetOnlineTimeResponse.newBuilder();
                long onlineTime = player.onlineGiftManager.onlineData.sumTime;
                res.setS2CCode(200);
                OnlineGiftHandler.OnlineGift.Builder gift = OnlineGiftHandler.OnlineGift.newBuilder();
                gift.setOnlineTime((int) onlineTime);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


