/*    */ package com.wanniu.game.data.ext;
/*    */ 
/*    */ import com.wanniu.game.data.DropListCO;
/*    */ import java.util.HashMap;
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
/*    */ public class DropListExt
/*    */   extends DropListCO
/*    */ {
/*    */   public int[] weeks;
/*    */   public Map<String, Integer> rewardPreview;
/*    */   public Map<String, Integer> firstRewardPreview;
/*    */   public Map<String, Integer> weekRewardPreview;
/*    */   
/*    */   public void initProperty() {
/* 37 */     String[] weeks = this.weekDay.split(",");
/* 38 */     this.weeks = new int[weeks.length];
/* 39 */     for (int i = 0; i < weeks.length; i++) {
/* 40 */       this.weeks[i] = Integer.parseInt(weeks[i]);
/* 41 */       if (this.weeks[i] == 7) {
/* 42 */         this.weeks[i] = 1;
/*    */       } else {
/* 44 */         this.weeks[i] = this.weeks[i] + 1;
/*    */       } 
/*    */     } 
/*    */     
/* 48 */     String[] rewardPreviewStrs = this.itemView.split(";");
/* 49 */     this.rewardPreview = new HashMap<>();
/* 50 */     for (int j = 0; j < rewardPreviewStrs.length; j++) {
/*    */       
/* 52 */       String str = rewardPreviewStrs[j];
/* 53 */       String[] params = str.split(":");
/* 54 */       String code = params[0];
/* 55 */       int count = Integer.parseInt(params[1]);
/* 56 */       this.rewardPreview.put(code, Integer.valueOf(count));
/*    */     } 
/*    */ 
/*    */     
/* 60 */     String[] firstRewardPreviewStrs = this.firstReward.split(";");
/* 61 */     this.firstRewardPreview = new HashMap<>();
/* 62 */     for (int k = 0; k < rewardPreviewStrs.length; k++) {
/*    */       
/* 64 */       String str = firstRewardPreviewStrs[k];
/* 65 */       String[] params = str.split(":");
/* 66 */       String code = params[0];
/* 67 */       int count = Integer.parseInt(params[1]);
/* 68 */       this.firstRewardPreview.put(code, Integer.valueOf(count));
/*    */     } 
/*    */ 
/*    */     
/* 72 */     String[] weekRewardPreviewStrs = this.weekReward.split(";");
/* 73 */     this.weekRewardPreview = new HashMap<>();
/* 74 */     for (int m = 0; m < weekRewardPreviewStrs.length; m++) {
/*    */       
/* 76 */       String str = weekRewardPreviewStrs[m];
/* 77 */       String[] params = str.split(":");
/* 78 */       String code = params[0];
/* 79 */       int count = Integer.parseInt(params[1]);
/* 80 */       this.weekRewardPreview.put(code, Integer.valueOf(count));
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isWeek(int week) {
/* 86 */     for (int i = 0; i < this.weeks.length; i++) {
/* 87 */       if (this.weeks[i] == week) {
/* 88 */         return true;
/*    */       }
/*    */     } 
/* 91 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\data\ext\DropListExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */