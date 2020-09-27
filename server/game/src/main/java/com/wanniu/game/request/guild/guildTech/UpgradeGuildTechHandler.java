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


@GClientEvent("area.guildTechHandler.upgradeGuildTechRequest")
public class UpgradeGuildTechHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();

        return new PomeloResponse() {
            protected void write() throws IOException {
                GuildTechHandler.UpgradeGuildTechResponse.Builder res = GuildTechHandler.UpgradeGuildTechResponse.newBuilder();

                GuildTechManager guildTechManager = player.guildManager.guildTechManager;
                GuildResult ret = guildTechManager.upgradeTechLevel();
                int result = ret.result;
                GuildResult.UpgradeLevel resData = (GuildResult.UpgradeLevel) ret.data;
                if (result == 0) {
                    res.setS2CCode(200);
                    res.setS2CLevel(resData.level);
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
                    res.setS2CMsg(LangService.getValue("TECH_LEVEL_FULL"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == 4) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("GUILD_NEED_GUILD_LEVEL").replace("{buildingLevel}", String.valueOf(ret.needLevel)));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == 5) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("GOLD_NOT_ENOUGH"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == 6) {
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


