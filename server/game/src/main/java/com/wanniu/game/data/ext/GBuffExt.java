/*    */ package com.wanniu.game.data.ext;
/*    */ 
/*    */ import com.wanniu.game.data.GBuffCO;
/*    */ import com.wanniu.game.player.AttributeUtil;
/*    */ import io.netty.util.internal.StringUtil;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ public class GBuffExt
/*    */   extends GBuffCO
/*    */ {
/*    */   public Map<String, Integer> attrs;
/*    */   
/*    */   public void putAttr(String str, int value) {
/* 15 */     if (null == this.attrs) {
/* 16 */       this.attrs = new HashMap<>();
/*    */     }
/*    */     
/* 19 */     if (StringUtil.isNullOrEmpty(str)) {
/*    */       return;
/*    */     }
/*    */     
/* 23 */     String attr = AttributeUtil.getKeyByName(str);
/*    */     
/* 25 */     if (StringUtil.isNullOrEmpty(attr)) {
/*    */       return;
/*    */     }
/*    */     
/* 29 */     this.attrs.put(attr, Integer.valueOf(value));
/*    */   }
/*    */   
/*    */   public void initProperty() {
/* 33 */     putAttr(this.buffAttribute1, this.buffValue1);
/* 34 */     putAttr(this.buffAttribute2, this.buffValue2);
/* 35 */     putAttr(this.buffAttribute3, this.buffValue3);
/* 36 */     putAttr(this.buffAttribute4, this.buffValue4);
/* 37 */     putAttr(this.buffAttribute5, this.buffValue5);
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\data\ext\GBuffExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */