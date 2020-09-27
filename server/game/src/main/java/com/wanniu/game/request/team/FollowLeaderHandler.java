package com.wanniu.game.request.team;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.logfs.Out;
import com.wanniu.game.common.msg.ErrorResponse;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.team.TeamData;
import com.wanniu.game.team.TeamService;

import java.io.IOException;

import pomelo.area.TeamHandler;


@GClientEvent("area.teamHandler.followLeaderRequest")
public class FollowLeaderHandler
        extends TeamRequestFilter {
    public PomeloResponse request() throws Exception {
        return request((WNPlayer) this.pak.getPlayer());
    }


    public PomeloResponse request(WNPlayer player) throws Exception {
        TeamHandler.FollowLeaderRequest req = TeamHandler.FollowLeaderRequest.parseFrom(this.pak.getRemaingBytes());
        boolean follow = (req.getFollow() == 1);
        TeamData.TeamMemberData teamMember = player.getTeamManager().getTeamMember();
        if (teamMember != null && follow) {
            TeamData team = player.getTeamManager().getTeam();
            if (team == null || team.islock()) {
                return (PomeloResponse) new ErrorResponse(LangService.getValue("TEAM_LOCKED"));
            }
            WNPlayer leander = PlayerUtil.getOnlinePlayer(team.leaderId);
            if (!player.getInstanceId().equals(leander.getInstanceId()) && !leander.getArea().isOpenJoinTeam()) {
                return (PomeloResponse) new ErrorResponse(LangService.getValue("TEAM_BATTLE_FOLLOW"));
            }
        }
        Out.debug(new Object[]{"team follow : ", Boolean.valueOf(follow)});
        String res = TeamService.followLeader(player, follow);
        if (res != null) {
            return (PomeloResponse) new ErrorResponse(res);
        }
        return new PomeloResponse() {
            protected void write() throws IOException {
                TeamHandler.FollowLeaderResponse.Builder res = TeamHandler.FollowLeaderResponse.newBuilder();
                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


