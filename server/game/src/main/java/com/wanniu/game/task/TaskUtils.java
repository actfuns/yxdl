/*     */ package com.wanniu.game.task;
/*     */ 
/*     */ import com.google.protobuf.GeneratedMessage;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.util.RandomUtil;
/*     */ import com.wanniu.core.util.StringUtil;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.ConstsTR;
/*     */ import com.wanniu.game.common.Utils;
/*     */ import com.wanniu.game.data.CircleCO;
/*     */ import com.wanniu.game.data.CircleChoiceCO;
/*     */ import com.wanniu.game.data.DailyCO;
/*     */ import com.wanniu.game.data.DailyReduceCO;
/*     */ import com.wanniu.game.data.GameData;
/*     */ import com.wanniu.game.data.TaskChestCO;
/*     */ import com.wanniu.game.data.base.TaskBase;
/*     */ import com.wanniu.game.data.ext.WayTreasureExt;
/*     */ import com.wanniu.game.functionOpen.FunctionOpenUtil;
/*     */ import com.wanniu.game.player.GlobalConfig;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.poes.PlayerBasePO;
/*     */ import com.wanniu.game.poes.PlayerPO;
/*     */ import com.wanniu.game.team.TeamData;
/*     */ import com.wanniu.redis.PlayerPOManager;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.Comparator;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.TreeMap;
/*     */ import pomelo.area.TaskHandler;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TaskUtils
/*     */ {
/*  43 */   public static Map<Integer, TaskBase> AllTasks = new HashMap<>();
/*     */   
/*  45 */   public static List<CircleCO> AllCircleRates = null;
/*     */   
/*  47 */   public static List<DailyReduceCO> AllDailyRates = null;
/*     */   
/*  49 */   private static Map<Integer, List<TaskChestCO>> progressBox = null;
/*     */   
/*  51 */   private static List<Integer> dailySceneIds = null;
/*     */   
/*  53 */   private static Map<Integer, List<TaskBase>> sceneDailyTask = null;
/*     */   
/*  55 */   private static List<Integer> dailyLevels = null;
/*     */   
/*     */   public static void init() {
/*  58 */     AllTasks.putAll(GameData.MainLines);
/*  59 */     AllTasks.putAll(GameData.BranchLines);
/*  60 */     AllTasks.putAll(GameData.Dailys);
/*  61 */     AllTasks.putAll(GameData.CircleScenes);
/*     */ 
/*     */     
/*  64 */     AllCircleRates = new ArrayList<>(GameData.Circles.values());
/*  65 */     AllCircleRates.sort(new Comparator<CircleCO>()
/*     */         {
/*     */           public int compare(CircleCO arg0, CircleCO arg1)
/*     */           {
/*  69 */             int result = 0;
/*  70 */             if (arg0.num > arg1.num) {
/*  71 */               result = 1;
/*  72 */             } else if (arg0.num < arg1.num) {
/*  73 */               result = -1;
/*     */             } 
/*  75 */             return result;
/*     */           }
/*     */         });
/*     */     
/*  79 */     AllDailyRates = new ArrayList<>(GameData.DailyReduces.values());
/*  80 */     AllDailyRates.sort(new Comparator<DailyReduceCO>()
/*     */         {
/*     */           public int compare(DailyReduceCO arg0, DailyReduceCO arg1)
/*     */           {
/*  84 */             int result = 0;
/*  85 */             if (arg0.num > arg1.num) {
/*  86 */               result = 1;
/*  87 */             } else if (arg0.num < arg1.num) {
/*  88 */               result = -1;
/*     */             } 
/*  90 */             return result;
/*     */           }
/*     */         });
/*     */ 
/*     */     
/*  95 */     GameData.CircleScenes = new TreeMap<>(GameData.CircleScenes);
/*     */ 
/*     */     
/*  98 */     progressBox = new HashMap<>();
/*  99 */     progressBox.put(Integer.valueOf(2), new ArrayList<>());
/* 100 */     progressBox.put(Integer.valueOf(3), new ArrayList<>());
/*     */     
/* 102 */     for (TaskChestCO taskChest : GameData.TaskChests.values()) {
/* 103 */       ((List<TaskChestCO>)progressBox.get(Integer.valueOf(taskChest.kind))).add(taskChest);
/*     */     }
/*     */     
/* 106 */     for (List<TaskChestCO> taskChestList : progressBox.values()) {
/* 107 */       taskChestList.sort(new Comparator<TaskChestCO>()
/*     */           {
/*     */             public int compare(TaskChestCO o1, TaskChestCO o2) {
/* 110 */               if (o1.charLevel < o2.charLevel)
/* 111 */                 return 1; 
/* 112 */               if (o1.charLevel > o2.charLevel) {
/* 113 */                 return -1;
/*     */               }
/* 115 */               return 0;
/*     */             }
/*     */           });
/*     */     } 
/*     */     
/* 120 */     sceneDailyTask = new HashMap<>();
/* 121 */     dailySceneIds = new ArrayList<>();
/* 122 */     dailyLevels = new ArrayList<>();
/* 123 */     for (TaskBase daily : GameData.Dailys.values()) {
/* 124 */       List<TaskBase> list = sceneDailyTask.get(Integer.valueOf(daily.startScene));
/* 125 */       if (list == null) {
/* 126 */         list = new ArrayList<>();
/* 127 */         sceneDailyTask.put(Integer.valueOf(daily.startScene), list);
/*     */       } 
/* 129 */       list.add(daily);
/*     */       
/* 131 */       if (!dailySceneIds.contains(Integer.valueOf(daily.startScene))) {
/* 132 */         dailySceneIds.add(Integer.valueOf(daily.startScene));
/*     */       }
/*     */       
/* 135 */       if (!dailyLevels.contains(Integer.valueOf(daily.level))) {
/* 136 */         dailyLevels.add(Integer.valueOf(daily.level));
/*     */       }
/*     */     } 
/* 139 */     for (List<TaskBase> list_daily : sceneDailyTask.values()) {
/* 140 */       list_daily.sort(new Comparator<TaskBase>()
/*     */           {
/*     */             public int compare(TaskBase o1, TaskBase o2)
/*     */             {
/* 144 */               if (o1.iD < o2.iD)
/* 145 */                 return -1; 
/* 146 */               if (o1.iD > o2.iD) {
/* 147 */                 return 1;
/*     */               }
/* 149 */               return 0;
/*     */             }
/*     */           });
/*     */     } 
/*     */ 
/*     */     
/* 155 */     dailyLevels.sort(new Comparator<Integer>()
/*     */         {
/*     */           public int compare(Integer o1, Integer o2) {
/* 158 */             if (o1.intValue() < o2.intValue())
/* 159 */               return -1; 
/* 160 */             if (o1.intValue() > o2.intValue()) {
/* 161 */               return 1;
/*     */             }
/* 163 */             return 0;
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */   
/*     */   public static TaskData createTask(TaskBase prop) {
/* 170 */     return createTask(prop, Const.TaskState.NOT_START);
/*     */   }
/*     */   
/*     */   public static TaskData createTask(TaskBase prop, Const.TaskState state) {
/* 174 */     TaskData data = new TaskData(prop);
/* 175 */     data.db.state = state.getValue();
/* 176 */     return data;
/*     */   }
/*     */   
/*     */   public static List<TaskBase.ItemNode> getReward(TaskBase prop, int pro) {
/* 180 */     List<TaskBase.ItemNode> rewards = new ArrayList<>();
/* 181 */     if (prop.rewards.containsKey(Integer.valueOf(pro))) {
/* 182 */       List<TaskBase.ItemNode> temp = (List<TaskBase.ItemNode>)prop.rewards.get(Integer.valueOf(pro));
/* 183 */       for (TaskBase.ItemNode node : temp) {
/* 184 */         rewards.add(new TaskBase.ItemNode(node.itemCode, node.itemNum, node.isBind));
/*     */       }
/*     */     } 
/* 187 */     if (prop.rewards.containsKey(Integer.valueOf(0))) {
/* 188 */       List<TaskBase.ItemNode> temp = (List<TaskBase.ItemNode>)prop.rewards.get(Integer.valueOf(0));
/* 189 */       for (TaskBase.ItemNode node : temp) {
/* 190 */         rewards.add(new TaskBase.ItemNode(node.itemCode, node.itemNum, node.isBind));
/*     */       }
/*     */     } 
/* 193 */     return rewards;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static List<TaskBase> getDailyTasks(int level, int rank, int pro, int cycleType) {
/* 201 */     List<TaskBase> dailyTasks = new ArrayList<>();
/*     */ 
/*     */     
/* 204 */     for (DailyCO daily : GameData.Dailys.values()) {
/* 205 */       if (daily.before.equals("0") && (cycleType == -1 || daily.taskCycle == cycleType) && (daily.pro == 0 || daily.pro == pro) && 
/* 206 */         checkOpenWay(daily.openWay, daily.openDay) && checkTaskValidTime(daily.openTime, daily.endTime)) {
/* 207 */         dailyTasks.add(daily);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 212 */     return dailyTasks;
/*     */   }
/*     */   
/*     */   public static final TaskBase getTaskProp(int id) {
/* 216 */     TaskBase task = (TaskBase)GameData.MainLines.get(Integer.valueOf(id));
/* 217 */     if (task == null) {
/* 218 */       task = (TaskBase)GameData.BranchLines.get(Integer.valueOf(id));
/* 219 */       if (task == null) {
/* 220 */         task = (TaskBase)GameData.Dailys.get(Integer.valueOf(id));
/*     */       }
/* 222 */       if (task == null) {
/* 223 */         task = (TaskBase)GameData.CircleScenes.get(Integer.valueOf(id));
/*     */       }
/* 225 */       if (task == null) {
/* 226 */         task = (TaskBase)GameData.Treasures.get(Integer.valueOf(id));
/*     */       }
/*     */     } 
/* 229 */     return task;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static TaskBase getStealTaskProp(int giveNpc) {
/* 238 */     int type = Const.TaskType.STEAL.getValue();
/* 239 */     for (TaskBase task : AllTasks.values()) {
/* 240 */       if (task.type == type && task.giveNpc == giveNpc) {
/* 241 */         return task;
/*     */       }
/*     */     } 
/* 244 */     for (DailyCO daily : GameData.Dailys.values()) {
/* 245 */       if (daily.giveNpc == giveNpc) {
/* 246 */         return (TaskBase)daily;
/*     */       }
/*     */     } 
/* 249 */     return null;
/*     */   }
/*     */   
/*     */   public static boolean checkOpenWay(int openWay, String[] openDay) {
/* 253 */     if (openWay == Const.TaskOpenWay.None.getValue()) {
/* 254 */       return false;
/*     */     }
/* 256 */     if (openWay == Const.TaskOpenWay.DailyOpenInTime.getValue()) {
/* 257 */       return true;
/*     */     }
/* 259 */     Date now = new Date();
/* 260 */     Calendar c = Calendar.getInstance();
/* 261 */     c.setTime(now);
/* 262 */     int indexDay = c.get(7);
/* 263 */     if (indexDay == 0) {
/* 264 */       indexDay = 7;
/*     */     }
/* 266 */     for (String day : openDay) {
/* 267 */       int dayInt = Integer.parseInt(day);
/* 268 */       if (dayInt == indexDay && 
/* 269 */         openWay == Const.TaskOpenWay.WeekOpenInTime.getValue()) {
/* 270 */         return true;
/*     */       }
/*     */     } 
/*     */     
/* 274 */     return false;
/*     */   }
/*     */   
/*     */   public static boolean checkTaskValidTime(String startTime, String endTime) {
/* 278 */     if (StringUtil.isEmpty(startTime) || StringUtil.isEmpty(endTime)) {
/* 279 */       return true;
/*     */     }
/*     */     
/* 282 */     Date start = Utils.getTodayTimeFromString(startTime, null);
/* 283 */     Date end = Utils.getTodayTimeFromString(endTime, null);
/* 284 */     Date now = new Date();
/* 285 */     if (now.getTime() >= start.getTime() && now.getTime() <= end.getTime()) {
/* 286 */       return true;
/*     */     }
/* 288 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getLoopAwardRate(int times) {
/* 295 */     int rate = 0;
/* 296 */     for (CircleCO co : AllCircleRates) {
/* 297 */       if (co.num <= times) {
/* 298 */         rate = co.rate;
/*     */       }
/*     */     } 
/* 301 */     return rate;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean profitableLoop(WNPlayer player) {
/* 311 */     int times = player.taskManager.taskListPO.todayLoopTaskCount;
/* 312 */     CircleCO co = AllCircleRates.get(AllCircleRates.size() - 1);
/*     */     
/* 314 */     return (co.num > times);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getAvgLevel(TeamData team) {
/* 321 */     int openLevel = (FunctionOpenUtil.getPropByName(Const.FunctionType.LoopTask.getValue())).openLv;
/* 322 */     if (team == null) {
/* 323 */       return openLevel;
/*     */     }
/* 325 */     float levelRate = ((CircleChoiceCO)GameData.CircleChoices.get(Integer.valueOf(team.memberCount()))).rate;
/* 326 */     int totalLevel = 0;
/* 327 */     for (TeamData.TeamMemberData member : team.teamMembers.values()) {
/* 328 */       WNPlayer mPlayer = member.getPlayer();
/* 329 */       int lv = 0;
/* 330 */       if (mPlayer != null) {
/* 331 */         lv = mPlayer.getLevel();
/*     */       } else {
/* 333 */         PlayerPO playerPO = (PlayerPO)PlayerPOManager.findPO(ConstsTR.playerTR, member.id, PlayerPO.class);
/* 334 */         if (playerPO != null) {
/* 335 */           lv = playerPO.level;
/*     */         }
/*     */       } 
/*     */       
/* 339 */       lv = (int)(lv * levelRate);
/* 340 */       totalLevel += (lv > openLevel) ? lv : openLevel;
/*     */     } 
/* 342 */     int avgLevel = totalLevel / team.memberCount();
/* 343 */     return avgLevel;
/*     */   }
/*     */   
/* 346 */   private static int times = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static TaskBase getRDDailyTask(int level, int beforeTaskId, int pro) {
/* 352 */     List<TaskBase> list_tasks = null;
/* 353 */     TaskBase prop = null;
/* 354 */     int taskSceneId = 0;
/* 355 */     if (beforeTaskId == 0) {
/* 356 */       while (prop == null) {
/* 357 */         taskSceneId = ((Integer)dailySceneIds.get(RandomUtil.getIndex(dailySceneIds.size()))).intValue();
/* 358 */         list_tasks = sceneDailyTask.get(Integer.valueOf(taskSceneId));
/* 359 */         prop = getDailyTask(level, pro, list_tasks, 0);
/* 360 */         times++;
/* 361 */         if (times > 50) {
/* 362 */           times = 0;
/* 363 */           Out.error(new Object[] { "1getRDDailyTask死锁level=", Integer.valueOf(level), ",beforeTaskId=", Integer.valueOf(beforeTaskId), ",pro=", Integer.valueOf(pro) });
/*     */           break;
/*     */         } 
/*     */       } 
/* 367 */       if (prop != null) {
/* 368 */         times = 0;
/*     */       }
/* 370 */       return prop;
/*     */     } 
/*     */     
/* 373 */     TaskBase beforeProp = (TaskBase)GameData.Dailys.get(Integer.valueOf(beforeTaskId));
/* 374 */     taskSceneId = beforeProp.startScene;
/* 375 */     list_tasks = sceneDailyTask.get(Integer.valueOf(taskSceneId));
/* 376 */     int index = -1;
/* 377 */     for (int i = 0; i < list_tasks.size(); i++) {
/* 378 */       if (((TaskBase)list_tasks.get(i)).iD == beforeTaskId) {
/* 379 */         index = i;
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/* 384 */     while (prop == null) {
/* 385 */       list_tasks = sceneDailyTask.get(Integer.valueOf(taskSceneId));
/* 386 */       prop = getDailyTask(level, pro, list_tasks, index + 1);
/* 387 */       taskSceneId = getRDTaskSceneId(taskSceneId);
/* 388 */       index = -1;
/* 389 */       times++;
/* 390 */       if (times > 50) {
/* 391 */         times = 0;
/* 392 */         Out.error(new Object[] { "2getRDDailyTask死锁level=" + level + ",beforeTaskId=" + beforeTaskId + ",pro=" + pro });
/*     */         break;
/*     */       } 
/*     */     } 
/* 396 */     if (prop != null) {
/* 397 */       times = 0;
/*     */     }
/*     */ 
/*     */     
/* 401 */     return prop;
/*     */   }
/*     */   
/*     */   private static int getRDTaskSceneId(int beforeSceneId) {
/* 405 */     List<Integer> list = new ArrayList<>();
/* 406 */     for (Iterator<Integer> iterator = dailySceneIds.iterator(); iterator.hasNext(); ) { int sceneId = ((Integer)iterator.next()).intValue();
/* 407 */       if (beforeSceneId != sceneId) {
/* 408 */         list.add(Integer.valueOf(sceneId));
/*     */       } }
/*     */     
/* 411 */     return ((Integer)list.get(RandomUtil.getIndex(list.size()))).intValue();
/*     */   }
/*     */   
/*     */   private static TaskBase getDailyTask(int level, int pro, List<TaskBase> list_tasks, int index) {
/* 415 */     if (index >= list_tasks.size() - 1) {
/* 416 */       return null;
/*     */     }
/*     */     
/* 419 */     for (int i = index; i < list_tasks.size(); i++) {
/* 420 */       TaskBase prop = list_tasks.get(i);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 429 */       if (level >= prop.level && prop.level == getNeerLevel(level))
/*     */       {
/*     */ 
/*     */         
/* 433 */         if (prop.pro == 0 || prop.pro == pro)
/*     */         {
/*     */           
/* 436 */           return prop;
/*     */         }
/*     */       }
/*     */     } 
/* 440 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int getNeerLevel(int myLevel) {
/* 449 */     int lv = 0;
/* 450 */     for (Iterator<Integer> iterator = dailyLevels.iterator(); iterator.hasNext(); ) { int level = ((Integer)iterator.next()).intValue();
/* 451 */       if (level <= myLevel) {
/* 452 */         lv = level;
/*     */       } }
/*     */ 
/*     */     
/* 456 */     return lv;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getDailyAwardRate(int times) {
/* 463 */     int rate = 0;
/* 464 */     for (DailyReduceCO co : AllDailyRates) {
/* 465 */       if (co.num <= times) {
/* 466 */         rate = co.rate;
/*     */       }
/*     */     } 
/* 469 */     return rate;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void dealTrainEquipAllTask(WNPlayer player) {
/* 478 */     int equip_count = 0;
/* 479 */     Map<Integer, PlayerBasePO.EquipStrengthPos> strengthPos = player.equipManager.strengthPos;
/* 480 */     for (Iterator<Integer> iterator = strengthPos.keySet().iterator(); iterator.hasNext(); ) { int pos = ((Integer)iterator.next()).intValue();
/* 481 */       PlayerBasePO.EquipStrengthPos equip = strengthPos.get(Integer.valueOf(pos));
/* 482 */       int equipLevel = equip.enSection * (GlobalConfig.EquipmentCraft_Enchant_MaxenLevel + 1) + equip.enLevel;
/* 483 */       if (equipLevel < 10) {
/*     */         continue;
/*     */       }
/* 486 */       equip_count++; }
/*     */     
/* 488 */     player.taskManager.dealTaskEvent(Const.TaskType.TRAIN_EQUIP_ALL, "-1", equip_count);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static TaskChestCO getProgressBox(int taskKind, int level) {
/* 497 */     List<TaskChestCO> list = progressBox.get(Integer.valueOf(taskKind));
/* 498 */     for (TaskChestCO taskChest : list) {
/* 499 */       if (level >= taskChest.charLevel) {
/* 500 */         return taskChest;
/*     */       }
/*     */     } 
/* 503 */     Out.error(new Object[] { "getProgressBox error, taskKind=", Integer.valueOf(taskKind), ", level=", Integer.valueOf(level) });
/* 504 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static TaskBase getFirstLoopTask() {
/* 511 */     Iterator<TaskBase> iterator = GameData.CircleScenes.values().iterator(); if (iterator.hasNext()) { TaskBase _prop = iterator.next();
/* 512 */       return _prop; }
/*     */     
/* 514 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean canTalkWithNpc(int templateId, int npcId) {
/* 525 */     TaskBase prop = getTaskProp(templateId);
/* 526 */     if (prop != null && prop.needNpcs.contains(Integer.valueOf(npcId))) {
/* 527 */       return true;
/*     */     }
/* 529 */     return false;
/*     */   }
/*     */   
/*     */   public static void treasurePush(WNPlayer player, int wayId, int taskId) {
/* 533 */     TaskHandler.TreasureScenePointPush.Builder scenePointPush = TaskHandler.TreasureScenePointPush.newBuilder();
/* 534 */     WayTreasureExt way = (WayTreasureExt)GameData.WayTreasures.get(Integer.valueOf(wayId));
/* 535 */     int sceneIndex = RandomUtil.getIndex(way.doScenes.size());
/* 536 */     scenePointPush.setSceneId(((Integer)way.doScenes.get(sceneIndex)).intValue());
/* 537 */     List<Integer> points = way.doPoints.get(sceneIndex);
/* 538 */     scenePointPush.setPoint(((Integer)points.get(RandomUtil.getIndex(points.size()))).intValue());
/* 539 */     scenePointPush.setTaskId(taskId);
/* 540 */     player.receive("area.taskPush.treasureScenePointPush", (GeneratedMessage)scenePointPush.build());
/*     */     
/* 542 */     player.getXmdsManager().addUnit("", 0, null);
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\task\TaskUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */