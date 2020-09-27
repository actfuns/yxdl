package com.wanniu.game.request.activity;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.activity.RechargeActivityService;
import com.wanniu.game.common.msg.ErrorResponse;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.ActivityFavorHandler;


@GClientEvent("area.activityFavorHandler.continuousRechargeAwardRequest")
public class ContinuousRechargeAwardHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        ActivityFavorHandler.ContinuousRechargeAwardRequest request = ActivityFavorHandler.ContinuousRechargeAwardRequest.parseFrom(this.pak.getRemaingBytes());
        int day = request.getDay();

        if (day < 0) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("PARAM_ERROR"));
        }

        WNPlayer player = (WNPlayer) this.pak.getPlayer();

        PomeloResponse errorcode = RechargeActivityService.getInstance().receiveContinuousRecharge(player, day);
        if (errorcode != null) {
            return errorcode;
        }

        return new PomeloResponse() {
            protected void write() throws IOException {
                ActivityFavorHandler.ContinuousRechargeAwardResponse.Builder res = ActivityFavorHandler.ContinuousRechargeAwardResponse.newBuilder();
                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


