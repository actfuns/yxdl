/*    */ package com.wanniu.game.data.ext;
/*    */ 
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.core.util.ClassUtil;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.data.MasterPropCO;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ public class MasterPropExt
/*    */   extends MasterPropCO {
/* 12 */   public Map<Const.PlayerBtlData, Integer> attr_master = new HashMap<>();
/* 13 */   public Map<Const.PlayerBtlData, Float> attr_grow = new HashMap<>();
/*    */   
/*    */   public void initProperty() {
/* 16 */     for (int i = 1; i <= this.propCount; i++) {
/* 17 */       String propName = "prop" + i;
/* 18 */       String attrMax = "max" + i;
/* 19 */       String propName_grow = "grow" + i;
/*    */       
/*    */       try {
/* 22 */         Object obj = ClassUtil.getProperty(this, propName);
/* 23 */         if (obj != null) {
/* 24 */           String key = (String)obj;
/* 25 */           Const.PlayerBtlData pbd = Const.PlayerBtlData.getE(key);
/*    */           
/* 27 */           if (pbd != null) {
/* 28 */             this.attr_master.put(pbd, Integer.valueOf(((Integer)ClassUtil.getProperty(this, attrMax)).intValue()));
/*    */           }
/*    */           
/* 31 */           this.attr_grow.put(pbd, Float.valueOf(((Float)ClassUtil.getProperty(this, propName_grow)).floatValue()));
/*    */         } 
/* 33 */       } catch (Exception e) {
/* 34 */         Out.error(new Object[] { "Exception in MasterPropExt: ", e });
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\data\ext\MasterPropExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */