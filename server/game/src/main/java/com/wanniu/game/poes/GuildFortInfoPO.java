/*    */ package com.wanniu.game.poes;
/*    */ 
/*    */ public class GuildFortInfoPO {
/*    */   public int attendTimes;
/*    */   public int winTimes;
/*    */   
/*    */   public float getWinRate() {
/*  8 */     if (this.attendTimes <= 0) {
/*  9 */       return 0.0F;
/*    */     }
/*    */     
/* 12 */     return (this.winTimes / this.attendTimes * 100);
/*    */   }
/*    */   
/*    */   public void onStat(boolean isWin) {
/* 16 */     this.attendTimes++;
/* 17 */     if (isWin)
/* 18 */       this.winTimes++; 
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\poes\GuildFortInfoPO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */