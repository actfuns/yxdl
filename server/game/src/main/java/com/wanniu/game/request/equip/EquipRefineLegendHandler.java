package com.wanniu.game.request.equip;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.msg.ErrorResponse;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.ext.KaiGuangExt;
import com.wanniu.game.equip.EquipManager;
import com.wanniu.game.equip.NormalEquip;
import com.wanniu.game.item.NormalItem;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.sevengoal.SevenGoalManager;

import java.io.IOException;

import pomelo.area.EquipHandler;


@GClientEvent("area.equipHandler.equipRefineLegendRequest")
public class EquipRefineLegendHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        WNPlayer player = (WNPlayer) this.pak.getPlayer();


        if (!player.functionOpenManager.isOpen(Const.FunctionType.REFINE.getValue())) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("FUNC_SET_PLAYED_NOT_OPEN"));
        }

        EquipHandler.EquipRefineLegendRequest req = EquipHandler.EquipRefineLegendRequest.parseFrom(this.pak.getRemaingBytes());
        String equipId = req.getEquipId();
        EquipManager equipManager = player.equipManager;

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
            return (PomeloResponse) new ErrorResponse(LangService.getValue("BAG_STACKINDEX_ILLEGALITY"));
        }


        if (equip.prop.qcolor <= Const.ItemQuality.PURPLE.getValue()) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("EQUIP_REFINE_LEGEND_PURPLE"));
        }


        KaiGuangExt rebornCO = (KaiGuangExt) GameData.KaiGuangs.get(Integer.valueOf(equip.prop.levelReq));

        if (player.player.gold < rebornCO.costGold) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("NOT_ENOUGH_GOLD_LEARN"));
        }

        for (String mateCode : rebornCO.materials.keySet()) {
            int mateCount = ((Integer) rebornCO.materials.get(mateCode)).intValue();
            if (player.bag.findItemNumByCode(mateCode) < mateCount) {
                return (PomeloResponse) new ErrorResponse(LangService.getValue("ITEM_NOT_ENOUGH"));
            }
        }


        player.moneyManager.costGold(rebornCO.costGold, Const.GOODS_CHANGE_TYPE.Refine);

        for (String mateCode : rebornCO.materials.keySet()) {
            int mateCount = ((Integer) rebornCO.materials.get(mateCode)).intValue();
            player.bag.discardItem(mateCode, mateCount, Const.GOODS_CHANGE_TYPE.Refine);
        }


        equipManager.refineLegend(equip, gridIndex, isDressed);

        player.sevenGoalManager.processGoal(SevenGoalManager.SevenGoalTaskType.EQUIP_REFINE_COUNT, new Object[0]);

        return new PomeloResponse() {
            protected void write() throws IOException {
                EquipHandler.EquipRefineLegendResponse.Builder res = EquipHandler.EquipRefineLegendResponse.newBuilder();
                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


