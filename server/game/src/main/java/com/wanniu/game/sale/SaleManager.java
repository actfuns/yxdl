/*     */ package com.wanniu.game.sale;
/*     */ 
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.game.bag.BagUtil;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.data.base.DItemEquipBase;
/*     */ import com.wanniu.game.data.base.SaleBase;
/*     */ import com.wanniu.game.equip.NormalEquip;
/*     */ import com.wanniu.game.item.ItemUtil;
/*     */ import com.wanniu.game.item.NormalItem;
/*     */ import com.wanniu.game.item.po.ItemSpeData;
/*     */ import com.wanniu.game.player.PlayerUtil;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.TreeMap;
/*     */ import pomelo.area.FunctionHandler;
/*     */ import pomelo.area.SaleHandler;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SaleManager
/*     */ {
/*     */   private WNPlayer player;
/*     */   
/*     */   public enum ERR_CODE
/*     */   {
/*  32 */     ERR_CODE_OK(0), ERR_CODE_ITEM_NOT_EXIST(1), ERR_CODE_GOLD_NOT_ENOUGH(2), ERR_CODE_TICKET_NOT_ENOUGH(3), ERR_CODE_DIAMAND_NOT_ENOUGH(4), ERR_CODE_BAG_NOT_ENOUGH_POS(5), ERR_CODE_ITEM_NOSELL(6), ERR_CODE_SELL_ITEMS_EMPTY(7), ERR_CODE_PARAM_ERROR(8),
/*  33 */     ERR_CODE_MONEY_TYPE_ERROR(9), ERR_CODE_SOMETHING_ERR(99);
/*     */     private int value;
/*     */     
/*     */     ERR_CODE(int value) {
/*  37 */       this.value = value;
/*     */     }
/*     */     
/*     */     public int getValue() {
/*  41 */       return this.value;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public SaleManager(WNPlayer player) {
/*  48 */     this.player = player;
/*     */   }
/*     */ 
/*     */   
/*     */   public final SaleHandler.BuyPageResponse.Builder handleBuyPage(List<Integer> typeIds) {
/*  53 */     SaleHandler.BuyPageResponse.Builder result = SaleHandler.BuyPageResponse.newBuilder();
/*  54 */     result.setS2CCode(ERR_CODE.ERR_CODE_OK.getValue());
/*  55 */     ArrayList<SaleBase> props = SaleConfig.getInstance().findPropByTypeId(typeIds);
/*  56 */     ArrayList<SaleHandler.BuyItem> list = new ArrayList<>();
/*  57 */     for (int i = 0; i < props.size(); i++) {
/*  58 */       SaleBase prop = props.get(i);
/*  59 */       DItemEquipBase itemProp = ItemUtil.getPropByCode(prop.itemCode);
/*  60 */       if (itemProp == null) {
/*  61 */         Out.debug(new Object[] { "handleBuyPage prop:", prop });
/*  62 */         Out.error(new Object[] { "itemUtil.getPropByCode return null: code = ", prop.itemCode });
/*     */       } else {
/*     */         
/*  65 */         SaleHandler.BuyItem.Builder buyItem = SaleHandler.BuyItem.newBuilder();
/*  66 */         buyItem.setTypeId(prop.typeID);
/*  67 */         buyItem.setItemId(prop.itemID);
/*  68 */         buyItem.setItemShowName(prop.itemShowName);
/*  69 */         buyItem.setItem(ItemUtil.getMiniItemData(prop.itemCode, prop.itemCount));
/*  70 */         buyItem.setMoneyType(prop.moneyType);
/*  71 */         buyItem.setNeedMoney(prop.needMoney);
/*  72 */         buyItem.setMaxGroupCount((prop.itemCount > 1) ? 1 : itemProp.groupCount);
/*  73 */         list.add(buyItem.build());
/*     */       } 
/*  75 */     }  result.addAllS2CBuyItems(list);
/*  76 */     return result;
/*     */   }
/*     */   
/*     */   public final SaleHandler.AutoBuyItemByCodeResponse.Builder handleAutoBuyItemByTypeCode(List<Integer> typeIds, String itemCode, int num) {
/*  80 */     SaleHandler.AutoBuyItemByCodeResponse.Builder result = SaleHandler.AutoBuyItemByCodeResponse.newBuilder();
/*  81 */     result.setS2CCode(ERR_CODE.ERR_CODE_OK.getValue());
/*  82 */     ArrayList<SaleBase> propList = SaleConfig.getInstance().findPropByItemCode(itemCode);
/*  83 */     if (propList == null || propList.size() == 0) {
/*  84 */       result.setS2CCode(ERR_CODE.ERR_CODE_ITEM_NOT_EXIST.getValue());
/*  85 */       return result;
/*     */     } 
/*  87 */     SaleBase prop = propList.get(0);
/*  88 */     for (int i = 0; i < propList.size(); i++) {
/*  89 */       SaleBase temp = propList.get(i);
/*  90 */       if (typeIds.indexOf(Integer.valueOf(temp.typeID)) != -1) {
/*  91 */         prop = temp;
/*     */       }
/*     */     } 
/*  94 */     if (prop.moneyType != 1) {
/*  95 */       result.setS2CCode(ERR_CODE.ERR_CODE_MONEY_TYPE_ERROR.getValue());
/*  96 */       return result;
/*     */     } 
/*  98 */     int value = handleBuyItem(prop.typeID, prop.itemID, num, false);
/*  99 */     result.setS2CCode(value);
/* 100 */     result.setS2CNeedGold(prop.needMoney * num);
/*     */     
/* 102 */     return result;
/*     */   }
/*     */   
/*     */   public final int handleBuyItem(int typeId, int itemId, int num, boolean bDiamond) {
/* 106 */     int result = ERR_CODE.ERR_CODE_OK.getValue();
/* 107 */     SaleBase prop = SaleConfig.getInstance().findPropByTypeIdAndItemId(typeId, itemId);
/* 108 */     if (prop == null) {
/* 109 */       result = ERR_CODE.ERR_CODE_ITEM_NOT_EXIST.getValue();
/* 110 */       return result;
/*     */     } 
/*     */     
/* 113 */     int needMoney = prop.needMoney * num;
/*     */     
/* 115 */     if (prop.moneyType == 1 && !this.player.moneyManager.enoughGold(needMoney)) {
/*     */       
/* 117 */       if (!bDiamond) {
/*     */         
/* 119 */         result = ERR_CODE.ERR_CODE_GOLD_NOT_ENOUGH.getValue();
/* 120 */         return result;
/*     */       } 
/* 122 */       if (!this.player.moneyManager.enoughDiamond(needMoney - this.player.moneyManager.getGold())) {
/* 123 */         return result;
/*     */       }
/*     */     }
/* 126 */     else if (prop.moneyType == 2 && !this.player.moneyManager.enoughTicket(needMoney)) {
/*     */       
/* 128 */       if (!bDiamond) {
/* 129 */         ArrayList<Integer> args = new ArrayList<>();
/* 130 */         args.add(Integer.valueOf(typeId));
/* 131 */         args.add(Integer.valueOf(itemId));
/* 132 */         args.add(Integer.valueOf(num));
/* 133 */         FunctionHandler.TipsParam.Builder tipsParam = FunctionHandler.TipsParam.newBuilder();
/* 134 */         tipsParam.setDiamond(needMoney - this.player.moneyManager.getTicket());
/* 135 */         this.player.puchFuncGoToTicketNotEnough();
/* 136 */         return result;
/*     */       } 
/* 138 */       if (!this.player.moneyManager.enoughDiamond(needMoney - this.player.moneyManager.getTicket())) {
/* 139 */         return result;
/*     */       }
/*     */     }
/* 142 */     else if (prop.moneyType == 3 && !this.player.moneyManager.enoughDiamond(needMoney)) {
/* 143 */       result = ERR_CODE.ERR_CODE_DIAMAND_NOT_ENOUGH.getValue();
/* 144 */       return result;
/*     */     } 
/*     */     
/* 147 */     Const.ForceType forceBindType = Const.ForceType.DEFAULT;
/* 148 */     if (prop.isBind == 1) {
/* 149 */       forceBindType = Const.ForceType.BIND;
/* 150 */     } else if (prop.isBind == 2) {
/* 151 */       forceBindType = Const.ForceType.UN_BIND;
/*     */     } 
/*     */     
/* 154 */     int addNum = prop.itemCount * num;
/* 155 */     if (!this.player.getWnBag().testAddCodeItem(prop.itemCode, addNum, forceBindType, false)) {
/* 156 */       result = ERR_CODE.ERR_CODE_BAG_NOT_ENOUGH_POS.getValue();
/* 157 */       return result;
/*     */     } 
/*     */ 
/*     */     
/* 161 */     String buyType = "";
/*     */ 
/*     */ 
/*     */     
/* 165 */     if (prop.moneyType == 1) {
/* 166 */       buyType = "gold";
/* 167 */       if (bDiamond) {
/* 168 */         this.player.moneyManager.costDiamond(needMoney - this.player.moneyManager.getGold(), Const.GOODS_CHANGE_TYPE.buy);
/* 169 */         this.player.moneyManager.costGold(this.player.moneyManager.getGold(), Const.GOODS_CHANGE_TYPE.buy);
/* 170 */         buyType = buyType + "|diamond";
/*     */       } else {
/* 172 */         this.player.moneyManager.costGold(needMoney, Const.GOODS_CHANGE_TYPE.buy);
/*     */       }
/*     */     
/* 175 */     } else if (prop.moneyType == 2) {
/* 176 */       buyType = "ticket";
/* 177 */       if (bDiamond) {
/* 178 */         this.player.moneyManager.costDiamond(needMoney - this.player.moneyManager.getTicket(), Const.GOODS_CHANGE_TYPE.buy);
/* 179 */         this.player.moneyManager.costTicket(this.player.moneyManager.getTicket(), Const.GOODS_CHANGE_TYPE.buy);
/* 180 */         buyType = buyType + "|diamond";
/*     */       } else {
/* 182 */         this.player.moneyManager.costTicket(needMoney, Const.GOODS_CHANGE_TYPE.buy);
/*     */       }
/*     */     
/* 185 */     } else if (prop.moneyType == 3) {
/* 186 */       buyType = "diamond";
/* 187 */       this.player.moneyManager.costDiamond(needMoney, Const.GOODS_CHANGE_TYPE.buy);
/*     */     } 
/*     */ 
/*     */     
/* 191 */     this.player.getWnBag().addCodeItem(prop.itemCode, addNum, forceBindType, Const.GOODS_CHANGE_TYPE.shop, null, false, false);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 199 */     return result;
/*     */   }
/*     */ 
/*     */   
/*     */   public int handleSellItems(List<SaleHandler.SellGrid> sellGrids) {
/* 204 */     int result = ERR_CODE.ERR_CODE_OK.getValue();
/*     */     
/* 206 */     if (sellGrids.size() == 0) {
/* 207 */       result = ERR_CODE.ERR_CODE_SELL_ITEMS_EMPTY.getValue();
/* 208 */       return result;
/*     */     } 
/*     */     
/* 211 */     int allPrice = 0;
/* 212 */     List<Map<String, Object>> posnums = new ArrayList<>();
/* 213 */     ArrayList<NormalItem> allItems = new ArrayList<>();
/*     */     
/* 215 */     for (SaleHandler.SellGrid grid : sellGrids) {
/* 216 */       int pos = grid.getIndex();
/* 217 */       int num = grid.getNum();
/* 218 */       NormalItem item = this.player.getWnBag().getItem(pos);
/* 219 */       if (item == null) {
/* 220 */         result = ERR_CODE.ERR_CODE_ITEM_NOT_EXIST.getValue();
/* 221 */         return result;
/*     */       } 
/* 223 */       if (!item.canSell()) {
/* 224 */         result = ERR_CODE.ERR_CODE_ITEM_NOSELL.getValue();
/* 225 */         return result;
/*     */       } 
/* 227 */       if (item.itemDb.groupCount < num) {
/* 228 */         result = ERR_CODE.ERR_CODE_PARAM_ERROR.getValue();
/* 229 */         return result;
/*     */       } 
/*     */       
/* 232 */       int price = BagUtil.getSellPrice(item.price(), num);
/* 233 */       allPrice += price;
/*     */       
/* 235 */       Map<String, Object> obj = new HashMap<>();
/* 236 */       obj.put("pos", Integer.valueOf(pos));
/* 237 */       obj.put("num", Integer.valueOf(num));
/* 238 */       Map<Integer, Integer> currency = new TreeMap<>();
/* 239 */       currency.put(Integer.valueOf(Const.CurrencyType.DIAMOND.getValue()), Integer.valueOf(item.price()));
/* 240 */       obj.put("currency", currency);
/* 241 */       obj.put("costDes", Integer.valueOf(Const.GOODS_CHANGE_TYPE.clear_when_logout.getValue()));
/* 242 */       posnums.add(obj);
/*     */       
/* 244 */       if (item.itemDb.groupCount != num) {
/* 245 */         NormalItem newItem = ItemUtil.createItemsByItemCode((item.getTemplate()).code, num).get(0);
/* 246 */         newItem.itemDb.isNew = 0;
/* 247 */         newItem.setBind(item.getBind());
/* 248 */         allItems.add(newItem);
/*     */       } else {
/* 250 */         item.itemDb.isNew = 0;
/* 251 */         allItems.add(item);
/*     */       } 
/*     */ 
/*     */       
/* 255 */       if (item.getQLevel() >= Const.ItemQuality.ORANGE.getValue()) {
/* 256 */         StringBuffer sb = new StringBuffer();
/* 257 */         if (item instanceof NormalEquip) {
/* 258 */           NormalEquip equip = (NormalEquip)item;
/* 259 */           ItemSpeData speData = equip.itemDb.speData;
/* 260 */           if (speData != null) {
/* 261 */             sb.append(speData.baseAtts.toString());
/* 262 */             if (speData.extAtts != null) {
/* 263 */               sb.append("|||").append(speData.extAtts.toString());
/*     */             }
/* 265 */             if (speData.legendAtts != null) {
/* 266 */               sb.append("|||").append(speData.legendAtts.toString());
/*     */             }
/*     */           } 
/*     */         } 
/* 270 */         PlayerUtil.bi(getClass(), Const.BiLogType.Sale, this.player, new Object[] { item.itemDb.code + ":" + item.itemDb.id, sb.toString() });
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 275 */     this.player.moneyManager.addGold(allPrice, Const.GOODS_CHANGE_TYPE.clear_when_logout);
/*     */ 
/*     */     
/* 278 */     this.player.getWnBag().discardItemsByPos(posnums, Const.GOODS_CHANGE_TYPE.clear_when_logout);
/* 279 */     this.player.recycle.addEntityItems(allItems, Const.GOODS_CHANGE_TYPE.clear_when_logout);
/*     */     
/* 281 */     update();
/*     */     
/* 283 */     return result;
/*     */   }
/*     */   
/*     */   public int handleRebuyItem(int gridIndex, int num) {
/* 287 */     int result = ERR_CODE.ERR_CODE_OK.getValue();
/*     */     
/* 289 */     NormalItem item = this.player.recycle.getItem(gridIndex);
/* 290 */     if (item == null) {
/* 291 */       result = ERR_CODE.ERR_CODE_ITEM_NOT_EXIST.getValue();
/* 292 */       return result;
/*     */     } 
/* 294 */     if (item.itemDb.groupCount < num) {
/* 295 */       result = ERR_CODE.ERR_CODE_PARAM_ERROR.getValue();
/* 296 */       return result;
/*     */     } 
/*     */     
/* 299 */     int needGold = item.price() * num;
/* 300 */     if (!this.player.moneyManager.enoughGold(needGold)) {
/* 301 */       result = ERR_CODE.ERR_CODE_GOLD_NOT_ENOUGH.getValue();
/* 302 */       return result;
/*     */     } 
/*     */     
/* 305 */     if (!this.player.getWnBag().testAddCodeItem(item.itemCode(), num, Const.ForceType.DEFAULT, false)) {
/*     */       
/* 307 */       result = ERR_CODE.ERR_CODE_BAG_NOT_ENOUGH_POS.getValue();
/* 308 */       return result;
/*     */     } 
/*     */ 
/*     */     
/* 312 */     this.player.moneyManager.costGold(needGold, Const.GOODS_CHANGE_TYPE.buy);
/*     */ 
/*     */     
/* 315 */     if (item.itemDb.groupCount != num) {
/*     */       
/* 317 */       this.player.recycle.discardItemByPos(gridIndex, num, false, Const.GOODS_CHANGE_TYPE.clear_when_logout);
/* 318 */       NormalItem newItem = ItemUtil.createItemsByItemCode(item.itemCode(), num).get(0);
/* 319 */       newItem.itemDb.isNew = 0;
/* 320 */       newItem.setBind(item.getBind());
/* 321 */       Map<Integer, Object> currencyList = new HashMap<>();
/* 322 */       currencyList.put(Integer.valueOf(Const.CurrencyType.COIN.getValue()), Integer.valueOf(item.price()));
/*     */       
/* 324 */       this.player.getWnBag().addEntityItem(newItem, Const.GOODS_CHANGE_TYPE.clear_when_logout, currencyList, true, false);
/*     */     } else {
/* 326 */       this.player.recycle.removeItemByPos(gridIndex, false, Const.GOODS_CHANGE_TYPE.clear_when_logout);
/* 327 */       item.itemDb.isNew = 0;
/* 328 */       Map<Integer, Object> currencyList = new HashMap<>();
/* 329 */       currencyList.put(Integer.valueOf(Const.CurrencyType.COIN.getValue()), Integer.valueOf(item.price()));
/* 330 */       this.player.getWnBag().addEntityItem(item, Const.GOODS_CHANGE_TYPE.clear_when_logout, currencyList, true, false);
/*     */     } 
/*     */     
/* 333 */     update();
/*     */     
/* 335 */     return result;
/*     */   }
/*     */   
/*     */   private void update() {}
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\sale\SaleManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */