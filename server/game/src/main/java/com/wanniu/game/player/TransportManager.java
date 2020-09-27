/*    */ package com.wanniu.game.player;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TransportManager
/*    */ {
/*    */   public WNPlayer player;
/*    */   public Map<Integer, Integer> transportData;
/*    */   
/*    */   public TransportManager(WNPlayer player, Map<Integer, Integer> transportData) {
/* 18 */     this.player = player;
/* 19 */     if (transportData == null) {
/* 20 */       transportData = new HashMap<>();
/*    */     }
/*    */     
/* 23 */     this.transportData = transportData;
/*    */   }
/*    */   
/*    */   public void addNum(int id) {
/* 27 */     int num = ((Integer)this.transportData.get(Integer.valueOf(id))).intValue();
/* 28 */     num++;
/* 29 */     this.transportData.put(Integer.valueOf(id), Integer.valueOf(num));
/*    */   }
/*    */   
/*    */   public int getNum(int id) {
/* 33 */     int num = ((Integer)this.transportData.get(Integer.valueOf(id))).intValue();
/* 34 */     return num;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\player\TransportManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */