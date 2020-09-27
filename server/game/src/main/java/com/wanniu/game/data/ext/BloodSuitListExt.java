/*    */ package com.wanniu.game.data.ext;
/*    */ 
/*    */ import com.wanniu.game.data.BloodSuitListCO;
/*    */ import java.util.LinkedList;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BloodSuitListExt
/*    */   extends BloodSuitListCO
/*    */ {
/*    */   public List<Integer> partIdList;
/*    */   public List<Integer> occupationProIds;
/*    */   
/*    */   public void initProperty() {
/* 21 */     this.partIdList = new LinkedList<>();
/* 22 */     this.occupationProIds = new LinkedList<>();
/*    */     
/* 24 */     String[] partCodeListStrs = this.partCodeList.split(",");
/* 25 */     for (String partCodeListItem : partCodeListStrs) {
/* 26 */       this.partIdList.add(Integer.valueOf(Integer.parseInt(partCodeListItem)));
/*    */     }
/*    */     
/* 29 */     String[] occupationStrs = this.occupation.split(",");
/* 30 */     for (String occupationItem : occupationStrs)
/* 31 */       this.occupationProIds.add(Integer.valueOf(Integer.parseInt(occupationItem))); 
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\data\ext\BloodSuitListExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */