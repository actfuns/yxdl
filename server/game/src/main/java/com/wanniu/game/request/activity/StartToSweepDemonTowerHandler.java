package com.wanniu.game.request.activity;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.tcp.protocol.Packet;
import com.wanniu.game.activity.DemonTowerManager;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.DemonTowerHandler;


@GClientEvent("area.demonTowerHandler.startToSweepDemonTowerRequest")
public class StartToSweepDemonTowerHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        DemonTowerHandler.StartToSweepDemonTowerRequest req = DemonTowerHandler.StartToSweepDemonTowerRequest.parseFrom(this.pak.getRemaingBytes());
        return new PomeloResponse() {
            protected void write() throws IOException {
                WNPlayer player = (WNPlayer) StartToSweepDemonTowerHandler.this.pak.getPlayer();

                DemonTowerManager manager = player.demonTowerManager;

                DemonTowerHandler.StartToSweepDemonTowerResponse.Builder res = DemonTowerHandler.StartToSweepDemonTowerResponse.newBuilder();

                if (manager.po.maxFloor == 1) {

                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("DEMON_TOWER_CANNOT_SWEEP"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }
                if (manager.po.sweepCountLeft == 0) {

                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("DEMON_TOWER_NOT_ENOUGH_SWEEP_COUNT"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }
                if (manager.po.sweepEndTime != null) {

                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("DEMON_TOWER_IS_SWEEPING"));
                    this.body.writeBytes(res.build().toByteArray());


                    return;
                }


                int sweepTime = GlobalConfig.SweepTime * (manager.po.maxFloor - 1);

                res.setEndTimeStamp(System.currentTimeMillis() + sweepTime);


                player.demonTowerManager.StartToSweep(sweepTime);


                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


