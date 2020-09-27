package com.wanniu.game.request.equip;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.util.StringUtil;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.msg.ErrorResponse;
import com.wanniu.game.data.ext.SmritiExt;
import com.wanniu.game.equip.EquipManager;
import com.wanniu.game.equip.NormalEquip;
import com.wanniu.game.item.NormalItem;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;
import java.util.List;

import pomelo.area.EquipHandler;


@GClientEvent("area.equipHandler.smritiRequest")
public class EquipSmritiHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        final EquipManager equipManager = player.equipManager;

        EquipHandler.SmritiRequest req = EquipHandler.SmritiRequest.parseFrom(this.pak.getRemaingBytes());
        String leftEquipId = req.getLetfEquipId();
        String rightEquipId = req.getRightEquipId();
        if (StringUtil.isEmpty(leftEquipId) || StringUtil.isEmpty(rightEquipId) || leftEquipId.endsWith(rightEquipId)) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("DATA_ERR"));
        }
        final Object[] leftFlag = checkEquipExists(leftEquipId, player);
        boolean isExists = ((Boolean) leftFlag[0]).booleanValue();
        if (!isExists) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("BAG_STACKINDEX_ILLEGALITY"));
        }
        final Object[] rightFlag = checkEquipExists(rightEquipId, player);
        isExists = ((Boolean) rightFlag[0]).booleanValue();
        if (!isExists) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("BAG_STACKINDEX_ILLEGALITY"));
        }
        final NormalEquip leftEquip = (NormalEquip) leftFlag[3];
        final NormalEquip rightEquip = (NormalEquip) rightFlag[3];
        if (rightEquip.prop.tcLevel < leftEquip.prop.tcLevel) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("EQUIP_SMRITI_LEVEL"));
        }
        if (rightEquip.prop.qcolor < Const.EQUIP_QCOLOR.GREEN.value) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("EQUIP_SMRITI_QULITY"));
        }
        if (leftEquip.speData.extAtts == null || leftEquip.speData.extAtts.isEmpty()) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("EQUIP_SMRITI_CANNOT"));
        }

        return new PomeloResponse() {
            protected void write() throws IOException {
                EquipHandler.SmritiResponse.Builder res = EquipHandler.SmritiResponse.newBuilder();
                if (!player.functionOpenManager.isOpen(Const.FunctionType.Inherit.getValue())) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("FUNC_SET_PLAYED_NOT_OPEN"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                List<SmritiExt> coList = equipManager.findSmritiCO(leftEquip.prop.tcLevel);
                if (coList == null || coList.isEmpty()) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("CONFIG_ERR"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                SmritiExt smritiCo = coList.get(0);


                for (String mateCode : smritiCo.getNeedItems().keySet()) {
                    int mateCount = ((Integer) smritiCo.getNeedItems().get(mateCode)).intValue();

                    if (player.bag.findItemNumByCode(mateCode) < mateCount) {
                        res.setS2CCode(500);
                        res.setS2CMsg(LangService.getValue("ITEM_NOT_ENOUGH"));
                        this.body.writeBytes(res.build().toByteArray());
                        return;
                    }
                }
                boolean leftIsDressed = ((Boolean) leftFlag[1]).booleanValue();
                int leftGridIndex = ((Integer) leftFlag[2]).intValue();

                boolean rightIsDressed = ((Boolean) rightFlag[1]).booleanValue();
                int rightGridIndex = ((Integer) rightFlag[2]).intValue();

                if (player.player.gold < smritiCo.costGold) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("NOT_ENOUGH_GOLD_LEARN"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }

                player.moneyManager.costGold(smritiCo.costGold, Const.GOODS_CHANGE_TYPE.inherit);


                for (String mateCode : smritiCo.getNeedItems().keySet()) {
                    int mateCount = ((Integer) smritiCo.getNeedItems().get(mateCode)).intValue();
                    player.bag.discardItem(mateCode, mateCount, Const.GOODS_CHANGE_TYPE.inherit);
                }
                equipManager.smritiEquip(leftEquip, leftGridIndex, leftIsDressed, rightEquip, rightGridIndex, rightIsDressed);
                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }


    private Object[] checkEquipExists(String equipId, WNPlayer player) {
        Object[] obj = new Object[4];
        obj[0] = Boolean.valueOf(true);
        obj[1] = Boolean.valueOf(true);
        obj[2] = Integer.valueOf(0);
        EquipManager equipManager = player.equipManager;
        NormalEquip equip = null;
        int gridIndex = equipManager.getEquipmentById(equipId);
        if (gridIndex > 0) {
            equip = equipManager.getEquipment(gridIndex);
        }
        if (equip == null) {
            obj[1] = Boolean.valueOf(false);
            NormalItem item = player.bag.findItemById(equipId);
            if (item != null) {
                equip = (NormalEquip) item;
                gridIndex = player.bag.findPosById(equipId);
            }
        }
        if (equip == null) {
            obj[0] = Boolean.valueOf(false);
        }
        obj[2] = Integer.valueOf(gridIndex);
        obj[3] = equip;
        return obj;
    }
}


