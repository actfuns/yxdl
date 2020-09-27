package com.wanniu.game.request.activity;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.tcp.protocol.Packet;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.ActivityHandler;


@GClientEvent("area.activityHandler.activityLevelOrSwordRequest")
public class ActivityLevelOrSwordHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final ActivityHandler.ActivityLevelOrSwordRequest req = ActivityHandler.ActivityLevelOrSwordRequest.parseFrom(this.pak.getRemaingBytes());
        return new PomeloResponse() {
            protected void write() throws IOException {
                WNPlayer player = (WNPlayer) ActivityLevelOrSwordHandler.this.pak.getPlayer();
                ActivityHandler.ActivityLevelOrSwordResponse.Builder res = ActivityHandler.ActivityLevelOrSwordResponse.newBuilder();
                res = player.activityManager.levelOrSword(req.getC2SActivityId());
                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


