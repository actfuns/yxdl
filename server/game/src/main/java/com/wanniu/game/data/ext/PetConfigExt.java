/*    */ package com.wanniu.game.data.ext;
/*    */ 
/*    */ import com.wanniu.game.data.PetConfigCO;
/*    */ 
/*    */ public class PetConfigExt
/*    */   extends PetConfigCO {
/*  7 */   public int intValue = 0;
/*    */   
/*    */   public void initProperty() {
/* 10 */     if (this.paramType.trim().equals("NUMBER"))
/* 11 */       this.intValue = Integer.parseInt(this.paramValue); 
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\data\ext\PetConfigExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */