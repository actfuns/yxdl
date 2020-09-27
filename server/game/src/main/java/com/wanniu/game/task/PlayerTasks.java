/*      */ package com.wanniu.game.task;
/*      */ 
/*      */ import com.alibaba.fastjson.JSON;
/*      */ import com.alibaba.fastjson.JSONArray;
/*      */ import com.google.protobuf.GeneratedMessage;
/*      */ import com.wanniu.core.common.StringString;
/*      */ import com.wanniu.core.game.LangService;
/*      */ import com.wanniu.core.logfs.Out;
/*      */ import com.wanniu.core.util.StringUtil;
/*      */ import com.wanniu.game.GWorld;
/*      */ import com.wanniu.game.bag.WNBag;
/*      */ import com.wanniu.game.common.Const;
/*      */ import com.wanniu.game.common.msg.MessageUtil;
/*      */ import com.wanniu.game.daoyou.DaoYouService;
/*      */ import com.wanniu.game.data.BranchLineCO;
/*      */ import com.wanniu.game.data.CardCO;
/*      */ import com.wanniu.game.data.CharacterLevelCO;
/*      */ import com.wanniu.game.data.CircleRewardCO;
/*      */ import com.wanniu.game.data.DailyReduceCO;
/*      */ import com.wanniu.game.data.DailyRewardCO;
/*      */ import com.wanniu.game.data.GameData;
/*      */ import com.wanniu.game.data.TaskChestCO;
/*      */ import com.wanniu.game.data.base.DItemBase;
/*      */ import com.wanniu.game.data.base.TaskBase;
/*      */ import com.wanniu.game.equip.EquipManager;
/*      */ import com.wanniu.game.equip.NormalEquip;
/*      */ import com.wanniu.game.item.ItemUtil;
/*      */ import com.wanniu.game.item.NormalItem;
/*      */ import com.wanniu.game.item.data.ItemToBtlServerData;
/*      */ import com.wanniu.game.message.MessageData;
/*      */ import com.wanniu.game.player.BILogService;
/*      */ import com.wanniu.game.player.GlobalConfig;
/*      */ import com.wanniu.game.player.WNPlayer;
/*      */ import com.wanniu.game.player.po.MiscData;
/*      */ import com.wanniu.game.poes.PlayerBasePO;
/*      */ import com.wanniu.game.poes.TaskListPO;
/*      */ import com.wanniu.game.request.task.AcceptTaskHandler;
/*      */ import com.wanniu.game.task.po.TaskPO;
/*      */ import com.wanniu.game.team.TeamData;
/*      */ import java.util.ArrayList;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.concurrent.ConcurrentHashMap;
/*      */ import pomelo.area.TaskHandler;
/*      */ import pomelo.task.TaskOuterClass;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class PlayerTasks
/*      */ {
/*      */   private WNPlayer player;
/*      */   public TaskListPO taskListPO;
/*      */   public LoopResult loopResult;
/*      */   private int playerPro;
/*      */   public Map<Integer, TaskPO> normalTasks;
/*      */   public Map<Integer, Integer> finishedNormalTasks;
/*      */   public Map<Integer, TaskPO> dailyTasks;
/*      */   public Map<Integer, Integer> finishedDailyTasks;
/*      */   public Map<Integer, TaskPO> treasureTasks;
/*      */   public Map<Integer, Integer> finishedTreasureTasks;
/*      */   private Map<Integer, List<TaskData>> eventWatchers;
/*      */   
/*      */   public static class NotifyToBattleServerParam
/*      */   {
/*      */     public String playerUUID;
/*      */     public String questID;
/*      */     public boolean initStatus;
/*      */     public List<StringString> status;
/*      */   }
/*      */   
/*      */   public static class DropItemServerData
/*      */   {
/*      */     public Const.Position pos;
/*      */     public List<ItemToBtlServerData> items;
/*      */   }
/*      */   
/*      */   public PlayerTasks(WNPlayer player, TaskListPO tasks) {
/*   90 */     this.player = player;
/*   91 */     this.playerPro = player.getPro();
/*   92 */     this.taskListPO = tasks;
/*   93 */     init(tasks);
/*      */   }
/*      */ 
/*      */   
/*      */   private final void init(TaskListPO data) {
/*   98 */     this.normalTasks = data.normalTasks;
/*      */     
/*  100 */     this.finishedNormalTasks = data.finishedNormalTasks;
/*      */     
/*  102 */     if (GWorld.DEBUG) {
/*  103 */       if (data.treasureTasks == null) {
/*  104 */         data.treasureTasks = new HashMap<>();
/*      */       }
/*  106 */       if (data.finishedTreasureTasks == null) {
/*  107 */         data.finishedTreasureTasks = new HashMap<>();
/*      */       }
/*  109 */       if (data.loopResult == null) {
/*  110 */         data.loopResult = new LoopResult();
/*      */       }
/*      */     } 
/*      */     
/*  114 */     this.dailyTasks = data.dailyTasks;
/*  115 */     this.finishedDailyTasks = data.finishedDailyTasks;
/*      */     
/*  117 */     this.treasureTasks = data.treasureTasks;
/*  118 */     this.finishedTreasureTasks = data.finishedTreasureTasks;
/*      */     
/*  120 */     this.loopResult = data.loopResult;
/*      */     
/*  122 */     refreshWatchEvents();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void refreshNewDay() {
/*  131 */     MiscData miscData = this.player.playerAttachPO.miscData;
/*  132 */     if (miscData != null) {
/*  133 */       miscData.guildBlessToday = 0;
/*  134 */       miscData.guildSkillUpToday = 0;
/*  135 */       miscData.guildDonateToday = 0;
/*      */     } 
/*      */     
/*  138 */     this.finishedDailyTasks = new HashMap<>();
/*      */     
/*  140 */     if (this.taskListPO != null) {
/*  141 */       this.taskListPO.todayLoopTaskCount = 0;
/*  142 */       this.taskListPO.todayDailyTaskCount = 0;
/*      */     } 
/*      */ 
/*      */     
/*  146 */     for (TaskBase prop : GameData.BranchLines.values()) {
/*  147 */       if (this.player.getLevel() < prop.level) {
/*      */         continue;
/*      */       }
/*  150 */       if (this.normalTasks.containsKey(Integer.valueOf(prop.iD))) {
/*      */         
/*  152 */         if (prop.type == Const.TaskType.ACTIVITY_NUM.getValue() || prop.type == Const.TaskType.FINISH_DUNGEONS_COUNT.getValue() || prop.type == Const.TaskType.KILL_BOSS_COUNT.getValue()) {
/*  153 */           TaskData task = new TaskData(this.normalTasks.get(Integer.valueOf(prop.iD)));
/*  154 */           task.setProgress(0);
/*  155 */           pushTaskUpdate(task);
/*      */         } 
/*      */         continue;
/*      */       } 
/*  159 */       if (prop.type == Const.TaskType.ACTIVITY_NUM.getValue() || prop.type == Const.TaskType.FINISH_DUNGEONS_COUNT.getValue() || prop.type == Const.TaskType.KILL_BOSS_COUNT.getValue()) {
/*  160 */         AcceptTaskHandler.AcceptTaskResult result = acceptTask(prop.iD, 1);
/*  161 */         if (result.task != null) {
/*  162 */           result.task.setSecProgress(getSecProgress(result.task.getKind()));
/*  163 */           pushTaskUpdate(result.task);
/*      */         }  continue;
/*  165 */       }  if (prop.type == Const.TaskType.ACCEPT_DAILY_LOOP.getValue() && StringUtil.isNotEmpty(prop.targetID)) {
/*  166 */         int targetId = Integer.parseInt(prop.targetID);
/*  167 */         if (targetId == 2 && this.dailyTasks.size() == 0) {
/*  168 */           AcceptTaskHandler.AcceptTaskResult result = acceptTask(prop.iD, 1);
/*  169 */           if (result.task != null) {
/*  170 */             result.task.setSecProgress(getSecProgress(result.task.getKind()));
/*  171 */             pushTaskUpdate(result.task);
/*      */           }  continue;
/*  173 */         }  if (targetId == 3) {
/*  174 */           TeamData team = this.player.getTeamManager().getTeam();
/*  175 */           if (team == null || (team != null && (team.loopTasks == null || team.loopTasks.size() == 0))) {
/*  176 */             AcceptTaskHandler.AcceptTaskResult result = acceptTask(prop.iD, 1);
/*  177 */             if (result.task != null) {
/*  178 */               result.task.setSecProgress(getSecProgress(result.task.getKind()));
/*  179 */               pushTaskUpdate(result.task);
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  189 */     refreshWatchEvents();
/*      */   }
/*      */   
/*      */   public final void refreshWatchEvents() {
/*  193 */     this.eventWatchers = new ConcurrentHashMap<>();
/*      */     
/*  195 */     for (TaskPO db : this.normalTasks.values()) {
/*  196 */       TaskData task = new TaskData(db);
/*  197 */       int type = task.getType();
/*  198 */       List<TaskData> tasks = this.eventWatchers.get(Integer.valueOf(type));
/*  199 */       if (tasks == null) {
/*  200 */         tasks = new ArrayList<>();
/*  201 */         this.eventWatchers.put(Integer.valueOf(type), tasks);
/*      */       } 
/*  203 */       tasks.add(task);
/*      */     } 
/*      */     
/*  206 */     for (TaskPO db : this.dailyTasks.values()) {
/*  207 */       TaskData task = new TaskData(db);
/*  208 */       int type = task.getType();
/*  209 */       List<TaskData> tasks = this.eventWatchers.get(Integer.valueOf(type));
/*  210 */       if (tasks == null) {
/*  211 */         tasks = new ArrayList<>();
/*  212 */         this.eventWatchers.put(Integer.valueOf(type), tasks);
/*      */       } 
/*  214 */       tasks.add(task);
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  230 */     for (TaskPO db : this.treasureTasks.values()) {
/*  231 */       TaskData task = new TaskData(db);
/*  232 */       int type = task.getType();
/*  233 */       List<TaskData> tasks = this.eventWatchers.get(Integer.valueOf(type));
/*  234 */       if (tasks == null) {
/*  235 */         tasks = new ArrayList<>();
/*  236 */         this.eventWatchers.put(Integer.valueOf(type), tasks);
/*      */       } 
/*  238 */       tasks.add(task);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final JSONArray toJson4BattleServer() {
/*  246 */     JSONArray data = new JSONArray();
/*  247 */     for (Map.Entry<Integer, TaskPO> node : this.normalTasks.entrySet()) {
/*  248 */       TaskData task = new TaskData(node.getValue());
/*  249 */       if (task.getState() > Const.TaskState.NOT_START.getValue()) {
/*  250 */         data.add(task.toJson4BattleServer());
/*      */       }
/*      */     } 
/*  253 */     for (Map.Entry<Integer, TaskPO> node : this.dailyTasks.entrySet()) {
/*  254 */       TaskData task = new TaskData(node.getValue());
/*  255 */       if (task.getState() > Const.TaskState.NOT_START.getValue()) {
/*  256 */         data.add(task.toJson4BattleServer());
/*      */       }
/*      */     } 
/*      */     
/*  260 */     Map<Integer, TaskPO> loopTasks = this.player.teamManager.getLoopTasks();
/*  261 */     if (loopTasks != null) {
/*  262 */       for (Map.Entry<Integer, TaskPO> node : loopTasks.entrySet()) {
/*  263 */         TaskData task = new TaskData(node.getValue());
/*  264 */         if (task.getState() > Const.TaskState.NOT_START.getValue()) {
/*  265 */           data.add(task.toJson4BattleServer());
/*      */         }
/*      */       } 
/*      */     }
/*      */     
/*  270 */     for (Map.Entry<Integer, TaskPO> node : this.treasureTasks.entrySet()) {
/*  271 */       TaskData task = new TaskData(node.getValue());
/*  272 */       if (task.getState() > Const.TaskState.NOT_START.getValue()) {
/*  273 */         data.add(task.toJson4BattleServer());
/*      */       }
/*      */     } 
/*  276 */     return data;
/*      */   }
/*      */ 
/*      */   
/*      */   public final void dealTaskEvent(Const.TaskType type, int num) {
/*  281 */     onEvent(new TaskEvent(type, new Object[] { null, Integer.valueOf(num) }));
/*      */   }
/*      */   
/*      */   public final void dealTaskEvent(Const.TaskType type, String target, int num) {
/*  285 */     onEvent(new TaskEvent(type, new Object[] { target, Integer.valueOf(num) }));
/*      */   }
/*      */   
/*      */   public final TaskData getTask(int templateId, int kind) {
/*  289 */     if (kind == 0 || kind == 1) {
/*  290 */       if (this.normalTasks.containsKey(Integer.valueOf(templateId))) {
/*  291 */         return new TaskData(this.normalTasks.get(Integer.valueOf(templateId)));
/*      */       }
/*  293 */     } else if (kind == 2) {
/*  294 */       if (this.dailyTasks.containsKey(Integer.valueOf(templateId))) {
/*  295 */         return new TaskData(this.dailyTasks.get(Integer.valueOf(templateId)));
/*      */       }
/*  297 */     } else if (kind == 3) {
/*      */       
/*  299 */       TeamData team = this.player.getTeamManager().getTeam();
/*  300 */       if (team != null && team.loopTasks != null && team.loopTasks.containsKey(Integer.valueOf(templateId))) {
/*  301 */         return new TaskData((TaskPO)team.loopTasks.get(Integer.valueOf(templateId)));
/*      */       }
/*  303 */     } else if (kind == 8) {
/*  304 */       if (this.treasureTasks.containsKey(Integer.valueOf(templateId))) {
/*  305 */         return new TaskData(this.treasureTasks.get(Integer.valueOf(templateId)));
/*      */       }
/*      */     } else {
/*  308 */       Out.error(new Object[] { "getTask is null:templateId=", Integer.valueOf(templateId), ",kind=", Integer.valueOf(kind) });
/*      */     } 
/*  310 */     return null;
/*      */   }
/*      */   
/*      */   public final TaskData getTaskByID(int templateId) {
/*  314 */     TaskPO task = this.normalTasks.get(Integer.valueOf(templateId));
/*  315 */     if (task == null) {
/*  316 */       task = this.dailyTasks.get(Integer.valueOf(templateId));
/*      */     }
/*  318 */     if (task == null) {
/*  319 */       TeamData team = this.player.getTeamManager().getTeam();
/*  320 */       if (team != null && team.loopTasks != null) {
/*  321 */         task = (TaskPO)team.loopTasks.get(Integer.valueOf(templateId));
/*      */       }
/*      */     } 
/*  324 */     if (task == null) {
/*  325 */       task = this.treasureTasks.get(Integer.valueOf(templateId));
/*      */     }
/*  327 */     if (task != null) {
/*  328 */       return new TaskData(task);
/*      */     }
/*  330 */     return null;
/*      */   }
/*      */   
/*      */   public final boolean isTaskDoingOrFinish(int templateId) {
/*  334 */     TaskData task = getTaskByID(templateId);
/*  335 */     if (task != null && 
/*  336 */       task.getState() >= Const.TaskState.NOT_COMPLETED.getValue()) {
/*  337 */       return true;
/*      */     }
/*      */     
/*  340 */     if (isFinish(templateId, 0)) {
/*  341 */       return true;
/*      */     }
/*  343 */     return false;
/*      */   }
/*      */   
/*      */   public final boolean isTaskDoing(int templateId) {
/*  347 */     TaskData task = getTaskByID(templateId);
/*  348 */     if (task != null && 
/*  349 */       task.getState() == Const.TaskState.NOT_COMPLETED.getValue()) {
/*  350 */       return true;
/*      */     }
/*      */     
/*  353 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final TaskData doingTaskHaveType(int taskType) {
/*  363 */     Out.debug(new Object[] { "doingTaskHaveType:", Integer.valueOf(taskType) });
/*  364 */     List<TaskData> all = this.eventWatchers.get(Integer.valueOf(taskType));
/*  365 */     if (all != null && all.size() > 0)
/*  366 */       for (TaskData task : all) {
/*  367 */         if (task != null && task.getState() == Const.TaskState.NOT_COMPLETED.getValue()) {
/*  368 */           return task;
/*      */         }
/*      */       }  
/*  371 */     return null;
/*      */   }
/*      */   
/*      */   public final boolean hasMainLineTask() {
/*  375 */     for (Map.Entry<Integer, TaskPO> node : this.normalTasks.entrySet()) {
/*  376 */       TaskData task = new TaskData(node.getValue());
/*  377 */       if (task != null && task.getKind() == 0) {
/*  378 */         return true;
/*      */       }
/*      */     } 
/*  381 */     return false;
/*      */   }
/*      */   
/*      */   private final boolean isDailyFinish(int templateId) {
/*  385 */     return this.finishedDailyTasks.containsKey(Integer.valueOf(templateId));
/*      */   }
/*      */   
/*      */   private final boolean isTreasureFinish(int templateId) {
/*  389 */     return this.finishedTreasureTasks.containsKey(Integer.valueOf(templateId));
/*      */   }
/*      */   
/*      */   private final boolean isLoopFinish(int templateId) {
/*  393 */     TeamData team = this.player.getTeamManager().getTeam();
/*  394 */     if (team != null && team.finishedLoopTasks != null) {
/*  395 */       return team.finishedLoopTasks.containsKey(Integer.valueOf(templateId));
/*      */     }
/*  397 */     return false;
/*      */   }
/*      */   
/*      */   private final boolean isNormalFinish(int templateId) {
/*  401 */     return this.finishedNormalTasks.containsKey(Integer.valueOf(templateId));
/*      */   }
/*      */   
/*      */   private final boolean isFinish(int templateId, int kind) {
/*  405 */     switch (kind) {
/*      */       case 2:
/*  407 */         return isDailyFinish(templateId);
/*      */       case 3:
/*  409 */         return isLoopFinish(templateId);
/*      */       case 8:
/*  411 */         return isTreasureFinish(templateId);
/*      */     } 
/*  413 */     return isNormalFinish(templateId);
/*      */   }
/*      */ 
/*      */   
/*      */   public final boolean isFinishTask(int templateId) {
/*  418 */     return (isDailyFinish(templateId) || isNormalFinish(templateId) || isTreasureFinish(templateId));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final String _canAcceptTaskByProp(TaskBase prop) {
/*  425 */     if (prop == null) {
/*  426 */       return LangService.getValue("TASK_TEMPLATE_NOT_EXIST");
/*      */     }
/*  428 */     int templateId = prop.getId();
/*  429 */     int kind = prop.getKind();
/*      */ 
/*      */     
/*  432 */     if (TaskUtils.checkOpenWay(prop.openWay, prop.openDay) && 
/*  433 */       !TaskUtils.checkTaskValidTime(prop.openTime, prop.endTime)) {
/*  434 */       return LangService.getValue("TASK_TIME_IS_NOT_OPEN");
/*      */     }
/*      */ 
/*      */     
/*  438 */     if (StringUtil.isNotEmpty(prop.job) && 
/*  439 */       prop.pro != this.player.getPro())
/*      */     {
/*  441 */       return LangService.getValue("TASK_JOB_ERROR");
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*  446 */     if ((kind == 0 || kind == 1) && 
/*  447 */       isFinish(templateId, prop.getKind())) {
/*  448 */       return LangService.getValue("TASK_IS_ACCPETED");
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*  453 */     TaskData task = getTask(templateId, kind);
/*  454 */     if (task != null && task.getState() != Const.TaskState.NOT_START.getValue()) {
/*  455 */       Out.debug(new Object[] { "task not has get " });
/*      */       
/*  457 */       return LangService.getValue("TASK_IS_ACCPETED");
/*      */     } 
/*      */     
/*  460 */     if (prop.kind != 3) {
/*      */       
/*  462 */       if ((this.player.getPlayer()).upLevel < prop.upOrder)
/*  463 */         return LangService.getValue("TASK_UPLEVEL_ERROR"); 
/*  464 */       if ((this.player.getPlayer()).level < prop.level) {
/*  465 */         return LangService.format("TASK_LEVEL_ERROR", new Object[] { Integer.valueOf(prop.level) });
/*      */       }
/*      */ 
/*      */       
/*  469 */       if ((this.player.getPlayer()).upLevel > prop.upLimit)
/*  470 */         return LangService.getValue("TASK_UPLEVEL_ERROR"); 
/*  471 */       if (prop.levelLimit > 0 && (this.player.getPlayer()).upLevel == prop.upLimit && (this.player.getPlayer()).level > prop.levelLimit) {
/*  472 */         return LangService.getValue("TASK_UPLEVEL_ERROR");
/*      */       }
/*      */     } 
/*      */     
/*  476 */     if (prop.kind != 2 && prop.type != Const.TaskType.ACCEPT_DAILY_LOOP.getValue() && prop.type != Const.TaskType.ACTIVITY_NUM.getValue() && prop.type != Const.TaskType.FINISH_DUNGEONS_COUNT.getValue() && prop.type != Const.TaskType.KILL_BOSS_COUNT.getValue()) {
/*  477 */       if (prop.beforeRelations > 0) {
/*      */         
/*  479 */         for (int j = 0; j < prop.beforeTask.length; j++) {
/*  480 */           int beforeTask = Integer.parseInt(prop.beforeTask[j]);
/*  481 */           if (beforeTask != 0 && 
/*  482 */             isFinish(beforeTask, prop.getKind())) {
/*  483 */             return null;
/*      */           }
/*      */         } 
/*      */         
/*  487 */         return LangService.getValue("TASK_BEFORE_ERROR");
/*      */       } 
/*      */       
/*  490 */       for (int i = 0; i < prop.beforeTask.length; i++) {
/*  491 */         int beforeTask = Integer.parseInt(prop.beforeTask[i]);
/*  492 */         if (beforeTask != 0 && 
/*  493 */           !isFinish(beforeTask, prop.getKind())) {
/*  494 */           Out.debug(new Object[] { "beforeTask not finished beforeTask:" + beforeTask });
/*  495 */           return LangService.getValue("TASK_BEFORE_ERROR");
/*      */         } 
/*      */       } 
/*      */       
/*  499 */       return null;
/*      */     } 
/*      */     
/*  502 */     return null;
/*      */   }
/*      */   
/*      */   private final boolean _isDiscardItemTask(TaskData task) {
/*  506 */     if (task.getType() == Const.TaskType.DISCARD_ITEM.getValue()) {
/*  507 */       task.db.state = Const.TaskState.NOT_COMPLETED.getValue();
/*  508 */       String itemId = task.prop.targets.get(0);
/*  509 */       if (itemId.length() > 0 && 
/*  510 */         this.player.getWnBag().findItemNumByCode(itemId) >= task.getTargetNum()) {
/*  511 */         dealTaskEvent(Const.TaskType.DISCARD_ITEM, itemId, task.getTargetNum());
/*  512 */         task.setSecProgress(getSecProgress(task.getKind()));
/*  513 */         pushTaskUpdate(task);
/*      */       }
/*      */     
/*      */     }
/*  517 */     else if (task.getTargetNum() != 0) {
/*  518 */       task.db.state = Const.TaskState.NOT_COMPLETED.getValue();
/*      */     } 
/*      */     
/*  521 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final boolean _discardItem(TaskData task) {
/*  531 */     if (task.getType() == Const.TaskType.DISCARD_ITEM.getValue()) {
/*  532 */       String itemId = task.prop.targets.get(0);
/*  533 */       if (itemId.length() > 0) {
/*  534 */         Out.debug(new Object[] { "accept code:", itemId });
/*  535 */         boolean flag = this.player.getWnBag().discardItem(itemId, task.getTargetNum(), Const.GOODS_CHANGE_TYPE.task_submit, null, false, false);
/*      */         
/*  537 */         task.db.state = Const.TaskState.COMPLETED_NOT_DELIVERY.getValue();
/*  538 */         return flag;
/*      */       } 
/*      */     } 
/*  541 */     return true;
/*      */   }
/*      */   
/*      */   public final void gmNewTask(int templateId) {
/*  545 */     TaskData task = getTaskByID(templateId);
/*  546 */     if (task != null) {
/*  547 */       task.db.state = Const.TaskState.NOT_START.getValue();
/*      */     } else {
/*  549 */       TaskBase prop = TaskUtils.getTaskProp(templateId);
/*  550 */       task = TaskUtils.createTask(prop);
/*  551 */       _addTask(task);
/*      */     } 
/*  553 */     task.setSecProgress(getSecProgress(task.getKind()));
/*  554 */     pushTaskUpdate(task);
/*      */   }
/*      */   
/*      */   public final void gmfinishTaskTarget(int templateId) {
/*  558 */     TaskData task = getTaskByID(templateId);
/*  559 */     if (task != null) {
/*  560 */       complete(task);
/*      */     }
/*      */   }
/*      */   
/*      */   public final void gmDiscardTaskByID(int templateId) {
/*  565 */     if (templateId == 0) {
/*  566 */       Out.debug(new Object[] { "------------------deleteTask------all------------" });
/*  567 */       Map<Integer, TaskPO> all = new HashMap<>();
/*  568 */       all.putAll(this.normalTasks);
/*  569 */       all.putAll(this.dailyTasks);
/*  570 */       TeamData team = this.player.getTeamManager().getTeam();
/*  571 */       if (team != null && team.loopTasks != null) {
/*  572 */         all.putAll(team.loopTasks);
/*      */       }
/*  574 */       all.putAll(this.treasureTasks);
/*  575 */       for (Map.Entry<Integer, TaskPO> node : all.entrySet()) {
/*  576 */         TaskData task = new TaskData(node.getValue());
/*  577 */         task.db.state = Const.TaskState.DELETE.getValue();
/*  578 */         _deleteTask(task.db.templateId, task.prop.getKind(), true);
/*  579 */         task.setSecProgress(getSecProgress(task.getKind()));
/*  580 */         pushTaskUpdate(task);
/*      */       } 
/*      */     } else {
/*  583 */       TaskData task = getTaskByID(templateId);
/*  584 */       if (task != null) {
/*  585 */         Out.debug(new Object[] { "------------------deleteTask------------------", Integer.valueOf(templateId) });
/*  586 */         task.db.state = Const.TaskState.DELETE.getValue();
/*  587 */         _deleteTask(task.db.templateId, task.prop.getKind(), true);
/*  588 */         task.setSecProgress(getSecProgress(task.getKind()));
/*  589 */         pushTaskUpdate(task);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public final void gmAcceptTask(int templateId) {
/*  595 */     TaskBase prop = TaskUtils.getTaskProp(templateId);
/*  596 */     TaskData task = TaskUtils.createTask(prop, Const.TaskState.NOT_COMPLETED);
/*  597 */     _isDiscardItemTask(task);
/*  598 */     _addTask(task);
/*      */ 
/*      */     
/*  601 */     List<TaskBase.ItemNode> rewards = task.prop.accepTaskRewards;
/*  602 */     Out.debug(new Object[] { "AccepTaskReward", rewards });
/*  603 */     List<WNBag.SimpleItemInfo> items = new ArrayList<>();
/*  604 */     for (TaskBase.ItemNode node : rewards) {
/*  605 */       WNBag.SimpleItemInfo map = new WNBag.SimpleItemInfo();
/*  606 */       map.itemCode = node.itemCode;
/*  607 */       map.itemNum = node.itemNum;
/*  608 */       map.forceType = Const.ForceType.BIND;
/*      */       
/*  610 */       items.add(map);
/*      */     } 
/*  612 */     if (!this.player.getWnBag().testAddCodeItems(items, Const.ForceType.BIND, false)) {
/*      */       return;
/*      */     }
/*      */     
/*  616 */     Out.debug(new Object[] { "AccepTask reward ", rewards });
/*  617 */     this.player.getWnBag().addCodeItems(items, Const.GOODS_CHANGE_TYPE.task, null, false, false);
/*      */ 
/*      */     
/*  620 */     this.player.functionOpenManager.onAcceptTask(String.valueOf(templateId));
/*      */ 
/*      */     
/*  623 */     List<StringString> attr = task.initBattleServerAttribute();
/*  624 */     NotifyToBattleServerParam param1 = new NotifyToBattleServerParam();
/*  625 */     param1.playerUUID = this.player.getId();
/*  626 */     param1.questID = String.valueOf(templateId);
/*  627 */     param1.initStatus = true;
/*  628 */     param1.status = attr;
/*  629 */     notifyToBattleServer("QuestStatusChangedR2B", param1);
/*      */     
/*  631 */     _checkProCondition(task);
/*  632 */     task.setSecProgress(getSecProgress(task.getKind()));
/*  633 */     pushTaskUpdate(task);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final AcceptTaskHandler.AcceptTaskResult acceptTask(int templateId, int kind) {
/*  643 */     Out.debug(new Object[] { "acceptTask templateId: ", Integer.valueOf(templateId), " kind: ", Integer.valueOf(kind) });
/*  644 */     AcceptTaskHandler.AcceptTaskResult result = new AcceptTaskHandler.AcceptTaskResult();
/*  645 */     TaskBase prop = TaskUtils.getTaskProp(templateId);
/*  646 */     String canAcceptRes = _canAcceptTaskByProp(prop);
/*  647 */     if (canAcceptRes != null) {
/*  648 */       result.msg = canAcceptRes;
/*  649 */       return result;
/*      */     } 
/*  651 */     result.task = getTask(templateId, kind);
/*  652 */     if (result.task == null) {
/*  653 */       result.task = TaskUtils.createTask(prop);
/*  654 */       if (result.task.getTargetNum() == 0)
/*      */       {
/*  656 */         result.task.db.state = Const.TaskState.NOT_COMPLETED.getValue();
/*      */       }
/*  658 */       _addTask(result.task);
/*      */     } 
/*      */     
/*  661 */     if (!_isDiscardItemTask(result.task)) {
/*  662 */       result.msg = LangService.getValue("TASK_BEFORE_ERROR");
/*  663 */       return result;
/*      */     } 
/*      */ 
/*      */     
/*  667 */     if (StringUtil.isNotEmpty(result.task.prop.modID)) {
/*  668 */       String[] data = result.task.prop.modID.split(":");
/*  669 */       this.player.playerBasePO.model = data[0];
/*  670 */       this.player.playerBasePO.speed = Float.parseFloat(data[1]);
/*  671 */       this.player.refreshBattlerServerAvatar();
/*  672 */       this.player.refreshBattlerServerEffect(false);
/*      */     } 
/*      */     
/*  675 */     _checkProCondition(result.task);
/*      */ 
/*      */     
/*  678 */     List<TaskBase.ItemNode> rewards = result.task.prop.accepTaskRewards;
/*  679 */     if (rewards != null) {
/*  680 */       WNBag bag = this.player.getWnBag();
/*  681 */       List<WNBag.SimpleItemInfo> rItems = new ArrayList<>(rewards.size());
/*  682 */       for (TaskBase.ItemNode node : rewards) {
/*  683 */         WNBag.SimpleItemInfo map = new WNBag.SimpleItemInfo();
/*  684 */         map.itemCode = node.itemCode;
/*  685 */         map.itemNum = node.itemNum;
/*  686 */         map.forceType = Const.ForceType.BIND;
/*  687 */         rItems.add(map);
/*      */       } 
/*  689 */       if (!bag.testAddCodeItems(rItems, Const.ForceType.BIND, false)) {
/*  690 */         return result;
/*      */       }
/*  692 */       List<NormalItem> finalRewards = new ArrayList<>();
/*  693 */       for (int i = 0; i < rewards.size(); i++) {
/*  694 */         TaskBase.ItemNode node = rewards.get(i);
/*  695 */         List<NormalItem> items = ItemUtil.createItemsByItemCode(node.itemCode, node.itemNum);
/*  696 */         for (NormalItem item : items) {
/*  697 */           item.setBind(1);
/*  698 */           finalRewards.add(item);
/*      */         } 
/*      */       } 
/*  701 */       bag.addEntityItems(finalRewards, Const.GOODS_CHANGE_TYPE.task);
/*      */     } 
/*      */ 
/*      */     
/*  705 */     this.player.functionOpenManager.onAcceptTask(String.valueOf(templateId));
/*      */ 
/*      */     
/*  708 */     if (kind == 2 || kind == 3) {
/*  709 */       this.player.taskManager.dealTaskEvent(Const.TaskType.ACCEPT_DAILY_LOOP, String.valueOf(kind), 1);
/*      */     }
/*      */     
/*  712 */     TeamData team = this.player.getTeamManager().getTeam();
/*  713 */     if (team != null && team.leaderId.equals(this.player.getId()) && kind == 3) {
/*  714 */       for (TeamData.TeamMemberData member : team.teamMembers.values()) {
/*  715 */         WNPlayer mPlayer = member.getPlayer();
/*  716 */         if (mPlayer == null) {
/*      */           continue;
/*      */         }
/*  719 */         questStatusChangeR2B(mPlayer, result.task, templateId);
/*      */       } 
/*      */     } else {
/*  722 */       questStatusChangeR2B(this.player, result.task, templateId);
/*      */     } 
/*      */ 
/*      */     
/*  726 */     BILogService.getInstance().ansycReportMission(this.player.getPlayer(), "任务接取", kind, prop.iD, prop.name);
/*  727 */     return result;
/*      */   }
/*      */ 
/*      */   
/*      */   public void questStatusChangeR2B(WNPlayer player, TaskData task, int templateId) {
/*  732 */     List<StringString> attr = task.initBattleServerAttribute();
/*  733 */     NotifyToBattleServerParam param1 = new NotifyToBattleServerParam();
/*  734 */     param1.playerUUID = player.getId();
/*  735 */     param1.questID = String.valueOf(templateId);
/*  736 */     param1.initStatus = true;
/*  737 */     param1.status = attr;
/*  738 */     player.taskManager.notifyToBattleServer("QuestStatusChangedR2B", param1);
/*      */   }
/*      */   
/*      */   private final void _checkProCondition(TaskData task) {
/*  742 */     if (task.prop.getType() == Const.TaskType.LEVEL_UP.getValue()) {
/*      */       
/*  744 */       dealTaskEvent(Const.TaskType.LEVEL_UP, (this.player.getPlayer()).level);
/*  745 */     } else if (task.prop.getType() == Const.TaskType.USERUP_LEVEL.getValue()) {
/*      */       
/*  747 */       dealTaskEvent(Const.TaskType.USERUP_LEVEL, (this.player.getPlayer()).upLevel);
/*  748 */     } else if (task.prop.getType() == Const.TaskType.TRAIN_EQUIP.getValue()) {
/*      */       
/*  750 */       EquipManager.EquipAndLevelData equips = this.player.equipManager.getAllEquipAndLevel();
/*  751 */       Out.debug(new Object[] { "_checkProCondition:", equips });
/*      */ 
/*      */       
/*  754 */       if (task.prop.targetID.equals("0")) {
/*  755 */         dealTaskEvent(Const.TaskType.TRAIN_EQUIP, task.prop.targetID, equips.maxLevel);
/*      */       } else {
/*  757 */         for (Iterator<Integer> iterator = equips.equips.keySet().iterator(); iterator.hasNext(); ) { int pos = ((Integer)iterator.next()).intValue();
/*  758 */           if (!String.valueOf(pos).equals(task.prop.targetID)) {
/*      */             continue;
/*      */           }
/*  761 */           PlayerBasePO.EquipStrengthPos equip = (PlayerBasePO.EquipStrengthPos)equips.equips.get(Integer.valueOf(pos));
/*  762 */           int equipLevel = equip.enSection * (GlobalConfig.EquipmentCraft_Enchant_MaxenLevel + 1) + equip.enLevel;
/*  763 */           if (equipLevel > 0) {
/*  764 */             dealTaskEvent(Const.TaskType.TRAIN_EQUIP, String.valueOf(pos), equipLevel);
/*      */           } }
/*      */ 
/*      */       
/*      */       } 
/*  769 */     } else if (task.prop.getType() == Const.TaskType.TRAIN_EQUIP_ALL.getValue()) {
/*  770 */       TaskUtils.dealTrainEquipAllTask(this.player);
/*  771 */     } else if (task.prop.getType() == Const.TaskType.FILL_GEM.getValue()) {
/*      */       
/*  773 */       for (PlayerBasePO.EquipStrengthPos posInfo : this.player.equipManager.strengthPos.values()) {
/*  774 */         for (String code : posInfo.gems.values()) {
/*  775 */           if (StringUtil.isEmpty(code))
/*      */             continue; 
/*  777 */           DItemBase prop = ItemUtil.getUnEquipPropByCode(code);
/*  778 */           dealTaskEvent(Const.TaskType.FILL_GEM, String.valueOf(prop.levelReq), 1);
/*      */         } 
/*      */       } 
/*  781 */     } else if (task.prop.getType() == Const.TaskType.FRIEND_NUM.getValue()) {
/*      */       
/*  783 */       int frinedNum = this.player.getFriendManager().getFriendsNum();
/*  784 */       if (frinedNum > 0) {
/*  785 */         dealTaskEvent(Const.TaskType.FRIEND_NUM, frinedNum);
/*      */       }
/*  787 */     } else if (task.prop.getType() == Const.TaskType.JOIN_LEAGUE.getValue()) {
/*      */       
/*  789 */       if (DaoYouService.getInstance().getDaoYou(this.player.getId()) != null) {
/*  790 */         dealTaskEvent(Const.TaskType.JOIN_LEAGUE, 1);
/*      */       }
/*  792 */     } else if (task.prop.getType() == Const.TaskType.EARN_NECK.getValue()) {
/*      */       
/*  794 */       if (this.player.playerAttachPO.miscData.hasGetNeck > 0) {
/*  795 */         dealTaskEvent(Const.TaskType.EARN_NECK, 1);
/*      */       }
/*  797 */     } else if (task.prop.getType() == Const.TaskType.ADD_GUILD.getValue()) {
/*      */       
/*  799 */       if (this.player.guildManager.isInGuild()) {
/*  800 */         dealTaskEvent(Const.TaskType.ADD_GUILD, 1);
/*      */       }
/*  802 */     } else if (task.prop.getType() == Const.TaskType.JOIN_SOLO.getValue()) {
/*      */       
/*  804 */       if (this.player.soloManager.soloData.havePlayed) {
/*  805 */         dealTaskEvent(Const.TaskType.JOIN_SOLO, 1);
/*      */       }
/*  807 */     } else if (task.prop.getType() == Const.TaskType.GUILD_PRAY.getValue()) {
/*      */       
/*  809 */       if (this.player.playerAttachPO.miscData.guildBlessToday > 0) {
/*  810 */         dealTaskEvent(Const.TaskType.GUILD_PRAY, this.player.playerAttachPO.miscData.guildBlessToday);
/*      */       }
/*  812 */     } else if (task.prop.getType() == Const.TaskType.GUILD_DONATE.getValue()) {
/*      */       
/*  814 */       if (this.player.playerAttachPO.miscData.guildDonateToday > 0) {
/*  815 */         dealTaskEvent(Const.TaskType.GUILD_DONATE, this.player.playerAttachPO.miscData.guildDonateToday);
/*      */       }
/*  817 */     } else if (task.prop.getType() == Const.TaskType.GUILD_TECH_UP.getValue()) {
/*      */       
/*  819 */       if (this.player.playerAttachPO.miscData.guildSkillUpToday > 0) {
/*  820 */         dealTaskEvent(Const.TaskType.GUILD_TECH_UP, this.player.playerAttachPO.miscData.guildSkillUpToday);
/*      */       }
/*  822 */     } else if (task.prop.getType() == Const.TaskType.TAKE_EQUIP_Qt.getValue()) {
/*      */       
/*  824 */       Map<Integer, NormalEquip> equips = this.player.equipManager.equips;
/*  825 */       for (Map.Entry<Integer, NormalEquip> node : equips.entrySet()) {
/*  826 */         NormalEquip equip = node.getValue();
/*  827 */         String[] conditionArr = ((String)task.prop.targets.get(0)).split("\\|");
/*  828 */         if (conditionArr.length > 1 && 
/*  829 */           equip.getQLevel() >= Integer.parseInt(conditionArr[0]) && equip.getQColor() >= Integer.parseInt(conditionArr[1])) {
/*  830 */           String tarSz = equip.getQLevel() + "|" + equip.getQColor() + "|" + equip.getPosition();
/*  831 */           dealTaskEvent(Const.TaskType.TAKE_EQUIP_Qt, tarSz, 1);
/*      */         }
/*      */       
/*      */       } 
/*  835 */     } else if (task.prop.getType() == Const.TaskType.MOUNT_UPLEVEL.getValue()) {
/*      */       
/*  837 */       if (this.player.mountManager != null && this.player.mountManager.mount != null) {
/*  838 */         int mountLevel = this.player.mountManager.mount.rideLevel * 11 + this.player.mountManager.mount.starLv;
/*  839 */         if (mountLevel > 0) {
/*  840 */           dealTaskEvent(Const.TaskType.MOUNT_UPLEVEL, mountLevel);
/*      */         }
/*      */       } 
/*  843 */     } else if (task.prop.getType() != Const.TaskType.TRAIN_RIDE.getValue()) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  851 */       if (task.prop.getType() != Const.TaskType.PET_TRAIN.getValue())
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  863 */         if (task.prop.getType() == Const.TaskType.ACCEPT_DAILY_LOOP.getValue()) {
/*      */           
/*  865 */           int kind = task.prop.getKind();
/*  866 */           boolean completed = false;
/*  867 */           if (kind == 2) {
/*  868 */             if (this.dailyTasks.size() > 0 || this.taskListPO.todayDailyTaskCount > 0) {
/*  869 */               completed = true;
/*      */             }
/*  871 */           } else if (kind == 3) {
/*  872 */             TeamData team = this.player.teamManager.getTeam();
/*  873 */             if (team != null && team.loopTasks != null && team.loopTasks.size() > 0) {
/*  874 */               completed = true;
/*  875 */             } else if (this.taskListPO.todayLoopTaskCount > 0) {
/*  876 */               completed = true;
/*      */             } 
/*      */           } 
/*  879 */           if (completed) {
/*  880 */             this.player.taskManager.dealTaskEvent(Const.TaskType.ACCEPT_DAILY_LOOP, String.valueOf(kind), 1);
/*      */           }
/*  882 */         } else if (task.prop.getType() == Const.TaskType.ROLE_UPGRADE.getValue() && 
/*  883 */           this.player.player.upLevel > 0) {
/*  884 */           dealTaskEvent(Const.TaskType.ROLE_UPGRADE, this.player.player.upLevel);
/*      */         } 
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final boolean discardTask(int templateId, int kind) {
/*  897 */     Out.debug(new Object[] { "discardTask templateId: ", Integer.valueOf(templateId), " kind: ", Integer.valueOf(kind) });
/*  898 */     TaskData task = getTask(templateId, kind);
/*  899 */     if (task != null) {
/*      */ 
/*      */       
/*  902 */       Out.debug(new Object[] { "------------------deleteTask------------------", Integer.valueOf(templateId) });
/*  903 */       task.db.state = Const.TaskState.DELETE.getValue();
/*  904 */       task.setSecProgress(getSecProgress(task.getKind()));
/*  905 */       _deleteTask(templateId, kind, true);
/*      */ 
/*      */       
/*  908 */       TeamData team = this.player.getTeamManager().getTeam();
/*  909 */       if (kind == 3 && team != null) {
/*  910 */         for (TeamData.TeamMemberData member : team.teamMembers.values()) {
/*  911 */           WNPlayer mPlayer = member.getPlayer();
/*  912 */           if (mPlayer != null) {
/*  913 */             mPlayer.taskManager.pushTaskUpdate(task);
/*      */           }
/*      */         } 
/*      */       } else {
/*  917 */         pushTaskUpdate(task);
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  930 */       return true;
/*      */     } 
/*  932 */     return false;
/*      */   }
/*      */   
/*      */   public final boolean discardTaskByID(int templateId) {
/*  936 */     TaskData task = getTaskByID(templateId);
/*  937 */     if (task != null && task.getState() == Const.TaskState.NOT_COMPLETED.getValue()) {
/*  938 */       Out.debug(new Object[] { "------------------deleteTask------------------", Integer.valueOf(templateId) });
/*  939 */       task.db.state = Const.TaskState.DELETE.getValue();
/*  940 */       task.setSecProgress(getSecProgress(task.getKind()));
/*  941 */       _deleteTask(templateId, task.getKind(), true);
/*  942 */       pushTaskUpdate(task);
/*  943 */       return true;
/*      */     } 
/*  945 */     return false;
/*      */   }
/*      */   
/*      */   public final boolean complete(TaskData task) {
/*  949 */     if (task.getState() == Const.TaskState.NOT_COMPLETED.getValue()) {
/*  950 */       task.complete();
/*      */       
/*  952 */       BILogService.getInstance().ansycReportMission(this.player.getPlayer(), "任务完成", task.getKind(), task.prop.iD, task.prop.name);
/*      */ 
/*      */       
/*  955 */       NotifyToBattleServerParam param = new NotifyToBattleServerParam();
/*  956 */       param.playerUUID = this.player.getId();
/*  957 */       param.questID = String.valueOf(task.db.templateId);
/*  958 */       param.initStatus = false;
/*  959 */       param.status = new ArrayList<>();
/*  960 */       param.status.add(new StringString("state", String.valueOf(task.db.templateId)));
/*  961 */       notifyToBattleServer("QuestStatusChangedR2B", param);
/*      */       
/*  963 */       task.setSecProgress(getSecProgress(task.getKind()));
/*  964 */       pushTaskUpdate(task);
/*  965 */       if (task.getKind() == 2) {
/*  966 */         dailyTaskFinEvent();
/*  967 */       } else if (task.getKind() == 3) {
/*  968 */         loopTaskFinEvent();
/*      */       } 
/*  970 */       return true;
/*      */     } 
/*  972 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final boolean completeTask(int templateId, int kind) {
/*  983 */     TaskData task = getTask(templateId, kind);
/*  984 */     if (task != null) {
/*  985 */       return complete(task);
/*      */     }
/*  987 */     return false;
/*      */   }
/*      */   
/*      */   public final void dailyTaskFinEvent() {
/*  991 */     dealTaskEvent(Const.TaskType.FINISH_DAILY_TASK, 1);
/*  992 */     Out.info(new Object[] { this.player.getId(), ":完成了一次师门任务进度。" });
/*      */     
/*  994 */     this.player.dailyActivityMgr.onEvent(Const.DailyType.DAILY_TASK, "0", 1);
/*      */   }
/*      */   
/*      */   public final void loopTaskFinEvent() {
/*  998 */     TeamData team = this.player.teamManager.getTeam();
/*  999 */     if (team == null) {
/*      */       return;
/*      */     }
/* 1002 */     for (TeamData.TeamMemberData member : team.teamMembers.values()) {
/* 1003 */       WNPlayer player = member.getPlayer();
/* 1004 */       if (player == null) {
/*      */         continue;
/*      */       }
/*      */       
/* 1008 */       player.taskManager.dealTaskEvent(Const.TaskType.FINISH_LOOP_TASK, 1);
/*      */       
/* 1010 */       player.dailyActivityMgr.onEvent(Const.DailyType.LOOP_TASK, "0", 1);
/*      */     } 
/*      */   }
/*      */   
/*      */   public final boolean completeTaskByID(int templateId) {
/* 1015 */     TaskData task = getTaskByID(templateId);
/* 1016 */     if (task != null) {
/* 1017 */       return complete(task);
/*      */     }
/* 1019 */     return false;
/*      */   }
/*      */   
/*      */   public final boolean isCompleteTaskByID(int templateId) {
/* 1023 */     if (isFinishTask(templateId)) {
/* 1024 */       return true;
/*      */     }
/* 1026 */     TaskData task = getTaskByID(templateId);
/* 1027 */     if (task != null) {
/* 1028 */       return task.isCompleted();
/*      */     }
/* 1030 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final boolean gmFinishTask(int templateId) {
/* 1040 */     if (templateId == 0) {
/* 1041 */       for (TaskPO taskPO : this.normalTasks.values()) {
/* 1042 */         TaskBase prop = TaskUtils.getTaskProp(taskPO.templateId);
/* 1043 */         if (prop.getKind() == 0) {
/* 1044 */           templateId = taskPO.templateId;
/*      */           break;
/*      */         } 
/*      */       } 
/* 1048 */     } else if (templateId == 1) {
/* 1049 */       for (TaskPO taskPO : this.normalTasks.values()) {
/* 1050 */         TaskBase prop = TaskUtils.getTaskProp(taskPO.templateId);
/* 1051 */         if (prop.getKind() == 1) {
/* 1052 */           templateId = taskPO.templateId;
/*      */           break;
/*      */         } 
/*      */       } 
/* 1056 */     } else if (templateId == 2) {
/* 1057 */       Iterator<TaskPO> iterator = this.dailyTasks.values().iterator(); if (iterator.hasNext()) { TaskPO taskPO = iterator.next();
/* 1058 */         templateId = taskPO.templateId; }
/*      */ 
/*      */     
/* 1061 */     } else if (templateId == 8) {
/* 1062 */       Iterator<TaskPO> iterator = this.treasureTasks.values().iterator(); if (iterator.hasNext()) { TaskPO taskPO = iterator.next();
/* 1063 */         templateId = taskPO.templateId; }
/*      */ 
/*      */     
/* 1066 */     } else if (templateId == 3) {
/* 1067 */       TeamData team = this.player.teamManager.getTeam();
/* 1068 */       if (team != null) {
/* 1069 */         Iterator<TaskPO> iterator = team.loopTasks.values().iterator(); if (iterator.hasNext()) { TaskPO taskPO = iterator.next();
/* 1070 */           templateId = taskPO.templateId; }
/*      */       
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 1076 */     TaskData task = getTaskByID(templateId);
/* 1077 */     if (task != null) {
/* 1078 */       int kind = task.getKind();
/* 1079 */       if (task.getState() >= Const.TaskState.NOT_START.getValue() && task.getState() <= Const.TaskState.COMPLETED_NOT_DELIVERY.getValue()) {
/*      */         
/* 1081 */         if (task.prop.overState2 == 1) {
/* 1082 */           this.player.playerBasePO.model = null;
/* 1083 */           this.player.playerBasePO.speed = 0.0F;
/* 1084 */           this.player.refreshBattlerServerAvatar();
/* 1085 */           this.player.refreshBattlerServerEffect(false);
/*      */         } 
/*      */         
/* 1088 */         List<TaskBase.ItemNode> rewards = TaskUtils.getReward(task.prop, this.playerPro);
/* 1089 */         List<NormalItem> tcItems = ItemUtil.createItemsByTcCode(task.prop.tcReward);
/* 1090 */         for (NormalItem v : tcItems) {
/* 1091 */           if (v.prop.itemSecondType == Const.ItemSecondType.virtual.getValue()) {
/* 1092 */             rewards.add(new TaskBase.ItemNode((v.getTemplate()).code, v.getWorth(), 0)); continue;
/*      */           } 
/* 1094 */           rewards.add(new TaskBase.ItemNode((v.getTemplate()).code, (v.getTemplate()).groupCount, 0));
/*      */         } 
/*      */         
/* 1097 */         Out.debug(new Object[] { "gmFinishTask task prop:", rewards });
/*      */         
/* 1099 */         WNBag bag = this.player.getWnBag();
/* 1100 */         Out.debug(new Object[] { "gmFinishTask testAddCodeItems " });
/* 1101 */         List<WNBag.SimpleItemInfo> rItems = new ArrayList<>();
/* 1102 */         for (TaskBase.ItemNode node : rewards) {
/* 1103 */           WNBag.SimpleItemInfo map = new WNBag.SimpleItemInfo();
/* 1104 */           map.itemCode = node.itemCode;
/* 1105 */           map.itemNum = node.itemNum;
/* 1106 */           map.forceType = Const.ForceType.BIND;
/* 1107 */           rItems.add(map);
/*      */         } 
/*      */         
/* 1110 */         if (!bag.testAddCodeItems(rItems, Const.ForceType.BIND, false)) {
/* 1111 */           return false;
/*      */         }
/*      */         
/* 1114 */         task.db.state = Const.TaskState.COMPLETED.getValue();
/*      */ 
/*      */         
/* 1117 */         NotifyToBattleServerParam param = new NotifyToBattleServerParam();
/* 1118 */         param.playerUUID = this.player.getId();
/* 1119 */         param.questID = String.valueOf(templateId);
/* 1120 */         notifyToBattleServer("QuestCommittedR2B", param);
/*      */         
/* 1122 */         task.setSecProgress(getSecProgress(task.getKind()));
/* 1123 */         pushTaskUpdate(task);
/*      */         
/* 1125 */         String[] nextTask = task.prop.nextTask;
/*      */         
/* 1127 */         _finishTask(templateId, kind);
/* 1128 */         _deleteTask(templateId, kind, false);
/*      */         
/* 1130 */         TeamData team = this.player.teamManager.getTeam();
/* 1131 */         if (kind == 2) {
/*      */           
/* 1133 */           TaskBase nextProp = TaskUtils.getRDDailyTask(this.player.getLevel(), templateId, this.player.getPro());
/* 1134 */           nextTask = new String[] { String.valueOf(nextProp.iD) };
/* 1135 */           _getNextAcceptTask(kind, nextTask, task.db.finishCount);
/* 1136 */         } else if (kind == 3) {
/*      */           
/* 1138 */           for (TeamData.TeamMemberData member : team.teamMembers.values()) {
/* 1139 */             WNPlayer mPlayer = member.getPlayer();
/* 1140 */             if (mPlayer == null) {
/*      */               continue;
/*      */             }
/* 1143 */             nextTask = task.prop.nextTask;
/* 1144 */             mPlayer.taskManager._getNextAcceptTask(kind, nextTask, task.db.finishCount);
/*      */           } 
/*      */         } else {
/* 1147 */           _getNextAcceptTask(kind, nextTask, task.db.finishCount);
/*      */         } 
/*      */ 
/*      */         
/* 1151 */         Out.debug(new Object[] { "gmFinishTask submit reward ", rewards });
/* 1152 */         bag.addCodeItems(rItems, Const.GOODS_CHANGE_TYPE.task, null, false, false);
/*      */       } 
/*      */     } 
/* 1155 */     if (!this.player.getArea().isNormal()) {
/* 1156 */       this.player.fightLevelManager.leaveDungeon(this.player, this.player.getArea());
/*      */     }
/* 1158 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   public final int getTaskExp(int exp, int expRatio) {
/* 1163 */     if (expRatio <= 0) {
/* 1164 */       return exp;
/*      */     }
/* 1166 */     int maxLevel = GlobalConfig.Role_LevelLimit;
/* 1167 */     if ((this.player.getPlayer()).level >= maxLevel) {
/* 1168 */       return exp;
/*      */     }
/*      */     
/* 1171 */     CharacterLevelCO prop = (CharacterLevelCO)GameData.CharacterLevels.get(Integer.valueOf(this.player.getLevel()));
/* 1172 */     if (prop != null) {
/* 1173 */       return exp + expRatio * prop.experience / 10000;
/*      */     }
/* 1175 */     return exp;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final int submitTask(int templateId, int kind, int isDouble) {
/* 1188 */     TaskData task = getTask(templateId, kind);
/* 1189 */     if (task == null || (task.getState() != Const.TaskState.COMPLETED_NOT_DELIVERY.getValue() && task.getType() != Const.TaskType.DISCARD_ITEM.getValue())) {
/* 1190 */       Out.error(new Object[] { "submitTask: task is null", (this.player.getPlayer()).name, ",kind=", Integer.valueOf(kind), ",id:", Integer.valueOf(templateId), "-", (task != null) ? Integer.valueOf(task.getState()) : null });
/* 1191 */       return -1;
/*      */     } 
/* 1193 */     List<TaskBase.ItemNode> rewards = TaskUtils.getReward(task.prop, this.playerPro);
/* 1194 */     List<NormalItem> tcItems = ItemUtil.createItemsByTcCode(task.prop.tcReward);
/*      */     
/* 1196 */     for (NormalItem v : tcItems) {
/* 1197 */       if (v.prop.itemSecondType == Const.ItemSecondType.virtual.getValue()) {
/* 1198 */         rewards.add(new TaskBase.ItemNode((v.getTemplate()).code, v.getWorth(), 0)); continue;
/*      */       } 
/* 1200 */       rewards.add(new TaskBase.ItemNode((v.getTemplate()).code, (v.getTemplate()).groupCount, 0));
/*      */     } 
/*      */     
/*      */     int i;
/*      */     
/* 1205 */     for (i = 0; i < rewards.size(); i++) {
/* 1206 */       TaskBase.ItemNode reward = rewards.get(i);
/* 1207 */       if (task.prop.expRatio > 0)
/*      */       {
/* 1209 */         if (reward.itemCode.equals("exp")) {
/* 1210 */           reward.itemNum = getTaskExp(reward.itemNum, task.prop.expRatio);
/*      */         }
/*      */       }
/*      */       
/* 1214 */       if (reward.itemCode.equals("gold")) {
/* 1215 */         int vip = this.player.baseDataManager.getVip();
/* 1216 */         int add = 0;
/* 1217 */         if (vip > 0) {
/* 1218 */           add = ((CardCO)GameData.Cards.get(Integer.valueOf(vip))).prv3;
/*      */         }
/* 1220 */         reward.itemNum += reward.itemNum * add / 10000;
/*      */       } 
/*      */     } 
/*      */     
/* 1224 */     if (isDouble > 0) {
/*      */       
/* 1226 */       if (task.prop.isDouble == 0) {
/* 1227 */         return -1;
/*      */       }
/* 1229 */       if (!this.player.moneyManager.enoughDiamond(task.prop.doubleCost)) {
/* 1230 */         return -2;
/*      */       }
/* 1232 */       for (TaskBase.ItemNode v : rewards) {
/* 1233 */         v.itemNum *= 2;
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1238 */     if (kind == 2) {
/* 1239 */       for (i = 0; i < rewards.size(); i++) {
/* 1240 */         TaskBase.ItemNode reward = rewards.get(i);
/* 1241 */         reward.itemNum = reward.itemNum * TaskUtils.getDailyAwardRate(this.taskListPO.todayDailyTaskCount) / 100;
/*      */       } 
/*      */     }
/*      */     
/* 1245 */     Out.debug(new Object[] { "submit task prop:", rewards });
/* 1246 */     WNBag bag = this.player.getWnBag();
/* 1247 */     List<Map<String, Object>> rItems = new ArrayList<>();
/* 1248 */     for (TaskBase.ItemNode node : rewards) {
/* 1249 */       Map<String, Object> map = new HashMap<>();
/* 1250 */       map.put("itemCode", node.itemCode);
/* 1251 */       map.put("itemNum", Integer.valueOf(node.itemNum));
/* 1252 */       map.put("isBind", Integer.valueOf(node.isBind));
/* 1253 */       rItems.add(map);
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1260 */     if (!_discardItem(task)) {
/* 1261 */       Out.error(new Object[] { "submitTask:", (this.player.getPlayer()).name, "id:", Integer.valueOf(templateId), "_discardItem" });
/* 1262 */       return -1;
/*      */     } 
/*      */     
/* 1265 */     TeamData team = this.player.getTeamManager().getTeam();
/* 1266 */     if (task.submit()) {
/*      */       
/* 1268 */       if (task.prop.overState2 == 1) {
/* 1269 */         this.player.playerBasePO.model = null;
/* 1270 */         this.player.playerBasePO.speed = 0.0F;
/* 1271 */         this.player.refreshBattlerServerAvatar();
/* 1272 */         this.player.refreshBattlerServerEffect(false);
/*      */       } 
/*      */ 
/*      */       
/* 1276 */       NotifyToBattleServerParam param = new NotifyToBattleServerParam();
/* 1277 */       param.playerUUID = this.player.getId();
/* 1278 */       param.questID = String.valueOf(templateId);
/* 1279 */       notifyToBattleServer("QuestCommittedR2B", param);
/* 1280 */       task.setSecProgress(getSecProgress(task.getKind()));
/*      */       
/* 1282 */       if (kind == 3 && team != null) {
/* 1283 */         for (TeamData.TeamMemberData member : team.teamMembers.values()) {
/* 1284 */           WNPlayer mPlayer = member.getPlayer();
/* 1285 */           if (mPlayer == null) {
/*      */             continue;
/*      */           }
/* 1288 */           mPlayer.taskManager.pushTaskUpdate(task);
/*      */         } 
/*      */       } else {
/* 1291 */         pushTaskUpdate(task);
/*      */       } 
/*      */       
/* 1294 */       if (isDouble > 0) {
/* 1295 */         this.player.moneyManager.costDiamond(task.prop.doubleCost, Const.GOODS_CHANGE_TYPE.task);
/*      */       }
/*      */       
/* 1298 */       _finishTask(templateId, kind);
/* 1299 */       _deleteTask(templateId, kind, false);
/*      */ 
/*      */       
/* 1302 */       if (kind == 3 && team != null && team.leaderId.equals(this.player.getId())) {
/*      */         
/* 1304 */         for (TeamData.TeamMemberData member : team.teamMembers.values()) {
/* 1305 */           WNPlayer player = member.getPlayer();
/* 1306 */           if (player != null) {
/* 1307 */             CircleRewardCO circleReward = (CircleRewardCO)GameData.CircleRewards.get(Integer.valueOf(player.getLevel()));
/* 1308 */             if (circleReward != null) {
/* 1309 */               Out.debug(new Object[] { "----------------" + circleReward.gold });
/* 1310 */               int rate = TaskUtils.getLoopAwardRate(player.taskManager.taskListPO.todayLoopTaskCount);
/* 1311 */               if (rate > 0) {
/* 1312 */                 int award_exp = circleReward.exp * rate / 100;
/* 1313 */                 int award_upexp = circleReward.cul * rate / 100;
/*      */                 
/* 1315 */                 if (team.leaderId.equals(player.getId()) && player.taskManager.taskListPO.todayLoopTaskCount <= 10) {
/* 1316 */                   award_exp += award_exp * 5 / 100;
/* 1317 */                   award_upexp += award_upexp * 5 / 1000;
/*      */                 } 
/* 1319 */                 player.addExp(award_exp, Const.GOODS_CHANGE_TYPE.task);
/* 1320 */                 player.addUpExp(award_upexp, Const.GOODS_CHANGE_TYPE.task);
/* 1321 */                 player.moneyManager.addGold(circleReward.gold * rate / 100, Const.GOODS_CHANGE_TYPE.task);
/*      */               } 
/* 1323 */               for (TeamData.TeamMemberData tempMember : team.teamMembers.values()) {
/* 1324 */                 WNPlayer teamMemPlayer = tempMember.getPlayer();
/* 1325 */                 if (teamMemPlayer == null) {
/*      */                   continue;
/*      */                 }
/* 1328 */                 int teamMemLvl = teamMemPlayer.getLevel();
/* 1329 */                 if (player.getLevel() >= teamMemLvl + 5) {
/* 1330 */                   int xianyuan = GlobalConfig.Fate_Loop;
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/* 1335 */                   player.processXianYuanGet(xianyuan);
/*      */                   break;
/*      */                 } 
/*      */               } 
/*      */             } else {
/* 1340 */               Out.error(new Object[] { "一条龙等级对应的奖励未配置 level=:" + player.getLevel() });
/*      */             } 
/*      */ 
/*      */             
/* 1344 */             int taskCircle = player.taskManager.taskListPO.todayLoopTaskCount / 5;
/* 1345 */             if (player.taskManager.taskListPO.todayLoopTaskCount > 0 && player.taskManager.taskListPO.todayLoopTaskCount % 5 == 0 && taskCircle <= GlobalConfig.Quest_rewardTimes2) {
/* 1346 */               TaskChestCO taskChest = TaskUtils.getProgressBox(3, player.getLevel());
/* 1347 */               player.bag.addCodeItemMail(taskChest.chest, 1, Const.ForceType.DEFAULT, Const.GOODS_CHANGE_TYPE.task, "Bag_full_common");
/*      */             } 
/*      */           } 
/*      */         } 
/*      */ 
/*      */         
/* 1353 */         if (team.finishedLoopTasks != null && team.finishedLoopTasks.size() >= 5) {
/* 1354 */           team.onAllOverLoopTask();
/* 1355 */           team.finishedLoopTasks.clear();
/*      */         } 
/*      */         
/* 1358 */         if (this.taskListPO.todayLoopTaskCount != 10 || this.taskListPO.loopBreaked)
/*      */         {
/* 1360 */           if (this.taskListPO.todayLoopTaskCount > 0 && this.taskListPO.todayLoopTaskCount % GlobalConfig.Loop_completeTips == 0) {
/* 1361 */             MessageData.MessageData_Quest data = new MessageData.MessageData_Quest();
/* 1362 */             data.finishCount = task.db.finishCount;
/* 1363 */             Map<String, String> strMsg = new HashMap<>();
/* 1364 */             strMsg.put("times", String.valueOf(this.taskListPO.todayLoopTaskCount));
/* 1365 */             MessageData message = MessageUtil.createMessage(Const.MESSAGE_TYPE.loop_task_times.getValue(), this.player.getId(), (MessageData.MessageData_Data)data, strMsg);
/* 1366 */             message.id = this.player.getId();
/* 1367 */             MessageUtil.sendMessageToPlayer(message, this.player.getId());
/*      */           } else {
/* 1369 */             String[] nextTask = task.prop.nextTask;
/* 1370 */             List<TaskData> tasks = _getNextAcceptTask(kind, nextTask, task.db.finishCount);
/* 1371 */             if (tasks.size() > 0)
/*      */             {
/* 1373 */               for (TeamData.TeamMemberData member : team.teamMembers.values()) {
/* 1374 */                 WNPlayer mPlayer = member.getPlayer();
/* 1375 */                 if (mPlayer == null || mPlayer == this.player) {
/*      */                   continue;
/*      */                 }
/* 1378 */                 for (TaskData t : tasks) {
/* 1379 */                   mPlayer.taskManager.pushTaskUpdate(t);
/*      */                 }
/*      */               } 
/*      */             }
/*      */           } 
/*      */         }
/* 1385 */         if (this.taskListPO.todayLoopTaskCount == 10 && !this.taskListPO.loopBreaked) {
/* 1386 */           this.taskListPO.loopBreaked = true;
/*      */         }
/* 1388 */       } else if (kind == 2) {
/*      */         
/* 1390 */         DailyRewardCO dailyReward = (DailyRewardCO)GameData.DailyRewards.get(Integer.valueOf(this.player.getLevel()));
/* 1391 */         if (dailyReward != null) {
/* 1392 */           int rate = TaskUtils.getDailyAwardRate(this.taskListPO.todayDailyTaskCount);
/* 1393 */           if (rate > 0) {
/* 1394 */             this.player.addExp(dailyReward.exp * rate / 100, Const.GOODS_CHANGE_TYPE.task);
/* 1395 */             this.player.addUpExp(dailyReward.cul * rate / 100, Const.GOODS_CHANGE_TYPE.task);
/* 1396 */             this.player.moneyManager.addGold(dailyReward.gold * rate / 100, Const.GOODS_CHANGE_TYPE.task);
/*      */           } 
/*      */         } 
/*      */         
/* 1400 */         if (this.player.taskManager.taskListPO != null && this.player.taskManager.taskListPO.todayDailyTaskCount < GlobalConfig.Daily_completeMax) {
/*      */           
/* 1402 */           if (this.player.taskManager.taskListPO.todayDailyTaskCount > 0 && this.player.taskManager.taskListPO.todayDailyTaskCount % 10 == 0) {
/* 1403 */             TaskHandler.TaskAutoPush.Builder autoPush = TaskHandler.TaskAutoPush.newBuilder();
/* 1404 */             autoPush.setAuto(0);
/* 1405 */             this.player.receive("area.taskPush.taskAutoPush", (GeneratedMessage)autoPush.build());
/*      */           } 
/*      */ 
/*      */           
/* 1409 */           DailyReduceCO dr = (DailyReduceCO)GameData.DailyReduces.get(Integer.valueOf(this.taskListPO.todayDailyTaskCount));
/* 1410 */           if (this.taskListPO.todayDailyTaskCount > 0 && dr != null) {
/* 1411 */             MessageData.MessageData_Quest data = new MessageData.MessageData_Quest();
/* 1412 */             data.finishCount = task.db.finishCount;
/* 1413 */             Map<String, String> strMsg = new HashMap<>(2);
/* 1414 */             strMsg.put("times", String.valueOf(this.taskListPO.todayDailyTaskCount));
/* 1415 */             strMsg.put("rate", String.valueOf(dr.rate));
/*      */             
/* 1417 */             MessageData message = MessageUtil.createMessage(Const.MESSAGE_TYPE.daily_task_times.getValue(), this.player.getId(), (MessageData.MessageData_Data)data, strMsg);
/* 1418 */             message.id = this.player.getId();
/* 1419 */             MessageUtil.sendMessageToPlayer(message, this.player.getId());
/*      */           } else {
/*      */             
/* 1422 */             TaskBase nextProp = TaskUtils.getRDDailyTask(this.player.getLevel(), templateId, this.player.getPro());
/* 1423 */             String[] nextTask = { String.valueOf(nextProp.iD) };
/* 1424 */             _getNextAcceptTask(kind, nextTask, task.db.finishCount);
/*      */           } 
/*      */         } 
/*      */         
/* 1428 */         int taskCircle = this.taskListPO.todayDailyTaskCount / 10;
/* 1429 */         if (this.taskListPO.todayDailyTaskCount > 0 && this.taskListPO.todayDailyTaskCount % 10 == 0 && taskCircle <= GlobalConfig.Quest_rewardTimes1) {
/* 1430 */           TaskChestCO taskChest = TaskUtils.getProgressBox(2, this.player.getLevel());
/* 1431 */           this.player.bag.addCodeItemMail(taskChest.chest, 1, Const.ForceType.DEFAULT, Const.GOODS_CHANGE_TYPE.task, "Bag_full_common");
/*      */         } 
/*      */ 
/*      */         
/* 1435 */         if (task.getType() == Const.TaskType.DISCARD_ITEM.getValue()) {
/* 1436 */           dailyTaskFinEvent();
/*      */         }
/*      */       } else {
/* 1439 */         String[] nextTask = task.prop.nextTask;
/* 1440 */         _getNextAcceptTask(kind, nextTask, task.db.finishCount);
/*      */       } 
/*      */ 
/*      */       
/* 1444 */       Out.debug(new Object[] { "task submit rewards ", rewards });
/*      */       
/* 1446 */       List<NormalItem> finalRewards = new ArrayList<>();
/* 1447 */       for (int j = 0; j < rewards.size(); j++) {
/* 1448 */         TaskBase.ItemNode reward = rewards.get(j);
/* 1449 */         if (reward.itemCode.equals("exp"))
/*      */         {
/* 1451 */           if (this.player.petNewManager.getFightingPetId() != null) {
/* 1452 */             int petProb = GlobalConfig.Pet_GetExp_Prob;
/* 1453 */             if (petProb > 100) {
/* 1454 */               petProb = 100;
/*      */             }
/* 1456 */             int petExp = (int)Math.floor((((TaskBase.ItemNode)rewards.get(j)).itemNum * petProb / 100));
/* 1457 */             this.player.petNewManager.addExp(this.player.petNewManager.getFightingPetId(), petExp);
/*      */           } 
/*      */         }
/* 1460 */         List<NormalItem> items = ItemUtil.createItemsByItemCode(reward.itemCode, reward.itemNum);
/* 1461 */         for (NormalItem item : items) {
/* 1462 */           item.setBind(1);
/* 1463 */           finalRewards.add(item);
/*      */         } 
/*      */       } 
/* 1466 */       bag.addCodeItemMail(finalRewards, Const.ForceType.DEFAULT, Const.GOODS_CHANGE_TYPE.task, "Bag_full_common");
/*      */       
/* 1468 */       if (kind == 3) {
/* 1469 */         for (TeamData.TeamMemberData member : team.teamMembers.values()) {
/* 1470 */           WNPlayer mPlayer = member.getPlayer();
/* 1471 */           if (mPlayer == null) {
/*      */             continue;
/*      */           }
/*      */           
/* 1475 */           mPlayer.functionOpenManager.onFinishTask(String.valueOf(templateId));
/*      */           
/* 1477 */           mPlayer.achievementManager.onFinishTask(templateId);
/* 1478 */           mPlayer.achievementManager.onFinishTaskNum(kind);
/*      */         } 
/*      */       } else {
/*      */         
/* 1482 */         this.player.functionOpenManager.onFinishTask(String.valueOf(templateId));
/*      */         
/* 1484 */         this.player.achievementManager.onFinishTask(templateId);
/* 1485 */         this.player.achievementManager.onFinishTaskNum(kind);
/*      */       } 
/* 1487 */       return 1;
/*      */     } 
/* 1489 */     Out.error(new Object[] { "submitTask:", (this.player.getPlayer()).name, "id:", Integer.valueOf(templateId), " submit error" });
/* 1490 */     return -1;
/*      */   }
/*      */   
/*      */   public final boolean updateStatus(int templateId, int kind) {
/* 1494 */     TaskData task = getTask(templateId, kind);
/* 1495 */     if (task == null) {
/* 1496 */       return false;
/*      */     }
/*      */     
/* 1499 */     if (task.getType() != Const.TaskType.INTERACT_NPC.getValue()) {
/* 1500 */       return false;
/*      */     }
/*      */     
/* 1503 */     if (task.getState() != Const.TaskState.NOT_COMPLETED.getValue()) {
/* 1504 */       return false;
/*      */     }
/*      */ 
/*      */     
/* 1508 */     task.complete();
/* 1509 */     task.setSecProgress(getSecProgress(task.getKind()));
/* 1510 */     pushTaskUpdate(task);
/* 1511 */     if (kind == 2) {
/* 1512 */       dailyTaskFinEvent();
/* 1513 */     } else if (kind == 3) {
/* 1514 */       loopTaskFinEvent();
/*      */     } 
/*      */     
/* 1517 */     BILogService.getInstance().ansycReportMission(this.player.getPlayer(), "任务完成", task.getKind(), task.prop.iD, task.prop.name);
/* 1518 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void onEvent(TaskEvent event) {
/* 1525 */     int eventType = event.type;
/* 1526 */     Out.debug(new Object[] { "task event handle", Integer.valueOf(eventType) });
/* 1527 */     List<TaskData> tasks = this.eventWatchers.get(Integer.valueOf(eventType));
/* 1528 */     if (tasks != null && tasks.size() > 0) {
/* 1529 */       for (TaskData task : tasks) {
/* 1530 */         if (task.onEvent(this.player, event)) {
/* 1531 */           task.setSecProgress(getSecProgress(task.getKind()));
/* 1532 */           onComplteTask(this.player, event, task);
/*      */         } 
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/* 1538 */     TeamData team = this.player.teamManager.getTeam();
/* 1539 */     if (team != null && team.isInLoopTask()) {
/* 1540 */       Map<Integer, TaskPO> loopTasks = team.loopTasks;
/* 1541 */       for (TaskPO db : loopTasks.values()) {
/* 1542 */         TaskData taskData = new TaskData(db);
/* 1543 */         if (taskData.getType() != eventType) {
/*      */           continue;
/*      */         }
/* 1546 */         if (taskData.onEvent(this.player, event)) {
/* 1547 */           taskData.setSecProgress(getSecProgress(taskData.getKind()));
/*      */         }
/* 1549 */         if (taskData.isCompleted()) {
/* 1550 */           for (TeamData.TeamMemberData member : team.teamMembers.values()) {
/* 1551 */             WNPlayer mPlayer = member.getPlayer();
/* 1552 */             if (mPlayer == null) {
/*      */               continue;
/*      */             }
/* 1555 */             onComplteTask(mPlayer, event, taskData);
/*      */           } 
/*      */         }
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void onComplteTask(WNPlayer player, TaskEvent event, TaskData task) {
/* 1563 */     player.taskManager.pushTaskUpdate(task);
/*      */     
/* 1565 */     if (task.db.state == Const.TaskState.COMPLETED_NOT_DELIVERY.getValue()) {
/*      */       
/* 1567 */       NotifyToBattleServerParam param = new NotifyToBattleServerParam();
/* 1568 */       param.playerUUID = player.getId();
/* 1569 */       param.questID = String.valueOf(task.db.templateId);
/* 1570 */       param.initStatus = false;
/* 1571 */       param.status = new ArrayList<>();
/* 1572 */       param.status.add(new StringString("state", String.valueOf(Const.TaskState.COMPLETED_NOT_DELIVERY.getValue())));
/* 1573 */       player.taskManager.notifyToBattleServer("QuestStatusChangedR2B", param);
/*      */ 
/*      */       
/* 1576 */       if (task.prop.completeNpc == -1) {
/* 1577 */         player.taskManager.submitTask(task.db.templateId, task.getKind(), 0);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private final void notifyToBattleServer(String name, NotifyToBattleServerParam param) {
/* 1585 */     this.player.getXmdsManager().notifyBattleServer(this.player.getInstanceId(), name, JSON.toJSONString(param));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final List<TaskData> _getNextAcceptTask(int kind, String[] nextTasks, int finishCount) {
/* 1594 */     List<TaskData> tasks = new ArrayList<>(2);
/* 1595 */     TaskData task = null;
/* 1596 */     boolean hasMain = false;
/* 1597 */     for (String taskId : nextTasks) {
/* 1598 */       int id = Integer.parseInt(taskId);
/* 1599 */       TaskBase prop = TaskUtils.getTaskProp(id);
/*      */       
/* 1601 */       if (prop != null && _canAcceptTaskByProp(prop) == null) {
/* 1602 */         if (prop.getKind() == 0) {
/* 1603 */           hasMain = true;
/*      */         }
/* 1605 */         if (prop.giveNpc == 0) {
/* 1606 */           task = (acceptTask(prop.getId(), prop.getKind())).task;
/*      */         } else {
/* 1608 */           task = TaskUtils.createTask(prop);
/* 1609 */           if (prop.getKind() == 0) {
/* 1610 */             if (!hasMainLineTask() && !isFinishTask(id)) {
/* 1611 */               this.normalTasks.put(Integer.valueOf(task.db.templateId), task.db);
/*      */             }
/* 1613 */           } else if (prop.getKind() == 1) {
/* 1614 */             this.normalTasks.put(Integer.valueOf(task.db.templateId), task.db);
/* 1615 */           } else if (prop.getKind() == 8) {
/* 1616 */             this.treasureTasks.put(Integer.valueOf(task.db.templateId), task.db);
/* 1617 */           } else if (prop.getKind() == 3) {
/* 1618 */             TeamData team = this.player.teamManager.getTeam();
/* 1619 */             if (team != null) {
/* 1620 */               if (team.loopTasks == null) {
/* 1621 */                 team.loopTasks = new HashMap<>();
/*      */               }
/* 1623 */               team.loopTasks.put(Integer.valueOf(task.db.templateId), task.db);
/*      */             } 
/*      */           } else {
/* 1626 */             this.dailyTasks.put(Integer.valueOf(task.db.templateId), task.db);
/*      */           } 
/*      */         } 
/* 1629 */         task.db.finishCount = finishCount;
/* 1630 */         task.setSecProgress(getSecProgress(task.getKind()));
/* 1631 */         tasks.add(task);
/* 1632 */         pushTaskUpdate(task);
/*      */       } 
/*      */     } 
/*      */     
/* 1636 */     if (kind == 0 && !hasMain) {
/* 1637 */       for (String taskId : nextTasks) {
/* 1638 */         int id = Integer.parseInt(taskId);
/* 1639 */         TaskBase prop = TaskUtils.getTaskProp(id);
/* 1640 */         if (prop != null && prop.getKind() == 0) {
/* 1641 */           task = TaskUtils.createTask(prop);
/* 1642 */           this.normalTasks.put(Integer.valueOf(task.db.templateId), task.db);
/* 1643 */           task.db.finishCount = finishCount;
/* 1644 */           task.setSecProgress(getSecProgress(task.getKind()));
/* 1645 */           tasks.add(task);
/* 1646 */           pushTaskUpdate(task);
/*      */         } 
/*      */       } 
/*      */     }
/* 1650 */     refreshWatchEvents();
/* 1651 */     return tasks;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final void _addTask(TaskData task) {
/* 1662 */     if (task.isDaily()) {
/* 1663 */       this.dailyTasks.put(Integer.valueOf(task.db.templateId), task.db);
/* 1664 */     } else if (task.isLoop()) {
/* 1665 */       TeamData team = this.player.teamManager.getTeam();
/* 1666 */       if (team != null) {
/* 1667 */         team.onFirstAcceptLoopTask();
/* 1668 */         if (team.loopTasks == null) {
/* 1669 */           team.loopTasks = new HashMap<>();
/*      */         }
/* 1671 */         team.loopTasks.put(Integer.valueOf(task.db.templateId), task.db);
/*      */       } 
/* 1673 */     } else if (task.isTreasure()) {
/* 1674 */       this.treasureTasks.put(Integer.valueOf(task.db.templateId), task.db);
/*      */     } else {
/* 1676 */       this.normalTasks.put(Integer.valueOf(task.db.templateId), task.db);
/*      */     } 
/* 1678 */     refreshWatchEvents();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final void _deleteTask(int templateId, int kind, boolean sendtoBattle) {
/* 1690 */     Out.debug(new Object[] { "_deleteTask templateId: ", Integer.valueOf(templateId), " kind: ", Integer.valueOf(kind) });
/* 1691 */     if (kind == 2) {
/* 1692 */       this.dailyTasks.remove(Integer.valueOf(templateId));
/* 1693 */     } else if (kind == 3) {
/* 1694 */       Map<Integer, TaskPO> loopTasks = this.player.teamManager.getLoopTasks();
/* 1695 */       if (loopTasks != null) {
/* 1696 */         loopTasks.remove(Integer.valueOf(templateId));
/*      */       }
/* 1698 */     } else if (kind == 8) {
/* 1699 */       this.treasureTasks.remove(Integer.valueOf(templateId));
/*      */     } else {
/* 1701 */       this.normalTasks.remove(Integer.valueOf(templateId));
/*      */     } 
/*      */     
/* 1704 */     if (sendtoBattle) {
/*      */       
/* 1706 */       NotifyToBattleServerParam param = new NotifyToBattleServerParam();
/* 1707 */       param.playerUUID = this.player.getId();
/* 1708 */       param.questID = String.valueOf(templateId);
/* 1709 */       notifyToBattleServer("QuestDroppedR2B", param);
/*      */     } 
/* 1711 */     refreshWatchEvents();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final void _finishTask(int templateId, int kind) {
/* 1723 */     Out.debug(new Object[] { "_finishTask templateId: ", Integer.valueOf(templateId), " kind: ", Integer.valueOf(kind) });
/* 1724 */     if (kind == 2) {
/* 1725 */       this.finishedDailyTasks.put(Integer.valueOf(templateId), Integer.valueOf(templateId));
/* 1726 */       this.taskListPO.todayDailyTaskCount++;
/* 1727 */     } else if (kind == 3) {
/*      */       
/* 1729 */       TeamData team = this.player.teamManager.getTeam();
/* 1730 */       if (team != null) {
/* 1731 */         if (team.finishedLoopTasks == null) {
/* 1732 */           team.finishedLoopTasks = new HashMap<>();
/*      */         }
/* 1734 */         team.finishedLoopTasks.put(Integer.valueOf(templateId), Integer.valueOf(templateId));
/*      */         
/* 1736 */         for (TeamData.TeamMemberData member : team.teamMembers.values()) {
/* 1737 */           WNPlayer mPlayer = member.getPlayer();
/* 1738 */           if (mPlayer != null) {
/* 1739 */             mPlayer.taskManager.taskListPO.todayLoopTaskCount++;
/*      */           }
/*      */         } 
/*      */       } 
/* 1743 */     } else if (kind == 8) {
/* 1744 */       this.finishedTreasureTasks.put(Integer.valueOf(templateId), Integer.valueOf(templateId));
/*      */     } else {
/*      */       
/* 1747 */       this.finishedNormalTasks.put(Integer.valueOf(templateId), Integer.valueOf(templateId));
/*      */     } 
/*      */   }
/*      */   
/*      */   public TaskOuterClass.Tasks toJson4Payload() {
/* 1752 */     TaskOuterClass.Tasks.Builder data = TaskOuterClass.Tasks.newBuilder();
/* 1753 */     List<TaskOuterClass.Task> taskList = new ArrayList<>();
/*      */     Iterator<Integer> iterator1;
/* 1755 */     for (iterator1 = this.normalTasks.keySet().iterator(); iterator1.hasNext(); ) { int templateId = ((Integer)iterator1.next()).intValue();
/* 1756 */       TaskData task = new TaskData(this.normalTasks.get(Integer.valueOf(templateId)));
/* 1757 */       task.setSecProgress(getSecProgress(task.getKind()));
/* 1758 */       if (task.getState() != Const.TaskState.DELETE.getValue()) {
/* 1759 */         TaskOuterClass.Task payLoad = task.buildTask();
/* 1760 */         if (payLoad != null) {
/* 1761 */           taskList.add(payLoad);
/*      */         }
/*      */       }  }
/*      */ 
/*      */ 
/*      */     
/* 1767 */     for (iterator1 = this.dailyTasks.keySet().iterator(); iterator1.hasNext(); ) { int templateId = ((Integer)iterator1.next()).intValue();
/* 1768 */       TaskData task = new TaskData(this.dailyTasks.get(Integer.valueOf(templateId)));
/* 1769 */       task.setSecProgress(getSecProgress(task.getKind()));
/* 1770 */       if (task.getState() != Const.TaskState.DELETE.getValue()) {
/* 1771 */         TaskOuterClass.Task payLoad = task.buildTask();
/* 1772 */         if (payLoad != null) {
/* 1773 */           taskList.add(payLoad);
/*      */         }
/*      */       }  }
/*      */ 
/*      */ 
/*      */     
/* 1779 */     Map<Integer, TaskPO> loopTasks = this.player.teamManager.getLoopTasks();
/* 1780 */     if (loopTasks != null) {
/* 1781 */       for (Iterator<Integer> iterator = loopTasks.keySet().iterator(); iterator.hasNext(); ) { int templateId = ((Integer)iterator.next()).intValue();
/* 1782 */         TaskData task = new TaskData(loopTasks.get(Integer.valueOf(templateId)));
/* 1783 */         task.setSecProgress(getSecProgress(task.getKind()));
/* 1784 */         if (task.getState() != Const.TaskState.DELETE.getValue()) {
/* 1785 */           TaskOuterClass.Task payLoad = task.buildTask();
/* 1786 */           if (payLoad != null) {
/* 1787 */             taskList.add(payLoad);
/*      */           }
/*      */         }  }
/*      */     
/*      */     }
/*      */ 
/*      */     
/* 1794 */     for (Iterator<Integer> iterator2 = this.treasureTasks.keySet().iterator(); iterator2.hasNext(); ) { int templateId = ((Integer)iterator2.next()).intValue();
/* 1795 */       TaskData task = new TaskData(this.treasureTasks.get(Integer.valueOf(templateId)));
/* 1796 */       task.setSecProgress(getSecProgress(task.getKind()));
/* 1797 */       if (task.getState() != Const.TaskState.DELETE.getValue()) {
/* 1798 */         TaskOuterClass.Task payLoad = task.buildTask();
/* 1799 */         if (payLoad != null) {
/* 1800 */           taskList.add(payLoad);
/*      */         }
/*      */       }  }
/*      */ 
/*      */     
/* 1805 */     data.addAllTaskList(taskList);
/*      */     
/* 1807 */     getDailyTask(taskList, -1, false);
/* 1808 */     return data.build();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void getDailyTask(List<TaskOuterClass.Task> dataArray, int cycleType, boolean isNewDay) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void pushTaskUpdate(TaskData data) {
/* 1874 */     pushTaskUpdate(data, this.player.teamManager.getTeam());
/*      */   }
/*      */   
/*      */   public final void pushTaskUpdate(TaskData data, TeamData team) {
/* 1878 */     if (data != null) {
/* 1879 */       data.setSecProgress(getSecProgress(data.getKind(), team));
/* 1880 */       TaskHandler.TaskUpdatePush.Builder builder = TaskHandler.TaskUpdatePush.newBuilder();
/* 1881 */       TaskOuterClass.Tasks.Builder task = TaskOuterClass.Tasks.newBuilder();
/* 1882 */       task.addTaskList(data.buildTask());
/* 1883 */       builder.setS2CData(task.build());
/* 1884 */       this.player.receive("area.taskPush.taskUpdatePush", (GeneratedMessage)builder.build());
/*      */     } 
/*      */   }
/*      */   
/*      */   public final void pushTaskUpdate(List<TaskOuterClass.Task> data) {
/* 1889 */     if (data.size() > 0) {
/* 1890 */       TaskHandler.TaskUpdatePush.Builder builder = TaskHandler.TaskUpdatePush.newBuilder();
/* 1891 */       TaskOuterClass.Tasks.Builder task = TaskOuterClass.Tasks.newBuilder();
/* 1892 */       task.addAllTaskList(data);
/* 1893 */       builder.setS2CData(task.build());
/* 1894 */       this.player.receive("area.taskPush.taskUpdatePush", (GeneratedMessage)builder.build());
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void onTaskRequestEvent(String eventName, int templateId, String key, int value) {
/* 1904 */     Out.debug(new Object[] { "onTaskRequestEvent recived name:", eventName, " id: ", Integer.valueOf(templateId) });
/* 1905 */     if (!eventName.equals("AcceptQuest"))
/*      */     {
/* 1907 */       if (!eventName.equals("CommitQuest"))
/*      */       {
/* 1909 */         if (eventName.equals("DropQuest")) {
/* 1910 */           discardTaskByID(templateId);
/*      */         }
/* 1912 */         else if (eventName.equals("UpdateQuestStatus")) {
/*      */           
/* 1914 */           TaskData task = getTaskByID(templateId);
/* 1915 */           if (task == null) {
/* 1916 */             Out.error(new Object[] { "UpdateQuestStatus can not find task: ", Integer.valueOf(templateId) });
/*      */             return;
/*      */           } 
/* 1919 */           if (key.equals("state") && value == Const.TaskState.COMPLETED_NOT_DELIVERY.getValue()) {
/*      */             
/* 1921 */             completeTaskByID(templateId);
/* 1922 */             if (task != null && task.prop.completeNpc == -1)
/*      */             {
/* 1924 */               submitTask(task.db.templateId, task.getKind(), 0);
/*      */             }
/* 1926 */           } else if (key.equals("add_progress")) {
/* 1927 */             Out.debug(new Object[] { "onTaskRequestEvent add_progress", task });
/* 1928 */             if (task != null) {
/* 1929 */               int progress = task.getProgress();
/*      */               
/* 1931 */               progress += value;
/* 1932 */               if (progress >= task.getTargetNum()) {
/* 1933 */                 progress = task.getTargetNum();
/*      */               }
/* 1935 */               boolean killed = task.setProgress(progress);
/* 1936 */               if (task.db.state == Const.TaskState.COMPLETED_NOT_DELIVERY.getValue()) {
/* 1937 */                 NotifyToBattleServerParam param = new NotifyToBattleServerParam();
/* 1938 */                 param.playerUUID = this.player.getId();
/* 1939 */                 param.questID = String.valueOf(templateId);
/* 1940 */                 param.initStatus = false;
/* 1941 */                 param.status = new ArrayList<>();
/* 1942 */                 param.status.add(new StringString("state", String.valueOf(Const.TaskState.COMPLETED_NOT_DELIVERY.getValue())));
/* 1943 */                 notifyToBattleServer("QuestStatusChangedR2B", param);
/* 1944 */               } else if (killed) {
/*      */                 
/* 1946 */                 NotifyToBattleServerParam param = new NotifyToBattleServerParam();
/* 1947 */                 param.playerUUID = this.player.getId();
/* 1948 */                 param.questID = String.valueOf(templateId);
/* 1949 */                 param.initStatus = false;
/* 1950 */                 param.status = new ArrayList<>();
/* 1951 */                 param.status.add(new StringString("refine_killed", "true"));
/* 1952 */                 notifyToBattleServer("QuestStatusChangedR2B", param);
/* 1953 */                 task.setBattleAttribute("refine_killed", "true");
/*      */               } 
/* 1955 */               task.pushProgressTips(this.player);
/*      */               
/* 1957 */               task.setSecProgress(getSecProgress(task.getKind()));
/* 1958 */               pushTaskUpdate(task);
/*      */             } 
/*      */           } else {
/* 1961 */             TaskData task1 = getTaskByID(templateId);
/* 1962 */             if (task1 != null) {
/* 1963 */               task1.setBattleAttribute(key, String.valueOf(value));
/*      */             }
/*      */           } 
/* 1966 */         } else if (eventName.equals("accessable")) {
/*      */           
/* 1968 */           TaskBase prop = TaskUtils.getTaskProp(templateId);
/* 1969 */           if (prop == null) {
/* 1970 */             Out.warn(new Object[] { "accessable task not found: ", Integer.valueOf(templateId) });
/*      */           }
/* 1972 */           else if (_canAcceptTaskByProp(prop) == null) {
/* 1973 */             TaskData newTask = null;
/* 1974 */             if (prop.giveNpc == 0) {
/* 1975 */               AcceptTaskHandler.AcceptTaskResult result = acceptTask(prop.getId(), prop.getKind());
/* 1976 */               newTask = result.task;
/*      */             } 
/* 1978 */             if (newTask != null) {
/* 1979 */               _addTask(newTask);
/* 1980 */               newTask.setSecProgress(getSecProgress(newTask.getKind()));
/* 1981 */               pushTaskUpdate(newTask);
/*      */             }
/*      */           
/*      */           }
/*      */         
/* 1986 */         } else if (eventName.equals("unaccessable")) {
/*      */           
/* 1988 */           TaskData task = getTaskByID(templateId);
/* 1989 */           if (task != null && task.getState() == Const.TaskState.NOT_START.getValue()) {
/* 1990 */             task.db.state = Const.TaskState.DELETE.getValue();
/* 1991 */             task.setSecProgress(getSecProgress(task.getKind()));
/* 1992 */             _deleteTask(templateId, task.getKind(), true);
/* 1993 */             pushTaskUpdate(task);
/*      */           } 
/*      */         } 
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public int getSecProgress(int kind) {
/* 2002 */     return getSecProgress(kind, this.player.teamManager.getTeam());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getSecProgress(int kind, TeamData team) {
/* 2009 */     if (kind == 2) {
/* 2010 */       int all = (this.taskListPO.todayDailyTaskCount + this.dailyTasks.size()) % 10;
/* 2011 */       if (all == 0) {
/* 2012 */         all = 10;
/*      */       }
/* 2014 */       return all;
/* 2015 */     }  if (kind == 3) {
/* 2016 */       int all = 0;
/*      */       
/* 2018 */       if (team == null) {
/* 2019 */         return -1;
/*      */       }
/* 2021 */       if ((team.finishedLoopTasks == null || team.finishedLoopTasks.size() == 0) && (team.loopTasks == null || team.loopTasks.size() == 0)) {
/* 2022 */         return -1;
/*      */       }
/* 2024 */       if (team.finishedLoopTasks != null) {
/* 2025 */         all += team.finishedLoopTasks.size();
/*      */       }
/* 2027 */       if (team.loopTasks != null) {
/* 2028 */         all += team.loopTasks.size();
/*      */       }
/* 2030 */       return all;
/*      */     } 
/* 2032 */     return -1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void onLevelChange(int level) {
/* 2042 */     List<TaskOuterClass.Task> data = new ArrayList<>();
/* 2043 */     for (BranchLineCO prop : GameData.BranchLines.values()) {
/* 2044 */       if (prop.level <= level && 
/* 2045 */         !isFinish(prop.iD, prop.kind) && _canAcceptTaskByProp((TaskBase)prop) == null) {
/* 2046 */         if (prop.giveNpc == 0) {
/* 2047 */           acceptTask(prop.iD, prop.kind);
/* 2048 */           TaskData taskData = getTask(prop.iD, prop.kind);
/* 2049 */           if (taskData != null) {
/* 2050 */             taskData.setSecProgress(getSecProgress(taskData.getKind()));
/* 2051 */             data.add(taskData.buildTask());
/*      */           }  continue;
/*      */         } 
/* 2054 */         TaskData task = TaskUtils.createTask((TaskBase)prop);
/* 2055 */         this.normalTasks.put(Integer.valueOf(task.db.templateId), task.db);
/* 2056 */         task.setSecProgress(getSecProgress(task.getKind()));
/* 2057 */         data.add(task.buildTask());
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2064 */     getDailyTask(data, -1, false);
/* 2065 */     Out.debug(new Object[] { "task onLevelChange: ", data });
/* 2066 */     if (data.size() > 0) {
/* 2067 */       refreshWatchEvents();
/* 2068 */       pushTaskUpdate(data);
/*      */     } 
/*      */     
/* 2071 */     dealTaskEvent(Const.TaskType.LEVEL_UP, level);
/*      */   }
/*      */   
/*      */   public final void onUpLevelChange(int upLevel) {
/* 2075 */     List<TaskOuterClass.Task> data = new ArrayList<>();
/* 2076 */     for (BranchLineCO p : GameData.BranchLines.values()) {
/* 2077 */       if (p.level <= upLevel && p.level > 0 && 
/* 2078 */         !isFinish(p.iD, p.kind) && _canAcceptTaskByProp((TaskBase)p) == null) {
/* 2079 */         if (p.giveNpc == 0) {
/* 2080 */           acceptTask(p.iD, p.kind);
/* 2081 */           TaskData taskData = getTask(p.iD, p.kind);
/* 2082 */           if (taskData != null) {
/* 2083 */             taskData.setSecProgress(getSecProgress(taskData.getKind()));
/* 2084 */             data.add(taskData.buildTask());
/*      */           }  continue;
/*      */         } 
/* 2087 */         TaskData task = TaskUtils.createTask((TaskBase)p);
/* 2088 */         this.normalTasks.put(Integer.valueOf(task.db.templateId), task.db);
/* 2089 */         task.setSecProgress(getSecProgress(task.getKind()));
/* 2090 */         data.add(task.buildTask());
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 2096 */     getDailyTask(data, -1, false);
/* 2097 */     Out.debug(new Object[] { "task onUpLevelChange: ", data });
/* 2098 */     if (data.size() > 0) {
/* 2099 */       refreshWatchEvents();
/* 2100 */       pushTaskUpdate(data);
/*      */     } 
/*      */     
/* 2103 */     dealTaskEvent(Const.TaskType.USERUP_LEVEL, (this.player.getPlayer()).upLevel);
/*      */   }
/*      */ 
/*      */   
/*      */   public void onLogin() {
/* 2108 */     Map<Integer, TaskPO> loopTasks = this.player.teamManager.getLoopTasks();
/* 2109 */     if (loopTasks != null)
/* 2110 */       for (TaskPO db : loopTasks.values())
/* 2111 */         pushTaskUpdate(new TaskData(db));  
/*      */   }
/*      */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\task\PlayerTasks.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */