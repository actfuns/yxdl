/*    */ package com.wanniu.game.data.ext;
/*    */ 
/*    */ import com.wanniu.game.data.WayTreasureCO;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WayTreasureExt
/*    */   extends WayTreasureCO
/*    */ {
/*    */   public List<Integer> doScenes;
/*    */   public List<List<Integer>> doPoints;
/*    */   public List<Integer> monsterIds;
/*    */   
/*    */   public void initProperty() {
/* 18 */     this.doScenes = new ArrayList<>();
/* 19 */     this.doPoints = new ArrayList<>();
/* 20 */     this.monsterIds = new ArrayList<>();
/*    */     
/* 22 */     String[] temp = this.doScene.split("\\|");
/* 23 */     for (String scene : temp) {
/* 24 */       this.doScenes.add(Integer.valueOf(Integer.parseInt(scene)));
/*    */     }
/*    */     
/* 27 */     temp = this.doPoint.split("\\|");
/* 28 */     for (String points : temp) {
/* 29 */       String[] ps = points.split(":");
/* 30 */       List<Integer> list_points = new ArrayList<>();
/* 31 */       for (String p : ps) {
/* 32 */         list_points.add(Integer.valueOf(Integer.parseInt(p)));
/*    */       }
/* 34 */       this.doPoints.add(list_points);
/*    */     } 
/*    */     
/* 37 */     temp = this.monsterID.split(":");
/* 38 */     for (String m : temp)
/* 39 */       this.monsterIds.add(Integer.valueOf(Integer.parseInt(m))); 
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\data\ext\WayTreasureExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */