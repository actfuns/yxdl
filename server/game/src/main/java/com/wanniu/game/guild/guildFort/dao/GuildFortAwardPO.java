/*    */ package com.wanniu.game.guild.guildFort.dao;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ public class GuildFortAwardPO {
/*    */   public enum AwardFlag {
/*  8 */     NO_AWARD(0),
/*  9 */     HAS_AWARD(1),
/* 10 */     AWARDED(2);
/*    */     public int value;
/*    */     
/*    */     AwardFlag(int value) {
/* 14 */       this.value = value;
/*    */     }
/*    */   }
/*    */   
/* 18 */   public Map<Integer, AwardFlag> awardStatus = new HashMap<>();
/* 19 */   public long updateDate = 0L;
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\guild\guildFort\dao\GuildFortAwardPO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */