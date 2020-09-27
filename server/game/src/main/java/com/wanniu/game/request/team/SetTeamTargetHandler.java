package com.wanniu.game.request.team;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.area.Area;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.msg.ErrorResponse;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.TeamTargetCO;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.team.TeamData;

import java.io.IOException;

import pomelo.area.TeamHandler;


@GClientEvent("area.teamHandler.setTeamTargetRequest")
public class SetTeamTargetHandler
        extends TeamRequestFilter {
    public PomeloResponse request(final WNPlayer player) throws Exception {
        TeamData.TeamMemberData selfTeamMember = player.getTeamManager().getTeamMember();
        if (selfTeamMember == null || !selfTeamMember.isLeader) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("TEAM_NO_AUTHORITY"));
        }
        Area area = player.getArea();
        if (area != null && !area.isNormal()) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("TEAM_LOCKED"));
        }
        TeamHandler.SetTeamTargetRequest msg = TeamHandler.SetTeamTargetRequest.parseFrom(this.pak.getRemaingBytes());
        final int targetId = msg.getC2STargetId();
        final int difficulty = msg.getC2SDifficulty();
        final int minLevel = msg.getC2SMinLevel();
        final int maxLevel = msg.getC2SMaxLevel();
        final int isAutoTeam = msg.getC2SIsAutoTeam();
        final int isAutoStart = msg.getC2SIsAutoStart();
        return new PomeloResponse() {
            protected void write() throws IOException {
                TeamHandler.SetTeamTargetResponse.Builder res = TeamHandler.SetTeamTargetResponse.newBuilder();
                TeamTargetCO targetProp = (TeamTargetCO) GameData.TeamTargets.get(Integer.valueOf(targetId));

                if (targetProp == null || (difficulty != 1 && difficulty != 2 && difficulty != 3) || minLevel < 0 || minLevel > GlobalConfig.Role_LevelLimit || (isAutoStart != 0 && isAutoStart != 1) || (isAutoTeam != 0 && isAutoTeam != 1)) {


                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("PARAM_ERROR"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }

                TeamData team = player.getTeamManager().getTeam();
                team.targetId = targetId;
                team.difficulty = difficulty;
                team.minLevel = minLevel;
                team.maxLevel = maxLevel;
                team.isAutoTeam = (isAutoTeam == 1);
                team.isAutoStart = (isAutoStart == 1);

                PlayerUtil.sendSysMessageToPlayer(LangService.getValue("TEAM_TARGET_SUCCESS"), player.getId(), Const.TipsType.BLACK);
                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());

                team.onTeamChange();
            }
        };
    }
}


