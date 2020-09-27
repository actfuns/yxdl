package com.wanniu.game.player;

import Xmds.PlayerPKInfoData;
import com.alibaba.fastjson.JSON;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.RandomUtil;
import com.wanniu.game.area.Area;
import com.wanniu.game.area.AreaDataConfig;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.Utils;
import com.wanniu.game.data.base.DItemEquipBase;
import com.wanniu.game.data.base.MapBase;
import com.wanniu.game.equip.NormalEquip;
import com.wanniu.game.item.ItemConfig;
import com.wanniu.game.item.ItemUtil;
import com.wanniu.game.item.NormalItem;
import com.wanniu.game.poes.PlayerPKDataPO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class PkRuleManager {
    public WNPlayer player;
    public PlayerPKDataPO pkData;

    public PkRuleManager(WNPlayer player, PlayerPKDataPO pkData) {
        this.player = player;
        this.pkData = pkData;
    }


    public Object[] dropRandItemFromBag() {
        Object[] item = this.player.bag.randomGetItem(GlobalConfig.pkDrop, GlobalConfig.Mysterious_DropItemsMaxNum);
        return item;
    }


    public void mijingDrop(List<NormalItem> finalResultData) {
        boolean hasRate = RandomUtil.hasHitRate(10000, GlobalConfig.Mysterious_DropItemsPro);
        if (hasRate) {
            Object[] dropItem = dropRandItemFromBag();
            if (dropItem != null) {
                Out.info(new Object[]{"pk dead drop,playerId=", (this.player == null) ? "" : this.player.getId(), ",code=", dropItem[0]});
                finalResultData.addAll(ItemUtil.createItemsByItemCode(dropItem[0].toString(), ((Integer) dropItem[1]).intValue()));
            }
        }
    }

    public List<NormalItem> dropItemByKilled(int pkValue, Area area) {
        List<NormalItem> finalResultData = new ArrayList<>(2);
        if (area.sceneType == Const.SCENE_TYPE.ILLUSION_2.getValue()) {
            mijingDrop(finalResultData);
            return finalResultData;
        }

        int rand = RandomUtil.getInt(10000);
        if (rand < GlobalConfig.PK_Killed_LostBagItem_Chance) {
            int cost = RandomUtil.getInt(100, 1000);
            int dropMoneyCount = this.player.moneyManager.costGoldOnPk(cost, Const.GOODS_CHANGE_TYPE.hitUser);
            if (dropMoneyCount > 0) {
                List<NormalItem> itemList = ItemUtil.createItemsByItemCode("gold", dropMoneyCount);

                if (itemList != null && !itemList.isEmpty()) {
                    NormalItem it = itemList.get(0);
                    DItemEquipBase base = ItemConfig.getInstance().getItemProp("goldpkdrop");
                    it.prop = it.prop.copy();
                    it.prop.icon = base.icon;
                    it.prop.name = String.valueOf(dropMoneyCount);
                    finalResultData.add(it);
                }
            }
        }
        if (pkValue <= 0) {
            return finalResultData;
        }

        Out.debug(new Object[]{Integer.valueOf(pkValue), " : ", Integer.valueOf(GlobalConfig.PK_Killed_LostEquip_PKValue)});
        if (pkValue >= GlobalConfig.PK_Killed_LostEquip_PKValue) {
            int rate = Math.min(GlobalConfig.PK_Killed_LostEquip_MaxRate, pkValue * 100 / GlobalConfig.PK_Killed_LostEquip_Denominator);
            Out.debug(new Object[]{"rate : ", Integer.valueOf(rate)});
            if (Utils.randomPercent(rate)) {
                Map<Integer, NormalEquip> equips = this.player.equipManager.equips;
                List<Integer> dropEquipPoss = new ArrayList<>(equips.size());
                for (Iterator<Integer> iterator = equips.keySet().iterator(); iterator.hasNext(); ) {
                    int pos = ((Integer) iterator.next()).intValue();
                    if (GlobalConfig.PK_EXCEPT_TYPES.indexOf(Integer.valueOf(pos)) == -1) {
                        dropEquipPoss.add(Integer.valueOf(pos));
                    }
                }

                if (dropEquipPoss.size() > 0) {
                    int randomIndex = RandomUtil.getIndex(dropEquipPoss.size());
                    int randomPos = ((Integer) dropEquipPoss.get(randomIndex)).intValue();
                    NormalEquip randomBodyData = this.player.equipManager.getEquipment(randomPos);
                    if (this.player.equipManager.DropEquipAndReturn(randomPos)) {
                        finalResultData.add(randomBodyData);
                    }
                }
            }
        }

        for (int i = 0; i < GlobalConfig.PK_Killed_LostBagItem_MaxCount; i++) {
            int rand2 = RandomUtil.getInt(10000);
            Out.debug(new Object[]{Integer.valueOf(rand2), " < ", Integer.valueOf(GlobalConfig.PK_Killed_LostBagItem_Chance)});
            if (rand2 < GlobalConfig.PK_Killed_LostBagItem_Chance) {
                NormalItem resultData = this.player.bag.randomGetItem();

                if (resultData != null) {
                    finalResultData.add(resultData);
                }
            }
        }
        return finalResultData;
    }

    public int getPkValue() {
        String _result = this.player.getXmdsManager().getPlayerPKInfoData(this.player.getId());
        PlayerPKInfoData result = (PlayerPKInfoData) JSON.parseObject(_result, PlayerPKInfoData.class);
        this.pkData.pkValue = result.pkValue;
        return result.pkValue;
    }

    public Map<String, Object> getPkDataToBattleJson() {
        Map<String, Object> data = new HashMap<>();
        data.put("mode", Integer.valueOf(this.pkData.pkModel));
        data.put("value", Integer.valueOf(this.pkData.pkValue));
        data.put("level", Integer.valueOf(this.pkData.pkLevel));


        MapBase sceneProp = AreaDataConfig.getInstance().get(this.player.getAreaId());
        if (sceneProp != null) {
            if (sceneProp.changePKtype == 0) {
                data.put("mode", Integer.valueOf(sceneProp.pktype));
            } else {
                this.pkData.pkModel = this.pkData.historyPkModel;
                data.put("mode", Integer.valueOf(this.pkData.pkModel));
            }
        }
        return data;
    }


    public void setPkModel(int newPkModel) {
        if (this.pkData.pkModel != newPkModel) {
            this.pkData.pkModel = newPkModel;
            this.player.getXmdsManager().refreshPlayerPKMode(this.player.getId(), this.pkData.pkModel);
        }
    }

    public void setHistoryPkModel() {
        this.pkData.historyPkModel = this.pkData.pkModel;
    }

    public void onExitGuild() {
        if (this.pkData.pkModel == Const.PkModel.Guild.value) {
            setPkModel(Const.PkModel.Peace.value);
        }
    }

    public void onExitTeam() {
        if (this.pkData.pkModel == Const.PkModel.Team.value) {
            setPkModel(Const.PkModel.Peace.value);
        }
    }

    public int getPkValueData() {
        return this.pkData.pkValue;
    }
}


