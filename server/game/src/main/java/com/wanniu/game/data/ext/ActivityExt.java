package com.wanniu.game.data.ext;

import com.wanniu.core.util.DateUtil;
import com.wanniu.game.data.ActivityCO;

import java.util.Date;

public class ActivityExt
        extends ActivityCO {
    public long beginTime;
    public long endTime;

    public void initProperty() {
        Date dateBegin = DateUtil.format(this.openTime);
        this.beginTime = dateBegin.getTime();
        Date dateEnd = DateUtil.format(this.closeTime);
        this.endTime = dateEnd.getTime();
    }
}


