package com.wanniu.game.request.team;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.team.TeamData;
import com.wanniu.game.team.TeamService;

import java.io.IOException;

import pomelo.area.TeamHandler;


@GClientEvent("area.teamHandler.kickOutTeamRequest")
public class KickOutTeamHandler
        extends TeamRequestFilter {
    public PomeloResponse request(final WNPlayer player) throws Exception {
        TeamHandler.KickOutTeamRequest msg = TeamHandler.KickOutTeamRequest.parseFrom(this.pak.getRemaingBytes());
        final String playerId = msg.getC2SPlayerId();
        return new PomeloResponse() {
            protected void write() throws IOException {
                TeamHandler.KickOutTeamResponse.Builder res = TeamHandler.KickOutTeamResponse.newBuilder();
                TeamData team = player.getTeamManager().getTeam();
                TeamData.TeamMemberData teamLeader = player.getTeamManager().getTeamMember();
                if (team == null || teamLeader == null) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("TEAM_LEAVE"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (!teamLeader.isLeader) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("TEAM_NO_AUTHORITY"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                TeamData.TeamMemberData teamMember = team.getMember(playerId);
                if (teamMember == null) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("TEAM_OBJ_LEAVE_TEAM"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (!teamLeader.teamId.equals(teamMember.teamId)) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("TEAM_WE_NOT_ONE_TEAM"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }
                if (TeamService.kickOutTeam(team, teamMember)) {
                    PlayerUtil.sendSysMessageToPlayer(LangService.getValue("TEAM_KICK"), playerId, null);
                    PlayerUtil.sendSysMessageToPlayer(LangService.getValue("TEAM_TARGET_KICK").replace("{playerName}", (teamMember.getPlayerData()).name), player
                            .getId(), null);
                }
                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


