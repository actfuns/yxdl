package com.wanniu.game.item.data.tc;

import java.util.List;


public class TCItemData {
    public static final int TC_EQUIP_TYPE = 1;
    public static final int TC_ITEMCODE = 2;
    public static final int TC_INNER_TC = 3;
    public int tcType;
    public String code;
    public int num;
    public int minNum;
    public int maxNum;
    public int rare;
    public List<Integer> expandParas;

    public TCItemData() {
    }

    public TCItemData(String code, int num, int rare, List<Integer> expandParas, int minNum, int maxNum) {
        this.code = code;
        this.num = num;
        this.rare = rare;
        this.expandParas = expandParas;

        this.minNum = minNum;
        this.maxNum = maxNum;
    }
}


