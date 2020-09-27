package com.wanniu.game.request.guild.guildManager;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.guild.guildBless.GuildBlessCenter;
import com.wanniu.game.player.WNPlayer;
import io.netty.util.internal.StringUtil;

import java.io.IOException;

import pomelo.guild.GuildManagerHandler;


@GClientEvent("guild.guildManagerHandler.getBlessInfoRequest")
public class GetBlessInfoHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();


        return new PomeloResponse() {
            protected void write() throws IOException {
                GuildManagerHandler.GetBlessInfoResponse.Builder res = GuildManagerHandler.GetBlessInfoResponse.newBuilder();

                GuildBlessCenter blessManager = GuildBlessCenter.getInstance();
                if (StringUtil.isNullOrEmpty(player.getId()) || null == blessManager) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }
                GuildManagerHandler.GuildBlessInfo blessData = blessManager.getBlessInfoByPlayerId(player.getId());
                res.setS2CCode(200);
                res.setS2CBlessInfo(blessData);

                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


