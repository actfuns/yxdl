package com.wanniu.game.data.base;

import com.wanniu.core.logfs.Out;
import com.wanniu.game.common.Const;
import com.wanniu.game.data.ext.ItemIdConfigExt;
import com.wanniu.game.data.ext.ItemTypeConfigExt;
import com.wanniu.game.item.ItemConfig;

import java.util.HashMap;
import java.util.Map;


public abstract class DItemBase
        extends DItemEquipBase {
    public String tips;
    public String ways;
    public int useCD;
    public String prop;
    public int par;
    public int min;
    public int max;
    public String smallIcon;
    public int destID;
    public int isApply;
    public int isApplyNow;
    public String applyTips;
    public String waysID;
    public int itemOrder;
    public String orderRule;
    public int orderID;
    public int minAffixCount;
    public int maxAffixCount;
    public Map<Integer, String> chestTC;
    public int redPoint;

    public void initProperty() {
        ItemIdConfigExt itemIdConfigProp = ItemConfig.getInstance().getIdConfig(this.type);
        if (itemIdConfigProp != null) {
            this.itemTypeId = itemIdConfigProp.typeID;
            this.itemOrder = itemIdConfigProp.order;
            this.orderRule = itemIdConfigProp.orderRule;
        } else {
            Out.error(new Object[]{getClass().getName(), " item no prop in itemIdConfig :", this.type, ", name:", this.name});
        }

        ItemTypeConfigExt itemTypeConfigProp = ItemConfig.getInstance().getTypeConfig(this.type);
        if (itemTypeConfigProp != null) {
            int itemType = Const.ItemType.getV(itemTypeConfigProp.parentCode);
            if (itemType == 0) {
                Out.error(new Object[]{getClass().getName(), " item no element in itemType:", itemTypeConfigProp.parentCode, ", name:", this.name});
            }

            this.itemType = itemType;
            this.orderID = itemTypeConfigProp.order;
        } else {
            Out.error(new Object[]{getClass().getName(), " item no prop in itemTypeConfig :", this.type, ", name:", this.name});
        }


        int itemSecondType = Const.ItemSecondType.getV(this.type);
        if (itemSecondType == 0) {
            Out.error(new Object[]{getClass().getName(), " item no itemSecondType : ", this.type, ", name:", this.name});
        }
        this.itemSecondType = itemSecondType;

        if (this.itemType == Const.ItemType.Chest.getValue()) {
            this.chestTC = new HashMap<>();
            if (this.prop.indexOf(":") != -1) {
                String[] tcs = this.prop.split(";");
                for (String str : tcs) {
                    String[] proTC = str.split(":");
                    if (proTC.length != 0) {


                        int pro = Integer.parseInt(proTC[0]);
                        String tc = proTC[1];
                        if (pro == 0) {
                            this.chestTC.put(Integer.valueOf(1), tc);
                            this.chestTC.put(Integer.valueOf(2), tc);
                            this.chestTC.put(Integer.valueOf(3), tc);
                            this.chestTC.put(Integer.valueOf(4), tc);
                            this.chestTC.put(Integer.valueOf(5), tc);
                        } else {
                            this.chestTC.put(Integer.valueOf(pro), tc);
                        }
                    }
                }
            } else {
                this.chestTC.put(Integer.valueOf(1), this.prop);
                this.chestTC.put(Integer.valueOf(2), this.prop);
                this.chestTC.put(Integer.valueOf(3), this.prop);
                this.chestTC.put(Integer.valueOf(4), this.prop);
                this.chestTC.put(Integer.valueOf(5), this.prop);
            }

        }
    }


    public String getKey() {
        return this.code;
    }
}


