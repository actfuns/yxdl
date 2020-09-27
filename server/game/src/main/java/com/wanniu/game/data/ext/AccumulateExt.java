/*    */ package com.wanniu.game.data.ext;
/*    */ 
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.core.util.ClassUtil;
/*    */ import com.wanniu.game.bag.WNBag;
/*    */ import com.wanniu.game.data.AccumulateCO;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import pomelo.item.ItemOuterClass;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AccumulateExt
/*    */   extends AccumulateCO
/*    */ {
/* 20 */   public List<WNBag.SimpleItemInfo> items = null;
/*    */ 
/*    */   
/*    */   public void initProperty() {
/* 24 */     this.items = new ArrayList<>();
/* 25 */     for (int i = 1; i <= 4; i++) {
/* 26 */       String codeKey = "item" + i + "code";
/* 27 */       String countKey = "item" + i + "count";
/*    */       try {
/* 29 */         if (ClassUtil.getProperty(this, codeKey) != null && ClassUtil.getProperty(this, countKey) != null) {
/* 30 */           WNBag.SimpleItemInfo item = new WNBag.SimpleItemInfo();
/* 31 */           item.itemCode = ClassUtil.getProperty(this, codeKey).toString();
/* 32 */           item.itemNum = ((Integer)ClassUtil.getProperty(this, countKey)).intValue();
/* 33 */           this.items.add(item);
/*    */         } 
/* 35 */       } catch (Exception e) {
/* 36 */         Out.error(new Object[] { e });
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   public final ItemOuterClass.MiniItem.Builder[] getMiniItems() {
/* 42 */     if (this.items != null && this.items.size() > 0) {
/* 43 */       ItemOuterClass.MiniItem.Builder[] miniItems = new ItemOuterClass.MiniItem.Builder[this.items.size()];
/* 44 */       for (int i = 0; i < this.items.size(); i++) {
/* 45 */         miniItems[i] = ItemOuterClass.MiniItem.newBuilder();
/* 46 */         miniItems[i].setCode(((WNBag.SimpleItemInfo)this.items.get(i)).itemCode);
/* 47 */         miniItems[i].setGroupCount(((WNBag.SimpleItemInfo)this.items.get(i)).itemNum);
/*    */       } 
/* 49 */       return miniItems;
/*    */     } 
/* 51 */     return null;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\data\ext\AccumulateExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */