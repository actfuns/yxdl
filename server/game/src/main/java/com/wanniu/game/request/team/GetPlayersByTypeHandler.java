package com.wanniu.game.request.team;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.logfs.Out;
import com.wanniu.game.area.Area;
import com.wanniu.game.common.msg.ErrorResponse;
import com.wanniu.game.daoyou.DaoYouService;
import com.wanniu.game.guild.GuildUtil;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.team.TeamUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import pomelo.area.TeamHandler;


@GClientEvent("area.teamHandler.getPlayersByTypeRequest")
public class GetPlayersByTypeHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        TeamHandler.GetPlayersByTypeRequest msg = TeamHandler.GetPlayersByTypeRequest.parseFrom(this.pak.getRemaingBytes());
        final int c2s_type = msg.getC2SType();
        Out.debug(new Object[]{"getPlayersByTypeRequest c2s_type::", Integer.valueOf(c2s_type)});

        if (c2s_type < 1 || c2s_type > 4) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("PARAM_ERROR"));
        }

        return new PomeloResponse() {
            protected void write() throws IOException {
                TeamHandler.GetPlayersByTypeResponse.Builder res = TeamHandler.GetPlayersByTypeResponse.newBuilder();

                Collection<String> playerIds = null;

                if (c2s_type == 1) {
                    playerIds = player.getFriendManager().getAllFriendId();
                } else if (c2s_type == 2) {
                    playerIds = DaoYouService.getInstance().getDaoYouMemPlayerId(player.getId());
                } else if (c2s_type == 3) {
                    playerIds = GuildUtil.getGuildMemberIdList(player.guildManager.getGuildId());
                } else {
                    Area area = player.getArea();
                    playerIds = area.actors.keySet();
                }

                if (playerIds == null) {
                    playerIds = new ArrayList<>(0);
                }

                List<String> finalPlayerIds = new ArrayList<>(playerIds.size());
                for (String rid : playerIds) {
                    if (!TeamUtil.isInTeam(rid) && PlayerUtil.isOnline(rid) && !player.getId().equals(rid)) {
                        finalPlayerIds.add(rid);
                    }
                }

                int maxViewCount = GlobalConfig.TeamViewMAX;
                if (finalPlayerIds.size() > maxViewCount) {
                    Collections.shuffle(finalPlayerIds);
                } else {
                    maxViewCount = finalPlayerIds.size();
                }

                for (int i = 0; i < maxViewCount; i++) {
                    String playerId = finalPlayerIds.get(i);
                    TeamHandler.Player.Builder playerTeamData = PlayerUtil.transToJson4TeamMemberSimple(PlayerUtil.findPlayer(playerId));
                    if (TeamUtil.isHasInvitedPlayer(player, playerId)) {
                        playerTeamData.setIsInvited(1);
                    } else {
                        playerTeamData.setIsInvited(0);
                    }
                    res.addS2CPlayers(playerTeamData.build());
                }

                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }

    public short getType() {
        return 774;
    }
}


