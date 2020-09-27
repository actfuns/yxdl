package com.wanniu.game.task;

import com.alibaba.fastjson.JSONArray;
import com.wanniu.core.game.LangService;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.StringUtil;
import com.wanniu.game.area.Area;
import com.wanniu.game.area.AreaUtil;
import com.wanniu.game.area.MonsterUnit;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.msg.MessageUtil;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.OpenLvCO;
import com.wanniu.game.data.PickItemCO;
import com.wanniu.game.data.base.MonsterBase;
import com.wanniu.game.functionOpen.FunctionOpenUtil;
import com.wanniu.game.guild.guildBoss.GuildBossAreaHurtRankCenter;
import com.wanniu.game.guild.guildBoss.GuildBossService;
import com.wanniu.game.monster.MonsterConfig;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.task.po.TaskPO;
import com.wanniu.game.team.TeamData;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class TaskEvent
        implements Runnable {
    public int type;
    public Object[] params;
    public WNPlayer player;

    public TaskEvent(Const.EventType name, Object... param) {
        this.type = name.getValue();
        this.params = param;
    }

    public TaskEvent(Const.TaskType name, Object... param) {
        this.type = name.getValue();
        this.params = param;
    }

    public TaskEvent(int type, String param) {
        this.type = type;
        if (StringUtil.isNotEmpty(param)) {
            this.params = JSONArray.parseArray(param).toArray();
        }
    }


    private boolean processGuildBoss() {
        if (this.type == Const.EventType.hurtRank.getValue()) {
            String guildId = (String) this.params[0];
            String playerId = (String) this.params[1];
            long hurt = ((Long) this.params[2]).longValue();
            int enterCount = ((Integer) this.params[3]).intValue();
            GuildBossAreaHurtRankCenter.getInstance().setNewData(guildId, playerId, hurt, enterCount);
            return true;
        }
        if (this.type == Const.EventType.hurtRank_sort.getValue()) {
            String guildId = (String) this.params[0];
            Collection<String> pushRoleIds = (Collection<String>) this.params[1];
            boolean isForcePush = ((Boolean) this.params[2]).booleanValue();
            long killTime = ((Long) this.params[3]).longValue();
            boolean hasKilled = ((Boolean) this.params[4]).booleanValue();
            GuildBossAreaHurtRankCenter.getInstance().processSortHurtRank(guildId, pushRoleIds, isForcePush, killTime, hasKilled);
            return true;
        }
        if (this.type == Const.EventType.statics_ranks.getValue()) {
            GuildBossService.getInstance().processStaticsAllRanks();
            return true;
        }
        if (this.type == Const.EventType.over_statics_ranks.getValue()) {
            String guildId = (String) this.params[0];
            Collection<String> roleIds = (Collection<String>) this.params[1];
            GuildBossAreaHurtRankCenter.getInstance().overStaticsRanks(guildId, roleIds);
            return true;
        }
        return false;
    }

    private void onInterActiveItemEvent() {
        int templateID = Integer.parseInt(this.params[0].toString());
        PickItemCO pickItemProp = (PickItemCO) GameData.PickItems.get(Integer.valueOf(templateID));
        if (pickItemProp != null) {
            String tcCode = pickItemProp.tC;
            if (this.player.bag.findFirstItemByCode("fishgear1") == null) {
                return;
            }


            TaskData task = this.player.taskManager.doingTaskHaveType(Const.TaskType.FISH.getValue());
            if (task != null) {
                String extendTc = task.questTc();
                PlayerUtil.onFishItem(this.player, null, extendTc);
            } else {
                PlayerUtil.onFishItem(this.player, tcCode, null);
            }

            this.player.achievementManager.onFishing();
        }
    }


    private void onAddUnitEvent() {
        String[] taskIds = GlobalConfig.Call_Boss_TaskID.split(",");
        TaskData task = null;
        for (String taskId : taskIds) {
            if (!StringUtil.isEmpty(taskId)) {


                task = this.player.taskManager.getTaskByID(Integer.parseInt(taskId));
                if (task != null)
                    break;
            }
        }
        if (task == null) {
            Out.error(new Object[]{this.player.getId() + " don't have CALL_BOSS QUEST"});

            return;
        }
        Area area = (Area) this.params[0];
        String[] location = ((String) this.params[1]).split(":");
        int x = Integer.parseInt(location[0]);
        int y = Integer.parseInt(location[1]);
        int monsterId = Integer.parseInt(task.prop.targetID);

        MonsterBase prop = MonsterConfig.getInstance().get(monsterId);
        List<MonsterUnit> data = new ArrayList<>();
        MonsterUnit unit = new MonsterUnit();
        unit.id = monsterId;
        unit.x = x;
        unit.y = y;
        unit.force = Const.AreaForce.MONSTER.value;
        unit.autoGuard = true;
        unit.unique = true;
        unit.shareType = prop.shareType;
        data.add(unit);
        area.addUnitsToArea(data);
    }


    private void onChangeAreaEvent() {
        int areaId = ((Integer) this.params[0]).intValue();
        int targetX = ((Integer) this.params[1]).intValue();
        int targetY = ((Integer) this.params[2]).intValue();
        AreaUtil.enterArea(this.player, areaId, targetX, targetY);
    }

    private void onLoopTransformEvent() {
        String[] location = String.valueOf(this.params[1]).split(":");
        int targetX = Integer.parseInt(location[0]);
        int targetY = Integer.parseInt(location[1]);
        int areaId = 0;
        TaskPO taskData = null;


        Map<Integer, TaskPO> loopTasks = this.player.teamManager.getLoopTasks();
        if (loopTasks != null) {
            Iterator<TaskPO> iterator = loopTasks.values().iterator();
            if (iterator.hasNext()) {
                TaskPO task = iterator.next();
                areaId = (TaskUtils.getTaskProp(task.templateId)).circleDungeonID;
                taskData = task;
            }

        }


        TeamData team = this.player.getTeamManager().getTeam();
        if (team != null && areaId != 0 && taskData != null && taskData.state == Const.TaskState.NOT_COMPLETED.getValue()) {
            if (team.leaderId.equals(this.player.getId())) {
                boolean success = true;
                for (TeamData.TeamMemberData teamMember : team.teamMembers.values()) {
                    WNPlayer mPlayer = PlayerUtil.getOnlinePlayer(teamMember.id);
                    if (mPlayer == null) {
                        success = false;
                        MessageUtil.sendSysTip(this.player, LangService.getValue("TEAM_PLAYER_OFF_LINE"), Const.TipsType.BLACK);
                        break;
                    }
                    if (!teamMember.isOnline()) {
                        success = false;
                        MessageUtil.sendSysTip(this.player, LangService.getValue("TEAM_PLAYER_OFF_LINE"), Const.TipsType.BLACK);

                        break;
                    }
                    OpenLvCO openConfig = FunctionOpenUtil.findFunctionOpenPropsByFuncName(Const.FunctionType.LoopTask.getValue());
                    if (mPlayer.getLevel() < openConfig.openLv) {
                        success = false;
                        MessageUtil.sendSysTip(this.player, LangService.getValue("TEAM_MEMBER_LEVEL_LIMIT").replace("{level}", String.valueOf(openConfig.openLv)), Const.TipsType.BLACK);

                        break;
                    }
                }
                if (success) {
                    if (team.memberCount() >= 3) {
                        if (team.followCount() == team.memberCount()) {
                            team.confirm = false;
                        }
                        AreaUtil.enterArea(this.player, areaId, targetX, targetY);
                    } else {
                        MessageUtil.sendSysTip(this.player, LangService.getValue("TASK_NEED_TEAM"), Const.TipsType.BLACK);
                    }
                }
            } else {
                MessageUtil.sendSysTip(this.player, LangService.getValue("TEAM_NO_AUTHORITY"), Const.TipsType.BLACK);
            }
        }
    }


    public void run() {
        if (processGuildBoss()) {
            return;
        }

        if (this.player.onSaveRebirth(this)) {
            return;
        }

        this.player.taskManager.onEvent(this);
        this.player.achievementManager.onTaskEvent(this);
        this.player.bag.onEvent(this);
        this.player.sceneProgressManager.onEvent(this);
        this.player.mountManager.onEvent(this);
        this.player.functionOpenManager.onEvent(this);

        if (this.type == Const.EventType.interActiveItem.getValue()) {
            onInterActiveItemEvent();
        } else if (this.type == Const.EventType.addUnit.getValue()) {
            onAddUnitEvent();
        } else if (this.type == Const.EventType.changeArea.getValue()) {
            onChangeAreaEvent();
        } else if (this.type == Const.EventType.loopTransform.getValue()) {
            onLoopTransformEvent();
        }
        this.player = null;
        this.params = null;
    }
}


