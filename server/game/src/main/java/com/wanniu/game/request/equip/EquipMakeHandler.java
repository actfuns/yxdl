package com.wanniu.game.request.equip;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.util.StringUtil;
import com.wanniu.game.bag.WNBag;
import com.wanniu.game.common.Const;
import com.wanniu.game.data.ext.EquipMakeExt;
import com.wanniu.game.equip.EquipCraftConfig;
import com.wanniu.game.equip.EquipCraftUtil;
import com.wanniu.game.item.ItemUtil;
import com.wanniu.game.item.NormalItem;
import com.wanniu.game.item.po.DetailItemNum;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;
import java.util.List;

import pomelo.area.EquipHandler;


@GClientEvent("area.equipHandler.equipMakeRequest")
public class EquipMakeHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();

        EquipHandler.EquipMakeRequest req = EquipHandler.EquipMakeRequest.parseFrom(this.pak.getRemaingBytes());
        final String targetCode = req.getC2STargetCode();

        return new PomeloResponse() {
            protected void write() throws IOException {
                EquipHandler.EquipMakeResponse.Builder res = EquipHandler.EquipMakeResponse.newBuilder();


                if (!player.functionOpenManager.isOpen(Const.FunctionType.Make.getValue())) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("FUNC_SET_PLAYED_NOT_OPEN"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }
                if (StringUtil.isEmpty(targetCode)) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("PARAM_ERROR"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }
                EquipMakeExt makeProp = EquipCraftConfig.getInstance().getEquipMakePropByCode(targetCode);
                if (makeProp == null) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("EQUIP_MAKE_NOT_MAKE_PAPER"));
                    this.body.writeBytes(res.build().toByteArray());


                    return;
                }

                if (player.player.gold < makeProp.costMoney) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("GOLD_NOT_ENOUGH"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }
                List<WNBag.SimpleItemInfo> reqMate = makeProp.reqMate;
                for (int i = 0; i < reqMate.size(); i++) {
                    WNBag.SimpleItemInfo itemInfo = reqMate.get(i);
                    DetailItemNum mateInfo = player.getWnBag().findDetailItemNumByCode(itemInfo.itemCode);
                    if (mateInfo.totalNum < itemInfo.itemNum) {
                        res.setS2CCode(500);
                        res.setS2CMsg(LangService.getValue("EQUIP_MAKE_MATE_NOT_ENOUGH"));
                        this.body.writeBytes(res.build().toByteArray());


                        return;
                    }
                }


                Const.ForceType forceType = Const.ForceType.BIND;
                if (!player.getWnBag().testAddCodeItem(targetCode, 1, forceType, true)) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("BAG_NOT_ENOUGH_POS"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }

                player.moneyManager.costGold(makeProp.costMoney, Const.GOODS_CHANGE_TYPE.equipMake);


                for (int j = 0; j < reqMate.size(); j++) {
                    WNBag.SimpleItemInfo mateInfo = reqMate.get(j);
                    player.getWnBag().discardItem(mateInfo.itemCode, mateInfo.itemNum, Const.GOODS_CHANGE_TYPE.equipMake, null, false, false);
                }


                NormalItem newEquip = ItemUtil.createItemsByItemCode(targetCode, 1).get(0);
                newEquip.setBind(ItemUtil.getPropBindType(newEquip.prop, forceType));
                player.getWnBag().addEntityItem(newEquip, Const.GOODS_CHANGE_TYPE.equipMake, null, false, false);
                EquipCraftUtil.sendEquipMakeMsg(player, newEquip);


                player.taskManager.dealTaskEvent(Const.TaskType.EQUIP_MAKE, "", 1);

                player.achievementManager.onEquipMake();

                player.equipManager.updateMakeScript(null);

                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


