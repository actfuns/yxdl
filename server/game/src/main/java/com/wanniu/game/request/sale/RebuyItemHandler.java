package com.wanniu.game.request.sale;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.sale.SaleManager;

import java.io.IOException;

import pomelo.area.SaleHandler;


@GClientEvent("area.saleHandler.rebuyItemRequest")
public class RebuyItemHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        SaleHandler.RebuyItemRequest msg = SaleHandler.RebuyItemRequest.parseFrom(this.pak.getRemaingBytes());
        final int gridIndex = msg.getC2SGridIndex();
        final int num = msg.getC2SNum();

        return new PomeloResponse() {
            protected void write() throws IOException {
                SaleHandler.RebuyItemResponse.Builder res = SaleHandler.RebuyItemResponse.newBuilder();
                int result = player.saleManager.handleRebuyItem(gridIndex, num);

                if (result == SaleManager.ERR_CODE.ERR_CODE_OK.getValue()) {

                    res.setS2CCode(200);
                } else if (result == SaleManager.ERR_CODE.ERR_CODE_ITEM_NOT_EXIST.getValue()) {

                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("SALE_ITEM_NOT_EXIST"));
                } else if (result == SaleManager.ERR_CODE.ERR_CODE_PARAM_ERROR.getValue()) {

                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("PARAM_ERROR"));
                } else if (result == SaleManager.ERR_CODE.ERR_CODE_GOLD_NOT_ENOUGH.getValue()) {

                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("GOLD_NOT_ENOUGH"));
                } else if (result == SaleManager.ERR_CODE.ERR_CODE_BAG_NOT_ENOUGH_POS.getValue()) {

                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("BAG_NOT_ENOUGH_POS"));
                } else {

                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
                }
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


