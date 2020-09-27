package com.wanniu.game.request.guild;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.guild.GuildResult;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.GuildHandler;


@GClientEvent("area.guildHandler.getMyGuildMembersRequest")
public class GetMyGuildMembersHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();

        return new PomeloResponse() {
            protected void write() throws IOException {
                GuildHandler.GetMyGuildMembersResponse.Builder res = GuildHandler.GetMyGuildMembersResponse.newBuilder();

                GuildResult ret = player.guildManager.getMyGuildMemberList();
                if (0 != ret.result) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("GUILD_NOT_EXIST"));
                    this.body.writeBytes(res.build().toByteArray());
                }

                res.setS2CCode(200);
                GuildResult.MyGuildMember data = (GuildResult.MyGuildMember) ret.data;
                if (null != data) {
                    res.addAllS2CMemberList(data.list);
                    res.setS2CLeftKickNum(data.leftKickNum);
                }
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


