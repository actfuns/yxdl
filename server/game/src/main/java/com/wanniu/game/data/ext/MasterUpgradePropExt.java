/*    */ package com.wanniu.game.data.ext;
/*    */ 
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.core.util.ClassUtil;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.data.MasterUpgradePropCO;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ public class MasterUpgradePropExt
/*    */   extends MasterUpgradePropCO {
/* 12 */   public Map<Const.PlayerBtlData, Integer> attr_master = new HashMap<>();
/*    */ 
/*    */   
/*    */   public void initProperty() {
/* 16 */     for (int i = 1; i <= this.propCount; i++) {
/* 17 */       String propName = "petProp" + i;
/* 18 */       String attrMax = "petMax" + i;
/*    */       
/*    */       try {
/* 21 */         Object obj = ClassUtil.getProperty(this, propName);
/* 22 */         if (obj != null) {
/* 23 */           String key = (String)obj;
/* 24 */           Const.PlayerBtlData pbd = Const.PlayerBtlData.getE(key);
/*    */           
/* 26 */           if (pbd != null) {
/* 27 */             this.attr_master.put(pbd, Integer.valueOf(((Integer)ClassUtil.getProperty(this, attrMax)).intValue()));
/*    */           }
/*    */         } 
/* 30 */       } catch (Exception e) {
/* 31 */         Out.error(new Object[] { "Exception in MasterUpgradePropExt: ", e });
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\data\ext\MasterUpgradePropExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */