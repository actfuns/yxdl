package com.wanniu.game.request.guild.guildFort;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.GuildFortHandler;


@GClientEvent("area.guildFortHandler.applyReportDetailRequest")
public class ApplyReportDetailHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        GuildFortHandler.ApplyReportDetailRequest req = GuildFortHandler.ApplyReportDetailRequest.parseFrom(this.pak.getRemaingBytes());
        final String date = req.getDate();
        final int fortId = req.getAreaId();

        return new PomeloResponse() {
            protected void write() throws IOException {
                GuildFortHandler.ApplyReportDetailResponse.Builder res = GuildFortHandler.ApplyReportDetailResponse.newBuilder();
                String msg = player.guildFortManager.handleApplyReportDetail(res, date, fortId);
                if (msg != null) {
                    res.setS2CCode(500);
                    res.setS2CMsg(msg);
                } else {
                    res.setS2CCode(200);
                }
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


