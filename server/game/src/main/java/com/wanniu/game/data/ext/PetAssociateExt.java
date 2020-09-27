/*    */ package com.wanniu.game.data.ext;
/*    */ 
/*    */ import com.wanniu.game.data.PetAssociateCO;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PetAssociateExt
/*    */   extends PetAssociateCO
/*    */ {
/* 17 */   public Map<Integer, Integer> petIDMap = new HashMap<>();
/*    */   
/* 19 */   public Map<Integer, Integer> addProMap = new HashMap<>();
/*    */ 
/*    */ 
/*    */   
/*    */   public void initProperty() {
/* 24 */     String[] petIDStrs = this.petID.split(";");
/* 25 */     for (String petIDStr : petIDStrs) {
/* 26 */       String[] subPetIDStr = petIDStr.split(":");
/* 27 */       this.petIDMap.put(Integer.valueOf(Integer.parseInt(subPetIDStr[0])), Integer.valueOf(Integer.parseInt(subPetIDStr[1])));
/*    */     } 
/*    */     
/* 30 */     String[] addProStrs = this.addPro.split(";");
/* 31 */     for (String addProStr : addProStrs) {
/* 32 */       String[] subAddProStr = addProStr.split(":");
/* 33 */       this.addProMap.put(Integer.valueOf(Integer.parseInt(subAddProStr[0])), Integer.valueOf(Integer.parseInt(subAddProStr[1])));
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\data\ext\PetAssociateExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */