/*    */ package com.wanniu.game.data.ext;
/*    */ 
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.core.util.ClassUtil;
/*    */ import com.wanniu.core.util.StringUtil;
/*    */ import com.wanniu.game.data.base.DEquipBase;
/*    */ import com.wanniu.game.player.AttributeUtil;
/*    */ import java.util.HashMap;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class UniqueEquipExt
/*    */   extends DEquipBase
/*    */ {
/*    */   public String getKey() {
/* 19 */     return this.code;
/*    */   }
/*    */ 
/*    */   
/*    */   public void initProperty() {
/* 24 */     initProp();
/*    */     
/* 26 */     this.fixedAtts = new HashMap<>();
/*    */     try {
/* 28 */       for (int i = 1; i <= 6; i++) {
/* 29 */         String attrName = "rProp" + i;
/* 30 */         String par = "rPar" + i;
/* 31 */         String minValue = "rMin" + i;
/* 32 */         String maxValue = "rMax" + i;
/*    */         
/* 34 */         String key = (String)ClassUtil.getProperty(this, attrName);
/* 35 */         if (!StringUtil.isEmpty(key))
/*    */         {
/* 37 */           this.fixedAtts.put(AttributeUtil.getKeyByName(key), 
/* 38 */               Integer.valueOf(((Integer)ClassUtil.getProperty(this, minValue)).intValue())); } 
/*    */       } 
/* 40 */     } catch (Exception e) {
/* 41 */       Out.error(new Object[] { e });
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\data\ext\UniqueEquipExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */