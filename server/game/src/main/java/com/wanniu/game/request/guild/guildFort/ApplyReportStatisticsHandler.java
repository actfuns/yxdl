package com.wanniu.game.request.guild.guildFort;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.GuildFortHandler;


@GClientEvent("area.guildFortHandler.applyReportStatisticsRequest")
public class ApplyReportStatisticsHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        GuildFortHandler.ApplyReportStatisticsRequest req = GuildFortHandler.ApplyReportStatisticsRequest.parseFrom(this.pak.getRemaingBytes());
        final String date = req.getDate();
        final int fortId = req.getAreaId();
        final String guildId = req.getGuildId();

        return new PomeloResponse() {
            protected void write() throws IOException {
                GuildFortHandler.ApplyReportStatisticsResponse.Builder res = GuildFortHandler.ApplyReportStatisticsResponse.newBuilder();
                String msg = player.guildFortManager.handleApplyReportStatistics(res, date, fortId, guildId);
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


