/*    */ package com.wanniu.game.data.ext;
/*    */ 
/*    */ import com.wanniu.core.util.StringUtil;
/*    */ import com.wanniu.game.data.PayRewardCO;
/*    */ import com.wanniu.game.mail.data.MailData;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PayRewardExt
/*    */   extends PayRewardCO
/*    */ {
/*    */   public RefreshTime RefreshTime;
/*    */   public ArrayList<MailData.Attachment> RankReward;
/*    */   
/*    */   public void initProperty() {
/* 17 */     this.RankReward = new ArrayList<>();
/*    */     
/* 19 */     if (StringUtil.isNotEmpty(this.payReward)) {
/* 20 */       String[] rewards = this.payReward.split(";");
/* 21 */       for (int i = 0; i < rewards.length; i++) {
/* 22 */         String[] rw = rewards[i].split(":");
/* 23 */         if (rw.length == 2) {
/* 24 */           MailData.Attachment item = new MailData.Attachment();
/* 25 */           item.itemCode = rw[0];
/* 26 */           item.itemNum = Integer.parseInt(rw[1]);
/* 27 */           this.RankReward.add(item);
/*    */         } 
/*    */       } 
/*    */     } 
/*    */     
/* 32 */     if (StringUtil.isNotEmpty(this.payRefreshDay)) {
/* 33 */       String[] day = this.payRefreshDay.split("-");
/* 34 */       if (day.length == 2) {
/* 35 */         this.RefreshTime = new RefreshTime();
/* 36 */         this.RefreshTime.Year = Integer.parseInt(day[0]);
/* 37 */         this.RefreshTime.Month = Integer.parseInt(day[1]);
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   public static class RefreshTime {
/*    */     public int Year;
/*    */     public int Month;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\data\ext\PayRewardExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */