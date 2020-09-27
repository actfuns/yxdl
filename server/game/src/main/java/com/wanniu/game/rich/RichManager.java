/*     */ package com.wanniu.game.rich;
/*     */ 
/*     */ import com.wanniu.core.game.LangService;
/*     */ import com.wanniu.core.game.entity.GEntity;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.util.DateUtils;
/*     */ import com.wanniu.core.util.RandomUtil;
/*     */ import com.wanniu.game.GWorld;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.ConstsTR;
/*     */ import com.wanniu.game.common.DateUtils;
/*     */ import com.wanniu.game.common.ModuleManager;
/*     */ import com.wanniu.game.daily.DailyActivityMgr;
/*     */ import com.wanniu.game.data.GameData;
/*     */ import com.wanniu.game.data.ZillionaireCageCO;
/*     */ import com.wanniu.game.data.ZillionaireFreeCO;
/*     */ import com.wanniu.game.data.ext.ScheduleExt;
/*     */ import com.wanniu.game.data.ext.TurnRewardExt;
/*     */ import com.wanniu.game.item.ItemUtil;
/*     */ import com.wanniu.game.item.NormalItem;
/*     */ import com.wanniu.game.player.GlobalConfig;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.poes.DailyActivityPO;
/*     */ import com.wanniu.game.poes.RichPO;
/*     */ import com.wanniu.redis.PlayerPOManager;
/*     */ import java.time.Instant;
/*     */ import java.time.LocalDateTime;
/*     */ import java.time.ZoneId;
/*     */ import java.time.temporal.ChronoUnit;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import pomelo.area.PlayerHandler;
/*     */ import pomelo.rich.RichHandler;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RichManager
/*     */   extends ModuleManager
/*     */ {
/*     */   WNPlayer player;
/*     */   RichPO richPO;
/*     */   DailyActivityMgr dailyActivityMgr;
/*     */   
/*     */   public RichManager(WNPlayer player) {
/*  68 */     this.player = player;
/*     */   }
/*     */   
/*     */   public void init() {
/*  72 */     this.richPO = (RichPO)PlayerPOManager.findPO(ConstsTR.Rich, this.player.getId(), RichPO.class);
/*  73 */     if (this.richPO == null) {
/*  74 */       this.richPO = new RichPO();
/*  75 */       PlayerPOManager.put(ConstsTR.Rich, this.player.getId(), (GEntity)this.richPO);
/*     */     } 
/*     */     
/*  78 */     this.dailyActivityMgr = this.player.dailyActivityMgr;
/*     */   }
/*     */   
/*     */   LocalDateTime getStartLocalDateTime() {
/*  82 */     Instant startInstant = null;
/*     */     try {
/*  84 */       startInstant = DateUtils.parse(GlobalConfig.Zillionaire_Open_Time, "yyyy-MM-dd HH:mm:ss").toInstant();
/*  85 */     } catch (Exception e) {
/*  86 */       e.printStackTrace();
/*     */     } 
/*     */     
/*  89 */     LocalDateTime startLocalDateTime = LocalDateTime.ofInstant(startInstant, ZoneId.systemDefault());
/*     */     
/*  91 */     if (GWorld.OPEN_SERVER_DATE.atTime(0, 0).isAfter(startLocalDateTime)) {
/*  92 */       startLocalDateTime = GWorld.OPEN_SERVER_DATE.atTime(0, 0);
/*     */     }
/*     */     
/*  95 */     return startLocalDateTime;
/*     */   }
/*     */ 
/*     */   
/*     */   LocalDateTime getEndLocalDateTime() {
/* 100 */     LocalDateTime startDateTime = getStartLocalDateTime();
/* 101 */     int durationHour = GlobalConfig.Zillionaire_Continued_Time;
/* 102 */     return startDateTime.plus(durationHour, ChronoUnit.HOURS);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isActive() {
/* 107 */     Instant startInstant = null;
/*     */     try {
/* 109 */       startInstant = DateUtils.parse(GlobalConfig.Zillionaire_Open_Time, "yyyy-MM-dd HH:mm:ss").toInstant();
/* 110 */     } catch (Exception e) {
/* 111 */       e.printStackTrace();
/*     */     } 
/* 113 */     LocalDateTime startDateTime = LocalDateTime.ofInstant(startInstant, ZoneId.systemDefault());
/*     */     
/* 115 */     if (GWorld.OPEN_SERVER_DATE.atTime(0, 0).isAfter(startDateTime)) {
/* 116 */       startDateTime = GWorld.OPEN_SERVER_DATE.atTime(0, 0);
/*     */     }
/*     */     
/* 119 */     int durationHour = GlobalConfig.Zillionaire_Continued_Time;
/* 120 */     LocalDateTime endDateTime = startDateTime.plus(durationHour, ChronoUnit.HOURS);
/*     */     
/* 122 */     if (LocalDateTime.now().isBefore(startDateTime)) {
/* 123 */       return false;
/*     */     }
/* 125 */     if (LocalDateTime.now().isAfter(endDateTime)) {
/* 126 */       return false;
/*     */     }
/* 128 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void checkData() {
/* 134 */     if (this.richPO.currentTurn != GlobalConfig.Zillionaire_CurrentTurn) {
/* 135 */       this.richPO.reset(GlobalConfig.Zillionaire_CurrentTurn);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public RichHandler.GetRichInfoResponse.Builder getRichInfo(String playerId) {
/* 141 */     RichHandler.GetRichInfoResponse.Builder builder = RichHandler.GetRichInfoResponse.newBuilder();
/*     */     
/* 143 */     checkData();
/*     */     
/* 145 */     if (!isActive()) {
/* 146 */       builder.setS2CCode(500);
/* 147 */       builder.setS2CMsg(LangService.getValue("RICH_INACTIVED"));
/* 148 */       return builder;
/*     */     } 
/*     */     
/* 151 */     for (ZillionaireFreeCO zillionaireFreeCO : GameData.ZillionaireFrees.values()) {
/* 152 */       RichHandler.TaskInfo.Builder taskInfoBuilder = RichHandler.TaskInfo.newBuilder();
/*     */       
/* 154 */       DailyActivityPO.DailyInfo info = this.player.dailyActivityMgr.getTaskInfo(zillionaireFreeCO.taskID);
/* 155 */       ScheduleExt scheduleExt = (ScheduleExt)GameData.Schedules.get(Integer.valueOf(zillionaireFreeCO.taskID));
/* 156 */       taskInfoBuilder.setSchName(scheduleExt.schName);
/* 157 */       taskInfoBuilder.setFinishedCount(info.process);
/* 158 */       taskInfoBuilder.setMaxCount(scheduleExt.maxCount);
/*     */       
/* 160 */       builder.addTaskInfo(taskInfoBuilder.build());
/*     */     } 
/* 162 */     for (TurnRewardExt turnRewardExt : GameData.TurnRewards.values()) {
/* 163 */       RichHandler.TurnReward.Builder turnRewardBuilder = RichHandler.TurnReward.newBuilder();
/* 164 */       turnRewardBuilder.setTurnId(turnRewardExt.sort);
/*     */       
/* 166 */       for (Map.Entry<String, Integer> entry : (Iterable<Map.Entry<String, Integer>>)turnRewardExt.getRewardMap.entrySet()) {
/* 167 */         RichHandler.Reward.Builder rewardBuilder = RichHandler.Reward.newBuilder();
/* 168 */         rewardBuilder.setCode(entry.getKey());
/* 169 */         rewardBuilder.setGroupCount(((Integer)entry.getValue()).intValue());
/*     */         
/* 171 */         turnRewardBuilder.addReward(rewardBuilder);
/*     */       } 
/*     */       
/* 174 */       turnRewardBuilder.setState(((Integer)this.richPO.turnStatesMap.get(Integer.valueOf(turnRewardExt.sort))).intValue());
/*     */       
/* 176 */       builder.addTurnReward(turnRewardBuilder);
/*     */     } 
/*     */     
/* 179 */     builder.setCurrentStep(this.richPO.currentStep);
/* 180 */     builder.setFreeCount(this.richPO.freeCount);
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
/* 194 */     builder.setStartTimestamp(getStartLocalDateTime().format(DateUtils.F_YYYYMMDDHHMMSS));
/* 195 */     builder.setEndTimestamp(getEndLocalDateTime().format(DateUtils.F_YYYYMMDDHHMMSS));
/* 196 */     builder.setS2CCode(200);
/*     */     
/* 198 */     return builder;
/*     */   }
/*     */   
/*     */   private int getRound() {
/* 202 */     int finishedRound = 0;
/* 203 */     for (Iterator<Integer> iterator = this.richPO.turnStatesMap.values().iterator(); iterator.hasNext(); ) { int state = ((Integer)iterator.next()).intValue();
/* 204 */       if (state != 0) {
/* 205 */         finishedRound++;
/*     */       } }
/*     */ 
/*     */     
/* 209 */     return Math.min(GameData.TurnRewards.size(), finishedRound + 1);
/*     */   }
/*     */   
/*     */   public RichHandler.DiceResponse.Builder dice(String playerId) {
/* 213 */     RichHandler.DiceResponse.Builder builder = RichHandler.DiceResponse.newBuilder();
/*     */     
/* 215 */     checkData();
/*     */     
/* 217 */     if (!isActive()) {
/* 218 */       builder.setS2CCode(500);
/* 219 */       builder.setS2CMsg(LangService.getValue("RICH_INACTIVED"));
/* 220 */       return builder;
/*     */     } 
/*     */     
/* 223 */     if (this.richPO.freeCount > 0)
/* 224 */     { this.richPO.freeCount--;
/* 225 */       updateSuperScript(); }
/* 226 */     else { if (!this.player.moneyManager.enoughDiamond(GlobalConfig.Zillionaire_Yuanbao_One)) {
/* 227 */         builder.setS2CCode(500);
/* 228 */         builder.setS2CMsg(LangService.getValue("RICH_NOT_ENOUGH_DIAMOND"));
/* 229 */         Out.error(new Object[] { builder });
/* 230 */         return builder;
/*     */       } 
/* 232 */       this.player.moneyManager.costDiamond(GlobalConfig.Zillionaire_Yuanbao_One, Const.GOODS_CHANGE_TYPE.Rich); }
/*     */ 
/*     */     
/* 235 */     int stepCount = GameData.ZillionaireCages.size();
/*     */ 
/*     */     
/* 238 */     int randomStep = RandomUtil.getInt(1, 6);
/*     */     
/* 240 */     int newStep = (this.richPO.currentStep - 1 + randomStep) % stepCount + 1;
/*     */     
/* 242 */     if (this.richPO.currentStep + randomStep > stepCount) {
/* 243 */       int currentRound = getRound();
/*     */       
/* 245 */       if (((Integer)this.richPO.turnStatesMap.get(Integer.valueOf(currentRound))).intValue() == 0) {
/* 246 */         this.richPO.turnStatesMap.put(Integer.valueOf(currentRound), Integer.valueOf(1));
/* 247 */         updateSuperScript();
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 252 */     this.richPO.currentStep = newStep;
/*     */     
/* 254 */     builder.setStep(randomStep);
/*     */     
/* 256 */     RichHandler.Reward.Builder rewardBuilder = RichHandler.Reward.newBuilder();
/* 257 */     ZillionaireCageCO zillionaireCageCO = (ZillionaireCageCO)GameData.ZillionaireCages.get(Integer.valueOf(this.richPO.currentStep));
/* 258 */     rewardBuilder.setCode(zillionaireCageCO.itemCode);
/* 259 */     rewardBuilder.setGroupCount(zillionaireCageCO.nUM);
/*     */     
/* 261 */     this.player.bag.addCodeItemMail(zillionaireCageCO.itemCode, zillionaireCageCO.nUM, (zillionaireCageCO.isBind == 0) ? Const.ForceType.UN_BIND : Const.ForceType.BIND, Const.GOODS_CHANGE_TYPE.Rich, "Bag_full_common");
/*     */ 
/*     */     
/* 264 */     builder.setS2CCode(200);
/* 265 */     builder.setReward(rewardBuilder);
/*     */     
/* 267 */     return builder;
/*     */   }
/*     */   
/*     */   public RichHandler.FetchTurnAwardResponse.Builder fetchTurnAward(String playerId, int turnId) {
/* 271 */     RichHandler.FetchTurnAwardResponse.Builder builder = RichHandler.FetchTurnAwardResponse.newBuilder();
/*     */     
/* 273 */     checkData();
/*     */     
/* 275 */     if (!isActive()) {
/* 276 */       builder.setS2CCode(500);
/* 277 */       builder.setS2CMsg(LangService.getValue("RICH_INACTIVED"));
/* 278 */       return builder;
/*     */     } 
/*     */     
/* 281 */     if (!this.richPO.turnStatesMap.containsKey(Integer.valueOf(turnId))) {
/* 282 */       builder.setS2CCode(500);
/* 283 */       builder.setS2CMsg(LangService.getValue("RICH_TURN_ID_ERROR"));
/* 284 */       return builder;
/*     */     } 
/*     */     
/* 287 */     int state = ((Integer)this.richPO.turnStatesMap.get(Integer.valueOf(turnId))).intValue();
/* 288 */     if (state == 0) {
/* 289 */       builder.setS2CCode(500);
/* 290 */       builder.setS2CMsg(LangService.getValue("RICH_TURN_NOT_FINISHED"));
/* 291 */       return builder;
/*     */     } 
/* 293 */     if (state == 2) {
/* 294 */       builder.setS2CCode(500);
/* 295 */       builder.setS2CMsg(LangService.getValue("RICH_TURN_FETCHED"));
/* 296 */       return builder;
/*     */     } 
/*     */     
/* 299 */     TurnRewardExt turnRewardExt = (TurnRewardExt)GameData.TurnRewards.get(Integer.valueOf(turnId));
/*     */     
/* 301 */     this.richPO.turnStatesMap.put(Integer.valueOf(turnId), Integer.valueOf(2));
/* 302 */     List<NormalItem> rewards = ItemUtil.createItemsByItemCode(turnRewardExt.getRewardMap);
/* 303 */     this.player.bag.addCodeItemMail(rewards, (turnRewardExt.isBind == 0) ? Const.ForceType.UN_BIND : Const.ForceType.BIND, Const.GOODS_CHANGE_TYPE.Rich, "Bag_full_common");
/*     */ 
/*     */     
/* 306 */     for (Map.Entry<String, Integer> entry : (Iterable<Map.Entry<String, Integer>>)turnRewardExt.getRewardMap.entrySet()) {
/* 307 */       RichHandler.Reward.Builder rewardBuilder = RichHandler.Reward.newBuilder();
/* 308 */       rewardBuilder.setCode(entry.getKey());
/* 309 */       rewardBuilder.setGroupCount(((Integer)entry.getValue()).intValue());
/*     */       
/* 311 */       builder.addReward(rewardBuilder);
/*     */     } 
/*     */     
/* 314 */     builder.setS2CCode(200);
/*     */     
/* 316 */     updateSuperScript();
/*     */     
/* 318 */     return builder;
/*     */   }
/*     */ 
/*     */   
/*     */   public void AddFreeCount(int taskId) {
/* 323 */     if (!isActive()) {
/*     */       return;
/*     */     }
/*     */     
/* 327 */     for (ZillionaireFreeCO zillionaireFreeCO : GameData.ZillionaireFrees.values()) {
/* 328 */       if (zillionaireFreeCO.taskID == taskId) {
/* 329 */         if (this.richPO.freeCount < GlobalConfig.Zillionaire_FreeUp) {
/* 330 */           this.richPO.freeCount++;
/*     */           
/* 332 */           updateSuperScript();
/*     */         } 
/*     */         return;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private int getFechableCount() {
/* 341 */     int count = 0;
/* 342 */     for (Iterator<Integer> iterator = this.richPO.turnStatesMap.values().iterator(); iterator.hasNext(); ) { int value = ((Integer)iterator.next()).intValue();
/* 343 */       if (value == 1) {
/* 344 */         count++;
/*     */       } }
/*     */     
/* 347 */     return count;
/*     */   }
/*     */   
/*     */   public void updateSuperScript() {
/* 351 */     List<PlayerHandler.SuperScriptType> data = getSuperScript();
/* 352 */     this.player.updateSuperScriptList(data);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<PlayerHandler.SuperScriptType> getSuperScript() {
/* 357 */     List<PlayerHandler.SuperScriptType> ret = new ArrayList<>();
/* 358 */     PlayerHandler.SuperScriptType.Builder t = PlayerHandler.SuperScriptType.newBuilder();
/* 359 */     t.setType(Const.SUPERSCRIPT_TYPE.RICH.getValue());
/* 360 */     int count = 0;
/* 361 */     if (isActive()) {
/* 362 */       count = 1;
/* 363 */       if (this.richPO.freeCount > 0) {
/* 364 */         count = 2;
/*     */       }
/* 366 */       if (getFechableCount() > 0) {
/* 367 */         count = 2;
/*     */       }
/*     */     } 
/*     */     
/* 371 */     t.setNumber(count);
/* 372 */     ret.add(t.build());
/* 373 */     return ret;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onPlayerEvent(Const.PlayerEventType eventType) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Const.ManagerType getManagerType() {
/* 385 */     return Const.ManagerType.RICH;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\rich\RichManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */