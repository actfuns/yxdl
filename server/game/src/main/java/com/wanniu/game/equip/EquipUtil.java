package com.wanniu.game.equip;

import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.StringUtil;
import com.wanniu.game.bag.WNBag;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.Utils;
import com.wanniu.game.data.CharacterCO;
import com.wanniu.game.data.EnchantCO;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.base.DEquipBase;
import com.wanniu.game.data.base.DItemBase;
import com.wanniu.game.data.base.DItemEquipBase;
import com.wanniu.game.data.ext.EnchantExt;
import com.wanniu.game.data.ext.EquipMakeExt;
import com.wanniu.game.data.ext.ReBornExt;
import com.wanniu.game.data.ext.ReBuildExt;
import com.wanniu.game.data.ext.RefineExt;
import com.wanniu.game.data.ext.SeniorReBuildExt;
import com.wanniu.game.item.ItemConfig;
import com.wanniu.game.item.ItemUtil;
import com.wanniu.game.item.data.AttsObj;
import com.wanniu.game.item.po.PlayerItemPO;
import com.wanniu.game.player.AttributeUtil;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.PlayerBasePO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import pomelo.Common;
import pomelo.area.EquipHandler;
import pomelo.item.ItemOuterClass;


public class EquipUtil {
    public static int maxStrengthLevel;
    public static List<String> strengthMaterial = new ArrayList<>();

    public static List<String> makeMaterial = new ArrayList<>();

    static {
        for (EnchantExt enchant : GameData.Enchants.values()) {
            if (maxStrengthLevel < enchant.iD) {
                maxStrengthLevel = enchant.iD;
            }
            if (StringUtil.isNotEmpty(enchant.mateCode1) && !strengthMaterial.contains(enchant.mateCode1)) {
                strengthMaterial.add(enchant.mateCode1);
            }
            if (StringUtil.isNotEmpty(enchant.mateCode2) && !strengthMaterial.contains(enchant.mateCode2)) {
                strengthMaterial.add(enchant.mateCode2);
            }
        }

        for (EquipMakeExt make : GameData.EquipMakes.values()) {
            if (StringUtil.isNotEmpty(make.reqMateCode1) && !makeMaterial.contains(make.reqMateCode1)) {
                makeMaterial.add(make.reqMateCode1);
            }
            if (StringUtil.isNotEmpty(make.reqMateCode2) && !makeMaterial.contains(make.reqMateCode2)) {
                makeMaterial.add(make.reqMateCode2);
            }
            if (StringUtil.isNotEmpty(make.reqMateCode3) && !makeMaterial.contains(make.reqMateCode3)) {
                makeMaterial.add(make.reqMateCode3);
            }
        }

        for (RefineExt refineExt : GameData.Refines.values()) {
            if (StringUtil.isNotEmpty(refineExt.mateCode1) && !makeMaterial.contains(refineExt.mateCode1)) {
                makeMaterial.add(refineExt.mateCode1);
            }
            if (StringUtil.isNotEmpty(refineExt.mateCode2) && !makeMaterial.contains(refineExt.mateCode2)) {
                makeMaterial.add(refineExt.mateCode2);
            }
        }

        for (ReBuildExt reBuildExt : GameData.ReBuilds.values()) {
            if (StringUtil.isNotEmpty(reBuildExt.mateCode1) && !makeMaterial.contains(reBuildExt.mateCode1)) {
                makeMaterial.add(reBuildExt.mateCode1);
            }
            if (StringUtil.isNotEmpty(reBuildExt.mateCode2) && !makeMaterial.contains(reBuildExt.mateCode2)) {
                makeMaterial.add(reBuildExt.mateCode2);
            }
            if (StringUtil.isNotEmpty(reBuildExt.mateCode3) && !makeMaterial.contains(reBuildExt.mateCode3)) {
                makeMaterial.add(reBuildExt.mateCode3);
            }
        }

        for (SeniorReBuildExt seniorReBuildExt : GameData.SeniorReBuilds.values()) {
            if (StringUtil.isNotEmpty(seniorReBuildExt.mateCode1) && !makeMaterial.contains(seniorReBuildExt.mateCode1)) {
                makeMaterial.add(seniorReBuildExt.mateCode1);
            }
            if (StringUtil.isNotEmpty(seniorReBuildExt.mateCode2) && !makeMaterial.contains(seniorReBuildExt.mateCode2)) {
                makeMaterial.add(seniorReBuildExt.mateCode2);
            }
            if (StringUtil.isNotEmpty(seniorReBuildExt.mateCode3) && !makeMaterial.contains(seniorReBuildExt.mateCode3)) {
                makeMaterial.add(seniorReBuildExt.mateCode3);
            }
        }

        for (ReBornExt reBornExt : GameData.ReBorns.values()) {
            if (StringUtil.isNotEmpty(reBornExt.mateCode1) && !makeMaterial.contains(reBornExt.mateCode1)) {
                makeMaterial.add(reBornExt.mateCode1);
            }
            if (StringUtil.isNotEmpty(reBornExt.mateCode2) && !makeMaterial.contains(reBornExt.mateCode2)) {
                makeMaterial.add(reBornExt.mateCode2);
            }
        }
    }


    public static List<ItemOuterClass.EquipmentJewelAtt> toJson4Gem(PlayerBasePO.EquipStrengthPos posInfo) {
        List<ItemOuterClass.EquipmentJewelAtt> data = new ArrayList<>();
        if (posInfo.gems == null)
            return data;
        for (Iterator<Integer> iterator = posInfo.gems.keySet().iterator(); iterator.hasNext(); ) {
            int gem_index = ((Integer) iterator.next()).intValue();

            String gemCode = (String) posInfo.gems.get(Integer.valueOf(gem_index));
            ItemOuterClass.EquipmentJewelAtt.Builder gemData = ItemOuterClass.EquipmentJewelAtt.newBuilder();
            gemData.setIndex(gem_index);
            if (StringUtil.isNotEmpty(gemCode)) {
                DItemBase prop = ItemUtil.getUnEquipPropByCode(gemCode);
                gemData.setId(AttributeUtil.getIdByName(prop.prop));
                gemData.setValue(prop.min);

                ItemOuterClass.MiniItem.Builder mini = ItemUtil.getMiniItemData(gemCode, 1);
                if (prop != null && mini != null) {
                    gemData.setGem(mini);
                }
            }

            data.add(gemData.build());
        }

        Out.debug(new Object[]{EquipUtil.class, " toJson4Gem ", data});
        return data;
    }


    public static boolean fillGem(PlayerBasePO.EquipStrengthPos posInfo, int[] index, String code, WNPlayer player) {
        DItemBase prop = ItemUtil.getUnEquipPropByCode(code);
        if (prop == null) {
            Out.error(new Object[]{"Equip fillGem config error code ", code});
            return false;
        }


        if (posInfo.gems.size() >= posInfo.socks) {
            return false;
        }

        for (int i = 1; i <= posInfo.socks; i++) {
            if (!posInfo.gems.containsKey(Integer.valueOf(i))) {
                posInfo.gems.put(Integer.valueOf(i), code);
                index[0] = i;
                break;
            }
        }
        return true;
    }


    public static EquipHandler.EquipStrengthenData getStrengthInfo(WNPlayer player, int pos) {
        NormalEquip equip = player.equipManager.getEquipment(pos);
        PlayerBasePO.EquipStrengthPos pair = player.equipManager.strengthPos.get(Integer.valueOf(pos));
        EquipHandler.EquipStrengthenData.Builder data = EquipHandler.EquipStrengthenData.newBuilder();
        List<Common.AttributeSimple> simpleAtts = new ArrayList<>();
        if (pair.enSection == GlobalConfig.EquipmentCraft_Enchant_MaxEnClass && pair.enLevel == GlobalConfig.EquipmentCraft_Enchant_MaxenLevel) {
            data.addAllSimpleAtts(simpleAtts);
        } else {
            List<ItemOuterClass.MiniItem> list_cost_items = new ArrayList<>();
            EnchantExt prop = getStrengthConfig(pair.enSection, pair.enLevel);
            if (prop != null) {
                for (String code : prop.mates.keySet()) {
                    list_cost_items.add(ItemUtil.getMiniItemData(code, prop.mates.getIntValue(code), null).build());
                }
                data.addAllCostItem(list_cost_items);
                data.setNeedGoldNum(prop.costGold);
                if (equip != null) {
                    Map<String, Integer> atts = new HashMap<>();
                    Utils.deepCopy(atts, equip.itemDb.speData.baseAtts);
                    if (equip.itemDb.speData.extAtts == null) {
                        Utils.deepCopy(atts, equip.prop.fixedAtts);
                    } else {
                        Utils.deepCopyAffix(atts, equip.itemDb.speData.extAtts, equip.getQLevel());
                    }
                    data.addAllSimpleAtts(ItemUtil.getStrengthSimpleAtt(atts, pair.enSection, pair.enLevel));
                }
            } else {
                Out.error(new Object[]{"pos = ", Integer.valueOf(pos), ",enSection = ", Integer.valueOf(pair.enSection), ", enLevel = ", Integer.valueOf(pair.enLevel)});
            }
        }
        return data.build();
    }


    public static List<Common.Avatar> getAvatarData(int pro, PlayerBasePO playerBasePO, boolean changeModel) {
        CharacterCO basicProp = (CharacterCO) GameData.Characters.get(Integer.valueOf(pro));
        Map<Integer, PlayerItemPO> equipDatas = playerBasePO.equipGrids;
        Map<Integer, PlayerBasePO.EquipStrengthPos> strengthPos = playerBasePO.strengthPos;
        PlayerItemPO tmpCloth = equipDatas.get(Integer.valueOf(Const.EquipType.CLOTH.getValue()));
        PlayerItemPO tmpRHand = equipDatas.get(Integer.valueOf(Const.EquipType.MAIN_HAND.getValue()));

        List<Common.Avatar> data = new ArrayList<>();
        Common.Avatar.Builder avatar = Common.Avatar.newBuilder();
        avatar.setEffectType(0);
        avatar.setTag(Const.AVATAR_TYPE.AVATAR_BODY.value);


        if (tmpCloth != null) {
            DEquipBase prop = (DEquipBase) ItemConfig.getInstance().getItemProp(tmpCloth.code);
            if (StringUtil.isNotEmpty(prop.avatarId)) {
                avatar.setFileName(String.valueOf(prop.avatarId));
            } else {
                avatar.setFileName(String.valueOf(basicProp.model));
            }
        } else {
            avatar.setFileName(String.valueOf(basicProp.model));
        }
        data.add(avatar.build());

        Common.Avatar.Builder avatar_r = Common.Avatar.newBuilder();
        avatar_r.setTag(Const.AVATAR_TYPE.R_HAND_WEAPON.value);
        String defaultRoleWeapon = basicProp.weaponmodel;
        if (tmpRHand != null) {
            String reDefaultWeapon;
            DEquipBase prop = (DEquipBase) ItemConfig.getInstance().getItemProp(tmpRHand.code);

            if (StringUtil.isEmpty(prop.avatarId)) {
                reDefaultWeapon = defaultRoleWeapon;
            } else {
                reDefaultWeapon = String.valueOf(prop.avatarId);
            }

            PlayerBasePO.EquipStrengthPos pair = strengthPos.get(Integer.valueOf(Const.EquipType.MAIN_HAND.getValue()));
            if (basicProp.pro == Const.PlayerPro.YU_JIAN.value) {
                Common.Avatar.Builder avatar_l = Common.Avatar.newBuilder();
                avatar_l.setEffectType(getEffectTypeId(pair.enSection, pair.enLevel));
                avatar_l.setTag(Const.AVATAR_TYPE.L_HAND_WEAPON.value);
                avatar_l.setFileName(String.valueOf(reDefaultWeapon));
                data.add(avatar_l.build());

                avatar_r.setEffectType(getEffectTypeId(pair.enSection, pair.enLevel));
                avatar_r.setFileName(String.valueOf(reDefaultWeapon));
            } else {
                avatar_r.setEffectType(getEffectTypeId(pair.enSection, pair.enLevel));
                avatar_r.setFileName(String.valueOf(reDefaultWeapon));
            }

        } else if (basicProp.pro == Const.PlayerPro.YU_JIAN.value) {
            Common.Avatar.Builder avatar_l = Common.Avatar.newBuilder();
            avatar_l.setEffectType(0);
            avatar_l.setTag(Const.AVATAR_TYPE.L_HAND_WEAPON.value);
            avatar_l.setFileName(String.valueOf(defaultRoleWeapon));
            data.add(avatar_l.build());

            avatar_r.setEffectType(0);
            avatar_r.setFileName(String.valueOf(defaultRoleWeapon));
        } else {
            avatar_r.setEffectType(0);
            avatar_r.setFileName(String.valueOf(defaultRoleWeapon));
        }

        data.add(avatar_r.build());

        return data;
    }

    public static int getEffectTypeId(int enClass, int enLevel) {
        Out.debug(new Object[]{"Equip getEffectTypeId: ", Integer.valueOf(enClass), ",", Integer.valueOf(enLevel)});
        if (enClass == 0 && enLevel < 1) {
            return 0;
        }
        EnchantExt enchantExt = EquipCraftConfig.getInstance().getEnchantConfig(enClass, enLevel);
        if (enchantExt == null) {
            Out.error(new Object[]{"equip getEffectTypeId null:", Integer.valueOf(enLevel)});
            return 0;
        }
        return ((EnchantCO) enchantExt).effectType;
    }


    public static EnchantExt getStrengthConfig(int enClass, int enLevel) {
        if (enClass > GlobalConfig.EquipmentCraft_Enchant_MaxEnClass || enLevel > GlobalConfig.EquipmentCraft_Enchant_MaxenLevel) {
            return null;
        }
        if (enClass == GlobalConfig.EquipmentCraft_Enchant_MaxEnClass && enLevel == GlobalConfig.EquipmentCraft_Enchant_MaxenLevel) {
            return null;
        }
        if (enLevel == GlobalConfig.EquipmentCraft_Enchant_MaxenLevel) {
            enClass++;
            enLevel = 0;
        } else {
            enLevel++;
        }

        return EquipCraftConfig.getInstance().getEnchantConfig(enClass, enLevel);
    }


    public static boolean isMaxStrengthLevel(int enClass, int enLevel) {
        if (enClass == GlobalConfig.EquipmentCraft_Enchant_MaxEnClass && enLevel == GlobalConfig.EquipmentCraft_Enchant_MaxenLevel) {
            return true;
        }

        return false;
    }


    public static boolean existSameTypeGem(int type, PlayerBasePO.EquipStrengthPos posInfo) {
        for (String code : posInfo.gems.values()) {
            if (StringUtil.isNotEmpty(code)) {
                DItemEquipBase prop = ItemConfig.getInstance().getItemProp(code);
                if (type == ((DItemBase) prop).par) {
                    return true;
                }
            }
        }

        return false;
    }


    public static List<WNBag.SimpleItemInfo> getGemList(PlayerBasePO.EquipStrengthPos posInfo, int index) {
        List<WNBag.SimpleItemInfo> itemList = new ArrayList<>();

        String jewel_code = (String) posInfo.gems.get(Integer.valueOf(index));
        if (StringUtil.isNotEmpty(jewel_code)) {
            Const.ForceType forceType = Const.ForceType.getE(Const.BindType.UN_BIND.getValue());
            WNBag.SimpleItemInfo map = new WNBag.SimpleItemInfo();
            map.itemCode = jewel_code;
            map.itemNum = 1;
            map.forceType = forceType;
            itemList.add(map);
        }


        return itemList;
    }


    public static List<Common.AttributeBase> getAttsAttributeBase(List<AttsObj> atts) {
        List<Common.AttributeBase> list = new ArrayList<>();
        if (atts == null) {
            return list;
        }
        for (AttsObj att : atts) {
            Common.AttributeBase ab = getAttributeBase(att);
            list.add(ab);
        }
        return list;
    }

    public static Common.AttributeBase getAttributeBase(AttsObj att) {
        Common.AttributeBase.Builder ab = Common.AttributeBase.newBuilder();

        ab.setId(AttributeUtil.getIdByKey(att.key));
        ab.setIsFormat(AttributeUtil.getFormatByKey(att.key));
        ab.setValue(att.value);

        ab.setMinValue(att.min);
        ab.setMaxValue(att.max);

        ab.setParam3(att.par);
        return ab.build();
    }


    public static List<ItemOuterClass.ItemDetail> getAllEquipDetails4PayLoad(PlayerBasePO playerBasePO, Map<Integer, PlayerItemPO> equipGrids) {
        List<NormalEquip> list = new ArrayList<>();
        for (PlayerItemPO itemDb : equipGrids.values()) {
            list.add((NormalEquip) ItemUtil.createItemByDbOpts(itemDb));
        }
        List<ItemOuterClass.ItemDetail> data = new ArrayList<>();
        for (NormalEquip equip : list) {
            data.add(equip.getItemDetail(playerBasePO).build());
        }
        return data;
    }
}


