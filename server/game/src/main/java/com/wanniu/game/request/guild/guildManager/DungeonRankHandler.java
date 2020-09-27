package com.wanniu.game.request.guild.guildManager;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.guild.GuildService;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;
import java.util.ArrayList;

import pomelo.guild.GuildManagerHandler;


@GClientEvent("guild.guildManagerHandler.dungeonRankRequest")
public class DungeonRankHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        final GuildManagerHandler.DungeonRankRequest req = GuildManagerHandler.DungeonRankRequest.parseFrom(this.pak.getRemaingBytes());
        return new PomeloResponse() {
            protected void write() throws IOException {
                GuildManagerHandler.DungeonRankResponse.Builder res = GuildManagerHandler.DungeonRankResponse.newBuilder();
                ArrayList<GuildManagerHandler.RankInfo> data = GuildService.dungeonRank(player.getId(), req.getS2CType());
                res.setS2CCode(200);
                res.addAllS2CData(data);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


