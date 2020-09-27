package com.wanniu.game.request.team;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.msg.ErrorResponse;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.team.TeamUtil;

import java.io.IOException;

import pomelo.area.TeamHandler;


@GClientEvent("area.teamHandler.createTeamRequest")
public class CreateTeamHandler
        extends TeamRequestFilter {
    public PomeloResponse request(final WNPlayer player) throws Exception {
        if (!TeamUtil.isValidOfMap(player.getSceneType())) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("TEAM_IN_RAID"));
        }
        if (player.getTeamManager().isInTeam()) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("TEAM_ALREADY_IN_TEAM"));
        }

        return new PomeloResponse() {
            protected void write() throws IOException {
                TeamHandler.CreateTeamResponse.Builder res = TeamHandler.CreateTeamResponse.newBuilder();

                String result = null;
                if (player.getSceneType() == Const.SCENE_TYPE.CROSS_SERVER.getValue()) {
                    result = TeamUtil.createAcrossTeam(player.getId(), null);
                } else {
                    result = TeamUtil.createLocaleTeam(player.getId(), null);
                }

                if (result == null) {
                    res.setS2CCode(200);
                } else {
                    res.setS2CCode(500);
                    res.setS2CMsg(result);
                }
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


