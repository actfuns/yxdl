package com.wanniu.game.request.activity;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.activity.ActivityManager;
import com.wanniu.game.common.msg.ErrorResponse;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.ActivityFavorHandler;


@GClientEvent("area.activityFavorHandler.limitTimeGiftBuyRequest")
public class LimitTimeGiftBuyHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        ActivityFavorHandler.LimitTimeGiftBuyRequest req = ActivityFavorHandler.LimitTimeGiftBuyRequest.parseFrom(this.pak.getRemaingBytes());
        int id = req.getId();

        WNPlayer player = (WNPlayer) this.pak.getPlayer();

        ActivityManager activityManager = player.activityManager;


        final ActivityFavorHandler.LimitTimeGiftBuyResponse.Builder res = ActivityFavorHandler.LimitTimeGiftBuyResponse.newBuilder();

        int result = activityManager.BugLimitTimeGift(id);

        switch (result) {


            case 0:
                return new PomeloResponse() {
                    protected void write() throws IOException {
                        res.setS2CCode(200);
                        this.body.writeBytes(res.build().toByteArray());
                    }
                };
            case 2:
                return (PomeloResponse) new ErrorResponse(LangService.getValue("LIMIT_TIME_GIFT_BOUGHT"));
            case 3:
                return (PomeloResponse) new ErrorResponse(LangService.getValue("LIMIT_TIME_GIFT_NO_ENOUTH_DIAMOND"));
        }
        return (PomeloResponse) new ErrorResponse(LangService.getValue("PARAM_ERROR"));
    }
}


