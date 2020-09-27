package com.wanniu.game.request.guild;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;
import java.util.List;

import pomelo.area.GuildHandler;


@GClientEvent("area.guildHandler.getApplyListRequest")
public class GetApplyListHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();


        return new PomeloResponse() {
            protected void write() throws IOException {
                GuildHandler.GetApplyListResponse.Builder res = GuildHandler.GetApplyListResponse.newBuilder();

                List<GuildHandler.ApplyInfo> applyList = player.guildManager.getMyGuildApplyList();
                res.setS2CCode(200);
                res.addAllS2CApplyList(applyList);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


