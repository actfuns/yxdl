package com.wanniu.game.request.petNew;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.tcp.protocol.Packet;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.PetNewHandler;


@GClientEvent("area.petNewHandler.changePetNameNewRequest")
public class ChangePetNameNewHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();

        return new PomeloResponse() {
            protected void write() throws IOException {
                PetNewHandler.ChangePetNameNewRequest req = PetNewHandler.ChangePetNameNewRequest.parseFrom(ChangePetNameNewHandler.this.pak.getRemaingBytes());
                int id = req.getC2SId();
                String name = req.getC2SName();
                PetNewHandler.ChangePetNameNewResponse.Builder res = player.petNewManager.changePetName(id, name);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


