package com.wanniu.game.data.ext;

import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.ClassUtil;
import com.wanniu.core.util.StringUtil;
import com.wanniu.game.bag.WNBag;
import com.wanniu.game.data.EquipMakeCO;

import java.util.ArrayList;
import java.util.List;


public class EquipMakeExt
        extends EquipMakeCO {
    public List<WNBag.SimpleItemInfo> reqMate;

    public void initProperty() {
        this.reqMate = new ArrayList<>();

        for (int i = 1; i <= 3; i++) {
            String codeKey = "reqMateCode" + i;
            String countKey = "reqMateCount" + i;
            try {
                if (StringUtil.isNotEmpty((String) ClassUtil.getProperty(this, codeKey))) {
                    WNBag.SimpleItemInfo mateItem = new WNBag.SimpleItemInfo();
                    mateItem.itemCode = (String) ClassUtil.getProperty(this, codeKey);
                    mateItem.itemNum = ((Integer) ClassUtil.getProperty(this, countKey)).intValue();
                    this.reqMate.add(mateItem);
                }
            } catch (Exception e) {
                Out.error(new Object[]{e});
            }
        }
    }
}


