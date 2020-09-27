package com.wanniu.game.request.activity;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.activity.ActivityManager;
import com.wanniu.game.common.msg.ErrorResponse;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.ActivityHandler;


@GClientEvent("area.activityHandler.activityLsRequest")
public class ActivityLsHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        WNPlayer player = (WNPlayer) this.pak.getPlayer();
        if (null == player) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("SOMETHING_ERR"));
        }
        final ActivityManager activityMgr = player.activityManager;
        if (null == activityMgr) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("SOMETHING_ERR"));
        }

        final ActivityHandler.ActivityLsResponse.Builder res = ActivityHandler.ActivityLsResponse.newBuilder();
        res.addAllS2CWelfareLs(activityMgr.getVailyActivityLs());

        return new PomeloResponse() {
            protected void write() throws IOException {
                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());
                activityMgr.updateSuperScriptList();
            }
        };
    }
}


