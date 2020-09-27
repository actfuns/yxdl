package com.wanniu.game.request.activity;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.tcp.protocol.Packet;
import com.wanniu.game.common.Const;
import com.wanniu.game.data.ext.ActivityExt;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.ActivityHandler;


@GClientEvent("area.activityHandler.activityInviteCodeRequest")
public class ActivityInviteCodeHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        return new PomeloResponse() {
            protected void write() throws IOException {
                WNPlayer player = (WNPlayer) ActivityInviteCodeHandler.this.pak.getPlayer();
                ActivityHandler.ActivityInviteCodeResponse.Builder res = ActivityHandler.ActivityInviteCodeResponse.newBuilder();
                ActivityExt prop = player.activityManager.findActivityByType(Const.ACTIVITY_CENTER_TYPE.INVITE_CODE.getValue());
                if (prop == null) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("CUR_NO_ACTIVITY"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
            }
        };
    }
}


