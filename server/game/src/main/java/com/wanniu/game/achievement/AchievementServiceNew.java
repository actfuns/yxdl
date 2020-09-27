/*     */ package com.wanniu.game.achievement;
/*     */ 
/*     */ import com.wanniu.core.game.LangService;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.util.StringUtil;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.ConstsTR;
/*     */ import com.wanniu.game.common.msg.MessageUtil;
/*     */ import com.wanniu.game.common.msg.WNNotifyManager;
/*     */ import com.wanniu.game.data.ArmourAttributeCO;
/*     */ import com.wanniu.game.data.GameData;
/*     */ import com.wanniu.game.data.ext.AchievementConfigExt;
/*     */ import com.wanniu.game.data.ext.AchievementExt;
/*     */ import com.wanniu.game.functionOpen.FunctionOpenManager;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.poes.AchievementDataPO;
/*     */ import com.wanniu.game.poes.PlayerPO;
/*     */ import com.wanniu.game.poes.TaskListPO;
/*     */ import com.wanniu.redis.PlayerPOManager;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.function.Predicate;
/*     */ import pomelo.area.AchievementHandler;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AchievementServiceNew
/*     */ {
/*     */   public List<AchievementExt> achievementLevelArray;
/*     */   public List<AchievementExt> achievementUpLevelArray;
/*     */   public List<AchievementExt> achievementPower;
/*     */   
/*     */   enum ERR_CODE
/*     */   {
/*  40 */     ERR_CODE_OK(0), ERR_CODE_BAG_FULL(1), ERR_CODE_NO_SUCH_AWARD(2), ERR_CODE_CONFIG_ERROR(3), ERR_CODE_PLAYER_LEVEL(4), ERR_CODE_ACHIEVEMENT_SCORE(5), ERR_CODE_ACHIEVEMENT_NOT_FINISH(6), ERR_CODE_DATA_ERROR(7), ERR_CODE_NOT_ENOUGH_GLOD(8), ERE_CODE_FAIL(9), ERR_CODE_NEED_GOTO(10);
/*     */     private int value;
/*     */     
/*     */     ERR_CODE(int value) {
/*  44 */       this.value = value;
/*     */     }
/*     */     
/*     */     public int getValue() {
/*  48 */       return this.value;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private AchievementServiceNew() {
/*  59 */     init();
/*     */   }
/*     */   
/*     */   private static class Holder {
/*  63 */     private static AchievementServiceNew Instance = new AchievementServiceNew();
/*     */   }
/*     */   
/*     */   public static AchievementServiceNew getInstance() {
/*  67 */     return Holder.Instance;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void init() {
/*  74 */     initAchievementType();
/*     */   }
/*     */   
/*     */   public void initAchievementType() {
/*  78 */     this.achievementLevelArray = getAchievementsByConditionType(Const.ACHIEVEMENT_CONDITION_TYPE.PLAYER_LEVEL);
/*     */     
/*  80 */     this.achievementUpLevelArray = getAchievementsByConditionType(Const.ACHIEVEMENT_CONDITION_TYPE.PLAYER_RANK);
/*     */     
/*  82 */     this.achievementPower = getAchievementsByConditionType(Const.ACHIEVEMENT_CONDITION_TYPE.PLAYER_POWER_POINT);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private List<AchievementExt> getAchievementsByConditionType(Const.ACHIEVEMENT_CONDITION_TYPE type) {
/*  92 */     Collection<AchievementExt> all = GameData.Achievements.values();
/*  93 */     List<AchievementExt> result = new ArrayList<>();
/*  94 */     for (AchievementExt achExt : all) {
/*  95 */       if (type.value == achExt.conditionType) {
/*  96 */         result.add(achExt);
/*     */       }
/*     */     } 
/*     */     
/* 100 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int isAdd(int id, List<Integer> add) {
/* 111 */     int tem = 0;
/*     */     
/* 113 */     for (Integer key : add) {
/* 114 */       if (key.intValue() == id) {
/* 115 */         tem = 1;
/* 116 */         return tem;
/*     */       } 
/*     */     } 
/* 119 */     return tem;
/*     */   }
/*     */   
/*     */   public AchievementHandler.Achievement achievementToJson4Payload(AchievementDataPO.AchievePO achievementRecord) {
/* 123 */     AchievementHandler.Achievement.Builder achievementData = AchievementHandler.Achievement.newBuilder();
/* 124 */     if (achievementRecord != null) {
/* 125 */       achievementData.setStatus(0);
/* 126 */       achievementData.setId(achievementRecord.id);
/* 127 */       achievementData.setScheduleCurr(achievementRecord.scheduleCurr);
/*     */     } 
/* 129 */     return achievementData.build();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isComplete(AchievementDataPO.AchievePO po, AchievementExt ext) {
/* 136 */     if (po.scheduleCurr >= ext.targetNum) {
/* 137 */       return true;
/*     */     }
/* 139 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getColorContent(int pro, String playerName, String achievementName) {
/* 147 */     int quality = Const.ACHIEVEMENT_QUALITY_TYPE.ORANGE.value;
/* 148 */     String playerNameTxt = LangService.format("NAME_COLOR", new Object[] { playerName });
/* 149 */     if (quality == Const.ACHIEVEMENT_QUALITY_TYPE.WHITE.value)
/* 150 */       return LangService.getValue("ACHIEVEMENT_FINISH_WHITE").replace("{playerName}", playerNameTxt).replace("{achievementName}", achievementName); 
/* 151 */     if (quality == Const.ACHIEVEMENT_QUALITY_TYPE.GREEN.value)
/* 152 */       return LangService.getValue("ACHIEVEMENT_FINISH_GREEN").replace("{playerName}", playerNameTxt).replace("{achievementName}", achievementName); 
/* 153 */     if (quality == Const.ACHIEVEMENT_QUALITY_TYPE.BLUE.value)
/* 154 */       return LangService.getValue("ACHIEVEMENT_FINISH_BLUE").replace("{playerName}", playerNameTxt).replace("{achievementName}", achievementName); 
/* 155 */     if (quality == Const.ACHIEVEMENT_QUALITY_TYPE.PURPLE.value)
/* 156 */       return LangService.getValue("ACHIEVEMENT_FINISH_PRUPLE").replace("{playerName}", playerNameTxt).replace("{achievementName}", achievementName); 
/* 157 */     if (quality == Const.ACHIEVEMENT_QUALITY_TYPE.ORANGE.value)
/* 158 */       return LangService.getValue("ACHIEVEMENT_FINISH_ORANGE").replace("{playerName}", playerNameTxt).replace("{achievementName}", achievementName); 
/* 159 */     if (quality == Const.ACHIEVEMENT_QUALITY_TYPE.RED.value) {
/* 160 */       return LangService.getValue("ACHIEVEMENT_FINISH_RED").replace("{playerName}", playerNameTxt).replace("{achievementName}", achievementName);
/*     */     }
/* 162 */     return playerNameTxt;
/*     */   }
/*     */   
/*     */   public List<AchievementExt> findByConditionType(Const.ACHIEVEMENT_CONDITION_TYPE conditionType) {
/* 166 */     return GameData.findAchievements(t -> (t.conditionType == conditionType.value));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<AchievementExt> findAchievementsByIdAndConditionType(int id, Const.ACHIEVEMENT_CONDITION_TYPE conditionType) {
/* 172 */     return GameData.findAchievements(t -> 
/* 173 */         (t.conditionType == conditionType.value && t.id == id));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<AchievementExt> findByConditionTypeAndTargetIdInt(Const.ACHIEVEMENT_CONDITION_TYPE conditionType, int targetID) {
/* 181 */     return GameData.findAchievements(ext -> 
/* 182 */         (ext.conditionType == conditionType.value && Integer.parseInt(ext.targetID) == targetID));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<AchievementExt> findByConditionTypeAndTargetIdString(final Const.ACHIEVEMENT_CONDITION_TYPE conditionType, final String targetID) {
/* 190 */     List<AchievementExt> achievementArray = GameData.findAchievements(new Predicate<AchievementExt>()
/*     */         {
/*     */           public boolean test(AchievementExt ext) {
/* 193 */             return (ext.conditionType == conditionType.value && (StringUtil.isEmpty(targetID) || (StringUtil.isNotEmpty(targetID) && ext.targetID.equals(targetID))));
/*     */           }
/*     */         });
/*     */     
/* 197 */     return achievementArray;
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
/*     */   public List<AchievementHandler.Achievement> _onConditionChange(int newSchedule, List<AchievementExt> achievementArray, WNPlayer player, boolean isAdd) {
/* 212 */     Map<Integer, AchievementDataPO.AchievePO> achievementRecords = player.achievementManager.getAchievementRecords();
/* 213 */     if (achievementRecords == null) {
/* 214 */       return null;
/*     */     }
/* 216 */     List<AchievementHandler.Achievement> achievementDatas = new ArrayList<>();
/*     */     
/* 218 */     if (!player.functionOpenManager.isOpen(Const.FunctionType.ACHIEVEMENT.getValue())) {
/* 219 */       return achievementDatas;
/*     */     }
/*     */     
/* 222 */     for (AchievementExt achievement : achievementArray) {
/* 223 */       if (achievement == null)
/*     */         continue; 
/* 225 */       AchievementConfigExt config = (AchievementConfigExt)GameData.AchievementConfigs.get(Integer.valueOf(achievement.chapterID));
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 230 */       if (!GetChapterOpened(player.getId(), achievement.chapterID)) {
/*     */         continue;
/*     */       }
/*     */       
/* 234 */       AchievementDataPO.AchievePO achievementRecord = achievementRecords.get(Integer.valueOf(achievement.id));
/* 235 */       if (achievementRecord == null) {
/* 236 */         achievementRecord = new AchievementDataPO.AchievePO();
/* 237 */         achievementRecord.id = achievement.id;
/* 238 */         achievementRecord.scheduleCurr = 0;
/* 239 */         achievementRecords.put(Integer.valueOf(achievement.id), achievementRecord);
/*     */       } 
/* 241 */       if (achievementRecord.scheduleCurr >= achievement.targetNum) {
/*     */         continue;
/*     */       }
/*     */ 
/*     */       
/* 246 */       if (achievement.conditionType == Const.ACHIEVEMENT_CONDITION_TYPE.EQUIP_POS_LEVEL.value || achievement.conditionType == Const.ACHIEVEMENT_CONDITION_TYPE.PET_LEVEL.value) {
/* 247 */         int schedule = 0;
/* 248 */         if (achievementRecord.data == null) {
/* 249 */           schedule = 1;
/* 250 */           achievementRecord.data = new ArrayList();
/* 251 */           achievementRecord.data.add(String.valueOf(newSchedule));
/*     */         } else {
/* 253 */           boolean newpos = true;
/* 254 */           for (String pos : achievementRecord.data) {
/* 255 */             if (Integer.parseInt(pos) == newSchedule) {
/* 256 */               newpos = false;
/*     */               break;
/*     */             } 
/*     */           } 
/* 260 */           if (newpos) {
/* 261 */             achievementRecord.data.add(String.valueOf(newSchedule));
/*     */           }
/* 263 */           schedule = achievementRecord.data.size();
/*     */         } 
/* 265 */         achievementRecord.scheduleCurr = schedule;
/*     */       }
/* 267 */       else if (isAdd) {
/* 268 */         achievementRecord.scheduleCurr += newSchedule;
/*     */       } else {
/* 270 */         achievementRecord.scheduleCurr = newSchedule;
/*     */       } 
/*     */       
/* 273 */       if (achievementRecord.scheduleCurr >= achievement.targetNum) {
/*     */         
/* 275 */         achievementRecord.scheduleCurr = achievement.targetNum;
/*     */ 
/*     */         
/* 278 */         if (GetChapterFinished(player.getId(), achievement.chapterID)) {
/* 279 */           int holyArmourId = -1;
/* 280 */           for (ArmourAttributeCO armourAttributeCO : GameData.ArmourAttributes.values()) {
/* 281 */             if (armourAttributeCO.typeId == achievement.chapterID)
/* 282 */               holyArmourId = armourAttributeCO.iD; 
/*     */           } 
/* 284 */           if (holyArmourId == -1) {
/* 285 */             Out.error(new Object[] { "脚本错误" });
/* 286 */             return null;
/*     */           } 
/*     */           
/* 289 */           AchievementDataPO.HolyArmour holyArmour = (AchievementDataPO.HolyArmour)player.achievementManager.achievementDataPO.holyArmourMap.get(Integer.valueOf(holyArmourId));
/* 290 */           if (holyArmour.states == 1) {
/* 291 */             holyArmour.states = 2;
/*     */           }
/*     */         } 
/*     */ 
/*     */         
/* 296 */         achievementDatas.add(achievementToJson4Payload(achievementRecord));
/*     */         
/* 298 */         if (achievement.broadCast == 1) {
/*     */           
/* 300 */           String content = getColorContent(player.getPro(), player.getName(), achievement.name);
/* 301 */           MessageUtil.sendRollChat(player.getLogicServerId(), content, Const.CHAT_SCOPE.SYSTEM);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 306 */     if (achievementDatas != null && achievementDatas.size() > 0) {
/* 307 */       WNNotifyManager.getInstance().pushAchievements(player, achievementDatas);
/* 308 */       player.achievementManager.updateSuperScript();
/*     */     } 
/* 310 */     return achievementDatas;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void OnFriendAchieveOfOfflinePlayer(int newSchedule, List<AchievementExt> achievementArray, String playerId) {
/* 317 */     AchievementDataPO achievementDataPO = (AchievementDataPO)PlayerPOManager.findPO(ConstsTR.achievementTR, playerId, AchievementDataPO.class);
/*     */     
/* 319 */     Map<Integer, AchievementDataPO.AchievePO> achievementRecords = achievementDataPO.achievements;
/* 320 */     if (achievementRecords == null) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 325 */     if (!FunctionOpenManager.IsOpen(Const.FunctionType.ACHIEVEMENT.getValue(), playerId)) {
/*     */       return;
/*     */     }
/*     */     
/* 329 */     for (AchievementExt achievement : achievementArray) {
/* 330 */       if (achievement == null)
/*     */         continue; 
/* 332 */       AchievementConfigExt config = (AchievementConfigExt)GameData.AchievementConfigs.get(Integer.valueOf(achievement.chapterID));
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 337 */       if (!GetChapterOpened(playerId, achievement.chapterID)) {
/*     */         continue;
/*     */       }
/*     */       
/* 341 */       AchievementDataPO.AchievePO achievementRecord = achievementRecords.get(Integer.valueOf(achievement.id));
/* 342 */       if (achievementRecord == null) {
/*     */         return;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 349 */       if (achievementRecord.scheduleCurr >= achievement.targetNum) {
/*     */         continue;
/*     */       }
/*     */ 
/*     */       
/* 354 */       achievementRecord.scheduleCurr += newSchedule;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Map<Integer, int[]> GetChapterProgress(String playerId) {
/* 364 */     AchievementDataPO achievementDataPO = (AchievementDataPO)PlayerPOManager.findPO(ConstsTR.achievementTR, playerId, AchievementDataPO.class);
/*     */     
/* 366 */     Map<Integer, int[]> result = (Map)new HashMap<>();
/* 367 */     for (AchievementConfigExt achievementConfigExt : GameData.AchievementConfigs.values()) {
/*     */       
/* 369 */       List<AchievementExt> list_achieve = GameData.findAchievements(t -> (t.chapterID == achievementConfigExt.id));
/*     */ 
/*     */       
/* 372 */       int[] ar = new int[2];
/* 373 */       ar[0] = 0;
/* 374 */       ar[1] = list_achieve.size();
/* 375 */       result.put(Integer.valueOf(achievementConfigExt.id), ar);
/*     */     } 
/*     */     
/* 378 */     for (AchievementDataPO.AchievePO achievePO : achievementDataPO.achievements.values()) {
/* 379 */       AchievementExt prop = (AchievementExt)GameData.Achievements.get(Integer.valueOf(achievePO.id));
/* 380 */       if (prop == null) {
/* 381 */         Out.error(new Object[] { AchievementManager.class, Integer.valueOf(achievePO.id) });
/*     */         
/*     */         continue;
/*     */       } 
/* 385 */       AchievementConfigExt config = (AchievementConfigExt)GameData.AchievementConfigs.get(Integer.valueOf(prop.chapterID));
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 390 */       if (!GetChapterOpened(playerId, prop.chapterID)) {
/*     */         continue;
/*     */       }
/* 393 */       if (achievePO.awardState == 1) {
/* 394 */         int[] ar = result.get(Integer.valueOf(prop.chapterID));
/* 395 */         ar[0] = ar[0] + 1; continue;
/*     */       } 
/* 397 */       if (achievePO.scheduleCurr >= prop.targetNum) {
/* 398 */         int[] ar = result.get(Integer.valueOf(prop.chapterID));
/* 399 */         ar[0] = ar[0] + 1;
/*     */       } 
/*     */     } 
/*     */     
/* 403 */     for (Map.Entry<Integer, int[]> entry : result.entrySet()) {
/* 404 */       if (((int[])entry.getValue())[0] == ((int[])entry.getValue())[1]) {
/* 405 */         int holyArmourId = -1;
/* 406 */         for (ArmourAttributeCO armourAttributeCO : GameData.ArmourAttributes.values()) {
/* 407 */           if (armourAttributeCO.typeId == ((Integer)entry.getKey()).intValue())
/* 408 */             holyArmourId = armourAttributeCO.iD; 
/*     */         } 
/* 410 */         if (holyArmourId == -1) {
/* 411 */           Out.error(new Object[] { "脚本错误" });
/* 412 */           return null;
/*     */         } 
/*     */         
/* 415 */         AchievementDataPO.HolyArmour holyArmour = (AchievementDataPO.HolyArmour)achievementDataPO.holyArmourMap.get(Integer.valueOf(holyArmourId));
/* 416 */         if (holyArmour.states == 1) {
/* 417 */           holyArmour.states = 2;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 422 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean GetChapterOpened(String playerId, int chapterId) {
/* 429 */     AchievementConfigExt achievementConfigExt = (AchievementConfigExt)GameData.AchievementConfigs.get(Integer.valueOf(chapterId));
/* 430 */     TaskListPO taskListPO = (TaskListPO)PlayerPOManager.findPO(ConstsTR.taskTR, playerId, TaskListPO.class);
/* 431 */     PlayerPO playerPO = (PlayerPO)PlayerPOManager.findPO(ConstsTR.playerTR, playerId, PlayerPO.class);
/*     */     
/* 433 */     if (playerPO.level < achievementConfigExt.lv) {
/* 434 */       return false;
/*     */     }
/* 436 */     if (achievementConfigExt.quest != 0 && !taskListPO.finishedNormalTasks.containsKey(Integer.valueOf(achievementConfigExt.quest))) {
/* 437 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 446 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean GetChapterFinished(String playerId, int chapterId) {
/* 453 */     Map<Integer, int[]> progress = GetChapterProgress(playerId);
/*     */     
/* 455 */     int[] ar = progress.get(Integer.valueOf(chapterId));
/* 456 */     if (ar[0] == ar[1]) {
/* 457 */       return true;
/*     */     }
/* 459 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\achievement\AchievementServiceNew.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */