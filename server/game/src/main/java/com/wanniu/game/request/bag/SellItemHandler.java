package com.wanniu.game.request.bag;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.bag.BagUtil;
import com.wanniu.game.bag.WNBag;
import com.wanniu.game.common.Const;
import com.wanniu.game.item.ItemUtil;
import com.wanniu.game.item.NormalItem;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.BagHandler;


@GClientEvent("area.bagHandler.sellItemRequest")
public class SellItemHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        WNBag wnBag = player.getWnBag();

        BagHandler.SellItemRequest req = BagHandler.SellItemRequest.parseFrom(this.pak.getRemaingBytes());
        final int index = req.getC2SGridIndex();
        final int num = req.getC2SNum();

        return new PomeloResponse() {
            protected void write() throws IOException {
                BagHandler.SellItemResponse.Builder res = BagHandler.SellItemResponse.newBuilder();


                NormalItem item = player.bag.getItem(index);
                if (item == null) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("ITEM_NULL"));

                    return;
                }
                if (!item.canSell()) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("ITEM_CAN_NOT_SELL"));

                    return;
                }
                if (item.itemDb.groupCount < num || num <= 0) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("PARAM_ERROR"));

                    return;
                }
                int price = BagUtil.getSellPrice(item.price(), num);

                int delNum = num;


                if (item.itemDb.groupCount != num) {

                    player.bag.discardItemByPos(index, num, Const.GOODS_CHANGE_TYPE.clear_when_logout);
                    NormalItem newItem = ItemUtil.createItemsByItemCode(item.itemDb.code, num).get(0);
                    newItem.itemDb.isNew = 0;
                    newItem.setBind(item.getBind());
                    player.recycle.addEntityItem(newItem, Const.GOODS_CHANGE_TYPE.clear_when_logout, null, true, true);
                } else {
                    item.itemDb.isNew = 0;
                    delNum = item.itemDb.groupCount;
                    player.bag.removeItemByPos(index, true, Const.GOODS_CHANGE_TYPE.clear_when_logout);
                    player.recycle.addEntityItem(item, Const.GOODS_CHANGE_TYPE.clear_when_logout, null, true, true);
                }

                player.moneyManager.addGold(price, Const.GOODS_CHANGE_TYPE.clear_when_logout);
                if (item.prop.itemSecondType == Const.ItemSecondType.gem.getValue()) ;


                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


