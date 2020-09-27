package com.wanniu.game.request.guild;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.guild.GuildCommonUtil;
import com.wanniu.game.guild.GuildResult;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.GuildHandler;


@GClientEvent("area.guildHandler.joinGuildRequest")
public class JoinGuildHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        GuildHandler.JoinGuildRequest req = GuildHandler.JoinGuildRequest.parseFrom(this.pak.getRemaingBytes());
        final String c2s_guildId = req.getC2SGuildId();
        return new PomeloResponse() {
            protected void write() throws IOException {
                GuildHandler.JoinGuildResponse.Builder res = GuildHandler.JoinGuildResponse.newBuilder();

                GuildResult resData = player.guildManager.joinGuild(c2s_guildId);
                int result = resData.result;
                if (result == 0) {
                    res.setS2CCode(200);
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }
                res.setS2CCode(500);
                String errMsg = GuildCommonUtil.getJoinGuildErrorMsg(resData);
                res.setS2CMsg(errMsg);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


