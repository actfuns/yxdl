/*    */ package com.wanniu.game.consignmentShop;
/*    */ 
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.game.common.msg.WNNotifyManager;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.game.poes.ConsignmentItemsPO;
/*    */ import com.wanniu.game.poes.PlayerConsignmentItemsPO;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collections;
/*    */ import java.util.Comparator;
/*    */ import java.util.List;
/*    */ import pomelo.item.ItemOuterClass;
/*    */ 
/*    */ public class ConsignmentManager
/*    */ {
/*    */   private WNPlayer player;
/*    */   public PlayerConsignmentItemsPO po;
/*    */   
/*    */   public ConsignmentManager(WNPlayer player, PlayerConsignmentItemsPO po) {
/* 20 */     this.player = player;
/* 21 */     this.po = po;
/*    */   }
/*    */   
/*    */   public final boolean hasBuyFirstConsignItem() {
/* 25 */     return (this.po.buyFirstConsignItem == 1);
/*    */   }
/*    */   
/*    */   public final void signBuyFirstConsignItem() {
/* 29 */     this.po.buyFirstConsignItem = 1;
/*    */   }
/*    */   
/*    */   public void afterPlayerChangeName() {
/* 33 */     List<ConsignmentItemsPO> list_consignment = ConsignmentLineService.getInstance().findByPlayerId(this.player.getId());
/* 34 */     if (list_consignment != null && !list_consignment.isEmpty()) {
/* 35 */       for (ConsignmentItemsPO po : list_consignment) {
/* 36 */         po.consignmentPlayerName = this.player.player.name;
/*    */       }
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final boolean remove(String id, boolean isPush) {
/* 48 */     if (ConsignmentLineService.getInstance().remove(id)) {
/* 49 */       if (isPush) {
/* 50 */         WNNotifyManager.getInstance().consignmentRemovePush(this.player, id);
/*    */       }
/* 52 */       return true;
/*    */     } 
/* 54 */     Out.error(new Object[] { "consignment remove :", this.player.getId(), ":", id, " not exits" });
/* 55 */     return false;
/*    */   }
/*    */   
/*    */   public final List<ItemOuterClass.ConsignmentItem> getAll() {
/* 59 */     List<ItemOuterClass.ConsignmentItem> data = new ArrayList<>();
/* 60 */     List<ConsignmentItemsPO> list_consignment = ConsignmentLineService.getInstance().findByPlayerId(this.player.getId());
/* 61 */     Collections.sort(list_consignment, new Comparator<ConsignmentItemsPO>()
/*    */         {
/*    */           public int compare(ConsignmentItemsPO o1, ConsignmentItemsPO o2)
/*    */           {
/* 65 */             return (int)(o2.consignmentTime - o1.consignmentTime);
/*    */           }
/*    */         });
/*    */     
/* 69 */     for (ConsignmentItemsPO item : list_consignment) {
/* 70 */       data.add(ConsignmentUtil.buildConsignmentItem(this.player, item));
/*    */     }
/* 72 */     return data;
/*    */   }
/*    */   
/*    */   public void refreshNewDay() {}
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\consignmentShop\ConsignmentManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */