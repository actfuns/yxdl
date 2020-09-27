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


@GClientEvent("area.attendanceHandler.getCumulativeRewardRequest")
public class GetCumulativeRewardHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final AttendanceHandler.GetCumulativeRewardRequest req = AttendanceHandler.GetCumulativeRewardRequest.parseFrom(this.pak.getRemaingBytes());
        return new PomeloResponse() {
            protected void write() throws IOException {
                GPlayer player = GetCumulativeRewardHandler.this.pak.getPlayer();
                if (player == null) {
                    AttendanceHandler.GetCumulativeRewardResponse.Builder builder = AttendanceHandler.GetCumulativeRewardResponse.newBuilder();
                    builder.setS2CCode(500);
                    builder.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
                    this.body.writeBytes(builder.build().toByteArray());
                    return;
                }
                int id = req.getId();
                if (id == 0) {
                    AttendanceHandler.GetCumulativeRewardResponse.Builder builder = AttendanceHandler.GetCumulativeRewardResponse.newBuilder();
                    builder.setS2CCode(500);
                    builder.setS2CMsg(LangService.getValue("PARAM_ERROR"));
                    this.body.writeBytes(builder.build().toByteArray());
                    return;
                }
                WNPlayer wPlayer = (WNPlayer) player;
                AttendanceHandler.GetCumulativeRewardResponse.Builder res = null;
                int resultCode = wPlayer.playerAttendance.getCumulativeReward(id);
                switch (resultCode) {
                    case 0:
                        res = wPlayer.playerAttendance.createGetCumulativeRewardResponse();
                        res.setS2CCode(200);
                        this.body.writeBytes(res.build().toByteArray());
                        Out.info(new Object[]{player.getId(), ":累计签到成功"});
                        return;
                    case -1:
                        res = AttendanceHandler.GetCumulativeRewardResponse.newBuilder();
                        res.setS2CCode(500);
                        res.setS2CMsg(LangService.getValue("SIGN_HAVE_RECEIVED"));
                        this.body.writeBytes(res.build().toByteArray());
                        return;
                    case -2:
                        res = AttendanceHandler.GetCumulativeRewardResponse.newBuilder();
                        res.setS2CCode(500);
                        res.setS2CMsg(LangService.getValue("SIGN_NOT_EXIST"));
                        this.body.writeBytes(res.build().toByteArray());
                        return;
                    case -3:
                        res = AttendanceHandler.GetCumulativeRewardResponse.newBuilder();
                        res.setS2CCode(500);
                        res.setS2CMsg(LangService.getValue("SIGN_NOT_ENOUGH_COUNT"));
                        this.body.writeBytes(res.build().toByteArray());
                        return;
                    case -4:
                        res = AttendanceHandler.GetCumulativeRewardResponse.newBuilder();
                        res.setS2CCode(500);
                        res.setS2CMsg(LangService.getValue("BAG_NOT_ENOUGH_POS"));
                        this.body.writeBytes(res.build().toByteArray());
                        return;
                }
                res = AttendanceHandler.GetCumulativeRewardResponse.newBuilder();
                res.setS2CCode(500);
                res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


