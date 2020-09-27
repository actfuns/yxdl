/*    */ package com.wanniu.game.data.ext;
/*    */ 
/*    */ import com.wanniu.core.util.DateUtil;
/*    */ import com.wanniu.core.util.StringUtil;
/*    */ import com.wanniu.game.data.ShopMallItemsCO;
/*    */ import java.util.Date;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ShopMallItemsExt
/*    */   extends ShopMallItemsCO
/*    */ {
/*    */   public Date startTime;
/*    */   public Date endTime;
/*    */   
/*    */   public void initProperty() {
/* 21 */     String periodStart = this.periodStart;
/* 22 */     if (StringUtil.isNotEmpty(periodStart)) {
/* 23 */       this.startTime = DateUtil.format(periodStart);
/*    */     }
/*    */     
/* 26 */     String periodEnd = this.periodStart;
/* 27 */     if (StringUtil.isNotEmpty(periodEnd))
/* 28 */       this.endTime = DateUtil.format(periodEnd); 
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\data\ext\ShopMallItemsExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */