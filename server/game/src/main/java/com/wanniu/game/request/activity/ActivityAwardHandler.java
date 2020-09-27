package com.wanniu.game.request.activity;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.logfs.Out;
import com.wanniu.game.data.ext.ActivityExt;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.ActivityHandler;


@GClientEvent("area.activityHandler.activityAwardRequest")
public class ActivityAwardHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        ActivityHandler.ActivityAwardRequest req = ActivityHandler.ActivityAwardRequest.parseFrom(this.pak.getRemaingBytes());
        final int awardId = req.getS2CAwardId();
        final int activityId = req.getS2CActivityId();

        final ActivityHandler.ActivityAwardResponse.Builder res = player.activityManager.activityAward(awardId, activityId);

        return new PomeloResponse() {
            protected void write() throws IOException {
                if (res.getS2CCode() == 200) {
                    player.activityManager.updateSuperScriptList();

                    res.setS2CMsg(LangService.getValue("ACTIVITY_RECEIVE"));
                    this.body.writeBytes(res.build().toByteArray());

                    ActivityExt propCenter = player.activityManager.findActivityById(activityId);
                    Out.info(new Object[]{this.val$player.getId(), ":", propCenter.activity, "领取成功,礼包id:", Integer.valueOf(this.val$awardId)});
                } else {
                    res.setS2CCode(500);
                    this.body.writeBytes(res.build().toByteArray());
                }
            }
        };
    }
}


