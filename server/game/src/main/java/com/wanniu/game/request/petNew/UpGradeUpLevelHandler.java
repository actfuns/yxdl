package com.wanniu.game.request.petNew;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.tcp.protocol.Packet;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.PetNewHandler;


@GClientEvent("area.petNewHandler.upGradeUpLevelRequest")
public class UpGradeUpLevelHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        return new PomeloResponse() {
            protected void write() throws IOException {
                PetNewHandler.UpGradeUpLevelRequest req = PetNewHandler.UpGradeUpLevelRequest.parseFrom(UpGradeUpLevelHandler.this.pak.getRemaingBytes());
                int id = req.getC2SId();
                PetNewHandler.UpGradeUpLevelResponse.Builder res = player.petNewManager.upgradeUplevel(id);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


