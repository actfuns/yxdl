package com.wanniu.game.request.petNew;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.tcp.protocol.Packet;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.PetNewHandler;


@GClientEvent("area.petNewHandler.getPetInfoNewRequest")
public class GetPetInfoNewHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        return new PomeloResponse() {
            protected void write() throws IOException {
                PetNewHandler.GetPetInfoNewRequest req = PetNewHandler.GetPetInfoNewRequest.parseFrom(GetPetInfoNewHandler.this.pak.getRemaingBytes());
                PetNewHandler.GetPetInfoNewResponse.Builder res = player.petNewManager.getPetInfo(req.getC2SPetId());
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


