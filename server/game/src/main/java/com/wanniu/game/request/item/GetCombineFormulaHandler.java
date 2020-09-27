package com.wanniu.game.request.item;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.bag.WNBag;
import com.wanniu.game.data.ext.CombineExt;
import com.wanniu.game.equip.EquipCraftConfig;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.ItemHandler;
import pomelo.item.ItemOuterClass;


@GClientEvent("area.itemHandler.getCombineFormulaRequest")
public class GetCombineFormulaHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        WNPlayer player = (WNPlayer) this.pak.getPlayer();
        WNBag wnBag = player.getWnBag();

        ItemHandler.GetCombineFormulaRequest req = ItemHandler.GetCombineFormulaRequest.parseFrom(this.pak.getRemaingBytes());
        final int destId = req.getC2SDestID();

        return new PomeloResponse() {
            protected void write() throws IOException {
                ItemHandler.GetCombineFormulaResponse.Builder res = ItemHandler.GetCombineFormulaResponse.newBuilder();

                CombineExt prop = EquipCraftConfig.getInstance().getCombineProp(destId);
                if (prop == null) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("ITEM_NOT_COMBINE"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                ItemOuterClass.Combine data = EquipCraftConfig.getInstance().getCombineFormula(prop);

                res.setS2CCode(200);
                res.setS2CData(data);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


