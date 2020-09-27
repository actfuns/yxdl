package com.wanniu.game.request.equip;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.equip.EquipManager;
import com.wanniu.game.equip.NormalEquip;
import com.wanniu.game.item.NormalItem;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.EquipHandler;


@GClientEvent("area.equipHandler.saveRefineLegendRequest")
public class SaveRefineLegendHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        final EquipManager equipManager = player.equipManager;

        EquipHandler.SaveRefineLegendRequest req = EquipHandler.SaveRefineLegendRequest.parseFrom(this.pak.getRemaingBytes());
        final String equipId = req.getEquipId();

        return new PomeloResponse() {
            protected void write() throws IOException {
                EquipHandler.SaveRefineLegendResponse.Builder res = EquipHandler.SaveRefineLegendResponse.newBuilder();
                boolean isDressed = true;
                NormalEquip equip = null;
                int gridIndex = equipManager.getEquipmentById(equipId);
                if (gridIndex > 0) {
                    equip = equipManager.getEquipment(gridIndex);
                }

                if (equip == null) {
                    isDressed = false;
                    NormalItem item = player.bag.findItemById(equipId);
                    if (item != null) {
                        equip = (NormalEquip) item;
                        gridIndex = player.bag.findPosById(equipId);
                    }
                }
                if (equip == null) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("BAG_STACKINDEX_ILLEGALITY"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }
                equipManager.saveRefineLegend(equip, gridIndex, isDressed);

                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


