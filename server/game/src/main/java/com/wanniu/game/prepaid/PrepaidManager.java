/*     */ package com.wanniu.game.prepaid;
/*     */ 
/*     */ import com.wanniu.core.game.entity.GEntity;
/*     */ import com.wanniu.core.util.StringUtil;
/*     */ import com.wanniu.game.activity.ActivityManager;
/*     */ import com.wanniu.game.activity.RechargeActivityService;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.ConstsTR;
/*     */ import com.wanniu.game.common.ModuleManager;
/*     */ import com.wanniu.game.common.Utils;
/*     */ import com.wanniu.game.data.CardCO;
/*     */ import com.wanniu.game.data.GameData;
/*     */ import com.wanniu.game.data.PayCO;
/*     */ import com.wanniu.game.data.SuperPackageCO;
/*     */ import com.wanniu.game.data.ext.DailyPayExt;
/*     */ import com.wanniu.game.data.ext.FirstPayExt;
/*     */ import com.wanniu.game.data.ext.TotalPayExt;
/*     */ import com.wanniu.game.item.VirtualItemType;
/*     */ import com.wanniu.game.mail.MailUtil;
/*     */ import com.wanniu.game.mail.data.MailData;
/*     */ import com.wanniu.game.mail.data.MailSysData;
/*     */ import com.wanniu.game.player.BILogService;
/*     */ import com.wanniu.game.player.PlayerUtil;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.player.bi.LogReportService;
/*     */ import com.wanniu.game.poes.ActivityDataPO;
/*     */ import com.wanniu.game.poes.BagsPO;
/*     */ import com.wanniu.game.poes.PlayerPO;
/*     */ import com.wanniu.game.poes.SevenGoalPO;
/*     */ import com.wanniu.game.prepaid.po.PrepaidPO;
/*     */ import com.wanniu.game.prepaid.po.PrepaidRecord;
/*     */ import com.wanniu.game.sevengoal.SevenGoalManager;
/*     */ import com.wanniu.redis.PlayerPOManager;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import org.apache.commons.lang3.time.DateUtils;
/*     */ import pomelo.Common;
/*     */ import pomelo.area.ActivityFavorHandler;
/*     */ import pomelo.area.PrepaidHandler;
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
/*     */ public class PrepaidManager
/*     */   extends ModuleManager
/*     */ {
/*     */   public final String playerId;
/*     */   public PrepaidPO po;
/*     */   
/*     */   public PrepaidManager(String playerId) {
/*  60 */     this.playerId = playerId;
/*  61 */     this.po = loadPO(playerId);
/*     */   }
/*     */   
/*     */   private PrepaidPO loadPO(String playerId2) {
/*  65 */     PrepaidPO po = (PrepaidPO)PlayerPOManager.findPO(ConstsTR.prepaidNewTR, this.playerId, PrepaidPO.class);
/*  66 */     if (po == null) {
/*  67 */       po = new PrepaidPO();
/*  68 */       PlayerPOManager.put(ConstsTR.prepaidNewTR, this.playerId, (GEntity)po);
/*     */     } 
/*  70 */     return po;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onCharge(int productId, boolean isCard, boolean isSuperPackage, boolean logBI) {
/*  81 */     int oldPayMoney = this.po.total_charge;
/*     */     
/*  83 */     if (this.po.dailyDate != null && !DateUtils.isSameDay(new Date(), this.po.dailyDate)) {
/*  84 */       this.po.dailyPayRmb = 0;
/*     */     }
/*     */     
/*  87 */     if (!isSuperPackage) {
/*  88 */       if (isCard) {
/*  89 */         chargeCard(productId, logBI);
/*     */       } else {
/*  91 */         chargeDiamond(productId, logBI);
/*     */       } 
/*     */     } else {
/*  94 */       chargeDiamondOfSuperPackage(productId, logBI);
/*     */     } 
/*     */     
/*  97 */     this.po.dailyDate = new Date();
/*  98 */     int payRmb = this.po.total_charge - oldPayMoney;
/*  99 */     this.po.dailyPayRmb += payRmb;
/*     */ 
/*     */     
/* 102 */     if (oldPayMoney == 0) {
/* 103 */       PlayerPO baseData = (PlayerPO)PlayerPOManager.findPO(ConstsTR.playerTR, this.playerId, PlayerPO.class);
/* 104 */       List<FirstPayExt> props = GameData.findFirstPays(t -> (t.Job == baseData.pro));
/* 105 */       MailSysData d = new MailSysData("Pay_FirstPay");
/* 106 */       ArrayList<MailData.Attachment> list = new ArrayList<>();
/* 107 */       for (DailyPayExt.AwardInfo a : ((FirstPayExt)props.get(0)).awards) {
/* 108 */         MailData.Attachment attachment = new MailData.Attachment();
/* 109 */         attachment.itemCode = a.itemCode;
/* 110 */         attachment.itemNum = a.itemNum;
/* 111 */         attachment.isBind = 1;
/* 112 */         list.add(attachment);
/*     */       } 
/* 114 */       d.attachments = list;
/* 115 */       MailUtil.getInstance().sendMailToOnePlayer(this.playerId, (MailData)d, Const.GOODS_CHANGE_TYPE.FIRST_CHARGE);
/*     */     } 
/*     */ 
/*     */     
/* 119 */     for (TotalPayExt i : GameData.TotalPays.values()) {
/* 120 */       if (oldPayMoney < i.target && this.po.total_charge >= i.target) {
/* 121 */         MailSysData d = new MailSysData("Pay_TotalPay");
/* 122 */         ArrayList<MailData.Attachment> list = new ArrayList<>();
/* 123 */         for (DailyPayExt.AwardInfo a : i.awards) {
/* 124 */           MailData.Attachment attachment = new MailData.Attachment();
/* 125 */           attachment.itemCode = a.itemCode;
/* 126 */           attachment.itemNum = a.itemNum;
/* 127 */           attachment.isBind = 1;
/* 128 */           list.add(attachment);
/*     */         } 
/* 130 */         d.attachments = list;
/* 131 */         MailUtil.getInstance().sendMailToOnePlayer(this.playerId, (MailData)d, Const.GOODS_CHANGE_TYPE.CUMULATIVE_CHARGE);
/*     */       } 
/*     */     } 
/*     */     
/* 135 */     if (getFirstPayStatus() == 2) {
/* 136 */       WNPlayer wNPlayer = PlayerUtil.getOnlinePlayer(this.playerId);
/* 137 */       if (wNPlayer != null) {
/* 138 */         wNPlayer.updateSuperScript(Const.SUPERSCRIPT_TYPE.FIRSTPAY_GIFT, 0);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 143 */     if (isSuperPackage) {
/* 144 */       ActivityDataPO activityDataPO = (ActivityDataPO)PlayerPOManager.findPO(ConstsTR.activityTR, this.playerId, ActivityDataPO.class);
/* 145 */       if (!activityDataPO.superPackageRecorder.containsKey(Integer.valueOf(productId))) {
/* 146 */         ActivityManager.RewardRecord rewardRecord = new ActivityManager.RewardRecord();
/* 147 */         rewardRecord.awardId = productId;
/* 148 */         rewardRecord.awardTime = new Date();
/* 149 */         activityDataPO.superPackageRecorder.put(Integer.valueOf(productId), rewardRecord);
/* 150 */         MailSysData d = new MailSysData("SuperPackage_Item");
/* 151 */         ArrayList<MailData.Attachment> list = new ArrayList<>();
/* 152 */         SuperPackageCO superPackageCO = (SuperPackageCO)GameData.SuperPackages.get(Integer.valueOf(productId));
/* 153 */         MailData.Attachment attachment = new MailData.Attachment();
/* 154 */         attachment.itemCode = superPackageCO.packageCode;
/* 155 */         attachment.itemNum = superPackageCO.packageNum;
/* 156 */         attachment.isBind = 1;
/* 157 */         list.add(attachment);
/* 158 */         d.attachments = list;
/* 159 */         MailUtil.getInstance().sendMailToOnePlayer(this.playerId, (MailData)d, Const.GOODS_CHANGE_TYPE.SUPER_PACKAGE);
/*     */         
/* 161 */         WNPlayer wNPlayer = PlayerUtil.getOnlinePlayer(this.playerId);
/* 162 */         if (wNPlayer != null) {
/* 163 */           ActivityFavorHandler.SuperPackageBuyPush.Builder spbpBuilder = ActivityFavorHandler.SuperPackageBuyPush.newBuilder();
/* 164 */           spbpBuilder.setS2CCode(200);
/* 165 */           spbpBuilder.setPackageId(productId);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 171 */     RechargeActivityService.getInstance().onPayEvent(this.playerId, this.po.dailyPayRmb, payRmb);
/*     */ 
/*     */     
/* 174 */     WNPlayer player = PlayerUtil.getOnlinePlayer(this.playerId);
/* 175 */     if (player != null) {
/*     */       
/* 177 */       player.sevenGoalManager.processGoal(SevenGoalManager.SevenGoalTaskType.PAY_COUNT, new Object[] { Integer.valueOf(this.po.dailyPayRmb / 100) });
/*     */     } else {
/*     */       
/* 180 */       SevenGoalPO sevenGoalPO = (SevenGoalPO)PlayerPOManager.findPO(ConstsTR.SevenGoal, this.playerId, SevenGoalPO.class);
/* 181 */       sevenGoalPO.processPayCount();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void onCharge(int productId, boolean isCard) {
/* 187 */     onCharge(productId, isCard, false, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getFirstPayStatus() {
/* 196 */     if (this.po.total_charge == 0) {
/* 197 */       return 0;
/*     */     }
/* 199 */     boolean totalFinished = true;
/* 200 */     for (TotalPayExt i : GameData.TotalPays.values()) {
/* 201 */       if (this.po.total_charge < i.target) {
/* 202 */         totalFinished = false;
/*     */         break;
/*     */       } 
/*     */     } 
/* 206 */     return totalFinished ? 2 : 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void chargeCard(int productId, boolean logBI) {
/* 215 */     CardCO cardProp = (CardCO)GameData.Cards.get(Integer.valueOf(productId));
/* 216 */     if (cardProp == null)
/*     */       return; 
/* 218 */     int amount = cardProp.payMoneyAmount;
/* 219 */     this.po.total_charge += amount;
/* 220 */     this.po.dailyChargeDiamond += cardProp.payDiamond;
/* 221 */     PrepaidRecord record = new PrepaidRecord();
/* 222 */     record.money = amount;
/* 223 */     record.date = new Date();
/* 224 */     record.isCard = true;
/*     */     
/* 226 */     this.po.chargeRecord.add(record);
/* 227 */     Calendar c = Calendar.getInstance();
/* 228 */     c.add(5, cardProp.lastTime);
/* 229 */     WNPlayer player = PlayerUtil.getOnlinePlayer(this.playerId);
/* 230 */     if (player != null) {
/* 231 */       player.baseDataManager.modifyVip(cardProp.iD, cardProp.lastTime);
/* 232 */       player.moneyManager.addDiamond(cardProp.payDiamond, Const.GOODS_CHANGE_TYPE.VIPBUY);
/* 233 */       player.pushDynamicData(Utils.ofMap(new Object[] { "vip", Integer.valueOf(player.player.vip) }));
/*     */       
/* 235 */       if (cardProp.iD == Const.VipType.forever.value) {
/* 236 */         player.bag.addBagGridCount(cardProp.prv6);
/* 237 */         player.wareHouse.addBagGridCount(cardProp.prv5);
/*     */       } 
/* 239 */       player.onPay();
/*     */       
/* 241 */       if (logBI) {
/* 242 */         BILogService.getInstance().ansycReportRechargeSuccess(player.getPlayer(), cardProp.payDiamond, cardProp.payMoneyAmount, cardProp.name);
/*     */       }
/*     */     } else {
/* 245 */       PlayerPO baseData = (PlayerPO)PlayerPOManager.findPO(ConstsTR.playerTR, this.playerId, PlayerPO.class);
/* 246 */       modifyVip(cardProp.iD, cardProp.lastTime, baseData);
/* 247 */       int before = baseData.diamond;
/* 248 */       baseData.diamond += cardProp.payDiamond;
/* 249 */       int after = baseData.diamond;
/*     */ 
/*     */       
/* 252 */       if (cardProp.iD == Const.VipType.forever.value) {
/* 253 */         BagsPO bagsPO = (BagsPO)PlayerPOManager.findPO(ConstsTR.bagTR, this.playerId, BagsPO.class);
/* 254 */         bagsPO.bagData.bagGridCount += cardProp.prv6;
/* 255 */         bagsPO.wareHouseData.bagGridCount += cardProp.prv5;
/*     */       } 
/* 257 */       PlayerPOManager.sync(this.playerId);
/*     */       
/* 259 */       if (logBI) {
/* 260 */         BILogService.getInstance().ansycReportRechargeSuccess(baseData, cardProp.payDiamond, cardProp.payMoneyAmount, cardProp.name);
/*     */       }
/*     */ 
/*     */       
/* 264 */       LogReportService.getInstance().ansycReportMoneyFlow(baseData, VirtualItemType.DIAMOND, before, 1, cardProp.payDiamond, after, Const.GOODS_CHANGE_TYPE.VIPBUY.value);
/*     */     } 
/* 266 */     if (StringUtil.isNotEmpty(cardProp.prv9)) {
/* 267 */       MailSysData d = new MailSysData("Pay_title");
/* 268 */       ArrayList<MailData.Attachment> list = new ArrayList<>();
/* 269 */       MailData.Attachment attachment = new MailData.Attachment();
/* 270 */       attachment.itemCode = cardProp.prv9;
/* 271 */       attachment.itemNum = 1;
/* 272 */       list.add(attachment);
/* 273 */       d.attachments = list;
/* 274 */       d.replace = new HashMap<>();
/* 275 */       d.replace.put("card", cardProp.name);
/* 276 */       MailUtil.getInstance().sendMailToOnePlayer(this.playerId, (MailData)d, Const.GOODS_CHANGE_TYPE.VIPBUY);
/*     */     } 
/*     */ 
/*     */     
/* 280 */     if (this.po.firstCharge == 0) {
/* 281 */       this.po.firstCharge = amount;
/*     */     }
/*     */ 
/*     */     
/* 285 */     if (player != null) {
/* 286 */       player.vipManager.updateSuperScript();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void chargeDiamond(int productId, boolean logBI) {
/* 294 */     PayCO payProp = (PayCO)GameData.Pays.get(Integer.valueOf(productId));
/* 295 */     if (payProp == null)
/*     */       return; 
/* 297 */     int amount = payProp.payMoneyAmount;
/* 298 */     this.po.total_charge += amount;
/* 299 */     this.po.dailyChargeDiamond += payProp.payDiamond;
/* 300 */     PrepaidRecord record = new PrepaidRecord();
/* 301 */     record.money = amount;
/* 302 */     record.date = new Date();
/* 303 */     this.po.chargeRecord.add(record);
/* 304 */     int chargeDiamond = payProp.payDiamond;
/*     */     
/* 306 */     if (!this.po.first_buy_record.containsKey(Integer.valueOf(productId))) {
/* 307 */       this.po.first_buy_record.put(Integer.valueOf(productId), Integer.valueOf(productId));
/* 308 */       chargeDiamond += payProp.firstDiamond;
/*     */     } else {
/* 310 */       chargeDiamond += payProp.nonFirstDiamond;
/*     */     } 
/* 312 */     WNPlayer player = PlayerUtil.getOnlinePlayer(this.playerId);
/* 313 */     if (player != null) {
/* 314 */       player.moneyManager.addDiamond(chargeDiamond, Const.GOODS_CHANGE_TYPE.CHARGE);
/* 315 */       player.onPay();
/* 316 */       if (logBI) {
/* 317 */         BILogService.getInstance().ansycReportRechargeSuccess(player.getPlayer(), chargeDiamond, payProp.payMoneyAmount, payProp.packageName);
/*     */       }
/*     */     } else {
/* 320 */       PlayerPO baseData = (PlayerPO)PlayerPOManager.findPO(ConstsTR.playerTR, this.playerId, PlayerPO.class);
/* 321 */       int before = baseData.diamond;
/* 322 */       baseData.diamond += chargeDiamond;
/* 323 */       int after = baseData.diamond;
/* 324 */       PlayerPOManager.sync(this.playerId);
/*     */       
/* 326 */       if (logBI) {
/* 327 */         BILogService.getInstance().ansycReportRechargeSuccess(baseData, chargeDiamond, payProp.payMoneyAmount, payProp.packageName);
/*     */       }
/*     */ 
/*     */       
/* 331 */       LogReportService.getInstance().ansycReportMoneyFlow(baseData, VirtualItemType.DIAMOND, before, 1, chargeDiamond, after, Const.GOODS_CHANGE_TYPE.CHARGE.value);
/*     */     } 
/* 333 */     if (this.po.firstCharge == 0) {
/* 334 */       this.po.firstCharge = payProp.payMoneyAmount;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void chargeDiamondOfSuperPackage(int productId, boolean logBI) {
/* 342 */     SuperPackageCO superPackageCO = (SuperPackageCO)GameData.SuperPackages.get(Integer.valueOf(productId));
/* 343 */     if (superPackageCO == null)
/*     */       return; 
/* 345 */     int amount = superPackageCO.packagePrice;
/* 346 */     this.po.total_charge += amount;
/* 347 */     this.po.dailyChargeDiamond += superPackageCO.diamondNum;
/* 348 */     PrepaidRecord record = new PrepaidRecord();
/* 349 */     record.money = amount;
/* 350 */     record.date = new Date();
/* 351 */     this.po.chargeRecord.add(record);
/* 352 */     int chargeDiamond = superPackageCO.diamondNum;
/*     */     
/* 354 */     WNPlayer player = PlayerUtil.getOnlinePlayer(this.playerId);
/* 355 */     if (player != null) {
/* 356 */       player.moneyManager.addDiamond(chargeDiamond, Const.GOODS_CHANGE_TYPE.SUPER_PACKAGE);
/* 357 */       player.onPay();
/* 358 */       if (logBI) {
/* 359 */         BILogService.getInstance().ansycReportRechargeSuccess(player.getPlayer(), chargeDiamond, superPackageCO.packagePrice, superPackageCO.packageName);
/*     */       }
/*     */     } else {
/* 362 */       PlayerPO baseData = (PlayerPO)PlayerPOManager.findPO(ConstsTR.playerTR, this.playerId, PlayerPO.class);
/* 363 */       int before = baseData.diamond;
/* 364 */       baseData.diamond += chargeDiamond;
/* 365 */       int after = baseData.diamond;
/* 366 */       PlayerPOManager.sync(this.playerId);
/*     */       
/* 368 */       if (logBI) {
/* 369 */         BILogService.getInstance().ansycReportRechargeSuccess(baseData, chargeDiamond, superPackageCO.packagePrice, superPackageCO.packageName);
/*     */       }
/*     */ 
/*     */       
/* 373 */       LogReportService.getInstance().ansycReportMoneyFlow(baseData, VirtualItemType.DIAMOND, before, 1, chargeDiamond, after, Const.GOODS_CHANGE_TYPE.SUPER_PACKAGE.value);
/*     */     } 
/* 375 */     if (this.po.firstCharge == 0) {
/* 376 */       this.po.firstCharge = superPackageCO.packagePrice;
/*     */     }
/*     */   }
/*     */   
/*     */   public void onResume(int consumeDiamond) {
/* 381 */     this.po.total_consume += consumeDiamond;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void modifyVip(int vip, int lastTime, PlayerPO baseData) {
/* 392 */     Const.VipType vt = Const.VipType.getE(vip);
/*     */ 
/*     */     
/* 395 */     if ((baseData.vip == Const.VipType.month.value || baseData.vip == Const.VipType.sb_double.value) && 
/* 396 */       baseData.vipEndTime.before(Calendar.getInstance().getTime())) {
/* 397 */       baseData.vipEndTime = null;
/* 398 */       if (baseData.vip == Const.VipType.month.value) {
/* 399 */         baseData.vip = Const.VipType.none.value;
/*     */       } else {
/* 401 */         baseData.vip = Const.VipType.forever.value;
/*     */       } 
/*     */     } 
/*     */     
/* 405 */     if (vt == null)
/*     */       return; 
/* 407 */     if (vt == Const.VipType.month) {
/* 408 */       if (baseData.vip == Const.VipType.forever.value || baseData.vip == Const.VipType.sb_double.value) {
/* 409 */         baseData.vip = Const.VipType.sb_double.value;
/*     */       } else {
/* 411 */         baseData.vip = vt.value;
/*     */       } 
/*     */     }
/* 414 */     if (vt == Const.VipType.forever) {
/* 415 */       if (baseData.vip == Const.VipType.month.value || baseData.vip == Const.VipType.sb_double.value) {
/* 416 */         baseData.vip = Const.VipType.sb_double.value;
/*     */       } else {
/* 418 */         baseData.vip = vt.value;
/*     */       } 
/*     */     }
/* 421 */     if (vt == Const.VipType.month) {
/* 422 */       CardCO cardProp = (CardCO)GameData.Cards.get(Integer.valueOf(vip));
/* 423 */       Calendar c = Calendar.getInstance();
/* 424 */       if (baseData.vipEndTime != null && baseData.vipEndTime.after(Calendar.getInstance().getTime())) {
/* 425 */         c.setTime(baseData.vipEndTime);
/* 426 */         c.add(5, cardProp.lastTime);
/* 427 */         baseData.vipEndTime = c.getTime();
/*     */       } else {
/* 429 */         c.add(5, cardProp.lastTime);
/* 430 */         baseData.vipEndTime = c.getTime();
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public int getDailyCharge() {
/* 436 */     return this.po.dailyChargeDiamond;
/*     */   }
/*     */   
/*     */   public int getPayedTimes() {
/* 440 */     return this.po.chargeRecord.size();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEachPayMoneyEnough(int times, int money) {
/* 452 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onPrepaidChargeByMoney(int money) {
/* 459 */     onCharge(((PayCO)GameData.Pays.values().stream().filter(v -> (v.nonFirstDiamond == money)).findFirst().get()).iD, false);
/*     */   }
/*     */   
/*     */   public Date getDailyDate() {
/* 463 */     return this.po.dailyDate;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onPlayerEvent(Const.PlayerEventType eventType) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public Const.ManagerType getManagerType() {
/* 473 */     return Const.ManagerType.PREPAID;
/*     */   }
/*     */   
/*     */   public List<PrepaidHandler.FeeItem> getPrepaidList() {
/* 477 */     List<PrepaidHandler.FeeItem> list = new ArrayList<>();
/* 478 */     for (PayCO prop : GameData.Pays.values()) {
/* 479 */       PrepaidHandler.FeeItem.Builder fi = PrepaidHandler.FeeItem.newBuilder();
/* 480 */       fi.setId(prop.iD);
/* 481 */       fi.setPackageIcon(prop.packageIcon);
/* 482 */       fi.setAppProductId(prop.appProductId);
/* 483 */       fi.setPackageName(prop.packageName);
/* 484 */       fi.setPackageDesc(prop.packageDesc);
/* 485 */       fi.setPackageDescFirst(prop.packageDescFirst);
/* 486 */       fi.setPayMoneyType(prop.payMoneyType);
/* 487 */       fi.setPayMoneyAmount(prop.payMoneyAmount);
/* 488 */       fi.setPayDiamond(prop.payDiamond);
/* 489 */       fi.setFirstDiamond(prop.firstDiamond);
/* 490 */       fi.setNonFirstDiamond(prop.nonFirstDiamond);
/* 491 */       fi.setPayCashFirst(prop.payCashFirst);
/* 492 */       fi.setPayTag(prop.payTag);
/* 493 */       if (this.po.first_buy_record.containsKey(Integer.valueOf(prop.iD))) {
/* 494 */         fi.setVirgin(0);
/*     */       } else {
/* 496 */         fi.setVirgin(1);
/*     */       } 
/* 498 */       list.add(fi.build());
/*     */     } 
/* 500 */     return list;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PrepaidHandler.PrepaidFirstResponse getPrepaidFirstAward() {
/* 509 */     PrepaidHandler.PrepaidFirstResponse.Builder res = PrepaidHandler.PrepaidFirstResponse.newBuilder();
/* 510 */     res.setS2CCode(200);
/* 511 */     res.setTotalPay(this.po.total_charge);
/* 512 */     for (TotalPayExt p : GameData.TotalPays.values()) {
/* 513 */       PrepaidHandler.PrepaidFirstItem.Builder item = PrepaidHandler.PrepaidFirstItem.newBuilder();
/* 514 */       item.setIsFinish((this.po.total_charge >= p.target) ? 1 : 0);
/* 515 */       item.setPayMoney(p.target);
/* 516 */       for (DailyPayExt.AwardInfo a : p.awards) {
/* 517 */         Common.KeyValueStruct.Builder i = Common.KeyValueStruct.newBuilder();
/* 518 */         i.setKey(a.itemCode);
/* 519 */         i.setValue(String.valueOf(a.itemNum));
/* 520 */         item.addItems(i);
/*     */       } 
/* 522 */       res.addAwards(item);
/*     */     } 
/* 524 */     return res.build();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onChargeCardByOpen(Object type) {
/* 531 */     onCharge(((CardCO)GameData.Cards.values().stream().filter(v -> v.name.equals(type)).findFirst().get()).iD, true);
/*     */   }
/*     */   
/*     */   public int getTodayPayValue() {
/* 535 */     if (this.po.dailyDate != null && !DateUtils.isSameDay(new Date(), this.po.dailyDate)) {
/* 536 */       return 0;
/*     */     }
/* 538 */     return this.po.dailyPayRmb;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\prepaid\PrepaidManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */