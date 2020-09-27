package com.wanniu.game.request.activity;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.tcp.protocol.Packet;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.ActivityHandler;


@GClientEvent("area.activityHandler.reSetluckyAwardRequest")
public class ReSetluckyAwardHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        return new PomeloResponse() {
            protected void write() throws IOException {
                WNPlayer player = (WNPlayer) ReSetluckyAwardHandler.this.pak.getPlayer();
                ActivityHandler.ReSetluckyAwardResponse.Builder res = ActivityHandler.ReSetluckyAwardResponse.newBuilder();
                ActivityHandler.ReSetluckyAwardResponse.Builder data = player.activityManager.reSetluckyAward();
                if (data.getS2CCode() == 200) {

                    res.setS2CCode(200);
                    res.addAllS2CAwards(data.getS2CAwardsList());
                    this.body.writeBytes(res.build().toByteArray());
                } else {
                    res.setS2CCode(500);
                    res.setS2CMsg(data.getS2CMsg());
                    this.body.writeBytes(res.build().toByteArray());
                }
            }
        };
    }
}


