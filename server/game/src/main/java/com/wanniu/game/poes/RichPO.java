/*    */ package com.wanniu.game.poes;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GEntity;
/*    */ import com.wanniu.game.DBTable;
/*    */ import com.wanniu.game.data.GameData;
/*    */ import com.wanniu.game.data.TurnRewardCO;
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
/*    */ @DBTable("player_rich")
/*    */ public class RichPO
/*    */   extends GEntity
/*    */ {
/*    */   public int currentStep;
/*    */   public int freeCount;
/*    */   public int currentTurn;
/*    */   public Map<Integer, Integer> turnStatesMap;
/*    */   
/*    */   public RichPO() {
/* 28 */     reset(-1);
/*    */   }
/*    */   
/*    */   public void reset(int newTurn) {
/* 32 */     this.turnStatesMap = new HashMap<>();
/* 33 */     for (TurnRewardCO turnRewardCO : GameData.TurnRewards.values()) {
/* 34 */       this.turnStatesMap.put(Integer.valueOf(turnRewardCO.sort), Integer.valueOf(0));
/*    */     }
/* 36 */     this.currentStep = 1;
/* 37 */     this.freeCount = 0;
/*    */     
/* 39 */     this.currentTurn = newTurn;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\poes\RichPO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */