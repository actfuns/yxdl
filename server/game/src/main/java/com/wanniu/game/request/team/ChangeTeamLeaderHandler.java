package com.wanniu.game.request.team;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.util.StringUtil;
import com.wanniu.game.common.msg.ErrorResponse;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.team.TeamData;
import com.wanniu.game.team.TeamService;
import com.wanniu.game.team.TeamUtil;

import java.io.IOException;

import pomelo.area.TeamHandler;


@GClientEvent("area.teamHandler.changeTeamLeaderRequest")
public class ChangeTeamLeaderHandler
        extends TeamRequestFilter {
    public PomeloResponse request(final WNPlayer player) throws Exception {
        TeamHandler.ChangeTeamLeaderRequest msg = TeamHandler.ChangeTeamLeaderRequest.parseFrom(this.pak.getRemaingBytes());
        String playerId = msg.getC2SPlayerId();
        if (StringUtil.isEmpty(playerId)) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("DATA_ERR"));
        }
        if (!PlayerUtil.isOnline(playerId)) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("TEAM_OFF_LINE"));
        }
        final TeamData.TeamMemberData teamLeader = player.getTeamManager().getTeamMember();
        if (teamLeader == null) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("TEAM_LEAVE"));
        }
        if (!teamLeader.isLeader) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("TEAM_NO_AUTHORITY"));
        }
        final TeamData team = player.getTeamManager().getTeam();
        final TeamData.TeamMemberData teamMember = team.getMember(playerId);
        if (teamMember == null) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("TEAM_OBJ_LEAVE_TEAM"));
        }
        if (!teamLeader.teamId.equals(teamMember.teamId)) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("TEAM_WE_NOT_ONE_TEAM"));
        }

        return new PomeloResponse() {
            protected void write() throws IOException {
                TeamHandler.ChangeTeamLeaderResponse.Builder res = TeamHandler.ChangeTeamLeaderResponse.newBuilder();

                teamLeader.isLeader = false;
                teamMember.isLeader = true;
                team.leaderId = teamMember.id;

                TeamService.refreshTeam(team);
                TeamUtil.sendSysMessageByLeaderChanged(teamLeader.teamId, player.getName());

                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


