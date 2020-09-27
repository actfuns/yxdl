package com.wanniu.game.request.mount;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.entity.GPlayer;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.MountHandler;


@GClientEvent("area.mountHandler.saveMountRequest")
public class SaveMountHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        MountHandler.SaveMountRequest req = MountHandler.SaveMountRequest.parseFrom(this.pak.getRemaingBytes());
        GPlayer player = this.pak.getPlayer();
        WNPlayer wPlayer = (WNPlayer) player;
        int skinId = req.getC2SSkinId();
        int mountId = req.getC2SMountId();
        return new PomeloResponse() {
            protected void write() throws IOException {
            }
        };
    }
}


