/*     */ package com.wanniu.game.message;
/*     */ 
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.game.GWorld;
/*     */ import com.wanniu.game.data.SocialMessageCO;
/*     */ import com.wanniu.game.poes.MessagePO;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.atomic.AtomicLong;
/*     */ import pomelo.area.MessageHandler;
/*     */ 
/*     */ public class MessageData
/*     */ {
/*     */   public String id;
/*     */   public int messageType;
/*     */   public String createPlayerId;
/*     */   
/*     */   public static class MessageData_Data {}
/*     */   
/*     */   public static class MessageData_Team
/*     */     extends MessageData_Data
/*     */   {
/*     */     public String applyId;
/*     */     public String name;
/*     */     public String teamId;
/*     */   }
/*     */   
/*     */   public static class MessageData_DaoYou
/*     */     extends MessageData_Data
/*     */   {
/*     */     public String fromPlayerId;
/*     */     public String fromPlayerName;
/*     */   }
/*     */   
/*     */   public static class MessageData_Team_InviteId
/*     */     extends MessageData_Data
/*     */   {
/*     */     public String inviteId;
/*     */   }
/*     */   
/*     */   public static class MessageData_Team_apply
/*     */     extends MessageData_Data
/*     */   {
/*     */     public String teamId;
/*     */     public String applyId;
/*     */     public String name;
/*     */   }
/*     */   
/*     */   public static class MessageData_Quest
/*     */     extends MessageData_Data {
/*     */     public int finishCount;
/*     */   }
/*     */   
/*     */   public static class MessageData_Consignment
/*     */     extends MessageData_Data {
/*     */     public String id;
/*     */     public int num1;
/*     */     public int num2;
/*     */   }
/*  60 */   public Map<String, String> strMsg = new HashMap<>();
/*     */   
/*     */   public MessageData_Data data;
/*     */   public long validTime;
/*     */   public String strMsgToClient;
/*     */   public int HUDTime;
/*  66 */   private static final AtomicLong UUID = new AtomicLong(System.nanoTime());
/*     */   
/*     */   public MessageData() {
/*  69 */     this.id = String.valueOf(UUID.incrementAndGet());
/*     */   }
/*     */   
/*     */   public MessageData(MessagePO opts) {
/*  73 */     if (opts != null) {
/*  74 */       this.id = opts.id;
/*  75 */       this.messageType = opts.messageType;
/*  76 */       this.createPlayerId = opts.createPlayerId;
/*  77 */       this.strMsg = opts.strMsg;
/*  78 */       this.data = opts.data;
/*  79 */       init();
/*     */     } 
/*     */   }
/*     */   
/*     */   public final void init() {
/*  84 */     SocialMessageCO socialMessageProp = SocialMessageConfig.getInstance().findMessageByMessageType(this.messageType);
/*  85 */     if (socialMessageProp == null) {
/*  86 */       Out.error(new Object[] { "there is no prop in socialMessageProp messageType:" + this.messageType });
/*     */       return;
/*     */     } 
/*  89 */     this.validTime = -1L;
/*  90 */     this.strMsgToClient = socialMessageProp.messageText;
/*  91 */     if (this.strMsg != null) {
/*  92 */       for (Map.Entry<String, String> node : this.strMsg.entrySet()) {
/*  93 */         this.strMsgToClient = this.strMsgToClient.replace("{" + (String)node.getKey() + "}", node.getValue());
/*     */       }
/*     */     }
/*  96 */     this.validTime = System.currentTimeMillis() + (socialMessageProp.messageTime * 1000);
/*  97 */     this.HUDTime = socialMessageProp.hUDTime;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getMessageType() {
/* 104 */     return this.messageType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isPastDue() {
/* 111 */     if (this.validTime == -1L) {
/* 112 */       return false;
/*     */     }
/* 114 */     boolean isClearByNewDay = isClearByNewDay();
/* 115 */     if (isClearByNewDay) {
/* 116 */       return false;
/*     */     }
/* 118 */     return (GWorld.APP_TIME > this.validTime);
/*     */   }
/*     */   
/*     */   public final boolean isClearByNewDay() {
/* 122 */     return (this.validTime == 0L);
/*     */   }
/*     */   
/*     */   public final MessageHandler.Message toJson4PayLoad() {
/* 126 */     MessageHandler.Message.Builder build = MessageHandler.Message.newBuilder();
/* 127 */     build.setId(this.id);
/* 128 */     build.setMessageType(this.messageType);
/* 129 */     build.setRemainTime(this.HUDTime);
/* 130 */     build.setStrMsg((null != this.strMsgToClient) ? this.strMsgToClient : "");
/* 131 */     return build.build();
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\message\MessageData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */