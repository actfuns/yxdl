package com.wanniu.game.request.task;

import com.alibaba.fastjson.JSON;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.player.WNPlayer;
import pomelo.area.TaskHandler;


@GClientEvent("area.taskHandler.cjPlayEndNotify")
public class CjPlayEndNotifyHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        TaskHandler.CjPlayEndNotify req = TaskHandler.CjPlayEndNotify.parseFrom(this.pak.getRemaingBytes());
        WNPlayer player = (WNPlayer) this.pak.getPlayer();
        String msg = req.getS2CMsg();

        CJBattleServerNotify notify = new CJBattleServerNotify();
        notify.playerId = player.getId();
        notify.msg = msg;

        player.getXmdsManager().notifyBattleServer(player.getInstanceId(), "CjPlayEndNotify", JSON.toJSONString(notify));
        return null;
    }

    public static final class CJBattleServerNotify {
        public String playerId;
        public String msg;
    }
}


