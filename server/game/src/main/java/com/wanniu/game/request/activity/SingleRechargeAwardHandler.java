package com.wanniu.game.request.activity;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.activity.RechargeActivityService;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.ActivityFavorHandler;


@GClientEvent("area.activityFavorHandler.singleRechargeAwardRequest")
public class SingleRechargeAwardHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        ActivityFavorHandler.SingleRechargeAwardRequest request = ActivityFavorHandler.SingleRechargeAwardRequest.parseFrom(this.pak.getRemaingBytes());
        int id = request.getId();
        WNPlayer player = (WNPlayer) this.pak.getPlayer();

        PomeloResponse errorcode = RechargeActivityService.getInstance().receiveSingleRecharge(player, id);
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


