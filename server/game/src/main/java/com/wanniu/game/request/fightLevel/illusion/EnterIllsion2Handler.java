package com.wanniu.game.request.fightLevel.illusion;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.area.AreaUtil;
import com.wanniu.game.common.msg.ErrorResponse;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.request.fightLevel.FightLevelLine;
import com.wanniu.game.team.TeamData;

import java.io.IOException;
import java.util.Map;

import pomelo.area.FightLevelHandler;


@GClientEvent("area.fightLevelHandler.enterLllsion2Request")
public class EnterIllsion2Handler
        extends FightLevelLine {
    public PomeloResponse request(final WNPlayer player) throws Exception {
        if (!isInOpenTime(player)) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("FIVE_2_FIVE_NOT_IN_TIME"));
        }

        Map<String, TeamData.TeamMemberData> members = player.getTeamManager().getTeamMembers();
        if (members != null && !members.isEmpty() &&
                !player.getTeamManager().isTeamLeader()) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("DUNGEON_GUILDBOSS_NOT_TEAM_LEADER"));
        }


        return new PomeloResponse() {
            protected void write() throws IOException {
                FightLevelHandler.EnterLllsion2Response.Builder res = FightLevelHandler.EnterLllsion2Response.newBuilder();

                AreaUtil.enterArea(player, 53001);

                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }


    public boolean isInOpenTime(WNPlayer player) {
        return (player.dailyActivityMgr.calIllusion2ScriptNum() == 2);
    }
}


