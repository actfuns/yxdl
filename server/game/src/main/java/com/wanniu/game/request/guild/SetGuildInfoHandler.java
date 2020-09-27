package com.wanniu.game.request.guild;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.data.ext.GuildSettingExt;
import com.wanniu.game.guild.GuildResult;
import com.wanniu.game.guild.GuildSetData;
import com.wanniu.game.guild.GuildUtil;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.GuildHandler;


@GClientEvent("area.guildHandler.setGuildInfoRequest")
public class SetGuildInfoHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        final GuildHandler.SetGuildInfoRequest req = GuildHandler.SetGuildInfoRequest.parseFrom(this.pak.getRemaingBytes());

        return new PomeloResponse() {
            protected void write() throws IOException {
                GuildHandler.SetGuildInfoResponse.Builder res = GuildHandler.SetGuildInfoResponse.newBuilder();
                GuildSetData params = new GuildSetData();
                params.entryLevel = req.getEntryLevel();
                params.entryUpLevel = req.getEntryUpLevel();
                params.guildMode = req.getGuildMode();
                GuildResult ret = player.guildManager.setGuildInfo(params);
                int result = ret.result;
                if (result == 0) {
                    res.setS2CCode(200);
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == -1) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == -2) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("GUILD_NOT_JOIN"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == -3) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("GUILD_NO_POWER"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == -4) {
                    GuildSettingExt prop = GuildUtil.getGuildSettingExtProp();
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("GUILD_ENTRY_MIN_LEVEL").replace("{roleLevel}", String.valueOf(prop.joinLv)));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                res.setS2CCode(500);
                res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


