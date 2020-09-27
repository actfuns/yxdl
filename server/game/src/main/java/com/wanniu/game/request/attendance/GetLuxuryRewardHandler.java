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


@GClientEvent("area.attendanceHandler.getLuxuryRewardRequest")
public class GetLuxuryRewardHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        return new PomeloResponse() {
            protected void write() throws IOException {
                GPlayer player = GetLuxuryRewardHandler.this.pak.getPlayer();
                if (player == null) {
                    AttendanceHandler.GetLuxuryRewardResponse.Builder builder = AttendanceHandler.GetLuxuryRewardResponse.newBuilder();
                    builder.setS2CCode(500);
                    builder.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
                    this.body.writeBytes(builder.build().toByteArray());
                    return;
                }
                WNPlayer wPlayer = (WNPlayer) player;
                int resultCode = wPlayer.playerAttendance.getLuxuryReward();
                AttendanceHandler.GetLuxuryRewardResponse.Builder res = null;
                switch (resultCode) {
                    case 0:
                        res = wPlayer.playerAttendance.createGetLuxuryRewardResponse();
                        res.setS2CCode(200);
                        this.body.writeBytes(res.build().toByteArray());
                        Out.info(new Object[]{player.getId(), ":豪华签到成功"});
                        return;
                    case -1:
                        res = AttendanceHandler.GetLuxuryRewardResponse.newBuilder();
                        res.setS2CCode(500);
                        res.setS2CMsg(LangService.getValue("SIGN_HAVE_RECEIVED"));
                        this.body.writeBytes(res.build().toByteArray());
                        return;
                    case -2:
                        res = AttendanceHandler.GetLuxuryRewardResponse.newBuilder();
                        res.setS2CCode(500);
                        res.setS2CMsg(LangService.getValue("SIGN_NOT_RECHARGE"));
                        this.body.writeBytes(res.build().toByteArray());
                        return;
                    case -3:
                        res = AttendanceHandler.GetLuxuryRewardResponse.newBuilder();
                        res.setS2CCode(500);
                        res.setS2CMsg(LangService.getValue("BAG_NOT_ENOUGH_POS"));
                        this.body.writeBytes(res.build().toByteArray());
                        return;
                }
                res = AttendanceHandler.GetLuxuryRewardResponse.newBuilder();
                res.setS2CCode(500);
                res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


