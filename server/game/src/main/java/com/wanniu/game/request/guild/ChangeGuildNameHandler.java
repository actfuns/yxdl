package com.wanniu.game.request.guild;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.data.ext.GuildSettingExt;
import com.wanniu.game.guild.GuildResult;
import com.wanniu.game.guild.GuildUtil;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.GuildHandler;


@GClientEvent("area.guildHandler.changeGuildNameRequest")
public class ChangeGuildNameHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        GuildHandler.ChangeGuildNameRequest req = GuildHandler.ChangeGuildNameRequest.parseFrom(this.pak.getRemaingBytes());
        final String name = req.getName();

        return new PomeloResponse() {
            protected void write() throws IOException {
                GuildHandler.ChangeGuildNameResponse.Builder res = GuildHandler.ChangeGuildNameResponse.newBuilder();
                if (null == player) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }
                GuildResult ret = player.guildManager.changeGuildName(name);
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
                    res.setS2CMsg(LangService.getValue("PARAM_ERROR"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == -4) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("GUILD_NAME_TOO_SHORT"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == -5) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("GUILD_NAME_TOO_LONG"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == -6) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("GUILD_NAME_MATERIAL_NOT_ENOUGH"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == -8) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("GUILD_NAME_SPECIAL_CHAR"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == -9) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("GUILD_NAME_BLACK_STRING"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == 1) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("GUILD_NAME_EXIST"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == 2) {
                    GuildSettingExt prop = GuildUtil.getGuildSettingExtProp();
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("GUILD_NAME_CHANGE_CD").replace("{cd}", String.valueOf(prop.changeNameCD)));
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


