package com.wanniu.game.request.task;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.logfs.Out;
import com.wanniu.game.common.msg.ErrorResponse;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.task.TaskData;
import com.wanniu.game.team.TeamData;

import java.io.IOException;

import pomelo.area.TaskHandler;


@GClientEvent("area.taskHandler.submitTaskRequest")
public class SubmitTaskHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        TaskHandler.SubmitTaskRequest req = TaskHandler.SubmitTaskRequest.parseFrom(this.pak.getRemaingBytes());
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        final int templateId = req.getC2STemplateId();
        if (templateId == 0) {
            Out.error(new Object[]{"submitTaskRequest:", player.getName(), "--", Integer.valueOf(templateId)});
            return (PomeloResponse) new ErrorResponse(LangService.getValue("CANNOT_COMPLETE_QUEST"));
        }
        final int kind = req.getC2SKind();
        TaskData task = player.getPlayerTasks().getTask(templateId, kind);
        if (task == null) {
            return (PomeloResponse) new ErrorResponse("");
        }

        String npcId = req.getC2SNpcId();
        if (!player.canTalkWithNpc(templateId, Integer.parseInt(npcId))) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("TASK_OBJ_FAR_AWAY"));
        }

        final int isDouble = req.getC2SDouble();

        return new PomeloResponse() {
            protected void write() throws IOException {
                TaskHandler.SubmitTaskResponse.Builder res = TaskHandler.SubmitTaskResponse.newBuilder();
                int code = 0;

                if (kind == 3) {
                    TeamData team = player.getTeamManager().getTeam();
                    if (team == null || !team.leaderId.equals(player.getId())) {
                        res.setS2CCode(500);
                        res.setS2CMsg(LangService.getValue("TEAM_NO_AUTHORITY"));
                        this.body.writeBytes(res.build().toByteArray());


                        return;
                    }
                }


                code = player.getPlayerTasks().submitTask(templateId, kind, isDouble);


                if (code == 1) {
                    res.setS2CCode(200);
                } else if (code == -2) {
                    res.setS2CCode(500);
                } else {
                    res.setS2CCode(500);
                }


                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


