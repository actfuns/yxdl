package com.wanniu.game.request.attendance;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.entity.GPlayer;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.tcp.protocol.Packet;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.AttendanceHandler;


@GClientEvent("area.attendanceHandler.getAttendanceInfoRequest")
public class GetAttendanceInfoHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        return new PomeloResponse() {
            protected void write() throws IOException {
                GPlayer player = GetAttendanceInfoHandler.this.pak.getPlayer();
                if (player != null) {
                    WNPlayer wPlayer = (WNPlayer) player;
                    AttendanceHandler.GetAttendanceInfoResponse.Builder res = wPlayer.playerAttendance.createGetAttendanceInfoResponse();
                    res.setS2CCode(200);
                    this.body.writeBytes(res.build().toByteArray());
                } else {

                    AttendanceHandler.GetAttendanceInfoResponse.Builder res = AttendanceHandler.GetAttendanceInfoResponse.newBuilder();
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
                    this.body.writeBytes(res.build().toByteArray());
                }
            }
        };
    }
}


