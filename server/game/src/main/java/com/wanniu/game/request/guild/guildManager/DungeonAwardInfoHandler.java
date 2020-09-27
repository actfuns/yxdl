package com.wanniu.game.request.guild.guildManager;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.guild.GuildService;
import com.wanniu.game.guild.guildDungeon.GuildDungeonAward;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.guild.GuildManagerHandler;


@GClientEvent("guild.guildManagerHandler.dungeonAwardInfoRequest")
public class DungeonAwardInfoHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();

        return new PomeloResponse() {
            protected void write() throws IOException {
                GuildManagerHandler.DungeonAwardInfoResponse.Builder res = GuildManagerHandler.DungeonAwardInfoResponse.newBuilder();

                GuildDungeonAward data = GuildService.dungeonAwardInfo(player.getId());
                res.setS2CCode(200);
                res.addAllItemInfos(data.itemInfos);
                res.setDiceLeftTime(data.diceLeftTime);
                res.addAllGetDungeonScoreInfo(data.getDungeonScoreInfo);
                res.setIsFightOver(data.isFightOver);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


