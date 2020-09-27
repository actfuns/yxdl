package com.wanniu.game.request.activity;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.tcp.protocol.Packet;
import com.wanniu.game.activity.DemonTowerManager;
import com.wanniu.game.common.Const;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.DemonTowerHandler;


@GClientEvent("area.demonTowerHandler.finishSweepDemonTowerRequest")
public class FinishSweepDemonTowerHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        return new PomeloResponse() {
            protected void write() throws IOException {
                WNPlayer player = (WNPlayer) FinishSweepDemonTowerHandler.this.pak.getPlayer();

                DemonTowerManager manager = player.demonTowerManager;

                DemonTowerHandler.FinishSweepDemonTowerResponse.Builder res = DemonTowerHandler.FinishSweepDemonTowerResponse.newBuilder();


                if (player.moneyManager.getDiamond() < GlobalConfig.SweepPrice) {

                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("DEMON_TOWER_NOT_ENOUGH_DIAMOND"));
                    this.body.writeBytes(res.build().toByteArray());


                    return;
                }

                if (manager.po.sweepEndTime == null) {

                    if (manager.getSweepCountLeft() <= 0) {

                        res.setS2CCode(500);
                        res.setS2CMsg(LangService.getValue("DEMON_TOWER_NOT_ENOUGH_SWEEP_COUNT"));
                        this.body.writeBytes(res.build().toByteArray());

                        return;
                    }
                    player.moneyManager.costDiamond(GlobalConfig.SweepPrice, Const.GOODS_CHANGE_TYPE.DemonTower);
                    manager.po.sweepCountLeft--;
                    manager.FinishSweep();

                } else {


                    player.moneyManager.costDiamond(GlobalConfig.SweepPrice, Const.GOODS_CHANGE_TYPE.DemonTower);
                    manager.FinishSweepWhenSpeeping();
                }


                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


