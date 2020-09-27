package com.wanniu.game.data.base;

import com.wanniu.core.util.DateUtil;
import com.wanniu.core.util.StringUtil;

import java.util.Date;


public class IntergalShopBase {
    public int iD;
    public String itemCode;
    public String name;
    public int isShow;
    public int isBind;
    public int num;
    public int price;
    public String periodStart;
    public String periodEnd;
    public int price2;
    public int buyTimes;
    public int reqLvl;
    public int series;
    public int countDown;
    public int serveLimit;
    public int serveBuyTimes;
    public Date periodStartDate;
    public Date periodEndDate;

    public int getKey() {
        return this.iD;
    }


    public void initProperty() {
        if (StringUtil.isNotEmpty(this.periodStart)) {
            this.periodStartDate = DateUtil.format(this.periodStart);
        }
        if (StringUtil.isNotEmpty(this.periodEnd))
            this.periodEndDate = DateUtil.format(this.periodEnd);
    }

    public void beforeProperty() {
    }
}


