package com.wanniu.game.data.base;

import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.ClassUtil;
import com.wanniu.core.util.StringUtil;
import com.wanniu.game.common.Const;
import com.wanniu.game.data.ItemIdConfigCO;
import com.wanniu.game.data.ItemTypeConfigCO;
import com.wanniu.game.data.ext.ItemIdConfigExt;
import com.wanniu.game.data.ext.ItemTypeConfigExt;
import com.wanniu.game.item.ItemConfig;
import com.wanniu.game.player.AttributeUtil;

import java.util.HashMap;
import java.util.Map;


public abstract class DEquipBase
        extends DItemEquipBase {
    public int isBothHand;
    public int space;
    public int isValid;
    public int isIdentfied;
    public int rare;
    public int tcLevel;
    public int qLevel;
    public int upReq;
    public int meltLevel;
    public int socksNum;
    public int canLvUp;
    public int canUpgrade;
    public String affixSheet;
    public String affixCount;
    public String prop1;
    public int par1;
    public int min1;
    public int max1;
    public String prop2;
    public int par2;
    public int min2;
    public int max2;
    public String prop3;
    public int par3;
    public int min3;
    public int max3;
    public int noMelt;
    public int wareHouseValue;
    public int wareHouseCost;
    public String baseCode;
    public int rPropCount;
    public Map<String, Integer> fixedAtts;
    public String rProp1;
    public int rPar1;
    public int rMin1;
    public int rMax1;
    public String rProp2;
    public int rPar2;
    public int rMin2;
    public int rMax2;
    public String rProp3;
    public int rPar3;
    public int rMin3;
    public int rMax3;
    public String rProp4;
    public int rPar4;
    public int rMin4;
    public int rMax4;
    public String rProp5;
    public int rPar5;
    public int rMin5;
    public int rMax5;
    public String rProp6;
    public int rPar6;
    public int rMin6;
    public int rMax6;
    public int uPar1;
    public String uProp1;
    public int uMin1;
    public int uMax1;
    public String uProp2;
    public int uPar2;
    public int uMin2;
    public int uMax2;
    public int suitID;
    public int starLevel;
    public int SocksNum;
    public int itemOrder;
    public String orderRule;
    public int orderID;
    public Map<String, FourProp> baseAtts;
    public int minAffixCount;
    public int maxAffixCount;
    public String waysID;
    public Map<String, FourProp> uniqueAtts;

    public void initProperty() {
        initProp();
    }

    public void initProp() {
        if (StringUtil.isEmpty(this.type)) {
            Out.error(new Object[]{this.code, " type is nil"});
            return;
        }
        ItemIdConfigExt itemIdConfigExt = ItemConfig.getInstance().getIdConfig(this.type);
        if (itemIdConfigExt != null) {
            this.itemTypeId = ((ItemIdConfigCO) itemIdConfigExt).typeID;
            this.itemOrder = ((ItemIdConfigCO) itemIdConfigExt).order;
            this.orderRule = ((ItemIdConfigCO) itemIdConfigExt).orderRule;
        } else {
            Out.error(new Object[]{getClass().getName(), " equip no prop in itemIdConfig :", this.type, ", name:", this.name});
        }


        ItemTypeConfigExt itemTypeConfigExt = ItemConfig.getInstance().getTypeConfig(this.type);
        if (itemTypeConfigExt != null) {
            int itemType = Const.ItemType.getV(((ItemTypeConfigCO) itemTypeConfigExt).parentCode);
            if (itemType == 0) {
                Out.error(new Object[]{getClass().getName(), " equip no element in itemType:", ((ItemTypeConfigCO) itemTypeConfigExt).parentCode, ", name:", this.name});
            }

            this.itemType = itemType;
            this.orderID = ((ItemTypeConfigCO) itemTypeConfigExt).order;
        } else {
            Out.error(new Object[]{getClass().getName(), " equip no prop in itemTypeConfig :", this.type, ", name:", this.name});
        }

        int itemSecondType = Const.ItemSecondType.getV(this.type);
        if (itemSecondType == 0) {
            Out.error(new Object[]{getClass().getName(), " equip no itemSecondType : ", this.type, ", name:", this.name});
        }
        this.itemSecondType = itemSecondType;

        this.groupCount = 1;

        this.Pro = Const.PlayerPro.Value(this.pro);


        this.baseAtts = new HashMap<>();
        int i;
        for (i = 1; i <= 3; i++) {
            String attrName = "prop" + i;
            String attrPar = "par" + i;
            String attrMin = "min" + i;
            String attrMax = "max" + i;
            String key = null;

            try {
                if (ClassUtil.getProperty(this, attrName) == null || StringUtil.isEmpty((String) ClassUtil.getProperty(this, attrName))) {
                    Out.debug(new Object[]{getClass().getName(), " EquipProp attName is space"});
                } else {

                    key = AttributeUtil.getKeyByName((String) ClassUtil.getProperty(this, attrName));
                    if (StringUtil.isNotEmpty(key)) {

                        FourProp minMax = new FourProp(key, ((Integer) ClassUtil.getProperty(this, attrPar)).intValue(), ((Integer) ClassUtil.getProperty(this, attrMin)).intValue(), ((Integer) ClassUtil.getProperty(this, attrMax)).intValue());
                        this.baseAtts.put(key, minMax);
                    } else {
                        Out.error(new Object[]{getClass().getName(), " EquipProp attrName not exist ", attrName});
                    }
                }
            } catch (Exception e) {
                Out.error(new Object[]{e});
            }
        }


        this.uniqueAtts = new HashMap<>();
        for (i = 1; i <= 2; i++) {
            String attrName = "uProp" + i;
            String par = "uPar" + i;
            String minValue = "uMin" + i;
            String maxValue = "uMax" + i;

            try {
                Object attrNameObj = ClassUtil.getProperty(this, attrName);
                if (attrNameObj != null && !StringUtil.isEmpty((String) attrNameObj)) {

                    this.uniqueAtts.put(AttributeUtil.getKeyByName((String) attrNameObj), new FourProp(
                            AttributeUtil.getKeyByName((String) attrNameObj), (
                            (Integer) ClassUtil.getProperty(this, par)).intValue(), (
                            (Integer) ClassUtil.getProperty(this, minValue)).intValue(), (
                            (Integer) ClassUtil.getProperty(this, maxValue)).intValue()));
                }
            } catch (Exception e) {
                Out.error(new Object[]{e});
            }
        }

        if (StringUtil.isNotEmpty(this.affixCount)) {
            String[] countData = this.affixCount.substring(1, this.affixCount.length() - 1).split(",");
            this.minAffixCount = Integer.parseInt(countData[0]);
            this.maxAffixCount = Integer.parseInt(countData[1]);
        }
    }
}


