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


@GClientEvent("area.attendanceHandler.getLeftVipRewardRequest")
public class GetLeftVipRewardHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        return new PomeloResponse() {
            AttendanceHandler.GetLeftVipRewardRequest req = AttendanceHandler.GetLeftVipRewardRequest.parseFrom(GetLeftVipRewardHandler.this.pak.getRemaingBytes());

            protected void write() throws IOException {
                int id = this.req.getId();
                GPlayer player = GetLeftVipRewardHandler.this.pak.getPlayer();
                if (player == null) {
                    AttendanceHandler.GetLeftVipRewardResponse.Builder builder = AttendanceHandler.GetLeftVipRewardResponse.newBuilder();
                    builder.setS2CCode(500);
                    builder.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
                    this.body.writeBytes(builder.build().toByteArray());
                    return;
                }
                if (id == 0) {
                    AttendanceHandler.GetLeftVipRewardResponse.Builder builder = AttendanceHandler.GetLeftVipRewardResponse.newBuilder();
                    builder.setS2CCode(500);
                    builder.setS2CMsg(LangService.getValue("PARAM_ERROR"));
                    this.body.writeBytes(builder.build().toByteArray());
                    return;
                }
                WNPlayer wPlayer = (WNPlayer) player;
                int resultCode = wPlayer.playerAttendance.getLeftVipReward(id);
                AttendanceHandler.GetLeftVipRewardResponse.Builder res = null;
                switch (resultCode) {
                    case 0:
                        res = wPlayer.playerAttendance.createGetLeftVipRewardResponse();
                        res.setS2CCode(200);
                        this.body.writeBytes(res.build().toByteArray());
                        Out.info(new Object[]{player.getId(), ":vip签到成功"});
                        return;
                    case -1:
                        res = AttendanceHandler.GetLeftVipRewardResponse.newBuilder();
                        res.setS2CCode(500);
                        res.setS2CMsg(LangService.getValue("SIGN_HAVE_RECEIVED"));
                        this.body.writeBytes(res.build().toByteArray());
                        return;
                    case -2:
                        res = AttendanceHandler.GetLeftVipRewardResponse.newBuilder();
                        res.setS2CCode(500);
                        res.setS2CMsg(LangService.getValue("SIGN_HAVE_NOT_SIGN"));
                        this.body.writeBytes(res.build().toByteArray());
                        return;
                    case -3:
                        res = AttendanceHandler.GetLeftVipRewardResponse.newBuilder();
                        res.setS2CCode(500);
                        res.setS2CMsg(LangService.getValue("SIGN_NO_VIP_DOUBLE"));
                        this.body.writeBytes(res.build().toByteArray());
                        return;
                    case -4:
                        res = AttendanceHandler.GetLeftVipRewardResponse.newBuilder();
                        res.setS2CCode(500);
                        res.setS2CMsg(LangService.getValue("SIGN_VIP_LEVEL_NOT_ENOUGH"));
                        this.body.writeBytes(res.build().toByteArray());
                        return;
                    case -5:
                        res = AttendanceHandler.GetLeftVipRewardResponse.newBuilder();
                        res.setS2CCode(500);
                        res.setS2CMsg(LangService.getValue("BAG_NOT_ENOUGH_POS"));
                        this.body.writeBytes(res.build().toByteArray());
                        return;
                }
                res = AttendanceHandler.GetLeftVipRewardResponse.newBuilder();
                res.setS2CCode(500);
                res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


