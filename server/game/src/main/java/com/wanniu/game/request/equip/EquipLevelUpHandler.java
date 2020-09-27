package com.wanniu.game.request.equip;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.common.Const;
import com.wanniu.game.equip.NormalEquip;
import com.wanniu.game.item.ItemUtil;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import pomelo.area.EquipHandler;


@GClientEvent("area.equipHandler.equipLevelUpRequest")
public class EquipLevelUpHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();

        EquipHandler.EquipLevelUpRequest req = EquipHandler.EquipLevelUpRequest.parseFrom(this.pak.getRemaingBytes());
        final EquipHandler.EquipPos equipPos = req.getC2SEquipPos();
        final int _mateType = req.getC2SMateType();

        return new PomeloResponse() {
            protected void write() throws IOException {
                EquipHandler.EquipLevelUpResponse.Builder res = EquipHandler.EquipLevelUpResponse.newBuilder();

                int mateType = _mateType;
                if (mateType != 1 && mateType != 2) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("PARAM_ERROR"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }
                NormalEquip oldEquip = (NormalEquip) ItemUtil.getEquip(player, equipPos);
                if (oldEquip == null) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("EQUIP_NOT_EXIST"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (!oldEquip.isEquip()) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("ITEM_NOT_EQUIP"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (oldEquip.prop.itemType != Const.ItemType.Weapon.getValue() && oldEquip.prop.itemType != Const.ItemType.Armor.getValue()) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("EQUIP_CAN_NOT_LEVEL_UP"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }
                int minColor = GlobalConfig.Equipment_LvUp_QColor;
                if (oldEquip.prop.qcolor < minColor) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("EQUIP_LEVEL_UP_QUALITY_TO_LOW"));
                    this.body.writeBytes(res.build().toByteArray());


                    return;
                }

                if (equipPos.getBagOrBody() == Const.EquipPos.BODY.value) {
                    player.equipManager.unEquip(oldEquip.getPosition());
                } else {
                    player.getWnBag().removeItemByPos(equipPos.getPosOrGrid(), true, Const.GOODS_CHANGE_TYPE.equipLevelUp);
                }
                Map<String, Integer> biItems = new HashMap<>();
                biItems.put(oldEquip.itemDb.code, Integer.valueOf(1));

                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


