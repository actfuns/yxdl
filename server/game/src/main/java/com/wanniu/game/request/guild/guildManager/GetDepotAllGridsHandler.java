package com.wanniu.game.request.guild.guildManager;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.guild.guidDepot.GuildDepotCenter;
import com.wanniu.game.guild.guidDepot.PlayerGuildDepot;
import com.wanniu.game.player.WNPlayer;
import io.netty.util.internal.StringUtil;

import java.io.IOException;

import pomelo.guild.GuildManagerHandler;


@GClientEvent("guild.guildManagerHandler.getDepotAllGridsRequest")
public class GetDepotAllGridsHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        return new PomeloResponse() {
            protected void write() throws IOException {
                GuildManagerHandler.GetDepotAllGridsResponse.Builder res = GuildManagerHandler.GetDepotAllGridsResponse.newBuilder();

                GuildDepotCenter depotManager = GuildDepotCenter.getInstance();
                if (StringUtil.isNullOrEmpty(player.getId()) || null == depotManager) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                PlayerGuildDepot data = depotManager.getDepotDataByPlayerId(player);
                res.setS2CCode(200);
                res.setS2CBagInfo(data.bagInfo);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


