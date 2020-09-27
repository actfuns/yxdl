package com.wanniu.game.request.team;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.team.TeamUtil;

import java.io.IOException;

import pomelo.area.TeamHandler;


@GClientEvent("area.teamHandler.leaveTeamRequest")
public class LeaveTeamHandler
        extends TeamRequestFilter {
    protected PomeloResponse checkRemote(WNPlayer player) {
        return null;
    }


    public PomeloResponse request(final WNPlayer player) throws Exception {
        return new PomeloResponse() {
            protected void write() throws IOException {
                TeamHandler.LeaveTeamResponse.Builder res = TeamHandler.LeaveTeamResponse.newBuilder();
                boolean isInTeam = player.getTeamManager().isInTeam();
                if (isInTeam) {
                    TeamUtil.leaveTeamInAreaServer(player);
                    res.setS2CCode(200);
                } else {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("TEAM_LEAVE"));
                }
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


