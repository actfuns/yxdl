package com.wanniu.game.achievement;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GEntity;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.StringUtil;
import com.wanniu.game.achievement.po.BaseInfo;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.ConstsTR;
import com.wanniu.game.data.AchievementCO;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.base.DItemBase;
import com.wanniu.game.data.ext.AchievementConfigExt;
import com.wanniu.game.data.ext.AchievementExt;
import com.wanniu.game.data.ext.ArmourAttributeExt;
import com.wanniu.game.data.ext.ArmourPlusExt;
import com.wanniu.game.item.ItemUtil;
import com.wanniu.game.item.NormalItem;
import com.wanniu.game.player.AttributeUtil;
import com.wanniu.game.player.BILogService;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.AchievementDataPO;
import com.wanniu.game.poes.PlayerBasePO;
import com.wanniu.game.task.TaskEvent;
import com.wanniu.redis.PlayerPOManager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import pomelo.area.AchievementHandler;
import pomelo.area.PlayerHandler;
import pomelo.item.ItemOuterClass;


public class AchievementManager {
    private WNPlayer player;
    public AchievementDataPO achievementDataPO;
    public Map<Integer, AchievementDataPO.AchievePO> achievementRecordMap;
    private AchievementServiceNew achievementService;

    protected AchievementManager() {
    }

    public AchievementManager(WNPlayer player, AchievementDataPO achievementData) {
        this.player = player;
        this.achievementDataPO = achievementData;
        if (this.achievementDataPO == null) {
            this.achievementDataPO = new AchievementDataPO();
            PlayerPOManager.put(ConstsTR.achievementTR, player.getId(), (GEntity) this.achievementDataPO);
        }

        this.achievementRecordMap = this.achievementDataPO.achievements;

        this.achievementService = AchievementServiceNew.getInstance();
    }

    public Map<Integer, AchievementDataPO.AchievePO> getAchievementRecords() {
        return this.achievementRecordMap;
    }


    public void toJson4PayloadbyTypeId(int chapterId, AchievementHandler.AchievementGetTypeElementResponse.Builder res) {
        List<AchievementExt> achievements = GameData.findAchievements(t -> (t.chapterID == chapterId));


        AchievementConfigExt configExt = (AchievementConfigExt) GameData.AchievementConfigs.get(Integer.valueOf(chapterId));
        int recordCount = 0;
        for (AchievementExt achievementRelation : achievements) {
            AchievementHandler.Achievement.Builder builder = AchievementHandler.Achievement.newBuilder();
            AchievementDataPO.AchievePO achieve = this.achievementRecordMap.get(Integer.valueOf(achievementRelation.id));
            if (achieve != null) {
                builder.setId(achieve.id);
                builder.setScheduleCurr(achieve.scheduleCurr);
                builder.setStatus(0);
                if (achieve.awardState == 1) {

                    recordCount++;
                    builder.setStatus(2);
                    builder.setScheduleCurr(achievementRelation.targetNum);
                } else if (this.achievementService.isComplete(achieve, achievementRelation)) {
                    recordCount++;

                    builder.setStatus(1);
                }

            } else {

                builder.setId(achievementRelation.id);
                builder.setScheduleCurr(0);

                builder.setStatus(0);
            }
            res.addS2CAchievements(builder);
        }
        res.setS2CRewardCount(recordCount);
        int status = 0;
        if (this.achievementDataPO.receivedAwards.contains(Integer.valueOf(chapterId))) {
            status = 2;
        } else if (achievements.size() > 0 && recordCount >= achievements.size()) {
            status = 1;
        }
        res.setS2CRewardStatus(status);


        List<Integer> list_opend_chapter = new ArrayList<>();
        for (AchievementConfigExt config : GameData.AchievementConfigs.values()) {
            if (this.player.getLevel() < config.lv) {
                continue;
            }
            if (config.quest != 0 && !this.player.taskManager.finishedNormalTasks.containsKey(Integer.valueOf(config.quest))) {
                continue;
            }
            list_opend_chapter.add(Integer.valueOf(config.typeId));
        }
        res.addAllS2COpenedChapter(list_opend_chapter);


        List<ItemOuterClass.MiniItem> list_chest = new ArrayList<>();
        for (String itemCode : configExt.awards.keySet()) {
            list_chest.add(ItemUtil.getMiniItemData(itemCode, ((Integer) configExt.awards.get(itemCode)).intValue()).build());
        }
        res.addAllS2CChestView(list_chest);
    }


    public BaseInfo getAward(int type, int awardId) {
        BaseInfo data = new BaseInfo();
        data.code = 200;


        if (this.player == null) {
            data.code = 500;
            data.msg = LangService.getValue("SOMETHING_ERR");
            return data;
        }


        if (type == 0) {
            AchievementConfigExt configExt = (AchievementConfigExt) GameData.AchievementConfigs.get(Integer.valueOf(awardId));

            if (configExt == null) {
                data.code = 500;
                data.msg = LangService.getValue("SOMETHING_ERR");
                return data;
            }


            if (this.achievementDataPO.receivedAwards.contains(Integer.valueOf(awardId))) {
                data.code = 500;
                data.msg = LangService.getValue("SIGN_HAVE_RECEIVED");
                return data;
            }


            List<AchievementExt> list_achieves = GameData.findAchievements(t -> (t.chapterID == awardId));


            AchievementDataPO.AchievePO achivePO = null;
            for (AchievementExt ext : list_achieves) {
                achivePO = this.achievementRecordMap.get(Integer.valueOf(awardId));
                if (achivePO == null) {
                    break;
                }
                if (achivePO.awardState == 1) {
                    break;
                }
                if (!this.achievementService.isComplete(achivePO, ext)) {
                    break;
                }
            }


            this.achievementDataPO.receivedAwards.add(Integer.valueOf(awardId));


            List<NormalItem> list_items = ItemUtil.createItemsByItemCode(configExt.awards);
            this.player.bag.addCodeItemMail(list_items, null, Const.GOODS_CHANGE_TYPE.achieve, "Bag_full_common");
        } else if (type == 1) {
            AchievementExt achievementExt = (AchievementExt) GameData.Achievements.get(Integer.valueOf(awardId));
            AchievementDataPO.AchievePO achivePO = this.achievementRecordMap.get(Integer.valueOf(awardId));

            if (achievementExt == null || achivePO == null) {
                data.code = 500;
                data.msg = LangService.getValue("SOMETHING_ERR");
                return data;
            }


            if (achivePO.awardState == 1) {
                data.code = 500;
                data.msg = LangService.getValue("SIGN_HAVE_RECEIVED");
                return data;
            }


            if (!this.achievementService.isComplete(achivePO, achievementExt)) {
                data.code = 500;
                data.msg = LangService.getValue("SIGN_HAVE_RECEIVED");
                return data;
            }


            achivePO.awardState = 1;


            this.player.bag.addCodeItemMail(achievementExt.awardKey, achievementExt.awardValue, null, Const.GOODS_CHANGE_TYPE.achieve, "Bag_full_common");
        } else {
            data.code = 500;
            data.msg = LangService.getValue("SOMETHING_ERR");
            return data;
        }

        return data;
    }


    public void onIllusionTimeChange(int minutes) {
        List<AchievementExt> achievementArray = this.achievementService.findByConditionType(Const.ACHIEVEMENT_CONDITION_TYPE.ILLUSION_TIME);
        if (achievementArray.size() > 0) {
            this.achievementService._onConditionChange(minutes, achievementArray, this.player, true);
        }
    }


    public void onKillBoss(int num) {
        List<AchievementExt> achievementArray = this.achievementService.findByConditionType(Const.ACHIEVEMENT_CONDITION_TYPE.KILL_BOSS);
        if (achievementArray.size() > 0) {
            this.achievementService._onConditionChange(num, achievementArray, this.player, true);
        }
    }


    public void onPassDemonTower(int floor, boolean win) {
        if (win) {
            List<AchievementExt> list = this.achievementService.findByConditionType(Const.ACHIEVEMENT_CONDITION_TYPE.PASS_DEMONTOWER);
            if (list.size() > 0) {
                this.achievementService._onConditionChange(floor, list, this.player, false);
            }
        }
        List<AchievementExt> achievementArray = this.achievementService.findByConditionType(Const.ACHIEVEMENT_CONDITION_TYPE.DEMONTOWER_TIMES);
        if (achievementArray.size() > 0) {
            this.achievementService._onConditionChange(1, achievementArray, this.player, true);
        }
    }


    public void onWorldSpeakTimes() {
        List<AchievementExt> achievementArray = this.achievementService.findByConditionType(Const.ACHIEVEMENT_CONDITION_TYPE.WORLD_SPEAK_TIME);
        if (achievementArray.size() > 0) {
            this.achievementService._onConditionChange(1, achievementArray, this.player, true);
        }
    }


    public void onGemFillTotalLevel() {
        List<AchievementExt> achievementArray = this.achievementService.findByConditionType(Const.ACHIEVEMENT_CONDITION_TYPE.GEM_FILL_TOTAL_LEVEL);
        int level = 0;
        for (PlayerBasePO.EquipStrengthPos pos : this.player.equipManager.strengthPos.values()) {
            for (String code : pos.gems.values()) {
                if (StringUtil.isEmpty(code))
                    continue;
                DItemBase prop = ItemUtil.getUnEquipPropByCode(code);
                level += prop.levelReq;
            }
        }
        if (achievementArray.size() > 0) {
            this.achievementService._onConditionChange(level, achievementArray, this.player, false);
        }
    }


    public void onEquipPosStrengthLevel(int pos, int level) {
        List<AchievementExt> achievementArray = this.achievementService.findByConditionType(Const.ACHIEVEMENT_CONDITION_TYPE.EQUIP_POS_LEVEL);

        List<AchievementExt> tmpArray = new ArrayList<>();
        if (achievementArray.size() > 0) {
            for (AchievementExt achievement : achievementArray) {
                if (Integer.parseInt(achievement.targetID) <= level) {
                    tmpArray.add(achievement);
                }
            }
        }

        if (tmpArray.size() > 0) {
            this.achievementService._onConditionChange(pos, tmpArray, this.player, true);
        }
    }


    public void onEquipMake() {
        List<AchievementExt> achievementArray = this.achievementService.findByConditionType(Const.ACHIEVEMENT_CONDITION_TYPE.EQUIP_MAKE_TIMES);
        if (achievementArray.size() > 0) {
            this.achievementService._onConditionChange(1, achievementArray, this.player, true);
        }
    }


    public void onEquipReborn() {
        List<AchievementExt> achievementArray = this.achievementService.findByConditionType(Const.ACHIEVEMENT_CONDITION_TYPE.EQUIP_REBORN_TIMES);
        if (achievementArray.size() > 0) {
            this.achievementService._onConditionChange(1, achievementArray, this.player, true);
        }
    }


    public void onEquipRefine() {
        List<AchievementExt> achievementArray = this.achievementService.findByConditionType(Const.ACHIEVEMENT_CONDITION_TYPE.EQUIP_REFINE_TIMES);
        if (achievementArray.size() > 0) {
            this.achievementService._onConditionChange(1, achievementArray, this.player, true);
        }
    }


    public void onEquipRebuild() {
        List<AchievementExt> achievementArray = this.achievementService.findByConditionType(Const.ACHIEVEMENT_CONDITION_TYPE.EQUIP_REBUILD_TIMES);
        if (achievementArray.size() > 0) {
            this.achievementService._onConditionChange(1, achievementArray, this.player, true);
        }
    }


    public void onPassFiveVsFive() {
        List<AchievementExt> achievementArray = this.achievementService.findByConditionType(Const.ACHIEVEMENT_CONDITION_TYPE.FIVE_VS_FIVE_TIMES);
        if (achievementArray.size() > 0) {
            this.achievementService._onConditionChange(1, achievementArray, this.player, true);
        }
    }


    public void onArenaBattle() {
        List<AchievementExt> achievementArray = this.achievementService.findByConditionType(Const.ACHIEVEMENT_CONDITION_TYPE.AREANA_TIMES);
        if (achievementArray.size() > 0) {
            this.achievementService._onConditionChange(1, achievementArray, this.player, true);
        }
    }


    public void onSoloBattle() {
        List<AchievementExt> achievementArray = this.achievementService.findByConditionType(Const.ACHIEVEMENT_CONDITION_TYPE.SOLO_TIMES);
        if (achievementArray.size() > 0) {
            this.achievementService._onConditionChange(1, achievementArray, this.player, true);
        }
    }


    public void onWorldLevelTimes() {
        List<AchievementExt> achievementArray = this.achievementService.findByConditionType(Const.ACHIEVEMENT_CONDITION_TYPE.WORLD_LEVEL_TIMES);
        if (achievementArray.size() > 0) {
            this.achievementService._onConditionChange(1, achievementArray, this.player, true);
        }
    }


    public void onMountGot() {
        List<AchievementExt> achievementArray = this.achievementService.findByConditionType(Const.ACHIEVEMENT_CONDITION_TYPE.MOUNT_COUNT);
        if (achievementArray.size() > 0) {
            this.achievementService._onConditionChange(1, achievementArray, this.player, true);
        }
    }


    public void onXianyuanChange(int num) {
        List<AchievementExt> achievementArray = this.achievementService.findByConditionType(Const.ACHIEVEMENT_CONDITION_TYPE.XIANYUAN_COUNT);
        if (achievementArray.size() > 0) {
            this.achievementService._onConditionChange(num, achievementArray, this.player, true);
        }
    }


    public void playerLevelChange(int newLevel) {
        if (this.achievementService.achievementLevelArray.size() > 0) {
            this.achievementService._onConditionChange(newLevel, this.achievementService.achievementLevelArray, this.player, false);
        }

        updateSuperScript();
    }


    public void playerRankChange(int newRank) {
        List<AchievementExt> achievementArray = this.achievementService.achievementUpLevelArray;
        if (achievementArray.size() > 0) {
            this.achievementService._onConditionChange(newRank, achievementArray, this.player, false);
        }
    }


    public void playerPowerChange(int newPower) {
        List<AchievementExt> achievementArray = this.achievementService.achievementPower;
        if (achievementArray.size() > 0) {
            this.achievementService._onConditionChange(newPower, achievementArray, this.player, false);
        }
    }


    public void killNpc(String npcId) {
        List<AchievementExt> achievementArray = this.achievementService.findByConditionTypeAndTargetIdInt(Const.ACHIEVEMENT_CONDITION_TYPE.KILL_NPC, Integer.parseInt(npcId));

        if (achievementArray.size() > 0) {
            this.achievementService._onConditionChange(1, achievementArray, this.player, true);
        }
    }


    public void equipEnhance(int pos, int level) {
        List<AchievementExt> achievementArray = this.achievementService.findByConditionTypeAndTargetIdInt(Const.ACHIEVEMENT_CONDITION_TYPE.EQUIPMENT_ENHANCE, pos);
        if (achievementArray.size() > 0) {
            this.achievementService._onConditionChange(level, achievementArray, this.player, false);
        }

        List<AchievementExt> achievementArray_every_pos = this.achievementService.findByConditionTypeAndTargetIdInt(Const.ACHIEVEMENT_CONDITION_TYPE.EQUIPMENT_ENHANCE, 0);

        if (achievementArray_every_pos.size() > 0) {
            this.achievementService._onConditionChange(level, achievementArray_every_pos, this.player, false);
        }
    }

    public void onPlaceArrived(int achievementId) {
        List<AchievementExt> achievementArray = this.achievementService.findAchievementsByIdAndConditionType(achievementId, Const.ACHIEVEMENT_CONDITION_TYPE.PLACE_ARRIVED);

        if (achievementArray.size() > 0) {
            this.achievementService._onConditionChange(1, achievementArray, this.player, true);
        }
    }

    public void onFinishTask(int taskId) {
        List<AchievementExt> achievementArray = this.achievementService.findByConditionTypeAndTargetIdInt(Const.ACHIEVEMENT_CONDITION_TYPE.FINISH_TASK, taskId);

        if (achievementArray.size() > 0) {
            this.achievementService._onConditionChange(1, achievementArray, this.player, false);
        }

        for (AchievementConfigExt config : GameData.AchievementConfigs.values()) {
            if (config.quest == taskId) {
                updateSuperScript();
                break;
            }
        }
    }

    public void onFinishTaskNum(int kind) {
        Const.ACHIEVEMENT_CONDITION_TYPE conditionType = Const.ACHIEVEMENT_CONDITION_TYPE.DEFAULT;

        if (kind == 2) {
            conditionType = Const.ACHIEVEMENT_CONDITION_TYPE.FINISH_DAILY_TASK;
        } else if (kind == 3) {
            conditionType = Const.ACHIEVEMENT_CONDITION_TYPE.FINISH_LOOP_TASK;
        } else if (kind == 0 || kind == 1) {
            conditionType = Const.ACHIEVEMENT_CONDITION_TYPE.FINISH_TASK_NUM;
        }

        List<AchievementExt> achievementArray = this.achievementService.findByConditionType(conditionType);

        if (achievementArray.size() > 0) {
            this.achievementService._onConditionChange(1, achievementArray, this.player, true);
        }
    }

    public void onGetGold(int num) {
        List<AchievementExt> achievementArray = this.achievementService.findByConditionType(Const.ACHIEVEMENT_CONDITION_TYPE.GET_GOLD);

        if (achievementArray.size() > 0) {
            this.achievementService._onConditionChange(num, achievementArray, this.player, true);
        }
    }

    public void onGetDiamondInConsignment(int num) {
        List<AchievementExt> achievementArray = this.achievementService.findByConditionType(Const.ACHIEVEMENT_CONDITION_TYPE.GET_DIAMOND_IN_CONSIGNMENT);

        if (achievementArray.size() > 0) {
            this.achievementService._onConditionChange(num, achievementArray, this.player, true);
        }
    }

    public void onGetMagicRing(String ringId) {
        List<AchievementExt> achievementArray = new ArrayList<>();
        Collection<AchievementExt> datas = GameData.Achievements.values();

        for (AchievementCO d : datas) {
            AchievementExt data = (AchievementExt) d;
            if (Const.ACHIEVEMENT_CONDITION_TYPE.GET_MAGIC_RING.value != data.conditionType) {
                continue;
            }
            if (!data.targetID.equals(ringId)) {
                continue;
            }
            achievementArray.add(data);
        }

        if (achievementArray.size() > 0) {
            this.achievementService._onConditionChange(1, achievementArray, this.player, false);
        }
    }

    public void onGetMedal(String medalId) {
        List<AchievementExt> achievementArray = new ArrayList<>();
        Collection<AchievementExt> datas = GameData.Achievements.values();

        for (AchievementCO d : datas) {
            AchievementExt data = (AchievementExt) d;
            if (Const.ACHIEVEMENT_CONDITION_TYPE.GET_MEDAL.value != data.conditionType) {
                continue;
            }

            if (!data.targetID.equals(medalId)) {
                continue;
            }
            achievementArray.add(data);
        }

        if (achievementArray.size() > 0) {
            this.achievementService._onConditionChange(1, achievementArray, this.player, false);
        }
    }

    public void onGetNecklace(String medalId) {
        List<AchievementExt> achievementArray = new ArrayList<>();
        Collection<AchievementExt> datas = GameData.Achievements.values();

        for (AchievementCO d : datas) {
            AchievementExt data = (AchievementExt) d;
            if (Const.ACHIEVEMENT_CONDITION_TYPE.GET_NECKLACE.value != data.conditionType) {
                continue;
            }

            if (!data.targetID.equals(medalId)) {
                continue;
            }
            achievementArray.add(data);
        }

        if (achievementArray.size() > 0) {
            this.achievementService._onConditionChange(1, achievementArray, this.player, false);
        }
    }


    public void onGetEquipment(String code) {
        List<AchievementExt> achievementArray = this.achievementService.findByConditionTypeAndTargetIdString(Const.ACHIEVEMENT_CONDITION_TYPE.GET_EQUIPMENT, code);

        if (achievementArray.size() > 0) {
            this.achievementService._onConditionChange(1, achievementArray, this.player, true);
        }
    }

    public void onEquipEnchant() {
        List<AchievementExt> achievementArray = this.achievementService.findByConditionType(Const.ACHIEVEMENT_CONDITION_TYPE.EQUIPMENT_ENCHANT);

        if (achievementArray.size() > 0) {
            this.achievementService._onConditionChange(1, achievementArray, this.player, true);
        }
    }

    public void onGetPet(int color) {
        List<AchievementExt> achievementArray = this.achievementService.findByConditionType(Const.ACHIEVEMENT_CONDITION_TYPE.GET_PET);

        if (achievementArray.size() > 0) {
            this.achievementService._onConditionChange(1, achievementArray, this.player, true);
        }


        List<AchievementExt> achievementArray_petColor = new ArrayList<>();

        List<AchievementExt> datas = this.achievementService.findByConditionType(Const.ACHIEVEMENT_CONDITION_TYPE.GET_QUALITY_PET);

        for (AchievementExt data : datas) {
            if (Integer.parseInt(data.targetID) > color) {
                continue;
            }
            achievementArray_petColor.add(data);
        }

        if (achievementArray_petColor.size() > 0) {
            this.achievementService._onConditionChange(1, achievementArray_petColor, this.player, true);
        }
    }

    public void onGetPetLevel(int petId, int level) {
        List<AchievementExt> achievementArray = this.achievementService.findByConditionType(Const.ACHIEVEMENT_CONDITION_TYPE.PET_LEVEL);
        List<AchievementExt> tmpArray = new ArrayList<>();
        if (achievementArray.size() > 0) {
            for (AchievementExt achievement : achievementArray) {
                if (Integer.parseInt(achievement.targetID) <= level) {
                    tmpArray.add(achievement);
                }
            }

            this.achievementService._onConditionChange(petId, tmpArray, this.player, false);
        }
    }

    public void onPetUpGrade(int olderLevel, int level) {
        List<AchievementExt> achievementArray = this.achievementService.findByConditionType(Const.ACHIEVEMENT_CONDITION_TYPE.PET_UPGRADE_LEVEL);
        List<AchievementExt> tmpArray = new ArrayList<>();
        if (achievementArray.size() > 0) {
            for (AchievementExt achievement : achievementArray) {
                if (Integer.parseInt(achievement.targetID) > olderLevel && Integer.parseInt(achievement.targetID) <= level) {
                    tmpArray.add(achievement);
                }
            }

            this.achievementService._onConditionChange(1, tmpArray, this.player, false);
        }
    }

    public void onPetTransformLevel(int olderLevel, int level) {
        List<AchievementExt> achievementArray = this.achievementService.findByConditionType(Const.ACHIEVEMENT_CONDITION_TYPE.PET_TRANSFORM_LEVEL);
        List<AchievementExt> tmpArray = new ArrayList<>();
        if (achievementArray.size() > 0) {
            for (AchievementExt achievement : achievementArray) {
                if (Integer.parseInt(achievement.targetID) > olderLevel && Integer.parseInt(achievement.targetID) <= level) {
                    tmpArray.add(achievement);
                }
            }

            this.achievementService._onConditionChange(1, tmpArray, this.player, true);
        }
    }

    public void onHorseLevelChange(int level) {
        List<AchievementExt> achievementArray = this.achievementService.findByConditionType(Const.ACHIEVEMENT_CONDITION_TYPE.RIDE_DEVELOPMENT);

        if (achievementArray.size() > 0) {
            this.achievementService._onConditionChange(level, achievementArray, this.player, false);
        }
    }

    public void onWingLevelChange(int id) {
        List<AchievementExt> achievementArray = this.achievementService.findByConditionTypeAndTargetIdInt(Const.ACHIEVEMENT_CONDITION_TYPE.WING_LEVEL, id);

        if (achievementArray.size() > 0) {
            this.achievementService._onConditionChange(1, achievementArray, this.player, false);
        }
    }


    public void onFishing() {
        List<AchievementExt> achievementArray = this.achievementService.findByConditionType(Const.ACHIEVEMENT_CONDITION_TYPE.FISH_ITEM);

        if (achievementArray.size() > 0) {
            this.achievementService._onConditionChange(1, achievementArray, this.player, true);
        }
    }

    public void onSkillLevelChange(int level) {
        List<AchievementExt> achievementArray = this.achievementService.findByConditionType(Const.ACHIEVEMENT_CONDITION_TYPE.SKILL_LEVEL);

        if (achievementArray.size() > 0) {
            this.achievementService._onConditionChange(level, achievementArray, this.player, false);
        }
    }

    public void onPassedDungeon(int id) {
        List<AchievementExt> achievementArray = this.achievementService.findByConditionTypeAndTargetIdInt(Const.ACHIEVEMENT_CONDITION_TYPE.DUNGEON_PASSED, id);

        if (achievementArray.size() > 0) {
            this.achievementService._onConditionChange(1, achievementArray, this.player, true);
        }
    }

    public void onWinSolo(int rankId) {
        List<AchievementExt> achievementArray = this.achievementService.findByConditionType(Const.ACHIEVEMENT_CONDITION_TYPE.SOLO_WIN);

        if (achievementArray.size() > 0) {
            this.achievementService._onConditionChange(1, achievementArray, this.player, true);
        }


        List<AchievementExt> achievementArray_soloRank = this.achievementService.findByConditionTypeAndTargetIdInt(Const.ACHIEVEMENT_CONDITION_TYPE.SOLO_RANK, rankId);

        if (achievementArray_soloRank.size() > 0) {
            this.achievementService._onConditionChange(1, achievementArray_soloRank, this.player, true);
        }
    }

    public void onArenaKill() {
        List<AchievementExt> achievementArray = this.achievementService.findByConditionType(Const.ACHIEVEMENT_CONDITION_TYPE.ARENA_KILL_PLAYER);

        if (achievementArray.size() > 0) {
            this.achievementService._onConditionChange(1, achievementArray, this.player, true);
        }
    }

    public void onArenaScore(int score) {
        List<AchievementExt> achievementArray = this.achievementService.findByConditionType(Const.ACHIEVEMENT_CONDITION_TYPE.ARENA_SCORE);

        if (achievementArray.size() > 0) {
            this.achievementService._onConditionChange(score, achievementArray, this.player, false);
        }
    }

    public void onGetAllyGold(int gold) {
        List<AchievementExt> achievementArray = this.achievementService.findByConditionType(Const.ACHIEVEMENT_CONDITION_TYPE.ALLY_GOLD);

        if (achievementArray.size() > 0) {
            this.achievementService._onConditionChange(gold, achievementArray, this.player, true);
        }
    }

    public void onGetAllyKillCount(int count) {
        List<AchievementExt> achievementArray = this.achievementService.findByConditionType(Const.ACHIEVEMENT_CONDITION_TYPE.ALLY_KILL_PLAYER);

        if (achievementArray.size() > 0) {
            this.achievementService._onConditionChange(count, achievementArray, this.player, false);
        }
    }

    public void onFriendNumber(int friendNum) {
        List<AchievementExt> achievementArray = this.achievementService.findByConditionType(Const.ACHIEVEMENT_CONDITION_TYPE.FRIENDS_NUM);

        if (achievementArray.size() > 0) {
            this.achievementService._onConditionChange(friendNum, achievementArray, this.player, true);
        }
    }

    public void onGemCombine(String code, int num) {
        List<AchievementExt> achievementArray = this.achievementService.findByConditionTypeAndTargetIdString(Const.ACHIEVEMENT_CONDITION_TYPE.GEM_COMBINE, code);

        if (achievementArray.size() > 0) {
            this.achievementService._onConditionChange(num, achievementArray, this.player, true);
        }
    }


    public void onTaskEvent(TaskEvent event) {
        int eventName = event.type;
        if (eventName == Const.EventType.killMonster.getValue()) {
            killNpc(event.params[0].toString());
        }
    }


    public void onEvent(Const.ACHIEVEMENT_CONDITION_TYPE condition_type, Object... params) {
        List<AchievementExt> achievementArray = null;
        int num = 0;
        switch (condition_type) {
            case GEM_COMBINE:
                achievementArray = this.achievementService.findByConditionTypeAndTargetIdString(Const.ACHIEVEMENT_CONDITION_TYPE.GEM_COMBINE, (String) params[0]);
                break;
        }


        if (achievementArray.size() > 0) {
            this.achievementService._onConditionChange(num, achievementArray, this.player, true);
        }
    }


    public List<PlayerHandler.SuperScriptType> getSuperScript() {
        List<PlayerHandler.SuperScriptType> list = new ArrayList<>();
        int number = 0;

        Map<Integer, Integer> chapters = new HashMap<>();
        for (null = GameData.AchievementConfigs.keySet().iterator(); null.hasNext(); ) {
            int typeId = ((Integer) null.next()).intValue();
            chapters.put(Integer.valueOf(typeId), Integer.valueOf(0));
        }


        for (AchievementDataPO.AchievePO achievePO : this.achievementDataPO.achievements.values()) {
            AchievementExt prop = (AchievementExt) GameData.Achievements.get(Integer.valueOf(achievePO.id));
            if (prop == null) {
                Out.error(new Object[]{AchievementManager.class, Integer.valueOf(achievePO.id)});

                continue;
            }
            AchievementConfigExt config = (AchievementConfigExt) GameData.AchievementConfigs.get(Integer.valueOf(prop.chapterID));


            if (!AchievementServiceNew.GetChapterOpened(this.player.getId(), prop.chapterID)) {
                continue;
            }
            if (achievePO.scheduleCurr >= prop.targetNum &&
                    achievePO.awardState == 0) {
                number++;


                if (chapters.containsKey(Integer.valueOf(config.typeId))) {
                    chapters.put(Integer.valueOf(config.typeId), Integer.valueOf(((Integer) chapters.get(Integer.valueOf(config.typeId))).intValue() + 1));
                    continue;
                }
                chapters.put(Integer.valueOf(config.typeId), Integer.valueOf(1));
            }
        }


        for (AchievementConfigExt config : GameData.AchievementConfigs.values()) {


            if (!AchievementServiceNew.GetChapterOpened(this.player.getId(), config.typeId)) {
                continue;
            }
            if (this.achievementDataPO.receivedAwards.contains(Integer.valueOf(config.typeId))) {
                continue;
            }
            List<AchievementExt> list_achieve = GameData.findAchievements(t -> (t.chapterID == config.typeId));


            if (list_achieve.size() == 0) {
                continue;
            }


            int recordCount = 0;
            for (AchievementExt achievementProp : list_achieve) {
                AchievementDataPO.AchievePO achieve = this.achievementRecordMap.get(Integer.valueOf(achievementProp.id));

                if (achieve == null) {
                    continue;
                }
                if (achieve.awardState == 1) {
                    recordCount++;
                    continue;
                }
                if (this.achievementService.isComplete(achieve, achievementProp)) {
                    recordCount++;
                }
            }

            if (recordCount == list_achieve.size()) {
                number++;


                if (chapters.containsKey(Integer.valueOf(config.typeId))) {
                    chapters.put(Integer.valueOf(config.typeId), Integer.valueOf(((Integer) chapters.get(Integer.valueOf(config.typeId))).intValue() + 1));
                    continue;
                }
                chapters.put(Integer.valueOf(config.typeId), Integer.valueOf(1));
            }
        }


        PlayerHandler.SuperScriptType.Builder data = PlayerHandler.SuperScriptType.newBuilder();
        data.setType(Const.SUPERSCRIPT_TYPE.GROWUP_TARGET.getValue());
        data.setNumber(number);
        list.add(data.build());


        for (Iterator<Integer> iterator = chapters.keySet().iterator(); iterator.hasNext(); ) {
            int chapterId = ((Integer) iterator.next()).intValue();
            PlayerHandler.SuperScriptType.Builder sc = PlayerHandler.SuperScriptType.newBuilder();
            sc.setType(Const.SUPERSCRIPT_TYPE.GROWUP_TARGET.getValue() + chapterId / 10);
            sc.setNumber(((Integer) chapters.get(Integer.valueOf(chapterId))).intValue());
            list.add(sc.build());
        }


        Map<Integer, int[]> progressMap = AchievementServiceNew.GetChapterProgress(this.player.getId());
        int progress = 0;
        for (int[] ar : progressMap.values()) {
            progress += ar[0];
        }
        PlayerHandler.SuperScriptType.Builder progressData = PlayerHandler.SuperScriptType.newBuilder();
        progressData.setType(Const.SUPERSCRIPT_TYPE.GROWUP_TOTAL.getValue());
        progressData.setNumber(progress);
        list.add(progressData.build());
        return list;
    }

    public void updateSuperScript() {
        this.player.updateSuperScriptList(getSuperScript());
    }


    public Map<Const.PlayerBtlData, Integer> calAllInfluence() {
        Map<Const.PlayerBtlData, Integer> data = new HashMap<>();

        int haveCount = 0;
        for (AchievementDataPO.HolyArmour holyArmour : this.achievementDataPO.holyArmourMap.values()) {
            if (holyArmour.states == 3) {
                ArmourAttributeExt armourAttributeExt = (ArmourAttributeExt) GameData.ArmourAttributes.get(Integer.valueOf(holyArmour.id));
                AttributeUtil.addData2AllData(armourAttributeExt.atts, data);
                haveCount++;
            }
        }
        if (haveCount > 0) {
            int x = haveCount;
            for (ArmourPlusExt armourPlusExt : GameData.findArmourPluss(v -> (x >= v.activateNum))) {
                AttributeUtil.addData2AllData(armourPlusExt.atts, data);
            }
        }
        return data;
    }


    public boolean activateHolyArmour(int id) {
        AchievementDataPO.HolyArmour armour = (AchievementDataPO.HolyArmour) this.player.achievementManager.achievementDataPO.holyArmourMap.get(Integer.valueOf(id));
        if (armour.states != 2) {
            return false;
        }
        armour.states = 3;
        this.player.btlDataManager.data_holy_armour = calAllInfluence();
        this.player.btlDataManager.calFinalData();
        this.player.onArmourActive();
        this.player.refreshBattlerServerAvatar();


        Map<Integer, String> data = new HashMap<>();
        for (AchievementDataPO.HolyArmour holyArmour : this.achievementDataPO.holyArmourMap.values()) {
            if (holyArmour.states == 3) {
                ArmourAttributeExt armourAttributeExt = (ArmourAttributeExt) GameData.ArmourAttributes.get(Integer.valueOf(holyArmour.id));
                if (armourAttributeExt != null) {
                    data.put(Integer.valueOf(holyArmour.id), armourAttributeExt.name);
                }
            }
        }
        BILogService.getInstance().ansycReportHolyArmour(this.player.getPlayer(), data);

        Out.info(new Object[]{"玩家：", this.player.getId(), "激活了元始圣甲，部位id:", Integer.valueOf(id)});
        return true;
    }

    public void FinishChapterAchievement(int chapterId) {
        Map<Integer, AchievementDataPO.AchievePO> achievementRecords = this.player.achievementManager.getAchievementRecords();

        List<AchievementExt> achievementArray = GameData.findAchievements(t -> (t.chapterID == chapterId));


        for (AchievementExt achievement : achievementArray) {


            AchievementDataPO.AchievePO achievementRecord = achievementRecords.get(Integer.valueOf(achievement.id));
            if (achievementRecord == null) {
                achievementRecord = new AchievementDataPO.AchievePO();
                achievementRecord.id = achievement.id;
                achievementRecord.scheduleCurr = 0;
                achievementRecords.put(Integer.valueOf(achievement.id), achievementRecord);
            }
            achievementRecord.scheduleCurr = achievement.targetNum;
        }


        this.player.achievementManager.updateSuperScript();
    }
}


