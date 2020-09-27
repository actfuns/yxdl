package com.wanniu.game.request.equip;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.equip.EquipManager;
import com.wanniu.game.equip.NormalEquip;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.EquipHandler;


@GClientEvent("area.equipHandler.refineResetRequest")
public class RefineResetHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        WNPlayer player = (WNPlayer) this.pak.getPlayer();
        final EquipManager wnEquip = player.equipManager;

        EquipHandler.RefineResetRequest req = EquipHandler.RefineResetRequest.parseFrom(this.pak.getRemaingBytes());
        final int equipPos = req.getC2SPos();
        final int propIndex = req.getC2SPropIndex() - 1;

        return new PomeloResponse() {
            protected void write() throws IOException {
                EquipHandler.RefineResetResponse.Builder res = EquipHandler.RefineResetResponse.newBuilder();

                if (propIndex < 0) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("PARAM_ERROR"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                NormalEquip equip = wnEquip.getEquipment(equipPos);
                if (equip == null) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("BAG_STACKINDEX_ILLEGALITY"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                int result = -1;
                if (result == 0) {
                    res.setS2CCode(200);
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == -1) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("REFINE_RESET_PROP_NOT_EXIST"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == -2) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("REFINE_RESET_MATE_NOT_ENOUGH"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                res.setS2CCode(500);
                res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


