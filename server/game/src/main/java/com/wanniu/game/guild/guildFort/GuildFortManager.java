/*     */ package com.wanniu.game.guild.guildFort;
/*     */ 
/*     */ import com.wanniu.core.db.GCache;
/*     */ import com.wanniu.core.game.LangService;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.util.DateUtil;
/*     */ import com.wanniu.game.area.Area;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.ModuleManager;
/*     */ import com.wanniu.game.data.GuildLevelCO;
/*     */ import com.wanniu.game.guild.GuildServiceCenter;
/*     */ import com.wanniu.game.guild.GuildUtil;
/*     */ import com.wanniu.game.guild.guildFort.dao.GuildFortAwardPO;
/*     */ import com.wanniu.game.guild.guildFort.dao.GuildFortBattleReportPO;
/*     */ import com.wanniu.game.guild.guildFort.dao.GuildFortBidderPO;
/*     */ import com.wanniu.game.guild.guildFort.dao.GuildFortContenderPO;
/*     */ import com.wanniu.game.guild.guildFort.dao.GuildFortMemberPO;
/*     */ import com.wanniu.game.guild.guildFort.dao.GuildFortReportPO;
/*     */ import com.wanniu.game.item.NormalItem;
/*     */ import com.wanniu.game.mail.MailUtil;
/*     */ import com.wanniu.game.mail.data.MailData;
/*     */ import com.wanniu.game.mail.data.MailSysData;
/*     */ import com.wanniu.game.player.GlobalConfig;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.poes.GuildPO;
/*     */ import com.wanniu.game.team.TeamData;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import pomelo.area.GuildFortHandler;
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
/*     */ public class GuildFortManager
/*     */   extends ModuleManager
/*     */ {
/*     */   private WNPlayer player;
/*  64 */   private GuildFortAwardPO dailyAwards = null;
/*  65 */   private int fortId = 0;
/*     */ 
/*     */   
/*     */   private static final String Tradenionstrongholds = "Tradenionstrongholds";
/*     */ 
/*     */   
/*     */   private static final String Rewardstatus = "Rewardstatus";
/*     */ 
/*     */   
/*     */   private String getGuildId() {
/*  75 */     return this.player.guildManager.getGuildId();
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
/*     */   private String getJobName() {
/*  89 */     return this.player.guildManager.getJobName();
/*     */   }
/*     */ 
/*     */   
/*     */   public GuildFortManager(WNPlayer wnPlayer) {
/*  94 */     this.player = wnPlayer;
/*  95 */     if (this.player.playerAttachPO.guildFortDailyAwards == null) {
/*  96 */       this.player.playerAttachPO.guildFortDailyAwards = new GuildFortAwardPO();
/*     */     }
/*  98 */     this.dailyAwards = this.player.playerAttachPO.guildFortDailyAwards;
/*     */     
/* 100 */     System.out.println("=========================================================" + this.dailyAwards);
/*     */   }
/*     */   
/*     */   private boolean isSameDay(long date) {
/* 104 */     return DateUtil.isSameDay(new Date(), new Date(date));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onPlayerEvent(Const.PlayerEventType eventType) {
/* 111 */     if (eventType == Const.PlayerEventType.REFRESH_NEWDAY) {
/* 112 */       recalcDailyAwards();
/* 113 */     } else if (eventType == Const.PlayerEventType.OFFLINE) {
/* 114 */       setFortId(0);
/* 115 */     } else if (eventType == Const.PlayerEventType.AFTER_LOGIN) {
/* 116 */       System.out.println("AFTER_LOGIN====================================" + this.dailyAwards.updateDate);
/* 117 */       if (!isSameDay(this.dailyAwards.updateDate)) {
/* 118 */         recalcDailyAwards();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Const.ManagerType getManagerType() {
/* 128 */     return Const.ManagerType.GUILD_FORT;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void recalcDailyAwards() {
/* 135 */     synchronized (this.dailyAwards.awardStatus) {
/* 136 */       this.dailyAwards.awardStatus.clear();
/* 137 */       List<GuildFort> list = GuildFortCenter.getInstance().getOccupiedForts(getGuildId());
/* 138 */       for (GuildFort fort : list)
/*     */       {
/* 140 */         this.dailyAwards.awardStatus.put(Integer.valueOf(fort.getId()), GuildFortAwardPO.AwardFlag.HAS_AWARD);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 151 */       this.dailyAwards.updateDate = System.currentTimeMillis();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clearDailyAwards() {
/* 159 */     synchronized (this.dailyAwards.awardStatus) {
/* 160 */       this.dailyAwards.awardStatus.clear();
/*     */     } 
/*     */   }
/*     */   
/*     */   private GuildFortAwardPO.AwardFlag getAwardFlag(int fortId) {
/* 165 */     synchronized (this.dailyAwards.awardStatus) {
/* 166 */       if (this.dailyAwards.awardStatus.containsKey(Integer.valueOf(fortId))) {
/*     */         
/* 168 */         GuildFortAwardPO.AwardFlag flag = (GuildFortAwardPO.AwardFlag)this.dailyAwards.awardStatus.get(Integer.valueOf(fortId));
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
/* 182 */         return (GuildFortAwardPO.AwardFlag)this.dailyAwards.awardStatus.get(Integer.valueOf(fortId));
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 188 */       return GuildFortAwardPO.AwardFlag.NO_AWARD;
/*     */     } 
/*     */   }
/*     */   
/*     */   private List<Integer> getAwardFortIds() {
/* 193 */     List<Integer> fortIds = new ArrayList<>();
/* 194 */     synchronized (this.dailyAwards.awardStatus) {
/* 195 */       for (Integer fortId : this.dailyAwards.awardStatus.keySet()) {
/* 196 */         if (this.dailyAwards.awardStatus.get(fortId) == GuildFortAwardPO.AwardFlag.HAS_AWARD) {
/* 197 */           fortIds.add(fortId);
/*     */         }
/*     */       } 
/*     */     } 
/* 201 */     return fortIds;
/*     */   }
/*     */   
/*     */   private boolean hasAward() {
/* 205 */     return (getAwardFortIds().size() > 0);
/*     */   }
/*     */   
/*     */   private boolean isBidded(GuildFort fort) {
/* 209 */     if (GuildFortService.getInstance().isInBidTime() && 
/* 210 */       fort.isInBidders(getGuildId())) {
/* 211 */       return true;
/*     */     }
/*     */ 
/*     */     
/* 215 */     return false;
/*     */   }
/*     */   
/*     */   public String handleGetGuildAreaList(GuildFortHandler.GetGuildAreaListResponse.Builder res) {
/* 219 */     int status = GuildFortCenter.getInstance().getStatus(false);
/* 220 */     res.setCurStatus(status);
/* 221 */     for (GuildFort fort : GuildFortCenter.getInstance().getAllGuildFort()) {
/* 222 */       GuildFortHandler.GuildAreaInfo.Builder data = GuildFortHandler.GuildAreaInfo.newBuilder();
/* 223 */       data.setAreaId(fort.getId());
/*     */ 
/*     */ 
/*     */       
/* 227 */       String occupyId = GCache.hget("Tradenionstrongholds", String.valueOf(fort.getId()));
/* 228 */       data.setApplied(isBidded(fort) ? 1 : 0);
/* 229 */       if (occupyId == null || occupyId.equals("")) {
/* 230 */         data.setGuildId("");
/* 231 */         data.setGuildName("");
/*     */       } else {
/* 233 */         GuildPO guild = GuildServiceCenter.getInstance().getGuild(occupyId);
/* 234 */         data.setGuildId(occupyId);
/* 235 */         data.setGuildName(guild.name);
/*     */       } 
/*     */       
/* 238 */       data.setGuildName1(fort.getDefenserName());
/* 239 */       data.setGuildName2(fort.getAttackerName());
/*     */       
/* 241 */       res.addAreaList(data);
/*     */     } 
/*     */     
/* 244 */     return null;
/*     */   }
/*     */   
/*     */   public String handleGetGuildAreaDetail(GuildFortHandler.GetGuildAreaDetailResponse.Builder res, int fortId) {
/* 248 */     GuildFort fort = GuildFortCenter.getInstance().getFort(fortId);
/* 249 */     if (fort == null) {
/* 250 */       return LangService.getValue("GUILDFORT_FORTID_NOT_EXIST");
/*     */     }
/* 252 */     GuildFortHandler.GuildAreaDetail.Builder data = GuildFortHandler.GuildAreaDetail.newBuilder();
/*     */     
/* 254 */     String occupyId = GCache.hget("Tradenionstrongholds", String.valueOf(fort.getId()));
/*     */     
/* 256 */     if (occupyId == null || occupyId.equals("")) {
/* 257 */       data.setGuildId("");
/*     */     } else {
/* 259 */       GuildPO guild = GuildServiceCenter.getInstance().getGuild(occupyId);
/* 260 */       data.setGuildId(occupyId);
/* 261 */       data.setGuildName(guild.name);
/* 262 */       data.setGuildLevel(guild.level);
/* 263 */       data.setGuildLeaderId(guild.presidentId);
/* 264 */       data.setGuildLeaderName(guild.presidentName);
/* 265 */       data.setGuildNumberCount(GuildUtil.getGuildMemberCount(occupyId));
/* 266 */       GuildLevelCO prop = GuildUtil.getGuildLevelPropByLevel(guild.level);
/* 267 */       data.setGuildNumberTotalCount(prop.member);
/*     */     } 
/* 269 */     data.addAllWinnerAwardList(fort.getWinnerReward());
/* 270 */     data.addAllDailyAwardList(fort.getDailyAward());
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
/* 281 */     data.setDailyAwardFlag((getAwardFlag(fortId)).value);
/* 282 */     int status = GuildFortCenter.getInstance().getStatus(isBidded(fort));
/* 283 */     data.setAreaStatus(status);
/* 284 */     if (status == GuildFortCenter.Status.NOT_BEGIN.value) {
/* 285 */       data.setCountDown(GuildFortService.getInstance().getBidBeginRemainSecond());
/* 286 */     } else if (status == GuildFortCenter.Status.INTIME_NOTBID.value || status == GuildFortCenter.Status.INTIME_BIDDED.value) {
/*     */       
/* 288 */       data.setCountDown(GuildFortService.getInstance().getBidEndRemainSecond());
/* 289 */     } else if (status == GuildFortCenter.Status.BID_ENDED.value) {
/* 290 */       data.setCountDown(GuildFortService.getInstance().getBattleBeginRemainSecond());
/*     */     } 
/*     */     
/* 293 */     res.setAreaDetail(data.build());
/* 294 */     return null;
/*     */   }
/*     */   
/*     */   public String handleGetGuildAreaApplyList(GuildFortHandler.GetGuildAreaApplyListResponse.Builder res, int fortId) {
/* 298 */     GuildFort fort = GuildFortCenter.getInstance().getFort(fortId);
/* 299 */     if (fort == null) {
/* 300 */       return LangService.getValue("GUILDFORT_FORTID_NOT_EXIST");
/*     */     }
/* 302 */     GuildFortService service = GuildFortService.getInstance();
/* 303 */     if (!service.isInOpen()) {
/* 304 */       return LangService.getValue("GUILDFORT_NOT_OPENED");
/*     */     }
/*     */     
/* 307 */     for (GuildFortBidderPO bidder : fort.getBidders()) {
/* 308 */       GuildFortHandler.GuildAreaApplyInfo.Builder data = GuildFortHandler.GuildAreaApplyInfo.newBuilder();
/* 309 */       GuildPO guild = GuildServiceCenter.getInstance().getGuild(bidder.guildId);
/* 310 */       data.setGuildIcon(guild.icon);
/* 311 */       data.setGuildId(bidder.guildId);
/* 312 */       data.setGuildName(guild.name);
/* 313 */       data.setGuildLevel(guild.level);
/* 314 */       data.setGuildLeaderId(guild.presidentId);
/* 315 */       data.setGuildLeaderName(guild.presidentName);
/* 316 */       data.setGuildNumberCount(GuildUtil.getGuildMemberCount(bidder.guildId));
/* 317 */       GuildLevelCO prop = GuildUtil.getGuildLevelPropByLevel(guild.level);
/* 318 */       data.setGuildNumberTotalCount(prop.member);
/* 319 */       if (GuildFortService.getInstance().isInBidTime()) {
/* 320 */         if (this.player.guildManager.getGuildId().equals(bidder.guildId)) {
/* 321 */           data.setApplyFund(bidder.fund);
/*     */         } else {
/* 323 */           data.setApplyFund(0);
/*     */         } 
/*     */       } else {
/* 326 */         data.setApplyFund(bidder.fund);
/*     */       } 
/* 328 */       data.setIsWinner(fort.isBidWinner(bidder.guildId));
/* 329 */       res.addApplyList(data);
/*     */     } 
/* 331 */     if (service.isInBidTime()) {
/* 332 */       res.setCountDown(GuildFortService.getInstance().getBidEndRemainSecond());
/*     */     }
/* 334 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   private void bidCommitNotify(GuildPO guild, String playerName, String fortName, int fund, long sumFund) {
/* 339 */     String msgStr = LangService.getValue("GUILDFORT_FUNDCHANGED_NOTICE2");
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 344 */     msgStr = msgStr.replace("{position}", getJobName()).replace("{name}", playerName).replace("{fortname}", fortName).replace("{fund}", String.valueOf(fund)).replace("{sumfund}", String.valueOf(sumFund));
/* 345 */     Set<String> playerIds = GuildUtil.getGuildMemberIdList(guild.id);
/* 346 */     GuildFortUtil.sendRollTipsAsyn(playerIds, msgStr, Const.CHAT_SCOPE.GUILD);
/*     */     
/* 348 */     MailSysData mailData = new MailSysData("GuildFortBidFundCommit");
/* 349 */     mailData.replace = new HashMap<>();
/* 350 */     mailData.replace.put("position", getJobName());
/* 351 */     mailData.replace.put("name", playerName);
/* 352 */     mailData.replace.put("fortname", fortName);
/* 353 */     mailData.replace.put("fund", String.valueOf(fund));
/* 354 */     mailData.replace.put("sumfund", String.valueOf(sumFund));
/* 355 */     List<String> ids = GuildServiceCenter.getInstance().getGuildMemberIdList(guild.id, new Const.GuildJob[] { Const.GuildJob.PRESIDENT, Const.GuildJob.VICE_PRESIDENT });
/* 356 */     MailUtil.getInstance().sendMailToSomePlayer(ids.<String>toArray(new String[ids.size()]), (MailData)mailData, Const.GOODS_CHANGE_TYPE.guild_mail);
/*     */   }
/*     */   
/*     */   private void bidCancelNotify(GuildPO guild, String playerName, String fortName, int fund) {
/* 360 */     String msgStr = LangService.getValue("GUILDFORT_FUNDCHANGED_NOTICE1");
/*     */     
/* 362 */     msgStr = msgStr.replace("{position}", getJobName()).replace("{name}", playerName).replace("{fortname}", fortName).replace("{fund}", String.valueOf(fund));
/* 363 */     Set<String> playerIds = GuildUtil.getGuildMemberIdList(guild.id);
/* 364 */     GuildFortUtil.sendRollTipsAsyn(playerIds, msgStr, Const.CHAT_SCOPE.GUILD);
/*     */     
/* 366 */     MailSysData mailData = new MailSysData("GuildFortBidFundCancel");
/* 367 */     mailData.replace = new HashMap<>();
/* 368 */     mailData.replace.put("position", getJobName());
/* 369 */     mailData.replace.put("name", playerName);
/* 370 */     mailData.replace.put("fortname", fortName);
/* 371 */     mailData.replace.put("fund", String.valueOf(fund));
/* 372 */     List<String> ids = GuildServiceCenter.getInstance().getGuildMemberIdList(guild.id, new Const.GuildJob[] { Const.GuildJob.PRESIDENT, Const.GuildJob.VICE_PRESIDENT });
/* 373 */     MailUtil.getInstance().sendMailToSomePlayer(ids.<String>toArray(new String[ids.size()]), (MailData)mailData, Const.GOODS_CHANGE_TYPE.guild_mail);
/*     */   }
/*     */   
/*     */   public String handleApplyFund(GuildFortHandler.ApplyFundResponse.Builder res, int fortId, int fund) {
/* 377 */     if (fund <= 0) {
/* 378 */       return LangService.getValue("GUILD_FUND_NOT_ENOUGH");
/*     */     }
/*     */     
/* 381 */     if (fund < GlobalConfig.GuildFort_MinBetMoney) {
/* 382 */       return LangService.getValue("SOMETHING_ERR");
/*     */     }
/*     */     
/* 385 */     if (!GuildFortService.getInstance().isInBidTime()) {
/* 386 */       return LangService.getValue("GUILDFORT_NOTIN_BIDTIME");
/*     */     }
/*     */     
/* 389 */     GuildFort fort = GuildFortCenter.getInstance().getFort(fortId);
/* 390 */     if (fort == null) {
/* 391 */       return LangService.getValue("GUILDFORT_FORTID_NOT_EXIST");
/*     */     }
/* 393 */     if (!this.player.guildManager.isInGuild()) {
/* 394 */       return LangService.getValue("GUILD_NOT_JOIN");
/*     */     }
/* 396 */     if (!this.player.guildManager.isPresident() && !this.player.guildManager.isVicePresident()) {
/* 397 */       return LangService.getValue("GUILDFORT_NOT_PRISIDENT_ONBID");
/*     */     }
/* 399 */     GuildPO guild = this.player.guildManager.getGuildInfo();
/* 400 */     if (guild.fund < fund) {
/* 401 */       return LangService.getValue("GUILD_FUND_NOT_ENOUGH");
/*     */     }
/* 403 */     if (!fort.isInBidders(guild.id) && GuildFortCenter.getInstance().isBitFortExceeded(guild.id)) {
/* 404 */       return LangService.getValue("GUILDFORT_BITFORT_EXCEEDED");
/*     */     }
/*     */     
/* 407 */     int afterCommitFund = fort.commitBidFund(guild.id, fund);
/* 408 */     if (afterCommitFund > 0) {
/* 409 */       bidCommitNotify(guild, this.player.getName(), fort.getName(), fund, afterCommitFund);
/* 410 */       GuildFortCenter.getInstance().onBidOperation();
/*     */     } else {
/* 412 */       return LangService.getValue("SOMETHING_ERR");
/*     */     } 
/*     */ 
/*     */     
/* 416 */     return null;
/*     */   }
/*     */   
/*     */   public String handleApplyCancelFund(int fortId) {
/* 420 */     if (!GuildFortService.getInstance().isInBidTime()) {
/* 421 */       return LangService.getValue("GUILDFORT_NOTIN_BIDTIME");
/*     */     }
/*     */     
/* 424 */     GuildFort fort = GuildFortCenter.getInstance().getFort(fortId);
/* 425 */     if (fort == null) {
/* 426 */       return LangService.getValue("GUILDFORT_FORTID_NOT_EXIST");
/*     */     }
/*     */     
/* 429 */     if (!this.player.guildManager.isInGuild()) {
/* 430 */       return LangService.getValue("GUILD_NOT_JOIN");
/*     */     }
/* 432 */     if (!this.player.guildManager.isPresident() && !this.player.guildManager.isVicePresident()) {
/* 433 */       return LangService.getValue("GUILDFORT_NOT_PRISIDENT_ONBID");
/*     */     }
/* 435 */     GuildPO guild = this.player.guildManager.getGuildInfo();
/* 436 */     if (!fort.isInBidders(guild.id)) {
/* 437 */       return LangService.getValue("GUILDFORT_NOT_BIDDED");
/*     */     }
/*     */     
/* 440 */     int fund = fort.extractBidFund(guild.id);
/* 441 */     if (fund > 0) {
/* 442 */       Out.info(new Object[] { "Apply cancel fund guild id:", guild.id, " original fund:", Long.valueOf(guild.fund), " to caneled fund:" + fund });
/* 443 */       bidCancelNotify(guild, this.player.getName(), fort.getName(), fund);
/* 444 */       GuildFortCenter.getInstance().onBidOperation();
/*     */     } else {
/* 446 */       return LangService.getValue("SOMETHING_ERR");
/*     */     } 
/*     */     
/* 449 */     return null;
/*     */   }
/*     */   
/*     */   public String handleEnterPrepareArea(int fortId) {
/* 453 */     GuildFort fort = GuildFortCenter.getInstance().getFort(fortId);
/* 454 */     if (fort == null) {
/* 455 */       return LangService.getValue("GUILDFORT_FORTID_NOT_EXIST");
/*     */     }
/*     */     
/* 458 */     if (!GuildFortService.getInstance().isInEnterFortTime()) {
/* 459 */       return LangService.getValue("GUILDFORT_NOT_IN_BATTLETIME");
/*     */     }
/* 461 */     if (GuildFortService.getInstance().isInBattleTime() && fort.isBattleOver()) {
/* 462 */       return LangService.getValue("GUILDFORT_BATTLE_ENDED");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 468 */     Area area = fort.requestEnterPrepareArea(this.player);
/* 469 */     if (area == null) {
/* 470 */       return LangService.getValue("GUILDFORT_NOT_IN_BATTLEGUILD");
/*     */     }
/* 472 */     setFortId(fort.getId());
/*     */     
/* 474 */     return null;
/*     */   }
/*     */   
/*     */   private String handleEnterPveArea(int fortId) {
/* 478 */     GuildFort fort = GuildFortCenter.getInstance().getFort(fortId);
/* 479 */     if (fort == null) {
/* 480 */       return LangService.getValue("GUILDFORT_FORTID_NOT_EXIST");
/*     */     }
/* 482 */     if (!GuildFortService.getInstance().isInBattleTime()) {
/* 483 */       return LangService.getValue("GUILDFORT_NOT_IN_BATTLETIME");
/*     */     }
/*     */     
/* 486 */     if (fort.isBattleOver()) {
/* 487 */       return LangService.getValue("GUILDFORT_BATTLE_ENDED");
/*     */     }
/*     */     
/* 490 */     Area area = fort.requestEnterPveArea(this.player);
/* 491 */     if (area == null) {
/* 492 */       return LangService.getValue("GUILDFORT_NOT_IN_BATTLEGUILD");
/*     */     }
/*     */     
/* 495 */     return null;
/*     */   }
/*     */   
/*     */   private String handleEnterPvpArea(int fortId) {
/* 499 */     GuildFort fort = GuildFortCenter.getInstance().getFort(fortId);
/* 500 */     if (fort == null) {
/* 501 */       return LangService.getValue("GUILDFORT_FORTID_NOT_EXIST");
/*     */     }
/* 503 */     if (!GuildFortService.getInstance().isInBattleTime()) {
/* 504 */       return LangService.getValue("GUILDFORT_NOT_IN_BATTLETIME");
/*     */     }
/*     */     
/* 507 */     if (fort.isBattleOver()) {
/* 508 */       return LangService.getValue("GUILDFORT_BATTLE_ENDED");
/*     */     }
/*     */     
/* 511 */     Area area = fort.requestEnterPvpArea(this.player);
/* 512 */     if (area == null) {
/* 513 */       return LangService.getValue("GUILDFORT_NOT_IN_BATTLEGUILD");
/*     */     }
/*     */     
/* 516 */     return null;
/*     */   }
/*     */   
/*     */   public String handleApplyDailyAwardList(GuildFortHandler.ApplyDailyAwardListResponse.Builder res) {
/* 520 */     for (GuildFort fort : GuildFortCenter.getInstance().getAllGuildFort()) {
/* 521 */       GuildFortHandler.AreaAward.Builder data = GuildFortHandler.AreaAward.newBuilder();
/* 522 */       data.setAreaId(fort.getId());
/* 523 */       data.addAllDailyAwardList(fort.getDailyAward());
/*     */       
/* 525 */       String occupyId = GCache.hget("Tradenionstrongholds", String.valueOf(fort.getId()));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 535 */       if (occupyId == null) {
/* 536 */         data.setGuildName("");
/* 537 */         data.setStatus(GuildFortAwardPO.AwardFlag.NO_AWARD.value);
/*     */         
/* 539 */         res.addAreaAwardList(data);
/*     */         
/*     */         continue;
/*     */       } 
/* 543 */       if (fort.isOccupier(getGuildId())) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 553 */         GuildFortAwardPO.AwardFlag flag = getAwardFlag(fort.getId());
/*     */ 
/*     */ 
/*     */         
/* 557 */         data.setGuildName(this.player.guildManager.getGuildName());
/* 558 */         data.setStatus(flag.value);
/*     */       
/*     */       }
/*     */       else {
/*     */ 
/*     */         
/* 564 */         GuildPO guild = GuildServiceCenter.getInstance().getGuild(occupyId);
/*     */         
/* 566 */         if (guild != null) {
/* 567 */           data.setGuildName(guild.name);
/*     */         } else {
/* 569 */           data.setGuildName("");
/*     */         } 
/* 571 */         data.setStatus(GuildFortAwardPO.AwardFlag.NO_AWARD.value);
/*     */       } 
/* 573 */       res.addAreaAwardList(data);
/*     */     } 
/*     */     
/* 576 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   private String getDailyAward(GuildFort fort) {
/* 581 */     List<NormalItem> dailyAward = fort.generateDailyAward();
/*     */     
/* 583 */     if (!this.player.getWnBag().testAddEntityItems(dailyAward, true)) {
/* 584 */       return LangService.getValue("BAG_NOT_ENOUGH_POS");
/*     */     }
/*     */     
/* 587 */     this.player.getWnBag().addEntityItems(dailyAward, Const.GOODS_CHANGE_TYPE.guildfort_daily_award);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 596 */     this.dailyAwards.awardStatus.put(Integer.valueOf(fort.getId()), GuildFortAwardPO.AwardFlag.AWARDED);
/* 597 */     this.dailyAwards.updateDate = System.currentTimeMillis();
/*     */     
/* 599 */     pushRedPoint();
/*     */     
/* 601 */     return null;
/*     */   }
/*     */   
/*     */   public String handleApplyDailyAward(int fortId) {
/* 605 */     GuildFort fort = GuildFortCenter.getInstance().getFort(fortId);
/* 606 */     if (fort == null) {
/* 607 */       return LangService.getValue("GUILDFORT_FORTID_NOT_EXIST");
/*     */     }
/*     */     
/* 610 */     if (!fort.isOccupier(getGuildId())) {
/* 611 */       return LangService.getValue("GUILDFORT_NO_AWARD");
/*     */     }
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
/* 623 */     GuildFortAwardPO.AwardFlag flag = getAwardFlag(fortId);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 628 */     switch (flag) {
/*     */       case NO_AWARD:
/* 630 */         return LangService.getValue("GUILDFORT_NO_AWARD");
/*     */       case AWARDED:
/* 632 */         return LangService.getValue("GUILDFORT_ERR_AWARDED");
/*     */       case HAS_AWARD:
/* 634 */         return getDailyAward(fort);
/*     */     } 
/*     */     
/* 637 */     Out.error(new Object[] { "something error occured in handleApplyDailyAward with fortId:", Integer.valueOf(fortId), " playerId:" + this.player
/* 638 */           .getId() });
/* 639 */     return LangService.getValue("SOMETHING_ERR");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private GuildFortHandler.FortGuildInfo buildStatInfo(GuildFortContenderPO stat) {
/* 645 */     GuildFortHandler.FortGuildInfo.Builder data = GuildFortHandler.FortGuildInfo.newBuilder();
/* 646 */     GuildPO guild = GuildServiceCenter.getInstance().getGuild(stat.getGuildId());
/* 647 */     if (guild != null) {
/* 648 */       data.setGuildIcon(guild.icon);
/* 649 */       data.setGuildName(guild.name);
/* 650 */       data.setGuildLevel(guild.level);
/*     */     } 
/* 652 */     data.setGuildId(stat.getGuildId());
/* 653 */     data.setArmyFlag(stat.killFlagNum);
/* 654 */     data.setKill(stat.killPlayerNum);
/* 655 */     data.setDefenseSoul(stat.defBuffScore);
/* 656 */     data.setAttackSoul(stat.attBuffScore);
/* 657 */     data.setMumber(stat.memberNumber);
/* 658 */     data.setDefense(stat.defBuff);
/* 659 */     data.setAttack(stat.attBuff);
/* 660 */     data.setScore(stat.getScore());
/*     */     
/* 662 */     return data.build();
/*     */   }
/*     */   
/*     */   public String handleApplyFortGuildInfo(GuildFortHandler.ApplyFortGuildInfoResponse.Builder res) {
/* 666 */     if (this.player.getAreaId() != 54002 && this.player.getAreaId() != 54003 && this.player.getAreaId() != 54001) {
/* 667 */       return LangService.getValue("GUILDFORT_NOT_IN_BATTLEGUILD");
/*     */     }
/* 669 */     if (!GuildFortService.getInstance().isInEnterFortTime()) {
/* 670 */       return LangService.getValue("GUILDFORT_NOT_IN_BATTLETIME");
/*     */     }
/*     */     
/* 673 */     GuildFort fort = GuildFortCenter.getInstance().getFort(this.fortId);
/* 674 */     if (fort == null) {
/* 675 */       return LangService.getValue("GUILDFORT_FORTID_NOT_EXIST");
/*     */     }
/*     */     
/* 678 */     GuildFortContenderPO me = fort.getStatByPlayer(this.player, false);
/* 679 */     GuildFortContenderPO opponent = fort.getStatByPlayer(this.player, true);
/* 680 */     res.setOwnGuild(buildStatInfo(me));
/* 681 */     res.setEnemyGuild(buildStatInfo(opponent));
/*     */     
/* 683 */     return null;
/*     */   }
/*     */   
/*     */   public String handleChangeArea(int areaId) {
/* 687 */     if (this.fortId == 0) {
/* 688 */       return LangService.getValue("GUILDFORT_FORTID_NOT_EXIST");
/*     */     }
/* 690 */     String result = checkTeam(this.player);
/* 691 */     if (result != null) {
/* 692 */       return result;
/*     */     }
/* 694 */     if (areaId == 54002)
/* 695 */       return handleEnterPveArea(this.fortId); 
/* 696 */     if (areaId == 54003)
/* 697 */       return handleEnterPvpArea(this.fortId); 
/* 698 */     if (areaId == 54001) {
/* 699 */       return handleEnterPrepareArea(this.fortId);
/*     */     }
/*     */     
/* 702 */     return LangService.getValue("AREA_ID_NULL");
/*     */   }
/*     */   
/*     */   public void handleLeaveArea(int areaId) {
/* 706 */     if (areaId == 54001) {
/* 707 */       setFortId(0);
/*     */     }
/*     */   }
/*     */   
/*     */   private String checkTeam(WNPlayer player) {
/* 712 */     Map<String, TeamData.TeamMemberData> members = player.getTeamManager().getTeamMembers();
/* 713 */     if (members == null || members.isEmpty()) {
/* 714 */       return null;
/*     */     }
/* 716 */     if (!player.getTeamManager().isTeamLeader() && player.getTeamManager().isFollowLeader()) {
/* 717 */       return LangService.getValue("TEAM_FOLLOW_CHANGE_AREA");
/*     */     }
/* 719 */     String guildId = getGuildId();
/*     */     
/* 721 */     for (TeamData.TeamMemberData member : members.values()) {
/* 722 */       if (member.getPlayer() == null || (member.getPlayer()).guildManager == null || 
/* 723 */         (member.getPlayer()).guildManager.guild == null)
/* 724 */         return LangService.getValue("GUILDFORT_NOT_SAME_GUILD"); 
/* 725 */       if (!(member.getPlayer()).guildManager.getGuildId().equals(guildId)) {
/* 726 */         return LangService.getValue("GUILDFORT_NOT_SAME_GUILD");
/*     */       }
/*     */     } 
/*     */     
/* 730 */     return null;
/*     */   }
/*     */   
/*     */   public String handleApplyAllReportList(GuildFortHandler.ApplyAllReportListResponse.Builder res) {
/* 734 */     List<GuildFortReportPO> reports = GuildFortCenter.getInstance().getReports();
/* 735 */     for (GuildFortReportPO report : reports) {
/* 736 */       GuildFortHandler.ReportList.Builder data = GuildFortHandler.ReportList.newBuilder();
/* 737 */       data.setDate(report.date);
/* 738 */       Map<Integer, GuildFortBattleReportPO> battleReports = report.battleReports;
/* 739 */       for (Integer fId : battleReports.keySet()) {
/* 740 */         GuildFortBattleReportPO br = battleReports.get(fId);
/* 741 */         if (br.defenser.guildId.equals("") && br.attacker.guildId.equals("")) {
/*     */           continue;
/*     */         }
/*     */         
/* 745 */         GuildFortHandler.ReportListInfo.Builder subData = GuildFortHandler.ReportListInfo.newBuilder();
/* 746 */         subData.setAreaId(fId.intValue());
/* 747 */         subData.setDefenseGuildName(br.defenser.guildName);
/* 748 */         subData.setDefenseGuildIcon(br.defenser.guildIcon);
/* 749 */         subData.setAttackGuildName(br.attacker.guildName);
/* 750 */         subData.setAttackGuildIcon(br.attacker.guildIcon);
/*     */         
/* 752 */         if (br.defenser.isWinner()) {
/* 753 */           subData.setResult(0);
/* 754 */         } else if (br.attacker.isWinner()) {
/* 755 */           subData.setResult(1);
/*     */         } else {
/* 757 */           subData.setResult(2);
/*     */         } 
/* 759 */         data.addReportListInfo(subData);
/*     */       } 
/*     */       
/* 762 */       if (data.getReportListInfoCount() > 0) {
/* 763 */         res.addReportList(data);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 768 */     return null;
/*     */   }
/*     */   
/*     */   private void buildReportGuildDetail(GuildFortHandler.ReportGuildDetail.Builder res, GuildFortContenderPO contender) {
/* 772 */     res.setGuildIcon(contender.guildIcon);
/* 773 */     res.setGuildId(contender.guildId);
/* 774 */     res.setGuildName(contender.guildName);
/* 775 */     res.setGuildLevel(contender.guildLevel);
/* 776 */     res.setIsWinner(contender.isWinner() ? 1 : 0);
/*     */     
/* 778 */     res.setCollect(contender.pickItemNum);
/* 779 */     res.setDefense(contender.defBuff);
/* 780 */     res.setSoul(contender.killMonsterNum);
/* 781 */     res.setAttack(contender.attBuff);
/* 782 */     res.setKill(contender.killPlayerNum);
/* 783 */     res.setKillScore(contender.killPlayerScore);
/* 784 */     res.setDestroyFlag(contender.killFlagNum);
/* 785 */     res.setDestroyFlagScore(contender.killFlagScore);
/*     */     
/* 787 */     res.setTotalScore(contender.getScore());
/*     */   }
/*     */   
/*     */   public String handleApplyReportDetail(GuildFortHandler.ApplyReportDetailResponse.Builder res, String date, int fortId) {
/* 791 */     List<GuildFortReportPO> reports = GuildFortCenter.getInstance().getReports();
/* 792 */     for (GuildFortReportPO report : reports) {
/* 793 */       if (report.date.equals(date)) {
/* 794 */         GuildFortBattleReportPO br = (GuildFortBattleReportPO)report.battleReports.get(Integer.valueOf(fortId));
/* 795 */         if (br != null) {
/* 796 */           GuildFortHandler.ReportDetail.Builder data = GuildFortHandler.ReportDetail.newBuilder();
/* 797 */           data.setAreaId(fortId);
/* 798 */           GuildFortHandler.ReportGuildDetail.Builder subData = GuildFortHandler.ReportGuildDetail.newBuilder();
/* 799 */           buildReportGuildDetail(subData, br.defenser);
/* 800 */           data.setDetail1(subData);
/* 801 */           subData = GuildFortHandler.ReportGuildDetail.newBuilder();
/* 802 */           buildReportGuildDetail(subData, br.attacker);
/* 803 */           data.setDetail2(subData);
/* 804 */           res.setReportDetail(data);
/* 805 */           return null;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 810 */     return LangService.getValue("GUILDFORT_REPORT_NOT_FOUND");
/*     */   }
/*     */ 
/*     */   
/*     */   public String handleApplyReportStatistics(GuildFortHandler.ApplyReportStatisticsResponse.Builder res, String date, int fortId, String guildId) {
/* 815 */     List<GuildFortReportPO> reports = GuildFortCenter.getInstance().getReports();
/* 816 */     for (GuildFortReportPO report : reports) {
/* 817 */       if (report.date.equals(date)) {
/* 818 */         GuildFortBattleReportPO br = (GuildFortBattleReportPO)report.battleReports.get(Integer.valueOf(fortId));
/* 819 */         if (br != null) {
/* 820 */           GuildFortContenderPO ct = br.getContender(guildId);
/* 821 */           if (ct != null) {
/* 822 */             for (GuildFortMemberPO m : ct.getMembers()) {
/* 823 */               GuildFortHandler.ReportStatisticsDetail.Builder data = GuildFortHandler.ReportStatisticsDetail.newBuilder();
/* 824 */               data.setName(m.playerName);
/* 825 */               data.setLevel(m.playerLevel);
/* 826 */               data.setJob(m.guildJob);
/*     */               
/* 828 */               data.setKill(m.getKilledPlayerNum());
/* 829 */               data.setDestroyFlag(m.getKilledFlagNum());
/*     */               
/* 831 */               data.setDamage(m.getFightHurt());
/* 832 */               data.setCure(m.getFightCure());
/* 833 */               data.setDefenseScore(m.getDefBuffScore());
/* 834 */               data.setAttackSoul(m.getAttBuffScore());
/* 835 */               data.setTotalScore(m.getScore());
/*     */ 
/*     */               
/* 838 */               res.addStatisticsDetail(data);
/*     */             } 
/* 840 */             return null;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 846 */     return LangService.getValue("GUILDFORT_REPORT_NOT_FOUND");
/*     */   }
/*     */   
/*     */   private void setFortId(int fortId) {
/* 850 */     this.fortId = fortId;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<PlayerHandler.SuperScriptType> getSuperScript() {
/* 855 */     List<PlayerHandler.SuperScriptType> list = new ArrayList<>();
/* 856 */     boolean isInBid = GuildFortService.getInstance().isInBidTime();
/* 857 */     boolean isInEnterFort = GuildFortService.getInstance().isInEnterFortTime();
/* 858 */     boolean isCanAward = hasAward();
/*     */     
/* 860 */     PlayerHandler.SuperScriptType.Builder data = null;
/*     */     
/* 862 */     data = PlayerHandler.SuperScriptType.newBuilder();
/* 863 */     data.setType(Const.SUPERSCRIPT_TYPE.GUILDFORT_INBID.getValue());
/* 864 */     if (isInBid) {
/* 865 */       data.setNumber(1);
/*     */     } else {
/* 867 */       data.setNumber(0);
/*     */     } 
/* 869 */     list.add(data.build());
/*     */     
/* 871 */     data = PlayerHandler.SuperScriptType.newBuilder();
/* 872 */     data.setType(Const.SUPERSCRIPT_TYPE.GUILDFORT_INBATTLE.getValue());
/* 873 */     if (isInEnterFort) {
/* 874 */       data.setNumber(1);
/*     */     } else {
/* 876 */       data.setNumber(0);
/*     */     } 
/* 878 */     list.add(data.build());
/*     */     
/* 880 */     data = PlayerHandler.SuperScriptType.newBuilder();
/* 881 */     data.setType(Const.SUPERSCRIPT_TYPE.GUILDFORT_INAWARD.getValue());
/* 882 */     if (isCanAward) {
/* 883 */       data.setNumber(1);
/*     */     } else {
/* 885 */       data.setNumber(0);
/*     */     } 
/* 887 */     list.add(data.build());
/*     */     
/* 889 */     return list;
/*     */   }
/*     */   
/*     */   public void pushRedPoint() {
/* 893 */     this.player.updateSuperScriptList(getSuperScript());
/* 894 */     this.player.guildManager.pushRedPoint();
/*     */   }
/*     */   
/*     */   public boolean needUpdateRedPoint() {
/* 898 */     return (GuildFortService.getInstance().isInBidTime() || GuildFortService.getInstance().isInEnterFortTime() || 
/* 899 */       hasAward());
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\guild\guildFort\GuildFortManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */