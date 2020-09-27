package com.wanniu.game.item;

import Xmds.RefreshPlayerPropertyChange;
import com.wanniu.core.game.LangService;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.RandomUtil;
import com.wanniu.core.util.StringUtil;
import com.wanniu.game.bag.WNBag;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.Utils;
import com.wanniu.game.data.AfterFilterCO;
import com.wanniu.game.data.EnchantCO;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.MeltConfigCO;
import com.wanniu.game.data.ReBuildStarCO;
import com.wanniu.game.data.base.DEquipBase;
import com.wanniu.game.data.base.DItemBase;
import com.wanniu.game.data.base.DItemEquipBase;
import com.wanniu.game.data.base.FourProp;
import com.wanniu.game.data.ext.AffixExt;
import com.wanniu.game.data.ext.EnchantExt;
import com.wanniu.game.data.ext.TreasureClassExt;
import com.wanniu.game.equip.EquipCraftConfig;
import com.wanniu.game.equip.EquipUtil;
import com.wanniu.game.equip.NormalEquip;
import com.wanniu.game.equip.RepeatKeyMap;
import com.wanniu.game.item.data.AttsObj;
import com.wanniu.game.item.data.tc.TCItemData;
import com.wanniu.game.item.po.ItemSpeData;
import com.wanniu.game.item.po.PlayerItemPO;
import com.wanniu.game.player.AttributeUtil;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.request.bag.UseItemHandler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import pomelo.Common;
import pomelo.area.EquipHandler;
import pomelo.item.ItemOuterClass;


public class ItemUtil {
    public static boolean isEquipByItemType(int itemType) {
        if (itemType == Const.ItemType.Weapon.getValue() || itemType == Const.ItemType.Armor.getValue() || itemType == Const.ItemType.Oranament.getValue() || itemType == Const.ItemType.RideEquip.getValue()) {
            return true;
        }
        return false;
    }


    public static DItemEquipBase getPropByCode(String code) {
        if (StringUtils.isEmpty(code)) {
            return null;
        }


        DItemEquipBase prop = ItemConfig.getInstance().getItemProp(code);
        return prop;
    }


    public static DItemBase getUnEquipPropByCode(String code) {
        return (DItemBase) ItemConfig.getInstance().getItemProp(code);
    }


    public static boolean isVirtualItem(String code) {
        DItemEquipBase prop = ItemConfig.getInstance().getItemProp(code);
        if (prop == null) {
            return false;
        }

        int itemSecondType = ItemConfig.getInstance().getSecondType(prop.type);
        if (itemSecondType == Const.ItemSecondType.virtual.getValue()) {


            return true;
        }

        return false;
    }

    public static List<Common.AttributeSimple> getStrengthSimpleAtt(Map<String, Integer> data, int enClass, int enLevel) {
        List<Common.AttributeSimple> newDataArray = new ArrayList<>();
        int maxClass = GlobalConfig.EquipmentCraft_Enchant_MaxEnClass;
        int maxLevel = GlobalConfig.EquipmentCraft_Enchant_MaxenLevel;

        for (Map.Entry<String, Integer> entry : data.entrySet()) {
            Common.AttributeSimple.Builder tempData = Common.AttributeSimple.newBuilder();
            if (((String) entry.getKey()).equals("MinPhy")) {
                tempData.setId(AttributeUtil.getIdByKey("Phy"));
                tempData.setValue(0);
                if (enClass < maxClass || (enClass == maxClass && enLevel < maxLevel)) {
                    EnchantExt enchantExt = EquipUtil.getStrengthConfig(enClass, enLevel);
                    tempData.setValue((int) (0.5D * (((Integer) data.get(entry.getKey())).intValue() + ((Integer) data.get("MaxPhy")).intValue()) * ((EnchantCO) enchantExt).propPer / 10000.0D));
                }
                newDataArray.add(tempData.build());
            }
            if (((String) entry.getKey()).equals("MinMag")) {
                tempData.setId(AttributeUtil.getIdByKey("Mag"));
                tempData.setValue(0);
                if (enClass < maxClass || (enClass == maxClass && enLevel < maxLevel)) {
                    EnchantExt enchantExt = EquipUtil.getStrengthConfig(enClass, enLevel);
                    tempData.setValue((int) (0.5D * (((Integer) data.get(entry.getKey())).intValue() + ((Integer) data.get("MaxMag")).intValue()) * ((EnchantCO) enchantExt).propPer / 10000.0D));
                }
                newDataArray.add(tempData.build());
            }
        }
        for (Map.Entry<String, Integer> entry : data.entrySet()) {
            if (!((String) entry.getKey()).equals("MinMag") && !((String) entry.getKey()).equals("MaxMag") && !((String) entry.getKey()).equals("MinPhy") && !((String) entry.getKey()).equals("MaxPhy")) {
                Common.AttributeSimple.Builder newData = Common.AttributeSimple.newBuilder();
                newData.setId(AttributeUtil.getIdByKey(entry.getKey()));
                newData.setValue(0);
                if (enClass < maxClass || (enClass == maxClass && enLevel < maxLevel)) {
                    EnchantExt enchantExt = EquipUtil.getStrengthConfig(enClass, enLevel);
                    newData.setValue(((Integer) data.get(entry.getKey())).intValue() * ((EnchantCO) enchantExt).propPer / 10000);
                }
                newDataArray.add(newData.build());
            }
        }
        return newDataArray;
    }


    public static NormalItem createItemByDbOpts(PlayerItemPO itemDb) {
        DItemEquipBase prop = ItemConfig.getInstance().getItemProp(itemDb.code);
        if (prop == null) {

            Out.error(new Object[]{"createItemByDbOpts error,code have deleted: ", itemDb.code});

            throw new RuntimeException();
        }


        NormalItem item = createItemByOpts(itemDb, prop);
        return item;
    }


    public static NormalItem createItemByOpts(PlayerItemPO itemDb, DItemEquipBase prop) {
        int itemSecondType = ItemConfig.getInstance().getSecondType(prop.type);
        NormalItem item = null;
        if (isEquipByItemType(prop.itemType)) {
            NormalEquip normalEquip = new NormalEquip(itemDb, prop);
        } else if (itemSecondType == Const.ItemSecondType.virtual.getValue()) {
            item = new VirtualItem(itemDb, prop);
        } else {
            item = new NormalItem(itemDb, prop);
        }

        return item;
    }


    public static int getIndexByRare(List<Integer> rareArray) {
        int result = 0;
        if (rareArray == null || rareArray.size() == 0)
            return result;
        int rares = 0;
        for (Iterator<Integer> iterator = rareArray.iterator(); iterator.hasNext(); ) {
            int rare = ((Integer) iterator.next()).intValue();
            rares += rare;
        }

        if (rares == 0) {
            return result;
        }
        int ranRare = RandomUtil.getInt(0, rares);
        int maxRare = 0;
        for (int i = 0; i < rareArray.size(); i++) {
            int rare = ((Integer) rareArray.get(i)).intValue();
            maxRare += rare;
            if (rare > 0 && ranRare <= maxRare) {
                result = i;

                break;
            }
        }
        return result;
    }

    public static ItemSpeData createItemSpeData(DItemEquipBase prop, int worth) {
        ItemSpeData speData = new ItemSpeData();

        if (isEquipByItemType(prop.itemType)) {
            speData = initSpeData((DEquipBase) prop);
        } else if (ItemConfig.getInstance().getSecondType(prop.type) == Const.ItemSecondType.virtual.getValue()) {
            speData.worth = worth;
        }


        return speData;
    }

    public static ItemSpeData initSpeData(DEquipBase prop) {
        ItemSpeData speData = new ItemSpeData();

        speData.baseAtts = new HashMap<>();
        if (StringUtil.isEmpty(prop.baseCode)) {
            speData.extAtts = new RepeatKeyMap();


            initBaseAtts(speData.baseAtts, prop);
            initExtAtts(speData.extAtts, prop, 0, 0);

            Map<String, Integer> exarAttr = getSameAttsExtAttributes(speData.extAtts, prop.type, prop.code);
            if (exarAttr != null) {
                speData.extAttsAdd = exarAttr;
            }
            initLegendAtts(speData, prop);
        } else {

            for (String attrName : prop.baseAtts.keySet()) {
                FourProp pair = (FourProp) prop.baseAtts.get(attrName);
                if (pair == null) {
                    continue;
                }
                speData.baseAtts.put(pair.prop, Integer.valueOf(RandomUtil.getInt(pair.min, pair.max)));
            }
        }


        return speData;
    }


    public static void initBaseAtts(Map<String, Integer> baseAtts, DEquipBase prop) {
        for (String attrName : prop.baseAtts.keySet()) {
            FourProp pair = (FourProp) prop.baseAtts.get(attrName);
            if (pair == null) {
                continue;
            }
            baseAtts.put(pair.prop, Integer.valueOf(RandomUtil.getInt(pair.min, pair.max)));
        }
    }


    public static void initExtAtts(RepeatKeyMap<Integer, Integer> extAtts, DEquipBase prop, int lastCount, int lockedCount) {
        int rdIndex = RandomUtil.hit(new int[]{GlobalConfig.Equipment_MinAffixChance, 10000 - GlobalConfig.Equipment_MinAffixChance});
        int rdTimes = (rdIndex == 0) ? prop.minAffixCount : prop.maxAffixCount;
        rdTimes = (rdTimes > lastCount) ? rdTimes : lastCount;


        if (lastCount != 0 && rdTimes < prop.maxAffixCount) {
            rdIndex = RandomUtil.hit(new int[]{GlobalConfig.Equipment_ReBuild_AddAffixChance, 10000 - GlobalConfig.Equipment_ReBuild_AddAffixChance});
            rdTimes = (rdIndex == 0) ? (rdTimes + 1) : rdTimes;
        }


        rdTimes -= lockedCount;

        List<Integer> usedGroupId = new ArrayList<>();
        for (int i = 0; i < rdTimes; i++) {
            AffixExt finalAffix = initRebuildOneAtts(prop, usedGroupId, Const.AffixType.normal);
            if (finalAffix != null) {


                FourProp rdProp = (FourProp) finalAffix.props.get(Integer.valueOf(prop.qcolor));
                if (rdProp != null) {
                    extAtts.put(Integer.valueOf(finalAffix.iD), Integer.valueOf(RandomUtil.getInt(rdProp.min, rdProp.max)));
                }
            }
        }
    }


    public static void initRebuildExtAtts(RepeatKeyMap<Integer, Integer> tempExtAtts, DEquipBase prop, int lastCount, int lockedCount) {
        int rdIndex = RandomUtil.hit(new int[]{GlobalConfig.Equipment_MinAffixChance, 10000 - GlobalConfig.Equipment_MinAffixChance});
        int rdTimes = (rdIndex == 0) ? prop.minAffixCount : prop.maxAffixCount;
        rdTimes = (rdTimes > lastCount) ? rdTimes : lastCount;


        if (lastCount != 0 && rdTimes < prop.maxAffixCount) {
            rdIndex = RandomUtil.hit(new int[]{GlobalConfig.Equipment_ReBuild_AddAffixChance, 10000 - GlobalConfig.Equipment_ReBuild_AddAffixChance});
            rdTimes = (rdIndex == 0) ? (rdTimes + 1) : rdTimes;
        }


        rdTimes -= lockedCount;
        if (rdTimes > 5) {
            Out.error(new Object[]{"equip", prop.code, ",", prop.desc, "rebuild rdTimes error ", Integer.valueOf(rdTimes)});
        }

        List<Integer> usedGroupId = new ArrayList<>();
        StringBuilder sb = new StringBuilder(">>>>>>>>>usedGroupId:");

        for (RepeatKeyMap.Pair<Integer, Integer> rp : (Iterable<RepeatKeyMap.Pair<Integer, Integer>>) tempExtAtts.entrySet()) {
            if (((Integer) rp.k).intValue() > 0) {
                AffixExt affix = (AffixExt) GameData.Affixs.get(rp.k);
                if (affix == null) {
                    Out.warn(new Object[]{"key=" + rp.k + " val=" + rp.v});

                    continue;
                }
                int gid = affix.groupID;
                usedGroupId.add(Integer.valueOf(gid));
                sb.append(gid).append(",");
            }
        }
        Out.debug(new Object[]{sb});

        for (int i = 0; i < rdTimes; i++) {
            AffixExt finalAffix = initRebuildOneAtts(prop, usedGroupId, Const.AffixType.normal);
            if (finalAffix != null) {


                FourProp rdProp = (FourProp) finalAffix.props.get(Integer.valueOf(prop.qcolor));
                if (rdProp != null) {
                    int val = RandomUtil.getInt(calcRebuildPropMin(rdProp.min), rdProp.max);
                    tempExtAtts.putIfEmpty(Integer.valueOf(finalAffix.iD), Integer.valueOf(val));
                    if (val < rdProp.min) {
                        Out.info(new Object[]{"成功生成一条属性低于下限>>>>>>>>>>" + finalAffix.iD + "," + ((FourProp) finalAffix.props.get(Integer.valueOf(prop.qcolor))).prop + "," + val + " min=" + rdProp.min});
                    } else {
                        Out.debug(new Object[]{"成功生成一条属性>>>>>>>>>>" + finalAffix.iD + "," + ((FourProp) finalAffix.props.get(Integer.valueOf(prop.qcolor))).prop + "," + val});
                    }
                }
            }
        }
    }


    public static int calcRebuildPropMin(int originalMin) {
        return originalMin * GlobalConfig.Equipment_PropNum_FloorRate / 100;
    }


    public static void seniorInitExtAtts(RepeatKeyMap<Integer, Integer> extAtts, RepeatKeyMap<Integer, Integer> tempExtAtts_senior, DEquipBase prop) {
        List<RepeatKeyMap.Pair<Integer, Integer>> list = extAtts.entrySet();
        for (RepeatKeyMap.Pair<Integer, Integer> p : list) {
            AffixExt finalAffix = (AffixExt) GameData.Affixs.get(p.k);
            if (finalAffix == null) {
                Out.warn(new Object[]{"key=" + p.k + " val=" + p.v});
                continue;
            }
            FourProp rdProp = (FourProp) finalAffix.props.get(Integer.valueOf(prop.qcolor));
            if (rdProp == null) {
                continue;
            }
            int max = rdProp.max;
            if (((Integer) p.v).intValue() < max) {
                int addPer = RandomUtil.getIndex(GlobalConfig.Equipment_SeniorReBuild_MaxRatio + 1);
                if (addPer <= 0) {
                    tempExtAtts_senior.put(p.k, p.v);
                    continue;
                }
                int add = Math.round((((Integer) p.v).intValue() * addPer) * 1.0F / 100.0F);
                if (add <= 0) {
                    tempExtAtts_senior.put(p.k, p.v);
                    continue;
                }
                int after = add + ((Integer) p.v).intValue();
                after = (after > max) ? max : after;
                tempExtAtts_senior.put(p.k, Integer.valueOf(after));
                continue;
            }
            tempExtAtts_senior.put(p.k, p.v);
        }
    }


    public static void initLegendAtts(ItemSpeData speData, DEquipBase prop) {
        List<Integer> usedGroupId = new ArrayList<>();
        AffixExt finalAffix = initOneAtts(prop, usedGroupId, Const.AffixType.legend);
        if (finalAffix != null) {
            FourProp rdProp = (FourProp) finalAffix.props.get(Integer.valueOf(prop.qcolor));
            if (rdProp != null) {
                speData.legendAtts = new HashMap<>();
                speData.legendAtts.put(Integer.valueOf(finalAffix.iD), Integer.valueOf(RandomUtil.getInt(rdProp.min, rdProp.max)));
            }
        }
    }


    public static void initUniqueAtts(List<AttsObj> uniqueAtts, DEquipBase prop) {
        for (FourProp pair : prop.uniqueAtts.values()) {
            uniqueAtts.add(new AttsObj(pair.prop, RandomUtil.getInt(pair.min, pair.max), pair.par, pair.min, pair.max));
        }
    }


    private static ReBuildStarCO findReBuildStarCObyNum(int num, String type) {
        List<ReBuildStarCO> list = GameData.findReBuildStars(t ->
                (t.type.equals(type) && t.enClass == num));

        if (list != null && !list.isEmpty()) {
            return list.get(0);
        }
        return null;
    }

    private static ReBuildStarCO findReBuildStarCObyMax(List<ReBuildStarCO> lt) {
        if (lt == null || lt.isEmpty()) {
            return null;
        }
        ReBuildStarCO maxCO = null;
        for (ReBuildStarCO co : lt) {
            if (maxCO == null) {
                maxCO = co;
                continue;
            }
            maxCO = (co.enClass > maxCO.enClass) ? co : maxCO;
        }

        return maxCO;
    }

    private static List<ReBuildStarCO> findMaxStarCO(String type) {
        List<ReBuildStarCO> list = GameData.findReBuildStars(t -> t.type.equals(type));


        return list;
    }


    public static Map<String, Integer> getSameAttsExtAttributes(RepeatKeyMap<Integer, Integer> attrs, String type, String code) {
        Map<Integer, Integer> sames = new HashMap<>();
        for (Integer key : attrs.keySet()) {
            if (sames.containsKey(key)) {
                sames.put(key, Integer.valueOf(((Integer) sames.get(key)).intValue() + 1));
                continue;
            }
            sames.put(key, Integer.valueOf(1));
        }


        Map<String, Integer> attr = null;
        for (Integer key : sames.keySet()) {
            int repeatTimes = ((Integer) sames.get(key)).intValue();
            if (repeatTimes <= 1) {
                continue;
            }
            attr = (attr == null) ? new HashMap<>() : attr;
            ReBuildStarCO co = findReBuildStarCObyNum(repeatTimes, type);
            if (co == null) {
                Out.warn(new Object[]{"重铸装备获取额外属性失败1,发现当前相同的条目数大于配表数量,当前数量为:" + repeatTimes, "部位=" + type, "code=", code});
                List<ReBuildStarCO> lt = findMaxStarCO(type);
                co = findReBuildStarCObyMax(lt);
                if (co == null)
                    Out.warn(new Object[]{"重铸装备获取额外属性失败1,发现不可预料的情况,难道是配表为空?,当前数量为:" + repeatTimes, "部位=" + type, "code=", code});
                continue;
            }
            Const.PlayerBtlData data = Const.PlayerBtlData.getE(co.prop);
            Integer vl = attr.get(data.toString());
            if (vl == null) {
                attr.put(data.toString(), Integer.valueOf(co.proNum));
                continue;
            }
            attr.put(data.toString(), Integer.valueOf(co.proNum + vl.intValue()));
        }


        return attr;
    }


    public static AffixExt initRebuildOneAtts(DEquipBase prop, List<Integer> usedGroupId, Const.AffixType affixType) {
        List<AffixExt> list_affixs = new ArrayList<>();
        List<Integer> rareArray = new ArrayList<>();

        StringBuilder sb = new StringBuilder("================");
        for (AffixExt affix : GameData.Affixs.values()) {
            if ((affix.equipType.equalsIgnoreCase("All") || affix.equipType.indexOf(prop.type) != -1) && (prop.tcLevel == affix.level || affix.level == 0) && (StringUtil.isEmpty(affix.pro) || affix.pro.indexOf(prop.pro) != -1) && affixType.value == affix.affixType && affix.isValid == 1) {


                list_affixs.add(affix);
                sb.append(affix.groupID).append(",");
                rareArray.add(Integer.valueOf(affix.rare));
            }
        }

        Out.debug(new Object[]{Integer.valueOf(list_affixs.size()), ":::::", sb});
        if (list_affixs.size() > 0) {
            while (true) {
                int index = Utils.getIndexByRareByList(rareArray);
                AffixExt finalAffix = list_affixs.get(index);

                if (isValid(usedGroupId, finalAffix.groupID)) {
                    usedGroupId.add(Integer.valueOf(finalAffix.groupID));
                    return finalAffix;
                }
                Out.debug(new Object[]{Integer.valueOf(finalAffix.groupID)});
            }
        }

        Out.error(new Object[]{"not six affix prop:", prop.code, ":", prop.name});

        return null;
    }


    public static AffixExt getFixOneAtts(int lv, String type, String pro, Const.AffixType affixType, String attName) {
        AffixExt fixAffix = null;
        for (AffixExt affix : GameData.Affixs.values()) {
            if ((affix.equipType.equalsIgnoreCase("All") || affix.equipType.indexOf(type) != -1) && (lv == affix.level || affix.level == 0) && (StringUtil.isEmpty(affix.pro) || affix.pro.indexOf(pro) != -1) && affixType.value == affix.affixType && affix.isValid == 1 && attName
                    .equals(affix.attName)) {
                fixAffix = affix;
                break;
            }
        }
        return fixAffix;
    }


    public static AffixExt initOneAtts(DEquipBase prop, List<Integer> usedGroupId, Const.AffixType affixType) {
        List<AffixExt> list_affixs = new ArrayList<>();
        List<Integer> rareArray = new ArrayList<>();
        for (AffixExt affix : GameData.Affixs.values()) {
            if ((affix.equipType.equalsIgnoreCase("All") || affix.equipType.indexOf(prop.type) != -1) && (prop.tcLevel == affix.level || affix.level == 0) && (StringUtil.isEmpty(affix.pro) || affix.pro.indexOf(prop.pro) != -1) && !usedGroupId.contains(Integer.valueOf(affix.groupID)) && affixType.value == affix.affixType && affix.isValid == 1) {
                list_affixs.add(affix);
                rareArray.add(Integer.valueOf(affix.rare));
            }
        }
        if (list_affixs.size() > 0) {
            int index = Utils.getIndexByRareByList(rareArray);
            AffixExt finalAffix = list_affixs.get(index);
            usedGroupId.add(Integer.valueOf(finalAffix.groupID));
            return finalAffix;
        }
        Out.error(new Object[]{"not six affix prop:", prop.code, ":", prop.name});

        return null;
    }


    private static boolean isValid(List<Integer> usedGroupId, int groupID) {
        int haved = 1;
        for (Integer i : usedGroupId) {
            if (i.intValue() == groupID) {
                haved++;
            }
        }
        boolean result = false;
        switch (haved) {
            case 1:
                result = true;
                break;
            case 2:
                result = Utils.randomPercent(GlobalConfig.Equipment_SameAffixChance2);
                break;
            case 3:
                result = Utils.randomPercent(GlobalConfig.Equipment_SameAffixChance3);
                break;
            case 4:
                result = Utils.randomPercent(GlobalConfig.Equipment_SameAffixChance4);
                break;
            case 5:
                result = Utils.randomPercent(GlobalConfig.Equipment_SameAffixChance5);
                break;
        }

        return result;
    }


    public static void initAllExtAtts(List<AttsObj> extAtts, DEquipBase prop) {
        for (AffixExt affix : GameData.Affixs.values()) {
            if ((affix.equipType.equalsIgnoreCase("All") || affix.equipType.indexOf(prop.type) != -1) && (prop.tcLevel == affix.level || affix.level == 0) && (StringUtil.isEmpty(affix.pro) || affix.pro.indexOf(prop.pro) != -1) && affix.isValid == 1) {
                FourProp rdProp = (FourProp) affix.props.get(Integer.valueOf(prop.qcolor));
                if (rdProp != null) {
                    extAtts.add(new AttsObj(rdProp.prop, RandomUtil.getInt(rdProp.min, rdProp.max), rdProp.par, rdProp.min, rdProp.max));
                }
            }
        }
    }


    public static List<NormalItem> createItemsByItemCode(Map<String, Integer> rewards) {
        List<NormalItem> returnItems = new ArrayList<>();
        for (String itemCode : rewards.keySet()) {
            List<NormalItem> items = createItemsByItemCode(itemCode, ((Integer) rewards.get(itemCode)).intValue());
            returnItems.addAll(items);
        }
        return returnItems;
    }


    public static List<NormalItem> createItemsByItemCode(String code, int groupCount) {
        DItemEquipBase prop = ItemConfig.getInstance().getItemProp(code);
        if (prop == null) {
            return new ArrayList<>();
        }
        return createItemsByProp(prop, groupCount);
    }

    private static List<NormalItem> createItemsByProp(DItemEquipBase prop, int groupCount) {
        List<NormalItem> items = new ArrayList<>();

        if (ItemConfig.getInstance().getSecondType(prop.type) == Const.ItemSecondType.virtual.getValue()) {
            PlayerItemPO itemDb = new PlayerItemPO();
            itemDb.id = UUID.randomUUID().toString();
            itemDb.code = prop.code;
            itemDb.groupCount = 1;
            itemDb.isNew = 1;
            itemDb.speData = createItemSpeData(prop, groupCount);
            itemDb.gotTime = new Date();
            itemDb.cdTime = 0L;
            itemDb.isBind = 0;

            NormalItem item = createItemByOpts(itemDb, prop);
            Out.debug(new Object[]{"生成一个虚拟物品：", item});
            items.add(item);
            return items;
        }

        int remainCount = groupCount;
        while (remainCount > 0) {
            int count = remainCount;
            if (remainCount > prop.groupCount) {
                count = prop.groupCount;
            }
            remainCount -= count;

            PlayerItemPO itemDb = new PlayerItemPO();
            itemDb.id = UUID.randomUUID().toString();
            itemDb.code = prop.code;
            itemDb.groupCount = count;
            itemDb.isNew = 1;


            itemDb.speData = createItemSpeData(prop, 0);

            itemDb.gotTime = new Date();
            itemDb.cdTime = 0L;
            itemDb.isBind = prop.bindType;

            NormalItem item = createItemByOpts(itemDb, prop);
            items.add(item);
        }
        return items;
    }


    private static List<NormalItem> createEquipsByTcLevelAndType(int qColor, int tcLevel, int itemSecondType) {
        List<NormalItem> items = new ArrayList<>();
        List<DEquipBase> props = ItemConfig.getInstance().getEquipProps(qColor, tcLevel, itemSecondType);
        if (props.size() <= 0) {
            Out.debug(new Object[]{ItemUtil.class, "创建装备失败 qColor:", Integer.valueOf(qColor), " tcLevel:", Integer.valueOf(tcLevel), " itemSecondType:", Integer.valueOf(itemSecondType)});
            return items;
        }

        List<Integer> rareArray = new ArrayList<>();
        props.forEach(prop -> rareArray.add(Integer.valueOf(prop.rare)));


        int index = getIndexByRare(rareArray);
        DEquipBase prop = props.get(index);
        return createItemsByProp((DItemEquipBase) prop, 1);
    }


    private static List<NormalItem> createItemsByItemData(TreasureClassExt prop, TCItemData itemData, int color, boolean isNumOfRare, List<Integer> colorRareArray, int level) {
        List<NormalItem> items = new ArrayList<>();
        String itemCode = itemData.code;
        int num = itemData.num;
        if (num == 0) {
            num = Utils.random(itemData.minNum, itemData.maxNum);
        }

        if (isNumOfRare) {
            num *= itemData.rare;
        }

        if (itemData.tcType == 1) {

            int itemSecondType = Const.ItemSecondType.getV(itemCode);
            int tcLevel = prop.tcLevel;
            for (int i = 0; i < num; i++) {
                List<NormalItem> getItems = createEquipsByTcLevelAndType(color, tcLevel, itemSecondType);
                items.addAll(getItems);
            }
        } else {

            TreasureClassExt tcProp = ItemConfig.getInstance().getTcProp(itemCode);
            if (tcProp != null && itemData.tcType == 3) {
                List<NormalItem> getItems = null;


                getItems = createItemsByTcCode(itemCode, colorRareArray, level);
                items.addAll(getItems);
            } else {
                List<NormalItem> getItems = createItemsByItemCode(itemCode, num);
                items.addAll(getItems);
            }
        }
        return items;
    }


    public static List<NormalItem> createItemsByTcCode(String code) {
        return createItemsByTcCode(code, null, 0);
    }


    public static List<NormalItem> createItemsByRealTC(String code, int level) {
        return createItemsByTcCode(code, null, level);
    }


    private static List<NormalItem> createItemsByTcCode(String code, List<Integer> colorRareArray, int level) {
        System.out.println(code + "::::::::::::::::::::::::TCCODE:::::::::::::::::::::::");
        List<NormalItem> items = new ArrayList<>();
        if (StringUtil.isEmpty(code)) {
            return items;
        }
        if (level > 0) {
            code = ItemConfig.getInstance().getRealTC(code, level);
            System.out.println("error:::::::::::::::::::::::::::::::::level");
        }
        TreasureClassExt prop = ItemConfig.getInstance().getTcProp(code);
        if (prop == null) {
            System.out.println("error:::::::::::::::::::::::::::::::::prop");
            return items;
        }


        int picks = prop.picks;
        boolean isHasColor = true;

        if (colorRareArray == null || colorRareArray.size() == 0) {
            isHasColor = false;
        }
        if (picks > 0) {
            System.out.println("error:::::::::::::::::::::::::::::::::picks");
            for (int i = 0; i < picks; i++) {
                List<Integer> rareArray = new ArrayList<>();
                rareArray.add(Integer.valueOf(prop.noDrop));
                List<TCItemData> itemDatas = prop.items;
                for (TCItemData itemData : itemDatas) {
                    rareArray.add(Integer.valueOf(itemData.rare));
                }
                int index = getIndexByRare(rareArray);
                if (index > 0) {
                    if (colorRareArray == null || colorRareArray.size() == 0) {
                        colorRareArray = new ArrayList<>();
                        colorRareArray.add(Integer.valueOf(prop.white));
                        colorRareArray.add(Integer.valueOf(prop.blue));
                        colorRareArray.add(Integer.valueOf(prop.purple));
                        colorRareArray.add(Integer.valueOf(prop.legend));
                        colorRareArray.add(Integer.valueOf(prop.green));
                    }

                    int colorIndex = getIndexByRare(colorRareArray);
                    int color = colorIndex;

                    TCItemData itemData = itemDatas.get(index - 1);

                    List<NormalItem> getItems = null;
                    if (prop.overColor != 0) {
                        getItems = createItemsByItemData(prop, itemData, color, false, colorRareArray, level);
                    } else {
                        getItems = createItemsByItemData(prop, itemData, color, false, null, level);
                    }
                    System.out.println(getItems + "error:::::::::::::::::::::::::::::::::getItems");
                    items.addAll(getItems);
                }
                if (!isHasColor) {
                    colorRareArray = null;
                }
            }
        } else {
            picks = Math.abs(picks);
            for (int i = 0; i < picks; i++) {

                List<TCItemData> itemDatas = prop.items;
                TCItemData itemData = itemDatas.get(i);
                if (itemData != null) {
                    if (colorRareArray == null || colorRareArray.size() == 0) {
                        colorRareArray = new ArrayList<>();
                        colorRareArray.add(Integer.valueOf(prop.white));
                        colorRareArray.add(Integer.valueOf(prop.blue));
                        colorRareArray.add(Integer.valueOf(prop.purple));
                        colorRareArray.add(Integer.valueOf(prop.legend));
                        colorRareArray.add(Integer.valueOf(prop.green));
                    }

                    int colorIndex = getIndexByRare(colorRareArray);
                    int color = colorIndex + 1;


                    List<NormalItem> getItems = null;
                    if (prop.overColor != 0) {
                        getItems = createItemsByItemData(prop, itemData, color, true, colorRareArray, level);
                    } else {
                        getItems = createItemsByItemData(prop, itemData, color, true, null, level);
                    }
                    System.out.println(getItems + "error:::::::::::::::::::::::::::::::::getItems2");
                    items.addAll(getItems);
                }
                if (!isHasColor) {
                    colorRareArray = null;
                }
            }
        }


        AfterFilterCO afterFilter = (AfterFilterCO) GameData.AfterFilters.get(code);
        if (afterFilter != null) {
            for (NormalItem item : items) {
                if (StringUtil.isEmpty(afterFilter.bindType)) {
                    continue;
                }
                try {
                    item.setBindFilter(Integer.parseInt(afterFilter.bindType));


                    item.setBindFilter(Integer.parseInt(afterFilter.noAuction));
                } catch (Exception e) {
                    Out.error(new Object[]{"过滤表填错了"});
                }
            }
        }
        System.out.println(items + "error:::::::::::::::::::::::::::::::::items");
        return items;
    }

    public static List<NormalItem> getPackUpItems(List<NormalItem> items) {
        Map<String, NormalItem> temp = new HashMap<>();
        List<NormalItem> data = new ArrayList<>();

        for (int i = 0; i < items.size(); i++) {
            NormalItem item = items.get(i);

            if (item.isVirtual()) {
                if (temp.get(item.itemDb.code) == null) {
                    temp.put(item.itemDb.code, item);
                } else {
                    ((VirtualItem) temp.get(item.itemDb.code)).addWorth(item.getWorth());
                }
            } else {
                data.add(item);
            }
        }

        for (NormalItem item : temp.values()) {
            data.add(item);
        }

        temp = new HashMap<>();
        Map<String, NormalItem> tempBind = new HashMap<>();
        List<NormalItem> newData = new ArrayList<>();


        for (int j = 0; j < data.size(); j++) {
            NormalItem item = data.get(j);
            if (item != null) {


                if (item.itemDb.groupCount != item.prop.groupCount) {
                    if (item.isBinding()) {
                        mergeItems(item, tempBind, newData);
                    } else {
                        mergeItems(item, temp, newData);
                    }
                } else {
                    newData.add(item);
                }
            }
        }
        for (NormalItem item : temp.values()) {
            newData.add(item);
        }

        for (NormalItem item : tempBind.values()) {
            newData.add(item);
        }

        return newData;
    }

    public static void mergeItems(NormalItem item, Map<String, NormalItem> temp, List<NormalItem> newData) {
        if (temp.get(item.itemDb.code) == null) {
            temp.put(item.itemDb.code, item);
        } else if (((NormalItem) temp.get(item.itemDb.code)).itemDb.groupCount + item.itemDb.groupCount >= item.prop.groupCount) {
            int tmpCount = item.itemDb.groupCount;

            item.setNum(item.prop.groupCount);
            newData.add(item);


            ((NormalItem) temp.get(item.itemDb.code)).setNum(((NormalItem) temp.get(item.itemDb.code)).itemDb.groupCount + tmpCount - item.prop.groupCount);
            if (((NormalItem) temp.get(item.itemDb.code)).itemDb.groupCount == 0) {
                temp.remove(item.itemDb.code);
            }
        } else {

            ((NormalItem) temp.get(item.itemDb.code)).addGroupNum(item.itemDb.groupCount);
        }
    }


    public static int getPackUpItemsNum(List<NormalItem> items) {
        int sum = 0;
        for (int i = 0; i < items.size(); i++) {
            if (((NormalItem) items.get(i)).prop.itemSecondType != Const.ItemSecondType.virtual.getValue() &&


                    !((NormalItem) items.get(i)).isVirtQuest()) {
                sum++;
            }
        }
        return sum;
    }


    public static int getPropBindType(DItemEquipBase template, Const.ForceType forceType) {
        int bindType = template.bindType;
        if (forceType == Const.ForceType.BIND) {
            bindType = Const.BindType.BIND.getValue();
        } else if (forceType == Const.ForceType.UN_BIND) {
            if (isEquipByItemType(template.itemType)) {
                bindType = Const.BindType.EQUIP_BIND.getValue();
            } else {
                bindType = Const.BindType.UN_BIND.getValue();
            }
        }
        return bindType;
    }

    public static ItemOuterClass.MiniItem.Builder getMiniItemData(String code, int num) {
        return getMiniItemData(code, num, null);
    }

    public static ItemOuterClass.MiniItem.Builder getMiniItemData(String code, int num, Const.ForceType forceBindType) {
        DItemEquipBase prop = getPropByCode(code);
        if (prop != null) {
            int bindType = getPropBindType(prop, forceBindType);
            ItemOuterClass.MiniItem.Builder data = ItemOuterClass.MiniItem.newBuilder();
            data.setCode(prop.code);
            data.setGroupCount(num);
            data.setIcon(prop.icon);
            data.setQColor(prop.qcolor);
            data.setName(prop.name);
            data.setStar(0);
            data.setBindType(bindType);

            return data;
        }

        return null;
    }


    public static List<Object[]> getEnchantMaterial(DItemEquipBase prop) {
        List<Object[]> data = new ArrayList();
        String codes = GlobalConfig.Magical_MateCodes;
        String counts = GlobalConfig.Magical_MateCounts;
        String diamonds = GlobalConfig.Magical_MatePrice;

        if (StringUtil.isEmpty(codes) || StringUtil.isEmpty(counts) || StringUtil.isEmpty(diamonds)) {
            return data;
        }

        String[] codesArray = codes.split(",");
        String[] countsArray = counts.split(",");
        String[] diamondsArray = diamonds.split(",");

        data.add(new Object[]{codesArray[prop.qcolor], Integer.valueOf(Integer.parseInt(countsArray[prop.qcolor])), Integer.valueOf(Integer.parseInt(diamondsArray[prop.qcolor]))});

        return data;
    }


    public static NormalItem getEquip(WNPlayer player, EquipHandler.EquipPos equipPos) {
        if (equipPos.getBagOrBody() == Const.EquipPos.BODY.value) {
            return (NormalItem) player.equipManager.getEquipment(equipPos.getPosOrGrid());
        }
        return player.getWnBag().getItem(equipPos.getPosOrGrid());
    }


    public static MeltConfigCO getMeltProp(int meltLevel, int quality) {
        return EquipCraftConfig.getInstance().getMeltProp(meltLevel, quality);
    }


    public static NormalItem getItemById(WNPlayer player, String id) {
        NormalItem item = player.bag.findItemById(id);
        if (item != null) {
            return item;
        }

        NormalEquip normalEquip = player.equipManager.getEquipById(id);
        if (normalEquip != null) {
            return (NormalItem) normalEquip;
        }
        return null;
    }

    public static UseItemHandler.GetItemChanagePropertyResult getItemChanageProperty(NormalItem item) {
        DItemBase prop = (DItemBase) item.prop;
        return getItemChanageProperty(prop);
    }

    public static UseItemHandler.GetItemChanagePropertyResult getItemChanageProperty(DItemBase prop) {
        RefreshPlayerPropertyChange itemData = new RefreshPlayerPropertyChange();
        UseItemHandler.GetItemChanagePropertyResult data = new UseItemHandler.GetItemChanagePropertyResult(itemData, false);

        if (prop.itemSecondType == Const.ItemSecondType.hpot.getValue()) {
            itemData.changeType = Const.PropertyChangeType.HP.value;


        } else {


            itemData.changeType = Const.PropertyChangeType.HPAndMP.value;
        }

        int format = AttributeUtil.getFormatByName(prop.prop);
        itemData.valueType = format;

        itemData.value = prop.min;
        itemData.duration = prop.par;
        if (prop.par > 0) {
            itemData.timestamp = System.currentTimeMillis() + prop.par;
        } else {
            itemData.timestamp = 0L;
        }

        data.itemData = itemData;

        return data;
    }

    public static String getColorItemNameByQcolor(int itemQcolor, String itemName) {
        if (itemQcolor == Const.ItemQuality.WHITE.getValue()) {
            itemName = LangService.getValue("ITEM_QCOLOR_NAME_WHITE").replace("{itemName}", itemName);
        } else if (itemQcolor == Const.ItemQuality.GREEN.getValue()) {
            itemName = LangService.getValue("ITEM_QCOLOR_NAME_GREEN").replace("{itemName}", itemName);
        } else if (itemQcolor == Const.ItemQuality.BLUE.getValue()) {
            itemName = LangService.getValue("ITEM_QCOLOR_NAME_BLUE").replace("{itemName}", itemName);
        } else if (itemQcolor == Const.ItemQuality.PURPLE.getValue()) {
            itemName = LangService.getValue("ITEM_QCOLOR_NAME_PURPLE").replace("{itemName}", itemName);
        } else if (itemQcolor == Const.ItemQuality.ORANGE.getValue()) {
            itemName = LangService.getValue("ITEM_QCOLOR_NAME_ORANGE").replace("{itemName}", itemName);
        } else if (itemQcolor == Const.ItemQuality.RED.getValue()) {
            itemName = LangService.getValue("ITEM_QCOLOR_NAME_RED").replace("{itemName}", itemName);
        }
        return itemName;
    }

    public static int getEquipScoreRatio(String code) {
        DItemEquipBase prop = getPropByCode(code);
        if (prop == null) {
            Out.error(new Object[]{"there is no prop for Equip ", code});
            return 0;
        }
        if (!isEquipByItemType(prop.itemType)) {
            return 0;
        }

        return 0;
    }

    public static int getEquipScore(Map<String, Integer> attrs) {
        int score = 0;
        for (Map.Entry<String, Integer> node : attrs.entrySet()) {
            score += (int) (AttributeUtil.getScoreRatioByKey(node.getKey()) * Math.abs(((Integer) node.getValue()).intValue()));
        }
        return score;
    }


    public static int getMaxStrengthLevel() {
        return 0;
    }


    public static ArrayList<WNBag.SimpleItemInfo> parseString(String itemCode) {
        ArrayList<WNBag.SimpleItemInfo> simpleItemInfos = new ArrayList<>();
        if (StringUtil.isEmpty(itemCode)) {
            return simpleItemInfos;
        }
        String[] rewards = itemCode.split(";");
        for (String ss : rewards) {
            String[] rw = ss.split(":");
            if (rw.length == 2) {
                WNBag.SimpleItemInfo item = new WNBag.SimpleItemInfo();
                item.itemCode = rw[0];
                item.itemNum = Integer.parseInt(rw[1]);
                item.forceType = Const.ForceType.BIND;
                simpleItemInfos.add(item);
            }
        }
        return simpleItemInfos;
    }

    public static Map<String, Integer> parseString2Map(String itemCode) {
        if (StringUtils.isEmpty(itemCode)) {
            return Collections.emptyMap();
        }

        Map<String, Integer> awards = new HashMap<>();
        String[] items = StringUtils.split(itemCode, ";");
        for (String item : items) {
            String[] codenum = item.split(":");
            awards.put(codenum[0], Integer.valueOf(Integer.parseInt(codenum[1])));
        }
        return awards;
    }
}


