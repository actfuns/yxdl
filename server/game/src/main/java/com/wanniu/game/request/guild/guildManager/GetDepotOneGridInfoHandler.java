package com.wanniu.game.request.guild.guildManager;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.guild.guidDepot.GuildDepotCenter;
import com.wanniu.game.guild.guidDepot.GuildDepotOneGrid;
import com.wanniu.game.player.WNPlayer;
import io.netty.util.internal.StringUtil;

import java.io.IOException;

import pomelo.guild.GuildManagerHandler;


@GClientEvent("guild.guildManagerHandler.getDepotOneGridInfoRequest")
public class GetDepotOneGridInfoHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        GuildManagerHandler.GetDepotOneGridInfoRequest req = GuildManagerHandler.GetDepotOneGridInfoRequest.parseFrom(this.pak.getRemaingBytes());
        final int bagIndex = req.getBagIndex();
        return new PomeloResponse() {
            protected void write() throws IOException {
                GuildManagerHandler.GetDepotOneGridInfoResponse.Builder res = GuildManagerHandler.GetDepotOneGridInfoResponse.newBuilder();
                GuildDepotCenter depotManager = GuildDepotCenter.getInstance();
                if (StringUtil.isNullOrEmpty(player.getId()) || null == depotManager) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }
                GuildDepotOneGrid data = depotManager.getDepotOneGridInfoByPlayerId(player, bagIndex);
                res.setS2CCode(200);
                res.setS2CBagGrid(data.grid);
                res.setS2CBagDetail(data.detail);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


