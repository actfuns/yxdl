/*     */ package com.wanniu.game.five2Five;
/*     */ 
/*     */ import com.google.protobuf.GeneratedMessage;
/*     */ import com.wanniu.core.game.JobFactory;
/*     */ import com.wanniu.core.game.LangService;
/*     */ import com.wanniu.core.game.entity.GPlayer;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.util.DateUtil;
/*     */ import com.wanniu.game.GWorld;
/*     */ import com.wanniu.game.area.Area;
/*     */ import com.wanniu.game.area.AreaData;
/*     */ import com.wanniu.game.area.AreaUtil;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.Utils;
/*     */ import com.wanniu.game.data.GameData;
/*     */ import com.wanniu.game.data.GameMapCO;
/*     */ import com.wanniu.game.data.base.MapBase;
/*     */ import com.wanniu.game.data.ext.PersonalRankExt;
/*     */ import com.wanniu.game.five2Five.dao.Five2FiveDao;
/*     */ import com.wanniu.game.functionOpen.FunctionOpenUtil;
/*     */ import com.wanniu.game.item.ItemUtil;
/*     */ import com.wanniu.game.item.NormalItem;
/*     */ import com.wanniu.game.leaderBoard.LeaderBoardDetail;
/*     */ import com.wanniu.game.mail.MailUtil;
/*     */ import com.wanniu.game.mail.data.MailData;
/*     */ import com.wanniu.game.mail.data.MailSysData;
/*     */ import com.wanniu.game.player.GlobalConfig;
/*     */ import com.wanniu.game.player.PlayerUtil;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.poes.Five2FivePO;
/*     */ import com.wanniu.game.poes.Five2FivePlayerBtlReportPO;
/*     */ import com.wanniu.game.poes.Five2FiveSystemPO;
/*     */ import com.wanniu.game.rank.RankType;
/*     */ import com.wanniu.game.team.TeamData;
/*     */ import com.wanniu.game.team.TeamManager;
/*     */ import com.wanniu.game.team.TeamService;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.UUID;
/*     */ import java.util.concurrent.CopyOnWriteArrayList;
/*     */ import java.util.concurrent.TimeUnit;
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
/*     */ public class Five2FiveService
/*     */ {
/*  70 */   private static final long MIN_SEASON_MILLISEC = TimeUnit.DAYS.toMillis(3L);
/*     */ 
/*     */   
/*     */   private Five2FiveSystemPO five2FiveSystemPo;
/*     */ 
/*     */ 
/*     */   
/*     */   public enum Five2FiveResult
/*     */   {
/*  79 */     DEFAULT, WIN, FAIL, TIE;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Five2FiveService getInstance() {
/*  85 */     if (instance == null) {
/*  86 */       synchronized (Five2FiveService.class) {
/*  87 */         if (instance == null) {
/*  88 */           instance = new Five2FiveService();
/*     */         }
/*     */       } 
/*     */     }
/*  92 */     return instance;
/*     */   }
/*     */   
/*  95 */   private static Five2FiveService instance = null;
/*     */   
/*     */   private Five2FiveService() {
/*  98 */     init();
/*     */   }
/*     */ 
/*     */   
/*     */   private void init() {
/* 103 */     JobFactory.addDelayJob(new Five2FiveMatchTeamThread(), 3000L, TimeUnit.MILLISECONDS);
/*     */     
/* 105 */     this.five2FiveSystemPo = Five2FiveDao.getFive2FivePO(String.valueOf(GWorld.__SERVER_ID));
/* 106 */     if (this.five2FiveSystemPo == null) {
/* 107 */       this.five2FiveSystemPo = new Five2FiveSystemPO();
/* 108 */       this.five2FiveSystemPo.logicServerId = GWorld.__SERVER_ID;
/* 109 */       this.five2FiveSystemPo.id = UUID.randomUUID().toString();
/* 110 */       this.five2FiveSystemPo.seasonRefreshTime = calcSoloSeasonTime();
/* 111 */       updateFive2FiveSystem(this.five2FiveSystemPo);
/*     */     } 
/*     */ 
/*     */     
/* 115 */     long initialDelay = this.five2FiveSystemPo.seasonRefreshTime.getTime() - System.currentTimeMillis();
/* 116 */     JobFactory.addFixedRateJob(new Runnable()
/*     */         {
/*     */           public void run()
/*     */           {
/*     */             try {
/* 121 */               Out.info(new Object[] { "开始发放5v5周奖励" }, );
/* 122 */               List<LeaderBoardDetail> datas = RankType.PVP_5V5.getHandler().getRankDetail(Five2FiveService.this.five2FiveSystemPo.logicServerId, 0, -1);
/* 123 */               int rank = 1;
/* 124 */               for (LeaderBoardDetail detail : datas) {
/* 125 */                 String playerId = detail.memberId;
/* 126 */                 WNPlayer player = PlayerUtil.getOnlinePlayer(playerId);
/* 127 */                 if (player != null) {
/* 128 */                   Map<Integer, PersonalRankExt> personalRanks = GameData.PersonalRanks;
/* 129 */                   PersonalRankExt maxExt = null;
/* 130 */                   for (PersonalRankExt temp : personalRanks.values()) {
/* 131 */                     if (maxExt == null || (temp.startRank > maxExt.startRank && temp.stopRank > maxExt.stopRank)) {
/* 132 */                       maxExt = temp;
/*     */                     }
/*     */                   } 
/* 135 */                   PersonalRankExt rankExt = null;
/* 136 */                   for (PersonalRankExt rankReward : personalRanks.values()) {
/* 137 */                     int startRank = rankReward.startRank;
/* 138 */                     int endRank = rankReward.stopRank;
/* 139 */                     if (rank >= startRank && rank <= endRank) {
/* 140 */                       rankExt = rankReward;
/*     */                       break;
/*     */                     } 
/*     */                   } 
/* 144 */                   if (rankExt == null) {
/* 145 */                     rankExt = maxExt;
/*     */                   }
/* 147 */                   Map<String, Integer> rankRewards = rankExt.rankRewards;
/* 148 */                   MailSysData mailData = new MailSysData("Trial_Competition");
/* 149 */                   Map<String, String> replace = new HashMap<>();
/* 150 */                   replace.put("rank", String.valueOf(rank));
/* 151 */                   mailData.replace = replace;
/* 152 */                   mailData.attachments = new ArrayList();
/*     */                   
/* 154 */                   for (Map.Entry<String, Integer> attach : rankRewards.entrySet()) {
/* 155 */                     MailData.Attachment item = new MailData.Attachment();
/* 156 */                     item.itemCode = attach.getKey();
/* 157 */                     item.itemNum = ((Integer)attach.getValue()).intValue();
/* 158 */                     mailData.attachments.add(item);
/*     */                   } 
/* 160 */                   MailUtil.getInstance().sendMailToOnePlayer(playerId, (MailData)mailData, Const.GOODS_CHANGE_TYPE.five2five);
/*     */                 } else {
/* 162 */                   Map<String, Integer> hasNoReciveRankRewardPlayer = Five2FiveService.this.five2FiveSystemPo.hasNoReciveRankRewardPlayer;
/* 163 */                   if (hasNoReciveRankRewardPlayer == null) {
/* 164 */                     hasNoReciveRankRewardPlayer = new HashMap<>();
/*     */                   }
/* 166 */                   hasNoReciveRankRewardPlayer.put(playerId, Integer.valueOf(rank));
/* 167 */                   Five2FiveService.this.five2FiveSystemPo.hasNoReciveRankRewardPlayer = hasNoReciveRankRewardPlayer;
/*     */                 } 
/* 169 */                 rank++;
/*     */               } 
/* 171 */               RankType.PVP_5V5.getHandler().delRank(GWorld.__SERVER_ID);
/* 172 */               Out.info(new Object[] { "发放5v5周奖励结束" });
/* 173 */               Five2FiveService.this.five2FiveSystemPo.seasonRefreshTime = Five2FiveService.this.calcSoloSeasonTime();
/*     */               
/* 175 */               Five2FiveService.this.updateFive2FiveSystem(Five2FiveService.this.five2FiveSystemPo);
/* 176 */             } catch (Exception e) {
/* 177 */               Out.error(new Object[] { e });
/*     */             } 
/*     */           }
/* 180 */         }initialDelay, TimeUnit.DAYS.toMillis(7L));
/*     */ 
/*     */     
/* 183 */     for (String times : GlobalConfig.Group_Daily_OpenTime.split(";")) {
/* 184 */       String[] time = times.split(",");
/* 185 */       Date begin = DateUtil.format(time[0]);
/* 186 */       Date end = DateUtil.format(time[1]);
/* 187 */       JobFactory.addScheduleJob(new Runnable()
/*     */           {
/*     */             public void run()
/*     */             {
/* 191 */               for (GPlayer p : PlayerUtil.getAllOnlinePlayer()) {
/* 192 */                 WNPlayer wp = (WNPlayer)p;
/* 193 */                 wp.updateSuperScriptList(wp.five2FiveManager.getSuperScript());
/*     */               } 
/*     */             }
/* 196 */           },  DateUtil.getTaskDelay(begin), TimeUnit.DAYS.toMillis(1L));
/*     */       
/* 198 */       JobFactory.addScheduleJob(new Runnable()
/*     */           {
/*     */             public void run()
/*     */             {
/* 202 */               for (GPlayer p : PlayerUtil.getAllOnlinePlayer()) {
/* 203 */                 WNPlayer wp = (WNPlayer)p;
/* 204 */                 wp.updateSuperScriptList(wp.five2FiveManager.getSuperScript());
/* 205 */                 wp.five2FiveManager.cancelFive2FiveMatch(false);
/*     */               } 
/* 207 */               Five2FiveMatchPool.clearMatchPool();
/*     */             }
/* 209 */           },  DateUtil.getTaskDelay(end), TimeUnit.DAYS.toMillis(1L));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Date calcSoloSeasonTime() {
/* 219 */     Date endDate = calcSeasonEndTime(7, 0);
/* 220 */     if (endDate.getTime() - System.currentTimeMillis() < MIN_SEASON_MILLISEC) {
/* 221 */       endDate = calcSeasonEndTime(14, 0);
/*     */     }
/* 223 */     return endDate;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Date calcSeasonEndTime(int term, int endWeekDay) {
/* 234 */     if (endWeekDay >= 7) {
/* 235 */       endWeekDay = 0;
/*     */     }
/* 237 */     Date endDate = DateUtil.getFiveTimeOfDay(DateUtil.getDateAfter(term));
/* 238 */     Calendar endC = Calendar.getInstance();
/* 239 */     endC.setTime(endDate);
/* 240 */     endC.set(7, endWeekDay + 1);
/*     */     
/* 242 */     return endC.getTime();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getAvgWaitTime(boolean single) {
/* 252 */     long totalWaitTime = 0L;
/* 253 */     int totalMatchSuccessCount = 0;
/* 254 */     if (single) {
/* 255 */       totalWaitTime = this.five2FiveSystemPo.singleTotalMatchSuccessCostTime;
/* 256 */       totalMatchSuccessCount = this.five2FiveSystemPo.totalMatchSuccessSingle;
/*     */     } else {
/* 258 */       totalWaitTime = this.five2FiveSystemPo.teamTotalMatchSuccessCostTime;
/* 259 */       totalMatchSuccessCount = this.five2FiveSystemPo.totalMatchSuccessTeam;
/*     */     } 
/* 261 */     if (totalMatchSuccessCount == 0) {
/* 262 */       return GlobalConfig.Group_AverageTime;
/*     */     }
/* 264 */     return (int)(totalWaitTime / totalMatchSuccessCount / 1000L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void singleApplyMatch(WNPlayer player) {
/* 273 */     Five2FiveMatchPool.singlePutInApplyPool(player);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void teamApplyMatch(TeamData teamData) {
/* 282 */     Five2FiveMatchPool.teamPutInApplyPool(teamData.teamMembers, teamData.id);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date applyMatchTime(String playerId) {
/* 292 */     return Five2FiveMatchPool.applyMatchTime(playerId);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String isCanEnter(WNPlayer player) {
/* 303 */     if (!isInOpenTime()) {
/* 304 */       return LangService.getValue("FIVE_2_FIVE_NOT_IN_TIME");
/*     */     }
/* 306 */     if (player.getLevel() < (FunctionOpenUtil.findFunctionOpenPropsByFuncName("5v5")).openLv) {
/* 307 */       return LangService.getValue("FIVE_2_FIVE_NOT_ENOUGH_LEVEL");
/*     */     }
/* 309 */     TeamManager tm = player.teamManager;
/* 310 */     boolean isInTeam = tm.isInTeam();
/* 311 */     GameMapCO gameMapCO = (GameMapCO)GameData.GameMaps.get(Integer.valueOf(GlobalConfig.Group_Map));
/*     */     
/* 313 */     Date applyMatchTime = applyMatchTime(player.getId());
/* 314 */     if (applyMatchTime != null) {
/* 315 */       return LangService.getValue("FIVE_2_FIVE_MATCHING");
/*     */     }
/*     */     
/* 318 */     if (player.soloManager.isBusy() || player.soloManager.isInMatching()) {
/* 319 */       return LangService.getValue("FIVE_2_FIVE_BUSY");
/*     */     }
/* 321 */     if (isInTeam) {
/* 322 */       boolean isTeamLeader = tm.isTeamLeader();
/* 323 */       if (!isTeamLeader) {
/* 324 */         return LangService.getValue("TEAM_NO_AUTHORITY");
/*     */       }
/* 326 */       Map<String, TeamData.TeamMemberData> teamMembers = tm.getTeamMembers();
/* 327 */       for (Map.Entry<String, TeamData.TeamMemberData> teamMember : teamMembers.entrySet()) {
/* 328 */         String teamPlayerId = teamMember.getKey();
/* 329 */         if (!PlayerUtil.isOnline(teamPlayerId)) {
/* 330 */           return LangService.getValue("FIVE_2_FIVE_NOT_ONLINE");
/*     */         }
/* 332 */         String validateResult = processValidate(PlayerUtil.getOnlinePlayer(teamPlayerId), gameMapCO);
/* 333 */         if (!validateResult.equals("")) {
/* 334 */           return validateResult;
/*     */         }
/*     */       } 
/*     */     } 
/* 338 */     return "";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String processValidate(WNPlayer player, GameMapCO gameMapCO) {
/* 349 */     if (!funIsOpen(player)) {
/* 350 */       return LangService.getValue("FIVE_2_FIVE_MEM_NOT_OPEN");
/*     */     }
/*     */ 
/*     */     
/* 354 */     if (player.soloManager.isBusy() || player.soloManager.isInMatching() || player.arenaManager.isInArenaMap(player.getAreaId())) {
/* 355 */       return LangService.getValue("FIVE_2_FIVE_TEAM_MEM_BUSY");
/*     */     }
/*     */     
/* 358 */     Date applyMatchTime = applyMatchTime(player.getId());
/* 359 */     if (applyMatchTime != null) {
/* 360 */       return LangService.getValue("FIVE_2_FIVE_TEAM_MEM_BUSY");
/*     */     }
/*     */     
/* 363 */     String isCan = AreaUtil.canEnterArea((MapBase)gameMapCO, player);
/* 364 */     if (isCan != null) {
/* 365 */       return isCan;
/*     */     }
/* 367 */     return "";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isInOpenTime() {
/* 376 */     if (GWorld.DEBUG) {
/* 377 */       return true;
/*     */     }
/* 379 */     Calendar c = Calendar.getInstance();
/* 380 */     int weekDay = c.get(7) - 1;
/* 381 */     if (!GlobalConfig.Group_Weekly_OpenTime.contains(String.valueOf(weekDay))) {
/* 382 */       return false;
/*     */     }
/* 384 */     Date nowTime = c.getTime();
/* 385 */     for (String times : GlobalConfig.Group_Daily_OpenTime.split(";")) {
/* 386 */       String[] time = times.split(",");
/* 387 */       Date begin = DateUtil.format(time[0]);
/* 388 */       Date end = DateUtil.format(time[1]);
/* 389 */       if (nowTime.after(begin) && nowTime.before(end)) {
/* 390 */         return true;
/*     */       }
/*     */     } 
/* 393 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean funIsOpen(WNPlayer player) {
/* 403 */     return player.functionOpenManager.isOpen(Const.FunctionType.FIVE_2_FIVE.getValue());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getFive2FiveScore(String playerId) {
/* 413 */     WNPlayer player = PlayerUtil.getOnlinePlayer(playerId);
/* 414 */     Five2FivePO five2FivePO = null;
/* 415 */     if (player == null) {
/* 416 */       five2FivePO = Five2FiveDao.getPlayerFive2FivePO(playerId);
/*     */     } else {
/* 418 */       five2FivePO = player.allBlobData.five2FivePo;
/* 419 */       if (five2FivePO == null) {
/* 420 */         five2FivePO = Five2FiveDao.getPlayerFive2FivePO(playerId);
/* 421 */         player.allBlobData.five2FivePo = five2FivePO;
/*     */       } 
/*     */     } 
/* 424 */     int score = five2FivePO.score;
/* 425 */     return score;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void processTeamChangeOnFive2Five(String leaderId) {
/* 434 */     Date applyTime = applyMatchTime(leaderId);
/*     */     
/* 436 */     if (applyTime != null) {
/* 437 */       Five2FiveHandler.Five2FiveTeamChangePush.Builder teamChangePush = Five2FiveHandler.Five2FiveTeamChangePush.newBuilder();
/* 438 */       teamChangePush.setS2CCode(200);
/* 439 */       WNPlayer leaderPlayer = PlayerUtil.getOnlinePlayer(leaderId);
/* 440 */       if (leaderPlayer == null) {
/*     */         return;
/*     */       }
/* 443 */       leaderPlayer.receive("five2five.five2FivePush.five2FiveTeamChangePush", (GeneratedMessage)teamChangePush.build());
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
/*     */   public void five2FiveAfterMatchSucess(Five2FiveMatchTeamVo matchTeamVoA, Five2FiveMatchTeamVo matchTeamVoB) {
/* 455 */     List<Five2FiveTempTeamMember> tempTeamMemsA = matchTeamVoA.tempTeamMember;
/* 456 */     int memNumberA = tempTeamMemsA.size();
/* 457 */     List<Five2FiveHandler.Five2FiveMatchMemberInfo> matchMemInfosA = new ArrayList<>();
/* 458 */     for (int i = 0; i < memNumberA; i++) {
/* 459 */       Five2FiveHandler.Five2FiveMatchMemberInfo.Builder matchMemInfo = Five2FiveHandler.Five2FiveMatchMemberInfo.newBuilder();
/* 460 */       Five2FiveTempTeamMember tempTeamMem = tempTeamMemsA.get(i);
/* 461 */       matchMemInfo.setPlayerId(tempTeamMem.playerId);
/* 462 */       matchMemInfo.setPlayerPro(tempTeamMem.playerPro);
/* 463 */       matchMemInfo.setPlayerLvl(tempTeamMem.playerLvl);
/* 464 */       matchMemInfo.setPlayerName(tempTeamMem.playerName);
/* 465 */       matchMemInfo.setReadyStatus(0);
/* 466 */       matchMemInfosA.add(matchMemInfo.build());
/*     */     } 
/*     */ 
/*     */     
/* 470 */     List<Five2FiveTempTeamMember> tempTeamMemsB = matchTeamVoB.tempTeamMember;
/* 471 */     int memNumberB = tempTeamMemsB.size();
/* 472 */     List<Five2FiveHandler.Five2FiveMatchMemberInfo> matchMemInfosB = new ArrayList<>();
/* 473 */     for (int j = 0; j < memNumberB; j++) {
/* 474 */       Five2FiveHandler.Five2FiveMatchMemberInfo.Builder matchMemInfo = Five2FiveHandler.Five2FiveMatchMemberInfo.newBuilder();
/* 475 */       Five2FiveTempTeamMember tempTeamMem = tempTeamMemsB.get(j);
/* 476 */       matchMemInfo.setPlayerId(tempTeamMem.playerId);
/* 477 */       matchMemInfo.setPlayerPro(tempTeamMem.playerPro);
/* 478 */       matchMemInfo.setPlayerLvl(tempTeamMem.playerLvl);
/* 479 */       matchMemInfo.setPlayerName(tempTeamMem.playerName);
/* 480 */       matchMemInfo.setReadyStatus(0);
/* 481 */       matchMemInfosB.add(matchMemInfo.build());
/*     */     } 
/*     */ 
/*     */     
/* 485 */     Five2FiveHandler.Five2FiveMatchMemberInfoPush.Builder matchMemPushA = Five2FiveHandler.Five2FiveMatchMemberInfoPush.newBuilder();
/* 486 */     matchMemPushA.setS2CCode(200);
/* 487 */     matchMemPushA.setTempTeamId(matchTeamVoA.tempTeamId);
/* 488 */     matchMemPushA.addAllMatchTeamInfoA(matchMemInfosA);
/* 489 */     matchMemPushA.addAllMatchTeamInfoB(matchMemInfosB);
/* 490 */     int waitResonseTimeSec = GlobalConfig.Group_ReadyTime;
/* 491 */     matchMemPushA.setWaitResponseTimeSec(waitResonseTimeSec);
/* 492 */     for (int k = 0; k < memNumberA; k++) {
/* 493 */       Five2FiveTempTeamMember tempTeamMem = tempTeamMemsA.get(k);
/* 494 */       String playerId = tempTeamMem.playerId;
/* 495 */       WNPlayer player = PlayerUtil.findPlayer(playerId);
/* 496 */       if (player != null)
/*     */       {
/*     */         
/* 499 */         player.receive("five2five.five2FivePush.five2FiveMatchMemberInfoPush", (GeneratedMessage)matchMemPushA.build());
/*     */       }
/*     */     } 
/* 502 */     Five2FiveHandler.Five2FiveMatchMemberInfoPush.Builder matchMemPushB = Five2FiveHandler.Five2FiveMatchMemberInfoPush.newBuilder();
/* 503 */     matchMemPushB.setS2CCode(200);
/* 504 */     matchMemPushB.setTempTeamId(matchTeamVoB.tempTeamId);
/* 505 */     matchMemPushB.addAllMatchTeamInfoA(matchMemInfosA);
/* 506 */     matchMemPushB.addAllMatchTeamInfoB(matchMemInfosB);
/* 507 */     matchMemPushB.setWaitResponseTimeSec(waitResonseTimeSec);
/* 508 */     for (int m = 0; m < memNumberB; m++) {
/* 509 */       Five2FiveTempTeamMember tempTeamMem = tempTeamMemsB.get(m);
/* 510 */       String playerId = tempTeamMem.playerId;
/* 511 */       WNPlayer player = PlayerUtil.findPlayer(playerId);
/* 512 */       if (player != null)
/*     */       {
/*     */         
/* 515 */         player.receive("five2five.five2FivePush.five2FiveMatchMemberInfoPush", (GeneratedMessage)matchMemPushB.build());
/*     */       }
/*     */     } 
/*     */     
/* 519 */     List<Five2FiveTeamApplyVo> teamMatchVosA = matchTeamVoA.teamMatchVos;
/* 520 */     if (teamMatchVosA != null) {
/* 521 */       long teamCostTime = this.five2FiveSystemPo.teamTotalMatchSuccessCostTime;
/* 522 */       for (int n = 0; n < teamMatchVosA.size(); n++) {
/* 523 */         Five2FiveTeamApplyVo teamMatchVoA = teamMatchVosA.get(n);
/* 524 */         long thisTeamCostTime = System.currentTimeMillis() - teamMatchVoA.joinTime.getTime();
/* 525 */         teamCostTime += thisTeamCostTime;
/*     */       } 
/* 527 */       this.five2FiveSystemPo.teamTotalMatchSuccessCostTime = teamCostTime;
/* 528 */       this.five2FiveSystemPo.totalMatchSuccessTeam++;
/*     */     } 
/*     */     
/* 531 */     List<Five2FiveSingleApplyVo> singleMatchVosA = matchTeamVoA.singleMatchVos;
/* 532 */     if (singleMatchVosA != null) {
/* 533 */       long singleCostTime = this.five2FiveSystemPo.singleTotalMatchSuccessCostTime;
/* 534 */       for (Five2FiveSingleApplyVo single : singleMatchVosA) {
/* 535 */         long thisPlayerCostTime = System.currentTimeMillis() - single.joinTime.getTime();
/* 536 */         singleCostTime += thisPlayerCostTime;
/*     */       } 
/* 538 */       this.five2FiveSystemPo.singleTotalMatchSuccessCostTime = singleCostTime;
/* 539 */       this.five2FiveSystemPo.totalMatchSuccessSingle += singleMatchVosA.size();
/*     */     } 
/*     */     
/* 542 */     List<Five2FiveTeamApplyVo> teamMatchVosB = matchTeamVoB.teamMatchVos;
/* 543 */     if (teamMatchVosB != null) {
/* 544 */       long teamCostTime = this.five2FiveSystemPo.teamTotalMatchSuccessCostTime;
/* 545 */       for (int n = 0; n < teamMatchVosB.size(); n++) {
/* 546 */         Five2FiveTeamApplyVo teamMatchVoB = teamMatchVosB.get(n);
/* 547 */         long thisTeamCostTime = System.currentTimeMillis() - teamMatchVoB.joinTime.getTime();
/* 548 */         teamCostTime += thisTeamCostTime;
/*     */       } 
/*     */       
/* 551 */       this.five2FiveSystemPo.teamTotalMatchSuccessCostTime = teamCostTime;
/* 552 */       this.five2FiveSystemPo.totalMatchSuccessTeam++;
/*     */     } 
/*     */     
/* 555 */     List<Five2FiveSingleApplyVo> singleMatchVosB = matchTeamVoB.singleMatchVos;
/* 556 */     if (singleMatchVosB != null) {
/* 557 */       long singleCostTime = this.five2FiveSystemPo.singleTotalMatchSuccessCostTime;
/* 558 */       for (Five2FiveSingleApplyVo single : singleMatchVosB) {
/* 559 */         long thisPlayerCostTime = System.currentTimeMillis() - single.joinTime.getTime();
/* 560 */         singleCostTime += thisPlayerCostTime;
/*     */       } 
/* 562 */       this.five2FiveSystemPo.singleTotalMatchSuccessCostTime = singleCostTime;
/* 563 */       this.five2FiveSystemPo.totalMatchSuccessSingle += singleMatchVosB.size();
/*     */     } 
/*     */     
/* 566 */     pushMatchPool();
/*     */     
/* 568 */     waitPlayerReady(matchTeamVoA, matchTeamVoB);
/* 569 */     updateFive2FiveSystem(this.five2FiveSystemPo);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean singleQuitFive2FiveMatch(String playerId, boolean isSelf) {
/* 578 */     if (!isInOpenTime()) {
/* 579 */       return false;
/*     */     }
/* 581 */     boolean re = Five2FiveMatchPool.singleRemoveApplyPool(playerId);
/* 582 */     if (re && !isSelf) {
/* 583 */       pushCancelMatch(playerId);
/*     */     }
/* 585 */     return re;
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
/*     */   
/*     */   public Five2FiveMatchTeamVo getMatchingTeam(String tempTeamId) {
/* 604 */     return Five2FiveMatchPool.getMatchingTeam(tempTeamId);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void updatePlayerFive2FiveBtlReportPO(Five2FivePlayerBtlReportPO btlPo) {
/* 613 */     Five2FiveDao.updatePlayerFive2FiveBtlReportPO(btlPo);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateFive2FiveSystem(Five2FiveSystemPO systemPo) {
/* 622 */     Five2FiveDao.updateFive2FiveSystem(systemPo);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void delPlayerFive2FiveBtlReportPO(Five2FivePlayerBtlReportPO btlPo) {
/* 631 */     Five2FiveDao.delPlayerFive2FiveBtlReportPO(btlPo);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void shardMatchResult(String instanceId, List<Five2FivePlayerResultInfoVo> resultInfos) {
/* 641 */     Five2FiveDao.updateShardBtlReport(instanceId, resultInfos);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<Five2FivePlayerResultInfoVo> queryResultInfos(String instanceId) {
/* 651 */     return Five2FiveDao.getShardBtlReport(instanceId);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void afterAllChoiced(Five2FiveMatchTeamVo matchTeamVoA, Five2FiveMatchTeamVo matchTeamVoB) {
/* 661 */     if (Five2FiveMatchPool.removeMatchedTeam(matchTeamVoA.tempTeamId) == null || 
/* 662 */       Five2FiveMatchPool.removeMatchedTeam(matchTeamVoB.tempTeamId) == null) {
/* 663 */       Out.warn(new Object[] { "5v5 removeMatchedTeam null occured" });
/*     */       return;
/*     */     } 
/* 666 */     Out.info(new Object[] { "five2five readyInScene:TeamA:", matchTeamVoA.tempTeamId, ",teamB:", matchTeamVoB.tempTeamId });
/* 667 */     if (!matchTeamVoA.isAllChoice.compareAndSet(false, true)) {
/* 668 */       Out.warn(new Object[] { "five2fivelog:err1:", matchTeamVoA.tempTeamId });
/*     */       
/*     */       return;
/*     */     } 
/* 672 */     matchTeamVoB.isAllChoice.set(true);
/*     */     
/* 674 */     CopyOnWriteArrayList<Five2FiveTempTeamMember> tempTeamMemsA = matchTeamVoA.tempTeamMember;
/* 675 */     CopyOnWriteArrayList<Five2FiveTempTeamMember> tempTeamMemsB = matchTeamVoB.tempTeamMember;
/*     */     
/* 677 */     Area area = null;
/* 678 */     Map<String, Object> userData = Utils.ofMap(new Object[] { "tempTeamMemsA", tempTeamMemsA, "tempTeamMemsB", tempTeamMemsB });
/* 679 */     for (Five2FiveTempTeamMember tempTeamMem : tempTeamMemsA) {
/* 680 */       WNPlayer memPlayer = PlayerUtil.getOnlinePlayer(tempTeamMem.playerId);
/* 681 */       if (memPlayer == null) {
/* 682 */         Out.warn(new Object[] { "player offlined in 5v5, playerId=" + tempTeamMem.playerId });
/*     */         continue;
/*     */       } 
/* 685 */       if (area == null) {
/* 686 */         area = enterFive2FiveArea(memPlayer, userData, matchTeamVoA.tempTeamId); continue;
/*     */       } 
/* 688 */       enterFive2FiveArea(memPlayer, area, userData, matchTeamVoA.tempTeamId);
/*     */     } 
/*     */     
/* 691 */     for (Five2FiveTempTeamMember tempTeamMem : tempTeamMemsB) {
/* 692 */       WNPlayer memPlayer = PlayerUtil.getOnlinePlayer(tempTeamMem.playerId);
/* 693 */       if (memPlayer == null) {
/* 694 */         Out.warn(new Object[] { "player offlined in 5v5, playerId=" + tempTeamMem.playerId });
/*     */         continue;
/*     */       } 
/* 697 */       if (area == null) {
/* 698 */         area = enterFive2FiveArea(memPlayer, userData, matchTeamVoB.tempTeamId); continue;
/*     */       } 
/* 700 */       enterFive2FiveArea(memPlayer, area, userData, matchTeamVoB.tempTeamId);
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
/*     */   private Area enterFive2FiveArea(WNPlayer player, Map<String, Object> userData, String templateId) {
/* 712 */     cancelFollow(player);
/* 713 */     Area area = AreaUtil.createAreaAndDispatch(player, Arrays.asList(new String[] { player.getId() }, ), player.getLogicServerId(), GlobalConfig.Group_Map, userData);
/* 714 */     if (!PlayerUtil.isOnline(player.getId())) {
/* 715 */       area.addPlayer(player);
/* 716 */       area.playerEnterRequest(player);
/* 717 */       player.getXmdsManager().playerReady(player.getId());
/* 718 */       area.onPlayerAutoBattle(player, true);
/*     */     } 
/* 720 */     Out.info(new Object[] { "five2fivelog:in scene:playerId:", player.getId(), ",templateId=", templateId, ",sceneid:", Integer.valueOf(area.areaId), ",sceneInstanceId:", area.instanceId });
/* 721 */     return area;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void enterFive2FiveArea(WNPlayer player, Area area, Map<String, Object> userData, String templateId) {
/* 731 */     cancelFollow(player);
/* 732 */     if (area != null && !area.isClose()) {
/* 733 */       if (!PlayerUtil.isOnline(player.getId())) {
/* 734 */         area.addPlayer(player);
/* 735 */         area.playerEnterRequest(player);
/* 736 */         player.getXmdsManager().playerReady(player.getId());
/* 737 */         area.onPlayerAutoBattle(player, true);
/*     */       } else {
/* 739 */         AreaData areaData = new AreaData(area.areaId, area.instanceId);
/* 740 */         AreaUtil.dispatchByInstanceId(player, areaData);
/*     */       } 
/*     */     }
/* 743 */     Out.info(new Object[] { "five2fivelog:in scene:playerId:", player.getId(), ",templateId=", templateId, ",sceneid:", Integer.valueOf(area.areaId), ",sceneInstanceId:", area.instanceId });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void cancelFollow(WNPlayer player) {
/* 752 */     if (player.getTeamManager().isTeamLeader()) {
/* 753 */       for (String id : player.getTeamManager().getTeamMembers().keySet()) {
/* 754 */         WNPlayer p = PlayerUtil.getOnlinePlayer(id);
/* 755 */         if (p == null) {
/*     */           continue;
/*     */         }
/* 758 */         TeamService.followLeader(p, false);
/*     */       } 
/*     */     } else {
/* 761 */       TeamService.followLeader(player, false);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getFirstRankInfo() {
/* 771 */     return RankType.PVP_5V5.getHandler().getFirstRankMemberId(this.five2FiveSystemPo.logicServerId);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getPlayerRank(String playerId) {
/* 781 */     return (int)RankType.PVP_5V5.getHandler().getRank(this.five2FiveSystemPo.logicServerId, playerId);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<NormalItem> createItem(Map<String, Integer> rewards) {
/* 791 */     List<NormalItem> returnItems = new ArrayList<>();
/* 792 */     for (String itemCode : rewards.keySet()) {
/* 793 */       List<NormalItem> items = ItemUtil.createItemsByItemCode(itemCode, ((Integer)rewards.get(itemCode)).intValue());
/* 794 */       returnItems.addAll(items);
/*     */     } 
/* 796 */     return returnItems;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public boolean teamIsMatchedSuccess(String teamId) {
/* 807 */     return Five2FiveMatchPool.teamIsMakeWithOthers(teamId);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Five2FivePO createFive2FivePO(String playerId) {
/* 817 */     Five2FivePO five2FivePO = new Five2FivePO();
/* 818 */     five2FivePO.createTime = new Date();
/* 819 */     five2FivePO.updateTime = this.five2FiveSystemPo.seasonRefreshTime;
/* 820 */     return five2FivePO;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Five2FiveSystemPO getFive2FiveSystemPO() {
/* 829 */     return this.five2FiveSystemPo;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int getApplyPlayerCount() {
/* 838 */     return Five2FiveMatchPool.getApplyPlayer().size();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void waitPlayerReady(final Five2FiveMatchTeamVo matchTeamVoA, final Five2FiveMatchTeamVo matchTeamVoB) {
/* 848 */     JobFactory.addDelayJob(new Runnable()
/*     */         {
/*     */           public void run() {
/* 851 */             Five2FiveService.this.afterAllChoiced(matchTeamVoA, matchTeamVoB);
/*     */           }
/*     */         }(GlobalConfig.Group_ReadyTime + 1), TimeUnit.SECONDS);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void pushMatchFailed(String playerId, boolean single, boolean isReMatch) {
/* 864 */     Five2FiveHandler.Five2FiveMatchFailedPush.Builder matchFailedPush = Five2FiveHandler.Five2FiveMatchFailedPush.newBuilder();
/* 865 */     matchFailedPush.setS2CCode(200);
/* 866 */     if (isReMatch) {
/* 867 */       Five2FiveHandler.Five2FiveMatchTime.Builder matchTime = Five2FiveHandler.Five2FiveMatchTime.newBuilder();
/* 868 */       matchTime.setAvgWaitTime(getAvgWaitTime(single));
/* 869 */       matchTime.setMatchTime((int)(System.currentTimeMillis() / 1000L));
/* 870 */       matchFailedPush.setFive2FiveMatchTime(matchTime);
/*     */     } 
/* 872 */     WNPlayer player = PlayerUtil.getOnlinePlayer(playerId);
/* 873 */     if (player != null) {
/* 874 */       player.receive("five2five.five2FivePush.five2FiveMatchFailedPush", (GeneratedMessage)matchFailedPush.build());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   void afterMatchedFailedProcess(Five2FiveMatchTeamVo matchTeamVo) {
/* 886 */     CopyOnWriteArrayList<Five2FiveTempTeamMember> tempTeamMems = matchTeamVo.tempTeamMember;
/* 887 */     List<Five2FiveTeamApplyVo> teamMatchVos = matchTeamVo.teamMatchVos;
/* 888 */     List<Five2FiveSingleApplyVo> singleMatchVos = matchTeamVo.singleMatchVos;
/* 889 */     if (singleMatchVos != null) {
/* 890 */       for (int i = 0; i < singleMatchVos.size(); i++) {
/* 891 */         Five2FiveSingleApplyVo single = singleMatchVos.get(i);
/* 892 */         WNPlayer player = single.player;
/* 893 */         if (player != null) {
/* 894 */           for (int j = 0; j < tempTeamMems.size(); j++) {
/* 895 */             Five2FiveTempTeamMember tempTeamMem = tempTeamMems.get(j);
/* 896 */             if (tempTeamMem.isReadyOrCancel.get() == Const.Five2Five.five2five_choice_ready.value && player.getId().equals(tempTeamMem.playerId)) {
/* 897 */               Five2FiveMatchPool.singlePutInApplyPool(player);
/* 898 */               pushMatchFailed(tempTeamMem.playerId, true, true);
/* 899 */             } else if ((tempTeamMem.isReadyOrCancel.get() == Const.Five2Five.five2five_choice_giveup.value || tempTeamMem.isReadyOrCancel.get() == 0) && player.getId().equals(tempTeamMem.playerId)) {
/* 900 */               pushMatchFailed(tempTeamMem.playerId, true, false);
/*     */             } 
/*     */           } 
/*     */         }
/*     */       } 
/*     */     }
/*     */     
/* 907 */     if (teamMatchVos != null) {
/* 908 */       for (int i = 0; i < teamMatchVos.size(); i++) {
/* 909 */         Five2FiveTeamApplyVo teamMatchVo = teamMatchVos.get(i);
/* 910 */         boolean isTeamAllReady = true;
/* 911 */         for (String teamMemPlayerId : teamMatchVo.teamMembers.keySet()) {
/* 912 */           WNPlayer player = PlayerUtil.getOnlinePlayer(teamMemPlayerId);
/* 913 */           if (player != null) {
/* 914 */             for (Five2FiveTempTeamMember tempTeamMem : tempTeamMems) {
/* 915 */               if (tempTeamMem.isReadyOrCancel.get() != Const.Five2Five.five2five_choice_ready.value && player.getId().equals(tempTeamMem.playerId)) {
/* 916 */                 isTeamAllReady = false;
/*     */               }
/*     */             } 
/*     */           }
/*     */         } 
/* 921 */         if (isTeamAllReady) {
/* 922 */           for (String teamMemPlayerId : teamMatchVo.teamMembers.keySet()) {
/* 923 */             pushMatchFailed(teamMemPlayerId, false, true);
/*     */           }
/* 925 */           Five2FiveMatchPool.teamPutInApplyPool(teamMatchVo.teamMembers, teamMatchVo.teamId);
/*     */         } else {
/* 927 */           for (String teamMemPlayerId : teamMatchVo.teamMembers.keySet()) {
/* 928 */             pushMatchFailed(teamMemPlayerId, false, false);
/*     */           }
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
/*     */   public void pushCancelMatch(String playerId) {
/* 941 */     WNPlayer memPlayer = PlayerUtil.getOnlinePlayer(playerId);
/* 942 */     if (memPlayer != null) {
/* 943 */       Five2FiveHandler.Five2FiveLeaderCancelMatchPush.Builder leaderCancelMatch = Five2FiveHandler.Five2FiveLeaderCancelMatchPush.newBuilder();
/* 944 */       leaderCancelMatch.setS2CCode(200);
/* 945 */       memPlayer.receive("five2five.five2FivePush.five2FiveLeaderCancelMatchPush", (GeneratedMessage)leaderCancelMatch.build());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void pushReady(String readyId, String pushPlayer) {
/* 956 */     Five2FiveHandler.Five2FiveMemberChoicePush.Builder memChoice = Five2FiveHandler.Five2FiveMemberChoicePush.newBuilder();
/* 957 */     memChoice.setS2CCode(200);
/* 958 */     memChoice.setAgreeOrReady(Const.Five2Five.five2five_choice_type_ready.value);
/* 959 */     memChoice.setPlayerId(readyId);
/* 960 */     memChoice.setChoice(Const.Five2Five.five2five_choice_ready.value);
/* 961 */     WNPlayer player = PlayerUtil.getOnlinePlayer(pushPlayer);
/* 962 */     if (player != null) {
/* 963 */       player.receive("five2five.five2FivePush.five2FiveMemberChoicePush", (GeneratedMessage)memChoice.build());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void pushMatchPool() {
/* 971 */     Five2FiveHandler.Five2FiveMatchPoolChangePush.Builder poolChange = Five2FiveHandler.Five2FiveMatchPoolChangePush.newBuilder();
/* 972 */     poolChange.setS2CCode(200);
/* 973 */     List<String> poolPlayers = Five2FiveMatchPool.getApplyPlayer();
/* 974 */     poolChange.setPreNumber(poolPlayers.size());
/* 975 */     for (int i = 0; i < poolPlayers.size(); i++) {
/* 976 */       String tempPlayerId = poolPlayers.get(i);
/* 977 */       WNPlayer tempPlayer = PlayerUtil.getOnlinePlayer(tempPlayerId);
/* 978 */       if (tempPlayer != null)
/* 979 */         tempPlayer.receive("five2five.five2FivePush.five2FiveMatchPoolChangePush", (GeneratedMessage)poolChange.build()); 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\five2Five\Five2FiveService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */