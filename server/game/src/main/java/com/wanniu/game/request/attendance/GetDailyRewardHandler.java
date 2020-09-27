package com.wanniu.game.request.attendance;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.entity.GPlayer;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.tcp.protocol.Packet;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.AttendanceHandler;


@GClientEvent("area.attendanceHandler.getDailyRewardRequest")
public class GetDailyRewardHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        return new PomeloResponse() {
            protected void write() throws IOException {
                GPlayer player = GetDailyRewardHandler.this.pak.getPlayer();
                if (player == null) {
                    AttendanceHandler.GetDailyRewardResponse.Builder res = AttendanceHandler.GetDailyRewardResponse.newBuilder();
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
                    this.body.writeBytes(res.build().toByteArray());
                } else {
                    WNPlayer wplayer = (WNPlayer) player;
                    int code = wplayer.playerAttendance.getDailyReward();
                    AttendanceHandler.GetDailyRewardResponse.Builder res = null;
                    switch (code) {
                        case 0:
                            res = wplayer.playerAttendance.createGetDailyRewardResponse();
                            res.setS2CCode(200);
                            this.body.writeBytes(res.build().toByteArray());
                            wplayer.activityManager.updateDeskRedPoint();
                            Out.info(new Object[]{player.getId(), ":普通签到成功"});
                            return;
                        case -1:
                            res = AttendanceHandler.GetDailyRewardResponse.newBuilder();
                            res.setS2CCode(500);
                            res.setS2CMsg(LangService.getValue("SIGN_HAVE_SIGNED"));
                            this.body.writeBytes(res.build().toByteArray());
                            return;
                        case -2:
                            res = AttendanceHandler.GetDailyRewardResponse.newBuilder();
                            res.setS2CCode(500);
                            res.setS2CMsg(LangService.getValue("SIGN_NOT_EXIST"));
                            this.body.writeBytes(res.build().toByteArray());
                            return;
                        case -3:
                            res = AttendanceHandler.GetDailyRewardResponse.newBuilder();
                            res.setS2CCode(500);
                            res.setS2CMsg(LangService.getValue("BAG_NOT_ENOUGH_POS"));
                            this.body.writeBytes(res.build().toByteArray());
                            return;
                    }
                    res = AttendanceHandler.GetDailyRewardResponse.newBuilder();
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
                    this.body.writeBytes(res.build().toByteArray());
                }
            }
        };
    }
}


