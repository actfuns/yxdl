package com.wanniu.game.request.guild.guildManager;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.logfs.Out;
import com.wanniu.game.guild.GuildCommonUtil;
import com.wanniu.game.guild.guidDepot.GuildDepotCenter;
import com.wanniu.game.guild.guidDepot.PlayerGuildDepot;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.guild.GuildManagerHandler;


@GClientEvent("guild.guildManagerHandler.getDepotInfoRequest")
public class GetDepotInfoHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();


        return new PomeloResponse() {
            protected void write() throws IOException {
                GuildManagerHandler.GetDepotInfoResponse.Builder res = GuildManagerHandler.GetDepotInfoResponse.newBuilder();

                PlayerGuildDepot depotData = GuildDepotCenter.getInstance().getDepotDataByPlayerId(player);
                if (null == depotData) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }
                GuildManagerHandler.DepotInfo.Builder depotInfo = GuildManagerHandler.DepotInfo.newBuilder();
                if (null != depotData.depotInfo) {
                    depotInfo.setLevel(depotData.depotInfo.level);
                    GuildManagerHandler.DepotCondition depCond = GuildCommonUtil.toManagerCond(depotData.depotInfo.condition);
                    if (null != depCond) {
                        depotInfo.setDepotCond(depCond);
                    } else {
                        Out.error(new Object[]{"depCond is null:", depCond});
                    }

                    depotInfo.setDeleteCount(depotData.depotInfo.deleteCount);
                    depotInfo.setDeleteCountMax(depotData.depotInfo.deleteCountMax);
                }

                GuildManagerHandler.BagInfo.Builder depotBag = GuildManagerHandler.BagInfo.newBuilder();
                if (null != depotData.bagInfo) {
                    depotBag.setBagGridCount(depotData.bagInfo.getBagGridCount());
                    depotBag.setBagTotalCount(depotData.bagInfo.getBagTotalCount());
                    depotBag.addAllBagGrids(depotData.bagInfo.getBagGridsList());
                    depotBag.addAllBagDetails(depotData.detailInfo);
                }

                res.setS2CCode(200);
                res.setS2CDepotInfo(depotInfo.build());
                res.setS2CDepotBag(depotBag.build());
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


