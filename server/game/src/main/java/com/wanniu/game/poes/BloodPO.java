/*    */ package com.wanniu.game.poes;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GEntity;
/*    */ import com.wanniu.game.DBField;
/*    */ import com.wanniu.game.DBTable;
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
/*    */ @DBTable("player_blood")
/*    */ public final class BloodPO
/*    */   extends GEntity
/*    */ {
/*    */   @DBField(isPKey = true, fieldType = "varchar", size = 50)
/* 22 */   public String playerId = null;
/* 23 */   public Map<Integer, Integer> equipedMap = new HashMap<>();
/*    */   
/*    */   public BloodPO(String playerId) {
/* 26 */     this();
/* 27 */     this.playerId = playerId;
/*    */   }
/*    */   
/*    */   public BloodPO() {}
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\poes\BloodPO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */