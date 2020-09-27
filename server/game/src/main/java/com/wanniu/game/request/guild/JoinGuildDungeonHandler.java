package com.wanniu.game.request.guild;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.area.Area;
import com.wanniu.game.guild.guildDungeon.GuildDungeonResult;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.GuildHandler;


@GClientEvent("area.guildHandler.joinGuildDungeonRequest")
public class JoinGuildDungeonHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        GuildHandler.JoinGuildDungeonRequest req = GuildHandler.JoinGuildDungeonRequest.parseFrom(this.pak.getRemaingBytes());
        final int c2s_type = req.getC2SType();
        return new PomeloResponse() {
            protected void write() throws IOException {
                GuildHandler.JoinGuildDungeonResponse.Builder res = GuildHandler.JoinGuildDungeonResponse.newBuilder();
                Area area = player.getArea();
                GuildDungeonResult data = player.guildManager.joinGuildDungeon(area, c2s_type);
                if (data.result) {
                    res.setS2CCode(200);
                    res.setS2CType(data.type);
                    this.body.writeBytes(res.build().toByteArray());
                } else {
                    res.setS2CCode(500);
                    res.setS2CMsg(data.info);
                    this.body.writeBytes(res.build().toByteArray());
                }
            }
        };
    }
}


