package com.wanniu.game.request.sale;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.sale.SaleManager;

import java.io.IOException;
import java.util.List;

import pomelo.area.SaleHandler;


@GClientEvent("area.saleHandler.buyPageRequest")
public class BuyPageHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        SaleHandler.BuyPageRequest req = SaleHandler.BuyPageRequest.parseFrom(this.pak.getRemaingBytes());
        final List<Integer> typeIds = req.getC2SSellIndexList();
        return new PomeloResponse() {
            protected void write() throws IOException {
                SaleHandler.BuyPageResponse.Builder res = player.saleManager.handleBuyPage(typeIds);
                if (res.getS2CCode() == SaleManager.ERR_CODE.ERR_CODE_OK.getValue()) {
                    res.setS2CCode(200);
                } else {

                    res.setS2CCode(500);
                }
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


