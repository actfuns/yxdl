/*     */ package com.wanniu.game.guild.guildFort;
/*     */ 
/*     */ import com.google.protobuf.GeneratedMessage;
/*     */ import com.wanniu.core.db.GCache;
/*     */ import com.wanniu.core.game.JobFactory;
/*     */ import com.wanniu.core.game.LangService;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.game.area.Area;
/*     */ import com.wanniu.game.area.AreaUtil;
/*     */ import com.wanniu.game.area.DamageHealVO;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.Utils;
/*     */ import com.wanniu.game.common.msg.MessagePush;
/*     */ import com.wanniu.game.data.ext.GuildFortExt;
/*     */ import com.wanniu.game.guild.GuildServiceCenter;
/*     */ import com.wanniu.game.guild.GuildUtil;
/*     */ import com.wanniu.game.guild.guildFort.dao.GuildFortBattleReportPO;
/*     */ import com.wanniu.game.guild.guildFort.dao.GuildFortBidderPO;
/*     */ import com.wanniu.game.guild.guildFort.dao.GuildFortContenderPO;
/*     */ import com.wanniu.game.guild.guildFort.dao.GuildFortMemberPO;
/*     */ import com.wanniu.game.guild.guildFort.dao.GuildFortPO;
/*     */ import com.wanniu.game.item.ItemUtil;
/*     */ import com.wanniu.game.item.NormalItem;
/*     */ import com.wanniu.game.mail.MailUtil;
/*     */ import com.wanniu.game.mail.data.MailData;
/*     */ import com.wanniu.game.mail.data.MailSysData;
/*     */ import com.wanniu.game.player.GlobalConfig;
/*     */ import com.wanniu.game.player.PlayerUtil;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.poes.GuildPO;
/*     */ import com.wanniu.game.rank.RankType;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Comparator;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import pomelo.area.GuildFortHandler;
/*     */ import pomelo.item.ItemOuterClass;
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
/*     */ public class GuildFort
/*     */ {
/*  53 */   private GuildFortExt fortConfig = null;
/*  54 */   private GuildFortPO po = null;
/*     */ 
/*     */   
/*     */   private boolean battleOver = false;
/*     */   
/*  59 */   public GuildFortContenderPO defenser = null;
/*  60 */   public GuildFortContenderPO attacker = null;
/*     */   
/*  62 */   private GuildFortPveArea defPrepareArea = null;
/*  63 */   private GuildFortPveArea attPrepareArea = null;
/*  64 */   private GuildFortPveArea defPveArea = null;
/*  65 */   private GuildFortPveArea attPveArea = null;
/*  66 */   private GuildFortPvpArea pvpArea = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GuildFort(GuildFortExt fortConfig) {
/*  74 */     this.fortConfig = fortConfig;
/*  75 */     this.po = new GuildFortPO();
/*  76 */     this.po.fortId = fortConfig.iD;
/*     */   }
/*     */   
/*     */   public void setPo(GuildFortPO guildFortPO) {
/*  80 */     this.po = guildFortPO;
/*     */   }
/*     */   
/*     */   public GuildFortPO getPo() {
/*  84 */     return this.po;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<ItemOuterClass.MiniItem> getWinnerReward() {
/*  91 */     List<ItemOuterClass.MiniItem> res = new ArrayList<>();
/*  92 */     for (String key : this.fortConfig.winnerReward.keySet()) {
/*  93 */       ItemOuterClass.MiniItem.Builder data = ItemUtil.getMiniItemData(key, ((Integer)this.fortConfig.winnerReward.get(key)).intValue());
/*  94 */       res.add(data.build());
/*     */     } 
/*     */     
/*  97 */     return res;
/*     */   }
/*     */   
/*     */   public List<ItemOuterClass.MiniItem> getDailyAward() {
/* 101 */     List<ItemOuterClass.MiniItem> res = new ArrayList<>();
/* 102 */     for (String key : this.fortConfig.dailyReward.keySet()) {
/* 103 */       ItemOuterClass.MiniItem.Builder data = ItemUtil.getMiniItemData(key, ((Integer)this.fortConfig.dailyReward.get(key)).intValue());
/* 104 */       res.add(data.build());
/*     */     } 
/*     */     
/* 107 */     return res;
/*     */   }
/*     */   
/*     */   public List<NormalItem> generateDailyAward() {
/* 111 */     return ItemUtil.createItemsByItemCode(this.fortConfig.dailyReward);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getId() {
/* 119 */     return this.fortConfig.iD;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOccupyGuildId() {
/* 128 */     return GCache.hget("Tradenionstrongholds", String.valueOf(this.po.fortId));
/*     */   }
/*     */   
/*     */   public String getOccupyGuildIds() {
/* 132 */     return this.po.occupyGuildId;
/*     */   }
/*     */   
/*     */   public boolean isOccupier(String guildId) {
/* 136 */     String id = GCache.hget("Tradenionstrongholds", String.valueOf(this.po.fortId));
/* 137 */     if (id != null && id.equals(guildId)) {
/* 138 */       return true;
/*     */     }
/* 140 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int commitBidFund(String guildId, int fund) {
/* 151 */     GuildPO guild = GuildServiceCenter.getInstance().getGuild(guildId);
/* 152 */     int sumFund = 0;
/* 153 */     if (guild != null) {
/* 154 */       Out.info(new Object[] { "Apply fund guild id:", guild.id, " original fund:", Long.valueOf(guild.fund), " to deduct fund:" + fund });
/* 155 */       guild.fund -= fund;
/*     */       
/* 157 */       boolean isIn = false;
/* 158 */       for (GuildFortBidderPO bidder : this.po.bidders) {
/* 159 */         if (bidder.guildId.equals(guildId)) {
/* 160 */           if (bidder.fund + fund > Integer.MAX_VALUE) {
/* 161 */             Out.error(new Object[] { "Bid fund overflowed, guildId:" + guildId, " biddedFund:", Integer.valueOf(bidder.fund), " toAdd fund:", Integer.valueOf(fund) });
/* 162 */             return sumFund;
/*     */           } 
/* 164 */           bidder.fund += fund;
/* 165 */           sumFund = bidder.fund;
/* 166 */           isIn = true;
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/* 171 */       if (!isIn) {
/* 172 */         GuildFortBidderPO bidder = new GuildFortBidderPO(guildId, fund);
/* 173 */         this.po.bidders.add(bidder);
/* 174 */         sumFund = bidder.fund;
/*     */       } 
/*     */     } else {
/* 177 */       Out.warn(new Object[] { "Can't find the guild when commitBidFund by guildId=", guildId, " and fund=", Integer.valueOf(fund) });
/*     */     } 
/*     */     
/* 180 */     return sumFund;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int extractBidFund(String guildId) {
/* 190 */     int index = getInBiddersIndex(guildId);
/* 191 */     if (index != -1 && index < this.po.bidders.size()) {
/* 192 */       GuildFortBidderPO bidder = this.po.bidders.remove(index);
/* 193 */       Out.info(new Object[] { "Apply cancel all bidded fund, guild id=", guildId, "  fund=", Integer.valueOf(bidder.fund) });
/*     */       
/* 195 */       return returnBidFund(guildId, bidder.fund);
/*     */     } 
/* 197 */     return 0;
/*     */   }
/*     */   
/*     */   private int getInBiddersIndex(String guildId) {
/* 201 */     int index = 0;
/* 202 */     for (GuildFortBidderPO bidder : this.po.bidders) {
/* 203 */       if (bidder.guildId.equals(guildId)) {
/* 204 */         return index;
/*     */       }
/* 206 */       index++;
/*     */     } 
/* 208 */     return -1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void sendBidSucMail(String guildId, int fund) {
/* 218 */     GuildPO guild = GuildServiceCenter.getInstance().getGuild(guildId);
/*     */     
/* 220 */     MailSysData mailData = new MailSysData("GuildFortBidSuccess");
/* 221 */     mailData.replace = new HashMap<>();
/* 222 */     mailData.replace.put("guildname", guild.name);
/* 223 */     mailData.replace.put("fund", String.valueOf(fund));
/* 224 */     mailData.replace.put("fortname", getName());
/* 225 */     mailData.replace.put("fighttime", GuildFortService.getInstance().getBattleBeginTimeString());
/* 226 */     Set<String> ids = GuildUtil.getGuildMemberIdList(guildId);
/* 227 */     MailUtil.getInstance().sendMailToSomePlayer(ids.<String>toArray(new String[ids.size()]), (MailData)mailData, Const.GOODS_CHANGE_TYPE.guild_mail);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void sendBidFailMail(String guildId, int fund) {
/* 237 */     GuildPO guild = GuildServiceCenter.getInstance().getGuild(guildId);
/*     */     
/* 239 */     MailSysData mailData = new MailSysData("GuildFortBidFailed");
/* 240 */     mailData.replace = new HashMap<>();
/* 241 */     mailData.replace.put("guildname", guild.name);
/* 242 */     mailData.replace.put("fund", String.valueOf(fund));
/* 243 */     mailData.replace.put("fortname", getName());
/*     */     
/* 245 */     Set<String> ids = GuildUtil.getGuildMemberIdList(guildId);
/* 246 */     MailUtil.getInstance().sendMailToSomePlayer(ids.<String>toArray(new String[ids.size()]), (MailData)mailData, Const.GOODS_CHANGE_TYPE.guild_mail);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void sendBattleWinMail(GuildPO guild, int score, GuildFortContenderPO opponent) {
/* 257 */     String opponentName = "";
/* 258 */     if (opponent != null) {
/* 259 */       opponentName = opponent.guildName;
/*     */     }
/*     */     
/* 262 */     MailSysData mailData = new MailSysData("GuildFortNotifyBattleEndForWin");
/* 263 */     mailData.replace = new HashMap<>();
/* 264 */     mailData.replace.put("fortname", getName());
/* 265 */     mailData.replace.put("point", String.valueOf(score));
/* 266 */     mailData.replace.put("guildname", opponentName);
/*     */     
/* 268 */     ArrayList<MailData.Attachment> list = new ArrayList<>();
/* 269 */     for (String itemCode : this.fortConfig.winnerReward.keySet()) {
/* 270 */       MailData.Attachment attach = new MailData.Attachment();
/* 271 */       attach.itemCode = itemCode;
/* 272 */       attach.itemNum = ((Integer)this.fortConfig.winnerReward.get(itemCode)).intValue();
/* 273 */       list.add(attach);
/*     */     } 
/* 275 */     mailData.attachments = list;
/*     */     
/* 277 */     Set<String> ids = GuildUtil.getGuildMemberIdList(guild.id);
/* 278 */     MailUtil.getInstance().sendMailToSomePlayer(ids.<String>toArray(new String[ids.size()]), (MailData)mailData, Const.GOODS_CHANGE_TYPE.guild_mail);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void sendBattleFailMail(GuildPO guild, int score, GuildFortContenderPO opponent) {
/* 289 */     String opponentName = "";
/* 290 */     if (opponent != null) {
/* 291 */       opponentName = opponent.guildName;
/*     */     }
/*     */     
/* 294 */     MailSysData mailData = new MailSysData("GuildFortNotifyBattleEndForLose");
/* 295 */     mailData.replace = new HashMap<>();
/* 296 */     mailData.replace.put("fortname", getName());
/* 297 */     mailData.replace.put("point", String.valueOf(score));
/* 298 */     mailData.replace.put("guildname", opponentName);
/*     */     
/* 300 */     ArrayList<MailData.Attachment> list = new ArrayList<>();
/* 301 */     for (String itemCode : this.fortConfig.loserReward.keySet()) {
/* 302 */       MailData.Attachment attach = new MailData.Attachment();
/* 303 */       attach.itemCode = itemCode;
/* 304 */       attach.itemNum = ((Integer)this.fortConfig.loserReward.get(itemCode)).intValue();
/* 305 */       list.add(attach);
/*     */     } 
/* 307 */     mailData.attachments = list;
/*     */     
/* 309 */     Set<String> ids = GuildUtil.getGuildMemberIdList(guild.id);
/* 310 */     MailUtil.getInstance().sendMailToSomePlayer(ids.<String>toArray(new String[ids.size()]), (MailData)mailData, Const.GOODS_CHANGE_TYPE.guild_mail);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isInBidders(String guildId) {
/* 319 */     return (getInBiddersIndex(guildId) != -1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onBidOver() {
/* 326 */     calcBidResult();
/*     */   }
/*     */ 
/*     */   
/*     */   private void buildReport() {
/* 331 */     GuildFortBattleReportPO report = new GuildFortBattleReportPO();
/* 332 */     report.fortId = this.fortConfig.iD;
/* 333 */     report.fortName = this.fortConfig.name;
/* 334 */     if (this.defenser != null) {
/* 335 */       this.defenser.build();
/* 336 */       report.defenser = this.defenser;
/*     */     } else {
/* 338 */       report.defenser = new GuildFortContenderPO();
/*     */     } 
/*     */     
/* 341 */     if (this.attacker != null) {
/* 342 */       this.attacker.build();
/* 343 */       report.attacker = this.attacker;
/*     */     } else {
/* 345 */       report.attacker = new GuildFortContenderPO();
/*     */     } 
/*     */     
/* 348 */     GuildFortCenter.getInstance().addBattleReport(report);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void updateWinTimes(GuildFortContenderPO po, boolean isWin, GuildFortContenderPO opponent) {
/* 358 */     GuildPO guild = GuildServiceCenter.getInstance().getGuild(po.guildId);
/* 359 */     if (guild != null) {
/* 360 */       guild.fortInfo.onStat(isWin);
/* 361 */       if (isWin) {
/* 362 */         sendBattleWinMail(guild, po.getScore(), opponent);
/* 363 */         po.setWinner(true);
/*     */       } else {
/* 365 */         sendBattleFailMail(guild, po.getScore(), opponent);
/*     */       } 
/*     */     } else {
/* 368 */       Out.error(new Object[] { "can't find the guild when updateWinTimes, guildId=", po.guildId, " isWin=", Boolean.valueOf(isWin) });
/*     */     } 
/*     */   }
/*     */   
/*     */   private void setNobodyOccupied() {
/* 373 */     this.po.occupyGuildId = null;
/*     */   }
/*     */   
/*     */   private void calcBidResult() {
/* 377 */     System.out.println("-----------------------------------------------------------------------------::::::result:::::");
/* 378 */     List<GuildFortBidderPO> toSort = this.po.bidders;
/* 379 */     toSort.sort(new Comparator<GuildFortBidderPO>()
/*     */         {
/*     */           public int compare(GuildFortBidderPO o1, GuildFortBidderPO o2) {
/* 382 */             if (o1.fund < o2.fund)
/* 383 */               return 1; 
/* 384 */             if (o1.fund > o2.fund) {
/* 385 */               return -1;
/*     */             }
/* 387 */             return 0;
/*     */           }
/*     */         });
/*     */     
/* 391 */     int size = toSort.size();
/* 392 */     if (size == 0) {
/* 393 */       this.defenser = null;
/* 394 */       this.attacker = null;
/* 395 */     } else if (size == 1) {
/* 396 */       this.defenser = new GuildFortContenderPO(((GuildFortBidderPO)toSort.get(0)).guildId);
/* 397 */       this.attacker = null;
/* 398 */       sendBidSucMail(this.defenser.guildId, ((GuildFortBidderPO)toSort.get(0)).fund);
/*     */     } else {
/* 400 */       this.defenser = new GuildFortContenderPO(((GuildFortBidderPO)toSort.get(0)).guildId);
/* 401 */       this.attacker = new GuildFortContenderPO(((GuildFortBidderPO)toSort.get(1)).guildId);
/* 402 */       sendBidSucMail(this.defenser.guildId, ((GuildFortBidderPO)toSort.get(0)).fund);
/* 403 */       sendBidSucMail(this.attacker.guildId, ((GuildFortBidderPO)toSort.get(1)).fund);
/*     */     } 
/*     */     
/* 406 */     for (int i = 2; i < size; i++) {
/* 407 */       GuildFortBidderPO bidder = toSort.get(i);
/* 408 */       returnBidFund(bidder.guildId, bidder.fund);
/* 409 */       sendBidFailMail(bidder.guildId, bidder.fund);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void calcBattleResult() {
/* 414 */     this.po.occupyGuildId = null;
/* 415 */     if (this.defenser == null && this.attacker == null) {
/* 416 */       this.po.occupyGuildId = null;
/*     */       return;
/*     */     } 
/* 419 */     if (this.defenser != null && this.attacker == null) {
/* 420 */       if (this.defenser.getScore() >= GlobalConfig.GuildFort_MinWinPoint) {
/* 421 */         this.po.occupyGuildId = this.defenser.getGuildId();
/* 422 */         updateWinTimes(this.defenser, true, this.attacker);
/*     */       } else {
/* 424 */         this.po.occupyGuildId = null;
/* 425 */         updateWinTimes(this.defenser, false, this.attacker);
/*     */       } 
/*     */       return;
/*     */     } 
/* 429 */     if (this.defenser != null && this.attacker != null) {
/* 430 */       if (this.defenser.getScore() < this.attacker.getScore()) {
/* 431 */         if (this.attacker.getScore() >= GlobalConfig.GuildFort_MinWinPoint) {
/* 432 */           this.po.occupyGuildId = this.attacker.getGuildId();
/* 433 */           updateWinTimes(this.attacker, true, this.defenser);
/*     */         } else {
/* 435 */           updateWinTimes(this.attacker, false, this.defenser);
/*     */         } 
/* 437 */         updateWinTimes(this.defenser, false, this.attacker);
/*     */       } else {
/* 439 */         if (this.defenser.getScore() >= GlobalConfig.GuildFort_MinWinPoint) {
/* 440 */           this.po.occupyGuildId = this.defenser.getGuildId();
/* 441 */           updateWinTimes(this.defenser, true, this.attacker);
/*     */         } else {
/* 443 */           updateWinTimes(this.defenser, false, this.attacker);
/*     */         } 
/* 445 */         updateWinTimes(this.attacker, false, this.defenser);
/*     */       } 
/*     */       
/*     */       return;
/*     */     } 
/* 450 */     this.po.occupyGuildId = null;
/*     */   }
/*     */ 
/*     */   
/*     */   private int returnBidFund(String guildId, int fund) {
/* 455 */     GuildPO guild = GuildServiceCenter.getInstance().getGuild(guildId);
/* 456 */     if (guild != null) {
/* 457 */       int deductedFund = fund * (100 - GlobalConfig.GuildFort_BackRate) / 100;
/* 458 */       guild.fund += deductedFund;
/* 459 */       Out.info(new Object[] { "return Bid Fund guild id=", guildId, "  fund=", Integer.valueOf(fund) });
/* 460 */       return deductedFund;
/*     */     } 
/* 462 */     Out.warn(new Object[] { "Can't find the guild when return bidFund by guildId=", guildId, " return fund=", Integer.valueOf(fund) });
/*     */ 
/*     */     
/* 465 */     return 0;
/*     */   }
/*     */   
/*     */   private void broadcastBattleOver() {
/* 469 */     String guildId = getOccupyGuildId();
/* 470 */     if (guildId != null) {
/* 471 */       GuildPO guild = GuildServiceCenter.getInstance().getGuild(guildId);
/* 472 */       if (guild != null) {
/* 473 */         String msgStr = LangService.getValue("GUILDFORT_BATTLEEND_NOTICE");
/* 474 */         msgStr = msgStr.replace("{fortname}", getName()).replace("{guildname}", guild.name);
/* 475 */         GuildFortUtil.sendRollTipsToAllAnsy(msgStr);
/*     */       } else {
/* 477 */         Out.warn(new Object[] { "Can't find guild by guildId = ", guildId });
/*     */       } 
/*     */     } else {
/* 480 */       Out.info(new Object[] { getName(), " no one occupied..." });
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<String> getAllMemberIds() {
/* 488 */     List<String> ids = new ArrayList<>();
/* 489 */     if (this.defenser != null) {
/* 490 */       ids.addAll(GuildUtil.getGuildMemberIdList(this.defenser.guildId));
/*     */     }
/* 492 */     if (this.attacker != null) {
/* 493 */       ids.addAll(GuildUtil.getGuildMemberIdList(this.attacker.guildId));
/*     */     }
/*     */     
/* 496 */     return ids;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onBattleBegin() {
/* 503 */     setNobodyOccupied();
/* 504 */     if (this.defenser == null && this.attacker == null) {
/* 505 */       setBattleOver(true);
/* 506 */       dispose();
/*     */       return;
/*     */     } 
/* 509 */     setBattleOver(false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void onBattleOver() {
/* 516 */     if (isBattleOver()) {
/* 517 */       Out.warn(new Object[] { "guild fort battle has already overed!!!" });
/*     */       return;
/*     */     } 
/* 520 */     setBattleOver(true);
/* 521 */     calcBattleResult();
/* 522 */     pushBattleResult();
/* 523 */     updateRank();
/* 524 */     buildReport();
/* 525 */     broadcastBattleOver();
/* 526 */     dispose();
/*     */   }
/*     */   
/*     */   private void closeAllArea() {
/* 530 */     if (this.pvpArea != null) {
/* 531 */       AreaUtil.closeArea(this.pvpArea.instanceId);
/* 532 */       this.pvpArea = null;
/*     */     } 
/* 534 */     if (this.defPveArea != null) {
/* 535 */       AreaUtil.closeArea(this.defPveArea.instanceId);
/* 536 */       this.defPveArea = null;
/*     */     } 
/* 538 */     if (this.attPveArea != null) {
/* 539 */       AreaUtil.closeArea(this.attPveArea.instanceId);
/* 540 */       this.attPveArea = null;
/*     */     } 
/* 542 */     if (this.defPrepareArea != null) {
/* 543 */       AreaUtil.closeArea(this.defPrepareArea.instanceId);
/* 544 */       this.defPrepareArea = null;
/*     */     } 
/* 546 */     if (this.attPrepareArea != null) {
/* 547 */       AreaUtil.closeArea(this.attPrepareArea.instanceId);
/* 548 */       this.attPrepareArea = null;
/*     */     } 
/*     */   }
/*     */   
/*     */   private void dispose() {
/* 553 */     this.po.bidders.clear();
/* 554 */     JobFactory.addDelayJob(new Runnable()
/*     */         {
/*     */           public void run() {
/* 557 */             GuildFort.this.closeAllArea();
/*     */           }
/*     */         },  5000L);
/* 560 */     this.defenser = null;
/* 561 */     this.attacker = null;
/*     */   }
/*     */   
/*     */   public boolean isBattleOver() {
/* 565 */     return this.battleOver;
/*     */   }
/*     */   
/*     */   private void setBattleOver(boolean isOver) {
/* 569 */     this.battleOver = isOver;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isBattleMember(WNPlayer player) {
/* 578 */     return !(getContenderByPlayer(player) == null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Area requestEnterPrepareArea(WNPlayer player) {
/* 587 */     String guildId = player.guildManager.getGuildId();
/* 588 */     if (isDefenserMember(guildId)) {
/* 589 */       if (this.defPrepareArea == null) {
/* 590 */         Map<String, Object> userData = Utils.ofMap(new Object[] { "fortId", Integer.valueOf(getId()) });
/* 591 */         this.defPrepareArea = (GuildFortPveArea)AreaUtil.dispatchByAreaId(player, 54001, userData);
/*     */       } else {
/* 593 */         AreaUtil.changeTeamArea(player, this.defPrepareArea.getAreaData());
/*     */       } 
/* 595 */       return this.defPrepareArea;
/*     */     } 
/*     */     
/* 598 */     if (isAttackerMember(guildId)) {
/* 599 */       if (this.attPrepareArea == null) {
/* 600 */         Map<String, Object> userData = Utils.ofMap(new Object[] { "fortId", Integer.valueOf(getId()) });
/* 601 */         this.attPrepareArea = (GuildFortPveArea)AreaUtil.dispatchByAreaId(player, 54001, userData);
/*     */       } else {
/* 603 */         AreaUtil.changeTeamArea(player, this.attPrepareArea.getAreaData());
/*     */       } 
/* 605 */       return this.attPrepareArea;
/*     */     } 
/*     */     
/* 608 */     return null;
/*     */   }
/*     */   
/*     */   public Area requestEnterPveArea(WNPlayer player) {
/* 612 */     if (isDefenserMember(player.guildManager.getGuildId())) {
/* 613 */       if (this.defPveArea == null) {
/* 614 */         Map<String, Object> userData = Utils.ofMap(new Object[] { "fortId", Integer.valueOf(getId()) });
/* 615 */         this.defPveArea = (GuildFortPveArea)AreaUtil.dispatchByAreaId(player, 54002, userData);
/*     */       } else {
/* 617 */         AreaUtil.changeTeamArea(player, this.defPveArea.getAreaData());
/*     */       } 
/* 619 */       return this.defPveArea;
/*     */     } 
/*     */     
/* 622 */     if (isAttackerMember(player.guildManager.getGuildId())) {
/* 623 */       if (this.attPveArea == null) {
/* 624 */         Map<String, Object> userData = Utils.ofMap(new Object[] { "fortId", Integer.valueOf(getId()) });
/* 625 */         this.attPveArea = (GuildFortPveArea)AreaUtil.dispatchByAreaId(player, 54002, userData);
/*     */       } else {
/* 627 */         AreaUtil.changeTeamArea(player, this.attPveArea.getAreaData());
/*     */       } 
/* 629 */       return this.attPveArea;
/*     */     } 
/*     */     
/* 632 */     return null;
/*     */   }
/*     */   
/*     */   public Area requestEnterPvpArea(WNPlayer player) {
/* 636 */     if (this.pvpArea == null) {
/* 637 */       Map<String, Object> userData = Utils.ofMap(new Object[] { "fortId", Integer.valueOf(getId()) });
/* 638 */       this.pvpArea = (GuildFortPvpArea)AreaUtil.dispatchByAreaId(player, 54003, userData);
/*     */     } else {
/* 640 */       AreaUtil.changeTeamArea(player, this.pvpArea.getAreaData());
/*     */     } 
/*     */     
/* 643 */     return this.pvpArea;
/*     */   }
/*     */   
/*     */   public GuildFortContenderPO getContenderByPlayer(WNPlayer player) {
/* 647 */     return getContenderByGuildId(player.guildManager.getGuildId());
/*     */   }
/*     */ 
/*     */   
/*     */   private MessagePush generateDefenserReport(GuildFortHandler.FortGuildStatistics.Builder defBuilder, GuildFortHandler.FortGuildStatistics.Builder attBuilder) {
/* 652 */     GuildFortHandler.OnGuildFortPush.Builder res = GuildFortHandler.OnGuildFortPush.newBuilder();
/* 653 */     res.setS2CCode(200);
/*     */     
/* 655 */     if (defBuilder != null) {
/* 656 */       res.setOwnGuild(defBuilder);
/*     */     }
/* 658 */     if (attBuilder != null) {
/* 659 */       res.setEnemyGuild(attBuilder);
/*     */     }
/*     */     
/* 662 */     return new MessagePush("area.guildFortPush.onGuildFortPush", (GeneratedMessage)res.build());
/*     */   }
/*     */   
/*     */   private MessagePush generateAttackerReport(GuildFortHandler.FortGuildStatistics.Builder defBuilder, GuildFortHandler.FortGuildStatistics.Builder attBuilder) {
/* 666 */     GuildFortHandler.OnGuildFortPush.Builder res = GuildFortHandler.OnGuildFortPush.newBuilder();
/* 667 */     res.setS2CCode(200);
/*     */     
/* 669 */     if (defBuilder != null) {
/* 670 */       res.setEnemyGuild(defBuilder);
/*     */     }
/* 672 */     if (attBuilder != null) {
/* 673 */       res.setOwnGuild(attBuilder);
/*     */     }
/*     */     
/* 676 */     return new MessagePush("area.guildFortPush.onGuildFortPush", (GeneratedMessage)res.build());
/*     */   }
/*     */   
/*     */   private GuildFortHandler.FortGuildStatistics.Builder getStatistics(GuildFortContenderPO contender) {
/* 680 */     if (contender == null) {
/* 681 */       return null;
/*     */     }
/* 683 */     GuildFortHandler.FortGuildStatistics.Builder def = GuildFortHandler.FortGuildStatistics.newBuilder();
/* 684 */     GuildFortStatPush stat = contender.getPush();
/* 685 */     def.setArmyFlag(stat.killFlagNum);
/* 686 */     def.setMumber(stat.memberNumber);
/* 687 */     def.setDefenseSoul(stat.defBuffScore);
/* 688 */     def.setAttackSoul(stat.attBuffScore);
/* 689 */     def.setKill(stat.killPlayerNum);
/* 690 */     def.setAttack(stat.attBuff);
/* 691 */     def.setDefense(stat.defBuff);
/*     */     
/* 693 */     def.setScore(stat.score);
/* 694 */     return def;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GuildFortContenderPO getStatByPlayer(WNPlayer player, boolean isOpponent) {
/* 704 */     String gid = player.guildManager.getGuildId();
/* 705 */     if (isDefenserMember(gid)) {
/* 706 */       if (isOpponent) {
/* 707 */         if (this.attacker != null) {
/* 708 */           return this.attacker.getContenderPO();
/*     */         }
/*     */       }
/* 711 */       else if (this.defenser != null) {
/* 712 */         return this.defenser.getContenderPO();
/*     */       }
/*     */     
/* 715 */     } else if (isAttackerMember(gid)) {
/* 716 */       if (isOpponent) {
/* 717 */         if (this.defenser != null) {
/* 718 */           return this.defenser.getContenderPO();
/*     */         }
/*     */       }
/* 721 */       else if (this.attacker != null) {
/* 722 */         return this.attacker.getContenderPO();
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 727 */     return new GuildFortContenderPO();
/*     */   }
/*     */   
/*     */   public GuildFortContenderPO getContenderByGuildId(String guildId) {
/* 731 */     if (isDefenserMember(guildId))
/* 732 */       return this.defenser; 
/* 733 */     if (isAttackerMember(guildId)) {
/* 734 */       return this.attacker;
/*     */     }
/* 736 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   private void addDefBuffScore(GuildFortContenderPO contender, int score) {
/* 741 */     contender.defBuffScore += score;
/* 742 */     int afterAddDiv = contender.defBuffScore / GlobalConfig.GuildFort_PickAddDefense;
/* 743 */     if (afterAddDiv > contender.defBuff) {
/* 744 */       contender.defBuff = afterAddDiv;
/* 745 */       pushReport();
/* 746 */       pushBuffChanged(contender);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void addAttBuffScore(GuildFortContenderPO contender, int score) {
/* 751 */     contender.attBuffScore += score;
/* 752 */     int afterAddDiv = contender.attBuffScore / GlobalConfig.GuildFort_KillMonAddAttack;
/* 753 */     if (afterAddDiv > contender.attBuff) {
/* 754 */       contender.attBuff = afterAddDiv;
/* 755 */       pushReport();
/* 756 */       pushBuffChanged(contender);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void pushReport() {
/* 761 */     GuildFortHandler.FortGuildStatistics.Builder defBuilder = getStatistics(this.defenser);
/* 762 */     GuildFortHandler.FortGuildStatistics.Builder attBuilder = getStatistics(this.attacker);
/*     */     
/* 764 */     MessagePush defMsg = generateDefenserReport(defBuilder, attBuilder);
/* 765 */     MessagePush attMsg = generateAttackerReport(defBuilder, attBuilder);
/*     */     
/* 767 */     if (this.defPrepareArea != null) {
/* 768 */       this.defPrepareArea.pushReport(defMsg, attMsg);
/*     */     }
/* 770 */     if (this.defPveArea != null) {
/* 771 */       this.defPveArea.pushReport(defMsg, attMsg);
/*     */     }
/* 773 */     if (this.attPrepareArea != null) {
/* 774 */       this.attPrepareArea.pushReport(defMsg, attMsg);
/*     */     }
/* 776 */     if (this.attPveArea != null) {
/* 777 */       this.attPveArea.pushReport(defMsg, attMsg);
/*     */     }
/* 779 */     if (this.pvpArea != null) {
/* 780 */       this.pvpArea.pushReport(defMsg, attMsg);
/*     */     }
/*     */   }
/*     */   
/*     */   private void pushBattleResult() {
/* 785 */     if (this.defenser != null) {
/* 786 */       for (GuildFortMemberPO member : this.defenser.getMembers()) {
/* 787 */         WNPlayer player = PlayerUtil.getOnlinePlayer(member.playerId);
/* 788 */         if (player != null) {
/* 789 */           player.sendSysTip("据点战结果在这里。。。", Const.TipsType.NORMAL);
/*     */         }
/*     */       } 
/*     */     }
/*     */     
/* 794 */     if (this.attacker != null) {
/* 795 */       for (GuildFortMemberPO member : this.attacker.getMembers()) {
/* 796 */         WNPlayer player = PlayerUtil.getOnlinePlayer(member.playerId);
/* 797 */         if (player != null) {
/* 798 */           player.sendSysTip("据点战结果在这里。。。", Const.TipsType.NORMAL);
/*     */         }
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   private void pushBuffChanged(GuildFortContenderPO contender) {
/* 805 */     if (this.pvpArea != null) {
/* 806 */       this.pvpArea.onAddBuff(contender);
/*     */     }
/*     */   }
/*     */   
/*     */   private void addScore(GuildFortContenderPO contender, int score) {
/* 811 */     System.out.println("-----------------------------------------------add----------------" + score);
/* 812 */     System.out.println("-----------------------------------------------contender---------------" + contender.score);
/* 813 */     contender.score += score;
/* 814 */     pushReport();
/* 815 */     if (contender.score >= GlobalConfig.GuildFort_MaxWinPoint) {
/* 816 */       onBattleOver();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void onPlayerEntered(WNPlayer player) {
/* 822 */     GuildFortContenderPO contender = getContenderByPlayer(player);
/* 823 */     contender.getMemberAndPut(player);
/* 824 */     pushReport();
/*     */   }
/*     */   
/*     */   public void onPickedItem(WNPlayer player, int itemId) {
/* 828 */     if (isBattleOver()) {
/* 829 */       Out.warn(new Object[] { "guild fort battle is overed while on stat" });
/*     */       
/*     */       return;
/*     */     } 
/* 833 */     GuildFortContenderPO contender = getContenderByPlayer(player);
/* 834 */     GuildFortMemberPO stat = contender.getMemberAndPut(player);
/* 835 */     Integer times = (Integer)GlobalConfig.guildFortPickPoint.get(Integer.valueOf(itemId));
/* 836 */     if (times == null) {
/* 837 */       Out.warn(new Object[] { "guildFortPickPoint not contains the itemId,itemId: ", Integer.valueOf(itemId), " playerId: " + player.getId() });
/*     */       return;
/*     */     } 
/* 840 */     stat.onPickedItem(itemId, times.intValue());
/*     */     
/* 842 */     addDefBuffScore(contender, times.intValue());
/*     */   }
/*     */   
/*     */   public void onKilledMonster(WNPlayer player, int monsterId) {
/* 846 */     if (isBattleOver()) {
/* 847 */       Out.warn(new Object[] { "guild fort battle is overed while on stat" });
/*     */       return;
/*     */     } 
/* 850 */     GuildFortContenderPO contender = getContenderByPlayer(player);
/* 851 */     GuildFortMemberPO stat = contender.getMemberAndPut(player);
/* 852 */     Integer times = (Integer)GlobalConfig.guildFortKillMonPoint.get(Integer.valueOf(monsterId));
/* 853 */     if (times == null) {
/* 854 */       Out.warn(new Object[] { "guildFortKillMonPoint not contains the monster,monsterId: ", Integer.valueOf(monsterId), " playerId: " + player.getId() });
/*     */       
/*     */       return;
/*     */     } 
/* 858 */     stat.onKilledMonster(monsterId, times.intValue());
/* 859 */     addAttBuffScore(contender, times.intValue());
/*     */   }
/*     */   
/*     */   public void onKilledFlag(WNPlayer player, int monsterId) {
/* 863 */     if (isBattleOver()) {
/* 864 */       Out.warn(new Object[] { "guild fort battle is overed while on stat" });
/*     */       return;
/*     */     } 
/* 867 */     GuildFortContenderPO contender = getContenderByPlayer(player);
/* 868 */     GuildFortMemberPO stat = contender.getMemberAndPut(player);
/* 869 */     stat.onKilledFlag(GlobalConfig.GuildFort_DestroyPoint);
/*     */     
/* 871 */     addScore(contender, GlobalConfig.GuildFort_DestroyPoint);
/*     */   }
/*     */   
/*     */   public void onKilledPlayer(WNPlayer player) {
/* 875 */     if (isBattleOver()) {
/* 876 */       Out.warn(new Object[] { "guild fort battle is overed while on stat" });
/*     */       
/*     */       return;
/*     */     } 
/* 880 */     GuildFortContenderPO contender = getContenderByPlayer(player);
/* 881 */     GuildFortMemberPO stat = contender.getMemberAndPut(player);
/* 882 */     stat.onKilledPlayer(GlobalConfig.GuildFort_KillPoint);
/*     */     
/* 884 */     addScore(contender, GlobalConfig.GuildFort_KillPoint);
/*     */   }
/*     */   
/*     */   public void onBattleReport(WNPlayer player, DamageHealVO report, int count) {
/* 888 */     if (isBattleOver()) {
/* 889 */       Out.warn(new Object[] { "guild fort battle is overed while on stat" });
/*     */       return;
/*     */     } 
/* 892 */     GuildFortContenderPO contender = getContenderByPlayer(player);
/* 893 */     GuildFortMemberPO stat = contender.getMemberAndPut(player);
/* 894 */     stat.onFightHurt(report.TotalDamage, count);
/* 895 */     stat.onFightHurt(report.TotalHealing, count);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isDefenserMember(String guildId) {
/* 900 */     return (this.defenser != null && this.defenser.isMember(guildId));
/*     */   }
/*     */   
/*     */   public boolean isAttackerMember(String guildId) {
/* 904 */     return (this.attacker != null && this.attacker.isMember(guildId));
/*     */   }
/*     */   
/*     */   public List<GuildFortBidderPO> getBidders() {
/* 908 */     return this.po.bidders;
/*     */   }
/*     */   
/*     */   public boolean isBidWinner(String guildId) {
/* 912 */     if (this.defenser != null && this.defenser.getGuildId().equals(guildId)) {
/* 913 */       return true;
/*     */     }
/*     */     
/* 916 */     return false;
/*     */   }
/*     */   
/*     */   public String getName() {
/* 920 */     return this.fortConfig.name;
/*     */   }
/*     */   
/*     */   public String getDefenserName() {
/* 924 */     if (this.defenser == null) {
/* 925 */       return "";
/*     */     }
/*     */     
/* 928 */     return this.defenser.guildName;
/*     */   }
/*     */   
/*     */   public String getAttackerName() {
/* 932 */     if (this.attacker == null) {
/* 933 */       return "";
/*     */     }
/*     */     
/* 936 */     return this.attacker.guildName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateRank() {
/* 944 */     String guildId = getOccupyGuildId();
/* 945 */     if (guildId == null) {
/* 946 */       Out.error(new Object[] { "occupied guild id null occured in update rank" });
/*     */       return;
/*     */     } 
/* 949 */     GuildPO guild = GuildServiceCenter.getInstance().getGuild(guildId);
/* 950 */     if (guild != null)
/* 951 */       RankType.GUILD_FORT.getHandler().handle(guild); 
/*     */   }
/*     */   
/*     */   public GuildFort() {}
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\guild\guildFort\GuildFort.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */