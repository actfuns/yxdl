/*    */ package com.wanniu.game.data.ext;
/*    */ 
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.core.util.ClassUtil;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.data.UpLevelExpCO;
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
/*    */ public class UpLevelExpExt
/*    */   extends UpLevelExpCO
/*    */ {
/*    */   public int Pro;
/*    */   public Map<Const.PlayerBtlData, Integer> attrs;
/*    */   
/*    */   public void initProperty() {
/* 26 */     this.attrs = new HashMap<>();
/* 27 */     for (int i = 1; i <= 5; i++) {
/* 28 */       String propName = "prop" + i;
/* 29 */       String maxValue = "max" + i;
/*    */       
/*    */       try {
/* 32 */         Object obj = ClassUtil.getProperty(this, propName);
/* 33 */         if (obj != null) {
/* 34 */           String key = (String)obj;
/*    */           
/* 36 */           Const.PlayerBtlData pbd = Const.PlayerBtlData.getE(key);
/* 37 */           if (pbd != null) {
/* 38 */             this.attrs.put(pbd, Integer.valueOf(((Integer)ClassUtil.getProperty(this, maxValue)).intValue()));
/*    */           }
/*    */         } 
/* 41 */       } catch (Exception e) {
/* 42 */         Out.error(new Object[] { e });
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\data\ext\UpLevelExpExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */