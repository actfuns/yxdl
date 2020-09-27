package com.wanniu.game.request.guild.guildFort;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.GuildFortHandler;


@GClientEvent("area.guildFortHandler.getGuildAreaApplyListRequest")
public class GetGuildAreaApplyListHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        GuildFortHandler.GetGuildAreaApplyListRequest req = GuildFortHandler.GetGuildAreaApplyListRequest.parseFrom(this.pak.getRemaingBytes());
        final int fortId = req.getAreaId();

        return new PomeloResponse() {
            protected void write() throws IOException {
                GuildFortHandler.GetGuildAreaApplyListResponse.Builder res = GuildFortHandler.GetGuildAreaApplyListResponse.newBuilder();
                String msg = player.guildFortManager.handleGetGuildAreaApplyList(res, fortId);
                if (msg != null) {
                    res.setS2CCode(500);
                    res.setS2CMsg(msg);
                } else {
                    res.setS2CCode(200);
                }
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


