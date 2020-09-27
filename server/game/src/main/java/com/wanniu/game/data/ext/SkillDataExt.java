package com.wanniu.game.data.ext;

import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.StringUtil;
import com.wanniu.game.common.Const;
import com.wanniu.game.data.SkillDataCO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SkillDataExt
        extends SkillDataCO {
    public int pro_;
    public List<Integer> lvReqData;
    public Map<Integer, Integer> costReqData;
    public List<CostItemReqData> costItemReqData;
    public int[] power_arr;

    public void initProperty() {
        this.pro_ = Const.PlayerPro.Value(this.pro);

        String lvReqStr = this.upReqLevel;
        this.lvReqData = new ArrayList<>();
        if (StringUtil.isNotEmpty(lvReqStr)) {
            String[] a_lvReqStr = lvReqStr.split(";");
            int len = a_lvReqStr.length;
            for (int i = 0; i < len; i++) {
                this.lvReqData.add(Integer.valueOf(Integer.parseInt(a_lvReqStr[i])));
            }
        }
        this.lvReqData.add(Integer.valueOf(-1));

        String costReqStr = this.upCostGold;
        this.costReqData = new HashMap<>();
        if (StringUtil.isNotEmpty(costReqStr)) {
            String[] a_costReqStr = costReqStr.split(";");
            int len = a_costReqStr.length;
            for (int i = 0; i < len; i++) {
                String str = a_costReqStr[i];
                String[] a_str = str.split(":");
                if (a_str != null && a_str.length >= 2) {
                    this.costReqData.put(Integer.valueOf(Integer.parseInt(a_str[0])), Integer.valueOf(Integer.parseInt(a_str[1])));
                }
            }
        }


        String costItemReqStr = this.upCostItem;
        this.costItemReqData = new ArrayList<>();
        if (StringUtil.isNotEmpty(costItemReqStr)) {
            String[] a_costItemReqStr = costItemReqStr.split(";");
            int len = a_costItemReqStr.length;
            for (int i = 0; i < len; i++) {
                String str = a_costItemReqStr[i];
                String[] a_str = str.split(":");
                if (a_str != null && a_str.length >= 2) {
                    this.costItemReqData.add(new CostItemReqData(i, a_str[0], Integer.parseInt(a_str[1])));
                    if (i == len - 1) {
                        this.costItemReqData.add(new CostItemReqData(i, a_str[0], -1));
                    }
                }
            }
        }


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
                    Out.error(new Object[]{"技能脚本的战力有问题,skillid=", Integer.valueOf(this.skillID)});
                }
                this.power_arr[Integer.parseInt(a_str[0])] = Integer.parseInt(a_str[1]);
            }
        }
    }

    public class CostItemReqData {
        public int lv;
        public String itemCode;
        public int num;

        public CostItemReqData(int lv, String itemCode, int num) {
            this.lv = lv;
            this.itemCode = itemCode;
            this.num = num;
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


