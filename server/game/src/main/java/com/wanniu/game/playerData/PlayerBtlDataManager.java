package com.wanniu.game.playerData;

import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.StringUtil;
import com.wanniu.game.GWorld;
import com.wanniu.game.common.CommonUtil;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.ModuleManager;
import com.wanniu.game.daoyou.DaoYouCenter;
import com.wanniu.game.daoyou.DaoYouService;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.ext.CharacterExt;
import com.wanniu.game.data.ext.UpLevelExpExt;
import com.wanniu.game.player.AttributeUtil;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.DaoYouPO;
import com.wanniu.game.rank.RankType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import pomelo.Common;


public class PlayerBtlDataManager
        extends ModuleManager {
    private static final int Tenthousand = 10000;
    public Map<Const.PlayerBtlData, Integer> data_pro_lvl = new ConcurrentHashMap<>();

    public Map<Const.PlayerBtlData, Integer> data_class = new ConcurrentHashMap<>();

    public Map<String, Integer> data_equip = new ConcurrentHashMap<>();


    public Map<Const.PlayerBtlData, Integer> data_fashion = new ConcurrentHashMap<>();

    public Map<Const.PlayerBtlData, Integer> data_mount = new ConcurrentHashMap<>();

    public Map<Const.PlayerBtlData, Integer> data_dao_you = new ConcurrentHashMap<>();

    public Map<Const.PlayerBtlData, Integer> data_guild_bless = new ConcurrentHashMap<>();


    public Map<Const.PlayerBtlData, Integer> data_holy_armour = new ConcurrentHashMap<>();

    public Map<Const.PlayerBtlData, Integer> data_exchange_property = new ConcurrentHashMap<>();

    public Map<Const.PlayerBtlData, Integer> data_blood = new ConcurrentHashMap<>();


    public Map<Const.PlayerBtlData, Integer> allInflus = new ConcurrentHashMap<>();


    public Map<Const.PlayerBtlData, Integer> finalInflus = new ConcurrentHashMap<>();


    public Map<Const.PlayerBtlData, Integer> fightPowerInflus = new HashMap<>();

    private WNPlayer player;

    public PlayerBtlDataManager(WNPlayer player) {
        this.player = player;
        init();
    }


    private void init() {
        calProLvlData();
        calClassData();

        this.data_mount = this.player.mountManager.data_mount_final;
        calDaoYouData();
        this.data_equip = this.player.equipManager.calAllInfluence();
        this.data_fashion = this.player.fashionManager.calAllInfluence();
        this.data_holy_armour = this.player.achievementManager.calAllInfluence();
        this.data_blood = this.player.bloodManager.calAllInfluence();
        resetCalExchangeProparty();


        calFinalData();
    }

    public void resetCalExchangeProparty() {
        int count = (this.player.getPlayer()).exchangCount;
        if (count > 0) {
            Map<Const.PlayerBtlData, Integer> exchange_property = new ConcurrentHashMap<>();
            exchange_property.put(Const.PlayerBtlData.MaxHP, Integer.valueOf(GlobalConfig.Exchange_AddBlood * count));
            exchange_property.put(Const.PlayerBtlData.Phy, Integer.valueOf(GlobalConfig.Exchange_AddPhyAttack * count));
            exchange_property.put(Const.PlayerBtlData.Ac, Integer.valueOf(GlobalConfig.Exchange_AddPhyDefense * count));
            exchange_property.put(Const.PlayerBtlData.Mag, Integer.valueOf(GlobalConfig.Exchange_AddMagAttack * count));
            exchange_property.put(Const.PlayerBtlData.Resist, Integer.valueOf(GlobalConfig.Exchange_AddMagDefense * count));
            this.data_exchange_property = exchange_property;
        }
    }

    private void calClassData() {
        if (this.player.player.upOrder == 0) {
            this.data_class = new HashMap<>();
        } else {
            UpLevelExpExt prop = GameData.findUpLevelExps(t -> (t.upOrder == this.player.player.upOrder)).get(0);
            this.data_class = prop.attrs;
        }
    }


    private void onEquipChange() {
        calFinalData();
    }


    private void calModuleData() {
        this.allInflus.clear();
        this.finalInflus.clear();
        AttributeUtil.addData2AllData(this.data_pro_lvl, this.allInflus);
        AttributeUtil.addData2AllData(this.data_class, this.allInflus);

        AttributeUtil.addData2AllDataByKey(this.data_equip, this.allInflus);


        AttributeUtil.addData2AllData(this.data_fashion, this.allInflus);
        AttributeUtil.addData2AllData(this.data_blood, this.allInflus);

        AttributeUtil.addData2AllData(this.player.skillManager.data_skill_attr, this.allInflus);
        AttributeUtil.addData2AllData(this.data_mount, this.allInflus);
        AttributeUtil.addData2AllData(this.player.petNewManager.masterAttr, this.allInflus);
        AttributeUtil.addData2AllData(this.player.petNewManager.masterAttrOnOutFight, this.allInflus);

        AttributeUtil.addData2AllData(this.data_dao_you, this.allInflus);
        AttributeUtil.addData2AllData(this.data_holy_armour, this.allInflus);

        AttributeUtil.addData2AllData(this.data_exchange_property, this.allInflus);


        AttributeUtil.addData2AllDataByKey(this.player.guildManager.guildTechManager.calAllInfluence(), this.allInflus);

        AttributeUtil.addData2AllDataByKey(this.player.titleManager.calAllInfluence(), this.allInflus);


        if (this.player.allBlobData.robotAttr != null) {
            AttributeUtil.addData2AllData(this.player.allBlobData.robotAttr, this.allInflus);
        }
    }


    private void calBuffData() {
        this.fightPowerInflus = new HashMap<>(this.allInflus);

        AttributeUtil.addData2AllDataByKey(this.player.guildManager.calAllInfluence(), this.allInflus);

        AttributeUtil.addData2AllDataByKey(this.player.guildBossManager.calAllInfluence(), this.allInflus);
    }


    private void calFinalData(int oldMaxHp, int oldPhy, int oldMag) {
        int baseValue = 0;
        if (this.allInflus.containsKey(Const.PlayerBtlData.Phy)) {
            baseValue = ((Integer) this.allInflus.get(Const.PlayerBtlData.Phy)).intValue();
        }
        if (this.allInflus.containsKey(Const.PlayerBtlData.Attack)) {
            baseValue += ((Integer) this.allInflus.get(Const.PlayerBtlData.Attack)).intValue();
        }
        this.allInflus.put(Const.PlayerBtlData.Phy, Integer.valueOf(baseValue));
        int basePer = 0;
        if (this.allInflus.containsKey(Const.PlayerBtlData.PhyPer)) {
            basePer += ((Integer) this.allInflus.get(Const.PlayerBtlData.PhyPer)).intValue();
        }
        if (this.allInflus.containsKey(Const.PlayerBtlData.AttackPer)) {
            basePer += ((Integer) this.allInflus.get(Const.PlayerBtlData.AttackPer)).intValue();
        }
        this.allInflus.put(Const.PlayerBtlData.PhyPer, Integer.valueOf(basePer));

        baseValue = 0;
        if (this.allInflus.containsKey(Const.PlayerBtlData.Mag)) {
            baseValue = ((Integer) this.allInflus.get(Const.PlayerBtlData.Mag)).intValue();
        }
        if (this.allInflus.containsKey(Const.PlayerBtlData.Attack)) {
            baseValue += ((Integer) this.allInflus.get(Const.PlayerBtlData.Attack)).intValue();
        }
        this.allInflus.put(Const.PlayerBtlData.Mag, Integer.valueOf(baseValue));
        basePer = 0;
        if (this.allInflus.containsKey(Const.PlayerBtlData.MagPer)) {
            basePer += ((Integer) this.allInflus.get(Const.PlayerBtlData.MagPer)).intValue();
        }
        if (this.allInflus.containsKey(Const.PlayerBtlData.AttackPer)) {
            basePer += ((Integer) this.allInflus.get(Const.PlayerBtlData.AttackPer)).intValue();
        }
        this.allInflus.put(Const.PlayerBtlData.MagPer, Integer.valueOf(basePer));

        baseValue = 0;
        if (this.allInflus.containsKey(Const.PlayerBtlData.Ac)) {
            baseValue = ((Integer) this.allInflus.get(Const.PlayerBtlData.Ac)).intValue();
        }
        if (this.allInflus.containsKey(Const.PlayerBtlData.Def)) {
            baseValue += ((Integer) this.allInflus.get(Const.PlayerBtlData.Def)).intValue();
        }
        this.allInflus.put(Const.PlayerBtlData.Ac, Integer.valueOf(baseValue));
        basePer = 0;
        if (this.allInflus.containsKey(Const.PlayerBtlData.AcPer)) {
            basePer += ((Integer) this.allInflus.get(Const.PlayerBtlData.AcPer)).intValue();
        }
        if (this.allInflus.containsKey(Const.PlayerBtlData.DefPer)) {
            basePer += ((Integer) this.allInflus.get(Const.PlayerBtlData.DefPer)).intValue();
        }
        this.allInflus.put(Const.PlayerBtlData.AcPer, Integer.valueOf(basePer));

        baseValue = 0;
        if (this.allInflus.containsKey(Const.PlayerBtlData.Resist)) {
            baseValue = ((Integer) this.allInflus.get(Const.PlayerBtlData.Resist)).intValue();
        }
        if (this.allInflus.containsKey(Const.PlayerBtlData.Def)) {
            baseValue += ((Integer) this.allInflus.get(Const.PlayerBtlData.Def)).intValue();
        }
        this.allInflus.put(Const.PlayerBtlData.Resist, Integer.valueOf(baseValue));
        basePer = 0;
        if (this.allInflus.containsKey(Const.PlayerBtlData.ResistPer)) {
            basePer += ((Integer) this.allInflus.get(Const.PlayerBtlData.ResistPer)).intValue();
        }
        if (this.allInflus.containsKey(Const.PlayerBtlData.DefPer)) {
            basePer += ((Integer) this.allInflus.get(Const.PlayerBtlData.DefPer)).intValue();
        }
        this.allInflus.put(Const.PlayerBtlData.ResistPer, Integer.valueOf(basePer));
        this.allInflus.remove(Const.PlayerBtlData.Attack);
        this.allInflus.remove(Const.PlayerBtlData.AttackPer);
        this.allInflus.remove(Const.PlayerBtlData.Def);
        this.allInflus.remove(Const.PlayerBtlData.DefPer);


        AttributeUtil.addData2AllData(this.allInflus, this.finalInflus);


        int curMaxHp = 0;
        if (this.finalInflus.containsKey(Const.PlayerBtlData.HPPer) && this.finalInflus.containsKey(Const.PlayerBtlData.MaxHP)) {
            curMaxHp = ((Integer) this.finalInflus.get(Const.PlayerBtlData.MaxHP)).intValue();
            curMaxHp += curMaxHp * ((Integer) this.finalInflus.get(Const.PlayerBtlData.HPPer)).intValue() / 10000;
            this.finalInflus.put(Const.PlayerBtlData.MaxHP, Integer.valueOf(curMaxHp));
        }

        if (this.finalInflus.containsKey(Const.PlayerBtlData.Phy) && this.finalInflus.containsKey(Const.PlayerBtlData.PhyPer)) {
            int value = ((Integer) this.finalInflus.get(Const.PlayerBtlData.Phy)).intValue();
            this.finalInflus.put(Const.PlayerBtlData.Phy, Integer.valueOf(value + value * ((Integer) this.finalInflus.get(Const.PlayerBtlData.PhyPer)).intValue() / 10000));
        }

        if (this.finalInflus.containsKey(Const.PlayerBtlData.Mag) && this.finalInflus.containsKey(Const.PlayerBtlData.MagPer)) {
            int value = ((Integer) this.finalInflus.get(Const.PlayerBtlData.Mag)).intValue();
            this.finalInflus.put(Const.PlayerBtlData.Mag, Integer.valueOf(value + value * ((Integer) this.finalInflus.get(Const.PlayerBtlData.MagPer)).intValue() / 10000));
        }

        if (this.finalInflus.containsKey(Const.PlayerBtlData.Hit) && this.finalInflus.containsKey(Const.PlayerBtlData.HitPer)) {
            int value = ((Integer) this.finalInflus.get(Const.PlayerBtlData.Hit)).intValue();
            this.finalInflus.put(Const.PlayerBtlData.Hit, Integer.valueOf(value + value * ((Integer) this.finalInflus.get(Const.PlayerBtlData.HitPer)).intValue() / 10000));
        }

        if (this.finalInflus.containsKey(Const.PlayerBtlData.Dodge) && this.finalInflus.containsKey(Const.PlayerBtlData.DodgePer)) {
            int value = ((Integer) this.finalInflus.get(Const.PlayerBtlData.Dodge)).intValue();
            this.finalInflus.put(Const.PlayerBtlData.Dodge, Integer.valueOf(value + value * ((Integer) this.finalInflus.get(Const.PlayerBtlData.DodgePer)).intValue() / 10000));
        }

        if (this.finalInflus.containsKey(Const.PlayerBtlData.Crit) && this.finalInflus.containsKey(Const.PlayerBtlData.CritPer)) {
            int value = ((Integer) this.finalInflus.get(Const.PlayerBtlData.Crit)).intValue();
            this.finalInflus.put(Const.PlayerBtlData.Crit, Integer.valueOf(value + value * ((Integer) this.finalInflus.get(Const.PlayerBtlData.CritPer)).intValue() / 10000));
        }

        if (this.finalInflus.containsKey(Const.PlayerBtlData.ResCrit) && this.finalInflus.containsKey(Const.PlayerBtlData.ResCritPer)) {
            int value = ((Integer) this.finalInflus.get(Const.PlayerBtlData.ResCrit)).intValue();
            this.finalInflus.put(Const.PlayerBtlData.ResCrit, Integer.valueOf(value + value * ((Integer) this.finalInflus.get(Const.PlayerBtlData.ResCritPer)).intValue() / 10000));
        }


        if (this.finalInflus.containsKey(Const.PlayerBtlData.Ac) && this.finalInflus.containsKey(Const.PlayerBtlData.AcPer)) {
            int value = ((Integer) this.finalInflus.get(Const.PlayerBtlData.Ac)).intValue();
            this.finalInflus.put(Const.PlayerBtlData.Ac, Integer.valueOf(value + value * ((Integer) this.finalInflus.get(Const.PlayerBtlData.AcPer)).intValue() / 10000));
        }

        if (this.finalInflus.containsKey(Const.PlayerBtlData.Resist) && this.finalInflus.containsKey(Const.PlayerBtlData.ResistPer)) {
            int value = ((Integer) this.finalInflus.get(Const.PlayerBtlData.Resist)).intValue();
            this.finalInflus.put(Const.PlayerBtlData.Resist, Integer.valueOf(value + value * ((Integer) this.finalInflus.get(Const.PlayerBtlData.ResistPer)).intValue() / 10000));
        }

        int nowMaxHp = ((Integer) this.finalInflus.getOrDefault(Const.PlayerBtlData.MaxHP, Integer.valueOf(0))).intValue();
        int nowPhy = ((Integer) this.finalInflus.getOrDefault(Const.PlayerBtlData.Phy, Integer.valueOf(0))).intValue();
        int nowMag = ((Integer) this.finalInflus.getOrDefault(Const.PlayerBtlData.Mag, Integer.valueOf(0))).intValue();
        if (oldMaxHp != nowMaxHp && this.player.rankManager != null) {
            this.player.rankManager.onEvent(RankType.HP, new Object[]{Integer.valueOf(nowMaxHp)});
        }
        if (oldPhy != nowPhy && this.player.rankManager != null) {
            this.player.rankManager.onEvent(RankType.PHY, new Object[]{Integer.valueOf(nowPhy)});
        }
        if (oldMag != nowMag && this.player.rankManager != null) {
            this.player.rankManager.onEvent(RankType.MAGIC, new Object[]{Integer.valueOf(nowMag)});
        }
        if (GWorld.DEBUG) {
            StringBuilder sb = (new StringBuilder("\r\n==========================player:")).append(this.player.getName()).append(" finalInflus begin=====================\r\n");
            for (Const.PlayerBtlData key : this.finalInflus.keySet()) {
                sb.append(key.toString() + "\t" + key.chName + "=" + this.finalInflus.get(key)).append("\r\n");
            }
            sb.append("==========================player finalInflus end=================================\r\n");
            Out.error(new Object[]{sb.toString()});
        }
    }


    public void calFinalData(Map<String, Integer> influs, boolean isBuffAttr) {
        int oldMaxHp = ((Integer) this.finalInflus.getOrDefault(Const.PlayerBtlData.MaxHP, Integer.valueOf(0))).intValue();
        int oldPhy = ((Integer) this.finalInflus.getOrDefault(Const.PlayerBtlData.Phy, Integer.valueOf(0))).intValue();
        int oldMag = ((Integer) this.finalInflus.getOrDefault(Const.PlayerBtlData.Mag, Integer.valueOf(0))).intValue();
        calModuleData();
        if (isBuffAttr) {
            calBuffData();
            AttributeUtil.addData2AllDataByKey(influs, this.allInflus);
        } else {
            AttributeUtil.addData2AllDataByKey(influs, this.allInflus);
            calBuffData();
        }

        calFinalData(oldMaxHp, oldPhy, oldMag);
    }


    public void calFinalData() {
        int oldMaxHp = ((Integer) this.finalInflus.getOrDefault(Const.PlayerBtlData.MaxHP, Integer.valueOf(0))).intValue();
        int oldPhy = ((Integer) this.finalInflus.getOrDefault(Const.PlayerBtlData.Phy, Integer.valueOf(0))).intValue();
        int oldMag = ((Integer) this.finalInflus.getOrDefault(Const.PlayerBtlData.Mag, Integer.valueOf(0))).intValue();

        calModuleData();
        calBuffData();
        calFinalData(oldMaxHp, oldPhy, oldMag);
    }


    private void onPlayerUpgrade() {
        calProLvlData();
        calFinalData();
    }


    private void onClassLvlUp() {
        calClassData();
        calFinalData();
    }


    public void onExchangeProparty() {
        resetCalExchangeProparty();
        calFinalData();
    }


    private void calProLvlData() {
        this.data_pro_lvl.clear();
        CharacterExt character_prop = GameData.findCharacters(t -> (t.pro == this.player.player.pro)).get(0);
        this.data_pro_lvl.put(Const.PlayerBtlData.MaxHP, Integer.valueOf(CommonUtil.getGrowUpValue(character_prop.initHP, character_prop.hPGrowUp, this.player.player.level)));
        this.data_pro_lvl.put(Const.PlayerBtlData.Phy, Integer.valueOf(CommonUtil.getGrowUpValue(character_prop.basePhyDamage, character_prop.phyGrowUp, this.player.player.level)));
        this.data_pro_lvl.put(Const.PlayerBtlData.Mag, Integer.valueOf(CommonUtil.getGrowUpValue(character_prop.baseMagDamage, character_prop.magGrowUp, this.player.player.level)));
        this.data_pro_lvl.put(Const.PlayerBtlData.Hit, Integer.valueOf(CommonUtil.getGrowUpValue(character_prop.initHit, character_prop.hitGrowUP, this.player.player.level)));
        this.data_pro_lvl.put(Const.PlayerBtlData.Dodge, Integer.valueOf(CommonUtil.getGrowUpValue(character_prop.initDodge, character_prop.dodgeGrowUP, this.player.player.level)));
        this.data_pro_lvl.put(Const.PlayerBtlData.Crit, Integer.valueOf(CommonUtil.getGrowUpValue(character_prop.initCrit, character_prop.critGrowUP, this.player.player.level)));
        this.data_pro_lvl.put(Const.PlayerBtlData.ResCrit, Integer.valueOf(CommonUtil.getGrowUpValue(character_prop.initResCrit, character_prop.resCritGrowUP, this.player.player.level)));
        this.data_pro_lvl.put(Const.PlayerBtlData.Ac, Integer.valueOf(CommonUtil.getGrowUpValue(character_prop.initAc, character_prop.acGrowUp, this.player.player.level)));
        this.data_pro_lvl.put(Const.PlayerBtlData.Resist, Integer.valueOf(CommonUtil.getGrowUpValue(character_prop.initResist, character_prop.resistGrowUp, this.player.player.level)));
        this.data_pro_lvl.put(Const.PlayerBtlData.HPRecover, Integer.valueOf(character_prop.baseHPRegen));
        this.data_pro_lvl.put(Const.PlayerBtlData.HealEffect, Integer.valueOf(character_prop.healEffect));
        this.data_pro_lvl.put(Const.PlayerBtlData.HealedEffect, Integer.valueOf(character_prop.healedEffect));
        this.data_pro_lvl.put(Const.PlayerBtlData.CritDamage, Integer.valueOf(character_prop.critDamage));


        if (StringUtil.isNotEmpty(character_prop.giftProp1)) {
            Const.PlayerBtlData gift = Const.PlayerBtlData.getE(character_prop.giftProp1);
            if (gift != null)
                putBtlData(gift, character_prop.giftValue1, this.data_pro_lvl);
        }
        if (!StringUtil.isNotEmpty(character_prop.giftProp2)) {
            Const.PlayerBtlData gift = Const.PlayerBtlData.getE(character_prop.giftProp2);
            if (gift != null)
                putBtlData(gift, character_prop.giftValue2, this.data_pro_lvl);
        }
        if (!StringUtil.isNotEmpty(character_prop.giftProp3)) {
            Const.PlayerBtlData gift = Const.PlayerBtlData.getE(character_prop.giftProp3);
            if (gift != null) {
                putBtlData(gift, character_prop.giftValue3, this.data_pro_lvl);
            }
        }
    }


    private static void putBtlData(Const.PlayerBtlData e, int value, Map<Const.PlayerBtlData, Integer> map) {
        if (map.containsKey(e)) {
            int value_data = ((Integer) map.get(e)).intValue();
            map.put(e, Integer.valueOf(value + value_data));
        } else {
            map.put(e, Integer.valueOf(value));
        }
    }


    public Map<String, Number> _getBattlerServerEffect() {
        Map<String, Number> map = new HashMap<>();
        for (Const.PlayerBtlData pbd : Const.PlayerBtlData.values()) {
            if (this.allInflus.containsKey(pbd)) {
                map.put(pbd.name(), this.allInflus.get(pbd));
            } else {
                map.put(pbd.name(), Integer.valueOf(0));
            }
        }
        map.put("HP", Integer.valueOf(this.player.playerTempData.hp));
        float moveSpeed = 5.6F * (1.0F + ((Number) map.get(Const.PlayerBtlData.RunSpeed.name())).floatValue() / 10000.0F);
        if (this.player.playerBasePO.speed != 0.0F) {
            moveSpeed = this.player.playerBasePO.speed;
        }
        map.put("MoveSpeed", Float.valueOf(moveSpeed));
        int bagRemainCount = this.player.bag.emptyGridNum();
        map.put("bagRemainCount", Integer.valueOf(bagRemainCount));
        return map;
    }

    public List<Common.AttributeSimple> _getPlayerAttr() {
        List<Common.AttributeSimple> list = new ArrayList<>();
        for (Const.PlayerBtlData pbd : this.finalInflus.keySet()) {
            Common.AttributeSimple.Builder asb = Common.AttributeSimple.newBuilder();
            asb.setId(pbd.id);
            asb.setValue(((Integer) this.finalInflus.get(pbd)).intValue());
            list.add(asb.build());
        }
        return list;
    }

    public int getPlayerBtlPropValue(Const.PlayerBtlData pbd) {
        if (this.finalInflus.containsKey(pbd)) {
            return ((Integer) this.finalInflus.get(pbd)).intValue();
        }
        return 0;
    }

    public void onMountPropChange() {
        this.data_mount = this.player.mountManager.data_mount_final;
        calFinalData();
    }


    private void onPetPropChange() {
        calFinalData();
    }


    public void onDaoYouChange() {
        calDaoYouData();
        calFinalData();
    }

    public void onGuildBossInpire() {
        calFinalData();
    }

    public void calDaoYouData() {
        DaoYouPO dyp = DaoYouService.getInstance().getDaoYou(this.player.getId());
        if (dyp == null) {
            this.data_dao_you.clear();
            return;
        }
        String daoYouId = dyp.id;
        Map<Const.PlayerBtlData, Integer> tempDataDaoYou = DaoYouCenter.getInstance().getDaoYouBtl(daoYouId);
        if (tempDataDaoYou == null) {
            return;
        }
        this.data_dao_you = tempDataDaoYou;
    }


    public void onPlayerEvent(Const.PlayerEventType eventType) {
        switch (eventType) {
            case UPGRADE:
                onPlayerUpgrade();
                break;
            case CLASS_UPGRADE:
                onClassLvlUp();
                break;
            case EQUIPMENT_CHANGE:
                onEquipChange();
                break;
            case PET_PROP_CHANGE:
                onPetPropChange();
                break;
            case GUILD_BLESS_CHANGE:
            case GUILD_TECH_CHANGE:
            case TITLE_CHANGE:
            case UPGRADE_TALENT_PASSIVE_SKILL:
                calFinalData();
                break;
            case EXCHANGE_PROPARTY:
                onExchangeProparty();
                break;
        }
    }


    public Const.ManagerType getManagerType() {
        return Const.ManagerType.BTL_DATA;
    }
}


