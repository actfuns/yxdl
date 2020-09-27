/*     */ package com.wanniu.game.task;
/*     */ 
/*     */ import com.alibaba.fastjson.JSONObject;
/*     */ import com.wanniu.core.common.StringString;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.data.base.TaskBase;
/*     */ import com.wanniu.game.player.BILogService;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.task.po.TaskPO;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import pomelo.task.TaskOuterClass;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TaskData
/*     */ {
/*     */   public TaskBase prop;
/*     */   public TaskPO db;
/*  27 */   private int secProgress = -1;
/*     */   
/*     */   public TaskData(TaskBase prop) {
/*  30 */     this.db = new TaskPO();
/*  31 */     this.db.templateId = prop.getId();
/*  32 */     this.db.progress = 0;
/*  33 */     this.db.finishCount = 0;
/*  34 */     this.db.extendData = new HashMap<>();
/*  35 */     this.prop = prop;
/*     */   }
/*     */   
/*     */   public TaskData(TaskPO po) {
/*  39 */     this.db = po;
/*     */     
/*  41 */     TaskBase prop = TaskUtils.getTaskProp(this.db.templateId);
/*  42 */     if (prop != null) {
/*  43 */       this.prop = prop;
/*  44 */       setProgress(this.db.progress);
/*     */     } else {
/*  46 */       Out.error(new Object[] { "there is no data of id: ", Integer.valueOf(this.db.templateId), " in taskProps " });
/*     */     } 
/*     */   }
/*     */   
/*     */   protected Map<String, String> _getBattlerAttribute() {
/*  51 */     if (this.db.battle_attributes == null) {
/*  52 */       this.db.battle_attributes = new HashMap<>();
/*     */     }
/*  54 */     return this.db.battle_attributes;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getKind() {
/*  61 */     return this.prop.getKind();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getType() {
/*  68 */     return this.prop.getType();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getTargetNum() {
/*  75 */     return this.prop.quantity;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isTargetID(TaskEvent msg) {
/*  80 */     if (this.prop.getType() == Const.TaskType.FINISH_CLONESCENE.getValue()) {
/*  81 */       if (Integer.valueOf(msg.params[0].toString()).intValue() == this.prop.doScene) {
/*  82 */         return true;
/*     */       }
/*  84 */       return false;
/*     */     } 
/*  86 */     if (this.prop.getType() == Const.TaskType.TAKE_EQUIP_Qt.getValue()) {
/*  87 */       String[] conditionArr = ((String)this.prop.targets.get(0)).split("\\|");
/*  88 */       String[] conditionArr1 = ((String)msg.params[0]).split("\\|");
/*  89 */       if (conditionArr.length > 1 && conditionArr1.length > 2) {
/*  90 */         int arr0 = Integer.parseInt(conditionArr[0]);
/*  91 */         int arr10 = Integer.parseInt(conditionArr1[0]);
/*  92 */         int arr1 = Integer.parseInt(conditionArr[1]);
/*  93 */         int arr11 = Integer.parseInt(conditionArr1[1]);
/*  94 */         int arr12 = Integer.parseInt(conditionArr1[2]);
/*  95 */         if (arr10 >= arr0 && arr11 >= arr1) {
/*  96 */           if (this.db.extendData == null) {
/*  97 */             this.db.extendData = new HashMap<>();
/*     */           }
/*  99 */           if (this.db.extendData.containsKey(Integer.valueOf(arr12))) {
/* 100 */             return false;
/*     */           }
/* 102 */           this.db.extendData.put(Integer.valueOf(arr12), Integer.valueOf(1));
/* 103 */           return true;
/*     */         } 
/* 105 */         if (arr10 < arr0 || arr11 >= arr1);
/*     */ 
/*     */         
/* 108 */         return false;
/*     */       } 
/* 110 */       return false;
/*     */     } 
/*     */     
/* 113 */     if (this.prop.isTarget(String.valueOf(msg.params[0]))) {
/* 114 */       return true;
/*     */     }
/* 116 */     if (this.prop.isTarget("") && this.prop.getType() != Const.TaskType.reachPos.getValue()) {
/* 117 */       return true;
/*     */     }
/* 119 */     if (this.prop.getType() == Const.TaskType.TRAIN_EQUIP.getValue() && this.prop.isTarget("0")) {
/* 120 */       return true;
/*     */     }
/* 122 */     return false;
/*     */   }
/*     */   
/*     */   public final boolean isTargetFromID(String id) {
/* 126 */     return this.prop.isTargetFormId(id);
/*     */   }
/*     */   
/*     */   public final String questTc() {
/* 130 */     return this.prop.questTC;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean submit() {
/* 139 */     if (this.db.state == Const.TaskState.COMPLETED_NOT_DELIVERY.getValue()) {
/* 140 */       this.db.state = Const.TaskState.COMPLETED.getValue();
/* 141 */       return true;
/*     */     } 
/* 143 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isCompleted() {
/* 150 */     return (this.db.state == Const.TaskState.COMPLETED_NOT_DELIVERY.getValue());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void complete() {
/* 157 */     if (this.db.state == Const.TaskState.NOT_COMPLETED.getValue()) {
/* 158 */       this.db.progress = getTargetNum();
/* 159 */       this.db.state = Const.TaskState.COMPLETED_NOT_DELIVERY.getValue();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isDaily() {
/* 167 */     return (2 == getKind());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isLoop() {
/* 174 */     return (3 == getKind());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isTreasure() {
/* 181 */     return (8 == getKind());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean autoAccept() {
/* 190 */     if (this.prop.giveNpc == 0) {
/* 191 */       return true;
/*     */     }
/* 193 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getState() {
/* 202 */     return this.db.state;
/*     */   }
/*     */   
/*     */   public final void pushProgressTips(WNPlayer player) {
/* 206 */     if (this.db.progress > 0) {
/* 207 */       String tips = this.prop.changePrompt;
/* 208 */       if (tips.length() > 0) {
/* 209 */         String replaceStr = "(" + this.db.progress + "/" + getTargetNum() + ")";
/* 210 */         tips = tips.replace("{0}", replaceStr);
/* 211 */         player.sendSysTip(tips, Const.TipsType.NO_BG);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public final boolean onEvent(WNPlayer player, TaskEvent event) {
/* 217 */     boolean flag = false;
/* 218 */     if (this.db.state != Const.TaskState.NOT_COMPLETED.getValue()) {
/* 219 */       return flag;
/*     */     }
/* 221 */     int name = event.type;
/* 222 */     if (name == getType()) {
/* 223 */       int targetNum = getTargetNum();
/* 224 */       if (isTargetID(event)) {
/* 225 */         Out.debug(new Object[] { "enter  task onEvent" });
/* 226 */         if (name == Const.TaskType.LEVEL_UP.getValue() || name == Const.TaskType.USERUP_LEVEL.getValue() || name == Const.TaskType.TRAIN_EQUIP.getValue() || name == Const.TaskType.MOUNT_UPLEVEL.getValue() || name == Const.TaskType.WING_UPLEVEL.getValue() || name == Const.TaskType.TRAIN_EQUIP_ALL.getValue()) {
/* 227 */           this.db.progress = Math.max(((Integer)event.params[1]).intValue(), this.db.progress);
/*     */         } else {
/* 229 */           this.db.progress += ((Integer)event.params[1]).intValue();
/*     */         } 
/*     */         
/* 232 */         if (this.db.progress >= targetNum) {
/* 233 */           this.db.progress = targetNum;
/* 234 */           complete();
/* 235 */           if (getKind() == 2) {
/* 236 */             player.getPlayerTasks().dailyTaskFinEvent();
/* 237 */           } else if (getKind() == 3) {
/* 238 */             player.getPlayerTasks().loopTaskFinEvent();
/*     */           } 
/*     */ 
/*     */           
/* 242 */           BILogService.getInstance().ansycReportMission(player.getPlayer(), "任务完成", this.prop.kind, this.prop.iD, this.prop.name);
/*     */         } 
/* 244 */         pushProgressTips(player);
/* 245 */         flag = true;
/*     */       } 
/*     */     } 
/*     */     
/* 249 */     return flag;
/*     */   }
/*     */   
/*     */   public int getProgress() {
/* 253 */     return this.db.progress;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean setProgress(int prgs) {
/* 260 */     this.db.progress = prgs;
/* 261 */     if (this.db.progress >= getTargetNum()) {
/* 262 */       complete();
/*     */     }
/* 264 */     return (this.db.progress >= getTargetNum());
/*     */   }
/*     */   
/*     */   public int getSecProgress() {
/* 268 */     return this.secProgress;
/*     */   }
/*     */   
/*     */   public void setSecProgress(int secProgress) {
/* 272 */     this.secProgress = secProgress;
/*     */   }
/*     */   
/*     */   public final List<StringString> initBattleServerAttribute() {
/* 276 */     List<StringString> attr = new ArrayList<>();
/* 277 */     attr.add(new StringString("type", String.valueOf(getType())));
/* 278 */     attr.add(new StringString("areaId", String.valueOf(this.prop.doScene)));
/* 279 */     attr.add(new StringString("pointId", String.valueOf(this.prop.doPoint)));
/* 280 */     attr.add(new StringString("targetId", String.valueOf(this.prop.targetID)));
/*     */ 
/*     */     
/* 283 */     if (this.db.state == Const.TaskState.COMPLETED_NOT_DELIVERY.getValue()) {
/* 284 */       attr.add(new StringString("state", "1"));
/*     */     } else {
/* 286 */       attr.add(new StringString("state", "0"));
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 292 */     Map<String, String> saved_attrs = _getBattlerAttribute();
/* 293 */     for (Map.Entry<String, String> node : saved_attrs.entrySet()) {
/* 294 */       attr.add(new StringString(node.getKey(), node.getValue()));
/*     */     }
/* 296 */     return attr;
/*     */   }
/*     */   
/*     */   public final void setBattleAttribute(String key, String value) {
/* 300 */     Map<String, String> saved_attrs = _getBattlerAttribute();
/* 301 */     if (value != null) {
/* 302 */       saved_attrs.put(key, value);
/*     */     } else {
/* 304 */       saved_attrs.remove(key);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final JSONObject toJson4BattleServer() {
/* 312 */     JSONObject data = new JSONObject();
/* 313 */     data.put("QuestID", Integer.valueOf(this.db.templateId));
/* 314 */     data.put("State", Integer.valueOf(1));
/* 315 */     data.put("Attributes", initBattleServerAttribute());
/* 316 */     return data;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TaskPO toJson4Serialize() {
/* 323 */     return this.db;
/*     */   }
/*     */   
/*     */   public final TaskOuterClass.Task buildTask() {
/* 327 */     TaskOuterClass.Task.Builder builder = TaskOuterClass.Task.newBuilder();
/* 328 */     builder.setTemplateId(this.db.templateId);
/* 329 */     builder.setState(this.db.state);
/* 330 */     if (this.secProgress > -1) {
/* 331 */       builder.addProgress(this.secProgress);
/*     */     }
/* 333 */     builder.addProgress(this.db.progress);
/* 334 */     builder.setLeftTime(this.prop.limitTime);
/* 335 */     return builder.build();
/*     */   }
/*     */   
/*     */   public final TaskData clone() {
/* 339 */     TaskData task = new TaskData(this.prop);
/* 340 */     task.db.state = this.db.state;
/* 341 */     task.db.progress = this.db.progress;
/* 342 */     task.db.finishCount = this.db.finishCount;
/* 343 */     return task;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\task\TaskData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */