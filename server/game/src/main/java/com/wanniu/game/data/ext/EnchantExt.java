/*    */ package com.wanniu.game.data.ext;
/*    */ 
/*    */ import com.alibaba.fastjson.JSONObject;
/*    */ import com.wanniu.game.data.EnchantCO;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EnchantExt
/*    */   extends EnchantCO
/*    */ {
/* 13 */   public JSONObject mates = null;
/*    */ 
/*    */   
/*    */   public void initProperty() {
/* 17 */     this.mates = new JSONObject();
/* 18 */     this.mates.put(this.mateCode1, Integer.valueOf(this.mateCount1));
/* 19 */     this.mates.put(this.mateCode2, Integer.valueOf(this.mateCount2));
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\data\ext\EnchantExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */