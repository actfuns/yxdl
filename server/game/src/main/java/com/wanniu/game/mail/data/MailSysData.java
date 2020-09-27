/*    */ package com.wanniu.game.mail.data;
/*    */ 
/*    */ import com.wanniu.game.common.Const;
/*    */ import java.util.Map;
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
/*    */ public class MailSysData
/*    */   extends MailData
/*    */ {
/*    */   public Map<String, String> replace;
/*    */   public String key;
/*    */   
/*    */   public MailSysData(String key) {
/* 34 */     this.key = key;
/* 35 */     this.mailType = Const.MailType.MAIL_SYSTEM_TYPE.getValue();
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\mail\data\MailSysData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */