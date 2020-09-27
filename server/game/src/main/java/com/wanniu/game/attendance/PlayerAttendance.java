/*     */ package com.wanniu.game.attendance;
/*     */ 
/*     */ import com.google.protobuf.GeneratedMessage;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.util.DateUtil;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.data.ext.AccumulateExt;
/*     */ import com.wanniu.game.data.ext.LuxurySignExt;
/*     */ import com.wanniu.game.data.ext.NormalSignExt;
/*     */ import com.wanniu.game.item.ItemUtil;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.poes.AttendancePO;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import pomelo.area.AttendanceHandler;
/*     */ import pomelo.area.PlayerHandler;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PlayerAttendance
/*     */ {
/*     */   public WNPlayer player;
/*     */   public AttendancePO attDb;
/*     */   
/*     */   public enum GiftState
/*     */   {
/*  42 */     NO_RECEIVE(0), CAN_RECEIVE(1), RECEIVED(2), VIP_NOT_RECEIVE(3);
/*     */     
/*     */     private int value;
/*     */     
/*     */     GiftState(int value) {
/*  47 */       this.value = value;
/*     */     }
/*     */     
/*     */     public int getValue() {
/*  51 */       return this.value;
/*     */     }
/*     */   }
/*     */   
/*     */   public class DailySignInfo
/*     */   {
/*     */     public int id;
/*     */     public int boxIcon;
/*     */     public ItemOuterClass.MiniItem.Builder[] items;
/*     */     public int vipDoubleLevel;
/*     */     public int state;
/*     */     
/*     */     public final ItemOuterClass.MiniItem[] getMiniItems() {
/*  64 */       if (this.items != null) {
/*  65 */         ItemOuterClass.MiniItem[] itemList = new ItemOuterClass.MiniItem[this.items.length];
/*  66 */         for (int i = 0; i < itemList.length; i++) {
/*  67 */           ItemOuterClass.MiniItem.Builder miniItem = ItemUtil.getMiniItemData(this.items[i].getCode(), this.items[i].getGroupCount());
/*  68 */           if (null == miniItem) {
/*  69 */             Out.error(new Object[] { getClass(), "->[", this.items[i].getCode(), "] is not found" });
/*     */           } else {
/*     */             
/*  72 */             itemList[i] = miniItem.build();
/*     */           } 
/*  74 */         }  return itemList;
/*     */       } 
/*  76 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     public final AttendanceHandler.DailyInfo getDailyInfo() {
/*  81 */       AttendanceHandler.DailyInfo.Builder builder = AttendanceHandler.DailyInfo.newBuilder();
/*  82 */       builder.setId(this.id);
/*  83 */       builder.setVipDoubleLevel(this.vipDoubleLevel);
/*  84 */       builder.setState(this.state);
/*  85 */       ItemOuterClass.MiniItem[] itemList = getMiniItems();
/*  86 */       if (itemList != null && itemList.length > 0 && 
/*  87 */         null != itemList[0]) {
/*  88 */         builder.setItemList(itemList[0]);
/*     */       }
/*     */       
/*  91 */       return builder.build();
/*     */     }
/*     */   }
/*     */   
/*     */   public class CumulativeSignInfo
/*     */   {
/*     */     public int id;
/*     */     public String boxIcon;
/*     */     public ItemOuterClass.MiniItem.Builder[] items;
/*     */     public int needCountDay;
/*     */     public int state;
/*     */     
/*     */     public final ItemOuterClass.MiniItem[] getMiniItems() {
/* 104 */       if (this.items != null) {
/* 105 */         ItemOuterClass.MiniItem[] itemList = new ItemOuterClass.MiniItem[this.items.length];
/* 106 */         for (int i = 0; i < itemList.length; i++) {
/* 107 */           ItemOuterClass.MiniItem.Builder miniItem = ItemUtil.getMiniItemData(this.items[i].getCode(), this.items[i].getGroupCount());
/* 108 */           if (null == miniItem) {
/* 109 */             Out.error(new Object[] { getClass(), "->[", this.items[i].getCode(), "] is not found" });
/*     */           } else {
/*     */             
/* 112 */             itemList[i] = miniItem.build();
/*     */           } 
/* 114 */         }  return itemList;
/*     */       } 
/* 116 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     public final AttendanceHandler.CumulativeInfo getCumulativeInfo() {
/* 121 */       AttendanceHandler.CumulativeInfo.Builder builder = AttendanceHandler.CumulativeInfo.newBuilder();
/* 122 */       builder.setId(this.id);
/* 123 */       builder.setBoxIcon((this.boxIcon == null) ? "" : this.boxIcon);
/* 124 */       builder.setNeedCountDay(this.needCountDay);
/* 125 */       builder.setState(this.state);
/* 126 */       ItemOuterClass.MiniItem[] itemList = getMiniItems();
/* 127 */       if (itemList != null)
/* 128 */         for (int i = 0; i < itemList.length; i++) {
/* 129 */           ItemOuterClass.MiniItem miniItem = itemList[i];
/* 130 */           if (null != miniItem)
/*     */           {
/*     */ 
/*     */             
/* 134 */             builder.addItemList(miniItem);
/*     */           }
/*     */         }  
/* 137 */       return builder.build();
/*     */     }
/*     */   }
/*     */   
/*     */   public class LuxurySignInfo
/*     */   {
/*     */     public int id;
/*     */     public ItemOuterClass.MiniItem.Builder[] items;
/*     */     public int state;
/*     */     
/*     */     public final ItemOuterClass.MiniItem[] getMiniItems() {
/* 148 */       if (this.items != null) {
/* 149 */         ItemOuterClass.MiniItem[] itemList = new ItemOuterClass.MiniItem[this.items.length];
/* 150 */         for (int i = 0; i < itemList.length; i++) {
/* 151 */           if (null != itemList[i]) {
/*     */ 
/*     */             
/* 154 */             ItemOuterClass.MiniItem.Builder miniItem = ItemUtil.getMiniItemData(this.items[i].getCode(), this.items[i].getGroupCount());
/* 155 */             if (null == miniItem)
/* 156 */             { Out.error(new Object[] { getClass(), "->[", this.items[i].getCode(), "] is not found" }); }
/*     */             else
/*     */             
/* 159 */             { itemList[i] = miniItem.build(); } 
/*     */           } 
/* 161 */         }  return itemList;
/*     */       } 
/* 163 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     public final AttendanceHandler.LuxuryInfo getLuxuryInfo() {
/* 168 */       AttendanceHandler.LuxuryInfo.Builder builder = AttendanceHandler.LuxuryInfo.newBuilder();
/* 169 */       builder.setState(this.state);
/* 170 */       ItemOuterClass.MiniItem[] itemList = getMiniItems();
/* 171 */       if (itemList != null)
/* 172 */         for (int i = 0; i < itemList.length; i++) {
/* 173 */           if (null != itemList[i])
/*     */           {
/*     */             
/* 176 */             builder.addItemList(itemList[i]);
/*     */           }
/*     */         }  
/* 179 */       return builder.build();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PlayerAttendance(WNPlayer player, AttendancePO attDb) {
/* 187 */     this.player = player;
/* 188 */     this.attDb = attDb;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void refreshNewDay() {
/* 195 */     if (DateUtil.canRefreshData(5, this.attDb.lastLuxuryTime)) {
/* 196 */       this.attDb.luxuryState = GiftState.NO_RECEIVE.getValue();
/*     */     }
/* 198 */     if (DateUtil.canRefreshData(5, this.attDb.lastSignTime) && getSignedCount() >= 30) {
/* 199 */       int lastId = 30;
/* 200 */       NormalSignExt prop = AttendanceConfig.getInstance().findDnormalSignWithIDAndRound(this.attDb.stage, lastId);
/* 201 */       NormalSignExt propNext = AttendanceConfig.getInstance().findDnormalSignWithIDAndRound(this.attDb.stage + 1, 1);
/*     */       
/* 203 */       if (prop != null && prop.nextRound > 0) {
/* 204 */         this.attDb.stage = prop.nextRound;
/* 205 */       } else if (propNext != null) {
/* 206 */         this.attDb.stage++;
/*     */       } else {
/* 208 */         this.attDb.stage = 1;
/*     */       } 
/* 210 */       this.attDb.signMap = new HashMap<>();
/* 211 */       this.attDb.cumulativeMap = new HashMap<>();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void testRefresh() {
/* 219 */     this.attDb.lastSignTime = DateUtil.getZeroDate();
/* 220 */     refreshNewDay();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final DailySignInfo[] getDailyList() {
/* 227 */     ArrayList<DailySignInfo> infoList = new ArrayList<>();
/* 228 */     ArrayList<NormalSignExt> list = AttendanceConfig.getInstance().getDnormalSignsWithRound(this.attDb.stage);
/* 229 */     for (NormalSignExt prop : list) {
/* 230 */       DailySignInfo tempInfo = new DailySignInfo();
/* 231 */       tempInfo.id = prop.id;
/* 232 */       tempInfo.items = prop.getMiniItems();
/* 233 */       tempInfo.vipDoubleLevel = prop.vip;
/* 234 */       if (this.attDb.signMap.containsKey(Integer.valueOf(prop.id))) {
/* 235 */         tempInfo.state = (((Integer)this.attDb.signMap.get(Integer.valueOf(prop.id))).intValue() > 0) ? ((Integer)this.attDb.signMap.get(Integer.valueOf(prop.id))).intValue() : GiftState.CAN_RECEIVE.getValue();
/*     */       } else {
/* 237 */         this.attDb.signMap.put(Integer.valueOf(prop.id), Integer.valueOf(GiftState.NO_RECEIVE.getValue()));
/* 238 */         tempInfo.state = GiftState.NO_RECEIVE.getValue();
/*     */       } 
/* 240 */       infoList.add(tempInfo);
/*     */     } 
/* 242 */     DailySignInfo[] infos = new DailySignInfo[infoList.size()];
/* 243 */     int index = 0;
/* 244 */     for (DailySignInfo info : infoList) {
/* 245 */       infos[index++] = info;
/*     */     }
/* 247 */     return infos;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final CumulativeSignInfo[] getCumulativeList() {
/* 254 */     ArrayList<CumulativeSignInfo> infoList = new ArrayList<>();
/* 255 */     ArrayList<AccumulateExt> list = AttendanceConfig.getInstance().getDaccumulateWithRound(this.attDb.stage);
/* 256 */     for (AccumulateExt prop : list) {
/* 257 */       CumulativeSignInfo tempInfo = new CumulativeSignInfo();
/* 258 */       tempInfo.id = prop.id;
/* 259 */       tempInfo.items = prop.getMiniItems();
/* 260 */       tempInfo.needCountDay = prop.days;
/* 261 */       tempInfo.boxIcon = prop.iconcode;
/* 262 */       if (this.attDb.cumulativeMap.containsKey(Integer.valueOf(prop.id))) {
/* 263 */         int receive = ((Integer)this.attDb.cumulativeMap.get(Integer.valueOf(prop.id))).intValue();
/* 264 */         if (receive > 0) {
/* 265 */           tempInfo.state = receive;
/* 266 */         } else if (getSignedCount() >= prop.days) {
/* 267 */           tempInfo.state = GiftState.CAN_RECEIVE.getValue();
/*     */         } else {
/* 269 */           tempInfo.state = GiftState.NO_RECEIVE.getValue();
/*     */         } 
/*     */       } else {
/* 272 */         tempInfo.state = GiftState.NO_RECEIVE.getValue();
/* 273 */         this.attDb.cumulativeMap.put(Integer.valueOf(prop.id), Integer.valueOf(tempInfo.state));
/*     */       } 
/* 275 */       infoList.add(tempInfo);
/*     */     } 
/* 277 */     CumulativeSignInfo[] infos = new CumulativeSignInfo[infoList.size()];
/* 278 */     int index = 0;
/* 279 */     for (CumulativeSignInfo info : infoList) {
/* 280 */       infos[index++] = info;
/*     */     }
/* 282 */     return infos;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final LuxurySignInfo getLuxuryList() {
/* 289 */     LuxurySignInfo info = new LuxurySignInfo();
/* 290 */     LuxurySignExt tempInfo = AttendanceConfig.getInstance().findDluxurySignWithID(1);
/* 291 */     info.id = tempInfo.id;
/* 292 */     info.items = tempInfo.getMiniItems();
/* 293 */     info.state = this.attDb.luxuryState;
/* 294 */     return info;
/*     */   }
/*     */ 
/*     */   
/*     */   public final int getDailyReward() {
/* 299 */     Date nowDate = new Date();
/* 300 */     if (!DateUtil.canRefreshData(5, this.attDb.lastSignTime)) {
/* 301 */       return -1;
/*     */     }
/* 303 */     int nextId = getSignedCount() + 1;
/* 304 */     NormalSignExt prop = AttendanceConfig.getInstance().findDnormalSignWithIDAndRound(this.attDb.stage, nextId);
/* 305 */     if (prop == null) {
/* 306 */       return -2;
/*     */     }
/* 308 */     if (!this.attDb.signMap.containsKey(Integer.valueOf(nextId))) {
/* 309 */       this.attDb.signMap.put(Integer.valueOf(nextId), Integer.valueOf(GiftState.NO_RECEIVE.getValue()));
/*     */     }
/*     */     
/* 312 */     if (!this.player.getWnBag().testAddCodeItems(prop.items)) {
/* 313 */       return -3;
/*     */     }
/*     */     
/* 316 */     this.player.getWnBag().addCodeItems(prop.items, Const.GOODS_CHANGE_TYPE.sign);
/* 317 */     this.attDb.lastSignTime = nowDate;
/* 318 */     this.attDb.signMap.put(Integer.valueOf(nextId), Integer.valueOf(GiftState.RECEIVED.getValue()));
/*     */ 
/*     */     
/* 321 */     this.player.activityManager.updateSuperScriptList();
/*     */     
/* 323 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public final int getCumulativeReward(int id) {
/* 328 */     int receive = 0;
/* 329 */     if (this.attDb.cumulativeMap.containsKey(Integer.valueOf(id))) {
/* 330 */       receive = ((Integer)this.attDb.cumulativeMap.get(Integer.valueOf(id))).intValue();
/*     */     } else {
/* 332 */       this.attDb.cumulativeMap.put(Integer.valueOf(id), Integer.valueOf(GiftState.NO_RECEIVE.getValue()));
/* 333 */       receive = GiftState.NO_RECEIVE.getValue();
/*     */     } 
/* 335 */     if (receive == GiftState.RECEIVED.getValue()) {
/* 336 */       return -1;
/*     */     }
/* 338 */     AccumulateExt prop = AttendanceConfig.getInstance().findDaccumulateWithIDAndRound(this.attDb.stage, id);
/* 339 */     if (prop == null) {
/* 340 */       return -2;
/*     */     }
/* 342 */     if (getSignedCount() < prop.days) {
/* 343 */       return -3;
/*     */     }
/*     */     
/* 346 */     if (!this.player.getWnBag().testAddCodeItems(prop.items)) {
/* 347 */       return -4;
/*     */     }
/*     */     
/* 350 */     this.player.getWnBag().addCodeItems(prop.items, Const.GOODS_CHANGE_TYPE.sign, null, false, false);
/* 351 */     this.attDb.cumulativeMap.put(Integer.valueOf(id), Integer.valueOf(GiftState.RECEIVED.getValue()));
/* 352 */     this.player.activityManager.updateSuperScriptList();
/* 353 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getLuxuryReward() {
/* 360 */     Date now = new Date();
/* 361 */     if (this.attDb.luxuryState == GiftState.RECEIVED.getValue()) {
/* 362 */       return -1;
/*     */     }
/* 364 */     if (this.attDb.luxuryState == GiftState.NO_RECEIVE.getValue()) {
/* 365 */       return -2;
/*     */     }
/*     */     
/* 368 */     LuxurySignExt prop = AttendanceConfig.getInstance().findDluxurySignWithID(1);
/*     */     
/* 370 */     if (!this.player.getWnBag().testAddCodeItems(prop.items)) {
/* 371 */       return -3;
/*     */     }
/*     */ 
/*     */     
/* 375 */     this.player.getWnBag().addCodeItems(prop.items, Const.GOODS_CHANGE_TYPE.sign, null, false, false);
/* 376 */     this.attDb.lastLuxuryTime = now;
/* 377 */     this.attDb.luxuryState = GiftState.RECEIVED.getValue();
/*     */     
/* 379 */     updateSuperScript();
/*     */ 
/*     */     
/* 382 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getLeftVipReward(int id) {
/* 389 */     int sign = 0;
/* 390 */     if (this.attDb.signMap.containsKey(Integer.valueOf(id))) {
/* 391 */       sign = ((Integer)this.attDb.signMap.get(Integer.valueOf(id))).intValue();
/*     */     } else {
/* 393 */       sign = GiftState.NO_RECEIVE.getValue();
/* 394 */       this.attDb.signMap.put(Integer.valueOf(id), Integer.valueOf(sign));
/*     */     } 
/* 396 */     sign = ((Integer)this.attDb.signMap.get(Integer.valueOf(id))).intValue();
/* 397 */     int receive = sign;
/* 398 */     if (receive == GiftState.RECEIVED.getValue()) {
/* 399 */       return -1;
/*     */     }
/* 401 */     if (receive != GiftState.VIP_NOT_RECEIVE.getValue()) {
/* 402 */       return -2;
/*     */     }
/* 404 */     NormalSignExt prop = AttendanceConfig.getInstance().findDnormalSignWithIDAndRound(this.attDb.stage, id);
/* 405 */     if (prop.vip == 0) {
/* 406 */       return -3;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 413 */     if (!this.player.getWnBag().testAddCodeItems(prop.items)) {
/* 414 */       return -5;
/*     */     }
/*     */     
/* 417 */     this.player.getWnBag().addCodeItems(prop.items, Const.GOODS_CHANGE_TYPE.sign, null, false, false);
/* 418 */     sign = GiftState.RECEIVED.getValue();
/* 419 */     this.attDb.signMap.put(Integer.valueOf(id), Integer.valueOf(sign));
/* 420 */     updateSuperScript();
/*     */     
/* 422 */     return 0;
/*     */   }
/*     */   
/*     */   public final void onRecharge() {
/* 426 */     if (this.attDb.luxuryState == GiftState.NO_RECEIVE.getValue()) {
/* 427 */       this.attDb.luxuryState = GiftState.CAN_RECEIVE.getValue();
/* 428 */       pushToClientLuxuryReward();
/* 429 */       updateSuperScript();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final void pushToClientLuxuryReward() {
/* 435 */     AttendanceHandler.LuxuryRewardPush.Builder builder = AttendanceHandler.LuxuryRewardPush.newBuilder();
/* 436 */     builder.setS2CCode(200);
/* 437 */     LuxurySignInfo info = getLuxuryList();
/* 438 */     builder.setS2CLuxury(info.getLuxuryInfo());
/* 439 */     this.player.receive("area.attendancePush.luxuryRewardPush", (GeneratedMessage)builder.build());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getSignedCount() {
/* 446 */     int count = 0;
/* 447 */     for (Map.Entry<Integer, Integer> node : (Iterable<Map.Entry<Integer, Integer>>)this.attDb.signMap.entrySet()) {
/* 448 */       int state = ((Integer)node.getValue()).intValue();
/* 449 */       if (state >= GiftState.RECEIVED.getValue()) {
/* 450 */         count++;
/*     */       }
/*     */     } 
/* 453 */     return count;
/*     */   }
/*     */   
/*     */   private final AttendanceHandler.AttendanceInfo getAttendanceInfo() {
/* 457 */     AttendanceHandler.AttendanceInfo.Builder infoBuilder = AttendanceHandler.AttendanceInfo.newBuilder();
/* 458 */     if (!DateUtil.canRefreshData(5, this.attDb.lastSignTime)) {
/* 459 */       infoBuilder.setTodayState(GiftState.RECEIVED.getValue());
/*     */     } else {
/* 461 */       infoBuilder.setTodayState(GiftState.CAN_RECEIVE.getValue());
/*     */     } 
/* 463 */     infoBuilder.setSignedCount(getSignedCount());
/* 464 */     DailySignInfo[] dailyList = getDailyList();
/* 465 */     CumulativeSignInfo[] cumulativeList = getCumulativeList(); int i;
/* 466 */     for (i = 0; i < dailyList.length; i++) {
/* 467 */       infoBuilder.addDailyList(dailyList[i].getDailyInfo());
/*     */     }
/* 469 */     for (i = 0; i < cumulativeList.length; i++) {
/* 470 */       infoBuilder.addCumulativeList(cumulativeList[i].getCumulativeInfo());
/*     */     }
/* 472 */     return infoBuilder.build();
/*     */   }
/*     */ 
/*     */   
/*     */   public final AttendanceHandler.GetAttendanceInfoResponse.Builder createGetAttendanceInfoResponse() {
/* 477 */     AttendanceHandler.GetAttendanceInfoResponse.Builder builder = AttendanceHandler.GetAttendanceInfoResponse.newBuilder();
/* 478 */     AttendanceHandler.AttendanceInfo info = getAttendanceInfo();
/* 479 */     LuxurySignInfo luxury = getLuxuryList();
/* 480 */     builder.setS2CLuxury(luxury.getLuxuryInfo());
/* 481 */     builder.setS2CAttendance(info);
/* 482 */     return builder;
/*     */   }
/*     */   
/*     */   public final AttendanceHandler.GetDailyRewardResponse.Builder createGetDailyRewardResponse() {
/* 486 */     AttendanceHandler.GetDailyRewardResponse.Builder builder = AttendanceHandler.GetDailyRewardResponse.newBuilder();
/* 487 */     AttendanceHandler.AttendanceInfo info = getAttendanceInfo();
/* 488 */     builder.setS2CAttendance(info);
/* 489 */     return builder;
/*     */   }
/*     */   
/*     */   public final AttendanceHandler.GetCumulativeRewardResponse.Builder createGetCumulativeRewardResponse() {
/* 493 */     AttendanceHandler.GetCumulativeRewardResponse.Builder builder = AttendanceHandler.GetCumulativeRewardResponse.newBuilder();
/* 494 */     AttendanceHandler.AttendanceInfo info = getAttendanceInfo();
/* 495 */     builder.setS2CAttendance(info);
/* 496 */     return builder;
/*     */   }
/*     */   
/*     */   public final AttendanceHandler.GetLuxuryRewardResponse.Builder createGetLuxuryRewardResponse() {
/* 500 */     AttendanceHandler.GetLuxuryRewardResponse.Builder builder = AttendanceHandler.GetLuxuryRewardResponse.newBuilder();
/* 501 */     LuxurySignInfo luxury = getLuxuryList();
/* 502 */     builder.setS2CLuxury(luxury.getLuxuryInfo());
/* 503 */     return builder;
/*     */   }
/*     */   
/*     */   public final AttendanceHandler.GetLeftVipRewardResponse.Builder createGetLeftVipRewardResponse() {
/* 507 */     AttendanceHandler.GetLeftVipRewardResponse.Builder builder = AttendanceHandler.GetLeftVipRewardResponse.newBuilder();
/* 508 */     AttendanceHandler.AttendanceInfo info = getAttendanceInfo();
/* 509 */     builder.setS2CAttendance(info);
/* 510 */     return builder;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void updateSuperScript() {
/* 517 */     List<PlayerHandler.SuperScriptType> list = new ArrayList<>();
/* 518 */     list.add(getSuperScript());
/* 519 */     this.player.updateSuperScriptList(list);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PlayerHandler.SuperScriptType getSuperScript() {
/* 526 */     int number = 0;
/*     */     
/* 528 */     if (!this.player.functionOpenManager.isOpen(Const.FunctionType.SIGN.getValue())) {
/* 529 */       PlayerHandler.SuperScriptType.Builder builder = PlayerHandler.SuperScriptType.newBuilder();
/* 530 */       builder.setType(Const.SUPERSCRIPT_TYPE.FLAG_WELFARE_SIGN.getValue());
/* 531 */       builder.setNumber(number);
/* 532 */       return builder.build();
/*     */     } 
/* 534 */     int signedCount = 0;
/* 535 */     for (Map.Entry<Integer, Integer> node : (Iterable<Map.Entry<Integer, Integer>>)this.attDb.signMap.entrySet()) {
/* 536 */       int state = ((Integer)node.getValue()).intValue();
/* 537 */       if (state >= GiftState.RECEIVED.getValue()) {
/* 538 */         signedCount++;
/*     */       }
/*     */     } 
/* 541 */     if (DateUtil.canRefreshData(5, this.attDb.lastSignTime)) {
/* 542 */       number++;
/*     */     }
/*     */     
/* 545 */     ArrayList<AccumulateExt> cumulativeList = AttendanceConfig.getInstance().getDaccumulateWithRound(this.attDb.stage);
/* 546 */     for (int i = 0; i < cumulativeList.size(); i++) {
/* 547 */       AccumulateExt prop = cumulativeList.get(i);
/* 548 */       int receive = 0;
/* 549 */       if (this.attDb.cumulativeMap.containsKey(Integer.valueOf(prop.id))) {
/* 550 */         receive = ((Integer)this.attDb.cumulativeMap.get(Integer.valueOf(prop.id))).intValue();
/*     */       } else {
/* 552 */         this.attDb.cumulativeMap.put(Integer.valueOf(prop.id), Integer.valueOf(GiftState.NO_RECEIVE.getValue()));
/* 553 */         receive = GiftState.NO_RECEIVE.getValue();
/*     */       } 
/* 555 */       if (receive <= 0 && signedCount >= prop.days) {
/* 556 */         number++;
/*     */       }
/*     */     } 
/* 559 */     if (this.attDb.luxuryState == GiftState.CAN_RECEIVE.getValue()) {
/* 560 */       number++;
/*     */     }
/* 562 */     PlayerHandler.SuperScriptType.Builder scriptNum = PlayerHandler.SuperScriptType.newBuilder();
/* 563 */     scriptNum.setType(Const.SUPERSCRIPT_TYPE.FLAG_WELFARE_SIGN.getValue());
/* 564 */     scriptNum.setNumber(number);
/*     */     
/* 566 */     return scriptNum.build();
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\attendance\PlayerAttendance.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */