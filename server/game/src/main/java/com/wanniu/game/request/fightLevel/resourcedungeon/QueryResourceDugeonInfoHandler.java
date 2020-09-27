package com.wanniu.game.request.fightLevel.resourcedungeon;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.area.AreaDataConfig;
import com.wanniu.game.data.DungeonMapCostCO;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.base.MapBase;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.FightLevelsPO;
import com.wanniu.game.request.fightLevel.FightLevelLine;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import pomelo.area.ResourceDungeonHandler;


@GClientEvent("area.resourceDungeonHandler.queryResourceDugeonInfoRequest")
public class QueryResourceDugeonInfoHandler
        extends FightLevelLine {
    public PomeloResponse request(final WNPlayer player) throws Exception {
        return new PomeloResponse() {
            protected void write() throws IOException {
                ResourceDungeonHandler.QueryResourceDugeonInfoResponse.Builder res = ResourceDungeonHandler.QueryResourceDugeonInfoResponse.newBuilder();

                FightLevelsPO fightLevelsPO = player.fightLevelManager.getFightLevelsPo();
                List<ResourceDungeonHandler.ResourceDungeonInfo> list = new ArrayList<>();
                for (DungeonMapCostCO config : GameData.DungeonMapCosts.values()) {
                    MapBase mapProp = AreaDataConfig.getInstance().get(config.mapID);

                    FightLevelsPO.ResourceDungeonPO resourceDungeon = (FightLevelsPO.ResourceDungeonPO) fightLevelsPO.resourceDungeon.get(Integer.valueOf(config.mapID));

                    if (resourceDungeon == null) {
                        resourceDungeon = new FightLevelsPO.ResourceDungeonPO();
                        fightLevelsPO.resourceDungeon.put(Integer.valueOf(config.mapID), resourceDungeon);
                    }


                    ResourceDungeonHandler.ResourceDungeonInfo.Builder info = ResourceDungeonHandler.ResourceDungeonInfo.newBuilder();
                    info.setDungeonId(config.mapID);
                    info.setLastTimes(mapProp.defaultTimes - resourceDungeon.usedTimes + resourceDungeon.buyTimes);
                    info.setBuyTimes(resourceDungeon.buyTimes);
                    info.setCanBuyTimes(GameData.RechargeCosts.size() - resourceDungeon.buyTimes);
                    info.setCanSweep((resourceDungeon.usedTimes > 0));
                    info.setAwardItems(config.showReward);
                    info.setPlayType(config.playType);
                    info.setEnterLevel(config.enterLevel);
                    list.add(info.build());
                }

                res.addAllDungeons(list);
                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


