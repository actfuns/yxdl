package com.wanniu.game.request.task;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.logfs.Out;
import com.wanniu.game.common.Const;
import com.wanniu.game.data.base.TaskBase;
import com.wanniu.game.functionOpen.FunctionOpenUtil;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.task.TaskData;
import com.wanniu.game.task.TaskUtils;
import com.wanniu.game.task.po.TaskPO;
import com.wanniu.game.team.TeamData;

import java.io.IOException;
import java.util.Map;

import pomelo.area.TaskHandler;


@GClientEvent("area.taskHandler.acceptLoopTaskRequest")
public class AcceptLoopTaskHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        TaskHandler.AcceptLoopTaskRequest req = TaskHandler.AcceptLoopTaskRequest.parseFrom(this.pak.getRemaingBytes());
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        final String npcId = req.getC2SNpcId();

        return new PomeloResponse() {
            protected void write() throws IOException {
                TaskHandler.AcceptLoopTaskResponse.Builder res = TaskHandler.AcceptLoopTaskResponse.newBuilder();
                if (!player.canTalkWithNpc(0, Integer.parseInt(npcId))) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("TASK_OBJ_FAR_AWAY"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }

                int openLevel = (FunctionOpenUtil.getPropByName(Const.FunctionType.LoopTask.getValue())).openLv;
                if (player.getLevel() < openLevel) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("AREA_PLAYER_LEVEL_LIMIT").replace("{playerLevel}", openLevel + ""));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }

                TeamData team = player.getTeamManager().getTeam();
                if (team == null) {
                    res.setS2CCode(500);
                    res.setS2CMsg(String.format(LangService.getValue("TEAM_NEED_MEMBER"), new Object[]{Integer.valueOf(3)}));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }
                if (!team.leaderId.equals(player.getId())) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("TEAM_NO_AUTHORITY"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }

                if (team.memberCount() < 3) {
                    res.setS2CCode(500);
                    res.setS2CMsg(String.format(LangService.getValue("TEAM_NEED_MEMBER"), new Object[]{Integer.valueOf(3)}));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }

                if (team.isInLoopTask()) {

                    Map<Integer, TaskPO> loopTasks = player.teamManager.getLoopTasks();
                    StringBuilder sb = (new StringBuilder(player.getId())).append(" in acceptLoopTaskRequest||");
                    if (loopTasks != null) {
                        for (TaskPO db : loopTasks.values()) {
                            player.taskManager.pushTaskUpdate(new TaskData(db));
                            sb.append("loopTask:").append(db.templateId).append(",").append(db.state).append(",").append(db.progress).append(",");
                        }
                    }
                    Out.info(new Object[]{sb.toString()});
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("TASK_IS_ACCPETED"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }

                TaskBase prop = TaskUtils.getFirstLoopTask();

                AcceptTaskHandler.AcceptTaskResult result = player.getPlayerTasks().acceptTask(prop.iD, prop.kind);
                if (result.task != null) {
                    result.task.setSecProgress(player.taskManager.getSecProgress(result.task.getKind()));

                    for (TeamData.TeamMemberData member : team.teamMembers.values()) {
                        WNPlayer mPlayer = member.getPlayer();
                        if (mPlayer == null)
                            continue;
                        mPlayer.getPlayerTasks().pushTaskUpdate(result.task);


                        mPlayer.taskManager.dealTaskEvent(Const.TaskType.ACCEPT_DAILY_LOOP, String.valueOf(3), 1);
                    }
                } else {
                    Out.error(new Object[]{"accept loop task failed"});
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("CANNOT_ACCEPT_QUEST"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }
                res.setS2CCode(200);

                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


