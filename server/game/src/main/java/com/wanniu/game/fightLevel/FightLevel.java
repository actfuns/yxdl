package com.wanniu.game.fightLevel;

import com.alibaba.fastjson.JSONObject;
import com.google.protobuf.GeneratedMessage;
import com.wanniu.core.game.JobFactory;
import com.wanniu.core.game.LangService;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.tcp.protocol.Message;
import com.wanniu.game.GWorld;
import com.wanniu.game.area.Area;
import com.wanniu.game.area.AreaEvent;
import com.wanniu.game.area.DamageHealVO;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.msg.MessagePush;
import com.wanniu.game.fightLevel.po.OutputStatistics;
import com.wanniu.game.player.BILogService;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.task.TaskEvent;
import com.wanniu.game.task.TaskUtils;
import com.wanniu.game.team.TeamData;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;

import pomelo.area.FightLevelHandler;
import pomelo.area.TeamHandler;


public class FightLevel
        extends Area {
    public static final int NEED_PRODUCE_LEVEL = 30;
    public int hard;
    private int needProduce;
    private Const.SCENE_TYPE sceneType;
    private ScheduledFuture<?> jobFuture;
    private final ConcurrentHashMap<String, OutputStatistics> output = new ConcurrentHashMap<>();

    public FightLevel(JSONObject opts, Const.SCENE_TYPE sceneType) {
        super(opts);
        this.hard = this.prop.hardModel;
        this.sceneType = sceneType;


        this.jobFuture = JobFactory.addFixedRateJob(() -> GWorld.getInstance().ansycExec(()), 5000L, 3000L);
    }

    public void output() {
        if (this.output.isEmpty()) {
            return;
        }

        if (this.actors.isEmpty()) {
            return;
        }

        TeamHandler.OnTeamMumberHurtPush.Builder push = TeamHandler.OnTeamMumberHurtPush.newBuilder();
        for (OutputStatistics out : this.output.values()) {
            TeamHandler.MumberHurtInfo.Builder m = TeamHandler.MumberHurtInfo.newBuilder();
            m.setPlayerName(out.getName());
            m.setHurt(out.getHurt());
            m.setCure(out.getCure());
            push.addPlayers(m);
        }

        TeamHandler.OnTeamMumberHurtPush result = push.build();
        for (Map.Entry<String, Area.Actor> actorEntry : (Iterable<Map.Entry<String, Area.Actor>>) this.actors.entrySet()) {
            String playerId = actorEntry.getKey();
            WNPlayer player = getPlayer(playerId);
            if (player == null) {
                continue;
            }
            player.receive("area.teamPush.onTeamMumberHurtPush", (GeneratedMessage) result);
        }
        Out.debug(new Object[]{"副本输出.... areaId=", Integer.valueOf(this.areaId)});
    }


    public void bindBattleServer(WNPlayer player) {
        super.bindBattleServer(player);
        TeamData team = player.getTeamManager().getTeam();
        if (team != null) {
            WNPlayer member = null;
            for (TeamData.TeamMemberData teamMember : team.teamMembers.values()) {
                member = teamMember.getPlayer();
                if (member == null) {
                    continue;
                }
                if (needProduce(member)) {
                    this.needProduce++;
                }
            }

        } else if (needProduce(player)) {
            this.needProduce = 1;
        }
    }


    protected void onDailyActivity(WNPlayer player) {
        super.onDailyActivity(player);


        if (this.sceneType == Const.SCENE_TYPE.FIGHT_LEVEL) {
            player.dailyActivityMgr.onEvent(Const.DailyType.DUNGEON, "0", 1);
        }
    }

    public int reliveNum(String playerid) {
        Out.debug(new Object[]{getClass().getName(), "fightLevel reviveNum:", this.actors});
        Area.Actor actor = (Area.Actor) this.actors.get(playerid);
        if (actor == null) {

            Out.error(new Object[]{getClass().getName(), "fightLevel revive playerId not exist:", playerid});
            return 0;
        }

        int configNum = this.prop.revival;
        if (configNum <= 0) {
            return configNum;
        }
        if (configNum <= actor.rebornNum) {
            return 0;
        }
        return configNum - actor.rebornNum;
    }


    public void onGameOver(JSONObject event) {
        if (this.jobFuture != null) {
            this.jobFuture.cancel(false);
        }

        int winForce = event.getIntValue("winForce");
        boolean isWin = (winForce == 2);
        MessagePush push = new MessagePush("area.fightLevelPush.onFubenClosePush", (GeneratedMessage) FightLevelHandler.OnFubenClosePush.newBuilder().setS2CMsg(LangService.getValue("DUNGEON_OVER_MESSAGE")).setS2COverTime(this.prop.timeCount).build());


        WNPlayer player = null;
        for (Map.Entry<String, Area.Actor> actorEntry : (Iterable<Map.Entry<String, Area.Actor>>) this.actors.entrySet()) {
            String playerId = actorEntry.getKey();
            Area.Actor actor = actorEntry.getValue();
            player = getPlayer(playerId);
            if (player == null)
                continue;
            if (isWin) {
                player.finishFightLevel(this.hard, this.prop.templateID);
                player.onEvent(new TaskEvent(Const.TaskType.FINISH_CLONESCENE, new Object[]{String.valueOf(this.areaId), Integer.valueOf(1)}));


                if (this.prop.dungeonTab == 1 && player != null) {
                    Collection<String> teamMembers = player.getTeamMembers();
                    if (teamMembers != null) {
                        WNPlayer member = PlayerUtil.getOnlinePlayer(playerId);
                        int lvl = member.getLevel();
                        for (String teamMemPlayerId : teamMembers) {
                            if (this.actors.containsKey(teamMemPlayerId)) {
                                WNPlayer teamMember = PlayerUtil.getOnlinePlayer(teamMemPlayerId);
                                if (teamMember == null)
                                    continue;
                                int tempLvl = teamMember.getLevel();

                                if (lvl >= tempLvl + 5 || (!actor.profitable && (getActor(teamMemPlayerId)).profitable)) {
                                    player.processXianYuanGet(GlobalConfig.Fate_Dungeon);

                                    break;
                                }
                            }
                        }
                    }
                }
                if (this.prop.type == Const.SCENE_TYPE.FIGHT_LEVEL.getValue()) {
                    player.onEvent(new TaskEvent(Const.TaskType.FINISH_DUNGEONS_COUNT, new Object[]{String.valueOf(this.areaId), Integer.valueOf(1)}));
                }
            }


            player.achievementManager.onPassedDungeon(this.areaId);

            player.receive((Message) push);

            BILogService.getInstance().ansycReportFightLevel(player.getPlayer(), isWin ? 1 : 0, this.areaId, this.instanceId);
        }
        if (isWin) {

            TeamData team = player.getTeamManager().getTeam();
            if (team != null) {
                WNPlayer member = null;
                for (TeamData.TeamMemberData teamMember : team.teamMembers.values()) {
                    member = teamMember.getPlayer();
                    if (member == null) {
                        continue;
                    }
                    member.fightLevelManager.useProduce(this.prop.templateID);
                    member.fightLevelManager.onDungeonReset(this.areaId);
                }
            } else {
                player.fightLevelManager.useProduce(this.prop.templateID);
                player.fightLevelManager.onDungeonReset(this.areaId);
            }
        }
    }


    protected void onDisponseLeave(WNPlayer player) {
        Out.debug(new Object[]{"-------------------dispose----", player.getName()});
        TeamData.TeamMemberData teamMember = player.getTeamManager().getTeamMember();
        if (teamMember == null || teamMember.isLeader || !teamMember.follow) {
            Out.debug(new Object[]{player.getName(), " leave fight level!!!!!!!!!!!!!!!!!!"});
            player.fightLevelManager.leaveDungeon(player, this);
        }
    }


    public boolean isUseTC() {
        return (this.needProduce > 0);
    }

    public void onPlayerDeadByMonster(WNPlayer player, AreaEvent.MonsterData monsterData) {
        String playerId = player.getId();

        Area.Actor actor = (Area.Actor) this.actors.get(playerId);
        if (actor == null && !player.isProxy()) {
            Out.error(new Object[]{"onPlayerDead not exist! :", playerId});

            return;
        }
        pushRelive(player);
    }


    private boolean needProduce(WNPlayer player) {
        if (this.prop.type == Const.SCENE_TYPE.LOOP.getValue()) {
            return TaskUtils.profitableLoop(player);
        }
        return (player.fightLevelManager.needProduce(this.prop.templateID) && player.getLevel() < this.prop.reqLevel + 30);
    }


    public void onPlayerDeadByPlayer(WNPlayer deadPlayer, WNPlayer hitPlayer, float x, float y) {
        Out.warn(new Object[]{"副本中出现玩家击杀玩家！"});
    }

    public void addPlayer(WNPlayer player) {
        super.addPlayer(player);
        Area.Actor actor = getActor(player.getId());
        if (actor != null) {
            actor.profitable = needProduce(player);
        }
    }


    public Area.AreaItem onPickItem(String playerId, String itemId, boolean isGuard) {
        return isUseTC() ? super.onPickItem(playerId, itemId, isGuard) : null;
    }

    public Area.ReliveType getReliveType() {
        return (this.prop.type == Const.SCENE_TYPE.LOOP.getValue()) ? Area.ReliveType.NOW : Area.ReliveType.BORN;
    }


    public void dispose(boolean processExit) {
        super.dispose(processExit);
        if (this.jobFuture != null) {
            this.jobFuture.cancel(false);
        }
    }


    public void onBattleReport(List<DamageHealVO> datas) {
        for (DamageHealVO damage : datas) {
            OutputStatistics out = this.output.get(damage.PlayerUUID);
            if (out == null) {
                WNPlayer player = PlayerUtil.getOnlinePlayer(damage.PlayerUUID);
                if (player != null) {
                    out = new OutputStatistics();
                    out.setId(damage.PlayerUUID);
                    out.setName(player.getName());
                    this.output.put(damage.PlayerUUID, out);
                }
            }

            if (out != null) {
                out.setHurt(damage.TotalDamage);
                out.setCure(damage.TotalHealing);
            }
        }
    }
}


