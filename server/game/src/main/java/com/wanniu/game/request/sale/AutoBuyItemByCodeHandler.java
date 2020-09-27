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


@GClientEvent("area.saleHandler.autoBuyItemByCodeRequest")
public class AutoBuyItemByCodeHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        SaleHandler.AutoBuyItemByCodeRequest msg = SaleHandler.AutoBuyItemByCodeRequest.parseFrom(this.pak.getRemaingBytes());
        final List<Integer> typeIds = msg.getC2STypeIdList();
        final String itemCode = msg.getC2SItemCode();
        final int num = msg.getC2SNum();
        return new PomeloResponse() {
            protected void write() throws IOException {
                SaleHandler.AutoBuyItemByCodeResponse.Builder result = player.saleManager.handleAutoBuyItemByTypeCode(typeIds, itemCode, num);

                if (result.getS2CCode() == SaleManager.ERR_CODE.ERR_CODE_OK.getValue()) {

                    result.setS2CCode(200);
                    this.body.writeBytes(result.build().toByteArray());
                    return;
                }
                if (result.getS2CCode() == SaleManager.ERR_CODE.ERR_CODE_GOLD_NOT_ENOUGH.getValue()) {

                    result.setS2CCode(200);
                    result.setS2CMsg(LangService.getValue("GOLD_NOT_ENOUGH"));
                    result.setS2CNotEnoughGold(1);
                    int needValue = result.getS2CNeedGold();
                    result.setS2CNeedGold(needValue);
                    this.body.writeBytes(result.build().toByteArray());
                    return;
                }
                result.setS2CCode(200);
                this.body.writeBytes(result.build().toByteArray());
            }
        };
    }
}


