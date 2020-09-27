/*    */ package com.wanniu.game.data.ext;
/*    */ 
/*    */ import com.wanniu.game.data.SuitConfigCO;
/*    */ import com.wanniu.game.player.AttributeUtil;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SuitConfigExt
/*    */   extends SuitConfigCO
/*    */ {
/*    */   public String _prop;
/*    */   
/*    */   public void initProperty() {
/* 15 */     this._prop = AttributeUtil.getKeyByName(this.prop);
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\data\ext\SuitConfigExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */