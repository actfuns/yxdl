package com.wanniu.game.request.activity;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.tcp.protocol.Packet;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.ActivityHandler;


@GClientEvent("area.activityHandler.payFirstRequest")
public class PayFirstRequestHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        return new PomeloResponse() {
            protected void write() throws IOException {
                WNPlayer player = (WNPlayer) PayFirstRequestHandler.this.pak.getPlayer();
                ActivityHandler.PayFirstResponse.Builder res = ActivityHandler.PayFirstResponse.newBuilder();
                ActivityHandler.PayFirstResponse.Builder data = player.activityManager.payFirst();
                data.setS2CCode(200);
                this.body.writeBytes(data.build().toByteArray());
            }
        };
    }
}


