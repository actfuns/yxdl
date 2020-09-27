package com.wanniu.game.playerSkill;

import com.wanniu.core.logfs.Out;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.ext.SkillDataExt;
import com.wanniu.game.data.ext.SkillValueExt;

import java.util.ArrayList;
import java.util.Map;


public class SkillUtil {
    public static SkillDataExt getProp(int skillId) {
        return (SkillDataExt) GameData.SkillDatas.get(Integer.valueOf(skillId));
    }


    public static ArrayList<String> getDesData(int skillId, int skillLevel) {
        SkillValueExt exProp = (SkillValueExt) GameData.SkillValues.get(Integer.valueOf(skillId));
        Out.debug(new Object[]{"this.exProp: ", exProp});
        ArrayList<String> desData = new ArrayList<>();

        float dmgRate = (exProp.dmgRate + (skillLevel - 1) * exProp.dmgRatePerLvl) / 10000.0F;
        desData.add("" + dmgRate);

        int exdDmg = 0;
        if (exProp.exdDmgSetData.containsKey(skillLevel + "")) {
            exdDmg = ((Integer) exProp.exdDmgSetData.get(skillLevel + "")).intValue();
        }

        desData.add("" + ((exdDmg > 0) ? exdDmg : 0));

        int chance = exProp.chance / 100;
        desData.add("" + chance);

        int buffTime = 0;
        if (exProp.BuffTimeData.containsKey(Integer.valueOf(skillLevel))) {
            buffTime = ((Integer) exProp.BuffTimeData.get(Integer.valueOf(skillLevel))).intValue() / 1000;
        }


        desData.add("" + buffTime);

        for (int j = 1; j < 4; j++) {
            Map<String, SkillValueExt.SkillValueSetData> valueSetData = exProp.valueSetData;
            SkillValueExt.SkillValueSetData valuedata = valueSetData.get("valueSetData" + j);
            if (valuedata != null && valuedata.valueSet != null) {
                Map<String, Integer> valueSet = valuedata.valueSet;
                Out.debug(new Object[]{valueSet});
                try {
                    if (valueSet != null && ((Integer) valueSet.get("" + skillLevel)).intValue() > 0) {

                        float relative = 1.0F;

                        int ValueAttribute = valuedata.valueAttribute;


                        if (ValueAttribute == 1) {
                            relative = 100.0F;
                        } else if (ValueAttribute == 2) {
                            relative = 1000.0F;
                        } else if (ValueAttribute == 3) {
                            relative = 10000.0F;
                        }

                        desData.add("" + (((Integer) valueSet.get("" + skillLevel)).intValue() / relative));
                    } else {
                        desData.add("0");
                    }
                } catch (Exception e) {
                    Out.error(new Object[]{e});
                }
            } else {

                desData.add("0");
            }
        }

        return desData;
    }
}


