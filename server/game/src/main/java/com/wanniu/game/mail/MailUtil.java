/*     */ package com.wanniu.game.mail;
/*     */ 
/*     */ import com.wanniu.core.db.GCache;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.data.GameData;
/*     */ import com.wanniu.game.data.MailSystemCO;
/*     */ import com.wanniu.game.item.ItemUtil;
/*     */ import com.wanniu.game.item.NormalItem;
/*     */ import com.wanniu.game.item.po.PlayerItemPO;
/*     */ import com.wanniu.game.mail.data.MailData;
/*     */ import com.wanniu.game.mail.data.MailGmData;
/*     */ import com.wanniu.game.mail.data.MailPlayerData;
/*     */ import com.wanniu.game.mail.data.MailSysData;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.UUID;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MailUtil
/*     */ {
/*     */   private static MailUtil instance;
/*     */   
/*     */   public static MailUtil getInstance() {
/*  30 */     if (instance == null) {
/*  31 */       instance = new MailUtil();
/*     */     }
/*  33 */     return instance;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean sendMail(WNPlayer player, WNMail mail) {
/*  44 */     Out.debug(new Object[] { "add a new mail1: ", mail });
/*  45 */     if (player == null) {
/*  46 */       return false;
/*     */     }
/*  48 */     MailCenter.getInstance().addMail(player.getId(), mail, true);
/*     */     
/*  50 */     return false;
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
/*     */   public MailSystemCO getMailSystemPropByKey(String key) {
/*  62 */     MailSystemCO mailProp = (MailSystemCO)GameData.MailSystems.get(key);
/*  63 */     return mailProp;
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
/*     */   public String replacString(String resource, Map<String, String> replaceObject) {
/*  75 */     if (replaceObject == null) {
/*  76 */       return resource;
/*     */     }
/*  78 */     String result = resource;
/*  79 */     for (Map.Entry<String, String> node : replaceObject.entrySet()) {
/*  80 */       String replaceKey = "{" + (String)node.getKey() + "}";
/*  81 */       result = result.replace(replaceKey, node.getValue());
/*     */     } 
/*  83 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public WNMail createMail(MailData mailData, String playerId, Const.GOODS_CHANGE_TYPE origin) {
/*  90 */     if (mailData.mailType < 0) {
/*  91 */       return null;
/*     */     }
/*  93 */     WNMail newMail = new WNMail();
/*  94 */     newMail.id = UUID.randomUUID().toString();
/*  95 */     newMail.origin = origin.value;
/*  96 */     newMail.playerId = playerId;
/*  97 */     newMail.status = Const.MailState.MAIL_STATE_NULL.getValue();
/*  98 */     newMail.createTime = (mailData.createTime != null) ? mailData.createTime : new Date();
/*  99 */     newMail.attachment = new ArrayList<>();
/* 100 */     newMail.orderId = (mailData.orderId != null) ? mailData.orderId : "";
/* 101 */     if (mailData.mailType == Const.MailType.MAIL_PLAYER_TYPE.getValue()) {
/* 102 */       MailPlayerData playerData = (MailPlayerData)mailData;
/* 103 */       if (playerData.mailSender == null || playerData.mailSenderId == null || playerData.mailTitle == null || playerData.mailIcon <= 0 || playerData.mailRead <= 0 || playerData.mailText == null) {
/* 104 */         Out.error(new Object[] { "createMail playerData param error " });
/* 105 */         return null;
/*     */       } 
/* 107 */       newMail.mailType = playerData.mailType;
/* 108 */       newMail.mailSender = playerData.mailSender;
/* 109 */       newMail.mailSenderId = playerData.mailSenderId;
/* 110 */       newMail.mailTitle = playerData.mailTitle;
/* 111 */       newMail.mailText = playerData.mailText;
/* 112 */       newMail.mailRead = playerData.mailRead;
/* 113 */       newMail.mailIcon = playerData.mailIcon;
/*     */     }
/* 115 */     else if (mailData.mailType == Const.MailType.MAIL_SYSTEM_TYPE.getValue()) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 121 */       MailSysData sysData = (MailSysData)mailData;
/*     */ 
/*     */       
/* 124 */       MailSystemCO mailProp = getMailSystemPropByKey(sysData.key);
/* 125 */       if (mailProp == null) {
/* 126 */         Out.error(new Object[] { "createMail mailKey error : " + sysData.key });
/* 127 */         return null;
/*     */       } 
/* 129 */       newMail.mailType = mailProp.mailType;
/* 130 */       newMail.mailSender = mailProp.mailSender;
/* 131 */       newMail.mailSenderId = "";
/* 132 */       newMail.mailTitle = mailProp.mailTitle;
/* 133 */       newMail.mailText = replacString(mailProp.mailText, sysData.replace);
/* 134 */       newMail.mailRead = mailProp.mailRead;
/* 135 */       newMail.mailIcon = 0;
/* 136 */       newMail.mailSubType = sysData.key;
/* 137 */     } else if (mailData.mailType == Const.MailType.MAIL_GM_TYPE.getValue()) {
/* 138 */       MailGmData gmMail = (MailGmData)mailData;
/* 139 */       newMail.mailType = gmMail.mailType;
/* 140 */       newMail.mailSender = gmMail.mailSender;
/* 141 */       newMail.mailSenderId = "";
/* 142 */       newMail.mailTitle = gmMail.mailTitle;
/* 143 */       newMail.mailText = gmMail.mailText;
/* 144 */       newMail.mailRead = Const.MailReadDeal.MAIL_READ_NULL.getValue();
/* 145 */       newMail.mailIcon = 0;
/*     */     } 
/*     */ 
/*     */     
/* 149 */     if (mailData.attachments != null)
/*     */     {
/* 151 */       for (MailData.Attachment attach : mailData.attachments) {
/* 152 */         List<NormalItem> items = ItemUtil.createItemsByItemCode(attach.itemCode, attach.itemNum);
/* 153 */         for (NormalItem item : items) {
/*     */           
/* 155 */           if (attach.isBind == Const.ForceType.BIND.getValue()) {
/* 156 */             item.setBind(Const.BindType.BIND.getValue());
/*     */           }
/*     */           
/* 159 */           if (attach.isBind == Const.ForceType.UN_BIND.getValue()) {
/* 160 */             item.setBind(Const.BindType.UN_BIND.getValue());
/*     */           }
/*     */           
/* 163 */           newMail.addAttach(item.itemDb);
/*     */         } 
/*     */       } 
/*     */     }
/* 167 */     if (mailData.tcCode != null) {
/*     */       
/* 169 */       List<NormalItem> items = ItemUtil.createItemsByTcCode(mailData.tcCode);
/* 170 */       for (NormalItem item : items) {
/* 171 */         newMail.addAttach(item.itemDb);
/*     */       }
/*     */     } 
/* 174 */     if (mailData.entityItems != null)
/*     */     {
/* 176 */       for (int i = 0; i < mailData.entityItems.size(); i++) {
/* 177 */         PlayerItemPO itemData = mailData.entityItems.get(i);
/* 178 */         NormalItem item = ItemUtil.createItemByDbOpts(itemData);
/* 179 */         if (item == null) {
/* 180 */           Out.error(new Object[] { "createMail createItemByDbOpts error:", itemData });
/* 181 */           return null;
/*     */         } 
/* 183 */         newMail.addAttach(item.itemDb);
/*     */       } 
/*     */     }
/*     */     
/* 187 */     if (newMail.attachment != null && newMail.attachment.size() > 0) {
/* 188 */       newMail.hadAttach = Const.MailAttach.MAIL_ATTACH_CARRY.getValue();
/*     */     } else {
/* 190 */       newMail.hadAttach = Const.MailAttach.MAIL_ATTACH_NULL.getValue();
/*     */     } 
/* 192 */     GCache.push("sendMails", newMail.toString());
/* 193 */     return newMail;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean sendMailToOnePlayer(String playerId, MailData mailData, Const.GOODS_CHANGE_TYPE origin) {
/* 201 */     String[] playerIds = { playerId };
/* 202 */     return sendMailToSomePlayer(playerIds, mailData, origin);
/*     */   }
/*     */   
/*     */   public boolean sendMailToSomePlayer(String[] playerIds, MailData mailData, Const.GOODS_CHANGE_TYPE origin) {
/* 206 */     for (int i = 0; i < playerIds.length; i++) {
/* 207 */       String playerId = playerIds[i];
/* 208 */       WNMail mail = createMail(mailData, playerId, origin);
/* 209 */       MailCenter.getInstance().addMail(playerId, mail, true);
/*     */     } 
/* 211 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\mail\MailUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */