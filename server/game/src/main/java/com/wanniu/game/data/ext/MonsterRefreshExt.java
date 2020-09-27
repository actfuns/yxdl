/*    */ package com.wanniu.game.data.ext;
/*    */ 
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.core.util.RandomUtil;
/*    */ import com.wanniu.core.util.StringUtil;
/*    */ import com.wanniu.game.data.MonsterRefreshCO;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ public class MonsterRefreshExt
/*    */   extends MonsterRefreshCO
/*    */ {
/*    */   public String[] monsterRefreshPoints;
/* 15 */   public float pointX = 0.0F;
/* 16 */   public float pointY = 0.0F;
/*    */   
/*    */   public Map<String, Integer> joinReward;
/*    */ 
/*    */   
/*    */   public void initProperty() {
/* 22 */     super.initProperty();
/*    */     
/* 24 */     this.monsterRefreshPoints = this.refreshPoint.split(":");
/*    */     
/* 26 */     String[] xy = this.monPoint.split(",");
/* 27 */     if (xy.length == 2) {
/*    */       try {
/* 29 */         this.pointX = Float.parseFloat(xy[0]);
/* 30 */         this.pointY = Float.parseFloat(xy[1]);
/* 31 */       } catch (NumberFormatException e) {
/* 32 */         Out.error(new Object[] { e });
/* 33 */         this.pointX = 0.0F;
/* 34 */         this.pointY = 0.0F;
/*    */       } 
/*    */     }
/* 37 */     if (!StringUtil.isEmpty(this.partakeDropPre)) {
/* 38 */       Map<String, Integer> tempJoinReward = new HashMap<>();
/* 39 */       String[] joins = this.partakeDropPre.split(";");
/* 40 */       if (joins != null && joins.length > 0) {
/* 41 */         for (String j : joins) {
/* 42 */           String[] js = j.split(":");
/* 43 */           tempJoinReward.put(js[0], Integer.valueOf(Integer.parseInt(js[1])));
/*    */         } 
/*    */       }
/* 46 */       this.joinReward = tempJoinReward;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public String getRefreshPoint() {
/* 52 */     return this.monsterRefreshPoints[RandomUtil.getIndex(this.monsterRefreshPoints.length)];
/*    */   }
/*    */   
/*    */   public boolean containsRefreshPoint(String point) {
/* 56 */     for (String p : this.monsterRefreshPoints) {
/* 57 */       if (p.equalsIgnoreCase(point)) {
/* 58 */         return true;
/*    */       }
/*    */     } 
/* 61 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\data\ext\MonsterRefreshExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */