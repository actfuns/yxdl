/*    */ package com.wanniu.game.data.ext;
/*    */ 
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.data.FirstPayCO;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ 
/*    */ public class FirstPayExt
/*    */   extends FirstPayCO
/*    */ {
/*    */   public int Job;
/*    */   public ArrayList<DailyPayExt.AwardInfo> awards;
/*    */   
/*    */   public void initProperty() {
/* 15 */     this.Job = Const.PlayerPro.Value(this.job);
/* 16 */     this.awards = new ArrayList<>();
/* 17 */     if (this.weaponCode != null) {
/* 18 */       this.awards.add(new DailyPayExt.AwardInfo(this.weaponCode, 1, 0));
/*    */     }
/* 20 */     if (this.rewardCode1 != null && this.rewardNum1 != 0) {
/* 21 */       DailyPayExt.AwardInfo awardInfo = new DailyPayExt.AwardInfo();
/* 22 */       awardInfo.itemCode = this.rewardCode1;
/* 23 */       awardInfo.itemNum = this.rewardNum1;
/* 24 */       this.awards.add(awardInfo);
/*    */     } 
/* 26 */     if (this.rewardCode2 != null && this.rewardNum2 != 0) {
/* 27 */       DailyPayExt.AwardInfo awardInfo = new DailyPayExt.AwardInfo();
/* 28 */       awardInfo.itemCode = this.rewardCode2;
/* 29 */       awardInfo.itemNum = this.rewardNum2;
/* 30 */       this.awards.add(awardInfo);
/*    */     } 
/* 32 */     if (this.rewardCode3 != null && this.rewardNum3 != 0) {
/* 33 */       DailyPayExt.AwardInfo awardInfo = new DailyPayExt.AwardInfo();
/* 34 */       awardInfo.itemCode = this.rewardCode3;
/* 35 */       awardInfo.itemNum = this.rewardNum3;
/* 36 */       this.awards.add(awardInfo);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\data\ext\FirstPayExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */