/*     */ package com.wanniu.game.mail;
/*     */ 
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.Utils;
/*     */ import com.wanniu.game.data.base.DItemEquipBase;
/*     */ import com.wanniu.game.item.ItemConfig;
/*     */ import com.wanniu.game.item.ItemUtil;
/*     */ import com.wanniu.game.item.po.PlayerItemPO;
/*     */ import com.wanniu.game.player.GlobalConfig;
/*     */ import com.wanniu.game.poes.PlayerBasePO;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import pomelo.area.MailHandler;
/*     */ import pomelo.item.ItemOuterClass;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WNMail
/*     */ {
/*     */   public String id;
/*     */   public String playerId;
/*     */   public Date createTime;
/*     */   public List<PlayerItemPO> attachment;
/*     */   public String orderId;
/*     */   public String mailSender;
/*     */   public String mailSenderId;
/*     */   public String mailTitle;
/*     */   public String mailText;
/*     */   public int mailRead;
/*     */   public int mailIcon;
/*     */   public int mailId;
/*     */   public int mailType;
/*     */   public String mailSubType;
/*     */   public int hadAttach;
/*     */   public int status;
/*     */   public int origin;
/*     */   
/*     */   public String toString() {
/*  40 */     return "WNMail{id='" + this.id + '\'' + ", playerId='" + this.playerId + '\'' + ", createTime=" + this.createTime + ", attachment=" + this.attachment + ", orderId='" + this.orderId + '\'' + ", mailSender='" + this.mailSender + '\'' + ", mailSenderId='" + this.mailSenderId + '\'' + ", mailTitle='" + this.mailTitle + '\'' + ", mailText='" + this.mailText + '\'' + ", mailRead=" + this.mailRead + ", mailIcon=" + this.mailIcon + ", mailId=" + this.mailId + ", mailType=" + this.mailType + ", mailSubType='" + this.mailSubType + '\'' + ", hadAttach=" + this.hadAttach + ", status=" + this.status + ", origin=" + this.origin + '}';
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
/*     */   public int compareTo(WNMail mail) {
/*  67 */     int flag = 0;
/*  68 */     if (this.attachment != null && this.attachment.size() > 0) {
/*  69 */       if (mail.attachment == null || mail.attachment.size() < 1) {
/*  70 */         return -1;
/*     */       }
/*     */     }
/*  73 */     else if (mail.attachment != null && mail.attachment.size() > 0) {
/*  74 */       return 1;
/*     */     } 
/*     */ 
/*     */     
/*  78 */     if (this.status != mail.status) {
/*  79 */       return this.status - mail.status;
/*     */     }
/*     */     
/*  82 */     if (this.createTime.after(mail.createTime))
/*  83 */       return -1; 
/*  84 */     if (this.createTime.before(mail.createTime))
/*  85 */       return 1; 
/*  86 */     return flag;
/*     */   }
/*     */ 
/*     */   
/*     */   public MailHandler.Mail.Builder toMailBuilder(PlayerBasePO basePO) {
/*  91 */     MailHandler.Mail.Builder builder = MailHandler.Mail.newBuilder();
/*  92 */     builder.setId(this.id);
/*  93 */     builder.setMailId(0);
/*  94 */     builder.setMailType(this.mailType);
/*  95 */     builder.setMailIcon(this.mailIcon);
/*  96 */     builder.setMailSender(this.mailSender);
/*  97 */     builder.setMailSenderId(this.mailSenderId);
/*  98 */     builder.setMailTitle(this.mailTitle);
/*  99 */     builder.setMailText(this.mailText);
/* 100 */     String time = String.valueOf(this.createTime.getTime());
/* 101 */     builder.setCreateTime(time);
/* 102 */     builder.setStatus(this.status);
/* 103 */     builder.setMailRead(this.mailRead);
/* 104 */     builder.setHadAttach(this.hadAttach);
/* 105 */     if (this.hadAttach == Const.MailAttach.MAIL_ATTACH_CARRY.getValue())
/*     */     {
/* 107 */       for (PlayerItemPO att : this.attachment) {
/*     */         
/* 109 */         int groupCount = att.groupCount;
/* 110 */         DItemEquipBase prop = ItemConfig.getInstance().getItemProp(att.code);
/* 111 */         if (ItemConfig.getInstance().getSecondType(prop.type) == Const.ItemSecondType.virtual.getValue() && 
/* 112 */           att.speData != null) {
/* 113 */           groupCount = att.speData.worth;
/*     */         }
/*     */         
/* 116 */         ItemOuterClass.MiniItem item = ItemUtil.getMiniItemData(att.code, groupCount, Const.ForceType.getE(att.isBind)).build();
/* 117 */         builder.addAttachment(item);
/*     */ 
/*     */ 
/*     */         
/* 121 */         builder.addNewAttachment(ItemUtil.createItemByDbOpts(att).getItemDetail(basePO));
/*     */       } 
/*     */     }
/* 124 */     return builder;
/*     */   }
/*     */   
/*     */   public void addAttach(PlayerItemPO item) {
/* 128 */     if (this.attachment.size() <= GlobalConfig.Mail_Attach_Size) {
/* 129 */       this.attachment.add(item);
/*     */     } else {
/* 131 */       Out.warn(new Object[] { "mail attach too many:", Utils.serialize(item) });
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\mail\WNMail.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */