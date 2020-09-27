package com.wanniu.game.request.task;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.team.TeamData;

import java.io.IOException;

import pomelo.area.TaskHandler;


@GClientEvent("area.taskHandler.discardTaskRequest")
public class DiscardTaskHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        TaskHandler.DiscardTaskRequest req = TaskHandler.DiscardTaskRequest.parseFrom(this.pak.getRemaingBytes());
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        final int templateId = req.getC2STemplateId();
        final int kind = req.getC2SKind();

        return new PomeloResponse() {
            protected void write() throws IOException {
                TaskHandler.DiscardTaskResponse.Builder res = TaskHandler.DiscardTaskResponse.newBuilder();

                if (kind == 3) {
                    TeamData team = player.getTeamManager().getTeam();
                    if (team != null && !team.leaderId.equals(player.getId())) {
                        res.setS2CCode(500);
                        res.setS2CMsg(LangService.getValue("TEAM_NO_AUTHORITY"));
                        this.body.writeBytes(res.build().toByteArray());

                        return;
                    }
                }

                if (templateId > 0 && player.getPlayerTasks().discardTask(templateId, kind)) {
                    res.setS2CCode(200);
                } else {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("CANNOT_GIVEUP_QUEST"));
                }
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


