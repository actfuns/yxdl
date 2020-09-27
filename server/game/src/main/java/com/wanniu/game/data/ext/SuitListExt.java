/*    */ package com.wanniu.game.data.ext;
/*    */ 
/*    */ import com.wanniu.game.data.SuitListCO;
/*    */ import com.wanniu.game.equip.NormalEquip;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SuitListExt
/*    */   extends SuitListCO
/*    */ {
/*    */   public List<String> partCodes;
/*    */   
/*    */   public void initProperty() {
/* 21 */     this.partCodes = new ArrayList<>();
/* 22 */     String[] pars = this.partCodeList.split(",");
/* 23 */     for (String code : pars) {
/* 24 */       this.partCodes.add(code);
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public List<String> getContaintsCode(Map<Integer, NormalEquip> equips) {
/* 33 */     List<String> list = new ArrayList<>();
/* 34 */     for (NormalEquip equip : equips.values()) {
/* 35 */       if (equip == null) {
/*    */         continue;
/*    */       }
/* 38 */       if (this.partCodes.contains(equip.itemDb.code)) {
/* 39 */         list.add(equip.itemDb.code);
/*    */       }
/*    */     } 
/* 42 */     return list;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\data\ext\SuitListExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */