package com.wanniu.game.request.guild.guildDepot;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.guild.GuildResult;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.GuildDepotHandler;


@GClientEvent("area.guildDepotHandler.upgradeDepotRequest")
public class UpgradeDepotHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();

        return new PomeloResponse() {
            protected void write() throws IOException {
                GuildDepotHandler.UpgradeDepotResponse.Builder res = GuildDepotHandler.UpgradeDepotResponse.newBuilder();

                GuildResult resData = player.guildManager.upgradeDepotLevel();
                int result = resData.result;
                GuildResult.DepotUpgradeLevelData data = (GuildResult.DepotUpgradeLevelData) resData.data;
                if (result == 0) {
                    res.setS2CCode(200);
                    res.setS2CLevel(data.newLevel);
                    res.setS2CFund((int) data.fund);
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
                    res.setS2CMsg(LangService.getValue("DEPOT_NOT_EXIST"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == 4) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("DEPOT_LEVEL_FULL"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == 5) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("GUILD_LEVEL_NOT_ENOUGH"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == 6) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("GOLD_NOT_ENOUGH"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == 7) {
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


