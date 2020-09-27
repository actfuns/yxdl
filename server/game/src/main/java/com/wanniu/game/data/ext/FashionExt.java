/*    */ package com.wanniu.game.data.ext;
/*    */ 
/*    */ import com.wanniu.core.util.StringUtil;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.data.FashionCO;
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
/*    */ 
/*    */ public class FashionExt
/*    */   extends FashionCO
/*    */ {
/*    */   public int avatarTag;
/*    */   public Map<Const.PlayerBtlData, Integer> atts;
/*    */   
/*    */   public void initProperty() {
/* 25 */     if (this.type == Const.FASHION_TYPE.WEPON.value) {
/* 26 */       this.avatarTag = Const.AVATAR_TYPE.R_HAND_WEAPON.value;
/* 27 */     } else if (this.type == Const.FASHION_TYPE.CLOTH.value) {
/* 28 */       this.avatarTag = Const.AVATAR_TYPE.AVATAR_BODY.value;
/* 29 */     } else if (this.type == Const.FASHION_TYPE.WING.value) {
/* 30 */       this.avatarTag = Const.AVATAR_TYPE.REAR_EQUIPMENT.value;
/*    */     } 
/* 32 */     this.atts = new HashMap<>();
/*    */     
/* 34 */     if (StringUtil.isNotEmpty(this.prop1))
/*    */     {
/* 36 */       this.atts.put(Const.PlayerBtlData.getE(this.prop1), Integer.valueOf(this.num1));
/*    */     }
/* 38 */     if (StringUtil.isNotEmpty(this.prop2)) {
/* 39 */       this.atts.put(Const.PlayerBtlData.getE(this.prop2), Integer.valueOf(this.num2));
/*    */     }
/* 41 */     if (StringUtil.isNotEmpty(this.prop3)) {
/* 42 */       this.atts.put(Const.PlayerBtlData.getE(this.prop3), Integer.valueOf(this.num3));
/*    */     }
/* 44 */     if (StringUtil.isNotEmpty(this.prop4)) {
/* 45 */       this.atts.put(Const.PlayerBtlData.getE(this.prop4), Integer.valueOf(this.num4));
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public String getKey() {
/* 51 */     return this.code;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\data\ext\FashionExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */