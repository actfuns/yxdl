package com.wanniu.game.request.team;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.area.Area;
import com.wanniu.game.area.AreaUtil;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.msg.ErrorResponse;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.team.TeamData;
import com.wanniu.game.team.TeamService;

import java.io.IOException;

import pomelo.area.TeamHandler;


@GClientEvent("area.teamHandler.summonConfirmRequest")
public class SummonConfirmHandler
        extends TeamRequestFilter {
    public PomeloResponse request(final WNPlayer player) throws Exception {
        TeamHandler.SummonConfirmRequest msg = TeamHandler.SummonConfirmRequest.parseFrom(this.pak.getRemaingBytes());

        final int operate = msg.getS2COperate();
        if (operate != 1 && operate != 0) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("DATA_ERR"));
        }

        String messageId = msg.getC2SId();
        TeamData.TeamMemberData selfTeamMember = player.getTeamManager().getTeamMember();
        if (selfTeamMember == null || selfTeamMember.isLeader || !selfTeamMember.teamId.equals(messageId)) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("EXPIRED_MSG"));
        }

        return new PomeloResponse() {
            protected void write() throws IOException {
                TeamHandler.SummonConfirmResponse.Builder res = TeamHandler.SummonConfirmResponse.newBuilder();

                TeamData team = player.getTeamManager().getTeam();
                String summonResultStr = "";
                if (operate == 0) {
                    summonResultStr = LangService.getValue("TEAM_SUMMON_FAIL").replace("{playerName}", player.getName());
                } else {
                    if (team == null || !team.isOpenFollow()) {
                        res.setS2CCode(500);
                        res.setS2CMsg(LangService.getValue("TEAM_LOCKED"));
                        this.body.writeBytes(res.build().toByteArray());
                        return;
                    }
                    WNPlayer leader = PlayerUtil.getOnlinePlayer(team.leaderId);
                    Area area = leader.getArea();
                    String result = AreaUtil.canEnterArea(area.prop, player);
                    if (result == null) {
                        result = TeamService.followLeader(player, true);
                    }
                    if (result != null) {
                        res.setS2CCode(500);
                        res.setS2CMsg(result);
                        this.body.writeBytes(res.build().toByteArray());


                        return;
                    }


                    summonResultStr = LangService.getValue("TEAM_SUMMON_SUCCESS").replace("{playerName}", player.getName());
                }

                PlayerUtil.sendSysMessageToPlayer(summonResultStr, team.leaderId, Const.TipsType.BLACK);
                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


