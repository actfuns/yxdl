package com.wanniu.game.request.guild;

import com.alibaba.fastjson.JSONObject;
import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.GWorld;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.msg.MessageUtil;
import com.wanniu.game.data.ext.GuildSettingExt;
import com.wanniu.game.guild.GuildResult;
import com.wanniu.game.guild.GuildUtil;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.GuildHandler;


@GClientEvent("area.guildHandler.createGuildRequest")
public class CreateGuildHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        final GuildHandler.CreateGuildRequest req = GuildHandler.CreateGuildRequest.parseFrom(this.pak.getRemaingBytes());
        final JSONObject params = new JSONObject();
        params.put("icon", req.getC2SIcon());
        params.put("name", req.getC2SName());
        params.put("qqGroup", req.getC2SQqGroup());

        return new PomeloResponse() {
            protected void write() throws IOException {
                GuildHandler.CreateGuildResponse.Builder res = GuildHandler.CreateGuildResponse.newBuilder();
                if (null == player) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                GuildResult ret = player.guildManager.createGuild(params);
                int result = ret.result;
                if (0 == result) {
                    GuildHandler.MyGuildInfo guildInfo = player.guildManager.getMyGuildInfo();
                    if (null == guildInfo) {
                        res.setS2CCode(500);
                        res.setS2CMsg(LangService.getValue("GUILD_NAME_EXIST"));
                        this.body.writeBytes(res.build().toByteArray());
                        return;
                    }
                    MessageUtil.sendRollChat(GWorld.__SERVER_ID, String.format(LangService.getValue("GUILD_CREATE"), new Object[]{this.val$player.getName(), this.val$req.getC2SName()}), Const.CHAT_SCOPE.SYSTEM);
                    res.setS2CCode(200);
                    res.setS2CGuildInfo(guildInfo);
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                GuildSettingExt prop = GuildUtil.getGuildSettingExtProp();
                if (-1 == result) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (-2 == result) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("GUILD_CREATE_ERROR"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (-3 == result) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("GUILD_CREATE_LEVEL").replace("{roleLevel}", String.valueOf(prop.joinLv)));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (-4 == result) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("GUILD_CREATE_COST").replace("{guildPay}", String.valueOf(prop.cost)));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (-5 == result) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("PARAM_ERROR"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (-6 == result) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("GUILD_NAME_TOO_SHORT"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (-7 == result) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("GUILD_NAME_TOO_LONG"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (-8 == result) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("GUILD_NAME_SPECIAL_CHAR"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (-9 == result) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("GUILD_NAME_BLACK_STRING"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (-10 == result) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("GUILD_CREATE_CD").replace("{time}", String.valueOf(ret.cdInfo)));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (1 == result) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("GUILD_NAME_EXIST"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (-11 == result) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("GUILD_NAME_EMPTY"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
            }
        };
    }
}


