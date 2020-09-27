package com.wanniu.game.request.equip;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.equip.EquipManager;
import com.wanniu.game.equip.NormalEquip;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.EquipHandler;


@GClientEvent("area.equipHandler.getRefineExtPropRequest")
public class GetRefineExtPropHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        final EquipManager equipManager = player.equipManager;

        EquipHandler.GetRefineExtPropRequest req = EquipHandler.GetRefineExtPropRequest.parseFrom(this.pak.getRemaingBytes());
        final String equipId = req.getEquipId();

        return new PomeloResponse() {
            protected void write() throws IOException {
                EquipHandler.GetRefineExtPropResponse.Builder res = EquipHandler.GetRefineExtPropResponse.newBuilder();

                int pos = equipManager.getEquipmentById(equipId);
                NormalEquip equip = equipManager.getEquipment(pos);
                if (equip == null) {
                    equip = (NormalEquip) player.bag.findItemById(equipId);
                }

                res.addAllExtAtts(equipManager.getRefineExtProp(equip));

                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


