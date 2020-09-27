/*    */ package com.wanniu.game.poes;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CdksUsePO
/*    */ {
/* 15 */   public List<CdkUse> listCdk = new ArrayList<>();
/*    */ 
/*    */ 
/*    */   
/*    */   public static class CdkUse
/*    */   {
/*    */     public String cdk;
/*    */ 
/*    */     
/*    */     public Date useDate;
/*    */     
/*    */     public int channel;
/*    */ 
/*    */     
/*    */     public CdkUse() {}
/*    */ 
/*    */     
/*    */     public CdkUse(String cdk, Date useDate, int channel) {
/* 33 */       this.cdk = cdk;
/* 34 */       this.useDate = useDate;
/* 35 */       this.channel = channel;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\poes\CdksUsePO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */