package com.wanniu.game.equip;

import com.wanniu.core.common.IntIntPair;
import com.wanniu.game.bag.WNBag;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.MeltConfigCO;
import com.wanniu.game.data.ext.CombineExt;
import com.wanniu.game.data.ext.EnchantExt;
import com.wanniu.game.data.ext.EquipMakeExt;
import com.wanniu.game.data.ext.SuitConfigExt;
import com.wanniu.game.data.ext.SuitListExt;
import com.wanniu.game.item.ItemUtil;
import com.wanniu.game.player.WNPlayer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pomelo.item.ItemOuterClass;


public class EquipCraftConfig {
    private static EquipCraftConfig instance;

    public static EquipCraftConfig getInstance() {
        if (instance == null) {
            instance = new EquipCraftConfig();
        }
        return instance;
    }


    private List<Integer> refineMagicGroupIds = null;


    private EquipCraftConfig() {
        this.refineMagicGroupIds = new ArrayList<>();
    }


    public CombineExt getCombineProp(int destId) {
        return (CombineExt) GameData.Combines.get(Integer.valueOf(destId));
    }


    public ItemOuterClass.Combine getCombineFormula(CombineExt prop) {
        ItemOuterClass.Combine.Builder data = ItemOuterClass.Combine.newBuilder();
        data.setProduct(ItemUtil.getMiniItemData(prop.destCode, 1, null));

        List<ItemOuterClass.MiniItem> materials = new ArrayList<>();
        for (WNBag.SimpleItemInfo componet : prop.material) {

            ItemOuterClass.MiniItem tmp = ItemUtil.getMiniItemData(componet.itemCode, componet.itemNum, null).build();
            if (tmp != null) {
                materials.add(tmp);
            }
        }
        data.addAllMaterials(materials);
        data.setGold(prop.costGold);

        return data.build();
    }


    public EnchantExt getEnchantConfig(int enClass, int enLevel) {
        List<EnchantExt> list = GameData.findEnchants(t ->
                (t.enClass == enClass && t.enLevel == enLevel));

        return (list.size() > 0) ? list.get(0) : null;
    }


    public int getMaxStrengthLevel() {
        return GameData.Enchants.values().size();
    }


    public List<Integer> getRefineMagicGroupIds() {
        return this.refineMagicGroupIds;
    }


    public EquipMakeExt getEquipMakePropByCode(String targetCode) {
        List<EquipMakeExt> list = GameData.findEquipMakes(t -> t.targetCode.equals(targetCode));


        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }


    public MeltConfigCO getMeltProp(int meltLevel, int quality) {
        Collection<MeltConfigCO> col = GameData.MeltConfigs.values();
        for (MeltConfigCO cfg : col) {
            if (cfg.meltLevel == meltLevel && cfg.equipQColor == quality) {
                return cfg;
            }
        }
        return null;
    }


    public List<IntIntPair> getValidSuits(WNPlayer player) {
        List<IntIntPair> results = new ArrayList<>();
        for (SuitListExt config : GameData.SuitLists.values()) {
            if (config.isValid == 0) {
                continue;
            }
            if (player.player.level < config.level) {
                continue;
            }
            List<String> suitCodes = config.getContaintsCode(player.equipManager.equips);
            if (suitCodes.size() == 0) {
                continue;
            }
            results.add(new IntIntPair(config.suitID, suitCodes.size()));
        }
        return results;
    }


    public Map<String, Integer> getSuitAtts(List<IntIntPair> configs) {
        Map<String, Integer> results = new HashMap<>();
        for (SuitConfigExt config : GameData.SuitConfigs.values()) {
            for (IntIntPair idCount : configs) {
                if (config.suitID == idCount.first && config.partReqCount <= idCount.second) {
                    if (results.containsKey(config._prop)) {
                        results.put(config._prop, Integer.valueOf(((Integer) results.get(config._prop)).intValue() + config.min));
                        continue;
                    }
                    results.put(config._prop, Integer.valueOf(config.min));
                }
            }
        }

        return results;
    }
}


