package com.wanniu.game.request.guild.guildManager;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.guild.guidDepot.GuildDepotCenter;
import com.wanniu.game.player.WNPlayer;
import io.netty.util.internal.StringUtil;

import java.io.IOException;
import java.util.ArrayList;

import pomelo.guild.GuildManagerHandler;
import pomelo.item.ItemOuterClass;


@GClientEvent("guild.guildManagerHandler.getDepotAllDetailsRequest")
public class GetDepotAllDetailsHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();


        return new PomeloResponse() {
            protected void write() throws IOException {
                GuildManagerHandler.GetDepotAllDetailsResponse.Builder res = GuildManagerHandler.GetDepotAllDetailsResponse.newBuilder();

                GuildDepotCenter depotManager = GuildDepotCenter.getInstance();
                if (StringUtil.isNullOrEmpty(player.getId()) || null == depotManager) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                ArrayList<ItemOuterClass.ItemDetail> list = depotManager.getDepotDetailsByPlayerId(player);
                res.setS2CCode(200);
                res.addAllS2CBagDetails(list);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


