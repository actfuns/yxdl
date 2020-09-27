package com.wanniu.game.request.guild.guildBless;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.GuildBlessHandler;


@GClientEvent("area.guildBlessHandler.getMyBlessInfoRequest")
public class GetMyBlessInfoHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();

        return new PomeloResponse() {
            protected void write() throws IOException {
                GuildBlessHandler.GetMyBlessInfoResponse.Builder res = GuildBlessHandler.GetMyBlessInfoResponse.newBuilder();

                GuildBlessHandler.MyBlessInfo data = player.guildManager.getMyBlessInfo();
                res.setS2CCode(200);
                res.setS2CBlessInfo(data);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


