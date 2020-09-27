/*     */ package com.wanniu.game.task;
/*     */ 
/*     */ import com.alibaba.fastjson.JSONArray;
/*     */ import com.wanniu.core.game.LangService;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.util.StringUtil;
/*     */ import com.wanniu.game.area.Area;
/*     */ import com.wanniu.game.area.AreaUtil;
/*     */ import com.wanniu.game.area.MonsterUnit;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.msg.MessageUtil;
/*     */ import com.wanniu.game.data.GameData;
/*     */ import com.wanniu.game.data.OpenLvCO;
/*     */ import com.wanniu.game.data.PickItemCO;
/*     */ import com.wanniu.game.data.base.MonsterBase;
/*     */ import com.wanniu.game.functionOpen.FunctionOpenUtil;
/*     */ import com.wanniu.game.guild.guildBoss.GuildBossAreaHurtRankCenter;
/*     */ import com.wanniu.game.guild.guildBoss.GuildBossService;
/*     */ import com.wanniu.game.monster.MonsterConfig;
/*     */ import com.wanniu.game.player.GlobalConfig;
/*     */ import com.wanniu.game.player.PlayerUtil;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.task.po.TaskPO;
/*     */ import com.wanniu.game.team.TeamData;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TaskEvent
/*     */   implements Runnable
/*     */ {
/*     */   public int type;
/*     */   public Object[] params;
/*     */   public WNPlayer player;
/*     */   
/*     */   public TaskEvent(Const.EventType name, Object... param) {
/*  44 */     this.type = name.getValue();
/*  45 */     this.params = param;
/*     */   }
/*     */   
/*     */   public TaskEvent(Const.TaskType name, Object... param) {
/*  49 */     this.type = name.getValue();
/*  50 */     this.params = param;
/*     */   }
/*     */   
/*     */   public TaskEvent(int type, String param) {
/*  54 */     this.type = type;
/*  55 */     if (StringUtil.isNotEmpty(param)) {
/*  56 */       this.params = JSONArray.parseArray(param).toArray();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean processGuildBoss() {
/*  66 */     if (this.type == Const.EventType.hurtRank.getValue()) {
/*  67 */       String guildId = (String)this.params[0];
/*  68 */       String playerId = (String)this.params[1];
/*  69 */       long hurt = ((Long)this.params[2]).longValue();
/*  70 */       int enterCount = ((Integer)this.params[3]).intValue();
/*  71 */       GuildBossAreaHurtRankCenter.getInstance().setNewData(guildId, playerId, hurt, enterCount);
/*  72 */       return true;
/*  73 */     }  if (this.type == Const.EventType.hurtRank_sort.getValue()) {
/*  74 */       String guildId = (String)this.params[0];
/*  75 */       Collection<String> pushRoleIds = (Collection<String>)this.params[1];
/*  76 */       boolean isForcePush = ((Boolean)this.params[2]).booleanValue();
/*  77 */       long killTime = ((Long)this.params[3]).longValue();
/*  78 */       boolean hasKilled = ((Boolean)this.params[4]).booleanValue();
/*  79 */       GuildBossAreaHurtRankCenter.getInstance().processSortHurtRank(guildId, pushRoleIds, isForcePush, killTime, hasKilled);
/*  80 */       return true;
/*  81 */     }  if (this.type == Const.EventType.statics_ranks.getValue()) {
/*  82 */       GuildBossService.getInstance().processStaticsAllRanks();
/*  83 */       return true;
/*  84 */     }  if (this.type == Const.EventType.over_statics_ranks.getValue()) {
/*  85 */       String guildId = (String)this.params[0];
/*  86 */       Collection<String> roleIds = (Collection<String>)this.params[1];
/*  87 */       GuildBossAreaHurtRankCenter.getInstance().overStaticsRanks(guildId, roleIds);
/*  88 */       return true;
/*     */     } 
/*  90 */     return false;
/*     */   }
/*     */   
/*     */   private void onInterActiveItemEvent() {
/*  94 */     int templateID = Integer.parseInt(this.params[0].toString());
/*  95 */     PickItemCO pickItemProp = (PickItemCO)GameData.PickItems.get(Integer.valueOf(templateID));
/*  96 */     if (pickItemProp != null) {
/*  97 */       String tcCode = pickItemProp.tC;
/*  98 */       if (this.player.bag.findFirstItemByCode("fishgear1") == null) {
/*     */         return;
/*     */       }
/*     */ 
/*     */       
/* 103 */       TaskData task = this.player.taskManager.doingTaskHaveType(Const.TaskType.FISH.getValue());
/* 104 */       if (task != null) {
/* 105 */         String extendTc = task.questTc();
/* 106 */         PlayerUtil.onFishItem(this.player, null, extendTc);
/*     */       } else {
/* 108 */         PlayerUtil.onFishItem(this.player, tcCode, null);
/*     */       } 
/*     */       
/* 111 */       this.player.achievementManager.onFishing();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void onAddUnitEvent() {
/* 117 */     String[] taskIds = GlobalConfig.Call_Boss_TaskID.split(",");
/* 118 */     TaskData task = null;
/* 119 */     for (String taskId : taskIds) {
/* 120 */       if (!StringUtil.isEmpty(taskId)) {
/*     */ 
/*     */         
/* 123 */         task = this.player.taskManager.getTaskByID(Integer.parseInt(taskId));
/* 124 */         if (task != null)
/*     */           break; 
/*     */       } 
/*     */     } 
/* 128 */     if (task == null) {
/* 129 */       Out.error(new Object[] { this.player.getId() + " don't have CALL_BOSS QUEST" });
/*     */       
/*     */       return;
/*     */     } 
/* 133 */     Area area = (Area)this.params[0];
/* 134 */     String[] location = ((String)this.params[1]).split(":");
/* 135 */     int x = Integer.parseInt(location[0]);
/* 136 */     int y = Integer.parseInt(location[1]);
/* 137 */     int monsterId = Integer.parseInt(task.prop.targetID);
/*     */     
/* 139 */     MonsterBase prop = MonsterConfig.getInstance().get(monsterId);
/* 140 */     List<MonsterUnit> data = new ArrayList<>();
/* 141 */     MonsterUnit unit = new MonsterUnit();
/* 142 */     unit.id = monsterId;
/* 143 */     unit.x = x;
/* 144 */     unit.y = y;
/* 145 */     unit.force = Const.AreaForce.MONSTER.value;
/* 146 */     unit.autoGuard = true;
/* 147 */     unit.unique = true;
/* 148 */     unit.shareType = prop.shareType;
/* 149 */     data.add(unit);
/* 150 */     area.addUnitsToArea(data);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void onChangeAreaEvent() {
/* 157 */     int areaId = ((Integer)this.params[0]).intValue();
/* 158 */     int targetX = ((Integer)this.params[1]).intValue();
/* 159 */     int targetY = ((Integer)this.params[2]).intValue();
/* 160 */     AreaUtil.enterArea(this.player, areaId, targetX, targetY);
/*     */   }
/*     */   
/*     */   private void onLoopTransformEvent() {
/* 164 */     String[] location = String.valueOf(this.params[1]).split(":");
/* 165 */     int targetX = Integer.parseInt(location[0]);
/* 166 */     int targetY = Integer.parseInt(location[1]);
/* 167 */     int areaId = 0;
/* 168 */     TaskPO taskData = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 174 */     Map<Integer, TaskPO> loopTasks = this.player.teamManager.getLoopTasks();
/* 175 */     if (loopTasks != null) {
/* 176 */       Iterator<TaskPO> iterator = loopTasks.values().iterator(); if (iterator.hasNext()) { TaskPO task = iterator.next();
/* 177 */         areaId = (TaskUtils.getTaskProp(task.templateId)).circleDungeonID;
/* 178 */         taskData = task; }
/*     */     
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 184 */     TeamData team = this.player.getTeamManager().getTeam();
/* 185 */     if (team != null && areaId != 0 && taskData != null && taskData.state == Const.TaskState.NOT_COMPLETED.getValue()) {
/* 186 */       if (team.leaderId.equals(this.player.getId())) {
/* 187 */         boolean success = true;
/* 188 */         for (TeamData.TeamMemberData teamMember : team.teamMembers.values()) {
/* 189 */           WNPlayer mPlayer = PlayerUtil.getOnlinePlayer(teamMember.id);
/* 190 */           if (mPlayer == null) {
/* 191 */             success = false;
/* 192 */             MessageUtil.sendSysTip(this.player, LangService.getValue("TEAM_PLAYER_OFF_LINE"), Const.TipsType.BLACK);
/*     */             break;
/*     */           } 
/* 195 */           if (!teamMember.isOnline()) {
/* 196 */             success = false;
/* 197 */             MessageUtil.sendSysTip(this.player, LangService.getValue("TEAM_PLAYER_OFF_LINE"), Const.TipsType.BLACK);
/*     */             
/*     */             break;
/*     */           } 
/* 201 */           OpenLvCO openConfig = FunctionOpenUtil.findFunctionOpenPropsByFuncName(Const.FunctionType.LoopTask.getValue());
/* 202 */           if (mPlayer.getLevel() < openConfig.openLv) {
/* 203 */             success = false;
/* 204 */             MessageUtil.sendSysTip(this.player, LangService.getValue("TEAM_MEMBER_LEVEL_LIMIT").replace("{level}", String.valueOf(openConfig.openLv)), Const.TipsType.BLACK);
/*     */             
/*     */             break;
/*     */           } 
/*     */         } 
/* 209 */         if (success) {
/* 210 */           if (team.memberCount() >= 3) {
/* 211 */             if (team.followCount() == team.memberCount()) {
/* 212 */               team.confirm = false;
/*     */             }
/* 214 */             AreaUtil.enterArea(this.player, areaId, targetX, targetY);
/*     */           } else {
/* 216 */             MessageUtil.sendSysTip(this.player, LangService.getValue("TASK_NEED_TEAM"), Const.TipsType.BLACK);
/*     */           } 
/*     */         }
/*     */       } else {
/* 220 */         MessageUtil.sendSysTip(this.player, LangService.getValue("TEAM_NO_AUTHORITY"), Const.TipsType.BLACK);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void run() {
/* 229 */     if (processGuildBoss()) {
/*     */       return;
/*     */     }
/*     */     
/* 233 */     if (this.player.onSaveRebirth(this)) {
/*     */       return;
/*     */     }
/*     */     
/* 237 */     this.player.taskManager.onEvent(this);
/* 238 */     this.player.achievementManager.onTaskEvent(this);
/* 239 */     this.player.bag.onEvent(this);
/* 240 */     this.player.sceneProgressManager.onEvent(this);
/* 241 */     this.player.mountManager.onEvent(this);
/* 242 */     this.player.functionOpenManager.onEvent(this);
/*     */     
/* 244 */     if (this.type == Const.EventType.interActiveItem.getValue()) {
/* 245 */       onInterActiveItemEvent();
/* 246 */     } else if (this.type == Const.EventType.addUnit.getValue()) {
/* 247 */       onAddUnitEvent();
/* 248 */     } else if (this.type == Const.EventType.changeArea.getValue()) {
/* 249 */       onChangeAreaEvent();
/* 250 */     } else if (this.type == Const.EventType.loopTransform.getValue()) {
/* 251 */       onLoopTransformEvent();
/*     */     } 
/* 253 */     this.player = null;
/* 254 */     this.params = null;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\task\TaskEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */