/*    */ package com.wanniu.game.mail;
/*    */ 
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.game.data.GameData;
/*    */ import com.wanniu.game.data.MailOperateCO;
/*    */ import java.util.Map;
/*    */ 
/*    */ public class MailConfig
/*    */ {
/*    */   private static MailConfig instance;
/*    */   private Map<Integer, MailOperateCO> opreateMailTable;
/*    */   
/*    */   public static MailConfig getInstance() {
/* 14 */     if (instance == null) {
/* 15 */       instance = new MailConfig();
/*    */     }
/* 17 */     return instance;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private MailConfig() {
/* 26 */     this.opreateMailTable = GameData.MailOperates;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final MailOperateCO findDOperateMailByMailId(int mailId) {
/* 38 */     if (this.opreateMailTable.containsKey(Integer.valueOf(mailId))) {
/* 39 */       return this.opreateMailTable.get(Integer.valueOf(mailId));
/*    */     }
/* 41 */     Out.error(new Object[] { getClass().getName(), " : Can`t find MailOperate By mailId = ", Integer.valueOf(mailId) });
/* 42 */     return null;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\mail\MailConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */