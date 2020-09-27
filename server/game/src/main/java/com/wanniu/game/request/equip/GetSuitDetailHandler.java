package com.wanniu.game.request.equip;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.equip.Suit;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.EquipHandler;


@GClientEvent("area.equipHandler.getSuitDetailRequest")
public class GetSuitDetailHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();

        EquipHandler.GetSuitDetailRequest req = EquipHandler.GetSuitDetailRequest.parseFrom(this.pak.getRemaingBytes());
        final int suitType = req.getC2SSuitType();

        return new PomeloResponse() {
            protected void write() throws IOException {
                EquipHandler.GetSuitDetailResponse.Builder res = EquipHandler.GetSuitDetailResponse.newBuilder();


                res.setS2CCode(200);
                res.addAllS2CData(Suit.getSuitTypeDetail(player.getPro(), suitType));

                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


