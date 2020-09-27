package com.wanniu.game.request.daily;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.tcp.protocol.Packet;
import com.wanniu.game.common.CommonUtil;
import com.wanniu.game.daily.DailyActivityMgr;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;


@GClientEvent("area.dailyActivityHandler.dailyActivityRequest")
public class DailyActivityHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        return new PomeloResponse() {
            WNPlayer player = (WNPlayer) DailyActivityHandler.this.pak.getPlayer();


            protected void write() throws IOException {
                pomelo.area.DailyActivityHandler.DailyActivityResponse.Builder res = pomelo.area.DailyActivityHandler.DailyActivityResponse.newBuilder();
                try {
                    if (null == this.player) {
                        res.setS2CCode(500);
                        res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
                        this.body.writeBytes(res.build().toByteArray());
                        PlayerUtil.logWarnIfPlayerNull(DailyActivityHandler.this.pak);

                        return;
                    }
                    DailyActivityMgr mgr = this.player.dailyActivityMgr;
                    res.setS2CCode(200);
                    res.addAllS2CDailyLs(mgr.getDailyLs());
                    res.setS2CTotalDegree(mgr.po.totalDegree);
                    res.addAllS2CDegreeLs(mgr.getDegreeLs());
                    res.setS2CWeekIndex(CommonUtil.getWeek());
                    this.body.writeBytes(res.build().toByteArray());
                } catch (Exception err) {
                    Out.error(new Object[]{err});
                    res.setS2CCode(500);
                    this.body.writeBytes(res.build().toByteArray());
                }
            }
        };
    }
}


