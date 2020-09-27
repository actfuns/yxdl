package com.wanniu.game.request.team;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.logfs.Out;
import com.wanniu.game.common.msg.ErrorResponse;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.team.TeamData;
import com.wanniu.game.team.TeamService;

import java.io.IOException;

import pomelo.area.TeamHandler;


@GClientEvent("area.teamHandler.setAutoAcceptTeamRequest")
public class SetAutoAcceptTeamHandler
        extends TeamRequestFilter {
    public PomeloResponse request(final WNPlayer player) throws Exception {
        TeamHandler.SetAutoAcceptTeamRequest msg = TeamHandler.SetAutoAcceptTeamRequest.parseFrom(this.pak.getRemaingBytes());
        final int isAccept = msg.getC2SIsAccept();
        if (isAccept != 1 && isAccept != 0) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("SOMETHING_ERR"));
        }
        Out.debug(new Object[]{"isAccept:::", Integer.valueOf(isAccept)});
        return new PomeloResponse() {
            protected void write() throws IOException {
                TeamHandler.SetAutoAcceptTeamResponse.Builder res = TeamHandler.SetAutoAcceptTeamResponse.newBuilder();
                res.setS2CCode(200);
                TeamData.TeamMemberData teamLeader = player.getTeamManager().getTeamMember();
                if (teamLeader != null && teamLeader.isLeader) {
                    TeamData team = player.getTeamManager().getTeam();
                    if (team != null) {
                        team.setAutoTeam((isAccept == 1));
                    }
                    TeamService.refreshTeam(team, false);
                } else {
                    player.setIsAcceptAutoTeam(isAccept);
                }
                res.setS2CIsAcceptAutoTeam(player.getTeamManager().getIsAutoTeam());
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


