package com.wanniu.game.request.guild;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.guild.GuildResult;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.GuildHandler;


@GClientEvent("area.guildHandler.transferPresidentRequest")
public class TransferPresidentHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        GuildHandler.TransferPresidentRequest req = GuildHandler.TransferPresidentRequest.parseFrom(this.pak.getRemaingBytes());
        final String memberId = req.getMemberId();
        return new PomeloResponse() {
            protected void write() throws IOException {
                GuildHandler.TransferPresidentResponse.Builder res = GuildHandler.TransferPresidentResponse.newBuilder();

                GuildResult ret = player.guildManager.transferGuildPresident(memberId);
                int result = ret.result;
                if (result == 0) {
                    GuildResult.MyGuildMember data = (GuildResult.MyGuildMember) (player.guildManager.getMyGuildMemberList()).data;
                    GuildHandler.MyGuildInfo guildInfo = player.guildManager.getMyGuildInfo();
                    res.setS2CCode(200);
                    res.addAllS2CMemberList(data.list);
                    res.setS2CGuildInfo(guildInfo);
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == -20) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("PARAM_ERROR"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == -1) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("GUILD_NOT_JOIN"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == -2) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("GUILD_NO_POWER"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == -3) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("GUILD_MEMBER_NOT_EXIST"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                res.setS2CCode(500);
                res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


