package com.wanniu.game.data.ext;

import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.StringUtil;
import com.wanniu.game.bag.WNBag;
import com.wanniu.game.common.Const;
import com.wanniu.game.data.ActivityConfigCO;

import java.util.ArrayList;
import java.util.HashMap;


public class ActivityConfigExt
        extends ActivityConfigCO {
    public HashMap<Integer, ArrayList<WNBag.SimpleItemInfo>> costItems;
    public HashMap<Integer, ArrayList<WNBag.SimpleItemInfo>> RankReward;
    public int indexDay;
    public String condition;

    public void initProperty() {
        this.RankReward = new HashMap<>();
        this.costItems = new HashMap<>();
        if (this.mailID == 0) {
            Out.error(new Object[]{"ActivityConfig`s MailID == 0 ID:", Integer.valueOf(this.id)});
        }
        if (this.extend1 != null) {
            this.costItems.put(Integer.valueOf(0), parseString(this.extend1));
        }
        if (this.itemCode != null) {
            this.RankReward.put(Integer.valueOf(0), parseString(this.itemCode));
        } else {
            this.RankReward.put(Integer.valueOf(1), parseString(this.zSItemCode));
            this.RankReward.put(Integer.valueOf(2), parseString(this.cKItemCode));
            this.RankReward.put(Integer.valueOf(3), parseString(this.fSItemCode));
            this.RankReward.put(Integer.valueOf(4), parseString(this.lRItemCode));
            this.RankReward.put(Integer.valueOf(5), parseString(this.mSItemCode));
        }

        if (StringUtil.isEmpty(this.notes1)) {
            return;
        }
        String[] notes = this.notes1.split("_");
        if (notes.length > 2) {
            String indexDay = notes[1];
            if (indexDay.equals("OneDay")) {
                this.indexDay = 1;
                this.condition = notes[2];
            } else if (indexDay.equals("TwoDay")) {
                this.indexDay = 2;
                this.condition = notes[2];
            } else if (indexDay.equals("ThreeDay")) {
                this.indexDay = 3;
                this.condition = notes[2];
            } else if (indexDay.equals("FourDay")) {
                this.indexDay = 4;
                this.condition = notes[2];
            } else if (indexDay.equals("FiveDay")) {
                this.indexDay = 5;
                this.condition = notes[2];
            } else if (indexDay.equals("SixDay")) {
                this.indexDay = 6;
                this.condition = notes[2];
            } else if (indexDay.equals("SevenDay")) {
                this.indexDay = 7;
                this.condition = notes[2];
            }
        }
    }


    public static class ActivityConfigItem {
        public String itemCode;


        public int itemNum;


        public Const.ForceType isBind;
    }


    public ArrayList<WNBag.SimpleItemInfo> parseString(String itemCode) {
        ArrayList<WNBag.SimpleItemInfo> RankReward = new ArrayList<>();
        if (StringUtil.isEmpty(itemCode)) {
            return RankReward;
        }
        String[] rewards = itemCode.split(";");
        for (String ss : rewards) {
            String[] rw = ss.split(":");
            if (rw.length == 2) {
                WNBag.SimpleItemInfo item = new WNBag.SimpleItemInfo();
                item.itemCode = rw[0];
                item.itemNum = Integer.parseInt(rw[1]);
                item.forceType = Const.ForceType.BIND;
                RankReward.add(item);
            }
        }
        return RankReward;
    }
}


