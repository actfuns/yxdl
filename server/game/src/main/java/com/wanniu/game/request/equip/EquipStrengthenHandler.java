package com.wanniu.game.request.equip;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.bag.WNBag;
import com.wanniu.game.common.Const;
import com.wanniu.game.data.ext.EnchantExt;
import com.wanniu.game.equip.EquipManager;
import com.wanniu.game.equip.EquipUtil;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.PlayerBasePO;

import java.io.IOException;

import pomelo.area.EquipHandler;


@GClientEvent("area.equipHandler.equipStrengthenRequest")
public class EquipStrengthenHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        final WNBag wnBag = player.getWnBag();
        final EquipManager wnEquip = player.equipManager;

        EquipHandler.EquipStrengthenRequest req = EquipHandler.EquipStrengthenRequest.parseFrom(this.pak.getRemaingBytes());
        final int pos = req.getC2SPos();

        return new PomeloResponse() {
            protected void write() throws IOException {
                EquipHandler.EquipStrengthenResponse.Builder res = EquipHandler.EquipStrengthenResponse.newBuilder();

                if (!player.functionOpenManager.isOpen(Const.FunctionType.STRENGTHEN.getValue())) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("FUNC_SET_PLAYED_NOT_OPEN"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }
                PlayerBasePO.EquipStrengthPos strengthPos = (PlayerBasePO.EquipStrengthPos) player.equipManager.strengthPos.get(Integer.valueOf(pos));
                if (strengthPos == null) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("EQUIP_POS_NOT_EXIST"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }
                if (EquipUtil.isMaxStrengthLevel(strengthPos.enSection, strengthPos.enLevel)) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("EQUIP_MAX_STRENGTH_LEVEL"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }
                EnchantExt prop = EquipUtil.getStrengthConfig(strengthPos.enSection, strengthPos.enLevel);
                if (prop == null) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }
                if (player.moneyManager.getGold() < prop.costGold) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("GOLD_NOT_ENOUGH"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }

                for (String mateCode : prop.mates.keySet()) {
                    int haveNum = wnBag.findItemNumByCode(mateCode);
                    int needNum = prop.mates.getIntValue(mateCode);
                    if (haveNum < needNum) {
                        res.setS2CCode(500);
                        res.setS2CMsg(LangService.getValue("ITEM_NOT_ENOUGH"));
                        this.body.writeBytes(res.build().toByteArray());

                        return;
                    }
                }

                for (String mateCode : prop.mates.keySet()) {
                    int needNum = prop.mates.getIntValue(mateCode);
                    wnBag.discardItem(mateCode, needNum, Const.GOODS_CHANGE_TYPE.equipstrengh, null, false, false);
                }

                player.moneyManager.costGold(prop.costGold, Const.GOODS_CHANGE_TYPE.equipstrengh);

                Object[] result = wnEquip.equipStrengthen(pos);

                res.setS2CStrengthenData(EquipUtil.getStrengthInfo(player, pos));
                if (((Boolean) result[0]).booleanValue()) {
                    res.setS2CSuccess(1);
                } else {
                    res.setS2CSuccess(1);
                }

                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


