/*    */ package com.wanniu.game.poes;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GEntity;
/*    */ import com.wanniu.game.DBField;
/*    */ import com.wanniu.game.DBTable;
/*    */ import com.wanniu.game.bag.BagPO;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @DBTable("player_bags")
/*    */ public class BagsPO
/*    */   extends GEntity
/*    */ {
/*    */   @DBField(fieldType = "mediumblob")
/*    */   public BagPO bagData;
/*    */   @DBField(fieldType = "mediumblob")
/*    */   public BagPO wareHouseData;
/*    */   @DBField(fieldType = "mediumblob")
/*    */   public BagPO recycleData;
/*    */   
/*    */   public BagsPO() {}
/*    */   
/*    */   public BagsPO(BagPO bagPO, BagPO wareHouseData, BagPO recycleData) {
/* 32 */     this.bagData = bagPO;
/* 33 */     this.wareHouseData = wareHouseData;
/* 34 */     this.recycleData = recycleData;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\poes\BagsPO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */