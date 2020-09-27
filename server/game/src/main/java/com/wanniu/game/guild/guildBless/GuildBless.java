/*     */ package com.wanniu.game.guild.guildBless;
/*     */ 
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.util.DateUtil;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.Utils;
/*     */ import com.wanniu.game.data.BlessItemCO;
/*     */ import com.wanniu.game.data.GShopCO;
/*     */ import com.wanniu.game.data.GameData;
/*     */ import com.wanniu.game.data.GuildBuildingCO;
/*     */ import com.wanniu.game.data.base.DItemEquipBase;
/*     */ import com.wanniu.game.data.ext.BlessLevelExt;
/*     */ import com.wanniu.game.data.ext.BlesslibaoExt;
/*     */ import com.wanniu.game.data.ext.GShopExt;
/*     */ import com.wanniu.game.data.ext.GuildSettingExt;
/*     */ import com.wanniu.game.guild.GuildCommonUtil;
/*     */ import com.wanniu.game.guild.GuildMsg;
/*     */ import com.wanniu.game.guild.GuildRandomItem;
/*     */ import com.wanniu.game.guild.GuildResult;
/*     */ import com.wanniu.game.guild.GuildService;
/*     */ import com.wanniu.game.guild.GuildUtil;
/*     */ import com.wanniu.game.guild.RecordInfo;
/*     */ import com.wanniu.game.guild.RoleInfo;
/*     */ import com.wanniu.game.guild.guidDepot.GuildRecordData;
/*     */ import com.wanniu.game.guild.guildTech.GuildTech;
/*     */ import com.wanniu.game.guild.guildTech.GuildTechData;
/*     */ import com.wanniu.game.guild.po.GuildBlessPO;
/*     */ import com.wanniu.game.item.ItemUtil;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import io.netty.util.internal.StringUtil;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import pomelo.guild.GuildManagerHandler;
/*     */ import pomelo.item.ItemOuterClass;
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
/*     */ public class GuildBless
/*     */ {
/*     */   public GuildBlessPO blessData;
/*     */   public String id;
/*     */   public int logicServerId;
/*     */   public int level;
/*     */   public Date createTime;
/*     */   public int blessValue;
/*     */   public int blessValueMax;
/*     */   public ArrayList<GuildRecordData> news;
/*     */   public Date refreshTime;
/*     */   public Map<Integer, GuildBlessPO.GuildBlessItem> blessItems;
/*     */   public Map<Const.PlayerBtlData, Integer> bufsAttr;
/*     */   public int blessLevel;
/*     */   public ArrayList<Integer> goods;
/*     */   public GuildTechData techData;
/*     */   public int throwAwardState;
/*     */   public GuildTech tech;
/*     */   public List<Map<String, Integer>> giftLs;
/*  67 */   public float[] blessProcess = new float[] { 0.3F, 0.6F, 1.0F };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int randIndexByWeight(List<GuildRandomItem> objArr, String weightKey) {
/*  77 */     if (objArr.size() == 0) {
/*  78 */       return -1;
/*     */     }
/*  80 */     String key = "weight";
/*  81 */     if (!StringUtil.isNullOrEmpty(weightKey)) {
/*  82 */       key = weightKey;
/*     */     }
/*     */ 
/*     */     
/*  86 */     int totalWeight = 0;
/*  87 */     for (int i = 0; i < objArr.size(); i++) {
/*  88 */       GuildRandomItem randomItem = objArr.get(i);
/*  89 */       if (null != randomItem)
/*     */       {
/*  91 */         totalWeight += randomItem.getPropertyValue(key);
/*     */       }
/*     */     } 
/*  94 */     int randNum = Utils.random(1, totalWeight);
/*  95 */     int totalNum = 0;
/*  96 */     for (int j = 0; j < objArr.size(); j++) {
/*  97 */       GuildRandomItem randomItem = objArr.get(j);
/*  98 */       if (null != randomItem) {
/*     */         
/* 100 */         totalNum += randomItem.getPropertyValue(key);
/* 101 */         if (randNum <= totalNum)
/* 102 */           return j; 
/*     */       } 
/*     */     } 
/* 105 */     return -1;
/*     */   }
/*     */ 
/*     */   
/*     */   public <T> ArrayList<T> randomSomeFromArray(List<T> buffList, int num) {
/* 110 */     ArrayList<T> resultArray = new ArrayList<>();
/* 111 */     if (null == buffList) {
/* 112 */       return resultArray;
/*     */     }
/*     */     
/* 115 */     ArrayList<T> cacheArr = new ArrayList<>();
/* 116 */     for (int i = 0; i < buffList.size(); i++) {
/* 117 */       cacheArr.add(buffList.get(i));
/*     */     }
/*     */     
/* 120 */     int randCount = (num <= cacheArr.size()) ? num : cacheArr.size();
/* 121 */     for (int j = 0; j < randCount; j++) {
/* 122 */       int index = Utils.random(0, cacheArr.size() - 1);
/* 123 */       resultArray.add(cacheArr.get(index));
/* 124 */       cacheArr.remove(index);
/*     */     } 
/* 126 */     return resultArray;
/*     */   }
/*     */ 
/*     */   
/*     */   public Map<String, Integer> randomSomeFromMap(Map<String, Integer> buffMap, int num) {
/* 131 */     Map<String, Integer> _map = new HashMap<>();
/* 132 */     ArrayList<String> cacheArr = new ArrayList<>();
/* 133 */     for (String key : buffMap.keySet()) {
/* 134 */       cacheArr.add(key);
/*     */     }
/*     */     
/* 137 */     int randCount = (num <= cacheArr.size()) ? num : cacheArr.size();
/* 138 */     for (int i = 0; i < randCount; i++) {
/* 139 */       int index = Utils.random(0, cacheArr.size() - 1);
/* 140 */       String key = cacheArr.get(index);
/* 141 */       _map.put(key, buffMap.get(key));
/* 142 */       cacheArr.remove(index);
/*     */     } 
/*     */     
/* 145 */     return _map;
/*     */   }
/*     */   
/*     */   public GuildBless(GuildBlessPO blessData, int logicServerId) {
/* 149 */     this();
/* 150 */     this.blessData = blessData;
/* 151 */     this.id = blessData.id;
/* 152 */     this.logicServerId = blessData.logicServerId;
/* 153 */     this.level = blessData.level;
/* 154 */     this.createTime = blessData.createTime;
/*     */ 
/*     */     
/* 157 */     GuildBlessPO.GuildBlessAllBlob blobData = blessData.allBlobData;
/* 158 */     this.blessValue = blobData.blessValue;
/* 159 */     this.blessValueMax = blobData.blessValueMax;
/* 160 */     this.news = blobData.news;
/* 161 */     this.refreshTime = blobData.refreshTime;
/* 162 */     this.blessItems = blobData.blessItems;
/* 163 */     this.blessLevel = blobData.blessLevel;
/* 164 */     this.giftLs = blessData.gifts;
/* 165 */     refreshBlessProcess();
/*     */ 
/*     */     
/* 168 */     this.goods = blobData.goods;
/* 169 */     if (null != this.goods && this.goods.size() == 0) {
/* 170 */       randomShopGoods();
/*     */     }
/*     */     
/* 173 */     if (null == blobData.techData) {
/* 174 */       this.tech = new GuildTech(this.id);
/*     */     } else {
/* 176 */       this.tech = new GuildTech(blobData.techData);
/*     */     } 
/*     */   }
/*     */   
/*     */   public GuildBless() {
/* 181 */     this.giftLs = new ArrayList<>();
/* 182 */     this.blessItems = new HashMap<>();
/* 183 */     this.blessData = new GuildBlessPO();
/* 184 */     resetBlessAwardState();
/*     */   }
/*     */   
/*     */   public GuildBless(String guildId, int logicServerId) {
/* 188 */     this();
/* 189 */     createDefaultBless(guildId, logicServerId);
/*     */   }
/*     */   
/*     */   public void resetBlessAwardState() {
/* 193 */     for (int i = 0; i < this.blessData.allBlobData.finishStateArr.length; i++) {
/* 194 */       this.blessData.allBlobData.finishStateArr[i] = Const.EVENT_GIFT_STATE.NOT_RECEIVE.getValue();
/*     */     }
/*     */   }
/*     */   
/*     */   public void createDefaultBless(String guildId, int logicServerId) {
/* 199 */     GuildBuildingCO buildProp = GuildUtil.getGuildBuildingProp(Const.GuildBuilding.BLESS.getValue());
/* 200 */     this.id = guildId;
/* 201 */     this.logicServerId = logicServerId;
/* 202 */     this.level = buildProp.minLv;
/* 203 */     this.createTime = new Date();
/*     */     
/* 205 */     this.blessValue = 0;
/* 206 */     this.blessValueMax = 0;
/* 207 */     this.refreshTime = new Date();
/* 208 */     this.blessData.allBlobData.refreshTime = this.refreshTime;
/* 209 */     this.news = new ArrayList<>();
/* 210 */     this.blessItems = new HashMap<>();
/* 211 */     this.blessLevel = this.level;
/* 212 */     resetBlessAwardState();
/* 213 */     randomBlessItemAndProcess();
/*     */     
/* 215 */     randomShopGoods();
/*     */     
/* 217 */     this.tech = new GuildTech(guildId);
/*     */   }
/*     */   
/*     */   public void refreshBlessProcess() {
/* 221 */     this.blessValueMax = 0;
/* 222 */     if (null == this.blessItems) {
/*     */       return;
/*     */     }
/* 225 */     for (GuildBlessPO.GuildBlessItem item : this.blessItems.values()) {
/* 226 */       this.blessValueMax += item.needNum;
/*     */     }
/*     */   }
/*     */   
/*     */   public GuildBlessPO toJson4Serialize() {
/* 231 */     GuildBlessPO data = new GuildBlessPO();
/* 232 */     data.id = this.id;
/* 233 */     data.logicServerId = this.logicServerId;
/* 234 */     data.level = this.level;
/* 235 */     data.createTime = this.createTime;
/*     */     
/* 237 */     GuildBlessPO.GuildBlessAllBlob blobData = new GuildBlessPO.GuildBlessAllBlob();
/* 238 */     blobData.blessValue = this.blessValue;
/* 239 */     blobData.blessValueMax = this.blessValueMax;
/* 240 */     blobData.news = this.news;
/* 241 */     blobData.refreshTime = this.refreshTime;
/* 242 */     blobData.blessItems = this.blessItems;
/* 243 */     blobData.blessLevel = this.blessLevel;
/* 244 */     blobData.finishStateArr = this.blessData.allBlobData.finishStateArr;
/*     */     
/* 246 */     blobData.goods = this.goods;
/*     */     
/* 248 */     blobData.techData = this.tech.toJson4Serialize();
/*     */     
/* 250 */     data.allBlobData = blobData;
/* 251 */     data.gifts = this.giftLs;
/* 252 */     return data;
/*     */   }
/*     */   
/*     */   public void randomBlessItemAndProcess() {
/* 256 */     randomBlessItem();
/*     */     
/* 258 */     this.blessValue = 0;
/* 259 */     refreshBlessProcess();
/*     */   }
/*     */   
/*     */   public void randomBlessItem() {
/* 263 */     BlessLevelExt levelProp = GuildUtil.getBlessPropByLevel(this.level);
/* 264 */     List<BlessItemCO> itemPropList = GuildUtil.getBlessItemListByLevel(this.level);
/* 265 */     int kindNum = (levelProp.itemKind < itemPropList.size()) ? levelProp.itemKind : itemPropList.size();
/*     */     
/* 267 */     List<GuildRandomItem> baseItems = new ArrayList<>();
/* 268 */     Map<Integer, GuildBlessPO.GuildBlessItem> resultItems = new HashMap<>(); int i;
/* 269 */     for (i = 0; i < itemPropList.size(); i++) {
/* 270 */       BlessItemCO prop = itemPropList.get(i);
/* 271 */       GuildRandomItem randomItem = new GuildRandomItem();
/* 272 */       randomItem.id = prop.iD;
/* 273 */       randomItem.weight = prop.pro;
/* 274 */       randomItem.minNum = Math.min(prop.minNeed, prop.maxNeed);
/* 275 */       randomItem.maxNum = Math.max(prop.minNeed, prop.maxNeed);
/* 276 */       baseItems.add(randomItem);
/*     */     } 
/*     */     
/* 279 */     for (i = 0; i < kindNum; i++) {
/* 280 */       int index = randIndexByWeight(baseItems, null);
/* 281 */       if (-1 == index) {
/*     */         break;
/*     */       }
/*     */       
/* 285 */       GuildRandomItem itemMap = baseItems.get(index);
/*     */       
/* 287 */       if (null != itemMap) {
/* 288 */         int minX = itemMap.minNum;
/* 289 */         int maxX = itemMap.maxNum;
/* 290 */         int needNum = Utils.random(minX, maxX);
/* 291 */         GuildBlessPO.GuildBlessItem blessItem = new GuildBlessPO.GuildBlessItem();
/* 292 */         blessItem.id = itemMap.id;
/* 293 */         blessItem.finishNum = 0;
/* 294 */         blessItem.needNum = needNum;
/* 295 */         resultItems.put(Integer.valueOf(blessItem.id), blessItem);
/* 296 */         baseItems.remove(index);
/*     */       } 
/*     */     } 
/*     */     
/* 300 */     this.blessItems = resultItems;
/*     */     
/* 302 */     this.blessLevel = this.level;
/*     */     
/* 304 */     BlesslibaoExt giftProp = (BlesslibaoExt)GameData.Blesslibaos.get(Integer.valueOf(this.level));
/* 305 */     this.giftLs.clear();
/*     */     
/* 307 */     this.giftLs.add(randomSomeFromMap(giftProp.itemCode30, giftProp.blessBuffNum));
/* 308 */     this.giftLs.add(randomSomeFromMap(giftProp.itemCode60, giftProp.blessBuffNum));
/* 309 */     this.giftLs.add(randomSomeFromMap(giftProp.itemCode100, giftProp.blessBuffNum));
/* 310 */     this.blessData.gifts = this.giftLs;
/*     */   }
/*     */ 
/*     */   
/*     */   public void randomShopGoods() {
/* 315 */     List<GShopExt> itemPropList = GuildUtil.getShopPropList();
/* 316 */     List<GuildRandomItem> baseItems = new ArrayList<>();
/* 317 */     for (int i = 0; i < itemPropList.size(); i++) {
/* 318 */       GShopCO prop = (GShopCO)itemPropList.get(i);
/* 319 */       GuildRandomItem item = new GuildRandomItem();
/* 320 */       item.id = prop.itemID;
/* 321 */       item.weight = prop.pro;
/* 322 */       baseItems.add(item);
/*     */     } 
/*     */     
/* 325 */     ArrayList<Integer> goodsIdArray = new ArrayList<>();
/* 326 */     for (int j = 0; j < 8; j++) {
/* 327 */       int index = randIndexByWeight(baseItems, null);
/* 328 */       if (index == -1) {
/*     */         break;
/*     */       }
/* 331 */       goodsIdArray.add(Integer.valueOf(((GuildRandomItem)baseItems.get(index)).id));
/* 332 */       baseItems.remove(index);
/*     */     } 
/*     */     
/* 335 */     goodsIdArray.sort((a, b) -> a.intValue() - b.intValue());
/*     */ 
/*     */     
/* 338 */     this.goods = goodsIdArray;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int[] calFinishState() {
/* 347 */     if (this.blessProcess.length != this.blessData.allBlobData.finishStateArr.length) {
/* 348 */       Out.error(new Object[] { "blessProcess.length != this.finishStateArr.length" });
/* 349 */       return null;
/*     */     } 
/*     */     
/* 352 */     for (int i = 0; i < this.blessData.allBlobData.finishStateArr.length; i++) {
/* 353 */       if (Const.EVENT_GIFT_STATE.NOT_RECEIVE.getValue() == this.blessData.allBlobData.finishStateArr[i] && 
/* 354 */         this.blessValue >= Math.floor((this.blessValueMax * this.blessProcess[i]))) {
/* 355 */         this.blessData.allBlobData.finishStateArr[i] = Const.EVENT_GIFT_STATE.CAN_RECEIVE.getValue();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 360 */     return this.blessData.allBlobData.finishStateArr;
/*     */   }
/*     */   
/*     */   public void checkRefreshNewDay(boolean isPush) {
/* 364 */     randomBlessItemAndProcess();
/* 365 */     randomShopGoods();
/* 366 */     this.tech.refreshNewDay(false);
/* 367 */     this.refreshTime = new Date();
/* 368 */     resetBlessAwardState();
/* 369 */     if (isPush) {
/* 370 */       GuildMsg.TechRefreshGuildMsg msgData = new GuildMsg.TechRefreshGuildMsg();
/* 371 */       msgData.techData.blobData.products = this.tech.products;
/* 372 */       GuildMsg msg = new GuildMsg(Const.NotifyType.BLESS_NEW_DAY_PUSH.getValue(), (GuildMsg.GuildMsgData)msgData);
/* 373 */       GuildService.notifyAllMemberRefreshGuild(this.id, msg, null);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addRecord(GuildRecordData record) {
/* 378 */     record.time = new Date();
/* 379 */     GuildSettingExt settingProp = GuildUtil.getGuildSettingExtProp();
/* 380 */     this.news.add(0, record);
/* 381 */     int len = this.news.size();
/* 382 */     if (len > settingProp.recording) {
/* 383 */       this.news.remove(len - 1);
/*     */     }
/* 385 */     saveToRedis();
/*     */   }
/*     */   
/*     */   public void saveToRedis() {
/* 389 */     GuildBlessPO data = toJson4Serialize();
/* 390 */     GuildUtil.updateGuildBless(data);
/*     */   }
/*     */   
/*     */   public void saveToMysql() {
/* 394 */     saveToRedis();
/*     */   }
/*     */   
/*     */   public GuildResult.GuildGiftAndBuffData getGiftAndBuffInfo(int index) {
/* 398 */     GuildResult.GuildGiftAndBuffData data = new GuildResult.GuildGiftAndBuffData();
/* 399 */     Map<String, Integer> giftMap = this.giftLs.get(index);
/* 400 */     if (null != giftMap) {
/* 401 */       data.itemCode = giftMap;
/*     */     }
/* 403 */     return data;
/*     */   }
/*     */   
/*     */   public GuildManagerHandler.GuildBlessInfo toJson4PayLoad() {
/* 407 */     BlessLevelExt levelProp = GuildUtil.getBlessPropByLevel(this.blessLevel);
/* 408 */     GuildManagerHandler.GuildBlessInfo.Builder data = GuildManagerHandler.GuildBlessInfo.newBuilder();
/* 409 */     data.setLevel(this.level);
/* 410 */     data.setBlessValue(this.blessValue);
/* 411 */     data.setBlessValueMax(this.blessValueMax);
/* 412 */     data.addAllFinishState(GuildCommonUtil.toList(this.blessData.allBlobData.finishStateArr));
/* 413 */     data.setBlessCountMax(levelProp.blessTime);
/*     */ 
/*     */     
/* 416 */     for (GuildBlessPO.GuildBlessItem item : this.blessItems.values()) {
/* 417 */       GuildManagerHandler.BlessItem.Builder tempInfo = GuildManagerHandler.BlessItem.newBuilder();
/* 418 */       BlessItemCO prop = GuildUtil.getBlessItemById(item.id);
/* 419 */       tempInfo.setId(item.id);
/* 420 */       ItemOuterClass.MiniItem.Builder tmpItem = ItemUtil.getMiniItemData(prop.itemID, item.needNum);
/* 421 */       if (null != tmpItem) {
/* 422 */         tempInfo.setItem(tmpItem);
/*     */       } else {
/* 424 */         Out.error(new Object[] { "GuildBless toJson4PayLoad config is null:", prop.itemID });
/*     */       } 
/* 426 */       tempInfo.setFinishNum(item.finishNum);
/* 427 */       data.addItemList(tempInfo);
/*     */     } 
/*     */     
/* 430 */     return data.build();
/*     */   }
/*     */   
/*     */   public List<RecordInfo> getRecordList(int page) {
/* 434 */     List<RecordInfo> list = new ArrayList<>();
/* 435 */     int perPageNum = 50;
/* 436 */     int startIndex = (page - 1) * perPageNum;
/* 437 */     int endIndex = startIndex + perPageNum;
/* 438 */     for (int i = startIndex; i < this.news.size() && i < endIndex; i++) {
/* 439 */       GuildRecordData record = this.news.get(i);
/* 440 */       RecordInfo tempInfo = new RecordInfo();
/* 441 */       tempInfo.time = DateUtil.format(record.time, "MM-dd HH:mm:ss");
/* 442 */       if (null != record.role1 && record.role1.pro > 0) {
/* 443 */         RoleInfo info1 = new RoleInfo();
/* 444 */         info1.pro = record.role1.pro;
/* 445 */         info1.name = record.role1.name;
/* 446 */         tempInfo.role1 = info1;
/*     */       } 
/* 448 */       if (null != record.role2 && record.role2.pro > 0) {
/* 449 */         RoleInfo info2 = new RoleInfo();
/* 450 */         info2.pro = record.role2.pro;
/* 451 */         info2.name = record.role2.name;
/* 452 */         tempInfo.role1 = info2;
/*     */       } 
/*     */       
/* 455 */       tempInfo.resultNum = record.result.v1;
/* 456 */       if (!StringUtil.isNullOrEmpty(record.result.v2)) {
/* 457 */         tempInfo.resultStr = record.result.v2;
/*     */       }
/*     */       
/* 460 */       if (null != record.item && !StringUtil.isNullOrEmpty(record.item.name)) {
/* 461 */         tempInfo.item = record.item;
/*     */       }
/*     */       
/* 464 */       tempInfo.recordType = record.type;
/* 465 */       list.add(tempInfo);
/*     */     } 
/* 467 */     return list;
/*     */   }
/*     */   
/*     */   public boolean isTodayValidBlessId(int id) {
/* 471 */     GuildBlessPO.GuildBlessItem blessItem = this.blessItems.get(Integer.valueOf(id));
/* 472 */     if (null == blessItem || blessItem.needNum <= 0) {
/* 473 */       return false;
/*     */     }
/* 475 */     return true;
/*     */   }
/*     */   
/*     */   public boolean isChange(int[] oldState, int[] newState) {
/* 479 */     boolean isChange = false;
/* 480 */     for (int i = 0; i < oldState.length; i++) {
/* 481 */       if (Const.EVENT_GIFT_STATE.NOT_RECEIVE.getValue() == oldState[i] && oldState[i] != newState[i]) {
/* 482 */         isChange = true;
/*     */       }
/*     */     } 
/* 485 */     return isChange;
/*     */   }
/*     */   
/*     */   public GuildResult blessAction(int id, int times, WNPlayer player) {
/* 489 */     GuildResult ret = new GuildResult();
/* 490 */     int[] oldState = new int[3];
/* 491 */     for (int i = 0; i < this.blessData.allBlobData.finishStateArr.length; i++) {
/* 492 */       oldState[i] = this.blessData.allBlobData.finishStateArr[i];
/*     */     }
/*     */     
/* 495 */     ((GuildBlessPO.GuildBlessItem)this.blessItems.get(Integer.valueOf(id))).finishNum += times;
/* 496 */     this.blessValue += times;
/*     */     
/* 498 */     int[] newState = calFinishState();
/*     */     
/* 500 */     if (isChange(oldState, newState)) {
/* 501 */       GuildMsg.BlessRefreshGuildMsg msgData = new GuildMsg.BlessRefreshGuildMsg();
/* 502 */       msgData.blessValue = this.blessValue;
/* 503 */       msgData.finishStateArr = newState;
/* 504 */       GuildMsg msg = new GuildMsg(Const.NotifyType.BLESS_FINISH_PUSH.getValue(), (GuildMsg.GuildMsgData)msgData);
/* 505 */       GuildService.notifyAllMemberRefreshGuild(this.id, msg, player.getId());
/*     */     } 
/*     */     
/* 508 */     BlessItemCO blessItemProp = GuildUtil.getBlessItemById(id);
/* 509 */     DItemEquipBase itemProp = ItemUtil.getPropByCode(blessItemProp.itemID);
/*     */     
/* 511 */     GuildRecordData record = new GuildRecordData();
/* 512 */     record.type = Const.GuildRecord.BLESS_USE_ITEM.getValue();
/* 513 */     record.role1.pro = player.getPro();
/* 514 */     record.role1.name = player.getName();
/* 515 */     record.result.v2 = Integer.toString(times);
/* 516 */     record.item.qColor = itemProp.qcolor;
/* 517 */     record.item.name = itemProp.name;
/* 518 */     addRecord(record);
/*     */     
/* 520 */     GuildResult.GuildBlessActionData data = new GuildResult.GuildBlessActionData();
/* 521 */     data.blessValue = this.blessValue;
/* 522 */     data.id = id;
/* 523 */     data.finishNum = ((GuildBlessPO.GuildBlessItem)this.blessItems.get(Integer.valueOf(id))).finishNum;
/* 524 */     data.finishState = newState;
/*     */ 
/*     */     
/* 527 */     BlessLevelExt levelProp = GuildUtil.getBlessPropByLevel(this.level);
/* 528 */     data.buffTime = levelProp.bufftime * 60;
/* 529 */     data.buffIds = randomSomeFromArray(levelProp.buffList, levelProp.blessBuffNum);
/* 530 */     ret.result = 0;
/* 531 */     ret.data = (GuildResult.GuildResultData)data;
/* 532 */     return ret;
/*     */   }
/*     */   
/*     */   public void upgradeLevel(String playerId) {
/* 536 */     this.level++;
/* 537 */     saveToRedis();
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\guild\guildBless\GuildBless.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */