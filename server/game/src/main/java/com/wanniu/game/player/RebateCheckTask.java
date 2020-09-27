/*    */ package com.wanniu.game.player;
/*    */ 
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.item.VirtualItemType;
/*    */ import com.wanniu.game.mail.MailUtil;
/*    */ import com.wanniu.game.mail.data.MailData;
/*    */ import com.wanniu.game.mail.data.MailSysData;
/*    */ import com.wanniu.redis.GlobalDao;
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import org.apache.commons.lang3.StringUtils;
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
/*    */ 
/*    */ 
/*    */ public class RebateCheckTask
/*    */   implements Runnable
/*    */ {
/* 38 */   private static int rate = 20;
/*    */   
/*    */   private final String uid;
/*    */   private final String palyerId;
/*    */   private final String palyerName;
/*    */   
/*    */   public RebateCheckTask(WNPlayer player) {
/* 45 */     this.uid = player.getUid();
/* 46 */     this.palyerId = player.getId();
/* 47 */     this.palyerName = player.getName();
/*    */   }
/*    */ 
/*    */   
/*    */   public void run() {
/*    */     try {
/* 53 */       String value = GlobalDao.hget("rebate", this.uid);
/* 54 */       if (StringUtils.isNotEmpty(value) && 
/* 55 */         GlobalDao.hremove("rebate", this.uid) > 0L) {
/* 56 */         int diamond = Integer.parseInt(value) / 100 * rate;
/* 57 */         Out.info(new Object[] { "充值返利.uid=", this.uid, ",playerId=", this.palyerId, ",name=", this.palyerName, ",rmb=", value, " 分, diamond=", Integer.valueOf(diamond) });
/*    */         
/* 59 */         MailSysData mail = new MailSysData("CCBReward1");
/* 60 */         mail.attachments = new ArrayList();
/*    */ 
/*    */         
/* 63 */         MailData.Attachment att = new MailData.Attachment();
/* 64 */         att.itemCode = VirtualItemType.DIAMOND.getItemcode();
/* 65 */         att.itemNum = diamond;
/* 66 */         mail.attachments.add(att);
/*    */         
/* 68 */         mail.replace = new HashMap<>();
/* 69 */         MailUtil.getInstance().sendMailToOnePlayer(this.palyerId, (MailData)mail, Const.GOODS_CHANGE_TYPE.PAY_REBATE);
/*    */       }
/*    */     
/* 72 */     } catch (Exception e) {
/* 73 */       Out.info(new Object[] { "充值返利异常.uid=", this.uid, ",playerId=", this.palyerId, ",name=", this.palyerName, e });
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\player\RebateCheckTask.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */