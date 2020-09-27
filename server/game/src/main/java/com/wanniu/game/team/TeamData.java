package com.wanniu.game.team;

import com.google.protobuf.GeneratedMessage;
import com.wanniu.core.game.JobFactory;
import com.wanniu.core.game.LangService;
import com.wanniu.core.game.protocol.PomeloPush;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.tcp.protocol.Message;
import com.wanniu.core.util.RandomUtil;
import com.wanniu.game.GWorld;
import com.wanniu.game.area.Area;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.Utils;
import com.wanniu.game.common.msg.MessagePush;
import com.wanniu.game.common.msg.MessageUtil;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.TeamTargetCO;
import com.wanniu.game.guild.GuildUtil;
import com.wanniu.game.message.MessageData;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.PlayerPO;
import com.wanniu.game.task.po.TaskPO;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;

import pomelo.area.TeamHandler;


public class TeamData {
    public String id;
    public int logicServerId;
    public Map<String, TeamMemberData> teamMembers;
    public String leaderId;
    public int sceneType;
    public int targetId;
    public int difficulty;
    public int curTargetId;
    public int curDifficulty;
    public int minLevel = 0;
    public int maxLevel = 0;

    public boolean isAutoTeam;

    public boolean isAutoStart;

    public boolean isRobotJoin;

    public boolean isRobotLeader;

    public boolean local = true;
    public boolean confirm = true;
    public ScheduledFuture<?> lockfuture;
    public Map<String, Long> invites = new ConcurrentHashMap<>();
    public Map<String, Long> applies = new ConcurrentHashMap<>();


    public Map<Integer, TaskPO> loopTasks;

    public Map<Integer, Integer> finishedLoopTasks;

    private boolean hasLoopTask;

    private long rebotCanLeaveTime;

    public long robotFreeTime;

    public long robotJoinTime;


    public void onFirstAcceptLoopTask() {
        this.hasLoopTask = true;
    }


    public void onAllOverLoopTask() {
        this.hasLoopTask = false;
        this.rebotCanLeaveTime = System.currentTimeMillis() + 300000L;
    }


    public boolean canRobotLeave() {
        if (isInLoopTask()) {
            return false;
        }
        return (System.currentTimeMillis() >= this.rebotCanLeaveTime);
    }

    public boolean isInLoopTask() {
        return this.hasLoopTask;
    }

    public int memberCount() {
        return this.teamMembers.size();
    }

    public void setAutoTeam(boolean auto) {
        this.isAutoTeam = auto;
        if (auto) {
            setRobotTime();
        }
    }

    public void addApply(String playerId, long validate) {
        this.applies.put(playerId, Long.valueOf(validate));
        if (this.applies.size() == 1) {
            onTeamChange();
        }
    }

    public void removeApply(String playerId) {
        if (this.applies.containsKey(playerId)) {
            this.applies.remove(playerId);
            if (this.applies.isEmpty()) {
                onTeamChange();
            }
        }
    }

    public void setRobotTime() {
        if (GWorld.APP_TIME > this.robotFreeTime && GWorld.APP_TIME < this.robotFreeTime + 300000L) {
            this.robotJoinTime = GWorld.APP_TIME + Utils.getSecMills(60, 300);
        } else {
            this.robotJoinTime = GWorld.APP_TIME + Utils.getSecMills(6, 10);
        }
        setFreeRobotTime();
    }

    public void setFreeRobotTime() {
        if (this.isRobotJoin) {
            this.robotFreeTime = Math.max(GWorld.APP_TIME, this.robotJoinTime) + Utils.getSecMills(60, 200);
        }
    }

    public boolean isAllOnline() {
        for (TeamMemberData teamMember : this.teamMembers.values()) {
            if (!teamMember.isOnline()) {
                return false;
            }
        }
        return true;
    }

    public boolean isAllRobotOnline() {
        for (TeamMemberData teamMember : this.teamMembers.values()) {
            if (!teamMember.robot && teamMember.isOnline()) {
                return false;
            }
        }
        return true;
    }

    public int followCount() {
        int count = 0;
        for (TeamMemberData member : this.teamMembers.values()) {
            if (member.isFollow()) {
                count++;
            }
        }
        return count;
    }

    public boolean isFull() {
        return (memberCount() >= GlobalConfig.NormalTeamMaxNum);
    }

    public TeamHandler.Team.Builder createTeamProto() {
        TeamMemberData leader = getLeader();
        if (leader == null) {
            Out.warn(new Object[]{"组队队长异常，自动转让队长..."});
            if (memberCount() > 0) {
                changeLeader();
                leader = getLeader();
            } else {
                TeamService.destroyTeam(this);
                return null;
            }
        }
        if (leader == null || !leader.isOnline()) {
            return null;
        }
        TeamHandler.Team.Builder team = TeamHandler.Team.newBuilder();
        team.setId(this.id);
        team.setTargetId(this.targetId);
        team.setLeaderId(this.leaderId);
        team.setMinLevel(this.minLevel);
        team.setMaxLevel(this.maxLevel);
        for (TeamMemberData teamMember : this.teamMembers.values()) {
            TeamHandler.TeamMemberBasic.Builder basic = TeamHandler.TeamMemberBasic.newBuilder();
            PlayerPO member = teamMember.getPlayerData();
            basic.setId(teamMember.id);
            basic.setPro(member.pro);
            basic.setName(member.name);
            basic.setLevel(member.level);
            basic.setUpLevel(0);
            basic.setGuildName(GuildUtil.getGuildName(teamMember.id));
            team.addTeamMembers(basic);
        }
        return team;
    }

    public int getCurTargetId() {
        return (this.curTargetId != 0) ? this.curTargetId : this.targetId;
    }

    public int getCurDifficulty() {
        return (this.curDifficulty != 0) ? this.curDifficulty : this.difficulty;
    }

    public int getTargetMap() {
        int targetId = getCurTargetId();
        int difficulty = getCurDifficulty();
        if (targetId == 0)
            return 0;
        return getTargetMap(targetId, difficulty);
    }

    public static int getTargetMap(int targetId, int difficulty) {
        int mapId = 0;
        TeamTargetCO teamTargetProp = (TeamTargetCO) GameData.TeamTargets.get(Integer.valueOf(targetId));
        if (teamTargetProp != null &&
                difficulty == 1) {
            mapId = teamTargetProp.normalMapID;
        }


        if (mapId == 0 && targetId == 1020) {
            mapId = GlobalConfig.DemonTowerMapIds[RandomUtil.getIndex(GlobalConfig.DemonTowerMapIds.length)];
        }
        return mapId;
    }

    public void invite(WNPlayer fromPlayer, String toPlayerId) {
        Map<String, String> strMsg = new HashMap<>(2);
        strMsg.put("playerName", PlayerUtil.getFullColorName(fromPlayer));
        TeamTargetCO target = (TeamTargetCO) GameData.TeamTargets.get(Integer.valueOf(this.targetId));
        strMsg.put("target", (target != null) ? LangService.format("TEAM_TARGET_DESC", new Object[]{target.targetName}) : "");
        MessageData.MessageData_Team_InviteId msgData = new MessageData.MessageData_Team_InviteId();
        msgData.inviteId = toPlayerId;
        MessageData message = MessageUtil.createMessage(Const.MESSAGE_TYPE.team_invite.getValue(), fromPlayer.getId(), (MessageData.MessageData_Data) msgData, strMsg);
        message.id = this.id;
        MessageUtil.sendMessageToPlayer(message, toPlayerId);
        this.invites.put(toPlayerId, Long.valueOf(message.validTime));
    }

    public TeamMemberData getLeader() {
        return this.teamMembers.get(this.leaderId);
    }

    public TeamMemberData getMember(String memberId) {
        return this.teamMembers.get(memberId);
    }

    public boolean islock() {
        return (this.lockfuture != null);
    }

    public void lock(int time) {
        if (this.lockfuture != null) {
            this.lockfuture.cancel(true);
            Out.warn(new Object[]{"team lock more..."});
        }
        this.lockfuture = JobFactory.addDelayJob(() -> {
            this.lockfuture = null;
            Out.debug(new Object[]{"lock timeout..."}, );
        } (time * 1000));
    }


    public void unlock() {
        if (this.lockfuture != null) {
            this.lockfuture.cancel(true);
            this.lockfuture = null;
        }
    }

    public WNPlayer getPlayer(String rid) {
        return PlayerUtil.getOnlinePlayer(rid);
    }

    public boolean isOpenFollow() {
        return isOpenJoin();
    }

    public boolean isOpenJoin() {
        boolean lock = islock();
        if (lock) {
            return false;
        }
        WNPlayer player = getPlayer(this.leaderId);
        Area area = (player == null) ? null : player.getArea();
        return (area != null && area.isOpenJoinTeam());
    }

    public void changeLeader() {
        synchronized (TeamService.lock) {
            TeamMemberData newLeader = null;
            Map<String, TeamMemberData> teamMembers = this.teamMembers;
            for (TeamMemberData member : teamMembers.values()) {
                if (newLeader != null && member.isOnline() && ((member.joinTime < newLeader.joinTime && !member.robot) || !newLeader.isOnline() || (newLeader.robot && !member.robot))) {
                    newLeader = member;
                    continue;
                }
                if (newLeader == null) {
                    newLeader = member;
                }
            }
            if (newLeader != null) {
                TeamMemberData oldLeader = getLeader();
                this.leaderId = newLeader.id;
                newLeader.isLeader = true;
                this.isRobotLeader = newLeader.robot;
                if (oldLeader != null && oldLeader != newLeader) {
                    oldLeader.isLeader = false;
                }
            } else {
                Out.warn(new Object[]{"队长无法转让, 队员：", Integer.valueOf(teamMembers.size())});
            }
        }
    }

    public void receive(String route, GeneratedMessage msg) {
        receive((PomeloPush) new MessagePush(route, msg));
    }

    public void receive(PomeloPush push) {
        for (String rid : this.teamMembers.keySet()) {
            WNPlayer player = getPlayer(rid);
            if (player != null) {
                player.receive((Message) push);
            }
        }
    }

    public void onTeamChange() {
        TeamHandler.OnTeamTargetPush targetPush = TeamHandler.OnTeamTargetPush.newBuilder().setS2CTeamTarget(TeamUtil.generateTeamTargetData(this)).setHaveApply(this.applies.size()).setS2CIsAcceptAutoTeam(this.isAutoTeam ? 1 : 0).build();
        for (String rid : this.teamMembers.keySet()) {
            WNPlayer member = PlayerUtil.getOnlinePlayer(rid);
            if (member != null) {
                member.receive("area.teamPush.onTeamTargetPush", (GeneratedMessage) targetPush);
            }
        }
    }


    public static class TeamMemberData {
        public String teamId;

        public String id;

        public long joinTime;
        public boolean robot;
        public boolean isLeader;
        public boolean follow;
        public int handup;

        public TeamMemberData(String teamId, String playerId) {
            this.teamId = teamId;
            this.id = playerId;
            this.joinTime = GWorld.APP_TIME;
            this.follow = true;
        }

        public boolean isOnline() {
            return PlayerUtil.isOnline(this.id);
        }

        public WNPlayer getPlayer() {
            return PlayerUtil.getOnlinePlayer(this.id);
        }

        public PlayerPO getPlayerData() {
            return PlayerUtil.getPlayerBaseData(this.id);
        }

        public TeamData getTeam() {
            return TeamService.getTeam(this.teamId);
        }

        public boolean isFollow() {
            return (this.follow || this.isLeader);
        }

        public int getFollow() {
            return (this.follow && !this.isLeader) ? 1 : 0;
        }

        public int getLeader() {
            return this.isLeader ? 1 : 0;
        }

        public boolean isBusy() {
            if (!isOnline()) {
                return true;
            }
            WNPlayer player = getPlayer();
            if (!isFollow()) {
                Area area = player.getArea();
                if (area == null || !area.isNormal()) {
                    return true;
                }
            }
            return false;
        }

        public void receive(String route, GeneratedMessage msg) {
            receive((PomeloPush) new MessagePush(route, msg));
        }

        public void receive(PomeloPush push) {
            WNPlayer player = getPlayer();
            if (player != null)
                player.receive((Message) push);
        }
    }
}


