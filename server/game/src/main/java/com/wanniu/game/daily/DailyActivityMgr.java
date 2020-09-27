/*     */ package com.wanniu.game.daily;
/*     */ 
/*     */ import com.alibaba.fastjson.JSONObject;
/*     */ import com.google.protobuf.GeneratedMessage;
/*     */ import com.wanniu.core.game.LangService;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.util.DateUtil;
/*     */ import com.wanniu.game.attendance.PlayerAttendance;
/*     */ import com.wanniu.game.common.CommonUtil;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.data.GameData;
/*     */ import com.wanniu.game.data.ext.ScheduleExt;
/*     */ import com.wanniu.game.data.ext.VitBonusExt;
/*     */ import com.wanniu.game.player.PlayerUtil;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.poes.DailyActivityPO;
/*     */ import com.wanniu.game.poes.PlayerPO;
/*     */ import com.wanniu.game.rich.RichManager;
/*     */ import com.wanniu.game.sevengoal.SevenGoalManager;
/*     */ import io.netty.util.internal.StringUtil;
/*     */ import java.time.Duration;
/*     */ import java.time.LocalTime;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import pomelo.area.DailyActivityHandler;
/*     */ import pomelo.area.PlayerHandler;
/*     */ import pomelo.dailyActivity.DailyActivity;
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
/*     */ public class DailyActivityMgr
/*     */ {
/*     */   private String playerId;
/*     */   public DailyActivityPO po;
/*     */   private RichManager richManager;
/*     */   private SevenGoalManager sevenGoalManager;
/*     */   
/*     */   public enum ScheduleType
/*     */   {
/*  47 */     DEMON_INVADE(13), FIVE_MOUNTAIN(7), SOLO(6), TRIAL(8), ILLUSION2(15), GUILD_BOSS(16);
/*     */     
/*     */     private int value;
/*     */     
/*     */     ScheduleType(int value) {
/*  52 */       this.value = value;
/*     */     }
/*     */ 
/*     */     
/*     */     public int getValue() {
/*  57 */       return this.value;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected DailyActivityMgr() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public DailyActivityMgr(String playerId, DailyActivityPO po) {
/*  69 */     setPlayerId(playerId);
/*  70 */     this.po = po;
/*     */   }
/*     */ 
/*     */   
/*     */   public void init(RichManager richManager, SevenGoalManager sevenGoalManager) {
/*  75 */     for (Integer id : GameData.Schedules.keySet()) {
/*  76 */       if (!this.po.activeMap.containsKey(id)) {
/*  77 */         DailyActivityPO.DailyInfo dailyInfo = new DailyActivityPO.DailyInfo();
/*  78 */         dailyInfo.id = id.intValue();
/*  79 */         dailyInfo.process = 0;
/*  80 */         this.po.activeMap.put(id, dailyInfo);
/*     */       } 
/*     */     } 
/*     */     
/*  84 */     for (Integer id : GameData.VitBonuss.keySet()) {
/*  85 */       if (!this.po.rewards.containsKey(id)) {
/*  86 */         DailyActivityPO.DailyRewardInfo reward = new DailyActivityPO.DailyRewardInfo();
/*  87 */         reward.id = id.intValue();
/*  88 */         reward.state = 0;
/*  89 */         this.po.rewards.put(id, reward);
/*     */       } 
/*     */     } 
/*     */     
/*  93 */     updateRewardState();
/*     */     
/*  95 */     this.richManager = richManager;
/*  96 */     this.sevenGoalManager = sevenGoalManager;
/*     */   }
/*     */   
/*     */   public void reset() {
/* 100 */     for (Integer id : this.po.activeMap.keySet()) {
/* 101 */       DailyActivityPO.DailyInfo info = (DailyActivityPO.DailyInfo)this.po.activeMap.get(id);
/* 102 */       if (null == info) {
/*     */         continue;
/*     */       }
/* 105 */       info.process = 0;
/*     */     } 
/*     */     
/* 108 */     for (Integer id : this.po.rewards.keySet()) {
/* 109 */       DailyActivityPO.DailyRewardInfo reward = (DailyActivityPO.DailyRewardInfo)this.po.rewards.get(id);
/* 110 */       if (null == reward) {
/*     */         continue;
/*     */       }
/* 113 */       reward.state = 0;
/*     */     } 
/*     */     
/* 116 */     this.po.totalDegree = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void refreshNewDay() {
/* 123 */     reset();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTimeState(int taskId) {
/* 133 */     int size = (getConfig(taskId)).timeArray.size();
/* 134 */     if (size > 0) {
/*     */       
/* 136 */       for (int j = 0; j < size; j++) {
/* 137 */         ScheduleExt.TimeCond timeCond = (getConfig(taskId)).timeArray.get(j);
/* 138 */         int timeState = DateUtil.isInTime(timeCond.beginTime, timeCond.endTime);
/* 139 */         if (Const.TimeState.TIME_NOT_UP.getValue() == timeState)
/* 140 */           return Const.TimeState.TIME_NOT_UP.getValue(); 
/* 141 */         if (Const.TimeState.TIME_UP.getValue() == timeState) {
/* 142 */           return Const.TimeState.TIME_UP.getValue();
/*     */         }
/*     */       } 
/* 145 */       return Const.TimeState.TIME_OVER.getValue();
/*     */     } 
/*     */     
/* 148 */     return Const.TimeState.TIME_UP.getValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getTimeState2(int taskId) {
/* 159 */     int size = (getConfig(taskId)).periodInCalendarArray.size();
/* 160 */     if (size > 0) {
/*     */       
/* 162 */       for (int j = 0; j < size; j++) {
/* 163 */         ScheduleExt.TimeCond timeCond = (getConfig(taskId)).periodInCalendarArray.get(j);
/* 164 */         int timeState = DateUtil.isInTime2(timeCond.beginTime, timeCond.endTime);
/* 165 */         if (timeState == 1 || timeState == 2) {
/* 166 */           return timeState;
/*     */         }
/*     */       } 
/* 169 */       return 0;
/*     */     } 
/*     */     
/* 172 */     return 2;
/*     */   }
/*     */ 
/*     */   
/*     */   public DailyActivity.DailyInfo.Builder dailyToProto(int taskId) {
/* 177 */     DailyActivityPO.DailyInfo elem = (DailyActivityPO.DailyInfo)this.po.activeMap.get(Integer.valueOf(taskId));
/* 178 */     if (!isWeekSatisfy(taskId)) {
/* 179 */       return null;
/*     */     }
/*     */     
/* 182 */     DailyActivity.DailyInfo.Builder info = DailyActivity.DailyInfo.newBuilder();
/* 183 */     info.setId(taskId);
/* 184 */     info.setCurNum(elem.process);
/* 185 */     info.setMaxNum((getConfig(taskId)).maxCount);
/* 186 */     info.setPerDegree((getConfig(taskId)).vitBonus);
/* 187 */     info.setLvLimit((getConfig(taskId)).lvLimit);
/*     */     
/* 189 */     for (int j = 0; j < (getConfig(taskId)).timeArray.size(); j++) {
/* 190 */       ScheduleExt.TimeCond timeCond = (getConfig(taskId)).timeArray.get(j);
/* 191 */       int timeState = DateUtil.isInTime(timeCond.beginTime, timeCond.endTime);
/* 192 */       if (Const.TimeState.TIME_NOT_UP.getValue() == timeState) {
/* 193 */         String timeStr = timeCond.beginTime + "-" + timeCond.endTime;
/* 194 */         info.setOpenPeriod(timeStr);
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/* 199 */     info.setIsOver(getTimeState(taskId));
/* 200 */     return info;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<DailyActivity.DailyInfo> getDailyLs() {
/* 209 */     List<DailyActivity.DailyInfo> dailyLs = new ArrayList<>();
/* 210 */     for (Integer taskId : this.po.activeMap.keySet()) {
/* 211 */       if (!isValid(taskId.intValue())) {
/*     */         continue;
/*     */       }
/* 214 */       DailyActivity.DailyInfo.Builder info = dailyToProto(taskId.intValue());
/* 215 */       if (null != info)
/* 216 */         dailyLs.add(info.build()); 
/*     */     } 
/* 218 */     return dailyLs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<DailyActivity.DegreeInfo> getDegreeLs() {
/* 227 */     updateRewardState();
/* 228 */     List<DailyActivity.DegreeInfo> degreeLs = new ArrayList<>();
/* 229 */     for (Integer id : this.po.rewards.keySet()) {
/* 230 */       DailyActivityPO.DailyRewardInfo elem = (DailyActivityPO.DailyRewardInfo)this.po.rewards.get(id);
/*     */       
/* 232 */       DailyActivity.DegreeInfo.Builder info = DailyActivity.DegreeInfo.newBuilder();
/* 233 */       info.setId(id.intValue());
/* 234 */       info.setNeedDegree((getVitBounsConfig(id.intValue())).reqVit);
/* 235 */       info.setState(elem.state);
/* 236 */       degreeLs.add(info.build());
/*     */     } 
/* 238 */     return degreeLs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JSONObject getReward(int id) {
/* 248 */     JSONObject ret = new JSONObject();
/* 249 */     if (!this.po.rewards.containsKey(Integer.valueOf(id))) {
/* 250 */       ret.put("result", Integer.valueOf(-1));
/* 251 */       ret.put("des", LangService.getValue("DAILY_ACTIVITY_NOT_EXIST"));
/* 252 */       return ret;
/*     */     } 
/*     */     
/* 255 */     DailyActivityPO.DailyRewardInfo reward = (DailyActivityPO.DailyRewardInfo)this.po.rewards.get(Integer.valueOf(id));
/* 256 */     if (null == reward) {
/* 257 */       ret.put("result", Integer.valueOf(-1));
/* 258 */       ret.put("des", LangService.getValue("DAILY_ACTIVITY_NOT_EXIST"));
/* 259 */       return ret;
/*     */     } 
/*     */     
/* 262 */     if (PlayerAttendance.GiftState.NO_RECEIVE.getValue() == reward.state) {
/* 263 */       ret.put("result", Integer.valueOf(-2));
/* 264 */       ret.put("des", LangService.getValue("DAILY_ACTIVITY_NOT_RECEIVE"));
/* 265 */       return ret;
/*     */     } 
/*     */     
/* 268 */     if (PlayerAttendance.GiftState.RECEIVED.getValue() == reward.state) {
/* 269 */       ret.put("result", Integer.valueOf(-3));
/* 270 */       ret.put("des", LangService.getValue("DAILY_ACTIVITY_RECEIVED"));
/* 271 */       return ret;
/*     */     } 
/*     */     
/* 274 */     if (PlayerAttendance.GiftState.CAN_RECEIVE.getValue() == reward.state) {
/* 275 */       reward.state = PlayerAttendance.GiftState.RECEIVED.getValue();
/* 276 */       ret.put("result", Integer.valueOf(0));
/* 277 */       ret.put("des", LangService.getValue("DAILY_ACTIVITY_SUCESS"));
/* 278 */       return ret;
/*     */     } 
/*     */     
/* 281 */     ret.put("result", Integer.valueOf(-2));
/* 282 */     ret.put("des", LangService.getValue("DAILY_ACTIVITY_NOT_RECEIVE"));
/* 283 */     return ret;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isTaskExist(int taskId) {
/* 293 */     return this.po.activeMap.containsKey(Integer.valueOf(taskId));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DailyActivityPO.DailyInfo getTaskInfo(int taskId) {
/* 303 */     return (DailyActivityPO.DailyInfo)this.po.activeMap.get(Integer.valueOf(taskId));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isWeekSatisfy(int taskId) {
/* 313 */     int w = CommonUtil.getWeek();
/* 314 */     ScheduleExt config = getConfig(taskId);
/* 315 */     if (null == config) {
/* 316 */       Out.error(new Object[] { "dailyActivityMgr config is error in Schedules.json--->>>", Integer.valueOf(taskId) });
/* 317 */       return false;
/*     */     } 
/* 319 */     List<Integer> weekArray = config.weekArray;
/* 320 */     if (weekArray.size() > 0 && -1 == weekArray.indexOf(Integer.valueOf(w))) {
/* 321 */       return false;
/*     */     }
/* 323 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isTimeSatisfy(int taskId) {
/* 333 */     if ((getConfig(taskId)).timeArray.isEmpty()) {
/* 334 */       return true;
/*     */     }
/* 336 */     for (int j = 0; j < (getConfig(taskId)).timeArray.size(); j++) {
/* 337 */       ScheduleExt.TimeCond timeCond = (getConfig(taskId)).timeArray.get(j);
/* 338 */       if (Const.TimeState.TIME_UP.getValue() == DateUtil.isInTime(timeCond.beginTime, timeCond.endTime)) {
/* 339 */         return true;
/*     */       }
/*     */     } 
/* 342 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isLvSatisfy(int taskId) {
/* 352 */     PlayerPO playerPO = PlayerUtil.getPlayerBaseData(getPlayerId());
/*     */     
/* 354 */     if (null == playerPO) {
/* 355 */       Out.error(new Object[] { "playerPO is null" });
/* 356 */       return false;
/*     */     } 
/*     */ 
/*     */     
/* 360 */     if (playerPO.level < (getConfig(taskId)).lvLimit) {
/* 361 */       Out.debug(new Object[] { "playerPO.level limit ->>>>", Integer.valueOf(playerPO.level), "config lv ->>>", Integer.valueOf((getConfig(taskId)).lvLimit) });
/* 362 */       return false;
/*     */     } 
/* 364 */     return true;
/*     */   }
/*     */   
/*     */   public boolean isValid(int taskId) {
/* 368 */     ScheduleExt config = getConfig(taskId);
/* 369 */     if (null == config) {
/* 370 */       Out.error(new Object[] { "config is null-->>", Integer.valueOf(taskId) });
/* 371 */       return false;
/*     */     } 
/*     */     
/* 374 */     return (1 == (getConfig(taskId)).isValid);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSatisfyCond(int taskId) {
/* 383 */     if (!isWeekSatisfy(taskId)) {
/* 384 */       return false;
/*     */     }
/*     */     
/* 387 */     if (!isLvSatisfy(taskId)) {
/* 388 */       return false;
/*     */     }
/*     */     
/* 391 */     if (!isTimeSatisfy(taskId)) {
/* 392 */       return false;
/*     */     }
/* 394 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ScheduleExt getConfig(int taskId) {
/* 404 */     return (ScheduleExt)GameData.Schedules.get(Integer.valueOf(taskId));
/*     */   }
/*     */   
/*     */   public VitBonusExt getVitBounsConfig(int id) {
/* 408 */     return (VitBonusExt)GameData.VitBonuss.get(Integer.valueOf(id));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getCanAddNum(int taskId, int num) {
/* 418 */     DailyActivityPO.DailyInfo info = getTaskInfo(taskId);
/* 419 */     if (null == info) {
/* 420 */       return 0;
/*     */     }
/*     */     
/* 423 */     ScheduleExt config = getConfig(taskId);
/* 424 */     if (null == config) {
/* 425 */       return 0;
/*     */     }
/*     */     
/* 428 */     return Math.min(num, config.maxCount - info.process);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void updatePush(int taskId) {
/* 437 */     WNPlayer player = PlayerUtil.getOnlinePlayer(this.playerId);
/* 438 */     if (null != player) {
/* 439 */       List<DailyActivity.DailyInfo> dailyLs = new ArrayList<>();
/* 440 */       dailyLs.add(dailyToProto(taskId).build());
/* 441 */       DailyActivityHandler.UpdateActivityPush.Builder dailyPush = DailyActivityHandler.UpdateActivityPush.newBuilder();
/* 442 */       dailyPush.addAllS2CDailyLs(dailyLs);
/* 443 */       dailyPush.setS2CTotalDegree(this.po.totalDegree);
/* 444 */       dailyPush.addAllS2CDegreeLs(getDegreeLs());
/* 445 */       player.receive("area.dailyActivityPush.updateActivityPush", (GeneratedMessage)dailyPush.build());
/*     */     } 
/*     */   }
/*     */   
/*     */   public void updateRewardState() {
/* 450 */     for (Integer key : this.po.rewards.keySet()) {
/* 451 */       DailyActivityPO.DailyRewardInfo reward = (DailyActivityPO.DailyRewardInfo)this.po.rewards.get(key);
/* 452 */       if (null == reward || PlayerAttendance.GiftState.RECEIVED.getValue() == reward.state) {
/*     */         continue;
/*     */       }
/*     */       
/* 456 */       if (this.po.totalDegree >= (getVitBounsConfig(reward.id)).reqVit) {
/* 457 */         reward.state = PlayerAttendance.GiftState.CAN_RECEIVE.getValue();
/*     */         
/*     */         continue;
/*     */       } 
/* 461 */       reward.state = PlayerAttendance.GiftState.NO_RECEIVE.getValue();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void doProcess(int taskId, int num) {
/* 473 */     if (isTaskExist(taskId)) {
/* 474 */       DailyActivityPO.DailyInfo info = getTaskInfo(taskId);
/* 475 */       if (null != info && isSatisfyCond(taskId)) {
/* 476 */         int canAddNum = getCanAddNum(taskId, num);
/* 477 */         info.process += canAddNum;
/*     */         
/* 479 */         ScheduleExt config = getConfig(taskId);
/* 480 */         if (null == config) {
/* 481 */           Out.error(new Object[] { "config is null-->>", Integer.valueOf(taskId) });
/*     */           return;
/*     */         } 
/* 484 */         this.po.totalDegree += canAddNum * config.vitBonus;
/* 485 */         if (canAddNum > 0) {
/*     */           
/* 487 */           updatePush(taskId);
/* 488 */           updateRewardState();
/* 489 */           updateSuperScript();
/*     */           
/* 491 */           if (isComplete(taskId)) {
/* 492 */             this.richManager.AddFreeCount(taskId);
/*     */           }
/*     */         } 
/*     */ 
/*     */         
/* 497 */         WNPlayer player = PlayerUtil.getOnlinePlayer(getPlayerId());
/* 498 */         if (player != null) {
/* 499 */           player.taskManager.dealTaskEvent(Const.TaskType.ACTIVITY_NUM, canAddNum * config.vitBonus);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isComplete(int taskId) {
/* 513 */     DailyActivityPO.DailyInfo info = getTaskInfo(taskId);
/* 514 */     if (null == info) {
/* 515 */       Out.error(new Object[] { "DailyInfo is null", info });
/* 516 */       return false;
/*     */     } 
/*     */     
/* 519 */     if ((getConfig(taskId)).maxCount <= 0) {
/* 520 */       return false;
/*     */     }
/* 522 */     return (info.process >= (getConfig(taskId)).maxCount);
/*     */   }
/*     */   
/*     */   public boolean dailyAPI(Const.DailyType type, String target, ScheduleExt task) {
/* 526 */     if (StringUtil.isNullOrEmpty(target)) {
/* 527 */       return (task.type == type.value);
/*     */     }
/*     */     
/* 530 */     return (task.type == type.value && -1 != task.targetArray.indexOf(target));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int[] findTaskId(Const.DailyType type, String id) {
/* 541 */     List<ScheduleExt> ls = GameData.findSchedules(o -> dailyAPI(type, id, o));
/*     */ 
/*     */ 
/*     */     
/* 545 */     int[] ids = new int[ls.size()];
/* 546 */     for (int i = 0; i < ls.size(); i++) {
/* 547 */       ids[i] = ((ScheduleExt)ls.get(i)).schID;
/*     */     }
/*     */     
/* 550 */     return ids;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onEvent(Const.DailyType type, String target, int num) {
/* 561 */     int[] taskIds = findTaskId(type, target);
/* 562 */     for (int i = 0; i < taskIds.length; i++) {
/* 563 */       int taskId = taskIds[i];
/* 564 */       if (!isTaskExist(taskId)) {
/*     */         return;
/*     */       }
/* 567 */       if (isSatisfyCond(taskId) && !isComplete(taskId)) {
/* 568 */         doProcess(taskId, num);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void onLogin() {
/* 575 */     updateSuperScript();
/*     */   }
/*     */   
/*     */   public void updateSuperScript() {
/* 579 */     List<PlayerHandler.SuperScriptType> data = getSuperScript();
/* 580 */     PlayerUtil.getOnlinePlayer(getPlayerId()).updateSuperScriptList(data);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<PlayerHandler.SuperScriptType> getSuperScript() {
/* 589 */     List<PlayerHandler.SuperScriptType> ret = new ArrayList<>();
/*     */     
/* 591 */     int sum = 0;
/* 592 */     for (Integer id : this.po.rewards.keySet()) {
/* 593 */       DailyActivityPO.DailyRewardInfo elem = (DailyActivityPO.DailyRewardInfo)this.po.rewards.get(id);
/* 594 */       if (PlayerAttendance.GiftState.CAN_RECEIVE.getValue() == elem.state) {
/* 595 */         sum++;
/*     */       }
/*     */     } 
/*     */     
/* 599 */     PlayerHandler.SuperScriptType.Builder t = PlayerHandler.SuperScriptType.newBuilder();
/* 600 */     t.setType(Const.SUPERSCRIPT_TYPE.ACTIVITY_CENTER.getValue());
/* 601 */     t.setNumber(sum);
/* 602 */     ret.add(t.build());
/*     */     
/* 604 */     PlayerHandler.SuperScriptType.Builder sst = PlayerHandler.SuperScriptType.newBuilder();
/* 605 */     sst.setType(Const.SUPERSCRIPT_TYPE.FLAG_ACTIVITY_ACIVITY.getValue());
/* 606 */     sst.setNumber(sum);
/* 607 */     ret.add(sst.build());
/*     */     
/* 609 */     ScheduleExt scheduleExt = getConfig(ScheduleType.DEMON_INVADE.value);
/* 610 */     int timeState = getTimeState2(scheduleExt.schID);
/* 611 */     PlayerHandler.SuperScriptType.Builder yzrq = PlayerHandler.SuperScriptType.newBuilder();
/* 612 */     yzrq.setType(Const.SUPERSCRIPT_TYPE.DEMON_INVADE_ACTIVED.getValue());
/* 613 */     yzrq.setNumber(timeState);
/* 614 */     ret.add(yzrq.build());
/*     */     
/* 616 */     scheduleExt = getConfig(ScheduleType.FIVE_MOUNTAIN.value);
/* 617 */     timeState = getTimeState2(scheduleExt.schID);
/* 618 */     PlayerHandler.SuperScriptType.Builder f2f = PlayerHandler.SuperScriptType.newBuilder();
/* 619 */     f2f.setType(Const.SUPERSCRIPT_TYPE.FIVE_MOUNTAIN_ACTIVED.getValue());
/* 620 */     f2f.setNumber(timeState);
/* 621 */     ret.add(f2f.build());
/*     */     
/* 623 */     scheduleExt = getConfig(ScheduleType.SOLO.value);
/* 624 */     timeState = getTimeState2(scheduleExt.schID);
/* 625 */     PlayerHandler.SuperScriptType.Builder solo = PlayerHandler.SuperScriptType.newBuilder();
/* 626 */     solo.setType(Const.SUPERSCRIPT_TYPE.SOLO_ACTIVED.getValue());
/* 627 */     solo.setNumber(timeState);
/* 628 */     ret.add(solo.build());
/*     */     
/* 630 */     scheduleExt = getConfig(ScheduleType.TRIAL.value);
/* 631 */     timeState = getTimeState2(scheduleExt.schID);
/* 632 */     PlayerHandler.SuperScriptType.Builder trial = PlayerHandler.SuperScriptType.newBuilder();
/* 633 */     trial.setType(Const.SUPERSCRIPT_TYPE.TRIAL_ACTIVIED.getValue());
/* 634 */     trial.setNumber(timeState);
/* 635 */     ret.add(trial.build());
/*     */ 
/*     */     
/* 638 */     PlayerHandler.SuperScriptType.Builder illusion2 = PlayerHandler.SuperScriptType.newBuilder();
/* 639 */     illusion2.setType(Const.SUPERSCRIPT_TYPE.ILLUSION2.getValue());
/* 640 */     illusion2.setNumber(calIllusion2ScriptNum());
/* 641 */     ret.add(illusion2.build());
/*     */ 
/*     */     
/* 644 */     scheduleExt = getConfig(ScheduleType.GUILD_BOSS.value);
/* 645 */     timeState = getTimeState2(scheduleExt.schID);
/* 646 */     PlayerHandler.SuperScriptType.Builder guild_boss = PlayerHandler.SuperScriptType.newBuilder();
/* 647 */     guild_boss.setType(Const.SUPERSCRIPT_TYPE.GUILD_BOSS2.getValue());
/* 648 */     guild_boss.setNumber(timeState);
/* 649 */     ret.add(guild_boss.build());
/*     */     
/* 651 */     return ret;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int calIllusion2ScriptNum() {
/* 658 */     return getTimeState2(ScheduleType.ILLUSION2.value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getCloseIllusion2Second() {
/* 665 */     List<ScheduleExt.TimeCond> times = (getConfig(ScheduleType.ILLUSION2.value)).periodInCalendarArray;
/* 666 */     if (times.isEmpty()) {
/* 667 */       return 1;
/*     */     }
/*     */     
/* 670 */     for (ScheduleExt.TimeCond timeCond : times) {
/* 671 */       if (DateUtil.isInTime2(timeCond.beginTime, timeCond.endTime) == 2) {
/* 672 */         String[] ts = timeCond.endTime.split(":");
/* 673 */         int hour = Integer.parseInt(ts[0]);
/* 674 */         int minute = Integer.parseInt(ts[1]);
/* 675 */         int second = (ts.length == 3) ? Integer.parseInt(ts[2]) : 0;
/* 676 */         LocalTime now = LocalTime.now();
/* 677 */         LocalTime end = LocalTime.of(hour, minute, second);
/* 678 */         return Math.max(1, (int)Duration.between(now, end).getSeconds());
/*     */       } 
/*     */     } 
/* 681 */     return 1;
/*     */   }
/*     */   
/*     */   public String getPlayerId() {
/* 685 */     return this.playerId;
/*     */   }
/*     */   
/*     */   public void setPlayerId(String playerId) {
/* 689 */     this.playerId = playerId;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\daily\DailyActivityMgr.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */