/*    */ package com.wanniu.game.revelry;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
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
/*    */ public class RevelryToday
/*    */ {
/*    */   private final String name;
/* 26 */   private final List<RevelryColumn> columns = new ArrayList<>();
/* 27 */   private long timeleft = 2147483647L;
/*    */   
/*    */   public RevelryToday(String name) {
/* 30 */     this.name = name;
/*    */   }
/*    */   
/*    */   public String getName() {
/* 34 */     return this.name;
/*    */   }
/*    */   
/*    */   public List<RevelryColumn> getColumns() {
/* 38 */     return this.columns;
/*    */   }
/*    */   
/*    */   public long getTimeleft() {
/* 42 */     return this.timeleft;
/*    */   }
/*    */   
/*    */   public void setTimeleft(long timeleft) {
/* 46 */     this.timeleft = timeleft;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\revelry\RevelryToday.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */