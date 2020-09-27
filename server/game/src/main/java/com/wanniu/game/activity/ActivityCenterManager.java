package com.wanniu.game.activity;

import com.wanniu.core.db.GCache;
import com.wanniu.core.util.StringUtil;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.ConstsTR;
import com.wanniu.game.data.ActivityCO;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.ext.ActivityExt;

import java.util.Iterator;
import java.util.List;

public class ActivityCenterManager {
    private static ActivityCenterManager instance;

    public static synchronized ActivityCenterManager getIntance() {
        if (instance == null)
            instance = new ActivityCenterManager();
        return instance;
    }


    public int getFundsNum(int serverId) {
        String data = GCache.hget(Integer.toString(serverId), ConstsTR.fundsTR.value);
        int num = 0;
        if (StringUtil.isEmpty(data)) {
            num = getJoinNum(serverId);
            GCache.hset(Integer.toString(serverId), ConstsTR.fundsTR.value, String.valueOf(num));
        } else {
            num = Integer.parseInt(data);
        }
        return num;
    }


    public void addFundRecord(int serverId) {
        GCache.hincr(Integer.toString(serverId), ConstsTR.fundsTR.value, 1L);
    }


    public int getJoinNum(int serverId) {
        int num = 0;
        List<ActivityExt> props = GameData.findActivitys(t -> (t.activityTab == Const.ActivityRewardType.FOUNDATION.getValue()));
        ActivityExt prop = null;
        Iterator<ActivityExt> iterator = props.iterator();
        if (iterator.hasNext()) {
            ActivityCO p = (ActivityCO) iterator.next();
            prop = (ActivityExt) p;
        }


        if (prop != null) {
            num = prop.joinNum;
        }
        return num;
    }
}


