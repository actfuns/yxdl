package com.wanniu.game.request.player;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.common.msg.ErrorResponse;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.team.TeamData;


public abstract class ChangeAreaFilter
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        WNPlayer player = (WNPlayer) this.pak.getPlayer();
        if (player.inPvP()) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("MAP_IN_FIGHT"));
        }

        TeamData.TeamMemberData teamMember = player.getTeamManager().getTeamMember();
        if (teamMember != null && !teamMember.isLeader && teamMember.follow) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("TEAM_FOLLOW_CHANGE_AREA"));
        }

        return request(player);
    }


    public abstract PomeloResponse request(WNPlayer paramWNPlayer) throws Exception;

    public short getType() {
        return 1281;
    }
}


