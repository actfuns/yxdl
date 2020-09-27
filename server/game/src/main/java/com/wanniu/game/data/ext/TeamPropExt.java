/*    */ package com.wanniu.game.data.ext;
/*    */ 
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.core.util.StringUtil;
/*    */ import com.wanniu.game.data.TeamPropCO;
/*    */ import com.wanniu.game.player.AttributeUtil;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ public class TeamPropExt
/*    */   extends TeamPropCO
/*    */ {
/*    */   public Map<String, Integer> attrs;
/*    */   
/*    */   public void initProperty() {
/* 16 */     super.initProperty();
/*    */     
/* 18 */     this.attrs = new HashMap<>();
/* 19 */     for (int i = 1; i <= 8; i++) {
/* 20 */       String attrName = "";
/* 21 */       int attrValue = 0;
/* 22 */       switch (i) {
/*    */         case 1:
/* 24 */           attrName = this.prop1;
/* 25 */           attrValue = this.min1;
/*    */           break;
/*    */         case 2:
/* 28 */           attrName = this.prop2;
/* 29 */           attrValue = this.min2;
/*    */           break;
/*    */         case 3:
/* 32 */           attrName = this.prop3;
/* 33 */           attrValue = this.min3;
/*    */           break;
/*    */         case 4:
/* 36 */           attrName = this.prop4;
/* 37 */           attrValue = this.min4;
/*    */           break;
/*    */         case 5:
/* 40 */           attrName = this.prop5;
/* 41 */           attrValue = this.min5;
/*    */           break;
/*    */         case 6:
/* 44 */           attrName = this.prop6;
/* 45 */           attrValue = this.min6;
/*    */           break;
/*    */         case 7:
/* 48 */           attrName = this.prop7;
/* 49 */           attrValue = this.min7;
/*    */           break;
/*    */         case 8:
/* 52 */           attrName = this.prop8;
/* 53 */           attrValue = this.min8;
/*    */           break;
/*    */       } 
/* 56 */       if (StringUtil.isNotEmpty(attrName)) {
/* 57 */         String key = AttributeUtil.getKeyByName(attrName);
/* 58 */         if (key != null) {
/* 59 */           this.attrs.put(key, Integer.valueOf(attrValue));
/*    */         }
/*    */       } else {
/*    */         
/* 63 */         Out.debug(new Object[] { "EquipProp attName is space" });
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\data\ext\TeamPropExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */