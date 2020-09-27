package com.wanniu.game.request.team;

import com.google.protobuf.GeneratedMessage;
import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.tcp.protocol.Message;
import com.wanniu.core.util.StringUtil;
import com.wanniu.game.area.Area;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.msg.ErrorResponse;
import com.wanniu.game.common.msg.MessagePush;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.team.TeamData;

import java.io.IOException;

import pomelo.area.TeamHandler;


@GClientEvent("area.teamHandler.summonRequest")
public class SummonHandler
        extends TeamRequestFilter {
    public PomeloResponse request(WNPlayer player) throws Exception {
        TeamData team = player.getTeamManager().getTeam();
        if (team == null) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("TEAM_NO_AUTHORITY"));
        }

        TeamHandler.SummonRequest msg = TeamHandler.SummonRequest.parseFrom(this.pak.getRemaingBytes());
        String targetId = msg.getC2STeamMemberId();

        Area area = player.getArea();
        String content = LangService.getValue("TEAM_SUMMON_MESSAGE").replace("{1}", area.getSceneName()).replace("{2}", String.valueOf(area.lineIndex));
        TeamHandler.OnSummonTeamPush.Builder data = TeamHandler.OnSummonTeamPush.newBuilder();
        data.setS2CId(team.id);
        data.setS2CContent(content);
        String targetNmae = null;
        MessagePush push = new MessagePush("area.teamPush.onSummonTeamPush", (GeneratedMessage) data.build());
        if (StringUtil.isNotEmpty(targetId)) {
            if (!PlayerUtil.isOnline(targetId)) {
                return (PomeloResponse) new ErrorResponse(LangService.getValue("PLAYER_NOT_ONLINE"));
            }
            WNPlayer other = PlayerUtil.getOnlinePlayer(targetId);
            if (!other.getArea().isNormal()) {
                return (PomeloResponse) new ErrorResponse(LangService.getValue("TEAM_TARGET_IN_RAID"));
            }
            TeamData.TeamMemberData selfTeamMember = player.getTeamManager().getTeamMember();
            TeamData.TeamMemberData targetTeamMember = other.getTeamManager().getTeamMember();

            if (selfTeamMember == null || !selfTeamMember.isLeader || targetTeamMember == null ||
                    !selfTeamMember.teamId.equals(targetTeamMember.teamId)) {
                return (PomeloResponse) new ErrorResponse(LangService.getValue("TEAM_SUMMON_NOT_LEADER"));
            }

            if (player.getInstanceId().equals(other.getInstanceId()) && targetTeamMember.follow) {
                return (PomeloResponse) new ErrorResponse(LangService.getValue("TEAM_SUMMON_FAIL_TARGET_INSTANCE"));
            }
            other.receive((Message) push);
            targetNmae = other.getName();
        } else {
            targetNmae = LangService.getValue("TEAM_MEMBER");
            for (TeamData.TeamMemberData member : team.teamMembers.values()) {
                if (!member.follow && !member.isLeader) {
                    WNPlayer mPlayer = member.getPlayer();
                    if (mPlayer != null) {
                        mPlayer.receive((Message) push);
                    }
                }
            }
        }

        PlayerUtil.sendSysMessageToPlayer(LangService.format("TEAM_SUMMON_SEND_MESSAGE", new Object[]{targetNmae}), player.getId(), Const.TipsType.BLACK);

        return new PomeloResponse() {
            protected void write() throws IOException {
                TeamHandler.SummonResponse.Builder res = TeamHandler.SummonResponse.newBuilder();

                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


