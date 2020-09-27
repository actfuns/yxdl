/*    */ package com.wanniu.game.data.ext;
/*    */ 
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.game.bag.WNBag;
/*    */ import com.wanniu.game.common.CommonUtil;
/*    */ import com.wanniu.game.data.OlGiftCO;
/*    */ import com.wanniu.game.item.ItemUtil;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import pomelo.item.ItemOuterClass;
/*    */ 
/*    */ 
/*    */ public class OlGiftExt
/*    */   extends OlGiftCO
/*    */ {
/*    */   public List<WNBag.SimpleItemInfo> items;
/*    */   
/*    */   public void initProperty() {
/* 19 */     this.items = new ArrayList<>();
/* 20 */     this.items = CommonUtil.parseItems(this.reward);
/*    */   }
/*    */ 
/*    */   
/*    */   public final List<ItemOuterClass.MiniItem> getMiniItems() {
/* 25 */     List<ItemOuterClass.MiniItem> itemList = new ArrayList<>();
/* 26 */     if (this.items != null)
/* 27 */       for (int i = 0; i < this.items.size(); i++) {
/* 28 */         WNBag.SimpleItemInfo item = this.items.get(i);
/* 29 */         if (null != item) {
/*    */ 
/*    */           
/* 32 */           ItemOuterClass.MiniItem.Builder miniItem = ItemUtil.getMiniItemData(item.itemCode, item.itemNum);
/* 33 */           if (null == miniItem) {
/* 34 */             Out.error(new Object[] { getClass(), "->[", item.itemCode, "] is not found" });
/*    */           }
/*    */           else {
/*    */             
/* 38 */             itemList.add(miniItem.build());
/*    */           } 
/*    */         } 
/* 41 */       }   return itemList;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\data\ext\OlGiftExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */