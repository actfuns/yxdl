package com.wanniu.game.request.guild.guildManager;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.guild.GuildUtil;
import com.wanniu.game.guild.guidDepot.GuildDepot;
import com.wanniu.game.guild.guidDepot.GuildDepotCenter;
import com.wanniu.game.guild.guildBless.GuildBless;
import com.wanniu.game.guild.guildBless.GuildBlessCenter;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.GuildMemberPO;
import io.netty.util.internal.StringUtil;

import java.io.IOException;

import pomelo.guild.GuildManagerHandler;


@GClientEvent("guild.guildManagerHandler.getBuildingLevelRequest")
public class GetBuildingLevelHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();


        return new PomeloResponse() {
            protected void write() throws IOException {
                GuildManagerHandler.GetBuildingLevelResponse.Builder res = GuildManagerHandler.GetBuildingLevelResponse.newBuilder();

                GuildBlessCenter blessManager = GuildBlessCenter.getInstance();
                GuildDepotCenter depotManager = GuildDepotCenter.getInstance();
                if (StringUtil.isNullOrEmpty(player.getId()) || null == blessManager || null == depotManager) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }
                GuildManagerHandler.BuildingLevel.Builder data = GuildManagerHandler.BuildingLevel.newBuilder();
                GuildMemberPO myInfo = GuildUtil.getGuildMember(player.getId());
                if (null != myInfo) {
                    GuildBless bless = blessManager.getBless(myInfo.guildId);
                    if (null != bless) {
                        data.setBlessLevel(bless.level);
                        data.setTechLevel(bless.tech.level);
                    }

                    GuildDepot depot = depotManager.getDepot(myInfo.guildId);
                    if (null != depot) {
                        data.setDepotLevel(depot.depotData.level);
                    }
                }

                res.setS2CCode(200);
                res.setS2CLevelInfo(data.build());
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


