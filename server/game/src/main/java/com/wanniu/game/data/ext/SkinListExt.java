/*    */ package com.wanniu.game.data.ext;
/*    */ 
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.core.util.ClassUtil;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.data.SkinListCO;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ public class SkinListExt
/*    */   extends SkinListCO {
/* 12 */   public Map<Const.PlayerBtlData, Integer> skinAttrs = new HashMap<>();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void initProperty() {
/* 19 */     for (int i = 1; i <= 6; i++) {
/* 20 */       String propName = "prop" + i;
/* 21 */       String attrMax = "max" + i;
/*    */ 
/*    */       
/*    */       try {
/* 25 */         Object obj = ClassUtil.getProperty(this, propName);
/* 26 */         if (obj != null) {
/* 27 */           String key = (String)obj;
/* 28 */           Const.PlayerBtlData pbd = Const.PlayerBtlData.getE(key);
/*    */           
/* 30 */           if (pbd != null) {
/* 31 */             this.skinAttrs.put(pbd, Integer.valueOf(((Integer)ClassUtil.getProperty(this, attrMax)).intValue()));
/*    */           }
/*    */         }
/*    */       
/* 35 */       } catch (Exception e) {
/* 36 */         Out.error(new Object[] { "Exception in SkinListExt: ", e });
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\data\ext\SkinListExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */