package com.wanniu.game.request.activity;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.tcp.protocol.Packet;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.ActivityHandler;


@GClientEvent("area.activityHandler.paySecondRequest")
public class PaySecondHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        ActivityHandler.PaySecondRequest req = ActivityHandler.PaySecondRequest.parseFrom(this.pak.getRemaingBytes());
        return new PomeloResponse() {
            protected void write() throws IOException {
                WNPlayer player = (WNPlayer) PaySecondHandler.this.pak.getPlayer();
                ActivityHandler.PaySecondResponse.Builder res = ActivityHandler.PaySecondResponse.newBuilder();

                ActivityHandler.PayFirstResponse.Builder data = player.activityManager.paySecond();
                data.setS2CCode(200);
                this.body.writeBytes(data.build().toByteArray());
            }
        };
    }
}


