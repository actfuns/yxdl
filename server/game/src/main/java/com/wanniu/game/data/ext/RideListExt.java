/*    */ package com.wanniu.game.data.ext;
/*    */ 
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.core.util.ClassUtil;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.data.GameData;
/*    */ import com.wanniu.game.data.RideListCO;
/*    */ import java.util.HashMap;
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ 
/*    */ public class RideListExt extends RideListCO {
/* 13 */   public Map<Const.PlayerBtlData, Integer> levelAttrs = new HashMap<>();
/* 14 */   public Map<Const.PlayerBtlData, Integer> starAttrs = new HashMap<>();
/*    */ 
/*    */ 
/*    */   
/* 18 */   public Map<Const.PlayerBtlData, Integer> totalPreStarAttrs = new HashMap<>();
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void initProperty() {
/* 24 */     for (int i = 1; i <= 7; i++) {
/* 25 */       String propName = "prop" + i;
/* 26 */       String attrMax = "max" + i;
/* 27 */       String starPropName = "starProp" + i;
/* 28 */       String starAttrMax = "starMax" + i;
/*    */ 
/*    */       
/*    */       try {
/* 32 */         Object obj = ClassUtil.getProperty(this, propName);
/* 33 */         if (obj != null) {
/* 34 */           String key = (String)obj;
/* 35 */           Const.PlayerBtlData pbd = Const.PlayerBtlData.getE(key);
/*    */           
/* 37 */           if (pbd != null) {
/* 38 */             this.levelAttrs.put(pbd, Integer.valueOf(((Integer)ClassUtil.getProperty(this, attrMax)).intValue()));
/*    */           }
/*    */         } 
/* 41 */         obj = ClassUtil.getProperty(this, starPropName);
/* 42 */         if (obj != null) {
/* 43 */           String key = (String)obj;
/* 44 */           Const.PlayerBtlData pbd = Const.PlayerBtlData.getE(key);
/*    */           
/* 46 */           if (pbd != null) {
/* 47 */             this.starAttrs.put(pbd, Integer.valueOf(((Integer)ClassUtil.getProperty(this, starAttrMax)).intValue()));
/* 48 */             this.totalPreStarAttrs.put(pbd, Integer.valueOf(0));
/*    */           }
/*    */         
/*    */         } 
/* 52 */       } catch (Exception e) {
/* 53 */         Out.error(new Object[] { "Exception in RidelistExt: ", e });
/*    */       } 
/*    */     } 
/*    */     
/* 57 */     Map<Integer, RideListExt> map = GameData.RideLists;
/* 58 */     for (Iterator<Integer> iterator = map.keySet().iterator(); iterator.hasNext(); ) { int level = ((Integer)iterator.next()).intValue();
/* 59 */       if (level < this.rideLevel) {
/* 60 */         RideListExt prop_pre = map.get(Integer.valueOf(level));
/* 61 */         Map<Const.PlayerBtlData, Integer> starAttrs_pre = prop_pre.starAttrs;
/* 62 */         for (Const.PlayerBtlData pbd : starAttrs_pre.keySet()) {
/* 63 */           int value = ((Integer)this.totalPreStarAttrs.get(pbd)).intValue();
/* 64 */           value += ((Integer)starAttrs_pre.get(pbd)).intValue() * 10;
/* 65 */           this.totalPreStarAttrs.put(pbd, Integer.valueOf(value));
/*    */         } 
/*    */       }  }
/*    */   
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\data\ext\RideListExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */