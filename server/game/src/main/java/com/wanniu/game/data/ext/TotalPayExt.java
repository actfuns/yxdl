/*    */ package com.wanniu.game.data.ext;
/*    */ 
/*    */ import com.wanniu.game.data.TotalPayCO;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ 
/*    */ public class TotalPayExt
/*    */   extends TotalPayCO
/*    */ {
/*    */   public ArrayList<DailyPayExt.AwardInfo> awards;
/*    */   
/*    */   public void initProperty() {
/* 13 */     this.awards = new ArrayList<>();
/* 14 */     if (this.rewardCode1 != null && this.rewardNum1 != 0) {
/* 15 */       DailyPayExt.AwardInfo awardInfo = new DailyPayExt.AwardInfo();
/* 16 */       awardInfo.itemCode = this.rewardCode1;
/* 17 */       awardInfo.itemNum = this.rewardNum1;
/* 18 */       this.awards.add(awardInfo);
/*    */     } 
/* 20 */     if (this.rewardCode2 != null && this.rewardNum2 != 0) {
/* 21 */       DailyPayExt.AwardInfo awardInfo = new DailyPayExt.AwardInfo();
/* 22 */       awardInfo.itemCode = this.rewardCode2;
/* 23 */       awardInfo.itemNum = this.rewardNum2;
/* 24 */       this.awards.add(awardInfo);
/*    */     } 
/* 26 */     if (this.rewardCode3 != null && this.rewardNum3 != 0) {
/* 27 */       DailyPayExt.AwardInfo awardInfo = new DailyPayExt.AwardInfo();
/* 28 */       awardInfo.itemCode = this.rewardCode3;
/* 29 */       awardInfo.itemNum = this.rewardNum3;
/* 30 */       this.awards.add(awardInfo);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\data\ext\TotalPayExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */