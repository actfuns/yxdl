package com.wanniu.game.request.prepaid;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;
import java.util.List;

import pomelo.area.PrepaidHandler;


@GClientEvent("area.prepaidHandler.prepaidListRequest")
public class PrepaidListHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        return new PomeloResponse() {
            protected void write() throws IOException {
                PrepaidHandler.PrepaidListResponse.Builder res = PrepaidHandler.PrepaidListResponse.newBuilder();
                List<PrepaidHandler.FeeItem> items = player.prepaidManager.getPrepaidList();
                res.addAllS2CItems(items);
                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


