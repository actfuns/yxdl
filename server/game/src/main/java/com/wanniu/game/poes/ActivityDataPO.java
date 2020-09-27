package com.wanniu.game.poes;

import com.wanniu.core.game.entity.GEntity;
import com.wanniu.game.DBTable;
import com.wanniu.game.activity.ActivityManager;
import com.wanniu.game.activity.po.LuckyAward;
import com.wanniu.game.bag.WNBag;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.LimitTimeGiftCO;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


@DBTable("player_activity")
public class ActivityDataPO
        extends GEntity {
    public ArrayList<LuckyAward> luckyAwardContainer = new ArrayList<>();
    public Date refreshTime = new Date(0L);
    public HashMap<Integer, ActivityManager.RewardRecord> activityRewardRecorder = new HashMap<>();
    public HashMap<Integer, ActivityManager.RewardRecord> dailyRechargeRecorder = new HashMap<>();
    public HashMap<Integer, ActivityManager.RewardRecord> superPackageRecorder = new HashMap<>();
    public HashMap<Integer, HashMap<Integer, Integer>> activityInfo = new HashMap<>();
    public HashMap<Integer, WNBag.SimpleItemInfo> drawedContainer = new HashMap<>();
    public HashMap<Integer, Integer> recovery = new HashMap<>();
    public HashMap<Integer, Integer> recoveryHistory = new HashMap<>();


    public boolean daily_recharge_have_entered = false;


    public boolean super_pakage_have_enterd = false;


    public Map<Integer, Integer> daily_draw_forgerandom_map = new HashMap<>();
    public Map<Integer, Integer> daily_draw_forgerandom_map_add = new HashMap<>();

    public List<Integer> sevendayList = new LinkedList<>();

    public ActivityDataPO() {
        for (int i = 0; i < 7; i++) {
            this.sevendayList.add(i, Integer.valueOf(0));
        }
        this.sevendayList.set(0, Integer.valueOf(1));

        this.timeLimitGiftTriggeredTimeMap = new HashMap<>();
        this.timeLimitGiftTriggeredIdMap = new HashMap<>();
        this.timeLimitGiftPushMap = new HashMap<>();
        this.timeLimitGiftBuyMap = new HashMap<>();
        for (LimitTimeGiftCO limitTimeGiftCO : GameData.LimitTimeGifts.values()) {
            this.timeLimitGiftPushMap.put(Integer.valueOf(limitTimeGiftCO.id), Integer.valueOf(0));
            if (!this.timeLimitGiftTriggeredTimeMap.containsKey(Integer.valueOf(limitTimeGiftCO.condition))) {
                this.timeLimitGiftTriggeredTimeMap.put(Integer.valueOf(limitTimeGiftCO.condition), null);
            }
            if (!this.timeLimitGiftTriggeredIdMap.containsKey(Integer.valueOf(limitTimeGiftCO.condition))) {
                this.timeLimitGiftTriggeredIdMap.put(Integer.valueOf(limitTimeGiftCO.condition), Integer.valueOf(-1));
            }
            this.timeLimitGiftBuyMap.put(Integer.valueOf(limitTimeGiftCO.id), Integer.valueOf(0));
        }
    }

    public int buffTimes;
    public int daily_draw_free_time;
    public int daily_draw_free_time_add;
    public Map<Integer, Date> timeLimitGiftTriggeredTimeMap;
    public Map<Integer, Integer> timeLimitGiftTriggeredIdMap;
    public Map<Integer, Integer> timeLimitGiftPushMap;
    public Map<Integer, Integer> timeLimitGiftBuyMap;
}


