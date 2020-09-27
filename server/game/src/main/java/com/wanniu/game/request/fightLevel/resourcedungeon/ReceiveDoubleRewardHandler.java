package com.wanniu.game.request.fightLevel.resourcedungeon;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.common.Const;
import com.wanniu.game.data.DungeonMapCostCO;
import com.wanniu.game.data.GameData;
import com.wanniu.game.item.po.PlayerItemPO;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.FightLevelsPO;
import com.wanniu.game.request.fightLevel.FightLevelLine;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import pomelo.Common;
import pomelo.area.ResourceDungeonHandler;


@GClientEvent("area.resourceDungeonHandler.receiveDoubleRewardRequest")
public class ReceiveDoubleRewardHandler
        extends FightLevelLine {
    public PomeloResponse request(final WNPlayer player) throws Exception {
        ResourceDungeonHandler.ReceiveDoubleRewardRequest req = ResourceDungeonHandler.ReceiveDoubleRewardRequest.parseFrom(this.pak.getRemaingBytes());

        final int dungeonId = req.getDungeonId();

        return new PomeloResponse() {
            protected void write() throws IOException {
                ResourceDungeonHandler.ReceiveDoubleRewardResponse.Builder res = ResourceDungeonHandler.ReceiveDoubleRewardResponse.newBuilder();


                DungeonMapCostCO config = (DungeonMapCostCO) GameData.DungeonMapCosts.get(Integer.valueOf(dungeonId));
                FightLevelsPO fightLevelsPO = player.fightLevelManager.getFightLevelsPo();


                if (config.isDoubleBonus == 0) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("PARAM_ERROR"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }

                if (fightLevelsPO.doubleReward == null) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("DUNGEON_NOT_DOUBLE_REWARD"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }
                if (player.player.diamond < config.bounsCostDiamond) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("DIAMAND_NOT_ENOUGH"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }

                List<Common.KeyValueStruct> changeItems = new ArrayList<>();


                if (fightLevelsPO.doubleReward.doubleVirtualItems != null) {
                    for (String key : fightLevelsPO.doubleReward.doubleVirtualItems.keySet()) {
                        int value = ((Integer) fightLevelsPO.doubleReward.doubleVirtualItems.get(key)).intValue();
                        Common.KeyValueStruct.Builder items = Common.KeyValueStruct.newBuilder();
                        items.setKey(key);
                        items.setValue(String.valueOf(value));
                        changeItems.add(items.build());

                        if (key.equals("exp")) {
                            player.addExp(value, Const.GOODS_CHANGE_TYPE.resource_dungeon_award);
                            continue;
                        }
                        if (key.equals("gold")) {
                            player.moneyManager.addGold(value, Const.GOODS_CHANGE_TYPE.resource_dungeon_award);
                        }
                    }
                }
                if (fightLevelsPO.doubleReward.doubleItems != null && fightLevelsPO.doubleReward.doubleItems
                        .size() > 0) {
                    for (PlayerItemPO it : fightLevelsPO.doubleReward.doubleItems) {
                        Common.KeyValueStruct.Builder items = Common.KeyValueStruct.newBuilder();
                        items.setKey(it.code);
                        items.setValue(String.valueOf(it.groupCount));
                        changeItems.add(items.build());
                    }
                    player.bag.addEntityItemsPO(fightLevelsPO.doubleReward.doubleItems, Const.GOODS_CHANGE_TYPE.resource_dungeon_award);
                }


                player.moneyManager.costDiamond(config.bounsCostDiamond, Const.GOODS_CHANGE_TYPE.resource_dungeon_cost_diamond, changeItems);


                fightLevelsPO.doubleReward = null;

                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


