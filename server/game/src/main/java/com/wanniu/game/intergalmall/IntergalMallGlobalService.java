package com.wanniu.game.intergalmall;

import com.wanniu.core.db.GCache;
import com.wanniu.core.util.StringUtil;
import com.wanniu.game.common.ConstsTR;

import java.util.Map;


public class IntergalMallGlobalService {
    private IntergalMallGlobalService() {
    }

    public static class Holder {
        public static final IntergalMallGlobalService instance = new IntergalMallGlobalService();
    }

    public static IntergalMallGlobalService getInstance() {
        return Holder.instance;
    }


    public void refreshNewDay() {
        Map<String, String> nums = GCache.hgetAll(ConstsTR.intergalMallGlobalTR.value);
        if (nums == null) {
            return;
        }
        for (String key : nums.keySet()) {
            GCache.hset(ConstsTR.intergalMallGlobalTR.value, key, String.valueOf(0));
        }
    }

    public int getGlobalNum(int shopType, int itemId) {
        int result = 0;
        String str = GCache.hget(ConstsTR.intergalMallGlobalTR.value, shopType + "/" + itemId);
        if (StringUtil.isNotEmpty(str)) {
            result = Integer.parseInt(str);
        }
        return result;
    }
}


