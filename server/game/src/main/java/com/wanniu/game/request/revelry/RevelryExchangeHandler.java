package com.wanniu.game.request.revelry;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.logfs.Out;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.msg.ErrorResponse;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.KingCO;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.revelry.ActivityRevelryHandler;


@GClientEvent("revelry.activityRevelryHandler.revelryExchangeRequest")
public class RevelryExchangeHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        ActivityRevelryHandler.RevelryExchangeRequest req = ActivityRevelryHandler.RevelryExchangeRequest.parseFrom(this.pak.getRemaingBytes());

        int tabId = req.getId();
        KingCO template = (KingCO) GameData.Kings.get(Integer.valueOf(tabId));
        if (template == null) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("PARAM_ERROR"));
        }

        int count = req.getNum();
        if (count <= 0 || count > 9999) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("PARAM_ERROR"));
        }

        WNPlayer player = (WNPlayer) this.pak.getPlayer();


        int needNum = template.num2 * count;
        if (!player.getWnBag().isItemNumEnough(template.item2code, needNum)) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("NOT_ENOUGH_ITEM"));
        }


        int addNum = template.num1 * count;
        if (!player.getWnBag().testAddCodeItem(template.item1code, addNum)) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("BAG_FULL"));
        }

        Out.info(new Object[]{"冲榜兑换物品，playerId=", player.getId(), ",name=", player.getName(), ",tabId=", Integer.valueOf(tabId), ",num=", Integer.valueOf(count)});

        player.getWnBag().discardItem(template.item2code, needNum, Const.GOODS_CHANGE_TYPE.REVELRY_EXCHANGE);

        player.getWnBag().addCodeItem(template.item1code, addNum, Const.ForceType.DEFAULT, Const.GOODS_CHANGE_TYPE.REVELRY_EXCHANGE);

        return new PomeloResponse() {
            protected void write() throws IOException {
                ActivityRevelryHandler.RevelryExchangeResponse.Builder result = ActivityRevelryHandler.RevelryExchangeResponse.newBuilder();
                result.setS2CCode(200);
                this.body.writeBytes(result.build().toByteArray());
            }
        };
    }
}


