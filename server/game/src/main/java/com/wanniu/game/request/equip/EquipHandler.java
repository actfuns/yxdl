package com.wanniu.game.request.equip;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.bag.WNBag;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.msg.ErrorResponse;
import com.wanniu.game.equip.EquipManager;
import com.wanniu.game.equip.NormalEquip;
import com.wanniu.game.item.NormalItem;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;


@GClientEvent("area.equipHandler.equipRequest")
public class EquipHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        final WNBag wnBag = player.getWnBag();
        final EquipManager wnEquip = player.equipManager;

        pomelo.area.EquipHandler.EquipRequest req = pomelo.area.EquipHandler.EquipRequest.parseFrom(this.pak.getRemaingBytes());
        final int gridIndex = req.getC2SGridIndex();
        NormalItem item = wnBag.getItem(gridIndex);

        if (item == null) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("SOMETHING_ERR"));
        }
        if (!item.isEquip()) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("ITEM_NOT_EQUIP"));
        }
        final NormalEquip equip = (NormalEquip) item;
        if (equip.prop.Pro != 0 &&
                equip.prop.Pro != player.getPro()) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("OCCUPATION_WRONG"));
        }


        if (equip.getUpLevel() != 0) {
            if (equip.getUpLevel() > (player.getPlayer()).upLevel) {
                return (PomeloResponse) new ErrorResponse(LangService.getValue("UP_NOT_ENOUGH"));
            }
        } else if (equip.getLevel() > player.getLevel()) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("LEVEL_NOT_ENOUGH"));
        }


        return new PomeloResponse() {
            protected void write() throws IOException {
                pomelo.area.EquipHandler.EquipResponse.Builder res = pomelo.area.EquipHandler.EquipResponse.newBuilder();

                if (equip.prop.itemType == Const.ItemType.Weapon.getValue() && (equip.prop.isBothHand == 1 || wnEquip.haveBothHandWeapon())) {

                    int num = player.equipManager.weaponNum();
                    num--;
                    if (wnBag.emptyGridNum() < num) {
                        res.setS2CCode(500);
                        res.setS2CMsg(LangService.getValue("BAG_NOT_ENOUGH_POS"));
                        this.body.writeBytes(res.build().toByteArray());

                        return;
                    }
                    wnBag.removeItemByPos(gridIndex, false, Const.GOODS_CHANGE_TYPE.equip);
                    NormalEquip mainH = wnEquip.getEquipment(Const.EquipType.MAIN_HAND.getValue());
                    if (mainH != null) {
                        wnBag.addEntityItem((NormalItem) mainH, null, null, true, true);
                        wnEquip.unEquip(Const.EquipType.MAIN_HAND.getValue());
                    }


                    wnEquip.equip(equip);


                    res.setS2CCode(200);
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                NormalEquip oldEquip = player.equipManager.getEquipment(equip.getPosition());
                wnBag.removeItemByPos(gridIndex, false, Const.GOODS_CHANGE_TYPE.equip);
                if (oldEquip != null) {
                    wnBag.addItemToPos(gridIndex, (NormalItem) oldEquip, Const.GOODS_CHANGE_TYPE.equip);
                }
                wnEquip.equip(equip);


                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


