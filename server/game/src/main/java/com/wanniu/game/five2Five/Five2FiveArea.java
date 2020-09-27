/*     */ package com.wanniu.game.five2Five;
/*     */ 
/*     */ import com.alibaba.fastjson.JSON;
/*     */ import com.alibaba.fastjson.JSONObject;
/*     */ import com.wanniu.core.game.JobFactory;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.game.GWorld;
/*     */ import com.wanniu.game.area.Area;
/*     */ import com.wanniu.game.common.msg.WNNotifyManager;
/*     */ import com.wanniu.game.player.GlobalConfig;
/*     */ import com.wanniu.game.player.PlayerUtil;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.sevengoal.SevenGoalManager;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.UUID;
/*     */ import java.util.concurrent.CopyOnWriteArrayList;
/*     */ import pomelo.area.PlayerHandler;
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
/*     */ public class Five2FiveArea
/*     */   extends Area
/*     */ {
/*     */   private CopyOnWriteArrayList<Five2FiveTempTeamMember> tempTeamMemsA;
/*     */   private CopyOnWriteArrayList<Five2FiveTempTeamMember> tempTeamMemsB;
/*     */   
/*     */   public Five2FiveArea(JSONObject opts) {
/*  41 */     super(opts);
/*  42 */     this.tempTeamMemsA = (CopyOnWriteArrayList<Five2FiveTempTeamMember>)opts.get("tempTeamMemsA");
/*  43 */     this.tempTeamMemsB = (CopyOnWriteArrayList<Five2FiveTempTeamMember>)opts.get("tempTeamMemsB");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setForce(WNPlayer player) {
/*  53 */     for (Five2FiveTempTeamMember tempTeamMem : this.tempTeamMemsA) {
/*  54 */       if (player.getId().equals(tempTeamMem.playerId)) {
/*  55 */         player.setForce(tempTeamMem.force);
/*     */         return;
/*     */       } 
/*     */     } 
/*  59 */     for (Five2FiveTempTeamMember tempTeamMem : this.tempTeamMemsB) {
/*  60 */       if (player.getId().equals(tempTeamMem.playerId)) {
/*  61 */         player.setForce(tempTeamMem.force);
/*     */         return;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addPlayer(WNPlayer player) {
/*  71 */     setForce(player);
/*  72 */     player.setArea(this);
/*  73 */     String enterSceneData = toJSON4EnterScene(player);
/*  74 */     JSONObject jsonObject = JSONObject.parseObject(enterSceneData);
/*     */     
/*  76 */     Map<String, Number> effects = (Map<String, Number>)jsonObject.get("effects");
/*  77 */     int index = 1;
/*  78 */     boolean isFinded = false;
/*  79 */     for (Five2FiveTempTeamMember member : this.tempTeamMemsA) {
/*  80 */       if (member.playerId.equals(player.getId())) {
/*  81 */         index = member.index;
/*  82 */         isFinded = true;
/*     */         break;
/*     */       } 
/*     */     } 
/*  86 */     if (!isFinded) {
/*  87 */       for (Five2FiveTempTeamMember member : this.tempTeamMemsB) {
/*  88 */         if (member.playerId.equals(player.getId())) {
/*  89 */           index = member.index;
/*     */         }
/*     */       } 
/*     */     }
/*  93 */     effects.put("index", Integer.valueOf(index));
/*  94 */     jsonObject.put("indexOut", Integer.valueOf(index));
/*  95 */     enterSceneData = JSONObject.toJSONString(jsonObject);
/*  96 */     Out.debug(new Object[] { "begin enter scene id:", this.instanceId });
/*     */     try {
/*  98 */       String playerId = player.getId();
/*     */       
/* 100 */       if (!this.actors.containsKey(playerId)) {
/* 101 */         this.hasPlayerEntered = true;
/* 102 */         this.actors.put(playerId, new Area.Actor());
/*     */       } 
/* 104 */       removeCloseFuture();
/* 105 */       Out.debug(new Object[] { "enter scene id: ", this.instanceId, " ok", "index:", Integer.valueOf(this.lineIndex) });
/* 106 */     } catch (Exception error) {
/* 107 */       Out.error(new Object[] { "c# enter scene id: ", this.instanceId, " error : ", error, " enterSceneData:", enterSceneData });
/* 108 */       throw error;
/*     */     } 
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
/*     */   public void onPlayerDeadByPlayer(WNPlayer deadPlayer, WNPlayer hitPlayer, float x, float y) {
/* 122 */     int overTime = GlobalConfig.Group_Resurrection;
/* 123 */     if (deadPlayer != null) {
/*     */       
/* 125 */       PlayerHandler.PlayerRelivePush.Builder data = newPlayerRelivePush(deadPlayer, false);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 134 */       data.setCountDown(overTime);
/* 135 */       data.setCbType(Area.ReliveCB.RELIVE.value);
/*     */       
/* 137 */       WNNotifyManager.getInstance().pushRelive(deadPlayer, data.build());
/*     */     } 
/*     */     
/* 140 */     Area.Actor playerData = (Area.Actor)this.actors.get(deadPlayer.getId());
/* 141 */     if (playerData == null) {
/* 142 */       Out.error(new Object[] { getClass(), "onPlayerDeadByPlayer not exist! :", deadPlayer.getId() });
/*     */       return;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onGameOver(JSONObject event) {
/* 155 */     Out.debug(new Object[] { "5v5 gameover" });
/* 156 */     int winForce = event.getIntValue("winForce");
/* 157 */     List<Five2FiveTempTeamMember> tempTeamMems = new ArrayList<>();
/* 158 */     tempTeamMems.addAll(this.tempTeamMemsA);
/* 159 */     tempTeamMems.addAll(this.tempTeamMemsB);
/*     */     
/* 161 */     String statistice = getXmdsManager().getInstanceStatistic(this.instanceId);
/* 162 */     JSONObject statisticeJson = JSON.parseObject(statistice);
/* 163 */     Map<String, int[]> everyStatistieces = (Map)new HashMap<>();
/* 164 */     for (Five2FiveTempTeamMember tempTeamMem : tempTeamMems) {
/* 165 */       String tempTeamMemPlayerId = tempTeamMem.playerId;
/* 166 */       Map<String, Integer> everyStatice = (Map<String, Integer>)statisticeJson.get(tempTeamMemPlayerId);
/* 167 */       int[] everyStatistiece = new int[4];
/* 168 */       if (everyStatice != null) {
/* 169 */         everyStatistiece[0] = ((Integer)everyStatice.get("killPlayerCount")).intValue();
/* 170 */         everyStatistiece[1] = ((Integer)everyStatice.get("totalDamage")).intValue();
/* 171 */         everyStatistiece[2] = ((Integer)everyStatice.get("totalHealing")).intValue();
/* 172 */         Integer deadCount = everyStatice.get("deadCount");
/* 173 */         everyStatistiece[3] = (deadCount == null) ? 0 : deadCount.intValue();
/*     */       } 
/* 175 */       everyStatistieces.put(tempTeamMemPlayerId, everyStatistiece);
/*     */     } 
/*     */     
/* 178 */     int maxMvpValue = 0;
/* 179 */     String mvpPlayerId = "";
/* 180 */     Map<String, Integer> killCounts = new HashMap<>();
/* 181 */     Map<String, Integer> hurts = new HashMap<>();
/* 182 */     Map<String, Integer> treatMents = new HashMap<>();
/* 183 */     Map<String, Integer> deadCounts = new HashMap<>();
/* 184 */     for (Five2FiveTempTeamMember tempTeamMem : tempTeamMems) {
/* 185 */       String tempTeamPlayerId = tempTeamMem.playerId;
/* 186 */       int[] everyStatistiece = everyStatistieces.get(tempTeamPlayerId);
/* 187 */       int killCount = everyStatistiece[0];
/* 188 */       int hurt = everyStatistiece[1];
/* 189 */       int treatMent = everyStatistiece[2];
/* 190 */       int deadCount = everyStatistiece[3];
/*     */       
/* 192 */       if (tempTeamMem.force == winForce) {
/* 193 */         int mvpValue = killCount * GlobalConfig.Group_Kill + hurt * GlobalConfig.Group_Dps + treatMent * GlobalConfig.Group_Treatment;
/* 194 */         if (mvpValue > maxMvpValue) {
/* 195 */           maxMvpValue = mvpValue;
/* 196 */           mvpPlayerId = tempTeamPlayerId;
/*     */         } 
/*     */       } 
/* 199 */       killCounts.put(tempTeamPlayerId, Integer.valueOf(killCount));
/* 200 */       hurts.put(tempTeamPlayerId, Integer.valueOf(hurt));
/* 201 */       treatMents.put(tempTeamPlayerId, Integer.valueOf(treatMent));
/* 202 */       deadCounts.put(tempTeamPlayerId, Integer.valueOf(deadCount));
/*     */     } 
/*     */     
/* 205 */     Map<String, Five2FivePlayerResultInfoVo> playerResultInfosA = new HashMap<>();
/* 206 */     for (Five2FiveTempTeamMember tempTeamMem : this.tempTeamMemsA) {
/* 207 */       String tempTeamPlayerId = tempTeamMem.playerId;
/* 208 */       int killCount = ((Integer)killCounts.get(tempTeamPlayerId)).intValue();
/* 209 */       int hurt = ((Integer)hurts.get(tempTeamPlayerId)).intValue();
/* 210 */       int treatMent = ((Integer)treatMents.get(tempTeamPlayerId)).intValue();
/* 211 */       boolean isMvp = false;
/* 212 */       if (mvpPlayerId.equals(tempTeamPlayerId)) {
/* 213 */         isMvp = true;
/*     */       }
/* 215 */       processPlayerResultInfo(tempTeamPlayerId, killCount, hurt, treatMent, isMvp, ((Integer)deadCounts.get(tempTeamPlayerId)).intValue(), playerResultInfosA);
/*     */     } 
/*     */     
/* 218 */     Map<String, Five2FivePlayerResultInfoVo> playerResultInfosB = new HashMap<>();
/* 219 */     for (Five2FiveTempTeamMember tempTeamMem : this.tempTeamMemsB) {
/* 220 */       String tempTeamPlayerId = tempTeamMem.playerId;
/* 221 */       int killCount = ((Integer)killCounts.get(tempTeamPlayerId)).intValue();
/* 222 */       int hurt = ((Integer)hurts.get(tempTeamPlayerId)).intValue();
/* 223 */       int treatMent = ((Integer)treatMents.get(tempTeamPlayerId)).intValue();
/* 224 */       boolean isMvp = false;
/* 225 */       if (mvpPlayerId.equals(tempTeamPlayerId)) {
/* 226 */         isMvp = true;
/*     */       }
/* 228 */       processPlayerResultInfo(tempTeamPlayerId, killCount, hurt, treatMent, isMvp, ((Integer)deadCounts.get(tempTeamPlayerId)).intValue(), playerResultInfosB);
/* 229 */       if (playerResultInfosA.containsKey(tempTeamPlayerId)) {
/* 230 */         Out.warn(new Object[] { "5v5 Area:" + this.instanceId + " player [" + tempTeamPlayerId + "] duplicate" });
/*     */       }
/*     */     } 
/*     */     
/* 234 */     String resultInstanceId = UUID.randomUUID().toString();
/* 235 */     onBothSidesGameOver(everyStatistieces, resultInstanceId, mvpPlayerId, winForce, this.tempTeamMemsA, playerResultInfosA, playerResultInfosB);
/* 236 */     onBothSidesGameOver(everyStatistieces, resultInstanceId, mvpPlayerId, winForce, this.tempTeamMemsB, playerResultInfosA, playerResultInfosB);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void onDisponseLeave(WNPlayer player) {
/* 242 */     player.five2FiveManager.leaveFive2FiveArea();
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
/*     */   private void onBothSidesGameOver(Map<String, int[]> everyStatistieces, String resultInstanceId, String mvpPlayerId, int winForce, CopyOnWriteArrayList<Five2FiveTempTeamMember> tempTeamMems, Map<String, Five2FivePlayerResultInfoVo> resultInfosA, Map<String, Five2FivePlayerResultInfoVo> resultInfosB) {
/* 258 */     for (Five2FiveTempTeamMember tempTeamMem : tempTeamMems) {
/* 259 */       String tempTeamPlayerId = tempTeamMem.playerId;
/* 260 */       WNPlayer tempTeamPlayer = getPlayer(tempTeamPlayerId);
/* 261 */       if (tempTeamPlayer == null) {
/* 262 */         tempTeamPlayer = (WNPlayer)GWorld.getInstance().getWaitPlayers().get(tempTeamPlayerId);
/*     */       }
/* 264 */       int[] everyStatistiece = everyStatistieces.get(tempTeamPlayerId);
/* 265 */       int killCount = 0;
/* 266 */       int hurt = 0;
/* 267 */       int treatMent = 0;
/* 268 */       if (everyStatistiece != null) {
/* 269 */         killCount = everyStatistiece[0];
/* 270 */         hurt = everyStatistiece[1];
/* 271 */         treatMent = everyStatistiece[2];
/*     */       } 
/* 273 */       int result = 0;
/* 274 */       int scoreChange = 0;
/* 275 */       if (winForce == 0) {
/* 276 */         result = Five2FiveService.Five2FiveResult.TIE.ordinal();
/* 277 */         scoreChange = 0;
/* 278 */       } else if (tempTeamMem.force == winForce) {
/* 279 */         result = Five2FiveService.Five2FiveResult.WIN.ordinal();
/* 280 */         scoreChange = GlobalConfig.Group_Integral;
/*     */       } else {
/* 282 */         result = Five2FiveService.Five2FiveResult.FAIL.ordinal();
/* 283 */         scoreChange = -GlobalConfig.Group_Lose;
/*     */       } 
/* 285 */       boolean isMvp = false;
/* 286 */       if (tempTeamPlayerId.equals(mvpPlayerId)) {
/* 287 */         isMvp = true;
/*     */       }
/* 289 */       tempTeamPlayer.five2FiveManager.onGameEnd(resultInstanceId, result, killCount, hurt, treatMent, scoreChange, isMvp, resultInfosA, resultInfosB);
/*     */     } 
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
/*     */   private void processPlayerResultInfo(String tempTeamPlayerId, int killCount, int hurt, int treatMent, boolean isMvp, int deadCount, Map<String, Five2FivePlayerResultInfoVo> resultInfos) {
/* 304 */     Five2FivePlayerResultInfoVo resultInfoVo = new Five2FivePlayerResultInfoVo();
/* 305 */     WNPlayer tempPlayer = PlayerUtil.getOnlinePlayer(tempTeamPlayerId);
/* 306 */     if (tempPlayer == null) {
/* 307 */       tempPlayer = (WNPlayer)GWorld.getInstance().getWaitPlayers().get(tempTeamPlayerId);
/*     */     }
/* 309 */     resultInfoVo = new Five2FivePlayerResultInfoVo(tempPlayer.getId(), tempPlayer.getName(), tempPlayer.getLevel(), tempPlayer.getPro(), killCount, hurt, treatMent, isMvp ? 1 : 0, deadCount);
/* 310 */     resultInfos.put(tempTeamPlayerId, resultInfoVo);
/*     */     
/* 312 */     tempPlayer.achievementManager.onPassFiveVsFive();
/*     */   }
/*     */ 
/*     */   
/*     */   public void onPlayerLogout(WNPlayer player) {
/* 317 */     boolean keepObject = isKeepObject();
/* 318 */     if (keepObject && !isClose()) {
/*     */       
/* 320 */       player.getXmdsManager().playerReady(player.getId());
/*     */       
/* 322 */       onPlayerAutoBattle(player, true);
/*     */     } 
/*     */     
/* 325 */     Area.Actor actor = getActor(player.getId());
/* 326 */     if (actor != null && !actor.alive && !PlayerUtil.isOnline(player.getId())) {
/* 327 */       JobFactory.addDelayJob(() -> { if (!actor.alive) relive(player.getId(), getReliveType());  }(GlobalConfig.Group_Resurrection * 1000));
/*     */     }
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
/*     */   public void onPlayerEntered(WNPlayer player) {
/* 340 */     super.onPlayerEntered(player);
/* 341 */     player.sevenGoalManager.processGoal(SevenGoalManager.SevenGoalTaskType.TRIAL_ANTICIPATE, new Object[0]);
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\five2Five\Five2FiveArea.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */