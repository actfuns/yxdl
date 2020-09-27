package com.wanniu.game.team;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.wanniu.core.game.JobFactory;
import com.wanniu.core.game.LangService;
import com.wanniu.core.logfs.Out;
import com.wanniu.game.GWorld;
import com.wanniu.game.area.Area;
import com.wanniu.game.area.AreaData;
import com.wanniu.game.area.AreaUtil;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.Utils;
import com.wanniu.game.guild.GuildUtil;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.player.WNRobot;
import com.wanniu.game.poes.PlayerPO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import pomelo.area.TeamHandler;


public class TeamService
        extends BaseTeamService {
    private static AtomicLong UUID = new AtomicLong(System.nanoTime());


    public static String createTeam(WNPlayer leader, List<String> memberIds, int logicServerId) {
        Out.debug(new Object[]{"teamService createTeam"});
        synchronized (lock) {
            boolean isInTeam = leader.getTeamManager().isInTeam();
            if (isInTeam) {
                return LangService.getValue("TEAM_ENTER");
            }

            if (memberIds != null) {
                for (String playerId : memberIds) {
                    boolean isIn = isInTeam(playerId);
                    if (isIn) {
                        return LangService.getValue("TEAM_ENTER");
                    }
                }
            }
            String teamId = String.valueOf(UUID.incrementAndGet());
            TeamData.TeamMemberData teamLeader = new TeamData.TeamMemberData(teamId, leader.getId());
            teamLeader.isLeader = true;
            TeamData team = new TeamData();
            team.id = teamId;
            team.leaderId = teamLeader.id;
            team.logicServerId = logicServerId;
            team.teamMembers = new ConcurrentHashMap<>();

            team.sceneType = leader.getSceneType();


            team.difficulty = 1;
            team.isAutoTeam = (GlobalConfig.TeamAutoInvite == 1);

            addTeam(team);

            team.teamMembers.put(teamLeader.id, teamLeader);
            addTeamMember(teamLeader);
            if (memberIds != null) {
                for (String playerId : memberIds) {
                    TeamData.TeamMemberData member = new TeamData.TeamMemberData(teamId, playerId);
                    team.teamMembers.put(member.id, member);
                    addTeamMember(member);
                }
            }
            refreshTeam(team);
        }
        return null;
    }

    public static void changeTeamArea(WNPlayer player) {
        TeamData team = player.getTeamManager().getTeam();
        if (team != null) {
            if (player.getId().equals(team.leaderId)) {
                team.sceneType = player.getSceneType();
            }
            player.teamManager.checkLogin();
            Area area = player.getArea();
            if (area.sceneType == Const.SCENE_TYPE.FIGHT_LEVEL.getValue() || area.sceneType == Const.SCENE_TYPE.LOOP.getValue() || area.sceneType == Const.SCENE_TYPE.GUILD_BOSS.getValue()) {
                if (player.getTeamManager().getTeamMember() != null) {
                    (player.getTeamManager().getTeamMember()).follow = false;
                }
                refreshTeam(team);
                area.onPlayerAutoBattle(player, true);
                Out.debug(new Object[]{"自动战斗请求:", player.getName(), " - " + player.getId(), " - ", area.prop.name});
            } else {
                refreshTeam(team);
            }
            if (area.isNormal()) {
                team.setFreeRobotTime();
            }
        } else {

            player.teamManager.pushTeamData();
        }
    }


    public static String joinTeam(String teamId, WNPlayer wPlayer) {
        if (wPlayer == null) {
            return LangService.getValue("PLAYER_NOT_ONLINE");
        }
        TeamData team = getTeam(teamId);
        synchronized (lock) {
            if (team == null) {
                return LangService.getValue("TEAM_BREAK_UP");
            }
            if (!team.isOpenJoin()) {
                return LangService.getValue("TEAM_LOCKED");
            }
            String res = TeamUtil.canJoinTeam(wPlayer, team);
            if (res != null) {
                return res;
            }
            TeamData.TeamMemberData member = wPlayer.getTeamManager().getTeamMember();
            if (member != null) {
                return LangService.getValue("TEAM_ALREADY_IN_TEAM");
            }

            member = new TeamData.TeamMemberData(teamId, wPlayer.getId());
            WNPlayer leader = team.getPlayer(team.leaderId);
            member.follow = (leader != null && leader.getInstanceId().equals(wPlayer.getInstanceId()));
            member.robot = wPlayer.isRobot();
            team.isRobotJoin |= member.robot;

            team.teamMembers.put(member.id, member);
            addTeamMember(member);
        }


        kickRobotMember(team);

        refreshTeam(team);

        TeamUtil.handleFullOfTeam(team, team.getPlayer(team.leaderId));
        return null;
    }

    public static void kickRobotMember(TeamData team) {
        if (team.memberCount() > 3) {
            for (Iterator<Map.Entry<String, TeamData.TeamMemberData>> iterator = team.teamMembers.entrySet().iterator(); iterator.hasNext(); ) {
                Map.Entry<String, TeamData.TeamMemberData> entry = iterator.next();
                if (((TeamData.TeamMemberData) entry.getValue()).robot) {
                    WNRobot robot = GWorld.getRobot(entry.getKey());
                    if (robot == null)
                        continue;
                    if (robot.quitTeamFuture != null)
                        continue;
                    robot.quitTeamFuture = JobFactory.addDelayJob(() -> {
                        robot.quitTeamFuture = null;
                        if (team.isOpenJoin()) {
                            leaveTeam((WNPlayer) robot);
                        }
                    }Utils.getSecMills(1, 15));
                    break;
                }
            }

        }
    }


    public static String leaveTeam(WNPlayer player) {
        String playerId = player.getId();
        TeamData team = player.getTeamManager().getTeam();
        synchronized (lock) {
            TeamData.TeamMemberData teamMember = player.getTeamManager().getTeamMember();
            if (teamMember != null) {
                team.teamMembers.remove(playerId);
                removeTeamMember(playerId);
                if (teamMember.isLeader && team.memberCount() > 0) {

                    team.changeLeader();
                    team.invites.clear();
                    team.applies.clear();
                }
            }
        }

        if (team != null) {
            if (team.memberCount() == 0) {
                destroyTeam(team);
            } else if (!destoryRobotTeam(team)) {
                refreshTeam(team);
            }
        }

        clearTeamData(playerId);

        return null;
    }

    public static boolean destoryRobotTeam(TeamData team) {
        for (TeamData.TeamMemberData member : team.teamMembers.values()) {
            if (!member.robot) {
                return false;
            }
        }
        destroyTeam(team);
        return true;
    }


    public static boolean kickOutTeam(TeamData team, TeamData.TeamMemberData teamMember) {
        if (teamMember != null && team != null) {
            String playerId = teamMember.id;
            WNPlayer player = PlayerUtil.getOnlinePlayer(playerId);
            synchronized (lock) {
                team.teamMembers.remove(playerId);
                if (player != null && player.getTeamManager().getTeamMember() != teamMember) {
                    return true;
                }
                removeTeamMember(playerId);
            }
            clearTeamData(playerId);
            refreshTeam(team);
            return true;
        }
        return false;
    }


    public static TeamHandler.Team.Builder generateTeamData(TeamData team) {
        TeamHandler.Team.Builder data = TeamHandler.Team.newBuilder();
        data.setId(team.id);
        data.setLeaderId(team.leaderId);

        List<TeamHandler.TeamMemberBasic> teamMemberBasics = new ArrayList<>();
        Map<String, TeamData.TeamMemberData> teamMembers = team.teamMembers;
        for (TeamData.TeamMemberData teamMember : teamMembers.values()) {
            TeamHandler.TeamMemberBasic.Builder memberBasic = TeamHandler.TeamMemberBasic.newBuilder();
            memberBasic.setId(teamMember.id);
            PlayerPO member = teamMember.getPlayerData();
            memberBasic.setPro(member.pro);
            memberBasic.setName(member.name);
            memberBasic.setLevel(member.level);
            memberBasic.setUpLevel(0);
            memberBasic.setGuildName(GuildUtil.getGuildName(teamMember.id));
            teamMemberBasics.add(memberBasic.build());
        }
        data.addAllTeamMembers(teamMemberBasics);
        data.setMinLevel(team.minLevel);
        data.setMaxLevel(team.maxLevel);
        return data;
    }


    public static List<TeamData> queryTeamByTarget(TeamFilter filter) {
        List<TeamData> result = new ArrayList<>();
        Collection<TeamData> teams = TeamMap.values();
        for (TeamData team : teams) {
            if (filter.filter(team)) {
                result.add(team);
            }
        }

        int maxViewCount = GlobalConfig.TeamViewMAX;
        if (result.size() > maxViewCount) {
            Collections.shuffle(result);
            return result.subList(0, maxViewCount);
        }

        return result;
    }


    public static String dissolveTeam(String playerId) {
        TeamData.TeamMemberData teamMember = getTeamMember(playerId);

        if (teamMember != null && teamMember.isLeader) {
            destroyTeam(teamMember.getTeam());
            return LangService.getValue("TEAM_NO_AUTHORITY");
        }
        return null;
    }

    public static void refreshTeam(TeamData team) {
        refreshTeam(team, true);
    }

    public static void refreshTeam(TeamData team, boolean notify) {
        if (team != null) {
            Set<String> teamMemberIds = team.teamMembers.keySet();
            for (String playerId : teamMemberIds) {
                updateTeamData(team, playerId, notify);
            }
        }
    }

    public static void clearTeamData(String playerId) {
        updateTeamData((TeamData) null, playerId, true);
    }

    public static void updateTeamData(TeamData team, String playerId, boolean notify) {
        Out.debug(new Object[]{"teamService sendTeam2TeamMembers:", playerId});
        WNPlayer player = PlayerUtil.getOnlinePlayer(playerId);
        if (player != null) {
            Map<String, TeamData.TeamMemberData> teamMembers = null;
            if (team == null) {
                player.pkRuleManager.onExitTeam();
            } else {
                teamMembers = team.teamMembers;
            }
            player.getTeamManager().setTeamData(team);
            List<String> teamMemberIds = new ArrayList<>();
            JSONArray members = new JSONArray();
            if (teamMembers != null) {
                team.isRobotJoin = false;
                for (TeamData.TeamMemberData teamMember : teamMembers.values()) {
                    team.isRobotJoin |= teamMember.robot;
                    if (!teamMember.id.equals(player.getId())) {
                        teamMemberIds.add(teamMember.id);
                    }
                    members.add(Utils.toJSON(new Object[]{"followLeader", Integer.valueOf(teamMember.getFollow()), "uuid", teamMember.id}));
                }
            }
            player.getTeamManager().pushTeamData();
            if (notify) {
                player.getTeamManager().onMemberChange(teamMemberIds);
                player.getXmdsManager().refreshPlayerTeamData(player.getId(), JSON.toJSONString(teamMemberIds));
                player.getXmdsManager().refreshTeamData(player.getId(), Utils.toJSONString(new Object[]{"leaderId", (team == null) ? "" : team.leaderId, "members", members}));
            }
        }
    }

    public static String followLeader(WNPlayer player, boolean follow) {
        if (player == null)
            return null;
        TeamData.TeamMemberData member = player.getTeamManager().getTeamMember();
        if (member != null && member.follow != follow) {
            TeamData team = player.getTeamManager().getTeam();
            if (follow) {
                WNPlayer leader = PlayerUtil.getOnlinePlayer(team.leaderId);
                if (leader != null && !leader.getInstanceId().equals(player.getInstanceId())) {
                    Area area = leader.getArea();
                    if (area.prop.reqLevel > player.getLevel()) {
                        return LangService.format("TEAM_AREA_FOLLOW_LV", new Object[]{Integer.valueOf(area.prop.reqLevel)});
                    }
                    AreaUtil.changeArea(member.getPlayer(), new AreaData(area.areaId, area.instanceId));
                }
            }
            member.follow = follow;
            refreshTeam(team);
        }
        return null;
    }

    public static void addAutoMatch(WNPlayer player, int targetId, int difficulty) {
        String playerId = player.getId();
        BaseTeamService.MatchData match = AutoMathes.get(playerId);
        if (match != null) {
            removeAutoMatch(playerId);
            if (match.targetId == targetId && match.difficulty == difficulty) {
                return;
            }
            match.targetId = targetId;
            match.difficulty = difficulty;
        } else {
            int logicServerId = player.getLogicServerId();
            match = AutoMathes.getTargetMatch(GWorld.__SERVER_ID, targetId, difficulty);
            if (match != null) {
                if (!matchTeam(match)) {
                    WNPlayer leader = match.player;
                    createTeam(leader, Arrays.asList(new String[]{player.getId()}, ), logicServerId);
                    TeamData team = leader.getTeamManager().getTeam();
                    if (team != null) {
                        Out.debug(new Object[]{"auto match player : ", leader.getId()});
                        team.isAutoTeam = true;
                    } else {
                        Out.error(new Object[]{"auto match player : ", leader.getId()});
                    }
                }
                return;
            }
            match = new BaseTeamService.MatchData(player, targetId, difficulty);
        }
        AutoMathes.put(playerId, match);
    }

    public static void removeAutoMatch(String playerId) {
        AutoMathes.remove(playerId);
    }

    public static boolean isAutoMatch(String playerId) {
        return AutoMathes.containsKey(playerId);
    }

    public static void onLogout(WNPlayer player) {
        TeamUtil.removeAcrossMatch(player);
        removeAutoMatch(player.getId());
        TeamData team = player.getTeamManager().getTeam();
        if (team != null) {
            (player.getPlayerTempData()).teamId = team.id;
            if (player.getTeamManager().isTeamLeader() && team.memberCount() > 1) {
                team.changeLeader();
            }
            refreshTeam(team);
        } else {
            for (TeamData teamData : TeamMap.values()) {
                teamData.removeApply(player.getId());
            }
            (player.getPlayerTempData()).teamId = null;
        }
    }
}


