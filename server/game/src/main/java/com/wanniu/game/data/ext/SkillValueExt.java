package com.wanniu.game.data.ext;

import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.ClassUtil;
import com.wanniu.core.util.StringUtil;
import com.wanniu.game.common.Utils;
import com.wanniu.game.data.SkillValueCO;

import java.util.HashMap;
import java.util.Map;


public class SkillValueExt
        extends SkillValueCO {
    public Map<String, Integer> costManaSetData;
    public Map<String, Integer> exdDmgSetData;
    public Map<Integer, Integer> BuffTimeData;
    public Map<String, SkillValueSetData> valueSetData;

    public static class SkillValueSetData {
        public String valueName;
        public Map<String, Integer> valueSet = new HashMap<>();

        public int valueAttribute;
    }


    public void initProperty() {
        String costManaSetStr = this.costManaSet;

        this.costManaSetData = new HashMap<>();
        if (StringUtil.isNotEmpty(costManaSetStr)) {
            String[] a_costManaSetStr = costManaSetStr.split(";");
            int len = a_costManaSetStr.length;
            for (int i = 0; i < len; i++) {
                String str = a_costManaSetStr[i];
                String[] a_str = str.split(":");
                if (a_str != null && a_str.length >= 2) {
                    this.costManaSetData.put(a_str[0], Integer.valueOf(Integer.parseInt(a_str[1])));
                }
            }
        }

        String exdDmgSetStr = this.exdDmgSet;
        this.exdDmgSetData = new HashMap<>();
        if (StringUtil.isNotEmpty(exdDmgSetStr)) {
            String[] a_exdDmgSetStr = exdDmgSetStr.split(";");
            int len = a_exdDmgSetStr.length;
            for (int i = 0; i < len; i++) {
                String str = a_exdDmgSetStr[i];
                String[] a_str = str.split(":");
                if (a_str != null && a_str.length >= 2) {
                    this.exdDmgSetData.put(a_str[0], Integer.valueOf(Integer.parseInt(a_str[1])));
                }
            }
        }

        String BuffTimeStr = this.buffTime;
        this.BuffTimeData = new HashMap<>();
        if (StringUtil.isNotEmpty(BuffTimeStr)) {
            String[] BuffTimeArray = BuffTimeStr.split(";");
            for (int i = 0; i < BuffTimeArray.length; i++) {
                String str = BuffTimeArray[i];
                String[] a_str = str.split(":");
                if (a_str != null && a_str.length >= 2) {
                    this.BuffTimeData.put(Integer.valueOf(Integer.parseInt(a_str[0])), Integer.valueOf(Integer.parseInt(a_str[1])));
                }
            }
        }

        try {
            this.valueSetData = new HashMap<>();
            String valueSetStr4 = null;
            Object vss = null;
            for (int j = 1; j < 3; j++) {
                if (j == 1) {
                    vss = ClassUtil.getProperty(this, "valueSet");
                } else {
                    vss = ClassUtil.getProperty(this, "valueSet" + j);
                }
                if (vss != null) {


                    valueSetStr4 = (String) vss;
                    Map<String, Integer> valueSetData4 = new HashMap<>();
                    if (StringUtil.isNotEmpty(valueSetStr4)) {
                        String[] a_valueSetStr4 = valueSetStr4.split(";");
                        int len4 = a_valueSetStr4.length;
                        for (int i = 0; i < len4; i++) {
                            String str4 = a_valueSetStr4[i];
                            String[] a_str4 = str4.split(":");
                            if (a_str4 != null && a_str4.length >= 2) {

                                String value = a_str4[1];
                                int _value = 0;
                                String[] tmp = value.split("-");

                                if (tmp.length > 1) {

                                    _value = Utils.random(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]));
                                } else {
                                    _value = Integer.parseInt(value);
                                }

                                valueSetData4.put(a_str4[0], Integer.valueOf(_value));
                            }
                        }
                        String keystring = "valueSetData" + j;
                        SkillValueSetData data = new SkillValueSetData();
                        data.valueName = (String) ClassUtil.getProperty(this, "valueAttributeName" + j);
                        data.valueSet = valueSetData4;
                        data.valueAttribute = ((Integer) ClassUtil.getProperty(this, "valueAttribute" + j)).intValue();
                        this.valueSetData.put(keystring, data);
                    }
                }
            }
        } catch (Exception e) {
            Out.error(new Object[]{e});
        }
    }
}


