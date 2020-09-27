package com.wanniu.game.request.player;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.logfs.Out;
import com.wanniu.game.area.AreaUtil;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.msg.ErrorResponse;
import com.wanniu.game.common.msg.MessageUtil;
import com.wanniu.game.data.OpenLvCO;
import com.wanniu.game.functionOpen.FunctionOpenUtil;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.task.TaskUtils;
import com.wanniu.game.task.po.TaskPO;
import com.wanniu.game.team.TeamData;

import java.io.IOException;
import java.util.Map;

import pomelo.area.PlayerHandler;


@GClientEvent("area.playerHandler.changeAreaByTaskRequest")
public class ChangeAreaByTaskHandler
        extends ChangeAreaFilter {
    public PomeloResponse request(WNPlayer player) throws Exception {
        PlayerHandler.ChangeAreaByTaskRequest req = PlayerHandler.ChangeAreaByTaskRequest.parseFrom(this.pak.getRemaingBytes());
        int mapId = req.getMapId();
        int taskId = req.getTaskId();
        int x = req.getPosx();
        int y = req.getPosy();
        int pointId = req.getPoint();

        if (mapId <= 0 || taskId <= 0) {
            return (PomeloResponse) new ErrorResponse(player.getAreaId() + " - " + pointId + " : " + LangService.getValue("AREA_ID_NULL"));
        }

        boolean done = false;


        TeamData team = player.getTeamManager().getTeam();
        if (team != null) {
            TaskPO taskData = null;
            int areaId = 0;

            Map<Integer, TaskPO> loopTasks = player.teamManager.getLoopTasks();
            if (loopTasks != null) {
                for (TaskPO task : loopTasks.values()) {
                    if (taskId == task.templateId) {
                        areaId = (TaskUtils.getTaskProp(task.templateId)).circleDungeonID;
                        taskData = task;
                        break;
                    }
                }
            }
            if (areaId > 0 && taskData != null && taskData.state == Const.TaskState.NOT_COMPLETED.getValue()) {
                if (team.leaderId.equals(player.getId())) {
                    boolean success = true;
                    for (TeamData.TeamMemberData teamMember : team.teamMembers.values()) {
                        WNPlayer mPlayer = PlayerUtil.getOnlinePlayer(teamMember.id);
                        if (mPlayer == null) {
                            success = false;
                            MessageUtil.sendSysTip(player, LangService.getValue("TEAM_PLAYER_OFF_LINE"), Const.TipsType.BLACK);
                            break;
                        }
                        if (!teamMember.isOnline()) {
                            success = false;
                            MessageUtil.sendSysTip(player, LangService.getValue("TEAM_PLAYER_OFF_LINE"), Const.TipsType.BLACK);

                            break;
                        }
                        OpenLvCO openConfig = FunctionOpenUtil.findFunctionOpenPropsByFuncName(Const.FunctionType.LoopTask.getValue());
                        if (mPlayer.getLevel() < openConfig.openLv) {
                            success = false;
                            MessageUtil.sendSysTip(player,
                                    LangService.getValue("TEAM_MEMBER_LEVEL_LIMIT").replace("{level}", String.valueOf(openConfig.openLv)), Const.TipsType.BLACK);

                            break;
                        }
                    }

                    if (success) {
                        if (team.memberCount() >= 3) {
                            if (team.followCount() == team.memberCount()) {
                                team.confirm = false;
                            }
                            if (player.getAreaId() != areaId) {
                                AreaUtil.dispatchByAreaId(player, areaId, null);
                                done = true;
                            }
                        } else {
                            MessageUtil.sendSysTip(player, LangService.getValue("TASK_NEED_TEAM"), Const.TipsType.BLACK);
                        }
                    }
                } else {
                    MessageUtil.sendSysTip(player, LangService.getValue("TEAM_NO_AUTHORITY"), Const.TipsType.BLACK);
                }
            }

            if (!done) {
                Out.warn(new Object[]{"changeAreaByTaskRequest handle failed: " + req.toString()});
            }
        }
        Out.debug(new Object[]{"changeAreaByTaskRequest: " + req.toString()});

        final PlayerHandler.ChangeAreaByTaskResponse.Builder res = PlayerHandler.ChangeAreaByTaskResponse.newBuilder();
        res.setS2CCode(200);
        return new PomeloResponse() {
            protected void write() throws IOException {
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


