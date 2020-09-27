package com.wanniu.game.request.fightLevel;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.logfs.Out;
import com.wanniu.game.area.Area;
import com.wanniu.game.area.AreaData;
import com.wanniu.game.area.AreaUtil;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.msg.ErrorResponse;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.FightLevelHandler;


@GClientEvent("area.fightLevelHandler.leaveDungeonRequest")
public class LeaveDungeonHandler
        extends FightLevelLine {
    public PomeloResponse request(final WNPlayer player) throws Exception {
        final Area area = player.getArea();

        if (area == null) {
            AreaUtil.dispatchByAreaId(player, new AreaData(player.playerTempData.historyAreaId, player.playerTempData.historyX, player.playerTempData.historyY), null);


            Out.warn(new Object[]{"chuxianle1!!!playerId=", player.getId(), "area null"});
            return (PomeloResponse) new ErrorResponse(LangService.getValue("DATA_ERR"));
        }
        if (area.sceneType == Const.SCENE_TYPE.NORMAL.getValue()) {
            Out.warn(new Object[]{"chuxianle2!!!playerId=", player.getId(), "areaId=", Integer.valueOf(area.areaId), ",instanceId=", area.instanceId});
            return (PomeloResponse) new ErrorResponse(LangService.getValue("DATA_ERR"));
        }

        return new PomeloResponse() {
            protected void write() throws IOException {
                FightLevelHandler.LeaveDungeonResponse.Builder res = FightLevelHandler.LeaveDungeonResponse.newBuilder();
                String data = null;
                if (area.sceneType == Const.SCENE_TYPE.GUILD_FORT_PVE.getValue()) {
                    player.guildFortManager.handleLeaveArea(area.areaId);
                }

                if (area.hasHighQualityItem()) {
                    player.puchFuncGoToPickItem();
                    res.setS2CCode(200);
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                data = player.fightLevelManager.leaveDungeon(player, area);

                if (data == null) {
                    res.setS2CCode(200);
                } else {
                    res.setS2CCode(500);
                    res.setS2CMsg(data);
                }
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


