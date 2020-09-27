package com.wanniu.game.request.equip;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.equip.EquipUtil;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.PlayerBasePO;

import java.io.IOException;

import pomelo.area.EquipHandler;


@GClientEvent("area.equipHandler.equipPreStrengthenRequest")
public class EquipPreStrengthenHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();

        EquipHandler.EquipPreStrengthenRequest req = EquipHandler.EquipPreStrengthenRequest.parseFrom(this.pak.getRemaingBytes());
        final int pos = req.getC2SPos();

        return new PomeloResponse() {
            protected void write() throws IOException {
                EquipHandler.EquipPreStrengthenResponse.Builder res = EquipHandler.EquipPreStrengthenResponse.newBuilder();

                PlayerBasePO.EquipStrengthPos strengthPos = (PlayerBasePO.EquipStrengthPos) player.equipManager.strengthPos.get(Integer.valueOf(pos));
                if (strengthPos == null) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("EQUIP_POS_NOT_EXIST"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                res.setS2CStrengthenData(EquipUtil.getStrengthInfo(player, pos));

                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


