package com.wanniu.game.sale;

import com.wanniu.core.logfs.Out;
import com.wanniu.game.bag.BagUtil;
import com.wanniu.game.common.Const;
import com.wanniu.game.data.base.DItemEquipBase;
import com.wanniu.game.data.base.SaleBase;
import com.wanniu.game.equip.NormalEquip;
import com.wanniu.game.item.ItemUtil;
import com.wanniu.game.item.NormalItem;
import com.wanniu.game.item.po.ItemSpeData;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import pomelo.area.FunctionHandler;
import pomelo.area.SaleHandler;


public class SaleManager {
    private WNPlayer player;

    public enum ERR_CODE {
        ERR_CODE_OK(0), ERR_CODE_ITEM_NOT_EXIST(1), ERR_CODE_GOLD_NOT_ENOUGH(2), ERR_CODE_TICKET_NOT_ENOUGH(3), ERR_CODE_DIAMAND_NOT_ENOUGH(4), ERR_CODE_BAG_NOT_ENOUGH_POS(5), ERR_CODE_ITEM_NOSELL(6), ERR_CODE_SELL_ITEMS_EMPTY(7), ERR_CODE_PARAM_ERROR(8),
        ERR_CODE_MONEY_TYPE_ERROR(9), ERR_CODE_SOMETHING_ERR(99);
        private int value;

        ERR_CODE(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }


    public SaleManager(WNPlayer player) {
        this.player = player;
    }


    public final SaleHandler.BuyPageResponse.Builder handleBuyPage(List<Integer> typeIds) {
        SaleHandler.BuyPageResponse.Builder result = SaleHandler.BuyPageResponse.newBuilder();
        result.setS2CCode(ERR_CODE.ERR_CODE_OK.getValue());
        ArrayList<SaleBase> props = SaleConfig.getInstance().findPropByTypeId(typeIds);
        ArrayList<SaleHandler.BuyItem> list = new ArrayList<>();
        for (int i = 0; i < props.size(); i++) {
            SaleBase prop = props.get(i);
            DItemEquipBase itemProp = ItemUtil.getPropByCode(prop.itemCode);
            if (itemProp == null) {
                Out.debug(new Object[]{"handleBuyPage prop:", prop});
                Out.error(new Object[]{"itemUtil.getPropByCode return null: code = ", prop.itemCode});
            } else {

                SaleHandler.BuyItem.Builder buyItem = SaleHandler.BuyItem.newBuilder();
                buyItem.setTypeId(prop.typeID);
                buyItem.setItemId(prop.itemID);
                buyItem.setItemShowName(prop.itemShowName);
                buyItem.setItem(ItemUtil.getMiniItemData(prop.itemCode, prop.itemCount));
                buyItem.setMoneyType(prop.moneyType);
                buyItem.setNeedMoney(prop.needMoney);
                buyItem.setMaxGroupCount((prop.itemCount > 1) ? 1 : itemProp.groupCount);
                list.add(buyItem.build());
            }
        }
        result.addAllS2CBuyItems(list);
        return result;
    }

    public final SaleHandler.AutoBuyItemByCodeResponse.Builder handleAutoBuyItemByTypeCode(List<Integer> typeIds, String itemCode, int num) {
        SaleHandler.AutoBuyItemByCodeResponse.Builder result = SaleHandler.AutoBuyItemByCodeResponse.newBuilder();
        result.setS2CCode(ERR_CODE.ERR_CODE_OK.getValue());
        ArrayList<SaleBase> propList = SaleConfig.getInstance().findPropByItemCode(itemCode);
        if (propList == null || propList.size() == 0) {
            result.setS2CCode(ERR_CODE.ERR_CODE_ITEM_NOT_EXIST.getValue());
            return result;
        }
        SaleBase prop = propList.get(0);
        for (int i = 0; i < propList.size(); i++) {
            SaleBase temp = propList.get(i);
            if (typeIds.indexOf(Integer.valueOf(temp.typeID)) != -1) {
                prop = temp;
            }
        }
        if (prop.moneyType != 1) {
            result.setS2CCode(ERR_CODE.ERR_CODE_MONEY_TYPE_ERROR.getValue());
            return result;
        }
        int value = handleBuyItem(prop.typeID, prop.itemID, num, false);
        result.setS2CCode(value);
        result.setS2CNeedGold(prop.needMoney * num);

        return result;
    }

    public final int handleBuyItem(int typeId, int itemId, int num, boolean bDiamond) {
        int result = ERR_CODE.ERR_CODE_OK.getValue();
        SaleBase prop = SaleConfig.getInstance().findPropByTypeIdAndItemId(typeId, itemId);
        if (prop == null) {
            result = ERR_CODE.ERR_CODE_ITEM_NOT_EXIST.getValue();
            return result;
        }

        int needMoney = prop.needMoney * num;

        if (prop.moneyType == 1 && !this.player.moneyManager.enoughGold(needMoney)) {

            if (!bDiamond) {

                result = ERR_CODE.ERR_CODE_GOLD_NOT_ENOUGH.getValue();
                return result;
            }
            if (!this.player.moneyManager.enoughDiamond(needMoney - this.player.moneyManager.getGold())) {
                return result;
            }
        } else if (prop.moneyType == 2 && !this.player.moneyManager.enoughTicket(needMoney)) {

            if (!bDiamond) {
                ArrayList<Integer> args = new ArrayList<>();
                args.add(Integer.valueOf(typeId));
                args.add(Integer.valueOf(itemId));
                args.add(Integer.valueOf(num));
                FunctionHandler.TipsParam.Builder tipsParam = FunctionHandler.TipsParam.newBuilder();
                tipsParam.setDiamond(needMoney - this.player.moneyManager.getTicket());
                this.player.puchFuncGoToTicketNotEnough();
                return result;
            }
            if (!this.player.moneyManager.enoughDiamond(needMoney - this.player.moneyManager.getTicket())) {
                return result;
            }
        } else if (prop.moneyType == 3 && !this.player.moneyManager.enoughDiamond(needMoney)) {
            result = ERR_CODE.ERR_CODE_DIAMAND_NOT_ENOUGH.getValue();
            return result;
        }

        Const.ForceType forceBindType = Const.ForceType.DEFAULT;
        if (prop.isBind == 1) {
            forceBindType = Const.ForceType.BIND;
        } else if (prop.isBind == 2) {
            forceBindType = Const.ForceType.UN_BIND;
        }

        int addNum = prop.itemCount * num;
        if (!this.player.getWnBag().testAddCodeItem(prop.itemCode, addNum, forceBindType, false)) {
            result = ERR_CODE.ERR_CODE_BAG_NOT_ENOUGH_POS.getValue();
            return result;
        }


        String buyType = "";


        if (prop.moneyType == 1) {
            buyType = "gold";
            if (bDiamond) {
                this.player.moneyManager.costDiamond(needMoney - this.player.moneyManager.getGold(), Const.GOODS_CHANGE_TYPE.buy);
                this.player.moneyManager.costGold(this.player.moneyManager.getGold(), Const.GOODS_CHANGE_TYPE.buy);
                buyType = buyType + "|diamond";
            } else {
                this.player.moneyManager.costGold(needMoney, Const.GOODS_CHANGE_TYPE.buy);
            }

        } else if (prop.moneyType == 2) {
            buyType = "ticket";
            if (bDiamond) {
                this.player.moneyManager.costDiamond(needMoney - this.player.moneyManager.getTicket(), Const.GOODS_CHANGE_TYPE.buy);
                this.player.moneyManager.costTicket(this.player.moneyManager.getTicket(), Const.GOODS_CHANGE_TYPE.buy);
                buyType = buyType + "|diamond";
            } else {
                this.player.moneyManager.costTicket(needMoney, Const.GOODS_CHANGE_TYPE.buy);
            }

        } else if (prop.moneyType == 3) {
            buyType = "diamond";
            this.player.moneyManager.costDiamond(needMoney, Const.GOODS_CHANGE_TYPE.buy);
        }


        this.player.getWnBag().addCodeItem(prop.itemCode, addNum, forceBindType, Const.GOODS_CHANGE_TYPE.shop, null, false, false);


        return result;
    }


    public int handleSellItems(List<SaleHandler.SellGrid> sellGrids) {
        int result = ERR_CODE.ERR_CODE_OK.getValue();

        if (sellGrids.size() == 0) {
            result = ERR_CODE.ERR_CODE_SELL_ITEMS_EMPTY.getValue();
            return result;
        }

        int allPrice = 0;
        List<Map<String, Object>> posnums = new ArrayList<>();
        ArrayList<NormalItem> allItems = new ArrayList<>();

        for (SaleHandler.SellGrid grid : sellGrids) {
            int pos = grid.getIndex();
            int num = grid.getNum();
            NormalItem item = this.player.getWnBag().getItem(pos);
            if (item == null) {
                result = ERR_CODE.ERR_CODE_ITEM_NOT_EXIST.getValue();
                return result;
            }
            if (!item.canSell()) {
                result = ERR_CODE.ERR_CODE_ITEM_NOSELL.getValue();
                return result;
            }
            if (item.itemDb.groupCount < num) {
                result = ERR_CODE.ERR_CODE_PARAM_ERROR.getValue();
                return result;
            }

            int price = BagUtil.getSellPrice(item.price(), num);
            allPrice += price;

            Map<String, Object> obj = new HashMap<>();
            obj.put("pos", Integer.valueOf(pos));
            obj.put("num", Integer.valueOf(num));
            Map<Integer, Integer> currency = new TreeMap<>();
            currency.put(Integer.valueOf(Const.CurrencyType.DIAMOND.getValue()), Integer.valueOf(item.price()));
            obj.put("currency", currency);
            obj.put("costDes", Integer.valueOf(Const.GOODS_CHANGE_TYPE.clear_when_logout.getValue()));
            posnums.add(obj);

            if (item.itemDb.groupCount != num) {
                NormalItem newItem = ItemUtil.createItemsByItemCode((item.getTemplate()).code, num).get(0);
                newItem.itemDb.isNew = 0;
                newItem.setBind(item.getBind());
                allItems.add(newItem);
            } else {
                item.itemDb.isNew = 0;
                allItems.add(item);
            }


            if (item.getQLevel() >= Const.ItemQuality.ORANGE.getValue()) {
                StringBuffer sb = new StringBuffer();
                if (item instanceof NormalEquip) {
                    NormalEquip equip = (NormalEquip) item;
                    ItemSpeData speData = equip.itemDb.speData;
                    if (speData != null) {
                        sb.append(speData.baseAtts.toString());
                        if (speData.extAtts != null) {
                            sb.append("|||").append(speData.extAtts.toString());
                        }
                        if (speData.legendAtts != null) {
                            sb.append("|||").append(speData.legendAtts.toString());
                        }
                    }
                }
                PlayerUtil.bi(getClass(), Const.BiLogType.Sale, this.player, new Object[]{item.itemDb.code + ":" + item.itemDb.id, sb.toString()});
            }
        }


        this.player.moneyManager.addGold(allPrice, Const.GOODS_CHANGE_TYPE.clear_when_logout);


        this.player.getWnBag().discardItemsByPos(posnums, Const.GOODS_CHANGE_TYPE.clear_when_logout);
        this.player.recycle.addEntityItems(allItems, Const.GOODS_CHANGE_TYPE.clear_when_logout);

        update();

        return result;
    }

    public int handleRebuyItem(int gridIndex, int num) {
        int result = ERR_CODE.ERR_CODE_OK.getValue();

        NormalItem item = this.player.recycle.getItem(gridIndex);
        if (item == null) {
            result = ERR_CODE.ERR_CODE_ITEM_NOT_EXIST.getValue();
            return result;
        }
        if (item.itemDb.groupCount < num) {
            result = ERR_CODE.ERR_CODE_PARAM_ERROR.getValue();
            return result;
        }

        int needGold = item.price() * num;
        if (!this.player.moneyManager.enoughGold(needGold)) {
            result = ERR_CODE.ERR_CODE_GOLD_NOT_ENOUGH.getValue();
            return result;
        }

        if (!this.player.getWnBag().testAddCodeItem(item.itemCode(), num, Const.ForceType.DEFAULT, false)) {

            result = ERR_CODE.ERR_CODE_BAG_NOT_ENOUGH_POS.getValue();
            return result;
        }


        this.player.moneyManager.costGold(needGold, Const.GOODS_CHANGE_TYPE.buy);


        if (item.itemDb.groupCount != num) {

            this.player.recycle.discardItemByPos(gridIndex, num, false, Const.GOODS_CHANGE_TYPE.clear_when_logout);
            NormalItem newItem = ItemUtil.createItemsByItemCode(item.itemCode(), num).get(0);
            newItem.itemDb.isNew = 0;
            newItem.setBind(item.getBind());
            Map<Integer, Object> currencyList = new HashMap<>();
            currencyList.put(Integer.valueOf(Const.CurrencyType.COIN.getValue()), Integer.valueOf(item.price()));

            this.player.getWnBag().addEntityItem(newItem, Const.GOODS_CHANGE_TYPE.clear_when_logout, currencyList, true, false);
        } else {
            this.player.recycle.removeItemByPos(gridIndex, false, Const.GOODS_CHANGE_TYPE.clear_when_logout);
            item.itemDb.isNew = 0;
            Map<Integer, Object> currencyList = new HashMap<>();
            currencyList.put(Integer.valueOf(Const.CurrencyType.COIN.getValue()), Integer.valueOf(item.price()));
            this.player.getWnBag().addEntityItem(item, Const.GOODS_CHANGE_TYPE.clear_when_logout, currencyList, true, false);
        }

        update();

        return result;
    }

    private void update() {
    }
}


