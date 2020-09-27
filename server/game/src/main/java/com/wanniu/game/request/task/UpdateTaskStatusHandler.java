package com.wanniu.game.request.task;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.TaskHandler;


@GClientEvent("area.taskHandler.updateTaskStatusRequest")
public class UpdateTaskStatusHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        TaskHandler.UpdateTaskStatusRequest req = TaskHandler.UpdateTaskStatusRequest.parseFrom(this.pak.getRemaingBytes());
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        final int templateId = req.getC2STemplateId();
        final int kind = req.getC2SKind();
        return new PomeloResponse() {
            protected void write() throws IOException {
                TaskHandler.UpdateTaskStatusResponse.Builder res = TaskHandler.UpdateTaskStatusResponse.newBuilder();
                if (templateId > 0 && player.getPlayerTasks().updateStatus(templateId, kind)) {
                    res.setS2CCode(200);
                } else {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
                }
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


