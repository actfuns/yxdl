/*    */ package com.wanniu.login.po;
/*    */ 
/*    */ import java.util.UUID;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AnnouncementPO
/*    */ {
/* 12 */   public String id = UUID.randomUUID().toString();
/*    */   
/*    */   public String name;
/*    */   
/*    */   public String orgContent;
/*    */   
/*    */   public String content;
/*    */   public boolean isUse;
/*    */   
/*    */   public AnnouncementPO() {}
/*    */   
/*    */   public AnnouncementPO(String name, String orgContent, String content, boolean isUse) {
/* 24 */     this.name = name;
/* 25 */     this.orgContent = orgContent;
/* 26 */     this.content = content;
/* 27 */     this.isUse = isUse;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-login\xmds-login.jar!\com\wanniu\login\po\AnnouncementPO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */