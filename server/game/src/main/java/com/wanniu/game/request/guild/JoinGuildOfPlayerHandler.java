package com.wanniu.game.request.guild;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.guild.GuildCommonUtil;
import com.wanniu.game.guild.GuildResult;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.GuildHandler;


@GClientEvent("area.guildHandler.joinGuildOfPlayerRequest")
public class JoinGuildOfPlayerHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        GuildHandler.JoinGuildOfPlayerRequest req = GuildHandler.JoinGuildOfPlayerRequest.parseFrom(this.pak.getRemaingBytes());
        final String c2s_playerId = req.getC2SPlayerId();
        return new PomeloResponse() {
            protected void write() throws IOException {
                GuildHandler.JoinGuildOfPlayerResponse.Builder res = GuildHandler.JoinGuildOfPlayerResponse.newBuilder();

                GuildResult resData = player.guildManager.joinGuildByPlayerId(c2s_playerId);
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


