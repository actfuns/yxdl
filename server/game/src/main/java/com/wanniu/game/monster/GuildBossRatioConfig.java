/*    */ package com.wanniu.game.monster;
/*    */ 
/*    */ import com.wanniu.game.data.GameData;
/*    */ import com.wanniu.game.data.GuildBossRatioCO;
/*    */ import com.wanniu.game.data.ext.InspireLevelExt;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
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
/*    */ 
/*    */ 
/*    */ public class GuildBossRatioConfig
/*    */ {
/* 31 */   public static Map<Integer, GuildBossRatioCO> monsterProps = new HashMap<>();
/* 32 */   public static Map<String, InspireLevelExt> inspires = new HashMap<>();
/*    */   
/*    */   public static void loadScript() {
/* 35 */     monsterProps.putAll(GameData.GuildBossRatios);
/* 36 */     loadInspire();
/*    */   }
/*    */   
/*    */   private static void loadInspire() {
/* 40 */     Map<String, InspireLevelExt> tpInspires = new HashMap<>();
/* 41 */     Map<Integer, InspireLevelExt> inspireLevels = GameData.InspireLevels;
/* 42 */     Set<Map.Entry<Integer, InspireLevelExt>> sets = inspireLevels.entrySet();
/* 43 */     for (Map.Entry<Integer, InspireLevelExt> e : sets) {
/* 44 */       InspireLevelExt co = e.getValue();
/* 45 */       String key = co.inspireType + "_" + co.inspireNum;
/* 46 */       tpInspires.put(key, co);
/*    */     } 
/*    */     
/* 49 */     for (Map.Entry<Integer, InspireLevelExt> e : sets) {
/* 50 */       InspireLevelExt co = e.getValue();
/* 51 */       int num = co.inspireNum;
/* 52 */       int lastnum = num - 1;
/* 53 */       String key = co.inspireType + "_" + co.inspireNum;
/* 54 */       InspireLevelExt currentExt = tpInspires.get(key);
/* 55 */       currentExt.totalInspirePlus = currentExt.inspirePlus * 100;
/* 56 */       if (lastnum > 0) {
/* 57 */         String lastKey = co.inspireType + "_" + lastnum;
/* 58 */         InspireLevelExt lastExt = tpInspires.get(lastKey);
/* 59 */         currentExt.totalInspirePlus += lastExt.totalInspirePlus;
/*    */       } 
/*    */     } 
/* 62 */     inspires = tpInspires;
/*    */   }
/*    */   
/*    */   public static GuildBossRatioCO getGuildBossRatioCO(int level) {
/* 66 */     return monsterProps.get(Integer.valueOf(level));
/*    */   }
/*    */   
/*    */   public static InspireLevelExt getInspireLevelCO(int type, int num) {
/* 70 */     String key = type + "_" + num;
/* 71 */     return inspires.get(key);
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\monster\GuildBossRatioConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */