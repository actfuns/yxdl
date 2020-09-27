/*    */ package com.wanniu.game.poes;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GEntity;
/*    */ import com.wanniu.game.DBTable;
/*    */ import com.wanniu.game.data.ArmourAttributeCO;
/*    */ import com.wanniu.game.data.GameData;
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @DBTable("player_achieves")
/*    */ public class AchievementDataPO
/*    */   extends GEntity
/*    */ {
/* 33 */   public Map<Integer, AchievePO> achievements = new HashMap<>();
/*    */   
/* 35 */   public List<Integer> receivedAwards = new ArrayList<>();
/*    */ 
/*    */   
/* 38 */   public List<Integer> finishedFriendAchievementList = new ArrayList<>();
/*    */ 
/*    */   
/* 41 */   public Map<Integer, HolyArmour> holyArmourMap = new HashMap<>();
/*    */   
/*    */   public AchievementDataPO() {
/* 44 */     for (ArmourAttributeCO armourAttributeCO : GameData.ArmourAttributes.values()) {
/* 45 */       HolyArmour armour = new HolyArmour(armourAttributeCO.iD);
/* 46 */       this.holyArmourMap.put(Integer.valueOf(armour.id), armour);
/*    */     } 
/*    */   }
/*    */   
/*    */   public static class AchievePO {
/*    */     public int id;
/*    */     public int scheduleCurr;
/*    */     public List<String> data;
/*    */     public int awardState;
/*    */   }
/*    */   
/*    */   public static class HolyArmour {
/*    */     public int id;
/*    */     public int states;
/*    */     
/*    */     public HolyArmour() {}
/*    */     
/*    */     public HolyArmour(int id) {
/* 64 */       this.id = id;
/* 65 */       this.states = 1;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\poes\AchievementDataPO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */