package com.wanniu.game.request.team;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.msg.ErrorResponse;
import com.wanniu.game.common.msg.MessageUtil;
import com.wanniu.game.message.MessageData;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.team.TeamData;
import com.wanniu.game.team.TeamService;
import com.wanniu.game.team.TeamUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import pomelo.area.TeamHandler;


@GClientEvent("area.teamHandler.joinTeamRequest")
public class JoinTeamHandler
        extends TeamRequestFilter {
    public PomeloResponse request(final WNPlayer player) throws Exception {
        if (TeamUtil.isInTeam(player.getId())) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("TEAM_ALREADY_IN_TEAM"));
        }

        TeamHandler.JoinTeamRequest msg = TeamHandler.JoinTeamRequest.parseFrom(this.pak.getRemaingBytes());
        final String teamId = msg.getC2STeamId();
        final TeamData team = TeamService.getTeam(teamId);
        if (teamId == null || team == null) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("TEAM_NULL"));
        }

        if (team.applies.containsKey(player.getId())) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("TEAM_ALREADY_INVITATION"));
        }

        String result = TeamUtil.canJoinTeam(player, team);
        if (result != null) {
            return (PomeloResponse) new ErrorResponse(result);
        }

        return new PomeloResponse() {
            protected void write() throws IOException {
                TeamHandler.JoinTeamResponse.Builder res = TeamHandler.JoinTeamResponse.newBuilder();

                Map<String, String> strMsg = new HashMap<>(1);
                strMsg.put("playerName", PlayerUtil.getFullColorName(player));
                MessageData.MessageData_Team_apply msgData = new MessageData.MessageData_Team_apply();
                msgData.applyId = player.getId();
                msgData.name = player.getName();
                msgData.teamId = teamId;
                MessageData message = MessageUtil.createMessage(Const.MESSAGE_TYPE.team_apply.getValue(), player.getId(), (MessageData.MessageData_Data) msgData, strMsg);
                message.id = player.getId();
                if (!player.getTeamManager().isInTeam()) {
                    team.addApply(player.getId(), message.validTime);
                    MessageUtil.sendMessageToPlayer(message, team.leaderId);
                    PlayerUtil.sendSysMessageToPlayer(LangService.getValue("TEAM_APPLY"), player.getId(), Const.TipsType.BLACK);
                }
                res.setS2CCode(200);

                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


