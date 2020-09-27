package com.wanniu.game.request.activity;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.logfs.Out;
import com.wanniu.game.GWorld;
import com.wanniu.game.activity.ActivityCenterManager;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.msg.ErrorResponse;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;
import java.util.HashMap;

import pomelo.area.ActivityHandler;


@GClientEvent("area.activityHandler.activityBuyFundsRequest")
public class ActivityBuyFundsHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();

        HashMap<Integer, Integer> actInfo = player.activityManager.getActivityInfo(Const.ActivityRewardType.FOUNDATION.getValue());
        if (actInfo != null) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("ACTIVITY_NOT_REQUIRMENT"));
        }

        int needDiamond = GlobalConfig.Activity_Fund_Buy;
        if (!player.moneyManager.costDiamond(needDiamond, Const.GOODS_CHANGE_TYPE.BUY_FUNDS)) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("ACTIVITY_NOT_CONDITION"));
        }

        Out.info(new Object[]{"购买基金，playerId=", player.getId()});
        HashMap<Integer, Integer> data = new HashMap<>();
        player.activityManager.addActivityInfo(Const.lActivityRewardType.FOUNDATION.getVaue(), data);

        ActivityCenterManager.getIntance().addFundRecord(GWorld.__SERVER_ID);

        return new PomeloResponse() {
            protected void write() throws IOException {
                ActivityHandler.ActivityBuyFundsRes.Builder res = ActivityHandler.ActivityBuyFundsRes.newBuilder();
                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());

                player.activityManager.updateSuperScriptList();
            }
        };
    }
}


