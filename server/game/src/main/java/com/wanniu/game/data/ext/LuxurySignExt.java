package com.wanniu.game.data.ext;

import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.ClassUtil;
import com.wanniu.game.bag.WNBag;
import com.wanniu.game.data.LuxurySignCO;

import java.util.ArrayList;
import java.util.List;

import pomelo.item.ItemOuterClass;


public class LuxurySignExt
        extends LuxurySignCO {
    public List<WNBag.SimpleItemInfo> items = null;


    public void initProperty() {
        this.items = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            String codeKey = "item" + i + "code";
            String countKey = "item" + i + "count";
            try {
                if (ClassUtil.getProperty(this, codeKey) != null && ClassUtil.getProperty(this, countKey) != null) {
                    WNBag.SimpleItemInfo item = new WNBag.SimpleItemInfo();
                    item.itemCode = ClassUtil.getProperty(this, codeKey).toString();
                    item.itemNum = ((Integer) ClassUtil.getProperty(this, countKey)).intValue();
                    this.items.add(item);
                }
            } catch (Exception e) {
                Out.error(new Object[]{e});
            }
        }
    }

    public final ItemOuterClass.MiniItem.Builder[] getMiniItems() {
        if (this.items != null && this.items.size() > 0) {
            ItemOuterClass.MiniItem.Builder[] miniItems = new ItemOuterClass.MiniItem.Builder[this.items.size()];
            for (int i = 0; i < this.items.size(); i++) {
                miniItems[i] = ItemOuterClass.MiniItem.newBuilder();
                miniItems[i].setCode(((WNBag.SimpleItemInfo) this.items.get(i)).itemCode);
                miniItems[i].setGroupCount(((WNBag.SimpleItemInfo) this.items.get(i)).itemNum);
            }
            return miniItems;
        }
        return null;
    }
}


