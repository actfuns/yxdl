package com.wanniu.game.request.guild;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;
import java.util.List;

import pomelo.area.GuildHandler;


@GClientEvent("area.guildHandler.getGuildListRequest")
public class GetGuildListHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        final GuildHandler.GetGuildListRequest req = GuildHandler.GetGuildListRequest.parseFrom(this.pak.getRemaingBytes());

        return new PomeloResponse() {
            protected void write() throws IOException {
                GuildHandler.GetGuildListResponse.Builder res = GuildHandler.GetGuildListResponse.newBuilder();
                List<GuildHandler.GuildInfo> guildList = player.guildManager.getGuildList(req.getC2SName());
                res.setS2CCode(200);
                res.addAllS2CGuildList(guildList);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


