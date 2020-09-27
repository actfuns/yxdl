package com.wanniu.game.data.ext;

import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.ClassUtil;
import com.wanniu.game.data.GShopCO;

import java.util.ArrayList;
import java.util.List;

import pomelo.area.GuildShopHandler;

public class GShopExt
        extends GShopCO {
    public List<GuildShopHandler.ShopMoneyInfo> moneyReqList;

    public void initProperty() {
        List<GuildShopHandler.ShopMoneyInfo> _moneyReqList = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            String typeKey = "type" + i;
            String valueKey = "value" + i;

            try {
                if (null != ClassUtil.getProperty(this, typeKey) && null != ClassUtil.getProperty(this, valueKey)) {
                    GuildShopHandler.ShopMoneyInfo.Builder moneyInfo = GuildShopHandler.ShopMoneyInfo.newBuilder();
                    moneyInfo.setType(((Integer) ClassUtil.getProperty(this, typeKey)).intValue());
                    moneyInfo.setValue(((Integer) ClassUtil.getProperty(this, valueKey)).intValue());
                    _moneyReqList.add(moneyInfo.build());
                }
            } catch (Exception e) {
                Out.error(new Object[]{e});
            }
        }
        this.moneyReqList = _moneyReqList;
    }
}


