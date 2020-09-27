package com.wanniu.game.item;

import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.StringUtil;
import com.wanniu.game.data.BeforeFilterCO;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.MiscCO;
import com.wanniu.game.data.PlantingCO;
import com.wanniu.game.data.base.DEquipBase;
import com.wanniu.game.data.base.DItemBase;
import com.wanniu.game.data.base.DItemEquipBase;
import com.wanniu.game.data.ext.EquipSockExt;
import com.wanniu.game.data.ext.ItemIdConfigExt;
import com.wanniu.game.data.ext.ItemTypeConfigExt;
import com.wanniu.game.data.ext.ReBuildExt;
import com.wanniu.game.data.ext.TreasureClassExt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ItemConfig {
    private Map<String, DItemBase> itemTemplates = new HashMap<>();


    private Map<String, DEquipBase> equipTemplates = new HashMap<>();


    private Map<String, List<Integer>> gemPos = new HashMap<>();


    public Map<String, BeforeFilterCO> tcs = null;


    public Map<Integer, Map<Integer, ReBuildExt>> rebuildMap = null;


    public static Map<String, MiscCO> seedMiscMap = null;

    public static Map<String, MiscCO> productMiscMap = null;

    public static Map<String, PlantingCO> plantingMap = null;

    public static ItemConfig getInstance() {
        return Holder.instance;
    }


    private static final class Holder {
        public static final ItemConfig instance = new ItemConfig();
    }


    public void loadScript() {
        this.itemTemplates.putAll(GameData.Jewels);
        this.itemTemplates.putAll(GameData.RideItems);
        this.itemTemplates.putAll(GameData.PetItems);
        this.itemTemplates.putAll(GameData.Chests);
        this.itemTemplates.putAll(GameData.Potions);
        this.itemTemplates.putAll(GameData.Mates);
        this.itemTemplates.putAll(GameData.Miscs);
        this.itemTemplates.putAll(GameData.Virtuals);
        this.itemTemplates.putAll(GameData.Ranks);
        this.itemTemplates.putAll(GameData.Quests);
        this.itemTemplates.putAll(GameData.Actives);
        this.itemTemplates.putAll(GameData.FashionItems);


        this.equipTemplates.putAll(GameData.NormalEquips);
        this.equipTemplates.putAll(GameData.BlueEquips);
        this.equipTemplates.putAll(GameData.PurpleEquips);
        this.equipTemplates.putAll(GameData.LegendEquips);
        this.equipTemplates.putAll(GameData.SuitEquips);
        this.equipTemplates.putAll(GameData.RideEquips);
        this.equipTemplates.putAll(GameData.UniqueEquips);


        for (EquipSockExt sock : GameData.EquipSocks.values()) {
            for (String gem : sock.typeList) {
                List<Integer> poses = this.gemPos.get(gem);
                if (poses == null) {
                    poses = new ArrayList<>();
                    this.gemPos.put(gem, poses);
                }

                if (!poses.contains(Integer.valueOf(sock.typeID))) {
                    poses.add(Integer.valueOf(sock.typeID));
                }
            }
        }


        this.tcs = new HashMap<>();
        for (BeforeFilterCO filter : GameData.BeforeFilters.values()) {
            if (filter.dynamicLv.indexOf("~") != -1) {
                String[] lvZones = filter.dynamicLv.split(",");
                for (String lvZone : lvZones) {
                    String[] lvs = lvZone.split("~");
                    if (lvs.length == 2) {
                        int min = Integer.parseInt(lvs[0]);
                        int max = Integer.parseInt(lvs[1]);
                        for (int i = min; i <= max; i++) {
                            this.tcs.put(filter.tcCode + i, filter);
                        }
                    } else {
                        Out.error(new Object[]{"BeforeFilterCO.dynamicLv 格式错误：~号分隔必须有2个level数字"});
                    }
                }
                continue;
            }
            this.tcs.put(filter.tcCode + filter.dynamicLv, filter);
        }


        this.rebuildMap = new HashMap<>();
        for (ReBuildExt reBuildExt : GameData.ReBuilds.values()) {
            if (!this.rebuildMap.containsKey(Integer.valueOf(reBuildExt.level)))
                this.rebuildMap.put(Integer.valueOf(reBuildExt.level), new HashMap<>());
            if (!((Map) this.rebuildMap.get(Integer.valueOf(reBuildExt.level))).containsKey(Integer.valueOf(reBuildExt.lockNum))) {
                ((Map<Integer, ReBuildExt>) this.rebuildMap.get(Integer.valueOf(reBuildExt.level))).put(Integer.valueOf(reBuildExt.lockNum), reBuildExt);
            }
        }

        seedMiscMap = new HashMap<>();
        for (MiscCO miscCO : GameData.Miscs.values()) {
            if (miscCO.code.length() == 6) {
                String strs = miscCO.code.substring(0, 4);
                if (strs.equals("seed"))
                    seedMiscMap.put(miscCO.code, miscCO);
            }
        }
        productMiscMap = new HashMap<>();
        for (MiscCO miscCO : GameData.Miscs.values()) {
            if (miscCO.code.length() == 9) {
                String strs = miscCO.code.substring(0, 7);
                if (strs.equals("product"))
                    productMiscMap.put(miscCO.code, miscCO);
            }
        }
        plantingMap = new HashMap<>();
        for (PlantingCO plantingCO : GameData.Plantings.values()) {
            plantingMap.put(plantingCO.code, plantingCO);
        }
    }

    public Map<String, DItemBase> getItemTemplates() {
        return this.itemTemplates;
    }

    public Map<String, DEquipBase> getEquipTemplates() {
        return this.equipTemplates;
    }

    public DEquipBase getEquipProp(String templateCode) {
        DEquipBase result = this.equipTemplates.get(templateCode);
        if (result == null) {
            Out.error(new Object[]{String.format("Item equipTemplate [%s] is not found.", new Object[]{templateCode})});
        }
        return result;
    }

    public DItemEquipBase getItemPropByName(String name) {
        for (DItemEquipBase result : this.itemTemplates.values()) {
            if (result.name.equals(name)) {
                return result;
            }
        }
        for (DItemEquipBase result : this.equipTemplates.values()) {
            if (result.name.equals(name)) {
                return result;
            }
        }
        return null;
    }


    public DItemEquipBase getItemProp(String templateCode) {
        DItemEquipBase result = (DItemEquipBase) this.itemTemplates.get(templateCode);
        if (result == null) {
            result = (DItemEquipBase) this.equipTemplates.get(templateCode);
        }
        if (result == null) {
            Out.error(new Object[]{getClass(), String.format("Item template [%s] is not found.", new Object[]{templateCode})});
        }
        return result;
    }


    public List<DEquipBase> getEquipProps(int qColor, int tcLevel, int itemSecondType) {
        List<DEquipBase> list = new ArrayList<>();
        Collection<DEquipBase> collection = this.equipTemplates.values();
        for (DEquipBase template : collection) {
            if (template.qcolor == qColor && template.tcLevel == tcLevel && getSecondType(template.type) == itemSecondType && template.isValid != 0) {
                list.add(template);
            }
        }
        return list;
    }


    public ItemIdConfigExt getIdConfig(String itemType) {
        return (ItemIdConfigExt) GameData.ItemIdConfigs.get(itemType);
    }


    public ItemTypeConfigExt getTypeConfig(String subType) {
        for (ItemTypeConfigExt cfg : GameData.ItemTypeConfigs.values()) {
            for (String component : cfg.subTypes) {
                if (!StringUtil.isEmpty(component) && component.equalsIgnoreCase(subType)) {
                    return cfg;
                }
            }
        }
        return null;
    }


    public int getFirstType(String type) {
        return (getTypeConfig(type)).iD;
    }


    public int getSecondType(String type) {
        return (getIdConfig(type)).typeID;
    }


    public TreasureClassExt getTcProp(String tcCode) {
        return (TreasureClassExt) GameData.TreasureClasss.get(tcCode);
    }


    public DItemBase findUnEquipPropsByProp(String prop) {
        Collection<DItemBase> items = this.itemTemplates.values();
        for (DItemBase item : items) {
            if (item.prop.equals(prop)) {
                return item;
            }
        }
        return null;
    }


    public List<DItemBase> findUnEquipPropsByType(String type) {
        Collection<DItemBase> items = this.itemTemplates.values();
        List<DItemBase> ret = new ArrayList<>();
        for (DItemBase item : items) {
            if (item.type.equals(type)) {
                ret.add(item);
            }
        }
        return ret;
    }


    public List<Integer> findPosByGem(String gem) {
        return this.gemPos.get(gem);
    }


    public String getRealTC(String tc, int level) {
        if (level <= 0) {
            return tc;
        }
        BeforeFilterCO lvTC = this.tcs.get(tc + level);
        if (lvTC == null) {
            return tc;
        }

        return lvTC.tcForLv;
    }

    private ItemConfig() {
    }
}


