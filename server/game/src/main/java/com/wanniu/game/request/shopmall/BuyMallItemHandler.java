package com.wanniu.game.request.shopmall;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.entity.GPlayer;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.GWorld;
import com.wanniu.game.common.msg.ErrorResponse;
import com.wanniu.game.data.ext.ShopMallItemsExt;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.shopMall.ShopMallConfig;
import com.wanniu.game.shopMall.ShopMallManager;

import java.io.IOException;

import pomelo.area.ShopMallHandler;


@GClientEvent("area.shopMallHandler.buyMallItemRequest")
public class BuyMallItemHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        GPlayer player = this.pak.getPlayer();
        ShopMallHandler.BuyMallItemRequest req = ShopMallHandler.BuyMallItemRequest.parseFrom(this.pak.getRemaingBytes());
        String itemId = req.getC2SItemId();
        int count = req.getC2SCount();
        String playerId = req.getC2SPlayerId();
        int bDiamond = req.getC2SBDiamond();

        if (itemId == null || count <= 0 || playerId == null || count > 9999) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("PARAM_ERROR"));
        }


        ShopMallItemsExt mallItemProp = ShopMallConfig.getInstance().fingShowMallItemByID(itemId);
        if (!GWorld.DEBUG && mallItemProp != null && mallItemProp.itemType == 199) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("PARAM_ERROR"));
        }

        WNPlayer wPlayer = (WNPlayer) player;
        ShopMallManager.ShopMallResult result = wPlayer.shopMallManager.buyMallItem(itemId, count, playerId, bDiamond);

        final ShopMallHandler.BuyMallItemResponse.Builder res = ShopMallHandler.BuyMallItemResponse.newBuilder();

        if (result.result) {
            res.setTotalNum(result.totalNum);
            res.setS2CCode(200);
        } else {
            if (!result.msg.equals(LangService.getValue("BAG_NOT_ENOUGH_POS"))) {
                return (PomeloResponse) new ErrorResponse(result.msg);
            }
            return (PomeloResponse) new ErrorResponse();
        }


        return new PomeloResponse() {
            protected void write() throws IOException {
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


