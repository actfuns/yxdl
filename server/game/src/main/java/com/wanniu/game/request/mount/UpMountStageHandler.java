package com.wanniu.game.request.mount;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.entity.GPlayer;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.MountHandler;


@GClientEvent("area.mountHandler.upMountStageRequest")
public class UpMountStageHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        MountHandler.UpMountStageRequest req = MountHandler.UpMountStageRequest.parseFrom(this.pak.getRemaingBytes());
        GPlayer player = this.pak.getPlayer();
        WNPlayer wPlayer = (WNPlayer) player;
        return new PomeloResponse() {
            protected void write() throws IOException {
            }
        };
    }
}


