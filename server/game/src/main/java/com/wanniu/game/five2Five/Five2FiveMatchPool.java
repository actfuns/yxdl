/*     */ package com.wanniu.game.five2Five;
/*     */ 
/*     */ import com.wanniu.core.GConfig;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.player.GlobalConfig;
/*     */ import com.wanniu.game.player.PlayerUtil;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.poes.PlayerPO;
/*     */ import com.wanniu.game.team.TeamData;
/*     */ import com.wanniu.game.team.TeamService;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.UUID;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import java.util.concurrent.CopyOnWriteArrayList;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Five2FiveMatchPool
/*     */ {
/*  33 */   private static final int TEAM_NUMBER = GConfig.getInstance().getInt("five_2_five_match_number", 1);
/*     */ 
/*     */   
/*  36 */   private static final CopyOnWriteArrayList<Five2FiveSingleApplyVo> playerApplysPool = new CopyOnWriteArrayList<>();
/*     */ 
/*     */   
/*  39 */   private static final CopyOnWriteArrayList<Five2FiveTeamApplyVo> teamApplysPool = new CopyOnWriteArrayList<>();
/*     */ 
/*     */   
/*  42 */   private static final CopyOnWriteArrayList<Five2FiveMatchTeamVo> teamMatchPool = new CopyOnWriteArrayList<>();
/*     */ 
/*     */   
/*  45 */   private static final Map<String, Five2FiveMatchTeamVo> matchedPool = new ConcurrentHashMap<>();
/*     */ 
/*     */   
/*  48 */   private static final ReentrantReadWriteLock poolLock = new ReentrantReadWriteLock();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final long MAX_WAIT_LOCK_MILL = 100L;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int getBeginNeedCount() {
/*  61 */     return TEAM_NUMBER;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void clearMatchPool() {
/*  68 */     playerApplysPool.clear();
/*  69 */     teamApplysPool.clear();
/*  70 */     teamMatchPool.clear();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final List<String> getApplyPlayer() {
/*  79 */     List<String> playerIds = new ArrayList<>(); int i;
/*  80 */     for (i = 0; i < playerApplysPool.size(); i++) {
/*  81 */       WNPlayer tempPlayer = ((Five2FiveSingleApplyVo)playerApplysPool.get(i)).player;
/*  82 */       if (tempPlayer != null) {
/*  83 */         playerIds.add(tempPlayer.getId());
/*     */       }
/*     */     } 
/*  86 */     for (i = 0; i < teamApplysPool.size(); i++) {
/*  87 */       Five2FiveTeamApplyVo temp = teamApplysPool.get(i);
/*  88 */       if (temp != null) {
/*     */ 
/*     */         
/*  91 */         Set<String> memPlayerIds = temp.teamMembers.keySet();
/*  92 */         playerIds.addAll(memPlayerIds);
/*     */       } 
/*  94 */     }  for (i = 0; i < teamMatchPool.size(); i++) {
/*  95 */       Five2FiveMatchTeamVo temp = teamMatchPool.get(i);
/*  96 */       if (temp != null)
/*     */       {
/*     */         
/*  99 */         if (temp.tempTeamMember != null) {
/*     */ 
/*     */           
/* 102 */           List<Five2FiveTempTeamMember> tempTeamMember = temp.tempTeamMember;
/* 103 */           for (int j = 0; j < tempTeamMember.size(); j++) {
/* 104 */             Five2FiveTempTeamMember tempMem = tempTeamMember.get(j);
/* 105 */             String tempMemPlayerId = tempMem.playerId;
/* 106 */             playerIds.add(tempMemPlayerId);
/*     */           } 
/*     */         }  } 
/* 109 */     }  return playerIds;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final Five2FiveMatchTeamVo removeMatchedTeam(String tempTeamId) {
/* 118 */     return matchedPool.remove(tempTeamId);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final void singlePutInApplyPool(WNPlayer player) {
/* 127 */     Five2FiveSingleApplyVo singleMatchVo = new Five2FiveSingleApplyVo();
/* 128 */     singleMatchVo.joinTime = new Date();
/* 129 */     singleMatchVo.player = player;
/*     */     try {
/* 131 */       if (!poolLock.writeLock().tryLock(100L, TimeUnit.MILLISECONDS)) {
/* 132 */         Out.warn(new Object[] { "Try writeLock timeout" });
/*     */       }
/* 134 */       playerApplysPool.add(singleMatchVo);
/* 135 */     } catch (Exception e) {
/* 136 */       Out.error(new Object[] { e });
/*     */     } finally {
/* 138 */       poolLock.writeLock().unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final void teamPutInApplyPool(Map<String, TeamData.TeamMemberData> teamMembers, String teamId) {
/* 149 */     Five2FiveTeamApplyVo teamMatchVo = new Five2FiveTeamApplyVo(teamMembers, teamId);
/* 150 */     teamMatchVo.joinTime = new Date();
/*     */     try {
/* 152 */       if (!poolLock.writeLock().tryLock(100L, TimeUnit.MILLISECONDS)) {
/* 153 */         Out.warn(new Object[] { "Try writeLock timeout" });
/*     */       }
/*     */       
/* 156 */       if (teamMatchVo.teamMembers.size() == TEAM_NUMBER) {
/* 157 */         Five2FiveMatchTeamVo tempTeam = createTempTeam(null, Arrays.asList(new Five2FiveTeamApplyVo[] { teamMatchVo }));
/* 158 */         if (tempTeam == null) {
/* 159 */           teamApplysPool.add(teamMatchVo);
/*     */         } else {
/* 161 */           teamMatchPool.add(tempTeam);
/*     */         } 
/*     */       } else {
/* 164 */         teamApplysPool.add(teamMatchVo);
/*     */       } 
/* 166 */     } catch (Exception e) {
/* 167 */       Out.error(new Object[] { e });
/*     */     } finally {
/* 169 */       poolLock.writeLock().unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final boolean singleRemoveApplyPool(String playerId) {
/*     */     try {
/* 181 */       if (!poolLock.writeLock().tryLock(100L, TimeUnit.MILLISECONDS)) {
/* 182 */         Out.warn(new Object[] { "Try writeLock timeout" });
/*     */       }
/*     */       int i;
/* 185 */       for (i = 0; i < playerApplysPool.size(); i++) {
/* 186 */         Five2FiveSingleApplyVo singleMatchVo = playerApplysPool.get(i);
/* 187 */         WNPlayer player = singleMatchVo.player;
/* 188 */         if (player == null) {
/* 189 */           playerApplysPool.remove(singleMatchVo);
/*     */         
/*     */         }
/* 192 */         else if (player.getId().equals(playerId)) {
/* 193 */           playerApplysPool.remove(singleMatchVo);
/* 194 */           Five2FiveService.getInstance().pushMatchPool();
/* 195 */           return true;
/*     */         } 
/*     */       } 
/*     */       
/* 199 */       for (i = 0; i < teamApplysPool.size(); i++) {
/* 200 */         Five2FiveTeamApplyVo teamMatchVo = teamApplysPool.get(i);
/* 201 */         TeamData teamData = TeamService.getTeam(teamMatchVo.teamId);
/* 202 */         if (teamData == null) {
/* 203 */           teamApplysPool.remove(teamMatchVo);
/*     */         } else {
/*     */           
/* 206 */           Map<String, TeamData.TeamMemberData> teamMembers = teamMatchVo.teamMembers;
/* 207 */           if (teamMembers.size() == 0) {
/* 208 */             teamApplysPool.remove(teamMatchVo);
/*     */           
/*     */           }
/* 211 */           else if (teamMembers.containsKey(playerId)) {
/* 212 */             teamApplysPool.remove(teamMatchVo);
/*     */ 
/*     */             
/* 215 */             for (TeamData.TeamMemberData td : teamMatchVo.teamMembers.values()) {
/* 216 */               if (td.id.equals(playerId)) {
/*     */                 continue;
/*     */               }
/* 219 */               Five2FiveService.getInstance().pushCancelMatch(td.id);
/*     */             } 
/*     */             
/* 222 */             Five2FiveService.getInstance().pushMatchPool();
/* 223 */             return true;
/*     */           } 
/*     */         } 
/*     */       } 
/* 227 */       for (i = 0; i < teamMatchPool.size(); i++) {
/* 228 */         Five2FiveMatchTeamVo matchTeamVo = teamMatchPool.get(i);
/* 229 */         CopyOnWriteArrayList<Five2FiveTempTeamMember> tempTeamMember = matchTeamVo.tempTeamMember;
/* 230 */         for (int j = 0; j < tempTeamMember.size(); j++) {
/* 231 */           Five2FiveTempTeamMember ttm = tempTeamMember.get(j);
/* 232 */           String tempPlayerId = ttm.playerId;
/* 233 */           if (tempPlayerId.equals(playerId)) {
/* 234 */             if (matchTeamVo.useNumber.getAndAdd(1) == 0) {
/* 235 */               teamMatchPool.remove(matchTeamVo);
/* 236 */               if (matchTeamVo.singleMatchVos != null) {
/* 237 */                 List<Five2FiveSingleApplyVo> noContainThisPlayerApplys = new ArrayList<>();
/* 238 */                 for (int k = 0; k < matchTeamVo.singleMatchVos.size(); k++) {
/* 239 */                   Five2FiveSingleApplyVo temp = matchTeamVo.singleMatchVos.get(k);
/* 240 */                   if (temp.player != null) {
/*     */ 
/*     */                     
/* 243 */                     String tempId = temp.player.getId();
/* 244 */                     if (!tempId.equals(playerId))
/* 245 */                       noContainThisPlayerApplys.add(temp); 
/*     */                   } 
/*     */                 } 
/* 248 */                 if (!noContainThisPlayerApplys.isEmpty()) {
/* 249 */                   playerApplysPool.addAll(noContainThisPlayerApplys);
/*     */                 }
/*     */               } 
/* 252 */               if (matchTeamVo.teamMatchVos != null)
/* 253 */                 for (int k = 0; k < matchTeamVo.teamMatchVos.size(); k++) {
/* 254 */                   Five2FiveTeamApplyVo tempTeam = matchTeamVo.teamMatchVos.get(k);
/* 255 */                   Map<String, TeamData.TeamMemberData> teamMembers = tempTeam.teamMembers;
/* 256 */                   if (teamMembers.size() == 0 || teamMembers.containsKey(playerId)) {
/*     */                     
/* 258 */                     for (TeamData.TeamMemberData td : teamMembers.values()) {
/* 259 */                       if (td.id.equals(playerId)) {
/*     */                         continue;
/*     */                       }
/* 262 */                       Five2FiveService.getInstance().pushCancelMatch(td.id);
/*     */                     }
/*     */                   
/*     */                   } else {
/*     */                     
/* 267 */                     teamApplysPool.add(tempTeam);
/*     */                   } 
/*     */                 }  
/* 270 */               Five2FiveService.getInstance().pushMatchPool();
/* 271 */               return true;
/*     */             } 
/*     */             
/*     */             break;
/*     */           } 
/*     */         } 
/*     */       } 
/* 278 */     } catch (Exception e) {
/* 279 */       Out.error(new Object[] { e });
/*     */     } finally {
/* 281 */       poolLock.writeLock().unlock();
/*     */     } 
/*     */     
/* 284 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static final boolean teamRemoveApplyPool(String teamId) {
/*     */     int i;
/* 295 */     for (i = 0; i < teamApplysPool.size(); i++) {
/* 296 */       Five2FiveTeamApplyVo teamMatchVo = teamApplysPool.get(i);
/* 297 */       if (teamMatchVo.teamId.equals(teamId)) {
/* 298 */         teamApplysPool.remove(teamMatchVo);
/* 299 */         return true;
/*     */       } 
/*     */     } 
/*     */     
/* 303 */     for (i = 0; i < teamMatchPool.size(); i++) {
/* 304 */       Five2FiveMatchTeamVo matchTeamVo = teamMatchPool.get(i);
/* 305 */       List<Five2FiveTeamApplyVo> teamMatchVos = matchTeamVo.teamMatchVos;
/* 306 */       if (teamMatchVos != null)
/*     */       {
/*     */         
/* 309 */         for (int j = 0; j < teamMatchVos.size(); j++) {
/* 310 */           Five2FiveTeamApplyVo teamMatchVo = teamMatchVos.get(j);
/* 311 */           if (teamMatchVo.teamMembers.size() == 0) {
/* 312 */             teamMatchPool.remove(matchTeamVo);
/*     */           }
/* 314 */           else if (teamMatchVo.teamId.equals(teamId)) {
/* 315 */             if (matchTeamVo.useNumber.getAndAdd(1) == 0) {
/* 316 */               teamMatchPool.remove(matchTeamVo);
/* 317 */               if (matchTeamVo.singleMatchVos != null) {
/* 318 */                 playerApplysPool.addAll(matchTeamVo.singleMatchVos);
/*     */               }
/* 320 */               for (int k = 0; k < teamMatchVos.size(); k++) {
/* 321 */                 Five2FiveTeamApplyVo teamMatchVo_1 = teamMatchVos.get(k);
/* 322 */                 if (!teamMatchVo_1.teamId.equals(teamId)) {
/* 323 */                   teamApplysPool.add(teamMatchVo_1);
/*     */                 }
/*     */               } 
/* 326 */               return true;
/*     */             } 
/*     */             
/*     */             break;
/*     */           } 
/*     */         } 
/*     */       }
/*     */     } 
/* 334 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static final boolean teamIsMakeWithOthers(String teamId) {
/* 346 */     for (Map.Entry<String, Five2FiveMatchTeamVo> matchedVo : matchedPool.entrySet()) {
/* 347 */       Five2FiveMatchTeamVo matchTeamVo = matchedVo.getValue();
/* 348 */       List<Five2FiveTeamApplyVo> teamMatchVos = matchTeamVo.teamMatchVos;
/* 349 */       if (teamMatchVos != null) {
/* 350 */         for (int j = 0; j < teamMatchVos.size(); j++) {
/* 351 */           Five2FiveTeamApplyVo teamMatchVo = teamMatchVos.get(j);
/* 352 */           String teamMatchId = teamMatchVo.teamId;
/* 353 */           if (teamMatchId.equals(teamId)) {
/* 354 */             return true;
/*     */           }
/*     */         } 
/*     */       }
/*     */     } 
/* 359 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final Date applyMatchTime(String playerId) {
/*     */     int i;
/* 369 */     for (i = 0; i < playerApplysPool.size(); i++) {
/* 370 */       Five2FiveSingleApplyVo singleMatchVo = playerApplysPool.get(i);
/* 371 */       if (singleMatchVo.player.getId().equals(playerId)) {
/* 372 */         return singleMatchVo.joinTime;
/*     */       }
/*     */     } 
/*     */     
/* 376 */     for (i = 0; i < teamApplysPool.size(); i++) {
/* 377 */       Five2FiveTeamApplyVo teamMatchVo = teamApplysPool.get(i);
/* 378 */       Map<String, TeamData.TeamMemberData> teamMembers = teamMatchVo.teamMembers;
/* 379 */       if (teamMembers.containsKey(playerId)) {
/* 380 */         return teamMatchVo.joinTime;
/*     */       }
/*     */     } 
/*     */     
/* 384 */     for (i = 0; i < teamMatchPool.size(); i++) {
/* 385 */       Five2FiveMatchTeamVo matchTeamVo = teamMatchPool.get(i);
/* 386 */       List<Five2FiveTeamApplyVo> teamMatchVos = matchTeamVo.teamMatchVos;
/* 387 */       if (teamMatchVos != null) {
/* 388 */         for (int j = 0; j < teamMatchVos.size(); j++) {
/* 389 */           Five2FiveTeamApplyVo tempTeamApplyVo = teamMatchVos.get(j);
/* 390 */           Map<String, TeamData.TeamMemberData> teamMembers = tempTeamApplyVo.teamMembers;
/* 391 */           if (teamMembers.containsKey(playerId)) {
/* 392 */             return tempTeamApplyVo.joinTime;
/*     */           }
/*     */         } 
/*     */       }
/* 396 */       List<Five2FiveSingleApplyVo> singleMatchVos = matchTeamVo.singleMatchVos;
/* 397 */       if (singleMatchVos != null) {
/* 398 */         for (int j = 0; j < singleMatchVos.size(); j++) {
/* 399 */           WNPlayer single = ((Five2FiveSingleApplyVo)singleMatchVos.get(j)).player;
/* 400 */           if (single != null && single.getId().equals(playerId)) {
/* 401 */             return ((Five2FiveSingleApplyVo)singleMatchVos.get(j)).joinTime;
/*     */           }
/*     */         } 
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 408 */     for (Five2FiveMatchTeamVo vo : matchedPool.values()) {
/* 409 */       for (Five2FiveTempTeamMember m : vo.tempTeamMember) {
/* 410 */         if (m.playerId.equals(playerId)) {
/* 411 */           return new Date();
/*     */         }
/*     */       } 
/*     */     } 
/* 415 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int getSingleApplyPoolSize() {
/* 424 */     return playerApplysPool.size();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int getTeamApplyPoolSize() {
/* 433 */     return teamApplysPool.size();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int getTeamMatchPoolSize() {
/* 442 */     return teamMatchPool.size();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final Five2FiveMatchTeamVo getMatchingTeam(String tempTeamId) {
/* 452 */     return matchedPool.get(tempTeamId);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final void teamMatchTeam() {
/* 459 */     for (int i = 0; i < teamMatchPool.size(); i++) {
/* 460 */       Five2FiveMatchTeamVo matchTeam = teamMatchPool.get(i);
/* 461 */       int totalSize = 0;
/* 462 */       List<Five2FiveSingleApplyVo> singleMatchVos = matchTeam.singleMatchVos;
/* 463 */       if (singleMatchVos != null) {
/* 464 */         totalSize += singleMatchVos.size();
/*     */       }
/* 466 */       List<Five2FiveTeamApplyVo> teamMatchVos = matchTeam.teamMatchVos;
/* 467 */       if (teamMatchVos != null) {
/* 468 */         for (int j = 0; j < teamMatchVos.size(); j++) {
/* 469 */           Five2FiveTeamApplyVo teamApply = teamMatchVos.get(j);
/* 470 */           Map<String, TeamData.TeamMemberData> teamMembers = teamApply.teamMembers;
/* 471 */           totalSize += teamMembers.size();
/*     */         } 
/*     */       }
/* 474 */       if (totalSize != TEAM_NUMBER) {
/* 475 */         teamMatchPool.remove(matchTeam);
/* 476 */         if (matchTeam.singleMatchVos != null) {
/* 477 */           playerApplysPool.addAll(matchTeam.singleMatchVos);
/*     */         }
/* 479 */         if (matchTeam.teamMatchVos != null) {
/* 480 */           teamApplysPool.addAll(matchTeam.teamMatchVos);
/*     */         }
/*     */       } else {
/*     */         
/* 484 */         String tempTeamId = matchTeam.tempTeamId;
/* 485 */         Date joinTime = matchTeam.joinTime;
/* 486 */         Date now = new Date();
/* 487 */         long diff = (now.getTime() - joinTime.getTime()) / 1000L;
/* 488 */         int addNumber = (int)((diff / GlobalConfig.Group_MatchingTime == 0L) ? 1L : (diff / GlobalConfig.Group_MatchingTime));
/* 489 */         int teamScore = matchTeam.teamScore;
/* 490 */         int scoreChange = GlobalConfig.Group_PlusPoint * addNumber;
/* 491 */         int matchMinScore = getMinMatchScore(teamScore, scoreChange);
/* 492 */         int matchMaxScore = getMaxMatchScore(teamScore, scoreChange);
/* 493 */         Five2FiveMatchTeamVo conformTeam = getConformToRulesTeamsEqual5(tempTeamId, matchMinScore, matchMaxScore);
/* 494 */         if (conformTeam != null) {
/* 495 */           matchSuccess(matchTeam, conformTeam);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static final void doMatchJob() {
/* 504 */     if (!Five2FiveService.getInstance().isInOpenTime()) {
/*     */       return;
/*     */     }
/*     */     try {
/* 508 */       poolLock.writeLock().lock();
/* 509 */       long begin = System.currentTimeMillis();
/* 510 */       makeFiveTeam();
/* 511 */       teamMatchTeam();
/* 512 */       long spendTimeMill = begin - System.currentTimeMillis();
/* 513 */       if (spendTimeMill > 100L) {
/* 514 */         Out.warn(new Object[] { "5v5 doMatchJob spend too much time mills : " + spendTimeMill });
/*     */       }
/*     */     } finally {
/* 517 */       poolLock.writeLock().unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final void makeFiveTeam() {
/* 525 */     teamFindTeam();
/* 526 */     playerFindPlayer();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Five2FiveMatchTeamVo createTempTeam(List<Five2FiveSingleApplyVo> singleMatchVos, List<Five2FiveTeamApplyVo> teamMatchVos) {
/* 536 */     Out.debug(new Object[] { "5v5 createTempTeam" });
/* 537 */     Five2FiveMatchTeamVo matchVo = new Five2FiveMatchTeamVo();
/* 538 */     CopyOnWriteArrayList<Five2FiveTempTeamMember> tempTeamMember = new CopyOnWriteArrayList<>();
/* 539 */     int totalScore = 0;
/* 540 */     if (singleMatchVos != null) {
/* 541 */       for (int i = 0; i < singleMatchVos.size(); i++) {
/* 542 */         Five2FiveSingleApplyVo singleMatchVo = singleMatchVos.get(i);
/* 543 */         WNPlayer player = singleMatchVo.player;
/* 544 */         if (player == null) {
/* 545 */           playerApplysPool.remove(singleMatchVo);
/* 546 */           Out.debug(new Object[] { "5v5 createTempTeam failed:player is null" });
/* 547 */           return null;
/*     */         } 
/* 549 */         Five2FiveTempTeamMember temp = new Five2FiveTempTeamMember();
/* 550 */         temp.playerId = player.getId();
/* 551 */         temp.playerPro = player.getPro();
/* 552 */         temp.playerLvl = player.getLevel();
/* 553 */         temp.playerName = player.getName();
/* 554 */         tempTeamMember.add(temp);
/* 555 */         totalScore += Five2FiveService.getInstance().getFive2FiveScore(player.getId());
/*     */       } 
/*     */     }
/* 558 */     if (teamMatchVos != null) {
/* 559 */       for (int i = 0; i < teamMatchVos.size(); i++) {
/* 560 */         Five2FiveTeamApplyVo teamMatchVo = teamMatchVos.get(i);
/* 561 */         if (teamMatchVo == null) {
/* 562 */           Out.debug(new Object[] { "5v5 createTempTeam failed:teamData is null" });
/* 563 */           return null;
/*     */         } 
/* 565 */         Map<String, TeamData.TeamMemberData> teamMembers = teamMatchVo.teamMembers;
/* 566 */         if (teamMembers.size() == 0) {
/* 567 */           teamApplysPool.remove(teamMatchVo);
/* 568 */           Out.debug(new Object[] { "5v5 createTempTeam failed:teamMembers is null" });
/* 569 */           return null;
/*     */         } 
/* 571 */         for (Map.Entry<String, TeamData.TeamMemberData> tempMemEntry : teamMembers.entrySet()) {
/* 572 */           String playerId = tempMemEntry.getKey();
/* 573 */           PlayerPO player = PlayerUtil.getPlayerBaseData(playerId);
/* 574 */           Five2FiveTempTeamMember temp = new Five2FiveTempTeamMember();
/* 575 */           temp.playerId = player.id;
/* 576 */           temp.playerPro = player.pro;
/* 577 */           temp.playerLvl = player.level;
/* 578 */           temp.playerName = player.name;
/* 579 */           tempTeamMember.add(temp);
/* 580 */           totalScore += Five2FiveService.getInstance().getFive2FiveScore(player.id);
/*     */         } 
/*     */       } 
/*     */     }
/* 584 */     if (tempTeamMember.size() != TEAM_NUMBER) {
/* 585 */       Out.debug(new Object[] { "5v5 createTempTeam failed: tempTeam size not full" });
/* 586 */       return null;
/*     */     } 
/* 588 */     Out.debug(new Object[] { "5v5 createTempTeam success" });
/* 589 */     matchVo.tempTeamId = UUID.randomUUID().toString();
/* 590 */     matchVo.joinTime = new Date();
/* 591 */     matchVo.tempTeamMember = tempTeamMember;
/* 592 */     totalScore /= TEAM_NUMBER;
/* 593 */     matchVo.teamScore = totalScore;
/* 594 */     matchVo.singleMatchVos = singleMatchVos;
/* 595 */     matchVo.teamMatchVos = teamMatchVos;
/* 596 */     Out.info(new Object[] { "组建临时队伍:tempTeamId=", matchVo.tempTeamId });
/* 597 */     for (Five2FiveTempTeamMember v : matchVo.tempTeamMember) {
/* 598 */       Out.info(new Object[] { "成员：", v.playerId });
/*     */     } 
/*     */     
/* 601 */     return matchVo;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void teamFindTeam() {
/* 608 */     int i = 0; while (true) { if (i < teamApplysPool.size()) {
/* 609 */         Five2FiveTeamApplyVo matchTeam = teamApplysPool.get(i);
/* 610 */         Date joinTime = matchTeam.joinTime;
/* 611 */         Date now = new Date();
/* 612 */         long diff = (now.getTime() - joinTime.getTime()) / 1000L;
/* 613 */         int addNumber = (int)((diff / GlobalConfig.Group_MatchingTime == 0L) ? 1L : (diff / GlobalConfig.Group_MatchingTime));
/* 614 */         Map<String, TeamData.TeamMemberData> teamMembers = matchTeam.teamMembers;
/* 615 */         if (teamMembers == null || teamMembers.size() == 0) {
/* 616 */           teamApplysPool.remove(matchTeam);
/*     */         } else {
/*     */           
/* 619 */           if (teamMembers.size() == TEAM_NUMBER) {
/* 620 */             Five2FiveMatchTeamVo tempTeam = createTempTeam(null, Arrays.asList(new Five2FiveTeamApplyVo[] { matchTeam }));
/* 621 */             if (tempTeam == null) {
/* 622 */               teamApplysPool.add(matchTeam);
/*     */             } else {
/* 624 */               teamMatchPool.add(tempTeam);
/* 625 */               teamApplysPool.remove(matchTeam);
/*     */               i++;
/*     */             } 
/*     */           } 
/* 629 */           int teamScore = getTeamScore(teamMembers);
/* 630 */           int scoreChange = GlobalConfig.Group_PlusPoint * addNumber;
/* 631 */           int matchMinScore = getMinMatchScore(teamScore, scoreChange);
/* 632 */           int matchMaxScore = getMaxMatchScore(teamScore, scoreChange);
/* 633 */           int memSizeDiff = TEAM_NUMBER - teamMembers.size();
/* 634 */           String teamId = matchTeam.teamId;
/* 635 */           Five2FiveTeamApplyVo conformTeam = getConformToRulesTeamsLess5(teamId, matchMinScore, matchMaxScore, memSizeDiff);
/* 636 */           if (conformTeam != null) {
/* 637 */             removeTeamAndAddTeam(matchTeam, conformTeam);
/*     */             break;
/*     */           } 
/* 640 */           List<Five2FiveSingleApplyVo> conformSingle = getConformToRulesPlayer(null, matchMinScore, matchMaxScore);
/* 641 */           if (conformSingle.size() >= memSizeDiff) {
/* 642 */             for (int j = 0; j < memSizeDiff; j++) {
/* 643 */               Five2FiveSingleApplyVo singleMatchVo = conformSingle.get(j);
/* 644 */               removeSingleAndAddTeam(singleMatchVo, matchTeam);
/*     */             } 
/*     */           }
/*     */         } 
/*     */       } else {
/*     */         break;
/*     */       } 
/*     */       i++; }
/*     */   
/*     */   }
/*     */   
/*     */   private static void playerFindPlayer() {
/* 656 */     for (int i = 0; i < playerApplysPool.size(); i++) {
/* 657 */       Five2FiveSingleApplyVo matchPlayer = playerApplysPool.get(i);
/* 658 */       WNPlayer player = matchPlayer.player;
/* 659 */       if (player == null) {
/* 660 */         playerApplysPool.remove(matchPlayer);
/*     */       } else {
/*     */         
/* 663 */         String playerId = player.getId();
/* 664 */         Date joinTime = matchPlayer.joinTime;
/* 665 */         Date now = new Date();
/* 666 */         long diff = (now.getTime() - joinTime.getTime()) / 1000L;
/* 667 */         int addNumber = (int)((diff / GlobalConfig.Group_MatchingTime == 0L) ? 1L : (diff / GlobalConfig.Group_MatchingTime));
/* 668 */         int scoreChange = GlobalConfig.Group_PlusPoint * addNumber;
/* 669 */         int score = Five2FiveService.getInstance().getFive2FiveScore(playerId);
/* 670 */         int matchMinScore = getMinMatchScore(score, scoreChange);
/* 671 */         int matchMaxScore = getMaxMatchScore(score, scoreChange);
/* 672 */         List<Five2FiveSingleApplyVo> conformSingle = getConformToRulesPlayer(playerId, matchMinScore, matchMaxScore);
/* 673 */         if (conformSingle.size() >= TEAM_NUMBER - 1) {
/* 674 */           removeSingleAndCreateTeam(matchPlayer, conformSingle);
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
/*     */   
/*     */   private static void matchSuccess(Five2FiveMatchTeamVo teamMatchVoA, Five2FiveMatchTeamVo teamMatchVoB) {
/* 687 */     teamMatchPool.remove(teamMatchVoA);
/* 688 */     teamMatchPool.remove(teamMatchVoB);
/* 689 */     matchedPool.put(teamMatchVoA.tempTeamId, teamMatchVoA);
/* 690 */     matchedPool.put(teamMatchVoB.tempTeamId, teamMatchVoB);
/*     */     
/* 692 */     Out.info(new Object[] { "匹配成功 A队:", teamMatchVoA.tempTeamId, "，B队:", teamMatchVoB.tempTeamId });
/* 693 */     int index = 1; int i;
/* 694 */     for (i = 0; i < teamMatchVoA.tempTeamMember.size(); i++) {
/* 695 */       Five2FiveTempTeamMember tempTeamMember = teamMatchVoA.tempTeamMember.get(i);
/* 696 */       tempTeamMember.force = Const.AreaForce.FORCEA.value;
/* 697 */       tempTeamMember.index = index;
/* 698 */       index++;
/* 699 */       Out.info(new Object[] { "匹配A队成员:", tempTeamMember.playerId });
/*     */     } 
/* 701 */     index = 1;
/* 702 */     for (i = 0; i < teamMatchVoB.tempTeamMember.size(); i++) {
/* 703 */       Five2FiveTempTeamMember tempTeamMember = teamMatchVoB.tempTeamMember.get(i);
/* 704 */       tempTeamMember.force = Const.AreaForce.FORCEB.value;
/* 705 */       tempTeamMember.index = index;
/* 706 */       index++;
/* 707 */       Out.info(new Object[] { "匹配B队成员:", tempTeamMember.playerId });
/*     */     } 
/* 709 */     teamMatchVoA.oppoTempTeamId = teamMatchVoB.tempTeamId;
/* 710 */     teamMatchVoB.oppoTempTeamId = teamMatchVoA.tempTeamId;
/*     */     
/* 712 */     Five2FiveService.getInstance().five2FiveAfterMatchSucess(teamMatchVoA, teamMatchVoB);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void removeSingleAndCreateTeam(Five2FiveSingleApplyVo matchPlayer, List<Five2FiveSingleApplyVo> conformSingle) {
/* 722 */     List<Five2FiveSingleApplyVo> singleApplyVos = new ArrayList<>();
/* 723 */     singleApplyVos.add(matchPlayer);
/* 724 */     for (int i = 0; i < TEAM_NUMBER - 1; i++) {
/* 725 */       Five2FiveSingleApplyVo tempMatchTeamVo = conformSingle.get(i);
/* 726 */       singleApplyVos.add(tempMatchTeamVo);
/*     */     } 
/* 728 */     Five2FiveMatchTeamVo matchTeamVo = createTempTeam(singleApplyVos, null);
/* 729 */     if (matchTeamVo != null) {
/* 730 */       playerApplysPool.removeAll(singleApplyVos);
/* 731 */       teamMatchPool.add(matchTeamVo);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void removeSingleAndAddTeam(Five2FiveSingleApplyVo singleMatchVo, Five2FiveTeamApplyVo matchTeam) {
/* 742 */     List<Five2FiveSingleApplyVo> singleApplyVos = new ArrayList<>();
/* 743 */     singleApplyVos.add(singleMatchVo);
/* 744 */     Five2FiveMatchTeamVo matchTeamVo = createTempTeam(singleApplyVos, Arrays.asList(new Five2FiveTeamApplyVo[] { matchTeam }));
/* 745 */     if (matchTeamVo != null) {
/* 746 */       playerApplysPool.remove(singleMatchVo);
/* 747 */       teamApplysPool.remove(matchTeam);
/* 748 */       teamMatchPool.add(matchTeamVo);
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
/*     */   private static void removeTeamAndAddTeam(Five2FiveTeamApplyVo teamMemA, Five2FiveTeamApplyVo teamMemB) {
/* 760 */     Five2FiveMatchTeamVo matchTeamVo = createTempTeam(null, Arrays.asList(new Five2FiveTeamApplyVo[] { teamMemA, teamMemB }));
/* 761 */     if (matchTeamVo != null) {
/* 762 */       teamApplysPool.remove(teamMemA);
/* 763 */       teamApplysPool.remove(teamMemB);
/* 764 */       teamMatchPool.add(matchTeamVo);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int getTeamScore(Map<String, TeamData.TeamMemberData> teamMembers) {
/* 775 */     int teamScore = 0;
/* 776 */     for (Map.Entry<String, TeamData.TeamMemberData> tempMemEntry : teamMembers.entrySet()) {
/* 777 */       String teamMemPlayerId = tempMemEntry.getKey();
/* 778 */       int teamMemScore = Five2FiveService.getInstance().getFive2FiveScore(teamMemPlayerId);
/* 779 */       teamScore += teamMemScore;
/*     */     } 
/* 781 */     int size = teamMembers.size();
/* 782 */     if (size != 0) {
/* 783 */       return teamScore / size;
/*     */     }
/* 785 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int getMinMatchScore(int score, int scoreChange) {
/* 796 */     int minScore = -1;
/* 797 */     if (scoreChange < GlobalConfig.Group_MaxPoint) {
/* 798 */       minScore = (score - scoreChange < 0) ? 0 : (score - scoreChange);
/*     */     }
/* 800 */     return minScore;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int getMaxMatchScore(int score, int scoreChange) {
/* 811 */     int maxScore = -1;
/* 812 */     if (scoreChange < GlobalConfig.Group_MaxPoint) {
/* 813 */       maxScore = score + scoreChange;
/*     */     }
/* 815 */     return maxScore;
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
/*     */   private static Five2FiveTeamApplyVo getConformToRulesTeamsLess5(String teamId, int minTeamScore, int maxTeamScore, int memNumber) {
/* 828 */     for (int i = 0; i < teamApplysPool.size(); i++) {
/* 829 */       Five2FiveTeamApplyVo matchTeam = teamApplysPool.get(i);
/* 830 */       Map<String, TeamData.TeamMemberData> teamMembers = matchTeam.teamMembers;
/* 831 */       if (teamMembers == null || teamMembers.size() == 0) {
/* 832 */         teamApplysPool.remove(matchTeam);
/*     */       
/*     */       }
/* 835 */       else if (teamId == null || !teamId.equals(matchTeam.teamId)) {
/*     */ 
/*     */         
/* 838 */         if (teamMembers.size() == memNumber) {
/* 839 */           int currentTeamScore = getTeamScore(teamMembers);
/* 840 */           if (minTeamScore == -1 || maxTeamScore == -1 || (currentTeamScore >= minTeamScore && currentTeamScore <= maxTeamScore))
/* 841 */             return matchTeam; 
/*     */         } 
/*     */       } 
/*     */     } 
/* 845 */     return null;
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
/*     */   private static Five2FiveMatchTeamVo getConformToRulesTeamsEqual5(String tempTeamId, int minTeamScore, int maxTeamScore) {
/* 857 */     for (int i = 0; i < teamMatchPool.size(); i++) {
/* 858 */       Five2FiveMatchTeamVo matchTeam = teamMatchPool.get(i);
/* 859 */       if (matchTeam.tempTeamMember.size() != TEAM_NUMBER) {
/* 860 */         teamMatchPool.remove(matchTeam);
/* 861 */         if (matchTeam.singleMatchVos != null) {
/* 862 */           playerApplysPool.addAll(matchTeam.singleMatchVos);
/*     */         }
/* 864 */         if (matchTeam.teamMatchVos != null) {
/* 865 */           teamApplysPool.addAll(matchTeam.teamMatchVos);
/*     */         }
/*     */       } else {
/*     */         
/* 869 */         int currentTeamScore = matchTeam.teamScore;
/* 870 */         if (tempTeamId == null || !tempTeamId.equals(matchTeam.tempTeamId))
/*     */         {
/*     */           
/* 873 */           if (minTeamScore == -1 || maxTeamScore == -1 || (currentTeamScore >= minTeamScore && currentTeamScore <= maxTeamScore && matchTeam.useNumber.getAndAdd(1) == 0))
/* 874 */             return matchTeam;  } 
/*     */       } 
/*     */     } 
/* 877 */     return null;
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
/*     */   private static List<Five2FiveSingleApplyVo> getConformToRulesPlayer(String playerId, int minTeamScore, int maxTeamScore) {
/* 889 */     List<Five2FiveSingleApplyVo> conformToRulesSingles = new ArrayList<>();
/* 890 */     for (int i = 0; i < playerApplysPool.size(); i++) {
/* 891 */       Five2FiveSingleApplyVo matchSingle = playerApplysPool.get(i);
/* 892 */       WNPlayer player = matchSingle.player;
/* 893 */       if (player == null) {
/* 894 */         playerApplysPool.remove(matchSingle);
/*     */       } else {
/*     */         
/* 897 */         String matchPlayerId = player.getId();
/* 898 */         if (playerId == null || !matchPlayerId.equals(playerId)) {
/*     */ 
/*     */           
/* 901 */           int currentTeamScore = Five2FiveService.getInstance().getFive2FiveScore(matchPlayerId);
/* 902 */           if (minTeamScore == -1 || maxTeamScore == -1 || (currentTeamScore >= minTeamScore && currentTeamScore <= maxTeamScore))
/* 903 */             conformToRulesSingles.add(matchSingle); 
/*     */         } 
/*     */       } 
/* 906 */     }  return conformToRulesSingles;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\five2Five\Five2FiveMatchPool.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */