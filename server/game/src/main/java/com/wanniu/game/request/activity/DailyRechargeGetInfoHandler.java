package com.wanniu.game.request.activity;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.tcp.protocol.Packet;
import com.wanniu.game.activity.ActivityManager;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.prepaid.PrepaidManager;

import java.io.IOException;

import pomelo.area.ActivityFavorHandler;
import pomelo.area.ActivityHandler;


@GClientEvent("area.activityFavorHandler.dailyRechargeGetInfoRequest")
public class DailyRechargeGetInfoHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        ActivityFavorHandler.DailyRechargeGetInfoRequest req = ActivityFavorHandler.DailyRechargeGetInfoRequest.parseFrom(this.pak.getRemaingBytes());
        return new PomeloResponse() {
            protected void write() throws IOException {
                WNPlayer player = (WNPlayer) DailyRechargeGetInfoHandler.this.pak.getPlayer();

                ActivityManager activityManager = player.activityManager;
                PrepaidManager prepaidManager = player.prepaidManager;

                ActivityFavorHandler.DailyRechargeGetInfoResponse.Builder res = ActivityFavorHandler.DailyRechargeGetInfoResponse.newBuilder();


                ActivityHandler.totalInfo totalInfo = activityManager.DailyRecharge_Today().build();
                res.setTotalInfo(totalInfo);
                res.setRechargeNum(prepaidManager.getDailyCharge());
                res.setRechargeMax(activityManager.DailyRecharge_GetTodayMax());


                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


