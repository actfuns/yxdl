package com.wanniu.game.data.ext;

import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.ClassUtil;
import com.wanniu.core.util.StringUtil;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.Utils;
import com.wanniu.game.data.PetSkillCO;

import java.util.HashMap;
import java.util.Map;


public class PetSkillExt
        extends PetSkillCO {
    public Map<Const.PlayerBtlData, Map<Integer, Integer>> attributeValues = new HashMap<>();


    public int[] power_arr;


    public void initProperty() {
        for (int i = 1; i < 4; i++) {

            String strValueSet = "valueSet";
            if (i > 1) {
                strValueSet = strValueSet + i;
            }

            Map<Integer, Integer> attributeValue = new HashMap<>();
            try {
                String[] valueSet = ClassUtil.getProperty(this, strValueSet).toString().split(";");

                for (String attribute : valueSet) {

                    String[] as = attribute.split(":");

                    if (as.length > 1) {

                        int level = Integer.parseInt(as[0]);

                        String value = as[1];

                        String[] tmp = value.split("-");
                        int _value = 0;
                        if (tmp.length > 1) {

                            _value = Utils.random(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]));
                        } else {
                            _value = Integer.parseInt(value);
                        }

                        attributeValue.put(Integer.valueOf(level), Integer.valueOf(_value));
                    }
                }


                String attributeName = (String) ClassUtil.getProperty(this, "valueAttributeName" + i);

                if (StringUtil.isNotEmpty(attributeName) &&
                        Const.PlayerBtlData.getEByKey(attributeName) != null) {

                    this.attributeValues.put(Const.PlayerBtlData.getEByKey(attributeName), attributeValue);
                }
            } catch (Exception e) {
                Out.error(new Object[]{e});
            }
        }

        if (StringUtil.isNotEmpty(this.power)) {
            String[] str_arr = this.power.split(";");
            int len = str_arr.length;
            this.power_arr = new int[len + 1];
            this.power_arr[0] = 0;
            for (int j = 0; j < len; j++) {
                String str = str_arr[j];
                String[] a_str = str.split(":");
                int lvl = Integer.parseInt(a_str[0]);
                if (lvl != j + 1) {
                    Out.error(new Object[]{"宠物技能脚本的战力有问题,skillid=" + this.skillID});
                }
                this.power_arr[Integer.parseInt(a_str[0])] = Integer.parseInt(a_str[1]);
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
}


