/*     */ package com.wanniu.game.solo;
/*     */ 
/*     */ import com.alibaba.fastjson.JSONObject;
/*     */ import com.wanniu.core.game.JobFactory;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.game.area.Area;
/*     */ import com.wanniu.game.area.AreaManager;
/*     */ import com.wanniu.game.area.MonsterUnit;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.data.SoloMonsterCO;
/*     */ import com.wanniu.game.player.GlobalConfig;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.sevengoal.SevenGoalManager;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SoloArea
/*     */   extends Area
/*     */ {
/*  25 */   public static int clearSeconds = 400;
/*     */   
/*     */   private boolean isGameOver = false;
/*     */   
/*     */   public SoloArea(JSONObject opts) {
/*  30 */     super(opts);
/*     */     
/*  32 */     JobFactory.addDelayJob(() -> { Out.info(new Object[] { "问道玩法清场.", this.instanceId }, ); AreaManager.getInstance().closeArea(this.instanceId); }clearSeconds, TimeUnit.SECONDS);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addRobot(SoloMonsterCO soloProp) {
/*  39 */     String startPoint = String.valueOf(soloProp.startPoint);
/*     */     
/*  41 */     MonsterUnit monsterData = new MonsterUnit();
/*  42 */     monsterData.id = soloProp.monID;
/*  43 */     monsterData.force = Const.AreaForce.FORCEB.value;
/*  44 */     monsterData.flag = startPoint;
/*  45 */     monsterData.autoGuard = true;
/*  46 */     List<MonsterUnit> monsters = new ArrayList<>();
/*  47 */     monsters.add(monsterData);
/*  48 */     addUnitsToArea(monsters);
/*     */   }
/*     */   
/*     */   public String toJSON4EnterScene(WNPlayer player) {
/*  52 */     JSONObject json = player.toJSON4EnterScene(this);
/*     */     
/*  54 */     Map<String, Number> tempData = (Map<String, Number>)json.get("tempData");
/*  55 */     tempData.put("x", Integer.valueOf(0));
/*  56 */     tempData.put("y", Integer.valueOf(0));
/*  57 */     return json.toJSONString();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setForce(WNPlayer player) {}
/*     */ 
/*     */   
/*     */   private static class SoloResult
/*     */   {
/*     */     public String playerId;
/*     */     
/*     */     public int result;
/*     */ 
/*     */     
/*     */     public SoloResult(String playerId, int result) {
/*  72 */       this.playerId = playerId;
/*  73 */       this.result = result;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onPlayerEntered(WNPlayer player) {
/*  81 */     super.onPlayerEntered(player);
/*  82 */     player.sevenGoalManager.processGoal(SevenGoalManager.SevenGoalTaskType.SOLO_ANTICIPATE, new Object[0]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onGameOver(JSONObject msg) {
/*  89 */     if (this.isGameOver) {
/*     */       return;
/*     */     }
/*  92 */     Out.info(new Object[] { "soloArea gameover,instanceId=", this.instanceId });
/*  93 */     int winForce = msg.getIntValue("winForce");
/*  94 */     List<SoloResult> playerDatas = new ArrayList<>();
/*     */     
/*  96 */     int winScore = 0, failScore = 0;
/*  97 */     for (String playerId : this.actors.keySet()) {
/*  98 */       WNPlayer player = getPlayer(playerId);
/*  99 */       if (winForce == 0) {
/* 100 */         playerDatas.add(new SoloResult(playerId, 3)); continue;
/* 101 */       }  if (player.getForce() == winForce) {
/* 102 */         playerDatas.add(new SoloResult(playerId, 1));
/* 103 */         winScore = player.soloManager.getScore(); continue;
/*     */       } 
/* 105 */       playerDatas.add(new SoloResult(playerId, 2));
/* 106 */       failScore = player.soloManager.getScore();
/*     */     } 
/*     */ 
/*     */     
/* 110 */     int addScore = 0;
/* 111 */     int subScore = 0;
/* 112 */     if (winForce != 0) {
/* 113 */       addScore = calcWinnerScore(winScore, failScore);
/* 114 */       subScore = calcLoserScore(winScore, failScore);
/*     */     } 
/*     */     
/* 117 */     for (String playerId : this.actors.keySet()) {
/* 118 */       WNPlayer player = getPlayer(playerId);
/* 119 */       if (player != null) {
/*     */         
/* 121 */         if (playerDatas.size() == 2) {
/* 122 */           if (playerId == ((SoloResult)playerDatas.get(0)).playerId) {
/* 123 */             player.soloManager.onGameEnd(((SoloResult)playerDatas.get(0)).result, getPlayer(((SoloResult)playerDatas.get(1)).playerId), addScore, subScore); continue;
/*     */           } 
/* 125 */           player.soloManager.onGameEnd(((SoloResult)playerDatas.get(1)).result, getPlayer(((SoloResult)playerDatas.get(0)).playerId), addScore, subScore);
/*     */           continue;
/*     */         } 
/* 128 */         player.soloManager.onGameEnd(((SoloResult)playerDatas.get(0)).result, null, addScore, subScore);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 134 */     this.isGameOver = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int calcScoreVariable(int winnerScore, int loserScore) {
/* 145 */     int base = GlobalConfig.Solo_WinGetPoint;
/* 146 */     int diff = winnerScore - loserScore;
/* 147 */     int floatValue = diff / 20;
/*     */     
/* 149 */     floatValue = Math.min(Math.max(-base, floatValue), base);
/* 150 */     return base - floatValue;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int calcWinnerScore(int winnerScore, int loserScore) {
/* 160 */     return calcScoreVariable(winnerScore, loserScore) + 1;
/*     */   }
/*     */ 
/*     */   
/* 164 */   private static int TOP_RANKSCORE = 1000;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int calcLoserScore(int winnerScore, int loserScore) {
/* 172 */     if (loserScore < TOP_RANKSCORE) {
/* 173 */       return 1;
/*     */     }
/* 175 */     return -calcScoreVariable(winnerScore, loserScore);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void onDisponseLeave(WNPlayer player) {
/* 181 */     player.soloManager.handleLeaveSoloArea();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onPlayerDeadByPlayer(WNPlayer deadplayer, WNPlayer hitPlayer, float x, float y) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void onPlayerLogout(WNPlayer player) {
/* 191 */     boolean keepObject = isKeepObject();
/* 192 */     if (keepObject && !isClose()) {
/*     */       
/* 194 */       player.getXmdsManager().playerReady(player.getId());
/*     */       
/* 196 */       onPlayerAutoBattle(player, true);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\solo\SoloArea.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */