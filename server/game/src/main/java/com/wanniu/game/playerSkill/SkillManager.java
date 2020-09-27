package com.wanniu.game.playerSkill;

import Xmds.SkillDataICE;
import com.wanniu.core.common.StringInt;
import com.wanniu.core.logfs.Out;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.ModuleManager;
import com.wanniu.game.common.msg.WNNotifyManager;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.base.DItemEquipBase;
import com.wanniu.game.data.ext.CharacterExt;
import com.wanniu.game.data.ext.PassiveSkillExt;
import com.wanniu.game.data.ext.SkillDataExt;
import com.wanniu.game.data.ext.SkillValueExt;
import com.wanniu.game.data.ext.TalentEffectExt;
import com.wanniu.game.item.ItemUtil;
import com.wanniu.game.player.BILogService;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.playerSkill.po.SkillDB;
import com.wanniu.game.poes.SkillsPO;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import pomelo.area.PlayerHandler;
import pomelo.area.SkillHandler;
import pomelo.area.SkillKeysHandler;


public class SkillManager
        extends ModuleManager {
    public WNPlayer player;
    public SkillsPO player_skills;
    private static SkillComparator comparator = new SkillComparator();
    private static SkillLevelComparator comparator_lv = new SkillLevelComparator();
    public Map<Const.PlayerBtlData, Integer> data_skill_attr;

    public SkillManager(WNPlayer player, SkillsPO skills) {
        this.player = player;
        this.player_skills = skills;
        refreshPassiveSkillData();
    }


    public static SkillsPO initNewPlayerSkills(int pro, int initLevel) {
        CharacterExt prop = GameData.findCharacters(t -> (t.pro == pro)).get(0);
        List<CharacterExt.InitSkill> initSkills = prop.initSkills;
        Map<Integer, SkillDB> skills_list = new HashMap<>();
        int openCount = 0;
        for (int i = 0; i < initSkills.size(); i++) {
            CharacterExt.InitSkill cfg = initSkills.get(i);
            SkillDB skill = new SkillDB(cfg.level, cfg.id, 0, 0, 0, i);
            SkillDataExt scf = (SkillDataExt) GameData.SkillDatas.get(Integer.valueOf(cfg.id));
            int needLvl = ((Integer) scf.lvReqData.get(0)).intValue();
            if (initLevel >= needLvl) {
                skill.flag = 1;
                openCount++;
            }
            skills_list.put(Integer.valueOf(cfg.id), skill);
        }

        SkillsPO player_skills = new SkillsPO();
        player_skills.skills = skills_list;
        player_skills.openCount = openCount;
        player_skills.talentSkills = new HashMap<>();


        return player_skills;
    }


    public void onPlayerUpgrade() {
        List<SkillDataExt> props = GameData.findSkillDatas(t -> (t.pro_ == this.player.player.pro && t.learnSkill == 1 && t.lvReqData.size() > 0 && ((Integer) t.lvReqData.get(0)).intValue() <= this.player.baseDataManager.baseData.level));

        List<Integer> list = new ArrayList<>();
        for (SkillDataExt prop : props) {
            SkillDB skill = getSkill(prop.skillID);
            if (skill != null &&
                    skill.flag != 1) {
                skill.flag = 1;
                skill.lv = 1;
                list.add(Integer.valueOf(prop.skillID));
            }
        }

        if (list.size() > 0) {
            this.player.refreshBattlerServerSkill(Const.SkillHandleType.ADD.getValue(), list);
            WNNotifyManager.getInstance().pushSkillUpdate(this.player, list);
            WNNotifyManager.getInstance().pushSkillKeysUpdate(this.player, this.player.skillKeyManager.toJson4Payload());
        }
    }


    public SkillDB getSkill(int skillId) {
        return (SkillDB) this.player_skills.skills.get(Integer.valueOf(skillId));
    }

    public void upgradeSkill(SkillDB skill) {
        int skill_next_lv = skill.lv + 1;
        SkillDataExt prop = (SkillDataExt) GameData.SkillDatas.get(Integer.valueOf(skill.id));
        int cost = 0;
        if (prop.costReqData.containsKey(Integer.valueOf(skill_next_lv)))
            cost = ((Integer) prop.costReqData.get(Integer.valueOf(skill_next_lv))).intValue();
        this.player.moneyManager.costGold(cost, Const.GOODS_CHANGE_TYPE.skill);
        skill.lv = skill_next_lv;
        Out.info(new Object[]{"技能升级 playerId=", this.player.getId(), ",skillId=", Integer.valueOf(skill.id), ",level=", Integer.valueOf(skill_next_lv)});

        this.player.achievementManager.onSkillLevelChange(skill.lv);

        BILogService.getInstance().ansycReportSkillUpgrade(this.player.getPlayer(), skill.id, prop.skillName, skill.lv);
    }

    public boolean upgradeOneSkill(int skillId) {
        SkillDB skill = getSkill(skillId);
        CheckSkillData result = checkSkillReq(skill);
        if (result.result == 0) {
            upgradeSkill(skill);
        }

        List<Integer> list = new ArrayList<>();
        list.add(Integer.valueOf(skillId));
        WNNotifyManager.getInstance().pushSkillUpdate(this.player, list);
        this.player.refreshBattlerServerSkill(Const.SkillHandleType.CHANGE.getValue(), list);
        this.player.onPlayerSkillUpgrade();
        return true;
    }


    private void sortAndUpgrade(Map<Integer, Object> map, int deep) {
        if (--deep < 0) {
            Out.error(new Object[]{"sortAndUpgrade 死锁", map});

            return;
        }
        List<SkillDB> list = new ArrayList<>();

        for (SkillDB skillDB : this.player_skills.skills.values()) {
            if ((checkSkillReq(skillDB)).result == 0)
                list.add(skillDB);
        }
        if (list.size() < 1)
            return;
        list.sort(comparator_lv);
        SkillDB skill = list.get(0);
        upgradeSkill(skill);
        map.put(Integer.valueOf(skill.id), null);
        sortAndUpgrade(map, deep);
    }

    public SkillDB getSkillByPos(int pos) {
        for (SkillDB skill : this.player_skills.skills.values()) {
            if (skill.pos == pos)
                return skill;
        }
        return null;
    }


    public int changeSkillsPos(SkillKeysHandler.SaveSkillKeysRequest req) {
        List<SkillKeysHandler.SkillKey> list = req.getS2CSkillKeysList();


        for (SkillKeysHandler.SkillKey sk : list) {
            int skillId = sk.getSkillId();
            int pos = sk.getKeyPos();
            if (skillId == 0) {
                SkillDB skillDB = getSkillByPos(pos);
                if (skillDB != null &&
                        skillDB.pos == 0)
                    return -3;
                continue;
            }
            SkillDB skill = getSkill(skillId);
            if (skill == null) {
                return -4;
            }
            if (sk.getKeyPos() > 5 || sk.getKeyPos() == 0) {
                return -3;
            }

            int flag_pos = 0, flag_skillId = 0;
            for (SkillKeysHandler.SkillKey _sk : list) {
                if (_sk.getKeyPos() == sk.getKeyPos())
                    flag_pos++;
                if (_sk.getSkillId() == skillId)
                    flag_skillId++;
            }
            if (flag_pos > 1 || flag_skillId > 1) {
                return -1;
            }
        }


        for (SkillKeysHandler.SkillKey sk : list) {
            int skillId = sk.getSkillId();
            int pos = sk.getKeyPos();
            if (skillId == 0) {
                SkillDB skillDB = getSkillByPos(pos);
                if (skillDB != null)
                    skillDB.pos = 0;
                continue;
            }
            SkillDB skill = getSkill(sk.getSkillId());
            skill.pos = sk.getKeyPos();
        }


        return 0;
    }

    public final List<SkillInfo> toJson4BattleServer() {
        List<SkillInfo> skills = new ArrayList<>();

        for (SkillDB skill : this.player_skills.skills.values()) {
            if (skill.flag == 1) {
                SkillInfo data = new SkillInfo();
                SkillDataExt prop = getProp(skill.id);
                data.type = prop.skillType;
                data.id = skill.id;
                data.level = skill.lv;

                data.talentLevel = 1;
                data.skillTime = skill.skillTime;
                data.cdTime = 0;
                skills.add(data);
            }
        }
        return skills;
    }

    public static SkillDataExt getProp(int skillId) {
        return (SkillDataExt) GameData.SkillDatas.get(Integer.valueOf(skillId));
    }

    public final void syncBattleSkillTime(List<SkillDataICE> skillTimeArray) {
        for (SkillDataICE skillTimeData : skillTimeArray) {
            SkillDB skill = getSkill(skillTimeData.skillId);
            if (skill != null) {
                skill.skillTime = skillTimeData.skillTime;
                continue;
            }
            Out.debug(new Object[]{"syncBattleSkillTime error-- id is: ", Integer.valueOf(skillTimeData.skillId)});
        }
    }


    public final void onLevelChange() {
        updateSuperScript();
    }


    public void updateSuperScript() {
    }


    public final SkillHandler.GetAllSkillResponse.Builder toJson4Payload() {
        SkillHandler.GetAllSkillResponse.Builder result = SkillHandler.GetAllSkillResponse.newBuilder();
        ArrayList<SkillHandler.SkillBasic> data = new ArrayList<>();
        result.setHubLock(false);
        for (SkillDB skill : this.player_skills.skills.values()) {
            data.add(toJSON4BasicPayload(skill, false));
        }
        data.sort(comparator);
        result.addAllSkillList(data);
        return result;
    }

    public final ArrayList<SkillHandler.SkillBasic> getSkillsBasicList() {
        ArrayList<SkillHandler.SkillBasic> data = new ArrayList<>();
        for (SkillDB skill : this.player_skills.skills.values()) {
            data.add(toJSON4BasicPayload(skill, false));
        }
        data.sort(comparator);
        return data;
    }

    public final SkillHandler.SkillBasic getSkillBasicUpdate4PayLoad(int skillId) {
        SkillDB skill = getSkill(skillId);
        SkillHandler.SkillBasic basicJson = null;
        basicJson = toJSON4BasicPayload(skill, true);
        return basicJson;
    }

    public final SkillHandler.SkillBasic toJSON4BasicPayload(SkillDB skill, boolean isRefresh) {
        SkillHandler.SkillBasic.Builder data = SkillHandler.SkillBasic.newBuilder();
        SkillDataExt prop = SkillUtil.getProp(skill.id);
        data.setPos(prop.skillIndex);
        data.setLevel(skill.lv);
        data.setExtlv(skill.extLv);
        data.setFlag(skill.flag);
        data.setSkillId(skill.id);
        data.setName(prop.skillName);
        data.setPic(prop.skillIcon);
        if (prop.skillType == Const.SkillType.EFFECT_PASSIVE.getValue()) {
            data.setType(Const.SkillType.BATTLE_PASSIVE.getValue());
        } else {
            data.setType(prop.skillType);
        }
        data.setMaxLevel(prop.maxLevel);
        int nextLevel = 0;
        if (skill.lv < prop.lvReqData.size()) {
            nextLevel = ((Integer) prop.lvReqData.get(skill.lv)).intValue();
        }
        data.setUpgradeNeedLevel(nextLevel);
        data.setDetailNeedRefresh(!!isRefresh);

        ArrayList<Integer> superScripts = new ArrayList<>();
        int isCanUp = 0;
        int isEnSkill1CanUp = 0;
        int isEnSkill2CanUp = 0;

        CheckSkillData result = checkSkillReq(skill);
        isCanUp = (result.result == 0) ? 1 : 0;
        superScripts.add(Integer.valueOf(isCanUp));
        superScripts.add(Integer.valueOf(isEnSkill1CanUp));
        superScripts.add(Integer.valueOf(isEnSkill2CanUp));

        int nextReqCost = 0;
        if (prop.costReqData.containsKey(Integer.valueOf(skill.lv + 1)))
            nextReqCost = ((Integer) prop.costReqData.get(Integer.valueOf(skill.lv + 1))).intValue();
        data.setCost(nextReqCost);


        data.addAllCanUpgrade(superScripts);
        return data.build();
    }

    public final SkillHandler.SkillDetail getSkillDetail4PayLoad(int skillId) {
        SkillDB skill = getSkill(skillId);
        if (skill == null)
            return null;
        SkillDataExt prop = SkillUtil.getProp(skillId);
        SkillHandler.SkillDetail.Builder data = SkillHandler.SkillDetail.newBuilder();
        SkillValueExt exProp = (SkillValueExt) GameData.SkillValues.get(Integer.valueOf(skillId));
        data.setColddown(exProp.cDTime);


        data.setCurManaCost(0);


        ArrayList<String> curDesData = SkillUtil.getDesData(skillId, getUpCorrectLevel(skill) + skill.extLv);


        data.addAllCurDesData(curDesData);
        int nextReqCost = 0;
        if (prop.costReqData.containsKey(Integer.valueOf(skill.lv + 1)))
            nextReqCost = ((Integer) prop.costReqData.get(Integer.valueOf(skill.lv + 1))).intValue();
        ArrayList<SkillHandler.ReqItem> items = new ArrayList<>();

        String iCode = "gold";
        DItemEquipBase itemData = ItemUtil.getPropByCode(iCode);
        int curItemNum = (this.player.getPlayer()).gold;
        int iNum = nextReqCost;

        if (itemData != null) {
            SkillHandler.ReqItem.Builder item = SkillHandler.ReqItem.newBuilder();
            item.setItemCode(iCode);
            item.setItemQua(itemData.qcolor);
            item.setItemIcon(itemData.icon);
            item.setItemReqNum(iNum);
            item.setItemCurNum(curItemNum);
            items.add(item.build());
        }
        data.addAllReqItems(items);

        ArrayList<SkillHandler.TalentDetail> TalentList = new ArrayList<>();


        data.addAllTalentList(TalentList);


        int canUpgrade = 0;
        data.setCanUpgrade(canUpgrade);
        return data.build();
    }


    public final CheckSkillData checkSkillReq(SkillDB skill) {
        int curLv = skill.lv;
        SkillDataExt prop = SkillUtil.getProp(skill.id);


        if (curLv >= prop.maxLevel) {
            CheckSkillData checkSkillData = new CheckSkillData(-1);
            return checkSkillData;
        }


        int reqPlayerLevel = 0;
        if (curLv >= prop.lvReqData.size()) {
            reqPlayerLevel = 0;
        } else {
            reqPlayerLevel = ((Integer) prop.lvReqData.get(curLv)).intValue();
        }
        if (reqPlayerLevel > this.player.getLevel()) {
            CheckSkillData checkSkillData = new CheckSkillData(-2);
            return checkSkillData;
        }


        int reqCost = 0;
        if (prop.costReqData.containsKey(Integer.valueOf(curLv + 1))) {
            reqCost = ((Integer) prop.costReqData.get(Integer.valueOf(curLv + 1))).intValue();
        }
        if (!this.player.moneyManager.enoughGold(reqCost)) {
            CheckSkillData checkSkillData = new CheckSkillData(-3);
            return checkSkillData;
        }


        StringInt item = null;


        CheckSkillData data = new CheckSkillData(0);
        data.reqCost = reqCost;
        data.reqCostItem = item;
        return data;
    }

    public final int getUpCorrectLevel(SkillDB skill) {
        return (skill.lv <= 0) ? 1 : skill.lv;
    }

    private static class SkillComparator implements Comparator<SkillHandler.SkillBasic> {
        private SkillComparator() {
        }

        public int compare(SkillHandler.SkillBasic skillA, SkillHandler.SkillBasic skillB) {
            return skillA.getPos() - skillB.getPos();
        }
    }

    private static class SkillLevelComparator implements Comparator<SkillDB> {
        private SkillLevelComparator() {
        }

        public int compare(SkillDB skillA, SkillDB skillB) {
            return skillA.lv - skillB.lv;
        }
    }


    public final List<SkillInfo> toJson4UpdateBattleServer(int type, List<Integer> skillIds) {
        if (skillIds == null || skillIds.size() <= 0) {
            return null;
        }
        ArrayList<SkillInfo> skills = new ArrayList<>();
        for (Iterator<Integer> iterator = skillIds.iterator(); iterator.hasNext(); ) {
            int skillId = ((Integer) iterator.next()).intValue();
            SkillDB skill = getSkill(skillId);
            if (skill != null && skill.flag == 1) {
                SkillInfo skilldata = _getBattlerServerSkillData(type, skill);
                Out.debug(new Object[]{"toJson4UpdateBattleServer _getBattlerServerSkillData: ", Integer.valueOf(skill.id), "--", skilldata});
                if (skilldata != null) {
                    skills.add(skilldata);
                }
            }
        }

        return skills;
    }

    private final SkillInfo _getBattlerServerSkillData(int type, SkillDB skill) {
        SkillDataExt prop = SkillUtil.getProp(skill.id);
        if (type == Const.SkillHandleType.DELETE.getValue()) {
            SkillInfo skillInfo = new SkillInfo();
            skillInfo.id = skill.id;
            skillInfo.level = skill.lv;
            skillInfo.talentLevel = skill.lv;
            skillInfo.type = prop.skillType;
            skillInfo.skillTime = skill.skillTime;

            skillInfo.cdTime = 0;
            return skillInfo;
        }
        SkillInfo info = new SkillInfo();
        if (prop.skillType == Const.SkillType.ACTIVE.getValue()) {

            int skillLv = skill.lv;
            int skillType = prop.skillType;


            boolean isMeetWeapon = false;


            if (!isMeetWeapon) {


                info.id = skill.id;
                info.level = skillLv;
                info.talentLevel = skillLv;
                info.type = skillType;
                info.skillTime = skill.skillTime;

                info.cdTime = 0;


            }


        } else {


            return null;
        }
        return info;
    }


    public void onPlayerEvent(Const.PlayerEventType eventType) {
        switch (eventType) {
            case UPGRADE:
                onPlayerUpgrade();
                break;
        }
    }


    public List<PlayerHandler.SuperScriptType> getSuperScript() {
        List<PlayerHandler.SuperScriptType> list = new ArrayList<>();
        PlayerHandler.SuperScriptType.Builder data = PlayerHandler.SuperScriptType.newBuilder();
        data.setType(Const.SUPERSCRIPT_TYPE.SKILL.getValue());
        data.setNumber(0);
        for (SkillDB skill : this.player_skills.skills.values()) {

            if ((checkSkillReq(skill)).result == 0) {
                data.setNumber(1);
                break;
            }
        }
        list.add(data.build());
        return list;
    }


    public Const.ManagerType getManagerType() {
        return Const.ManagerType.SKILL;
    }


    public boolean canUpgradeSkill(SkillDB skill) {
        int curLv = skill.lv;
        SkillDataExt prop = SkillUtil.getProp(skill.id);


        if (curLv >= prop.maxLevel) {
            return false;
        }
        int reqPlayerLevel = 0;
        if (curLv >= prop.lvReqData.size()) {
            reqPlayerLevel = 0;
        } else {
            reqPlayerLevel = ((Integer) prop.lvReqData.get(curLv)).intValue();
        }
        if (reqPlayerLevel > this.player.getLevel()) {
            return false;
        }
        return true;
    }


    public int upgradeSkillOneKey2() {
        boolean flag = false;
        for (SkillDB skill : this.player_skills.skills.values()) {
            if (canUpgradeSkill(skill)) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            return -1;
        }
        Map<Integer, Object> map = new HashMap<>();
        sortAndUpgrade(map, 150);
        List<Integer> list_id = new ArrayList<>();
        for (Integer id : map.keySet()) {
            list_id.add(id);
        }
        if (list_id.size() > 0) {
            WNNotifyManager.getInstance().pushSkillUpdate(this.player, list_id);
            this.player.refreshBattlerServerSkill(Const.SkillHandleType.CHANGE.getValue(), list_id);
            this.player.onPlayerSkillUpgrade();
            this.player.pushDynamicData("gold", Integer.valueOf(this.player.player.gold));
            return 0;
        }
        return -2;
    }

    public static class CheckSkillData {
        public int result;
        public int reqCost;
        public StringInt reqCostItem;
        public int reqSpCost;

        public CheckSkillData(int result) {
            this.result = result;
        }
    }

    public static class SkillInfo {
        public int id;
        public int level;
        public int talentLevel;
        public int type;
        public long skillTime;
        public int cdTime;
        public int flag;
    }

    public int getSkillsPower() {
        int power = 0;
        for (SkillDB skill : this.player_skills.skills.values()) {

            SkillDataExt skillData = SkillUtil.getProp(skill.id);
            power = skillData.getSkillPower(skill.lv) + power;
        }


        return power;
    }


    public void refreshPassiveSkillData() {
        this.data_skill_attr = new ConcurrentHashMap<>();
        Map<Integer, SkillDB> map = this.player_skills.talentSkills;
        if (map == null)
            return;
        for (SkillDB s : map.values()) {
            PassiveSkillExt prop = (PassiveSkillExt) GameData.PassiveSkills.get(Integer.valueOf(s.id));
            if (prop.skillType == 0) {

                if (prop.ValueAttribute1 != null) {
                    int value = 0;
                    if (prop.ValueSetMap1 != null && prop.ValueSetMap1.containsKey(Integer.valueOf(s.lv))) {
                        value = ((Integer) prop.ValueSetMap1.get(Integer.valueOf(s.lv))).intValue();
                    } else {
                        Out.error(new Object[]{"麻痹啊，天赋技能", Integer.valueOf(s.id), "对应等级无数据"});
                    }
                    this.data_skill_attr.put(prop.ValueAttribute1, Integer.valueOf(value));
                }
                if (prop.ValueAttribute2 != null) {
                    int value = 0;
                    if (prop.ValueSetMap2 != null && prop.ValueSetMap2.containsKey(Integer.valueOf(s.lv))) {
                        value = ((Integer) prop.ValueSetMap2.get(Integer.valueOf(s.lv))).intValue();
                    } else {
                        Out.error(new Object[]{"麻痹啊，天赋技能", Integer.valueOf(s.id), "对应等级无数据"});
                    }
                    this.data_skill_attr.put(prop.ValueAttribute2, Integer.valueOf(value));
                }
                if (prop.ValueAttribute3 != null) {
                    int value = 0;
                    if (prop.ValueSetMap3 != null && prop.ValueSetMap3.containsKey(Integer.valueOf(s.lv))) {
                        value = ((Integer) prop.ValueSetMap3.get(Integer.valueOf(s.lv))).intValue();
                    } else {
                        Out.error(new Object[]{"麻痹啊，天赋技能", Integer.valueOf(s.id), "对应等级无数据"});
                    }
                    this.data_skill_attr.put(prop.ValueAttribute3, Integer.valueOf(value));
                }
            }
        }
    }

    public void addTalentPoint(int value) {
        this.player_skills.talentPoint += value;
    }


    private void addNewTalentSkill(TalentEffectExt prop) {
        if (prop.talentType == 0) {
            refreshPassiveSkillData();
            this.player.onTalentPassiveSkillUpgrade();
        } else if (prop.talentType != 1) {


            if (prop.talentType == 2) {
                SkillDB s = (SkillDB) this.player_skills.skills.get(Integer.valueOf(prop.beforeSkill));
                if (s != null) {
                    int replaceSkillId = prop.getReplaceSkillId(1);
                    if (replaceSkillId != 0)
                        s.replaceSkillId = replaceSkillId;
                }
            }
        }
    }
}


