package com.wanniu.game.request.team;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.area.Area;
import com.wanniu.game.guild.GuildUtil;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.PlayerPO;
import com.wanniu.game.team.TeamData;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import pomelo.area.TeamHandler;


@GClientEvent("area.teamHandler.getNearTeamsRequest")
public class GetNearTeamsHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        return new PomeloResponse() {
            protected void write() throws IOException {
                TeamHandler.GetNearTeamsResponse.Builder res = TeamHandler.GetNearTeamsResponse.newBuilder();
                Area area = player.getArea();
                Map<String, TeamData> teams = new HashMap<>();
                for (String playerId : area.actors.keySet()) {
                    WNPlayer near = PlayerUtil.getOnlinePlayer(playerId);
                    if (near == null) {
                        continue;
                    }
                    TeamData team = near.getTeamManager().getTeam();
                    if (team != null && team != player.getTeamManager().getTeam()) {
                        teams.put(team.id, team);
                    }
                }
                for (TeamData team : teams.values()) {
                    TeamHandler.NearTeam.Builder nearTeam = TeamHandler.NearTeam.newBuilder();
                    nearTeam.setTeamId(team.id);
                    PlayerPO leader = PlayerUtil.getPlayerBaseData(team.leaderId);
                    TeamHandler.NearTeamLeader.Builder ntLeader = TeamHandler.NearTeamLeader.newBuilder();
                    ntLeader.setName(leader.name);
                    ntLeader.setGuildName(GuildUtil.getGuildName(leader.id));
                    ntLeader.setLv(leader.level);
                    ntLeader.setPro(leader.pro);
                    nearTeam.setLeader(ntLeader);
                    for (TeamData.TeamMemberData teamMember : team.teamMembers.values()) {
                        TeamHandler.NearTeamMember.Builder ntMember = TeamHandler.NearTeamMember.newBuilder();
                        PlayerPO member = teamMember.getPlayerData();
                        ntMember.setPro(member.pro);
                        ntMember.setLv(member.level);
                        nearTeam.addMembers(ntMember);
                    }
                    nearTeam.setApply(team.applies.containsKey(player.getId()) ? 1 : 0);
                    res.addTeams(nearTeam);
                }
                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }

    public short getType() {
        return 773;
    }
}


