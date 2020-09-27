package com.wanniu.game.data.ext;

import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.StringUtil;
import com.wanniu.game.data.TalentEffectCO;

import java.util.HashMap;
import java.util.Map;


public class TalentEffectExt
        extends TalentEffectCO {
    public int[] power_arr;
    public Map<Integer, Integer> replaceSkillMap;

    public void initProperty() {
        if (StringUtil.isNotEmpty(this.power)) {
            String[] str_arr = this.power.split(";");
            int len = str_arr.length;
            this.power_arr = new int[len + 1];
            this.power_arr[0] = 0;
            for (int i = 0; i < len; i++) {
                String str = str_arr[i];
                String[] a_str = str.split(":");
                int lvl = Integer.parseInt(a_str[0]);
                if (lvl != i + 1) {
                    Out.error(new Object[]{"天赋的战力有问题,talentID=", Integer.valueOf(this.talentID)});
                }
                this.power_arr[Integer.parseInt(a_str[0])] = Integer.parseInt(a_str[1]);
            }
        }

        if (this.talentType == 2) {
            this.replaceSkillMap = new HashMap<>();
            String[] str_arr = this.replaceSkill.split(";");
            int len = str_arr.length;
            for (int i = 0; i < len; i++) {
                String str = str_arr[i];
                String[] a_str = str.split(":");
                int lvl = Integer.parseInt(a_str[0]);
                if (lvl != i + 1) {
                    Out.error(new Object[]{"天赋脚本的替换的技能,talentID=", Integer.valueOf(this.talentID)});
                }
                this.replaceSkillMap.put(Integer.valueOf(lvl), Integer.valueOf(Integer.parseInt(a_str[1])));
            }
        }
    }


    public int getSkillPower(int lvl) {
        if (lvl < 0)
            return 0;
        if (this.power_arr != null) {


            if (lvl > this.power_arr.length - 1) {
                return this.power_arr[this.power_arr.length - 1];
            }
            return this.power_arr[lvl];
        }
        return 0;
    }

    public int getReplaceSkillId(int talentLv) {
        if (this.replaceSkillMap != null && this.replaceSkillMap.containsKey(Integer.valueOf(talentLv)))
            return ((Integer) this.replaceSkillMap.get(Integer.valueOf(talentLv))).intValue();
        return 0;
    }
}


