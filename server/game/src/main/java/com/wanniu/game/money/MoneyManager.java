/*     */ package com.wanniu.game.money;
/*     */ 
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.game.activity.RechargeActivityService;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.HackerException;
/*     */ import com.wanniu.game.daoyou.AllyConfiguration;
/*     */ import com.wanniu.game.daoyou.DaoYouService;
/*     */ import com.wanniu.game.item.VirtualItemType;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.player.bi.LogReportService;
/*     */ import com.wanniu.game.poes.PlayerPO;
/*     */ import com.wanniu.game.poes.XianYuanPO;
/*     */ import com.wanniu.game.rank.RankType;
/*     */ import com.wanniu.game.sevengoal.SevenGoalManager;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import pomelo.Common;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MoneyManager
/*     */ {
/*     */   private final WNPlayer player;
/*  32 */   public static int today_max_diamond_threshold = 100000;
/*  33 */   public static int today_max_kicket_threshold = 20000;
/*  34 */   public static int today_max_gold_threshold = 200000000;
/*     */   
/*     */   public MoneyManager(WNPlayer player) {
/*  37 */     this.player = player;
/*     */   }
/*     */ 
/*     */   
/*     */   private PlayerPO getBaseData() {
/*  42 */     return this.player.player;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean enoughGold(int num) {
/*  52 */     if (num < 0) {
/*  53 */       throw new HackerException("判定玩家身上的银两是否足够时参数小于0.");
/*     */     }
/*  55 */     return ((getBaseData()).gold >= num);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean costGold(int num, Const.GOODS_CHANGE_TYPE origin) {
/*  71 */     if (num == 0) {
/*  72 */       return true;
/*     */     }
/*  74 */     if (!enoughGold(num)) {
/*  75 */       return false;
/*     */     }
/*  77 */     int before = (getBaseData()).gold;
/*  78 */     (getBaseData()).gold -= num;
/*  79 */     int after = (getBaseData()).gold;
/*  80 */     Out.info(new Object[] { "cost gold. id=", this.player.getId(), ",name=", this.player.getName(), ",before=", Integer.valueOf(before), ",value=", Integer.valueOf(num), ",after=", Integer.valueOf(after), ",origin=", Integer.valueOf(origin.value) });
/*  81 */     LogReportService.getInstance().ansycReportMoneyFlow(this.player.getPlayer(), VirtualItemType.GOLD, before, 2, num, after, origin.value);
/*     */ 
/*     */     
/*  84 */     pushDynamicDataByGold(origin);
/*     */     
/*  86 */     updateScript();
/*  87 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int costGoldByPercent(int percent, Const.GOODS_CHANGE_TYPE origin) {
/*  98 */     if (percent <= 0 || (getBaseData()).gold <= 0) {
/*  99 */       return 0;
/*     */     }
/* 101 */     float fc = 1.0F * (getBaseData()).gold / 10000.0F * percent;
/* 102 */     int cost = Math.round(fc);
/* 103 */     cost = (cost <= 0) ? 1 : cost;
/* 104 */     boolean success = costGold(cost, origin);
/* 105 */     if (!success) {
/* 106 */       Out.warn(new Object[] { "cost gold not enough并发!!!!!. id=", this.player.getId(), ",name=", this.player.getName(), "origin=", Integer.valueOf(origin.value), ",cost:", Integer.valueOf(cost) });
/*     */     }
/* 108 */     return success ? cost : 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int costGoldOnPk(int goldNum, Const.GOODS_CHANGE_TYPE origin) {
/* 119 */     if (goldNum <= 0 || (getBaseData()).gold <= 0) {
/* 120 */       return 0;
/*     */     }
/*     */     
/* 123 */     boolean success = costGold(goldNum, origin);
/* 124 */     if (!success) {
/* 125 */       Out.warn(new Object[] { "cost gold not enough并发!!!!!. id=", this.player.getId(), ",name=", this.player.getName(), "origin=", Integer.valueOf(origin.value), ",cost:", Integer.valueOf(goldNum) });
/*     */     }
/* 127 */     return success ? goldNum : 0;
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addGold(int num, Const.GOODS_CHANGE_TYPE origin) {
/* 143 */     if (num == 0) {
/*     */       return;
/*     */     }
/* 146 */     if (num < 0) {
/* 147 */       throw new HackerException("增加银两时参数小于0.");
/*     */     }
/* 149 */     int before = (getBaseData()).gold;
/*     */     
/* 151 */     if (0L + (getBaseData()).gold + num > 2147483647L) {
/* 152 */       (getBaseData()).gold = Integer.MAX_VALUE;
/*     */     } else {
/* 154 */       (getBaseData()).gold += num;
/*     */     } 
/* 156 */     int after = (getBaseData()).gold;
/*     */ 
/*     */     
/* 159 */     if (origin != Const.GOODS_CHANGE_TYPE.monsterdrop) {
/* 160 */       Out.info(new Object[] { "add gold. id=", this.player.getId(), ",name=", this.player.getName(), ",before=", Integer.valueOf(before), ",value=", Integer.valueOf(num), ",after=", Integer.valueOf(after), ",origin=", Integer.valueOf(origin.value) });
/* 161 */       LogReportService.getInstance().ansycReportMoneyFlow(this.player.getPlayer(), VirtualItemType.GOLD, before, 1, num, after, origin.value);
/*     */     } 
/*     */ 
/*     */     
/* 165 */     pushDynamicDataByGold(origin);
/* 166 */     this.player.achievementManager.onGetGold(num);
/* 167 */     if (origin != Const.GOODS_CHANGE_TYPE.monsterdrop) {
/* 168 */       updateScript();
/*     */     }
/*     */ 
/*     */     
/* 172 */     (getBaseData()).todayGold += num;
/* 173 */     if ((getBaseData()).todayGold >= today_max_gold_threshold) {
/* 174 */       Out.warn(new Object[] { "今日银两收益超过预期值,playerId:", this.player.getId(), ",name:", this.player.getName(), ",todayGold:", Integer.valueOf((getBaseData()).todayGold), ",max:", Integer.valueOf(today_max_gold_threshold) });
/* 175 */       LogReportService.getInstance().ansycReportMoneyMonitor(this.player, VirtualItemType.GOLD, (getBaseData()).todayGold, today_max_gold_threshold);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getGold() {
/* 185 */     return (getBaseData()).gold;
/*     */   }
/*     */ 
/*     */   
/*     */   private void pushDynamicDataByGold(Const.GOODS_CHANGE_TYPE origin) {
/* 190 */     this.player.pushDynamicData("gold", Integer.valueOf((getBaseData()).gold), origin);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void updateScript() {
/* 196 */     this.player.equipManager.updateStrengthScript(null);
/* 197 */     this.player.equipManager.updateMakeScript(null);
/*     */     
/* 199 */     this.player.guildManager.pushRedPoint();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean enoughDiamond(int num) {
/* 209 */     if (num < 0) {
/* 210 */       throw new HackerException("判定玩家身上的充值元宝是否足够时参数小于0.");
/*     */     }
/* 212 */     return ((getBaseData()).diamond >= num);
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
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean costDiamond(int num, Const.GOODS_CHANGE_TYPE origin) {
/* 227 */     return costDiamond(num, origin, null);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean costDiamond(int num, Const.GOODS_CHANGE_TYPE origin, List<Common.KeyValueStruct> itemChange) {
/* 243 */     if (num == 0) {
/* 244 */       return true;
/*     */     }
/* 246 */     if (!enoughDiamond(num)) {
/* 247 */       return false;
/*     */     }
/* 249 */     int before = (getBaseData()).diamond;
/* 250 */     (getBaseData()).diamond -= num;
/* 251 */     int after = (getBaseData()).diamond;
/* 252 */     Out.info(new Object[] { "cost diamond. id=", this.player.getId(), ",name=", this.player.getName(), ",before=", Integer.valueOf(before), ",value=", Integer.valueOf(num), ",after=", Integer.valueOf(after), ",origin=", Integer.valueOf(origin.value) });
/* 253 */     LogReportService.getInstance().ansycReportMoneyFlow(this.player.getPlayer(), VirtualItemType.DIAMOND, before, 2, num, after, origin.value);
/*     */ 
/*     */     
/* 256 */     if (!Const.GOODS_CHANGE_TYPE.AUCTION.equals(origin) && !Const.GOODS_CHANGE_TYPE.RedPacket.equals(origin)) {
/* 257 */       (getBaseData()).totalCostDiamond += num;
/* 258 */       RechargeActivityService.getInstance().onConsumeEvent(this.player.getId(), num);
/*     */ 
/*     */       
/* 261 */       if (num > AllyConfiguration.getInstance().getConfigI("MinCostDiamond")) {
/* 262 */         int value = num * AllyConfiguration.getInstance().getConfigI("FeeBackRate") / 100;
/* 263 */         DaoYouService.getInstance().calDaoYouRebate(this.player, value);
/*     */       } 
/*     */     } 
/*     */     
/* 267 */     this.player.pushDynamicData("diamond", Integer.valueOf((getBaseData()).diamond), origin, itemChange);
/*     */     
/* 269 */     this.player.sevenGoalManager.processGoal(SevenGoalManager.SevenGoalTaskType.COST_DIAMOND_COUNT, new Object[0]);
/* 270 */     this.player.sevenGoalManager.processGoal(SevenGoalManager.SevenGoalTaskType.COST_DIAMOND_OR_BINDDIAMOND_COUNT, new Object[] { Integer.valueOf(num) });
/* 271 */     return true;
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
/*     */   
/*     */   public void addDiamond(int num, Const.GOODS_CHANGE_TYPE origin) {
/* 284 */     if (num == 0) {
/*     */       return;
/*     */     }
/* 287 */     if (num < 0) {
/* 288 */       throw new HackerException("增加充值元宝时参数小于0.");
/*     */     }
/* 290 */     int before = (getBaseData()).diamond;
/*     */     
/* 292 */     if (0L + (getBaseData()).diamond + num > 2147483647L) {
/* 293 */       (getBaseData()).diamond = Integer.MAX_VALUE;
/*     */     } else {
/* 295 */       (getBaseData()).diamond += num;
/*     */     } 
/* 297 */     int after = (getBaseData()).diamond;
/* 298 */     Out.info(new Object[] { "add diamond. id=", this.player.getId(), ",name=", this.player.getName(), ",before=", Integer.valueOf(before), ",value=", Integer.valueOf(num), ",after=", Integer.valueOf(after), ",origin=", Integer.valueOf(origin.value) });
/* 299 */     LogReportService.getInstance().ansycReportMoneyFlow(this.player.getPlayer(), VirtualItemType.DIAMOND, before, 1, num, after, origin.value);
/*     */     
/* 301 */     this.player.pushDynamicData("diamond", Integer.valueOf((getBaseData()).diamond), origin);
/*     */ 
/*     */     
/* 304 */     (getBaseData()).todayDiamond += num;
/* 305 */     if ((getBaseData()).todayDiamond >= today_max_diamond_threshold) {
/* 306 */       Out.warn(new Object[] { "今日充值元宝收益超过预期值,playerId:", this.player.getId(), ",name:", this.player.getName(), ",todayDiamond:", Integer.valueOf((getBaseData()).todayDiamond), ",max:", Integer.valueOf(today_max_diamond_threshold) });
/* 307 */       LogReportService.getInstance().ansycReportMoneyMonitor(this.player, VirtualItemType.DIAMOND, (getBaseData()).todayDiamond, today_max_diamond_threshold);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getDiamond() {
/* 317 */     return (getBaseData()).diamond;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean enoughTicket(int num) {
/* 327 */     if (num < 0) {
/* 328 */       throw new HackerException("判定玩家身上的绑定元宝是否足够时参数小于0.");
/*     */     }
/* 330 */     return ((getBaseData()).ticket >= num);
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
/*     */ 
/*     */   
/*     */   public boolean costTicket(int num, Const.GOODS_CHANGE_TYPE origin) {
/* 344 */     return costTicket(num, origin, null);
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
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean costTicket(int num, Const.GOODS_CHANGE_TYPE origin, List<Common.KeyValueStruct> itemChange) {
/* 359 */     if (num == 0) {
/* 360 */       return true;
/*     */     }
/* 362 */     if (!enoughTicket(num)) {
/* 363 */       return false;
/*     */     }
/* 365 */     int before = (getBaseData()).ticket;
/* 366 */     (getBaseData()).ticket -= num;
/* 367 */     int after = (getBaseData()).ticket;
/* 368 */     Out.info(new Object[] { "cost ticket. id=", this.player.getId(), ",name=", this.player.getName(), ",before=", Integer.valueOf(before), ",value=", Integer.valueOf(num), ",after=", Integer.valueOf(after), ",origin=", Integer.valueOf(origin.value) });
/* 369 */     LogReportService.getInstance().ansycReportMoneyFlow(this.player.getPlayer(), VirtualItemType.CASH, before, 2, num, after, origin.value);
/*     */     
/* 371 */     this.player.pushDynamicData("ticket", Integer.valueOf((getBaseData()).ticket), origin, itemChange);
/* 372 */     this.player.sevenGoalManager.processGoal(SevenGoalManager.SevenGoalTaskType.COST_DIAMOND_OR_BINDDIAMOND_COUNT, new Object[] { Integer.valueOf(num) });
/* 373 */     return true;
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
/*     */   
/*     */   public void addTicket(int num, Const.GOODS_CHANGE_TYPE origin) {
/* 386 */     if (num == 0) {
/*     */       return;
/*     */     }
/* 389 */     if (num < 0) {
/* 390 */       throw new HackerException("增加绑定元宝时参数小于0.");
/*     */     }
/* 392 */     int before = (getBaseData()).ticket;
/*     */     
/* 394 */     if (0L + (getBaseData()).ticket + num > 2147483647L) {
/* 395 */       (getBaseData()).ticket = Integer.MAX_VALUE;
/*     */     } else {
/* 397 */       (getBaseData()).ticket += num;
/*     */     } 
/* 399 */     int after = (getBaseData()).ticket;
/* 400 */     Out.info(new Object[] { "add ticket. id=", this.player.getId(), ",name=", this.player.getName(), ",before=", Integer.valueOf(before), ",value=", Integer.valueOf(num), ",after=", Integer.valueOf(after), ",origin=", Integer.valueOf(origin.value) });
/* 401 */     LogReportService.getInstance().ansycReportMoneyFlow(this.player.getPlayer(), VirtualItemType.CASH, before, 1, num, after, origin.value);
/*     */     
/* 403 */     if (origin != Const.GOODS_CHANGE_TYPE.monsterdrop) {
/* 404 */       this.player.customTip(Const.CUSTOMTIPTYPE.TICKET, num);
/*     */     }
/* 406 */     this.player.pushDynamicData("ticket", Integer.valueOf((getBaseData()).ticket), origin);
/*     */ 
/*     */     
/* 409 */     (getBaseData()).todayTicket += num;
/* 410 */     if ((getBaseData()).todayTicket >= today_max_kicket_threshold) {
/* 411 */       Out.warn(new Object[] { "今日绑定元宝收益超过预期值,playerId:", this.player.getId(), ",name:", this.player.getName(), ",todayTicket:", Integer.valueOf((getBaseData()).todayTicket), ",max:", Integer.valueOf(today_max_kicket_threshold) });
/* 412 */       LogReportService.getInstance().ansycReportMoneyMonitor(this.player, VirtualItemType.CASH, (getBaseData()).todayTicket, today_max_kicket_threshold);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTicket() {
/* 422 */     return (getBaseData()).ticket;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean enoughTicketAndDiamond(int num) {
/* 433 */     if (num < 0) {
/* 434 */       throw new HackerException("判定玩家身上的（绑定元宝+充值元宝）总和是否足够时参数小于0.");
/*     */     }
/* 436 */     return (0L + (getBaseData()).ticket + (getBaseData()).diamond >= num);
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
/*     */ 
/*     */   
/*     */   public CostResult costTicketAndDiamond(int num, Const.GOODS_CHANGE_TYPE origin) {
/* 450 */     return costTicketAndDiamond(num, origin, null);
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
/*     */ 
/*     */ 
/*     */   
/*     */   public CostResult costTicketAndDiamond(int num, Const.GOODS_CHANGE_TYPE origin, List<Common.KeyValueStruct> itemChange) {
/* 465 */     if (num == 0) {
/* 466 */       return new CostResult(true);
/*     */     }
/*     */     
/* 469 */     if (costTicket(num, origin, itemChange)) {
/* 470 */       return (new CostResult(true)).addValue(VirtualItemType.CASH, num);
/*     */     }
/*     */ 
/*     */     
/* 474 */     if (!enoughTicketAndDiamond(num)) {
/* 475 */       return new CostResult(false);
/*     */     }
/*     */ 
/*     */     
/* 479 */     int ticket = getTicket();
/* 480 */     if (ticket > 0) {
/* 481 */       costTicket(ticket, origin, itemChange);
/*     */     }
/*     */     
/* 484 */     int diamond = num - ticket;
/* 485 */     costDiamond(diamond, origin, itemChange);
/*     */     
/* 487 */     return (new CostResult(true)).addValue(VirtualItemType.CASH, ticket).addValue(VirtualItemType.DIAMOND, diamond);
/*     */   }
/*     */ 
/*     */   
/*     */   public void refreshNewDay() {
/* 492 */     Out.info(new Object[] { "每日监控收入值清零，roleId=", this.player.getId(), ",todayDiamond=", Integer.valueOf((getBaseData()).todayDiamond), ",todayTicket=", Integer.valueOf((getBaseData()).todayTicket), ",todayGold=", Integer.valueOf((getBaseData()).todayGold) });
/* 493 */     (getBaseData()).todayDiamond = 0;
/* 494 */     (getBaseData()).todayTicket = 0;
/* 495 */     (getBaseData()).todayGold = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addConsumePoint(int num, Const.GOODS_CHANGE_TYPE origin) {
/* 505 */     if (num == 0) {
/*     */       return;
/*     */     }
/* 508 */     if (num < 0) {
/* 509 */       throw new HackerException("增加消费积分时参数小于0.");
/*     */     }
/*     */     
/* 512 */     int before = (getBaseData()).consumePoint;
/*     */     
/* 514 */     if (0L + (getBaseData()).consumePoint + num > 2147483647L) {
/* 515 */       (getBaseData()).consumePoint = Integer.MAX_VALUE;
/*     */     } else {
/* 517 */       (getBaseData()).consumePoint += num;
/*     */     } 
/* 519 */     int after = (getBaseData()).consumePoint;
/* 520 */     Out.info(new Object[] { "add consumePoint. id=", this.player.getId(), ",name=", this.player.getName(), ",before=", Integer.valueOf(before), ",value=", Integer.valueOf(num), ",after=", Integer.valueOf(after), ",origin=", Integer.valueOf(origin.value) });
/* 521 */     LogReportService.getInstance().ansycReportMoneyFlow(this.player.getPlayer(), VirtualItemType.CONSUMEPOINT, before, 1, num, after, origin.value);
/*     */     
/* 523 */     pushDynamicDataByConsumePoint(origin);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean enoughConsumePoint(int num) {
/* 530 */     if (num < 0) {
/* 531 */       throw new HackerException("判定玩家身上的消费积分是否足够时参数小于0.");
/*     */     }
/* 533 */     return (getConsumePoint() >= num);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean costConsumePoint(int num, Const.GOODS_CHANGE_TYPE origin) {
/* 540 */     if (num == 0) {
/* 541 */       return false;
/*     */     }
/* 543 */     if (!enoughConsumePoint(num)) {
/* 544 */       return false;
/*     */     }
/*     */     
/* 547 */     int before = (getBaseData()).consumePoint;
/* 548 */     (getBaseData()).consumePoint -= num;
/* 549 */     int after = (getBaseData()).consumePoint;
/* 550 */     Out.info(new Object[] { "cost consumePoint. id=", this.player.getId(), ",name=", this.player.getName(), ",before=", Integer.valueOf(before), ",value=", Integer.valueOf(num), ",after=", Integer.valueOf(after), ",origin=", Integer.valueOf(origin.value) });
/* 551 */     LogReportService.getInstance().ansycReportMoneyFlow(this.player.getPlayer(), VirtualItemType.CONSUMEPOINT, before, 2, num, after, origin.value);
/*     */ 
/*     */     
/* 554 */     pushDynamicDataByConsumePoint(origin);
/* 555 */     return true;
/*     */   }
/*     */   
/*     */   private void pushDynamicDataByConsumePoint(Const.GOODS_CHANGE_TYPE origin) {
/* 559 */     this.player.pushDynamicData("consumePoint", Integer.valueOf((getBaseData()).consumePoint));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getConsumePoint() {
/* 568 */     return (getBaseData()).consumePoint;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private XianYuanPO getXianYuanPo() {
/* 577 */     return this.player.allBlobData.xianYuan;
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
/*     */   public void addXianYuan(int num, Const.GOODS_CHANGE_TYPE origin) {
/* 589 */     addXianYuan(num, origin, -1);
/*     */   }
/*     */   
/*     */   public void addXianYuan(int num, Const.GOODS_CHANGE_TYPE origin, int from) {
/* 593 */     if (num == 0) {
/*     */       return;
/*     */     }
/* 596 */     if (num < 0) {
/* 597 */       throw new HackerException("增加仙缘时参数小于0.");
/*     */     }
/*     */     
/* 600 */     XianYuanPO po = getXianYuanPo();
/*     */     
/* 602 */     int before = po.xianYuanNum;
/*     */     
/* 604 */     if (0L + po.xianYuanNum + num > 2147483647L) {
/* 605 */       po.xianYuanNum = Integer.MAX_VALUE;
/*     */     } else {
/* 607 */       po.xianYuanNum += num;
/*     */     } 
/* 609 */     int after = po.xianYuanNum;
/*     */     
/* 611 */     Out.info(new Object[] { "add xianyuan. id=", this.player.getId(), ",name=", this.player.getName(), ",before=", Integer.valueOf(before), ",value=", Integer.valueOf(num), ",after=", Integer.valueOf(after), ",origin=", Integer.valueOf(origin.value), ",from=", Integer.valueOf(from) });
/* 612 */     LogReportService.getInstance().ansycReportMoneyFlow(this.player.getPlayer(), VirtualItemType.FATE, before, 1, num, after, origin.value);
/*     */ 
/*     */     
/* 615 */     po.sumXianYuan += num;
/* 616 */     po.updateTime = new Date();
/*     */     
/* 618 */     this.player.rankManager.onEvent(RankType.XIANYUAN, new Object[] { Integer.valueOf(po.sumXianYuan) });
/*     */ 
/*     */     
/* 621 */     this.player.pushDynamicData("fate", Integer.valueOf(num));
/*     */     
/* 623 */     this.player.achievementManager.onXianyuanChange(num);
/*     */     
/* 625 */     this.player.sevenGoalManager.processGoal(SevenGoalManager.SevenGoalTaskType.XIANYUAN_TO, new Object[] { Integer.valueOf(num) });
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
/*     */   public void addXianYuan(int num, int from) {
/* 637 */     addXianYuan(num, Const.GOODS_CHANGE_TYPE.def, from);
/*     */     
/* 639 */     XianYuanPO xianYuanPo = getXianYuanPo();
/* 640 */     if (xianYuanPo.reviceNumbers == null) {
/* 641 */       xianYuanPo.reviceNumbers = new HashMap<>();
/*     */     }
/* 643 */     xianYuanPo.reviceNumbers.compute(Integer.valueOf(from), (k, v) -> Integer.valueOf((v == null) ? num : (v.intValue() + num)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean enoughXianYuan(int num) {
/* 650 */     if (num < 0) {
/* 651 */       throw new HackerException("判定玩家身上的仙缘值是否足够时参数小于0.");
/*     */     }
/* 653 */     return (getXianYuan() >= num);
/*     */   }
/*     */   
/*     */   public int getXianYuan() {
/* 657 */     return (getXianYuanPo()).xianYuanNum;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean costXianYuan(int num, Const.GOODS_CHANGE_TYPE origin) {
/* 664 */     if (num == 0) {
/* 665 */       return false;
/*     */     }
/* 667 */     if (!enoughXianYuan(num)) {
/* 668 */       return false;
/*     */     }
/* 670 */     XianYuanPO po = getXianYuanPo();
/* 671 */     int before = po.xianYuanNum;
/* 672 */     po.xianYuanNum -= num;
/* 673 */     int after = po.xianYuanNum;
/* 674 */     Out.info(new Object[] { "cost xianyuan. id=", this.player.getId(), ",name=", this.player.getName(), ",before=", Integer.valueOf(before), ",value=", Integer.valueOf(num), ",after=", Integer.valueOf(after), ",origin=", Integer.valueOf(origin.value) });
/* 675 */     LogReportService.getInstance().ansycReportMoneyFlow(this.player.getPlayer(), VirtualItemType.FATE, before, 2, num, after, origin.value);
/*     */     
/* 677 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\money\MoneyManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */