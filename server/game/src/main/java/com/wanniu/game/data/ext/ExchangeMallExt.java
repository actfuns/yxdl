package com.wanniu.game.data.ext;

import com.wanniu.core.util.DateUtil;
import com.wanniu.core.util.StringUtil;
import com.wanniu.game.data.ExchangeMallCO;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class ExchangeMallExt
        extends ExchangeMallCO {
    public Map<String, Integer> exchangeNeedMap;
    public Date startTime;
    public Date endTime;

    public void initProperty() {
        this.exchangeNeedMap = new HashMap<>();

        String[] strs1 = this.exchangeNeed.split(";");
        for (String strItem : strs1) {

            String[] strs2 = strItem.split(":");
            this.exchangeNeedMap.put(strs2[0], Integer.valueOf(Integer.parseInt(strs2[1])));
        }


        String periodStart = this.periodStart;
        if (StringUtil.isNotEmpty(periodStart)) {
            this.startTime = DateUtil.format(periodStart);
        }

        String periodEnd = this.periodStart;
        if (StringUtil.isNotEmpty(periodEnd))
            this.endTime = DateUtil.format(periodEnd);
    }
}


