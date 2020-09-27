package com.wanniu.game.request.guild.guildManager;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.guild.GuildService;
import com.wanniu.game.guild.guildDungeon.OpenGuildDungeonResult;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.guild.GuildManagerHandler;


@GClientEvent("guild.guildManagerHandler.openGuildDungeonRequest")
public class OpenGuildDungeonHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();

        return new PomeloResponse() {
            protected void write() throws IOException {
                GuildManagerHandler.OpenGuildDungeonResponse.Builder res = GuildManagerHandler.OpenGuildDungeonResponse.newBuilder();

                OpenGuildDungeonResult data = GuildService.openGuildDungeon(player.getId());
                if (data.result) {
                    res.setS2CCode(200);
                    res.setS2CWaitTime((int) data.waitTime);
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                res.setS2CCode(500);
                res.setS2CMsg(data.info);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


