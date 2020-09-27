package com.wanniu.game.request.equip;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.common.Const;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.ext.ReBornExt;
import com.wanniu.game.equip.EquipManager;
import com.wanniu.game.equip.NormalEquip;
import com.wanniu.game.item.NormalItem;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.sevengoal.SevenGoalManager;

import java.io.IOException;

import pomelo.area.EquipHandler;


@GClientEvent("area.equipHandler.equipRebornRequest")
public class EquipRebornHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        final EquipManager equipManager = player.equipManager;

        EquipHandler.EquipRebornRequest req = EquipHandler.EquipRebornRequest.parseFrom(this.pak.getRemaingBytes());
        final String equipId = req.getEquipId();

        return new PomeloResponse() {
            protected void write() throws IOException {
                EquipHandler.EquipRebornResponse.Builder res = EquipHandler.EquipRebornResponse.newBuilder();

                if (!player.functionOpenManager.isOpen(Const.FunctionType.Reborn.getValue())) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("FUNC_SET_PLAYED_NOT_OPEN"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }
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
                ReBornExt rebornCO = (ReBornExt) GameData.ReBorns.get(Integer.valueOf(equip.prop.levelReq));

                if (player.player.gold < rebornCO.costGold) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("NOT_ENOUGH_GOLD_LEARN"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }
                for (String mateCode : rebornCO.materials.keySet()) {
                    int mateCount = ((Integer) rebornCO.materials.get(mateCode)).intValue();
                    if (player.bag.findItemNumByCode(mateCode) < mateCount) {
                        res.setS2CCode(500);
                        res.setS2CMsg(LangService.getValue("ITEM_NOT_ENOUGH"));
                        this.body.writeBytes(res.build().toByteArray());

                        return;
                    }
                }
                player.moneyManager.costGold(rebornCO.costGold, Const.GOODS_CHANGE_TYPE.Reborn);


                for (String mateCode : rebornCO.materials.keySet()) {
                    int mateCount = ((Integer) rebornCO.materials.get(mateCode)).intValue();
                    player.bag.discardItem(mateCode, mateCount, Const.GOODS_CHANGE_TYPE.Reborn);
                }


                equipManager.reborn(equip, gridIndex, isDressed);

                player.sevenGoalManager.processGoal(SevenGoalManager.SevenGoalTaskType.EQUIP_REBORN_COUNT, new Object[0]);

                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


