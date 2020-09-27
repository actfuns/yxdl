package com.wanniu.game.request.guild;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.guild.GuildResult;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.GuildHandler;


@GClientEvent("area.guildHandler.changeGuildNoticeRequest")
public class ChangeGuildNoticeHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        GuildHandler.ChangeGuildNoticeRequest req = GuildHandler.ChangeGuildNoticeRequest.parseFrom(this.pak.getRemaingBytes());
        final String notice = req.getNotice();

        return new PomeloResponse() {
            protected void write() throws IOException {
                GuildHandler.ChangeGuildNoticeResponse.Builder res = GuildHandler.ChangeGuildNoticeResponse.newBuilder();
                if (null == player) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }
                GuildResult resData = player.guildManager.changeGuildNotice(notice);
                int result = resData.result;
                if (result == 0) {
                    res.setS2CCode(200);
                    res.setS2CNotice(resData.newNotice);
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
                    res.setS2CMsg(LangService.getValue("PARAM_ERROR"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == -4) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("GUILD_NOTICE_TOO_LONG"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == -9) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("GUILD_NOTICE_BLACK_STRING"));
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


