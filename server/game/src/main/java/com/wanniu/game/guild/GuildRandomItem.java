/*    */ package com.wanniu.game.guild;
/*    */ 
/*    */ public class GuildRandomItem {
/*    */   public int id;
/*    */   public int weight;
/*    */   public int minNum;
/*    */   public int maxNum;
/*    */   
/*    */   public int getPropertyValue(String key) {
/* 10 */     if (key.equals("id"))
/* 11 */       return this.id; 
/* 12 */     if (key.equals("weight"))
/* 13 */       return this.weight; 
/* 14 */     if (key.equals("minNum"))
/* 15 */       return this.minNum; 
/* 16 */     if (key.equals("maxNum")) {
/* 17 */       return this.maxNum;
/*    */     }
/* 19 */     return 0;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\guild\GuildRandomItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */