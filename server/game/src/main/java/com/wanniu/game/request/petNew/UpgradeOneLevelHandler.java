package com.wanniu.game.request.petNew;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.tcp.protocol.Packet;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.PetNewHandler;


@GClientEvent("area.petNewHandler.upgradeOneLevelRequest")
public class UpgradeOneLevelHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();

        return new PomeloResponse() {
            protected void write() throws IOException {
                PetNewHandler.UpgradeOneLevelRequest req = PetNewHandler.UpgradeOneLevelRequest.parseFrom(UpgradeOneLevelHandler.this.pak.getRemaingBytes());
                int id = req.getC2SId();
                PetNewHandler.UpgradeOneLevelResponse.Builder res = player.petNewManager.reqUpgradeOneLevel(id);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


