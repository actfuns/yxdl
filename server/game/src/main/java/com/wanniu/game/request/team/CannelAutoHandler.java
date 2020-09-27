package com.wanniu.game.request.team;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.common.msg.ErrorResponse;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.team.TeamData;
import com.wanniu.game.team.TeamService;

import java.io.IOException;

import pomelo.area.TeamHandler;


@GClientEvent("area.teamHandler.cancelAutoRequest")
public class CannelAutoHandler
        extends TeamRequestFilter {
    public PomeloResponse request(WNPlayer player) throws Exception {
        TeamData team = player.getTeamManager().getTeam();
        if (team != null && !player.getTeamManager().isTeamLeader()) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("TEAM_NO_AUTHORITY"));
        }

        TeamService.removeAutoMatch(player.getId());

        return new PomeloResponse() {
            protected void write() throws IOException {
                TeamHandler.CancelAutoResponse.Builder res = TeamHandler.CancelAutoResponse.newBuilder();
                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


