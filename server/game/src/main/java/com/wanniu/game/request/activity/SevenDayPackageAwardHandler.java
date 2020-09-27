package com.wanniu.game.request.activity;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.tcp.protocol.Packet;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.ActivityFavorHandler;


@GClientEvent("area.activityFavorHandler.sevenDayPackageAwardRequest")
public class SevenDayPackageAwardHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final ActivityFavorHandler.SevenDayPackageAwardRequest req = ActivityFavorHandler.SevenDayPackageAwardRequest.parseFrom(this.pak.getRemaingBytes());
        return new PomeloResponse() {
            protected void write() throws IOException {
                WNPlayer player = (WNPlayer) SevenDayPackageAwardHandler.this.pak.getPlayer();

                ActivityFavorHandler.SevenDayPackageAwardResponse response = player.activityManager.receiveSevenDayPackageAward(req.getPackageId());
                this.body.writeBytes(response.toByteArray());
            }
        };
    }
}


