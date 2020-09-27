package com.wanniu.game.request.activity;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.activity.ActivityNoticeService;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.ActivityHandler;


@GClientEvent("area.activityHandler.activityNoticeRequest")
public class ActivityNoticeHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        WNPlayer player = (WNPlayer) this.pak.getPlayer();
        final String context = ActivityNoticeService.getInstance().getNotice(player);

        return new PomeloResponse() {
            protected void write() throws IOException {
                ActivityHandler.ActivityNoticeRes.Builder res = ActivityHandler.ActivityNoticeRes.newBuilder();
                res.setS2CCode(200);
                res.setS2CContext(context);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }

    public static class ContextInfo {
        public String Content;
        public String ReleasePerson;
        public String ReleaseTime;
        public String NoticeTitle;
        public int ID;
        public int isRead;
    }
}


