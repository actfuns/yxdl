package com.wanniu.game.request.farm;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.farm.FarmMgr;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.farm.FarmHandler;


@GClientEvent("farm.farmHandler.buyShopItemRequest")
public class ChangeShopItemHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        FarmHandler.ChangeShopItemRequest msg = FarmHandler.ChangeShopItemRequest.parseFrom(this.pak.getRemaingBytes());
        final int itemId = msg.getItemId();
        return new PomeloResponse() {
            protected void write() throws IOException {
                FarmHandler.ChangeShopItemResponse.Builder res = FarmHandler.ChangeShopItemResponse.newBuilder();
                FarmMgr farmMgr = player.farmMgr;

                boolean changeRes = farmMgr.ChangeShopItem(itemId);
                if (!changeRes) {

                    res.setS2CCode(200);
                    res.setS2CMsg(LangService.getValue("FARM_CANNOT_CHANGE"));

                    return;
                }
                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


