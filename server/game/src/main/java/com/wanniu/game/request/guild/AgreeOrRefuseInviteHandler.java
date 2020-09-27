package com.wanniu.game.request.guild;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.guild.GuildCommonUtil;
import com.wanniu.game.guild.GuildResult;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;
import java.util.HashMap;
import java.util.TreeMap;

import pomelo.area.GuildHandler;


@GClientEvent("area.guildHandler.agreeOrRefuseInviteRequest")
public class AgreeOrRefuseInviteHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        GuildHandler.AgreeOrRefuseInviteRequest req = GuildHandler.AgreeOrRefuseInviteRequest.parseFrom(this.pak.getRemaingBytes());
        final int isAgree = req.getC2SIsAgree();
        final String playerId = req.getC2SInviteId();
        final String guildId = req.getC2SGuildId();

        return new PomeloResponse() {
            protected void write() throws IOException {
                GuildHandler.AgreeOrRefuseInviteResponse.Builder res = GuildHandler.AgreeOrRefuseInviteResponse.newBuilder();
                if (null == player) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }
                if (0 == isAgree) {
                    String playerName = PlayerUtil.getColorPlayerNameByPro(player.getPro(), player.getName());
                    HashMap<String, String> map = new HashMap<>();
                    map.put("rolename", playerName);
                    GuildCommonUtil.sendMailSystenType(playerId, "Guild_invite_refused", map);
                    res.setS2CCode(200);
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }
                GuildResult resData = player.guildManager.joinGuild(guildId);
                int result = resData.result;
                if (result == 0) {

                    String playerName = PlayerUtil.getColorPlayerNameByPro(player.getPro(), player.getName());
                    TreeMap<String, String> map1 = new TreeMap<>();
                    map1.put("rolename", playerName);
                    GuildCommonUtil.sendMailSystenType(playerId, "Guild_invite_agreed", map1);
                    res.setS2CCode(200);
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }
                res.setS2CCode(500);
                String errMsg = GuildCommonUtil.getJoinGuildErrorMsg(resData);
                res.setS2CMsg(errMsg);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


