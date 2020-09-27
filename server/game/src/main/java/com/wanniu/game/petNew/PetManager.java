package com.wanniu.game.petNew;

import com.alibaba.fastjson.JSONObject;
import com.google.protobuf.GeneratedMessage;
import com.wanniu.core.common.IntIntPair;
import com.wanniu.core.game.LangService;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.StringUtil;
import com.wanniu.game.area.AreaDataConfig;
import com.wanniu.game.area.AreaUtil;
import com.wanniu.game.common.CommonUtil;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.ModuleManager;
import com.wanniu.game.common.msg.MessageUtil;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.PetItemCO;
import com.wanniu.game.data.base.MapBase;
import com.wanniu.game.data.ext.BaseDataExt;
import com.wanniu.game.data.ext.PetAssociateExt;
import com.wanniu.game.data.ext.PetConfigExt;
import com.wanniu.game.player.AttributeUtil;
import com.wanniu.game.player.BILogService;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.player.bi.LogReportService;
import com.wanniu.game.poes.PetNewPO;
import com.wanniu.game.poes.PlayerPetsNewPO;
import com.wanniu.game.rank.RankType;
import com.wanniu.game.sevengoal.SevenGoalManager;
import com.wanniu.game.util.BlackWordUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import pomelo.area.PetNewHandler;
import pomelo.area.PlayerHandler;


public class PetManager
        extends ModuleManager {
    public PlayerPetsNewPO petsPO;
    public WNPlayer player;
    public Map<Integer, PetNew> playerPets;
    public Map<Const.PlayerBtlData, Integer> masterAttr = new ConcurrentHashMap<>();
    public Map<Const.PlayerBtlData, Integer> masterAttrOnOutFight = new HashMap<>();


    public PetManager(WNPlayer player, PlayerPetsNewPO petsPO) {
        this.player = player;
        this.petsPO = petsPO;
        this.playerPets = new HashMap<>();
    }

    public void init() {
        for (PetNewPO petPO : this.petsPO.pets.values()) {
            PetNew pet = new PetNew(petPO, this.player);
            this.playerPets.put(Integer.valueOf(petPO.id), pet);
        }
        refreshMasterAttr();
    }


    public PetNewHandler.SummonPetResponse.Builder summonPet(int id) {
        PetNewHandler.SummonPetResponse.Builder res = PetNewHandler.SummonPetResponse.newBuilder();
        Map<Integer, BaseDataExt> map = GameData.BaseDatas;

        if (!map.containsKey(Integer.valueOf(id)) || this.petsPO.pets.containsKey(Integer.valueOf(id))) {
            res.setS2CCode(500);
            res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
            Out.warn(new Object[]{"宠物召唤失败,配表不存在或者已经有该宠物了!,roleId=", this.player.getId(), ",id=", Integer.valueOf(id)});
            return res;
        }
        BaseDataExt prop = map.get(Integer.valueOf(id));
        String itemCode = prop.petItemCode;
        int itemCount = prop.itemCount;
        if (!this.player.bag.isItemNumEnough(itemCode, itemCount)) {
            res.setS2CCode(500);
            res.setS2CMsg(LangService.getValue("NOT_ENOUGH_ITEM"));
            Out.warn(new Object[]{"宠物召唤失败,道具不足!,roleId=", this.player.getId(), ",id=", Integer.valueOf(id)});
            return res;
        }

        this.player.bag.discardItem(itemCode, itemCount, Const.GOODS_CHANGE_TYPE.pet);

        PetNew pet = createPet(id, prop);
        if (pet.po.id == this.petsPO.fightPetId) {
            res.setS2CFight(1);
        } else {
            res.setS2CFight(0);
        }
        res.setS2CCode(200);
        Out.info(new Object[]{"宠物召唤成功!,roleId=", this.player.getId(), ",id=", Integer.valueOf(id)});
        return res;
    }


    public String summonPetByItem(int id) {
        if (this.playerPets.containsKey(Integer.valueOf(id)))
            return LangService.getValue("ALREADY_HAVE_PET");
        BaseDataExt prop = (BaseDataExt) GameData.BaseDatas.get(Integer.valueOf(id));
        if (prop == null)
            return LangService.getValue("SOMETHING_ERR");
        createPet(id, prop);
        return null;
    }

    public PetNew createPet(int id, BaseDataExt prop) {
        PetNewPO petPo = new PetNewPO();
        petPo.id = id;
        petPo.name = prop.petName;
        petPo.level = prop.initLevel;
        petPo.upLevel = 0;
        petPo.skills = new HashMap<>();
        int index = 0;
        for (IntIntPair iip : prop.getInitSkills()) {
            PetSkill skill = new PetSkill(iip.first, iip.second, index, 0);
            petPo.skills.put(Integer.valueOf(iip.first), skill);
            index++;
        }
        petPo.passiveSkills = new HashMap<>();


        this.petsPO.pets.put(Integer.valueOf(petPo.id), petPo);
        PetNew pet = new PetNew(petPo, this.player);
        this.playerPets.put(Integer.valueOf(id), pet);
        if (this.playerPets.size() == 1) {
            petOutFight(petPo.id, 1);
        }
        refreshMasterAttr();
        this.player.onPetPropChange();
        String key = MessageUtil.getColor(pet.prop.qcolor);
        if (key != null && key.length() > 0) {
            String color = LangService.getValue(key).replace("{a}", petPo.name);
            String str = LangService.getValue("GAIN_PET").replace("{petName}", color);
            this.player.sendSysTip(str, Const.TipsType.NORMAL);
        }
        PetNewHandler.OnNewPetDetailPush.Builder data = PetNewHandler.OnNewPetDetailPush.newBuilder();
        data.setS2CCode(200);
        data.setS2CMsg("");
        data.setPetInfo(pet.toJson4PayLoad());

        this.player.receive("area.petNewPush.onNewPetDetailPush", (GeneratedMessage) data.build());
        this.player.achievementManager.onGetPet(prop.qcolor);
        this.player.achievementManager.onGetPetLevel(petPo.id, petPo.level);

        LogReportService.getInstance().ansycReportPetSkin(this.player, id);
        BILogService.getInstance().ansycReportPetActivate(this.player.getPlayer(), id, prop.petName);
        return pet;
    }

    public PetNewHandler.GetAllPetsInfoResponse.Builder toJson4Payload() {
        PetNewHandler.GetAllPetsInfoResponse.Builder data = PetNewHandler.GetAllPetsInfoResponse.newBuilder();
        data.setS2CCode(200);
        data.setS2CFightingPetId(this.petsPO.fightPetId);
        for (PetNew pet : this.playerPets.values()) {
            data.addS2CPetInfo(pet.toJson4PayLoad());
        }
        return data;
    }

    public void refreshMasterAttr() {
        this.masterAttr = new HashMap<>();
        this.masterAttrOnOutFight = new HashMap<>();
        for (PetNew pet : this.playerPets.values()) {
            AttributeUtil.addData2AllData(pet.attr_master, this.masterAttr);
            if (this.petsPO.fightPetId == pet.po.id) {
                int rate = 0;

                switch (pet.prop.qcolor) {
                    case 1:
                        rate = ((PetConfigExt) GameData.PetConfigs.get("PetPro.Transform1")).intValue;
                        break;
                    case 2:
                        rate = ((PetConfigExt) GameData.PetConfigs.get("PetPro.Transform2")).intValue;
                        break;
                    case 3:
                        rate = ((PetConfigExt) GameData.PetConfigs.get("PetPro.Transform3")).intValue;
                        break;
                    case 4:
                        rate = ((PetConfigExt) GameData.PetConfigs.get("PetPro.Transform4")).intValue;
                        break;
                }
                if (rate == 0) {
                    Out.error(new Object[]{"Can't find qcolor by petid:" + pet.po.id + " qcolor:" + pet.prop.qcolor});

                    continue;
                }
                for (Const.PlayerBtlData btl : pet.attr_all_pet.keySet()) {
                    if (btl != Const.PlayerBtlData.CritDamage) {
                        int val = ((Integer) pet.attr_all_pet.get(btl)).intValue() * rate / 100;
                        this.masterAttrOnOutFight.put(btl, Integer.valueOf(val));
                    }
                }
            }
        }
        AttributeUtil.addData2AllData(calAssociateInfluence(), this.masterAttr);


        if (this.player.rankManager != null) {
            updateRank();
        }
    }

    private void updateRank() {
        PetNewPO petMax = null;
        int petFightPowerMax = 0;
        for (PetNewPO pet : this.petsPO.pets.values()) {
            int petFightPower = pet.fightPower;
            if (petFightPower > petFightPowerMax) {
                petFightPowerMax = petFightPower;
                petMax = pet;
            }
        }
        if (petMax != null && this.player.rankManager != null) {
            this.player.rankManager.onEvent(RankType.PET, new Object[]{Integer.valueOf(petMax.id), petMax.name, Integer.valueOf(petMax.fightPower)});
        }
    }

    public String petOutFight(int petId, int type) {
        PetNew pet = this.playerPets.get(Integer.valueOf(petId));
        if (pet == null) {
            return LangService.getValue("PET_NOT_EXIST");
        }
        if (type == 1) {
            if (this.petsPO.fightPetId == petId) {
                return LangService.getValue("ALREADY_BATTLE");
            }
            if (StringUtil.isEmpty(getFightingPetId())) {

                this.player.getXmdsManager().refreshPlayerPetDataChange(this.player.getId(), PetOperatorType.Add.getValue(), pet.getBattlerServerPetData());
            } else {
                this.player.getXmdsManager().refreshPlayerPetDataChange(this.player.getId(), PetOperatorType.Replace.getValue(), pet.getBattlerServerPetData());
            }
            this.petsPO.fightPetId = petId;
            this.player.sendSysTip(LangService.getValue("BATTLING"), Const.TipsType.NO_BG);
        } else if (type == 0) {
            if (StringUtil.isEmpty(getFightingPetId()) || this.petsPO.fightPetId != petId) {
                return LangService.getValue("ALREADY_REST");
            }
            this.petsPO.fightPetId = 0;
            MapBase prop = AreaUtil.getAreaProp(this.player.getAreaId());
            if (prop != null && 1 == prop.takePet) {
                try {
                    this.player.getXmdsManager().refreshPlayerPetDataChange(this.player.getId(), PetOperatorType.Delete.getValue(), null);
                } catch (Exception e) {
                    Out.error(new Object[]{"syncNowPetData error", e});
                }
                this.player.sendSysTip(LangService.getValue("RESTING"), Const.TipsType.NO_BG);
            }
        } else {
            return LangService.getValue("PARAM_ERROR");
        }

        refreshMasterAttr();
        this.player.onPetPropChange();


        this.player.player.fightingPetId = String.valueOf(this.petsPO.fightPetId);
        this.player.pushDynamicData("fightingPetId", this.player.player.fightingPetId);

        BILogService.getInstance().ansycReportPetBattle(this.player.getPlayer(), petId, pet.prop.petName, pet.po.level, pet.po.upLevel, type);
        return null;
    }


    public PetNewHandler.ChangePetNameNewResponse.Builder changePetName(int id, String petName) {
        PetNewHandler.ChangePetNameNewResponse.Builder result = PetNewHandler.ChangePetNameNewResponse.newBuilder();
        result.setS2CCode(500);
        PetNew pet = this.playerPets.get(Integer.valueOf(id));
        if (pet == null) {
            result.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
            return result;
        }

        if (petName == null || petName.length() <= 0) {
            result.setS2CMsg(LangService.getValue("PET_NAME_NULL"));
            return result;
        }
        if (petName.length() > 6) {
            result.setS2CMsg(LangService.getValue("PET_NAME_LONG"));
            return result;
        }
        if (!CommonUtil.isLegalString(petName) || BlackWordUtil.isIncludeBlackString(petName)) {
            result.setS2CMsg(LangService.getValue("ILLEGAL_CHARACTER"));
            return result;
        }
        if (!this.player.moneyManager.costDiamond(((PetConfigExt) GameData.PetConfigs.get("Rename.Cost")).intValue, Const.GOODS_CHANGE_TYPE.petChangeName)) {
            result.setS2CMsg(LangService.getValue("NOT_ENOUGH_DIAMOND"));
            return result;
        }
        result.setS2CCode(200);

        pet.po.name = petName;

        updateRank();

        if (this.petsPO.fightPetId == pet.po.id) {
            this.player.getXmdsManager().refreshPlayerPetDataChange(this.player.getId(), PetOperatorType.Reset.getValue(), pet.getBattlerServerPetData());
        }
        result.setPetInfo(pet.toJson4PayLoad());
        return result;
    }


    public PetNewHandler.AddExpByItemResponse.Builder addExpByItem(int id, String itemCode, int itemCount) {
        PetNewHandler.AddExpByItemResponse.Builder result = PetNewHandler.AddExpByItemResponse.newBuilder();
        result.setS2CCode(500);
        PetNew pet = this.playerPets.get(Integer.valueOf(id));
        if (pet == null) {
            result.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
            Out.warn(new Object[]{"宠物单次加经验失败,找不到该宠物!,roleId=", this.player.getId(), ",宠物id=", Integer.valueOf(id), ",道具Id=", itemCode});
            return result;
        }
        if (!pet.prop.list_ExpCode.contains(itemCode)) {
            result.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
            Out.warn(new Object[]{"宠物单次加经验失败,配表找不到宠物使用的经验药水!,roleId=", this.player.getId(), ",宠物id=", Integer.valueOf(id), ",道具Id=", itemCode});
            return result;
        }
        if (!this.player.bag.isItemNumEnough(itemCode, itemCount)) {
            result.setS2CMsg(LangService.getValue("NOT_ENOUGH_ITEM"));
            return result;
        }
        if (!pet.canAddExp()) {
            result.setS2CMsg(LangService.getValue("PET_MAX_LEVEL"));
            Out.warn(new Object[]{"宠物单次加经验失败,等级超上限了!,roleId=", this.player.getId(), ",宠物id=", Integer.valueOf(id), ",道具Id=", itemCode, ",当前等级为:", Integer.valueOf(pet.po.level), ",当前可提升最大等级为:", Integer.valueOf(pet.getCurMaxLv())});
            return result;
        }
        result.setS2CCode(200);
        PetItemCO prop_item = (PetItemCO) GameData.PetItems.get(itemCode);
        int exp = prop_item.min;
        int remain = itemCount;

        while (pet.canAddExp() && remain > 0) {
            remain--;
            pet.addExp(exp, true);
        }
        this.player.bag.discardItem(itemCode, itemCount - remain, Const.GOODS_CHANGE_TYPE.pet);
        result.setPetInfo(pet.toJson4PayLoad());


        this.player.taskManager.dealTaskEvent(Const.TaskType.PET_TRAIN, String.valueOf(id), 1);
        Out.info(new Object[]{"宠物单次加经验成功!,roleId=", this.player.getId(), ",宠物id=", Integer.valueOf(id), ",道具Id=", itemCode, "，当前等级=", Integer.valueOf(pet.po.level), ",当前经验为:", Long.valueOf(pet.po.exp)});
        return result;
    }


    public PetNewHandler.UpgradeToTopResponse.Builder reqUpgrade2Top(int id) {
        PetNewHandler.UpgradeToTopResponse.Builder result = PetNewHandler.UpgradeToTopResponse.newBuilder();
        result.setS2CCode(500);
        PetNew pet = this.playerPets.get(Integer.valueOf(id));
        if (pet == null) {
            result.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
            Out.warn(new Object[]{"宠物升级最高等级失败,找不到该宠物!,roleId=", this.player.getId(), ",宠物id=", Integer.valueOf(id)});
            return result;
        }
        if (!pet.canAddExp()) {
            result.setS2CMsg(LangService.getValue("PET_MAX_LEVEL"));
            Out.warn(new Object[]{"宠物升级最高等级失败,等级超上限了!,roleId=", this.player.getId(), ",宠物id=", Integer.valueOf(id), ",当前等级为:", Integer.valueOf(pet.po.level), ",当前可提升最大等级为:", Integer.valueOf(pet.getCurMaxLv())});
            return result;
        }
        boolean flag = false;
        for (String itemCode : pet.prop.list_ExpCode) {
            if (this.player.bag.findItemNumByCode(itemCode) > 0) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            result.setS2CMsg(LangService.getValue("NOT_ENOUGH_ITEM"));
            return result;
        }
        result.setS2CCode(200);
        boolean hasUpgrade = false;
        boolean hasItem = true;
        int loopCount = 0;
        while (pet.canAddExp() && hasItem && loopCount++ < 100) {
            boolean isItemFlag = false;
            long nextLvExp = pet.getNextLevelneedExp();
            for (String itemCode : pet.prop.list_ExpCode) {
                if (!pet.canAddExp())
                    break;
                PetItemCO prop_item = (PetItemCO) GameData.PetItems.get(itemCode);
                int exp = prop_item.min;
                int itemCount = this.player.bag.findItemNumByCode(itemCode);
                if (itemCount <= 0) {
                    continue;
                }
                isItemFlag = true;
                long canAddExp = 1L * itemCount * exp;
                int removeItemCount = itemCount;
                int result_addExp = 0;
                if (nextLvExp >= canAddExp) {
                    result_addExp = pet.addExp((int) canAddExp, false);
                } else {
                    long t1 = nextLvExp % exp;
                    removeItemCount = (t1 == 0L) ? (int) (nextLvExp / exp) : (int) (nextLvExp / exp + 1L);
                    result_addExp = pet.addExp((int) nextLvExp, false);
                }
                if (result_addExp == 1) {
                    hasUpgrade = true;
                    nextLvExp = pet.getNextLevelneedExp();
                }
                this.player.bag.discardItem(itemCode, removeItemCount, Const.GOODS_CHANGE_TYPE.pet);
            }
            hasItem = isItemFlag;
        }
        if (loopCount >= 100) {
            Out.warn(new Object[]{"一键升顶时判断有异常情况,怀疑死循环,playerId=", this.player.getId()});
        }

        if (hasUpgrade && this.petsPO.fightPetId == pet.po.id) {
            this.player.getXmdsManager().refreshPlayerPetDataChange(this.player.getId(), PetOperatorType.Reset.getValue(), pet.getBattlerServerPetData());
        }
        if (hasUpgrade) {
            refreshMasterAttr();
            this.player.onPetPropChange();
            pet.pushInfoUpdate();
        } else {
            pet.pushExpUpdate();
        }
        result.setPetInfo(pet.toJson4PayLoad());


        this.player.taskManager.dealTaskEvent(Const.TaskType.PET_TRAIN, String.valueOf(id), 1);
        Out.info(new Object[]{"宠物升级最高等级成功!,roleId=", this.player.getId(), ",宠物id=", Integer.valueOf(id), "，当前等级=", Integer.valueOf(pet.po.level), ",当前经验为:", Long.valueOf(pet.po.exp)});
        return result;
    }


    public PetNewHandler.UpgradeOneLevelResponse.Builder reqUpgradeOneLevel(int id) {
        PetNewHandler.UpgradeOneLevelResponse.Builder result = PetNewHandler.UpgradeOneLevelResponse.newBuilder();
        result.setS2CCode(500);
        PetNew pet = this.playerPets.get(Integer.valueOf(id));
        if (pet == null) {
            result.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
            return result;
        }
        if (!pet.canAddExp()) {
            result.setS2CMsg(LangService.getValue("PET_MAX_LEVEL"));
            return result;
        }
        boolean flag = false;
        for (String itemCode : pet.prop.list_ExpCode) {
            if (this.player.bag.findItemNumByCode(itemCode) > 0) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            result.setS2CMsg(LangService.getValue("NOT_ENOUGH_ITEM"));
            return result;
        }

        result.setS2CCode(200);
        int targetLevel = pet.po.level + 1;
        boolean hasUpgrade = false;
        for (String itemCode : pet.prop.list_ExpCode) {
            if (!pet.canAddExp())
                break;
            PetItemCO prop_item = (PetItemCO) GameData.PetItems.get(itemCode);
            int exp = prop_item.min;
            int itemCount = this.player.bag.findItemNumByCode(itemCode);
            int remain = itemCount;
            int result_addExp = 0;
            while (pet.po.level < targetLevel && remain > 0) {
                remain--;
                result_addExp = pet.addExp(exp, false);
                if (!hasUpgrade && result_addExp == 1) {
                    hasUpgrade = true;
                }
            }
            this.player.bag.discardItem(itemCode, itemCount - remain, Const.GOODS_CHANGE_TYPE.pet);
        }
        result.setPetInfo(pet.toJson4PayLoad());


        if (hasUpgrade && this.petsPO.fightPetId == pet.po.id) {
            this.player.getXmdsManager().refreshPlayerPetDataChange(this.player.getId(), PetOperatorType.Reset.getValue(), pet.getBattlerServerPetData());
        }
        if (hasUpgrade) {
            refreshMasterAttr();
            this.player.onPetPropChange();
            pet.pushInfoUpdate();
        } else {
            pet.pushExpUpdate();
        }


        this.player.taskManager.dealTaskEvent(Const.TaskType.PET_TRAIN, String.valueOf(id), 1);
        return result;
    }

    public Map<String, Object> getBattlerServerPetBase() {
        if (this.petsPO.fightPetId != 0) {
            PetNew pet = this.playerPets.get(Integer.valueOf(this.petsPO.fightPetId));
            return (Map<String, Object>) pet.getBattlerServerPetBase();
        }
        Map<String, Object> data = new HashMap<>();
        data.put("Model", "");
        data.put("ModelPercent", Integer.valueOf(0));
        data.put("ModelStar", "");
        data.put("ModelStarPercent", Integer.valueOf(0));
        data.put("name", "");
        data.put("level", Integer.valueOf(0));
        data.put("Qcolor", Integer.valueOf(0));
        data.put("templateId", Integer.valueOf(0));
        data.put("Icon", "");
        data.put("upGradeLevel", Integer.valueOf(0));
        return data;
    }


    public Map<String, Object> getBattlerServerPetEffect() {
        Map<String, Object> data = new HashMap<>();
        if (this.petsPO.fightPetId != 0) {
            PetNew pet = this.playerPets.get(Integer.valueOf(this.petsPO.fightPetId));


            JSONObject json = pet.getBattlerServerPetEffect();
            for (String key : json.keySet()) {
                data.put(key, json.get(key));
            }
        } else {
            data.put("Ac", Integer.valueOf(0));
            data.put("Crit", Integer.valueOf(0));
            data.put("Dodge", Integer.valueOf(0));
            data.put("Hit", Integer.valueOf(0));
            data.put("HP", Integer.valueOf(0));
            data.put("HPReborn", Integer.valueOf(0));
            data.put("IgnoreAc", Integer.valueOf(0));
            data.put("IgnoreAcPer", Integer.valueOf(0));
            data.put("IgnoreResist", Integer.valueOf(0));
            data.put("IgnoreResistPer", Integer.valueOf(0));
            data.put("IgnorMagDamage", Integer.valueOf(0));
            data.put("IgnorPhyDamage", Integer.valueOf(0));
            data.put("MaxHP", Integer.valueOf(0));
            data.put("MaxMag", Integer.valueOf(0));
            data.put("MaxMP", Integer.valueOf(0));
            data.put("MaxPhy", Integer.valueOf(0));
            data.put("MinMag", Integer.valueOf(0));
            data.put("MinPhy", Integer.valueOf(0));
            data.put("MoveSpeed", Integer.valueOf(0));
            data.put("MP", Integer.valueOf(0));
            data.put("MPReborn", Integer.valueOf(0));
            data.put("Rescrit", Integer.valueOf(0));
            data.put("Resist", Integer.valueOf(0));
            data.put("HealEffect", Integer.valueOf(0));
            data.put("HealedEffect", Integer.valueOf(0));
        }
        return data;
    }


    public List<Map<String, Integer>> getBattlerServerPetSkill() {
        List<Map<String, Integer>> data = new ArrayList<>();
        if (this.petsPO.fightPetId != 0) {
            PetNew pet = this.playerPets.get(Integer.valueOf(this.petsPO.fightPetId));
            return pet.getBattlerServerPetSkill();
        }
        return data;
    }


    public int getPkDataToBattleJson() {
        MapBase sceneProp = AreaDataConfig.getInstance().get(this.player.getAreaId());
        if (sceneProp != null &&
                sceneProp.changePetAI == 0) {
            return sceneProp.petAI;
        }

        return getPkModel();
    }


    public static int getPkModel() {
        return 1;
    }

    public String getFightingPetId() {
        return (this.petsPO.fightPetId == 0) ? "" : (this.petsPO.fightPetId + "");
    }


    public List<PlayerHandler.SuperScriptType> getSuperScript() {
        return null;
    }


    public int petCanGet() {
        return this.petsPO.pkModel;
    }

    public PetNew getFightingPet() {
        return this.playerPets.get(Integer.valueOf(this.petsPO.fightPetId));
    }

    public void addExp(String id, int exp) {
        addExp(StringUtil.isEmpty(id) ? 0 : Integer.parseInt(id), exp);
    }

    public void addExp(int id, int exp) {
        PetNew pet = this.playerPets.get(Integer.valueOf(id));
        if (pet != null) {
            pet.addExp(exp, true);
        }
    }

    public String changePetPkModel(int reqModel) {
        MapBase sceneProp = AreaDataConfig.getInstance().get(this.player.getAreaId());
        if (sceneProp != null &&
                sceneProp.changePKtype == 0) {
            return LangService.getValue("AREA_CANNOT_CHANG_PKMODE");
        }

        if (reqModel == getPkModel()) {
            return LangService.getValue("PARAM_ERROR");
        }
        this.petsPO.pkModel = reqModel;

        this.player.getXmdsManager().refreshPlayerPetFollowModeChange(this.player.getId(), reqModel);

        this.player.pushDynamicData("petPkModel", Integer.valueOf(this.petsPO.pkModel));

        return null;
    }

    public PetNewHandler.UpGradeUpLevelResponse.Builder upgradeUplevel(int id) {
        PetNewHandler.UpGradeUpLevelResponse.Builder res = PetNewHandler.UpGradeUpLevelResponse.newBuilder();
        res.setS2CCode(500);
        PetNew pet = this.playerPets.get(Integer.valueOf(id));
        if (pet == null) {
            res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
            Out.warn(new Object[]{"宠物突破失败,因为宠物不存在!,roleId=", this.player.getId(), ",宠物id=", Integer.valueOf(id)});
            return res;
        }
        int result = pet.upgradeUplevel();
        if (result == 0) {
            res.setS2CCode(200);
            res.setPetInfo(pet.toJson4PayLoad());
        } else {
            Out.warn(new Object[]{"宠物突破失败!,roleId=", this.player.getId(), ",宠物id=", Integer.valueOf(id), "result=", Integer.valueOf(result)});
            res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
        }
        this.player.sevenGoalManager.processGoal(SevenGoalManager.SevenGoalTaskType.PET_UPGRADE_UPLV, new Object[]{Integer.valueOf(getMaxPetUpLv())});
        Out.info(new Object[]{"宠物突破成功!,roleId=", this.player.getId(), ",宠物id=", Integer.valueOf(id), "当前阶为:", Integer.valueOf(pet.po.upLevel)});
        return res;
    }

    private void onPlayerUpgrade() {
        for (PetNew pet : this.playerPets.values()) {
            pet.initCurMaxLv();
        }
    }

    public PetNewHandler.GetPetInfoNewResponse.Builder getPetInfo(int id) {
        PetNewHandler.GetPetInfoNewResponse.Builder res = PetNewHandler.GetPetInfoNewResponse.newBuilder();
        PetNew pet = this.playerPets.get(Integer.valueOf(id));
        if (pet == null) {
            res.setS2CCode(500);
            res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
            return res;
        }
        res.setS2CCode(200);
        res.setS2CPet(pet.toJson4PayLoad());
        return res;
    }


    public Map<Const.PlayerBtlData, Integer> calAssociateInfluence() {
        Map<Const.PlayerBtlData, Integer> data = new HashMap<>();
        for (PetAssociateExt petAssociateExt : GameData.PetAssociates.values()) {
            boolean actived = true;
            for (Map.Entry<Integer, Integer> entry : (Iterable<Map.Entry<Integer, Integer>>) petAssociateExt.petIDMap.entrySet()) {
                PetNewPO activedPetNewPO = null;
                for (PetNewPO petNewPO : this.petsPO.pets.values()) {
                    if (petNewPO.id == ((Integer) entry.getKey()).intValue()) {
                        if (petNewPO.upLevel >= ((Integer) entry.getValue()).intValue()) {

                            activedPetNewPO = petNewPO;
                            break;
                        }
                    }
                }
                if (activedPetNewPO == null) {
                    actived = false;
                }
            }


            if (!actived) {
                continue;
            }


            for (Map.Entry<Integer, Integer> entry2 : (Iterable<Map.Entry<Integer, Integer>>) petAssociateExt.addProMap.entrySet()) {
                Const.PlayerBtlData key = Const.PlayerBtlData.getE(((Integer) entry2.getKey()).intValue());
                int oldValue = 0;
                if (data.containsKey(key)) {
                    oldValue += ((Integer) data.get(key)).intValue();
                }

                data.put(key, Integer.valueOf(((Integer) entry2.getValue()).intValue() + oldValue));
            }
        }

        return data;
    }

    public int getMaxPetUpLv() {
        int maxUpLv = 0;
        for (PetNew petNew : this.playerPets.values()) {
            if (petNew.po.upLevel > maxUpLv) {
                maxUpLv = petNew.po.upLevel;
            }
        }
        return maxUpLv;
    }


    public void onPlayerEvent(Const.PlayerEventType eventType) {
        switch (eventType) {
            case UPGRADE:
                onPlayerUpgrade();
                break;
        }
    }


    public Const.ManagerType getManagerType() {
        return Const.ManagerType.PET;
    }
}


