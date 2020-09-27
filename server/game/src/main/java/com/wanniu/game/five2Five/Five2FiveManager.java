/*     */ package com.wanniu.game.five2Five;
/*     */ 
/*     */ import com.google.protobuf.GeneratedMessage;
/*     */ import com.wanniu.core.game.LangService;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.util.DateUtil;
/*     */ import com.wanniu.game.GWorld;
/*     */ import com.wanniu.game.area.AreaUtil;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.ModuleManager;
/*     */ import com.wanniu.game.data.GameData;
/*     */ import com.wanniu.game.data.GameMapCO;
/*     */ import com.wanniu.game.data.ext.DayRewardExt;
/*     */ import com.wanniu.game.data.ext.PersonalRankExt;
/*     */ import com.wanniu.game.five2Five.dao.Five2FiveDao;
/*     */ import com.wanniu.game.item.NormalItem;
/*     */ import com.wanniu.game.mail.MailUtil;
/*     */ import com.wanniu.game.mail.data.MailData;
/*     */ import com.wanniu.game.mail.data.MailSysData;
/*     */ import com.wanniu.game.player.GlobalConfig;
/*     */ import com.wanniu.game.player.PlayerUtil;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.poes.Five2FivePO;
/*     */ import com.wanniu.game.poes.Five2FivePlayerBtlReportPO;
/*     */ import com.wanniu.game.poes.Five2FiveSystemPO;
/*     */ import com.wanniu.game.poes.PlayerPO;
/*     */ import com.wanniu.game.rank.RankType;
/*     */ import com.wanniu.game.team.TeamData;
/*     */ import com.wanniu.game.team.TeamManager;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.CopyOnWriteArrayList;
/*     */ import pomelo.area.PlayerHandler;
/*     */ import pomelo.five2five.Five2FiveHandler;
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
/*     */ public class Five2FiveManager
/*     */   extends ModuleManager
/*     */ {
/*     */   private WNPlayer player;
/*     */   private int isAgreeOrRefuse;
/*     */   
/*     */   public Five2FiveManager(WNPlayer player) {
/*  68 */     this.player = player;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void applyFive2Five(String playerId, Five2FiveHandler.Five2FiveResponse.Builder res) {
/*  78 */     Five2FivePO five2FivePO = this.player.allBlobData.five2FivePo;
/*  79 */     if (five2FivePO == null) {
/*  80 */       five2FivePO = Five2FiveDao.getPlayerFive2FivePO(this.player.getId());
/*  81 */       if (five2FivePO == null) {
/*  82 */         res.setS2CCode(500);
/*  83 */         res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
/*     */         return;
/*     */       } 
/*  86 */       this.player.allBlobData.five2FivePo = five2FivePO;
/*     */     } 
/*  88 */     refreshFive2FiveInfo(five2FivePO);
/*  89 */     res.setS2CCode(200);
/*  90 */     Five2FiveHandler.Five2FiveRankInfo.Builder firstRankInfo = Five2FiveHandler.Five2FiveRankInfo.newBuilder();
/*  91 */     String firstPlayerId = Five2FiveService.getInstance().getFirstRankInfo();
/*  92 */     if (!firstPlayerId.equals("")) {
/*  93 */       firstRankInfo.setPlayerId(firstPlayerId);
/*  94 */       WNPlayer firstPlayer = PlayerUtil.getOnlinePlayer(firstPlayerId);
/*  95 */       PlayerPO playerPo = null;
/*  96 */       if (firstPlayer == null) {
/*  97 */         playerPo = PlayerUtil.getPlayerBaseData(firstPlayerId);
/*     */       } else {
/*  99 */         playerPo = firstPlayer.player;
/*     */       } 
/* 101 */       firstRankInfo.setPlayerName(playerPo.name);
/* 102 */       firstRankInfo.setPlayerLvl(playerPo.level);
/* 103 */       firstRankInfo.setPro(playerPo.pro);
/* 104 */       firstRankInfo.setPlayerUpLvl(playerPo.upLevel);
/* 105 */       firstRankInfo.setPlayerFightPower(playerPo.fightPower);
/* 106 */       int firstScore = Five2FiveService.getInstance().getFive2FiveScore(firstPlayerId);
/* 107 */       firstRankInfo.setScore(firstScore);
/* 108 */       res.setFirstRankInfo(firstRankInfo);
/*     */     } 
/*     */     
/* 111 */     res.setScore(five2FivePO.score);
/* 112 */     long selfRank = Five2FiveService.getInstance().getPlayerRank(playerId);
/* 113 */     res.setRank((int)selfRank);
/* 114 */     res.setWin(five2FivePO.winCount);
/* 115 */     res.setTie(five2FivePO.tieCount);
/* 116 */     res.setFail(five2FivePO.failCount);
/* 117 */     res.setMvp(five2FivePO.mvpCount);
/* 118 */     res.setTotalCanReciveCount(five2FivePO.canReciveRewardCount);
/* 119 */     res.setHasRecivedCount(five2FivePO.hasReciveRewardCount);
/*     */     
/* 121 */     TeamManager tm = this.player.teamManager;
/* 122 */     boolean isInTeam = tm.isInTeam();
/* 123 */     int avgWaitTime = 0;
/* 124 */     if (isInTeam) {
/* 125 */       avgWaitTime = Five2FiveService.getInstance().getAvgWaitTime(false);
/*     */     } else {
/* 127 */       avgWaitTime = Five2FiveService.getInstance().getAvgWaitTime(true);
/*     */     } 
/*     */     
/* 130 */     Five2FiveHandler.Five2FiveMatchTime.Builder matchTime = Five2FiveHandler.Five2FiveMatchTime.newBuilder();
/* 131 */     matchTime.setAvgWaitTime(avgWaitTime);
/* 132 */     Date applyMatchTime = Five2FiveService.getInstance().applyMatchTime(playerId);
/* 133 */     if (applyMatchTime != null) {
/* 134 */       matchTime.setMatchTime((int)Math.floor((applyMatchTime.getTime() / 1000L)));
/*     */     } else {
/* 136 */       matchTime.setMatchTime(0);
/*     */     } 
/* 138 */     res.setMatchPeople(Five2FiveMatchPool.getApplyPlayer().size());
/* 139 */     res.setFive2FiveMatchTime(matchTime);
/* 140 */     res.setSeasonEndTime(String.valueOf((Five2FiveService.getInstance().getFive2FiveSystemPO()).seasonRefreshTime.getTime()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void cancelFive2FiveMatch(boolean isSelf) {
/* 147 */     String playerId = this.player.getId();
/* 148 */     if (applyMatchTime(playerId) == null) {
/*     */       return;
/*     */     }
/*     */     
/* 152 */     Five2FiveService.getInstance().singleQuitFive2FiveMatch(playerId, isSelf);
/*     */     
/* 154 */     Five2FiveService.getInstance().pushMatchPool();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void applyFive2FiveMatch(Five2FiveHandler.Five2FiveMatchResponse.Builder res, int matchOrReMatch) {
/* 165 */     TeamManager tm = this.player.teamManager;
/* 166 */     if (matchOrReMatch == 2) {
/* 167 */       TeamData teamData = tm.getTeam();
/* 168 */       Map<String, TeamData.TeamMemberData> teamMembers = teamData.teamMembers;
/* 169 */       for (TeamData.TeamMemberData memData : teamMembers.values()) {
/* 170 */         String memPlayerId = memData.id;
/* 171 */         Five2FiveService.getInstance().singleQuitFive2FiveMatch(memPlayerId, true);
/*     */       } 
/*     */     } 
/*     */     
/* 175 */     String validateResult = Five2FiveService.getInstance().isCanEnter(this.player);
/* 176 */     if (!validateResult.equals("")) {
/* 177 */       res.setS2CCode(500);
/* 178 */       res.setS2CMsg(validateResult);
/*     */       
/*     */       return;
/*     */     } 
/* 182 */     res.setS2CCode(200);
/* 183 */     boolean isInTeam = tm.isInTeam();
/*     */     
/* 185 */     Date now = new Date();
/* 186 */     if (isInTeam) {
/* 187 */       TeamData teamData = tm.getTeam();
/* 188 */       Map<String, TeamData.TeamMemberData> teamMembers = teamData.teamMembers;
/* 189 */       List<Five2FiveHandler.Five2FiveMatchMemberInfo> five2FiveMatchMemberInfos = new ArrayList<>();
/* 190 */       for (TeamData.TeamMemberData memData : teamMembers.values()) {
/* 191 */         String memPlayerId = memData.id;
/* 192 */         Five2FiveService.getInstance().singleQuitFive2FiveMatch(memPlayerId, true);
/*     */         
/* 194 */         Five2FiveHandler.Five2FiveMatchMemberInfo.Builder memInfo = Five2FiveHandler.Five2FiveMatchMemberInfo.newBuilder();
/* 195 */         WNPlayer player = memData.getPlayer();
/* 196 */         if (player == null) {
/*     */           continue;
/*     */         }
/* 199 */         player.five2FiveManager.isAgreeOrRefuse = 0;
/* 200 */         memInfo.setPlayerId(player.getId());
/* 201 */         memInfo.setPlayerPro(player.getPro());
/* 202 */         memInfo.setPlayerLvl(player.getLevel());
/* 203 */         memInfo.setPlayerName(player.getName());
/* 204 */         int readyStatus = 0;
/* 205 */         if (memPlayerId.equals(teamData.leaderId)) {
/* 206 */           readyStatus = Const.Five2Five.five2five_choice_ready.value;
/*     */         }
/* 208 */         memInfo.setReadyStatus(readyStatus);
/* 209 */         five2FiveMatchMemberInfos.add(memInfo.build());
/*     */       } 
/*     */       
/* 212 */       if (teamMembers.size() > 1) {
/* 213 */         for (TeamData.TeamMemberData memData : teamMembers.values()) {
/* 214 */           WNPlayer player = memData.getPlayer();
/* 215 */           if (player == null) {
/*     */             continue;
/*     */           }
/* 218 */           Five2FiveHandler.Five2FiveApplyMatchPush.Builder applyMatch = Five2FiveHandler.Five2FiveApplyMatchPush.newBuilder();
/* 219 */           applyMatch.addAllFive2FiveMatchMemberInfo(five2FiveMatchMemberInfos);
/* 220 */           applyMatch.setWaitResponseTimeSec(GlobalConfig.Group_ReadyTime);
/* 221 */           player.receive("five2five.five2FivePush.five2FiveApplyMatchPush", (GeneratedMessage)applyMatch.build());
/*     */         } 
/*     */       } else {
/* 224 */         Five2FiveService.getInstance().teamApplyMatch(teamData);
/*     */         
/* 226 */         int avgWaitTime = Five2FiveService.getInstance().getAvgWaitTime(false);
/* 227 */         Five2FiveHandler.Five2FiveMatchTime.Builder matchTime = Five2FiveHandler.Five2FiveMatchTime.newBuilder();
/* 228 */         matchTime.setAvgWaitTime(avgWaitTime);
/* 229 */         matchTime.setMatchTime((int)(now.getTime() / 1000L));
/* 230 */         res.setFive2FiveMatchTime(matchTime);
/*     */       } 
/*     */       
/* 233 */       this.player.five2FiveManager.isAgreeOrRefuse = Const.Five2Five.five2five_choice_ready.value;
/*     */     } else {
/* 235 */       int avgWaitTime = Five2FiveService.getInstance().getAvgWaitTime(true);
/* 236 */       Five2FiveHandler.Five2FiveMatchTime.Builder matchTime = Five2FiveHandler.Five2FiveMatchTime.newBuilder();
/* 237 */       matchTime.setAvgWaitTime(avgWaitTime);
/* 238 */       matchTime.setMatchTime((int)(now.getTime() / 1000L));
/* 239 */       res.setFive2FiveMatchTime(matchTime);
/* 240 */       Five2FiveService.getInstance().singleApplyMatch(this.player);
/* 241 */       this.isAgreeOrRefuse = 0;
/*     */     } 
/*     */     
/* 244 */     Five2FiveService.getInstance().pushMatchPool();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String agreeMatch(WNPlayer player) {
/* 255 */     TeamManager tm = player.teamManager;
/* 256 */     if (tm == null) {
/* 257 */       return LangService.getValue("SOMETHING_ERR");
/*     */     }
/*     */     
/* 260 */     TeamData teamData = tm.getTeam();
/* 261 */     if (teamData == null) {
/* 262 */       return LangService.getValue("SOMETHING_ERR");
/*     */     }
/*     */     
/* 265 */     player.five2FiveManager.isAgreeOrRefuse = Const.Five2Five.five2five_choice_ready.value;
/* 266 */     Five2FiveHandler.Five2FiveMemberChoicePush.Builder choice = Five2FiveHandler.Five2FiveMemberChoicePush.newBuilder();
/* 267 */     choice.setS2CCode(200);
/* 268 */     choice.setAgreeOrReady(Const.Five2Five.five2five_choice_type_agree.value);
/* 269 */     choice.setPlayerId(player.getId());
/* 270 */     choice.setChoice(Const.Five2Five.five2five_choice_ready.value);
/*     */     
/* 272 */     int agreeNumber = 0;
/* 273 */     int refuseNumber = 0;
/* 274 */     Map<String, TeamData.TeamMemberData> teamMembers = teamData.teamMembers;
/* 275 */     for (TeamData.TeamMemberData memData : teamMembers.values()) {
/* 276 */       WNPlayer playerMem = memData.getPlayer();
/* 277 */       if (playerMem == null) {
/*     */         continue;
/*     */       }
/*     */       
/* 281 */       int teamMemAgreeOrRefuse = playerMem.five2FiveManager.isAgreeOrRefuse;
/* 282 */       if (teamMemAgreeOrRefuse == Const.Five2Five.five2five_choice_giveup.value) {
/* 283 */         refuseNumber++;
/*     */       }
/* 285 */       if (teamMemAgreeOrRefuse == Const.Five2Five.five2five_choice_ready.value) {
/* 286 */         agreeNumber++;
/*     */       }
/* 288 */       playerMem.receive("five2five.five2FivePush.five2FiveMemberChoicePush", (GeneratedMessage)choice.build());
/*     */     } 
/*     */     
/* 291 */     Five2FiveHandler.Five2FiveApplyMatchResultPush.Builder applyMatchResultPush = Five2FiveHandler.Five2FiveApplyMatchResultPush.newBuilder();
/* 292 */     boolean isPush = false;
/* 293 */     if (refuseNumber != 0 && agreeNumber + refuseNumber == teamMembers.size()) {
/* 294 */       applyMatchResultPush.setS2CCode(500);
/* 295 */       isPush = true;
/* 296 */     } else if (agreeNumber == teamMembers.size()) {
/* 297 */       Five2FiveService.getInstance().teamApplyMatch(teamData);
/*     */       
/* 299 */       applyMatchResultPush.setS2CCode(200);
/*     */       
/* 301 */       Five2FiveHandler.Five2FiveMatchTime.Builder matchTime = Five2FiveHandler.Five2FiveMatchTime.newBuilder();
/* 302 */       int avgWaitTime = Five2FiveService.getInstance().getAvgWaitTime(false);
/* 303 */       matchTime.setAvgWaitTime(avgWaitTime);
/* 304 */       matchTime.setMatchTime((int)(System.currentTimeMillis() / 1000L));
/* 305 */       applyMatchResultPush.setFive2FiveMatchTime(matchTime);
/* 306 */       isPush = true;
/*     */     } 
/* 308 */     if (isPush) {
/* 309 */       for (TeamData.TeamMemberData teamMemberData : teamMembers.values()) {
/* 310 */         WNPlayer teamPlayer = teamMemberData.getPlayer();
/* 311 */         if (teamPlayer == null) {
/*     */           continue;
/*     */         }
/* 314 */         teamPlayer.receive("five2five.five2FivePush.five2FiveApplyMatchResultPush", (GeneratedMessage)applyMatchResultPush.build());
/*     */       } 
/*     */ 
/*     */       
/* 318 */       Five2FiveService.getInstance().pushMatchPool();
/*     */     } 
/* 320 */     return "";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String refuseMatch(WNPlayer player) {
/* 331 */     TeamManager tm = player.teamManager;
/* 332 */     if (tm == null) {
/* 333 */       return LangService.getValue("SOMETHING_ERR");
/*     */     }
/*     */     
/* 336 */     TeamData teamData = tm.getTeam();
/* 337 */     if (teamData == null) {
/* 338 */       return LangService.getValue("SOMETHING_ERR");
/*     */     }
/*     */     
/* 341 */     player.five2FiveManager.isAgreeOrRefuse = Const.Five2Five.five2five_choice_giveup.value;
/* 342 */     Five2FiveHandler.Five2FiveMemberChoicePush.Builder choice = Five2FiveHandler.Five2FiveMemberChoicePush.newBuilder();
/* 343 */     choice.setS2CCode(200);
/* 344 */     choice.setAgreeOrReady(Const.Five2Five.five2five_choice_type_agree.value);
/* 345 */     choice.setPlayerId(player.getId());
/* 346 */     choice.setChoice(Const.Five2Five.five2five_choice_giveup.value);
/*     */     
/* 348 */     Map<String, TeamData.TeamMemberData> teamMembers = teamData.teamMembers;
/* 349 */     for (TeamData.TeamMemberData memData : teamMembers.values()) {
/* 350 */       WNPlayer playerMem = memData.getPlayer();
/* 351 */       if (playerMem == null) {
/*     */         continue;
/*     */       }
/* 354 */       playerMem.receive("five2five.five2FivePush.five2FiveMemberChoicePush", (GeneratedMessage)choice.build());
/*     */     } 
/* 356 */     return "";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String matchReady(String tempTeamId) {
/* 366 */     Five2FiveMatchTeamVo tempTeamVo = Five2FiveService.getInstance().getMatchingTeam(tempTeamId);
/* 367 */     if (tempTeamVo == null) {
/* 368 */       return LangService.getValue("SOMETHING_ERR");
/*     */     }
/*     */     
/* 371 */     CopyOnWriteArrayList<Five2FiveTempTeamMember> tempTeamMembers = tempTeamVo.tempTeamMember;
/* 372 */     int totalReadyNumber = 0;
/* 373 */     for (Five2FiveTempTeamMember tempTeamMember : tempTeamMembers) {
/* 374 */       String playerId = tempTeamMember.playerId;
/* 375 */       WNPlayer tempTeamPlayer = PlayerUtil.findPlayer(playerId);
/* 376 */       if (tempTeamPlayer == null) {
/*     */         continue;
/*     */       }
/* 379 */       if (playerId.equals(this.player.getId())) {
/* 380 */         tempTeamMember.isReadyOrCancel.set(Const.Five2Five.five2five_choice_ready.value);
/*     */       }
/* 382 */       if (tempTeamMember.isReadyOrCancel.get() == Const.Five2Five.five2five_choice_ready.value) {
/* 383 */         totalReadyNumber++;
/*     */       }
/*     */       
/* 386 */       Five2FiveService.getInstance().pushReady(this.player.getId(), playerId);
/*     */     } 
/*     */     
/* 389 */     CopyOnWriteArrayList<Five2FiveTempTeamMember> oppoTempTeamMembers = (Five2FiveService.getInstance().getMatchingTeam(tempTeamVo.oppoTempTeamId)).tempTeamMember;
/* 390 */     for (Five2FiveTempTeamMember tempTeamMember : oppoTempTeamMembers) {
/* 391 */       if (tempTeamMember.isReadyOrCancel.get() == Const.Five2Five.five2five_choice_ready.value) {
/* 392 */         totalReadyNumber++;
/*     */       }
/*     */       
/* 395 */       Five2FiveService.getInstance().pushReady(this.player.getId(), tempTeamMember.playerId);
/*     */     } 
/* 397 */     if (totalReadyNumber == tempTeamMembers.size() + oppoTempTeamMembers.size()) {
/* 398 */       if (!tempTeamVo.isAllChoice.get()) {
/* 399 */         Five2FiveMatchTeamVo tempTeamVoB = Five2FiveService.getInstance().getMatchingTeam(tempTeamVo.oppoTempTeamId);
/* 400 */         Five2FiveService.getInstance().afterAllChoiced(tempTeamVo, tempTeamVoB);
/* 401 */         tempTeamVo.isAllChoice.set(true);
/*     */       } else {
/* 403 */         return "";
/*     */       } 
/*     */     }
/* 406 */     return "";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String reciveReward() {
/* 415 */     Five2FivePO five2FivePo = this.player.allBlobData.five2FivePo;
/* 416 */     if (five2FivePo == null) {
/* 417 */       return LangService.getValue("FIVE_2_FIVE_NO_REWERD_CAN_RECIVE");
/*     */     }
/* 419 */     int canReciveRewardCount = canReciveRewardCount();
/* 420 */     if (canReciveRewardCount == 0) {
/* 421 */       return LangService.getValue("FIVE_2_FIVE_NO_REWERD_CAN_RECIVE");
/*     */     }
/*     */     
/* 424 */     DayRewardExt dayReward = (DayRewardExt)GameData.DayRewards.get(Integer.valueOf(five2FivePo.hasReciveRewardCount + 1));
/* 425 */     if (dayReward == null) {
/* 426 */       return LangService.getValue("FIVE_2_FIVE_NO_REWERD_CAN_RECIVE");
/*     */     }
/*     */     
/* 429 */     List<NormalItem> rankReward = Five2FiveService.getInstance().createItem(dayReward.dayRewards);
/*     */     
/* 431 */     if (!this.player.getWnBag().testAddEntityItems(rankReward, true)) {
/* 432 */       return LangService.getValue("BAG_NOT_ENOUGH_POS");
/*     */     }
/*     */     
/* 435 */     this.player.getWnBag().addEntityItems(rankReward, Const.GOODS_CHANGE_TYPE.five2five);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 441 */     five2FivePo.lastReciveRewardTime = new Date();
/* 442 */     five2FivePo.hasReciveRewardCount++;
/*     */     
/* 444 */     updateSuperScript();
/* 445 */     return "";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String shardMatchResult(String instanceId) {
/* 455 */     List<Five2FivePlayerBtlReportPO> five2FiveBtlReportPO = this.player.allBlobData.five2FiveBtlReportPO;
/* 456 */     if (five2FiveBtlReportPO == null) {
/* 457 */       return LangService.getValue("FIVE_2_FIVE_NO_REPORT");
/*     */     }
/* 459 */     int resultA = Five2FiveService.Five2FiveResult.TIE.ordinal();
/* 460 */     List<Five2FivePlayerResultInfoVo> resultInfos = new ArrayList<>();
/* 461 */     for (int i = 0; i < five2FiveBtlReportPO.size(); i++) {
/* 462 */       Five2FivePlayerBtlReportPO reportPo = five2FiveBtlReportPO.get(i);
/* 463 */       if (reportPo != null && 
/* 464 */         instanceId.equals(reportPo.id)) {
/* 465 */         if (reportPo.resultInfoA != null && reportPo.resultInfoB != null) {
/* 466 */           for (Five2FivePlayerResultInfoVo everyResultInfo : reportPo.resultInfoA.values()) {
/* 467 */             resultInfos.add(everyResultInfo);
/*     */             
/* 469 */             if (everyResultInfo.playerId.equals(reportPo.playerId)) {
/* 470 */               resultA = reportPo.status;
/*     */             }
/*     */           } 
/* 473 */           for (Five2FivePlayerResultInfoVo everyResultInfo : reportPo.resultInfoB.values()) {
/* 474 */             resultInfos.add(everyResultInfo);
/*     */             
/* 476 */             if (everyResultInfo.playerId.equals(reportPo.playerId)) {
/* 477 */               if (reportPo.status == Five2FiveService.Five2FiveResult.WIN.ordinal()) {
/* 478 */                 resultA = Five2FiveService.Five2FiveResult.FAIL.ordinal(); continue;
/* 479 */               }  if (reportPo.status == Five2FiveService.Five2FiveResult.FAIL.ordinal()) {
/* 480 */                 resultA = Five2FiveService.Five2FiveResult.WIN.ordinal();
/*     */               }
/*     */             } 
/*     */           } 
/*     */         } 
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/* 489 */     if (resultInfos.size() == 0) {
/* 490 */       return LangService.getValue("FIVE_2_FIVE_NO_REPORT");
/*     */     }
/* 492 */     ((Five2FivePlayerResultInfoVo)resultInfos.get(0)).resultA = resultA;
/* 493 */     Five2FiveService.getInstance().shardMatchResult(instanceId, resultInfos);
/* 494 */     Out.info(new Object[] { "试炼战报,插入分享后的战报成功!角色id=", this.player.getId(), ",战报id=", instanceId });
/* 495 */     String shareContent = LangService.getValue("5V5_SHARE");
/* 496 */     shareContent = shareContent.replace("playerName", this.player.getName());
/* 497 */     shareContent = shareContent.replace("Battlefield", instanceId);
/* 498 */     return "";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void lookBtlReport(Five2FiveHandler.Five2FiveLookBtlReportResponse.Builder res) {
/* 507 */     String playerId = this.player.getId();
/* 508 */     List<Five2FivePlayerBtlReportPO> five2FiveBtlReportPO = this.player.allBlobData.five2FiveBtlReportPO;
/* 509 */     List<Five2FiveHandler.Five2FiveBtlReport> playerResultInfo = new ArrayList<>();
/* 510 */     if (five2FiveBtlReportPO == null) {
/* 511 */       five2FiveBtlReportPO = Five2FiveDao.getPlayerFive2FiveBtlReportPO(playerId);
/* 512 */       if (five2FiveBtlReportPO == null) {
/* 513 */         res.setS2CCode(200);
/* 514 */         res.addAllBr(playerResultInfo);
/*     */         return;
/*     */       } 
/* 517 */       this.player.allBlobData.five2FiveBtlReportPO = five2FiveBtlReportPO;
/*     */     } 
/* 519 */     res.setS2CCode(200);
/* 520 */     for (Five2FivePlayerBtlReportPO btlReport : five2FiveBtlReportPO) {
/* 521 */       Map<String, Five2FivePlayerResultInfoVo> resultInfosA = btlReport.resultInfoA;
/* 522 */       Map<String, Five2FivePlayerResultInfoVo> resultInfosB = btlReport.resultInfoB;
/* 523 */       Map<String, Five2FivePlayerResultInfoVo> resultInfos = new HashMap<>();
/* 524 */       resultInfos.putAll(resultInfosA);
/* 525 */       resultInfos.putAll(resultInfosB);
/* 526 */       Five2FivePlayerResultInfoVo resultInfo = resultInfos.get(playerId);
/* 527 */       Five2FiveHandler.Five2FiveBtlReport.Builder five2FiveBtlReport = Five2FiveHandler.Five2FiveBtlReport.newBuilder();
/* 528 */       five2FiveBtlReport.setStatus(btlReport.status);
/* 529 */       five2FiveBtlReport.setScoreChange(btlReport.scoreChange);
/* 530 */       five2FiveBtlReport.setKillCount(resultInfo.killCount);
/* 531 */       five2FiveBtlReport.setHurt(resultInfo.hurt);
/* 532 */       five2FiveBtlReport.setTreatMent(resultInfo.treatMent);
/* 533 */       Date createTime = btlReport.createTime;
/* 534 */       String createTimeStr = DateUtil.format(createTime, "yyyy/MM/dd");
/* 535 */       five2FiveBtlReport.setCreateTime(createTimeStr);
/* 536 */       playerResultInfo.add(five2FiveBtlReport.build());
/*     */     } 
/* 538 */     res.addAllBr(playerResultInfo);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void lookMatchResult(String matchResultId, Five2FiveHandler.Five2FiveLookMatchResultResponse.Builder res) {
/* 548 */     List<Five2FivePlayerResultInfoVo> resultInfos = Five2FiveService.getInstance().queryResultInfos(matchResultId);
/* 549 */     if (resultInfos.size() == 0) {
/* 550 */       res.setS2CCode(500);
/* 551 */       res.setS2CMsg(LangService.getValue("FIVE_2_FIVE_NO_REPORT"));
/*     */       return;
/*     */     } 
/* 554 */     res.setS2CCode(200);
/* 555 */     List<Five2FivePlayerResultInfoVo> playerResultInfos = Five2FiveService.getInstance().queryResultInfos(matchResultId);
/* 556 */     List<Five2FiveHandler.Five2FivePlayerResultInfo> playerResultInfosA = new ArrayList<>();
/* 557 */     List<Five2FiveHandler.Five2FivePlayerResultInfo> playerResultInfosB = new ArrayList<>();
/* 558 */     int number = 0;
/* 559 */     for (Five2FivePlayerResultInfoVo everyResultInfo : playerResultInfos) {
/* 560 */       Five2FiveHandler.Five2FivePlayerResultInfo.Builder tempResult = Five2FiveHandler.Five2FivePlayerResultInfo.newBuilder();
/* 561 */       tempResult.setHurt(everyResultInfo.hurt);
/* 562 */       tempResult.setIsMvp(everyResultInfo.isMvp);
/* 563 */       tempResult.setKillCount(everyResultInfo.killCount);
/* 564 */       tempResult.setPlayerId(everyResultInfo.playerId);
/* 565 */       tempResult.setTreatMent(everyResultInfo.treatMent);
/* 566 */       tempResult.setPlayerName(everyResultInfo.playerName);
/* 567 */       tempResult.setPlayerLevel(everyResultInfo.playerLevel);
/* 568 */       tempResult.setPlayerPro(everyResultInfo.playerPro);
/* 569 */       tempResult.setDeadCount(everyResultInfo.deadCount);
/* 570 */       if (number < Five2FiveMatchPool.getBeginNeedCount()) {
/* 571 */         playerResultInfosA.add(tempResult.build());
/*     */       } else {
/* 573 */         playerResultInfosB.add(tempResult.build());
/*     */       } 
/* 575 */       number++;
/*     */     } 
/* 577 */     res.setS2CCode(200);
/* 578 */     res.addAllResultInfoA(playerResultInfosA);
/* 579 */     res.addAllResultInfoB(playerResultInfosB);
/* 580 */     res.setResultA(((Five2FivePlayerResultInfoVo)resultInfos.get(0)).resultA);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void refreshRewardCount() {
/* 587 */     Five2FivePO five2FivePo = this.player.allBlobData.five2FivePo;
/* 588 */     Date lastChallengeTime = five2FivePo.lastChallengeTime;
/* 589 */     if (lastChallengeTime == null || DateUtil.canRefreshData(5, lastChallengeTime)) {
/* 590 */       five2FivePo.canReciveRewardCount = 0;
/* 591 */       five2FivePo.hasReciveRewardCount = 0;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int canReciveRewardCount() {
/* 602 */     Five2FivePO five2FivePo = this.player.allBlobData.five2FivePo;
/* 603 */     if (five2FivePo == null) {
/* 604 */       return 0;
/*     */     }
/* 606 */     refreshRewardCount();
/* 607 */     return five2FivePo.canReciveRewardCount - five2FivePo.hasReciveRewardCount;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date applyMatchTime(String playerId) {
/* 617 */     return Five2FiveService.getInstance().applyMatchTime(playerId);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void refreshNewDay() {
/* 624 */     updateSuperScript();
/* 625 */     Out.debug(new Object[] { "==========>> Five2FiveManager.refreshNewDay() on ", new Date() });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String leaveFive2FiveArea() {
/* 635 */     int historyAreaId = (this.player.getPlayerTempData()).historyAreaId;
/* 636 */     if (historyAreaId <= 0) {
/* 637 */       return LangService.getValue("AREA_ID_NULL");
/*     */     }
/*     */     
/* 640 */     Object finalResult = AreaUtil.dispatchByAreaId(this.player, historyAreaId, (this.player.getPlayerTempData()).historyX, (this.player.getPlayerTempData()).historyY);
/* 641 */     if (finalResult != null) {
/* 642 */       return LangService.getValue("AREA_ID_NULL");
/*     */     }
/* 644 */     return LangService.getValue("SOMETHING_ERR");
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
/*     */ 
/*     */   
/*     */   public void onGameEnd(String resultInstanceId, int result, int killCount, int hurt, int treatMent, int scoreChange, boolean isMvp, Map<String, Five2FivePlayerResultInfoVo> resultInfosA, Map<String, Five2FivePlayerResultInfoVo> resultInfosB) {
/* 662 */     Five2FivePO five2FivePO = this.player.allBlobData.five2FivePo;
/* 663 */     refreshFive2FiveInfo(five2FivePO);
/* 664 */     int oldScore = five2FivePO.score;
/* 665 */     five2FivePO.score = (five2FivePO.score + scoreChange < 0) ? 0 : (five2FivePO.score + scoreChange);
/* 666 */     if (result == Five2FiveService.Five2FiveResult.WIN.ordinal()) {
/* 667 */       five2FivePO.winCount++;
/* 668 */     } else if (result == Five2FiveService.Five2FiveResult.TIE.ordinal()) {
/* 669 */       five2FivePO.tieCount++;
/*     */     } else {
/* 671 */       five2FivePO.failCount++;
/*     */     } 
/* 673 */     if (isMvp) {
/* 674 */       five2FivePO.mvpCount++;
/*     */     }
/* 676 */     five2FivePO.canReciveRewardCount = (five2FivePO.canReciveRewardCount + 1 >= GlobalConfig.Group_RewardTimes) ? GlobalConfig.Group_RewardTimes : (five2FivePO.canReciveRewardCount + 1);
/* 677 */     five2FivePO.lastChallengeTime = new Date();
/*     */ 
/*     */     
/* 680 */     Five2FivePlayerBtlReportPO reportPo = new Five2FivePlayerBtlReportPO();
/* 681 */     reportPo.id = resultInstanceId;
/* 682 */     reportPo.playerId = this.player.getId();
/* 683 */     reportPo.status = result;
/* 684 */     reportPo.scoreChange = five2FivePO.score - oldScore;
/* 685 */     reportPo.resultInfoA = resultInfosA;
/* 686 */     reportPo.resultInfoB = resultInfosB;
/* 687 */     reportPo.createTime = new Date();
/* 688 */     List<Five2FivePlayerBtlReportPO> reportPos = this.player.allBlobData.five2FiveBtlReportPO;
/* 689 */     if (reportPos == null) {
/* 690 */       reportPos = Five2FiveDao.getPlayerFive2FiveBtlReportPO(this.player.getId());
/*     */     }
/* 692 */     if (reportPos.size() >= GlobalConfig.Group_Record) {
/* 693 */       Five2FivePlayerBtlReportPO firstBtlReport = reportPos.get(reportPos.size() - 1);
/* 694 */       Five2FiveService.getInstance().delPlayerFive2FiveBtlReportPO(firstBtlReport);
/* 695 */       reportPos.remove(reportPos.size() - 1);
/* 696 */       Out.info(new Object[] { "试炼战报,删除多余的战报:角色id=", this.player.getId(), ",战报id=", firstBtlReport.id });
/*     */     } 
/* 698 */     reportPos.add(0, reportPo);
/* 699 */     this.player.allBlobData.five2FiveBtlReportPO = reportPos;
/*     */     
/* 701 */     Five2FiveService.getInstance().updatePlayerFive2FiveBtlReportPO(reportPo);
/* 702 */     Out.info(new Object[] { "试炼战报,写入战报:角色id=", this.player.getId(), ",战报id=", reportPo.id });
/*     */     
/* 704 */     int oldRank = Five2FiveService.getInstance().getPlayerRank(this.player.getId());
/*     */ 
/*     */     
/* 707 */     RankType.PVP_5V5.getHandler().asyncUpdateRank(GWorld.__SERVER_ID, this.player.getId(), five2FivePO.score);
/*     */     
/* 709 */     Five2FiveHandler.Five2FiveOnGameEndPush.Builder gameEndPush = Five2FiveHandler.Five2FiveOnGameEndPush.newBuilder();
/* 710 */     gameEndPush.setS2CCode(200);
/* 711 */     Five2FiveHandler.Five2FiveGameResult.Builder gameResult = Five2FiveHandler.Five2FiveGameResult.newBuilder();
/* 712 */     gameResult.setResult(result);
/* 713 */     gameResult.setNewScore(five2FivePO.score - oldScore);
/* 714 */     gameResult.setCurrScore(five2FivePO.score);
/* 715 */     gameResult.setMvpCount(five2FivePO.mvpCount);
/* 716 */     int currentRank = Five2FiveService.getInstance().getPlayerRank(this.player.getId());
/* 717 */     gameResult.setRankChange((oldRank == 0) ? currentRank : (oldRank - currentRank));
/* 718 */     gameResult.setCurrRank(currentRank);
/* 719 */     gameResult.setInstanceId(resultInstanceId);
/* 720 */     gameEndPush.setS2CGameResult(gameResult);
/* 721 */     gameEndPush.setS2CGameOverTime(((GameMapCO)GameData.GameMaps.get(Integer.valueOf(GlobalConfig.Group_Map))).timeCount);
/* 722 */     List<Five2FiveHandler.Five2FivePlayerResultInfo> resultsA = new ArrayList<>();
/* 723 */     for (Five2FivePlayerResultInfoVo resultInfoVo : resultInfosA.values()) {
/* 724 */       Five2FiveHandler.Five2FivePlayerResultInfo.Builder temp = Five2FiveHandler.Five2FivePlayerResultInfo.newBuilder();
/* 725 */       temp.setPlayerId(resultInfoVo.playerId);
/* 726 */       temp.setKillCount(resultInfoVo.killCount);
/* 727 */       temp.setHurt(resultInfoVo.hurt);
/* 728 */       temp.setTreatMent(resultInfoVo.treatMent);
/* 729 */       temp.setIsMvp(resultInfoVo.isMvp);
/* 730 */       temp.setPlayerName(resultInfoVo.playerName);
/* 731 */       temp.setPlayerLevel(resultInfoVo.playerLevel);
/* 732 */       temp.setPlayerPro(resultInfoVo.playerPro);
/* 733 */       temp.setDeadCount(resultInfoVo.deadCount);
/* 734 */       resultsA.add(temp.build());
/*     */     } 
/* 736 */     List<Five2FiveHandler.Five2FivePlayerResultInfo> resultsB = new ArrayList<>();
/* 737 */     for (Five2FivePlayerResultInfoVo resultInfoVo : resultInfosB.values()) {
/* 738 */       Five2FiveHandler.Five2FivePlayerResultInfo.Builder temp = Five2FiveHandler.Five2FivePlayerResultInfo.newBuilder();
/* 739 */       temp.setPlayerId(resultInfoVo.playerId);
/* 740 */       temp.setKillCount(resultInfoVo.killCount);
/* 741 */       temp.setHurt(resultInfoVo.hurt);
/* 742 */       temp.setTreatMent(resultInfoVo.treatMent);
/* 743 */       temp.setIsMvp(resultInfoVo.isMvp);
/* 744 */       temp.setPlayerName(resultInfoVo.playerName);
/* 745 */       temp.setPlayerLevel(resultInfoVo.playerLevel);
/* 746 */       temp.setPlayerPro(resultInfoVo.playerPro);
/* 747 */       temp.setDeadCount(resultInfoVo.deadCount);
/* 748 */       resultsB.add(temp.build());
/*     */     } 
/* 750 */     gameEndPush.addAllResultInfoA(resultsA);
/* 751 */     gameEndPush.addAllResultInfoB(resultsB);
/* 752 */     this.player.receive("five2five.five2FivePush.five2FiveOnGameEndPush", (GeneratedMessage)gameEndPush.build());
/* 753 */     this.player.dailyActivityMgr.onEvent(Const.DailyType.PVP_5V5, "0", 1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onPlayerOffline() {
/* 760 */     if (Five2FiveService.getInstance().isInOpenTime()) {
/* 761 */       Five2FiveMatchPool.singleRemoveApplyPool(this.player.getId());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onPlayerOnline() {
/* 769 */     Five2FivePO five2FivePO = this.player.allBlobData.five2FivePo;
/* 770 */     if (five2FivePO == null) {
/* 771 */       five2FivePO = Five2FiveDao.getPlayerFive2FivePO(this.player.getId());
/* 772 */       if (five2FivePO == null) {
/*     */         return;
/*     */       }
/* 775 */       this.player.allBlobData.five2FivePo = five2FivePO;
/*     */     } 
/* 777 */     Five2FiveSystemPO five2FiveSystemPo = Five2FiveService.getInstance().getFive2FiveSystemPO();
/* 778 */     if (five2FiveSystemPo != null) {
/* 779 */       Map<String, Integer> hasNoReciveRankRewardPlayer = five2FiveSystemPo.hasNoReciveRankRewardPlayer;
/* 780 */       if (hasNoReciveRankRewardPlayer != null && hasNoReciveRankRewardPlayer.containsKey(this.player.getId())) {
/* 781 */         Map<Integer, PersonalRankExt> personalRanks = GameData.PersonalRanks;
/* 782 */         PersonalRankExt maxExt = null;
/* 783 */         for (PersonalRankExt temp : personalRanks.values()) {
/* 784 */           if (maxExt == null || (temp.startRank > maxExt.startRank && temp.stopRank > maxExt.stopRank)) {
/* 785 */             maxExt = temp;
/*     */           }
/*     */         } 
/* 788 */         PersonalRankExt rankExt = null;
/* 789 */         int rank = ((Integer)hasNoReciveRankRewardPlayer.get(this.player.getId())).intValue();
/* 790 */         for (PersonalRankExt rankReward : personalRanks.values()) {
/* 791 */           int startRank = rankReward.startRank;
/* 792 */           int endRank = rankReward.stopRank;
/* 793 */           if (rank >= startRank && rank <= endRank) {
/* 794 */             rankExt = rankReward;
/*     */             break;
/*     */           } 
/*     */         } 
/* 798 */         if (rankExt == null) {
/* 799 */           rankExt = maxExt;
/*     */         }
/* 801 */         Map<String, Integer> rankRewards = rankExt.rankRewards;
/* 802 */         MailSysData mailData = new MailSysData("Trial_Competition");
/* 803 */         Map<String, String> replace = new HashMap<>();
/* 804 */         replace.put("rank", String.valueOf(rank));
/* 805 */         mailData.replace = replace;
/* 806 */         mailData.attachments = new ArrayList();
/*     */         
/* 808 */         for (Map.Entry<String, Integer> attach : rankRewards.entrySet()) {
/* 809 */           MailData.Attachment item = new MailData.Attachment();
/* 810 */           item.itemCode = attach.getKey();
/* 811 */           item.itemNum = ((Integer)attach.getValue()).intValue();
/* 812 */           mailData.attachments.add(item);
/*     */         } 
/* 814 */         MailUtil.getInstance().sendMailToOnePlayer(this.player.getId(), (MailData)mailData, Const.GOODS_CHANGE_TYPE.five2five);
/* 815 */         hasNoReciveRankRewardPlayer.remove(this.player.getId());
/* 816 */         Five2FiveService.getInstance().updateFive2FiveSystem(five2FiveSystemPo);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void refreshFive2FiveInfo(Five2FivePO five2FivePO) {
/* 827 */     Five2FiveSystemPO five2FiveSystemPo = Five2FiveService.getInstance().getFive2FiveSystemPO();
/* 828 */     Date seasonRefreshTime = five2FiveSystemPo.seasonRefreshTime;
/*     */     
/* 830 */     if (five2FivePO.updateTime == null || !DateUtil.isSameDay(five2FivePO.updateTime, seasonRefreshTime)) {
/* 831 */       five2FivePO.score = 0;
/* 832 */       five2FivePO.winCount = 0;
/* 833 */       five2FivePO.tieCount = 0;
/* 834 */       five2FivePO.failCount = 0;
/* 835 */       five2FivePO.mvpCount = 0;
/* 836 */       five2FivePO.updateTime = seasonRefreshTime;
/*     */     } 
/* 838 */     refreshRewardCount();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void updateSuperScript() {
/* 845 */     List<PlayerHandler.SuperScriptType> list = new ArrayList<>();
/* 846 */     list.addAll(getSuperScript());
/* 847 */     this.player.updateSuperScriptList(list);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<PlayerHandler.SuperScriptType> getSuperScript() {
/* 857 */     List<PlayerHandler.SuperScriptType> list = new ArrayList<>();
/* 858 */     if (!this.player.functionOpenManager.isOpen(Const.FunctionType.FIVE_2_FIVE.getValue())) {
/* 859 */       return list;
/*     */     }
/* 861 */     PlayerHandler.SuperScriptType.Builder data = PlayerHandler.SuperScriptType.newBuilder();
/* 862 */     data.setType(Const.SUPERSCRIPT_TYPE.FIVE_2_FIVE_REWARD.getValue());
/* 863 */     data.setNumber(canReciveRewardCount());
/*     */     
/* 865 */     PlayerHandler.SuperScriptType.Builder data2 = PlayerHandler.SuperScriptType.newBuilder();
/* 866 */     data2.setType(Const.SUPERSCRIPT_TYPE.FIVE_2_FIVE.getValue());
/* 867 */     data2.setNumber(Five2FiveService.getInstance().isInOpenTime() ? 1 : 0);
/*     */     
/* 869 */     list.add(data.build());
/* 870 */     list.add(data2.build());
/* 871 */     return list;
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
/*     */   public void onPlayerEvent(Const.PlayerEventType eventType) {
/* 883 */     switch (eventType) {
/*     */       case REFRESH_NEWDAY:
/* 885 */         refreshNewDay();
/*     */         break;
/*     */       case AFTER_LOGIN:
/* 888 */         onPlayerOnline();
/*     */         break;
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
/*     */   public Const.ManagerType getManagerType() {
/* 903 */     return Const.ManagerType.FIVE_2_FIVE;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\five2Five\Five2FiveManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */