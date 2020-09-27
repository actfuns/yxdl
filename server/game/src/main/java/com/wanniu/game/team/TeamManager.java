package com.wanniu.game.team;

import com.google.protobuf.GeneratedMessage;
import com.wanniu.core.game.LangService;
import com.wanniu.core.logfs.Out;
import com.wanniu.game.common.Const;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.PlayerPO;
import com.wanniu.game.task.po.TaskPO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import pomelo.area.TeamHandler;


public class TeamManager {
    private WNPlayer player;
    private TeamData team;
    private TeamData.TeamMemberData teamMember;
    public boolean loginFlag;
    public int acrossTargetId;
    public int acrossDifficulty;

    public TeamManager() {
    }

    public TeamManager(WNPlayer player) {
        this.player = player;
        String teamId = (player.getPlayerTempData()).teamId;
        if (teamId != null) {
            TeamData team = TeamService.getTeam(teamId);
            setTeamData(team);
            checkLeader();
        }
    }

    public void quitAcrossMatch(boolean quit) {
        this.acrossTargetId = 0;
        this.player.teamMembers = null;
        if (this.team != null) {
            this.team.local = (quit || this.team.memberCount() <= 1);
        }
        TeamHandler.OnAcrossTeamInfoPush push = TeamHandler.OnAcrossTeamInfoPush.newBuilder().build();
        this.player.receive("area.teamPush.onAcrossTeamInfoPush", (GeneratedMessage) push);
    }


    public boolean isAcceptAutoTeam() {
        return ((this.player.getPlayer()).isAcceptAutoTeam == 1);
    }


    public boolean isAutoTeam() {
        return (this.team != null && this.team.isAutoTeam);
    }


    public int getIsAutoTeam() {
        if (this.team != null) {
            if (this.team.isAutoTeam) {
                return 1;
            }
            return 0;
        }

        return isAcceptAutoTeam() ? 1 : 0;
    }


    public void setIsAutoTeam(boolean auto) {
        if (this.team != null) {
            this.team.isAutoTeam = auto;
        }
    }


    public boolean onMessage(int msgType, int operate, String id) {
        Out.debug(new Object[]{Integer.valueOf(msgType), " team onEvent, ", id});
        String result = null;

        if (msgType == Const.MESSAGE_TYPE.team_invite.getValue()) {
            TeamData team = TeamService.getTeam(id);
            if (team == null) {
                this.player.sendSysTip(LangService.getValue("TEAM_NULL"));
                return true;
            }
            if (!team.invites.containsKey(this.player.getId())) {
                this.player.sendSysTip(LangService.getValue("EXPIRED_MSG"));
                return false;
            }
            team.invites.remove(this.player.getId());
            if (!team.isOpenJoin()) {
                this.player.sendSysTip(LangService.getValue("TEAM_BATTLE_ERR"));
                return false;
            }
            if (team.isFull()) {
                this.player.sendSysTip(LangService.getValue("TEAM_IS_FULL"));
                return false;
            }
            if (operate == Const.MESSAGE_OPERATE.TYPE_ACCEPT.getValue()) {
                boolean isInTeam = isInTeam();
                if (isInTeam) {
                    result = LangService.getValue("TEAM_EXISTS");
                } else {
                    String res = TeamUtil.canJoinTeam(this.player, team);
                    if (res == null) {
                        result = TeamService.joinTeam(team.id, this.player);
                    }
                }
                if (result == null) {
                    TeamData.TeamMemberData inviter = team.getLeader();
                    TeamUtil.sendSysMessageByPlayerEnter(inviter.teamId, this.player.getId());
                    return false;
                }
                this.player.sendSysTip(result);
                return true;
            }

            String s = LangService.format("TEAM_REFUSE", new Object[]{this.player.getName()});
            PlayerUtil.sendSysMessageToPlayer(s, team.leaderId, null);
        } else if (msgType == Const.MESSAGE_TYPE.team_apply.getValue()) {
            String applyId = id;
            if (this.team != null) {
                if (!this.team.applies.containsKey(applyId)) {
                    this.player.sendSysTip(LangService.getValue("EXPIRED_MSG"));
                    return false;
                }
                this.team.removeApply(applyId);
            }
            if (operate == Const.MESSAGE_OPERATE.TYPE_ACCEPT.getValue()) {
                if (TeamUtil.isInTeam(applyId)) {
                    this.player.sendSysTip(LangService.getValue("TEAM_TARGET_IN_TEAM"));
                    return false;
                }
                TeamData.TeamMemberData teamMember = this.team.getMember(this.player.getId());
                if (teamMember != null && teamMember.isLeader) {
                    result = TeamService.joinTeam(teamMember.teamId, PlayerUtil.getOnlinePlayer(applyId));
                }
                Out.debug(new Object[]{"join team result:", result});
                if (result == null) {
                    TeamUtil.sendSysMessageByPlayerEnter(teamMember.teamId, applyId);
                    return false;
                }
                String s = LangService.format("TEAM_REFUSE", new Object[]{this.player.getName()});
                PlayerUtil.sendSysMessageToPlayer(s, applyId, null);
                return true;
            }

            String res = LangService.getValue("TEAM_TARGET_REFUSE").replace("{playerName}", this.player.getName());
            PlayerUtil.sendSysMessageToPlayer(res, applyId, null);
        }

        return true;
    }

    public void pushTeamData() {
        String teamId = "";
        List<TeamHandler.TeamMember> teamMembers = new ArrayList<>();
        TeamHandler.OnTeamUpdatePush.Builder data = TeamHandler.OnTeamUpdatePush.newBuilder();
        TeamData team = this.team;
        if (team != null) {
            teamId = team.id;
            Map<String, TeamData.TeamMemberData> teamMembersData = getTeamMembers();
            for (TeamData.TeamMemberData teamMember : teamMembersData.values()) {
                if (!teamMember.id.equals(this.player.getId())) {
                    PlayerPO member = teamMember.getPlayerData();
                    TeamHandler.TeamMember.Builder tm = TeamHandler.TeamMember.newBuilder();
                    tm.setId(teamMember.id);
                    tm.setName(member.name);
                    tm.setPro(member.pro);
                    tm.setLevel(member.level);
                    tm.setIsLeader(teamMember.getLeader());
                    tm.setFollow(teamMember.getFollow());
                    if (teamMember.isOnline()) {
                        WNPlayer pm = teamMember.getPlayer();
                        tm.setAreaId(pm.getAreaId());
                        if (this.player.getInstanceId().equals(pm.getInstanceId())) {
                            tm.setStatus(Const.PlayerStatus.online.getValue());
                        } else {
                            tm.setStatus(Const.PlayerStatus.faraway.getValue());
                        }
                    } else {
                        tm.setStatus(Const.PlayerStatus.offline.getValue());
                    }

                    teamMembers.add(tm.build());
                    continue;
                }
                data.setFollow(teamMember.getFollow());
            }

            data.setS2CIsAcceptAutoTeam(team.isAutoTeam ? 1 : 0);
        }
        data.setS2CTeamId(teamId);
        data.addAllS2CData(teamMembers);
        this.player.receive("area.teamPush.onTeamUpdatePush", (GeneratedMessage) data.build());
    }

    private void checkLeader() {
        TeamData.TeamMemberData leader = (this.team == null) ? null : this.team.getLeader();
        if (this.teamMember != null && !this.teamMember.isLeader && (leader == null || !leader.isOnline())) {
            this.team.changeLeader();
        }
    }

    public void checkLogin() {
        if (this.loginFlag) {
            this.loginFlag = false;
            checkLeader();
            if (this.team != null) {
                TeamHandler.OnTeamTargetPush targetPush = TeamHandler.OnTeamTargetPush.newBuilder().setS2CTeamTarget(TeamUtil.generateTeamTargetData(this.team)).setHaveApply(this.team.applies.size()).setS2CIsAcceptAutoTeam(this.team.isAutoTeam ? 1 : 0).build();
                this.player.receive("area.teamPush.onTeamTargetPush", (GeneratedMessage) targetPush);
            }
        }
    }

    public void onPlayerUpgrade() {
        TeamService.refreshTeam(this.team, false);
    }


    public void onMemberChange(Collection<String> members) {
    }


    public void setTeamData(TeamData team) {
        if (this.team != team) {
            this.team = team;
            if (team == null) {
                this.teamMember = null;
            } else {
                this.teamMember = team.getMember(this.player.getId());
                if (this.teamMember == null) {
                    this.team = null;
                }
            }
        }
    }


    public boolean isInTeam() {
        return (this.teamMember != null);
    }


    public TeamData.TeamMemberData getTeamMember() {
        return this.teamMember;
    }


    public Map<String, TeamData.TeamMemberData> getTeamMembers() {
        if (this.team == null)
            return null;
        return this.team.teamMembers;
    }


    public TeamData getTeam() {
        return this.team;
    }


    public Map<Integer, TaskPO> getLoopTasks() {
        return (this.team != null) ? this.team.loopTasks : null;
    }


    public boolean isTeamLeader() {
        return (this.teamMember != null) ? this.teamMember.isLeader : false;
    }


    public boolean isFollowLeader() {
        return (this.teamMember != null) ? this.teamMember.follow : false;
    }


    public int followCount() {
        if (this.team != null) {
            return this.team.followCount();
        }
        return 1;
    }
}


