/*     */ package com.wanniu.game.sevengoal;
/*     */ 
/*     */ import com.wanniu.core.game.LangService;
/*     */ import com.wanniu.core.game.entity.GEntity;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.util.DateUtils;
/*     */ import com.wanniu.game.GWorld;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.ConstsTR;
/*     */ import com.wanniu.game.common.DateUtils;
/*     */ import com.wanniu.game.common.ModuleManager;
/*     */ import com.wanniu.game.data.GameData;
/*     */ import com.wanniu.game.data.SevDayTaskCO;
/*     */ import com.wanniu.game.data.SevTaskInsCO;
/*     */ import com.wanniu.game.data.ext.SevTaskRewardExt;
/*     */ import com.wanniu.game.item.ItemUtil;
/*     */ import com.wanniu.game.item.NormalItem;
/*     */ import com.wanniu.game.player.GlobalConfig;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.poes.SevenGoalPO;
/*     */ import com.wanniu.redis.PlayerPOManager;
/*     */ import java.time.Instant;
/*     */ import java.time.LocalDate;
/*     */ import java.time.LocalDateTime;
/*     */ import java.time.ZoneId;
/*     */ import java.time.temporal.ChronoUnit;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import pomelo.area.PlayerHandler;
/*     */ import pomelo.sevengoal.SevenGoalHandler;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SevenGoalManager
/*     */   extends ModuleManager
/*     */ {
/*     */   public WNPlayer player;
/*     */   public SevenGoalPO sevenGoalPO;
/*     */   
/*     */   public enum SevenGoalTaskType
/*     */   {
/*  47 */     MOUNT_UPGRADE_LV(1),
/*  48 */     SOLO_ANTICIPATE(2),
/*  49 */     ADD_FRIEND(3),
/*  50 */     PAY_COUNT(4),
/*  51 */     PET_UPGRADE_UPLV(5),
/*  52 */     EQUIP_STRENTHEN_COUNT(6),
/*  53 */     FIVE_MOUNTAIN_ANTICIPATE(7),
/*  54 */     COST_DIAMOND_COUNT(8),
/*  55 */     FIGHTPOWER_TO(9),
/*  56 */     GEM_COMBINE_COUNT(10),
/*  57 */     TRIAL_ANTICIPATE(11),
/*  58 */     COST_DIAMOND_OR_BINDDIAMOND_COUNT(12),
/*  59 */     EQUIP_REFINE_COUNT(13),
/*  60 */     EQUIP_REBORN_COUNT(14),
/*  61 */     EQUIP_REBUILD_COUNT(15),
/*  62 */     DEMON_TOWER_COUNT(16),
/*  63 */     AREA_BOSS_KILL_COUNT(17),
/*  64 */     LEVEL_TO(18),
/*  65 */     XIANYUAN_TO(19),
/*  66 */     GUILD_BOSS_COUNT(20),
/*  67 */     ILLUSION2_COUNT(21);
/*     */     
/*     */     final int value;
/*     */     
/*     */     SevenGoalTaskType(int value) {
/*  72 */       this.value = value;
/*     */     }
/*     */     
/*     */     public static SevenGoalTaskType getType(int value) {
/*  76 */       for (SevenGoalTaskType sevenGoalTaskType : values()) {
/*  77 */         if (sevenGoalTaskType.value == value) {
/*  78 */           return sevenGoalTaskType;
/*     */         }
/*     */       } 
/*  81 */       return null;
/*     */     }
/*     */   }
/*     */   
/*     */   public SevenGoalManager(WNPlayer player) {
/*  86 */     this.player = player;
/*     */     
/*  88 */     this.sevenGoalPO = (SevenGoalPO)PlayerPOManager.findPO(ConstsTR.SevenGoal, player.getId(), SevenGoalPO.class);
/*  89 */     if (this.sevenGoalPO == null) {
/*  90 */       this.sevenGoalPO = new SevenGoalPO();
/*  91 */       PlayerPOManager.put(ConstsTR.SevenGoal, player.getId(), (GEntity)this.sevenGoalPO);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public LocalDateTime getStartDateTime() {
/*  97 */     Instant startInstant = null;
/*     */     try {
/*  99 */       startInstant = DateUtils.parse(GlobalConfig.SevenGoal_Begin, "yyyy-MM-dd HH:mm:ss").toInstant();
/* 100 */     } catch (Exception exception) {}
/* 101 */     LocalDateTime startDateTime = LocalDateTime.ofInstant(startInstant, ZoneId.systemDefault());
/* 102 */     startDateTime.toLocalDate().atTime(5, 0);
/* 103 */     if (GWorld.OPEN_SERVER_DATE.atTime(5, 0).isAfter(startDateTime)) {
/* 104 */       startDateTime = GWorld.OPEN_SERVER_DATE.atTime(5, 0);
/*     */     }
/* 106 */     return startDateTime;
/*     */   }
/*     */   
/*     */   public LocalDateTime getEndDateTime() {
/* 110 */     return getStartDateTime().plus(GlobalConfig.SevenGoal_Continued, ChronoUnit.HOURS);
/*     */   }
/*     */   
/*     */   public boolean isActive() {
/* 114 */     Instant startInstant = null;
/*     */     try {
/* 116 */       startInstant = DateUtils.parse(GlobalConfig.SevenGoal_Begin, "yyyy-MM-dd HH:mm:ss").toInstant();
/* 117 */     } catch (Exception e) {
/* 118 */       e.printStackTrace();
/*     */     } 
/* 120 */     LocalDateTime startDateTime = LocalDateTime.ofInstant(startInstant, ZoneId.systemDefault());
/* 121 */     startDateTime.toLocalDate().atTime(5, 0);
/*     */     
/* 123 */     if (GWorld.OPEN_SERVER_DATE.atTime(5, 0).isAfter(startDateTime)) {
/* 124 */       startDateTime = GWorld.OPEN_SERVER_DATE.atTime(5, 0);
/*     */     }
/*     */     
/* 127 */     int durationHour = GlobalConfig.SevenGoal_Continued;
/* 128 */     LocalDateTime endDateTime = startDateTime.plus(durationHour, ChronoUnit.HOURS);
/*     */ 
/*     */     
/* 131 */     if (LocalDateTime.now().isBefore(startDateTime)) {
/* 132 */       return false;
/*     */     }
/* 134 */     if (LocalDateTime.now().isAfter(endDateTime)) {
/* 135 */       return false;
/*     */     }
/* 137 */     return true;
/*     */   }
/*     */   
/*     */   private int getDayId() {
/* 141 */     Instant startInstant = null;
/*     */     try {
/* 143 */       startInstant = DateUtils.parse(GlobalConfig.SevenGoal_Begin, "yyyy-MM-dd HH:mm:ss").toInstant();
/* 144 */     } catch (Exception e) {
/* 145 */       e.printStackTrace();
/*     */     } 
/* 147 */     LocalDate startDate = LocalDateTime.ofInstant(startInstant, ZoneId.systemDefault()).toLocalDate();
/*     */ 
/*     */     
/* 150 */     if (GWorld.OPEN_SERVER_DATE.isAfter(startDate)) {
/* 151 */       startDate = GWorld.OPEN_SERVER_DATE;
/*     */     }
/*     */ 
/*     */     
/* 155 */     return (int)ChronoUnit.DAYS.between(startDate, LocalDate.now()) + 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void checkData() {
/* 162 */     if (GlobalConfig.SevenGoal_CurrentTurn != this.sevenGoalPO.currentTurn) {
/* 163 */       this.sevenGoalPO.reset(GlobalConfig.SevenGoal_CurrentTurn);
/* 164 */       initData();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public SevenGoalHandler.GetSevenGoalResponse.Builder getSevenGoal() {
/* 171 */     checkData();
/*     */     
/* 173 */     SevenGoalHandler.GetSevenGoalResponse.Builder builder = SevenGoalHandler.GetSevenGoalResponse.newBuilder();
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
/* 188 */     for (DayInfo dayInfo : this.sevenGoalPO.dayInfoMap.values()) {
/* 189 */       SevenGoalHandler.DayInfo.Builder dayinfoBuilder = SevenGoalHandler.DayInfo.newBuilder();
/* 190 */       dayinfoBuilder.setDayId(dayInfo.dayId);
/*     */ 
/*     */ 
/*     */       
/* 194 */       for (TaskInfo taskInfo : dayInfo.taskMap.values()) {
/* 195 */         SevenGoalHandler.TaskInfo.Builder taskInfoBuilder = SevenGoalHandler.TaskInfo.newBuilder();
/*     */         
/* 197 */         taskInfoBuilder.setTaskId(taskInfo.taskId);
/* 198 */         taskInfoBuilder.setFinishedNum(taskInfo.finishedNum);
/*     */ 
/*     */         
/* 201 */         dayinfoBuilder.addTaskInfo(taskInfoBuilder);
/*     */       } 
/* 203 */       dayinfoBuilder.setFetched(dayInfo.fetched);
/* 204 */       builder.addDayInfo(dayinfoBuilder);
/*     */     } 
/* 206 */     builder.setCurrentDayId(getDayId());
/* 207 */     builder.setStartTimestamp(getStartDateTime().format(DateUtils.F_YYYYMMDDHHMMSS));
/* 208 */     builder.setEndTimestamp(getEndDateTime().format(DateUtils.F_YYYYMMDDHHMMSS));
/* 209 */     builder.setS2CCode(200);
/* 210 */     Out.error(new Object[] { builder });
/* 211 */     return builder;
/*     */   }
/*     */   
/*     */   public SevenGoalHandler.FetchAwardResponse.Builder fetchAward(int dayId) {
/* 215 */     checkData();
/*     */     
/* 217 */     SevenGoalHandler.FetchAwardResponse.Builder builder = SevenGoalHandler.FetchAwardResponse.newBuilder();
/*     */     
/* 219 */     if (!isActive()) {
/* 220 */       builder.setS2CCode(500);
/* 221 */       builder.setS2CMsg(LangService.getValue("SEVEN_GOAL_INACTIVED"));
/* 222 */       return builder;
/*     */     } 
/*     */     
/* 225 */     if (!this.sevenGoalPO.dayInfoMap.containsKey(Integer.valueOf(dayId))) {
/* 226 */       builder.setS2CCode(500);
/* 227 */       builder.setS2CMsg(LangService.getValue("SEVEN_GOAL_PARAM_ERROR"));
/* 228 */       return builder;
/*     */     } 
/*     */     
/* 231 */     if (dayId > getDayId()) {
/* 232 */       builder.setS2CCode(500);
/* 233 */       builder.setS2CMsg(LangService.getValue("SEVEN_GOAL_PARAM_ERROR"));
/* 234 */       return builder;
/*     */     } 
/*     */     
/* 237 */     DayInfo dayInfo = (DayInfo)this.sevenGoalPO.dayInfoMap.get(Integer.valueOf(dayId));
/*     */ 
/*     */     
/* 240 */     if (dayInfo.fetched == true) {
/* 241 */       builder.setS2CCode(500);
/* 242 */       builder.setS2CMsg(LangService.getValue("SEVEN_GOAL_FETCHED"));
/* 243 */       return builder;
/*     */     } 
/*     */     
/* 246 */     boolean allFinished = true;
/* 247 */     for (TaskInfo taskInfo : dayInfo.taskMap.values()) {
/* 248 */       SevDayTaskCO sevDayTaskCO = (SevDayTaskCO)GameData.SevDayTasks.get(Integer.valueOf(taskInfo.taskId));
/* 249 */       if (taskInfo.finishedNum < sevDayTaskCO.targetNum) {
/* 250 */         allFinished = false;
/*     */         break;
/*     */       } 
/*     */     } 
/* 254 */     if (!allFinished) {
/* 255 */       builder.setS2CCode(500);
/* 256 */       builder.setS2CMsg(LangService.getValue("SEVEN_GOAL_NOT_FINISHED"));
/* 257 */       return builder;
/*     */     } 
/* 259 */     dayInfo.fetched = true;
/* 260 */     Out.info(new Object[] { "玩家：", this.player.getId(), "  领取了七日目标奖励，dayId:", Integer.valueOf(dayId) });
/*     */ 
/*     */     
/* 263 */     SevTaskRewardExt sevTaskRewardExt = (SevTaskRewardExt)GameData.SevTaskRewards.get(Integer.valueOf(dayInfo.dayId));
/*     */     
/* 265 */     List<NormalItem> rewards = new ArrayList<>();
/* 266 */     String[] rewardStrs = sevTaskRewardExt.reward.split(";");
/* 267 */     for (String rewardSubStr : rewardStrs) {
/* 268 */       String[] rewardSubStrs = rewardSubStr.split(":");
/* 269 */       rewards.addAll(ItemUtil.createItemsByItemCode(rewardSubStrs[0], Integer.parseInt(rewardSubStrs[1])));
/*     */     } 
/* 271 */     this.player.bag.addCodeItemMail(rewards, Const.ForceType.BIND, Const.GOODS_CHANGE_TYPE.SevenGoal, "Bag_full_common");
/*     */ 
/*     */     
/* 274 */     builder.setS2CCode(200);
/*     */ 
/*     */     
/* 277 */     updateSuperScript();
/*     */     
/* 279 */     return builder;
/*     */   }
/*     */   
/*     */   public void processGoal(SevenGoalTaskType taskType, Object... params) {
/* 283 */     if (!isActive()) {
/*     */       return;
/*     */     }
/* 286 */     checkData();
/* 287 */     int dayId = getDayId();
/*     */ 
/*     */     
/* 290 */     boolean done = false;
/*     */     
/* 292 */     for (DayInfo dayInfo : this.sevenGoalPO.dayInfoMap.values()) {
/* 293 */       for (TaskInfo taskInfo : dayInfo.taskMap.values()) {
/* 294 */         SevDayTaskCO sevDayTaskCO = (SevDayTaskCO)GameData.SevDayTasks.get(Integer.valueOf(taskInfo.taskId));
/* 295 */         if (sevDayTaskCO.style != taskType.value) {
/*     */           continue;
/*     */         }
/* 298 */         if (sevDayTaskCO.date > dayId && sevDayTaskCO.advancedDown == 0) {
/*     */           continue;
/*     */         }
/* 301 */         if (taskInfo.finishedNum >= sevDayTaskCO.targetNum) {
/*     */           continue;
/*     */         }
/*     */ 
/*     */         
/* 306 */         switch (taskType) {
/*     */           case MOUNT_UPGRADE_LV:
/* 308 */             taskInfo.finishedNum = Math.min(((Integer)params[0]).intValue(), sevDayTaskCO.targetNum);
/* 309 */             done = true;
/*     */           
/*     */           case SOLO_ANTICIPATE:
/* 312 */             taskInfo.finishedNum = Math.min(taskInfo.finishedNum + 1, sevDayTaskCO.targetNum);
/* 313 */             done = true;
/*     */           
/*     */           case ADD_FRIEND:
/* 316 */             taskInfo.finishedNum = Math.min(taskInfo.finishedNum + 1, sevDayTaskCO.targetNum);
/* 317 */             done = true;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           case PAY_COUNT:
/* 324 */             taskInfo.finishedNum = Math.min(((Integer)params[0]).intValue(), sevDayTaskCO.targetNum);
/* 325 */             done = true;
/*     */           
/*     */           case PET_UPGRADE_UPLV:
/* 328 */             taskInfo.finishedNum = Math.min(((Integer)params[0]).intValue(), sevDayTaskCO.targetNum);
/* 329 */             done = true;
/*     */           
/*     */           case EQUIP_STRENTHEN_COUNT:
/* 332 */             taskInfo.finishedNum = Math.min(((Integer)params[0]).intValue(), sevDayTaskCO.targetNum);
/* 333 */             done = true;
/*     */           
/*     */           case FIVE_MOUNTAIN_ANTICIPATE:
/* 336 */             taskInfo.finishedNum = Math.min(taskInfo.finishedNum + 1, sevDayTaskCO.targetNum);
/* 337 */             done = true;
/*     */           
/*     */           case COST_DIAMOND_COUNT:
/* 340 */             taskInfo.finishedNum = Math.min(taskInfo.finishedNum + 1, sevDayTaskCO.targetNum);
/* 341 */             done = true;
/*     */ 
/*     */           
/*     */           case FIGHTPOWER_TO:
/* 345 */             taskInfo.finishedNum = Math.min(((Integer)params[0]).intValue(), sevDayTaskCO.targetNum);
/* 346 */             done = true;
/*     */ 
/*     */           
/*     */           case GEM_COMBINE_COUNT:
/* 350 */             if (((Integer)params[0]).intValue() == sevDayTaskCO.numParameter1) {
/* 351 */               taskInfo.finishedNum = Math.min(taskInfo.finishedNum + ((Integer)params[1]).intValue(), sevDayTaskCO.targetNum);
/* 352 */               done = true;
/*     */             } 
/*     */           
/*     */           case TRIAL_ANTICIPATE:
/* 356 */             taskInfo.finishedNum = Math.min(taskInfo.finishedNum + 1, sevDayTaskCO.targetNum);
/* 357 */             done = true;
/*     */           
/*     */           case COST_DIAMOND_OR_BINDDIAMOND_COUNT:
/* 360 */             taskInfo.finishedNum = Math.min(((Integer)params[0]).intValue(), sevDayTaskCO.targetNum);
/* 361 */             done = true;
/*     */           
/*     */           case EQUIP_REFINE_COUNT:
/* 364 */             taskInfo.finishedNum = Math.min(taskInfo.finishedNum + 1, sevDayTaskCO.targetNum);
/* 365 */             done = true;
/*     */           
/*     */           case EQUIP_REBORN_COUNT:
/* 368 */             taskInfo.finishedNum = Math.min(taskInfo.finishedNum + 1, sevDayTaskCO.targetNum);
/* 369 */             done = true;
/*     */           
/*     */           case EQUIP_REBUILD_COUNT:
/* 372 */             taskInfo.finishedNum = Math.min(taskInfo.finishedNum + 1, sevDayTaskCO.targetNum);
/* 373 */             done = true;
/*     */           
/*     */           case DEMON_TOWER_COUNT:
/* 376 */             taskInfo.finishedNum = Math.min(this.player.demonTowerManager.getMaxFloor() - 1, sevDayTaskCO.targetNum);
/* 377 */             done = true;
/*     */           
/*     */           case AREA_BOSS_KILL_COUNT:
/* 380 */             taskInfo.finishedNum = Math.min(taskInfo.finishedNum + 1, sevDayTaskCO.targetNum);
/* 381 */             done = true;
/*     */           
/*     */           case LEVEL_TO:
/* 384 */             taskInfo.finishedNum = Math.min(((Integer)params[0]).intValue(), sevDayTaskCO.targetNum);
/* 385 */             done = true;
/*     */           
/*     */           case XIANYUAN_TO:
/* 388 */             taskInfo.finishedNum = Math.min(taskInfo.finishedNum + ((Integer)params[0]).intValue(), sevDayTaskCO.targetNum);
/* 389 */             done = true;
/*     */           
/*     */           case GUILD_BOSS_COUNT:
/* 392 */             taskInfo.finishedNum = Math.min(taskInfo.finishedNum + 1, sevDayTaskCO.targetNum);
/* 393 */             done = true;
/*     */           
/*     */           case ILLUSION2_COUNT:
/* 396 */             taskInfo.finishedNum = Math.min(taskInfo.finishedNum + 1, sevDayTaskCO.targetNum);
/* 397 */             done = true;
/*     */         } 
/*     */ 
/*     */ 
/*     */       
/*     */       } 
/*     */     } 
/* 404 */     if (done) {
/* 405 */       updateSuperScript();
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
/*     */   public void initData() {
/* 417 */     if (!isActive()) {
/*     */       return;
/*     */     }
/*     */     
/* 421 */     for (DayInfo dayInfo : this.sevenGoalPO.dayInfoMap.values()) {
/* 422 */       for (TaskInfo taskInfo : dayInfo.taskMap.values()) {
/* 423 */         int maxPetUpLv; SevDayTaskCO sevDayTaskCO = (SevDayTaskCO)GameData.SevDayTasks.get(Integer.valueOf(taskInfo.taskId));
/* 424 */         SevTaskInsCO sevTaskInsCO = (SevTaskInsCO)GameData.SevTaskInss.get(Integer.valueOf(sevDayTaskCO.style));
/* 425 */         if (sevTaskInsCO.tip != 0) {
/*     */           continue;
/*     */         }
/*     */         
/* 429 */         SevenGoalTaskType sevenGoalTaskType = SevenGoalTaskType.getType(sevDayTaskCO.style);
/* 430 */         switch (sevenGoalTaskType) {
/*     */           case MOUNT_UPGRADE_LV:
/* 432 */             taskInfo.finishedNum = Math.min(this.player.mountManager.getMountLevel(), sevDayTaskCO.targetNum);
/*     */           
/*     */           case PET_UPGRADE_UPLV:
/* 435 */             maxPetUpLv = this.player.petNewManager.getMaxPetUpLv();
/* 436 */             taskInfo.finishedNum = Math.min(maxPetUpLv, sevDayTaskCO.targetNum);
/*     */           
/*     */           case EQUIP_STRENTHEN_COUNT:
/* 439 */             taskInfo.finishedNum = Math.min(this.player.equipManager.getTotalStrenthenLv(), sevDayTaskCO.targetNum);
/*     */           
/*     */           case FIGHTPOWER_TO:
/* 442 */             taskInfo.finishedNum = Math.min(this.player.getFightPower(), sevDayTaskCO.targetNum);
/*     */           
/*     */           case DEMON_TOWER_COUNT:
/* 445 */             taskInfo.finishedNum = Math.min(this.player.demonTowerManager.getMaxFloor() - 1, sevDayTaskCO.targetNum);
/*     */           
/*     */           case LEVEL_TO:
/* 448 */             taskInfo.finishedNum = Math.min(this.player.getLevel(), sevDayTaskCO.targetNum);
/*     */         } 
/*     */ 
/*     */ 
/*     */       
/*     */       } 
/*     */     } 
/* 455 */     updateSuperScript();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateSuperScript() {
/* 461 */     List<PlayerHandler.SuperScriptType> data = getSuperScript();
/* 462 */     this.player.updateSuperScriptList(data);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<PlayerHandler.SuperScriptType> getSuperScript() {
/* 467 */     List<PlayerHandler.SuperScriptType> ret = new ArrayList<>();
/*     */     
/* 469 */     int day = getDayId();
/*     */     
/* 471 */     int totalCount = 0;
/* 472 */     for (DayInfo dayInfo : this.sevenGoalPO.dayInfoMap.values()) {
/* 473 */       if (dayInfo.dayId > day || dayInfo.fetched) {
/*     */         continue;
/*     */       }
/* 476 */       boolean allFinished = true;
/* 477 */       for (TaskInfo taskInfo : dayInfo.taskMap.values()) {
/* 478 */         SevDayTaskCO sevDayTaskCO = (SevDayTaskCO)GameData.SevDayTasks.get(Integer.valueOf(taskInfo.taskId));
/* 479 */         if (taskInfo.finishedNum < sevDayTaskCO.targetNum) {
/* 480 */           allFinished = false;
/*     */           break;
/*     */         } 
/*     */       } 
/* 484 */       if (allFinished) {
/* 485 */         totalCount++;
/*     */       }
/*     */     } 
/* 488 */     PlayerHandler.SuperScriptType.Builder t = PlayerHandler.SuperScriptType.newBuilder();
/* 489 */     t.setType(Const.SUPERSCRIPT_TYPE.SEVEN_GOAL.getValue());
/* 490 */     int count = 0;
/* 491 */     if (isActive()) {
/* 492 */       count = 1;
/* 493 */       if (totalCount > 0) {
/* 494 */         count = 2;
/*     */       }
/*     */     } 
/* 497 */     t.setNumber(count);
/* 498 */     ret.add(t.build());
/*     */     
/* 500 */     return ret;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onPlayerEvent(Const.PlayerEventType eventType) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public Const.ManagerType getManagerType() {
/* 511 */     return Const.ManagerType.SEVEN_GOAL;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\sevengoal\SevenGoalManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */