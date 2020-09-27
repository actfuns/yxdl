package com.wanniu.game.request.activity;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.activity.ActivityManager;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.ActivityFavorHandler;


@GClientEvent("area.activityFavorHandler.limitTimeGiftInfoRequest")
public class LimitTimeGiftInfoHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        ActivityFavorHandler.LimitTimeGiftInfoRequest req = ActivityFavorHandler.LimitTimeGiftInfoRequest.parseFrom(this.pak.getRemaingBytes());

        WNPlayer player = (WNPlayer) this.pak.getPlayer();

        ActivityManager activityManager = player.activityManager;


        final ActivityFavorHandler.LimitTimeGiftInfoResponse.Builder res = ActivityFavorHandler.LimitTimeGiftInfoResponse.newBuilder();

        res.setS2CCode(200);
        res.addAllLimitTimeGiftInfo(activityManager.getLimitTimeGiftInfos());


        return new PomeloResponse() {
            protected void write() throws IOException {
                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


