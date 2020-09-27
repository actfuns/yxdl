/*    */ package com.wanniu.game.guild.guidDepot;
/*    */ 
/*    */ import com.wanniu.game.guild.ItemRecordInfo;
/*    */ import com.wanniu.game.guild.RoleInfo;
/*    */ import com.wanniu.game.poes.GuildMemberPO;
/*    */ import java.util.Date;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GuildRecordData
/*    */ {
/*    */   public int type;
/*    */   
/*    */   public static class GuildRecordResult
/*    */   {
/*    */     public int v1;
/*    */     public String v2;
/*    */     
/*    */     public GuildRecordResult() {
/* 23 */       this.v2 = "";
/*    */     }
/*    */     
/*    */     public GuildRecordResult(int v1, String v2) {
/* 27 */       this.v1 = v1;
/* 28 */       if (null != v2) {
/* 29 */         this.v2 = v2;
/*    */       } else {
/* 31 */         this.v2 = "";
/*    */       } 
/*    */     }
/*    */   }
/*    */ 
/*    */   
/* 37 */   public RoleInfo role1 = new RoleInfo();
/* 38 */   public RoleInfo role2 = new RoleInfo();
/* 39 */   public ItemRecordInfo item = new ItemRecordInfo();
/* 40 */   public GuildRecordResult result = new GuildRecordResult();
/* 41 */   public Date time = new Date();
/*    */   public String build;
/*    */   
/*    */   public GuildRecordData(int type, GuildMemberPO role1, GuildMemberPO role2) {
/* 45 */     this();
/* 46 */     this.type = type;
/* 47 */     if (null != role1) {
/* 48 */       this.role1.pro = role1.pro;
/* 49 */       this.role1.name = role1.name;
/*    */     } 
/*    */     
/* 52 */     if (null != role2) {
/* 53 */       this.role2.pro = role2.pro;
/* 54 */       this.role2.name = role2.name;
/*    */     } 
/*    */   }
/*    */   public GuildRecordData() {}
/*    */   public GuildRecordData(int type, GuildMemberPO role1, GuildMemberPO role2, GuildRecordResult result) {
/* 59 */     this();
/* 60 */     this.type = type;
/* 61 */     if (null != role1) {
/* 62 */       this.role1.pro = role1.pro;
/* 63 */       this.role1.name = role1.name;
/*    */     } 
/*    */     
/* 66 */     if (null != role2) {
/* 67 */       this.role2.pro = role2.pro;
/* 68 */       this.role2.name = role2.name;
/*    */     } 
/*    */     
/* 71 */     if (null != result)
/* 72 */       this.result = result; 
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\guild\guidDepot\GuildRecordData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */