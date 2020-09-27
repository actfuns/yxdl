package com.wanniu.game.equip;

import com.google.protobuf.GeneratedMessage;
import com.wanniu.core.common.IntIntPair;
import com.wanniu.core.game.entity.GEntity;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.DateUtil;
import com.wanniu.core.util.RandomUtil;
import com.wanniu.core.util.StringUtil;
import com.wanniu.game.GWorld;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.ConstsTR;
import com.wanniu.game.common.Utils;
import com.wanniu.game.common.msg.WNNotifyManager;
import com.wanniu.game.data.EquipSockCO;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.base.DEquipBase;
import com.wanniu.game.data.base.DItemBase;
import com.wanniu.game.data.base.FourProp;
import com.wanniu.game.data.ext.AffixExt;
import com.wanniu.game.data.ext.EnchantBonusExt;
import com.wanniu.game.data.ext.EnchantExt;
import com.wanniu.game.data.ext.EquipMakeExt;
import com.wanniu.game.data.ext.EquipSockExt;
import com.wanniu.game.data.ext.ReBornExt;
import com.wanniu.game.data.ext.ReBuildExt;
import com.wanniu.game.data.ext.RefineExt;
import com.wanniu.game.data.ext.SeniorReBuildExt;
import com.wanniu.game.data.ext.SmritiExt;
import com.wanniu.game.data.ext.SuitListExt;
import com.wanniu.game.item.ItemConfig;
import com.wanniu.game.item.ItemUtil;
import com.wanniu.game.item.NormalItem;
import com.wanniu.game.item.data.AttsObj;
import com.wanniu.game.item.po.PlayerItemPO;
import com.wanniu.game.player.AttributeUtil;
import com.wanniu.game.player.BILogService;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.PlayerBasePO;
import com.wanniu.game.poes.RedPointPO;
import com.wanniu.game.rank.RankType;
import com.wanniu.game.sevengoal.SevenGoalManager;
import com.wanniu.game.task.TaskUtils;
import com.wanniu.redis.PlayerPOManager;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import pomelo.Common;
import pomelo.area.PlayerHandler;
import pomelo.item.ItemOuterClass;
import pomelo.player.PlayerOuterClass;


public class EquipManager {
    public WNPlayer player;
    public Map<Integer, NormalEquip> equips;
    public Map<Integer, PlayerBasePO.EquipStrengthPos> strengthPos;
    public int effectTypeId;
    public boolean isEffectTypeFlush;
    public int maxStrengthLevel;
    public Map<Integer, Integer> redpoints;

    public EquipManager(WNPlayer player, Map<Integer, PlayerItemPO> equipDatas, Map<Integer, PlayerBasePO.EquipStrengthPos> strengthPos) {
        this.player = player;
        this.strengthPos = strengthPos;
        this.redpoints = new ConcurrentHashMap<>();

        _init(equipDatas);
    }

    private void _init(Map<Integer, PlayerItemPO> equipDatas) {
        this.equips = new ConcurrentHashMap<>();

        Iterator<Integer> keys = equipDatas.keySet().iterator();
        while (keys.hasNext()) {
            int gridIndex = ((Integer) keys.next()).intValue();
            if (equipDatas.get(Integer.valueOf(gridIndex)) == null)
                continue;
            NormalEquip equip = (NormalEquip) ItemUtil.createItemByDbOpts(equipDatas.get(Integer.valueOf(gridIndex)));
            if (equip != null) {
                this.equips.put(Integer.valueOf(gridIndex), equip);
            }
        }


        this.maxStrengthLevel = EquipCraftConfig.getInstance().getMaxStrengthLevel();
    }


    public NormalEquip getEquipment(int pos) {
        return this.equips.get(Integer.valueOf(pos));
    }


    public int getEquipmentById(String id) {
        for (Iterator<Integer> iterator = this.equips.keySet().iterator(); iterator.hasNext(); ) {
            int pos = ((Integer) iterator.next()).intValue();
            NormalEquip equip = getEquipment(pos);
            if (equip != null && equip.itemDb.id.equals(id)) {
                return pos;
            }
        }

        return 0;
    }

    public NormalEquip getEquipById(String id) {
        for (Iterator<Integer> iterator = this.equips.keySet().iterator(); iterator.hasNext(); ) {
            int pos = ((Integer) iterator.next()).intValue();
            NormalEquip equip = this.equips.get(Integer.valueOf(pos));
            if (equip.itemDb.id.equals(id)) {
                return equip;
            }
        }

        return null;
    }

    public List<SmritiExt> findSmritiCO(int lv) {
        List<SmritiExt> list = GameData.findSmritis(t -> (t.level == lv));


        return list;
    }


    public ItemOuterClass.EquipGridStrengthInfo getStrenghInfo(int pos) {
        PlayerBasePO.EquipStrengthPos info = this.strengthPos.get(Integer.valueOf(pos));
        ItemOuterClass.EquipGridStrengthInfo.Builder data = ItemOuterClass.EquipGridStrengthInfo.newBuilder();
        data.setPos(pos);
        data.setEnSection(info.enSection);
        data.setEnLevel(info.enLevel);
        data.addAllJewelAtts(EquipUtil.toJson4Gem(info));
        data.setSocks(info.socks);
        return data.build();
    }


    public List<ItemOuterClass.EquipGridStrengthInfo> toJson4StrengthPos() {
        List<ItemOuterClass.EquipGridStrengthInfo> list = new ArrayList<>();
        if (this.strengthPos == null)
            return list;
        for (Iterator<Integer> iterator = this.strengthPos.keySet().iterator(); iterator.hasNext(); ) {
            int pos = ((Integer) iterator.next()).intValue();
            list.add(getStrenghInfo(pos));
        }

        return list;
    }

    public PlayerOuterClass.Equipments toJson4Payload() {
        PlayerOuterClass.Equipments.Builder data = PlayerOuterClass.Equipments.newBuilder();
        List<ItemOuterClass.Grid> equips = new ArrayList<>();
        for (Iterator<Integer> iterator = this.equips.keySet().iterator(); iterator.hasNext(); ) {
            int pos = ((Integer) iterator.next()).intValue();
            equips.add(getEquip4PayLoad(pos));
        }

        data.addAllEquips(equips);
        return data.build();
    }

    public List<ItemOuterClass.ItemDetail> getAllEquipDetails4PayLoad() {
        List<ItemOuterClass.ItemDetail> data = new ArrayList<>();
        for (NormalEquip equip : this.equips.values()) {
            data.add(equip.getItemDetail(this.player.playerBasePO).build());
        }
        return data;
    }

    public ItemOuterClass.Grid getEquip4PayLoad(int pos) {
        ItemOuterClass.Grid.Builder equipGrid = ItemOuterClass.Grid.newBuilder();
        equipGrid.setGridIndex(pos);
        NormalItem equip = this.equips.get(Integer.valueOf(pos));
        if (equip != null) {
            equipGrid.setItem(equip.toJSON4GridPayload());
        }
        return equipGrid.build();
    }


    public boolean isAvatarPart(int pos) {
        boolean mainBool = (pos == Const.EquipType.MAIN_HAND.getValue());
        boolean clothBool = (pos == Const.EquipType.CLOTH.getValue());
        return (mainBool || clothBool);
    }


    public boolean equip(NormalEquip equipment) {
        if (equipment != null) {
            NormalEquip oldequip = this.equips.get(Integer.valueOf(equipment.getPosition()));

            this.equips.put(Integer.valueOf(equipment.getPosition()), equipment);

            if (equipment.getBind() == 2) {
                equipment.setBind(1);
                _updateAndPush(new int[]{equipment.getPosition()}, true);
            } else {
                _updateAndPush(new int[]{equipment.getPosition()}, false);
            }

            if (isAvatarPart(equipment.getPosition()) && StringUtil.isNotEmpty(equipment.prop.avatarId)) {
                if (oldequip == null) {
                    if (equipment.getPosition() == Const.EquipType.CLOTH.getValue()) {
                        if (!this.player.basicProp.model.equals(String.valueOf(equipment.prop.avatarId))) {
                            this.player.refreshBattlerServerAvatar();
                        }
                    } else if (equipment.getPosition() == Const.EquipType.MAIN_HAND.getValue() &&
                            !this.player.basicProp.weaponmodel.equals(String.valueOf(equipment.prop.avatarId))) {
                        this.player.refreshBattlerServerAvatar();
                    }

                } else if (oldequip.prop.avatarId != equipment.prop.avatarId) {
                    this.player.refreshBattlerServerAvatar();
                }
            }


            equipSync(Const.GOODS_CHANGE_TYPE.equip);

            PlayerBasePO.EquipStrengthPos strengthLevel = this.strengthPos.get(Integer.valueOf(equipment.getPosition()));
            if (strengthLevel.enSection > 0 || strengthLevel.enLevel > 0) {

                this.player.taskManager.dealTaskEvent(Const.TaskType.TRAIN_EQUIP, String.valueOf(equipment.getPosition()), strengthLevel.enSection * (GlobalConfig.EquipmentCraft_Enchant_MaxenLevel + 1) + strengthLevel.enLevel);
                TaskUtils.dealTrainEquipAllTask(this.player);
            }
            this.player.taskManager.dealTaskEvent(Const.TaskType.TAKE_EQUIP_Qt, equipment.getQLevel() + "|" + equipment.getQColor() + "|" + equipment.getPosition(), 1);


            ansycReportEquipChange(equipment, 1, equipment.getPosition());

            return true;
        }
        return false;
    }


    private void ansycReportEquipChange(NormalEquip equip, int type, int position) {
        if (equip.getQColor() < 4) {
            return;
        }
        try {
            Map<String, Object> data = new HashMap<>();
            data.put("equipCode", equip.prop.code);
            data.put("equipName", equip.prop.name);

            for (SuitListExt config : GameData.SuitLists.values()) {
                if (config.isValid == 0) {
                    continue;
                }
                if (this.player.getLevel() < config.level) {
                    continue;
                }

                if (config.partCodes.contains(equip.prop.code)) {
                    data.put("suitID", Integer.valueOf(config.suitID));
                    data.put("suitName", config.suitName);

                    break;
                }
            }
            BILogService.getInstance().ansycReportEquipChange(this.player.getPlayer(), type, position, data);
        } catch (Exception e) {
            Out.warn(new Object[]{"ansycReportEquipChange", e});
        }
    }


    public boolean unEquip(int position) {
        if (this.equips.size() == 0) {
            return false;
        }
        NormalEquip oldequip = this.equips.get(Integer.valueOf(position));

        this.equips.remove(Integer.valueOf(position));

        _updateAndPush(new int[]{position}, false);
        if (isAvatarPart(position)) {
            DEquipBase prop = oldequip.prop;
            if (oldequip.getPosition() == Const.EquipType.CLOTH.getValue()) {
                if (!this.player.basicProp.model.equals(String.valueOf(prop.avatarId))) {
                    this.player.refreshBattlerServerAvatar();
                }
            } else if (oldequip.getPosition() == Const.EquipType.MAIN_HAND.getValue() &&
                    !this.player.basicProp.weaponmodel.equals(String.valueOf(prop.avatarId))) {
                this.player.refreshBattlerServerAvatar();
            }
        }

        equipSync();


        ansycReportEquipChange(oldequip, 2, oldequip.getPosition());

        return true;
    }


    public boolean DropEquipAndReturn(int position) {
        if (unEquip(position)) {
            return true;
        }
        return false;
    }


    public boolean fillGem(int pos, int[] index, String code, WNPlayer player) {
        PlayerBasePO.EquipStrengthPos posInfo = this.strengthPos.get(Integer.valueOf(pos));
        if (posInfo != null &&
                EquipUtil.fillGem(posInfo, index, code, player)) {
            _updateAndPushPOS(new int[]{pos}, true);

            equipSync();
            this.player.getPlayerTasks().dealTaskEvent(Const.TaskType.FILL_GEM, code, 1);

            updateGemLevelRank();


            player.achievementManager.onGemFillTotalLevel();

            updateFillGemScript(null);
            return true;
        }

        return false;
    }

    public void updateGemLevelRank() {
        int level = 0;
        for (PlayerBasePO.EquipStrengthPos pos : this.player.equipManager.strengthPos.values()) {
            for (String code : pos.gems.values()) {
                if (StringUtil.isEmpty(code))
                    continue;
                DItemBase prop = ItemUtil.getUnEquipPropByCode(code);
                level += prop.levelReq;
            }
        }

        this.player.rankManager.onEvent(RankType.GemLevel, new Object[]{Integer.valueOf(level)});
    }


    public boolean unfillGem(int pos, int index) {
        PlayerBasePO.EquipStrengthPos posInfo = this.strengthPos.get(Integer.valueOf(pos));
        if (posInfo != null) {
            String code = (String) posInfo.gems.get(Integer.valueOf(index));
            if (StringUtil.isEmpty(code)) {
                return false;
            }

            posInfo.gems.remove(Integer.valueOf(index));

            NormalItem item = ItemUtil.createItemsByItemCode(code, 1).get(0);
            this.player.bag.addEntityItem(item, Const.GOODS_CHANGE_TYPE.equipmosaic, null, false, false);

            _updateAndPushPOS(new int[]{pos}, true);
            equipSync();


            updateGemLevelRank();
            return true;
        }
        return false;
    }

    public void _updateAndPushPOS(int[] gridIndexs, boolean refresh) {
        update();
        WNNotifyManager.getInstance().pushEquipmentPOS(this.player, gridIndexs, refresh);
        WNNotifyManager.getInstance().pushEquipmentDynamic(this.player, gridIndexs, refresh);
    }

    public void _updateAndPush(int[] gridIndexs, boolean refresh) {
        _updateAndPush(gridIndexs, refresh, true);
    }


    public void _updateAndPush(int[] gridIndexs, boolean refresh, boolean isDressed) {
        update();
        if (isDressed) {
            WNNotifyManager.getInstance().pushEquipmentDynamic(this.player, gridIndexs, refresh);
        } else {
            List<Integer> list = new ArrayList<>();
            for (int pos : gridIndexs) {
                list.add(Integer.valueOf(pos));
            }
            WNNotifyManager.getInstance().pushBagItemDynamic(this.player, list, refresh);
        }
    }

    public Map<String, Integer> calAllInfluence() {
        Map<String, Integer> data = new ConcurrentHashMap<>();
        Iterator<Integer> iterator;
        for (iterator = this.strengthPos.keySet().iterator(); iterator.hasNext(); ) {
            int position = ((Integer) iterator.next()).intValue();

            NormalEquip equip = getEquipment(position);


            if (equip != null) {
                if (equip.speData.extAtts == null) {
                    Utils.deepCopy(data, equip.prop.fixedAtts);
                } else {
                    Utils.deepCopyAffix(data, equip.speData.extAtts, equip.getQColor());
                }
                if (equip.speData.extAttsAdd != null) {
                    Utils.deepCopy(data, equip.speData.extAttsAdd);
                }

                Utils.deepCopyAffix(data, equip.speData.legendAtts, equip.getQColor());
            }

            PlayerBasePO.EquipStrengthPos strengthInfo = this.strengthPos.get(Integer.valueOf(position));
            if (strengthInfo == null || (strengthInfo.enSection == 0 && strengthInfo.enLevel == 0)) {
                if (equip != null) {
                    Utils.deepCopy(data, equip.speData.baseAtts);
                }
                continue;
            }
            if (equip != null) {
                EnchantExt enchantExt = (EnchantExt) GameData.Enchants.get(Integer.valueOf(strengthInfo.enSection * 100 + strengthInfo.enLevel));
                if (equip.speData.baseAtts != null && enchantExt != null) {
                    for (String key : equip.speData.baseAtts.keySet()) {
                        int value = ((Integer) equip.speData.baseAtts.get(key)).intValue();
                        value = value * (10000 + enchantExt.propPer) / 10000;
                        if (data.containsKey(key)) {
                            data.put(key, Integer.valueOf(((Integer) data.get(key)).intValue() + value));
                            continue;
                        }
                        data.put(key, Integer.valueOf(value));
                    }
                }
            }


            if (strengthInfo.enSection > 0) {
                for (int section = 1; section <= strengthInfo.enSection; section++) {
                    for (EnchantBonusExt enchantBonusCO : GameData.EnchantBonuss.values()) {
                        if (enchantBonusCO._type == position && enchantBonusCO.enClass == section) {
                            if (data.containsKey(enchantBonusCO._prop)) {
                                data.put(enchantBonusCO._prop, Integer.valueOf(((Integer) data.get(enchantBonusCO._prop)).intValue() + enchantBonusCO.min));
                                break;
                            }
                            data.put(enchantBonusCO._prop, Integer.valueOf(enchantBonusCO.min));


                            break;
                        }
                    }
                }
            }
        }


        for (iterator = this.strengthPos.keySet().iterator(); iterator.hasNext(); ) {
            int position = ((Integer) iterator.next()).intValue();
            PlayerBasePO.EquipStrengthPos strengthInfo = this.strengthPos.get(Integer.valueOf(position));
            for (Iterator<Integer> iterator1 = strengthInfo.gems.keySet().iterator(); iterator1.hasNext(); ) {
                int index = ((Integer) iterator1.next()).intValue();
                String code = (String) strengthInfo.gems.get(Integer.valueOf(index));
                DItemBase prop = (DItemBase) ItemConfig.getInstance().getItemProp(code);
                String key = AttributeUtil.getKeyByName(prop.prop);
                if (StringUtil.isEmpty(key)) {
                    Out.error(new Object[]{EquipUtil.class, "Equip fillGem config error code ", code, ",index=", Integer.valueOf(index)});

                    continue;
                }
                String gemProp = AttributeUtil.getKeyByName(prop.prop);
                int gemValue = prop.min;
                if (data.containsKey(gemProp)) {
                    data.put(gemProp, Integer.valueOf(((Integer) data.get(gemProp)).intValue() + gemValue));
                    continue;
                }
                data.put(gemProp, Integer.valueOf(gemValue));
            }
        }


        List<IntIntPair> list_suits = EquipCraftConfig.getInstance().getValidSuits(this.player);
        Map<String, Integer> suitAttr = EquipCraftConfig.getInstance().getSuitAtts(list_suits);
        Utils.deepCopy(data, suitAttr);

        return data;
    }


    public void sendNotice(WNPlayer player, NormalEquip equip) {
    }


    public Object[] equipStrengthen(int pos) {
        NormalEquip equip = getEquipment(pos);
        Object[] result = {Boolean.valueOf(true), Integer.valueOf(0)};


        PlayerBasePO.EquipStrengthPos pair = this.strengthPos.get(Integer.valueOf(pos));


        EnchantExt enchantExt = EquipUtil.getStrengthConfig(pair.enSection, pair.enLevel);
        if (enchantExt == null) {
            Out.error(new Object[]{"无法获取强化配置！"});
            return result;
        }


        int oldLevel = pair.enSection * 100 + pair.enLevel;

        pair.enSection = enchantExt.enClass;
        pair.enLevel = enchantExt.enLevel;
        Out.info(new Object[]{"强化部位 playerId=", this.player.getId(), ",pos=", Integer.valueOf(pos), ",level=", Integer.valueOf(pair.enSection * 10 + pair.enLevel)});


        int tmpEffectTypeId = EquipUtil.getEffectTypeId(pair.enSection, pair.enLevel);
        if (this.effectTypeId != tmpEffectTypeId) {
            this.isEffectTypeFlush = true;
        } else {
            this.isEffectTypeFlush = false;
        }
        this.effectTypeId = tmpEffectTypeId;

        if (((Boolean) result[0]).booleanValue()) {
            sendNotice(this.player, equip);

            _updateAndPushPOS(new int[]{pos}, true);

            if (isAvatarPart(pos) &&
                    this.isEffectTypeFlush) {
                this.player.refreshBattlerServerAvatar();
            }

            equipSync();
            int newLevel = pair.enSection * (GlobalConfig.EquipmentCraft_Enchant_MaxenLevel + 1) + pair.enLevel;
            this.player.taskManager.dealTaskEvent(Const.TaskType.TRAIN_EQUIP, String.valueOf(pos), newLevel);
            TaskUtils.dealTrainEquipAllTask(this.player);
            this.player.achievementManager.equipEnhance(pos, newLevel);
            this.player.achievementManager.onEquipPosStrengthLevel(pos, newLevel);

            updateStrengthScript(null);

            this.player.sevenGoalManager.processGoal(SevenGoalManager.SevenGoalTaskType.EQUIP_STRENTHEN_COUNT, new Object[]{Integer.valueOf(getTotalStrenthenLv())});

            BILogService.getInstance().ansycReportStrengthenCultivate(this.player.getPlayer(), pos, oldLevel, pair.enSection * 100 + pair.enLevel, enchantExt.mates);
            return result;
        }

        return result;
    }

    private void equipSync() {
        equipSync(Const.GOODS_CHANGE_TYPE.def);
    }


    private void equipSync(Const.GOODS_CHANGE_TYPE from) {
        this.player.btlDataManager.data_equip = calAllInfluence();
        this.player.onEquipChange(from);
    }


    public int weaponNum() {
        int num = 0;
        if (this.equips.get(Integer.valueOf(Const.EquipType.MAIN_HAND.getValue())) != null) {
            num++;
        }


        return num;
    }


    public boolean haveBothHandWeapon() {
        NormalEquip mainH = this.equips.get(Integer.valueOf(Const.EquipType.MAIN_HAND.getValue()));
        if (mainH != null && mainH.prop.isBothHand == 1) {
            return true;
        }


        return false;
    }


    public boolean haveSingleHandWeapon() {
        NormalEquip mainH = this.equips.get(Integer.valueOf(Const.EquipType.MAIN_HAND.getValue()));
        if (mainH != null && mainH.prop.isBothHand == 0) {
            return true;
        }


        return false;
    }


    public static class ResultEquipNumAndQt {
        public boolean isEnoughNum;


        public int value;
    }


    public ResultEquipNumAndQt equipNumAndQt(int num, int qt) {
        ResultEquipNumAndQt result = new ResultEquipNumAndQt();
        result.isEnoughNum = false;
        result.value = 0;
        int equpNum = 0;
        for (Iterator<Integer> iterator = this.equips.keySet().iterator(); iterator.hasNext(); ) {
            int pos = ((Integer) iterator.next()).intValue();
            NormalEquip equip = this.equips.get(Integer.valueOf(pos));
            if (qt != 0) {
                if (equip.getQColor() >= qt)
                    equpNum++;
                continue;
            }
            equpNum++;
        }


        if (equpNum >= num) {
            result.isEnoughNum = true;
        }
        result.value = equpNum;
        return result;
    }


    public static class EquipAndLevelData {
        public int maxLevel;

        public Map<Integer, PlayerBasePO.EquipStrengthPos> equips;
    }


    public EquipAndLevelData getAllEquipAndLevel() {
        EquipAndLevelData arr = new EquipAndLevelData();
        arr.equips = new HashMap<>();
        arr.maxLevel = 0;
        for (Map.Entry<Integer, PlayerBasePO.EquipStrengthPos> node : this.strengthPos.entrySet()) {
            PlayerBasePO.EquipStrengthPos sectionAndLevel = node.getValue();
            arr.equips.put(node.getKey(), node.getValue());

            int maxLevel = sectionAndLevel.enSection * (GlobalConfig.EquipmentCraft_Enchant_MaxenLevel + 1) + sectionAndLevel.enLevel;
            if (arr.maxLevel < maxLevel) {
                arr.maxLevel = maxLevel;
            }
        }
        return arr;
    }


    public int hasAllStrenghLevel(int lv) {
        int validNum = 0;
        for (int i = 1; i <= Const.EquipType.CHARM.getValue(); i++) {
            PlayerBasePO.EquipStrengthPos pair = this.strengthPos.get(Integer.valueOf(i));
            if (pair != null) {

                if (pair.enLevel >= lv)
                    validNum++;
            }
        }
        return validNum;
    }


    public void reborn(NormalEquip equip, int pos, boolean isDressed) {
        if (equip.itemDb.isNew == 1) {
            equip.itemDb.isNew = 0;
        }
        DEquipBase finalProp = equip.prop;
        if (StringUtil.isNotEmpty(equip.prop.baseCode)) {
            finalProp = ItemConfig.getInstance().getEquipProp(equip.prop.baseCode);
        }

        equip.speData.tempBaseAtts = new HashMap<>();
        for (String attrName : finalProp.baseAtts.keySet()) {
            FourProp pair = (FourProp) finalProp.baseAtts.get(attrName);
            if (pair == null) {
                continue;
            }
            equip.speData.tempBaseAtts.put(pair.prop, Integer.valueOf(RandomUtil.getInt(pair.min, pair.max)));
        }
        if (isDressed) {
            _updateAndPush(new int[]{pos}, true);
        } else {

            _updateAndPush(new int[]{pos}, true, false);
        }


        this.player.taskManager.dealTaskEvent(Const.TaskType.EQUIP_REBORN, "", 1);

        this.player.achievementManager.onEquipReborn();
    }


    public void saveReborn(NormalEquip equip, int pos, boolean isDressed) {
        if (equip.speData.tempBaseAtts == null) {
            return;
        }
        if (equip.itemDb.isNew == 1) {
            equip.itemDb.isNew = 0;
        }
        equip.speData.baseAtts = equip.speData.tempBaseAtts;
        equip.speData.tempBaseAtts = null;

        if (isDressed) {
            _updateAndPush(new int[]{pos}, true);
            equipSync(Const.GOODS_CHANGE_TYPE.saveReborn);
        } else {
            _updateAndPush(new int[]{pos}, true, false);
        }
    }

    private boolean contain(List<Integer> val, int index) {
        for (Iterator<Integer> iterator = val.iterator(); iterator.hasNext(); ) {
            int i = ((Integer) iterator.next()).intValue();
            if (i == index) {
                return true;
            }
        }


        return false;
    }


    public boolean checkRebuildLocks(List<Integer> lockIndexs, int attrSize) {
        int maxLockSize = getCanLockNum(attrSize);

        if (maxLockSize < 0 || lockIndexs.size() > maxLockSize) {
            return false;
        }

        for (Iterator<Integer> iterator = lockIndexs.iterator(); iterator.hasNext(); ) {
            int lockIndex = ((Integer) iterator.next()).intValue();
            if (lockIndex < 1 || lockIndex > attrSize) {
                return false;
            }
        }


        return true;
    }


    private int getCanLockNum(int attrSize) {
        int maxLockSize = 0;

        switch (attrSize) {
            case 3:
                maxLockSize = GlobalConfig.Equipment_ReBuild_MaxNumtoLock3;
                break;
            case 4:
                maxLockSize = GlobalConfig.Equipment_ReBuild_MaxNumtoLock4;
                break;
            case 5:
                maxLockSize = GlobalConfig.Equipment_ReBuild_MaxNumtoLock5;
                break;
        }

        return maxLockSize;
    }


    public void rebuild(NormalEquip equip, int pos, boolean isDressed, List<Integer> lockedAttIdList) {
        if (equip.itemDb.isNew == 1) {
            equip.itemDb.isNew = 0;
        }
        equip.speData.tempExtAtts = new RepeatKeyMap<>();
        equip.speData.tempExtAttsAdd = null;

        int index = 1;

        for (RepeatKeyMap.Pair<Integer, Integer> rp : (Iterable<RepeatKeyMap.Pair<Integer, Integer>>) equip.speData.extAtts.entrySet()) {
            if (contain(lockedAttIdList, index)) {
                equip.speData.tempExtAtts.put(rp.k, rp.v);
            } else {
                equip.speData.tempExtAtts.put(new RepeatKeyMap.Pair<>(Integer.valueOf(0), Integer.valueOf(0)));
            }
            index++;
        }

        DEquipBase finalProp = equip.prop;
        if (StringUtil.isNotEmpty(equip.prop.baseCode)) {
            finalProp = ItemConfig.getInstance().getEquipProp(equip.prop.baseCode);
        }

        ItemUtil.initRebuildExtAtts(equip.speData.tempExtAtts, finalProp, (equip.speData.extAtts == null) ? equip.prop.fixedAtts.size() : equip.speData.extAtts.size(), lockedAttIdList.size());
        Map<String, Integer> exarAttr = ItemUtil.getSameAttsExtAttributes(equip.speData.tempExtAtts, equip.prop.type, equip.prop.code);
        if (exarAttr != null) {
            equip.speData.tempExtAttsAdd = exarAttr;
        }

        if (isDressed) {
            _updateAndPush(new int[]{pos}, true);
        } else {
            _updateAndPush(new int[]{pos}, true, false);
        }


        this.player.taskManager.dealTaskEvent(Const.TaskType.EQUIP_REBUILD, "", 1);
        this.player.achievementManager.onEquipRebuild();
    }


    public void seniorRebuild(NormalEquip equip, int pos, boolean isDressed) {
        if (equip.itemDb.isNew == 1) {
            equip.itemDb.isNew = 0;
        }

        equip.speData.tempExtAtts_senior = new RepeatKeyMap<>();

        DEquipBase finalProp = equip.prop;
        if (StringUtil.isNotEmpty(equip.prop.baseCode)) {
            finalProp = ItemConfig.getInstance().getEquipProp(equip.prop.baseCode);
        }

        ItemUtil.seniorInitExtAtts(equip.speData.extAtts, equip.speData.tempExtAtts_senior, finalProp);

        if (isDressed) {
            _updateAndPush(new int[]{pos}, true);
            equipSync();
        } else {
            _updateAndPush(new int[]{pos}, true, false);
        }


        this.player.taskManager.dealTaskEvent(Const.TaskType.EQUIP_REBUILD, "", 1);
        this.player.achievementManager.onEquipRebuild();
    }


    public void saveRebuild(NormalEquip equip, int pos, boolean isDressed) {
        if (equip.speData.tempExtAtts == null) {
            return;
        }
        if (equip.itemDb.isNew == 1) {
            equip.itemDb.isNew = 0;
        }
        equip.speData.extAtts = equip.speData.tempExtAtts;
        equip.speData.extAttsAdd = equip.speData.tempExtAttsAdd;
        equip.speData.tempExtAttsAdd = null;
        equip.speData.tempExtAtts = null;

        equip.speData.tempExtAtts_senior = null;


        equip.speData.tempUniqueAtts = null;

        if (isDressed) {
            _updateAndPush(new int[]{pos}, true);
            equipSync(Const.GOODS_CHANGE_TYPE.saveReborn);
        } else {
            _updateAndPush(new int[]{pos}, true, false);
        }
    }

    public void smritiEquip(NormalEquip leftEquip, int leftPos, boolean leftIsDressed, NormalEquip rightEquip, int rightPos, boolean rightIsDressed) {
        rightEquip.speData.extAtts.clear();
        copyAtts(leftEquip, rightEquip, leftEquip.speData.extAtts, rightEquip.speData.extAtts);
        rightEquip.speData.extAttsAdd = leftEquip.speData.extAttsAdd;


        leftEquip.speData.extAtts.clear();
        leftEquip.speData.extAttsAdd = null;

        if (leftEquip.itemDb.isNew == 1) {
            leftEquip.itemDb.isNew = 0;
        }

        if (rightEquip.itemDb.isNew == 1) {
            rightEquip.itemDb.isNew = 0;
        }

        ItemUtil.initExtAtts(leftEquip.speData.extAtts, leftEquip.prop, 0, 0);

        _updateAndPush(new int[]{leftPos}, true, leftIsDressed);
        _updateAndPush(new int[]{rightPos}, true, rightIsDressed);

        if (leftIsDressed || rightIsDressed) {
            equipSync(Const.GOODS_CHANGE_TYPE.smriti_equip);
        }
    }

    private void copyAtts(NormalEquip leftEquip, NormalEquip rightEquip, RepeatKeyMap<Integer, Integer> source, RepeatKeyMap<Integer, Integer> dist) {
        if (source != null && !source.isEmpty()) {
            List<RepeatKeyMap.Pair<Integer, Integer>> list = source.getValues();
            for (RepeatKeyMap.Pair<Integer, Integer> k : list) {
                AffixExt affix = (AffixExt) GameData.Affixs.get(k.k);
                if (affix == null) {
                    Out.warn(new Object[]{"key=" + k.k + " val=" + k.v});
                    continue;
                }
                AffixExt finalAffix = ItemUtil.getFixOneAtts(rightEquip.prop.tcLevel, rightEquip.prop.type, rightEquip.prop.pro, Const.AffixType.normal, affix.attName);
                if (finalAffix == null) {
                    dist.put((Integer) k.k, (Integer) k.v);
                    Out.error(new Object[]{"smritiEquip can't find dist attr。src:" + leftEquip.getId() + "," + k.k + "," + k.v + " dist:" + rightEquip.getId()});
                    continue;
                }
                FourProp rdProp = (FourProp) finalAffix.props.get(Integer.valueOf(rightEquip.prop.qcolor));
                if (rdProp == null) {
                    dist.put(Integer.valueOf(finalAffix.iD), (Integer) k.v);
                    Out.error(new Object[]{"smritiEquip can't find dist qcolor。src:" + leftEquip.getId() + "," + k.k + "," + k.v + " dist:" + rightEquip.getId()});

                    continue;
                }
                int finalVal = ((Integer) k.v).intValue();
                if (finalVal > rdProp.max) {
                    finalVal = rdProp.max;
                    Out.error(new Object[]{"smritiEquip exceed max value。src:" + leftEquip.getId() + "," + k.k + "," + k.v + " dist:" + rightEquip.getId() + "," + k.k + "," + rdProp.max});
                }
                int min = ItemUtil.calcRebuildPropMin(rdProp.min);
                if (finalVal < min) {
                    finalVal = min;
                    Out.info(new Object[]{"smritiEquip less min value。src:" + leftEquip.getId() + "," + k.k + "," + k.v + " dist:" + rightEquip.getId() + "," + k.k + "," + min});
                }
                dist.put(Integer.valueOf(finalAffix.iD), Integer.valueOf(finalVal));
            }
        }
    }


    public void saveSeniorRebuild(NormalEquip equip, int pos, boolean isDressed) {
        if (equip.speData.tempExtAtts_senior == null) {
            return;
        }
        if (equip.itemDb.isNew == 1) {
            equip.itemDb.isNew = 0;
        }
        equip.speData.extAtts = equip.speData.tempExtAtts_senior;

        equip.speData.tempExtAtts_senior = null;


        equip.speData.tempUniqueAtts = null;

        if (isDressed) {
            _updateAndPush(new int[]{pos}, true);
            equipSync(Const.GOODS_CHANGE_TYPE.saveReborn);
        } else {
            _updateAndPush(new int[]{pos}, true, false);
        }
    }


    public void refineLegend(NormalEquip equip, int pos, boolean isDressed) {
        if (equip.itemDb.speData.legendAtts == null) {
            return;
        }

        if (equip.itemDb.isNew == 1) {
            equip.itemDb.isNew = 0;
        }

        List<Integer> usedGroupId = new ArrayList<>();


        DEquipBase finalProp = equip.prop;
        if (StringUtil.isNotEmpty(equip.prop.baseCode)) {
            finalProp = ItemConfig.getInstance().getEquipProp(equip.prop.baseCode);
        }

        AffixExt affxExt = ItemUtil.initOneAtts(finalProp, usedGroupId, Const.AffixType.legend);

        FourProp rdProp = (FourProp) affxExt.props.get(Integer.valueOf(equip.prop.qcolor));
        if (rdProp == null) {
            return;
        }

        equip.speData.tempUniqueAtts = new HashMap<>();
        equip.speData.tempUniqueAtts.put(Integer.valueOf(affxExt.iD), Integer.valueOf(RandomUtil.getInt(rdProp.min, rdProp.max)));

        if (isDressed) {
            _updateAndPush(new int[]{pos}, true);
            equipSync();
        } else {
            _updateAndPush(new int[]{pos}, true, false);
        }


        this.player.taskManager.dealTaskEvent(Const.TaskType.EQUIP_REFINE, "", 1);
        this.player.achievementManager.onEquipRefine();
    }


    public void saveRefineLegend(NormalEquip equip, int pos, boolean isDressed) {
        if (equip.speData.tempUniqueAtts == null) {
            return;
        }
        if (equip.itemDb.isNew == 1) {
            equip.itemDb.isNew = 0;
        }


        equip.itemDb.speData.legendAtts = equip.speData.tempUniqueAtts;
        equip.speData.tempUniqueAtts = null;

        if (isDressed) {
            _updateAndPush(new int[]{pos}, true);
            equipSync();
        } else {
            _updateAndPush(new int[]{pos}, true, false);
        }
    }

    public List<Common.AttributeBase> getRefineExtProp(NormalEquip equip) {
        List<Common.AttributeBase> result = new ArrayList<>();
        DEquipBase extProp = equip.prop;
        if (StringUtil.isNotEmpty(equip.prop.baseCode)) {
            extProp = ItemConfig.getInstance().getEquipProp(equip.prop.baseCode);
        }

        List<AttsObj> extAtts = new ArrayList<>();
        ItemUtil.initAllExtAtts(extAtts, extProp);

        for (AttsObj att : extAtts) {
            result.add(EquipUtil.getAttributeBase(att));
        }
        return result;
    }

    public List<PlayerHandler.SuperScriptType> getSuperScript() {
        List<PlayerHandler.SuperScriptType> list = new ArrayList<>();
        list.addAll(getWorkSuperScript());
        list.addAll(getStrengthSuperScript());
        list.addAll(getGemFillSuperScript(null));
        list.addAll(getEquipSuperScript(null));
        return list;
    }

    public void pushScripts() {
        PlayerHandler.SuperScriptPush.Builder data = PlayerHandler.SuperScriptPush.newBuilder();
        List<PlayerHandler.SuperScriptType> list = getWorkSuperScript();
        if (list != null && !list.isEmpty()) {
            data.addAllS2CData(list);
            this.player.receive("area.playerPush.onSuperScriptPush", (GeneratedMessage) data.build());
        }
    }


    public int getMakePoint() {
        if (!this.player.functionOpenManager.isOpen(Const.FunctionType.Make.getValue())) {
            return 0;
        }
        int number = 0;
        for (EquipMakeExt make : GameData.EquipMakes.values()) {
            if (this.player.player.gold < make.costMoney) {
                continue;
            }
            if (StringUtil.isNotEmpty(make.reqMateCode1) &&
                    this.player.bag.findItemNumByCode(make.reqMateCode1) < make.reqMateCount1) {
                continue;
            }

            if (StringUtil.isNotEmpty(make.reqMateCode2) &&
                    this.player.bag.findItemNumByCode(make.reqMateCode2) < make.reqMateCount2) {
                continue;
            }

            if (StringUtil.isNotEmpty(make.reqMateCode3) &&
                    this.player.bag.findItemNumByCode(make.reqMateCode3) < make.reqMateCount3) {
                continue;
            }

            if (this.player.getLevel() / 10 * 10 != make.equipLevel) {
                continue;
            }
            number = 1;
        }

        return number;
    }


    public int getRebornPoint() {
        if (!this.player.functionOpenManager.isOpen(Const.FunctionType.Reborn.getValue())) {
            return 0;
        }
        if (this.player.playerBasePO.openRebornToday) {
            return 0;
        }
        int number = 0;
        for (ReBornExt reBornExt : GameData.ReBorns.values()) {
            if (this.player.player.gold < reBornExt.costGold) {
                continue;
            }
            if (StringUtil.isNotEmpty(reBornExt.mateCode1) &&
                    this.player.bag.findItemNumByCode(reBornExt.mateCode1) < reBornExt.mateCount1) {
                continue;
            }

            if (StringUtil.isNotEmpty(reBornExt.mateCode2) &&
                    this.player.bag.findItemNumByCode(reBornExt.mateCode2) < reBornExt.mateCount2) {
                continue;
            }


            if (this.player.getLevel() / 10 * 10 != reBornExt.level) {
                continue;
            }
            number = 1;
        }

        return number;
    }


    public int getRebuildPoint() {
        if (!this.player.functionOpenManager.isOpen(Const.FunctionType.Rebuild.getValue())) {
            return 0;
        }
        if (this.player.playerBasePO.openRebuildToday) {
            return 0;
        }
        int number = 0;
        for (ReBuildExt reBuildExt : GameData.ReBuilds.values()) {
            if (this.player.player.gold < reBuildExt.costGold) {
                continue;
            }
            if (StringUtil.isNotEmpty(reBuildExt.mateCode1) &&
                    this.player.bag.findItemNumByCode(reBuildExt.mateCode1) < reBuildExt.mateCount1) {
                continue;
            }

            if (StringUtil.isNotEmpty(reBuildExt.mateCode2) &&
                    this.player.bag.findItemNumByCode(reBuildExt.mateCode2) < reBuildExt.mateCount2) {
                continue;
            }

            if (StringUtil.isNotEmpty(reBuildExt.mateCode3) &&
                    this.player.bag.findItemNumByCode(reBuildExt.mateCode3) < reBuildExt.mateCount3) {
                continue;
            }


            if (this.player.getLevel() / 10 * 10 != reBuildExt.level) {
                continue;
            }
            number = 1;
        }

        if (number > 0) {
            return number;
        }
        for (SeniorReBuildExt seniorReBuildExt : GameData.SeniorReBuilds.values()) {
            if (this.player.player.gold < seniorReBuildExt.costGold) {
                continue;
            }
            if (StringUtil.isNotEmpty(seniorReBuildExt.mateCode1) &&
                    this.player.bag.findItemNumByCode(seniorReBuildExt.mateCode1) < seniorReBuildExt.mateCount1) {
                continue;
            }

            if (StringUtil.isNotEmpty(seniorReBuildExt.mateCode2) &&
                    this.player.bag.findItemNumByCode(seniorReBuildExt.mateCode2) < seniorReBuildExt.mateCount2) {
                continue;
            }


            if (StringUtil.isNotEmpty(seniorReBuildExt.mateCode3) &&
                    this.player.bag.findItemNumByCode(seniorReBuildExt.mateCode3) < seniorReBuildExt.mateCount3) {
                continue;
            }


            if (this.player.getLevel() / 10 * 10 != seniorReBuildExt.level) {
                continue;
            }
            number = 1;
        }

        return number;
    }


    public int getKaiguangPoint() {
        if (!this.player.functionOpenManager.isOpen(Const.FunctionType.REFINE.getValue())) {
            return 0;
        }
        if (this.player.playerBasePO.openKaiguangToday) {
            return 0;
        }
        int number = 0;
        for (RefineExt reFineExt : GameData.Refines.values()) {
            if (this.player.player.gold < reFineExt.costGold) {
                continue;
            }

            if (StringUtil.isNotEmpty(reFineExt.mateCode1) &&
                    this.player.bag.findItemNumByCode(reFineExt.mateCode1) < reFineExt.mateCount1) {
                continue;
            }


            if (StringUtil.isNotEmpty(reFineExt.mateCode2) &&
                    this.player.bag.findItemNumByCode(reFineExt.mateCode2) < reFineExt.mateCount2) {
                continue;
            }


            if (this.player.getLevel() / 10 * 10 != reFineExt.level) {
                continue;
            }

            number = 1;
        }


        return number;
    }


    public List<PlayerHandler.SuperScriptType> getWorkSuperScript() {
        List<PlayerHandler.SuperScriptType> list = new ArrayList<>();


        int number1 = getMakePoint();
        PlayerHandler.SuperScriptType.Builder data1 = PlayerHandler.SuperScriptType.newBuilder();
        data1.setType(Const.SUPERSCRIPT_TYPE.MAKE.getValue());
        data1.setNumber(number1);
        list.add(data1.build());


        int number2 = getRebornPoint();
        PlayerHandler.SuperScriptType.Builder data2 = PlayerHandler.SuperScriptType.newBuilder();
        data2.setType(Const.SUPERSCRIPT_TYPE.REBORN.getValue());
        data2.setNumber(number2);
        list.add(data2.build());


        int number3 = getRebuildPoint();
        PlayerHandler.SuperScriptType.Builder data3 = PlayerHandler.SuperScriptType.newBuilder();
        data3.setType(Const.SUPERSCRIPT_TYPE.REBUILD.getValue());
        data3.setNumber(number3);
        list.add(data3.build());


        int number4 = getKaiguangPoint();
        PlayerHandler.SuperScriptType.Builder data4 = PlayerHandler.SuperScriptType.newBuilder();
        data4.setType(Const.SUPERSCRIPT_TYPE.KAIGUANG.getValue());
        data4.setNumber(number4);
        list.add(data4.build());


        PlayerHandler.SuperScriptType.Builder data = PlayerHandler.SuperScriptType.newBuilder();
        data.setType(Const.SUPERSCRIPT_TYPE.WORKING.getValue());
        data.setNumber(number1 + number2 + number3 + number4);
        list.add(data.build());


        return list;
    }

    public RedPointBean findRedPointBean(List<RedPointBean> list, int code) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        for (RedPointBean bean : list) {
            if (bean.id == code) {
                return bean;
            }
        }
        return null;
    }


    public List<PlayerHandler.SuperScriptType> getStrengthSuperScript() {
        List<PlayerHandler.SuperScriptType> list = new ArrayList<>();
        if (!this.player.functionOpenManager.isOpen(Const.FunctionType.STRENGTHEN.getValue())) {
            return list;
        }

        int number = 0;

        for (Iterator<Integer> iterator = this.strengthPos.keySet().iterator(); iterator.hasNext(); ) {
            int pos = ((Integer) iterator.next()).intValue();
            PlayerBasePO.EquipStrengthPos posInfo = this.strengthPos.get(Integer.valueOf(pos));
            int level = posInfo.enSection * 100 + posInfo.enLevel;
            if (level < EquipUtil.maxStrengthLevel) {
                int nextLv = level + 1;
                if (posInfo.enLevel >= 9) {
                    nextLv = (posInfo.enSection + 1) * 100;
                }
                EnchantExt enchant = (EnchantExt) GameData.Enchants.get(Integer.valueOf(nextLv));
                if (enchant != null && this.player.bag.isItemNumEnough(enchant.mateCode1, enchant.mateCount1) && this.player.bag.isItemNumEnough(enchant.mateCode2, enchant.mateCount2) && this.player.player.gold >= enchant.costGold) {
                    number = 1;
                    break;
                }
            }
        }

        PlayerHandler.SuperScriptType.Builder data = PlayerHandler.SuperScriptType.newBuilder();
        data.setType(Const.SUPERSCRIPT_TYPE.EQUIP_STRENGTH.getValue());
        data.setNumber(number);
        list.add(data.build());
        return list;
    }


    public List<PlayerHandler.SuperScriptType> getGemFillSuperScript(String templateCode) {
        long start = System.currentTimeMillis();
        List<PlayerHandler.SuperScriptType> list = new ArrayList<>();

        if (!this.player.functionOpenManager.isOpen(Const.FunctionType.SetNew.getValue())) {
            return list;
        }

        int number = 0;

        if (StringUtil.isNotEmpty(templateCode)) {

            boolean flag = false;
            List<Integer> codePoses = ItemConfig.getInstance().findPosByGem(templateCode);
            for (Iterator<Integer> iterator = codePoses.iterator(); iterator.hasNext(); ) {
                int pos = ((Integer) iterator.next()).intValue();
                PlayerBasePO.EquipStrengthPos posInfo = this.strengthPos.get(Integer.valueOf(pos));
                for (int i = 1; i <= posInfo.socks; i++) {
                    String code = (String) posInfo.gems.get(Integer.valueOf(i));
                    if (StringUtil.isEmpty(code)) {
                        number = 1;
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    break;
                }
            }


            if (number == 0) {
                DItemBase baseProp = (DItemBase) ItemConfig.getInstance().getItemProp(templateCode);
                List<Integer> poses = ItemConfig.getInstance().findPosByGem(templateCode);

                Map<Integer, Integer> gemLevels = new HashMap<>();

                for (Iterator<Integer> iterator1 = this.strengthPos.keySet().iterator(); iterator1.hasNext(); ) {
                    int pos = ((Integer) iterator1.next()).intValue();
                    if (!poses.contains(Integer.valueOf(pos))) {
                        continue;
                    }
                    PlayerBasePO.EquipStrengthPos posInfo = this.strengthPos.get(Integer.valueOf(pos));
                    for (String code : posInfo.gems.values()) {
                        if (StringUtil.isEmpty(code)) {
                            continue;
                        }
                        DItemBase prop = (DItemBase) ItemConfig.getInstance().getItemProp(code);
                        if (!gemLevels.containsKey(Integer.valueOf(prop.par)) || ((Integer) gemLevels.get(Integer.valueOf(prop.par))).intValue() > prop.levelReq) {
                            gemLevels.put(Integer.valueOf(prop.par), Integer.valueOf(prop.levelReq));
                        }
                    }
                }


                int level = gemLevels.containsKey(Integer.valueOf(baseProp.par)) ? ((Integer) gemLevels.get(Integer.valueOf(baseProp.par))).intValue() : 0;
                if (baseProp.levelReq > level) {
                    number = 1;
                }
            }
        } else {

            boolean flag = false;
            for (Iterator<Integer> iterator = this.strengthPos.keySet().iterator(); iterator.hasNext(); ) {
                int pos = ((Integer) iterator.next()).intValue();
                PlayerBasePO.EquipStrengthPos posInfo = this.strengthPos.get(Integer.valueOf(pos));
                for (int i = 1; i <= posInfo.socks; i++) {
                    String code = (String) posInfo.gems.get(Integer.valueOf(i));
                    if (!StringUtil.isNotEmpty(code)) {


                        List<String> typeList = ((EquipSockExt) GameData.EquipSocks.get(Integer.valueOf(pos))).typeList;
                        for (String _code : typeList) {
                            if (this.player.bag.findFirstItemByCode(_code) != null) {
                                number = 1;
                                flag = true;
                                break;
                            }
                        }
                        if (flag)
                            break;
                    }
                }
                if (flag) {
                    break;
                }
            }


            if (number == 0) {

                Map<Integer, Integer> posCodeLevelBag = new HashMap<>();
                List<NormalItem> list_bag = this.player.bag.findItemByType(Const.ItemSecondType.gem.getKey());
                if (list_bag.size() == 0) {
                    number = 0;
                } else {
                    for (NormalItem bagItem : list_bag) {
                        List<Integer> list_gem_pos = ItemConfig.getInstance().findPosByGem(bagItem.itemCode());
                        for (Iterator<Integer> iterator2 = list_gem_pos.iterator(); iterator2.hasNext(); ) {
                            int bagPos = ((Integer) iterator2.next()).intValue();
                            if (posCodeLevelBag.get(Integer.valueOf(bagPos)) == null || ((Integer) posCodeLevelBag.get(Integer.valueOf(bagPos))).intValue() < bagItem.prop.levelReq) {
                                posCodeLevelBag.put(Integer.valueOf(bagPos), Integer.valueOf(bagItem.prop.levelReq));
                            }
                        }

                    }


                    Map<Integer, Integer> posCodeLevel = new HashMap<>();
                    Iterator<Integer> iterator1;
                    for (iterator1 = this.strengthPos.keySet().iterator(); iterator1.hasNext(); ) {
                        int pos = ((Integer) iterator1.next()).intValue();
                        PlayerBasePO.EquipStrengthPos posInfo = this.strengthPos.get(Integer.valueOf(pos));
                        for (String code : posInfo.gems.values()) {
                            if (StringUtil.isEmpty(code)) {
                                continue;
                            }
                            DItemBase prop = (DItemBase) ItemConfig.getInstance().getItemProp(code);
                            if (posCodeLevel.get(Integer.valueOf(pos)) == null || ((Integer) posCodeLevel.get(Integer.valueOf(pos))).intValue() > prop.levelReq) {
                                posCodeLevel.put(Integer.valueOf(pos), Integer.valueOf(prop.levelReq));
                            }
                        }
                    }

                    flag = false;
                    for (iterator1 = posCodeLevelBag.keySet().iterator(); iterator1.hasNext(); ) {
                        int bagPos = ((Integer) iterator1.next()).intValue();
                        int levelBag = ((Integer) posCodeLevelBag.get(Integer.valueOf(bagPos))).intValue();
                        for (Iterator<Integer> iterator2 = posCodeLevel.keySet().iterator(); iterator2.hasNext(); ) {
                            int pos = ((Integer) iterator2.next()).intValue();
                            if (bagPos == pos &&
                                    levelBag > ((Integer) posCodeLevel.get(Integer.valueOf(pos))).intValue()) {
                                number = 1;
                                flag = true;

                                break;
                            }
                        }

                        if (flag) {
                            break;
                        }
                    }

                }
            }
        }

        long cost = System.currentTimeMillis() - start;
        if (cost > 10L) {
            Out.info(new Object[]{"getGemFillSuperScript cost ", Long.valueOf(cost)});
        }

        PlayerHandler.SuperScriptType.Builder data = PlayerHandler.SuperScriptType.newBuilder();
        data.setType(Const.SUPERSCRIPT_TYPE.EQUIP_FILL_GEM.getValue());
        data.setNumber(number);
        list.add(data.build());
        return list;
    }


    public List<PlayerHandler.SuperScriptType> getEquipSuperScript(NormalEquip equip) {
        List<PlayerHandler.SuperScriptType> list = new ArrayList<>();

        int number = 0;

        if (equip != null) {
            if (equip.getLevel() <= this.player.getLevel() && (equip.prop.Pro == this.player.getPro() || equip.prop.Pro == 0)) {
                NormalEquip playerEquip = this.equips.get(Integer.valueOf(equip.getPosition()));
                if (playerEquip == null) {
                    number = 1;
                } else if (playerEquip.getEquipScore(this.player.playerBasePO) < equip.getEquipScore(this.player.playerBasePO)) {
                    number = 1;
                }
            }
        } else {

            boolean flag = false;
            for (Const.EquipType ePos : Const.EquipType.values()) {
                int pos = ePos.getValue();
                List<NormalEquip> list_all = this.player.bag.findEquipByType(pos, this.player.getPro(), this.player.getLevel());
                if (list_all.size() > 0) {
                    NormalEquip playerEquip = this.equips.containsKey(Integer.valueOf(pos)) ? this.equips.get(Integer.valueOf(pos)) : null;
                    if (playerEquip == null) {
                        number = 1;
                        flag = true;
                    } else {
                        for (NormalEquip bagEquip : list_all) {
                            if (playerEquip.getEquipScore(this.player.playerBasePO) < bagEquip.getEquipScore(this.player.playerBasePO)) {
                                number = 1;
                                flag = true;
                                break;
                            }
                        }
                    }
                }
                if (flag) {
                    break;
                }
            }
        }
        PlayerHandler.SuperScriptType.Builder data = PlayerHandler.SuperScriptType.newBuilder();
        data.setType(Const.SUPERSCRIPT_TYPE.EQUIP_EQUIP.getValue());
        data.setNumber(number);
        list.add(data.build());
        return list;
    }

    private void removeSameScript(List<PlayerHandler.SuperScriptType> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        Iterator<PlayerHandler.SuperScriptType> iter = list.iterator();
        while (iter.hasNext()) {
            PlayerHandler.SuperScriptType script = iter.next();
            int oldNum = this.redpoints.containsKey(Integer.valueOf(script.getType())) ? ((Integer) this.redpoints.get(Integer.valueOf(script.getType()))).intValue() : 0;
            if (script.getNumber() > 0) {
                if (oldNum > 0) {
                    iter.remove();
                    continue;
                }
                this.redpoints.put(Integer.valueOf(script.getType()), Integer.valueOf(script.getNumber()));
                continue;
            }
            if (oldNum <= 0) {
                iter.remove();
                continue;
            }
            this.redpoints.put(Integer.valueOf(script.getType()), Integer.valueOf(script.getNumber()));
        }
    }


    public RedPointPO getAndCheckUpdateRedPointPO(String playerId) {
        RedPointPO redPointPO = (RedPointPO) PlayerPOManager.findPO(ConstsTR.redpointTR, playerId, RedPointPO.class);
        if (redPointPO == null) {
            synchronized (this.player) {
                redPointPO = (RedPointPO) PlayerPOManager.findPO(ConstsTR.redpointTR, playerId, RedPointPO.class);
                if (redPointPO == null) {
                    redPointPO = new RedPointPO();
                    PlayerPOManager.put(ConstsTR.redpointTR, playerId, (GEntity) redPointPO);
                }
            }
        }
        checkupdateRedpoint(redPointPO);
        return redPointPO;
    }

    public void checkupdateRedpoint(RedPointPO redPointPO) {
        if (redPointPO.list != null) {
            Date now = new Date();
            for (RedPointBean bean : redPointPO.list) {
                boolean isSameDay = DateUtil.isSameDay(bean.date, now);
                if (!isSameDay) {
                    bean.date = now;
                    bean.point = 0;
                }
            }
        }
    }


    public void updateMakeScript(String code) {
        if (StringUtil.isEmpty(code) || EquipUtil.makeMaterial.contains(code)) {
            GWorld.getInstance().ansycExec(() -> {
                List<PlayerHandler.SuperScriptType> list = getWorkSuperScript();
                this.player.updateSuperScriptList(list);
            });
        }
    }


    public void updateStrengthScript(String code) {
        if (StringUtil.isEmpty(code) || EquipUtil.strengthMaterial.contains(code)) {
            GWorld.getInstance().ansycExec(() -> {
                List<PlayerHandler.SuperScriptType> list = getStrengthSuperScript();
                removeSameScript(list);
                this.player.updateSuperScriptList(list);
            });
        }
    }


    public void updateFillGemScript(String code) {
        if (StringUtil.isEmpty(code) || GameData.Jewels.containsKey(code)) {
            GWorld.getInstance().ansycExec(() -> {
                List<PlayerHandler.SuperScriptType> list = getGemFillSuperScript(code);
                removeSameScript(list);
                this.player.updateSuperScriptList(list);
            });
        }
    }


    public void updateEquipScript(NormalEquip equip) {
        GWorld.getInstance().ansycExec(() -> {
            List<PlayerHandler.SuperScriptType> list = getEquipSuperScript(equip);
            this.player.updateSuperScriptList(list);
        });
    }

    public void updateSuperScript() {
        GWorld.getInstance().ansycExec(() -> {
            List<PlayerHandler.SuperScriptType> list = getSuperScript();
            this.player.updateSuperScriptList(list);
        });
    }

    public void onLogin() {
        this.redpoints.clear();
    }


    public void OnPlayerLevelUp() {
        int level = this.player.player.level;
        for (Iterator<Integer> iterator = this.strengthPos.keySet().iterator(); iterator.hasNext(); ) {
            int pos = ((Integer) iterator.next()).intValue();
            EquipSockCO sockCO = (EquipSockCO) GameData.EquipSocks.get(Integer.valueOf(pos));
            if (sockCO == null) {
                continue;
            }
            PlayerBasePO.EquipStrengthPos posInfo = this.strengthPos.get(Integer.valueOf(pos));
            int sockNum = 0;
            if (level >= sockCO.sock1OpenLvl) {
                sockNum++;
            }
            if (level >= sockCO.sock2OpenLvl) {
                sockNum++;
            }
            if (level >= sockCO.sock3OpenLvl) {
                sockNum++;
            }
            if (level >= sockCO.sock4OpenLvl) {
                sockNum++;
            }
            if (level >= sockCO.sock5OpenLvl) {
                sockNum++;
            }
            posInfo.socks = sockNum;
        }


        int len = (Const.EquipType.values()).length;
        int[] grids = new int[len];
        for (int i = 0; i < len; i++) {
            grids[i] = i + 1;
        }
        _updateAndPushPOS(grids, false);

        updateFillGemScript(null);
    }

    private void update() {
        this.player.playerBasePO.equipGrids = new HashMap<>();
        for (Iterator<Integer> iterator = this.equips.keySet().iterator(); iterator.hasNext(); ) {
            int pos = ((Integer) iterator.next()).intValue();
            if (this.equips.get(Integer.valueOf(pos)) != null) {
                this.player.playerBasePO.equipGrids.put(Integer.valueOf(pos), ((NormalEquip) this.equips.get(Integer.valueOf(pos))).itemDb);
            }
        }

    }

    public int getTotalStrenthenLv() {
        int totalLv = 0;
        for (PlayerBasePO.EquipStrengthPos equipStrengthPos : this.strengthPos.values()) {
            totalLv += equipStrengthPos.enSection * 10 + equipStrengthPos.enLevel;
        }
        return totalLv;
    }

    public void refreshNewDay() {
        this.player.playerBasePO.openRebornToday = false;
        this.player.playerBasePO.openRebuildToday = false;
        this.player.playerBasePO.openKaiguangToday = false;
    }
}


