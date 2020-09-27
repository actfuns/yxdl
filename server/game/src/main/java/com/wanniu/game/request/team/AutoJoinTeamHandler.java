package com.wanniu.game.request.team;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.common.msg.ErrorResponse;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.TeamTargetCO;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.team.TeamService;

import java.io.IOException;

import pomelo.area.TeamHandler;


@GClientEvent("area.teamHandler.autoJoinTeamRequest")
public class AutoJoinTeamHandler
        extends TeamRequestFilter {
    public PomeloResponse request(final WNPlayer player) throws Exception {
        TeamHandler.AutoJoinTeamRequest msg = TeamHandler.AutoJoinTeamRequest.parseFrom(this.pak.getRemaingBytes());

        final int targetId = msg.getC2STargetId();

        if (targetId == 0) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("TEAM_TARGET_ERROR"));
        }

        if (player.getTeamManager().isInTeam()) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("TEAM_ALREADY_IN_TEAM"));
        }

        final int difficulty = msg.getC2SDifficulty();
        TeamTargetCO targetProp = (TeamTargetCO) GameData.TeamTargets.get(Integer.valueOf(targetId));

        if (targetProp == null || (difficulty != 1 && difficulty != 2 && difficulty != 3)) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("PARAM_ERROR"));
        }

        return new PomeloResponse() {
            protected void write() throws IOException {
                TeamHandler.AutoJoinTeamResponse.Builder res = TeamHandler.AutoJoinTeamResponse.newBuilder();

                TeamService.addAutoMatch(player, targetId, difficulty);

                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


