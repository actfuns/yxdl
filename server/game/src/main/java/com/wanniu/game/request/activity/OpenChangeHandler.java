package com.wanniu.game.request.activity;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.tcp.protocol.Packet;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.ActivityHandler;


@GClientEvent("area.activityHandler.openChangeRequest")
public class OpenChangeHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        return new PomeloResponse() {
            protected void write() throws IOException {
                WNPlayer player = (WNPlayer) OpenChangeHandler.this.pak.getPlayer();
                ActivityHandler.OpenChangeResponse.Builder res = ActivityHandler.OpenChangeResponse.newBuilder();
                ActivityHandler.OpenChangeResponse.Builder changeInfo = player.activityManager.haoliChange();
                changeInfo.setS2CCode(200);
                this.body.writeBytes(changeInfo.build().toByteArray());
            }
        };
    }
}


