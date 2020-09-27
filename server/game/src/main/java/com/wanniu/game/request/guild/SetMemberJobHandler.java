package com.wanniu.game.request.guild;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.guild.GuildResult;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.GuildHandler;


@GClientEvent("area.guildHandler.setMemberJobRequest")
public class SetMemberJobHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        GuildHandler.SetMemberJobRequest req = GuildHandler.SetMemberJobRequest.parseFrom(this.pak.getRemaingBytes());
        final String memberId = req.getMemberId();
        final int job = req.getJob();

        return new PomeloResponse() {
            protected void write() throws IOException {
                GuildHandler.SetMemberJobResponse.Builder res = GuildHandler.SetMemberJobResponse.newBuilder();
                GuildResult ret = player.guildManager.setMemberJob(memberId, job);
                int result = ret.result;
                if (result == 0) {
                    res.setS2CCode(200);
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == -20) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("PARAM_ERROR"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == -21) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("GUILD_JOB_NOT_SET_SELF"));
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
                    res.setS2CMsg(LangService.getValue("GUILD_MEMBER_NOT_EXIST"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == -3) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("GUILD_NO_POWER"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == -4) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("GUILD_JOB_HIGHER_THAN_YOU"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == -5) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("GUILD_JOB_FULL"));
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


