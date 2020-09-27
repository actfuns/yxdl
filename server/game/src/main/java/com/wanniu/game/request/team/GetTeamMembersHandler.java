package com.wanniu.game.request.team;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.logfs.Out;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.team.TeamData;
import com.wanniu.game.team.TeamUtil;

import java.io.IOException;

import pomelo.area.TeamHandler;


@GClientEvent("area.teamHandler.getTeamMembersRequest")
public class GetTeamMembersHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        return new PomeloResponse() {
            protected void write() throws IOException {
                TeamHandler.GetTeamMembersResponse.Builder res = TeamHandler.GetTeamMembersResponse.newBuilder();
                TeamData.TeamMemberData teamMember = player.getTeamManager().getTeamMember();
                int isAutoTeam = player.getTeamManager().getIsAutoTeam();
                res.setS2CCode(200);
                res.setS2CIsAcceptAutoTeam(isAutoTeam);
                if (teamMember != null) {
                    TeamData team = player.getTeamManager().getTeam();
                    res.setS2CTeamTarget(TeamUtil.generateTeamTargetData(team));
                    res.addAllS2CTeamMembers(TeamUtil.generateTeamMemberDetailData(player, team));
                    res.setS2CIsAcceptAutoTeam(team.isAutoTeam ? 1 : 0);
                    res.setFollow(teamMember.getFollow());
                    res.setHaveApply(team.applies.size());
                } else {
                    Out.warn(new Object[]{this.val$player.getName(), " not in team request!"});
                }
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }

    public short getType() {
        return 775;
    }
}


