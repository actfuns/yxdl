package com.wanniu.game.request.activity;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.tcp.protocol.Packet;
import com.wanniu.game.activity.DemonTowerManager;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;
import java.util.HashMap;

import pomelo.area.DemonTowerHandler;


@GClientEvent("area.demonTowerHandler.getDemonTowerSweepInfoRequest")
public class GetDemonTowerSweepInfoHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        return new PomeloResponse() {
            protected void write() throws IOException {
                WNPlayer player = (WNPlayer) GetDemonTowerSweepInfoHandler.this.pak.getPlayer();

                DemonTowerManager manager = player.demonTowerManager;

                DemonTowerHandler.GetDemonTowerSweepInfoResponse.Builder res = DemonTowerHandler.GetDemonTowerSweepInfoResponse.newBuilder();


                HashMap<String, Integer> rewardMap = player.demonTowerManager.ComputeSweepRewards();
                if (rewardMap != null) {
                    for (String code : rewardMap.keySet()) {

                        DemonTowerHandler.DemontTowerRewardItem.Builder itemBuilder = DemonTowerHandler.DemontTowerRewardItem.newBuilder();
                        itemBuilder.setCode(code);
                        itemBuilder.setValue(((Integer) rewardMap.get(code)).intValue());
                        res.addItemView(itemBuilder.build());
                    }
                }


                boolean isSweeping = !(manager.po.sweepEndTime == null);
                if (!isSweeping) {
                    res.setSweepTime(GlobalConfig.SweepTime * (manager.po.maxFloor - 1));
                } else {
                    res.setSweepTime(manager.GetSecondToEndTime());
                }
                res.setDiamondCost(GlobalConfig.SweepPrice);
                res.setFloor(manager.po.maxFloor);
                res.setIsSweeping(isSweeping);


                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


