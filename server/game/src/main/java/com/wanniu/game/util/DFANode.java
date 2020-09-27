/*    */ package com.wanniu.game.util;
/*    */ 
/*    */ import java.util.LinkedList;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class DFANode
/*    */ {
/*    */   private int value;
/*    */   private List<DFANode> subNodes;
/*    */   private boolean isLast;
/*    */   
/*    */   public DFANode(int value, boolean isLast) {
/* 17 */     this.value = value;
/* 18 */     this.isLast = isLast;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private DFANode addSubNode(DFANode subNode) {
/* 26 */     if (this.subNodes == null)
/* 27 */       this.subNodes = new LinkedList<>(); 
/* 28 */     this.subNodes.add(subNode);
/* 29 */     return subNode;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public DFANode addIfNoExist(int value, boolean isLast) {
/* 36 */     if (this.subNodes == null) {
/* 37 */       return addSubNode(new DFANode(value, isLast));
/*    */     }
/* 39 */     for (DFANode subNode : this.subNodes) {
/* 40 */       if (subNode.value == value) {
/* 41 */         if (!subNode.isLast && isLast)
/* 42 */           subNode.isLast = true; 
/* 43 */         return subNode;
/*    */       } 
/*    */     } 
/* 46 */     return addSubNode(new DFANode(value, isLast));
/*    */   }
/*    */   
/*    */   public DFANode querySub(int value) {
/* 50 */     if (this.subNodes == null) {
/* 51 */       return null;
/*    */     }
/* 53 */     for (DFANode subNode : this.subNodes) {
/* 54 */       if (subNode.value == value)
/* 55 */         return subNode; 
/*    */     } 
/* 57 */     return null;
/*    */   }
/*    */   
/*    */   public boolean isLast() {
/* 61 */     return this.isLast;
/*    */   }
/*    */   
/*    */   public void setLast(boolean isLast) {
/* 65 */     this.isLast = isLast;
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 70 */     return this.value;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\gam\\util\DFANode.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */