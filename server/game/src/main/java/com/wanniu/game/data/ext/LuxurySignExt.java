/*    */ package com.wanniu.game.data.ext;
/*    */ 
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.core.util.ClassUtil;
/*    */ import com.wanniu.game.bag.WNBag;
/*    */ import com.wanniu.game.data.LuxurySignCO;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import pomelo.item.ItemOuterClass;
/*    */ 
/*    */ 
/*    */ public class LuxurySignExt
/*    */   extends LuxurySignCO
/*    */ {
/* 15 */   public List<WNBag.SimpleItemInfo> items = null;
/*    */ 
/*    */   
/*    */   public void initProperty() {
/* 19 */     this.items = new ArrayList<>();
/* 20 */     for (int i = 1; i <= 4; i++) {
/* 21 */       String codeKey = "item" + i + "code";
/* 22 */       String countKey = "item" + i + "count";
/*    */       try {
/* 24 */         if (ClassUtil.getProperty(this, codeKey) != null && ClassUtil.getProperty(this, countKey) != null) {
/* 25 */           WNBag.SimpleItemInfo item = new WNBag.SimpleItemInfo();
/* 26 */           item.itemCode = ClassUtil.getProperty(this, codeKey).toString();
/* 27 */           item.itemNum = ((Integer)ClassUtil.getProperty(this, countKey)).intValue();
/* 28 */           this.items.add(item);
/*    */         } 
/* 30 */       } catch (Exception e) {
/* 31 */         Out.error(new Object[] { e });
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   public final ItemOuterClass.MiniItem.Builder[] getMiniItems() {
/* 37 */     if (this.items != null && this.items.size() > 0) {
/* 38 */       ItemOuterClass.MiniItem.Builder[] miniItems = new ItemOuterClass.MiniItem.Builder[this.items.size()];
/* 39 */       for (int i = 0; i < this.items.size(); i++) {
/* 40 */         miniItems[i] = ItemOuterClass.MiniItem.newBuilder();
/* 41 */         miniItems[i].setCode(((WNBag.SimpleItemInfo)this.items.get(i)).itemCode);
/* 42 */         miniItems[i].setGroupCount(((WNBag.SimpleItemInfo)this.items.get(i)).itemNum);
/*    */       } 
/* 44 */       return miniItems;
/*    */     } 
/* 46 */     return null;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\data\ext\LuxurySignExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */