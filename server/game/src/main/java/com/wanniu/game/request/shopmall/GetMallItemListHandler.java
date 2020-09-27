package com.wanniu.game.request.shopmall;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.entity.GPlayer;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.msg.ErrorResponse;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.ShopMallConfigCO;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import pomelo.area.ShopMallHandler;


@GClientEvent("area.shopMallHandler.getMallItemListRequest")
public class GetMallItemListHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        ShopMallHandler.GetMallItemListRequest req = ShopMallHandler.GetMallItemListRequest.parseFrom(this.pak.getRemaingBytes());
        GPlayer player = this.pak.getPlayer();
        final WNPlayer wPlayer = (WNPlayer) player;

        final int itemType = req.getC2SItemType();


        final ShopMallConfigCO shopMallConfigCO = (ShopMallConfigCO) GameData.ShopMallConfigs.get(Integer.valueOf(itemType));
        if (shopMallConfigCO == null) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("PARAM_ERROR"));
        }


        return new PomeloResponse() {
            protected void write() throws IOException {
                ShopMallHandler.GetMallItemListResponse.Builder res = ShopMallHandler.GetMallItemListResponse.newBuilder();

                ArrayList<ShopMallHandler.MallItem.Builder> items = wPlayer.shopMallManager.getMallItemList(itemType);
                int endTime = 0;

                if (wPlayer.shopMallManager.isOpenOfMallTab(itemType)) {
                    Date now = new Date();
                    Calendar c = Calendar.getInstance();
                    c.setTime(now);
                    int nowHour = c.get(11);
                    int onSaleTime = 1;
                    int shelfTime = 1;
                    if (shopMallConfigCO.consumeType == Const.SHOP_MALL_CONSUME_TYPE.DIAMOND.getValue()) {
                        onSaleTime = GlobalConfig.Shop_OnSaleTime_Diamond;
                        shelfTime = GlobalConfig.Shop_ShelfTime_Diamond;
                    } else {
                        onSaleTime = GlobalConfig.Shop_OnSaleTime_Ticket;
                        shelfTime = GlobalConfig.Shop_ShelfTime_Ticket;
                    }
                    if (nowHour >= onSaleTime && nowHour < shelfTime) {
                        c.set(11, shelfTime);
                        c.set(12, 0);
                        c.set(13, 0);
                        endTime = (int) Math.ceil((now.getTime() / 1000L));
                    }
                } else {

                    endTime = -1;
                }
                res.setS2CCode(200);
                res.setS2CEndTime(endTime);
                for (int i = 0; i < items.size(); i++) {
                    res.addS2CItems(((ShopMallHandler.MallItem.Builder) items.get(i)).build());
                }
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


