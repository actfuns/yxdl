package com.wanniu.game.request.guild;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.guild.GuildResult;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;
import java.util.List;

import pomelo.area.GuildHandler;


@GClientEvent("area.guildHandler.changeOfficeNameRequest")
public class ChangeOfficeNameHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        GuildHandler.ChangeOfficeNameRequest req = GuildHandler.ChangeOfficeNameRequest.parseFrom(this.pak.getRemaingBytes());
        final List<GuildHandler.OfficeName> officeNames = req.getOfficeNamesList();

        return new PomeloResponse() {
            protected void write() throws IOException {
                GuildHandler.ChangeOfficeNameResponse.Builder res = GuildHandler.ChangeOfficeNameResponse.newBuilder();
                if (null == player) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }
                GuildResult ret = player.guildManager.changeOfficeName(officeNames);
                int result = ret.result;
                if (result == 0) {
                    res.setS2CCode(200);
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
                    res.setS2CMsg(LangService.getValue("GUILD_JOB_NOT_EXIST"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == -4) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("GUILD_JOB_NAME_EMPTY"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == -5) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("GUILD_JOB_NAME_TOO_LONG"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == -8) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("GUILD_JOB_NAME_SPECIAL_CHAR"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == -9) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("GUILD_JOB_NAME_BLACK_STRING"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == 1) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("GUILD_JOB_NAME_REPEATED"));
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


