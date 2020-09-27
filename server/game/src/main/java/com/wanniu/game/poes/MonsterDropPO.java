/*    */ package com.wanniu.game.poes;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GEntity;
/*    */ import com.wanniu.game.DBTable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @DBTable("monster_drop_info")
/*    */ public class MonsterDropPO
/*    */   extends GEntity
/*    */ {
/*    */   private int todayCount;
/*    */   
/*    */   public int getTodayCount() {
/* 18 */     return this.todayCount;
/*    */   }
/*    */   
/*    */   public void setTodayCount(int todayCount) {
/* 22 */     this.todayCount = todayCount;
/*    */   }
/*    */   
/*    */   public void clear() {
/* 26 */     this.todayCount = 0;
/*    */   }
/*    */   
/*    */   public void addBossCount() {
/* 30 */     this.todayCount++;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\poes\MonsterDropPO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */