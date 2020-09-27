package com.wanniu.game.team;

import com.wanniu.core.game.JobFactory;
import com.wanniu.core.logfs.Out;
import com.wanniu.game.GWorld;
import com.wanniu.game.area.Area;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.Utils;
import com.wanniu.game.common.msg.MessageUtil;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.ext.TeamTargetExt;
import com.wanniu.game.five2Five.Five2FiveService;
import com.wanniu.game.message.MessageData;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.player.WNRobot;
import com.wanniu.game.player.po.AllBlobPO;
import com.wanniu.game.task.TaskData;
import com.wanniu.game.task.po.TaskPO;
import com.wanniu.game.util.RobotUtil;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class BaseTeamService {
    protected static final MatchMap AutoMathes = new MatchMap();

    protected static final Map<String, TeamData> TeamMap = new ConcurrentHashMap<>();

    protected static final Map<String, TeamData.TeamMemberData> TeamMemberMap = new ConcurrentHashMap<>();

    static class MatchMap
            extends ConcurrentHashMap<String, MatchData> {
        private static final long serialVersionUID = 1L;
        private Map<String, BaseTeamService.MatchData> targets = new ConcurrentHashMap<>();


        public BaseTeamService.MatchData put(String key, BaseTeamService.MatchData value) {
            this.targets.put(value.getKey(), value);
            return super.put(key, value);
        }


        public BaseTeamService.MatchData remove(Object key) {
            BaseTeamService.MatchData match = super.remove(key);
            if (match != null) {
                this.targets.remove(match.getKey());
            }
            return match;
        }

        public BaseTeamService.MatchData getTargetMatch(int logicServerId, int targetId, int difficulty) {
            return this.targets.get(BaseTeamService.getTargetKey(logicServerId, targetId, difficulty));
        }

        public void clear() {
            super.clear();
            this.targets.clear();
        }
    }


    static class MatchData {
        WNPlayer player;

        int targetId;
        int difficulty;

        MatchData(WNPlayer player, int targetId, int difficulty) {
            this.player = player;
            this.targetId = targetId;
            this.difficulty = difficulty;
        }

        String getKey() {
            return BaseTeamService.getTargetKey(GWorld.__SERVER_ID, this.targetId, this.difficulty);
        }
    }

    private static String getTargetKey(int logicServerId, int targetId, int difficulty) {
        return logicServerId + ":" + targetId + ":" + difficulty;
    }

    static {
        long minute = 300000L;
        JobFactory.addScheduleJob(new Runnable() {
            public void run() {
                BaseTeamService.clearExpiredTeam();
            }
        }, minute, minute);
        long second = 3000L;
        JobFactory.addScheduleJob(new Runnable() {
            public void run() {
                if (BaseTeamService.AutoMathes.isEmpty())
                    return;
                Out.debug(new Object[]{"auto match team..."}, );
                for (Map.Entry<String, BaseTeamService.MatchData> entry : BaseTeamService.AutoMathes.entrySet()) {
                    BaseTeamService.matchTeam(entry.getValue());
                }
            }
        }, second, second);

        second = 1000L;
        JobFactory.addScheduleJob(new Runnable() {
            public void run() {
                GWorld.APP_TIME = System.currentTimeMillis();
                for (TeamData team : BaseTeamService.TeamMap.values()) {
                    if (!team.isOpenJoin())
                        continue;
                    if (team.isRobotJoin) {
                        if (team.isRobotLeader) {
                            team.changeLeader();
                        }
                        if (GWorld.APP_TIME > team.robotFreeTime && team.canRobotLeave()) {
                            try {
                                for (TeamData.TeamMemberData member : team.teamMembers.values()) {
                                    if (!member.robot)
                                        continue;
                                    WNRobot robot = (WNRobot) member.getPlayer();
                                    if (robot != null && robot.quitTeamFuture == null) {
                                        robot.quitTeamFuture = JobFactory.addDelayJob(() -> {
                                            robot.quitTeamFuture = null;
                                            TeamService.leaveTeam((WNPlayer) robot);
                                        }Utils.getSecMills(1, 10));
                                    }
                                }
                            } catch (Exception e) {
                                Out.error(new Object[]{e});
                            }
                            team.setFreeRobotTime();
                        }
                    }

                    TeamTargetExt teamTargetProp = (TeamTargetExt) GameData.TeamTargets.get(Integer.valueOf(team.targetId));
                    if (teamTargetProp == null) {
                        continue;
                    }

                    if (teamTargetProp.isRobot == 0) {
                        continue;
                    }

                    if (team.isAutoTeam && GWorld.APP_TIME > team.robotJoinTime && team.memberCount() < 3) {
                        try {
                            WNPlayer leader = team.getPlayer(team.leaderId);
                            if (GWorld.ROBOTS && leader != null) {
                                Area area = leader.getArea();
                                if (area.isFull())
                                    continue;
                                AllBlobPO allBlob = RobotUtil.matchRobot(leader, Math.max(area.prop.reqLevel, team.minLevel));
                                if (allBlob == null) {
                                    continue;
                                }

                                allBlob.robotAttr = teamTargetProp.randomAttrs();
                                WNRobot robot = new WNRobot(allBlob);
                                try {
                                    RobotUtil.newRobot(robot);
                                    leader.getArea().addPlayer((WNPlayer) robot);

                                    String result = TeamService.joinTeam(team.id, (WNPlayer) robot);
                                    if (result != null) {
                                        Out.warn(new Object[]{"机器人入队，不正常。", result});

                                        robot.free();
                                    }
                                } catch (Exception e) {
                                    Out.error(new Object[]{"创建机器人，进入场景失败", e});
                                    robot.free();
                                }
                            }
                        } catch (Exception e) {
                            Out.error(new Object[]{e});
                        }
                    }
                }
            }
        }second, second);


        clearExpiredMessage();
    }

    protected static Object lock = new Object();

    protected static boolean matchTeam(MatchData match) {
        WNPlayer player = match.player;
        for (TeamData team : TeamMap.values()) {
            if (team.isAutoTeam && team.local && team.targetId == match.targetId && team.difficulty == match.difficulty && team.memberCount() < GlobalConfig.NormalTeamMaxNum &&
                    team.minLevel <= player.getLevel() && (team.maxLevel == 0 || player.getLevel() <= team.maxLevel)) {
                TeamService.joinTeam(team.id, player);
                return true;
            }
        }

        return false;
    }

    public static void reload() {
        AutoMathes.clear();
        TeamMap.clear();
        TeamMemberMap.clear();
    }

    public static void clearExpiredMessage() {
        long now = GWorld.APP_TIME;
        long minValidtime = now + 60000L;
        for (TeamData team : TeamMap.values()) {
            for (Map.Entry<String, Long> entry : team.invites.entrySet()) {
                if (now > ((Long) entry.getValue()).longValue()) {
                    team.invites.remove(entry.getKey());
                    Out.debug(new Object[]{"remove team invite key : ", entry.getKey()});
                    continue;
                }
                minValidtime = Math.min(minValidtime, ((Long) entry.getValue()).longValue());
            }

            for (Map.Entry<String, Long> entry : team.applies.entrySet()) {
                if (now > ((Long) entry.getValue()).longValue()) {
                    team.removeApply(entry.getKey());
                    Out.debug(new Object[]{"remove team applies key : ", entry.getKey()});
                    continue;
                }
                minValidtime = Math.min(minValidtime, ((Long) entry.getValue()).longValue());
            }
        }

        minValidtime = Math.min(minValidtime - now, 60000L);
        JobFactory.addDelayJob(() -> clearExpiredMessage(), minValidtime);
    }


    public static void clearExpiredTeam() {
        long now = GWorld.APP_TIME;
        long validTime = Math.max(1800000, GlobalConfig.TeamOfflineMaxTime * 3600000);
        for (TeamData team : TeamMap.values()) {
            boolean flag = true;
            for (TeamData.TeamMemberData teamMember : team.teamMembers.values()) {
                if (teamMember.isOnline() || now - teamMember.joinTime < validTime) {
                    flag = false;
                    break;
                }
            }
            if (flag || team.isAllRobotOnline()) {
                Out.warn(new Object[]{"clearPastTeam : ", team.id});
                destroyTeam(team);
            }
        }
    }


    public static boolean isInTeam(String playerId) {
        return TeamMemberMap.containsKey(playerId);
    }

    public static boolean isInTeam(String teamId, String playerId) {
        TeamData.TeamMemberData tmData = TeamMemberMap.get(playerId);
        return (tmData != null && tmData.teamId.equals(teamId));
    }

    public static TeamData.TeamMemberData getTeamMember(String playerId) {
        return TeamMemberMap.get(playerId);
    }

    public static void addTeamMember(TeamData.TeamMemberData teamMember) {
        AutoMathes.remove(teamMember.id);
        TeamMemberMap.put(teamMember.id, teamMember);
        WNPlayer player = teamMember.getPlayer();


        TeamData team = teamMember.getTeam();

        if (!team.leaderId.equals(teamMember.id)) {
            Five2FiveService.getInstance().processTeamChangeOnFive2Five((teamMember.getTeam()).leaderId);
        }
        if (team.isInLoopTask() &&
                player != null) {
            for (TaskPO task : team.loopTasks.values()) {
                TaskData taskData = new TaskData(task);
                player.taskManager.pushTaskUpdate(taskData, team);
                player.taskManager.questStatusChangeR2B(player, taskData, task.templateId);


                player.taskManager.dealTaskEvent(Const.TaskType.ACCEPT_DAILY_LOOP, String.valueOf(3), 1);
            }
        }


        team.setRobotTime();


        Five2FiveService.getInstance().singleQuitFive2FiveMatch(teamMember.id, false);

        if (!teamMember.robot) {
            for (TeamData teamData : TeamMap.values()) {
                teamData.invites.remove(teamMember.id);
                teamData.removeApply(teamMember.id);
            }
        }
    }

    public static void removeTeamMember(String playerId) {
        TeamData.TeamMemberData teamMember = TeamMemberMap.remove(playerId);
        if (teamMember != null) {
            TeamData team = teamMember.getTeam();
            WNPlayer player = teamMember.getPlayer();
            if (player != null && player instanceof WNRobot) {
                player.free();
            }
            if (player != null && team != null) {
                if (team.loopTasks != null) {

                    for (TaskPO db : team.loopTasks.values()) {
                        TaskData taskData = new TaskData(db);
                        TaskData task = taskData.clone();
                        task.db.state = Const.TaskState.DELETE.getValue();
                        player.taskManager.pushTaskUpdate(task);
                    }


                    if (team.memberCount() < 3 && team.memberCount() > 0 && !team.isAutoTeam) {
                        for (TeamData.TeamMemberData member : team.teamMembers.values()) {
                            if (member.isLeader) {
                                MessageData.MessageData_Data data = new MessageData.MessageData_Data();
                                MessageData message = MessageUtil.createMessage(Const.MESSAGE_TYPE.loop_task_member_leave.getValue(), member.id, data);
                                message.id = member.id;
                                MessageUtil.sendMessageToPlayer(message, member.id);
                            }
                        }
                    }
                }
                team.setRobotTime();
            }
            TeamUtil.removeAcrossMatch(player);

            if (playerId.equals((teamMember.getTeam()).leaderId)) {
                WNPlayer leader = teamMember.getPlayer();
                if (leader != null) {
                    leader.five2FiveManager.cancelFive2FiveMatch(false);
                }
            } else {

                Five2FiveService.getInstance().processTeamChangeOnFive2Five((teamMember.getTeam()).leaderId);
            }
        }
    }

    public static Map<String, TeamData.TeamMemberData> getTeamMembers(String teamId) {
        TeamData team = getTeam(teamId);
        if (team != null) {
            return team.teamMembers;
        }
        return null;
    }

    public static TeamData getTeam(String teamId) {
        return TeamMap.get(teamId);
    }

    public static void addTeam(TeamData team) {
        TeamMap.put(team.id, team);
    }

    public static void destroyTeam(TeamData team) {
        synchronized (lock) {
            String teamId = team.id;
            Out.debug(new Object[]{"destory team - ", teamId});
            for (String memberId : team.teamMembers.keySet()) {
                removeTeamMember(memberId);
                TeamService.clearTeamData(memberId);
            }

            TeamMap.remove(teamId);
            team.teamMembers.clear();
        }
    }
}


