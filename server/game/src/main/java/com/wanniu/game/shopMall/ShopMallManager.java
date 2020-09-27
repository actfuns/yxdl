/*     */ package com.wanniu.game.shopMall;
/*     */ 
/*     */ import com.alibaba.fastjson.JSON;
/*     */ import com.wanniu.core.game.LangService;
/*     */ import com.wanniu.core.game.entity.GEntity;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.util.StringUtil;
/*     */ import com.wanniu.game.GWorld;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.ConstsTR;
/*     */ import com.wanniu.game.data.CardCO;
/*     */ import com.wanniu.game.data.GameData;
/*     */ import com.wanniu.game.data.ShopMallConfigCO;
/*     */ import com.wanniu.game.data.SocialFriendCO;
/*     */ import com.wanniu.game.data.base.DItemEquipBase;
/*     */ import com.wanniu.game.data.ext.ExchangeMallExt;
/*     */ import com.wanniu.game.data.ext.ShopMallItemsExt;
/*     */ import com.wanniu.game.item.ItemConfig;
/*     */ import com.wanniu.game.mail.MailUtil;
/*     */ import com.wanniu.game.mail.data.MailData;
/*     */ import com.wanniu.game.mail.data.MailPlayerData;
/*     */ import com.wanniu.game.player.GlobalConfig;
/*     */ import com.wanniu.game.player.PlayerUtil;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.player.bi.LogReportService;
/*     */ import com.wanniu.game.poes.PlayerPO;
/*     */ import com.wanniu.game.poes.ShopMallPO;
/*     */ import com.wanniu.redis.PlayerPOManager;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import pomelo.Common;
/*     */ import pomelo.area.PlayerHandler;
/*     */ import pomelo.area.ShopMallHandler;
/*     */ 
/*     */ public class ShopMallManager {
/*     */   private WNPlayer player;
/*     */   
/*     */   public static ShopMallItemData createShopMallItemData(String jsonString) {
/*  43 */     ShopMallItemData data = (ShopMallItemData)JSON.parseObject(jsonString, ShopMallItemData.class);
/*  44 */     return data;
/*     */   }
/*     */   
/*     */   public ShopMallPO db;
/*     */   
/*     */   public class ShopMallData {
/*     */     public String itemType;
/*     */     public int moneyType;
/*     */     public int isOpen;
/*     */     public String name;
/*     */     public int isLimit; }
/*     */   
/*     */   public class ShopMallResult { public boolean result;
/*     */     public String msg;
/*     */     public int totalNum;
/*     */     
/*     */     public ShopMallResult(boolean result, String msg) {
/*  61 */       this.result = result;
/*  62 */       this.msg = msg;
/*     */     } }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ShopMallManager(WNPlayer player, ShopMallPO db) {
/*  70 */     this.player = player;
/*  71 */     this.db = db;
/*  72 */     if (this.db == null) {
/*  73 */       this.db = new ShopMallPO();
/*  74 */       this.db.dayMallItemNums = new HashMap<>();
/*  75 */       this.db.weekMallItemNums = new HashMap<>();
/*  76 */       this.db.seenTab = new HashMap<>();
/*     */       
/*  78 */       refreshNewDay();
/*  79 */       refreshNewWeek();
/*  80 */       PlayerPOManager.put(ConstsTR.shopMallTR, this.player.getId(), (GEntity)this.db);
/*     */     } 
/*     */   }
/*     */   
/*     */   public final ShopMallResult buyMallItem(String itemId, int count, String playerId, int bDiamond) {
/*  85 */     ShopMallResult result = new ShopMallResult(true, null);
/*     */     
/*  87 */     ShopMallConfigCO shopMallConfigCO = null;
/*     */     
/*  89 */     ShopMallItemsExt mallItemProp = ShopMallConfig.getInstance().fingShowMallItemByID(itemId);
/*  90 */     ExchangeMallExt exchangeMallExt = ShopMallConfig.getInstance().findExchangeMallItemByID(itemId);
/*  91 */     Date now = new Date();
/*  92 */     Date endTime = null;
/*     */ 
/*     */     
/*  95 */     if (mallItemProp == null && exchangeMallExt == null) {
/*  96 */       return new ShopMallResult(false, LangService.getValue("ITEM_NULL"));
/*     */     }
/*     */     
/*  99 */     if (mallItemProp != null) {
/*     */       
/* 101 */       if (mallItemProp.buyTimes > 0 || mallItemProp.weekBuyTimes > 0) {
/* 102 */         int remainNum = getSelfMallItemRemainNum(mallItemProp.iD);
/* 103 */         if ((remainNum > 0 && remainNum < count) || remainNum == 0) {
/* 104 */           return new ShopMallResult(false, LangService.getValue("SHOPMALL_LIMIT_ITEM_OVER"));
/*     */         }
/*     */       } 
/*     */       
/* 108 */       shopMallConfigCO = (ShopMallConfigCO)GameData.ShopMallConfigs.get(Integer.valueOf(mallItemProp.itemType));
/* 109 */       endTime = mallItemProp.endTime;
/*     */     } 
/* 111 */     if (exchangeMallExt != null) {
/*     */       
/* 113 */       if (exchangeMallExt.exchangeTimes > 0 || exchangeMallExt.weekExchangeTimes > 0 || exchangeMallExt.totalTimes > 0) {
/* 114 */         int remainNum = getSelfMallExchangeItemRemainNum(exchangeMallExt.iD);
/* 115 */         if ((remainNum > 0 && remainNum < count) || remainNum == 0) {
/* 116 */           return new ShopMallResult(false, LangService.getValue("SHOPMALL_LIMIT_ITEM_OVER"));
/*     */         }
/*     */       } 
/*     */       
/* 120 */       shopMallConfigCO = (ShopMallConfigCO)GameData.ShopMallConfigs.get(Integer.valueOf(exchangeMallExt.itemType));
/* 121 */       endTime = exchangeMallExt.endTime;
/*     */     } 
/*     */     
/* 124 */     if (!isValidOfMallTab(shopMallConfigCO.itemType)) {
/* 125 */       return new ShopMallResult(false, LangService.getValue("SHOPMALL_ITEM_OPEN_NOT"));
/*     */     }
/*     */     
/* 128 */     if (endTime != null && now.getTime() > endTime.getTime()) {
/* 129 */       return new ShopMallResult(false, LangService.getValue("SHOPMALL_LIMIT_ITEM_OVER"));
/*     */     }
/*     */     
/* 132 */     if (StringUtil.isNotEmpty(playerId) && !this.player.friendManager.isFriend(playerId)) {
/* 133 */       return new ShopMallResult(false, LangService.getValue("FRIEND_FIND_NONE"));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 141 */     int itemNum = -1;
/* 142 */     if (mallItemProp != null) {
/* 143 */       int priceSingle = mallItemProp.price2;
/* 144 */       if (priceSingle <= 0) {
/* 145 */         priceSingle = mallItemProp.price;
/*     */       }
/* 147 */       int costNum = priceSingle * count;
/* 148 */       itemNum = mallItemProp.num * count;
/*     */       
/* 150 */       if (shopMallConfigCO.consumeType == Const.SHOP_MALL_CONSUME_TYPE.DIAMOND.getValue()) {
/*     */         
/* 152 */         if (!this.player.moneyManager.enoughDiamond(costNum)) {
/* 153 */           return new ShopMallResult(false, LangService.getValue("DIAMAND_NOT_ENOUGH"));
/*     */         }
/* 155 */       } else if (shopMallConfigCO.consumeType == Const.SHOP_MALL_CONSUME_TYPE.TICKET.getValue()) {
/*     */         
/* 157 */         if (!this.player.moneyManager.enoughTicketAndDiamond(costNum)) {
/* 158 */           return new ShopMallResult(false, LangService.getValue("DIAMAND_NOT_ENOUGH"));
/*     */         }
/*     */       } 
/*     */       
/* 162 */       int consumePoint = mallItemProp.points * count;
/*     */       
/* 164 */       this.player.moneyManager.addConsumePoint(consumePoint, Const.GOODS_CHANGE_TYPE.shop);
/*     */       
/* 166 */       List<Common.KeyValueStruct> itemChange = new ArrayList<>();
/* 167 */       Common.KeyValueStruct.Builder it = Common.KeyValueStruct.newBuilder();
/* 168 */       it.setKey(mallItemProp.itemCode);
/* 169 */       it.setValue(String.valueOf(itemNum));
/* 170 */       itemChange.add(it.build());
/*     */ 
/*     */       
/* 173 */       if (shopMallConfigCO.consumeType == Const.SHOP_MALL_CONSUME_TYPE.DIAMOND.getValue()) {
/* 174 */         this.player.moneyManager.costDiamond(costNum, Const.GOODS_CHANGE_TYPE.shop, itemChange);
/* 175 */       } else if (shopMallConfigCO.consumeType == Const.SHOP_MALL_CONSUME_TYPE.TICKET.getValue()) {
/* 176 */         this.player.moneyManager.costTicketAndDiamond(costNum, Const.GOODS_CHANGE_TYPE.shop, itemChange);
/*     */       } 
/*     */ 
/*     */       
/* 180 */       if (StringUtil.isEmpty(playerId)) {
/* 181 */         int forceType = mallItemProp.isBind;
/* 182 */         if (!this.player.getWnBag().testAddCodeItem(mallItemProp.itemCode, itemNum, Const.ForceType.getE(forceType))) {
/* 183 */           return new ShopMallResult(false, LangService.getValue("BAG_FULL"));
/*     */         }
/* 185 */         Out.info(new Object[] { "商城购买 playerId=", this.player.getId(), ",itemId=", mallItemProp.itemCode, ",count=", Integer.valueOf(itemNum) });
/* 186 */         Map<Integer, Object> currencyList = new HashMap<>();
/* 187 */         currencyList.put(Integer.valueOf(mallItemProp.consumeType), Integer.valueOf(priceSingle));
/* 188 */         this.player.getWnBag().addCodeItem(mallItemProp.itemCode, itemNum, Const.ForceType.getE(forceType), Const.GOODS_CHANGE_TYPE.shop, currencyList);
/*     */       } else {
/* 190 */         MailPlayerData mailData = new MailPlayerData();
/* 191 */         mailData.mailSender = this.player.getName();
/* 192 */         mailData.mailSenderId = this.player.getId();
/* 193 */         mailData.mailTitle = LangService.getValue("SHOPMALL_SEND_FRIEND_ITEM_TITLE");
/* 194 */         mailData.mailText = LangService.getValue("SHOPMALL_SEND_FRIEND_ITEM").replace("{playerName}", this.player.getName()).replace("{itemNum}", String.valueOf(itemNum)).replace("{itemName}", mallItemProp.name);
/* 195 */         mailData.mailRead = 1;
/* 196 */         mailData.mailIcon = (this.player.getPlayer()).pro;
/* 197 */         ArrayList<MailData.Attachment> atts = new ArrayList<>();
/* 198 */         MailData.Attachment att = new MailData.Attachment();
/* 199 */         att.itemCode = mallItemProp.itemCode;
/* 200 */         att.itemNum = itemNum;
/* 201 */         atts.add(att);
/* 202 */         mailData.attachments = atts;
/* 203 */         MailUtil.getInstance().sendMailToOnePlayer(playerId, (MailData)mailData, Const.GOODS_CHANGE_TYPE.shop);
/*     */         
/* 205 */         int friendshipNum = ((SocialFriendCO)GameData.SocialFriends.get(Integer.valueOf(7))).friendshipNum;
/*     */         
/* 207 */         String messageText = ((SocialFriendCO)GameData.SocialFriends.get(Integer.valueOf(7))).messageText;
/*     */ 
/*     */         
/* 210 */         this.player.baseDataManager.addFriendly(friendshipNum);
/* 211 */         this.player.pushDynamicData("friendly", Integer.valueOf(this.player.player.friendly));
/* 212 */         PlayerPO friend = (PlayerPO)PlayerPOManager.findPO(ConstsTR.playerTR, playerId, PlayerPO.class);
/* 213 */         PlayerUtil.sendSysMessageToPlayer(messageText.replace("{playerName}", friend.name).replace("itemName", mallItemProp.name), this.player.getId());
/*     */       } 
/*     */       
/* 216 */       result.totalNum = this.player.bag.findItemNumByCode(mallItemProp.itemCode);
/*     */       
/* 218 */       if (mallItemProp.buyTimes > 0 || mallItemProp.weekBuyTimes > 0) {
/* 219 */         addSelfMallItemNum(mallItemProp.iD, count);
/*     */       }
/*     */ 
/*     */       
/* 223 */       LogReportService.getInstance().ansycReportShop(this.player, mallItemProp.itemCode, itemNum, shopMallConfigCO.consumeType, costNum);
/*     */     } 
/* 225 */     if (exchangeMallExt != null) {
/* 226 */       itemNum = exchangeMallExt.num * count;
/*     */       
/* 228 */       for (Map.Entry<String, Integer> entry : (Iterable<Map.Entry<String, Integer>>)exchangeMallExt.exchangeNeedMap.entrySet()) {
/* 229 */         if (this.player.bag.findItemNumByCode((String)entry.getKey()) < ((Integer)entry.getValue()).intValue() * count) {
/* 230 */           return new ShopMallResult(false, "");
/*     */         }
/*     */       } 
/*     */       
/* 234 */       int forceType = exchangeMallExt.isBind;
/* 235 */       if (!this.player.getWnBag().testAddCodeItem(exchangeMallExt.itemCode, itemNum, Const.ForceType.getE(forceType))) {
/* 236 */         return new ShopMallResult(false, LangService.getValue("BAG_FULL"));
/*     */       }
/*     */       
/* 239 */       for (Map.Entry<String, Integer> entry : (Iterable<Map.Entry<String, Integer>>)exchangeMallExt.exchangeNeedMap.entrySet()) {
/* 240 */         this.player.bag.discardItem(entry.getKey(), ((Integer)entry.getValue()).intValue() * count, Const.GOODS_CHANGE_TYPE.shop);
/*     */       }
/*     */       
/* 243 */       Out.info(new Object[] { "商城兑换 playerId=", this.player.getId(), ",itemId=", exchangeMallExt.itemCode, ",count=", Integer.valueOf(count) });
/*     */       
/* 245 */       this.player.getWnBag().addCodeItem(exchangeMallExt.itemCode, itemNum, Const.ForceType.getE(forceType), Const.GOODS_CHANGE_TYPE.shop);
/*     */       
/* 247 */       result.totalNum = this.player.bag.findItemNumByCode(exchangeMallExt.itemCode);
/*     */       
/* 249 */       if (exchangeMallExt.exchangeTimes > 0 || exchangeMallExt.weekExchangeTimes > 0) {
/* 250 */         addSelfMallExchangeItemNum(exchangeMallExt.iD, count);
/*     */       }
/*     */     } 
/*     */     
/* 254 */     return result;
/*     */   }
/*     */   
/*     */   public final ArrayList<ShopMallHandler.MallItem.Builder> getMallItemList(int itemType) {
/* 258 */     ArrayList<ShopMallHandler.MallItem.Builder> items = new ArrayList<>();
/* 259 */     Date now = new Date();
/* 260 */     if (!isValidOfMallTab(itemType)) {
/* 261 */       return items;
/*     */     }
/* 263 */     seeTab(itemType);
/*     */ 
/*     */     
/* 266 */     List<ShopMallItemsExt> mallItems = GameData.findShopMallItemss(t -> (t.itemType == itemType));
/* 267 */     List<ExchangeMallExt> exchangeMallExts = GameData.findExchangeMalls(t -> (t.itemType == itemType));
/* 268 */     if (mallItems != null) {
/* 269 */       for (ShopMallItemsExt mallItem : mallItems) {
/* 270 */         if (mallItem.serveLimit == Const.SHOP_MALL_SERVER_LIMIT.SELF.getValue()) {
/*     */           
/* 272 */           if (!GWorld.DEBUG && mallItem.itemType == 199) {
/*     */             continue;
/*     */           }
/*     */           
/* 276 */           int remainNum = getSelfMallItemRemainNum(mallItem.iD);
/* 277 */           boolean flag = true;
/* 278 */           if (mallItem.isShow == 0) {
/* 279 */             flag = false;
/*     */           }
/* 281 */           if (remainNum == 0 && mallItem.isUseOut == 1) {
/* 282 */             flag = false;
/*     */           }
/* 284 */           long endTime = 0L;
/* 285 */           Date endDate = mallItem.endTime;
/* 286 */           if (endDate != null) {
/* 287 */             if (now.getTime() > endDate.getTime()) {
/* 288 */               flag = false;
/*     */             } else {
/* 290 */               endTime = endDate.getTime();
/*     */             } 
/*     */           }
/*     */           
/* 294 */           if (flag) {
/* 295 */             DItemEquipBase itemProp = ItemConfig.getInstance().getItemProp(mallItem.itemCode);
/* 296 */             if (itemProp != null) {
/* 297 */               ShopMallHandler.MallItem.Builder data = ShopMallHandler.MallItem.newBuilder();
/* 298 */               data.setId(mallItem.iD);
/* 299 */               data.setCode(mallItem.itemCode);
/* 300 */               data.setGroupCount(mallItem.num);
/* 301 */               data.setOriginPrice(mallItem.price);
/* 302 */               int nowPrice = (mallItem.price2 <= 0) ? mallItem.price : mallItem.price2;
/* 303 */               data.setNowPrice(nowPrice);
/* 304 */               data.setDisCount(mallItem.series);
/* 305 */               data.setEndTime((int)(endTime / 1000L));
/* 306 */               data.setRemainNum(remainNum);
/* 307 */               data.setConsumeScore(mallItem.points);
/* 308 */               data.setCanSend(1);
/* 309 */               switch (mallItem.isBind) {
/*     */                 case 1:
/* 311 */                   data.setBindType(1);
/* 312 */                   data.setCanSend(0);
/*     */                   break;
/*     */                 case 2:
/* 315 */                   data.setBindType(0);
/*     */                   break;
/*     */                 default:
/* 318 */                   data.setBindType(itemProp.bindType);
/*     */                   break;
/*     */               } 
/* 321 */               items.add(data); continue;
/*     */             } 
/* 323 */             Out.error(new Object[] { "there is no shop item prop, code : ", mallItem.itemCode });
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 333 */     if (exchangeMallExts != null) {
/* 334 */       for (ExchangeMallExt mallItem : exchangeMallExts) {
/*     */         
/* 336 */         if (!GWorld.DEBUG && mallItem.itemType == 199) {
/*     */           continue;
/*     */         }
/*     */         
/* 340 */         int remainNum = getSelfMallExchangeItemRemainNum(mallItem.iD);
/* 341 */         boolean flag = true;
/* 342 */         if (mallItem.isShow == 0) {
/* 343 */           flag = false;
/*     */         }
/* 345 */         if (remainNum == 0 && mallItem.isUseOut == 1) {
/* 346 */           flag = false;
/*     */         }
/* 348 */         long endTime = 0L;
/* 349 */         Date endDate = mallItem.endTime;
/* 350 */         if (endDate != null) {
/* 351 */           if (now.getTime() > endDate.getTime()) {
/* 352 */             flag = false;
/*     */           } else {
/* 354 */             endTime = endDate.getTime();
/*     */           } 
/*     */         }
/*     */         
/* 358 */         if (flag) {
/* 359 */           DItemEquipBase itemProp = ItemConfig.getInstance().getItemProp(mallItem.itemCode);
/* 360 */           if (itemProp != null) {
/* 361 */             ShopMallHandler.MallItem.Builder data = ShopMallHandler.MallItem.newBuilder();
/* 362 */             data.setId(mallItem.iD);
/* 363 */             data.setCode(mallItem.itemCode);
/* 364 */             data.setGroupCount(mallItem.num);
/* 365 */             data.setOriginPrice(0);
/* 366 */             data.setNowPrice(0);
/* 367 */             data.setDisCount(0);
/* 368 */             data.setEndTime((int)(endTime / 1000L));
/* 369 */             data.setRemainNum(remainNum);
/* 370 */             data.setConsumeScore(0);
/* 371 */             data.setCanSend(1);
/* 372 */             switch (mallItem.isBind) {
/*     */               case 1:
/* 374 */                 data.setBindType(1);
/* 375 */                 data.setCanSend(0);
/*     */                 break;
/*     */               case 2:
/* 378 */                 data.setBindType(0);
/*     */                 break;
/*     */               default:
/* 381 */                 data.setBindType(itemProp.bindType);
/*     */                 break;
/*     */             } 
/* 384 */             items.add(data); continue;
/*     */           } 
/* 386 */           Out.error(new Object[] { "there is no shop item prop, code : ", mallItem.itemCode });
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 392 */     return items;
/*     */   }
/*     */   
/*     */   public final List<ShopMallHandler.MallTab.Builder> getMallTabs() {
/* 396 */     List<ShopMallHandler.MallTab.Builder> tabs = new ArrayList<>();
/* 397 */     for (ShopMallConfigCO shopMallTabsProp : GameData.ShopMallConfigs.values()) {
/* 398 */       if (shopMallTabsProp.isOpened == 1 || GWorld.DEBUG) {
/*     */         
/* 400 */         if (!GWorld.DEBUG && shopMallTabsProp.itemType == 199) {
/*     */           continue;
/*     */         }
/* 403 */         ShopMallHandler.MallTab.Builder data = ShopMallHandler.MallTab.newBuilder();
/* 404 */         data.setMoneyType(shopMallTabsProp.consumeType);
/* 405 */         data.setItemType(shopMallTabsProp.itemType);
/* 406 */         if (isValidOfMallLimitItemTab(shopMallTabsProp.itemType)) {
/* 407 */           data.setIsOpen(1);
/*     */         } else {
/* 409 */           data.setIsOpen(0);
/*     */         } 
/* 411 */         data.setScriptNum(getSuperScriptNum(shopMallTabsProp.itemType));
/* 412 */         data.setName(shopMallTabsProp.labelName);
/*     */         
/* 414 */         if (shopMallTabsProp.itemType == Const.SHOP_MALL_ITEM_TYPE.DIAMOND_LIMIT.getValue() || shopMallTabsProp.itemType == Const.SHOP_MALL_ITEM_TYPE.TICKET_LIMIT.getValue() || shopMallTabsProp.itemType == Const.SHOP_MALL_ITEM_TYPE.ITEM_LIMIT.getValue()) {
/* 415 */           data.setIsLimit(1);
/*     */         } else {
/* 417 */           data.setIsLimit(0);
/*     */         } 
/* 419 */         data.setLastNumText(shopMallTabsProp.remainNum);
/* 420 */         tabs.add(data);
/*     */       } 
/*     */     } 
/* 423 */     return tabs;
/*     */   }
/*     */   
/*     */   public final void refreshNewDay() {
/* 427 */     if (this.db.seenTab == null) {
/* 428 */       this.db.seenTab = new HashMap<>();
/*     */     }
/* 430 */     if (this.db.dayMallItemNums == null) {
/* 431 */       this.db.dayMallItemNums = new HashMap<>();
/*     */     }
/*     */     
/* 434 */     if (this.db.seenTab.containsKey(Integer.valueOf(Const.SHOP_MALL_CONSUME_TYPE.DIAMOND.getValue()))) {
/* 435 */       ((Map)this.db.seenTab.get(Integer.valueOf(Const.SHOP_MALL_CONSUME_TYPE.DIAMOND.getValue()))).clear();
/*     */     } else {
/* 437 */       this.db.seenTab.put(Integer.valueOf(Const.SHOP_MALL_CONSUME_TYPE.DIAMOND.getValue()), new HashMap<>());
/*     */     } 
/* 439 */     if (this.db.seenTab.containsKey(Integer.valueOf(Const.SHOP_MALL_CONSUME_TYPE.TICKET.getValue()))) {
/* 440 */       ((Map)this.db.seenTab.get(Integer.valueOf(Const.SHOP_MALL_CONSUME_TYPE.TICKET.getValue()))).clear();
/*     */     } else {
/* 442 */       this.db.seenTab.put(Integer.valueOf(Const.SHOP_MALL_CONSUME_TYPE.TICKET.getValue()), new HashMap<>());
/*     */     } 
/* 444 */     this.db.dayMallItemNums.clear();
/* 445 */     this.db.dayMallExchangeItemNums.clear();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void refreshNewWeek() {
/* 452 */     if (this.db.weekMallItemNums == null) {
/* 453 */       this.db.weekMallItemNums = new HashMap<>();
/*     */     }
/*     */     
/* 456 */     this.db.weekMallItemNums.clear();
/* 457 */     this.db.weekMallExchangeItemNums.clear();
/* 458 */     this.db.resetTime = new Date();
/*     */   }
/*     */ 
/*     */   
/*     */   public void onLogin() {
/* 463 */     Date now = new Date();
/* 464 */     Date monday = ShopMallService.getInstance().getResetTime();
/* 465 */     if (now.getTime() > monday.getTime() && (this.db.resetTime == null || this.db.resetTime.getTime() < monday.getTime())) {
/* 466 */       refreshNewWeek();
/*     */     }
/*     */   }
/*     */   
/*     */   private final void seeTab(int itemType) {
/* 471 */     ShopMallConfigCO shopMallConfigCO = (ShopMallConfigCO)GameData.ShopMallConfigs.get(Integer.valueOf(itemType));
/* 472 */     if (shopMallConfigCO == null) {
/*     */       return;
/*     */     }
/* 475 */     if (this.db.seenTab.containsKey(Integer.valueOf(shopMallConfigCO.consumeType))) {
/* 476 */       Map<Integer, Boolean> node = (Map<Integer, Boolean>)this.db.seenTab.get(Integer.valueOf(shopMallConfigCO.consumeType));
/* 477 */       node.put(Integer.valueOf(itemType), Boolean.valueOf(true));
/*     */     } else {
/* 479 */       Map<Integer, Boolean> node = new HashMap<>();
/* 480 */       node.put(Integer.valueOf(itemType), Boolean.valueOf(true));
/* 481 */       this.db.seenTab.put(Integer.valueOf(shopMallConfigCO.consumeType), node);
/*     */     } 
/*     */   }
/*     */   
/*     */   private final void addSelfMallItemNum(String id, int count) {
/* 486 */     int num = 0;
/* 487 */     if (this.db.dayMallItemNums.containsKey(id)) {
/* 488 */       num = ((Integer)this.db.dayMallItemNums.get(id)).intValue();
/*     */     } else {
/* 490 */       this.db.dayMallItemNums.put(id, Integer.valueOf(num));
/*     */     } 
/* 492 */     num += count;
/* 493 */     this.db.dayMallItemNums.put(id, Integer.valueOf(num));
/*     */     
/* 495 */     int weekNum = 0;
/* 496 */     if (this.db.weekMallItemNums == null) {
/* 497 */       this.db.weekMallItemNums = new HashMap<>();
/*     */     }
/* 499 */     if (this.db.weekMallItemNums.containsKey(id)) {
/* 500 */       weekNum = ((Integer)this.db.weekMallItemNums.get(id)).intValue();
/*     */     } else {
/* 502 */       this.db.weekMallItemNums.put(id, Integer.valueOf(weekNum));
/*     */     } 
/* 504 */     weekNum += count;
/* 505 */     this.db.weekMallItemNums.put(id, Integer.valueOf(weekNum));
/*     */   }
/*     */   
/*     */   private final void addSelfMallExchangeItemNum(String id, int count) {
/* 509 */     int num = 0;
/* 510 */     if (this.db.dayMallExchangeItemNums.containsKey(id)) {
/* 511 */       num = ((Integer)this.db.dayMallExchangeItemNums.get(id)).intValue();
/*     */     } else {
/* 513 */       this.db.dayMallExchangeItemNums.put(id, Integer.valueOf(num));
/*     */     } 
/* 515 */     num += count;
/* 516 */     this.db.dayMallExchangeItemNums.put(id, Integer.valueOf(num));
/*     */     
/* 518 */     int weekNum = 0;
/* 519 */     if (this.db.weekMallExchangeItemNums.containsKey(id)) {
/* 520 */       weekNum = ((Integer)this.db.weekMallExchangeItemNums.get(id)).intValue();
/*     */     } else {
/* 522 */       this.db.weekMallExchangeItemNums.put(id, Integer.valueOf(weekNum));
/*     */     } 
/* 524 */     weekNum += count;
/* 525 */     this.db.weekMallExchangeItemNums.put(id, Integer.valueOf(weekNum));
/*     */     
/* 527 */     int totalNum = 0;
/* 528 */     if (this.db.totalMallExchangeItemNums.containsKey(id)) {
/* 529 */       totalNum = ((Integer)this.db.totalMallExchangeItemNums.get(id)).intValue();
/*     */     } else {
/* 531 */       this.db.totalMallExchangeItemNums.put(id, Integer.valueOf(totalNum));
/*     */     } 
/* 533 */     totalNum += count;
/* 534 */     this.db.totalMallExchangeItemNums.put(id, Integer.valueOf(totalNum));
/*     */   }
/*     */   
/*     */   private final int getSelfMallItemRemainNum(String id) {
/* 538 */     int useNum = 0;
/* 539 */     if (this.db.dayMallItemNums.containsKey(id)) {
/* 540 */       useNum = ((Integer)this.db.dayMallItemNums.get(id)).intValue();
/*     */     } else {
/* 542 */       this.db.dayMallItemNums.put(id, Integer.valueOf(useNum));
/*     */     } 
/*     */     
/* 545 */     ShopMallItemsExt mallItemProp = ShopMallConfig.getInstance().fingShowMallItemByID(id);
/*     */     
/* 547 */     int remainNum = -1;
/* 548 */     int dayTime = mallItemProp.buyTimes;
/* 549 */     int weekTime = mallItemProp.weekBuyTimes;
/*     */     
/* 551 */     if (dayTime > 0) {
/* 552 */       int vip = this.player.baseDataManager.getVip();
/* 553 */       int add = 0;
/* 554 */       if (vip > 0) {
/* 555 */         add = ((CardCO)GameData.Cards.get(Integer.valueOf(vip))).prv7;
/*     */       }
/* 557 */       remainNum = mallItemProp.buyTimes + add - useNum;
/* 558 */       remainNum = (remainNum >= 0) ? remainNum : 0;
/*     */     } 
/*     */     
/* 561 */     if (weekTime > 0) {
/* 562 */       useNum = 0;
/* 563 */       if (this.db.weekMallItemNums.containsKey(id)) {
/* 564 */         useNum = ((Integer)this.db.weekMallItemNums.get(id)).intValue();
/*     */       } else {
/* 566 */         this.db.weekMallItemNums.put(id, Integer.valueOf(useNum));
/*     */       } 
/* 568 */       remainNum = mallItemProp.weekBuyTimes - useNum;
/* 569 */       remainNum = (remainNum > 0) ? remainNum : 0;
/*     */     } 
/*     */     
/* 572 */     return remainNum;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final int getSelfMallExchangeItemRemainNum(String id) {
/* 579 */     ExchangeMallExt exchangeMallExt = ShopMallConfig.getInstance().findExchangeMallItemByID(id);
/*     */     
/* 581 */     int remainNum = -1;
/*     */     
/* 583 */     int dayTime = exchangeMallExt.exchangeTimes;
/* 584 */     int weekTime = exchangeMallExt.weekExchangeTimes;
/* 585 */     int totalTime = exchangeMallExt.totalTimes;
/*     */ 
/*     */     
/* 588 */     if (dayTime > 0) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 595 */       int dayUseNum = 0;
/* 596 */       if (this.db.dayMallExchangeItemNums.containsKey(id)) {
/* 597 */         dayUseNum = ((Integer)this.db.dayMallExchangeItemNums.get(id)).intValue();
/*     */       } else {
/* 599 */         this.db.dayMallExchangeItemNums.put(id, Integer.valueOf(dayUseNum));
/*     */       } 
/*     */       
/* 602 */       remainNum = exchangeMallExt.exchangeTimes - dayUseNum;
/* 603 */       remainNum = (remainNum >= 0) ? remainNum : 0;
/*     */     } 
/*     */     
/* 606 */     if (weekTime > 0) {
/* 607 */       int weekUseNum = 0;
/* 608 */       if (this.db.weekMallExchangeItemNums.containsKey(id)) {
/* 609 */         weekUseNum = ((Integer)this.db.weekMallExchangeItemNums.get(id)).intValue();
/*     */       } else {
/* 611 */         this.db.weekMallExchangeItemNums.put(id, Integer.valueOf(weekUseNum));
/*     */       } 
/*     */       
/* 614 */       remainNum = exchangeMallExt.weekExchangeTimes - weekUseNum;
/* 615 */       remainNum = (remainNum > 0) ? remainNum : 0;
/*     */     } 
/*     */     
/* 618 */     if (totalTime > 0) {
/* 619 */       int weekUseNum = 0;
/* 620 */       if (this.db.totalMallExchangeItemNums.containsKey(id)) {
/* 621 */         weekUseNum = ((Integer)this.db.totalMallExchangeItemNums.get(id)).intValue();
/*     */       } else {
/* 623 */         this.db.totalMallExchangeItemNums.put(id, Integer.valueOf(weekUseNum));
/*     */       } 
/*     */       
/* 626 */       remainNum = exchangeMallExt.totalTimes - weekUseNum;
/* 627 */       remainNum = (remainNum > 0) ? remainNum : 0;
/*     */     } 
/*     */     
/* 630 */     return remainNum;
/*     */   }
/*     */   
/*     */   private final boolean isValidOfMallTab(int itemType) {
/* 634 */     boolean result = isOpenOfMallTab(itemType);
/* 635 */     if (!result) {
/* 636 */       return false;
/*     */     }
/* 638 */     if ((itemType == Const.SHOP_MALL_ITEM_TYPE.DIAMOND_LIMIT.getValue() || itemType == Const.SHOP_MALL_ITEM_TYPE.TICKET_LIMIT.getValue() || itemType == Const.SHOP_MALL_ITEM_TYPE.ITEM_LIMIT.getValue()) && 
/* 639 */       !isValidOfMallLimitItemTab(itemType)) {
/* 640 */       return false;
/*     */     }
/*     */     
/* 643 */     return true;
/*     */   }
/*     */   
/*     */   public final boolean isOpenOfMallTab(int itemType) {
/* 647 */     ShopMallConfigCO shopMallConfigCO = (ShopMallConfigCO)GameData.ShopMallConfigs.get(Integer.valueOf(itemType));
/* 648 */     if (shopMallConfigCO == null) {
/* 649 */       return false;
/*     */     }
/*     */     
/* 652 */     if (shopMallConfigCO.isOpened == 0 && !GWorld.DEBUG) {
/* 653 */       return false;
/*     */     }
/* 655 */     return true;
/*     */   }
/*     */   
/*     */   private final boolean isValidOfMallLimitItemTab(int itemType) {
/* 659 */     Date now = new Date();
/* 660 */     Calendar c = Calendar.getInstance();
/* 661 */     c.setTime(now);
/* 662 */     int nowHour = c.get(11);
/* 663 */     ShopMallConfigCO shopMallConfigCO = (ShopMallConfigCO)GameData.ShopMallConfigs.get(Integer.valueOf(itemType));
/* 664 */     if (shopMallConfigCO == null) {
/* 665 */       return false;
/*     */     }
/* 667 */     if (shopMallConfigCO.consumeType == Const.SHOP_MALL_CONSUME_TYPE.DIAMOND.getValue() && itemType == Const.SHOP_MALL_ITEM_TYPE.DIAMOND_LIMIT.getValue()) {
/* 668 */       int onSaleTime = GlobalConfig.Shop_OnSaleTime_Diamond;
/* 669 */       int shelfTime = GlobalConfig.Shop_ShelfTime_Diamond;
/* 670 */       if (nowHour < onSaleTime || nowHour >= shelfTime) {
/* 671 */         return false;
/*     */       }
/* 673 */     } else if (shopMallConfigCO.consumeType == Const.SHOP_MALL_CONSUME_TYPE.TICKET.getValue() && itemType == Const.SHOP_MALL_ITEM_TYPE.TICKET_LIMIT.getValue()) {
/* 674 */       int onSaleTime = GlobalConfig.Shop_OnSaleTime_Ticket;
/* 675 */       int shelfTime = GlobalConfig.Shop_ShelfTime_Ticket;
/* 676 */       if (nowHour < onSaleTime || nowHour >= shelfTime) {
/* 677 */         return false;
/*     */       }
/* 679 */     } else if (shopMallConfigCO.consumeType == Const.SHOP_MALL_CONSUME_TYPE.ITEMCHANGE.getValue() && itemType == Const.SHOP_MALL_ITEM_TYPE.ITEM_LIMIT.getValue()) {
/* 680 */       int onSaleTime = GlobalConfig.Shop_OnSaleTime_Exchange;
/* 681 */       int shelfTime = GlobalConfig.Shop_ShelfTime_Exchange;
/* 682 */       if (nowHour < onSaleTime || nowHour >= shelfTime) {
/* 683 */         return false;
/*     */       }
/*     */     } 
/* 686 */     return true;
/*     */   }
/*     */   
/*     */   public final List<PlayerHandler.SuperScriptType> getSuperScript() {
/* 690 */     List<PlayerHandler.SuperScriptType> list = new ArrayList<>();
/* 691 */     PlayerHandler.SuperScriptType.Builder script = PlayerHandler.SuperScriptType.newBuilder();
/* 692 */     script.setType(Const.SUPERSCRIPT_TYPE.SHOPMALL.getValue());
/* 693 */     script.setNumber(0);
/*     */ 
/*     */     
/* 696 */     if (this.player.functionOpenManager.isOpen(Const.FunctionType.MALL.getValue())) {
/* 697 */       script.setNumber(getSuperScriptAllNum());
/*     */     }
/* 699 */     list.add(script.build());
/* 700 */     return list;
/*     */   }
/*     */   
/*     */   private final int getSuperScriptAllNum() {
/* 704 */     int result = 0;
/* 705 */     for (ShopMallConfigCO shopMallTabsProp : GameData.ShopMallConfigs.values()) {
/* 706 */       int moneyType = shopMallTabsProp.consumeType;
/* 707 */       int itemType = shopMallTabsProp.itemType;
/* 708 */       if (shopMallTabsProp.isOpened == 1) {
/* 709 */         int num = getSuperScriptNum(itemType);
/* 710 */         if (num > 0) {
/* 711 */           result = num;
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     } 
/* 716 */     return result;
/*     */   }
/*     */   
/*     */   private final int getSuperScriptNum(int itemType) {
/* 720 */     int result = 0;
/* 721 */     if (itemType != Const.SHOP_MALL_ITEM_TYPE.DIAMOND_LIMIT.getValue() && itemType != Const.SHOP_MALL_ITEM_TYPE.TICKET_LIMIT.getValue()) {
/*     */ 
/*     */       
/* 724 */       List<ShopMallItemsExt> mallItems = GameData.findShopMallItemss(t -> (t.itemType == itemType));
/* 725 */       for (ShopMallItemsExt mallItem : mallItems) {
/* 726 */         if (mallItem.serveLimit == Const.SHOP_MALL_SERVER_LIMIT.SELF.getValue());
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 746 */     return result;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\shopMall\ShopMallManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */