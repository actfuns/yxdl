/*    */ package com.wanniu.game.data.ext;
/*    */ 
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.core.util.ClassUtil;
/*    */ import com.wanniu.core.util.StringUtil;
/*    */ import com.wanniu.game.data.RankListCO;
/*    */ import com.wanniu.game.player.AttributeUtil;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RankListExt
/*    */   extends RankListCO
/*    */ {
/*    */   public Map<String, Integer> rankAttrs;
/*    */   
/*    */   public void initProperty() {
/* 22 */     this.rankAttrs = new HashMap<>();
/* 23 */     for (int i = 1; i <= 4; i++) {
/* 24 */       String propName = "prop" + i;
/* 25 */       String maxValue = "max" + i;
/*    */       
/*    */       try {
/* 28 */         if (ClassUtil.getProperty(this, propName) != null && StringUtil.isNotEmpty((String)ClassUtil.getProperty(this, propName))) {
/* 29 */           String key = AttributeUtil.getKeyByName((String)ClassUtil.getProperty(this, propName));
/* 30 */           if (StringUtil.isNotEmpty(key) && ClassUtil.getProperty(this, maxValue) != null) {
/* 31 */             this.rankAttrs.put(key, Integer.valueOf(((Integer)ClassUtil.getProperty(this, maxValue)).intValue()));
/*    */           }
/*    */         } 
/* 34 */       } catch (Exception e) {
/* 35 */         Out.error(new Object[] { e });
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\data\ext\RankListExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */