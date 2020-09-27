package com.wanniu.game.request.activity;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.tcp.protocol.Packet;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.ActivityHandler;


@GClientEvent("area.activityHandler.consumeTotalRequest")
public class ConsumeTotalHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        return new PomeloResponse() {
            protected void write() throws IOException {
                WNPlayer player = (WNPlayer) ConsumeTotalHandler.this.pak.getPlayer();
                ActivityHandler.ConsumeTotalResponse.Builder res = ActivityHandler.ConsumeTotalResponse.newBuilder();

                ActivityHandler.totalInfo.Builder data = player.activityManager.consumeTotal();
                res.setS2CCode(200);
                res.setS2CData(data);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


