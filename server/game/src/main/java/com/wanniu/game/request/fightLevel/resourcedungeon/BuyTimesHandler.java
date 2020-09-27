package com.wanniu.game.request.fightLevel.resourcedungeon;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.common.Const;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.RechargeCostCO;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.FightLevelsPO;
import com.wanniu.game.request.fightLevel.FightLevelLine;

import java.io.IOException;

import pomelo.area.ResourceDungeonHandler;


@GClientEvent("area.resourceDungeonHandler.buyTimesRequest")
public class BuyTimesHandler
        extends FightLevelLine {
    public PomeloResponse request(final WNPlayer player) throws Exception {
        ResourceDungeonHandler.BuyTimesRequest req = ResourceDungeonHandler.BuyTimesRequest.parseFrom(this.pak.getRemaingBytes());

        final int dungeonId = req.getDungeonId();

        return new PomeloResponse() {
            protected void write() throws IOException {
                ResourceDungeonHandler.BuyTimesResponse.Builder res = ResourceDungeonHandler.BuyTimesResponse.newBuilder();
                FightLevelsPO fightLevelsPO = player.fightLevelManager.getFightLevelsPo();
                FightLevelsPO.ResourceDungeonPO resourceDungeon = (FightLevelsPO.ResourceDungeonPO) fightLevelsPO.resourceDungeon.get(Integer.valueOf(dungeonId));
                if (resourceDungeon == null) {
                    resourceDungeon = new FightLevelsPO.ResourceDungeonPO();
                    fightLevelsPO.resourceDungeon.put(Integer.valueOf(dungeonId), resourceDungeon);
                }


                RechargeCostCO config = (RechargeCostCO) GameData.RechargeCosts.get(Integer.valueOf(resourceDungeon.buyTimes + 1));
                if (config == null) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("SOLO_BUY_TIMES_LIMIT"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }

                if (!player.moneyManager.costTicketAndDiamond(config.costNum, Const.GOODS_CHANGE_TYPE.resource_dungeon_buy_times).isSuccess()) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("TICKET_NOT_ENOUGH"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }

                resourceDungeon.buyTimes++;

                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


