/*     */ package com.wanniu.game.solo;
/*     */ 
/*     */ import com.google.protobuf.GeneratedMessage;
/*     */ import com.wanniu.core.game.JobFactory;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.game.GWorld;
/*     */ import com.wanniu.game.area.Area;
/*     */ import com.wanniu.game.area.AreaData;
/*     */ import com.wanniu.game.area.AreaUtil;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.Utils;
/*     */ import com.wanniu.game.player.GlobalConfig;
/*     */ import com.wanniu.game.player.PlayerUtil;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.solo.vo.MatcherVO;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import java.util.concurrent.CopyOnWriteArrayList;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import pomelo.Common;
/*     */ import pomelo.area.SoloHandler;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SoloMatcher
/*     */ {
/*     */   public long sumMatchingTime;
/*     */   public int matchedNumber;
/*  34 */   private Map<String, MatcherVO> matchers = new ConcurrentHashMap<>();
/*  35 */   private static List<MatchedTeam> matchedQueue = new CopyOnWriteArrayList<>();
/*     */   private static SoloMatcher soloService;
/*     */   
/*     */   public static SoloMatcher getInstance() {
/*  39 */     if (soloService == null) {
/*  40 */       soloService = new SoloMatcher();
/*     */     }
/*  42 */     return soloService;
/*     */   }
/*     */   
/*     */   private SoloMatcher() {
/*  46 */     init();
/*     */   }
/*     */   
/*     */   private void init() {
/*  50 */     this.sumMatchingTime = 0L;
/*  51 */     this.matchedNumber = 0;
/*     */     
/*  53 */     JobFactory.addScheduleJob(new Runnable()
/*     */         {
/*     */           public void run() {
/*  56 */             if (SoloService.getInstance().isInOpenTime()) {
/*  57 */               SoloMatcher.this.checkMatchers();
/*     */             }
/*     */           }
/*     */         },  GlobalConfig.Solo_MatchWaitTime, GlobalConfig.Solo_MatchWaitTime, TimeUnit.SECONDS);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void checkMatchers() {
/*  68 */     synchronized (this.matchers) {
/*  69 */       Iterator<MatcherVO> iter = this.matchers.values().iterator();
/*  70 */       while (iter.hasNext()) {
/*  71 */         MatcherVO mpo = iter.next();
/*  72 */         if (mpo.isOnline()) {
/*  73 */           if (mpo.getBeginTime() >= GlobalConfig.Solo_MatchWaitTime)
/*  74 */             mpo.increaseScoreRange(); 
/*     */           continue;
/*     */         } 
/*  77 */         if (mpo.getOfflinedTime() >= GlobalConfig.Solo_MatchOfflineTime) {
/*  78 */           iter.remove();
/*  79 */           Out.debug(new Object[] { "matcher list removed player:", mpo.getPlayer().getName() });
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/*  84 */       for (MatcherVO mpo : this.matchers.values()) {
/*  85 */         if (mpo.isMarkedDel()) {
/*  86 */           Out.warn(new Object[] { "匹配异常，命中匹配过了，playerId=", mpo.getPlayerId() });
/*     */           continue;
/*     */         } 
/*  89 */         if (!mpo.isOnline()) {
/*  90 */           Out.warn(new Object[] { "匹配异常，命中不在线了，playerId=", mpo.getPlayerId() });
/*     */           continue;
/*     */         } 
/*  93 */         markMatched(mpo);
/*     */       } 
/*     */       
/*  96 */       iter = this.matchers.values().iterator();
/*  97 */       while (iter.hasNext()) {
/*  98 */         MatcherVO mpo = iter.next();
/*  99 */         if (mpo.isMarkedDel()) {
/* 100 */           iter.remove();
/* 101 */           Out.debug(new Object[] { "matcher list removed player:" + mpo.getPlayer().getName() });
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void markMatched(MatcherVO player) {
/* 113 */     int minScore = player.getMinScore();
/* 114 */     int maxScore = player.getMaxScore();
/*     */     
/* 116 */     for (MatcherVO mpo : this.matchers.values()) {
/* 117 */       if (!mpo.isMarkedDel() && mpo.isOnline() && mpo.getScore() >= minScore && mpo.getScore() <= maxScore && !player.getPlayerId().equals(mpo.getPlayerId())) {
/* 118 */         mpo.setMarkedDel(true);
/* 119 */         player.setMarkedDel(true);
/* 120 */         addWaiter(mpo.getPlayer(), player.getPlayer());
/*     */         return;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void resetMatchingList() {
/* 130 */     this.sumMatchingTime = 0L;
/* 131 */     this.matchedNumber = 0;
/* 132 */     this.matchers.clear();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean joinBattle(WNPlayer wnPlayer) {
/* 142 */     MatchedTeam team = getTeam(wnPlayer.getId());
/* 143 */     if (team == null) {
/* 144 */       return false;
/*     */     }
/* 146 */     GWorld.getInstance().ansycExec(() -> {
/*     */           synchronized (team) {
/*     */             if (team.getAllPlayers().contains(wnPlayer)) {
/*     */               wnPlayer.achievementManager.onSoloBattle();
/*     */               
/*     */               if (team.getBattleArea() != null) {
/*     */                 enterSoloArea(wnPlayer, team.getBattleArea());
/*     */               } else {
/*     */                 team.setBattleArea(enterNewSoloArea(wnPlayer));
/*     */               } 
/*     */               
/*     */               Out.info(new Object[] { "solo enter scene: instanceId=", (team.getBattleArea()).instanceId });
/*     */               team.remove(wnPlayer.getId());
/*     */             } 
/*     */           } 
/*     */         });
/* 162 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getAvgMatchingTime() {
/* 171 */     if (this.matchedNumber <= 0) {
/* 172 */       return GlobalConfig.Solo_MATCH_TIME;
/*     */     }
/* 174 */     return (int)(this.sumMatchingTime / this.matchedNumber) / 1000;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long updateMatchingTime(long matchedTime) {
/* 184 */     this.matchedNumber++;
/* 185 */     this.sumMatchingTime += matchedTime;
/* 186 */     return this.sumMatchingTime / this.matchedNumber;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public WNPlayer findMatchedPlayer(int myScore, String myId) {
/* 197 */     WNPlayer dest = null;
/* 198 */     synchronized (this.matchers) {
/* 199 */       int matchScoreRange = GlobalConfig.Solo_MatchRangeIncrease;
/* 200 */       int minScore = myScore - matchScoreRange;
/* 201 */       int maxScore = myScore + matchScoreRange;
/*     */       
/* 203 */       MatcherVO player = this.matchers.get(myId);
/* 204 */       if (player != null) {
/* 205 */         minScore = player.getMinScore();
/* 206 */         maxScore = player.getMaxScore();
/*     */       } 
/* 208 */       for (MatcherVO mpo : this.matchers.values()) {
/*     */         
/* 210 */         if (mpo.isOnline() && !mpo.isMarkedDel() && mpo.getScore() >= minScore && mpo.getScore() <= maxScore) {
/* 211 */           dest = mpo.getPlayer();
/*     */           break;
/*     */         } 
/*     */       } 
/* 215 */       if (dest != null) {
/* 216 */         this.matchers.remove(dest.getId());
/* 217 */         if (player != null) {
/* 218 */           this.matchers.remove(player.getPlayerId());
/*     */         }
/*     */       } 
/*     */     } 
/* 222 */     return dest;
/*     */   }
/*     */   
/*     */   public void playerOffline(String playerId) {
/* 226 */     MatcherVO player = this.matchers.get(playerId);
/* 227 */     if (player != null) {
/* 228 */       player.setOffline();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addToMatchingList(int myScore, WNPlayer me) {
/* 239 */     MatcherVO player = this.matchers.get(me.getId());
/*     */     
/* 241 */     if (player != null) {
/* 242 */       player.setOnline();
/*     */     } else {
/* 244 */       this.matchers.put(me.getId(), new MatcherVO(myScore, me));
/*     */     } 
/* 246 */     Out.debug(new Object[] { me.getName(), " added -------mathers:", Integer.valueOf(this.matchers.size()) });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isInMatchingList(String playerId) {
/* 256 */     return (this.matchers.get(playerId) != null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void delToMatchingList(String playerId) {
/* 266 */     this.matchers.remove(playerId);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void addWaiter(WNPlayer a, WNPlayer b) {
/* 277 */     Out.info(new Object[] { "solo matched:", "a=", a.getId(), ",b=", b.getId() });
/* 278 */     final MatchedTeam team = new MatchedTeam(a, b);
/*     */     
/* 280 */     matchedQueue.add(team);
/* 281 */     pushSoloMatched(a, b, false);
/* 282 */     pushSoloMatched(b, a, false);
/*     */ 
/*     */     
/* 285 */     JobFactory.addDelayJob(new Runnable()
/*     */         {
/*     */           public void run() {
/* 288 */             Collection<WNPlayer> members = team.getAllPlayers();
/* 289 */             for (WNPlayer member : members) {
/* 290 */               SoloMatcher.getInstance().joinBattle(member);
/*     */             }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 300 */             SoloMatcher.matchedQueue.remove(team);
/*     */           }
/*     */         },  GlobalConfig.Solo_EnterTime, TimeUnit.SECONDS);
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
/*     */   private static Area enterNewSoloArea(WNPlayer player) {
/* 314 */     player.setForce(Const.AreaForce.FORCEA.value);
/* 315 */     player.soloManager.onEnterSoloArea();
/* 316 */     Map<String, Object> userData = Utils.ofMap(new Object[] { "isAddRobot", Boolean.valueOf(false), "pro", Integer.valueOf(player.getPro()) });
/* 317 */     Area area = AreaUtil.createAreaAndDispatch(player, Arrays.asList(new String[] { player.getId() }, ), player.getLogicServerId(), GlobalConfig.Solo_MapID, userData);
/* 318 */     if (!PlayerUtil.isOnline(player.getId())) {
/* 319 */       area.addPlayer(player);
/* 320 */       area.playerEnterRequest(player);
/* 321 */       player.getXmdsManager().playerReady(player.getId());
/* 322 */       area.onPlayerAutoBattle(player, true);
/*     */     } 
/* 324 */     Out.debug(new Object[] { player.getName(), "-------------- enter1 --------------", area.instanceId });
/* 325 */     return area;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void enterSoloArea(WNPlayer player, Area area) {
/* 335 */     player.soloManager.onEnterSoloArea();
/* 336 */     if (area != null && !area.isClose()) {
/* 337 */       player.setForce(Const.AreaForce.FORCEB.value);
/* 338 */       Out.debug(new Object[] { player.getName(), "-------------- enter2 --------------", area.instanceId });
/* 339 */       if (!PlayerUtil.isOnline(player.getId())) {
/* 340 */         area.addPlayer(player);
/* 341 */         area.playerEnterRequest(player);
/* 342 */         player.getXmdsManager().playerReady(player.getId());
/* 343 */         area.onPlayerAutoBattle(player, true);
/*     */       } else {
/* 345 */         AreaData areaData = new AreaData(area.areaId, area.instanceId);
/* 346 */         AreaUtil.dispatchByInstanceId(player, areaData);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private MatchedTeam getTeam(String playerId) {
/* 352 */     for (MatchedTeam team : matchedQueue) {
/* 353 */       if (team.getPlayer(playerId) != null) {
/* 354 */         return team;
/*     */       }
/*     */     } 
/* 357 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void pushSoloMatched(WNPlayer me, WNPlayer vsPlayer, boolean isReconnect) {
/* 367 */     if (me == null || vsPlayer == null) {
/* 368 */       Out.error(new Object[] { "Player null occoured in pushSoloMatched..." });
/*     */       return;
/*     */     } 
/* 371 */     me.soloManager.setBusy(true);
/* 372 */     me.dailyActivityMgr.onEvent(Const.DailyType.SOLO, "0", 1);
/* 373 */     getInstance().updateMatchingTime(me.soloManager.getMatchedTime());
/* 374 */     SoloHandler.OnSoloMatchedPush.Builder msg = SoloHandler.OnSoloMatchedPush.newBuilder();
/* 375 */     msg.setS2CCode(200);
/* 376 */     msg.setS2CVsPlayerName(vsPlayer.getName());
/* 377 */     msg.setS2CVsPlayerPro(vsPlayer.getPro());
/* 378 */     msg.setS2CVsPlayerLevel(vsPlayer.getLevel());
/* 379 */     List<Common.Avatar> equipAvatars = PlayerUtil.getBattlerServerAvatar(vsPlayer, false);
/* 380 */     msg.addAllS2CVsPlayerAvatars(equipAvatars);
/* 381 */     msg.setS2CWaitResponseTimeSec(GlobalConfig.Solo_EnterTime);
/* 382 */     me.receive("area.soloPush.onSoloMatchedPush", (GeneratedMessage)msg.build());
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\solo\SoloMatcher.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */