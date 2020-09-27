package com.wanniu.game.request.equip;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.equip.Suit;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;
import java.util.List;

import pomelo.area.EquipHandler;


@GClientEvent("area.equipHandler.getSuitAttrRequest")
public class GetSuitAttrHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();


        return new PomeloResponse() {
            protected void write() throws IOException {
                EquipHandler.GetSuitAttrResponse.Builder res = EquipHandler.GetSuitAttrResponse.newBuilder();

                List<EquipHandler.SuitTypeAttr> list = Suit.getPlayerSuitInfo(player);

                res.setS2CCode(200);
                res.addAllS2CData(list);

                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


