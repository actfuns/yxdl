/*    */ package com.wanniu.game.data.ext;
/*    */ 
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.data.ArmourPlusCO;
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
/*    */ public class ArmourPlusExt
/*    */   extends ArmourPlusCO
/*    */ {
/*    */   public Map<Const.PlayerBtlData, Integer> atts;
/*    */   
/*    */   public void initProperty() {
/* 21 */     this.atts = new HashMap<>();
/*    */     
/* 23 */     String[] propStrs = this.prop.split(";");
/*    */     
/* 25 */     for (String string : propStrs) {
/* 26 */       String[] subPropStrs = string.split(":");
/* 27 */       this.atts.put(Const.PlayerBtlData.getE(Integer.parseInt(subPropStrs[0])), Integer.valueOf(Integer.parseInt(subPropStrs[1])));
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getKey() {
/* 36 */     return this.iD;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\data\ext\ArmourPlusExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */