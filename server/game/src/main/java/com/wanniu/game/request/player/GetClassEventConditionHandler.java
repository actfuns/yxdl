package com.wanniu.game.request.player;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.tcp.protocol.Packet;
import com.wanniu.game.data.ext.UpLevelExpExt;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.PlayerHandler;


@GClientEvent("area.playerHandler.getClassEventConditionRequest")
public class GetClassEventConditionHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        return new PomeloResponse() {
            protected void write() throws IOException {
                WNPlayer player = (WNPlayer) GetClassEventConditionHandler.this.pak.getPlayer();

                PlayerHandler.GetClassEventConditionResponse.Builder res = PlayerHandler.GetClassEventConditionResponse.newBuilder();
                res.setS2CCode(200);
                UpLevelExpExt prop_next = player.baseDataManager.getNextUpLevelExp();
                String flag = player.baseDataManager.checkClassEvent(prop_next);
                if (flag == null) {
                    res.setS2CFlag(1);
                } else {
                    res.setS2CFlag(0);
                }
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


