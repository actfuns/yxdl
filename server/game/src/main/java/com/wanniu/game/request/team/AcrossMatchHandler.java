package com.wanniu.game.request.team;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.common.msg.ErrorResponse;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.team.TeamData;
import com.wanniu.game.team.TeamUtil;

import java.io.IOException;

import pomelo.area.TeamHandler;


@GClientEvent("area.teamHandler.acrossMatchRequest")
public class AcrossMatchHandler
        extends TeamRequestFilter {
    public PomeloResponse request(WNPlayer player) throws Exception {
        TeamHandler.AcrossMatchRequest target = TeamHandler.AcrossMatchRequest.parseFrom(this.pak.getRemaingBytes());
        int targetId = target.getTargetId();
        int difficulty = target.getDifficulty();
        TeamData team = player.getTeamManager().getTeam();
        if (team != null) {
            if (!player.getTeamManager().isTeamLeader()) {
                return (PomeloResponse) new ErrorResponse(LangService.getValue("TEAM_NO_AUTHORITY"));
            }
            team.curTargetId = targetId;
            team.curDifficulty = difficulty;
        } else {
            (player.getTeamManager()).acrossTargetId = targetId;
            (player.getTeamManager()).acrossDifficulty = difficulty;
        }

        TeamUtil.pushAcrossMatch(player);

        return new PomeloResponse() {
            protected void write() throws IOException {
                TeamHandler.AcrossMatchResponse.Builder res = TeamHandler.AcrossMatchResponse.newBuilder();
                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


