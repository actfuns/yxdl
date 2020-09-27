package com.wanniu.game.request.guild;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.GuildHandler;


@GClientEvent("area.guildHandler.getMyGuildInfoRequest")
public class GetMyGuildInfoHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();

        return new PomeloResponse() {
            protected void write() throws IOException {
                GuildHandler.GetMyGuildInfoResponse.Builder res = GuildHandler.GetMyGuildInfoResponse.newBuilder();

                GuildHandler.MyGuildInfo guildInfo = player.guildManager.getMyGuildInfo();
                res.setS2CCode(200);
                if (null != guildInfo) {
                    res.setS2CGuildInfo(guildInfo);
                }
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


