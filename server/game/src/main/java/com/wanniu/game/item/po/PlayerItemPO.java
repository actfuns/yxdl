/*    */ package com.wanniu.game.item.po;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.Date;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PlayerItemPO
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   public String id;
/*    */   public String code;
/*    */   public int groupCount;
/*    */   public int isNew;
/* 22 */   public ItemSpeData speData = new ItemSpeData();
/*    */ 
/*    */   
/*    */   public int isBind;
/*    */ 
/*    */   
/*    */   public int noAuction;
/*    */ 
/*    */   
/*    */   public int isBindFilter;
/*    */ 
/*    */   
/*    */   public int noAuctionFilter;
/*    */   
/*    */   public long cdTime;
/*    */   
/*    */   public Date gotTime;
/*    */ 
/*    */   
/*    */   public PlayerItemPO() {
/* 42 */     this.isBindFilter = -1;
/* 43 */     this.noAuctionFilter = -1;
/*    */   }
/*    */ 
/*    */   
/*    */   public PlayerItemPO copy() {
/* 48 */     PlayerItemPO po = new PlayerItemPO();
/* 49 */     po.id = this.id;
/* 50 */     po.code = this.code;
/* 51 */     po.groupCount = this.groupCount;
/* 52 */     po.isNew = this.isNew;
/* 53 */     po.speData = this.speData;
/* 54 */     po.isBind = this.isBind;
/* 55 */     po.noAuction = this.noAuction;
/* 56 */     po.cdTime = this.cdTime;
/* 57 */     po.gotTime = this.gotTime;
/* 58 */     po.isBindFilter = this.isBindFilter;
/* 59 */     po.noAuctionFilter = this.noAuctionFilter;
/* 60 */     return po;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\item\po\PlayerItemPO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */