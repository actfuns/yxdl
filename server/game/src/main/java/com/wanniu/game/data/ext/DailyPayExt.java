/*    */ package com.wanniu.game.data.ext;
/*    */ 
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.data.DailyPayCO;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class DailyPayExt
/*    */   extends DailyPayCO
/*    */ {
/*    */   public int Job;
/*    */   public ArrayList<AwardInfo> awards;
/*    */   
/*    */   public void initProperty() {
/* 14 */     this.Job = Const.PlayerPro.Value(this.job);
/* 15 */     this.awards = new ArrayList<>();
/* 16 */     if (this.rewardCode1 != null && this.rewardNum1 != 0) {
/* 17 */       AwardInfo awardInfo = new AwardInfo();
/* 18 */       awardInfo.itemCode = this.rewardCode1;
/* 19 */       awardInfo.itemNum = this.rewardNum1;
/* 20 */       this.awards.add(awardInfo);
/*    */     } 
/* 22 */     if (this.rewardCode2 != null && this.rewardNum2 != 0) {
/* 23 */       AwardInfo awardInfo = new AwardInfo();
/* 24 */       awardInfo.itemCode = this.rewardCode2;
/* 25 */       awardInfo.itemNum = this.rewardNum2;
/* 26 */       this.awards.add(awardInfo);
/*    */     } 
/* 28 */     if (this.rewardCode3 != null && this.rewardNum3 != 0) {
/* 29 */       AwardInfo awardInfo = new AwardInfo();
/* 30 */       awardInfo.itemCode = this.rewardCode3;
/* 31 */       awardInfo.itemNum = this.rewardNum3;
/* 32 */       this.awards.add(awardInfo);
/*    */     } 
/* 34 */     if (this.rewardCode4 != null && this.rewardNum4 != 0) {
/* 35 */       AwardInfo awardInfo = new AwardInfo();
/* 36 */       awardInfo.itemCode = this.rewardCode4;
/* 37 */       awardInfo.itemNum = this.rewardNum4;
/* 38 */       this.awards.add(awardInfo);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static class AwardInfo
/*    */   {
/*    */     public String itemCode;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     public int itemNum;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     public int enchantLv;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     public AwardInfo() {}
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     public AwardInfo(String itemCode, int itemNum, int enchantLv) {
/* 75 */       this.itemCode = itemCode;
/* 76 */       this.itemNum = itemNum;
/* 77 */       this.enchantLv = enchantLv;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\data\ext\DailyPayExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */