package com.wanniu.game.poes;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public class IllusionPO {
    public int todayExp;
    public int todayClassExp;
    public int todayGold;
    public Map<Integer, Integer> boxs;
    public Map<String, Integer> items;

    public boolean hasBoxData() {
        return (this.boxs != null && !this.boxs.isEmpty());
    }

    public boolean hasItemData() {
        return (this.items != null && !this.items.isEmpty());
    }

    public void resetBoxData() {
        if (this.boxs != null) {
            this.boxs.clear();
        }
    }

    public void resetItemData() {
        if (this.items != null) {
            this.items.clear();
        }
    }

    public void putBox(int lv, int count) {
        if (this.boxs == null) {
            this.boxs = new HashMap<>();
        }
        Integer cur = this.boxs.get(Integer.valueOf(lv));
        if (cur == null) {
            this.boxs.put(Integer.valueOf(lv), Integer.valueOf(count));
        } else {
            this.boxs.put(Integer.valueOf(lv), Integer.valueOf(count + cur.intValue()));
        }
    }

    public void putItem(String code, int count) {
        if (this.items == null) {
            this.items = new HashMap<>();
        }
        Integer cur = this.items.get(code);
        if (cur == null) {
            this.items.put(code, Integer.valueOf(count));
        } else {
            this.items.put(code, Integer.valueOf(count + cur.intValue()));
        }
    }

    public int calTotalItemNum(String code) {
        if (this.items == null || this.items.isEmpty()) {
            return 0;
        }
        Integer c = this.items.get(code);
        return (c == null) ? 0 : c.intValue();
    }

    public int calTotalNum() {
        if (this.boxs == null || this.boxs.isEmpty()) {
            return 0;
        }
        int total = 0;
        Collection<Integer> cols = this.boxs.values();
        for (Integer i : cols) {
            total += i.intValue();
        }
        return total;
    }
}


