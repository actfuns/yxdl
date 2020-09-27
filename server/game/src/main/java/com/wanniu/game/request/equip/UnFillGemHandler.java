package com.wanniu.game.request.equip;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.bag.WNBag;
import com.wanniu.game.equip.EquipManager;
import com.wanniu.game.equip.EquipUtil;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.PlayerBasePO;

import java.io.IOException;
import java.util.List;

import pomelo.area.EquipHandler;


@GClientEvent("area.equipHandler.unFillGemRequest")
public class UnFillGemHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        WNPlayer player = (WNPlayer) this.pak.getPlayer();
        final WNBag wnBag = player.getWnBag();
        final EquipManager wnEquip = player.equipManager;

        EquipHandler.UnFillGemRequest req = EquipHandler.UnFillGemRequest.parseFrom(this.pak.getRemaingBytes());
        final int pos = req.getC2SPos();
        final int index = req.getC2SIndex();

        return new PomeloResponse() {
            protected void write() throws IOException {
                EquipHandler.UnFillGemResponse.Builder res = EquipHandler.UnFillGemResponse.newBuilder();
                PlayerBasePO.EquipStrengthPos posInfo = (PlayerBasePO.EquipStrengthPos) wnEquip.strengthPos.get(Integer.valueOf(pos));
                if (posInfo == null) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("EQUIP_NOT_EXIST"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }
                List<WNBag.SimpleItemInfo> gemList = EquipUtil.getGemList(posInfo, index);
                if (gemList.size() == 0) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("EQUIP_UNFILL_ERROR"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }
                if (!wnBag.testAddCodeItems(gemList, null, false)) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("BAG_NOT_ENOUGH_POS"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }
                if (wnEquip.unfillGem(pos, index)) {
                    res.setS2CCode(200);
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }
                res.setS2CCode(500);
                res.setS2CMsg(LangService.getValue("EQUIP_UNFILL_ERROR"));
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


