package com.wanniu.game.guild.guildTech;

import com.wanniu.core.game.LangService;
import com.wanniu.core.logfs.Out;
import com.wanniu.game.common.Const;
import com.wanniu.game.data.GTechnologyItemCO;
import com.wanniu.game.data.GTechnologyLevelCO;
import com.wanniu.game.data.GuildBuildingCO;
import com.wanniu.game.data.ext.GBuffExt;
import com.wanniu.game.data.ext.GTechnologyExt;
import com.wanniu.game.guild.GuildResult;
import com.wanniu.game.guild.GuildService;
import com.wanniu.game.guild.GuildUtil;
import com.wanniu.game.guild.dao.FindPlayerGuildDao;
import com.wanniu.game.guild.guildBless.GuildBless;
import com.wanniu.game.guild.guildBless.GuildBlessCenter;
import com.wanniu.game.item.ItemUtil;
import com.wanniu.game.player.AttributeUtil;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.GuildMemberPO;
import com.wanniu.game.poes.GuildPO;
import com.wanniu.game.poes.PlayerGuildPO;
import io.netty.util.internal.StringUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import pomelo.area.GuildTechHandler;


public class GuildTechManager {
    public WNPlayer player;
    public int level;
    public int buffLevel;
    public Map<String, Integer> products;
    public PlayerGuildPO techData;

    public GuildTechManager(WNPlayer player) {
        this.player = player;
        this.level = 0;
        this.buffLevel = 0;
        this.products = new HashMap<>();
        this.techData = FindPlayerGuildDao.getPlayerGuildPOById(player.getId());
        init();
    }

    public void init() {
        List<Integer> skillIdArray = GuildUtil.getTechSkillIdList();
        for (int i = 0; i < skillIdArray.size(); i++) {
            int skillId = ((Integer) skillIdArray.get(i)).intValue();
            if (!this.techData.skills.containsKey(Integer.valueOf(skillId))) {
                GuildTechSkill skill = new GuildTechSkill();
                skill.skillId = skillId;
                skill.level = 0;
                this.techData.skills.put(Integer.valueOf(skillId), skill);
            }
        }
        refreshLevel();
    }


    public void refreshLevel() {
        GuildPO guidlPo = GuildUtil.getPlayerGuild(this.player.getId());
        if (null == guidlPo) {
            this.level = 0;
            this.buffLevel = 0;

            return;
        }
        GuildBless bless = GuildBlessCenter.getInstance().getBless(guidlPo.id);
        if (null != bless) {
            this.level = bless.tech.level;
            this.buffLevel = bless.tech.buffLevel;
        }
    }

    public GuildResult getGuildTechAsync() {
        GuildResult ret = GuildService.getGuildTodayTechData(this.player);
        boolean isChangeInfluence = refreshTechData(ret.techData);
        if (isChangeInfluence) {
            pushAndRefreshGuildEffect();
        }
        return ret;
    }

    public boolean refreshTechData(GuildTechData data) {
        boolean isChangeInfluence = false;
        this.level = data.blobData.level;

        if (this.buffLevel != data.blobData.buffLevel) {
            this.buffLevel = data.blobData.buffLevel;
            isChangeInfluence = true;
        }

        this.products = data.blobData.products;
        refreshLevel();
        return isChangeInfluence;
    }


    public void resetPublicData() {
        this.level = 0;
        this.buffLevel = 0;
        this.products.clear();
    }

    public GuildTechHandler.GuildTechInfo toJson4PayLoad() {
        GuildTechHandler.GuildTechInfo.Builder data = GuildTechHandler.GuildTechInfo.newBuilder();
        data.setLevel(this.level);

        data.setBuffInfo(getBuffData());


        data.addAllSkillList(getSkillData());


        return data.build();
    }

    public GuildTechHandler.GuildBuff getBuffData() {
        GuildTechHandler.GuildBuff.Builder data = GuildTechHandler.GuildBuff.newBuilder();
        GBuffExt buffProp = GuildUtil.getTechBuffPropByLevel(this.buffLevel);
        data.setLevel(this.buffLevel);
        if (null != buffProp) {
            data.setNeedFund(buffProp.funds);
            data.addAllCurrentAttrs(AttributeUtil.getAttributeBase(buffProp.attrs));
        }

        GBuffExt nextBuffProp = GuildUtil.getTechBuffPropByLevel(this.buffLevel + 1);
        if (null != nextBuffProp) {
            data.addAllNextAttrs(AttributeUtil.getAttributeBase(nextBuffProp.attrs));
        }
        return data.build();
    }

    public List<GuildTechHandler.GuildSkill> getSkillData() {
        List<GuildTechHandler.GuildSkill> data = new ArrayList<>();
        for (GuildTechSkill skill : this.techData.skills.values()) {
            int skillId = skill.skillId;
            int skillLevel = skill.level;

            GTechnologyExt prop = GuildUtil.getTechSkillPropByIdLevel(skillId, skillLevel);
            if (null == prop) {
                continue;
            }

            GTechnologyExt nextProp = GuildUtil.getTechSkillPropByIdLevel(skillId, skillLevel + 1);

            GuildTechHandler.GuildSkill.Builder skillData = GuildTechHandler.GuildSkill.newBuilder();
            skillData.setId(skillId);
            skillData.setLevel(skillLevel);
            skillData.setTechName(prop.techName);
            skillData.setTechDes(prop.techDes);
            skillData.addAllCurrentAttrs(AttributeUtil.getAttributeBase(prop.attrs));
            skillData.setRecommend((prop.recommendPros.indexOf(Integer.valueOf(this.player.getPro())) != -1) ? 1 : 0);
            skillData.setIcon(prop.icon);
            if (null != nextProp) {
                skillData.addAllNextAttrs(AttributeUtil.getAttributeBase(nextProp.attrs));
                skillData.setNeedContribution(prop.points);
                skillData.setNeedGold(prop.gold);
            }
            data.add(skillData.build());
        }

        return data;
    }

    public GuildTechHandler.GuildSkill getOneSkillData(int id) {
        GuildTechHandler.GuildSkill.Builder skillData = GuildTechHandler.GuildSkill.newBuilder();
        GuildTechSkill skill = (GuildTechSkill) this.techData.skills.get(Integer.valueOf(id));
        if (null == skill) {
            return skillData.build();
        }
        int skillId = skill.skillId;
        int skillLevel = skill.level;

        GTechnologyExt prop = GuildUtil.getTechSkillPropByIdLevel(skillId, skillLevel);
        if (null == prop) {
            return skillData.build();
        }
        GTechnologyExt nextProp = GuildUtil.getTechSkillPropByIdLevel(skillId, skillLevel + 1);

        skillData.setId(skillId);
        skillData.setLevel(skillLevel);
        skillData.setTechName(prop.techName);
        skillData.setTechDes(prop.techDes);
        skillData.addAllCurrentAttrs(AttributeUtil.getAttributeBase(prop.attrs));
        skillData.setRecommend((prop.recommendPros.indexOf(Integer.valueOf(this.player.getPro())) != 1) ? 1 : 0);
        skillData.setIcon(prop.icon);
        skillData.setNeedContribution(0);
        skillData.setNeedGold(0);
        if (null != nextProp) {
            skillData.addAllNextAttrs(AttributeUtil.getAttributeBase(nextProp.attrs));
            skillData.setNeedContribution(prop.points);
            skillData.setNeedGold(prop.gold);
        }
        return skillData.build();
    }

    public List<GuildTechHandler.GuildProduct> getProduceData() {
        List<GuildTechHandler.GuildProduct> data = new ArrayList<>();
        for (String key : this.products.keySet()) {
            int id = Integer.parseInt(key);
            GTechnologyItemCO prop = GuildUtil.getTechProducePropById(id);
            if (null == prop) {
                continue;
            }
            String itemCode = prop.itemID;
            int itemNum = prop.count;

            GuildTechHandler.GuildProduct.Builder product = GuildTechHandler.GuildProduct.newBuilder();
            product.setId(id);
            product.setItem(ItemUtil.getMiniItemData(itemCode, itemNum).build());
            product.getItem().toBuilder().setBindType(prop.isBind);
            product.setLevel(prop.needLevel);
            product.setUpLevel(0);
            product.setNeedJob(prop.needPosition);
            product.setNeedContribution(prop.pointsPrice);
            if (this.techData.boughtList.indexOf(Integer.valueOf(id)) != -1) {
                product.setState(Const.EVENT_GIFT_STATE.RECEIVED.getValue());
            } else {
                product.setState(Const.EVENT_GIFT_STATE.CAN_RECEIVE.getValue());
            }
            data.add(product.build());
        }
        return data;
    }

    public void refreshNewDay(boolean isNewDay) {
        if (isNewDay) {
            this.techData.boughtList.clear();
        }
    }


    public Map<String, Integer> calAllInfluence() {
        Map<String, Integer> influs = new HashMap<>();
        if (!this.player.guildManager.isInGuild()) {
            return influs;
        }

        refreshLevel();

        GBuffExt buffProp = GuildUtil.getTechBuffPropByLevel(this.buffLevel);
        for (String key : buffProp.attrs.keySet()) {
            if (StringUtil.isNullOrEmpty(key)) {
                Out.error(new Object[]{"key is null buffProp"});
                continue;
            }
            if (influs.containsKey(key)) {
                int tmp = ((Integer) influs.get(key)).intValue();
                influs.put(key, Integer.valueOf(tmp + ((Integer) buffProp.attrs.get(key)).intValue()));
                continue;
            }
            influs.put(key, (Integer) buffProp.attrs.get(key));
        }


        for (Iterator<Integer> iterator = this.techData.skills.keySet().iterator(); iterator.hasNext(); ) {
            int skillId = ((Integer) iterator.next()).intValue();
            GuildTechSkill skill = (GuildTechSkill) this.techData.skills.get(Integer.valueOf(skillId));
            GTechnologyExt skillProp = GuildUtil.getTechSkillPropByIdLevel(skill.skillId, skill.level);
            if (null == skillProp) {
                continue;
            }

            for (String key : skillProp.attrs.keySet()) {
                if (StringUtil.isNullOrEmpty(key)) {
                    Out.error(new Object[]{"key is null in skillProp"});

                    continue;
                }
                if (influs.containsKey(key)) {
                    int tmp = ((Integer) influs.get(key)).intValue();
                    influs.put(key, Integer.valueOf(tmp + ((Integer) skillProp.attrs.get(key)).intValue()));
                    continue;
                }
                influs.put(key, (Integer) skillProp.attrs.get(key));
            }
        }


        return influs;
    }

    public void pushAndRefreshGuildEffect() {
        this.player.updatePlayerGuildTechAttrs();
    }

    public GuildResult upgradeTechLevel() {
        GuildResult ret = new GuildResult();
        ret = GuildService.techUpgradeLevel(this.player);
        GuildResult.UpgradeLevel data = (GuildResult.UpgradeLevel) ret.data;
        if (ret.result == 0) {
            this.level = data.level;
            if (data.needGold > 0) {
                this.player.moneyManager.costGold(data.needGold, Const.GOODS_CHANGE_TYPE.guild_upgrade_tech_level);
            }
        }
        return ret;
    }

    public GuildResult upgradeBuffLevel() {
        GuildResult ret = new GuildResult();
        ret = GuildService.techUpgradeBuffLevel(this.player);
        GuildResult.UpgradeLevel data = (GuildResult.UpgradeLevel) ret.data;
        if (ret.result == 0) {
            this.buffLevel = data.buffLevel;
            pushAndRefreshGuildEffect();
        }
        return ret;
    }

    public GuildResult upgradeSkillLevel(int id) {
        GuildResult ret = new GuildResult();
        getGuildTechAsync();
        if (!this.techData.skills.containsKey(Integer.valueOf(id))) {
            ret.result = -1;
            ret.des = "技能不存在";
            return ret;
        }

        GuildBuildingCO buildingProp = GuildUtil.getGuildBuildingProp(Const.GuildBuilding.TECH.getValue());
        GTechnologyLevelCO skillLevelProp = GuildUtil.getTechLevelPropByLevel(this.level);

        int levelPerStage = 10;
        int skillLevelMax = this.level * levelPerStage;
        if (null != skillLevelProp) {
            skillLevelMax = skillLevelProp.maxSkill;
        }


        if (((GuildTechSkill) this.techData.skills.get(Integer.valueOf(id))).level >= buildingProp.maxLv * levelPerStage) {
            ret.result = -2;
            ret.des = "技能等级已满";
            return ret;
        }

        if (((GuildTechSkill) this.techData.skills.get(Integer.valueOf(id))).level >= skillLevelMax) {
            ret.result = -3;
            String _des = LangService.getValue("TECH_SKILL_NEED_TECH_LEVEL");
            _des = _des.replace("{0}", "" + this.level);
            _des = _des.replace("{1}", "" + skillLevelMax);
            ret.des = _des;
            return ret;
        }

        GTechnologyExt skillProp = GuildUtil.getTechSkillPropByIdLevel(id, ((GuildTechSkill) this.techData.skills.get(Integer.valueOf(id))).level);
        if (!this.player.guildManager.enoughContribution(skillProp.points)) {
            ret.result = -4;
            ret.des = "帮贡不足";
            return ret;
        }
        if (!this.player.moneyManager.enoughGold(skillProp.gold)) {
            ret.result = -5;
            ret.des = "银两不足";
            return ret;
        }

        ((GuildTechSkill) this.techData.skills.get(Integer.valueOf(id))).level++;
        this.player.guildManager.costContribution(skillProp.points, Const.GOODS_CHANGE_TYPE.guild_tech);
        this.player.moneyManager.costGold(skillProp.gold, Const.GOODS_CHANGE_TYPE.guild_tech);
        this.player.allBlobData.playerAttachPO.miscData.guildSkillUpToday = 1;

        pushAndRefreshGuildEffect();
        ret.result = 0;
        ret.des = "success";
        return ret;
    }

    public GuildResult buyGuildTechProduct(int id) {
        GuildResult ret = new GuildResult();
        getGuildTechAsync();
        GTechnologyItemCO prop = GuildUtil.getTechProducePropById(id);

        if (null == prop || !this.products.containsKey(Integer.valueOf(id))) {
            ret.result = -1;
            ret.des = "产出不存在";
            return ret;
        }
        if (this.techData.boughtList.indexOf(Integer.valueOf(id)) != -1) {
            ret.result = -2;
            ret.des = "已购买";
            return ret;
        }
        GuildMemberPO myInfo = GuildUtil.getGuildMember(this.player.getId());
        if (null == myInfo) {
            ret.result = -3;
            ret.des = "还没有加入公会";
            return ret;
        }
        if (myInfo.job > prop.needPosition) {
            ret.result = -4;
            ret.des = "职位太低";
            return ret;
        }
        if (prop.needLevel > 0 && this.player.getLevel() < prop.needLevel) {
            ret.result = -5;
            ret.des = "等级不够";
            return ret;
        }
        if (this.player.guildManager.enoughContribution(prop.pointsPrice)) {
            ret.result = -6;
            ret.des = "帮贡不足";
            return ret;
        }
        String itemCode = prop.itemID;
        int itemNum = ((Integer) this.products.get(Integer.valueOf(id))).intValue();
        if (!this.player.bag.testAddCodeItem(itemCode, itemNum, Const.ForceType.getE(prop.isBind))) {
            ret.result = -7;
            ret.des = "背包空间不足";
            return ret;
        }

        this.player.bag.addCodeItem(itemCode, itemNum, Const.ForceType.getE(prop.isBind), Const.GOODS_CHANGE_TYPE.guild_buy_tech_product, null);
        this.player.guildManager.costContribution(prop.pointsPrice, Const.GOODS_CHANGE_TYPE.guild_buy_tech_product);
        this.techData.boughtList.add(Integer.valueOf(id));

        ret.result = 0;
        ret.des = "success";
        ret.id = String.valueOf(id);
        ret.state = Const.EVENT_GIFT_STATE.RECEIVED.getValue();
        return ret;
    }
}


