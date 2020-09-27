package com.wanniu.game.request.guild;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.util.StringUtil;
import com.wanniu.game.guild.GuildResult;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.GuildHandler;


@GClientEvent("area.guildHandler.exitGuildRequest")
public class ExitGuildHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        return new PomeloResponse() {
            protected void write() throws IOException {
                GuildHandler.ExitGuildResponse.Builder res = GuildHandler.ExitGuildResponse.newBuilder();
                GuildResult ret = player.guildManager.exitGuild();
                int result = ret.result;
                if (result == 0) {
                    res.setS2CCode(200);
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == 1) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("GUILD_NOT_JOIN"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == 2) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("GUILD_PRESIDENT_CANNOT_EXIT"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                res.setS2CCode(500);
                res.setS2CMsg(StringUtil.isNotEmpty(ret.des) ? ret.des : LangService.getValue("SOMETHING_ERR"));
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


