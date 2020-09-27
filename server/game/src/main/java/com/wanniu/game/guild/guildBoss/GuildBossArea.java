/*     */ package com.wanniu.game.guild.guildBoss;
/*     */ 
/*     */ import com.alibaba.fastjson.JSONArray;
/*     */ import com.alibaba.fastjson.JSONObject;
/*     */ import com.google.protobuf.GeneratedMessage;
/*     */ import com.wanniu.core.game.JobFactory;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.tcp.protocol.Message;
/*     */ import com.wanniu.game.area.Area;
/*     */ import com.wanniu.game.area.DamageHealVO;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.msg.MessagePush;
/*     */ import com.wanniu.game.data.ext.InspireLevelExt;
/*     */ import com.wanniu.game.guild.GuildService;
/*     */ import com.wanniu.game.monster.GuildBossRatioConfig;
/*     */ import com.wanniu.game.player.GlobalConfig;
/*     */ import com.wanniu.game.player.PlayerUtil;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.poes.GuildBossPo;
/*     */ import com.wanniu.game.poes.GuildPO;
/*     */ import com.wanniu.game.sevengoal.SevenGoalManager;
/*     */ import com.wanniu.game.task.TaskEvent;
/*     */ import com.wanniu.game.task.TaskQueue;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import java.util.concurrent.ScheduledFuture;
/*     */ import pomelo.area.GuildBossHandler;
/*     */ 
/*     */ public class GuildBossArea
/*     */   extends Area
/*     */ {
/*     */   private GuildPO guildPo;
/*     */   private ScheduledFuture<?> future;
/*     */   private boolean isKilled = false;
/*     */   private boolean stopHurtAdd = false;
/*     */   private long killTime;
/*  42 */   private long outTime = 0L;
/*  43 */   private Map<String, Integer> playerEnterCount = new ConcurrentHashMap<>();
/*  44 */   private Set<String> onLines = new HashSet<>();
/*     */   
/*     */   public GuildBossArea(JSONObject opts, GuildPO guildPo) {
/*  47 */     super(opts);
/*  48 */     initStatisticsJob();
/*  49 */     if (this.guildPo == null && guildPo != null) {
/*  50 */       this.guildPo = guildPo;
/*     */     }
/*  52 */     this.outTime = calEndTime();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private long calEndTime() {
/*  61 */     return System.currentTimeMillis() + (GuildBossService.getInstance().getEndSeconds() * 1000);
/*     */   }
/*     */   
/*     */   public void preOverProcess() {
/*  65 */     pushDetailInfo();
/*  66 */     removeBoss();
/*     */   }
/*     */   
/*     */   public void removeBoss() {
/*  70 */     getXmdsManager().removeUnit(this.instanceId, 552001);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void pushDetailInfo() {
/*  77 */     JobFactory.addDelayJob(() -> processPushDetailInfo(), 2000L);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void processPushDetailInfo() {
/*  83 */     this.stopHurtAdd = true;
/*  84 */     cancelSchdule();
/*  85 */     Collection<String> roleIds = this.actors.keySet();
/*  86 */     TaskQueue.put(new TaskEvent(Const.EventType.over_statics_ranks, new Object[] { this.guildPo.id, roleIds }));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onGameOver() {
/*  93 */     this.killTime = System.currentTimeMillis() + 5000L;
/*  94 */     statistics(this.killTime, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onBattleReport(List<DamageHealVO> datas) {
/* 103 */     if (datas != null && !datas.isEmpty()) {
/* 104 */       for (DamageHealVO heal : datas) {
/* 105 */         if (heal.TotalDamage <= 0) {
/*     */           continue;
/*     */         }
/* 108 */         setNewData(heal.PlayerUUID, heal.TotalDamage);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected void addCloseFuture(int second) {
/* 115 */     super.addCloseFuture(second);
/*     */   }
/*     */ 
/*     */   
/*     */   public void dispose() {
/* 120 */     super.dispose();
/* 121 */     cancelSchdule();
/*     */   }
/*     */ 
/*     */   
/*     */   public void onMonsterDead(int monsterId, int level, float x, float y, int attackType, String refreshPoint, WNPlayer player, JSONArray teamSharedIdList, JSONArray atkAssistantList) {
/* 126 */     super.onMonsterDead(monsterId, level, x, y, attackType, refreshPoint, player, teamSharedIdList, atkAssistantList);
/* 127 */     if (monsterId == 552001) {
/* 128 */       onBossDead();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int receiveSinlgInspire(WNPlayer player, GuildBossPo guildBossPO, boolean isAttributeChanged) {
/* 139 */     int totalAdd = getInpireAdd(1, guildBossPO.inspire.count);
/* 140 */     GuildBossHandler.OnInspireChangePush.Builder msg = getOnInspireChangePush(guildBossPO.inspire.count, totalAdd / 100, 1);
/* 141 */     player.receive("area.guildBossPush.onInspireChangePush", (GeneratedMessage)msg.build());
/* 142 */     if (totalAdd > 0 && isAttributeChanged) {
/* 143 */       player.btlDataManager.onGuildBossInpire();
/* 144 */       player.refreshBattlerServerEffect(false);
/*     */     } 
/* 146 */     return totalAdd;
/*     */   }
/*     */   
/*     */   public int getInpireAdd(int index, int count) {
/* 150 */     InspireLevelExt co = GuildBossRatioConfig.getInspireLevelCO(index, count);
/* 151 */     return (co != null) ? co.totalInspirePlus : 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int receiveGuildInspire(int index, int count) {
/* 160 */     int totalAdd = getInpireAdd(index, count);
/* 161 */     GuildBossHandler.OnInspireChangePush.Builder msg = getOnInspireChangePush(count, totalAdd / 100, index);
/* 162 */     Collection<String> roleIds = this.actors.keySet();
/* 163 */     for (String playerId : roleIds) {
/* 164 */       WNPlayer player = PlayerUtil.getOnlinePlayer(playerId);
/* 165 */       player.receive("area.guildBossPush.onInspireChangePush", (GeneratedMessage)msg.build());
/* 166 */       if (totalAdd > 0) {
/* 167 */         player.btlDataManager.onGuildBossInpire();
/* 168 */         player.refreshBattlerServerEffect(false);
/*     */       } 
/*     */     } 
/* 171 */     return totalAdd;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int receiveGuildInspireAtk(WNPlayer player) {
/* 180 */     int totalAdd = getInpireAdd(2, this.guildPo.inspire.count);
/* 181 */     GuildBossHandler.OnInspireChangePush.Builder msg = getOnInspireChangePush(this.guildPo.inspire.count, totalAdd / 100, 2);
/* 182 */     player.receive("area.guildBossPush.onInspireChangePush", (GeneratedMessage)msg.build());
/* 183 */     return totalAdd;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int receiveGuildInspireDef(WNPlayer player) {
/* 192 */     int totalAdd = getInpireAdd(3, this.guildPo.defInspire.count);
/* 193 */     GuildBossHandler.OnInspireChangePush.Builder msg = getOnInspireChangePush(this.guildPo.defInspire.count, totalAdd / 100, 3);
/* 194 */     player.receive("area.guildBossPush.onInspireChangePush", (GeneratedMessage)msg.build());
/* 195 */     return totalAdd;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTotalAtkAdd(WNPlayer player) {
/* 205 */     int totalAdd = 0;
/* 206 */     GuildBossPo guildBossPO = player.guildBossManager.getAndCheckUpdateGuildBossPo(player.player.id);
/* 207 */     totalAdd += getInpireAdd(1, guildBossPO.inspire.count);
/* 208 */     if (this.guildPo != null && this.guildPo.inspire != null) {
/* 209 */       totalAdd += getInpireAdd(2, this.guildPo.inspire.count);
/*     */     }
/* 211 */     return totalAdd;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTotalDefAdd(WNPlayer player) {
/* 221 */     int totalAdd = 0;
/* 222 */     if (this.guildPo != null && this.guildPo.defInspire != null) {
/* 223 */       totalAdd += getInpireAdd(3, this.guildPo.defInspire.count);
/*     */     }
/* 225 */     return totalAdd;
/*     */   }
/*     */   
/*     */   public void receiveInspireAfterEnter(WNPlayer player) {
/* 229 */     GuildBossPo singleSprie = player.guildBossManager.getAndCheckUpdateGuildBossPo(player.player.id);
/* 230 */     int add = 0;
/* 231 */     add += receiveSinlgInspire(player, singleSprie, false);
/* 232 */     GuildPO guildPO = player.guildManager.guild;
/* 233 */     player.guildBossManager.getAndCheckGuildBossAtkPoForGuild(guildPO);
/* 234 */     player.guildBossManager.getAndCheckGuildBossDefPoForGuild(guildPO);
/* 235 */     add += receiveGuildInspireAtk(player);
/* 236 */     add += receiveGuildInspireDef(player);
/* 237 */     if (add > 0) {
/* 238 */       player.btlDataManager.onGuildBossInpire();
/* 239 */       player.refreshBattlerServerEffect(false);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void onPlayerLeave(WNPlayer player) {
/* 244 */     int totalAdd = 0;
/* 245 */     GuildBossPo guildBossPO = player.guildBossManager.getAndCheckUpdateGuildBossPo(player.player.id);
/* 246 */     totalAdd += getInpireAdd(1, guildBossPO.inspire.count);
/* 247 */     if (this.guildPo != null && this.guildPo.inspire != null) {
/* 248 */       totalAdd += getInpireAdd(2, this.guildPo.inspire.count);
/*     */     }
/* 250 */     if (totalAdd > 0) {
/* 251 */       player.btlDataManager.onGuildBossInpire();
/* 252 */       player.refreshBattlerServerEffect(false);
/*     */     } 
/*     */   }
/*     */   
/*     */   private GuildBossHandler.OnInspireChangePush.Builder getOnInspireChangePush(int personalTimes, int personalValue, int index) {
/* 257 */     GuildBossHandler.OnInspireChangePush.Builder bd = GuildBossHandler.OnInspireChangePush.newBuilder();
/* 258 */     bd.setTotalTimes(personalTimes);
/* 259 */     bd.setTotalValue(personalValue);
/* 260 */     bd.setIndex(index);
/* 261 */     bd.setS2CCode(200);
/* 262 */     return bd;
/*     */   }
/*     */   
/*     */   public void onBossDead() {
/* 266 */     Out.info(new Object[] { "工会BOSS活动。。怪被杀了,guildId=", this.guildPo.id });
/* 267 */     this.isKilled = true;
/* 268 */     this.killTime = System.currentTimeMillis();
/* 269 */     GuildBossService.getInstance().upgradeGuildBoss();
/* 270 */     statistics(this.killTime, true);
/* 271 */     pushDetailInfo();
/* 272 */     addCloseFuture(GlobalConfig.GuildBoss_LeaveTime - 3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void cancelSchdule() {
/* 279 */     if (this.future != null) {
/* 280 */       this.future.cancel(false);
/* 281 */       this.future = null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isKilled() {
/* 286 */     return this.isKilled;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void pushKickTime(WNPlayer player) {
/* 293 */     if (this.outTime == 0L) {
/*     */       return;
/*     */     }
/* 296 */     long now = System.currentTimeMillis();
/* 297 */     int seconds = 1;
/* 298 */     if (now < this.outTime) {
/* 299 */       seconds = (int)((this.outTime - now) / 1000L);
/*     */     }
/* 301 */     seconds = (seconds <= 0) ? 1 : seconds;
/* 302 */     MessagePush push = new MessagePush("area.guildBossPush.onQuitGuildBossPush", (GeneratedMessage)GuildBossHandler.OnQuitGuildBossPush.newBuilder().setEndSeconds(seconds).build());
/* 303 */     player.receive((Message)push);
/*     */   }
/*     */ 
/*     */   
/*     */   public void playerLeaveRequest(WNPlayer player, boolean keepObject) {
/* 308 */     super.playerLeaveRequest(player, keepObject);
/* 309 */     if (!keepObject) {
/* 310 */       synchronized (this) {
/* 311 */         this.onLines.remove(player.getId());
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onPlayerLeaved(WNPlayer player) {
/* 319 */     super.onPlayerLeaved(player);
/* 320 */     onPlayerLeave(player);
/*     */   }
/*     */ 
/*     */   
/*     */   public void onPlayerEntered(WNPlayer player) {
/* 325 */     super.onPlayerEntered(player);
/* 326 */     synchronized (this) {
/* 327 */       if (this.onLines.add(player.getId())) {
/* 328 */         Integer count = this.playerEnterCount.get(player.player.id);
/* 329 */         if (count == null) {
/* 330 */           this.playerEnterCount.put(player.player.id, Integer.valueOf(1));
/*     */         } else {
/* 332 */           this.playerEnterCount.put(player.player.id, Integer.valueOf(count.intValue() + 1));
/*     */         } 
/*     */       } 
/*     */     } 
/* 336 */     player.sevenGoalManager.processGoal(SevenGoalManager.SevenGoalTaskType.GUILD_BOSS_COUNT, new Object[0]);
/*     */   }
/*     */   
/*     */   public int getEnterCount(String playerId) {
/* 340 */     Integer count = this.playerEnterCount.get(playerId);
/* 341 */     if (count == null) {
/* 342 */       return 0;
/*     */     }
/* 344 */     return count.intValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void initStatisticsJob() {
/* 352 */     this.future = JobFactory.addScheduleJob(new Runnable()
/*     */         {
/*     */           public void run() {
/* 355 */             GuildBossArea.this.statistics(0L, false);
/*     */           }
/*     */         }1000L, 1000L);
/*     */   }
/*     */ 
/*     */   
/*     */   public void onReady(WNPlayer player) {
/* 362 */     String guildId = GuildService.getGuildId(player.player.id);
/* 363 */     if (guildId != null) {
/* 364 */       List<String> pushRoleIds = new ArrayList<>();
/* 365 */       pushRoleIds.add(player.getId());
/* 366 */       Collection<String> roleIds = this.actors.keySet();
/* 367 */       player.onEvent(new TaskEvent(Const.EventType.hurtRank_sort, new Object[] { guildId, roleIds, Boolean.valueOf(true), Long.valueOf(0L), Boolean.valueOf(false) }));
/* 368 */       receiveInspireAfterEnter(player);
/* 369 */       pushKickTime(player);
/*     */     } else {
/* 371 */       Out.warn(new Object[] { "发现有个玩家在工会BOSS场景没有工会ID,playerId=", player.player.id });
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void statistics(long bossKillTime, boolean hasKilled) {
/* 379 */     if (this.guildPo == null) {
/* 380 */       Out.warn(new Object[] { "发现有个玩家在工会BOSS场景没有工会ID,instanceId=", this.instanceId });
/*     */       return;
/*     */     } 
/* 383 */     Collection<String> roleIds = this.actors.keySet();
/* 384 */     TaskQueue.put(new TaskEvent(Const.EventType.hurtRank_sort, new Object[] { this.guildPo.id, roleIds, Boolean.valueOf(false), Long.valueOf(bossKillTime), Boolean.valueOf(hasKilled) }));
/*     */   }
/*     */   
/*     */   public void setNewData(String playerId, long hurt) {
/* 388 */     if (this.guildPo == null) {
/* 389 */       Out.warn(new Object[] { "发现有个玩家在工会BOSS场景没有工会ID,instanceId=", this.instanceId });
/*     */       return;
/*     */     } 
/* 392 */     if (this.stopHurtAdd) {
/*     */       return;
/*     */     }
/*     */     
/* 396 */     int enterCount = getEnterCount(playerId);
/* 397 */     TaskQueue.put(new TaskEvent(Const.EventType.hurtRank, new Object[] { this.guildPo.id, playerId, Long.valueOf(hurt), Integer.valueOf(enterCount) }));
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\guild\guildBoss\GuildBossArea.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */