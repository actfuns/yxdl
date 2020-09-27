package com.wanniu.game.request.sale;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.sale.SaleManager;

import java.io.IOException;
import java.util.List;

import pomelo.area.SaleHandler;


@GClientEvent("area.saleHandler.sellItemsRequest")
public class SellItemsHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        SaleHandler.SellItemsRequest msg = SaleHandler.SellItemsRequest.parseFrom(this.pak.getRemaingBytes());
        final List<SaleHandler.SellGrid> sellGrids = msg.getC2SSellGridsList();
        return new PomeloResponse() {
            protected void write() throws IOException {
                SaleHandler.SellItemsResponse.Builder res = SaleHandler.SellItemsResponse.newBuilder();
                int result = player.saleManager.handleSellItems(sellGrids);

                if (result == SaleManager.ERR_CODE.ERR_CODE_OK.getValue()) {

                    res.setS2CCode(200);
                } else if (result == SaleManager.ERR_CODE.ERR_CODE_SELL_ITEMS_EMPTY.getValue()) {

                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("SALE_SELL_ITEMS_EMPTY"));
                } else if (result == SaleManager.ERR_CODE.ERR_CODE_ITEM_NOT_EXIST.getValue()) {

                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("SALE_ITEM_NOT_EXIST"));
                } else if (result == SaleManager.ERR_CODE.ERR_CODE_ITEM_NOSELL.getValue()) {

                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("SALE_ITEM_NOSELL"));
                } else if (result == SaleManager.ERR_CODE.ERR_CODE_PARAM_ERROR.getValue()) {

                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("PARAM_ERROR"));
                } else {

                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
                }
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


