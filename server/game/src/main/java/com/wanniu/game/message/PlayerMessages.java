/*     */ package com.wanniu.game.message;
/*     */ 
/*     */ import com.google.protobuf.GeneratedMessage;
/*     */ import com.wanniu.core.game.LangService;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.msg.MessageUtil;
/*     */ import com.wanniu.game.player.PlayerUtil;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.sysSet.SysSetFlag;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import pomelo.area.MessageHandler;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PlayerMessages
/*     */ {
/*     */   private WNPlayer player;
/*     */   public Map<Integer, Map<String, MessageData>> sendedMessages;
/*     */   public Map<Integer, Map<String, MessageData>> receivedMessages;
/*     */   
/*     */   public PlayerMessages(WNPlayer player) {
/*  25 */     this.player = player;
/*  26 */     this.sendedMessages = new ConcurrentHashMap<>();
/*  27 */     this.receivedMessages = new ConcurrentHashMap<>();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final MessageData getReceivedMessage(int type, String messageId) {
/*  34 */     Map<String, MessageData> messages = this.receivedMessages.get(Integer.valueOf(type));
/*  35 */     if (messages != null) {
/*  36 */       MessageData message = messages.get(messageId);
/*  37 */       if (message != null && !message.isPastDue()) {
/*  38 */         return message;
/*     */       }
/*  40 */       return null;
/*     */     } 
/*     */     
/*  43 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean addSendedMessage(MessageData message) {
/*  48 */     if (message != null && !message.isPastDue()) {
/*  49 */       int count = clearPastDueMessages(false, message.messageType);
/*     */       
/*  51 */       int sendLimit = MessageUtil.getSendLimit(message.getMessageType());
/*  52 */       if (sendLimit > 0 && count >= sendLimit) {
/*  53 */         return false;
/*     */       }
/*     */       
/*  56 */       Map<String, MessageData> messages = this.sendedMessages.get(Integer.valueOf(message.messageType));
/*  57 */       if (messages == null) {
/*  58 */         messages = new ConcurrentHashMap<>();
/*  59 */         this.sendedMessages.put(Integer.valueOf(message.messageType), messages);
/*     */       } 
/*  61 */       messages.put(message.id, message);
/*     */     } 
/*  63 */     return true;
/*     */   }
/*     */   
/*     */   public final int getSendedMessageLengthByType(int type) {
/*  67 */     Map<String, MessageData> messages = getSendedMessageByType(type);
/*  68 */     int count = 0;
/*  69 */     if (messages != null) {
/*  70 */       count += messages.size();
/*     */     }
/*  72 */     return count;
/*     */   }
/*     */   
/*     */   public final Map<String, MessageData> getSendedMessageByType(int type) {
/*  76 */     clearPastDueMessages(false, type);
/*  77 */     Map<String, MessageData> messages = this.sendedMessages.get(Integer.valueOf(type));
/*  78 */     if (messages != null) {
/*  79 */       return messages;
/*     */     }
/*  81 */     return new ConcurrentHashMap<>();
/*     */   }
/*     */   
/*     */   public final boolean addReceivedMessage(MessageData message) {
/*  85 */     if (message != null && !message.isPastDue()) {
/*  86 */       Out.debug(new Object[] { "message data:", message });
/*  87 */       if (message.messageType == Const.MESSAGE_TYPE.team_invite.getValue() && !this.player.sysSetManager.isPermission(SysSetFlag.teamInviteSet))
/*  88 */       { String msg = LangService.format("TEAM_REFUSE", new Object[] { this.player.getName() });
/*  89 */         PlayerUtil.sendSysMessageToPlayer(msg, message.createPlayerId, null);
/*  90 */         MessageUtil.deleteSendedPlayerMessage(message); }
/*  91 */       else { if ((message.messageType == Const.MESSAGE_TYPE.team_invite.getValue() && this.player.getTeamManager().isAcceptAutoTeam()) || (message.messageType == Const.MESSAGE_TYPE.team_apply.getValue() && this.player.getTeamManager().isAutoTeam())) {
/*  92 */           return this.player.getTeamManager().onMessage(message.messageType, Const.MESSAGE_OPERATE.TYPE_ACCEPT.getValue(), message.id);
/*     */         }
/*  94 */         int count = clearPastDueMessages(true, message.messageType);
/*  95 */         if (count < Const.MESSAGE.MAX_COUNT.getValue()) {
/*  96 */           if (message.messageType != Const.MESSAGE_TYPE.team_invite.getValue() && message.messageType != Const.MESSAGE_TYPE.team_invite.getValue()) {
/*  97 */             Map<String, MessageData> messages = this.receivedMessages.get(Integer.valueOf(message.messageType));
/*  98 */             if (messages == null) {
/*  99 */               messages = new ConcurrentHashMap<>();
/* 100 */               this.receivedMessages.put(Integer.valueOf(message.messageType), messages);
/*     */             } 
/* 102 */             messages.put(message.id, message);
/*     */           } 
/* 104 */           MessageHandler.OnMessageAddPush.Builder builder = MessageHandler.OnMessageAddPush.newBuilder();
/* 105 */           builder.setS2CCode(200);
/* 106 */           builder.setS2CData(message.toJson4PayLoad());
/* 107 */           this.player.receive("area.messagePush.onMessageAddPush", (GeneratedMessage)builder.build());
/* 108 */           return true;
/*     */         }  }
/*     */     
/*     */     } 
/* 112 */     return false;
/*     */   }
/*     */   
/*     */   public final void deleteReceivedMessage(int type, String id) {
/* 116 */     Map<String, MessageData> messages = this.receivedMessages.get(Integer.valueOf(type));
/* 117 */     if (messages != null) {
/* 118 */       messages.remove(id);
/* 119 */       this.receivedMessages.put(Integer.valueOf(type), messages);
/*     */     } 
/*     */   }
/*     */   
/*     */   public final void deleteSendedMessage(int type, String id) {
/* 124 */     Map<String, MessageData> messages = this.sendedMessages.get(Integer.valueOf(type));
/* 125 */     if (messages != null) {
/* 126 */       messages.remove(id);
/* 127 */       this.sendedMessages.put(Integer.valueOf(type), messages);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int clearPastDueMessages(boolean isReceived, int type) {
/* 135 */     Map<Integer, Map<String, MessageData>> messageAll = isReceived ? this.receivedMessages : this.sendedMessages;
/* 136 */     if (messageAll == null) {
/* 137 */       return 0;
/*     */     }
/* 139 */     Map<String, MessageData> messages = messageAll.get(Integer.valueOf(type));
/* 140 */     int count = 0;
/* 141 */     if (messages != null) {
/* 142 */       for (Map.Entry<String, MessageData> node : messages.entrySet()) {
/* 143 */         MessageData message = node.getValue();
/* 144 */         if (message.isPastDue()) {
/* 145 */           messages.remove(node.getKey()); continue;
/*     */         } 
/* 147 */         count++;
/*     */       } 
/*     */     }
/*     */     
/* 151 */     return count;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void refreshNewDay() {
/* 158 */     _clearNewDayPastDueMessages(true);
/* 159 */     _clearNewDayPastDueMessages(false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void _clearNewDayPastDueMessages(boolean isReceived) {
/* 166 */     Map<Integer, Map<String, MessageData>> messageAll = isReceived ? this.receivedMessages : this.sendedMessages;
/* 167 */     if (messageAll == null)
/*     */       return; 
/* 169 */     for (Map.Entry<Integer, Map<String, MessageData>> node : messageAll.entrySet()) {
/* 170 */       Map<String, MessageData> messages = node.getValue();
/* 171 */       for (Map.Entry<String, MessageData> message : messages.entrySet()) {
/* 172 */         if (((MessageData)message.getValue()).isClearByNewDay()) {
/* 173 */           messages.remove(message.getKey());
/*     */         }
/*     */       } 
/* 176 */       messageAll.put(node.getKey(), messages);
/*     */     } 
/* 178 */     if (isReceived) {
/* 179 */       this.receivedMessages = messageAll;
/*     */     } else {
/* 181 */       this.sendedMessages = messageAll;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\message\PlayerMessages.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */