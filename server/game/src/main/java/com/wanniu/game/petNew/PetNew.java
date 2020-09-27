package com.wanniu.game.petNew;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.protobuf.GeneratedMessage;
import com.wanniu.core.common.IntIntPair;
import com.wanniu.core.logfs.Out;
import com.wanniu.game.area.AreaDataConfig;
import com.wanniu.game.common.CommonUtil;
import com.wanniu.game.common.Const;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.PetExpLevelCO;
import com.wanniu.game.data.base.MapBase;
import com.wanniu.game.data.ext.BaseDataExt;
import com.wanniu.game.data.ext.MasterPropExt;
import com.wanniu.game.data.ext.MasterUpgradePropExt;
import com.wanniu.game.data.ext.PassiveSkillExt;
import com.wanniu.game.data.ext.PetConfigExt;
import com.wanniu.game.data.ext.PetSkillExt;
import com.wanniu.game.data.ext.PetUpgradeExt;
import com.wanniu.game.player.AttributeUtil;
import com.wanniu.game.player.BILogService;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.player.bi.LogReportService;
import com.wanniu.game.poes.PetNewPO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pomelo.Common;
import pomelo.area.PetNewHandler;


public class PetNew {
    private static final int Tenthousand = 10000;
    public PetNewPO po;
    public BaseDataExt prop;
    private PetExpLevelCO curLevelExp;
    public Map<Const.PlayerBtlData, Integer> attr_all_pet;
    public Map<Const.PlayerBtlData, Integer> attr_final_pet;
    public Map<Const.PlayerBtlData, Integer> attr_final_pet_next;
    public Map<Const.PlayerBtlData, Integer> attr_master;
    private int curMaxLv;
    private WNPlayer master;

    public PetNew(PetNewPO po, WNPlayer master) {
        this.po = po;
        this.master = master;
        this.prop = (BaseDataExt) GameData.BaseDatas.get(Integer.valueOf(po.id));
        initCurMaxLv();
        this.attr_all_pet = new HashMap<>();
        this.attr_final_pet = new HashMap<>();
        this.attr_final_pet_next = new HashMap<>();
        calAttr();
        calMasterAttr();
    }

    public int getCurMaxLv() {
        return this.curMaxLv;
    }

    public void initCurMaxLv() {
        this.curLevelExp = (PetExpLevelCO) GameData.PetExpLevels.get(Integer.valueOf(this.po.level));
        this.curMaxLv = ((PetConfigExt) GameData.PetConfigs.get("LevelLimit")).intValue;
    }

    private void calAttr() {
        this.attr_all_pet.clear();
        this.attr_final_pet.clear();
        this.attr_all_pet.put(Const.PlayerBtlData.Phy, Integer.valueOf(CommonUtil.getGrowUpValue(this.prop.basePhyDamage, this.prop.phyGrowUp, this.po.level)));
        this.attr_all_pet.put(Const.PlayerBtlData.Mag, Integer.valueOf(CommonUtil.getGrowUpValue(this.prop.baseMagDamage, this.prop.magGrowUp, this.po.level)));
        this.attr_all_pet.put(Const.PlayerBtlData.Hit, Integer.valueOf(CommonUtil.getGrowUpValue(this.prop.initHit, this.prop.hitGrowUP, this.po.level)));
        this.attr_all_pet.put(Const.PlayerBtlData.Crit, Integer.valueOf(CommonUtil.getGrowUpValue(this.prop.initCrit, this.prop.critGrowUP, this.po.level)));
        this.attr_all_pet.put(Const.PlayerBtlData.CritDamage, Integer.valueOf(CommonUtil.getGrowUpValue(this.prop.initCritDamage, this.prop.critDamageGrowUp, this.po.level)));


        Map<Const.PlayerBtlData, Integer> upLevelAttrs = null;
        List<PetUpgradeExt> list = GameData.findPetUpgrades(t -> (t.petID == this.po.id && t.targetUpLevel == this.po.upLevel));
        if (list.size() > 0) {
            upLevelAttrs = ((PetUpgradeExt) list.get(0)).upLevelAttrs;
            AttributeUtil.addData2AllData(upLevelAttrs, this.attr_all_pet);
        }
        AttributeUtil.addData2AllData(calPassiveSkill(), this.attr_all_pet);

        AttributeUtil.addData2AllData(getSkillAttr(1), this.attr_all_pet);
        AttributeUtil.addData2AllData(this.attr_all_pet, this.attr_final_pet);

        calFinalData(this.attr_final_pet);

        this.po.fightPower = CommonUtil.calPetFightPower(this.attr_final_pet, this.po.id);
        this.po.fightPower += getSkillsPower();

        calNextAttr();
    }

    private void calNextAttr() {
        this.attr_final_pet_next.clear();

        Map<Const.PlayerBtlData, Integer> attr_temp = new HashMap<>();
        attr_temp.put(Const.PlayerBtlData.Phy, Integer.valueOf(CommonUtil.getGrowUpValue(this.prop.basePhyDamage, this.prop.phyGrowUp, this.po.level)));
        attr_temp.put(Const.PlayerBtlData.Mag, Integer.valueOf(CommonUtil.getGrowUpValue(this.prop.baseMagDamage, this.prop.magGrowUp, this.po.level)));
        attr_temp.put(Const.PlayerBtlData.Hit, Integer.valueOf(CommonUtil.getGrowUpValue(this.prop.initHit, this.prop.hitGrowUP, this.po.level)));
        attr_temp.put(Const.PlayerBtlData.Crit, Integer.valueOf(CommonUtil.getGrowUpValue(this.prop.initCrit, this.prop.critGrowUP, this.po.level)));
        attr_temp.put(Const.PlayerBtlData.CritDamage, Integer.valueOf(CommonUtil.getGrowUpValue(this.prop.initCritDamage, this.prop.critDamageGrowUp, this.po.level)));

        List<PetUpgradeExt> list = GameData.findPetUpgrades(t -> (t.petID == this.po.id && t.targetUpLevel == this.po.upLevel + 1));
        if (list.size() > 0) {
            Map<Const.PlayerBtlData, Integer> upLevelAttrs = ((PetUpgradeExt) list.get(0)).upLevelAttrs;
            AttributeUtil.addData2AllData(upLevelAttrs, attr_temp);
        }
        AttributeUtil.addData2AllData(calPassiveSkill(), attr_temp);

        AttributeUtil.addData2AllData(getSkillAttr(1), attr_temp);

        AttributeUtil.addData2AllData(attr_temp, this.attr_final_pet_next);
        calFinalData(this.attr_final_pet_next);
    }


    private void calFinalData(Map<Const.PlayerBtlData, Integer> attr) {
        int baseValue = 0;
        if (attr.containsKey(Const.PlayerBtlData.Phy)) {
            baseValue += ((Integer) attr.get(Const.PlayerBtlData.Phy)).intValue();
        }
        if (attr.containsKey(Const.PlayerBtlData.Attack)) {
            baseValue += ((Integer) attr.get(Const.PlayerBtlData.Attack)).intValue();
        }
        attr.put(Const.PlayerBtlData.Phy, Integer.valueOf(baseValue));

        int basePer = 0;
        if (attr.containsKey(Const.PlayerBtlData.PhyPer)) {
            basePer += ((Integer) attr.get(Const.PlayerBtlData.PhyPer)).intValue();
        }
        if (attr.containsKey(Const.PlayerBtlData.AttackPer)) {
            basePer += ((Integer) attr.get(Const.PlayerBtlData.AttackPer)).intValue();
        }
        attr.put(Const.PlayerBtlData.PhyPer, Integer.valueOf(basePer));

        baseValue = 0;
        if (attr.containsKey(Const.PlayerBtlData.Mag)) {
            baseValue += ((Integer) attr.get(Const.PlayerBtlData.Mag)).intValue();
        }
        if (attr.containsKey(Const.PlayerBtlData.Attack)) {
            baseValue += ((Integer) attr.get(Const.PlayerBtlData.Attack)).intValue();
        }
        attr.put(Const.PlayerBtlData.Mag, Integer.valueOf(baseValue));

        basePer = 0;
        if (attr.containsKey(Const.PlayerBtlData.MagPer)) {
            basePer += ((Integer) attr.get(Const.PlayerBtlData.MagPer)).intValue();
        }
        if (attr.containsKey(Const.PlayerBtlData.AttackPer)) {
            basePer += ((Integer) attr.get(Const.PlayerBtlData.AttackPer)).intValue();
        }
        attr.put(Const.PlayerBtlData.MagPer, Integer.valueOf(basePer));


        if (attr.containsKey(Const.PlayerBtlData.Phy) && attr.containsKey(Const.PlayerBtlData.PhyPer)) {
            int value = ((Integer) attr.get(Const.PlayerBtlData.Phy)).intValue();
            attr.put(Const.PlayerBtlData.Phy, Integer.valueOf(value + value * ((Integer) attr.get(Const.PlayerBtlData.PhyPer)).intValue() / 10000));
        }

        if (attr.containsKey(Const.PlayerBtlData.Mag) && attr.containsKey(Const.PlayerBtlData.MagPer)) {
            int value = ((Integer) attr.get(Const.PlayerBtlData.Mag)).intValue();
            attr.put(Const.PlayerBtlData.Mag, Integer.valueOf(value + value * ((Integer) attr.get(Const.PlayerBtlData.MagPer)).intValue() / 10000));
        }

        if (attr.containsKey(Const.PlayerBtlData.Hit) && attr.containsKey(Const.PlayerBtlData.HitPer)) {
            int value = ((Integer) attr.get(Const.PlayerBtlData.Hit)).intValue();
            attr.put(Const.PlayerBtlData.Hit, Integer.valueOf(value + value * ((Integer) attr.get(Const.PlayerBtlData.HitPer)).intValue() / 10000));
        }

        if (attr.containsKey(Const.PlayerBtlData.Crit) && attr.containsKey(Const.PlayerBtlData.CritPer)) {
            int value = ((Integer) attr.get(Const.PlayerBtlData.Crit)).intValue();
            attr.put(Const.PlayerBtlData.Crit, Integer.valueOf(value + value * ((Integer) attr.get(Const.PlayerBtlData.CritPer)).intValue() / 10000));
        }
    }


    private void calMasterAttr() {
        this.attr_master = new HashMap<>();
        MasterPropExt prop = (MasterPropExt) GameData.MasterProps.get(Integer.valueOf(this.po.id));
        for (Const.PlayerBtlData pbd : prop.attr_master.keySet()) {
            this.attr_master.put(pbd, Integer.valueOf(CommonUtil.getGrowUpValue(((Integer) prop.attr_master.get(pbd)).intValue(), ((Float) prop.attr_grow.get(pbd)).floatValue(), this.po.level)));
        }


        List<MasterUpgradePropExt> props = GameData.findMasterUpgradeProps(v -> (v.petID == this.po.id && v.upLevel == this.po.upLevel));
        if (props.size() == 1) {
            MasterUpgradePropExt template = props.get(0);
            AttributeUtil.addData2AllData(template.attr_master, this.attr_master);
        } else {
            Out.warn(new Object[]{"宠物升阶对人物加成配置异常. petId=", Integer.valueOf(this.po.id), ",upLevel=", Integer.valueOf(this.po.upLevel)});
        }

        AttributeUtil.addData2AllData(calMasterPassiveSkill(), this.attr_master);

        AttributeUtil.addData2AllData(getSkillAttr(2), this.attr_all_pet);
    }


    private Map<Const.PlayerBtlData, Integer> calPassiveSkill() {
        Map<Const.PlayerBtlData, Integer> map = new HashMap<>();
        for (PetSkill skill : this.po.skills.values()) {
            if (skill.level > 0) {
                PetSkillExt skillProp = (PetSkillExt) GameData.PetSkills.get(Integer.valueOf(skill.id));
                if (skillProp == null) {
                    Out.error(new Object[]{"can't find prop by skillId:", Integer.valueOf(skill.id)});
                    continue;
                }
                if (skillProp.skillType == Const.SkillType.PASSIVE.getValue())
                    for (Const.PlayerBtlData pbd : skillProp.attributeValues.keySet()) {
                        Map<Integer, Integer> map_attr_level = (Map<Integer, Integer>) skillProp.attributeValues.get(pbd);
                        Integer value = map_attr_level.get(Integer.valueOf(skill.level));
                        if (value != null) {
                            map.put(pbd, value);
                        }
                    }
            }
        }
        return map;
    }


    private Map<Const.PlayerBtlData, Integer> calMasterPassiveSkill() {
        Map<Const.PlayerBtlData, Integer> map = new HashMap<>();
        for (PetSkill skill : this.po.skills.values()) {
            if (skill.level > 0) {
                PetSkillExt skillProp = (PetSkillExt) GameData.PetSkills.get(Integer.valueOf(skill.id));
                if (skillProp.skillType == Const.SkillType.PET_PASSIVE.getValue())
                    for (Const.PlayerBtlData pbd : skillProp.attributeValues.keySet()) {
                        Map<Integer, Integer> map_attr_level = (Map<Integer, Integer>) skillProp.attributeValues.get(pbd);
                        Integer value = map_attr_level.get(Integer.valueOf(skill.level));
                        if (value != null) {
                            map.put(pbd, value);
                        }
                    }
            }
        }
        return map;
    }


    public PetNewHandler.PetDataInfo.Builder toJson4PayLoad() {
        PetNewHandler.PetDataInfo.Builder data = PetNewHandler.PetDataInfo.newBuilder();
        data.setId(this.po.id);
        data.setName(this.po.name);
        data.setExp(this.po.exp);
        data.setLevel(this.po.level);
        data.setUpLevel(this.po.upLevel);
        data.setFightPower(this.po.fightPower);
        ArrayList<Common.AttributeSimple> list_attrs_pet = new ArrayList<>();
        for (Const.PlayerBtlData pbd : this.attr_final_pet.keySet()) {
            Common.AttributeSimple.Builder asb = Common.AttributeSimple.newBuilder();
            asb.setId(pbd.id);
            asb.setValue(((Integer) this.attr_final_pet.get(pbd)).intValue());
            list_attrs_pet.add(asb.build());
        }
        data.addAllAttrsFinal(list_attrs_pet);

        ArrayList<Common.AttributeSimple> list_attrs_pet_next = new ArrayList<>();
        for (Const.PlayerBtlData pbd : this.attr_final_pet_next.keySet()) {
            Common.AttributeSimple.Builder asb = Common.AttributeSimple.newBuilder();
            asb.setId(pbd.id);
            asb.setValue(((Integer) this.attr_final_pet_next.get(pbd)).intValue());
            list_attrs_pet_next.add(asb.build());
        }
        data.addAllNextAttrsFinal(list_attrs_pet_next);

        ArrayList<PetNewHandler.SkillDataInfo> list_skill = new ArrayList<>();
        for (IntIntPair iip : this.prop.getInitSkills()) {
            PetSkill skill = (PetSkill) this.po.skills.get(Integer.valueOf(iip.first));
            if (skill != null) {
                PetNewHandler.SkillDataInfo.Builder sb = PetNewHandler.SkillDataInfo.newBuilder();
                sb.setId(skill.id);
                sb.setLevel(skill.level);
                sb.setPos(skill.pos);
                sb.setInborn(skill.inborn);
                list_skill.add(sb.build());
            }
        }
        data.addAllSkills(list_skill);
        return data;
    }

    public int addExp(int exp, boolean synchBattleServer) {
        if (this.po.level >= getCurMaxLv()) {
            return -1;
        }
        this.po.exp += exp;
        boolean upgrade = false;
        if (this.po.exp >= this.curLevelExp.experience) {
            upgrade = upgrade(synchBattleServer);
            if (synchBattleServer && this.master != null) {
                pushInfoUpdate();
            }
        } else if (synchBattleServer && this.master != null) {
            pushExpUpdate();
        }


        if (upgrade) {
            this.master.achievementManager.onGetPetLevel(this.po.id, this.po.level);
        }
        return upgrade ? 1 : 0;
    }

    public void pushInfoUpdate() {
        PetNewHandler.PetInfoUpdatePush.Builder data = PetNewHandler.PetInfoUpdatePush.newBuilder();
        data.setS2CPet(toJson4PayLoad());
        this.master.receive("area.petNewPush.petInfoUpdatePush", (GeneratedMessage) data.build());
    }

    public void pushExpUpdate() {
        PetNewHandler.PetExpUpdatePush.Builder data = PetNewHandler.PetExpUpdatePush.newBuilder();
        data.setS2CPetId(this.po.id);
        data.setS2CCurExp(this.po.exp);
        this.master.receive("area.petNewPush.petExpUpdatePush", (GeneratedMessage) data.build());
    }


    public long getNextLevelneedExp() {
        if (!canAddExp()) {
            return 0L;
        }

        PetExpLevelCO prop = (PetExpLevelCO) GameData.PetExpLevels.get(Integer.valueOf(this.po.level));
        return prop.experience - this.po.exp;
    }


    public static long[] getLevelByExp(long exp, int nowLevel, int curMaxLv) {
        int level = nowLevel;
        long curExp = exp;
        for (int i = nowLevel; i < curMaxLv; i++) {
            PetExpLevelCO prop = (PetExpLevelCO) GameData.PetExpLevels.get(Integer.valueOf(i));
            int needExp = prop.experience;
            if (curExp < needExp) {
                break;
            }
            curExp -= needExp;
            level++;
            if (level == ((PetConfigExt) GameData.PetConfigs.get("LevelLimit")).intValue) {
                curExp = 0L;
                break;
            }
            if (level == curMaxLv) {
                PetExpLevelCO _prop = (PetExpLevelCO) GameData.PetExpLevels.get(Integer.valueOf(level));
                if (curExp > _prop.experience) {
                    curExp = _prop.experience;
                }
            }
        }

        return new long[]{curExp, level};
    }

    public String getBattlerServerPetData() {
        JSONObject json = new JSONObject();
        json.put("petBase", getBattlerServerPetBase());
        json.put("petEffect", getBattlerServerPetEffect());
        json.put("petSkill", getBattlerServerPetSkill());
        json.put("petMode", Integer.valueOf(getPkDataToBattleJson()));
        String str = json.toString();
        return str;
    }

    public int getPkDataToBattleJson() {
        MapBase sceneProp = AreaDataConfig.getInstance().get(this.master.getAreaId());
        if (sceneProp != null &&
                sceneProp.changePetAI == 0) {
            return sceneProp.petAI;
        }

        return PetManager.getPkModel();
    }

    public boolean upgrade(boolean synchBattleServer) {
        int oldLevel = this.po.level;
        long oldExp = this.po.exp;
        boolean flag_upgrade = false;
        long[] par = getLevelByExp(this.po.exp, this.po.level, getCurMaxLv());
        int curLevel = (int) par[1];
        if (this.po.level != curLevel)
            flag_upgrade = true;
        this.po.exp = par[0];
        this.po.level = curLevel;


        LogReportService.getInstance().ansycReportPetUpgrade(this.master, this.po.id, this.po.name, this.po.upLevel, this.po.level, this.po.exp);
        BILogService.getInstance().ansycReportPetCultivate(this.master.getPlayer(), oldLevel, this.po.level, oldExp, this.po.exp, this.po.id);

        initCurMaxLv();
        calAttr();
        calMasterAttr();
        if (synchBattleServer) {
            this.master.petNewManager.refreshMasterAttr();
            this.master.onPetPropChange();
        }
        if (this.master.petNewManager.petsPO.fightPetId == this.po.id && synchBattleServer) {
            this.master.getXmdsManager().refreshPlayerPetDataChange(this.master.getId(), PetOperatorType.Reset.getValue(), getBattlerServerPetData());
        }
        return flag_upgrade;
    }


    public int upgradeUplevel() {
        int nextUplvl = this.po.upLevel + 1;
        if (nextUplvl > ((PetConfigExt) GameData.PetConfigs.get("Upgrade.LevelLimit")).intValue) {
            return -1;
        }
        PetUpgradeExt prop_next = GameData.findPetUpgrades(t -> (t.petID == this.po.id && t.targetUpLevel == nextUplvl)).get(0);
        if (this.po.level < prop_next.reqLevel) {
            return -2;
        }
        String mateCode = prop_next.mateCode;
        int mateCount = prop_next.mateCount;
        if (!this.master.bag.discardItem(mateCode, mateCount, Const.GOODS_CHANGE_TYPE.pet)) {
            return -3;
        }

        this.po.upLevel++;

        LogReportService.getInstance().ansycReportPetUpgrade(this.master, this.po.id, this.po.name, this.po.upLevel, this.po.level, this.po.exp);
        BILogService.getInstance().ansycReportPetCultivate(this.master.getPlayer(), this.po.upLevel, mateCode, mateCount, this.po.id);


        boolean newSkill = false;
        int openSkillID = prop_next.openSkillID;
        if (openSkillID != 0) {
            PetSkill skill = (PetSkill) this.po.skills.get(Integer.valueOf(openSkillID));
            if (skill != null) {
                skill.level = 1;
                newSkill = true;
            }
        }
        initCurMaxLv();
        calAttr();
        calMasterAttr();
        this.master.petNewManager.refreshMasterAttr();
        this.master.onPetPropChange();
        if (this.master.petNewManager.petsPO.fightPetId == this.po.id) {
            this.master.getXmdsManager().refreshPlayerPetDataChange(this.master.getId(), PetOperatorType.Reset.getValue(), getBattlerServerPetData());
        }
        JSONArray arr = new JSONArray();
        List<Map<String, Integer>> list = getBattlerServerPetSkill();
        for (Map<String, Integer> map : list) {
            arr.add(map);
        }
        if (newSkill && this.master.petNewManager.petsPO.fightPetId == this.po.id) {
            this.master.getXmdsManager().refreshPlayerPetSkillChange(this.master.getId(), 0, arr.toJSONString());
        }


        this.master.achievementManager.onPetUpGrade(0, this.po.upLevel);
        return 0;
    }

    public boolean canAddExp() {
        return (this.po.level < getCurMaxLv());
    }

    public JSONObject getBattlerServerPetBase() {
        JSONObject data = new JSONObject();
        data.put("Model", this.prop.model);
        data.put("ModelPercent", Integer.valueOf(this.prop.modelPercent));


        data.put("ModelStar", "");
        data.put("ModelStarPercent", Integer.valueOf(0));
        data.put("ModelStarScenePercent", Integer.valueOf(0));

        data.put("name", this.po.name);
        data.put("level", Integer.valueOf(this.po.level));
        data.put("Qcolor", Integer.valueOf(this.prop.qcolor));
        data.put("templateId", Integer.valueOf(this.po.id));
        data.put("Icon", this.prop.icon);
        data.put("upGradeLevel", Integer.valueOf(this.po.upLevel));
        return data;
    }

    public JSONObject getBattlerServerPetEffect() {
        JSONObject data = new JSONObject();
        for (Const.PlayerBtlData pbd : this.attr_all_pet.keySet()) {
            data.put(pbd.name(), this.attr_all_pet.get(pbd));
        }
        data.put("MoveSpeed", Float.valueOf(this.prop.moveSpeed));

        data.put(Const.PlayerBtlData.MaxHP.name(), Integer.valueOf(999999999));
        data.put("HP", Integer.valueOf(999999999));

        return data;
    }

    public List<Map<String, Integer>> getBattlerServerPetSkill() {
        List<Map<String, Integer>> data = new ArrayList<>();
        for (PetSkill skill : this.po.skills.values()) {
            int type = (getPetSkillBySkillId(skill.id)).skillType;
            if ((type == Const.SkillType.BATTLE_PASSIVE.getValue() || type == Const.SkillType.ACTIVE.getValue() || type == Const.SkillType.NORMAL.getValue()) &&
                    skill.level > 0) {
                Map<String, Integer> e = new HashMap<>();
                e.put("id", Integer.valueOf(skill.id));
                e.put("level", Integer.valueOf(skill.level));
                e.put("talentLevel", Integer.valueOf(skill.level));
                e.put("type", Integer.valueOf(type));
                e.put("skillTime", Integer.valueOf(0));
                data.add(e);
            }
        }


        return data;
    }

    public static PetSkillExt getPetSkillBySkillId(int skillId) {
        return (PetSkillExt) GameData.PetSkills.get(Integer.valueOf(skillId));
    }

    private int getSkillsPower() {
        int power = 0;
        for (PetSkill skill : this.po.skills.values()) {
            PetSkillExt skillProp = (PetSkillExt) GameData.PetSkills.get(Integer.valueOf(skill.id));
            power += skillProp.getSkillPower(skill.level);
        }
        return power;
    }


    private Map<Const.PlayerBtlData, Integer> getSkillAttr(int targetType) {
        Map<Const.PlayerBtlData, Integer> map = new HashMap<>();
        for (PetSkill ps : this.po.passiveSkills.values()) {
            PassiveSkillExt prop = (PassiveSkillExt) GameData.PassiveSkills.get(Integer.valueOf(ps.id));
            if (prop.skillType == 0 && prop.target == targetType) {

                if (prop.ValueAttribute1 != null) {
                    int value = 0;
                    if (prop.ValueSetMap1 != null && prop.ValueSetMap1.containsKey(Integer.valueOf(ps.level))) {
                        value = ((Integer) prop.ValueSetMap1.get(Integer.valueOf(ps.level))).intValue();
                    } else {
                        Out.error(new Object[]{"麻痹啊，天赋技能", Integer.valueOf(ps.id), "对应等级无数据"});
                    }
                    map.put(prop.ValueAttribute1, Integer.valueOf(value));
                }
                if (prop.ValueAttribute2 != null) {
                    int value = 0;
                    if (prop.ValueSetMap2 != null && prop.ValueSetMap2.containsKey(Integer.valueOf(ps.level))) {
                        value = ((Integer) prop.ValueSetMap2.get(Integer.valueOf(ps.level))).intValue();
                    } else {
                        Out.error(new Object[]{"麻痹啊，天赋技能", Integer.valueOf(ps.id), "对应等级无数据"});
                    }
                    map.put(prop.ValueAttribute2, Integer.valueOf(value));
                }
                if (prop.ValueAttribute3 != null) {
                    int value = 0;
                    if (prop.ValueSetMap3 != null && prop.ValueSetMap3.containsKey(Integer.valueOf(ps.level))) {
                        value = ((Integer) prop.ValueSetMap3.get(Integer.valueOf(ps.level))).intValue();
                    } else {
                        Out.error(new Object[]{"麻痹啊，天赋技能", Integer.valueOf(ps.id), "对应等级无数据"});
                    }
                    map.put(prop.ValueAttribute3, Integer.valueOf(value));
                }
            }
        }
        return map;
    }
}


