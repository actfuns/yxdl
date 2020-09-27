/*    */ package com.wanniu.gm.handler;
/*    */ 
/*    */ import com.alibaba.fastjson.JSONArray;
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.core.util.DateUtil;
/*    */ import com.wanniu.core.util.StringUtil;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.mail.MailCenter;
/*    */ import com.wanniu.game.mail.MailUtil;
/*    */ import com.wanniu.game.mail.data.MailData;
/*    */ import com.wanniu.game.mail.data.MailGmData;
/*    */ import com.wanniu.game.player.PlayerDao;
/*    */ import com.wanniu.game.player.PlayerUtil;
/*    */ import com.wanniu.gm.GMEvent;
/*    */ import com.wanniu.gm.GMResponse;
/*    */ import com.wanniu.gm.GMStateResponse;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GMEvent
/*    */ public class MailHandler
/*    */   extends GMBaseHandler
/*    */ {
/*    */   public GMResponse execute(JSONArray arr) {
/* 33 */     int type = arr.getIntValue(0);
/* 34 */     String rids = arr.getString(1);
/* 35 */     String title = arr.getString(2);
/* 36 */     String content = arr.getString(3);
/* 37 */     String sender = arr.getString(4);
/* 38 */     String createRoleDate = arr.getString(5);
/* 39 */     String minLevel = arr.getString(6);
/* 40 */     String atta = arr.getString(7);
/* 41 */     String mailId = null;
/* 42 */     if (type == 1) {
/* 43 */       mailId = arr.getString(8);
/*    */     }
/*    */     
/* 46 */     ArrayList<MailData.Attachment> list = new ArrayList<>();
/* 47 */     if (StringUtil.isNotEmpty(atta)) {
/* 48 */       for (String its : atta.split(";")) {
/* 49 */         MailData.Attachment attachment = new MailData.Attachment();
/* 50 */         attachment.itemCode = its.split(":")[0];
/* 51 */         attachment.itemNum = Integer.parseInt(its.split(":")[1]);
/*    */         
/* 53 */         attachment.isBind = Const.ForceType.BIND.getValue();
/* 54 */         list.add(attachment);
/*    */       } 
/*    */     }
/* 57 */     MailGmData mail = new MailGmData();
/* 58 */     mail.mailSender = sender;
/* 59 */     mail.mailTitle = title;
/* 60 */     mail.mailText = content;
/* 61 */     if (StringUtil.isNotEmpty(minLevel)) {
/* 62 */       mail.minLevel = Integer.parseInt(minLevel);
/*    */     }
/* 64 */     mail.attachments = list;
/*    */     
/* 66 */     if (type == 0) {
/* 67 */       String[] ids = rids.split(";");
/* 68 */       for (int i = 0; i < ids.length; i++) {
/* 69 */         String id = ids[i];
/* 70 */         if (PlayerUtil.getPlayerBaseData(id) == null) {
/*    */           
/* 72 */           String rid = PlayerDao.getIdByName(id);
/* 73 */           if (rid == null) {
/* 74 */             return (GMResponse)new GMStateResponse(-2);
/*    */           }
/* 76 */           ids[i] = rid;
/*    */         } 
/*    */       } 
/* 79 */       MailUtil.getInstance().sendMailToSomePlayer(ids, (MailData)mail, Const.GOODS_CHANGE_TYPE.GMT);
/*    */     } else {
/*    */       
/* 82 */       if (StringUtil.isNotEmpty(createRoleDate)) {
/* 83 */         mail.createRoleDate = DateUtil.format(createRoleDate);
/*    */       }
/* 85 */       MailCenter.getInstance().addServerMail(mailId, mail, Const.GOODS_CHANGE_TYPE.GMT);
/*    */     } 
/* 87 */     Out.info(new Object[] { "GM邮件记录 json=", arr.toJSONString() });
/* 88 */     return (GMResponse)new GMStateResponse(1);
/*    */   }
/*    */   
/*    */   public short getType() {
/* 92 */     return 4577;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\gm\handler\MailHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */