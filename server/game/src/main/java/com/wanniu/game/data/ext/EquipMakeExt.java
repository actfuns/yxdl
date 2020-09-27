/*    */ package com.wanniu.game.data.ext;
/*    */ 
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.core.util.ClassUtil;
/*    */ import com.wanniu.core.util.StringUtil;
/*    */ import com.wanniu.game.bag.WNBag;
/*    */ import com.wanniu.game.data.EquipMakeCO;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EquipMakeExt
/*    */   extends EquipMakeCO
/*    */ {
/*    */   public List<WNBag.SimpleItemInfo> reqMate;
/*    */   
/*    */   public void initProperty() {
/* 19 */     this.reqMate = new ArrayList<>();
/*    */     
/* 21 */     for (int i = 1; i <= 3; i++) {
/* 22 */       String codeKey = "reqMateCode" + i;
/* 23 */       String countKey = "reqMateCount" + i;
/*    */       try {
/* 25 */         if (StringUtil.isNotEmpty((String)ClassUtil.getProperty(this, codeKey))) {
/* 26 */           WNBag.SimpleItemInfo mateItem = new WNBag.SimpleItemInfo();
/* 27 */           mateItem.itemCode = (String)ClassUtil.getProperty(this, codeKey);
/* 28 */           mateItem.itemNum = ((Integer)ClassUtil.getProperty(this, countKey)).intValue();
/* 29 */           this.reqMate.add(mateItem);
/*    */         } 
/* 31 */       } catch (Exception e) {
/* 32 */         Out.error(new Object[] { e });
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\data\ext\EquipMakeExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */