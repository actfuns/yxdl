package com.wanniu.game.request.guild.guildTech;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.guild.guildTech.GuildTechManager;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.GuildTechHandler;


@GClientEvent("area.guildTechHandler.getGuildTechInfoRequest")
public class GetGuildTechInfoHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();

        return new PomeloResponse() {
            protected void write() throws IOException {
                GuildTechHandler.GetGuildTechInfoResponse.Builder res = GuildTechHandler.GetGuildTechInfoResponse.newBuilder();

                GuildTechManager guildTechManager = player.guildManager.guildTechManager;
                guildTechManager.getGuildTechAsync();
                GuildTechHandler.GuildTechInfo techInfo = guildTechManager.toJson4PayLoad();
                res.setS2CCode(200);
                res.setS2CTechInfo(techInfo);
                res.setS2CContribution(player.guildManager.getContribution());
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


