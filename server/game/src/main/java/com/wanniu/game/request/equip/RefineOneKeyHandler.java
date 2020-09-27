package com.wanniu.game.request.equip;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.util.StringUtil;
import com.wanniu.game.common.Const;
import com.wanniu.game.equip.EquipManager;
import com.wanniu.game.equip.NormalEquip;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;
import java.util.Map;

import pomelo.area.EquipHandler;


@GClientEvent("area.equipHandler.refineOneKeyRequest")
public class RefineOneKeyHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        final EquipManager wnEquip = player.equipManager;

        EquipHandler.RefineOneKeyRequest req = EquipHandler.RefineOneKeyRequest.parseFrom(this.pak.getRemaingBytes());
        final int equipPos = req.getC2SPos();
        final String itemCode = req.getC2SItemCode();

        return new PomeloResponse() {
            protected void write() throws IOException {
                EquipHandler.RefineOneKeyResponse.Builder res = EquipHandler.RefineOneKeyResponse.newBuilder();

                if (StringUtil.isEmpty(itemCode)) {
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
                Map<String, Integer> resData = null;
                int result = ((Integer) resData.get("result")).intValue();
                if (result == 0) {
                    if (((Integer) resData.get("successNum")).intValue() > 0) {
                        res.setS2CCode(200);
                        this.body.writeBytes(res.build().toByteArray());
                        return;
                    }
                    PlayerUtil.sendSysMessageToPlayer(LangService.getValue("REFINE_FAILED_TIPS"), player.getId(), Const.TipsType.NORMAL);
                    res.setS2CCode(500);
                    res.setS2CMsg("");
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == -1) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("EQUIP_CAN_NOT_REFINE"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == -2) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("REFINE_MATE_ERROR"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == 1) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("EQUIPMENT_REFINE_HIGHEST"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == 2) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("REFINE_MATE_NOT_ENOUGH"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == 3) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("CONFIG_ERR"));
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


