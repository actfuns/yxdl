package com.wanniu.game.request.revelry;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.activity.RechargeActivityService;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.revelry.ActivityRevelryHandler;


@GClientEvent("revelry.activityRevelryHandler.revelryRechargeAwardRequest")
public class RevelryRechargeAwardHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        ActivityRevelryHandler.RevelryRechargeAwardRequest req = ActivityRevelryHandler.RevelryRechargeAwardRequest.parseFrom(this.pak.getRemaingBytes());
        int id = req.getId();
        WNPlayer player = (WNPlayer) this.pak.getPlayer();

        PomeloResponse errorcode = RechargeActivityService.getInstance().receiveRevelryRecharge(player, id);
        if (errorcode != null) {
            return errorcode;
        }

        return new PomeloResponse() {
            protected void write() throws IOException {
                ActivityRevelryHandler.RevelryRechargeAwardResponse.Builder result = ActivityRevelryHandler.RevelryRechargeAwardResponse.newBuilder();
                result.setS2CCode(200);
                this.body.writeBytes(result.build().toByteArray());
            }
        };
    }
}


