package com.wanniu.game.request.activity;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.tcp.protocol.Packet;
import com.wanniu.game.activity.ActivityManager;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.ActivityFavorHandler;


@GClientEvent("area.activityFavorHandler.dailyRechargeGetAwardRequest")
public class DailyRechargeGetAwardHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        ActivityFavorHandler.DailyRechargeGetAwardRequest req = ActivityFavorHandler.DailyRechargeGetAwardRequest.parseFrom(this.pak.getRemaingBytes());
        final int awardId = req.getAwardId();
        return new PomeloResponse() {
            protected void write() throws IOException {
                WNPlayer player = (WNPlayer) DailyRechargeGetAwardHandler.this.pak.getPlayer();

                ActivityManager activityManager = player.activityManager;


                ActivityFavorHandler.DailyRechargeGetAwardResponse.Builder res = ActivityFavorHandler.DailyRechargeGetAwardResponse.newBuilder();


                boolean result = activityManager.DailyRecharge_GetAward(awardId);

                if (result) {

                    res.setS2CCode(200);
                    Out.info(new Object[]{player.getId(), ":每日充值奖励领取成功,奖励id:", Integer.valueOf(this.val$awardId)});
                } else {

                    res.setS2CCode(500);
                    res.setS2CMsg("ACTIVITY_NOT_REQUIRMENT");
                }


                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


