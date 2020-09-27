package com.wanniu.game.request.equip;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.bag.WNBag;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.EquipHandler;


@Deprecated
@GClientEvent("area.equipHandler.fillAllGemRequest")
public class FillAllGemHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        WNPlayer player = (WNPlayer) this.pak.getPlayer();
        WNBag wnBag = player.getWnBag();

        EquipHandler.FillAllGemRequest req = EquipHandler.FillAllGemRequest.parseFrom(this.pak.getRemaingBytes());
        int pos = req.getC2SPos();

        return new PomeloResponse() {
            protected void write() throws IOException {
                EquipHandler.FillAllGemResponse.Builder res = EquipHandler.FillAllGemResponse.newBuilder();
            }
        };
    }
}


