package com.wanniu.game.data.ext;

import com.wanniu.core.util.StringUtil;
import com.wanniu.game.common.Const;
import com.wanniu.game.data.PassiveSkillCO;

import java.util.HashMap;
import java.util.Map;

public class PassiveSkillExt
        extends PassiveSkillCO {
    public Const.PlayerBtlData ValueAttribute1;
    public Map<Integer, Integer> ValueSetMap1;
    public Const.PlayerBtlData ValueAttribute2;
    public Map<Integer, Integer> ValueSetMap2;
    public Const.PlayerBtlData ValueAttribute3;
    public Map<Integer, Integer> ValueSetMap3;

    public void initProperty() {
        if (StringUtil.isNotEmpty(this.valueAttributeName1)) {
            this.ValueAttribute1 = Const.PlayerBtlData.getEByKey(this.valueAttributeName1);
            this.ValueSetMap1 = new HashMap<>();
            String[] ss = this.valueSet.split(";");
            int len = ss.length;
            for (int i = 0; i < len; i++) {
                String str = ss[i];
                String[] a_str = str.split(":");
                if (a_str != null && a_str.length >= 2) {
                    this.ValueSetMap1.put(Integer.valueOf(Integer.parseInt(a_str[0])), Integer.valueOf(Integer.parseInt(a_str[1])));
                }
            }
        }
        if (StringUtil.isNotEmpty(this.valueAttributeName2)) {
            this.ValueAttribute2 = Const.PlayerBtlData.getEByKey(this.valueAttributeName2);
            this.ValueSetMap2 = new HashMap<>();
            String[] ss = this.valueSet2.split(";");
            int len = ss.length;
            for (int i = 0; i < len; i++) {
                String str = ss[i];
                String[] a_str = str.split(":");
                if (a_str != null && a_str.length >= 2) {
                    this.ValueSetMap2.put(Integer.valueOf(Integer.parseInt(a_str[0])), Integer.valueOf(Integer.parseInt(a_str[1])));
                }
            }
        }
        if (StringUtil.isNotEmpty(this.valueAttributeName3)) {
            this.ValueAttribute3 = Const.PlayerBtlData.getEByKey(this.valueAttributeName3);
            this.ValueSetMap3 = new HashMap<>();
            String[] ss = this.valueSet3.split(";");
            int len = ss.length;
            for (int i = 0; i < len; i++) {
                String str = ss[i];
                String[] a_str = str.split(":");
                if (a_str != null && a_str.length >= 2)
                    this.ValueSetMap3.put(Integer.valueOf(Integer.parseInt(a_str[0])), Integer.valueOf(Integer.parseInt(a_str[1])));
            }
        }
    }
}


