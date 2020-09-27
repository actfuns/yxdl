package com.wanniu.game.five2Five;

import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.team.TeamData;
import com.wanniu.game.team.TeamFilter;


public class Five2FiveTeamFilter
        implements TeamFilter {
    private int teamMaxNumber;
    private int targetId = GlobalConfig.Group_Team;

    public Five2FiveTeamFilter(int filterLogicServerId, int teamMaxNumber) {
        this.teamMaxNumber = teamMaxNumber;
    }


    public boolean filter(TeamData team) {
        return (team.isAutoTeam && team.targetId == this.targetId && team.memberCount() < this.teamMaxNumber);
    }
}


