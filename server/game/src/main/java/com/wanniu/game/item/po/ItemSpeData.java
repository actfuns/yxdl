/*    */ package com.wanniu.game.item.po;
/*    */ 
/*    */ import com.wanniu.game.equip.RepeatKeyMap;
/*    */ import java.io.Serializable;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ItemSpeData
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   public int worth;
/*    */   public Map<String, Integer> baseAtts;
/*    */   public Map<String, Integer> extAttsAdd;
/*    */   public RepeatKeyMap<Integer, Integer> extAtts;
/*    */   public Map<Integer, Integer> legendAtts;
/*    */   public Map<String, Integer> tempBaseAtts;
/*    */   public RepeatKeyMap<Integer, Integer> tempExtAtts;
/*    */   public RepeatKeyMap<Integer, Integer> tempExtAtts_senior;
/*    */   public Map<String, Integer> tempExtAttsAdd;
/*    */   public Map<Integer, Integer> tempUniqueAtts;
/*    */   
/*    */   public static class ExtObj
/*    */   {
/*    */     public int value;
/*    */     public int affixId;
/*    */     
/*    */     public ExtObj(int value, int affixId) {
/* 51 */       this.value = value;
/* 52 */       this.affixId = affixId;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\item\po\ItemSpeData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */