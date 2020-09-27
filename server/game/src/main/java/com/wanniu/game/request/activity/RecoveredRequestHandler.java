package com.wanniu.game.request.activity;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.tcp.protocol.Packet;
import com.wanniu.game.activity.ActivityManager;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.ActivityFavorHandler;


@GClientEvent("area.activityFavorHandler.recoveredRequest")
public class RecoveredRequestHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final ActivityFavorHandler.RecoveredRequest request = ActivityFavorHandler.RecoveredRequest.parseFrom(this.pak.getRemaingBytes());
        return new PomeloResponse() {
            protected void write() throws IOException {
                ActivityManager m = ((WNPlayer) RecoveredRequestHandler.this.pak.getPlayer()).activityManager;
                this.body.writeBytes(m.recoveredRequest(request.getId(), request.getType()).toByteArray());
            }
        };
    }
}


