package com.wanniu.game.rank;

import com.wanniu.core.logfs.Out;
import com.wanniu.game.common.msg.WNNotifyManager;
import com.wanniu.game.data.ext.RankListExt;
import com.wanniu.game.player.AttributeUtil;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.TitlePO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import pomelo.area.RankHandler;

public class TitleManager {
    public WNPlayer player;
    public TitlePO titlePO;

    public static class AwardRankData {
        public int id;
        public long gotTime;

        public AwardRankData() {
        }

        public AwardRankData(int id, long gotTime) {
            this.id = id;
            this.gotTime = gotTime;
        }
    }


    public static class RankBiData {
        public TreeMap<String, Integer> all;

        public TreeMap<String, Integer> single;
    }

    public TitleManager(WNPlayer player, TitlePO titlePO) {
        this.player = player;
        this.titlePO = titlePO;
    }

    public int getSelectedRankId() {
        return this.titlePO.selectedRankId;
    }

    public final int getTitleId() {
        return this.titlePO.selectedRankId;
    }


    public final void showRank() {
        this.player.refreshBattlerServerBasic();
    }

    public final ArrayList<RankHandler.AwardRank.Builder> getRankInfo() {
        checkInvalidRanks(true);
        ArrayList<RankHandler.AwardRank.Builder> list = new ArrayList<>();
        for (Map.Entry<Integer, AwardRankData> node : (Iterable<Map.Entry<Integer, AwardRankData>>) this.titlePO.awardRanks.entrySet()) {
            AwardRankData each = node.getValue();
            RankListExt prop = RankConfig.getInstance().findListRankPropByRankID(each.id);
            long validTime = (prop != null) ? (1L * prop.validTime * 60L * 60L * 1000L) : 0L;

            int invalidTime = 0;
            if (validTime > 0L) {
                invalidTime = (int) Math.floor(((each.gotTime + validTime) / 1000L));
            }
            RankHandler.AwardRank.Builder rank = RankHandler.AwardRank.newBuilder();
            rank.setId(each.id);
            rank.setInvalidTime(invalidTime);
            list.add(rank);
        }
        return list;
    }

    public final void saveRank(int selectedRankId) {
        if (this.titlePO.awardRanks.containsKey(Integer.valueOf(selectedRankId))) {
            this.titlePO.selectedRankId = selectedRankId;
            showRank();
        }
    }


    public final void onAwardRank(int rankId) {
        RankListExt prop = RankConfig.getInstance().findListRankPropByRankID(rankId);
        if (prop == null) {
            Out.error(new Object[]{"there is no data of RankID: ", Integer.valueOf(rankId), " in rankListProps "});
            return;
        }
        long gotTime = System.currentTimeMillis();
        this.titlePO.awardRanks.put(Integer.valueOf(rankId), new AwardRankData(rankId, gotTime));
        if (this.titlePO.selectedRankId == 0) {
            this.titlePO.selectedRankId = rankId;

            this.player.refreshBattlerServerBasic();
        }

        RankBiData biData = biGetInfluence(rankId);


        pushAndRefreshRankInflu(true);
        WNNotifyManager.getInstance().pushAwardRank(this.player, rankId);
    }


    private final void pushAndRefreshRankInflu(boolean refresh) {
        this.player.updateTitleAttrs();
        this.player.initAndCalAllInflu(null);
        if (refresh) {
            this.player.refreshBattlerServerEffect(false);
        }
        this.player.pushEffectData();
    }

    public final void refreshNewDay() {
        checkInvalidRanks(true);
    }

    public final void checkInvalidRanks(boolean refresh) {
        boolean needUpdate = false;
        if (null != this.titlePO.awardRanks) {
            Iterator<Map.Entry<Integer, AwardRankData>> iter = this.titlePO.awardRanks.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry<Integer, AwardRankData> entry = iter.next();
                AwardRankData each = entry.getValue();
                if (null == each) {
                    continue;
                }
                RankListExt prop = RankConfig.getInstance().findListRankPropByRankID(each.id);
                if (prop != null && prop.validTime > 0) {
                    long validTime = 1L * prop.validTime * 60L * 60L * 1000L;
                    long invalidTime = each.gotTime + validTime;
                    long currTime = System.currentTimeMillis();
                    if (currTime >= invalidTime) {
                        iter.remove();
                        needUpdate = true;
                    }
                }
            }
        }

        if (this.titlePO.selectedRankId != 0 && !this.titlePO.awardRanks.containsKey(Integer.valueOf(this.titlePO.selectedRankId))) {
            this.titlePO.selectedRankId = 0;
            if (refresh) {
                this.player.refreshBattlerServerBasic();
            }
        }
        if (needUpdate) {
            pushAndRefreshRankInflu(refresh);
        }
    }


    public final TreeMap<String, Integer> calAllInfluence() {
        TreeMap<String, Integer> data = new TreeMap<>();
        for (Map.Entry<Integer, AwardRankData> node : (Iterable<Map.Entry<Integer, AwardRankData>>) this.titlePO.awardRanks.entrySet()) {
            AwardRankData each = node.getValue();
            RankListExt prop = RankConfig.getInstance().findListRankPropByRankID(each.id);
            if (prop != null) {
                Map<String, Integer> rankAttrs = prop.rankAttrs;
                for (Map.Entry<String, Integer> atts : rankAttrs.entrySet()) {
                    if (data.containsKey(atts.getKey())) {
                        int value = ((Integer) atts.getValue()).intValue() + ((Integer) data.get(atts.getKey())).intValue();
                        data.put(atts.getKey(), Integer.valueOf(value));
                        continue;
                    }
                    data.put(atts.getKey(), atts.getValue());
                }
            }
        }

        return data;
    }

    private final RankBiData biGetInfluence(int rankId) {
        RankBiData data = new RankBiData();
        data.all = new TreeMap<>();
        data.single = new TreeMap<>();
        for (Map.Entry<Integer, AwardRankData> node : (Iterable<Map.Entry<Integer, AwardRankData>>) this.titlePO.awardRanks.entrySet()) {
            AwardRankData each = node.getValue();
            RankListExt prop = RankConfig.getInstance().findListRankPropByRankID(each.id);
            if (prop != null) {
                Map<String, Integer> rankAttrs = prop.rankAttrs;
                for (Map.Entry<String, Integer> atts : rankAttrs.entrySet()) {
                    String name = AttributeUtil.getNameByKey(atts.getKey());
                    if (data.all.containsKey(name)) {
                        int value = ((Integer) data.all.get(name)).intValue();
                        value += ((Integer) atts.getValue()).intValue();
                        data.all.put(name, Integer.valueOf(value));
                    } else {
                        data.all.put(name, atts.getValue());
                    }
                    if (rankId == each.id) {
                        if (data.single.containsKey(name)) {
                            int value = ((Integer) data.single.get(name)).intValue();
                            value += ((Integer) atts.getValue()).intValue();
                            data.single.put(name, Integer.valueOf(value));
                            continue;
                        }
                        data.single.put(name, atts.getValue());
                    }
                }
            }
        }

        return data;
    }


    public final int calFightPower() {
        TreeMap<String, Integer> allInflus = calAllInfluence();


        int fightPower = 0;
        return fightPower;
    }
}


