package com.wanniu.game.playerSkillKey;

import com.wanniu.game.common.Const;
import com.wanniu.game.common.ModuleManager;
import com.wanniu.game.data.ext.SkillDataExt;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.playerSkill.SkillUtil;
import com.wanniu.game.playerSkill.po.SkillDB;
import com.wanniu.game.poes.SkillsPO;

import java.util.ArrayList;
import java.util.List;

import pomelo.Common;


public class SkillKeyManager
        extends ModuleManager {
    public WNPlayer player;
    public SkillsPO player_skills;

    public SkillKeyManager(WNPlayer player, SkillsPO skills) {
        this.player = player;
        this.player_skills = skills;
    }


    public List<Common.SkillKeyStruct> toJson4Payload() {
        List<Common.SkillKeyStruct> list = new ArrayList<>();
        for (SkillDB skill : this.player_skills.skills.values()) {

            Common.SkillKeyStruct.Builder sk = Common.SkillKeyStruct.newBuilder();
            sk.setKeyPos(skill.pos);
            sk.setFlag(skill.flag);
            sk.setBaseSkillId(skill.id);
            SkillDataExt prop = SkillUtil.getProp(skill.id);
            sk.setIcon(prop.skillIcon);
            sk.setName(prop.skillName);
            sk.setAdvancedSkillId(skill.id);
            sk.setUnlockLevel(((Integer) prop.lvReqData.get(0)).intValue());
            list.add(sk.build());
        }

        return list;
    }


    public void onPlayerEvent(Const.PlayerEventType eventType) {
    }


    public Const.ManagerType getManagerType() {
        return Const.ManagerType.SKILL_KEY;
    }
}


