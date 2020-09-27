package com.wanniu.game.request.team;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.common.msg.ErrorResponse;
import com.wanniu.game.guild.GuildUtil;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.PlayerPO;
import com.wanniu.game.team.TeamData;

import java.io.IOException;

import pomelo.area.TeamHandler;


@GClientEvent("area.teamHandler.getAppliedPlayersRequest")
public class GetAppliedPlayersHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        WNPlayer player = (WNPlayer) this.pak.getPlayer();
        final TeamData team = player.getTeamManager().getTeam();
        if (team == null) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("TEAM_NULL"));
        }
        return new PomeloResponse() {
            protected void write() throws IOException {
                TeamHandler.GetAppliedPlayersResponse.Builder res = TeamHandler.GetAppliedPlayersResponse.newBuilder();
                for (String key : team.applies.keySet()) {
                    WNPlayer member = PlayerUtil.getOnlinePlayer(key);
                    if (member != null && !member.getTeamManager().isInTeam()) {
                        PlayerPO po = member.getPlayer();

                        TeamHandler.TeamMemberBasic.Builder data = TeamHandler.TeamMemberBasic.newBuilder();
                        data.setId(po.id);
                        data.setName(po.name);
                        data.setPro(po.pro);
                        data.setLevel(po.level);
                        data.setUpLevel(po.upLevel);
                        data.setGuildName(GuildUtil.getGuildName(po.id));

                        res.addS2CPlayers(data);
                        continue;
                    }
                    team.removeApply(key);
                }

                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }


    public short getType() {
        return 771;
    }
}


