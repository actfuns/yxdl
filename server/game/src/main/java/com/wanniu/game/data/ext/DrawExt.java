/*    */ package com.wanniu.game.data.ext;
/*    */ 
/*    */ import com.wanniu.core.util.StringUtil;
/*    */ import com.wanniu.game.data.DrawCO;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ 
/*    */ public class DrawExt
/*    */   extends DrawCO
/*    */ {
/*    */   public ArrayList<DrawItem> items;
/*    */   public int totalRate;
/*    */   
/*    */   public void initProperty() {
/* 15 */     this.items = new ArrayList<>();
/* 16 */     this.totalRate = 0;
/*    */     
/* 18 */     if (StringUtil.isEmpty(this.propLibrary)) {
/*    */       return;
/*    */     }
/* 21 */     String[] items = this.propLibrary.split(";");
/*    */     
/* 23 */     for (String ss : items) {
/*    */       
/* 25 */       String[] rw = ss.split(":");
/*    */       
/* 27 */       DrawItem item = new DrawItem();
/* 28 */       if (rw.length == 3) {
/*    */ 
/*    */         
/* 31 */         item.itemCode = rw[0];
/* 32 */         item.itemNum = Integer.parseInt(rw[1]);
/* 33 */         item.itemRate = Integer.parseInt(rw[2]);
/*    */         
/* 35 */         this.totalRate += item.itemRate;
/*    */       }
/* 37 */       else if (rw.length == 2) {
/*    */         
/* 39 */         item.itemCode = rw[0];
/* 40 */         item.itemNum = Integer.parseInt(rw[1]);
/*    */       }
/* 42 */       else if (rw.length == 1) {
/*    */         
/* 44 */         item.itemCode = rw[0];
/*    */       } 
/* 46 */       this.items.add(item);
/*    */     } 
/*    */   }
/*    */   
/*    */   public static class DrawItem {
/*    */     public String itemCode;
/*    */     public int itemNum;
/*    */     public int itemRate;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\data\ext\DrawExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */