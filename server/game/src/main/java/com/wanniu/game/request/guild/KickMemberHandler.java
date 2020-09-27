package com.wanniu.game.request.guild;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.util.StringUtil;
import com.wanniu.game.area.AreaUtil;
import com.wanniu.game.common.Const;
import com.wanniu.game.guild.GuildResult;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.GuildHandler;


@GClientEvent("area.guildHandler.kickMemberRequest")
public class KickMemberHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        final GuildHandler.KickMemberRequest req = GuildHandler.KickMemberRequest.parseFrom(this.pak.getRemaingBytes());
        return new PomeloResponse() {
            protected void write() throws IOException {
                GuildHandler.KickMemberResponse.Builder res = GuildHandler.KickMemberResponse.newBuilder();
                String kickId = req.getMemberId();
                WNPlayer kickPlayer = PlayerUtil.getOnlinePlayer(kickId);

                if (null != kickPlayer) {
                    int areaType = AreaUtil.getAreaType(kickPlayer.getAreaId());
                    if (areaType == Const.SCENE_TYPE.GUILD_DUNGEON.getValue()) {
                        res.setS2CCode(500);
                        res.setS2CMsg(LangService.getValue("IN_GDUNGEON_KICK"));
                        this.body.writeBytes(res.build().toByteArray());

                        return;
                    }
                }
                GuildResult resData = player.guildManager.kickMember(kickId);
                int result = resData.result;
                if (result == 0) {
                    res.setS2CCode(200);
                    res.setS2CLeftKickNum(resData.leftKickNum);
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == -1) {
                    res.setS2CCode(500);
                    if (StringUtil.isNotEmpty(resData.des)) {
                        res.setS2CMsg(resData.des);
                    } else {
                        res.setS2CMsg(LangService.getValue("GUILD_NOT_JOIN"));
                    }
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
                if (result == -4) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("GUILD_KICK_JOB_TOO_LOW"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == -5) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("GUILD_JOIN_TIME_TOO_SHORT"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == -6) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("GUILD_KICK_NUM_NOT_ENOUGH"));
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


