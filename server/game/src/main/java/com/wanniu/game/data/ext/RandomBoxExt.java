/*    */ package com.wanniu.game.data.ext;
/*    */ 
/*    */ import com.wanniu.core.util.RandomUtil;
/*    */ import com.wanniu.core.util.StringUtil;
/*    */ import com.wanniu.game.data.RandomBoxCO;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RandomBoxExt
/*    */   extends RandomBoxCO
/*    */ {
/*    */   public static class Point
/*    */   {
/*    */     public float x;
/*    */     public float y;
/*    */     
/*    */     Point(float x, float y) {
/* 23 */       this.x = x;
/* 24 */       this.y = y;
/*    */     }
/*    */     
/*    */     public String toString() {
/* 28 */       return this.x + "," + this.y;
/*    */     }
/*    */     
/*    */     public double distance(Point p) {
/* 32 */       return Math.sqrt(((p.x - this.x) * (p.x - this.x) + (p.y - this.y) * (p.y - this.y)));
/*    */     }
/*    */   }
/*    */ 
/*    */   
/* 37 */   public final List<Point> points = new ArrayList<>();
/*    */ 
/*    */   
/*    */   public void initProperty() {
/* 41 */     if (StringUtil.isNotEmpty(this.startPoint)) {
/* 42 */       String[] points = this.startPoint.split(":");
/* 43 */       for (String point : points) {
/* 44 */         String[] pos = point.split(",");
/* 45 */         this.points.add(new Point(Float.valueOf(pos[0]).floatValue(), Float.valueOf(pos[1]).floatValue()));
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   public Point randomPoint() {
/* 51 */     return this.points.get(RandomUtil.getIndex(this.points.size()));
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\data\ext\RandomBoxExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */