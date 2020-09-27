package com.wanniu.game.request.equip;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.bag.WNBag;
import com.wanniu.game.common.msg.ErrorResponse;
import com.wanniu.game.equip.EquipManager;
import com.wanniu.game.equip.NormalEquip;
import com.wanniu.game.item.NormalItem;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.EquipHandler;


@GClientEvent("area.equipHandler.unEquipRequest")
public class UnEquipHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        WNPlayer player = (WNPlayer) this.pak.getPlayer();
        WNBag wnBag = player.getWnBag();
        EquipManager wnEquip = player.equipManager;

        EquipHandler.UnEquipRequest req = EquipHandler.UnEquipRequest.parseFrom(this.pak.getRemaingBytes());
        int gridIndex = req.getC2SGridIndex();

        NormalEquip normalEquip = wnEquip.getEquipment(gridIndex);
        if (normalEquip == null) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("EQUIP_NOT_EQUIP"));
        }

        ((NormalItem) normalEquip).itemDb.isNew = 0;
        if (!wnBag.testAddEntityItem((NormalItem) normalEquip, true)) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("BAG_NOT_ENOUGH_POS"));
        }

        wnEquip.unEquip(gridIndex);
        wnBag.addEntityItem((NormalItem) normalEquip, null, null, true, false);

        return new PomeloResponse() {
            protected void write() throws IOException {
                EquipHandler.UnEquipResponse.Builder res = EquipHandler.UnEquipResponse.newBuilder();
                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


