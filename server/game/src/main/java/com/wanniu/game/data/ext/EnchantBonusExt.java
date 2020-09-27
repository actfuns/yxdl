/*    */ package com.wanniu.game.data.ext;
/*    */ 
/*    */ import com.wanniu.game.data.EnchantBonusCO;
/*    */ import com.wanniu.game.item.ItemConfig;
/*    */ import com.wanniu.game.player.AttributeUtil;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EnchantBonusExt
/*    */   extends EnchantBonusCO
/*    */ {
/*    */   public int _type;
/*    */   public String _prop;
/*    */   
/*    */   public void initProperty() {
/* 19 */     this._type = (ItemConfig.getInstance().getIdConfig(this.type)).typeID;
/*    */     
/* 21 */     this._prop = AttributeUtil.getKeyByName(this.prop);
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\data\ext\EnchantBonusExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */