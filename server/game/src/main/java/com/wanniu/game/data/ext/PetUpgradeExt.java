/*    */ package com.wanniu.game.data.ext;
/*    */ 
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.core.util.ClassUtil;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.data.PetUpgradeCO;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ public class PetUpgradeExt
/*    */   extends PetUpgradeCO
/*    */ {
/* 13 */   public Map<Const.PlayerBtlData, Integer> upLevelAttrs = new HashMap<>();
/*    */ 
/*    */ 
/*    */   
/*    */   public void initProperty() {
/* 18 */     for (int i = 1; i <= this.propCount; i++) {
/* 19 */       String propName = "petProp" + i;
/* 20 */       String attrMax = "petMax" + i;
/*    */       
/*    */       try {
/* 23 */         Object obj = ClassUtil.getProperty(this, propName);
/* 24 */         if (obj != null) {
/* 25 */           String key = (String)obj;
/* 26 */           Const.PlayerBtlData pbd = Const.PlayerBtlData.getE(key);
/*    */           
/* 28 */           if (pbd != null) {
/* 29 */             this.upLevelAttrs.put(pbd, Integer.valueOf(((Integer)ClassUtil.getProperty(this, attrMax)).intValue()));
/*    */           }
/*    */         } 
/* 32 */       } catch (Exception e) {
/* 33 */         Out.error(new Object[] { "Exception in PetUpgradeExt: ", e });
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\data\ext\PetUpgradeExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */