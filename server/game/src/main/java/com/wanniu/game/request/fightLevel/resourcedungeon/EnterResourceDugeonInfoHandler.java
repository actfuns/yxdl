package com.wanniu.game.request.fightLevel.resourcedungeon;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.GWorld;
import com.wanniu.game.area.AreaDataConfig;
import com.wanniu.game.area.AreaUtil;
import com.wanniu.game.data.DungeonMapCostCO;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.base.MapBase;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.FightLevelsPO;
import com.wanniu.game.request.fightLevel.FightLevelLine;

import java.io.IOException;

import pomelo.area.ResourceDungeonHandler;


@GClientEvent("area.resourceDungeonHandler.enterResourceDugeonInfoRequest")
public class EnterResourceDugeonInfoHandler
        extends FightLevelLine {
    public PomeloResponse request(final WNPlayer player) throws Exception {
        ResourceDungeonHandler.EnterResourceDugeonInfoRequest req = ResourceDungeonHandler.EnterResourceDugeonInfoRequest.parseFrom(this.pak.getRemaingBytes());

        final int dungeonId = req.getDungeonId();

        return new PomeloResponse() {
            protected void write() throws IOException {
                ResourceDungeonHandler.EnterResourceDugeonInfoResponse.Builder res = ResourceDungeonHandler.EnterResourceDugeonInfoResponse.newBuilder();

                FightLevelsPO fightLevelsPO = player.fightLevelManager.getFightLevelsPo();

                fightLevelsPO.doubleReward = null;

                MapBase mapProp = AreaDataConfig.getInstance().get(dungeonId);

                FightLevelsPO.ResourceDungeonPO resourceDungeon = (FightLevelsPO.ResourceDungeonPO) fightLevelsPO.resourceDungeon.get(Integer.valueOf(dungeonId));

                if (resourceDungeon == null) {
                    resourceDungeon = new FightLevelsPO.ResourceDungeonPO();
                    fightLevelsPO.resourceDungeon.put(Integer.valueOf(dungeonId), resourceDungeon);
                }

                if (resourceDungeon.usedTimes >= mapProp.defaultTimes + resourceDungeon.buyTimes) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("SOLO_ENTER_TIMES_LIMIT"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }
                DungeonMapCostCO dungeonMapCostCO = (DungeonMapCostCO) GameData.DungeonMapCosts.get(Integer.valueOf(dungeonId));
                if (player.getLevel() < dungeonMapCostCO.enterLevel) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("RESOURCE_DUNGEON_LEVEL_NEED"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                resourceDungeon.entering = true;

                GWorld.getInstance().ansycExec(() -> AreaUtil.enterArea(player, dungeonId));


                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


