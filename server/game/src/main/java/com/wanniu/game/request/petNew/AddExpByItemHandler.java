package com.wanniu.game.request.petNew;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.PetNewHandler;


@GClientEvent("area.petNewHandler.addExpByItemRequest")
public class AddExpByItemHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        WNPlayer player = (WNPlayer) this.pak.getPlayer();
        PetNewHandler.AddExpByItemRequest req = PetNewHandler.AddExpByItemRequest.parseFrom(this.pak.getRemaingBytes());
        int id = req.getC2SId();
        String itemCode = req.getC2SItemCode();

        final PetNewHandler.AddExpByItemResponse.Builder res = player.petNewManager.addExpByItem(id, itemCode, 1);

        return new PomeloResponse() {
            protected void write() throws IOException {
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


