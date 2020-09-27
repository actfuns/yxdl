/*    */ package com.wanniu.game.daoyou;
/*    */ 
/*    */ import com.wanniu.game.data.AllyConfigCO;
/*    */ import com.wanniu.game.data.GameData;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AllyConfiguration
/*    */ {
/*    */   public static AllyConfiguration getInstance() {
/* 14 */     return Inner.instance;
/*    */   }
/*    */   
/*    */   private static class Inner {
/* 18 */     private static AllyConfiguration instance = new AllyConfiguration();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private AllyConfiguration() {}
/*    */ 
/*    */ 
/*    */   
/*    */   public int getConfigI(String key) {
/* 29 */     return Integer.valueOf(getConfigS(key)).intValue();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getConfigS(String key) {
/* 36 */     return ((AllyConfigCO)GameData.AllyConfigs.get(key)).paramValue;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\daoyou\AllyConfiguration.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */