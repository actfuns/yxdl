package com.wanniu.game.request.petNew;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.tcp.protocol.Packet;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.PetNewHandler;


@GClientEvent("area.petNewHandler.petFightRequest")
public class PetFightHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();

        return new PomeloResponse() {
            protected void write() throws IOException {
                PetNewHandler.PetFightRequest req = PetNewHandler.PetFightRequest.parseFrom(PetFightHandler.this.pak.getRemaingBytes());
                int id = req.getC2SId();
                int type = req.getC2SType();
                PetNewHandler.ChangePetNameNewResponse.Builder res = PetNewHandler.ChangePetNameNewResponse.newBuilder();

                String msg = player.petNewManager.petOutFight(id, type);
                if (msg != null) {

                    res.setS2CMsg(msg);
                    res.setS2CCode(500);
                } else {
                    res.setS2CCode(200);
                }
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


