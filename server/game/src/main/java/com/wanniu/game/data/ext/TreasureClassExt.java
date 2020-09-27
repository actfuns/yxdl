package com.wanniu.game.data.ext;

import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.ClassUtil;
import com.wanniu.core.util.StringUtil;
import com.wanniu.game.data.TreasureClassCO;
import com.wanniu.game.item.data.tc.TCItemData;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TreasureClassExt
        extends TreasureClassCO {
    public List<TCItemData> items;

    public void initProperty() {
        this.items = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            Object _item = null;
            Object _rare = null;
            try {
                _item = ClassUtil.getProperty(this, "item" + i);
                _rare = ClassUtil.getProperty(this, "prob" + i);
            } catch (Exception e) {
                Out.error(new Object[]{e});
            }
            String item = null;
            int rare = 0;
            if (_item != null) {
                item = _item.toString();
                if (item.trim().length() != 0) {

                    rare = ((Integer) _rare).intValue();

                    String[] itemData = item.split("#");
                    String itemCode = itemData[0];
                    int num = 1;
                    List<Integer> expandParas = new ArrayList<>();
                    if (itemData.length > 1) {

                        if (StringUtil.isNotEmpty(itemData[1])) {
                            String[] expandParaStrs = itemData[1].split(",");
                            for (String expandParaStr : expandParaStrs) {
                                expandParas.add(Integer.valueOf(Integer.parseInt(expandParaStr.replace("{", "").replace("}", ""))));
                            }
                        }
                        if (itemData[1].substring(0, 1).equals("{")) {
                            String[] numData = itemData[1].substring(1, itemData[1].length() - 1).split(",");
                            int minNum = Integer.parseInt(numData[0]);
                            int maxNum = Integer.parseInt(numData[1]);

                            TCItemData tc = new TCItemData();
                            tc.tcType = 2;
                            tc.code = itemCode;
                            tc.minNum = minNum;
                            tc.maxNum = maxNum;
                            tc.rare = rare;
                            tc.expandParas = expandParas;
                            this.items.add(tc);
                        } else {
                            num = Integer.parseInt(itemData[1]);
                            TCItemData tc = new TCItemData();
                            tc.tcType = 2;
                            tc.code = itemCode;
                            tc.num = num;
                            tc.rare = rare;
                            tc.expandParas = expandParas;
                            this.items.add(tc);
                        }
                    } else {

                        TCItemData tc = new TCItemData();
                        Matcher matcher_tc = Pattern.compile("^[0-9A-Z]").matcher(itemCode);
                        Matcher matcher_item = Pattern.compile("^[a-z]").matcher(itemCode);
                        if (matcher_tc.find()) {
                            tc.tcType = 3;
                        } else if (matcher_item.find()) {
                            tc.tcType = 2;
                        } else {
                            tc.tcType = 1;
                        }

                        tc.code = itemCode;
                        tc.num = num;
                        tc.rare = rare;
                        tc.expandParas = expandParas;
                        this.items.add(tc);
                    }
                }
            }
        }
    }

    public String getKey() {
        return this.tcCode;
    }
}


