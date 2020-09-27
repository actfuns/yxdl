/*     */ package com.wanniu.game.guild.guildFort;
/*     */ 
/*     */ import com.google.protobuf.GeneratedMessage;
/*     */ import com.wanniu.core.game.entity.GPlayer;
/*     */ import com.wanniu.core.util.DateUtil;
/*     */ import com.wanniu.core.util.StringUtil;
/*     */ import com.wanniu.game.GWorld;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.msg.MessageUtil;
/*     */ import com.wanniu.game.guild.GuildUtil;
/*     */ import com.wanniu.game.mail.MailUtil;
/*     */ import com.wanniu.game.mail.data.MailData;
/*     */ import com.wanniu.game.mail.data.MailSysData;
/*     */ import com.wanniu.game.player.PlayerUtil;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import pomelo.chat.ChatHandler;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GuildFortUtil
/*     */ {
/*     */   public static void mailToAllGuildManagerWhenBidBegin() {
/*  32 */     List<String> playerIds = GuildUtil.getMemberIds(new Const.GuildJob[] { Const.GuildJob.PRESIDENT, Const.GuildJob.VICE_PRESIDENT });
/*  33 */     MailSysData mailData = new MailSysData("GuildFortNotifyBidBegin");
/*  34 */     mailData.replace = new HashMap<>();
/*  35 */     mailData.replace.put("begintime", GuildFortService.getInstance().getBattleBeginTimeString());
/*  36 */     mailData.replace.put("endtime", GuildFortService.getInstance().getBattleEndTimeString());
/*     */     
/*  38 */     MailUtil.getInstance().sendMailToSomePlayer(playerIds.<String>toArray(new String[playerIds.size()]), (MailData)mailData, Const.GOODS_CHANGE_TYPE.guild_mail);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void pushRedPointToAll() {
/*  45 */     for (GPlayer gPlayer : PlayerUtil.getAllOnlinePlayer()) {
/*  46 */       ((WNPlayer)gPlayer).guildFortManager.pushRedPoint();
/*     */     }
/*     */   }
/*     */   
/*     */   public static void pushRedPoint(Set<String> players) {
/*  51 */     for (String playerId : players) {
/*  52 */       WNPlayer player = PlayerUtil.getOnlinePlayer(playerId);
/*  53 */       if (player != null) {
/*  54 */         player.guildFortManager.pushRedPoint();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void sendRollTipsToAllAnsy(String msg) {
/*  65 */     sendRollTipsToAllAsyn(msg, Const.CHAT_SCOPE.WORLD);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void sendRollTipsToAllAsyn(String msg, Const.CHAT_SCOPE scope) {
/*  73 */     GWorld.getInstance().ansycExec(() -> {
/*     */           for (GPlayer p : PlayerUtil.getAllOnlinePlayer()) {
/*     */             WNPlayer wp = (WNPlayer)p;
/*     */             MessageUtil.sendSysTip(wp, msg, Const.TipsType.ROLL);
/*     */             sendChatMsg(wp, msg, scope, Const.TipsType.BLACK);
/*     */           } 
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void sendRollTipsAsyn(Set<String> playerIds, String msg, Const.CHAT_SCOPE scope) {
/*  89 */     GWorld.getInstance().ansycExec(() -> {
/*     */           for (String playerId : playerIds) {
/*     */             WNPlayer player = PlayerUtil.getOnlinePlayer(playerId);
/*     */             if (player != null) {
/*     */               if (scope == Const.CHAT_SCOPE.SYSTEM || scope == Const.CHAT_SCOPE.WORLD) {
/*     */                 MessageUtil.sendSysTip(player, msg, Const.TipsType.ROLL);
/*     */               }
/*     */               sendChatMsg(player, msg, scope, Const.TipsType.BLACK);
/*     */             } 
/*     */           } 
/*     */         });
/*     */   }
/*     */   
/*     */   private static void sendChatMsg(WNPlayer player, String content, Const.CHAT_SCOPE scope, Const.TipsType scroll) {
/* 103 */     ChatHandler.OnChatPush.Builder msg = ChatHandler.OnChatPush.newBuilder();
/* 104 */     msg.setS2CPlayerId((player.getPlayer()).id);
/* 105 */     msg.setS2CUid((player.getPlayer()).uid);
/* 106 */     msg.setS2CContent(StringUtil.isEmpty(content) ? "content is null" : content);
/* 107 */     msg.setS2CScope(scope.getValue());
/* 108 */     msg.setS2CSys(scroll.getValue());
/* 109 */     msg.setS2CTime(DateUtil.getDateTime());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 121 */     msg.setS2CServerData("{}");
/*     */     
/* 123 */     player.receive("chat.chatPush.onChatPush", (GeneratedMessage)msg.build());
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\guild\guildFort\GuildFortUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */