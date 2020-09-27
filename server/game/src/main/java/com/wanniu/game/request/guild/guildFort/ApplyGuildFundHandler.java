package com.wanniu.game.request.guild.guildFort;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.GuildFortHandler;


@GClientEvent("area.guildFortHandler.applyGuildFundRequest")
public class ApplyGuildFundHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        return new PomeloResponse() {
            protected void write() throws IOException {
                GuildFortHandler.ApplyGuildFundResponse.Builder res = GuildFortHandler.ApplyGuildFundResponse.newBuilder();
                String msg = ApplyGuildFundHandler.this.handleApplyGuildFund(res, player);

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

    private String handleApplyGuildFund(GuildFortHandler.ApplyGuildFundResponse.Builder res, WNPlayer player) {
        if (!player.guildManager.isInGuild()) {
            res.setGuildFund(0);
            return LangService.getValue("GUILD_NOT_JOIN");
        }

        int fund = (int) (player.guildManager.getGuildInfo()).fund;
        res.setGuildFund(fund);

        return null;
    }
}


