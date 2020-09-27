package com.wanniu.game.request.task;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.common.Const;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.TaskHandler;


@GClientEvent("area.taskHandler.taskFuncDeskRequest")
public class TaskFuncDeskHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        TaskHandler.TaskFuncDeskRequest req = TaskHandler.TaskFuncDeskRequest.parseFrom(this.pak.getRemaingBytes());
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        final String npcId = req.getC2SNcpId();
        return new PomeloResponse() {
            protected void write() throws IOException {
                TaskHandler.TaskFuncDeskResponse.Builder res = TaskHandler.TaskFuncDeskResponse.newBuilder();
                player.getPlayerTasks().dealTaskEvent(Const.TaskType.FUNC_DESK, npcId, 1);
                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


