/*     */ package com.wanniu.game.activity;
/*     */ 
/*     */ import com.alibaba.fastjson.JSON;
/*     */ import com.wanniu.core.game.LangService;
/*     */ import com.wanniu.core.game.entity.GEntity;
/*     */ import com.wanniu.core.game.protocol.PomeloResponse;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.game.GWorld;
/*     */ import com.wanniu.game.bag.WNBag;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.ConstsTR;
/*     */ import com.wanniu.game.common.msg.ErrorResponse;
/*     */ import com.wanniu.game.data.AddRechargeLimitCO;
/*     */ import com.wanniu.game.data.GameData;
/*     */ import com.wanniu.game.data.RevelryCO;
/*     */ import com.wanniu.game.data.StartSerRechargeCO;
/*     */ import com.wanniu.game.data.ext.ActivityConfigExt;
/*     */ import com.wanniu.game.data.ext.ActivityExt;
/*     */ import com.wanniu.game.item.ItemUtil;
/*     */ import com.wanniu.game.item.NormalItem;
/*     */ import com.wanniu.game.player.GlobalConfig;
/*     */ import com.wanniu.game.player.PlayerUtil;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.poes.ContinuousRechargePO;
/*     */ import com.wanniu.game.poes.RechargeActivityPO;
/*     */ import com.wanniu.game.poes.RevelryRechargePO;
/*     */ import com.wanniu.game.poes.SingleRechargePO;
/*     */ import com.wanniu.game.poes.TotalConsumePO;
/*     */ import com.wanniu.game.poes.TotalRechargePO;
/*     */ import com.wanniu.redis.PlayerPOManager;
/*     */ import java.time.LocalDate;
/*     */ import java.time.temporal.ChronoUnit;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.lang3.time.DateUtils;
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
/*     */ 
/*     */ 
/*     */ public class RechargeActivityService
/*     */ {
/*  62 */   private static final RechargeActivityService instance = new RechargeActivityService();
/*     */   
/*     */   private static final int STATE_NOT_COMPLETE = 0;
/*     */   
/*     */   private static final int STATE_COMPLETED = 1;
/*     */   
/*     */   private static final int STATE_RECEIVED = 2;
/*     */   
/*     */   public static RechargeActivityService getInstance() {
/*  71 */     return instance;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onPayEvent(String playerId, int todayPayRmb, int payRmb) {
/*  82 */     RechargeActivityPO po = getRechargeActivityPO(playerId);
/*  83 */     long now = System.currentTimeMillis();
/*     */ 
/*     */     
/*  86 */     if (inContinuousTime(now)) {
/*  87 */       onContinuousRecharge(playerId, po, todayPayRmb);
/*     */     }
/*     */ 
/*     */     
/*  91 */     if (inSingleTime(now)) {
/*  92 */       onSingleRecharge(playerId, po, payRmb);
/*     */     }
/*     */ 
/*     */     
/*  96 */     if (inActvityTime(Const.ActivityRewardType.TOTAL_PAY, now)) {
/*  97 */       onTotalRecharge(playerId, po, payRmb);
/*     */     }
/*     */ 
/*     */     
/* 101 */     if (inRevelayTime()) {
/* 102 */       onRevelryRecharge(playerId, po, todayPayRmb);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onConsumeEvent(String playerId, int value) {
/* 110 */     RechargeActivityPO po = getRechargeActivityPO(playerId);
/* 111 */     long now = System.currentTimeMillis();
/*     */ 
/*     */     
/* 114 */     if (inActvityTime(Const.ActivityRewardType.TOTAL_CONSUME, now)) {
/* 115 */       onTotalConsume(playerId, po, value);
/*     */     }
/*     */   }
/*     */   
/*     */   private void onTotalConsume(String playerId, RechargeActivityPO po, int value) {
/* 120 */     refreshTotalConsumePO(playerId, po);
/* 121 */     TotalConsumePO info = po.totalConsume;
/* 122 */     info.setRmb(info.getRmb() + value);
/* 123 */     Out.info(new Object[] { "累计消耗金额变更 playerId=", playerId, ", rmb=", Integer.valueOf(info.getRmb()) });
/*     */   }
/*     */   
/*     */   private void refreshTotalConsumePO(String playerId, RechargeActivityPO po) {
/* 127 */     if (po.totalConsume == null || !inActvityTime(Const.ActivityRewardType.TOTAL_CONSUME, po.totalConsume.getDate().getTime())) {
/* 128 */       Out.info(new Object[] { "重置累计消耗PO playerId=", playerId, ", po=", JSON.toJSONString(po.totalConsume) });
/* 129 */       po.totalConsume = new TotalConsumePO();
/* 130 */       po.totalConsume.setDate(new Date());
/* 131 */       po.totalConsume.setRmb(0);
/*     */     } 
/*     */   }
/*     */   
/*     */   public int getTotalConsumeValue(String playerId) {
/* 136 */     RechargeActivityPO po = getRechargeActivityPO(playerId);
/* 137 */     if (po.totalConsume == null) {
/* 138 */       return 0;
/*     */     }
/* 140 */     refreshTotalConsumePO(playerId, po);
/* 141 */     return po.totalConsume.getRmb();
/*     */   }
/*     */   
/*     */   private void onTotalRecharge(String playerId, RechargeActivityPO po, int payRmb) {
/* 145 */     refreshTotalRechargePO(playerId, po);
/* 146 */     TotalRechargePO info = po.totalRecharge;
/* 147 */     info.setRmb(info.getRmb() + payRmb);
/* 148 */     Out.info(new Object[] { "累计充值金额变更 playerId=", playerId, ", rmb=", Integer.valueOf(info.getRmb()) });
/*     */   }
/*     */ 
/*     */   
/*     */   private void refreshTotalRechargePO(String playerId, RechargeActivityPO po) {
/* 153 */     if (po.totalRecharge == null || !inActvityTime(Const.ActivityRewardType.TOTAL_PAY, po.totalRecharge.getDate().getTime())) {
/* 154 */       Out.info(new Object[] { "重置累计充值PO playerId=", playerId, ", po=", JSON.toJSONString(po.totalRecharge) });
/* 155 */       po.totalRecharge = new TotalRechargePO();
/* 156 */       po.totalRecharge.setDate(new Date());
/* 157 */       po.totalRecharge.setRmb(0);
/*     */     } 
/*     */   }
/*     */   
/*     */   public int getTotalPayValue(String playerId) {
/* 162 */     RechargeActivityPO po = getRechargeActivityPO(playerId);
/* 163 */     if (po.totalRecharge == null) {
/* 164 */       return 0;
/*     */     }
/* 166 */     refreshTotalRechargePO(playerId, po);
/* 167 */     return po.totalRecharge.getRmb();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean inActvityTime(Const.ActivityRewardType type, long time) {
/* 174 */     List<ActivityExt> props = GameData.findActivitys(t -> (t.activityTab == type.getValue()));
/* 175 */     if (props.isEmpty()) {
/* 176 */       return false;
/*     */     }
/* 178 */     ActivityExt activityExt = props.get(0);
/* 179 */     if (activityExt == null) {
/* 180 */       return false;
/*     */     }
/* 182 */     if (activityExt.beginTime > time) {
/* 183 */       return false;
/*     */     }
/* 185 */     if (activityExt.endTime < time) {
/* 186 */       return false;
/*     */     }
/* 188 */     return true;
/*     */   }
/*     */   
/*     */   private void onContinuousRecharge(String playerId, RechargeActivityPO po, int rmb) {
/* 192 */     refreshContinuousRechargePO(po);
/*     */     
/* 194 */     ContinuousRechargePO info = po.continuousRecharge;
/*     */     
/* 196 */     if (((Integer)info.getState().getOrDefault(Integer.valueOf(info.getDay()), Integer.valueOf(0))).intValue() == 0) {
/* 197 */       AddRechargeLimitCO template = getAddRechargeLimitCO(info.getDay());
/*     */       
/* 199 */       if (template != null && template.rechargeLimit * 100 <= rmb) {
/* 200 */         info.getState().put(Integer.valueOf(info.getDay()), Integer.valueOf(1));
/* 201 */         info.setDate(new Date());
/*     */ 
/*     */         
/* 204 */         boolean flag = true;
/* 205 */         for (AddRechargeLimitCO temlate : GameData.AddRechargeLimits.values()) {
/* 206 */           if (((Integer)po.continuousRecharge.getState().getOrDefault(Integer.valueOf(temlate.addTime), Integer.valueOf(0))).intValue() == 0) {
/* 207 */             flag = false;
/*     */             
/*     */             break;
/*     */           } 
/*     */         } 
/* 212 */         if (flag) {
/* 213 */           info.getState().put(Integer.valueOf(0), Integer.valueOf(1));
/*     */         }
/*     */ 
/*     */         
/* 217 */         WNPlayer player = PlayerUtil.getOnlinePlayer(playerId);
/* 218 */         if (player != null) {
/* 219 */           player.updateSuperScript(Const.SUPERSCRIPT_TYPE.CONTINUOUS_RECHARGE, 2);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private AddRechargeLimitCO getAddRechargeLimitCO(int day) {
/* 226 */     List<AddRechargeLimitCO> ts = GameData.findAddRechargeLimits(v -> (day == v.addTime));
/* 227 */     if (!ts.isEmpty()) {
/* 228 */       return ts.get(0);
/*     */     }
/* 230 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void refreshContinuousRechargePO(RechargeActivityPO po) {
/* 236 */     if (po.continuousRecharge == null || !inContinuousTime(po.continuousRecharge.getDate().getTime())) {
/* 237 */       po.continuousRecharge = new ContinuousRechargePO();
/* 238 */       po.continuousRecharge.setDate(new Date());
/* 239 */       po.continuousRecharge.setDay(1);
/* 240 */       po.continuousRecharge.setState(new HashMap<>());
/*     */     } else {
/* 242 */       ContinuousRechargePO info = po.continuousRecharge;
/*     */       
/* 244 */       if (((Integer)info.getState().getOrDefault(Integer.valueOf(info.getDay()), Integer.valueOf(0))).intValue() > 0 && 
/* 245 */         !DateUtils.isSameDay(info.getDate(), new Date())) {
/* 246 */         info.setDate(new Date());
/* 247 */         info.setDay(info.getDay() + 1);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public RechargeActivityPO getRechargeActivityPO(String playerId) {
/* 254 */     RechargeActivityPO po = (RechargeActivityPO)PlayerPOManager.findPO(ConstsTR.playerRechargeActivityTR, playerId, RechargeActivityPO.class);
/* 255 */     if (po == null) {
/* 256 */       po = new RechargeActivityPO();
/* 257 */       PlayerPOManager.put(ConstsTR.playerRechargeActivityTR, playerId, (GEntity)po);
/*     */     } 
/* 259 */     return po;
/*     */   }
/*     */ 
/*     */   
/*     */   public Map<Integer, Integer> getContinuousRechargeInfo(String playerId) {
/* 264 */     if (!inContinuousTime(System.currentTimeMillis())) {
/* 265 */       return Collections.emptyMap();
/*     */     }
/*     */     
/* 268 */     RechargeActivityPO po = getRechargeActivityPO(playerId);
/* 269 */     refreshContinuousRechargePO(po);
/*     */ 
/*     */     
/* 272 */     return po.continuousRecharge.getState();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getContinuousRechargeDay(String playerId) {
/* 277 */     if (!inContinuousTime(System.currentTimeMillis())) {
/* 278 */       return 0;
/*     */     }
/*     */     
/* 281 */     RechargeActivityPO po = getRechargeActivityPO(playerId);
/* 282 */     refreshContinuousRechargePO(po);
/*     */     
/* 284 */     return po.continuousRecharge.getDay();
/*     */   }
/*     */   
/*     */   private boolean inContinuousTime(long time) {
/* 288 */     int day = getOpenServerDay();
/* 289 */     return (0 < day && day <= 7);
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
/*     */   public PomeloResponse receiveContinuousRecharge(WNPlayer player, int day) {
/*     */     String reward;
/* 302 */     RechargeActivityPO po = getRechargeActivityPO(player.getId());
/* 303 */     if (po == null) {
/* 304 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("PARAM_ERROR"));
/*     */     }
/*     */     
/* 307 */     if (po.continuousRecharge == null) {
/* 308 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("PARAM_ERROR"));
/*     */     }
/*     */ 
/*     */     
/* 312 */     if (((Integer)po.continuousRecharge.getState().getOrDefault(Integer.valueOf(day), Integer.valueOf(0))).intValue() != 1) {
/* 313 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("PARAM_ERROR"));
/*     */     }
/*     */ 
/*     */     
/* 317 */     po.continuousRecharge.getState().put(Integer.valueOf(day), Integer.valueOf(2));
/* 318 */     Out.info(new Object[] { "领取连续充值奖励，playerId=", player.getId(), ", day=", Integer.valueOf(day) });
/*     */ 
/*     */ 
/*     */     
/* 322 */     if (day > 0) {
/* 323 */       AddRechargeLimitCO template = getAddRechargeLimitCO(day);
/* 324 */       reward = template.rechargeFReward;
/*     */     } else {
/* 326 */       reward = GlobalConfig.AddRecharge_Reward;
/*     */     } 
/*     */     
/* 329 */     List<NormalItem> result = new ArrayList<>();
/* 330 */     String[] strs1 = reward.split(",");
/* 331 */     for (String strs1_item : strs1) {
/* 332 */       String[] strs2 = strs1_item.split(":");
/* 333 */       result.addAll(ItemUtil.createItemsByItemCode(strs2[0], Integer.parseInt(strs2[1])));
/*     */     } 
/* 335 */     player.bag.addCodeItemMail(result, Const.ForceType.BIND, Const.GOODS_CHANGE_TYPE.ContinuousRecharge, "Bag_full_common");
/*     */ 
/*     */     
/* 338 */     onLogin(player);
/*     */     
/* 340 */     return null;
/*     */   }
/*     */   
/*     */   public Map<Integer, Integer> getSingleRechargeInfo(String playerId) {
/* 344 */     RechargeActivityPO po = getRechargeActivityPO(playerId);
/* 345 */     refreshSingleRechargePO(po);
/*     */     
/* 347 */     return po.singleRecharge.getState();
/*     */   }
/*     */ 
/*     */   
/*     */   private void refreshSingleRechargePO(RechargeActivityPO po) {
/* 352 */     if (po.singleRecharge == null || !inSingleTime(po.singleRecharge.getDate().getTime())) {
/* 353 */       po.singleRecharge = new SingleRechargePO();
/* 354 */       po.singleRecharge.setDate(new Date());
/* 355 */       po.singleRecharge.setState(new HashMap<>());
/*     */     } 
/*     */   }
/*     */   
/*     */   private boolean inSingleTime(long time) {
/* 360 */     List<ActivityExt> props = GameData.findActivitys(t -> (t.activityTab == Const.ActivityRewardType.SINGLE_RECHARGE.getValue()));
/* 361 */     if (props.isEmpty()) {
/* 362 */       return false;
/*     */     }
/* 364 */     ActivityExt activityExt = props.get(0);
/* 365 */     if (activityExt == null) {
/* 366 */       return false;
/*     */     }
/* 368 */     if (activityExt.beginTime > time) {
/* 369 */       return false;
/*     */     }
/* 371 */     if (activityExt.endTime < time) {
/* 372 */       return false;
/*     */     }
/* 374 */     return true;
/*     */   }
/*     */   
/*     */   private void onSingleRecharge(String playerId, RechargeActivityPO po, int payRmb) {
/* 378 */     List<ActivityExt> props = GameData.findActivitys(t -> (t.activityTab == Const.ActivityRewardType.SINGLE_RECHARGE.getValue()));
/* 379 */     if (props.isEmpty()) {
/*     */       return;
/*     */     }
/* 382 */     ActivityExt activityExt = props.get(0);
/* 383 */     if (activityExt == null) {
/*     */       return;
/*     */     }
/* 386 */     List<ActivityConfigExt> activityConfigExts = GameData.findActivityConfigs(t -> (t.type == activityExt.activityID && payRmb == t.parameter1 * 100));
/* 387 */     if (activityConfigExts.isEmpty()) {
/*     */       return;
/*     */     }
/*     */     
/* 391 */     ActivityConfigExt template = activityConfigExts.get(0);
/*     */     
/* 393 */     refreshSingleRechargePO(po);
/*     */     
/* 395 */     SingleRechargePO info = po.singleRecharge;
/*     */ 
/*     */     
/* 398 */     if (((Integer)info.getState().getOrDefault(Integer.valueOf(template.id), Integer.valueOf(0))).intValue() == 0) {
/* 399 */       info.getState().put(Integer.valueOf(template.id), Integer.valueOf(1));
/* 400 */       Out.info(new Object[] { "完成单笔充值活动 playerId=", playerId, ", id=", Integer.valueOf(template.id), ", rmb=", Integer.valueOf(payRmb) });
/*     */       
/* 402 */       WNPlayer player = PlayerUtil.getOnlinePlayer(playerId);
/* 403 */       if (player != null) {
/* 404 */         player.activityManager.updateSuperScriptList();
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public int getSingleRechargeRedPoint(String playerId) {
/* 410 */     RechargeActivityPO po = (RechargeActivityPO)PlayerPOManager.findPO(ConstsTR.playerRechargeActivityTR, playerId, RechargeActivityPO.class);
/* 411 */     if (po == null) {
/* 412 */       return 0;
/*     */     }
/* 414 */     if (po.singleRecharge == null) {
/* 415 */       return 0;
/*     */     }
/* 417 */     if (!inSingleTime(System.currentTimeMillis())) {
/* 418 */       return 0;
/*     */     }
/* 420 */     refreshSingleRechargePO(po);
/* 421 */     for (Integer i : po.singleRecharge.getState().values()) {
/* 422 */       if (i.intValue() == 1) {
/* 423 */         return 1;
/*     */       }
/*     */     } 
/* 426 */     return 0;
/*     */   }
/*     */   
/*     */   public PomeloResponse receiveSingleRecharge(WNPlayer player, int id) {
/* 430 */     List<ActivityConfigExt> activityConfigExts = GameData.findActivityConfigs(t -> (t.id == id));
/* 431 */     if (activityConfigExts.isEmpty()) {
/* 432 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("PARAM_ERROR"));
/*     */     }
/*     */     
/* 435 */     RechargeActivityPO po = getRechargeActivityPO(player.getId());
/* 436 */     if (po == null) {
/* 437 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("PARAM_ERROR"));
/*     */     }
/*     */     
/* 440 */     if (po.singleRecharge == null) {
/* 441 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("PARAM_ERROR"));
/*     */     }
/*     */ 
/*     */     
/* 445 */     if (((Integer)po.singleRecharge.getState().getOrDefault(Integer.valueOf(id), Integer.valueOf(0))).intValue() != 1) {
/* 446 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("PARAM_ERROR"));
/*     */     }
/*     */ 
/*     */     
/* 450 */     po.singleRecharge.getState().put(Integer.valueOf(id), Integer.valueOf(2));
/* 451 */     Out.info(new Object[] { "领取单笔充值奖励 playerId=", player.getId(), ", id=", Integer.valueOf(id) });
/*     */     
/* 453 */     ActivityConfigExt template = activityConfigExts.get(0);
/*     */     
/* 455 */     ArrayList<WNBag.SimpleItemInfo> reward = player.activityManager.getRankReward(template.RankReward);
/* 456 */     List<NormalItem> result = new ArrayList<>();
/* 457 */     for (WNBag.SimpleItemInfo sii : reward) {
/* 458 */       result.addAll(ItemUtil.createItemsByItemCode(sii.itemCode, sii.itemNum));
/*     */     }
/* 460 */     player.bag.addCodeItemMail(result, Const.ForceType.BIND, Const.GOODS_CHANGE_TYPE.SingleRecharge, "Bag_full_common");
/* 461 */     return null;
/*     */   }
/*     */   
/*     */   public void onLogin(WNPlayer player) {
/* 465 */     int value = 0;
/* 466 */     if (inContinuousTime(System.currentTimeMillis())) {
/* 467 */       value = 1;
/*     */       
/* 469 */       RechargeActivityPO po = getRechargeActivityPO(player.getId());
/* 470 */       refreshContinuousRechargePO(po);
/* 471 */       for (Iterator<Integer> iterator = po.continuousRecharge.getState().values().iterator(); iterator.hasNext(); ) { int v = ((Integer)iterator.next()).intValue();
/* 472 */         if (v == 1) {
/* 473 */           value = 2;
/*     */           
/*     */           break;
/*     */         }  }
/*     */     
/*     */     } 
/* 479 */     player.updateSuperScript(Const.SUPERSCRIPT_TYPE.CONTINUOUS_RECHARGE, value);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getOpenServerDay() {
/* 485 */     return (int)ChronoUnit.DAYS.between(GWorld.OPEN_SERVER_DATE, LocalDate.now()) + 1;
/*     */   }
/*     */   
/*     */   public Map<Integer, String> getAllColumn() {
/* 489 */     Map<Integer, String> result = new HashMap<>();
/* 490 */     for (StartSerRechargeCO template : GameData.StartSerRecharges.values()) {
/* 491 */       result.put(Integer.valueOf(template.date), template.showDate);
/*     */     }
/* 493 */     return result;
/*     */   }
/*     */   
/*     */   public RevelryRechargePO getRevelryRechargeInfo(String playerId, int day) {
/* 497 */     RechargeActivityPO po = getRechargeActivityPO(playerId);
/* 498 */     if (po.revelryRecharge == null) {
/* 499 */       return null;
/*     */     }
/* 501 */     return (RevelryRechargePO)po.revelryRecharge.get(Integer.valueOf(day));
/*     */   }
/*     */   
/*     */   private boolean inRevelayTime() {
/* 505 */     LocalDate openServerDate = GWorld.OPEN_SERVER_DATE;
/* 506 */     LocalDate now = LocalDate.now();
/* 507 */     return GameData.Revelrys.values().stream().filter(v -> (v.isOpen == 1 && now.isBefore(openServerDate.plusDays(v.endDays2)))).findFirst().isPresent();
/*     */   }
/*     */   
/*     */   private void onRevelryRecharge(String playerId, RechargeActivityPO po, int todayPayRmb) {
/* 511 */     refreshRevelryRechargePO(po);
/* 512 */     Integer day = Integer.valueOf(getOpenServerDay());
/* 513 */     RevelryRechargePO info = (RevelryRechargePO)po.revelryRecharge.get(day);
/* 514 */     if (info == null) {
/* 515 */       info = new RevelryRechargePO();
/* 516 */       info.setState(new HashMap<>());
/* 517 */       po.revelryRecharge.put(day, info);
/*     */     } 
/* 519 */     info.setRmb(todayPayRmb);
/*     */     
/* 521 */     boolean flag = false;
/* 522 */     for (StartSerRechargeCO template : GameData.findStartSerRecharges(v -> (v.date == day.intValue()))) {
/* 523 */       if (info.getRmb() >= template.rechargeNumber * 100 && (
/* 524 */         (Integer)info.getState().getOrDefault(Integer.valueOf(template.iD), Integer.valueOf(0))).intValue() == 0) {
/* 525 */         info.getState().put(Integer.valueOf(template.iD), Integer.valueOf(1));
/* 526 */         flag = true;
/*     */       } 
/*     */     } 
/*     */     
/* 530 */     if (flag) {
/* 531 */       WNPlayer player = PlayerUtil.getOnlinePlayer(playerId);
/* 532 */       if (player != null) {
/* 533 */         player.activityManager.updateSuperScriptList();
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   private void refreshRevelryRechargePO(RechargeActivityPO po) {
/* 539 */     if (po.revelryRecharge == null) {
/* 540 */       po.revelryRecharge = new HashMap<>();
/*     */     }
/*     */   }
/*     */   
/*     */   public PomeloResponse receiveRevelryRecharge(WNPlayer player, int id) {
/* 545 */     List<StartSerRechargeCO> templates = GameData.findStartSerRecharges(v -> (v.iD == id));
/* 546 */     if (templates.isEmpty()) {
/* 547 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("PARAM_ERROR"));
/*     */     }
/*     */     
/* 550 */     StartSerRechargeCO template = templates.get(0);
/* 551 */     if (template == null) {
/* 552 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("PARAM_ERROR"));
/*     */     }
/*     */     
/* 555 */     RevelryRechargePO po = getRevelryRechargeInfo(player.getId(), template.date);
/* 556 */     if (po == null) {
/* 557 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("PARAM_ERROR"));
/*     */     }
/*     */     
/* 560 */     if (((Integer)po.getState().getOrDefault(Integer.valueOf(template.iD), Integer.valueOf(0))).intValue() == 1) {
/* 561 */       po.getState().put(Integer.valueOf(template.iD), Integer.valueOf(2));
/* 562 */       Out.info(new Object[] { "领取开服狂欢的充值奖励，playerId=", player.getId(), ", day=", Integer.valueOf(template.date), ", id=", Integer.valueOf(template.iD) });
/*     */       
/* 564 */       List<NormalItem> result = new ArrayList<>();
/* 565 */       result.addAll(ItemUtil.createItemsByItemCode(template.reward1, template.num1));
/* 566 */       result.addAll(ItemUtil.createItemsByItemCode(template.reward2, template.num2));
/* 567 */       result.addAll(ItemUtil.createItemsByItemCode(template.reward3, template.num3));
/* 568 */       result.addAll(ItemUtil.createItemsByItemCode(template.reward4, template.num4));
/* 569 */       result.addAll(ItemUtil.createItemsByItemCode(template.reward5, template.num5));
/* 570 */       player.bag.addCodeItemMail(result, Const.ForceType.BIND, Const.GOODS_CHANGE_TYPE.RevelryRecharge, "Bag_full_common");
/*     */     } 
/*     */ 
/*     */     
/* 574 */     player.activityManager.updateSuperScriptList();
/* 575 */     return null;
/*     */   }
/*     */   
/*     */   public int getRevelryRechargeRedPoint(String playerId) {
/* 579 */     RechargeActivityPO po = (RechargeActivityPO)PlayerPOManager.findPO(ConstsTR.playerRechargeActivityTR, playerId, RechargeActivityPO.class);
/* 580 */     if (po == null) {
/* 581 */       return 0;
/*     */     }
/* 583 */     if (po.revelryRecharge == null) {
/* 584 */       return 0;
/*     */     }
/* 586 */     if (!inRevelayTime()) {
/* 587 */       return 0;
/*     */     }
/* 589 */     for (RevelryRechargePO p : po.revelryRecharge.values()) {
/* 590 */       for (Integer i : p.getState().values()) {
/* 591 */         if (i.intValue() == 1) {
/* 592 */           return 1;
/*     */         }
/*     */       } 
/*     */     } 
/* 596 */     return 0;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\activity\RechargeActivityService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */