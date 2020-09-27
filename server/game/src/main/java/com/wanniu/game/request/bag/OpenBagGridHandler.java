package com.wanniu.game.request.bag;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.bag.BagUtil;
import com.wanniu.game.bag.WNBag;
import com.wanniu.game.common.Const;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.BagHandler;


@GClientEvent("area.bagHandler.openBagGridRequest")
public class OpenBagGridHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();

        BagHandler.OpenBagGridRequest req = BagHandler.OpenBagGridRequest.parseFrom(this.pak.getRemaingBytes());
        final int type_from = req.getC2SType();
        final int num = req.getC2SNumber();

        return new PomeloResponse() {
            protected void write() throws IOException {
                BagHandler.OpenBagGridResponse.Builder res = BagHandler.OpenBagGridResponse.newBuilder();

                if (num <= 0) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("PARAM_ERROR"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }
                WNBag store = BagUtil.getStoreByType(player, type_from);
                if (store == null) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("PARAM_ERROR"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }
                int needDiamond = num * BagUtil.getGridPrice(type_from);

                if (!player.moneyManager.enoughTicketAndDiamond(needDiamond)) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("DIAMAND_NOT_ENOUGH"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }
                if (store.openGrid(num)) {
                    player.moneyManager.costTicketAndDiamond(needDiamond, Const.GOODS_CHANGE_TYPE.openbag);
                }

                res.setS2CCode(200);
                res.setS2CBagGridCount(store.bagPO.bagGridCount);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


