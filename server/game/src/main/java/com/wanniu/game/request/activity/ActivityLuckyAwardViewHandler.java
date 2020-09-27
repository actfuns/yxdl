package com.wanniu.game.request.activity;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.tcp.protocol.Packet;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.ActivityHandler;


@GClientEvent("area.activityHandler.activityLuckyAwardViewRequest")
public class ActivityLuckyAwardViewHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        return new PomeloResponse() {
            protected void write() throws IOException {
                WNPlayer player = (WNPlayer) ActivityLuckyAwardViewHandler.this.pak.getPlayer();
                ActivityHandler.ActivityLuckyAwardViewResponse.Builder data = player.activityManager.activityLuckyAwardView();
                data.setS2CCode(200);
                this.body.writeBytes(data.build().toByteArray());
            }
        };
    }
}


