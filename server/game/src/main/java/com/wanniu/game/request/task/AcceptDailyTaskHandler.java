package com.wanniu.game.request.task;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.common.Const;
import com.wanniu.game.data.base.TaskBase;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.task.TaskUtils;

import java.io.IOException;

import pomelo.area.TaskHandler;


@GClientEvent("area.taskHandler.acceptDailyTaskRequest")
public class AcceptDailyTaskHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        TaskHandler.AcceptDailyTaskRequest req = TaskHandler.AcceptDailyTaskRequest.parseFrom(this.pak.getRemaingBytes());
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        final String npcId = req.getC2SNpcId();

        return new PomeloResponse() {
            protected void write() throws IOException {
                TaskHandler.AcceptDailyTaskResponse.Builder res = TaskHandler.AcceptDailyTaskResponse.newBuilder();
                if (!player.canTalkWithNpc(0, Integer.parseInt(npcId))) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("TASK_OBJ_FAR_AWAY"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }
                if (!player.functionOpenManager.isOpen(Const.FunctionType.teacher.getValue())) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("FUNC_SET_PLAYED_NOT_OPEN"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }
                if (player.taskManager.dailyTasks.size() > 0) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("DAILY_HAS_ACCEPTED"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }

                if (player.taskManager.taskListPO != null && player.taskManager.taskListPO.todayDailyTaskCount >= GlobalConfig.Daily_completeMax) {

                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("DAILY_TODAY_MAX"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }

                TaskBase prop = TaskUtils.getRDDailyTask(player.getLevel(), 0, player.getPro());
                AcceptTaskHandler.AcceptTaskResult result = player.getPlayerTasks().acceptTask(prop.iD, 2);
                if (result.task != null) {
                    result.task.setSecProgress(player.taskManager.getSecProgress(result.task.getKind()));
                    player.getPlayerTasks().pushTaskUpdate(result.task);
                    res.setS2CCode(200);


                    player.taskManager.dealTaskEvent(Const.TaskType.ACCEPT_DAILY_LOOP, String.valueOf(2), 1);
                    player.taskManager.dealTaskEvent(Const.TaskType.ACCEPT_DAILY, String.valueOf(2), 1);
                } else {
                    res.setS2CCode(500);
                    res.setS2CMsg(result.msg);
                }
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


