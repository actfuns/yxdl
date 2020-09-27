package com.wanniu.game.five2Five;

import com.wanniu.game.team.TeamData;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class Five2FiveTeamApplyVo {
    public Date joinTime;
    public Map<String, TeamData.TeamMemberData> teamMembers;
    public String teamId;

    public Five2FiveTeamApplyVo(Map<String, TeamData.TeamMemberData> teamMembers, String teamId) {
        this.teamMembers = new HashMap<>();
        this.teamMembers.putAll(teamMembers);
        this.teamId = teamId;
    }
}


