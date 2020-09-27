package com.wanniu.game.data.ext;

import com.wanniu.core.logfs.Out;
import com.wanniu.game.bag.WNBag;
import com.wanniu.game.common.CommonUtil;
import com.wanniu.game.data.OlGiftCO;
import com.wanniu.game.item.ItemUtil;

import java.util.ArrayList;
import java.util.List;

import pomelo.item.ItemOuterClass;


public class OlGiftExt
        extends OlGiftCO {
    public List<WNBag.SimpleItemInfo> items;

    public void initProperty() {
        this.items = new ArrayList<>();
        this.items = CommonUtil.parseItems(this.reward);
    }


    public final List<ItemOuterClass.MiniItem> getMiniItems() {
        List<ItemOuterClass.MiniItem> itemList = new ArrayList<>();
        if (this.items != null)
            for (int i = 0; i < this.items.size(); i++) {
                WNBag.SimpleItemInfo item = this.items.get(i);
                if (null != item) {


                    ItemOuterClass.MiniItem.Builder miniItem = ItemUtil.getMiniItemData(item.itemCode, item.itemNum);
                    if (null == miniItem) {
                        Out.error(new Object[]{getClass(), "->[", item.itemCode, "] is not found"});
                    } else {

                        itemList.add(miniItem.build());
                    }
                }
            }
        return itemList;
    }
}


