package com.wanniu.game.request.activity;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.tcp.protocol.Packet;
import com.wanniu.game.activity.DemonTowerManager;
import com.wanniu.game.area.AreaData;
import com.wanniu.game.area.AreaUtil;
import com.wanniu.game.area.DemonTower;
import com.wanniu.game.common.Utils;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.ext.DropListExt;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.DemonTowerHandler;


@GClientEvent("area.demonTowerHandler.startDemonTowerRequest")
public class StartDemonTowerHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final DemonTowerHandler.StartDemonTowerRequest req = DemonTowerHandler.StartDemonTowerRequest.parseFrom(this.pak.getRemaingBytes());
        return new PomeloResponse() {
            protected void write() throws IOException {
                WNPlayer player = (WNPlayer) StartDemonTowerHandler.this.pak.getPlayer();
                int floorId = req.getFloorId();
                DemonTowerManager manager = player.demonTowerManager;
                Out.error(new Object[]{Integer.valueOf(floorId)});
                if (floorId == 0) {
                    floorId = Math.min(manager.po.maxFloor, GameData.DropLists.size());
                }
                DemonTowerHandler.StartDemonTowerResponse.Builder res = DemonTowerHandler.StartDemonTowerResponse.newBuilder();

                if (!GameData.DropLists.containsKey(Integer.valueOf(floorId))) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("PARAM_ERROR"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }
                if (floorId > player.demonTowerManager.po.maxFloor) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("DEMON_TOWER_NOT_OPEN"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }
                if (manager.po.sweepEndTime != null) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("DEMON_TOWER_IS_SWEEPING"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }
                if (manager.po.maxFloor >= GameData.DropLists.size()) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("DEMON_TOWER_IN_TOP"));
                    this.body.writeBytes(res.build().toByteArray());


                    return;
                }


                DropListExt dropListExt = (DropListExt) GameData.DropLists.get(Integer.valueOf(floorId));
                if (dropListExt == null) {
                    Out.error(new Object[]{"参数错误"});
                    return;
                }
                int mapId = dropListExt.mapId;
                DemonTower area = (DemonTower) AreaUtil.createArea(player, Utils.toJSON(new Object[]{"logicServerId",
                        Integer.valueOf(player.getLogicServerId()), "areaId", Integer.valueOf(mapId), "lv", Integer.valueOf(floorId)}));
                AreaData areaData = new AreaData(area.areaId, area.instanceId);
                AreaUtil.changeArea(player, areaData);


                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


