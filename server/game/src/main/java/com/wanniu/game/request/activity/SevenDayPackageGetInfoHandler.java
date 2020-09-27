package com.wanniu.game.request.activity;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.tcp.protocol.Packet;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;


@GClientEvent("area.activityFavorHandler.sevenDayPackageGetInfoRequest")
public class SevenDayPackageGetInfoHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        return new PomeloResponse() {
            protected void write() throws IOException {
                WNPlayer player = (WNPlayer) SevenDayPackageGetInfoHandler.this.pak.getPlayer();
                this.body.writeBytes(player.activityManager.getSevenDayPackageGetInfo().toByteArray());
            }
        };
    }
}


