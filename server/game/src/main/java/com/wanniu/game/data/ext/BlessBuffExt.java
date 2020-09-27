/*    */ package com.wanniu.game.data.ext;
/*    */ 
/*    */ import com.alibaba.fastjson.JSONObject;
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.game.data.BlessBuffCO;
/*    */ import com.wanniu.game.player.AttributeUtil;
/*    */ 
/*    */ public class BlessBuffExt
/*    */   extends BlessBuffCO {
/*    */   public JSONObject attr;
/*    */   
/*    */   public void initProperty() {
/* 13 */     super.initProperty();
/* 14 */     this.attr = new JSONObject();
/*    */     
/* 16 */     String key = AttributeUtil.getKeyByName(this.buffAttribute1);
/* 17 */     if (key == null) {
/* 18 */       Out.error(new Object[] { "BlessBuffExt attrName not exist : ", this.buffAttribute1 });
/*    */     }
/* 20 */     this.attr.put("attrKey", key);
/* 21 */     this.attr.put("attrValue", Integer.valueOf(this.buffValue1));
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\data\ext\BlessBuffExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */