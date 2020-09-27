/*     */ package com.wanniu.game.fightLevel;
/*     */ 
/*     */ import com.alibaba.fastjson.JSONObject;
/*     */ import com.google.protobuf.GeneratedMessage;
/*     */ import com.wanniu.core.game.JobFactory;
/*     */ import com.wanniu.core.game.LangService;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.tcp.protocol.Message;
/*     */ import com.wanniu.game.GWorld;
/*     */ import com.wanniu.game.area.Area;
/*     */ import com.wanniu.game.area.AreaEvent;
/*     */ import com.wanniu.game.area.DamageHealVO;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.msg.MessagePush;
/*     */ import com.wanniu.game.fightLevel.po.OutputStatistics;
/*     */ import com.wanniu.game.player.BILogService;
/*     */ import com.wanniu.game.player.GlobalConfig;
/*     */ import com.wanniu.game.player.PlayerUtil;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.task.TaskEvent;
/*     */ import com.wanniu.game.task.TaskUtils;
/*     */ import com.wanniu.game.team.TeamData;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import java.util.concurrent.ScheduledFuture;
/*     */ import pomelo.area.FightLevelHandler;
/*     */ import pomelo.area.TeamHandler;
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
/*     */ public class FightLevel
/*     */   extends Area
/*     */ {
/*     */   public static final int NEED_PRODUCE_LEVEL = 30;
/*     */   public int hard;
/*     */   private int needProduce;
/*     */   private Const.SCENE_TYPE sceneType;
/*     */   private ScheduledFuture<?> jobFuture;
/*  48 */   private final ConcurrentHashMap<String, OutputStatistics> output = new ConcurrentHashMap<>();
/*     */   
/*     */   public FightLevel(JSONObject opts, Const.SCENE_TYPE sceneType) {
/*  51 */     super(opts);
/*  52 */     this.hard = this.prop.hardModel;
/*  53 */     this.sceneType = sceneType;
/*     */ 
/*     */     
/*  56 */     this.jobFuture = JobFactory.addFixedRateJob(() -> GWorld.getInstance().ansycExec(()), 5000L, 3000L);
/*     */   }
/*     */   
/*     */   public void output() {
/*  60 */     if (this.output.isEmpty()) {
/*     */       return;
/*     */     }
/*     */     
/*  64 */     if (this.actors.isEmpty()) {
/*     */       return;
/*     */     }
/*     */     
/*  68 */     TeamHandler.OnTeamMumberHurtPush.Builder push = TeamHandler.OnTeamMumberHurtPush.newBuilder();
/*  69 */     for (OutputStatistics out : this.output.values()) {
/*  70 */       TeamHandler.MumberHurtInfo.Builder m = TeamHandler.MumberHurtInfo.newBuilder();
/*  71 */       m.setPlayerName(out.getName());
/*  72 */       m.setHurt(out.getHurt());
/*  73 */       m.setCure(out.getCure());
/*  74 */       push.addPlayers(m);
/*     */     } 
/*     */     
/*  77 */     TeamHandler.OnTeamMumberHurtPush result = push.build();
/*  78 */     for (Map.Entry<String, Area.Actor> actorEntry : (Iterable<Map.Entry<String, Area.Actor>>)this.actors.entrySet()) {
/*  79 */       String playerId = actorEntry.getKey();
/*  80 */       WNPlayer player = getPlayer(playerId);
/*  81 */       if (player == null) {
/*     */         continue;
/*     */       }
/*  84 */       player.receive("area.teamPush.onTeamMumberHurtPush", (GeneratedMessage)result);
/*     */     } 
/*  86 */     Out.debug(new Object[] { "副本输出.... areaId=", Integer.valueOf(this.areaId) });
/*     */   }
/*     */ 
/*     */   
/*     */   public void bindBattleServer(WNPlayer player) {
/*  91 */     super.bindBattleServer(player);
/*  92 */     TeamData team = player.getTeamManager().getTeam();
/*  93 */     if (team != null) {
/*  94 */       WNPlayer member = null;
/*  95 */       for (TeamData.TeamMemberData teamMember : team.teamMembers.values()) {
/*  96 */         member = teamMember.getPlayer();
/*  97 */         if (member == null) {
/*     */           continue;
/*     */         }
/* 100 */         if (needProduce(member)) {
/* 101 */           this.needProduce++;
/*     */         }
/*     */       }
/*     */     
/* 105 */     } else if (needProduce(player)) {
/* 106 */       this.needProduce = 1;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void onDailyActivity(WNPlayer player) {
/* 112 */     super.onDailyActivity(player);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 117 */     if (this.sceneType == Const.SCENE_TYPE.FIGHT_LEVEL) {
/* 118 */       player.dailyActivityMgr.onEvent(Const.DailyType.DUNGEON, "0", 1);
/*     */     }
/*     */   }
/*     */   
/*     */   public int reliveNum(String playerid) {
/* 123 */     Out.debug(new Object[] { getClass().getName(), "fightLevel reviveNum:", this.actors });
/* 124 */     Area.Actor actor = (Area.Actor)this.actors.get(playerid);
/* 125 */     if (actor == null) {
/*     */       
/* 127 */       Out.error(new Object[] { getClass().getName(), "fightLevel revive playerId not exist:", playerid });
/* 128 */       return 0;
/*     */     } 
/*     */     
/* 131 */     int configNum = this.prop.revival;
/* 132 */     if (configNum <= 0) {
/* 133 */       return configNum;
/*     */     }
/* 135 */     if (configNum <= actor.rebornNum) {
/* 136 */       return 0;
/*     */     }
/* 138 */     return configNum - actor.rebornNum;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onGameOver(JSONObject event) {
/* 144 */     if (this.jobFuture != null) {
/* 145 */       this.jobFuture.cancel(false);
/*     */     }
/*     */     
/* 148 */     int winForce = event.getIntValue("winForce");
/* 149 */     boolean isWin = (winForce == 2);
/* 150 */     MessagePush push = new MessagePush("area.fightLevelPush.onFubenClosePush", (GeneratedMessage)FightLevelHandler.OnFubenClosePush.newBuilder().setS2CMsg(LangService.getValue("DUNGEON_OVER_MESSAGE")).setS2COverTime(this.prop.timeCount).build());
/*     */ 
/*     */     
/* 153 */     WNPlayer player = null;
/* 154 */     for (Map.Entry<String, Area.Actor> actorEntry : (Iterable<Map.Entry<String, Area.Actor>>)this.actors.entrySet()) {
/* 155 */       String playerId = actorEntry.getKey();
/* 156 */       Area.Actor actor = actorEntry.getValue();
/* 157 */       player = getPlayer(playerId);
/* 158 */       if (player == null)
/*     */         continue; 
/* 160 */       if (isWin) {
/* 161 */         player.finishFightLevel(this.hard, this.prop.templateID);
/* 162 */         player.onEvent(new TaskEvent(Const.TaskType.FINISH_CLONESCENE, new Object[] { String.valueOf(this.areaId), Integer.valueOf(1) }));
/*     */ 
/*     */         
/* 165 */         if (this.prop.dungeonTab == 1 && player != null) {
/* 166 */           Collection<String> teamMembers = player.getTeamMembers();
/* 167 */           if (teamMembers != null) {
/* 168 */             WNPlayer member = PlayerUtil.getOnlinePlayer(playerId);
/* 169 */             int lvl = member.getLevel();
/* 170 */             for (String teamMemPlayerId : teamMembers) {
/* 171 */               if (this.actors.containsKey(teamMemPlayerId)) {
/* 172 */                 WNPlayer teamMember = PlayerUtil.getOnlinePlayer(teamMemPlayerId);
/* 173 */                 if (teamMember == null)
/*     */                   continue; 
/* 175 */                 int tempLvl = teamMember.getLevel();
/*     */                 
/* 177 */                 if (lvl >= tempLvl + 5 || (!actor.profitable && (getActor(teamMemPlayerId)).profitable)) {
/* 178 */                   player.processXianYuanGet(GlobalConfig.Fate_Dungeon);
/*     */                   
/*     */                   break;
/*     */                 } 
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } 
/* 186 */         if (this.prop.type == Const.SCENE_TYPE.FIGHT_LEVEL.getValue()) {
/* 187 */           player.onEvent(new TaskEvent(Const.TaskType.FINISH_DUNGEONS_COUNT, new Object[] { String.valueOf(this.areaId), Integer.valueOf(1) }));
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/* 192 */       player.achievementManager.onPassedDungeon(this.areaId);
/*     */       
/* 194 */       player.receive((Message)push);
/*     */       
/* 196 */       BILogService.getInstance().ansycReportFightLevel(player.getPlayer(), isWin ? 1 : 0, this.areaId, this.instanceId);
/*     */     } 
/* 198 */     if (isWin) {
/*     */       
/* 200 */       TeamData team = player.getTeamManager().getTeam();
/* 201 */       if (team != null) {
/* 202 */         WNPlayer member = null;
/* 203 */         for (TeamData.TeamMemberData teamMember : team.teamMembers.values()) {
/* 204 */           member = teamMember.getPlayer();
/* 205 */           if (member == null) {
/*     */             continue;
/*     */           }
/* 208 */           member.fightLevelManager.useProduce(this.prop.templateID);
/* 209 */           member.fightLevelManager.onDungeonReset(this.areaId);
/*     */         } 
/*     */       } else {
/* 212 */         player.fightLevelManager.useProduce(this.prop.templateID);
/* 213 */         player.fightLevelManager.onDungeonReset(this.areaId);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void onDisponseLeave(WNPlayer player) {
/* 220 */     Out.debug(new Object[] { "-------------------dispose----", player.getName() });
/* 221 */     TeamData.TeamMemberData teamMember = player.getTeamManager().getTeamMember();
/* 222 */     if (teamMember == null || teamMember.isLeader || !teamMember.follow) {
/* 223 */       Out.debug(new Object[] { player.getName(), " leave fight level!!!!!!!!!!!!!!!!!!" });
/* 224 */       player.fightLevelManager.leaveDungeon(player, this);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isUseTC() {
/* 230 */     return (this.needProduce > 0);
/*     */   }
/*     */   
/*     */   public void onPlayerDeadByMonster(WNPlayer player, AreaEvent.MonsterData monsterData) {
/* 234 */     String playerId = player.getId();
/*     */     
/* 236 */     Area.Actor actor = (Area.Actor)this.actors.get(playerId);
/* 237 */     if (actor == null && !player.isProxy()) {
/* 238 */       Out.error(new Object[] { "onPlayerDead not exist! :", playerId });
/*     */       
/*     */       return;
/*     */     } 
/* 242 */     pushRelive(player);
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean needProduce(WNPlayer player) {
/* 247 */     if (this.prop.type == Const.SCENE_TYPE.LOOP.getValue())
/*     */     {
/* 249 */       return TaskUtils.profitableLoop(player);
/*     */     }
/* 251 */     return (player.fightLevelManager.needProduce(this.prop.templateID) && player.getLevel() < this.prop.reqLevel + 30);
/*     */   }
/*     */ 
/*     */   
/*     */   public void onPlayerDeadByPlayer(WNPlayer deadPlayer, WNPlayer hitPlayer, float x, float y) {
/* 256 */     Out.warn(new Object[] { "副本中出现玩家击杀玩家！" });
/*     */   }
/*     */   
/*     */   public void addPlayer(WNPlayer player) {
/* 260 */     super.addPlayer(player);
/* 261 */     Area.Actor actor = getActor(player.getId());
/* 262 */     if (actor != null) {
/* 263 */       actor.profitable = needProduce(player);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Area.AreaItem onPickItem(String playerId, String itemId, boolean isGuard) {
/* 269 */     return isUseTC() ? super.onPickItem(playerId, itemId, isGuard) : null;
/*     */   }
/*     */   
/*     */   public Area.ReliveType getReliveType() {
/* 273 */     return (this.prop.type == Const.SCENE_TYPE.LOOP.getValue()) ? Area.ReliveType.NOW : Area.ReliveType.BORN;
/*     */   }
/*     */ 
/*     */   
/*     */   public void dispose(boolean processExit) {
/* 278 */     super.dispose(processExit);
/* 279 */     if (this.jobFuture != null) {
/* 280 */       this.jobFuture.cancel(false);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onBattleReport(List<DamageHealVO> datas) {
/* 287 */     for (DamageHealVO damage : datas) {
/* 288 */       OutputStatistics out = this.output.get(damage.PlayerUUID);
/* 289 */       if (out == null) {
/* 290 */         WNPlayer player = PlayerUtil.getOnlinePlayer(damage.PlayerUUID);
/* 291 */         if (player != null) {
/* 292 */           out = new OutputStatistics();
/* 293 */           out.setId(damage.PlayerUUID);
/* 294 */           out.setName(player.getName());
/* 295 */           this.output.put(damage.PlayerUUID, out);
/*     */         } 
/*     */       } 
/*     */       
/* 299 */       if (out != null) {
/* 300 */         out.setHurt(damage.TotalDamage);
/* 301 */         out.setCure(damage.TotalHealing);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\fightLevel\FightLevel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */