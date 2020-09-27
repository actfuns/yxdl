/*    */ package com.wanniu.game.data.ext;
/*    */ 
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.core.util.ClassUtil;
/*    */ import com.wanniu.core.util.StringUtil;
/*    */ import com.wanniu.game.bag.WNBag;
/*    */ import com.wanniu.game.data.CombineCO;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CombineExt
/*    */   extends CombineCO
/*    */ {
/* 18 */   public List<WNBag.SimpleItemInfo> material = null;
/*    */ 
/*    */   
/*    */   public void initProperty() {
/* 22 */     this.material = new ArrayList<>();
/* 23 */     for (int i = 1; i <= 3; i++) {
/* 24 */       String key = "srcCode" + i;
/* 25 */       String value = "srcCount" + i;
/*    */       
/*    */       try {
/* 28 */         String keyCode = (String)ClassUtil.getProperty(this, key);
/* 29 */         if (StringUtil.isNotEmpty(keyCode)) {
/* 30 */           WNBag.SimpleItemInfo item = new WNBag.SimpleItemInfo();
/* 31 */           item.itemCode = (String)ClassUtil.getProperty(this, key);
/* 32 */           item.itemNum = ((Integer)ClassUtil.getProperty(this, value)).intValue();
/* 33 */           this.material.add(item);
/*    */         } 
/* 35 */       } catch (Exception e) {
/* 36 */         Out.error(new Object[] { e });
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\data\ext\CombineExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */