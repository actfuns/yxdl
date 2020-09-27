/*     */ package com.wanniu.game.arena;
/*     */ 
/*     */ import com.alibaba.fastjson.JSONObject;
/*     */ import com.google.protobuf.GeneratedMessage;
/*     */ import com.wanniu.core.game.JobFactory;
/*     */ import com.wanniu.core.game.LangService;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.game.area.Area;
/*     */ import com.wanniu.game.area.AreaEvent;
/*     */ import com.wanniu.game.arena.vo.ArenaBattleVO;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.msg.MessageUtil;
/*     */ import com.wanniu.game.common.msg.WNNotifyManager;
/*     */ import com.wanniu.game.data.GameData;
/*     */ import com.wanniu.game.data.GameMapCO;
/*     */ import com.wanniu.game.player.GlobalConfig;
/*     */ import com.wanniu.game.player.PlayerUtil;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.sevengoal.SevenGoalManager;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import pomelo.area.ArenaHandler;
/*     */ import pomelo.area.PlayerHandler;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ArenaArea
/*     */   extends Area
/*     */ {
/*     */   private String firstPlayerId;
/*  35 */   private ConcurrentHashMap<String, ArenaBattleVO> rank = new ConcurrentHashMap<>();
/*     */   
/*     */   public ArenaArea(JSONObject opts) {
/*  38 */     super(opts);
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
/*     */   
/*     */   private void refreshPlayerRank(WNPlayer player) {
/*  54 */     ArenaBattleVO vo = this.rank.get(player.getId());
/*  55 */     int oldScore = vo.getScore();
/*  56 */     vo.setScore(player.arenaManager.getScore());
/*  57 */     vo.setKillCount(player.arenaManager.getCombo());
/*  58 */     if (oldScore != vo.getScore()) {
/*  59 */       vo.setUpdateTime(System.currentTimeMillis());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private List<ArenaHandler.ArenaBattleScore> getAllKillCount() {
/*  67 */     List<ArenaBattleVO> listRank = new ArrayList<>(this.rank.values());
/*  68 */     Collections.sort(listRank, new Comparator<ArenaBattleVO>()
/*     */         {
/*     */           public int compare(ArenaBattleVO left, ArenaBattleVO right) {
/*  71 */             return (left.getKillCount() >= right.getKillCount()) ? -1 : 1;
/*     */           }
/*     */         });
/*     */ 
/*     */     
/*  76 */     List<ArenaHandler.ArenaBattleScore> top3 = new ArrayList<>();
/*  77 */     for (ArenaBattleVO bf : listRank) {
/*  78 */       top3.add(bf.toBuilder(false));
/*     */     }
/*     */     
/*  81 */     return top3;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private List<ArenaHandler.ArenaBattleScore> getAllScores() {
/*  90 */     List<ArenaBattleVO> listRank = new ArrayList<>(this.rank.values());
/*  91 */     Collections.sort(listRank, new Comparator<ArenaBattleVO>()
/*     */         {
/*     */           public int compare(ArenaBattleVO left, ArenaBattleVO right) {
/*  94 */             int i = right.getScore() - left.getScore();
/*  95 */             if (i == 0) {
/*  96 */               i = (int)(left.getUpdateTime() - right.getUpdateTime());
/*     */             }
/*  98 */             return i;
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 103 */     List<ArenaHandler.ArenaBattleScore> top3 = new ArrayList<>();
/* 104 */     for (ArenaBattleVO bf : listRank) {
/* 105 */       top3.add(bf.toBuilder(true));
/*     */     }
/*     */     
/* 108 */     return top3;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void pushArenaBattleInfo(WNPlayer targetPlayer) {
/* 117 */     List<ArenaHandler.ArenaBattleScore> killRank = getAllKillCount();
/* 118 */     List<ArenaHandler.ArenaBattleScore> scoreRank = getAllScores();
/* 119 */     int i = 1;
/* 120 */     for (ArenaHandler.ArenaBattleScore ab : scoreRank) {
/* 121 */       WNPlayer player = null;
/* 122 */       if (targetPlayer != null && targetPlayer.getId().equals(ab.getId())) {
/* 123 */         player = targetPlayer;
/*     */       } else {
/* 125 */         player = getPlayer(ab.getId());
/*     */       } 
/*     */       
/* 128 */       if (player != null) {
/* 129 */         ArenaHandler.OnArenaBattleInfoPush.Builder builder = ArenaHandler.OnArenaBattleInfoPush.newBuilder();
/* 130 */         builder.setS2CCode(200);
/* 131 */         builder.setS2CKillCount(player.arenaManager.getCombo());
/* 132 */         builder.setS2CIndex(i);
/* 133 */         builder.setS2CScore(player.arenaManager.getScore());
/* 134 */         builder.addAllS2CScores(scoreRank);
/* 135 */         builder.setS2CPlayerCount(this.actors.size());
/* 136 */         builder.addAllS2CKillCountList(killRank);
/*     */         
/* 138 */         player.receive("area.arenaPush.onArenaBattleInfoPush", (GeneratedMessage)builder.build());
/*     */       } else {
/* 140 */         Out.error(new Object[] { getClass(), "_pushBattleMessage can't find player id:", ab.getId() });
/*     */       } 
/* 142 */       i++;
/*     */     } 
/* 144 */     if (!scoreRank.isEmpty()) {
/* 145 */       String newFirst = ((ArenaHandler.ArenaBattleScore)scoreRank.get(0)).getId();
/*     */       
/* 147 */       if (!newFirst.equals(this.firstPlayerId)) {
/* 148 */         String tips = LangService.format("ARENA_TO_FIRST", new Object[] { ((ArenaBattleVO)this.rank.get(newFirst)).getName() });
/* 149 */         for (String tempPlayerId : this.actors.keySet()) {
/* 150 */           WNPlayer tempPlayer = PlayerUtil.getOnlinePlayer(tempPlayerId);
/* 151 */           if (tempPlayer != null) {
/* 152 */             MessageUtil.sendSysTip(tempPlayer, tips, Const.TipsType.ROLL);
/*     */           }
/*     */         } 
/* 155 */         this.firstPlayerId = newFirst;
/*     */       } 
/*     */     } else {
/* 158 */       this.firstPlayerId = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setForce(WNPlayer player) {
/* 164 */     ArenaBattleVO obj = this.rank.get(player.getId());
/* 165 */     if (obj == null) {
/* 166 */       player.setForce(this.rank.size() + 2);
/*     */     } else {
/* 168 */       player.setForce(obj.getForce());
/*     */     } 
/*     */   }
/*     */   
/*     */   public void onPlayerEntered(WNPlayer player) {
/* 173 */     ArenaBattleVO obj = this.rank.get(player.getId());
/* 174 */     if (obj == null) {
/* 175 */       obj = new ArenaBattleVO();
/* 176 */       obj.setId(player.getId());
/* 177 */       obj.setName(player.getName());
/* 178 */       obj.setPro(player.getPro());
/* 179 */       obj.setForce(player.getForce());
/* 180 */       this.rank.put(obj.getId(), obj);
/*     */     } 
/*     */     
/* 183 */     player.getXmdsManager().refreshPlayerPKMode(player.getId(), Const.PkModel.All.value);
/* 184 */     player.achievementManager.onArenaScore(0);
/* 185 */     if (this.firstPlayerId == null) {
/* 186 */       this.firstPlayerId = player.getId();
/*     */     }
/* 188 */     player.arenaManager.setArenaInstanceId(this.instanceId);
/*     */     
/* 190 */     player.sevenGoalManager.processGoal(SevenGoalManager.SevenGoalTaskType.FIVE_MOUNTAIN_ANTICIPATE, new Object[0]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onPlayerDeadByMonster(WNPlayer deadplayer, AreaEvent.MonsterData monsterData, float playerX, float playerY) {
/* 198 */     if (deadplayer == null) {
/*     */       return;
/*     */     }
/*     */     
/* 202 */     if (this.firstPlayerId.equals(deadplayer.getId()) && deadplayer.arenaManager.getScore() > 0) {
/* 203 */       String tips = LangService.format("ARENA_FIRST_KILLED", new Object[] { deadplayer.getName() });
/* 204 */       for (String tempPlayerId : this.actors.keySet()) {
/* 205 */         WNPlayer tempPlayer = PlayerUtil.getOnlinePlayer(tempPlayerId);
/* 206 */         if (tempPlayer != null) {
/* 207 */           MessageUtil.sendSysTip(tempPlayer, tips, Const.TipsType.ROLL);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 212 */     int score = deadplayer.arenaManager.getScore();
/* 213 */     score = (int)Math.ceil(score * 60.0D / 100.0D);
/* 214 */     deadplayer.arenaManager.dropPlayerScore(null, playerX, playerY, score);
/* 215 */     refreshPlayerRank(deadplayer);
/*     */     
/* 217 */     int overTime = GlobalConfig.JJC_RebirthTime;
/* 218 */     if (deadplayer != null) {
/*     */       
/* 220 */       PlayerHandler.PlayerRelivePush.Builder data = newPlayerRelivePush(deadplayer, false);
/* 221 */       data.setCountDown(overTime);
/*     */       
/* 223 */       WNNotifyManager.getInstance().pushRelive(deadplayer, data.build());
/*     */     } 
/*     */     
/* 226 */     Area.Actor playerData = (Area.Actor)this.actors.get(deadplayer.getId());
/* 227 */     if (playerData == null) {
/* 228 */       Out.error(new Object[] { getClass(), "onPlayerDeadByPlayer not exist! :", deadplayer.getId() });
/*     */       
/*     */       return;
/*     */     } 
/* 232 */     pushArenaBattleInfo((WNPlayer)null);
/*     */   }
/*     */ 
/*     */   
/*     */   public void onPlayerDeadByPlayer(WNPlayer deadplayer, WNPlayer hitPlayer, float x, float y) {
/* 237 */     if (deadplayer == null || hitPlayer == null) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 242 */     if (this.firstPlayerId.equals(deadplayer.getId()) && deadplayer.arenaManager.getScore() > 0) {
/* 243 */       String tips = LangService.format("ARENA_FIRST_KILLED", new Object[] { deadplayer.getName() });
/* 244 */       for (String tempPlayerId : this.actors.keySet()) {
/* 245 */         WNPlayer tempPlayer = PlayerUtil.getOnlinePlayer(tempPlayerId);
/* 246 */         if (tempPlayer != null) {
/* 247 */           MessageUtil.sendSysTip(tempPlayer, tips, Const.TipsType.ROLL);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 252 */     int score = deadplayer.arenaManager.getScore();
/* 253 */     score = (int)Math.ceil(score * 60.0D / 100.0D);
/* 254 */     deadplayer.arenaManager.dropPlayerScore(hitPlayer, x, y, score);
/*     */     
/* 256 */     Area.Actor deadActor = (Area.Actor)this.actors.get(deadplayer.getId());
/* 257 */     hitPlayer.arenaManager.killPlayer(deadplayer, deadActor, this.rank.size());
/*     */     
/* 259 */     refreshPlayerRank(deadplayer);
/* 260 */     refreshPlayerRank(hitPlayer);
/*     */     
/* 262 */     int overTime = GlobalConfig.JJC_RebirthTime;
/* 263 */     if (deadplayer != null) {
/*     */       
/* 265 */       PlayerHandler.PlayerRelivePush.Builder data = newPlayerRelivePush(deadplayer, false);
/* 266 */       data.setCountDown(overTime);
/*     */       
/* 268 */       WNNotifyManager.getInstance().pushRelive(deadplayer, data.build());
/*     */     } 
/*     */     
/* 271 */     Area.Actor playerData = (Area.Actor)this.actors.get(deadplayer.getId());
/* 272 */     if (playerData == null) {
/* 273 */       Out.error(new Object[] { getClass(), "onPlayerDeadByPlayer not exist! :", deadplayer.getId() });
/*     */       
/*     */       return;
/*     */     } 
/* 277 */     pushArenaBattleInfo((WNPlayer)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean onCleanItem(Area.AreaItem areaItem) {
/* 288 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Area.AreaItem onPickItem(String playerId, String itemId, boolean isGuard) {
/* 299 */     WNPlayer player = getPlayer(playerId);
/* 300 */     if (player == null) {
/* 301 */       return null;
/*     */     }
/* 303 */     Out.debug(new Object[] { getClass(), player.getName(), " fightLevel onPickItem itemId:", itemId, ",isGuard:", Boolean.valueOf(isGuard) });
/* 304 */     Area.AreaItem itemInfo = (Area.AreaItem)this.items.get(itemId);
/* 305 */     if (itemInfo != null) {
/* 306 */       int groupCount = itemInfo.item.itemDb.groupCount;
/* 307 */       player.arenaManager.addScore(groupCount);
/* 308 */       refreshPlayerRank(player);
/* 309 */       this.items.remove(itemId);
/*     */     } 
/* 311 */     pushArenaBattleInfo((WNPlayer)null);
/* 312 */     return itemInfo;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isFull() {
/* 321 */     if (super.isFull()) {
/* 322 */       return true;
/*     */     }
/* 324 */     return (this.rank.size() >= this.fullCount);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isFull(int addCount) {
/* 333 */     if (super.isFull(addCount)) {
/* 334 */       return true;
/*     */     }
/* 336 */     return (this.rank.size() + addCount > this.fullCount);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void pushArenaBattleEnd(WNPlayer player) {
/* 345 */     if (player == null)
/*     */       return; 
/* 347 */     ArenaHandler.OnArenaBattleEndPush.Builder res = ArenaHandler.OnArenaBattleEndPush.newBuilder();
/* 348 */     res.setS2CCode(200);
/* 349 */     res.setOuttime(((GameMapCO)GameData.GameMaps.get(Integer.valueOf(70002))).timeCount);
/* 350 */     player.receive("area.arenaPush.onArenaBattleEndPush", (GeneratedMessage)res.build());
/*     */   }
/*     */ 
/*     */   
/*     */   public void onGameOver(JSONObject msg) {
/* 355 */     List<ArenaHandler.ArenaBattleScore> listRank = getAllScores();
/*     */     
/* 357 */     for (int i = 0; i < listRank.size(); i++) {
/* 358 */       ArenaHandler.ArenaBattleScore info = listRank.get(i);
/* 359 */       WNPlayer player = getPlayer(info.getId());
/* 360 */       if (player != null) {
/* 361 */         player.arenaManager.onAreaClose(i + 1);
/* 362 */         if (player.getInstanceId().equals(this.instanceId)) {
/* 363 */           pushArenaBattleEnd(player);
/*     */           
/* 365 */           getXmdsManager().revivePlayer(player.getId(), reliveData(Area.ReliveType.PLACE));
/*     */         } 
/*     */         
/* 368 */         player.getXmdsManager().refreshPlayerPKMode(player.getId(), player.pkRuleManager.pkData.pkModel);
/*     */       } else {
/* 370 */         Out.error(new Object[] { "can't find player error in arenaArea!!!" });
/*     */       } 
/*     */ 
/*     */       
/* 374 */       player.achievementManager.onArenaBattle();
/*     */     } 
/* 376 */     Out.debug(new Object[] { "ArenaArea onGameOver-----" });
/*     */   }
/*     */   
/*     */   public Area.ReliveType getReliveType() {
/* 380 */     return Area.ReliveType.RANDOM;
/*     */   }
/*     */   
/*     */   public void onEndEnterScene(WNPlayer player) {
/* 384 */     super.onEndEnterScene(player);
/* 385 */     pushArenaBattleInfo(player);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onPlayerLogout(WNPlayer player) {
/* 391 */     boolean keepObject = isKeepObject();
/* 392 */     if (keepObject && !isClose()) {
/*     */       
/* 394 */       player.getXmdsManager().playerReady(player.getId());
/*     */       
/* 396 */       onPlayerAutoBattle(player, true);
/*     */     } 
/*     */     
/* 399 */     Area.Actor actor = getActor(player.getId());
/* 400 */     if (actor != null && !actor.alive && !PlayerUtil.isOnline(player.getId())) {
/* 401 */       JobFactory.addDelayJob(() -> { if (!actor.alive) relive(player.getId(), getReliveType());  }(GlobalConfig.JJC_RebirthTime * 1000));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onPlayerLeaved(WNPlayer player) {
/* 412 */     refreshPlayerRank(player);
/* 413 */     pushArenaBattleInfo(player);
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\arena\ArenaArea.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */