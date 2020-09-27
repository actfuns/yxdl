/*    */ package com.wanniu.game.data.ext;
/*    */ 
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.data.ArmourAttributeCO;
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
/*    */ 
/*    */ public class ArmourAttributeExt
/*    */   extends ArmourAttributeCO
/*    */ {
/*    */   public Map<Const.PlayerBtlData, Integer> atts;
/*    */   
/*    */   public void initProperty() {
/* 22 */     this.atts = new HashMap<>();
/*    */     
/* 24 */     String[] propStrs = this.prop.split(";");
/*    */     
/* 26 */     for (String string : propStrs) {
/* 27 */       String[] subPropStrs = string.split(":");
/* 28 */       this.atts.put(Const.PlayerBtlData.getE(Integer.parseInt(subPropStrs[0])), Integer.valueOf(Integer.parseInt(subPropStrs[1])));
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getKey() {
/* 37 */     return this.iD;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\data\ext\ArmourAttributeExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */