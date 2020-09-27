package com.wanniu.game.equip;

import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.StringUtil;
import com.wanniu.game.common.CommonUtil;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.Utils;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.base.DEquipBase;
import com.wanniu.game.data.base.DItemEquipBase;
import com.wanniu.game.data.base.FourProp;
import com.wanniu.game.data.ext.AffixExt;
import com.wanniu.game.data.ext.EnchantExt;
import com.wanniu.game.item.ItemConfig;
import com.wanniu.game.item.ItemUtil;
import com.wanniu.game.item.NormalItem;
import com.wanniu.game.item.data.AttsObj;
import com.wanniu.game.item.po.ItemSpeData;
import com.wanniu.game.item.po.PlayerItemPO;
import com.wanniu.game.player.AttributeUtil;
import com.wanniu.game.poes.PlayerBasePO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import pomelo.item.ItemOuterClass;


public class NormalEquip
        extends NormalItem {
    public DEquipBase prop;
    public ItemSpeData speData;

    public NormalEquip(PlayerItemPO itemDb, DItemEquipBase prop) {
        super(itemDb, prop);

        this.prop = (DEquipBase) prop;
        this.speData = itemDb.speData;

        _init();
    }


    private void _init() {
    }


    public ItemSpeData getSpeData() {
        return this.speData;
    }


    public int getQColor() {
        return this.prop.qcolor;
    }

    public int getEquipScore(PlayerBasePO basePO) {
        return getEquipScore(_calInfluence(basePO));
    }

    public int getEquipScore(Map<String, Integer> attrs) {
        float score = 0.0F;
        for (Map.Entry<String, Integer> entry : attrs.entrySet()) {
            score += AttributeUtil.getScoreRatioByKey(entry.getKey()) * Math.abs(((Integer) entry.getValue()).intValue());
        }
        Out.debug(new Object[]{getClass(), " getEquipScore:", attrs.toString(), " = ", Float.valueOf(score)});
        return (int) score;
    }


    public ItemOuterClass.ItemDetail.Builder getItemDetail(PlayerBasePO basePO) {
        ItemOuterClass.ItemDetail.Builder data = ItemOuterClass.ItemDetail.newBuilder();
        data.setId(this.itemDb.id);
        data.setCode(this.itemDb.code);
        data.setBindType(getBind());
        data.setCanTrade(canTrade() ? 1 : 0);
        data.setCanAuction((canAuction() && getBind() != 1) ? 1 : 0);
        data.setCanDepotRole(canDepotRole() ? 1 : 0);
        data.setCanDepotGuild(canDepotGuild() ? 1 : 0);

        ItemOuterClass.EquipmentDetail.Builder equipDetail = ItemOuterClass.EquipmentDetail.newBuilder();
        equipDetail.setIsIdentfied(0);
        equipDetail.setScore(getEquipScore(_calInfluence(basePO)));

        equipDetail.setBaseScore(equipDetail.getScore());


        DEquipBase attsProp = ItemConfig.getInstance().getEquipProp(this.prop.code);
        if (StringUtil.isNotEmpty(this.prop.baseCode)) {
            attsProp = ItemConfig.getInstance().getEquipProp(this.prop.baseCode);
        }
        int remakeScore = 0;
        int tempremakeScore = 0;
        int seniortempremakeScore = 0;
        List<AttsObj> list_ext = new ArrayList<>();
        if (this.speData.extAtts == null) {
            if (this.prop.fixedAtts != null) {
                for (String key : this.prop.fixedAtts.keySet()) {
                    int value = ((Integer) this.prop.fixedAtts.get(key)).intValue();
                    list_ext.add(new AttsObj(key, value, 0, value, value));
                    remakeScore += CommonUtil.calOneAttributeFightScroreByStr(key, value);
                }
            }
        } else {
            for (RepeatKeyMap.Pair<Integer, Integer> rp : (Iterable<RepeatKeyMap.Pair<Integer, Integer>>) this.speData.extAtts.entrySet()) {
                AffixExt affix = (AffixExt) GameData.Affixs.get(rp.k);
                if (affix == null) {
                    Out.warn(new Object[]{"key=" + rp.k + " val=" + rp.v});
                    continue;
                }
                FourProp pair = (FourProp) affix.props.get(Integer.valueOf(getQColor()));
                if (pair == null) {
                    continue;
                }
                list_ext.add(new AttsObj(pair.prop, ((Integer) rp.v).intValue(), pair.par, ItemUtil.calcRebuildPropMin(pair.min), pair.max));
                remakeScore += CommonUtil.calOneAttributeFightScroreById(((Integer) rp.k).intValue(), ((Integer) rp.v).intValue(), this.prop.qcolor);
            }
        }

        equipDetail.addAllRandomAtts(EquipUtil.getAttsAttributeBase(list_ext));

        List<AttsObj> list_base = new ArrayList<>();
        if (this.speData.baseAtts != null) {
            for (String key : this.speData.baseAtts.keySet()) {
                FourProp pair = (FourProp) attsProp.baseAtts.get(key);
                if (pair == null) {
                    continue;
                }
                list_base.add(new AttsObj(key, ((Integer) this.speData.baseAtts.get(key)).intValue(), pair.par, pair.min, pair.max));
            }
        }
        equipDetail.addAllBaseAtts(EquipUtil.getAttsAttributeBase(list_base));

        List<AttsObj> star_base = new ArrayList<>();
        if (this.speData.extAttsAdd != null) {
            int add = 0;
            for (String key : this.speData.extAttsAdd.keySet()) {
                Integer vl = (Integer) this.speData.extAttsAdd.get(key);
                int ivl = (vl == null) ? 0 : vl.intValue();
                star_base.add(new AttsObj(key, ivl, 0, ivl, ivl));
                add = CommonUtil.calOneAttributeFightScroreByStr(key, ivl);
                remakeScore += add;
            }
            if (this.speData.tempExtAtts_senior != null) {
                seniortempremakeScore += add;
            }
        }
        equipDetail.addAllStarAttr(EquipUtil.getAttsAttributeBase(star_base));


        List<AttsObj> temp_star_base = new ArrayList<>();
        if (this.speData.tempExtAttsAdd != null) {
            for (String key : this.speData.tempExtAttsAdd.keySet()) {
                Integer vl = (Integer) this.speData.tempExtAttsAdd.get(key);
                int ivl = (vl == null) ? 0 : vl.intValue();
                temp_star_base.add(new AttsObj(key, ivl, 0, ivl, ivl));
                tempremakeScore += CommonUtil.calOneAttributeFightScroreByStr(key, ivl);
            }
        }
        equipDetail.addAllTempstarAttr(EquipUtil.getAttsAttributeBase(temp_star_base));
        if (this.speData.legendAtts != null) {
            for (Iterator<Integer> iterator = this.speData.legendAtts.keySet().iterator(); iterator.hasNext(); ) {
                int affixId = ((Integer) iterator.next()).intValue();
                AffixExt affix = (AffixExt) GameData.Affixs.get(Integer.valueOf(affixId));
                if (affix == null) {
                    continue;
                }
                FourProp pair = (FourProp) affix.props.get(Integer.valueOf(getQColor()));
                if (pair == null) {
                    continue;
                }
                equipDetail.addUniqueAtts(EquipUtil.getAttributeBase(new AttsObj(pair.prop, ((Integer) this.speData.legendAtts.get(Integer.valueOf(affixId))).intValue(), pair.par, pair.min, pair.max)));
            }

        }

        if (this.speData.tempBaseAtts != null) {
            List<AttsObj> list_temp_base = new ArrayList<>();
            for (String key : this.speData.tempBaseAtts.keySet()) {
                FourProp pair = (FourProp) attsProp.baseAtts.get(key);
                if (pair == null) {
                    continue;
                }
                list_temp_base.add(new AttsObj(key, ((Integer) this.speData.tempBaseAtts.get(key)).intValue(), pair.par, pair.min, pair.max));
            }
            equipDetail.addAllTempBaseAtts(EquipUtil.getAttsAttributeBase(list_temp_base));
        }

        if (this.speData.tempExtAtts != null) {
            List<AttsObj> list__temp_ext = new ArrayList<>();
            for (RepeatKeyMap.Pair<Integer, Integer> rp : (Iterable<RepeatKeyMap.Pair<Integer, Integer>>) this.speData.tempExtAtts.entrySet()) {
                AffixExt affix = (AffixExt) GameData.Affixs.get(rp.k);
                if (affix == null) {
                    Out.error(new Object[]{"tempExtAtts null exception, id=" + getId() + " code=" + this.itemDb.code + " name=" + getName() + " k=" + rp.k + " v=" + rp.v});
                    continue;
                }
                FourProp pair = (FourProp) affix.props.get(Integer.valueOf(getQColor()));
                if (pair == null) {
                    continue;
                }
                list__temp_ext.add(new AttsObj(pair.prop, ((Integer) rp.v).intValue(), pair.par, ItemUtil.calcRebuildPropMin(pair.min), pair.max));
                tempremakeScore += CommonUtil.calOneAttributeFightScroreByStr(pair.prop, ((Integer) rp.v).intValue());
            }
            equipDetail.addAllTempExtAtts(EquipUtil.getAttsAttributeBase(list__temp_ext));
        }

        if (this.speData.tempExtAtts_senior != null) {
            List<AttsObj> list__temp_ext = new ArrayList<>();
            for (RepeatKeyMap.Pair<Integer, Integer> rp : (Iterable<RepeatKeyMap.Pair<Integer, Integer>>) this.speData.tempExtAtts_senior.entrySet()) {
                AffixExt affix = (AffixExt) GameData.Affixs.get(rp.k);
                if (affix == null) {
                    Out.warn(new Object[]{"key=" + rp.k + " val=" + rp.v});
                    continue;
                }
                FourProp pair = (FourProp) affix.props.get(Integer.valueOf(getQColor()));
                if (pair == null) {
                    continue;
                }
                list__temp_ext.add(new AttsObj(pair.prop, ((Integer) rp.v).intValue(), pair.par, ItemUtil.calcRebuildPropMin(pair.min), pair.max));
                seniortempremakeScore += CommonUtil.calOneAttributeFightScroreByStr(pair.prop, ((Integer) rp.v).intValue());
            }

            equipDetail.addAllTempExtAttsSenior(EquipUtil.getAttsAttributeBase(list__temp_ext));
        }

        if (this.speData.tempUniqueAtts != null) {
            for (Iterator<Integer> iterator = this.speData.tempUniqueAtts.keySet().iterator(); iterator.hasNext(); ) {
                int affixId = ((Integer) iterator.next()).intValue();
                AffixExt affix = (AffixExt) GameData.Affixs.get(Integer.valueOf(affixId));
                if (affix == null) {
                    continue;
                }
                FourProp pair = (FourProp) affix.props.get(Integer.valueOf(getQColor()));
                if (pair == null) {
                    continue;
                }
                equipDetail.addTempUniqueAtts(EquipUtil.getAttributeBase(new AttsObj(pair.prop, ((Integer) this.speData.tempUniqueAtts.get(Integer.valueOf(affixId))).intValue(), pair.par, pair.min, pair.max)));
            }

        }
        equipDetail.setRemakeScore(remakeScore);
        equipDetail.setTempRemakeScore(tempremakeScore);
        equipDetail.setSeniorTempRemakeScore(seniortempremakeScore);
        data.setEquipDetail(equipDetail);

        return data;
    }

    public Map<String, Integer> _calInfluence(PlayerBasePO basePO) {
        PlayerBasePO.EquipStrengthPos strengthInfo = (PlayerBasePO.EquipStrengthPos) basePO.strengthPos.get(Integer.valueOf(getPosition()));

        Map<String, Integer> data = new HashMap<>();


        if (strengthInfo == null || (strengthInfo.enSection == 0 && strengthInfo.enLevel == 0)) {
            Utils.deepCopy(data, this.speData.baseAtts);
        } else {
            EnchantExt enchantExt = (EnchantExt) GameData.Enchants.get(Integer.valueOf(strengthInfo.enSection * 100 + strengthInfo.enLevel));
            if (enchantExt != null) {
                for (String key : this.speData.baseAtts.keySet()) {
                    int value = ((Integer) this.speData.baseAtts.get(key)).intValue();
                    value = value * (10000 + enchantExt.propPer) / 10000;
                    if (data.containsKey(key)) {
                        data.put(key, Integer.valueOf(((Integer) data.get(key)).intValue() + value));
                        continue;
                    }
                    data.put(key, Integer.valueOf(value));
                }
            }
        }


        if (this.speData.extAtts == null) {
            Utils.deepCopy(data, this.prop.fixedAtts);
        } else {
            Utils.deepCopyAffix(data, this.speData.extAtts, getQColor());
        }

        if (this.speData.extAttsAdd != null) {
            Utils.deepCopy(data, this.speData.extAttsAdd);
        }

        Utils.deepCopyAffix(data, this.speData.legendAtts, getQColor());

        return data;
    }

    public int getPosition() {
        return Const.ItemSecondType.getV(this.prop.type);
    }
}


