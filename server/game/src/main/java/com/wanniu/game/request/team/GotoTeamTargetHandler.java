package com.wanniu.game.request.team;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.area.Area;
import com.wanniu.game.common.msg.ErrorResponse;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.team.TeamData;
import com.wanniu.game.team.TeamUtil;

import java.io.IOException;

import pomelo.area.TeamHandler;


@GClientEvent("area.teamHandler.gotoTeamTargetRequest")
public class GotoTeamTargetHandler
        extends TeamRequestFilter {
    public PomeloResponse request(WNPlayer player) throws Exception {
        TeamHandler.GotoTeamTargetRequest target = TeamHandler.GotoTeamTargetRequest.parseFrom(this.pak.getRemaingBytes());
        int targetId = target.getTargetId();
        int difficulty = target.getDifficulty();
        TeamData team = player.getTeamManager().getTeam();
        if (team == null) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("TEAM_MEMBER_COUNT"));
        }
        if (!player.getTeamManager().isTeamLeader()) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("TEAM_NO_AUTHORITY"));
        }
        if (!team.isAllOnline()) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("TEAM_PLAYER_OFF_LINE"));
        }
        team.curTargetId = targetId;
        team.curDifficulty = difficulty;
        int mapId = team.getTargetMap();
        if (mapId == 0) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("TEAM_NOTARGET_GO"));
        }

        Area area = TeamUtil.goToTeamTarget(team, player);
        if (area == null) {
            return (PomeloResponse) new ErrorResponse("");
        }

        return new PomeloResponse() {
            protected void write() throws IOException {
                TeamHandler.GotoTeamTargetResponse.Builder res = TeamHandler.GotoTeamTargetResponse.newBuilder();
                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


