/*    */ package com.wanniu.game.solo.po;
/*    */ 
/*    */ import com.wanniu.game.DBField;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SoloSystemPO
/*    */ {
/*    */   @DBField(isPKey = true, fieldType = "varchar", size = 50)
/*    */   public String logicServerId;
/*    */   public Date seasonEndTime;
/*    */   public int term;
/*    */   public int rounds;
/*    */   public List<String> soloNewses;
/*    */   
/*    */   public SoloSystemPO() {}
/*    */   
/*    */   public SoloSystemPO(String logicServerId) {
/* 23 */     this.logicServerId = logicServerId;
/* 24 */     this.seasonEndTime = null;
/* 25 */     this.term = 0;
/* 26 */     this.rounds = 1;
/*    */     
/* 28 */     this.soloNewses = new ArrayList<>();
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\solo\po\SoloSystemPO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */