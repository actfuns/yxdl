package com.wanniu.game.data.ext;

import com.wanniu.core.util.DateUtil;
import com.wanniu.core.util.StringUtil;
import com.wanniu.game.data.ShopMallItemsCO;

import java.util.Date;


public class ShopMallItemsExt
        extends ShopMallItemsCO {
    public Date startTime;
    public Date endTime;

    public void initProperty() {
        String periodStart = this.periodStart;
        if (StringUtil.isNotEmpty(periodStart)) {
            this.startTime = DateUtil.format(periodStart);
        }

        String periodEnd = this.periodStart;
        if (StringUtil.isNotEmpty(periodEnd))
            this.endTime = DateUtil.format(periodEnd);
    }
}


