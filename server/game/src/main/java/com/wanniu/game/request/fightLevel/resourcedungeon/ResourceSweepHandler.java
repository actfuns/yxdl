package com.wanniu.game.request.fightLevel.resourcedungeon;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.logfs.Out;
import com.wanniu.game.area.AreaDataConfig;
import com.wanniu.game.common.Const;
import com.wanniu.game.data.DungeonMapCostCO;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.ResRewardCO;
import com.wanniu.game.data.base.MapBase;
import com.wanniu.game.item.ItemUtil;
import com.wanniu.game.item.NormalItem;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.FightLevelsPO;
import com.wanniu.game.request.fightLevel.FightLevelLine;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import pomelo.area.ResourceDungeonHandler;
import pomelo.item.ItemOuterClass;


@GClientEvent("area.resourceDungeonHandler.resourceSweepRequest")
public class ResourceSweepHandler
        extends FightLevelLine {
    public PomeloResponse request(final WNPlayer player) throws Exception {
        ResourceDungeonHandler.ResourceSweepRequest req = ResourceDungeonHandler.ResourceSweepRequest.parseFrom(this.pak.getRemaingBytes());
        final int dungeonId = req.getDungeonId();
        return new PomeloResponse() {
            protected void write() throws IOException {
                ResourceDungeonHandler.ResourceSweepResponse.Builder res = ResourceDungeonHandler.ResourceSweepResponse.newBuilder();


                MapBase mapProp = AreaDataConfig.getInstance().get(dungeonId);
                FightLevelsPO fightLevelsPO = player.fightLevelManager.getFightLevelsPo();
                FightLevelsPO.ResourceDungeonPO resourceDungeon = (FightLevelsPO.ResourceDungeonPO) fightLevelsPO.resourceDungeon.get(Integer.valueOf(dungeonId));
                if (resourceDungeon == null) {
                    resourceDungeon = new FightLevelsPO.ResourceDungeonPO();
                    fightLevelsPO.resourceDungeon.put(Integer.valueOf(dungeonId), resourceDungeon);
                }


                if (resourceDungeon.usedTimes < 1) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("SOLO_USE_SWEEP_BY_ONE"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }
                if (resourceDungeon.usedTimes >= mapProp.defaultTimes + resourceDungeon.buyTimes) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("SOLO_ENTER_TIMES_LIMIT"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }

                ResRewardCO config = (ResRewardCO) GameData.ResRewards.get(Integer.valueOf(player.getLevel()));
                if (config == null) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("SOLO_REWARD_NOT_EXIST"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }

                resourceDungeon.usedTimes++;


                DungeonMapCostCO dungeonMapCostCO = (DungeonMapCostCO) GameData.DungeonMapCosts.get(Integer.valueOf(dungeonId));
                int difficult = mapProp.hardModel;
                String saodangReward = null;
                try {
                    Object saodangRewardObj = ResRewardCO.class.getField("saodangReward" + String.valueOf(dungeonMapCostCO.playType) + String.valueOf(difficult)).get(config);
                    saodangReward = String.valueOf(saodangRewardObj);
                } catch (Exception e) {
                    e.printStackTrace();


                    return;
                }


                if (saodangReward.isEmpty()) {
                    System.out.println("empty::::::::::::::::::::::::::::::::::::::::::::;");
                    Out.error(new Object[]{"资源副本扫荡奖励未配置 playerId=", this.val$player.getId(), ",Name=", this.val$player.getName(), ",dungeonId=",
                            Integer.valueOf(this.val$dungeonId)});
                } else {
                    System.out.println(saodangReward + ":::::::::code:::::::::::::::::::::::::::::::::::::::::::::::::::");

                    List<NormalItem> list_items = new ArrayList<>();

                    switch (dungeonMapCostCO.playType) {
                        case 1:
                            switch (difficult) {
                                case 1:
                                    list_items = ItemUtil.createItemsByTcCode("JxBx-SD1");
                                    break;
                                case 2:
                                    list_items = ItemUtil.createItemsByTcCode("JxBx-SD2");
                                    break;
                                case 3:
                                    list_items = ItemUtil.createItemsByTcCode("JxBx-SD3");
                                    break;
                            }

                            break;

                        case 2:
                            switch (difficult) {
                                case 1:
                                    list_items = ItemUtil.createItemsByTcCode("ScBx-SD1");
                                    break;
                                case 2:
                                    list_items = ItemUtil.createItemsByTcCode("ScBx-SD2");
                                    break;
                                case 3:
                                    list_items = ItemUtil.createItemsByTcCode("ScBx-SD3");
                                    break;
                            }

                            break;

                        case 3:
                            switch (difficult) {
                                case 1:
                                    list_items = ItemUtil.createItemsByTcCode("HyBx-SD1");
                                    break;
                                case 2:
                                    list_items = ItemUtil.createItemsByTcCode("HyBx-SD2");
                                    break;
                                case 3:
                                    list_items = ItemUtil.createItemsByTcCode("HyBx-SD3");
                                    break;
                            }


                            break;
                    }


                    System.out.println(list_items + ":::::::::::::::::::::::::list_items:::::::::::::::::::::::::::::::::::");
                    player.bag.addCodeItemMail(list_items, null, Const.GOODS_CHANGE_TYPE.resource_dungeon_sweep, "Bag_full_common");

                    System.out.println(":::::::::::::::::::::::::接发给:::::::::::::::::::::::::::::::::::");

                    List<ItemOuterClass.MiniItem> list_award = new ArrayList<>();
                    System.out.println();
                    for (NormalItem item : list_items) {
                        System.out.println("::::::::::::::::::item:::::::::::::::::::::::::::::::");
                        list_award.add(item.toJSON4MiniItem());
                    }

                    res.addAllAwardItems(list_award);
                }
                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


