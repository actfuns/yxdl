/*    */ package com.wanniu.game.data.ext;
/*    */ 
/*    */ import com.wanniu.game.data.RefineCO;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RefineExt
/*    */   extends RefineCO
/*    */ {
/*    */   public Map<String, Integer> materials;
/*    */   
/*    */   public int getKey() {
/* 18 */     return this.level;
/*    */   }
/*    */ 
/*    */   
/*    */   public void initProperty() {
/* 23 */     this.materials = new HashMap<>();
/* 24 */     this.materials.put(this.mateCode1, Integer.valueOf(this.mateCount1));
/* 25 */     this.materials.put(this.mateCode2, Integer.valueOf(this.mateCount2));
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\data\ext\RefineExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */