package com.wanniu.game.request.guild;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.guild.GuildResult;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.GuildHandler;


@GClientEvent("area.guildHandler.contributeToGuildRequest")
public class ContributeToGuildHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        final GuildHandler.ContributeToGuildRequest req = GuildHandler.ContributeToGuildRequest.parseFrom(this.pak.getRemaingBytes());

        return new PomeloResponse() {
            protected void write() throws IOException {
                GuildHandler.ContributeToGuildResponse.Builder res = GuildHandler.ContributeToGuildResponse.newBuilder();
                if (null == player) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }
                GuildResult resData = player.guildManager.contributeToGuild(req.getType(), req.getTimes());
                int result = resData.result;
                if (result == 0) {
                    GuildHandler.MyGuildInfo guildInfo = player.guildManager.getMyGuildInfo();
                    res.setS2CCode(200);
                    res.setS2CGuildInfo(guildInfo);
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == -1) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("GUILD_NOT_JOIN"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == -2) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("PARAM_ERROR"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == -3) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("GOLD_NOT_ENOUGH"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == -4) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("GUILD_CONTRIBUTE_MATERIAL_NOT_ENOUGH"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == -5) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("GUILD_CONTRIBUTE_TIME_NOT_ENOUGH"));
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


