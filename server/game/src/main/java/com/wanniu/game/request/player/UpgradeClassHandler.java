package com.wanniu.game.request.player;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.tcp.protocol.Packet;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.PlayerHandler;


@GClientEvent("area.playerHandler.upgradeClassRequest")
public class UpgradeClassHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        return new PomeloResponse() {
            protected void write() throws IOException {
                WNPlayer player = (WNPlayer) UpgradeClassHandler.this.pak.getPlayer();
                PlayerHandler.UpgradeClassResponse.Builder res = PlayerHandler.UpgradeClassResponse.newBuilder();
                res.setS2CCode(200);
                String result = null;
                if (player != null)
                    result = player.baseDataManager.upgradeClass();
                if (result != null) {
                    res.setS2CCode(500);
                    res.setS2CMsg(result);
                }
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


