/*    */ package com.wanniu.game.data.ext;
/*    */ 
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.data.MedalListCO;
/*    */ 
/*    */ public class MedalListExt
/*    */   extends MedalListCO {
/*    */   public int _pro;
/*    */   
/*    */   public void initProperty() {
/* 11 */     this._pro = Const.PlayerPro.Value(this.pro);
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\data\ext\MedalListExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */