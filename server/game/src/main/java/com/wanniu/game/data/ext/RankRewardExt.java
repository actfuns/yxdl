package com.wanniu.game.data.ext;

import com.wanniu.core.util.RandomUtil;
import com.wanniu.core.util.StringUtil;
import com.wanniu.game.common.Const;
import com.wanniu.game.data.RankRewardCO;
import com.wanniu.game.item.ItemUtil;
import com.wanniu.game.item.NormalItem;

import java.util.ArrayList;
import java.util.List;


public class RankRewardExt
        extends RankRewardCO {
    private List<GuildBossRandItem> list;
    private int totalPercent;

    public void initProperty() {
        int t1 = this.prob1 + this.prob2 + this.prob3;
        this.totalPercent = t1;

        List<GuildBossRandItem> tplist = new ArrayList<>();
        tplist.add(new GuildBossRandItem(this.prob1, this.randomReward1));
        tplist.add(new GuildBossRandItem(this.prob2, this.randomReward2));
        tplist.add(new GuildBossRandItem(this.prob3, this.randomReward3));
        tplist.add(new GuildBossRandItem(this.prob4, this.randomReward4));
        tplist.add(new GuildBossRandItem(this.prob5, this.randomReward5));
        this.list = tplist;
    }

    public List<NormalItem> getRandomReward() {
        boolean hasRate = RandomUtil.hasHitRate(10000, this.rankProb + this.dropProb);
        if (hasRate) {
            String itemStr = getRandomItem();
            return parseItems(itemStr);
        }
        return null;
    }

    private String getRandomItem() {
        if (this.totalPercent <= 0 || this.list == null) {
            return null;
        }
        int pct = RandomUtil.randomValue(this.totalPercent);
        int totalCount = 0;
        for (GuildBossRandItem bean : this.list) {
            totalCount += bean.getRandomValue();
            if (totalCount > pct) {
                return bean.getReward();
            }
        }
        return null;
    }

    public List<NormalItem> getList() {
        return parseItems(this.rankReward);
    }

    private List<NormalItem> parseItems(String itemStr) {
        if (!StringUtil.isEmpty(itemStr)) {
            List<NormalItem> tpList = new ArrayList<>();
            String[] items = itemStr.split(";");
            for (String oneItem : items) {
                String[] randomCounts = oneItem.split("[|]");
                String oneItemStr = randomCounts[0];
                String[] countStr = randomCounts[1].split("-");
                int begin = Integer.parseInt(countStr[0]);
                int end = Integer.parseInt(countStr[1]);
                int count = RandomUtil.getInt(begin, end);
                for (int i = 0; i < count; i++) {
                    String[] item = oneItemStr.split(":");
                    List<NormalItem> list = ItemUtil.createItemsByItemCode(item[0], Integer.parseInt(item[1]));
                    if (list != null && !list.isEmpty()) {
                        for (NormalItem ni : list) {
                            ni.itemDb.isBind = Const.ForceType.BIND.getValue();
                            tpList.add(ni);
                        }
                    }
                }
            }

            return tpList;
        }
        return null;
    }

    public static class GuildBossRandItem {
        public GuildBossRandItem(int randomValue, String reward) {
            this.randomValue = randomValue;
            this.reward = reward;
        }

        private int randomValue;
        private String reward;

        public int getRandomValue() {
            return this.randomValue;
        }

        public void setRandomValue(int randomValue) {
            this.randomValue = randomValue;
        }

        public String getReward() {
            return this.reward;
        }

        public void setReward(String reward) {
            this.reward = reward;
        }
    }
}


