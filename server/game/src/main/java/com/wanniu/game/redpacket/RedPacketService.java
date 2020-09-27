/*     */ package com.wanniu.game.redpacket;
/*     */ 
/*     */ import com.alibaba.fastjson.JSON;
/*     */ import com.google.protobuf.GeneratedMessage;
/*     */ import com.wanniu.core.GGame;
/*     */ import com.wanniu.core.db.GCache;
/*     */ import com.wanniu.core.game.JobFactory;
/*     */ import com.wanniu.core.game.LangService;
/*     */ import com.wanniu.core.game.entity.GPlayer;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.tcp.protocol.Message;
/*     */ import com.wanniu.core.util.DateUtil;
/*     */ import com.wanniu.core.util.RandomUtil;
/*     */ import com.wanniu.game.GWorld;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.ConstsTR;
/*     */ import com.wanniu.game.common.msg.MessagePush;
/*     */ import com.wanniu.game.common.msg.MessageUtil;
/*     */ import com.wanniu.game.data.GameData;
/*     */ import com.wanniu.game.data.RedPackageCO;
/*     */ import com.wanniu.game.data.ext.ScheduleExt;
/*     */ import com.wanniu.game.guild.GuildServiceCenter;
/*     */ import com.wanniu.game.item.VirtualItemType;
/*     */ import com.wanniu.game.mail.MailUtil;
/*     */ import com.wanniu.game.mail.data.MailData;
/*     */ import com.wanniu.game.mail.data.MailSysData;
/*     */ import com.wanniu.game.message.MessageData;
/*     */ import com.wanniu.game.player.GlobalConfig;
/*     */ import com.wanniu.game.player.PlayerUtil;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.poes.GuildPO;
/*     */ import com.wanniu.game.poes.MessagePO;
/*     */ import com.wanniu.game.poes.RedPacketCenterPO;
/*     */ import com.wanniu.game.util.BlackWordUtil;
/*     */ import java.time.Duration;
/*     */ import java.time.LocalDate;
/*     */ import java.time.LocalDateTime;
/*     */ import java.time.LocalTime;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import pomelo.area.MessageHandler;
/*     */ import pomelo.chat.ChatHandler;
/*     */ import pomelo.redpacket.RedPacketHandler;
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
/*     */ public class RedPacketService
/*     */ {
/*     */   private static RedPacketService redPacketService;
/*     */   public RedPacketCenterPO redPacketCenterPO;
/*     */   private ScheduleExt scheduleExt;
/*  70 */   private int taskId = 18;
/*     */   
/*     */   public static RedPacketService getInstance() {
/*  73 */     if (redPacketService == null) {
/*  74 */       redPacketService = new RedPacketService();
/*     */     }
/*  76 */     return redPacketService;
/*     */   }
/*     */   
/*     */   public void init() {
/*  80 */     this.scheduleExt = (ScheduleExt)GameData.Schedules.get(Integer.valueOf(this.taskId));
/*     */     
/*  82 */     String data = GCache.hget(Integer.toString(GWorld.__SERVER_ID), ConstsTR.RedPacket.value);
/*  83 */     if (data == null) {
/*  84 */       this.redPacketCenterPO = new RedPacketCenterPO();
/*  85 */       GCache.hset(Integer.toString(GWorld.__SERVER_ID), ConstsTR.RedPacket.value, JSON.toJSONString(this.redPacketCenterPO));
/*     */     } else {
/*     */       
/*  88 */       this.redPacketCenterPO = (RedPacketCenterPO)JSON.parseObject(data, RedPacketCenterPO.class);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  93 */     List<RedPacket> rightToRemove = new LinkedList<>();
/*     */     
/*  95 */     synchronized (this.redPacketCenterPO) {
/*  96 */       for (null = this.redPacketCenterPO.redPackets.values().iterator(); null.hasNext(); ) { RedPacket redPacket = null.next();
/*  97 */         long leftMili = redPacket.dispatchDate.getTime() + (GlobalConfig.Red_HongbaoTime * 1000 * 60) - System.currentTimeMillis();
/*  98 */         if (leftMili <= 0L) {
/*  99 */           rightToRemove.add(redPacket);
/*     */           
/* 101 */           int fetchedNum = 0;
/* 102 */           for (RedPacketFetchInfo redPacketFetchInfo : redPacket.redPacketFetchInfoList) {
/* 103 */             if (redPacketFetchInfo.fetcherId == null) {
/* 104 */               fetchedNum += redPacketFetchInfo.num;
/*     */             }
/*     */           } 
/* 107 */           if (redPacket.benifitType == 1) {
/* 108 */             fetchedNum /= GlobalConfig.Red_HongbaoRatio;
/*     */           }
/* 110 */           if (fetchedNum > 0) {
/* 111 */             MailSysData mailData = new MailSysData("RedPackBack");
/* 112 */             List<MailData.Attachment> list_attach = new ArrayList<>();
/* 113 */             MailData.Attachment attachment = new MailData.Attachment();
/* 114 */             attachment.itemCode = VirtualItemType.DIAMOND.getItemcode();
/* 115 */             attachment.itemNum = fetchedNum;
/* 116 */             list_attach.add(attachment);
/* 117 */             mailData.attachments = list_attach;
/* 118 */             MailUtil.getInstance().sendMailToOnePlayer(redPacket.providerId, (MailData)mailData, Const.GOODS_CHANGE_TYPE.RedPacket);
/*     */           } 
/*     */           
/*     */           continue;
/*     */         } 
/* 123 */         String packetId = redPacket.id;
/* 124 */         JobFactory.addDelayJob(() -> { synchronized (this.redPacketCenterPO) { this.redPacketCenterPO.redPackets.remove(packetId); }  RedPacketHandler.OnRedPacketDispatchPush.Builder pushBuilder = RedPacketHandler.OnRedPacketDispatchPush.newBuilder(); pushBuilder.setS2CCode(200); pushBuilder.setId(packetId); GWorld.getInstance().broadcast((Message)new MessagePush("redpacket.redPacketPush.onRedPacketDispatchPush", (GeneratedMessage)pushBuilder.build()), GWorld.__SERVER_ID); if (redPacket.providerId != null) { int fetchedNum = 0; for (RedPacketFetchInfo redPacketFetchInfo : redPacket.redPacketFetchInfoList) fetchedNum += redPacketFetchInfo.num;  if (redPacket.benifitType == 1) fetchedNum /= GlobalConfig.Red_HongbaoRatio;  MailSysData mailData = new MailSysData("RedPackBack"); List<MailData.Attachment> list_attach = new ArrayList<>(); MailData.Attachment attachment = new MailData.Attachment(); attachment.itemCode = VirtualItemType.DIAMOND.getItemcode(); attachment.itemNum = fetchedNum; list_attach.add(attachment); mailData.attachments = list_attach; MailUtil.getInstance().sendMailToOnePlayer(redPacket.providerId, (MailData)mailData, Const.GOODS_CHANGE_TYPE.RedPacket); }  }leftMili); }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 157 */       for (RedPacket redPacket : rightToRemove) {
/* 158 */         Out.error(new Object[] { "clear:", redPacket.id, ",", redPacket.providerName, ",", redPacket.dispatchDate });
/* 159 */         this.redPacketCenterPO.redPackets.remove(redPacket.id);
/*     */       } 
/*     */       
/* 162 */       GCache.hset(Integer.toString(GWorld.__SERVER_ID), ConstsTR.RedPacket.value, JSON.toJSONString(this.redPacketCenterPO));
/*     */     } 
/*     */ 
/*     */     
/* 166 */     Map<LocalTime, Integer> slot = new HashMap<>();
/* 167 */     String[] slotStrs = GlobalConfig.Red_Time_Slot.split(";");
/* 168 */     for (String slotSubStr : slotStrs) {
/* 169 */       String[] slotSubStrs = slotSubStr.split(",");
/* 170 */       LocalTime localTime = LocalTime.parse(slotSubStrs[0]);
/* 171 */       int count = Integer.parseInt(slotSubStrs[1]);
/* 172 */       slot.put(localTime, Integer.valueOf(count));
/*     */     } 
/*     */     
/* 175 */     for (Map.Entry<LocalTime, Integer> entry : slot.entrySet()) {
/* 176 */       LocalTime startTime = entry.getKey();
/* 177 */       LocalDate startDate = LocalDate.now();
/* 178 */       LocalDateTime baseStartDateTime = LocalDateTime.of(startDate, startTime);
/* 179 */       int repeatCount = ((Integer)entry.getValue()).intValue(); long i;
/* 180 */       for (i = 0L; i < repeatCount; i++) {
/* 181 */         LocalDateTime startDateTime = baseStartDateTime.plusSeconds(i * GlobalConfig.Red_Time_Space);
/*     */         
/* 183 */         if (LocalDateTime.now().isAfter(startDateTime)) {
/* 184 */           startDateTime = startDateTime.plusDays(1L);
/*     */         }
/* 186 */         Duration duration = Duration.between(LocalDateTime.now(), startDateTime);
/* 187 */         long timeOffset = duration.toMillis();
/* 188 */         JobFactory.addFixedRateJob(() -> { String msg = ""; int msgCount = GameData.RedPackages.size(); if (msgCount >= 1) { int randomMsgId = RandomUtil.getInt(1, msgCount); msg = ((RedPackageCO)GameData.RedPackages.get(Integer.valueOf(randomMsgId))).words; }  dispatchRedPacket(null, GlobalConfig.God_Red_Money, GlobalConfig.Red_Time_Number, 0, 1, 1, msg); }timeOffset, Const.Time.Day
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 196 */             .getValue());
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
/*     */   
/*     */   public RedPacketHandler.GetRedPacketListResponse.Builder getAllRedPackets(String playerId) {
/* 209 */     RedPacketHandler.GetRedPacketListResponse.Builder builder = RedPacketHandler.GetRedPacketListResponse.newBuilder();
/*     */     
/* 211 */     GuildPO guildPO = GuildServiceCenter.getInstance().getGuildByMemberId(playerId);
/*     */     
/* 213 */     synchronized (this.redPacketCenterPO) {
/* 214 */       for (RedPacket redPacket : this.redPacketCenterPO.redPackets.values()) {
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
/* 229 */         if (redPacket.providerGuildId != null) {
/* 230 */           if (guildPO == null) {
/*     */             continue;
/*     */           }
/* 233 */           if (!redPacket.providerGuildId.equals(guildPO.id)) {
/*     */             continue;
/*     */           }
/*     */         } 
/*     */         
/* 238 */         RedPacketHandler.RedPacketInfo.Builder redPacketInfoBuilder = getRedPacketInfo(redPacket, playerId);
/*     */         
/* 240 */         if (redPacketInfoBuilder != null) {
/* 241 */           builder.addRedPacketInfo(redPacketInfoBuilder);
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 247 */     builder.setS2CCode(200);
/* 248 */     return builder;
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
/*     */   private RedPacketHandler.RedPacketInfo.Builder getRedPacketInfo(RedPacket redPacket, String playerId) {
/* 277 */     if (playerId != null) {
/* 278 */       GuildPO guildPO = GuildServiceCenter.getInstance().getGuildByMemberId(playerId);
/*     */       
/* 280 */       if (redPacket.providerGuildId != null) {
/* 281 */         if (guildPO == null) {
/* 282 */           return null;
/*     */         }
/* 284 */         if (!redPacket.providerGuildId.equals(guildPO.id)) {
/* 285 */           return null;
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 291 */     RedPacketHandler.RedPacketInfo.Builder builder = RedPacketHandler.RedPacketInfo.newBuilder();
/* 292 */     builder.setId(redPacket.id);
/* 293 */     builder.setCount(redPacket.count);
/* 294 */     builder.setTotalNum(redPacket.totalNum);
/* 295 */     builder.setChannelType((redPacket.providerGuildId == null) ? 0 : 1);
/* 296 */     builder.setBenifitType(redPacket.benifitType);
/* 297 */     builder.setFetchType(redPacket.fetchType);
/*     */     
/* 299 */     if (redPacket.providerId != null) {
/* 300 */       builder.setProviderId(redPacket.providerId);
/*     */     }
/*     */     
/* 303 */     builder.setProviderName(redPacket.providerName);
/* 304 */     builder.setMessage(redPacket.msg);
/* 305 */     builder.setDispatchTimestamp(redPacket.dispatchDate.getTime());
/*     */ 
/*     */     
/* 308 */     for (RedPacketFetchInfo redPacketFetchInfo : redPacket.redPacketFetchInfoList) {
/* 309 */       if (redPacketFetchInfo.fetcherId != null) {
/* 310 */         RedPacketHandler.FetcherInfo.Builder fetcherInfoBuilder = RedPacketHandler.FetcherInfo.newBuilder();
/* 311 */         fetcherInfoBuilder.setFetcherId(redPacketFetchInfo.fetcherId);
/* 312 */         fetcherInfoBuilder.setFetcherName(redPacketFetchInfo.fetcherName);
/* 313 */         fetcherInfoBuilder.setFetcherValue(redPacketFetchInfo.num);
/*     */         
/* 315 */         builder.addFetcherList(fetcherInfoBuilder);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 321 */     return builder;
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
/*     */   public int dispatchRedPacket(String playerId, int totalNum, int count, int channelType, int fetchType, int benifitType, String msg) {
/* 409 */     WNPlayer player = null;
/* 410 */     GuildPO guildPO = null;
/* 411 */     RedPacket redPacket = null;
/*     */ 
/*     */     
/* 414 */     if (playerId != null) {
/* 415 */       player = PlayerUtil.getOnlinePlayer(playerId);
/* 416 */       guildPO = GuildServiceCenter.getInstance().getGuildByMemberId(playerId);
/*     */       
/* 418 */       if (totalNum < GlobalConfig.Red_DiamondNumber_Down || totalNum > GlobalConfig.Red_DiamondNumber_Up)
/*     */       {
/* 420 */         return 1;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 426 */       if (player.getLevel() < GlobalConfig.Red_SendLevel)
/*     */       {
/* 428 */         return 3;
/*     */       }
/* 430 */       if (!player.moneyManager.enoughDiamond(totalNum))
/*     */       {
/* 432 */         return 4;
/*     */       }
/* 434 */       if (channelType == 1 && guildPO == null)
/*     */       {
/* 436 */         return 5;
/*     */       }
/*     */       
/* 439 */       player.moneyManager.costDiamond(totalNum, Const.GOODS_CHANGE_TYPE.RedPacket);
/*     */ 
/*     */       
/* 442 */       msg = BlackWordUtil.replaceBlackString(msg);
/*     */ 
/*     */       
/* 445 */       if (channelType == 0) {
/* 446 */         redPacket = new RedPacket(playerId, player.getName(), null, totalNum, count, fetchType, benifitType, msg);
/*     */       }
/*     */       else {
/*     */         
/* 450 */         redPacket = new RedPacket(playerId, player.getName(), guildPO.id, totalNum, count, fetchType, benifitType, msg);
/*     */       
/*     */       }
/*     */     
/*     */     }
/*     */     else {
/*     */       
/* 457 */       redPacket = new RedPacket(null, LangService.getValue("RED_PACKET_SYS_NAME"), null, totalNum, count, fetchType, benifitType, msg);
/*     */     } 
/*     */ 
/*     */     
/* 461 */     synchronized (this.redPacketCenterPO) {
/* 462 */       this.redPacketCenterPO.redPackets.put(redPacket.id, redPacket);
/* 463 */       GCache.hset(Integer.toString(GWorld.__SERVER_ID), ConstsTR.RedPacket.value, JSON.toJSONString(this.redPacketCenterPO));
/*     */     } 
/*     */ 
/*     */     
/* 467 */     String packetId = redPacket.id;
/* 468 */     RedPacket tempRedpacket = redPacket;
/* 469 */     JobFactory.addDelayJob(() -> { synchronized (this.redPacketCenterPO) { this.redPacketCenterPO.redPackets.remove(packetId); }  RedPacketHandler.OnRedPacketDispatchPush.Builder pushBuilder = RedPacketHandler.OnRedPacketDispatchPush.newBuilder(); pushBuilder.setS2CCode(200); pushBuilder.setId(packetId); GWorld.getInstance().broadcast((Message)new MessagePush("redpacket.redPacketPush.onRedPacketDispatchPush", (GeneratedMessage)pushBuilder.build()), GWorld.__SERVER_ID); if (tempRedpacket.providerId != null) { int fetchedNum = 0; for (RedPacketFetchInfo redPacketFetchInfo : tempRedpacket.redPacketFetchInfoList) { if (redPacketFetchInfo.fetcherId == null) fetchedNum += redPacketFetchInfo.num;  }  if (tempRedpacket.benifitType == 1) fetchedNum /= GlobalConfig.Red_HongbaoRatio;  if (fetchedNum > 0) { MailSysData mailData = new MailSysData("RedPackBack"); List<MailData.Attachment> list_attach = new ArrayList<>(); MailData.Attachment attachment = new MailData.Attachment(); attachment.itemCode = VirtualItemType.DIAMOND.getItemcode(); attachment.itemNum = fetchedNum; list_attach.add(attachment); mailData.attachments = list_attach; MailUtil.getInstance().sendMailToOnePlayer(tempRedpacket.providerId, (MailData)mailData, Const.GOODS_CHANGE_TYPE.RedPacket); }  }  }(GlobalConfig.Red_HongbaoTime * 1000 * 60));
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
/* 508 */     RedPacketHandler.OnRedPacketDispatchPush.Builder pushBuilder = RedPacketHandler.OnRedPacketDispatchPush.newBuilder();
/* 509 */     pushBuilder.setS2CCode(200);
/* 510 */     RedPacketHandler.RedPacketInfo.Builder redPacketInfoBuilder = getRedPacketInfo(redPacket, playerId);
/* 511 */     pushBuilder.setRedPacketInfo(redPacketInfoBuilder);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 516 */     MessagePO opts = new MessagePO();
/* 517 */     opts.createPlayerId = "";
/* 518 */     opts.id = "";
/* 519 */     opts.strMsg = null;
/* 520 */     opts.createTime = new Date();
/* 521 */     opts.messageType = Const.MESSAGE_TYPE.redpacket.getValue();
/* 522 */     opts.data = null;
/* 523 */     MessageData message = new MessageData(opts);
/* 524 */     MessageHandler.OnMessageAddPush.Builder onMessageAddPushBuilder = MessageHandler.OnMessageAddPush.newBuilder();
/* 525 */     onMessageAddPushBuilder.setS2CCode(200);
/* 526 */     onMessageAddPushBuilder.setS2CData(message.toJson4PayLoad());
/*     */ 
/*     */ 
/*     */     
/* 530 */     String chatMsg = LangService.format("RED_PACKET_DISPATCH_MSG", new Object[] { redPacket.providerName });
/* 531 */     if (redPacket.providerId == null) {
/* 532 */       chatMsg = LangService.getValue("RED_PACKET_SYS_MSG");
/*     */     }
/* 534 */     ChatHandler.OnChatPush.Builder chatPushBuilder = ChatHandler.OnChatPush.newBuilder();
/* 535 */     chatPushBuilder.setS2CPlayerId("");
/* 536 */     chatPushBuilder.setS2CUid("");
/* 537 */     chatPushBuilder.setS2CContent(chatMsg);
/* 538 */     chatPushBuilder.setS2CSys(1);
/* 539 */     chatPushBuilder.setS2CTime(DateUtil.getDateTime());
/* 540 */     chatPushBuilder.setS2CServerData("{}");
/* 541 */     if (redPacket.providerGuildId == null) {
/* 542 */       chatPushBuilder.setS2CScope(Const.CHAT_SCOPE.WORLD.getValue());
/*     */     } else {
/*     */       
/* 545 */       chatPushBuilder.setS2CScope(Const.CHAT_SCOPE.GUILD.getValue());
/*     */     } 
/*     */ 
/*     */     
/* 549 */     for (GPlayer gplayer : GGame.getInstance().getOnlinePlayers().values()) {
/* 550 */       GuildPO gguildPO = GuildServiceCenter.getInstance().getGuildByMemberId(gplayer.getId());
/* 551 */       if (redPacket.providerGuildId != null && (
/* 552 */         gguildPO == null || !gguildPO.id.equals(redPacket.providerGuildId))) {
/*     */         continue;
/*     */       }
/*     */       
/* 556 */       gplayer.receive((Message)new MessagePush("redpacket.redPacketPush.onRedPacketDispatchPush", (GeneratedMessage)pushBuilder.build()));
/* 557 */       gplayer.receive((Message)new MessagePush("area.messagePush.onMessageAddPush", (GeneratedMessage)onMessageAddPushBuilder.build()));
/* 558 */       gplayer.receive((Message)new MessagePush("chat.chatPush.onChatPush", (GeneratedMessage)chatPushBuilder.build()));
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
/* 588 */     Out.info(new Object[] { "玩家id:", playerId, ",发布了红包id:", redPacket.id, ",totalNum:", Integer.valueOf(redPacket.totalNum), ",count:", 
/* 589 */           Integer.valueOf(redPacket.count), ",channelType:", Integer.valueOf(channelType), ",fetchType:", 
/* 590 */           Integer.valueOf(redPacket.fetchType), ",benifitType:", Integer.valueOf(redPacket.benifitType) });
/*     */     
/* 592 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int fetchRedPacket(String playerId, String redPacketId) {
/* 602 */     GuildPO guildPO = GuildServiceCenter.getInstance().getGuildByMemberId(playerId);
/* 603 */     WNPlayer player = PlayerUtil.getOnlinePlayer(playerId);
/* 604 */     RedPacket redPacket = null;
/* 605 */     RedPacketFetchInfo selectedFetchInfo = null;
/* 606 */     int selectedPos = 0;
/* 607 */     synchronized (this.redPacketCenterPO) {
/* 608 */       redPacket = (RedPacket)this.redPacketCenterPO.redPackets.get(redPacketId);
/* 609 */       if (redPacket == null)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 616 */         return -1;
/*     */       }
/* 618 */       List<RedPacketFetchInfo> canFetchList = new LinkedList<>();
/* 619 */       for (RedPacketFetchInfo redPacketFetchInfo : redPacket.redPacketFetchInfoList) {
/* 620 */         if (redPacketFetchInfo.fetcherId != null) {
/* 621 */           if (redPacketFetchInfo.fetcherId.equals(playerId))
/*     */           {
/* 623 */             return -2;
/*     */           }
/*     */           continue;
/*     */         } 
/* 627 */         canFetchList.add(redPacketFetchInfo);
/*     */       } 
/*     */       
/* 630 */       if (canFetchList.size() == 0)
/*     */       {
/* 632 */         return -3;
/*     */       }
/* 634 */       selectedPos = RandomUtil.random(canFetchList.size());
/* 635 */       selectedFetchInfo = canFetchList.get(selectedPos);
/*     */ 
/*     */       
/* 638 */       if ((player.dailyActivityMgr.getTaskInfo(this.taskId)).process >= this.scheduleExt.maxAttend)
/*     */       {
/* 640 */         return -4;
/*     */       }
/* 642 */       if (player.getLevel() < GlobalConfig.Red_LootLevel)
/*     */       {
/* 644 */         return -5;
/*     */       }
/* 646 */       if (redPacket.providerGuildId != null) {
/* 647 */         if (guildPO == null)
/*     */         {
/* 649 */           return -6;
/*     */         }
/* 651 */         if (!redPacket.providerGuildId.equals(guildPO.id))
/*     */         {
/* 653 */           return -7;
/*     */         }
/*     */       } 
/*     */       
/* 657 */       selectedFetchInfo.SetFetcher(playerId, player.getName());
/*     */       
/* 659 */       GCache.hset(Integer.toString(GWorld.__SERVER_ID), ConstsTR.RedPacket.value, JSON.toJSONString(this.redPacketCenterPO));
/*     */       
/* 661 */       switch (redPacket.benifitType) {
/*     */         case 0:
/* 663 */           player.moneyManager.addDiamond(selectedFetchInfo.num, Const.GOODS_CHANGE_TYPE.RedPacket);
/*     */           break;
/*     */         case 1:
/* 666 */           player.moneyManager.addGold(selectedFetchInfo.num, Const.GOODS_CHANGE_TYPE.RedPacket);
/*     */           break;
/*     */         
/*     */         default:
/* 670 */           Out.error(new Object[] { "参数错误" });
/* 671 */           return -8;
/*     */       } 
/*     */     
/*     */     } 
/* 675 */     player.dailyActivityMgr.onEvent(Const.DailyType.RED_PACKET, "0", 1);
/*     */     
/* 677 */     RedPacketHandler.OnRedPacketDispatchPush.Builder pushBuilder = RedPacketHandler.OnRedPacketDispatchPush.newBuilder();
/* 678 */     pushBuilder.setS2CCode(200);
/* 679 */     RedPacketHandler.RedPacketInfo.Builder redPacketInfoBuilder = getRedPacketInfo(redPacket, playerId);
/* 680 */     pushBuilder.setRedPacketInfo(redPacketInfoBuilder);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 687 */     for (GPlayer gplayer : GGame.getInstance().getOnlinePlayers().values()) {
/* 688 */       GuildPO gguildPO = GuildServiceCenter.getInstance().getGuildByMemberId(gplayer.getId());
/* 689 */       if (redPacket.providerGuildId != null && (
/* 690 */         gguildPO == null || !gguildPO.id.equals(redPacket.providerGuildId))) {
/*     */         continue;
/*     */       }
/*     */ 
/*     */       
/* 695 */       gplayer.receive((Message)new MessagePush("redpacket.redPacketPush.onRedPacketDispatchPush", (GeneratedMessage)pushBuilder.build()));
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 700 */       if (redPacket.fetchType == 0) {
/* 701 */         ChatHandler.OnChatPush.Builder chatPushBuilder = ChatHandler.OnChatPush.newBuilder();
/* 702 */         if (redPacket.providerGuildId == null) {
/* 703 */           chatPushBuilder = MessageUtil.createChatMsg(player, redPacket.msg, Const.CHAT_SCOPE.WORLD, Const.TipsType.ROLL);
/*     */         } else {
/*     */           
/* 706 */           chatPushBuilder = MessageUtil.createChatMsg(player, redPacket.msg, Const.CHAT_SCOPE.GUILD, Const.TipsType.ROLL);
/*     */         } 
/*     */         
/* 709 */         gplayer.receive((Message)new MessagePush("chat.chatPush.onChatPush", (GeneratedMessage)chatPushBuilder.build()));
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 717 */     Out.info(new Object[] { "玩家id:", playerId, ",获得了红包id:", redPacket.id, ",totalNum:", Integer.valueOf(redPacket.totalNum), ",count:", 
/* 718 */           Integer.valueOf(redPacket.count), ",红包位置id:", Integer.valueOf(selectedPos), ",fetchType:", 
/* 719 */           Integer.valueOf(redPacket.fetchType), ",benifitType:", Integer.valueOf(redPacket.benifitType) });
/*     */ 
/*     */ 
/*     */     
/* 723 */     return selectedFetchInfo.num;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\redpacket\RedPacketService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */