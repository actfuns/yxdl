package com.wanniu.game.request.team;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.area.Area;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.msg.MessageUtil;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.team.TeamUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import pomelo.area.TeamHandler;


@GClientEvent("area.teamHandler.getNearbyPlayersRequest")
public class GetNearbyPlayersHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        return new PomeloResponse() {
            protected void write() throws IOException {
                TeamHandler.GetNearbyPlayersResponse.Builder res = TeamHandler.GetNearbyPlayersResponse.newBuilder();

                Area area = player.getArea();
                List<TeamHandler.Player> players = new ArrayList<>();
                List<String> playerIds = new ArrayList<>();
                for (String playerId : area.actors.keySet()) {
                    WNPlayer actor = PlayerUtil.findPlayer(playerId);
                    if (actor != null && actor.getLevel() >= GlobalConfig.Team_Min_Level &&
                            !actor.getTeamManager().isInTeam() && !playerId.equals(player.getId())) {
                        playerIds.add(playerId);
                    }
                }

                int count = playerIds.size();
                if (count > GlobalConfig.TeamViewMAX) {
                    count = GlobalConfig.TeamViewMAX;
                    Collections.shuffle(playerIds);
                }

                for (int i = 0; i < count; i++) {
                    String playerId = playerIds.get(i);
                    WNPlayer player = PlayerUtil.findPlayer(playerId);
                    TeamHandler.Player.Builder playerData = PlayerUtil.transToJson4TeamMemberSimple(player);
                    if (TeamUtil.isHasInvitedPlayer(player, playerId)) {
                        playerData.setIsInvited(1);
                    } else {
                        playerData.setIsInvited(0);
                    }
                    players.add(playerData.build());
                }

                res.setS2CCode(200);
                res.addAllS2CPlayers(players);
                res.setS2CMaxCount(MessageUtil.getSendLimit(Const.MESSAGE_TYPE.team_invite.getValue()));
                res.setS2CNowCount(player.messageManager.getSendedMessageLengthByType(Const.MESSAGE_TYPE.team_invite.getValue()));
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }


    public short getType() {
        return 772;
    }
}


