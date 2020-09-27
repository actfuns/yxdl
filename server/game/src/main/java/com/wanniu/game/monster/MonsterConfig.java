/*    */ package com.wanniu.game.monster;
/*    */ 
/*    */ import com.wanniu.game.data.GameData;
/*    */ import com.wanniu.game.data.base.MonsterBase;
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.function.Predicate;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MonsterConfig
/*    */ {
/*    */   private static MonsterConfig instance;
/*    */   
/*    */   public static MonsterConfig getInstance() {
/* 23 */     if (instance == null) {
/* 24 */       instance = new MonsterConfig();
/*    */     }
/* 26 */     return instance;
/*    */   }
/*    */   
/* 29 */   public Map<Integer, MonsterBase> monsterProps = new HashMap<>();
/*    */   
/*    */   public void loadScript() {
/* 32 */     this.monsterProps.putAll(GameData.Normal_Worlds);
/* 33 */     this.monsterProps.putAll(GameData.Dungeons);
/* 34 */     this.monsterProps.putAll(GameData.DemonTowers);
/* 35 */     this.monsterProps.putAll(GameData.Dungeon_Normals);
/* 36 */     this.monsterProps.putAll(GameData.Dungeon_Elites);
/* 37 */     this.monsterProps.putAll(GameData.Dungeon_Heros);
/*    */   }
/*    */   
/*    */   public MonsterBase get(int id) {
/* 41 */     return this.monsterProps.get(Integer.valueOf(id));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public List<MonsterBase> find(Predicate<MonsterBase> t) {
/* 48 */     List<MonsterBase> list = new ArrayList<>();
/* 49 */     for (MonsterBase m : this.monsterProps.values()) {
/* 50 */       if (t.test(m)) {
/* 51 */         list.add(m);
/*    */       }
/*    */     } 
/* 54 */     return list;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\monster\MonsterConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */