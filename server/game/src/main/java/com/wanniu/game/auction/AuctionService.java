/*     */ package com.wanniu.game.auction;
/*     */ 
/*     */ import com.google.protobuf.GeneratedMessage;
/*     */ import com.wanniu.core.GGame;
/*     */ import com.wanniu.core.game.JobFactory;
/*     */ import com.wanniu.core.game.entity.GPlayer;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.util.DateUtils;
/*     */ import com.wanniu.game.GWorld;
/*     */ import com.wanniu.game.activity.RechargeActivityService;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.ConstsTR;
/*     */ import com.wanniu.game.common.msg.MessageUtil;
/*     */ import com.wanniu.game.data.GameData;
/*     */ import com.wanniu.game.data.RewardListCO;
/*     */ import com.wanniu.game.data.base.DItemEquipBase;
/*     */ import com.wanniu.game.guild.GuildUtil;
/*     */ import com.wanniu.game.guild.ItemRecordInfo;
/*     */ import com.wanniu.game.guild.dao.GuildDao;
/*     */ import com.wanniu.game.guild.guidDepot.GuildAuctionLog;
/*     */ import com.wanniu.game.item.ItemUtil;
/*     */ import com.wanniu.game.item.NormalItem;
/*     */ import com.wanniu.game.item.VirtualItemType;
/*     */ import com.wanniu.game.mail.MailUtil;
/*     */ import com.wanniu.game.mail.data.MailData;
/*     */ import com.wanniu.game.mail.data.MailSysData;
/*     */ import com.wanniu.game.player.GlobalConfig;
/*     */ import com.wanniu.game.player.PlayerUtil;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.poes.AuctionItemPO;
/*     */ import com.wanniu.game.poes.GuildBossPo;
/*     */ import com.wanniu.game.poes.GuildMemberPO;
/*     */ import com.wanniu.game.poes.GuildPO;
/*     */ import com.wanniu.game.poes.PlayerPO;
/*     */ import com.wanniu.redis.PlayerPOManager;
/*     */ import java.time.Duration;
/*     */ import java.time.LocalDateTime;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Optional;
/*     */ import java.util.Set;
/*     */ import java.util.UUID;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import java.util.concurrent.ScheduledFuture;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import org.apache.commons.lang3.RandomUtils;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ import pomelo.auction.AuctionHandler;
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
/*     */ public class AuctionService
/*     */ {
/*  80 */   private static final AuctionService instance = new AuctionService();
/*     */   
/*  82 */   private static final Map<String, Long> syncs = new ConcurrentHashMap<>();
/*     */   
/*  84 */   private static final Map<String, ScheduledFuture<?>> futures = new ConcurrentHashMap<>();
/*     */   
/*     */   public static AuctionService getInstance() {
/*  87 */     return instance;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addSyncRequest(String playerId) {
/*  94 */     syncs.put(playerId, Long.valueOf(System.currentTimeMillis()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void cancelSyncRequest(String playerId) {
/* 101 */     syncs.remove(playerId);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addAuctionItem(List<NormalItem> items, String guildId, String rewardSource) {
/* 108 */     LocalDateTime now = LocalDateTime.now();
/*     */     
/* 110 */     List<AuctionItemPO> newItemList = new ArrayList<>();
/* 111 */     for (NormalItem item : items) {
/* 112 */       AuctionItemPO aitem = create(item, guildId, rewardSource);
/* 113 */       AuctionDataManager.getInstance().addAuctionItem(aitem);
/*     */       
/* 115 */       addDelayJob(now, aitem);
/* 116 */       newItemList.add(aitem);
/*     */     } 
/*     */ 
/*     */     
/* 120 */     GWorld.getInstance().ansycExec(() -> syncAddAuctionItemInfo(newItemList, 1));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void processGuildAuctionsPoint(String guildId) {
/* 127 */     List<GuildMemberPO> memberList = GuildUtil.getGuildMemberList(guildId);
/* 128 */     if (memberList != null && !memberList.isEmpty()) {
/* 129 */       for (GuildMemberPO po : memberList) {
/* 130 */         WNPlayer player = PlayerUtil.getOnlinePlayer(po.playerId);
/* 131 */         if (player != null) {
/* 132 */           player.auctionManager.pushScript();
/*     */         }
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void processWorldAuctionsPoint() {
/* 142 */     Map<String, GPlayer> map = GGame.getInstance().getOnlinePlayers();
/* 143 */     if (map != null && !map.isEmpty()) {
/* 144 */       Collection<GPlayer> playerIds = map.values();
/* 145 */       for (GPlayer player : playerIds) {
/* 146 */         ((WNPlayer)player).auctionManager.pushScript();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void syncAddAuctionItemInfo(List<AuctionItemPO> newItemList, int type) {
/* 153 */     for (String playerId : syncs.keySet()) {
/* 154 */       WNPlayer player = GWorld.getInstance().getPlayer(playerId);
/* 155 */       if (player == null) {
/*     */         continue;
/*     */       }
/*     */       
/* 159 */       AuctionHandler.AddAuctionItemPush.Builder push = AuctionHandler.AddAuctionItemPush.newBuilder();
/* 160 */       for (AuctionItemPO item : newItemList) {
/*     */         
/* 162 */         if (hasContinue(item, player)) {
/*     */           continue;
/*     */         }
/* 165 */         push.addS2CItem(toAuctionItem(player, item));
/*     */       } 
/* 167 */       if (push.getS2CItemCount() > 0) {
/* 168 */         push.setS2CType(type);
/* 169 */         player.receive("auction.auctionPush.addAuctionItemPush", (GeneratedMessage)push.build());
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void syncAuctionItemInfo(AuctionItemPO item) {
/* 176 */     for (String playerId : syncs.keySet()) {
/* 177 */       WNPlayer player = GWorld.getInstance().getPlayer(playerId);
/* 178 */       if (player == null) {
/*     */         continue;
/*     */       }
/*     */ 
/*     */       
/* 183 */       if (hasContinue(item, player)) {
/*     */         continue;
/*     */       }
/*     */       
/* 187 */       AuctionHandler.AuctionItemPush.Builder push = AuctionHandler.AuctionItemPush.newBuilder();
/* 188 */       push.setS2CItem(toAuctionItem(player, item));
/* 189 */       player.receive("auction.auctionPush.auctionItemPush", (GeneratedMessage)push.build());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void syncRemoveAuctionItem(AuctionItemPO item) {
/* 195 */     AuctionHandler.RemoveAuctionItemPush push = AuctionHandler.RemoveAuctionItemPush.newBuilder().setId(item.id).build();
/* 196 */     for (String playerId : syncs.keySet()) {
/* 197 */       WNPlayer player = GWorld.getInstance().getPlayer(playerId);
/* 198 */       if (player == null) {
/*     */         continue;
/*     */       }
/*     */ 
/*     */       
/* 203 */       if (hasContinue(item, player)) {
/*     */         continue;
/*     */       }
/*     */       
/* 207 */       player.receive("auction.auctionPush.removeAuctionItemPush", (GeneratedMessage)push);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean hasContinue(AuctionItemPO item, WNPlayer player) {
/* 213 */     if (StringUtils.isNotEmpty(item.guildId) && 
/* 214 */       !item.guildId.equals(player.guildManager.getGuildId()))
/*     */     {
/* 216 */       if (item.participant == null || !item.participant.contains(player.getId())) {
/* 217 */         return true;
/*     */       }
/*     */     }
/*     */     
/* 221 */     return false;
/*     */   }
/*     */   
/*     */   public AuctionHandler.AuctionItem toAuctionItem(WNPlayer player, AuctionItemPO item) {
/* 225 */     NormalItem normalItem = ItemUtil.createItemByDbOpts(item.db);
/* 226 */     AuctionHandler.AuctionItem.Builder builder = AuctionHandler.AuctionItem.newBuilder();
/* 227 */     builder.setId(item.id);
/* 228 */     builder.setDetail(normalItem.getItemDetail(player.playerBasePO));
/* 229 */     builder.setState(item.state);
/* 230 */     builder.setTimeleft((int)Duration.between(LocalDateTime.now(), item.stateOverTime).getSeconds());
/* 231 */     builder.setCurPrice(item.nextPrice);
/* 232 */     builder.setMaxPrice(item.maxPrice);
/* 233 */     builder.setSelf(player.getId().equals(item.playerId));
/* 234 */     builder.setNum(normalItem.getNum());
/* 235 */     builder.setSource((item.source == null) ? "" : item.source);
/* 236 */     return builder.build();
/*     */   }
/*     */   
/*     */   private AuctionItemPO create(NormalItem item, String guildId, String rewardSource) {
/* 240 */     AuctionItemPO data = new AuctionItemPO();
/* 241 */     data.id = UUID.randomUUID().toString();
/* 242 */     data.db = item.itemDb;
/*     */     
/* 244 */     data.db.isBind = Const.ForceType.BIND.getValue();
/*     */ 
/*     */     
/* 247 */     data.state = 1;
/* 248 */     data.stateOverTime = LocalDateTime.now().plusMinutes(GlobalConfig.Auction_GuildShowTime).plusSeconds(RandomUtils.nextInt(1, 60));
/* 249 */     data.guildId = guildId;
/* 250 */     data.source = rewardSource;
/*     */     
/* 252 */     Optional<RewardListCO> template = GameData.RewardLists.values().stream().filter(v -> data.db.code.equals(v.code)).findFirst();
/* 253 */     if (template.isPresent()) {
/* 254 */       data.curPrice = ((RewardListCO)template.get()).auctionMin * item.getNum();
/* 255 */       data.maxPrice = ((RewardListCO)template.get()).auctionMax * item.getNum();
/*     */     } else {
/* 257 */       Out.warn(new Object[] { "竞拍物品找不到竞价模板，code=", data.db.code });
/* 258 */       data.curPrice = 100 * item.getNum();
/* 259 */       data.maxPrice = 100000 * item.getNum();
/*     */     } 
/* 261 */     data.nextPrice = data.curPrice;
/* 262 */     return data;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<AuctionItemPO> getGuildAuctionItemList(WNPlayer player) {
/* 269 */     String guildId = player.guildManager.getGuildId();
/* 270 */     if (StringUtils.isEmpty(guildId)) {
/* 271 */       return Collections.emptyList();
/*     */     }
/* 273 */     return AuctionDataManager.getInstance().getItemByPredicate(v -> guildId.equals(v.guildId));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<AuctionItemPO> getSelfAuctionItemList(WNPlayer player) {
/* 280 */     return AuctionDataManager.getInstance().getItemByPredicate(v -> (v.participant != null && v.participant.contains(player.getId())));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<AuctionItemPO> getWorldAuctionItemList(WNPlayer player) {
/* 287 */     List<AuctionItemPO> list = AuctionDataManager.getInstance().getItemByPredicate(v -> (v.guildId == null));
/* 288 */     if (list != null && !list.isEmpty()) {
/* 289 */       GuildBossPo guildBossPO = player.guildBossManager.getAndCheckUpdateGuildBossPo(player.player.id);
/* 290 */       guildBossPO.aucpoint = 1;
/*     */       
/* 292 */       player.auctionManager.pushScript();
/*     */     } 
/* 294 */     return list;
/*     */   }
/*     */   
/*     */   public void addDelayJob(LocalDateTime now, AuctionItemPO item) {
/* 298 */     long timeleft = Duration.between(now, item.stateOverTime).getSeconds();
/* 299 */     futures.put(item.id, JobFactory.addDelayJob(() -> { removeSchedule(item.id); GWorld.getInstance().ansycExec(new AuctionTimeoutHandler(item.id)); }timeleft, TimeUnit.SECONDS));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void resetDelayJob(LocalDateTime now, AuctionItemPO item) {
/* 306 */     ScheduledFuture<?> future = futures.remove(item.id);
/* 307 */     if (future != null) {
/* 308 */       future.cancel(false);
/* 309 */       if (!future.isCancelled()) {
/* 310 */         Out.warn(new Object[] { "记录一个非法状态, itemId=", item.id });
/*     */         
/*     */         return;
/*     */       } 
/*     */     } 
/*     */     
/* 316 */     addDelayJob(now, item);
/*     */   }
/*     */   
/*     */   public void removeSchedule(String id) {
/* 320 */     futures.remove(id);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void settlementAttribution(AuctionItemPO item) {
/* 327 */     String playerId = item.playerId;
/* 328 */     Out.info(new Object[] { "结算竟拍归属，id=", item.id, ",code=", item.db.code, ",playerId=", playerId, ",price=", Integer.valueOf(item.curPrice) });
/*     */     
/* 330 */     AuctionDataManager.getInstance().removeAuctionItem(item.id);
/* 331 */     ScheduledFuture<?> future = futures.remove(item.id);
/* 332 */     if (future != null) {
/* 333 */       future.cancel(false);
/*     */     }
/* 335 */     boolean isPrice = (item.curPrice >= item.maxPrice);
/* 336 */     if (StringUtils.isNotEmpty(playerId)) {
/*     */       try {
/* 338 */         String mailKey = isPrice ? "AuctionGetReward2" : "AuctionGetReward1";
/* 339 */         MailSysData mail = new MailSysData(mailKey);
/* 340 */         mail.entityItems = new ArrayList();
/* 341 */         mail.entityItems.add(item.db);
/*     */         
/* 343 */         mail.replace = new HashMap<>();
/* 344 */         mail.replace.put("Price", String.valueOf(item.curPrice));
/* 345 */         DItemEquipBase itemBase = ItemUtil.getPropByCode(item.db.code);
/* 346 */         mail.replace.put("Item", MessageUtil.itemColorName(itemBase.qcolor, itemBase.name));
/*     */         
/* 348 */         MailUtil.getInstance().sendMailToOnePlayer(playerId, (MailData)mail, Const.GOODS_CHANGE_TYPE.AUCTION);
/*     */ 
/*     */         
/* 351 */         if (item.diamond > 0) {
/* 352 */           PlayerPO playerPo = PlayerUtil.getPlayerBaseData(playerId);
/* 353 */           if (playerPo != null) {
/* 354 */             playerPo.totalCostDiamond += item.diamond;
/* 355 */             RechargeActivityService.getInstance().onConsumeEvent(playerId, item.diamond);
/*     */             
/* 357 */             Out.info(new Object[] { "add totalCostDiamond playerId=", playerId, ",num=", Integer.valueOf(item.diamond) });
/*     */           } else {
/* 359 */             Out.warn(new Object[] { "add totalCostDiamond error. playerId=", playerId, ",num=", Integer.valueOf(item.diamond) });
/*     */           } 
/*     */         } 
/* 362 */       } catch (Exception e) {
/* 363 */         Out.warn(new Object[] { "竞拍结算归属异常.playerId=", playerId, ",diamond=", Integer.valueOf(item.diamond), ",ticket=", Integer.valueOf(item.ticket), ",itemcode=", item.db.code });
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 368 */     String guildId = item.guildId;
/* 369 */     if (StringUtils.isNotEmpty(guildId)) {
/* 370 */       int type = isPrice ? 2 : 1;
/* 371 */       GWorld.getInstance().ansycExec(() -> log(guildId, playerId, type, item.db.code, item.curPrice));
/*     */     } 
/*     */ 
/*     */     
/* 375 */     GWorld.getInstance().ansycExec(() -> getInstance().syncRemoveAuctionItem(item));
/*     */ 
/*     */     
/* 378 */     trySendAuctionBonus(guildId);
/*     */ 
/*     */     
/* 381 */     processWorldAuctionsPoint();
/*     */   }
/*     */   
/*     */   public void trySendAuctionBonus(String guildId) {
/*     */     int totalBonus, bonus;
/* 386 */     if (StringUtils.isEmpty(guildId)) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 391 */     if (AuctionDataManager.getInstance().hasGuildItem(guildId)) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 396 */     GuildPO guild = GuildUtil.getGuild(guildId);
/* 397 */     if (guild == null) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 402 */     Set<String> ids = GuildUtil.getGuildMemberIdList(guildId);
/* 403 */     if (ids == null || ids.isEmpty()) {
/*     */       return;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 409 */     synchronized (guild) {
/* 410 */       totalBonus = guild.auctionBonus;
/* 411 */       bonus = Math.min(GlobalConfig.Auction_MaxBonus, totalBonus / ids.size());
/* 412 */       if (bonus <= 0) {
/*     */         return;
/*     */       }
/* 415 */       guild.auctionBonus = 0;
/*     */     } 
/*     */ 
/*     */     
/* 419 */     for (String playerId : ids) {
/*     */       try {
/* 421 */         MailSysData mail = new MailSysData("AuctionShareBonus");
/* 422 */         mail.attachments = new ArrayList();
/*     */ 
/*     */         
/* 425 */         MailData.Attachment att = new MailData.Attachment();
/* 426 */         att.itemCode = VirtualItemType.CASH.getItemcode();
/* 427 */         att.itemNum = bonus;
/* 428 */         mail.attachments.add(att);
/*     */         
/* 430 */         mail.replace = new HashMap<>();
/* 431 */         mail.replace.put("Price", String.valueOf(totalBonus));
/* 432 */         mail.replace.put("Num", String.valueOf(bonus));
/*     */         
/* 434 */         MailUtil.getInstance().sendMailToOnePlayer(playerId, (MailData)mail, Const.GOODS_CHANGE_TYPE.AUCTION_BONUS);
/* 435 */       } catch (Exception e) {
/* 436 */         Out.warn(new Object[] { "竞拍分红异常.playerId=", playerId, ",ticket=", Integer.valueOf(bonus) });
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void restitution(AuctionItemPO item) {
/*     */     try {
/* 446 */       MailSysData mail = new MailSysData("AuctionReturn");
/* 447 */       mail.attachments = new ArrayList();
/*     */       
/* 449 */       if (item.diamond > 0) {
/* 450 */         MailData.Attachment att = new MailData.Attachment();
/* 451 */         att.itemCode = VirtualItemType.DIAMOND.getItemcode();
/* 452 */         att.itemNum = item.diamond;
/* 453 */         mail.attachments.add(att);
/*     */       } 
/* 455 */       if (item.ticket > 0) {
/* 456 */         MailData.Attachment att = new MailData.Attachment();
/* 457 */         att.itemCode = VirtualItemType.CASH.getItemcode();
/* 458 */         att.itemNum = item.ticket;
/* 459 */         mail.attachments.add(att);
/*     */       } 
/*     */       
/* 462 */       mail.replace = new HashMap<>();
/* 463 */       DItemEquipBase itemBase = ItemUtil.getPropByCode(item.db.code);
/* 464 */       mail.replace.put("Item", MessageUtil.itemColorName(itemBase.qcolor, itemBase.name));
/* 465 */       MailUtil.getInstance().sendMailToOnePlayer(item.playerId, (MailData)mail, Const.GOODS_CHANGE_TYPE.AUCTION_RESTITUTION);
/* 466 */     } catch (Exception e) {
/* 467 */       Out.warn(new Object[] { "竞拍归还竞价异常.playerId=", item.playerId, ",diamond=", Integer.valueOf(item.diamond), ",ticket=", Integer.valueOf(item.ticket) });
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
/*     */   public void log(String guildId, String playerId, int type, String itemcode, int price) {
/* 481 */     GuildAuctionLog log = new GuildAuctionLog();
/* 482 */     log.type = type;
/* 483 */     DItemEquipBase itemBase = ItemUtil.getPropByCode(itemcode);
/* 484 */     log.item = new ItemRecordInfo();
/* 485 */     log.item.name = itemBase.name;
/* 486 */     log.item.qColor = itemBase.qcolor;
/* 487 */     log.price = price;
/* 488 */     log.time = LocalDateTime.now().format(DateUtils.F_YYYYMMDDHHMMSS);
/* 489 */     if (StringUtils.isNotEmpty(playerId)) {
/* 490 */       PlayerPO baseData = (PlayerPO)PlayerPOManager.findPO(ConstsTR.playerTR, playerId, PlayerPO.class);
/* 491 */       if (baseData != null) {
/* 492 */         log.player = baseData.name;
/*     */       }
/*     */     } 
/* 495 */     addGuildAuctionLog(guildId, log);
/*     */   }
/*     */   
/*     */   public void addGuildAuctionLog(String guildId, GuildAuctionLog record) {
/* 499 */     List<GuildAuctionLog> logs = GuildDao.getGuildAuctionLog(guildId);
/* 500 */     synchronized (logs) {
/* 501 */       logs.add(0, record);
/* 502 */       while (logs.size() > 50) {
/* 503 */         logs.remove(logs.size() - 1);
/*     */       }
/*     */     } 
/* 506 */     GuildDao.saveGuildAuctionLog(guildId);
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\auction\AuctionService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */