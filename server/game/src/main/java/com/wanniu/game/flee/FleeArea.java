/*     */ package com.wanniu.game.flee;
/*     */ 
/*     */ import com.alibaba.fastjson.JSONObject;
/*     */ import com.google.protobuf.GeneratedMessage;
/*     */ import com.wanniu.game.area.Area;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.data.GameData;
/*     */ import com.wanniu.game.data.GameMapCO;
/*     */ import com.wanniu.game.player.GlobalConfig;
/*     */ import com.wanniu.game.player.PlayerUtil;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import pomelo.area.FleeHandler;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FleeArea
/*     */   extends Area
/*     */ {
/*  29 */   private ConcurrentHashMap<String, FleePlayer> playerMap = new ConcurrentHashMap<>();
/*     */   
/*     */   public FleeArea(JSONObject opts) {
/*  32 */     super(opts);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setForce(WNPlayer player) {
/*  37 */     FleePlayer fleePlayer = this.playerMap.get(player.getId());
/*  38 */     if (fleePlayer != null) {
/*  39 */       player.setForce(fleePlayer.force);
/*     */     } else {
/*  41 */       player.setForce(this.playerMap.size() + 1);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void onPlayerEntered(WNPlayer player) {
/*  47 */     FleePlayer fleePlayer = this.playerMap.get(player.getId());
/*  48 */     if (fleePlayer == null) {
/*  49 */       fleePlayer = new FleePlayer(player.getId(), player.getName(), player.getLevel(), player.getPro(), player.getForce(), this.playerMap.size() + 1);
/*  50 */       this.playerMap.put(fleePlayer.playerId, fleePlayer);
/*     */     } 
/*  52 */     player.getXmdsManager().refreshPlayerPKMode(player.getId(), Const.PkModel.All.value);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onPlayerDeadByPlayer(WNPlayer deadplayer, WNPlayer hitPlayer, float x, float y) {
/*  58 */     if (deadplayer == null || hitPlayer == null) {
/*     */       return;
/*     */     }
/*  61 */     ((FleePlayer)this.playerMap.get(hitPlayer.getId())).killCount++;
/*  62 */     FleePlayer deathPlayer = this.playerMap.get(deadplayer.getId());
/*  63 */     deathPlayer.rank = getAliveNum() + 1;
/*  64 */     deathPlayer.isDeath = true;
/*     */     
/*  66 */     int scoreChange = deadplayer.fleeManager.onGameOver(deathPlayer.rank);
/*     */     
/*  68 */     pushFleeDeath(deadplayer, deathPlayer.rank, scoreChange);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int getAliveNum() {
/*  77 */     int num = 0;
/*  78 */     for (Area.Actor a : this.actors.values()) {
/*  79 */       if (a.alive) {
/*  80 */         num++;
/*     */       }
/*     */     } 
/*  83 */     return num;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void pushFleeDeath(WNPlayer player, int rank, int scoreChange) {
/*  92 */     FleeHandler.OnFleeDeathPush.Builder res = FleeHandler.OnFleeDeathPush.newBuilder();
/*  93 */     res.setS2CCode(200);
/*  94 */     res.setOuttime(((GameMapCO)GameData.GameMaps.get(Integer.valueOf(GlobalConfig.Flee_MapID))).timeCount);
/*  95 */     res.setRank(rank);
/*  96 */     res.setScoreChange(scoreChange);
/*  97 */     player.receive("area.fleePush.onFleeDeathPush", (GeneratedMessage)res.build());
/*     */   }
/*     */ 
/*     */   
/*     */   public void onGameOver(JSONObject msg) {
/* 102 */     FleeHandler.OnFleeEndPush.Builder push = FleeHandler.OnFleeEndPush.newBuilder();
/* 103 */     push.setS2CCode(200);
/* 104 */     push.setOuttime(((GameMapCO)GameData.GameMaps.get(Integer.valueOf(GlobalConfig.Flee_MapID))).timeCount);
/* 105 */     List<FleePlayer> list = new ArrayList<>(this.playerMap.values());
/* 106 */     List<FleePlayer> notDeathList = new ArrayList<>();
/* 107 */     for (FleePlayer p : list) {
/* 108 */       if (!p.isDeath) {
/* 109 */         notDeathList.add(p);
/*     */       }
/*     */     } 
/* 112 */     list.removeAll(notDeathList);
/* 113 */     Collections.sort(notDeathList, (o1, o2) -> o1.force - o2.force);
/*     */ 
/*     */     
/* 116 */     for (int i = 0; i < notDeathList.size(); i++) {
/* 117 */       WNPlayer player = PlayerUtil.getOnlinePlayer(((FleePlayer)notDeathList.get(i)).playerId);
/* 118 */       player.fleeManager.onGameOver(i + 1);
/*     */     } 
/*     */     
/* 121 */     notDeathList.addAll(list);
/*     */     
/* 123 */     for (FleePlayer p : notDeathList) {
/* 124 */       FleeHandler.FleeMatchMemberInfo.Builder mem = FleeHandler.FleeMatchMemberInfo.newBuilder();
/* 125 */       mem.setPlayerId(p.playerId);
/* 126 */       mem.setPlayerName(p.playerName);
/* 127 */       mem.setPlayerLvl(p.playerLevel);
/* 128 */       mem.setPlayerPro(p.playerPro);
/* 129 */       mem.setKillCount(p.killCount);
/* 130 */       mem.setScoreChange(p.scoreChange);
/* 131 */       push.addRanks(mem);
/*     */     } 
/* 133 */     for (String id : this.actors.keySet()) {
/* 134 */       WNPlayer player = PlayerUtil.getOnlinePlayer(id);
/* 135 */       player.receive("area.fleePush.onFleeEndPush", (GeneratedMessage)push.build());
/*     */     } 
/*     */   }
/*     */   
/*     */   public Area.ReliveType getReliveType() {
/* 140 */     return Area.ReliveType.RANDOM;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onPlayerLogout(WNPlayer player) {
/* 146 */     boolean keepObject = isKeepObject();
/* 147 */     if (keepObject && !isClose()) {
/*     */       
/* 149 */       player.getXmdsManager().playerReady(player.getId());
/*     */       
/* 151 */       onPlayerAutoBattle(player, true);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\flee\FleeArea.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */