/*    */ package com.wanniu.game.arena.po;
/*    */ 
/*    */ import com.wanniu.game.DBField;
/*    */ import java.util.Date;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ArenaSystemPO
/*    */ {
/*    */   @DBField(isPKey = true, fieldType = "varchar", size = 50)
/*    */   public String logicServerId;
/*    */   public Date seasonResetTime;
/*    */   public int term;
/*    */   
/*    */   public ArenaSystemPO() {}
/*    */   
/*    */   public ArenaSystemPO(String logicServerId) {
/* 19 */     this.logicServerId = logicServerId;
/* 20 */     this.seasonResetTime = new Date();
/* 21 */     this.term = 0;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\arena\po\ArenaSystemPO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */