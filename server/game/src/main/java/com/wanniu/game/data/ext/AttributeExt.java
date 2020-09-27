/*    */ package com.wanniu.game.data.ext;
/*    */ 
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.data.AttributeCO;
/*    */ 
/*    */ public class AttributeExt
/*    */   extends AttributeCO
/*    */ {
/*    */   public Const.PlayerBtlData btlProp;
/*    */   
/*    */   public void initProperty() {
/* 12 */     this.btlProp = Const.PlayerBtlData.getE(this.iD);
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\data\ext\AttributeExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */