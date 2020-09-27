package com.wanniu.game.request.fightLevel;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.common.msg.ErrorResponse;
import com.wanniu.game.data.DungeonMapCO;
import com.wanniu.game.data.GameData;
import com.wanniu.game.fightLevel.FightLevelManager;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import pomelo.area.FightLevelHandler;


@GClientEvent("area.fightLevelHandler.fubenListRequest")
public class FubenListHandler
        extends FightLevelLine {
    public PomeloResponse request(final WNPlayer player) throws Exception {
        FightLevelHandler.FubenListRequest req = FightLevelHandler.FubenListRequest.parseFrom(this.pak.getRemaingBytes());
        int mapId = req.getMapId();
        final int mapType = req.getType();
        final DungeonMapCO map = (DungeonMapCO) GameData.DungeonMaps.get(Integer.valueOf(mapId));
        if (map == null) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("DUNGEON_NULL"));
        }

        return new PomeloResponse() {
            protected void write() throws IOException {
                FightLevelHandler.FubenListResponse.Builder res = FightLevelHandler.FubenListResponse.newBuilder();

                FightLevelManager fightLevelManager = player.fightLevelManager;
                List<DungeonMapCO> dungeonMaps = GameData.findDungeonMaps(t ->
                        (t.templateID == map.templateID && t.dungeonShow == 1 && t.type == mapType));

                Collections.sort(dungeonMaps, new Comparator<DungeonMapCO>() {
                    public int compare(DungeonMapCO o1, DungeonMapCO o2) {
                        return o1.hardModel - o2.hardModel;
                    }
                });
                dungeonMaps.forEach(t -> {
                    FightLevelHandler.FubenInfo.Builder dungeonInfo = FightLevelHandler.FubenInfo.newBuilder();

                    dungeonInfo.setMapId(t.mapID);

                    dungeonInfo.setRemainTimes((player.getLevel() >= t.reqLevel + 30) ? 0 : Math.max(0, 3 + fightLevelManager.getTodayBuy(t.templateID) - fightLevelManager.getTodayFinish(t.templateID)));

                    dungeonInfo.addAllAwardItems(fightLevelManager.getDropItems(t.bonusViewTC));

                    res.addS2CList(dungeonInfo);
                });
                res.setS2CHard(0);
                res.setS2CAcross(0);
                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


