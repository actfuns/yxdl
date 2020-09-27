package com.wanniu.game.request.activity;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.tcp.protocol.Packet;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.ActivityHandler;


@GClientEvent("area.activityHandler.payTotalRequest")
public class PayTotalHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        return new PomeloResponse() {
            protected void write() throws IOException {
                WNPlayer player = (WNPlayer) PayTotalHandler.this.pak.getPlayer();
                ActivityHandler.PayTotalResponse.Builder res = ActivityHandler.PayTotalResponse.newBuilder();

                ActivityHandler.totalInfo.Builder data = player.activityManager.payTotal();
                res.setS2CCode(200);
                res.setS2CData(data.build());
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


