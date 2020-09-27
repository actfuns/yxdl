package com.wanniu.game.request.equip;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.bag.WNBag;
import com.wanniu.game.common.Const;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.ext.EquipSockExt;
import com.wanniu.game.item.NormalItem;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.PlayerBasePO;

import java.io.IOException;

import pomelo.area.EquipHandler;


@GClientEvent("area.equipHandler.fillGemRequest")
public class FillGemHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        final WNBag wnBag = player.getWnBag();

        EquipHandler.FillGemRequest req = EquipHandler.FillGemRequest.parseFrom(this.pak.getRemaingBytes());
        final int pos = req.getC2SPos();

        final int gridIndex = req.getC2SGridIndex();

        return new PomeloResponse() {
            protected void write() throws IOException {
                EquipHandler.FillGemResponse.Builder res = EquipHandler.FillGemResponse.newBuilder();

                if (!player.functionOpenManager.isOpen(Const.FunctionType.SetNew.getValue())) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("FUNC_SET_PLAYED_NOT_OPEN"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }
                NormalItem item = wnBag.getItem(gridIndex);
                if (item == null || item.prop.itemSecondType != Const.ItemSecondType.gem.getValue()) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }

                if (!((EquipSockExt) GameData.EquipSocks.get(Integer.valueOf(pos))).typeList.contains(item.itemDb.code)) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("EQUIP_CANNOT_USE_GEM"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }

                PlayerBasePO.EquipStrengthPos posInfo = (PlayerBasePO.EquipStrengthPos) player.equipManager.strengthPos.get(Integer.valueOf(pos));
                if (posInfo == null) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("EQUIP_POS_NOT_EXIST"));
                    this.body.writeBytes(res.build().toByteArray());


                    return;
                }

                int[] index = {-1};
                if (player.equipManager.fillGem(pos, index, item.prop.code, player)) {
                    wnBag.discardItemByPos(gridIndex, 1, false, Const.GOODS_CHANGE_TYPE.equipmosaic);
                    if (index[0] != -1) {
                        res.setS2CIndex(index[0]);
                    }
                    res.setS2CCode(200);
                    this.body.writeBytes(res.build().toByteArray());
                } else {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("EQUIP_FILL_ERROR"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
            }
        };
    }
}


