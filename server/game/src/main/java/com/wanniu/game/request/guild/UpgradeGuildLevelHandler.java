package com.wanniu.game.request.guild;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.guild.GuildResult;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.GuildHandler;


@GClientEvent("area.guildHandler.upgradeGuildLevelRequest")
public class UpgradeGuildLevelHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();


        return new PomeloResponse() {
            protected void write() throws IOException {
                GuildHandler.UpgradeGuildLevelResponse.Builder res = GuildHandler.UpgradeGuildLevelResponse.newBuilder();

                GuildResult ret = player.guildManager.upgradeGuildLevel();
                int result = ret.result;
                if (result == 0) {
                    GuildHandler.MyGuildInfo myGuildInfo = player.guildManager.getMyGuildInfo();
                    res.setS2CCode(200);
                    res.setS2CGuildInfo(myGuildInfo);
                    this.body.writeBytes(res.build().toByteArray());
                    player.guildManager.update();
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
                    res.setS2CMsg(LangService.getValue("GUILD_NO_POWER"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == -3) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == -4) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("GOLD_NOT_ENOUGH"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == 1) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("GUILD_LEVEL_FULL"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == 2) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("GUILD_NEED_BLESS_LEVEL").replace("{buildingLevel}", String.valueOf(ret.needLevel)));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == 3) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("GUILD_NEED_TECH_LEVEL").replace("{buildingLevel}", String.valueOf(ret.needLevel)));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == 4) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("GUILD_NEED_DEPOT_LEVEL").replace("{buildingLevel}", String.valueOf(ret.needLevel)));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == 5) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("GUILD_EXP_NOT_ENOUGH"));
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


