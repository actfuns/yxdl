/*     */ package com.wanniu.game.common.msg;
/*     */ 
/*     */ import com.alibaba.fastjson.JSON;
/*     */ import com.google.protobuf.GeneratedMessage;
/*     */ import com.wanniu.core.tcp.protocol.Message;
/*     */ import com.wanniu.core.util.DateUtil;
/*     */ import com.wanniu.core.util.StringUtil;
/*     */ import com.wanniu.game.GWorld;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.ShowTipUtil;
/*     */ import com.wanniu.game.data.SocialMessageCO;
/*     */ import com.wanniu.game.message.MessageData;
/*     */ import com.wanniu.game.message.SocialMessageConfig;
/*     */ import com.wanniu.game.player.PlayerUtil;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
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
/*     */ public final class MessageUtil
/*     */   extends ShowTipUtil
/*     */ {
/*     */   public static void sendMessage(String playerId, String route, GeneratedMessage data) {
/*  32 */     WNPlayer player = GWorld.getInstance().getPlayer(playerId);
/*  33 */     if (player != null) {
/*  34 */       player.write((Message)new MessagePush(route, data));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void sendRollChat(int logicServerId, String content, Const.CHAT_SCOPE scope) {
/*  42 */     ChatHandler.OnChatPush.Builder msg = ChatHandler.OnChatPush.newBuilder();
/*  43 */     msg.setS2CPlayerId("");
/*  44 */     msg.setS2CUid("");
/*  45 */     msg.setS2CContent(StringUtil.isEmpty(content) ? "content is null" : content);
/*  46 */     msg.setS2CScope((scope != null) ? scope.getValue() : Const.CHAT_SCOPE.WORLD.getValue());
/*  47 */     msg.setS2CSys(Const.TipsType.BLACK.getValue());
/*  48 */     msg.setS2CTime(DateUtil.getDateTime());
/*  49 */     msg.setS2CServerData("{}");
/*     */     
/*  51 */     GWorld.getInstance().broadcast((Message)new MessagePush("chat.chatPush.onChatPush", (GeneratedMessage)msg.build()), logicServerId);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void sendSysChat(WNPlayer player, String content) {
/*  59 */     sendSysChat(player, content, Const.TipsType.NORMAL);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void sendSysChat(WNPlayer player, String content, Const.TipsType scroll) {
/*  66 */     sendChatMsgAsyn(player, content, Const.CHAT_SCOPE.SYSTEM, scroll);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void sendChatMsgAsyn(WNPlayer player, String content, Const.CHAT_SCOPE scope, Const.TipsType scroll) {
/*  73 */     GWorld.getInstance().ansycExec(() -> {
/*     */           ChatHandler.OnChatPush.Builder msg = createChatMsg(player, content, scope, scroll);
/*     */           player.receive("chat.chatPush.onChatPush", (GeneratedMessage)msg.build());
/*     */         });
/*     */   }
/*     */ 
/*     */   
/*     */   public static ChatHandler.OnChatPush.Builder createChatMsg(WNPlayer player, String content, Const.CHAT_SCOPE scope, Const.TipsType scroll) {
/*  81 */     ChatHandler.OnChatPush.Builder msg = ChatHandler.OnChatPush.newBuilder();
/*  82 */     Map<String, Object> serverData = new HashMap<>();
/*  83 */     serverData.put("acceptRoleId", "");
/*  84 */     serverData.put("s2c_level", Integer.valueOf(player.getLevel()));
/*  85 */     serverData.put("s2c_name", (player.getPlayer()).name);
/*  86 */     serverData.put("s2c_pro", Integer.valueOf(player.getPro()));
/*  87 */     serverData.put("s2c_vip", Integer.valueOf(0));
/*  88 */     serverData.put("s2c_zoneId", Integer.valueOf(player.getLogicServerId()));
/*     */     
/*  90 */     msg.setS2CPlayerId((player.getPlayer()).id);
/*     */     
/*  92 */     msg.setS2CUid((player.getPlayer()).uid);
/*  93 */     msg.setS2CContent(StringUtil.isEmpty(content) ? "content is null" : content);
/*  94 */     msg.setS2CScope(scope.getValue());
/*  95 */     msg.setS2CSys(scroll.getValue());
/*  96 */     msg.setS2CTime(DateUtil.getDateTime());
/*  97 */     msg.setS2CServerData(JSON.toJSONString(serverData));
/*  98 */     return msg;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static MessageData createMessage(int messageType, String createPlayerId, MessageData.MessageData_Data data) {
/* 107 */     return createMessage(messageType, createPlayerId, data, null);
/*     */   }
/*     */   
/*     */   public static MessageData createMessage(int messageType, String createPlayerId, MessageData.MessageData_Data data, Map<String, String> strMsg) {
/* 111 */     MessageData opts = new MessageData();
/* 112 */     opts.messageType = messageType;
/* 113 */     opts.createPlayerId = createPlayerId;
/* 114 */     opts.strMsg = strMsg;
/* 115 */     opts.data = data;
/* 116 */     opts.init();
/* 117 */     return opts;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getSendLimit(int messageType) {
/* 124 */     SocialMessageCO socialMessageProp = SocialMessageConfig.getInstance().findMessageByMessageType(messageType);
/* 125 */     int limit = 0;
/* 126 */     if (socialMessageProp != null) {
/* 127 */       limit = socialMessageProp.sendLimite;
/*     */     }
/* 129 */     return limit;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getReceiveLimit(int messageType) {
/* 136 */     SocialMessageCO socialMessageProp = SocialMessageConfig.getInstance().findMessageByMessageType(messageType);
/* 137 */     int limit = 0;
/* 138 */     if (socialMessageProp != null) {
/* 139 */       limit = socialMessageProp.receiveLimite;
/*     */     }
/* 141 */     return limit;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean sendMessageToPlayer(MessageData message, String playerId) {
/* 148 */     WNPlayer player = PlayerUtil.getOnlinePlayer(playerId);
/* 149 */     if (player != null) {
/* 150 */       return player.messageManager.addReceivedMessage(message);
/*     */     }
/* 152 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void deleteSendedPlayerMessage(MessageData message) {
/* 157 */     String playerId = message.createPlayerId;
/* 158 */     WNPlayer player = PlayerUtil.getOnlinePlayer(playerId);
/* 159 */     if (player != null)
/* 160 */       player.messageManager.deleteSendedMessage(message.messageType, message.id); 
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\common\msg\MessageUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */