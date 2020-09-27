/*    */ package com.wanniu.game.mail.po;
/*    */ 
/*    */ import com.wanniu.game.mail.data.MailData;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public class OfflineMailDB
/*    */ {
/*    */   public String id;
/*    */   public int logicServerId;
/*    */   public Date modifyTime;
/*    */   public Date oldestTime;
/* 14 */   public List<MailData> mails = new ArrayList<>();
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\mail\po\OfflineMailDB.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */