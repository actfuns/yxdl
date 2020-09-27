package com.wanniu.game.request.guild.guildTech;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.guild.GuildResult;
import com.wanniu.game.guild.guildTech.GuildTechManager;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.GuildTechHandler;


@GClientEvent("area.guildTechHandler.upgradeGuildBuffRequest")
public class UpgradeGuildBuffHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();

        return new PomeloResponse() {
            protected void write() throws IOException {
                GuildTechHandler.UpgradeGuildBuffResponse.Builder res = GuildTechHandler.UpgradeGuildBuffResponse.newBuilder();

                GuildTechManager guildTechManager = player.guildManager.guildTechManager;
                GuildResult ret = guildTechManager.upgradeBuffLevel();
                GuildResult.UpgradeLevel resData = (GuildResult.UpgradeLevel) ret.data;
                int result = ret.result;
                if (result == 0) {
                    GuildTechHandler.GuildBuff buffData = guildTechManager.getBuffData();
                    res.setS2CCode(200);
                    res.setS2CBuffInfo(buffData);
                    res.setS2CFund((int) resData.fund);
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
                    res.setS2CMsg(LangService.getValue("GUILD_NO_POWER"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == 3) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("TECH_BUFF_LEVEL_FULL"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == 4) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("TECH_BUFF_NEED_TECH_LEVEL"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == 5) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("GUILD_FUND_NOT_ENOUGH"));
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


