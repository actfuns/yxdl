package com.wanniu.game.request.activity;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.tcp.protocol.Packet;
import com.wanniu.game.activity.DemonTowerManager;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.ext.DropListExt;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.Common;
import pomelo.area.DemonTowerHandler;


@GClientEvent("area.demonTowerHandler.getDemonTowerInfoRequest")
public class GetDemonTowerInfoHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final DemonTowerHandler.GetDemonTowerInfoRequest req = DemonTowerHandler.GetDemonTowerInfoRequest.parseFrom(this.pak.getRemaingBytes());

        return new PomeloResponse() {
            protected void write() throws IOException {
                WNPlayer player = (WNPlayer) GetDemonTowerInfoHandler.this.pak.getPlayer();
                int floorId = req.getFloorId();
                DemonTowerManager manager = player.demonTowerManager;

                DemonTowerHandler.GetDemonTowerInfoResponse.Builder res = DemonTowerHandler.GetDemonTowerInfoResponse.newBuilder();
                if (floorId == 0) {
                    floorId = Math.min(manager.po.maxFloor, GameData.DropLists.size());
                }


                res.setMaxFloor(Math.min(manager.po.maxFloor, GameData.DropLists.size()));


                Common.DemonTowerFloorInfo.Builder floorInfoBuilder = manager.getFloorInfoBuilder(floorId);

                res.setDemonTowerFloorInfo(floorInfoBuilder);

                DropListExt dropListExt = (DropListExt) GameData.DropLists.get(Integer.valueOf(floorId));
                res.setFcValue(dropListExt.fcValue);
                res.setSweepCountLeft(manager.po.sweepCountLeft);
                res.setSweepCountMax(GlobalConfig.ResetNum);


                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


