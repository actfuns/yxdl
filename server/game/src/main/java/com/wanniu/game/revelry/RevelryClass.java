/*    */ package com.wanniu.game.revelry;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.TreeMap;
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
/*    */ public class RevelryClass
/*    */ {
/*    */   private final String name;
/* 26 */   private final Map<String, RevelryToday> todays = new TreeMap<>();
/*    */   
/*    */   public RevelryClass(String name) {
/* 29 */     this.name = name;
/*    */   }
/*    */   
/*    */   public String getName() {
/* 33 */     return this.name;
/*    */   }
/*    */   
/*    */   public Map<String, RevelryToday> getTodays() {
/* 37 */     return this.todays;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\revelry\RevelryClass.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */