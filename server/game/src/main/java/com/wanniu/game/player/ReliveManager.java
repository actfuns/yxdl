/*    */ package com.wanniu.game.player;
/*    */ 
/*    */ import com.wanniu.game.data.GameData;
/*    */ import com.wanniu.game.data.ResurrectionCO;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ public class ReliveManager
/*    */ {
/*    */   public int payCost;
/* 12 */   public int payConfirm = 1;
/*    */   public int nowReliveNum;
/* 14 */   public Map<Integer, Integer> reliveHistory = new HashMap<>();
/*    */   
/*    */   public void addRelive(int areaId) {
/* 17 */     this.reliveHistory.put(Integer.valueOf(areaId), Integer.valueOf(getReliveCount(areaId) + 1));
/*    */   }
/*    */   
/*    */   public int getReliveCount(int areaId) {
/* 21 */     return this.reliveHistory.containsKey(Integer.valueOf(areaId)) ? ((Integer)this.reliveHistory.get(Integer.valueOf(areaId))).intValue() : 0;
/*    */   }
/*    */   
/*    */   public int getReliveTotal(int areaId) {
/* 25 */     ResurrectionCO resurrection = (ResurrectionCO)GameData.Resurrections.get(Integer.valueOf(areaId));
/* 26 */     return (resurrection != null) ? resurrection.resurrectNum : 0;
/*    */   }
/*    */   
/*    */   public void refreshNewDay() {
/* 30 */     this.nowReliveNum = 0;
/* 31 */     this.reliveHistory.clear();
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\player\ReliveManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */